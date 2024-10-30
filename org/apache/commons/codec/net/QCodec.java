/*     */ package org.apache.commons.codec.net;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.BitSet;
/*     */ import org.apache.commons.codec.DecoderException;
/*     */ import org.apache.commons.codec.EncoderException;
/*     */ import org.apache.commons.codec.StringDecoder;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QCodec
/*     */   extends RFC1522Codec
/*     */   implements StringDecoder, StringEncoder
/*     */ {
/*     */   private final Charset charset;
/*  62 */   private static final BitSet PRINTABLE_CHARS = new BitSet(256);
/*     */   private static final byte SPACE = 32;
/*     */   
/*     */   static {
/*  66 */     PRINTABLE_CHARS.set(32);
/*  67 */     PRINTABLE_CHARS.set(33);
/*  68 */     PRINTABLE_CHARS.set(34);
/*  69 */     PRINTABLE_CHARS.set(35);
/*  70 */     PRINTABLE_CHARS.set(36);
/*  71 */     PRINTABLE_CHARS.set(37);
/*  72 */     PRINTABLE_CHARS.set(38);
/*  73 */     PRINTABLE_CHARS.set(39);
/*  74 */     PRINTABLE_CHARS.set(40);
/*  75 */     PRINTABLE_CHARS.set(41);
/*  76 */     PRINTABLE_CHARS.set(42);
/*  77 */     PRINTABLE_CHARS.set(43);
/*  78 */     PRINTABLE_CHARS.set(44);
/*  79 */     PRINTABLE_CHARS.set(45);
/*  80 */     PRINTABLE_CHARS.set(46);
/*  81 */     PRINTABLE_CHARS.set(47); byte b;
/*  82 */     for (b = 48; b <= 57; b++) {
/*  83 */       PRINTABLE_CHARS.set(b);
/*     */     }
/*  85 */     PRINTABLE_CHARS.set(58);
/*  86 */     PRINTABLE_CHARS.set(59);
/*  87 */     PRINTABLE_CHARS.set(60);
/*  88 */     PRINTABLE_CHARS.set(62);
/*  89 */     PRINTABLE_CHARS.set(64);
/*  90 */     for (b = 65; b <= 90; b++) {
/*  91 */       PRINTABLE_CHARS.set(b);
/*     */     }
/*  93 */     PRINTABLE_CHARS.set(91);
/*  94 */     PRINTABLE_CHARS.set(92);
/*  95 */     PRINTABLE_CHARS.set(93);
/*  96 */     PRINTABLE_CHARS.set(94);
/*  97 */     PRINTABLE_CHARS.set(96);
/*  98 */     for (b = 97; b <= 122; b++) {
/*  99 */       PRINTABLE_CHARS.set(b);
/*     */     }
/* 101 */     PRINTABLE_CHARS.set(123);
/* 102 */     PRINTABLE_CHARS.set(124);
/* 103 */     PRINTABLE_CHARS.set(125);
/* 104 */     PRINTABLE_CHARS.set(126);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final byte UNDERSCORE = 95;
/*     */ 
/*     */   
/*     */   private boolean encodeBlanks = false;
/*     */ 
/*     */ 
/*     */   
/*     */   public QCodec() {
/* 117 */     this(StandardCharsets.UTF_8);
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
/*     */   public QCodec(Charset paramCharset) {
/* 131 */     this.charset = paramCharset;
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
/*     */   public QCodec(String paramString) {
/* 145 */     this(Charset.forName(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getEncoding() {
/* 150 */     return "Q";
/*     */   }
/*     */ 
/*     */   
/*     */   protected byte[] doEncoding(byte[] paramArrayOfbyte) {
/* 155 */     if (paramArrayOfbyte == null) {
/* 156 */       return null;
/*     */     }
/* 158 */     byte[] arrayOfByte = QuotedPrintableCodec.encodeQuotedPrintable(PRINTABLE_CHARS, paramArrayOfbyte);
/* 159 */     if (this.encodeBlanks) {
/* 160 */       for (byte b = 0; b < arrayOfByte.length; b++) {
/* 161 */         if (arrayOfByte[b] == 32) {
/* 162 */           arrayOfByte[b] = 95;
/*     */         }
/*     */       } 
/*     */     }
/* 166 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */   
/*     */   protected byte[] doDecoding(byte[] paramArrayOfbyte) throws DecoderException {
/* 171 */     if (paramArrayOfbyte == null) {
/* 172 */       return null;
/*     */     }
/* 174 */     boolean bool = false;
/* 175 */     for (byte b : paramArrayOfbyte) {
/* 176 */       if (b == 95) {
/* 177 */         bool = true;
/*     */         break;
/*     */       } 
/*     */     } 
/* 181 */     if (bool) {
/* 182 */       byte[] arrayOfByte = new byte[paramArrayOfbyte.length];
/* 183 */       for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/* 184 */         byte b1 = paramArrayOfbyte[b];
/* 185 */         if (b1 != 95) {
/* 186 */           arrayOfByte[b] = b1;
/*     */         } else {
/* 188 */           arrayOfByte[b] = 32;
/*     */         } 
/*     */       } 
/* 191 */       return QuotedPrintableCodec.decodeQuotedPrintable(arrayOfByte);
/*     */     } 
/* 193 */     return QuotedPrintableCodec.decodeQuotedPrintable(paramArrayOfbyte);
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
/* 209 */     if (paramString == null) {
/* 210 */       return null;
/*     */     }
/* 212 */     return encodeText(paramString, paramCharset);
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
/* 227 */     if (paramString1 == null) {
/* 228 */       return null;
/*     */     }
/*     */     try {
/* 231 */       return encodeText(paramString1, paramString2);
/* 232 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 233 */       throw new EncoderException(unsupportedEncodingException.getMessage(), unsupportedEncodingException);
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
/* 248 */     if (paramString == null) {
/* 249 */       return null;
/*     */     }
/* 251 */     return encode(paramString, getCharset());
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
/* 266 */     if (paramString == null) {
/* 267 */       return null;
/*     */     }
/*     */     try {
/* 270 */       return decodeText(paramString);
/* 271 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 272 */       throw new DecoderException(unsupportedEncodingException.getMessage(), unsupportedEncodingException);
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
/* 287 */     if (paramObject == null)
/* 288 */       return null; 
/* 289 */     if (paramObject instanceof String) {
/* 290 */       return encode((String)paramObject);
/*     */     }
/* 292 */     throw new EncoderException("Objects of type " + paramObject
/* 293 */         .getClass().getName() + " cannot be encoded using Q codec");
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
/* 311 */     if (paramObject == null)
/* 312 */       return null; 
/* 313 */     if (paramObject instanceof String) {
/* 314 */       return decode((String)paramObject);
/*     */     }
/* 316 */     throw new DecoderException("Objects of type " + paramObject
/* 317 */         .getClass().getName() + " cannot be decoded using Q codec");
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
/* 329 */     return this.charset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefaultCharset() {
/* 338 */     return this.charset.name();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEncodeBlanks() {
/* 347 */     return this.encodeBlanks;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEncodeBlanks(boolean paramBoolean) {
/* 357 */     this.encodeBlanks = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\net\QCodec.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */