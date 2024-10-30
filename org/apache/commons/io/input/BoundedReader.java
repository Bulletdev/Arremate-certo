/*     */ package org.apache.commons.io.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BoundedReader
/*     */   extends Reader
/*     */ {
/*     */   private static final int INVALID = -1;
/*     */   private final Reader target;
/*  41 */   private int charsRead = 0;
/*     */   
/*  43 */   private int markedAt = -1;
/*     */ 
/*     */ 
/*     */   
/*     */   private int readAheadLimit;
/*     */ 
/*     */ 
/*     */   
/*     */   private final int maxCharsFromTargetReader;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BoundedReader(Reader paramReader, int paramInt) throws IOException {
/*  57 */     this.target = paramReader;
/*  58 */     this.maxCharsFromTargetReader = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/*  68 */     this.target.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() throws IOException {
/*  79 */     this.charsRead = this.markedAt;
/*  80 */     this.target.reset();
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
/*     */   public void mark(int paramInt) throws IOException {
/*  95 */     this.readAheadLimit = paramInt - this.charsRead;
/*     */     
/*  97 */     this.markedAt = this.charsRead;
/*     */     
/*  99 */     this.target.mark(paramInt);
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
/*     */   public int read() throws IOException {
/* 112 */     if (this.charsRead >= this.maxCharsFromTargetReader) {
/* 113 */       return -1;
/*     */     }
/*     */     
/* 116 */     if (this.markedAt >= 0 && this.charsRead - this.markedAt >= this.readAheadLimit) {
/* 117 */       return -1;
/*     */     }
/* 119 */     this.charsRead++;
/* 120 */     return this.target.read();
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
/*     */   public int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 136 */     for (byte b = 0; b < paramInt2; b++) {
/* 137 */       int i = read();
/* 138 */       if (i == -1) {
/* 139 */         return (b == 0) ? -1 : b;
/*     */       }
/* 141 */       paramArrayOfchar[paramInt1 + b] = (char)i;
/*     */     } 
/* 143 */     return paramInt2;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\BoundedReader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */