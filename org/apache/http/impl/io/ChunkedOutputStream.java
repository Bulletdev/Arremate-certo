/*     */ package org.apache.http.impl.io;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import org.apache.http.io.SessionOutputBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChunkedOutputStream
/*     */   extends OutputStream
/*     */ {
/*     */   private final SessionOutputBuffer out;
/*     */   private final byte[] cache;
/*  54 */   private int cachePosition = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean wroteLastChunk = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean closed = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public ChunkedOutputStream(SessionOutputBuffer paramSessionOutputBuffer, int paramInt) throws IOException {
/*  73 */     this(paramInt, paramSessionOutputBuffer);
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
/*     */   @Deprecated
/*     */   public ChunkedOutputStream(SessionOutputBuffer paramSessionOutputBuffer) throws IOException {
/*  88 */     this(2048, paramSessionOutputBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ChunkedOutputStream(int paramInt, SessionOutputBuffer paramSessionOutputBuffer) {
/*  99 */     this.cache = new byte[paramInt];
/* 100 */     this.out = paramSessionOutputBuffer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void flushCache() throws IOException {
/* 107 */     if (this.cachePosition > 0) {
/* 108 */       this.out.writeLine(Integer.toHexString(this.cachePosition));
/* 109 */       this.out.write(this.cache, 0, this.cachePosition);
/* 110 */       this.out.writeLine("");
/* 111 */       this.cachePosition = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void flushCacheWithAppend(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 120 */     this.out.writeLine(Integer.toHexString(this.cachePosition + paramInt2));
/* 121 */     this.out.write(this.cache, 0, this.cachePosition);
/* 122 */     this.out.write(paramArrayOfbyte, paramInt1, paramInt2);
/* 123 */     this.out.writeLine("");
/* 124 */     this.cachePosition = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void writeClosingChunk() throws IOException {
/* 129 */     this.out.writeLine("0");
/* 130 */     this.out.writeLine("");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void finish() throws IOException {
/* 140 */     if (!this.wroteLastChunk) {
/* 141 */       flushCache();
/* 142 */       writeClosingChunk();
/* 143 */       this.wroteLastChunk = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(int paramInt) throws IOException {
/* 150 */     if (this.closed) {
/* 151 */       throw new IOException("Attempted write to closed stream.");
/*     */     }
/* 153 */     this.cache[this.cachePosition] = (byte)paramInt;
/* 154 */     this.cachePosition++;
/* 155 */     if (this.cachePosition == this.cache.length) {
/* 156 */       flushCache();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte) throws IOException {
/* 166 */     write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 175 */     if (this.closed) {
/* 176 */       throw new IOException("Attempted write to closed stream.");
/*     */     }
/* 178 */     if (paramInt2 >= this.cache.length - this.cachePosition) {
/* 179 */       flushCacheWithAppend(paramArrayOfbyte, paramInt1, paramInt2);
/*     */     } else {
/* 181 */       System.arraycopy(paramArrayOfbyte, paramInt1, this.cache, this.cachePosition, paramInt2);
/* 182 */       this.cachePosition += paramInt2;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/* 191 */     flushCache();
/* 192 */     this.out.flush();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 200 */     if (!this.closed) {
/* 201 */       this.closed = true;
/* 202 */       finish();
/* 203 */       this.out.flush();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\io\ChunkedOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */