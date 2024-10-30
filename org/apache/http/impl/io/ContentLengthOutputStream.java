/*     */ package org.apache.http.impl.io;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import org.apache.http.io.SessionOutputBuffer;
/*     */ import org.apache.http.util.Args;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContentLengthOutputStream
/*     */   extends OutputStream
/*     */ {
/*     */   private final SessionOutputBuffer out;
/*     */   private final long contentLength;
/*     */   private long total;
/*     */   private boolean closed;
/*     */   
/*     */   public ContentLengthOutputStream(SessionOutputBuffer paramSessionOutputBuffer, long paramLong) {
/*  80 */     this.out = (SessionOutputBuffer)Args.notNull(paramSessionOutputBuffer, "Session output buffer");
/*  81 */     this.contentLength = Args.notNegative(paramLong, "Content length");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/*  91 */     if (!this.closed) {
/*  92 */       this.closed = true;
/*  93 */       this.out.flush();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/*  99 */     this.out.flush();
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 104 */     if (this.closed) {
/* 105 */       throw new IOException("Attempted write to closed stream.");
/*     */     }
/* 107 */     if (this.total < this.contentLength) {
/* 108 */       long l = this.contentLength - this.total;
/* 109 */       int i = paramInt2;
/* 110 */       if (i > l) {
/* 111 */         i = (int)l;
/*     */       }
/* 113 */       this.out.write(paramArrayOfbyte, paramInt1, i);
/* 114 */       this.total += i;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte) throws IOException {
/* 120 */     write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(int paramInt) throws IOException {
/* 125 */     if (this.closed) {
/* 126 */       throw new IOException("Attempted write to closed stream.");
/*     */     }
/* 128 */     if (this.total < this.contentLength) {
/* 129 */       this.out.write(paramInt);
/* 130 */       this.total++;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\io\ContentLengthOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */