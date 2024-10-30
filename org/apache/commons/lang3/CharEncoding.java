/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.IllegalCharsetNameException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class CharEncoding
/*     */ {
/*     */   public static final String ISO_8859_1 = "ISO-8859-1";
/*     */   public static final String US_ASCII = "US-ASCII";
/*     */   public static final String UTF_16 = "UTF-16";
/*     */   public static final String UTF_16BE = "UTF-16BE";
/*     */   public static final String UTF_16LE = "UTF-16LE";
/*     */   public static final String UTF_8 = "UTF-8";
/*     */   
/*     */   @Deprecated
/*     */   public static boolean isSupported(String paramString) {
/* 100 */     if (paramString == null) {
/* 101 */       return false;
/*     */     }
/*     */     try {
/* 104 */       return Charset.isSupported(paramString);
/* 105 */     } catch (IllegalCharsetNameException illegalCharsetNameException) {
/* 106 */       return false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\CharEncoding.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */