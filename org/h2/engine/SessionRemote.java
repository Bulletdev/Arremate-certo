/*     */ package org.h2.engine;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.Socket;
/*     */ import java.util.ArrayList;
/*     */ import org.h2.api.DatabaseEventListener;
/*     */ import org.h2.api.JavaObjectSerializer;
/*     */ import org.h2.command.CommandInterface;
/*     */ import org.h2.command.CommandRemote;
/*     */ import org.h2.jdbc.JdbcSQLException;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.message.Trace;
/*     */ import org.h2.message.TraceSystem;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.store.DataHandler;
/*     */ import org.h2.store.FileStore;
/*     */ import org.h2.store.LobStorageFrontend;
/*     */ import org.h2.store.LobStorageInterface;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ import org.h2.util.JdbcUtils;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.NetUtils;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.SmallLRUCache;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.util.TempFileDeleter;
/*     */ import org.h2.value.CompareMode;
/*     */ import org.h2.value.Transfer;
/*     */ import org.h2.value.Value;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SessionRemote
/*     */   extends SessionWithState
/*     */   implements DataHandler
/*     */ {
/*     */   public static final int SESSION_PREPARE = 0;
/*     */   public static final int SESSION_CLOSE = 1;
/*     */   public static final int COMMAND_EXECUTE_QUERY = 2;
/*     */   public static final int COMMAND_EXECUTE_UPDATE = 3;
/*     */   public static final int COMMAND_CLOSE = 4;
/*     */   public static final int RESULT_FETCH_ROWS = 5;
/*     */   public static final int RESULT_RESET = 6;
/*     */   public static final int RESULT_CLOSE = 7;
/*     */   public static final int COMMAND_COMMIT = 8;
/*     */   public static final int CHANGE_ID = 9;
/*     */   public static final int COMMAND_GET_META_DATA = 10;
/*     */   public static final int SESSION_PREPARE_READ_PARAMS = 11;
/*     */   public static final int SESSION_SET_ID = 12;
/*     */   public static final int SESSION_CANCEL_STATEMENT = 13;
/*     */   public static final int SESSION_CHECK_KEY = 14;
/*     */   public static final int SESSION_SET_AUTOCOMMIT = 15;
/*     */   public static final int SESSION_HAS_PENDING_TRANSACTION = 16;
/*     */   public static final int LOB_READ = 17;
/*     */   public static final int STATUS_ERROR = 0;
/*     */   public static final int STATUS_OK = 1;
/*     */   public static final int STATUS_CLOSED = 2;
/*     */   public static final int STATUS_OK_STATE_CHANGED = 3;
/*     */   private static SessionFactory sessionFactory;
/*     */   private TraceSystem traceSystem;
/*     */   private Trace trace;
/*  72 */   private ArrayList<Transfer> transferList = New.arrayList();
/*     */   
/*     */   private int nextId;
/*     */   
/*     */   private boolean autoCommit = true;
/*     */   
/*     */   private CommandInterface autoCommitFalse;
/*     */   private CommandInterface autoCommitTrue;
/*  80 */   private final Object lobSyncObject = new Object(); private ConnectionInfo connectionInfo; private String databaseName;
/*     */   private String cipher;
/*     */   private byte[] fileEncryptionKey;
/*     */   private String sessionId;
/*     */   private int clientVersion;
/*     */   private boolean autoReconnect;
/*     */   private int lastReconnect;
/*     */   private SessionInterface embedded;
/*     */   private DatabaseEventListener eventListener;
/*     */   private LobStorageFrontend lobStorage;
/*     */   private boolean cluster;
/*     */   private TempFileDeleter tempFileDeleter;
/*     */   private JavaObjectSerializer javaObjectSerializer;
/*     */   private volatile boolean javaObjectSerializerInitialized;
/*  94 */   private CompareMode compareMode = CompareMode.getInstance(null, 0);
/*     */   
/*     */   public SessionRemote(ConnectionInfo paramConnectionInfo) {
/*  97 */     this.connectionInfo = paramConnectionInfo;
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<String> getClusterServers() {
/* 102 */     ArrayList<String> arrayList = new ArrayList();
/* 103 */     for (byte b = 0; b < this.transferList.size(); b++) {
/* 104 */       Transfer transfer = this.transferList.get(b);
/* 105 */       arrayList.add(transfer.getSocket().getInetAddress().getHostAddress() + ":" + transfer.getSocket().getPort());
/*     */     } 
/*     */ 
/*     */     
/* 109 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   private Transfer initTransfer(ConnectionInfo paramConnectionInfo, String paramString1, String paramString2) throws IOException {
/* 114 */     Socket socket = NetUtils.createSocket(paramString2, 9092, paramConnectionInfo.isSSL());
/*     */     
/* 116 */     Transfer transfer = new Transfer(this);
/* 117 */     transfer.setSocket(socket);
/* 118 */     transfer.setSSL(paramConnectionInfo.isSSL());
/* 119 */     transfer.init();
/* 120 */     transfer.writeInt(6);
/* 121 */     transfer.writeInt(15);
/* 122 */     transfer.writeString(paramString1);
/* 123 */     transfer.writeString(paramConnectionInfo.getOriginalURL());
/* 124 */     transfer.writeString(paramConnectionInfo.getUserName());
/* 125 */     transfer.writeBytes(paramConnectionInfo.getUserPasswordHash());
/* 126 */     transfer.writeBytes(paramConnectionInfo.getFilePasswordHash());
/* 127 */     String[] arrayOfString = paramConnectionInfo.getKeys();
/* 128 */     transfer.writeInt(arrayOfString.length);
/* 129 */     for (String str : arrayOfString) {
/* 130 */       transfer.writeString(str).writeString(paramConnectionInfo.getProperty(str));
/*     */     }
/*     */     try {
/* 133 */       done(transfer);
/* 134 */       this.clientVersion = transfer.readInt();
/* 135 */       transfer.setVersion(this.clientVersion);
/* 136 */       if (this.clientVersion >= 14 && 
/* 137 */         paramConnectionInfo.getFileEncryptionKey() != null) {
/* 138 */         transfer.writeBytes(paramConnectionInfo.getFileEncryptionKey());
/*     */       }
/*     */       
/* 141 */       transfer.writeInt(12);
/* 142 */       transfer.writeString(this.sessionId);
/* 143 */       done(transfer);
/* 144 */       if (this.clientVersion >= 15) {
/* 145 */         this.autoCommit = transfer.readBoolean();
/*     */       } else {
/* 147 */         this.autoCommit = true;
/*     */       } 
/* 149 */       return transfer;
/* 150 */     } catch (DbException dbException) {
/* 151 */       transfer.close();
/* 152 */       throw dbException;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasPendingTransaction() {
/* 158 */     if (this.clientVersion < 10) {
/* 159 */       return true;
/*     */     }
/* 161 */     for (byte b1 = 0, b2 = 0; b1 < this.transferList.size(); b1++) {
/* 162 */       Transfer transfer = this.transferList.get(b1);
/*     */       try {
/* 164 */         traceOperation("SESSION_HAS_PENDING_TRANSACTION", 0);
/* 165 */         transfer.writeInt(16);
/*     */         
/* 167 */         done(transfer);
/* 168 */         return (transfer.readInt() != 0);
/* 169 */       } catch (IOException iOException) {
/* 170 */         removeServer(iOException, b1--, ++b2);
/*     */       } 
/*     */     } 
/* 173 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancel() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancelStatement(int paramInt) {
/* 189 */     for (Transfer transfer : this.transferList) {
/*     */       try {
/* 191 */         Transfer transfer1 = transfer.openNewConnection();
/* 192 */         transfer1.init();
/* 193 */         transfer1.writeInt(this.clientVersion);
/* 194 */         transfer1.writeInt(this.clientVersion);
/* 195 */         transfer1.writeString(null);
/* 196 */         transfer1.writeString(null);
/* 197 */         transfer1.writeString(this.sessionId);
/* 198 */         transfer1.writeInt(13);
/* 199 */         transfer1.writeInt(paramInt);
/* 200 */         transfer1.close();
/* 201 */       } catch (IOException iOException) {
/* 202 */         this.trace.debug(iOException, "could not cancel statement");
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void checkClusterDisableAutoCommit(String paramString) {
/* 208 */     if (this.autoCommit && this.transferList.size() > 1) {
/* 209 */       setAutoCommitSend(false);
/* 210 */       CommandInterface commandInterface = prepareCommand("SET CLUSTER " + paramString, 2147483647);
/*     */ 
/*     */       
/* 213 */       commandInterface.executeUpdate();
/*     */       
/* 215 */       this.autoCommit = true;
/* 216 */       this.cluster = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getAutoCommit() {
/* 222 */     return this.autoCommit;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAutoCommit(boolean paramBoolean) {
/* 227 */     if (!this.cluster) {
/* 228 */       setAutoCommitSend(paramBoolean);
/*     */     }
/* 230 */     this.autoCommit = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setAutoCommitFromServer(boolean paramBoolean) {
/* 234 */     if (this.cluster) {
/* 235 */       if (paramBoolean) {
/*     */         
/* 237 */         setAutoCommitSend(false);
/* 238 */         this.autoCommit = true;
/*     */       } 
/*     */     } else {
/* 241 */       this.autoCommit = paramBoolean;
/*     */     } 
/*     */   }
/*     */   
/*     */   private synchronized void setAutoCommitSend(boolean paramBoolean) {
/* 246 */     if (this.clientVersion >= 8) {
/* 247 */       for (byte b1 = 0, b2 = 0; b1 < this.transferList.size(); b1++) {
/* 248 */         Transfer transfer = this.transferList.get(b1);
/*     */         try {
/* 250 */           traceOperation("SESSION_SET_AUTOCOMMIT", paramBoolean ? 1 : 0);
/* 251 */           transfer.writeInt(15).writeBoolean(paramBoolean);
/*     */           
/* 253 */           done(transfer);
/* 254 */         } catch (IOException iOException) {
/* 255 */           removeServer(iOException, b1--, ++b2);
/*     */         }
/*     */       
/*     */       } 
/* 259 */     } else if (paramBoolean) {
/* 260 */       if (this.autoCommitTrue == null) {
/* 261 */         this.autoCommitTrue = prepareCommand("SET AUTOCOMMIT TRUE", 2147483647);
/*     */       }
/*     */       
/* 264 */       this.autoCommitTrue.executeUpdate();
/*     */     } else {
/* 266 */       if (this.autoCommitFalse == null) {
/* 267 */         this.autoCommitFalse = prepareCommand("SET AUTOCOMMIT FALSE", 2147483647);
/*     */       }
/*     */       
/* 270 */       this.autoCommitFalse.executeUpdate();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void autoCommitIfCluster() {
/* 279 */     if (this.autoCommit && this.cluster)
/*     */     {
/*     */ 
/*     */       
/* 283 */       for (byte b1 = 0, b2 = 0; b1 < this.transferList.size(); b1++) {
/* 284 */         Transfer transfer = this.transferList.get(b1);
/*     */         try {
/* 286 */           traceOperation("COMMAND_COMMIT", 0);
/* 287 */           transfer.writeInt(8);
/* 288 */           done(transfer);
/* 289 */         } catch (IOException iOException) {
/* 290 */           removeServer(iOException, b1--, ++b2);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private String getFilePrefix(String paramString) {
/* 297 */     StringBuilder stringBuilder = new StringBuilder(paramString);
/* 298 */     stringBuilder.append('/');
/* 299 */     for (byte b = 0; b < this.databaseName.length(); b++) {
/* 300 */       char c = this.databaseName.charAt(b);
/* 301 */       if (Character.isLetterOrDigit(c)) {
/* 302 */         stringBuilder.append(c);
/*     */       } else {
/* 304 */         stringBuilder.append('_');
/*     */       } 
/*     */     } 
/* 307 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPowerOffCount() {
/* 312 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPowerOffCount(int paramInt) {
/* 317 */     throw DbException.getUnsupportedException("remote");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SessionInterface connectEmbeddedOrServer(boolean paramBoolean) {
/* 327 */     ConnectionInfo connectionInfo1 = this.connectionInfo;
/* 328 */     if (connectionInfo1.isRemote()) {
/* 329 */       connectServer(connectionInfo1);
/* 330 */       return this;
/*     */     } 
/*     */ 
/*     */     
/* 334 */     boolean bool = Boolean.parseBoolean(connectionInfo1.getProperty("AUTO_SERVER", "false"));
/*     */     
/* 336 */     ConnectionInfo connectionInfo2 = null;
/*     */     try {
/* 338 */       if (bool) {
/* 339 */         connectionInfo2 = connectionInfo1.clone();
/* 340 */         this.connectionInfo = connectionInfo1.clone();
/*     */       } 
/* 342 */       if (paramBoolean) {
/* 343 */         connectionInfo1.setProperty("OPEN_NEW", "true");
/*     */       }
/* 345 */       if (sessionFactory == null) {
/* 346 */         sessionFactory = (SessionFactory)Class.forName("org.h2.engine.Engine").getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
/*     */       }
/*     */       
/* 349 */       return sessionFactory.createSession(connectionInfo1);
/* 350 */     } catch (Exception exception) {
/* 351 */       DbException dbException = DbException.convert(exception);
/* 352 */       if (dbException.getErrorCode() == 90020 && 
/* 353 */         bool) {
/* 354 */         String str = ((JdbcSQLException)dbException.getSQLException()).getSQL();
/*     */         
/* 356 */         if (str != null) {
/* 357 */           connectionInfo2.setServerKey(str);
/*     */ 
/*     */ 
/*     */           
/* 361 */           connectionInfo2.removeProperty("OPEN_NEW", (String)null);
/* 362 */           connectServer(connectionInfo2);
/* 363 */           return this;
/*     */         } 
/*     */       } 
/*     */       
/* 367 */       throw dbException;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void connectServer(ConnectionInfo paramConnectionInfo) {
/* 372 */     String str1 = paramConnectionInfo.getName();
/* 373 */     if (str1.startsWith("//")) {
/* 374 */       str1 = str1.substring("//".length());
/*     */     }
/* 376 */     int i = str1.indexOf('/');
/* 377 */     if (i < 0) {
/* 378 */       throw paramConnectionInfo.getFormatException();
/*     */     }
/* 380 */     this.databaseName = str1.substring(i + 1);
/* 381 */     String str2 = str1.substring(0, i);
/* 382 */     this.traceSystem = new TraceSystem(null);
/* 383 */     String str3 = paramConnectionInfo.getProperty(10, (String)null);
/*     */     
/* 385 */     if (str3 != null) {
/* 386 */       int k = Integer.parseInt(str3);
/* 387 */       String str = getFilePrefix(SysProperties.CLIENT_TRACE_DIRECTORY);
/*     */       
/*     */       try {
/* 390 */         this.traceSystem.setLevelFile(k);
/* 391 */         if (k > 0 && k < 4) {
/* 392 */           String str6 = FileUtils.createTempFile(str, ".trace.db", false, false);
/*     */           
/* 394 */           this.traceSystem.setFileName(str6);
/*     */         } 
/* 396 */       } catch (IOException iOException) {
/* 397 */         throw DbException.convertIOException(iOException, str);
/*     */       } 
/*     */     } 
/* 400 */     String str4 = paramConnectionInfo.getProperty(9, (String)null);
/*     */     
/* 402 */     if (str4 != null) {
/* 403 */       int k = Integer.parseInt(str4);
/* 404 */       this.traceSystem.setLevelSystemOut(k);
/*     */     } 
/* 406 */     this.trace = this.traceSystem.getTrace(6);
/* 407 */     String str5 = null;
/* 408 */     if (str2.indexOf(',') >= 0) {
/* 409 */       str5 = StringUtils.quoteStringSQL(str2);
/* 410 */       paramConnectionInfo.setProperty("CLUSTER", "TRUE");
/*     */     } 
/* 412 */     this.autoReconnect = Boolean.parseBoolean(paramConnectionInfo.getProperty("AUTO_RECONNECT", "false"));
/*     */ 
/*     */     
/* 415 */     boolean bool = Boolean.parseBoolean(paramConnectionInfo.getProperty("AUTO_SERVER", "false"));
/*     */     
/* 417 */     if (bool && str5 != null) {
/* 418 */       throw DbException.getUnsupportedException("autoServer && serverList != null");
/*     */     }
/*     */     
/* 421 */     this.autoReconnect |= bool;
/* 422 */     if (this.autoReconnect) {
/* 423 */       String str = paramConnectionInfo.getProperty("DATABASE_EVENT_LISTENER");
/* 424 */       if (str != null) {
/* 425 */         str = StringUtils.trim(str, true, true, "'");
/*     */         try {
/* 427 */           this.eventListener = JdbcUtils.loadUserClass(str).newInstance();
/*     */         }
/* 429 */         catch (Throwable throwable) {
/* 430 */           throw DbException.convert(throwable);
/*     */         } 
/*     */       } 
/*     */     } 
/* 434 */     this.cipher = paramConnectionInfo.getProperty("CIPHER");
/* 435 */     if (this.cipher != null) {
/* 436 */       this.fileEncryptionKey = MathUtils.secureRandomBytes(32);
/*     */     }
/* 438 */     String[] arrayOfString = StringUtils.arraySplit(str2, ',', true);
/* 439 */     int j = arrayOfString.length;
/* 440 */     this.transferList.clear();
/* 441 */     this.sessionId = StringUtils.convertBytesToHex(MathUtils.secureRandomBytes(32));
/*     */     
/* 443 */     boolean bool1 = false;
/*     */     try {
/* 445 */       for (byte b = 0; b < j; b++) {
/* 446 */         String str = arrayOfString[b];
/*     */         try {
/* 448 */           Transfer transfer = initTransfer(paramConnectionInfo, this.databaseName, str);
/* 449 */           this.transferList.add(transfer);
/* 450 */         } catch (IOException iOException) {
/* 451 */           if (j == 1) {
/* 452 */             throw DbException.get(90067, iOException, new String[] { iOException + ": " + str });
/*     */           }
/* 454 */           bool1 = true;
/*     */         } 
/*     */       } 
/* 457 */       checkClosed();
/* 458 */       if (bool1) {
/* 459 */         switchOffCluster();
/*     */       }
/* 461 */       checkClusterDisableAutoCommit(str5);
/* 462 */     } catch (DbException dbException) {
/* 463 */       this.traceSystem.close();
/* 464 */       throw dbException;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void switchOffCluster() {
/* 469 */     CommandInterface commandInterface = prepareCommand("SET CLUSTER ''", 2147483647);
/* 470 */     commandInterface.executeUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeServer(IOException paramIOException, int paramInt1, int paramInt2) {
/* 482 */     this.trace.debug(paramIOException, "removing server because of exception");
/* 483 */     this.transferList.remove(paramInt1);
/* 484 */     if (this.transferList.size() == 0 && autoReconnect(paramInt2)) {
/*     */       return;
/*     */     }
/* 487 */     checkClosed();
/* 488 */     switchOffCluster();
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized CommandInterface prepareCommand(String paramString, int paramInt) {
/* 493 */     checkClosed();
/* 494 */     return (CommandInterface)new CommandRemote(this, this.transferList, paramString, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean autoReconnect(int paramInt) {
/* 504 */     if (!isClosed()) {
/* 505 */       return false;
/*     */     }
/* 507 */     if (!this.autoReconnect) {
/* 508 */       return false;
/*     */     }
/* 510 */     if (!this.cluster && !this.autoCommit) {
/* 511 */       return false;
/*     */     }
/* 513 */     if (paramInt > SysProperties.MAX_RECONNECT) {
/* 514 */       return false;
/*     */     }
/* 516 */     this.lastReconnect++;
/*     */     while (true) {
/*     */       try {
/* 519 */         this.embedded = connectEmbeddedOrServer(false);
/*     */         break;
/* 521 */       } catch (DbException dbException) {
/* 522 */         if (dbException.getErrorCode() != 90135) {
/* 523 */           throw dbException;
/*     */         }
/*     */         
/*     */         try {
/* 527 */           Thread.sleep(500L);
/* 528 */         } catch (Exception exception) {}
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 533 */     if (this.embedded == this) {
/*     */       
/* 535 */       this.embedded = null;
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 540 */       connectEmbeddedOrServer(true);
/*     */     } 
/* 542 */     recreateSessionState();
/* 543 */     if (this.eventListener != null) {
/* 544 */       this.eventListener.setProgress(4, this.databaseName, paramInt, SysProperties.MAX_RECONNECT);
/*     */     }
/*     */     
/* 547 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkClosed() {
/* 556 */     if (isClosed()) {
/* 557 */       throw DbException.get(90067, "session closed");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 563 */     RuntimeException runtimeException = null;
/* 564 */     if (this.transferList != null) {
/* 565 */       synchronized (this) {
/* 566 */         for (Transfer transfer : this.transferList) {
/*     */           try {
/* 568 */             traceOperation("SESSION_CLOSE", 0);
/* 569 */             transfer.writeInt(1);
/* 570 */             done(transfer);
/* 571 */             transfer.close();
/* 572 */           } catch (RuntimeException runtimeException1) {
/* 573 */             this.trace.error(runtimeException1, "close");
/* 574 */             runtimeException = runtimeException1;
/* 575 */           } catch (Exception exception) {
/* 576 */             this.trace.error(exception, "close");
/*     */           } 
/*     */         } 
/*     */       } 
/* 580 */       this.transferList = null;
/*     */     } 
/* 582 */     this.traceSystem.close();
/* 583 */     if (this.embedded != null) {
/* 584 */       this.embedded.close();
/* 585 */       this.embedded = null;
/*     */     } 
/* 587 */     if (runtimeException != null) {
/* 588 */       throw runtimeException;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Trace getTrace() {
/* 594 */     return this.traceSystem.getTrace(6);
/*     */   }
/*     */   
/*     */   public int getNextId() {
/* 598 */     return this.nextId++;
/*     */   }
/*     */   
/*     */   public int getCurrentId() {
/* 602 */     return this.nextId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void done(Transfer paramTransfer) throws IOException {
/* 616 */     paramTransfer.flush();
/* 617 */     int i = paramTransfer.readInt();
/* 618 */     if (i == 0) {
/* 619 */       String str1 = paramTransfer.readString();
/* 620 */       String str2 = paramTransfer.readString();
/* 621 */       String str3 = paramTransfer.readString();
/* 622 */       int j = paramTransfer.readInt();
/* 623 */       String str4 = paramTransfer.readString();
/* 624 */       JdbcSQLException jdbcSQLException = new JdbcSQLException(str2, str3, str1, j, null, str4);
/*     */       
/* 626 */       if (j == 90067) {
/*     */         
/* 628 */         IOException iOException = new IOException(jdbcSQLException.toString(), (Throwable)jdbcSQLException);
/* 629 */         throw iOException;
/*     */       } 
/* 631 */       throw DbException.convert(jdbcSQLException);
/* 632 */     }  if (i == 2) {
/* 633 */       this.transferList = null;
/* 634 */     } else if (i == 3) {
/* 635 */       this.sessionStateChanged = true;
/* 636 */     } else if (i != 1) {
/*     */ 
/*     */       
/* 639 */       throw DbException.get(90067, "unexpected status " + i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isClustered() {
/* 650 */     return this.cluster;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isClosed() {
/* 655 */     return (this.transferList == null || this.transferList.size() == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void traceOperation(String paramString, int paramInt) {
/* 665 */     if (this.trace.isDebugEnabled()) {
/* 666 */       this.trace.debug("{0} {1}", new Object[] { paramString, Integer.valueOf(paramInt) });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkPowerOff() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkWritingAllowed() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDatabasePath() {
/* 682 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public String getLobCompressionAlgorithm(int paramInt) {
/* 687 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxLengthInplaceLob() {
/* 692 */     return SysProperties.LOB_CLIENT_MAX_SIZE_MEMORY;
/*     */   }
/*     */   
/*     */   public FileStore openFile(String paramString1, String paramString2, boolean paramBoolean) {
/*     */     FileStore fileStore;
/* 697 */     if (paramBoolean && !FileUtils.exists(paramString1)) {
/* 698 */       throw DbException.get(90124, paramString1);
/*     */     }
/*     */     
/* 701 */     if (this.cipher == null) {
/* 702 */       fileStore = FileStore.open(this, paramString1, paramString2);
/*     */     } else {
/* 704 */       fileStore = FileStore.open(this, paramString1, paramString2, this.cipher, this.fileEncryptionKey, 0);
/*     */     } 
/* 706 */     fileStore.setCheckedWriting(false);
/*     */     try {
/* 708 */       fileStore.init();
/* 709 */     } catch (DbException dbException) {
/* 710 */       fileStore.closeSilently();
/* 711 */       throw dbException;
/*     */     } 
/* 713 */     return fileStore;
/*     */   }
/*     */ 
/*     */   
/*     */   public DataHandler getDataHandler() {
/* 718 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getLobSyncObject() {
/* 723 */     return this.lobSyncObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public SmallLRUCache<String, String[]> getLobFileListCache() {
/* 728 */     return null;
/*     */   }
/*     */   
/*     */   public int getLastReconnect() {
/* 732 */     return this.lastReconnect;
/*     */   }
/*     */ 
/*     */   
/*     */   public TempFileDeleter getTempFileDeleter() {
/* 737 */     if (this.tempFileDeleter == null) {
/* 738 */       this.tempFileDeleter = TempFileDeleter.getInstance();
/*     */     }
/* 740 */     return this.tempFileDeleter;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isReconnectNeeded(boolean paramBoolean) {
/* 745 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public SessionInterface reconnect(boolean paramBoolean) {
/* 750 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void afterWriting() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public LobStorageInterface getLobStorage() {
/* 760 */     if (this.lobStorage == null) {
/* 761 */       this.lobStorage = new LobStorageFrontend(this);
/*     */     }
/* 763 */     return (LobStorageInterface)this.lobStorage;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized int readLob(long paramLong1, byte[] paramArrayOfbyte1, long paramLong2, byte[] paramArrayOfbyte2, int paramInt1, int paramInt2) {
/* 769 */     checkClosed();
/* 770 */     for (byte b1 = 0, b2 = 0; b1 < this.transferList.size(); b1++) {
/* 771 */       Transfer transfer = this.transferList.get(b1);
/*     */       try {
/* 773 */         traceOperation("LOB_READ", (int)paramLong1);
/* 774 */         transfer.writeInt(17);
/* 775 */         transfer.writeLong(paramLong1);
/* 776 */         if (this.clientVersion >= 12) {
/* 777 */           transfer.writeBytes(paramArrayOfbyte1);
/*     */         }
/* 779 */         transfer.writeLong(paramLong2);
/* 780 */         transfer.writeInt(paramInt2);
/* 781 */         done(transfer);
/* 782 */         paramInt2 = transfer.readInt();
/* 783 */         if (paramInt2 <= 0) {
/* 784 */           return paramInt2;
/*     */         }
/* 786 */         transfer.readBytes(paramArrayOfbyte2, paramInt1, paramInt2);
/* 787 */         return paramInt2;
/* 788 */       } catch (IOException iOException) {
/* 789 */         removeServer(iOException, b1--, ++b2);
/*     */       } 
/*     */     } 
/* 792 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public JavaObjectSerializer getJavaObjectSerializer() {
/* 797 */     initJavaObjectSerializer();
/* 798 */     return this.javaObjectSerializer;
/*     */   }
/*     */   
/*     */   private void initJavaObjectSerializer() {
/* 802 */     if (this.javaObjectSerializerInitialized) {
/*     */       return;
/*     */     }
/* 805 */     synchronized (this) {
/* 806 */       if (this.javaObjectSerializerInitialized) {
/*     */         return;
/*     */       }
/* 809 */       String str = readSerializationSettings();
/* 810 */       if (str != null) {
/* 811 */         str = str.trim();
/* 812 */         if (!str.isEmpty() && !str.equals("null")) {
/*     */           try {
/* 814 */             this.javaObjectSerializer = JdbcUtils.loadUserClass(str).newInstance();
/*     */           }
/* 816 */           catch (Exception exception) {
/* 817 */             throw DbException.convert(exception);
/*     */           } 
/*     */         }
/*     */       } 
/* 821 */       this.javaObjectSerializerInitialized = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String readSerializationSettings() {
/* 831 */     String str = null;
/* 832 */     CommandInterface commandInterface = prepareCommand("SELECT VALUE FROM INFORMATION_SCHEMA.SETTINGS  WHERE NAME='JAVA_OBJECT_SERIALIZER'", 2147483647);
/*     */ 
/*     */     
/*     */     try {
/* 836 */       ResultInterface resultInterface = commandInterface.executeQuery(0, false);
/* 837 */       if (resultInterface.next()) {
/* 838 */         Value[] arrayOfValue = resultInterface.currentRow();
/* 839 */         str = arrayOfValue[0].getString();
/*     */       } 
/*     */     } finally {
/* 842 */       commandInterface.close();
/*     */     } 
/* 844 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addTemporaryLob(Value paramValue) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public CompareMode getCompareMode() {
/* 854 */     return this.compareMode;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRemote() {
/* 859 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCurrentSchemaName() {
/* 864 */     throw DbException.getUnsupportedException("getSchema && remote session");
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCurrentSchemaName(String paramString) {
/* 869 */     throw DbException.getUnsupportedException("setSchema && remote session");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\SessionRemote.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */