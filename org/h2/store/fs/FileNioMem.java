/*     */ package org.h2.store.fs;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.channels.FileLock;
/*     */ import java.nio.channels.NonWritableChannelException;
/*     */ import java.nio.channels.SeekableByteChannel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class FileNioMem
/*     */   extends FileBase
/*     */ {
/*     */   final FileNioMemData data;
/*     */   private final boolean readOnly;
/*     */   private long pos;
/*     */   
/*     */   FileNioMem(FileNioMemData paramFileNioMemData, boolean paramBoolean) {
/* 267 */     this.data = paramFileNioMemData;
/* 268 */     this.readOnly = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public long size() {
/* 273 */     return this.data.length();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FileChannel truncate(long paramLong) throws IOException {
/* 279 */     if (this.readOnly) {
/* 280 */       throw new NonWritableChannelException();
/*     */     }
/* 282 */     if (paramLong < size()) {
/* 283 */       this.data.touch(this.readOnly);
/* 284 */       this.pos = Math.min(this.pos, paramLong);
/* 285 */       this.data.truncate(paramLong);
/*     */     } 
/* 287 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public FileChannel position(long paramLong) {
/* 292 */     this.pos = (int)paramLong;
/* 293 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int write(ByteBuffer paramByteBuffer) throws IOException {
/* 298 */     int i = paramByteBuffer.remaining();
/* 299 */     if (i == 0) {
/* 300 */       return 0;
/*     */     }
/* 302 */     this.data.touch(this.readOnly);
/*     */     
/* 304 */     this.pos = this.data.readWrite(this.pos, paramByteBuffer, 0, i, true);
/* 305 */     paramByteBuffer.position(paramByteBuffer.position() + i);
/* 306 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(ByteBuffer paramByteBuffer) throws IOException {
/* 311 */     int i = paramByteBuffer.remaining();
/* 312 */     if (i == 0) {
/* 313 */       return 0;
/*     */     }
/* 315 */     long l = this.data.readWrite(this.pos, paramByteBuffer, paramByteBuffer.position(), i, false);
/* 316 */     i = (int)(l - this.pos);
/* 317 */     if (i <= 0) {
/* 318 */       return -1;
/*     */     }
/* 320 */     paramByteBuffer.position(paramByteBuffer.position() + i);
/* 321 */     this.pos = l;
/* 322 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(ByteBuffer paramByteBuffer, long paramLong) throws IOException {
/* 327 */     int i = paramByteBuffer.remaining();
/* 328 */     if (i == 0) {
/* 329 */       return 0;
/*     */     }
/*     */     
/* 332 */     long l = this.data.readWrite(paramLong, paramByteBuffer, paramByteBuffer.position(), i, false);
/* 333 */     i = (int)(l - paramLong);
/* 334 */     if (i <= 0) {
/* 335 */       return -1;
/*     */     }
/* 337 */     paramByteBuffer.position(paramByteBuffer.position() + i);
/* 338 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public long position() {
/* 343 */     return this.pos;
/*     */   }
/*     */ 
/*     */   
/*     */   public void implCloseChannel() throws IOException {
/* 348 */     this.pos = 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void force(boolean paramBoolean) throws IOException {}
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized FileLock tryLock(long paramLong1, long paramLong2, boolean paramBoolean) throws IOException {
/* 359 */     if (paramBoolean) {
/* 360 */       if (!this.data.lockShared()) {
/* 361 */         return null;
/*     */       }
/*     */     }
/* 364 */     else if (!this.data.lockExclusive()) {
/* 365 */       return null;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 370 */     return new FileLock((FileChannel)null, paramLong1, paramLong2, paramBoolean)
/*     */       {
/*     */         public boolean isValid()
/*     */         {
/* 374 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void release() throws IOException {
/* 379 */           FileNioMem.this.data.unlock();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 387 */     return this.data.getName();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FileNioMem.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */