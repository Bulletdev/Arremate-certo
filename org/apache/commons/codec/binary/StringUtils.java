/*     */ package org.apache.commons.codec.binary;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.charset.Charset;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StringUtils
/*     */ {
/*     */   public static boolean equals(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/*  71 */     if (paramCharSequence1 == paramCharSequence2) {
/*  72 */       return true;
/*     */     }
/*  74 */     if (paramCharSequence1 == null || paramCharSequence2 == null) {
/*  75 */       return false;
/*     */     }
/*  77 */     if (paramCharSequence1 instanceof String && paramCharSequence2 instanceof String) {
/*  78 */       return paramCharSequence1.equals(paramCharSequence2);
/*     */     }
/*  80 */     return (paramCharSequence1.length() == paramCharSequence2.length() && CharSequenceUtils.regionMatches(paramCharSequence1, false, 0, paramCharSequence2, 0, paramCharSequence1.length()));
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
/*     */   private static ByteBuffer getByteBuffer(String paramString, Charset paramCharset) {
/*  93 */     if (paramString == null) {
/*  94 */       return null;
/*     */     }
/*  96 */     return ByteBuffer.wrap(paramString.getBytes(paramCharset));
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
/*     */   public static ByteBuffer getByteBufferUtf8(String paramString) {
/* 114 */     return getByteBuffer(paramString, StandardCharsets.UTF_8);
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
/*     */   private static byte[] getBytes(String paramString, Charset paramCharset) {
/* 127 */     if (paramString == null) {
/* 128 */       return null;
/*     */     }
/* 130 */     return paramString.getBytes(paramCharset);
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
/*     */   public static byte[] getBytesIso8859_1(String paramString) {
/* 148 */     return getBytes(paramString, StandardCharsets.ISO_8859_1);
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
/*     */   public static byte[] getBytesUnchecked(String paramString1, String paramString2) {
/* 172 */     if (paramString1 == null) {
/* 173 */       return null;
/*     */     }
/*     */     try {
/* 176 */       return paramString1.getBytes(paramString2);
/* 177 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 178 */       throw newIllegalStateException(paramString2, unsupportedEncodingException);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] getBytesUsAscii(String paramString) {
/* 197 */     return getBytes(paramString, StandardCharsets.US_ASCII);
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
/*     */   public static byte[] getBytesUtf16(String paramString) {
/* 215 */     return getBytes(paramString, StandardCharsets.UTF_16);
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
/*     */   public static byte[] getBytesUtf16Be(String paramString) {
/* 233 */     return getBytes(paramString, StandardCharsets.UTF_16BE);
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
/*     */   public static byte[] getBytesUtf16Le(String paramString) {
/* 251 */     return getBytes(paramString, StandardCharsets.UTF_16LE);
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
/*     */   public static byte[] getBytesUtf8(String paramString) {
/* 269 */     return getBytes(paramString, StandardCharsets.UTF_8);
/*     */   }
/*     */ 
/*     */   
/*     */   private static IllegalStateException newIllegalStateException(String paramString, UnsupportedEncodingException paramUnsupportedEncodingException) {
/* 274 */     return new IllegalStateException(paramString + ": " + paramUnsupportedEncodingException);
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
/*     */   private static String newString(byte[] paramArrayOfbyte, Charset paramCharset) {
/* 290 */     return (paramArrayOfbyte == null) ? null : new String(paramArrayOfbyte, paramCharset);
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
/*     */   public static String newString(byte[] paramArrayOfbyte, String paramString) {
/* 313 */     if (paramArrayOfbyte == null) {
/* 314 */       return null;
/*     */     }
/*     */     try {
/* 317 */       return new String(paramArrayOfbyte, paramString);
/* 318 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 319 */       throw newIllegalStateException(paramString, unsupportedEncodingException);
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
/*     */ 
/*     */   
/*     */   public static String newStringIso8859_1(byte[] paramArrayOfbyte) {
/* 336 */     return newString(paramArrayOfbyte, StandardCharsets.ISO_8859_1);
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
/*     */   public static String newStringUsAscii(byte[] paramArrayOfbyte) {
/* 352 */     return newString(paramArrayOfbyte, StandardCharsets.US_ASCII);
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
/*     */   public static String newStringUtf16(byte[] paramArrayOfbyte) {
/* 368 */     return newString(paramArrayOfbyte, StandardCharsets.UTF_16);
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
/*     */   public static String newStringUtf16Be(byte[] paramArrayOfbyte) {
/* 384 */     return newString(paramArrayOfbyte, StandardCharsets.UTF_16BE);
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
/*     */   public static String newStringUtf16Le(byte[] paramArrayOfbyte) {
/* 400 */     return newString(paramArrayOfbyte, StandardCharsets.UTF_16LE);
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
/*     */   public static String newStringUtf8(byte[] paramArrayOfbyte) {
/* 416 */     return newString(paramArrayOfbyte, StandardCharsets.UTF_8);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\binary\StringUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */