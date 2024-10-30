/*     */ package org.apache.commons.io.filefilter;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.io.Serializable;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MagicNumberFileFilter
/*     */   extends AbstractFileFilter
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -547733176983104172L;
/*     */   private final byte[] magicNumbers;
/*     */   private final long byteOffset;
/*     */   
/*     */   public MagicNumberFileFilter(byte[] paramArrayOfbyte) {
/* 112 */     this(paramArrayOfbyte, 0L);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MagicNumberFileFilter(String paramString) {
/* 137 */     this(paramString, 0L);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MagicNumberFileFilter(String paramString, long paramLong) {
/* 161 */     if (paramString == null) {
/* 162 */       throw new IllegalArgumentException("The magic number cannot be null");
/*     */     }
/* 164 */     if (paramString.isEmpty()) {
/* 165 */       throw new IllegalArgumentException("The magic number must contain at least one byte");
/*     */     }
/* 167 */     if (paramLong < 0L) {
/* 168 */       throw new IllegalArgumentException("The offset cannot be negative");
/*     */     }
/*     */     
/* 171 */     this.magicNumbers = paramString.getBytes(Charset.defaultCharset());
/*     */     
/* 173 */     this.byteOffset = paramLong;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MagicNumberFileFilter(byte[] paramArrayOfbyte, long paramLong) {
/* 201 */     if (paramArrayOfbyte == null) {
/* 202 */       throw new IllegalArgumentException("The magic number cannot be null");
/*     */     }
/* 204 */     if (paramArrayOfbyte.length == 0) {
/* 205 */       throw new IllegalArgumentException("The magic number must contain at least one byte");
/*     */     }
/* 207 */     if (paramLong < 0L) {
/* 208 */       throw new IllegalArgumentException("The offset cannot be negative");
/*     */     }
/*     */     
/* 211 */     this.magicNumbers = new byte[paramArrayOfbyte.length];
/* 212 */     System.arraycopy(paramArrayOfbyte, 0, this.magicNumbers, 0, paramArrayOfbyte.length);
/* 213 */     this.byteOffset = paramLong;
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
/*     */ 
/*     */   
/*     */   public boolean accept(File paramFile) {
/* 234 */     if (paramFile != null && paramFile.isFile() && paramFile.canRead())
/*     */     {
/* 236 */       try (RandomAccessFile null = new RandomAccessFile(paramFile, "r")) {
/* 237 */         byte[] arrayOfByte = new byte[this.magicNumbers.length];
/* 238 */         randomAccessFile.seek(this.byteOffset);
/* 239 */         int i = randomAccessFile.read(arrayOfByte);
/* 240 */         if (i != this.magicNumbers.length) {
/* 241 */           return false;
/*     */         }
/* 243 */         return Arrays.equals(this.magicNumbers, arrayOfByte);
/*     */       
/*     */       }
/* 246 */       catch (IOException iOException) {}
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 251 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 262 */     StringBuilder stringBuilder = new StringBuilder(super.toString());
/* 263 */     stringBuilder.append("(");
/* 264 */     stringBuilder.append(new String(this.magicNumbers, Charset.defaultCharset()));
/*     */     
/* 266 */     stringBuilder.append(",");
/* 267 */     stringBuilder.append(this.byteOffset);
/* 268 */     stringBuilder.append(")");
/* 269 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\filefilter\MagicNumberFileFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */