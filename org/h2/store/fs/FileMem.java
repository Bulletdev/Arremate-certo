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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class FileMem
/*     */   extends FileBase
/*     */ {
/*     */   final FileMemData data;
/*     */   private final boolean readOnly;
/*     */   private long pos;
/*     */   
/*     */   FileMem(FileMemData paramFileMemData, boolean paramBoolean) {
/* 277 */     this.data = paramFileMemData;
/* 278 */     this.readOnly = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public long size() {
/* 283 */     return this.data.length();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FileChannel truncate(long paramLong) throws IOException {
/* 289 */     if (this.readOnly) {
/* 290 */       throw new NonWritableChannelException();
/*     */     }
/* 292 */     if (paramLong < size()) {
/* 293 */       this.data.touch(this.readOnly);
/* 294 */       this.pos = Math.min(this.pos, paramLong);
/* 295 */       this.data.truncate(paramLong);
/*     */     } 
/* 297 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public FileChannel position(long paramLong) {
/* 302 */     this.pos = paramLong;
/* 303 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int write(ByteBuffer paramByteBuffer) throws IOException {
/* 308 */     int i = paramByteBuffer.remaining();
/* 309 */     if (i == 0) {
/* 310 */       return 0;
/*     */     }
/* 312 */     this.data.touch(this.readOnly);
/* 313 */     this.pos = this.data.readWrite(this.pos, paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), i, true);
/*     */     
/* 315 */     paramByteBuffer.position(paramByteBuffer.position() + i);
/* 316 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(ByteBuffer paramByteBuffer) throws IOException {
/* 321 */     int i = paramByteBuffer.remaining();
/* 322 */     if (i == 0) {
/* 323 */       return 0;
/*     */     }
/* 325 */     long l = this.data.readWrite(this.pos, paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), i, false);
/*     */     
/* 327 */     i = (int)(l - this.pos);
/* 328 */     if (i <= 0) {
/* 329 */       return -1;
/*     */     }
/* 331 */     paramByteBuffer.position(paramByteBuffer.position() + i);
/* 332 */     this.pos = l;
/* 333 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public long position() {
/* 338 */     return this.pos;
/*     */   }
/*     */ 
/*     */   
/*     */   public void implCloseChannel() throws IOException {
/* 343 */     this.pos = 0L;
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
/* 354 */     if (paramBoolean) {
/* 355 */       if (!this.data.lockShared()) {
/* 356 */         return null;
/*     */       }
/*     */     }
/* 359 */     else if (!this.data.lockExclusive()) {
/* 360 */       return null;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 365 */     return new FileLock((FileChannel)null, paramLong1, paramLong2, paramBoolean)
/*     */       {
/*     */         public boolean isValid()
/*     */         {
/* 369 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void release() throws IOException {
/* 374 */           FileMem.this.data.unlock();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 382 */     return this.data.getName();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FileMem.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */