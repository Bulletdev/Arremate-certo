/*     */ package org.apache.commons.io.input;
/*     */ 
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NullInputStream
/*     */   extends InputStream
/*     */ {
/*     */   private final long size;
/*     */   private long position;
/*  69 */   private long mark = -1L;
/*     */ 
/*     */   
/*     */   private long readlimit;
/*     */   
/*     */   private boolean eof;
/*     */   
/*     */   private final boolean throwEofException;
/*     */   
/*     */   private final boolean markSupported;
/*     */ 
/*     */   
/*     */   public NullInputStream() {
/*  82 */     this(0L, true, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NullInputStream(long paramLong) {
/*  92 */     this(paramLong, true, false);
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
/*     */   public NullInputStream(long paramLong, boolean paramBoolean1, boolean paramBoolean2) {
/* 107 */     this.size = paramLong;
/* 108 */     this.markSupported = paramBoolean1;
/* 109 */     this.throwEofException = paramBoolean2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getPosition() {
/* 118 */     return this.position;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getSize() {
/* 127 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int available() {
/* 137 */     long l = this.size - this.position;
/* 138 */     if (l <= 0L)
/* 139 */       return 0; 
/* 140 */     if (l > 2147483647L) {
/* 141 */       return Integer.MAX_VALUE;
/*     */     }
/* 143 */     return (int)l;
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
/*     */   public void close() throws IOException {
/* 155 */     this.eof = false;
/* 156 */     this.position = 0L;
/* 157 */     this.mark = -1L;
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
/*     */   public synchronized void mark(int paramInt) {
/* 169 */     if (!this.markSupported) {
/* 170 */       throw new UnsupportedOperationException("Mark not supported");
/*     */     }
/* 172 */     this.mark = this.position;
/* 173 */     this.readlimit = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/* 183 */     return this.markSupported;
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
/*     */   public int read() throws IOException {
/* 198 */     if (this.eof) {
/* 199 */       throw new IOException("Read after end of file");
/*     */     }
/* 201 */     if (this.position == this.size) {
/* 202 */       return doEndOfFile();
/*     */     }
/* 204 */     this.position++;
/* 205 */     return processByte();
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
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/* 221 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 239 */     if (this.eof) {
/* 240 */       throw new IOException("Read after end of file");
/*     */     }
/* 242 */     if (this.position == this.size) {
/* 243 */       return doEndOfFile();
/*     */     }
/* 245 */     this.position += paramInt2;
/* 246 */     int i = paramInt2;
/* 247 */     if (this.position > this.size) {
/* 248 */       i = paramInt2 - (int)(this.position - this.size);
/* 249 */       this.position = this.size;
/*     */     } 
/* 251 */     processBytes(paramArrayOfbyte, paramInt1, i);
/* 252 */     return i;
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
/*     */   public synchronized void reset() throws IOException {
/* 265 */     if (!this.markSupported) {
/* 266 */       throw new UnsupportedOperationException("Mark not supported");
/*     */     }
/* 268 */     if (this.mark < 0L) {
/* 269 */       throw new IOException("No position has been marked");
/*     */     }
/* 271 */     if (this.position > this.mark + this.readlimit) {
/* 272 */       throw new IOException("Marked position [" + this.mark + "] is no longer valid - passed the read limit [" + this.readlimit + "]");
/*     */     }
/*     */ 
/*     */     
/* 276 */     this.position = this.mark;
/* 277 */     this.eof = false;
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
/*     */   public long skip(long paramLong) throws IOException {
/* 293 */     if (this.eof) {
/* 294 */       throw new IOException("Skip after end of file");
/*     */     }
/* 296 */     if (this.position == this.size) {
/* 297 */       return doEndOfFile();
/*     */     }
/* 299 */     this.position += paramLong;
/* 300 */     long l = paramLong;
/* 301 */     if (this.position > this.size) {
/* 302 */       l = paramLong - this.position - this.size;
/* 303 */       this.position = this.size;
/*     */     } 
/* 305 */     return l;
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
/*     */   protected int processByte() {
/* 317 */     return 0;
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
/*     */   protected void processBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int doEndOfFile() throws EOFException {
/* 343 */     this.eof = true;
/* 344 */     if (this.throwEofException) {
/* 345 */       throw new EOFException();
/*     */     }
/* 347 */     return -1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\NullInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */