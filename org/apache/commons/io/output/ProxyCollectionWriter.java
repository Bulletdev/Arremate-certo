/*     */ package org.apache.commons.io.output;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import java.util.Collection;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ProxyCollectionWriter
/*     */   extends FilterCollectionWriter
/*     */ {
/*     */   public ProxyCollectionWriter(Collection<Writer> paramCollection) {
/*  44 */     super(paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ProxyCollectionWriter(Writer... paramVarArgs) {
/*  53 */     super(paramVarArgs);
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
/*     */   public Writer append(char paramChar) throws IOException {
/*     */     try {
/*  82 */       beforeWrite(1);
/*  83 */       super.append(paramChar);
/*  84 */       afterWrite(1);
/*  85 */     } catch (IOException iOException) {
/*  86 */       handleIOException(iOException);
/*     */     } 
/*  88 */     return this;
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
/* 101 */       int i = IOUtils.length(paramCharSequence);
/* 102 */       beforeWrite(i);
/* 103 */       super.append(paramCharSequence);
/* 104 */       afterWrite(i);
/* 105 */     } catch (IOException iOException) {
/* 106 */       handleIOException(iOException);
/*     */     } 
/* 108 */     return this;
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
/* 123 */       beforeWrite(paramInt2 - paramInt1);
/* 124 */       super.append(paramCharSequence, paramInt1, paramInt2);
/* 125 */       afterWrite(paramInt2 - paramInt1);
/* 126 */     } catch (IOException iOException) {
/* 127 */       handleIOException(iOException);
/*     */     } 
/* 129 */     return this;
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
/*     */   public void close() throws IOException {
/*     */     try {
/* 155 */       super.close();
/* 156 */     } catch (IOException iOException) {
/* 157 */       handleIOException(iOException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/*     */     try {
/* 169 */       super.flush();
/* 170 */     } catch (IOException iOException) {
/* 171 */       handleIOException(iOException);
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
/*     */   protected void handleIOException(IOException paramIOException) throws IOException {
/* 186 */     throw paramIOException;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(char[] paramArrayOfchar) throws IOException {
/*     */     try {
/* 198 */       int i = IOUtils.length(paramArrayOfchar);
/* 199 */       beforeWrite(i);
/* 200 */       super.write(paramArrayOfchar);
/* 201 */       afterWrite(i);
/* 202 */     } catch (IOException iOException) {
/* 203 */       handleIOException(iOException);
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
/*     */   public void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/*     */     try {
/* 218 */       beforeWrite(paramInt2);
/* 219 */       super.write(paramArrayOfchar, paramInt1, paramInt2);
/* 220 */       afterWrite(paramInt2);
/* 221 */     } catch (IOException iOException) {
/* 222 */       handleIOException(iOException);
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
/*     */   public void write(int paramInt) throws IOException {
/*     */     try {
/* 235 */       beforeWrite(1);
/* 236 */       super.write(paramInt);
/* 237 */       afterWrite(1);
/* 238 */     } catch (IOException iOException) {
/* 239 */       handleIOException(iOException);
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
/*     */   public void write(String paramString) throws IOException {
/*     */     try {
/* 252 */       int i = IOUtils.length(paramString);
/* 253 */       beforeWrite(i);
/* 254 */       super.write(paramString);
/* 255 */       afterWrite(i);
/* 256 */     } catch (IOException iOException) {
/* 257 */       handleIOException(iOException);
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
/*     */   public void write(String paramString, int paramInt1, int paramInt2) throws IOException {
/*     */     try {
/* 272 */       beforeWrite(paramInt2);
/* 273 */       super.write(paramString, paramInt1, paramInt2);
/* 274 */       afterWrite(paramInt2);
/* 275 */     } catch (IOException iOException) {
/* 276 */       handleIOException(iOException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\output\ProxyCollectionWriter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */