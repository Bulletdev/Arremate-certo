/*     */ package org.apache.poi.util;
/*     */ 
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
/*     */ public class BoundedInputStream
/*     */   extends InputStream
/*     */ {
/*     */   private final InputStream in;
/*     */   private final long max;
/*  45 */   private long pos = 0L;
/*     */ 
/*     */   
/*  48 */   private long mark = -1L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean propagateClose = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundedInputStream(InputStream paramInputStream, long paramLong) {
/*  63 */     this.max = paramLong;
/*  64 */     this.in = paramInputStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundedInputStream(InputStream paramInputStream) {
/*  74 */     this(paramInputStream, -1L);
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
/*     */   public int read() throws IOException {
/*  86 */     if (this.max >= 0L && this.pos == this.max) {
/*  87 */       return -1;
/*     */     }
/*  89 */     int i = this.in.read();
/*  90 */     this.pos++;
/*  91 */     return i;
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
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/* 103 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 117 */     if (this.max >= 0L && this.pos >= this.max) {
/* 118 */       return -1;
/*     */     }
/* 120 */     long l = (this.max >= 0L) ? Math.min(paramInt2, this.max - this.pos) : paramInt2;
/* 121 */     int i = this.in.read(paramArrayOfbyte, paramInt1, (int)l);
/*     */     
/* 123 */     if (i == -1) {
/* 124 */       return -1;
/*     */     }
/*     */     
/* 127 */     this.pos += i;
/* 128 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long skip(long paramLong) throws IOException {
/* 139 */     long l1 = (this.max >= 0L) ? Math.min(paramLong, this.max - this.pos) : paramLong;
/* 140 */     long l2 = this.in.skip(l1);
/* 141 */     this.pos += l2;
/* 142 */     return l2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int available() throws IOException {
/* 150 */     if (this.max >= 0L && this.pos >= this.max) {
/* 151 */       return 0;
/*     */     }
/* 153 */     return this.in.available();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 162 */     return this.in.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 172 */     if (this.propagateClose) {
/* 173 */       this.in.close();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void reset() throws IOException {
/* 183 */     this.in.reset();
/* 184 */     this.pos = this.mark;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void mark(int paramInt) {
/* 193 */     this.in.mark(paramInt);
/* 194 */     this.mark = this.pos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/* 203 */     return this.in.markSupported();
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
/*     */   public boolean isPropagateClose() {
/* 215 */     return this.propagateClose;
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
/*     */   public void setPropagateClose(boolean paramBoolean) {
/* 228 */     this.propagateClose = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\BoundedInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */