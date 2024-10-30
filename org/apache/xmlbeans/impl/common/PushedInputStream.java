/*     */ package org.apache.xmlbeans.impl.common;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class PushedInputStream
/*     */   extends InputStream
/*     */ {
/*  25 */   private static int defaultBufferSize = 2048;
/*     */   protected byte[] buf;
/*     */   protected int writepos;
/*     */   protected int readpos;
/*  29 */   protected int markpos = -1;
/*     */   protected int marklimit;
/*  31 */   protected OutputStream outputStream = new InternalOutputStream();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final OutputStream getOutputStream() {
/*  51 */     return this.outputStream;
/*     */   }
/*     */ 
/*     */   
/*     */   public PushedInputStream() {
/*  56 */     this(defaultBufferSize);
/*     */   }
/*     */ 
/*     */   
/*     */   public PushedInputStream(int paramInt) {
/*  61 */     if (paramInt < 0)
/*     */     {
/*  63 */       throw new IllegalArgumentException("Negative initial buffer size");
/*     */     }
/*  65 */     this.buf = new byte[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void shift(int paramInt) {
/*  73 */     int i = this.readpos;
/*  74 */     if (this.markpos > 0)
/*     */     {
/*  76 */       if (this.readpos - this.markpos > this.marklimit) {
/*  77 */         this.markpos = -1;
/*     */       } else {
/*  79 */         i = this.markpos;
/*     */       } 
/*     */     }
/*  82 */     int j = this.writepos - i;
/*     */     
/*  84 */     if (i > 0 && this.buf.length - j >= paramInt && j <= paramInt) {
/*     */       
/*  86 */       System.arraycopy(this.buf, i, this.buf, 0, j);
/*     */     }
/*     */     else {
/*     */       
/*  90 */       int k = j + paramInt;
/*  91 */       byte[] arrayOfByte = new byte[Math.max(this.buf.length << 1, k)];
/*  92 */       System.arraycopy(this.buf, i, arrayOfByte, 0, j);
/*  93 */       this.buf = arrayOfByte;
/*     */     } 
/*     */     
/*  96 */     if (i > 0) {
/*     */       
/*  98 */       this.readpos -= i;
/*  99 */       if (this.markpos > 0)
/* 100 */         this.markpos -= i; 
/* 101 */       this.writepos -= i;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized int read() throws IOException {
/* 107 */     if (this.readpos >= this.writepos) {
/*     */       
/* 109 */       fill(1);
/* 110 */       if (this.readpos >= this.writepos)
/* 111 */         return -1; 
/*     */     } 
/* 113 */     return this.buf[this.readpos++] & 0xFF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 122 */     int i = this.writepos - this.readpos;
/* 123 */     if (i < paramInt2) {
/*     */       
/* 125 */       fill(paramInt2 - i);
/* 126 */       i = this.writepos - this.readpos;
/* 127 */       if (i <= 0) return -1; 
/*     */     } 
/* 129 */     int j = (i < paramInt2) ? i : paramInt2;
/* 130 */     System.arraycopy(this.buf, this.readpos, paramArrayOfbyte, paramInt1, j);
/* 131 */     this.readpos += j;
/* 132 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized long skip(long paramLong) throws IOException {
/* 137 */     if (paramLong <= 0L) {
/* 138 */       return 0L;
/*     */     }
/* 140 */     long l1 = (this.writepos - this.readpos);
/*     */     
/* 142 */     if (l1 < paramLong) {
/*     */ 
/*     */       
/* 145 */       long l = paramLong - l1;
/* 146 */       if (l > 2147483647L)
/* 147 */         l = 2147483647L; 
/* 148 */       fill((int)l);
/* 149 */       l1 = (this.writepos - this.readpos);
/* 150 */       if (l1 <= 0L) {
/* 151 */         return 0L;
/*     */       }
/*     */     } 
/* 154 */     long l2 = (l1 < paramLong) ? l1 : paramLong;
/* 155 */     this.readpos = (int)(this.readpos + l2);
/* 156 */     return l2;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized int available() {
/* 161 */     return this.writepos - this.readpos;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void mark(int paramInt) {
/* 166 */     this.marklimit = paramInt;
/* 167 */     this.markpos = this.readpos;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void reset() throws IOException {
/* 172 */     if (this.markpos < 0)
/* 173 */       throw new IOException("Resetting to invalid mark"); 
/* 174 */     this.readpos = this.markpos;
/*     */   }
/*     */   protected abstract void fill(int paramInt) throws IOException;
/*     */   
/*     */   public boolean markSupported() {
/* 179 */     return true;
/*     */   }
/*     */   
/*     */   private class InternalOutputStream extends OutputStream {
/*     */     private final PushedInputStream this$0;
/*     */     
/*     */     public synchronized void write(int param1Int) throws IOException {
/* 186 */       if (PushedInputStream.this.writepos + 1 > PushedInputStream.this.buf.length)
/*     */       {
/* 188 */         PushedInputStream.this.shift(1);
/*     */       }
/* 190 */       PushedInputStream.this.buf[PushedInputStream.this.writepos] = (byte)param1Int;
/* 191 */       PushedInputStream.this.writepos++;
/*     */     }
/*     */     private InternalOutputStream() {}
/*     */     
/*     */     public synchronized void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
/* 196 */       if (param1Int1 < 0 || param1Int1 > param1ArrayOfbyte.length || param1Int2 < 0 || param1Int1 + param1Int2 > param1ArrayOfbyte.length || param1Int1 + param1Int2 < 0)
/*     */       {
/* 198 */         throw new IndexOutOfBoundsException(); } 
/* 199 */       if (param1Int2 == 0) {
/*     */         return;
/*     */       }
/* 202 */       if (PushedInputStream.this.writepos + param1Int2 > PushedInputStream.this.buf.length) {
/* 203 */         PushedInputStream.this.shift(param1Int2);
/*     */       }
/* 205 */       System.arraycopy(param1ArrayOfbyte, param1Int1, PushedInputStream.this.buf, PushedInputStream.this.writepos, param1Int2);
/* 206 */       PushedInputStream.this.writepos += param1Int2;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\PushedInputStream.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */