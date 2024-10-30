/*     */ package org.apache.commons.io.output;
/*     */ 
/*     */ import java.io.FilterWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import org.apache.commons.io.IOUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ProxyWriter
/*     */   extends FilterWriter
/*     */ {
/*     */   public ProxyWriter(Writer paramWriter) {
/*  39 */     super(paramWriter);
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
/*     */   public Writer append(char paramChar) throws IOException {
/*     */     try {
/*  53 */       beforeWrite(1);
/*  54 */       this.out.append(paramChar);
/*  55 */       afterWrite(1);
/*  56 */     } catch (IOException iOException) {
/*  57 */       handleIOException(iOException);
/*     */     } 
/*  59 */     return this;
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
/*     */   public Writer append(CharSequence paramCharSequence, int paramInt1, int paramInt2) throws IOException {
/*     */     try {
/*  74 */       beforeWrite(paramInt2 - paramInt1);
/*  75 */       this.out.append(paramCharSequence, paramInt1, paramInt2);
/*  76 */       afterWrite(paramInt2 - paramInt1);
/*  77 */     } catch (IOException iOException) {
/*  78 */       handleIOException(iOException);
/*     */     } 
/*  80 */     return this;
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
/*     */   public Writer append(CharSequence paramCharSequence) throws IOException {
/*     */     try {
/*  93 */       int i = IOUtils.length(paramCharSequence);
/*  94 */       beforeWrite(i);
/*  95 */       this.out.append(paramCharSequence);
/*  96 */       afterWrite(i);
/*  97 */     } catch (IOException iOException) {
/*  98 */       handleIOException(iOException);
/*     */     } 
/* 100 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(int paramInt) throws IOException {
/*     */     try {
/* 111 */       beforeWrite(1);
/* 112 */       this.out.write(paramInt);
/* 113 */       afterWrite(1);
/* 114 */     } catch (IOException iOException) {
/* 115 */       handleIOException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(char[] paramArrayOfchar) throws IOException {
/*     */     try {
/* 127 */       int i = IOUtils.length(paramArrayOfchar);
/* 128 */       beforeWrite(i);
/* 129 */       this.out.write(paramArrayOfchar);
/* 130 */       afterWrite(i);
/* 131 */     } catch (IOException iOException) {
/* 132 */       handleIOException(iOException);
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
/*     */   public void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/*     */     try {
/* 146 */       beforeWrite(paramInt2);
/* 147 */       this.out.write(paramArrayOfchar, paramInt1, paramInt2);
/* 148 */       afterWrite(paramInt2);
/* 149 */     } catch (IOException iOException) {
/* 150 */       handleIOException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(String paramString) throws IOException {
/*     */     try {
/* 162 */       int i = IOUtils.length(paramString);
/* 163 */       beforeWrite(i);
/* 164 */       this.out.write(paramString);
/* 165 */       afterWrite(i);
/* 166 */     } catch (IOException iOException) {
/* 167 */       handleIOException(iOException);
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
/*     */   public void write(String paramString, int paramInt1, int paramInt2) throws IOException {
/*     */     try {
/* 181 */       beforeWrite(paramInt2);
/* 182 */       this.out.write(paramString, paramInt1, paramInt2);
/* 183 */       afterWrite(paramInt2);
/* 184 */     } catch (IOException iOException) {
/* 185 */       handleIOException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/*     */     try {
/* 196 */       this.out.flush();
/* 197 */     } catch (IOException iOException) {
/* 198 */       handleIOException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 208 */     IOUtils.close(this.out, this::handleIOException);
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
/*     */   
/*     */   protected void beforeWrite(int paramInt) throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void afterWrite(int paramInt) throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handleIOException(IOException paramIOException) throws IOException {
/* 260 */     throw paramIOException;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\output\ProxyWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */