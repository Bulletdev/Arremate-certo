/*     */ package org.h2.server;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.FilterInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.net.Socket;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import org.h2.command.Command;
/*     */ import org.h2.engine.ConnectionInfo;
/*     */ import org.h2.engine.Engine;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.SessionInterface;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.expression.Parameter;
/*     */ import org.h2.expression.ParameterInterface;
/*     */ import org.h2.expression.ParameterRemote;
/*     */ import org.h2.jdbc.JdbcSQLException;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.ResultColumn;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.store.LobStorageInterface;
/*     */ import org.h2.util.IOUtils;
/*     */ import org.h2.util.SmallLRUCache;
/*     */ import org.h2.util.SmallMap;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.value.Transfer;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueLobDb;
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
/*     */ public class TcpServerThread
/*     */   implements Runnable
/*     */ {
/*     */   protected final Transfer transfer;
/*     */   private final TcpServer server;
/*     */   private Session session;
/*     */   private boolean stop;
/*     */   private Thread thread;
/*     */   private Command commit;
/*  52 */   private final SmallMap cache = new SmallMap(SysProperties.SERVER_CACHED_OBJECTS);
/*     */   
/*  54 */   private final SmallLRUCache<Long, CachedInputStream> lobs = SmallLRUCache.newInstance(Math.max(SysProperties.SERVER_CACHED_OBJECTS, SysProperties.SERVER_RESULT_SET_FETCH_SIZE * 5));
/*     */   
/*     */   private final int threadId;
/*     */   
/*     */   private int clientVersion;
/*     */   
/*     */   private String sessionId;
/*     */   
/*     */   TcpServerThread(Socket paramSocket, TcpServer paramTcpServer, int paramInt) {
/*  63 */     this.server = paramTcpServer;
/*  64 */     this.threadId = paramInt;
/*  65 */     this.transfer = new Transfer(null);
/*  66 */     this.transfer.setSocket(paramSocket);
/*     */   }
/*     */   
/*     */   private void trace(String paramString) {
/*  70 */     this.server.trace(this + " " + paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/*  76 */       this.transfer.init();
/*  77 */       trace("Connect");
/*     */ 
/*     */       
/*     */       try {
/*  81 */         if (!this.server.allow(this.transfer.getSocket())) {
/*  82 */           throw DbException.get(90117);
/*     */         }
/*  84 */         int i = this.transfer.readInt();
/*  85 */         if (i < 6) {
/*  86 */           throw DbException.get(90047, new String[] { "" + this.clientVersion, "6" });
/*     */         }
/*  88 */         if (i > 15) {
/*  89 */           throw DbException.get(90047, new String[] { "" + this.clientVersion, "15" });
/*     */         }
/*     */         
/*  92 */         int j = this.transfer.readInt();
/*  93 */         if (j >= 15) {
/*  94 */           this.clientVersion = 15;
/*     */         } else {
/*  96 */           this.clientVersion = i;
/*     */         } 
/*  98 */         this.transfer.setVersion(this.clientVersion);
/*  99 */         String str1 = this.transfer.readString();
/* 100 */         String str2 = this.transfer.readString();
/* 101 */         if (str1 == null && str2 == null) {
/* 102 */           String str = this.transfer.readString();
/* 103 */           int m = this.transfer.readInt();
/* 104 */           this.stop = true;
/* 105 */           if (m == 13) {
/*     */             
/* 107 */             int n = this.transfer.readInt();
/* 108 */             this.server.cancelStatement(str, n);
/* 109 */           } else if (m == 14) {
/*     */             
/* 111 */             str1 = this.server.checkKeyAndGetDatabaseName(str);
/* 112 */             if (!str.equals(str1)) {
/* 113 */               this.transfer.writeInt(1);
/*     */             } else {
/* 115 */               this.transfer.writeInt(0);
/*     */             } 
/*     */           } 
/*     */         } 
/* 119 */         String str3 = this.server.getBaseDir();
/* 120 */         if (str3 == null) {
/* 121 */           str3 = SysProperties.getBaseDir();
/*     */         }
/* 123 */         str1 = this.server.checkKeyAndGetDatabaseName(str1);
/* 124 */         ConnectionInfo connectionInfo = new ConnectionInfo(str1);
/* 125 */         connectionInfo.setOriginalURL(str2);
/* 126 */         connectionInfo.setUserName(this.transfer.readString());
/* 127 */         connectionInfo.setUserPasswordHash(this.transfer.readBytes());
/* 128 */         connectionInfo.setFilePasswordHash(this.transfer.readBytes());
/* 129 */         int k = this.transfer.readInt();
/* 130 */         for (byte b = 0; b < k; b++) {
/* 131 */           connectionInfo.setProperty(this.transfer.readString(), this.transfer.readString());
/*     */         }
/*     */         
/* 134 */         if (str3 != null) {
/* 135 */           connectionInfo.setBaseDir(str3);
/*     */         }
/* 137 */         if (this.server.getIfExists()) {
/* 138 */           connectionInfo.setProperty("IFEXISTS", "TRUE");
/*     */         }
/* 140 */         this.transfer.writeInt(1);
/* 141 */         this.transfer.writeInt(this.clientVersion);
/* 142 */         this.transfer.flush();
/* 143 */         if (this.clientVersion >= 13 && 
/* 144 */           connectionInfo.getFilePasswordHash() != null) {
/* 145 */           connectionInfo.setFileEncryptionKey(this.transfer.readBytes());
/*     */         }
/*     */         
/* 148 */         this.session = Engine.getInstance().createSession(connectionInfo);
/* 149 */         this.transfer.setSession((SessionInterface)this.session);
/* 150 */         this.server.addConnection(this.threadId, str2, connectionInfo.getUserName());
/* 151 */         trace("Connected");
/* 152 */       } catch (Throwable throwable) {
/* 153 */         sendError(throwable);
/* 154 */         this.stop = true;
/*     */       } 
/* 156 */       while (!this.stop) {
/*     */         try {
/* 158 */           process();
/* 159 */         } catch (Throwable throwable) {
/* 160 */           sendError(throwable);
/*     */         } 
/*     */       } 
/* 163 */       trace("Disconnect");
/* 164 */     } catch (Throwable throwable) {
/* 165 */       this.server.traceError(throwable);
/*     */     } finally {
/* 167 */       close();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void closeSession() {
/* 172 */     if (this.session != null) {
/* 173 */       RuntimeException runtimeException = null;
/*     */       try {
/* 175 */         Command command = this.session.prepareLocal("ROLLBACK");
/* 176 */         command.executeUpdate();
/* 177 */       } catch (RuntimeException runtimeException1) {
/* 178 */         runtimeException = runtimeException1;
/* 179 */         this.server.traceError(runtimeException1);
/* 180 */       } catch (Exception exception) {
/* 181 */         this.server.traceError(exception);
/*     */       } 
/*     */       try {
/* 184 */         this.session.close();
/* 185 */         this.server.removeConnection(this.threadId);
/* 186 */       } catch (RuntimeException runtimeException1) {
/* 187 */         if (runtimeException == null) {
/* 188 */           runtimeException = runtimeException1;
/* 189 */           this.server.traceError(runtimeException1);
/*     */         } 
/* 191 */       } catch (Exception exception) {
/* 192 */         this.server.traceError(exception);
/*     */       } finally {
/* 194 */         this.session = null;
/*     */       } 
/* 196 */       if (runtimeException != null) {
/* 197 */         throw runtimeException;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void close() {
/*     */     try {
/* 207 */       this.stop = true;
/* 208 */       closeSession();
/* 209 */     } catch (Exception exception) {
/* 210 */       this.server.traceError(exception);
/*     */     } finally {
/* 212 */       this.transfer.close();
/* 213 */       trace("Close");
/* 214 */       this.server.remove(this);
/*     */     } 
/*     */   }
/*     */   private void sendError(Throwable paramThrowable) {
/*     */     try {
/*     */       String str2, str3;
/* 220 */       SQLException sQLException = DbException.convert(paramThrowable).getSQLException();
/* 221 */       StringWriter stringWriter = new StringWriter();
/* 222 */       sQLException.printStackTrace(new PrintWriter(stringWriter));
/* 223 */       String str1 = stringWriter.toString();
/*     */ 
/*     */       
/* 226 */       if (sQLException instanceof JdbcSQLException) {
/* 227 */         JdbcSQLException jdbcSQLException = (JdbcSQLException)sQLException;
/* 228 */         str2 = jdbcSQLException.getOriginalMessage();
/* 229 */         str3 = jdbcSQLException.getSQL();
/*     */       } else {
/* 231 */         str2 = sQLException.getMessage();
/* 232 */         str3 = null;
/*     */       } 
/* 234 */       this.transfer.writeInt(0).writeString(sQLException.getSQLState()).writeString(str2).writeString(str3).writeInt(sQLException.getErrorCode()).writeString(str1).flush();
/*     */     
/*     */     }
/* 237 */     catch (Exception exception) {
/* 238 */       if (!this.transfer.isClosed()) {
/* 239 */         this.server.traceError(exception);
/*     */       }
/*     */       
/* 242 */       this.stop = true;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void setParameters(Command paramCommand) throws IOException {
/* 247 */     int i = this.transfer.readInt();
/* 248 */     ArrayList<Parameter> arrayList = paramCommand.getParameters();
/* 249 */     for (byte b = 0; b < i; b++) {
/* 250 */       Parameter parameter = arrayList.get(b);
/* 251 */       parameter.setValue(this.transfer.readValue());
/*     */     }  } private void process() throws IOException { int j; boolean bool1; long l1; String str; int n; Command command1; int m; ResultInterface resultInterface1; int k, i2; Command command2; int i1; ResultInterface resultInterface2; Object object; Command command3; ResultInterface resultInterface3; int i3; CachedInputStream cachedInputStream; boolean bool2; int i5; Command command4; int i4; boolean bool3; int i6; long l2; ArrayList arrayList; ResultInterface resultInterface4; int i7, i8;
/*     */     byte[] arrayOfByte;
/*     */     int i9, i10;
/*     */     byte b;
/* 256 */     int i = this.transfer.readInt();
/* 257 */     switch (i) {
/*     */       case 0:
/*     */       case 11:
/* 260 */         j = this.transfer.readInt();
/* 261 */         str = this.transfer.readString();
/* 262 */         i2 = this.session.getModificationId();
/* 263 */         command3 = this.session.prepareLocal(str);
/* 264 */         bool2 = command3.isReadOnly();
/* 265 */         this.cache.addObject(j, command3);
/* 266 */         bool3 = command3.isQuery();
/* 267 */         arrayList = command3.getParameters();
/* 268 */         this.transfer.writeInt(getState(i2)).writeBoolean(bool3).writeBoolean(bool2).writeInt(arrayList.size());
/*     */         
/* 270 */         if (i == 11) {
/* 271 */           for (ParameterInterface parameterInterface : arrayList) {
/* 272 */             ParameterRemote.writeMetaData(this.transfer, parameterInterface);
/*     */           }
/*     */         }
/* 275 */         this.transfer.flush();
/*     */         return;
/*     */       
/*     */       case 1:
/* 279 */         this.stop = true;
/* 280 */         closeSession();
/* 281 */         this.transfer.writeInt(1).flush();
/* 282 */         close();
/*     */         return;
/*     */       
/*     */       case 8:
/* 286 */         if (this.commit == null) {
/* 287 */           this.commit = this.session.prepareLocal("COMMIT");
/*     */         }
/* 289 */         j = this.session.getModificationId();
/* 290 */         this.commit.executeUpdate();
/* 291 */         this.transfer.writeInt(getState(j)).flush();
/*     */         return;
/*     */       
/*     */       case 10:
/* 295 */         j = this.transfer.readInt();
/* 296 */         n = this.transfer.readInt();
/* 297 */         command2 = (Command)this.cache.getObject(j, false);
/* 298 */         resultInterface3 = command2.getMetaData();
/* 299 */         this.cache.addObject(n, resultInterface3);
/* 300 */         i5 = resultInterface3.getVisibleColumnCount();
/* 301 */         this.transfer.writeInt(1).writeInt(i5).writeInt(0);
/*     */         
/* 303 */         for (bool3 = false; bool3 < i5; bool3++) {
/* 304 */           ResultColumn.writeColumn(this.transfer, resultInterface3, bool3);
/*     */         }
/* 306 */         this.transfer.flush();
/*     */         return;
/*     */       
/*     */       case 2:
/* 310 */         j = this.transfer.readInt();
/* 311 */         n = this.transfer.readInt();
/* 312 */         i1 = this.transfer.readInt();
/* 313 */         i3 = this.transfer.readInt();
/* 314 */         command4 = (Command)this.cache.getObject(j, false);
/* 315 */         setParameters(command4);
/* 316 */         i6 = this.session.getModificationId();
/*     */         
/* 318 */         synchronized (this.session) {
/* 319 */           resultInterface4 = command4.executeQuery(i1, false);
/*     */         } 
/* 321 */         this.cache.addObject(n, resultInterface4);
/* 322 */         i7 = resultInterface4.getVisibleColumnCount();
/* 323 */         i8 = getState(i6);
/* 324 */         this.transfer.writeInt(i8).writeInt(i7);
/* 325 */         i9 = resultInterface4.getRowCount();
/* 326 */         this.transfer.writeInt(i9);
/* 327 */         for (i10 = 0; i10 < i7; i10++) {
/* 328 */           ResultColumn.writeColumn(this.transfer, resultInterface4, i10);
/*     */         }
/* 330 */         i10 = Math.min(i9, i3);
/* 331 */         for (b = 0; b < i10; b++) {
/* 332 */           sendRow(resultInterface4);
/*     */         }
/* 334 */         this.transfer.flush();
/*     */         return;
/*     */       
/*     */       case 3:
/* 338 */         j = this.transfer.readInt();
/* 339 */         command1 = (Command)this.cache.getObject(j, false);
/* 340 */         setParameters(command1);
/* 341 */         i1 = this.session.getModificationId();
/*     */         
/* 343 */         synchronized (this.session) {
/* 344 */           i3 = command1.executeUpdate();
/*     */         } 
/*     */         
/* 347 */         if (this.session.isClosed()) {
/* 348 */           i4 = 2;
/* 349 */           this.stop = true;
/*     */         } else {
/* 351 */           i4 = getState(i1);
/*     */         } 
/* 353 */         this.transfer.writeInt(i4).writeInt(i3).writeBoolean(this.session.getAutoCommit());
/*     */         
/* 355 */         this.transfer.flush();
/*     */         return;
/*     */       
/*     */       case 4:
/* 359 */         j = this.transfer.readInt();
/* 360 */         command1 = (Command)this.cache.getObject(j, true);
/* 361 */         if (command1 != null) {
/* 362 */           command1.close();
/* 363 */           this.cache.freeObject(j);
/*     */         } 
/*     */         return;
/*     */       
/*     */       case 5:
/* 368 */         j = this.transfer.readInt();
/* 369 */         m = this.transfer.readInt();
/* 370 */         resultInterface2 = (ResultInterface)this.cache.getObject(j, false);
/* 371 */         this.transfer.writeInt(1);
/* 372 */         for (i3 = 0; i3 < m; i3++) {
/* 373 */           sendRow(resultInterface2);
/*     */         }
/* 375 */         this.transfer.flush();
/*     */         return;
/*     */       
/*     */       case 6:
/* 379 */         j = this.transfer.readInt();
/* 380 */         resultInterface1 = (ResultInterface)this.cache.getObject(j, false);
/* 381 */         resultInterface1.reset();
/*     */         return;
/*     */       
/*     */       case 7:
/* 385 */         j = this.transfer.readInt();
/* 386 */         resultInterface1 = (ResultInterface)this.cache.getObject(j, true);
/* 387 */         if (resultInterface1 != null) {
/* 388 */           resultInterface1.close();
/* 389 */           this.cache.freeObject(j);
/*     */         } 
/*     */         return;
/*     */       
/*     */       case 9:
/* 394 */         j = this.transfer.readInt();
/* 395 */         k = this.transfer.readInt();
/* 396 */         object = this.cache.getObject(j, false);
/* 397 */         this.cache.freeObject(j);
/* 398 */         this.cache.addObject(k, object);
/*     */         return;
/*     */       
/*     */       case 12:
/* 402 */         this.sessionId = this.transfer.readString();
/* 403 */         this.transfer.writeInt(1);
/* 404 */         this.transfer.writeBoolean(this.session.getAutoCommit());
/* 405 */         this.transfer.flush();
/*     */         return;
/*     */       
/*     */       case 15:
/* 409 */         bool1 = this.transfer.readBoolean();
/* 410 */         this.session.setAutoCommit(bool1);
/* 411 */         this.transfer.writeInt(1).flush();
/*     */         return;
/*     */       
/*     */       case 16:
/* 415 */         this.transfer.writeInt(1).writeInt(this.session.hasPendingTransaction() ? 1 : 0).flush();
/*     */         return;
/*     */ 
/*     */       
/*     */       case 17:
/* 420 */         l1 = this.transfer.readLong();
/*     */ 
/*     */ 
/*     */         
/* 424 */         if (this.clientVersion >= 11) {
/* 425 */           if (this.clientVersion >= 12) {
/* 426 */             object = this.transfer.readBytes();
/* 427 */             i4 = 1;
/*     */           } else {
/* 429 */             object = null;
/* 430 */             i4 = 0;
/*     */           } 
/* 432 */           cachedInputStream = (CachedInputStream)this.lobs.get(Long.valueOf(l1));
/* 433 */           if (cachedInputStream == null && i4 != 0) {
/* 434 */             cachedInputStream = new CachedInputStream(null);
/* 435 */             this.lobs.put(Long.valueOf(l1), cachedInputStream);
/*     */           } 
/*     */         } else {
/* 438 */           i4 = 0;
/* 439 */           object = null;
/* 440 */           cachedInputStream = (CachedInputStream)this.lobs.get(Long.valueOf(l1));
/*     */         } 
/* 442 */         l2 = this.transfer.readLong();
/* 443 */         i7 = this.transfer.readInt();
/* 444 */         if (i4 != 0) {
/* 445 */           this.transfer.verifyLobMac((byte[])object, l1);
/*     */         }
/* 447 */         if (cachedInputStream == null) {
/* 448 */           throw DbException.get(90007);
/*     */         }
/* 450 */         if (cachedInputStream.getPos() != l2) {
/* 451 */           LobStorageInterface lobStorageInterface = this.session.getDataHandler().getLobStorage();
/*     */           
/* 453 */           ValueLobDb valueLobDb = ValueLobDb.create(15, null, -1, l1, (byte[])object, -1L);
/* 454 */           InputStream inputStream = lobStorageInterface.getInputStream(valueLobDb, (byte[])object, -1L);
/* 455 */           cachedInputStream = new CachedInputStream(inputStream);
/* 456 */           this.lobs.put(Long.valueOf(l1), cachedInputStream);
/* 457 */           inputStream.skip(l2);
/*     */         } 
/*     */         
/* 460 */         i7 = Math.min(65536, i7);
/* 461 */         arrayOfByte = new byte[i7];
/* 462 */         i7 = IOUtils.readFully(cachedInputStream, arrayOfByte, i7);
/* 463 */         this.transfer.writeInt(1);
/* 464 */         this.transfer.writeInt(i7);
/* 465 */         this.transfer.writeBytes(arrayOfByte, 0, i7);
/* 466 */         this.transfer.flush();
/*     */         return;
/*     */     } 
/*     */     
/* 470 */     trace("Unknown operation: " + i);
/* 471 */     closeSession();
/* 472 */     close(); }
/*     */ 
/*     */ 
/*     */   
/*     */   private int getState(int paramInt) {
/* 477 */     if (this.session.getModificationId() == paramInt) {
/* 478 */       return 1;
/*     */     }
/* 480 */     return 3;
/*     */   }
/*     */   
/*     */   private void sendRow(ResultInterface paramResultInterface) throws IOException {
/* 484 */     if (paramResultInterface.next()) {
/* 485 */       this.transfer.writeBoolean(true);
/* 486 */       Value[] arrayOfValue = paramResultInterface.currentRow();
/* 487 */       for (byte b = 0; b < paramResultInterface.getVisibleColumnCount(); b++) {
/* 488 */         if (this.clientVersion >= 12) {
/* 489 */           this.transfer.writeValue(arrayOfValue[b]);
/*     */         } else {
/* 491 */           writeValue(arrayOfValue[b]);
/*     */         } 
/*     */       } 
/*     */     } else {
/* 495 */       this.transfer.writeBoolean(false);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void writeValue(Value paramValue) throws IOException {
/* 500 */     if ((paramValue.getType() == 16 || paramValue.getType() == 15) && 
/* 501 */       paramValue instanceof ValueLobDb) {
/* 502 */       ValueLobDb valueLobDb = (ValueLobDb)paramValue;
/* 503 */       if (valueLobDb.isStored()) {
/* 504 */         long l = valueLobDb.getLobId();
/* 505 */         this.lobs.put(Long.valueOf(l), new CachedInputStream(null));
/*     */       } 
/*     */     } 
/*     */     
/* 509 */     this.transfer.writeValue(paramValue);
/*     */   }
/*     */   
/*     */   void setThread(Thread paramThread) {
/* 513 */     this.thread = paramThread;
/*     */   }
/*     */   
/*     */   Thread getThread() {
/* 517 */     return this.thread;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void cancelStatement(String paramString, int paramInt) {
/* 527 */     if (StringUtils.equals(paramString, this.sessionId)) {
/* 528 */       Command command = (Command)this.cache.getObject(paramInt, false);
/* 529 */       command.cancel();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class CachedInputStream
/*     */     extends FilterInputStream
/*     */   {
/* 538 */     private static final ByteArrayInputStream DUMMY = new ByteArrayInputStream(new byte[0]);
/*     */     
/*     */     private long pos;
/*     */     
/*     */     CachedInputStream(InputStream param1InputStream) {
/* 543 */       super((param1InputStream == null) ? DUMMY : param1InputStream);
/* 544 */       if (param1InputStream == null) {
/* 545 */         this.pos = -1L;
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
/* 551 */       param1Int2 = super.read(param1ArrayOfbyte, param1Int1, param1Int2);
/* 552 */       if (param1Int2 > 0) {
/* 553 */         this.pos += param1Int2;
/*     */       }
/* 555 */       return param1Int2;
/*     */     }
/*     */ 
/*     */     
/*     */     public int read() throws IOException {
/* 560 */       int i = this.in.read();
/* 561 */       if (i >= 0) {
/* 562 */         this.pos++;
/*     */       }
/* 564 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public long skip(long param1Long) throws IOException {
/* 569 */       param1Long = super.skip(param1Long);
/* 570 */       if (param1Long > 0L) {
/* 571 */         this.pos += param1Long;
/*     */       }
/* 573 */       return param1Long;
/*     */     }
/*     */     
/*     */     public long getPos() {
/* 577 */       return this.pos;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\server\TcpServerThread.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */