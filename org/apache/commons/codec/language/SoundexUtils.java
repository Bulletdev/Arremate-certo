/*     */ package org.apache.commons.codec.language;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import org.apache.commons.codec.EncoderException;
/*     */ import org.apache.commons.codec.StringEncoder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class SoundexUtils
/*     */ {
/*     */   static String clean(String paramString) {
/*  41 */     if (paramString == null || paramString.length() == 0) {
/*  42 */       return paramString;
/*     */     }
/*  44 */     int i = paramString.length();
/*  45 */     char[] arrayOfChar = new char[i];
/*  46 */     byte b1 = 0;
/*  47 */     for (byte b2 = 0; b2 < i; b2++) {
/*  48 */       if (Character.isLetter(paramString.charAt(b2))) {
/*  49 */         arrayOfChar[b1++] = paramString.charAt(b2);
/*     */       }
/*     */     } 
/*  52 */     if (b1 == i) {
/*  53 */       return paramString.toUpperCase(Locale.ENGLISH);
/*     */     }
/*  55 */     return (new String(arrayOfChar, 0, b1)).toUpperCase(Locale.ENGLISH);
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
/*     */   static int difference(StringEncoder paramStringEncoder, String paramString1, String paramString2) throws EncoderException {
/*  85 */     return differenceEncoded(paramStringEncoder.encode(paramString1), paramStringEncoder.encode(paramString2));
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
/*     */   static int differenceEncoded(String paramString1, String paramString2) {
/* 110 */     if (paramString1 == null || paramString2 == null) {
/* 111 */       return 0;
/*     */     }
/* 113 */     int i = Math.min(paramString1.length(), paramString2.length());
/* 114 */     byte b1 = 0;
/* 115 */     for (byte b2 = 0; b2 < i; b2++) {
/* 116 */       if (paramString1.charAt(b2) == paramString2.charAt(b2)) {
/* 117 */         b1++;
/*     */       }
/*     */     } 
/* 120 */     return b1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\language\SoundexUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */