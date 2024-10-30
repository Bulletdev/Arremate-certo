/*     */ package org.h2.store.fs;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.channels.FileLock;
/*     */ import java.nio.channels.SeekableByteChannel;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipFile;
/*     */ import org.h2.util.IOUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class FileZip
/*     */   extends FileBase
/*     */ {
/* 261 */   private static final byte[] SKIP_BUFFER = new byte[1024];
/*     */   
/*     */   private final ZipFile file;
/*     */   private final ZipEntry entry;
/*     */   private long pos;
/*     */   private InputStream in;
/*     */   private long inPos;
/*     */   private final long length;
/*     */   private boolean skipUsingRead;
/*     */   
/*     */   FileZip(ZipFile paramZipFile, ZipEntry paramZipEntry) {
/* 272 */     this.file = paramZipFile;
/* 273 */     this.entry = paramZipEntry;
/* 274 */     this.length = paramZipEntry.getSize();
/*     */   }
/*     */ 
/*     */   
/*     */   public long position() {
/* 279 */     return this.pos;
/*     */   }
/*     */ 
/*     */   
/*     */   public long size() {
/* 284 */     return this.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(ByteBuffer paramByteBuffer) throws IOException {
/* 289 */     seek();
/* 290 */     int i = this.in.read(paramByteBuffer.array(), paramByteBuffer.arrayOffset() + paramByteBuffer.position(), paramByteBuffer.remaining());
/*     */     
/* 292 */     if (i > 0) {
/* 293 */       paramByteBuffer.position(paramByteBuffer.position() + i);
/* 294 */       this.pos += i;
/* 295 */       this.inPos += i;
/*     */     } 
/* 297 */     return i;
/*     */   }
/*     */   
/*     */   private void seek() throws IOException {
/* 301 */     if (this.inPos > this.pos) {
/* 302 */       if (this.in != null) {
/* 303 */         this.in.close();
/*     */       }
/* 305 */       this.in = null;
/*     */     } 
/* 307 */     if (this.in == null) {
/* 308 */       this.in = this.file.getInputStream(this.entry);
/* 309 */       this.inPos = 0L;
/*     */     } 
/* 311 */     if (this.inPos < this.pos) {
/* 312 */       long l = this.pos - this.inPos;
/* 313 */       if (!this.skipUsingRead) {
/*     */         try {
/* 315 */           IOUtils.skipFully(this.in, l);
/* 316 */         } catch (NullPointerException nullPointerException) {
/*     */           
/* 318 */           this.skipUsingRead = true;
/*     */         } 
/*     */       }
/* 321 */       if (this.skipUsingRead) {
/* 322 */         while (l > 0L) {
/* 323 */           int i = (int)Math.min(SKIP_BUFFER.length, l);
/* 324 */           i = this.in.read(SKIP_BUFFER, 0, i);
/* 325 */           l -= i;
/*     */         } 
/*     */       }
/* 328 */       this.inPos = this.pos;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public FileChannel position(long paramLong) {
/* 334 */     this.pos = paramLong;
/* 335 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public FileChannel truncate(long paramLong) throws IOException {
/* 340 */     throw new IOException("File is read-only");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void force(boolean paramBoolean) throws IOException {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int write(ByteBuffer paramByteBuffer) throws IOException {
/* 350 */     throw new IOException("File is read-only");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized FileLock tryLock(long paramLong1, long paramLong2, boolean paramBoolean) throws IOException {
/* 356 */     if (paramBoolean)
/*     */     {
/* 358 */       return new FileLock((FileChannel)null, paramLong1, paramLong2, paramBoolean)
/*     */         {
/*     */           public boolean isValid()
/*     */           {
/* 362 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void release() throws IOException {}
/*     */         };
/*     */     }
/* 370 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void implCloseChannel() throws IOException {
/* 375 */     if (this.in != null) {
/* 376 */       this.in.close();
/* 377 */       this.in = null;
/*     */     } 
/* 379 */     this.file.close();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\fs\FileZip.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */