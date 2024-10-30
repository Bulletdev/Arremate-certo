/*     */ package com.google.a.j;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.nio.CharBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @c
/*     */ final class i
/*     */   extends Reader
/*     */ {
/*     */   private CharSequence c;
/*     */   private int pos;
/*     */   private int mark;
/*     */   
/*     */   public i(CharSequence paramCharSequence) {
/*  42 */     this.c = (CharSequence)D.checkNotNull(paramCharSequence);
/*     */   }
/*     */   
/*     */   private void checkOpen() throws IOException {
/*  46 */     if (this.c == null) {
/*  47 */       throw new IOException("reader closed");
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean df() {
/*  52 */     return (remaining() > 0);
/*     */   }
/*     */   
/*     */   private int remaining() {
/*  56 */     return this.c.length() - this.pos;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized int read(CharBuffer paramCharBuffer) throws IOException {
/*  61 */     D.checkNotNull(paramCharBuffer);
/*  62 */     checkOpen();
/*  63 */     if (!df()) {
/*  64 */       return -1;
/*     */     }
/*  66 */     int j = Math.min(paramCharBuffer.remaining(), remaining());
/*  67 */     for (byte b = 0; b < j; b++) {
/*  68 */       paramCharBuffer.put(this.c.charAt(this.pos++));
/*     */     }
/*  70 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized int read() throws IOException {
/*  75 */     checkOpen();
/*  76 */     return df() ? this.c.charAt(this.pos++) : -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/*  81 */     D.a(paramInt1, paramInt1 + paramInt2, paramArrayOfchar.length);
/*  82 */     checkOpen();
/*  83 */     if (!df()) {
/*  84 */       return -1;
/*     */     }
/*  86 */     int j = Math.min(paramInt2, remaining());
/*  87 */     for (byte b = 0; b < j; b++) {
/*  88 */       paramArrayOfchar[paramInt1 + b] = this.c.charAt(this.pos++);
/*     */     }
/*  90 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized long skip(long paramLong) throws IOException {
/*  95 */     D.a((paramLong >= 0L), "n (%s) may not be negative", paramLong);
/*  96 */     checkOpen();
/*  97 */     int j = (int)Math.min(remaining(), paramLong);
/*  98 */     this.pos += j;
/*  99 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized boolean ready() throws IOException {
/* 104 */     checkOpen();
/* 105 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/* 110 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void mark(int paramInt) throws IOException {
/* 115 */     D.a((paramInt >= 0), "readAheadLimit (%s) may not be negative", paramInt);
/* 116 */     checkOpen();
/* 117 */     this.mark = this.pos;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void reset() throws IOException {
/* 122 */     checkOpen();
/* 123 */     this.pos = this.mark;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void close() throws IOException {
/* 128 */     this.c = null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\j\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */