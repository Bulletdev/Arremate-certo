/*     */ package org.apache.commons.codec.net;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.BitSet;
/*     */ import org.apache.commons.codec.BinaryDecoder;
/*     */ import org.apache.commons.codec.BinaryEncoder;
/*     */ import org.apache.commons.codec.DecoderException;
/*     */ import org.apache.commons.codec.EncoderException;
/*     */ import org.apache.commons.codec.StringDecoder;
/*     */ import org.apache.commons.codec.StringEncoder;
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
/*     */ public class URLCodec
/*     */   implements BinaryDecoder, BinaryEncoder, StringDecoder, StringEncoder
/*     */ {
/*     */   @Deprecated
/*     */   protected volatile String charset;
/*     */   protected static final byte ESCAPE_CHAR = 37;
/*     */   @Deprecated
/*     */   protected static final BitSet WWW_FORM_URL;
/*  73 */   private static final BitSet WWW_FORM_URL_SAFE = new BitSet(256);
/*     */ 
/*     */   
/*     */   static {
/*     */     byte b;
/*  78 */     for (b = 97; b <= 122; b++) {
/*  79 */       WWW_FORM_URL_SAFE.set(b);
/*     */     }
/*  81 */     for (b = 65; b <= 90; b++) {
/*  82 */       WWW_FORM_URL_SAFE.set(b);
/*     */     }
/*     */     
/*  85 */     for (b = 48; b <= 57; b++) {
/*  86 */       WWW_FORM_URL_SAFE.set(b);
/*     */     }
/*     */     
/*  89 */     WWW_FORM_URL_SAFE.set(45);
/*  90 */     WWW_FORM_URL_SAFE.set(95);
/*  91 */     WWW_FORM_URL_SAFE.set(46);
/*  92 */     WWW_FORM_URL_SAFE.set(42);
/*     */     
/*  94 */     WWW_FORM_URL_SAFE.set(32);
/*     */ 
/*     */     
/*  97 */     WWW_FORM_URL = (BitSet)WWW_FORM_URL_SAFE.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URLCodec() {
/* 105 */     this("UTF-8");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URLCodec(String paramString) {
/* 115 */     this.charset = paramString;
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
/*     */   public static final byte[] encodeUrl(BitSet paramBitSet, byte[] paramArrayOfbyte) {
/* 128 */     if (paramArrayOfbyte == null) {
/* 129 */       return null;
/*     */     }
/* 131 */     if (paramBitSet == null) {
/* 132 */       paramBitSet = WWW_FORM_URL_SAFE;
/*     */     }
/*     */     
/* 135 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 136 */     for (byte b : paramArrayOfbyte) {
/* 137 */       int i = b;
/* 138 */       if (i < 0) {
/* 139 */         i = 256 + i;
/*     */       }
/* 141 */       if (paramBitSet.get(i)) {
/* 142 */         if (i == 32) {
/* 143 */           i = 43;
/*     */         }
/* 145 */         byteArrayOutputStream.write(i);
/*     */       } else {
/* 147 */         byteArrayOutputStream.write(37);
/* 148 */         char c1 = Utils.hexDigit(i >> 4);
/* 149 */         char c2 = Utils.hexDigit(i);
/* 150 */         byteArrayOutputStream.write(c1);
/* 151 */         byteArrayOutputStream.write(c2);
/*     */       } 
/*     */     } 
/* 154 */     return byteArrayOutputStream.toByteArray();
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
/*     */   public static final byte[] decodeUrl(byte[] paramArrayOfbyte) throws DecoderException {
/* 168 */     if (paramArrayOfbyte == null) {
/* 169 */       return null;
/*     */     }
/* 171 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 172 */     for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/* 173 */       byte b1 = paramArrayOfbyte[b];
/* 174 */       if (b1 == 43) {
/* 175 */         byteArrayOutputStream.write(32);
/* 176 */       } else if (b1 == 37) {
/*     */         try {
/* 178 */           int i = Utils.digit16(paramArrayOfbyte[++b]);
/* 179 */           int j = Utils.digit16(paramArrayOfbyte[++b]);
/* 180 */           byteArrayOutputStream.write((char)((i << 4) + j));
/* 181 */         } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/* 182 */           throw new DecoderException("Invalid URL encoding: ", arrayIndexOutOfBoundsException);
/*     */         } 
/*     */       } else {
/* 185 */         byteArrayOutputStream.write(b1);
/*     */       } 
/*     */     } 
/* 188 */     return byteArrayOutputStream.toByteArray();
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
/*     */   public byte[] encode(byte[] paramArrayOfbyte) {
/* 200 */     return encodeUrl(WWW_FORM_URL_SAFE, paramArrayOfbyte);
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
/*     */   public byte[] decode(byte[] paramArrayOfbyte) throws DecoderException {
/* 216 */     return decodeUrl(paramArrayOfbyte);
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
/*     */   public String encode(String paramString1, String paramString2) throws UnsupportedEncodingException {
/* 231 */     if (paramString1 == null) {
/* 232 */       return null;
/*     */     }
/* 234 */     return StringUtils.newStringUsAscii(encode(paramString1.getBytes(paramString2)));
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
/*     */   public String encode(String paramString) throws EncoderException {
/* 250 */     if (paramString == null) {
/* 251 */       return null;
/*     */     }
/*     */     try {
/* 254 */       return encode(paramString, getDefaultCharset());
/* 255 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 256 */       throw new EncoderException(unsupportedEncodingException.getMessage(), unsupportedEncodingException);
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
/*     */ 
/*     */   
/*     */   public String decode(String paramString1, String paramString2) throws DecoderException, UnsupportedEncodingException {
/* 277 */     if (paramString1 == null) {
/* 278 */       return null;
/*     */     }
/* 280 */     return new String(decode(StringUtils.getBytesUsAscii(paramString1)), paramString2);
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
/*     */   public String decode(String paramString) throws DecoderException {
/* 296 */     if (paramString == null) {
/* 297 */       return null;
/*     */     }
/*     */     try {
/* 300 */       return decode(paramString, getDefaultCharset());
/* 301 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 302 */       throw new DecoderException(unsupportedEncodingException.getMessage(), unsupportedEncodingException);
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
/*     */   public Object encode(Object paramObject) throws EncoderException {
/* 317 */     if (paramObject == null)
/* 318 */       return null; 
/* 319 */     if (paramObject instanceof byte[])
/* 320 */       return encode((byte[])paramObject); 
/* 321 */     if (paramObject instanceof String) {
/* 322 */       return encode((String)paramObject);
/*     */     }
/* 324 */     throw new EncoderException("Objects of type " + paramObject.getClass().getName() + " cannot be URL encoded");
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
/*     */   public Object decode(Object paramObject) throws DecoderException {
/* 342 */     if (paramObject == null)
/* 343 */       return null; 
/* 344 */     if (paramObject instanceof byte[])
/* 345 */       return decode((byte[])paramObject); 
/* 346 */     if (paramObject instanceof String) {
/* 347 */       return decode((String)paramObject);
/*     */     }
/* 349 */     throw new DecoderException("Objects of type " + paramObject.getClass().getName() + " cannot be URL decoded");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefaultCharset() {
/* 360 */     return this.charset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public String getEncoding() {
/* 372 */     return this.charset;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\net\URLCodec.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */