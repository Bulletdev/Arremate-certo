/*     */ package org.apache.commons.io;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LineIterator
/*     */   implements Closeable, Iterator<String>
/*     */ {
/*     */   private final BufferedReader bufferedReader;
/*     */   private String cachedLine;
/*     */   private boolean finished = false;
/*     */   
/*     */   public LineIterator(Reader paramReader) throws IllegalArgumentException {
/*  68 */     if (paramReader == null) {
/*  69 */       throw new IllegalArgumentException("Reader must not be null");
/*     */     }
/*  71 */     if (paramReader instanceof BufferedReader) {
/*  72 */       this.bufferedReader = (BufferedReader)paramReader;
/*     */     } else {
/*  74 */       this.bufferedReader = new BufferedReader(paramReader);
/*     */     } 
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
/*     */   public boolean hasNext() {
/*  89 */     if (this.cachedLine != null)
/*  90 */       return true; 
/*  91 */     if (this.finished) {
/*  92 */       return false;
/*     */     }
/*     */     try {
/*     */       while (true) {
/*  96 */         String str = this.bufferedReader.readLine();
/*  97 */         if (str == null) {
/*  98 */           this.finished = true;
/*  99 */           return false;
/* 100 */         }  if (isValidLine(str)) {
/* 101 */           this.cachedLine = str;
/* 102 */           return true;
/*     */         } 
/*     */       } 
/* 105 */     } catch (IOException iOException) {
/* 106 */       IOUtils.closeQuietly(this, paramIOException2 -> paramIOException1.addSuppressed(paramIOException2));
/* 107 */       throw new IllegalStateException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isValidLine(String paramString) {
/* 119 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String next() {
/* 130 */     return nextLine();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String nextLine() {
/* 140 */     if (!hasNext()) {
/* 141 */       throw new NoSuchElementException("No more lines");
/*     */     }
/* 143 */     String str = this.cachedLine;
/* 144 */     this.cachedLine = null;
/* 145 */     return str;
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
/*     */   public void close() throws IOException {
/* 159 */     this.finished = true;
/* 160 */     this.cachedLine = null;
/* 161 */     IOUtils.close(this.bufferedReader);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove() {
/* 171 */     throw new UnsupportedOperationException("Remove unsupported on LineIterator");
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
/*     */   @Deprecated
/*     */   public static void closeQuietly(LineIterator paramLineIterator) {
/* 185 */     IOUtils.closeQuietly(paramLineIterator);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\LineIterator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */