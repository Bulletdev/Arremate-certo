/*     */ package org.apache.commons.codec.net;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.charset.Charset;
/*     */ import org.apache.commons.codec.DecoderException;
/*     */ import org.apache.commons.codec.EncoderException;
/*     */ import org.apache.commons.codec.binary.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class RFC1522Codec
/*     */ {
/*     */   protected static final char SEP = '?';
/*     */   protected static final String POSTFIX = "?=";
/*     */   protected static final String PREFIX = "=?";
/*     */   
/*     */   protected String encodeText(String paramString, Charset paramCharset) throws EncoderException {
/*  70 */     if (paramString == null) {
/*  71 */       return null;
/*     */     }
/*  73 */     StringBuilder stringBuilder = new StringBuilder();
/*  74 */     stringBuilder.append("=?");
/*  75 */     stringBuilder.append(paramCharset);
/*  76 */     stringBuilder.append('?');
/*  77 */     stringBuilder.append(getEncoding());
/*  78 */     stringBuilder.append('?');
/*  79 */     stringBuilder.append(StringUtils.newStringUsAscii(doEncoding(paramString.getBytes(paramCharset))));
/*  80 */     stringBuilder.append("?=");
/*  81 */     return stringBuilder.toString();
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
/*     */   protected String encodeText(String paramString1, String paramString2) throws EncoderException, UnsupportedEncodingException {
/* 104 */     if (paramString1 == null) {
/* 105 */       return null;
/*     */     }
/* 107 */     return encodeText(paramString1, Charset.forName(paramString2));
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
/*     */   protected String decodeText(String paramString) throws DecoderException, UnsupportedEncodingException {
/* 126 */     if (paramString == null) {
/* 127 */       return null;
/*     */     }
/* 129 */     if (!paramString.startsWith("=?") || !paramString.endsWith("?=")) {
/* 130 */       throw new DecoderException("RFC 1522 violation: malformed encoded content");
/*     */     }
/* 132 */     int i = paramString.length() - 2;
/* 133 */     int j = 2;
/* 134 */     int k = paramString.indexOf('?', j);
/* 135 */     if (k == i) {
/* 136 */       throw new DecoderException("RFC 1522 violation: charset token not found");
/*     */     }
/* 138 */     String str1 = paramString.substring(j, k);
/* 139 */     if (str1.equals("")) {
/* 140 */       throw new DecoderException("RFC 1522 violation: charset not specified");
/*     */     }
/* 142 */     j = k + 1;
/* 143 */     k = paramString.indexOf('?', j);
/* 144 */     if (k == i) {
/* 145 */       throw new DecoderException("RFC 1522 violation: encoding token not found");
/*     */     }
/* 147 */     String str2 = paramString.substring(j, k);
/* 148 */     if (!getEncoding().equalsIgnoreCase(str2)) {
/* 149 */       throw new DecoderException("This codec cannot decode " + str2 + " encoded content");
/*     */     }
/* 151 */     j = k + 1;
/* 152 */     k = paramString.indexOf('?', j);
/* 153 */     byte[] arrayOfByte = StringUtils.getBytesUsAscii(paramString.substring(j, k));
/* 154 */     arrayOfByte = doDecoding(arrayOfByte);
/* 155 */     return new String(arrayOfByte, str1);
/*     */   }
/*     */   
/*     */   protected abstract String getEncoding();
/*     */   
/*     */   protected abstract byte[] doEncoding(byte[] paramArrayOfbyte) throws EncoderException;
/*     */   
/*     */   protected abstract byte[] doDecoding(byte[] paramArrayOfbyte) throws DecoderException;
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\net\RFC1522Codec.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */