/*     */ package org.h2.store.fs;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.channels.FileLock;
/*     */ import java.nio.channels.SeekableByteChannel;
/*     */ import org.h2.message.DbException;
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
/*     */ class FileSplit
/*     */   extends FileBase
/*     */ {
/*     */   private final FilePathSplit file;
/*     */   private final String mode;
/*     */   private final long maxLength;
/*     */   private FileChannel[] list;
/*     */   private long filePointer;
/*     */   private long length;
/*     */   
/*     */   FileSplit(FilePathSplit paramFilePathSplit, String paramString, FileChannel[] paramArrayOfFileChannel, long paramLong1, long paramLong2) {
/* 259 */     this.file = paramFilePathSplit;
/* 260 */     this.mode = paramString;
/* 261 */     this.list = paramArrayOfFileChannel;
/* 262 */     this.length = paramLong1;
/* 263 */     this.maxLength = paramLong2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void implCloseChannel() throws IOException {
/* 268 */     for (FileChannel fileChannel : this.list) {
/* 269 */       fileChannel.close();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public long position() {
/* 275 */     return this.filePointer;
/*     */   }
/*     */ 
/*     */   
/*     */   public long size() {
/* 280 */     return this.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(ByteBuffer paramByteBuffer) throws IOException {
/* 285 */     int i = paramByteBuffer.remaining();
/* 286 */     if (i == 0) {
/* 287 */       return 0;
/*     */     }
/* 289 */     i = (int)Math.min(i, this.length - this.filePointer);
/* 290 */     if (i <= 0) {
/* 291 */       return -1;
/*     */     }
/* 293 */     long l = this.filePointer % this.maxLength;
/* 294 */     i = (int)Math.min(i, this.maxLength - l);
/* 295 */     FileChannel fileChannel = getFileChannel();
/* 296 */     fileChannel.position(l);
/* 297 */     i = fileChannel.read(paramByteBuffer);
/* 298 */     this.filePointer += i;
/* 299 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public FileChannel position(long paramLong) {
/* 304 */     this.filePointer = paramLong;
/* 305 */     return this;
/*     */   }
/*     */   
/*     */   private FileChannel getFileChannel() throws IOException {
/* 309 */     int i = (int)(this.filePointer / this.maxLength);
/* 310 */     while (i >= this.list.length) {
/* 311 */       int j = this.list.length;
/* 312 */       FileChannel[] arrayOfFileChannel = new FileChannel[j + 1];
/* 313 */       System.arraycopy(this.list, 0, arrayOfFileChannel, 0, j);
/* 314 */       FilePath filePath = this.file.getBase(j);
/* 315 */       arrayOfFileChannel[j] = filePath.open(this.mode);
/* 316 */       this.list = arrayOfFileChannel;
/*     */     } 
/* 318 */     return this.list[i];
/*     */   }
/*     */ 
/*     */   
/*     */   public FileChannel truncate(long paramLong) throws IOException {
/* 323 */     if (paramLong >= this.length) {
/* 324 */       return this;
/*     */     }
/* 326 */     this.filePointer = Math.min(this.filePointer, paramLong);
/* 327 */     int i = 1 + (int)(paramLong / this.maxLength);
/* 328 */     if (i < this.list.length) {
/*     */       
/* 330 */       FileChannel[] arrayOfFileChannel = new FileChannel[i];
/*     */       
/* 332 */       for (int j = this.list.length - 1; j >= i; j--) {
/*     */         
/* 334 */         this.list[j].truncate(0L);
/* 335 */         this.list[j].close();
/*     */         try {
/* 337 */           this.file.getBase(j).delete();
/* 338 */         } catch (DbException dbException) {
/* 339 */           throw DbException.convertToIOException(dbException);
/*     */         } 
/*     */       } 
/* 342 */       System.arraycopy(this.list, 0, arrayOfFileChannel, 0, arrayOfFileChannel.length);
/* 343 */       this.list = arrayOfFileChannel;
/*     */     } 
/* 345 */     long l = paramLong - this.maxLength * (i - 1);
/* 346 */     this.list[this.list.length - 1].truncate(l);
/* 347 */     this.length = paramLong;
/* 348 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void force(boolean paramBoolean) throws IOException {
/* 353 */     for (FileChannel fileChannel : this.list) {
/* 354 */       fileChannel.force(paramBoolean);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int write(ByteBuffer paramByteBuffer) throws IOException {
/* 360 */     if (this.filePointer >= this.length && this.filePointer > this.maxLength) {
/*     */       
/* 362 */       long l1 = this.filePointer;
/* 363 */       long l2 = this.length - this.length % this.maxLength + this.maxLength;
/* 364 */       for (; l2 < this.filePointer; l2 += this.maxLength) {
/* 365 */         if (l2 > this.length) {
/*     */           
/* 367 */           position(l2 - 1L);
/* 368 */           write(ByteBuffer.wrap(new byte[1]));
/*     */         } 
/* 370 */         this.filePointer = l1;
/*     */       } 
/*     */     } 
/* 373 */     long l = this.filePointer % this.maxLength;
/* 374 */     int i = paramByteBuffer.remaining();
/* 375 */     FileChannel fileChannel = getFileChannel();
/* 376 */     fileChannel.position(l);
/* 377 */     int j = (int)Math.min(i, this.maxLength - l);
/* 378 */     if (j == i) {
/* 379 */       j = fileChannel.write(paramByteBuffer);
/*     */     } else {
/* 381 */       int k = paramByteBuffer.limit();
/* 382 */       paramByteBuffer.limit(paramByteBuffer.position() + j);
/* 383 */       j = fileChannel.write(paramByteBuffer);
/* 384 */       paramByteBuffer.limit(k);
/*     */     } 
/* 386 */     this.filePointer += j;
/* 387 */     this.length = Math.max(this.length, this.filePointer);
/* 388 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized FileLock tryLock(long paramLong1, long paramLong2, boolean paramBoolean) throws IOException {
/* 394 */     return this.list[0].tryLock(paramLong1, paramLong2, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 399 */     return this.file.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FileSplit.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */