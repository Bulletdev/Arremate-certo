/*     */ package org.apache.commons.codec.net;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.IllegalCharsetNameException;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.nio.charset.UnsupportedCharsetException;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QuotedPrintableCodec
/*     */   implements BinaryDecoder, BinaryEncoder, StringDecoder, StringEncoder
/*     */ {
/*     */   private final Charset charset;
/*     */   private final boolean strict;
/*  85 */   private static final BitSet PRINTABLE_CHARS = new BitSet(256);
/*     */ 
/*     */   
/*     */   private static final byte ESCAPE_CHAR = 61;
/*     */ 
/*     */   
/*     */   private static final byte TAB = 9;
/*     */ 
/*     */   
/*     */   private static final byte SPACE = 32;
/*     */   
/*     */   private static final byte CR = 13;
/*     */   
/*     */   private static final byte LF = 10;
/*     */   
/*     */   private static final int SAFE_LENGTH = 73;
/*     */ 
/*     */   
/*     */   static {
/*     */     byte b;
/* 105 */     for (b = 33; b <= 60; b++) {
/* 106 */       PRINTABLE_CHARS.set(b);
/*     */     }
/* 108 */     for (b = 62; b <= 126; b++) {
/* 109 */       PRINTABLE_CHARS.set(b);
/*     */     }
/* 111 */     PRINTABLE_CHARS.set(9);
/* 112 */     PRINTABLE_CHARS.set(32);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public QuotedPrintableCodec() {
/* 119 */     this(StandardCharsets.UTF_8, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public QuotedPrintableCodec(boolean paramBoolean) {
/* 130 */     this(StandardCharsets.UTF_8, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public QuotedPrintableCodec(Charset paramCharset) {
/* 141 */     this(paramCharset, false);
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
/*     */   public QuotedPrintableCodec(Charset paramCharset, boolean paramBoolean) {
/* 154 */     this.charset = paramCharset;
/* 155 */     this.strict = paramBoolean;
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
/*     */   public QuotedPrintableCodec(String paramString) throws IllegalCharsetNameException, IllegalArgumentException, UnsupportedCharsetException {
/* 175 */     this(Charset.forName(paramString), false);
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
/*     */   private static final int encodeQuotedPrintable(int paramInt, ByteArrayOutputStream paramByteArrayOutputStream) {
/* 188 */     paramByteArrayOutputStream.write(61);
/* 189 */     char c1 = Utils.hexDigit(paramInt >> 4);
/* 190 */     char c2 = Utils.hexDigit(paramInt);
/* 191 */     paramByteArrayOutputStream.write(c1);
/* 192 */     paramByteArrayOutputStream.write(c2);
/* 193 */     return 3;
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
/*     */   private static int getUnsignedOctet(int paramInt, byte[] paramArrayOfbyte) {
/* 207 */     int i = paramArrayOfbyte[paramInt];
/* 208 */     if (i < 0) {
/* 209 */       i = 256 + i;
/*     */     }
/* 211 */     return i;
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
/*     */   private static int encodeByte(int paramInt, boolean paramBoolean, ByteArrayOutputStream paramByteArrayOutputStream) {
/* 227 */     if (paramBoolean) {
/* 228 */       return encodeQuotedPrintable(paramInt, paramByteArrayOutputStream);
/*     */     }
/* 230 */     paramByteArrayOutputStream.write(paramInt);
/* 231 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isWhitespace(int paramInt) {
/* 242 */     return (paramInt == 32 || paramInt == 9);
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
/*     */   public static final byte[] encodeQuotedPrintable(BitSet paramBitSet, byte[] paramArrayOfbyte) {
/* 258 */     return encodeQuotedPrintable(paramBitSet, paramArrayOfbyte, false);
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
/*     */   public static final byte[] encodeQuotedPrintable(BitSet paramBitSet, byte[] paramArrayOfbyte, boolean paramBoolean) {
/* 278 */     if (paramArrayOfbyte == null) {
/* 279 */       return null;
/*     */     }
/* 281 */     if (paramBitSet == null) {
/* 282 */       paramBitSet = PRINTABLE_CHARS;
/*     */     }
/* 284 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */     
/* 286 */     if (paramBoolean) {
/* 287 */       int i = 1;
/*     */       
/*     */       int j;
/* 290 */       for (j = 0; j < paramArrayOfbyte.length - 3; j++) {
/* 291 */         int m = getUnsignedOctet(j, paramArrayOfbyte);
/* 292 */         if (i < 73) {
/*     */           
/* 294 */           i += encodeByte(m, !paramBitSet.get(m), byteArrayOutputStream);
/*     */         } else {
/*     */           
/* 297 */           encodeByte(m, (!paramBitSet.get(m) || isWhitespace(m)), byteArrayOutputStream);
/*     */ 
/*     */           
/* 300 */           byteArrayOutputStream.write(61);
/* 301 */           byteArrayOutputStream.write(13);
/* 302 */           byteArrayOutputStream.write(10);
/* 303 */           i = 1;
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 309 */       j = getUnsignedOctet(paramArrayOfbyte.length - 3, paramArrayOfbyte);
/* 310 */       boolean bool = (!paramBitSet.get(j) || (isWhitespace(j) && i > 68)) ? true : false;
/* 311 */       i += encodeByte(j, bool, byteArrayOutputStream);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 316 */       if (i > 71) {
/* 317 */         byteArrayOutputStream.write(61);
/* 318 */         byteArrayOutputStream.write(13);
/* 319 */         byteArrayOutputStream.write(10);
/*     */       } 
/* 321 */       for (int k = paramArrayOfbyte.length - 2; k < paramArrayOfbyte.length; k++) {
/* 322 */         j = getUnsignedOctet(k, paramArrayOfbyte);
/*     */         
/* 324 */         bool = (!paramBitSet.get(j) || (k > paramArrayOfbyte.length - 2 && isWhitespace(j))) ? true : false;
/* 325 */         encodeByte(j, bool, byteArrayOutputStream);
/*     */       } 
/*     */     } else {
/* 328 */       for (byte b : paramArrayOfbyte) {
/* 329 */         int i = b;
/* 330 */         if (i < 0) {
/* 331 */           i = 256 + i;
/*     */         }
/* 333 */         if (paramBitSet.get(i)) {
/* 334 */           byteArrayOutputStream.write(i);
/*     */         } else {
/* 336 */           encodeQuotedPrintable(i, byteArrayOutputStream);
/*     */         } 
/*     */       } 
/*     */     } 
/* 340 */     return byteArrayOutputStream.toByteArray();
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
/*     */   public static final byte[] decodeQuotedPrintable(byte[] paramArrayOfbyte) throws DecoderException {
/* 357 */     if (paramArrayOfbyte == null) {
/* 358 */       return null;
/*     */     }
/* 360 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 361 */     for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/* 362 */       byte b1 = paramArrayOfbyte[b];
/* 363 */       if (b1 == 61) {
/*     */         
/*     */         try {
/* 366 */           if (paramArrayOfbyte[++b] != 13)
/*     */           
/*     */           { 
/* 369 */             int i = Utils.digit16(paramArrayOfbyte[b]);
/* 370 */             int j = Utils.digit16(paramArrayOfbyte[++b]);
/* 371 */             byteArrayOutputStream.write((char)((i << 4) + j)); } 
/* 372 */         } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/* 373 */           throw new DecoderException("Invalid quoted-printable encoding", arrayIndexOutOfBoundsException);
/*     */         } 
/* 375 */       } else if (b1 != 13 && b1 != 10) {
/*     */         
/* 377 */         byteArrayOutputStream.write(b1);
/*     */       } 
/*     */     } 
/* 380 */     return byteArrayOutputStream.toByteArray();
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
/*     */   public byte[] encode(byte[] paramArrayOfbyte) {
/* 396 */     return encodeQuotedPrintable(PRINTABLE_CHARS, paramArrayOfbyte, this.strict);
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
/*     */   public byte[] decode(byte[] paramArrayOfbyte) throws DecoderException {
/* 414 */     return decodeQuotedPrintable(paramArrayOfbyte);
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
/*     */   public String encode(String paramString) throws EncoderException {
/* 434 */     return encode(paramString, getCharset());
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
/*     */   public String decode(String paramString, Charset paramCharset) throws DecoderException {
/* 451 */     if (paramString == null) {
/* 452 */       return null;
/*     */     }
/* 454 */     return new String(decode(StringUtils.getBytesUsAscii(paramString)), paramCharset);
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
/*     */   public String decode(String paramString1, String paramString2) throws DecoderException, UnsupportedEncodingException {
/* 473 */     if (paramString1 == null) {
/* 474 */       return null;
/*     */     }
/* 476 */     return new String(decode(StringUtils.getBytesUsAscii(paramString1)), paramString2);
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
/* 492 */     return decode(paramString, getCharset());
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
/*     */   public Object encode(Object paramObject) throws EncoderException {
/* 507 */     if (paramObject == null)
/* 508 */       return null; 
/* 509 */     if (paramObject instanceof byte[])
/* 510 */       return encode((byte[])paramObject); 
/* 511 */     if (paramObject instanceof String) {
/* 512 */       return encode((String)paramObject);
/*     */     }
/* 514 */     throw new EncoderException("Objects of type " + paramObject
/* 515 */         .getClass().getName() + " cannot be quoted-printable encoded");
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
/* 533 */     if (paramObject == null)
/* 534 */       return null; 
/* 535 */     if (paramObject instanceof byte[])
/* 536 */       return decode((byte[])paramObject); 
/* 537 */     if (paramObject instanceof String) {
/* 538 */       return decode((String)paramObject);
/*     */     }
/* 540 */     throw new DecoderException("Objects of type " + paramObject
/* 541 */         .getClass().getName() + " cannot be quoted-printable decoded");
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
/* 553 */     return this.charset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefaultCharset() {
/* 562 */     return this.charset.name();
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
/*     */   public String encode(String paramString, Charset paramCharset) {
/* 580 */     if (paramString == null) {
/* 581 */       return null;
/*     */     }
/* 583 */     return StringUtils.newStringUsAscii(encode(paramString.getBytes(paramCharset)));
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
/*     */   public String encode(String paramString1, String paramString2) throws UnsupportedEncodingException {
/* 602 */     if (paramString1 == null) {
/* 603 */       return null;
/*     */     }
/* 605 */     return StringUtils.newStringUsAscii(encode(paramString1.getBytes(paramString2)));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\net\QuotedPrintableCodec.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */