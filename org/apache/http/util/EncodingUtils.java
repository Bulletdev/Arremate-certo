/*     */ package org.apache.http.util;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import org.apache.http.Consts;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class EncodingUtils
/*     */ {
/*     */   public static String getString(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, String paramString) {
/*  57 */     Args.notNull(paramArrayOfbyte, "Input");
/*  58 */     Args.notEmpty(paramString, "Charset");
/*     */     try {
/*  60 */       return new String(paramArrayOfbyte, paramInt1, paramInt2, paramString);
/*  61 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*  62 */       return new String(paramArrayOfbyte, paramInt1, paramInt2);
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
/*     */   public static String getString(byte[] paramArrayOfbyte, String paramString) {
/*  77 */     Args.notNull(paramArrayOfbyte, "Input");
/*  78 */     return getString(paramArrayOfbyte, 0, paramArrayOfbyte.length, paramString);
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
/*     */   public static byte[] getBytes(String paramString1, String paramString2) {
/*  90 */     Args.notNull(paramString1, "Input");
/*  91 */     Args.notEmpty(paramString2, "Charset");
/*     */     try {
/*  93 */       return paramString1.getBytes(paramString2);
/*  94 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*  95 */       return paramString1.getBytes();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] getAsciiBytes(String paramString) {
/* 106 */     Args.notNull(paramString, "Input");
/* 107 */     return paramString.getBytes(Consts.ASCII);
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
/*     */   public static String getAsciiString(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 121 */     Args.notNull(paramArrayOfbyte, "Input");
/* 122 */     return new String(paramArrayOfbyte, paramInt1, paramInt2, Consts.ASCII);
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
/*     */   public static String getAsciiString(byte[] paramArrayOfbyte) {
/* 134 */     Args.notNull(paramArrayOfbyte, "Input");
/* 135 */     return getAsciiString(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\htt\\util\EncodingUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */