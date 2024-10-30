/*     */ package org.h2.store;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.lang.ref.Reference;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.channels.FileLock;
/*     */ import java.util.Arrays;
/*     */ import org.h2.engine.Constants;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.security.SecureFileStore;
/*     */ import org.h2.store.fs.FileUtils;
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
/*     */ public class FileStore
/*     */ {
/*     */   public static final int HEADER_LENGTH = 48;
/*  36 */   private static final String HEADER = "-- H2 0.5/B --      ".substring(0, 15) + "\n";
/*     */ 
/*     */   
/*     */   protected String name;
/*     */ 
/*     */   
/*     */   private final DataHandler handler;
/*     */ 
/*     */   
/*     */   private FileChannel file;
/*     */ 
/*     */   
/*     */   private long filePos;
/*     */ 
/*     */   
/*     */   private long fileLength;
/*     */ 
/*     */   
/*     */   private Reference<?> autoDeleteReference;
/*     */ 
/*     */   
/*     */   private boolean checkedWriting = true;
/*     */ 
/*     */   
/*     */   private final String mode;
/*     */   
/*     */   private FileLock lock;
/*     */ 
/*     */   
/*     */   protected FileStore(DataHandler paramDataHandler, String paramString1, String paramString2) {
/*  66 */     this.handler = paramDataHandler;
/*  67 */     this.name = paramString1;
/*     */     try {
/*  69 */       boolean bool = FileUtils.exists(paramString1);
/*  70 */       if (bool && !FileUtils.canWrite(paramString1)) {
/*  71 */         paramString2 = "r";
/*     */       } else {
/*  73 */         FileUtils.createDirectories(FileUtils.getParent(paramString1));
/*     */       } 
/*  75 */       this.file = FileUtils.open(paramString1, paramString2);
/*  76 */       if (bool) {
/*  77 */         this.fileLength = this.file.size();
/*     */       }
/*  79 */     } catch (IOException iOException) {
/*  80 */       throw DbException.convertIOException(iOException, "name: " + paramString1 + " mode: " + paramString2);
/*     */     } 
/*     */     
/*  83 */     this.mode = paramString2;
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
/*     */   public static FileStore open(DataHandler paramDataHandler, String paramString1, String paramString2) {
/*  95 */     return open(paramDataHandler, paramString1, paramString2, null, null, 0);
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
/*     */   
/*     */   public static FileStore open(DataHandler paramDataHandler, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfbyte) {
/* 110 */     return open(paramDataHandler, paramString1, paramString2, paramString3, paramArrayOfbyte, 1024);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static FileStore open(DataHandler paramDataHandler, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfbyte, int paramInt) {
/*     */     SecureFileStore secureFileStore;
/* 128 */     if (paramString3 == null) {
/* 129 */       FileStore fileStore = new FileStore(paramDataHandler, paramString1, paramString2);
/*     */     } else {
/* 131 */       secureFileStore = new SecureFileStore(paramDataHandler, paramString1, paramString2, paramString3, paramArrayOfbyte, paramInt);
/*     */     } 
/*     */     
/* 134 */     return (FileStore)secureFileStore;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected byte[] generateSalt() {
/* 143 */     return HEADER.getBytes(Constants.UTF8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void initKey(byte[] paramArrayOfbyte) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCheckedWriting(boolean paramBoolean) {
/* 156 */     this.checkedWriting = paramBoolean;
/*     */   }
/*     */   
/*     */   private void checkWritingAllowed() {
/* 160 */     if (this.handler != null && this.checkedWriting) {
/* 161 */       this.handler.checkWritingAllowed();
/*     */     }
/*     */   }
/*     */   
/*     */   private void checkPowerOff() {
/* 166 */     if (this.handler != null) {
/* 167 */       this.handler.checkPowerOff();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init() {
/* 176 */     byte b = 16;
/*     */     
/* 178 */     byte[] arrayOfByte = HEADER.getBytes(Constants.UTF8);
/* 179 */     if (length() < 48L) {
/*     */       
/* 181 */       this.checkedWriting = false;
/* 182 */       writeDirect(arrayOfByte, 0, b);
/* 183 */       byte[] arrayOfByte1 = generateSalt();
/* 184 */       writeDirect(arrayOfByte1, 0, b);
/* 185 */       initKey(arrayOfByte1);
/*     */       
/* 187 */       write(arrayOfByte, 0, b);
/* 188 */       this.checkedWriting = true;
/*     */     } else {
/*     */       
/* 191 */       seek(0L);
/* 192 */       byte[] arrayOfByte2 = new byte[b];
/* 193 */       readFullyDirect(arrayOfByte2, 0, b);
/* 194 */       if (!Arrays.equals(arrayOfByte2, arrayOfByte)) {
/* 195 */         throw DbException.get(90048, this.name);
/*     */       }
/* 197 */       byte[] arrayOfByte1 = new byte[b];
/* 198 */       readFullyDirect(arrayOfByte1, 0, b);
/* 199 */       initKey(arrayOfByte1);
/*     */       
/* 201 */       readFully(arrayOfByte2, 0, 16);
/* 202 */       if (!Arrays.equals(arrayOfByte2, arrayOfByte)) {
/* 203 */         throw DbException.get(90049, this.name);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 212 */     if (this.file != null) {
/*     */       try {
/* 214 */         trace("close", this.name, this.file);
/* 215 */         this.file.close();
/* 216 */       } catch (IOException iOException) {
/* 217 */         throw DbException.convertIOException(iOException, this.name);
/*     */       } finally {
/* 219 */         this.file = null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeSilently() {
/*     */     try {
/* 230 */       close();
/* 231 */     } catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeAndDeleteSilently() {
/* 240 */     if (this.file != null) {
/* 241 */       closeSilently();
/* 242 */       this.handler.getTempFileDeleter().deleteFile(this.autoDeleteReference, this.name);
/* 243 */       this.name = null;
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
/*     */   protected void readFullyDirect(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 255 */     readFully(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readFully(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 266 */     if (SysProperties.CHECK && (paramInt2 < 0 || paramInt2 % 16 != 0))
/*     */     {
/* 268 */       DbException.throwInternalError("unaligned read " + this.name + " len " + paramInt2);
/*     */     }
/*     */     
/* 271 */     checkPowerOff();
/*     */     try {
/* 273 */       FileUtils.readFully(this.file, ByteBuffer.wrap(paramArrayOfbyte, paramInt1, paramInt2));
/* 274 */     } catch (IOException iOException) {
/* 275 */       throw DbException.convertIOException(iOException, this.name);
/*     */     } 
/* 277 */     this.filePos += paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void seek(long paramLong) {
/* 286 */     if (SysProperties.CHECK && paramLong % 16L != 0L)
/*     */     {
/* 288 */       DbException.throwInternalError("unaligned seek " + this.name + " pos " + paramLong);
/*     */     }
/*     */     
/*     */     try {
/* 292 */       if (paramLong != this.filePos) {
/* 293 */         this.file.position(paramLong);
/* 294 */         this.filePos = paramLong;
/*     */       } 
/* 296 */     } catch (IOException iOException) {
/* 297 */       throw DbException.convertIOException(iOException, this.name);
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
/*     */   protected void writeDirect(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 309 */     write(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 320 */     if (SysProperties.CHECK && (paramInt2 < 0 || paramInt2 % 16 != 0))
/*     */     {
/* 322 */       DbException.throwInternalError("unaligned write " + this.name + " len " + paramInt2);
/*     */     }
/*     */     
/* 325 */     checkWritingAllowed();
/* 326 */     checkPowerOff();
/*     */     try {
/* 328 */       FileUtils.writeFully(this.file, ByteBuffer.wrap(paramArrayOfbyte, paramInt1, paramInt2));
/* 329 */     } catch (IOException iOException) {
/* 330 */       closeFileSilently();
/* 331 */       throw DbException.convertIOException(iOException, this.name);
/*     */     } 
/* 333 */     this.filePos += paramInt2;
/* 334 */     this.fileLength = Math.max(this.filePos, this.fileLength);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLength(long paramLong) {
/* 343 */     if (SysProperties.CHECK && paramLong % 16L != 0L) {
/* 344 */       DbException.throwInternalError("unaligned setLength " + this.name + " pos " + paramLong);
/*     */     }
/*     */     
/* 347 */     checkPowerOff();
/* 348 */     checkWritingAllowed();
/*     */     try {
/* 350 */       if (paramLong > this.fileLength) {
/* 351 */         long l = this.filePos;
/* 352 */         this.file.position(paramLong - 1L);
/* 353 */         FileUtils.writeFully(this.file, ByteBuffer.wrap(new byte[1]));
/* 354 */         this.file.position(l);
/*     */       } else {
/* 356 */         this.file.truncate(paramLong);
/*     */       } 
/* 358 */       this.fileLength = paramLong;
/* 359 */     } catch (IOException iOException) {
/* 360 */       closeFileSilently();
/* 361 */       throw DbException.convertIOException(iOException, this.name);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long length() {
/*     */     try {
/* 372 */       long l = this.fileLength;
/* 373 */       if (SysProperties.CHECK2) {
/* 374 */         l = this.file.size();
/* 375 */         if (l != this.fileLength) {
/* 376 */           DbException.throwInternalError("file " + this.name + " length " + l + " expected " + this.fileLength);
/*     */         }
/*     */       } 
/*     */       
/* 380 */       if (SysProperties.CHECK2 && l % 16L != 0L) {
/* 381 */         long l1 = l + 16L - l % 16L;
/*     */         
/* 383 */         this.file.truncate(l1);
/* 384 */         this.fileLength = l1;
/* 385 */         DbException.throwInternalError("unaligned file length " + this.name + " len " + l);
/*     */       } 
/*     */       
/* 388 */       return l;
/* 389 */     } catch (IOException iOException) {
/* 390 */       throw DbException.convertIOException(iOException, this.name);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getFilePointer() {
/* 400 */     if (SysProperties.CHECK2) {
/*     */       try {
/* 402 */         if (this.file.position() != this.filePos) {
/* 403 */           DbException.throwInternalError();
/*     */         }
/* 405 */       } catch (IOException iOException) {
/* 406 */         throw DbException.convertIOException(iOException, this.name);
/*     */       } 
/*     */     }
/* 409 */     return this.filePos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sync() {
/*     */     try {
/* 418 */       this.file.force(true);
/* 419 */     } catch (IOException iOException) {
/* 420 */       closeFileSilently();
/* 421 */       throw DbException.convertIOException(iOException, this.name);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void autoDelete() {
/* 429 */     if (this.autoDeleteReference == null) {
/* 430 */       this.autoDeleteReference = this.handler.getTempFileDeleter().addFile(this.name, this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void stopAutoDelete() {
/* 438 */     this.handler.getTempFileDeleter().stopAutoDelete(this.autoDeleteReference, this.name);
/* 439 */     this.autoDeleteReference = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeFile() throws IOException {
/* 446 */     this.file.close();
/* 447 */     this.file = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void closeFileSilently() {
/*     */     try {
/* 457 */       this.file.close();
/* 458 */     } catch (IOException iOException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void openFile() throws IOException {
/* 468 */     if (this.file == null) {
/* 469 */       this.file = FileUtils.open(this.name, this.mode);
/* 470 */       this.file.position(this.filePos);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void trace(String paramString1, String paramString2, Object paramObject) {
/* 475 */     if (SysProperties.TRACE_IO) {
/* 476 */       System.out.println("FileStore." + paramString1 + " " + paramString2 + " " + paramObject);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized boolean tryLock() {
/*     */     try {
/* 487 */       this.lock = this.file.tryLock();
/* 488 */       return (this.lock != null);
/* 489 */     } catch (Exception exception) {
/*     */       
/* 491 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void releaseLock() {
/* 499 */     if (this.file != null && this.lock != null) {
/*     */       try {
/* 501 */         this.lock.release();
/* 502 */       } catch (Exception exception) {}
/*     */ 
/*     */       
/* 505 */       this.lock = null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\FileStore.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */