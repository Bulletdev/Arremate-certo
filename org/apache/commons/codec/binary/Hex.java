/*     */ package org.apache.commons.codec.binary;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import org.apache.commons.codec.BinaryDecoder;
/*     */ import org.apache.commons.codec.BinaryEncoder;
/*     */ import org.apache.commons.codec.DecoderException;
/*     */ import org.apache.commons.codec.EncoderException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Hex
/*     */   implements BinaryDecoder, BinaryEncoder
/*     */ {
/*  45 */   public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String DEFAULT_CHARSET_NAME = "UTF-8";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  57 */   private static final char[] DIGITS_LOWER = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   private static final char[] DIGITS_UPPER = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Charset charset;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] decodeHex(char[] paramArrayOfchar) throws DecoderException {
/*  76 */     byte[] arrayOfByte = new byte[paramArrayOfchar.length >> 1];
/*  77 */     decodeHex(paramArrayOfchar, arrayOfByte, 0);
/*  78 */     return arrayOfByte;
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
/*     */   public static int decodeHex(char[] paramArrayOfchar, byte[] paramArrayOfbyte, int paramInt) throws DecoderException {
/*  94 */     int i = paramArrayOfchar.length;
/*     */     
/*  96 */     if ((i & 0x1) != 0) {
/*  97 */       throw new DecoderException("Odd number of characters.");
/*     */     }
/*     */     
/* 100 */     int j = i >> 1;
/* 101 */     if (paramArrayOfbyte.length - paramInt < j) {
/* 102 */       throw new DecoderException("Output array is not large enough to accommodate decoded data.");
/*     */     }
/*     */     int k;
/*     */     byte b;
/* 106 */     for (k = paramInt, b = 0; b < i; k++) {
/* 107 */       int m = toDigit(paramArrayOfchar[b], b) << 4;
/* 108 */       b++;
/* 109 */       m |= toDigit(paramArrayOfchar[b], b);
/* 110 */       b++;
/* 111 */       paramArrayOfbyte[k] = (byte)(m & 0xFF);
/*     */     } 
/*     */     
/* 114 */     return j;
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
/*     */   public static byte[] decodeHex(String paramString) throws DecoderException {
/* 128 */     return decodeHex(paramString.toCharArray());
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
/*     */   public static char[] encodeHex(byte[] paramArrayOfbyte) {
/* 140 */     return encodeHex(paramArrayOfbyte, true);
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
/*     */   public static char[] encodeHex(byte[] paramArrayOfbyte, boolean paramBoolean) {
/* 154 */     return encodeHex(paramArrayOfbyte, paramBoolean ? DIGITS_LOWER : DIGITS_UPPER);
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
/*     */   protected static char[] encodeHex(byte[] paramArrayOfbyte, char[] paramArrayOfchar) {
/* 169 */     int i = paramArrayOfbyte.length;
/* 170 */     char[] arrayOfChar = new char[i << 1];
/* 171 */     encodeHex(paramArrayOfbyte, 0, paramArrayOfbyte.length, paramArrayOfchar, arrayOfChar, 0);
/* 172 */     return arrayOfChar;
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
/*     */   public static char[] encodeHex(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
/* 188 */     char[] arrayOfChar = new char[paramInt2 << 1];
/* 189 */     encodeHex(paramArrayOfbyte, paramInt1, paramInt2, paramBoolean ? DIGITS_LOWER : DIGITS_UPPER, arrayOfChar, 0);
/* 190 */     return arrayOfChar;
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
/*     */   public static void encodeHex(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean, char[] paramArrayOfchar, int paramInt3) {
/* 206 */     encodeHex(paramArrayOfbyte, paramInt1, paramInt2, paramBoolean ? DIGITS_LOWER : DIGITS_UPPER, paramArrayOfchar, paramInt3);
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
/*     */   private static void encodeHex(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, char[] paramArrayOfchar1, char[] paramArrayOfchar2, int paramInt3) {
/* 222 */     for (int i = paramInt1, j = paramInt3; i < paramInt1 + paramInt2; i++) {
/* 223 */       paramArrayOfchar2[j++] = paramArrayOfchar1[(0xF0 & paramArrayOfbyte[i]) >>> 4];
/* 224 */       paramArrayOfchar2[j++] = paramArrayOfchar1[0xF & paramArrayOfbyte[i]];
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
/*     */   public static char[] encodeHex(ByteBuffer paramByteBuffer) {
/* 241 */     return encodeHex(paramByteBuffer, true);
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
/*     */   public static char[] encodeHex(ByteBuffer paramByteBuffer, boolean paramBoolean) {
/* 258 */     return encodeHex(paramByteBuffer, paramBoolean ? DIGITS_LOWER : DIGITS_UPPER);
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
/*     */   protected static char[] encodeHex(ByteBuffer paramByteBuffer, char[] paramArrayOfchar) {
/* 276 */     return encodeHex(toByteArray(paramByteBuffer), paramArrayOfchar);
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
/*     */   public static String encodeHexString(byte[] paramArrayOfbyte) {
/* 288 */     return new String(encodeHex(paramArrayOfbyte));
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
/*     */   public static String encodeHexString(byte[] paramArrayOfbyte, boolean paramBoolean) {
/* 301 */     return new String(encodeHex(paramArrayOfbyte, paramBoolean));
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
/*     */   public static String encodeHexString(ByteBuffer paramByteBuffer) {
/* 316 */     return new String(encodeHex(paramByteBuffer));
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
/*     */   public static String encodeHexString(ByteBuffer paramByteBuffer, boolean paramBoolean) {
/* 332 */     return new String(encodeHex(paramByteBuffer, paramBoolean));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static byte[] toByteArray(ByteBuffer paramByteBuffer) {
/* 343 */     int i = paramByteBuffer.remaining();
/*     */     
/* 345 */     if (paramByteBuffer.hasArray()) {
/* 346 */       byte[] arrayOfByte1 = paramByteBuffer.array();
/* 347 */       if (i == arrayOfByte1.length) {
/* 348 */         paramByteBuffer.position(i);
/* 349 */         return arrayOfByte1;
/*     */       } 
/*     */     } 
/*     */     
/* 353 */     byte[] arrayOfByte = new byte[i];
/* 354 */     paramByteBuffer.get(arrayOfByte);
/* 355 */     return arrayOfByte;
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
/*     */   protected static int toDigit(char paramChar, int paramInt) throws DecoderException {
/* 367 */     int i = Character.digit(paramChar, 16);
/* 368 */     if (i == -1) {
/* 369 */       throw new DecoderException("Illegal hexadecimal character " + paramChar + " at index " + paramInt);
/*     */     }
/* 371 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Hex() {
/* 381 */     this.charset = DEFAULT_CHARSET;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Hex(Charset paramCharset) {
/* 391 */     this.charset = paramCharset;
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
/*     */   public Hex(String paramString) {
/* 403 */     this(Charset.forName(paramString));
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
/*     */   public byte[] decode(byte[] paramArrayOfbyte) throws DecoderException {
/* 418 */     return decodeHex((new String(paramArrayOfbyte, getCharset())).toCharArray());
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
/*     */   public byte[] decode(ByteBuffer paramByteBuffer) throws DecoderException {
/* 436 */     return decodeHex((new String(toByteArray(paramByteBuffer), getCharset())).toCharArray());
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
/*     */   public Object decode(Object paramObject) throws DecoderException {
/* 452 */     if (paramObject instanceof String)
/* 453 */       return decode(((String)paramObject).toCharArray()); 
/* 454 */     if (paramObject instanceof byte[])
/* 455 */       return decode((byte[])paramObject); 
/* 456 */     if (paramObject instanceof ByteBuffer) {
/* 457 */       return decode((ByteBuffer)paramObject);
/*     */     }
/*     */     try {
/* 460 */       return decodeHex((char[])paramObject);
/* 461 */     } catch (ClassCastException classCastException) {
/* 462 */       throw new DecoderException(classCastException.getMessage(), classCastException);
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
/*     */   public byte[] encode(byte[] paramArrayOfbyte) {
/* 483 */     return encodeHexString(paramArrayOfbyte).getBytes(getCharset());
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
/*     */   public byte[] encode(ByteBuffer paramByteBuffer) {
/* 503 */     return encodeHexString(paramByteBuffer).getBytes(getCharset());
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
/*     */   public Object encode(Object paramObject) throws EncoderException {
/*     */     byte[] arrayOfByte;
/* 523 */     if (paramObject instanceof String) {
/* 524 */       arrayOfByte = ((String)paramObject).getBytes(getCharset());
/* 525 */     } else if (paramObject instanceof ByteBuffer) {
/* 526 */       arrayOfByte = toByteArray((ByteBuffer)paramObject);
/*     */     } else {
/*     */       try {
/* 529 */         arrayOfByte = (byte[])paramObject;
/* 530 */       } catch (ClassCastException classCastException) {
/* 531 */         throw new EncoderException(classCastException.getMessage(), classCastException);
/*     */       } 
/*     */     } 
/* 534 */     return encodeHex(arrayOfByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Charset getCharset() {
/* 544 */     return this.charset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCharsetName() {
/* 554 */     return this.charset.name();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 564 */     return super.toString() + "[charsetName=" + this.charset + "]";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\binary\Hex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */