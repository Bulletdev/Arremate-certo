/*     */ package com.google.a.j;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import java.io.Closeable;
/*     */ import java.io.Flushable;
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ class a
/*     */   extends Writer
/*     */ {
/*     */   private final Appendable a;
/*     */   private boolean closed;
/*     */   
/*     */   a(Appendable paramAppendable) {
/*  45 */     this.a = (Appendable)D.checkNotNull(paramAppendable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/*  54 */     checkNotClosed();
/*     */ 
/*     */     
/*  57 */     this.a.append(new String(paramArrayOfchar, paramInt1, paramInt2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(int paramInt) throws IOException {
/*  66 */     checkNotClosed();
/*  67 */     this.a.append((char)paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(String paramString) throws IOException {
/*  72 */     checkNotClosed();
/*  73 */     this.a.append(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(String paramString, int paramInt1, int paramInt2) throws IOException {
/*  78 */     checkNotClosed();
/*     */     
/*  80 */     this.a.append(paramString, paramInt1, paramInt1 + paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/*  85 */     checkNotClosed();
/*  86 */     if (this.a instanceof Flushable) {
/*  87 */       ((Flushable)this.a).flush();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/*  93 */     this.closed = true;
/*  94 */     if (this.a instanceof Closeable) {
/*  95 */       ((Closeable)this.a).close();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Writer append(char paramChar) throws IOException {
/* 101 */     checkNotClosed();
/* 102 */     this.a.append(paramChar);
/* 103 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Writer append(CharSequence paramCharSequence) throws IOException {
/* 108 */     checkNotClosed();
/* 109 */     this.a.append(paramCharSequence);
/* 110 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Writer append(CharSequence paramCharSequence, int paramInt1, int paramInt2) throws IOException {
/* 115 */     checkNotClosed();
/* 116 */     this.a.append(paramCharSequence, paramInt1, paramInt2);
/* 117 */     return this;
/*     */   }
/*     */   
/*     */   private void checkNotClosed() throws IOException {
/* 121 */     if (this.closed)
/* 122 */       throw new IOException("Cannot write to a closed writer."); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\j\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */