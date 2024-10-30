/*     */ package org.apache.commons.codec.net;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import org.apache.commons.codec.CodecPolicy;
/*     */ import org.apache.commons.codec.DecoderException;
/*     */ import org.apache.commons.codec.EncoderException;
/*     */ import org.apache.commons.codec.StringDecoder;
/*     */ import org.apache.commons.codec.StringEncoder;
/*     */ import org.apache.commons.codec.binary.Base64;
/*     */ import org.apache.commons.codec.binary.BaseNCodec;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BCodec
/*     */   extends RFC1522Codec
/*     */   implements StringDecoder, StringEncoder
/*     */ {
/*  54 */   private static final CodecPolicy DECODING_POLICY_DEFAULT = CodecPolicy.LENIENT;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Charset charset;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final CodecPolicy decodingPolicy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BCodec() {
/*  71 */     this(StandardCharsets.UTF_8);
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
/*     */   public BCodec(Charset paramCharset) {
/*  84 */     this(paramCharset, DECODING_POLICY_DEFAULT);
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
/*     */   public BCodec(Charset paramCharset, CodecPolicy paramCodecPolicy) {
/*  98 */     this.charset = paramCharset;
/*  99 */     this.decodingPolicy = paramCodecPolicy;
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
/*     */   public BCodec(String paramString) {
/* 113 */     this(Charset.forName(paramString));
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
/*     */   public boolean isStrictDecoding() {
/* 127 */     return (this.decodingPolicy == CodecPolicy.STRICT);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getEncoding() {
/* 132 */     return "B";
/*     */   }
/*     */ 
/*     */   
/*     */   protected byte[] doEncoding(byte[] paramArrayOfbyte) {
/* 137 */     if (paramArrayOfbyte == null) {
/* 138 */       return null;
/*     */     }
/* 140 */     return Base64.encodeBase64(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */   
/*     */   protected byte[] doDecoding(byte[] paramArrayOfbyte) {
/* 145 */     if (paramArrayOfbyte == null) {
/* 146 */       return null;
/*     */     }
/* 148 */     return (new Base64(0, BaseNCodec.getChunkSeparator(), false, this.decodingPolicy)).decode(paramArrayOfbyte);
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
/*     */   public String encode(String paramString, Charset paramCharset) throws EncoderException {
/* 164 */     if (paramString == null) {
/* 165 */       return null;
/*     */     }
/* 167 */     return encodeText(paramString, paramCharset);
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
/*     */   public String encode(String paramString1, String paramString2) throws EncoderException {
/* 182 */     if (paramString1 == null) {
/* 183 */       return null;
/*     */     }
/*     */     try {
/* 186 */       return encodeText(paramString1, paramString2);
/* 187 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 188 */       throw new EncoderException(unsupportedEncodingException.getMessage(), unsupportedEncodingException);
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
/*     */   public String encode(String paramString) throws EncoderException {
/* 203 */     if (paramString == null) {
/* 204 */       return null;
/*     */     }
/* 206 */     return encode(paramString, getCharset());
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
/*     */   public String decode(String paramString) throws DecoderException {
/* 221 */     if (paramString == null) {
/* 222 */       return null;
/*     */     }
/*     */     try {
/* 225 */       return decodeText(paramString);
/* 226 */     } catch (UnsupportedEncodingException|IllegalArgumentException unsupportedEncodingException) {
/* 227 */       throw new DecoderException(unsupportedEncodingException.getMessage(), unsupportedEncodingException);
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
/* 242 */     if (paramObject == null)
/* 243 */       return null; 
/* 244 */     if (paramObject instanceof String) {
/* 245 */       return encode((String)paramObject);
/*     */     }
/* 247 */     throw new EncoderException("Objects of type " + paramObject
/* 248 */         .getClass().getName() + " cannot be encoded using BCodec");
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
/* 266 */     if (paramObject == null)
/* 267 */       return null; 
/* 268 */     if (paramObject instanceof String) {
/* 269 */       return decode((String)paramObject);
/*     */     }
/* 271 */     throw new DecoderException("Objects of type " + paramObject
/* 272 */         .getClass().getName() + " cannot be decoded using BCodec");
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
/*     */   public Charset getCharset() {
/* 284 */     return this.charset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefaultCharset() {
/* 293 */     return this.charset.name();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\net\BCodec.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */