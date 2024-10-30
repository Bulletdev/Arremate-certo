/*     */ package org.apache.commons.codec.digest;
/*     */ 
/*     */ import java.nio.charset.StandardCharsets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Crypt
/*     */ {
/*     */   public static String crypt(byte[] paramArrayOfbyte) {
/*  52 */     return crypt(paramArrayOfbyte, (String)null);
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
/*     */   public static String crypt(byte[] paramArrayOfbyte, String paramString) {
/*  75 */     if (paramString == null)
/*  76 */       return Sha2Crypt.sha512Crypt(paramArrayOfbyte); 
/*  77 */     if (paramString.startsWith("$6$"))
/*  78 */       return Sha2Crypt.sha512Crypt(paramArrayOfbyte, paramString); 
/*  79 */     if (paramString.startsWith("$5$"))
/*  80 */       return Sha2Crypt.sha256Crypt(paramArrayOfbyte, paramString); 
/*  81 */     if (paramString.startsWith("$1$")) {
/*  82 */       return Md5Crypt.md5Crypt(paramArrayOfbyte, paramString);
/*     */     }
/*  84 */     return UnixCrypt.crypt(paramArrayOfbyte, paramString);
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
/*     */   public static String crypt(String paramString) {
/* 106 */     return crypt(paramString, (String)null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String crypt(String paramString1, String paramString2) {
/* 167 */     return crypt(paramString1.getBytes(StandardCharsets.UTF_8), paramString2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\digest\Crypt.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */