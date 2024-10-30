/*     */ package org.h2.store;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.net.BindException;
/*     */ import java.net.ConnectException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.Socket;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.Properties;
/*     */ import org.h2.Driver;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.message.Trace;
/*     */ import org.h2.message.TraceSystem;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.NetUtils;
/*     */ import org.h2.util.SortedProperties;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.value.Transfer;
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
/*     */ 
/*     */ public class FileLock
/*     */   implements Runnable
/*     */ {
/*     */   public static final int LOCK_NO = 0;
/*     */   public static final int LOCK_FILE = 1;
/*     */   public static final int LOCK_SOCKET = 2;
/*     */   public static final int LOCK_SERIALIZED = 3;
/*     */   public static final int LOCK_FS = 4;
/*     */   private static final String MAGIC = "FileLock";
/*     */   private static final String FILE = "file";
/*     */   private static final String SOCKET = "socket";
/*     */   private static final String SERIALIZED = "serialized";
/*     */   private static final int RANDOM_BYTES = 16;
/*     */   private static final int SLEEP_GAP = 25;
/*     */   private static final int TIME_GRANULARITY = 2000;
/*     */   private volatile String fileName;
/*     */   private volatile ServerSocket serverSocket;
/*     */   private volatile boolean locked;
/*     */   private final int sleep;
/*     */   private final Trace trace;
/*     */   private long lastWrite;
/*     */   private String method;
/*     */   private String ipAddress;
/*     */   private Properties properties;
/*     */   private String uniqueId;
/*     */   private Thread watchdog;
/*     */   
/*     */   public FileLock(TraceSystem paramTraceSystem, String paramString, int paramInt) {
/* 116 */     this.trace = (paramTraceSystem == null) ? null : paramTraceSystem.getTrace(4);
/*     */     
/* 118 */     this.fileName = paramString;
/* 119 */     this.sleep = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void lock(int paramInt) {
/* 129 */     checkServer();
/* 130 */     if (this.locked) {
/* 131 */       DbException.throwInternalError("already locked");
/*     */     }
/* 133 */     switch (paramInt) {
/*     */       case 1:
/* 135 */         lockFile();
/*     */         break;
/*     */       case 2:
/* 138 */         lockSocket();
/*     */         break;
/*     */       case 3:
/* 141 */         lockSerialized();
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 146 */     this.locked = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void unlock() {
/* 154 */     if (!this.locked) {
/*     */       return;
/*     */     }
/* 157 */     this.locked = false;
/*     */     try {
/* 159 */       if (this.watchdog != null) {
/* 160 */         this.watchdog.interrupt();
/*     */       }
/* 162 */     } catch (Exception exception) {
/* 163 */       this.trace.debug(exception, "unlock");
/*     */     } 
/*     */     try {
/* 166 */       if (this.fileName != null && 
/* 167 */         load().equals(this.properties)) {
/* 168 */         FileUtils.delete(this.fileName);
/*     */       }
/*     */       
/* 171 */       if (this.serverSocket != null) {
/* 172 */         this.serverSocket.close();
/*     */       }
/* 174 */     } catch (Exception exception) {
/* 175 */       this.trace.debug(exception, "unlock");
/*     */     } finally {
/* 177 */       this.fileName = null;
/* 178 */       this.serverSocket = null;
/*     */     } 
/*     */     try {
/* 181 */       if (this.watchdog != null) {
/* 182 */         this.watchdog.join();
/*     */       }
/* 184 */     } catch (Exception exception) {
/* 185 */       this.trace.debug(exception, "unlock");
/*     */     } finally {
/* 187 */       this.watchdog = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProperty(String paramString1, String paramString2) {
/* 199 */     if (paramString2 == null) {
/* 200 */       this.properties.remove(paramString1);
/*     */     } else {
/* 202 */       this.properties.put(paramString1, paramString2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Properties save() {
/*     */     try {
/* 213 */       try (OutputStream null = FileUtils.newOutputStream(this.fileName, false)) {
/* 214 */         this.properties.store(outputStream, "FileLock");
/*     */       } 
/* 216 */       this.lastWrite = FileUtils.lastModified(this.fileName);
/* 217 */       if (this.trace.isDebugEnabled()) {
/* 218 */         this.trace.debug("save " + this.properties);
/*     */       }
/* 220 */       return this.properties;
/* 221 */     } catch (IOException iOException) {
/* 222 */       throw getExceptionFatal("Could not save properties " + this.fileName, iOException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void checkServer() {
/* 227 */     Properties properties = load();
/* 228 */     String str1 = properties.getProperty("server");
/* 229 */     if (str1 == null) {
/*     */       return;
/*     */     }
/* 232 */     boolean bool = false;
/* 233 */     String str2 = properties.getProperty("id");
/*     */     try {
/* 235 */       Socket socket = NetUtils.createSocket(str1, 9092, false);
/*     */       
/* 237 */       Transfer transfer = new Transfer(null);
/* 238 */       transfer.setSocket(socket);
/* 239 */       transfer.init();
/* 240 */       transfer.writeInt(6);
/* 241 */       transfer.writeInt(15);
/* 242 */       transfer.writeString(null);
/* 243 */       transfer.writeString(null);
/* 244 */       transfer.writeString(str2);
/* 245 */       transfer.writeInt(14);
/* 246 */       transfer.flush();
/* 247 */       int i = transfer.readInt();
/* 248 */       if (i == 1) {
/* 249 */         bool = true;
/*     */       }
/* 251 */       transfer.close();
/* 252 */       socket.close();
/* 253 */     } catch (IOException iOException) {
/*     */       return;
/*     */     } 
/* 256 */     if (bool) {
/* 257 */       DbException dbException = DbException.get(90020, "Server is running");
/*     */       
/* 259 */       throw dbException.addSQL(str1 + "/" + str2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Properties load() {
/* 269 */     IOException iOException = null;
/* 270 */     for (byte b = 0; b < 5; b++) {
/*     */       try {
/* 272 */         SortedProperties sortedProperties = SortedProperties.loadProperties(this.fileName);
/* 273 */         if (this.trace.isDebugEnabled()) {
/* 274 */           this.trace.debug("load " + sortedProperties);
/*     */         }
/* 276 */         return (Properties)sortedProperties;
/* 277 */       } catch (IOException iOException1) {
/* 278 */         iOException = iOException1;
/*     */       } 
/*     */     } 
/* 281 */     throw getExceptionFatal("Could not load properties " + this.fileName, iOException);
/*     */   }
/*     */ 
/*     */   
/*     */   private void waitUntilOld() {
/* 286 */     for (byte b = 0; b < ' '; b++) {
/* 287 */       long l1 = FileUtils.lastModified(this.fileName);
/* 288 */       long l2 = System.currentTimeMillis() - l1;
/* 289 */       if (l2 < -2000L) {
/*     */ 
/*     */         
/*     */         try {
/* 293 */           Thread.sleep(2L * this.sleep);
/* 294 */         } catch (Exception exception) {
/* 295 */           this.trace.debug(exception, "sleep");
/*     */         }  return;
/*     */       } 
/* 298 */       if (l2 > 2000L) {
/*     */         return;
/*     */       }
/*     */       try {
/* 302 */         Thread.sleep(25L);
/* 303 */       } catch (Exception exception) {
/* 304 */         this.trace.debug(exception, "sleep");
/*     */       } 
/*     */     } 
/* 307 */     throw getExceptionFatal("Lock file recently modified", null);
/*     */   }
/*     */   
/*     */   private void setUniqueId() {
/* 311 */     byte[] arrayOfByte = MathUtils.secureRandomBytes(16);
/* 312 */     String str = StringUtils.convertBytesToHex(arrayOfByte);
/* 313 */     this.uniqueId = Long.toHexString(System.currentTimeMillis()) + str;
/* 314 */     this.properties.setProperty("id", this.uniqueId);
/*     */   }
/*     */   
/*     */   private void lockSerialized() {
/* 318 */     this.method = "serialized";
/* 319 */     FileUtils.createDirectories(FileUtils.getParent(this.fileName));
/* 320 */     if (FileUtils.createFile(this.fileName)) {
/* 321 */       this.properties = (Properties)new SortedProperties();
/* 322 */       this.properties.setProperty("method", String.valueOf(this.method));
/* 323 */       setUniqueId();
/* 324 */       save();
/*     */     } else {
/*     */       
/*     */       try {
/* 328 */         this.properties = load();
/* 329 */       } catch (DbException dbException) {}
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void lockFile() {
/* 338 */     this.method = "file";
/* 339 */     this.properties = (Properties)new SortedProperties();
/* 340 */     this.properties.setProperty("method", String.valueOf(this.method));
/* 341 */     setUniqueId();
/* 342 */     FileUtils.createDirectories(FileUtils.getParent(this.fileName));
/* 343 */     if (!FileUtils.createFile(this.fileName)) {
/* 344 */       waitUntilOld();
/* 345 */       String str = load().getProperty("method", "file");
/* 346 */       if (!str.equals("file")) {
/* 347 */         throw getExceptionFatal("Unsupported lock method " + str, null);
/*     */       }
/* 349 */       save();
/* 350 */       sleep(2 * this.sleep);
/* 351 */       if (!load().equals(this.properties)) {
/* 352 */         throw getExceptionAlreadyInUse("Locked by another process: " + this.fileName);
/*     */       }
/* 354 */       FileUtils.delete(this.fileName);
/* 355 */       if (!FileUtils.createFile(this.fileName)) {
/* 356 */         throw getExceptionFatal("Another process was faster", null);
/*     */       }
/*     */     } 
/* 359 */     save();
/* 360 */     sleep(25);
/* 361 */     if (!load().equals(this.properties)) {
/* 362 */       this.fileName = null;
/* 363 */       throw getExceptionFatal("Concurrent update", null);
/*     */     } 
/* 365 */     this.locked = true;
/* 366 */     this.watchdog = new Thread(this, "H2 File Lock Watchdog " + this.fileName);
/* 367 */     Driver.setThreadContextClassLoader(this.watchdog);
/* 368 */     this.watchdog.setDaemon(true);
/* 369 */     this.watchdog.setPriority(9);
/* 370 */     this.watchdog.start();
/*     */   }
/*     */   
/*     */   private void lockSocket() {
/* 374 */     this.method = "socket";
/* 375 */     this.properties = (Properties)new SortedProperties();
/* 376 */     this.properties.setProperty("method", String.valueOf(this.method));
/* 377 */     setUniqueId();
/*     */ 
/*     */     
/* 380 */     this.ipAddress = NetUtils.getLocalAddress();
/* 381 */     FileUtils.createDirectories(FileUtils.getParent(this.fileName));
/* 382 */     if (!FileUtils.createFile(this.fileName)) {
/* 383 */       InetAddress inetAddress; waitUntilOld();
/* 384 */       long l = FileUtils.lastModified(this.fileName);
/* 385 */       Properties properties = load();
/* 386 */       String str1 = properties.getProperty("method", "socket");
/* 387 */       if (str1.equals("file")) {
/* 388 */         lockFile(); return;
/*     */       } 
/* 390 */       if (!str1.equals("socket")) {
/* 391 */         throw getExceptionFatal("Unsupported lock method " + str1, null);
/*     */       }
/* 393 */       String str2 = properties.getProperty("ipAddress", this.ipAddress);
/* 394 */       if (!this.ipAddress.equals(str2)) {
/* 395 */         throw getExceptionAlreadyInUse("Locked by another computer: " + str2);
/*     */       }
/* 397 */       String str3 = properties.getProperty("port", "0");
/* 398 */       int i = Integer.parseInt(str3);
/*     */       
/*     */       try {
/* 401 */         inetAddress = InetAddress.getByName(str2);
/* 402 */       } catch (UnknownHostException unknownHostException) {
/* 403 */         throw getExceptionFatal("Unknown host " + str2, unknownHostException);
/*     */       } 
/* 405 */       for (byte b = 0; b < 3; b++) {
/*     */         try {
/* 407 */           Socket socket = new Socket(inetAddress, i);
/* 408 */           socket.close();
/* 409 */           throw getExceptionAlreadyInUse("Locked by another process");
/* 410 */         } catch (BindException bindException) {
/* 411 */           throw getExceptionFatal("Bind Exception", null);
/* 412 */         } catch (ConnectException connectException) {
/* 413 */           this.trace.debug(connectException, "socket not connected to port " + str3);
/* 414 */         } catch (IOException iOException) {
/* 415 */           throw getExceptionFatal("IOException", null);
/*     */         } 
/*     */       } 
/* 418 */       if (l != FileUtils.lastModified(this.fileName)) {
/* 419 */         throw getExceptionFatal("Concurrent update", null);
/*     */       }
/* 421 */       FileUtils.delete(this.fileName);
/* 422 */       if (!FileUtils.createFile(this.fileName)) {
/* 423 */         throw getExceptionFatal("Another process was faster", null);
/*     */       }
/*     */     } 
/*     */     
/*     */     try {
/* 428 */       this.serverSocket = NetUtils.createServerSocket(0, false);
/* 429 */       int i = this.serverSocket.getLocalPort();
/* 430 */       this.properties.setProperty("ipAddress", this.ipAddress);
/* 431 */       this.properties.setProperty("port", String.valueOf(i));
/* 432 */     } catch (Exception exception) {
/* 433 */       this.trace.debug(exception, "lock");
/* 434 */       this.serverSocket = null;
/* 435 */       lockFile();
/*     */       return;
/*     */     } 
/* 438 */     save();
/* 439 */     this.locked = true;
/* 440 */     this.watchdog = new Thread(this, "H2 File Lock Watchdog (Socket) " + this.fileName);
/*     */     
/* 442 */     this.watchdog.setDaemon(true);
/* 443 */     this.watchdog.start();
/*     */   }
/*     */   
/*     */   private static void sleep(int paramInt) {
/*     */     try {
/* 448 */       Thread.sleep(paramInt);
/* 449 */     } catch (InterruptedException interruptedException) {
/* 450 */       throw getExceptionFatal("Sleep interrupted", interruptedException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static DbException getExceptionFatal(String paramString, Throwable paramThrowable) {
/* 455 */     return DbException.get(8000, paramThrowable, new String[] { paramString });
/*     */   }
/*     */ 
/*     */   
/*     */   private DbException getExceptionAlreadyInUse(String paramString) {
/* 460 */     DbException dbException = DbException.get(90020, paramString);
/*     */     
/* 462 */     if (this.fileName != null) {
/*     */       try {
/* 464 */         Properties properties = load();
/* 465 */         String str = properties.getProperty("server");
/* 466 */         if (str != null) {
/* 467 */           String str1 = str + "/" + properties.getProperty("id");
/* 468 */           dbException = dbException.addSQL(str1);
/*     */         } 
/* 470 */       } catch (DbException dbException1) {}
/*     */     }
/*     */ 
/*     */     
/* 474 */     return dbException;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getFileLockMethod(String paramString) {
/* 485 */     if (paramString == null || paramString.equalsIgnoreCase("FILE"))
/* 486 */       return 1; 
/* 487 */     if (paramString.equalsIgnoreCase("NO"))
/* 488 */       return 0; 
/* 489 */     if (paramString.equalsIgnoreCase("SOCKET"))
/* 490 */       return 2; 
/* 491 */     if (paramString.equalsIgnoreCase("SERIALIZED"))
/* 492 */       return 3; 
/* 493 */     if (paramString.equalsIgnoreCase("FS")) {
/* 494 */       return 4;
/*     */     }
/* 496 */     throw DbException.get(90060, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUniqueId() {
/* 502 */     return this.uniqueId;
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/* 508 */       while (this.locked && this.fileName != null) {
/*     */         
/*     */         try {
/* 511 */           if (!FileUtils.exists(this.fileName) || FileUtils.lastModified(this.fileName) != this.lastWrite)
/*     */           {
/* 513 */             save();
/*     */           }
/* 515 */           Thread.sleep(this.sleep);
/* 516 */         } catch (OutOfMemoryError outOfMemoryError) {
/*     */         
/* 518 */         } catch (InterruptedException interruptedException) {
/*     */         
/* 520 */         } catch (NullPointerException nullPointerException) {
/*     */         
/* 522 */         } catch (Exception exception) {
/* 523 */           this.trace.debug(exception, "watchdog");
/*     */         } 
/*     */       } 
/* 526 */       while (this.serverSocket != null) {
/*     */         try {
/* 528 */           this.trace.debug("watchdog accept");
/* 529 */           Socket socket = this.serverSocket.accept();
/* 530 */           socket.close();
/* 531 */         } catch (Exception exception) {
/* 532 */           this.trace.debug(exception, "watchdog");
/*     */         } 
/*     */       } 
/* 535 */     } catch (Exception exception) {
/* 536 */       this.trace.debug(exception, "watchdog");
/*     */     } 
/* 538 */     this.trace.debug("watchdog end");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\FileLock.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */