/*     */ package org.apache.commons.codec.binary;
/*     */ 
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
/*     */ public class BinaryCodec
/*     */   implements BinaryDecoder, BinaryEncoder
/*     */ {
/*  41 */   private static final char[] EMPTY_CHAR_ARRAY = new char[0];
/*     */ 
/*     */   
/*  44 */   private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
/*     */ 
/*     */   
/*     */   private static final int BIT_0 = 1;
/*     */ 
/*     */   
/*     */   private static final int BIT_1 = 2;
/*     */ 
/*     */   
/*     */   private static final int BIT_2 = 4;
/*     */ 
/*     */   
/*     */   private static final int BIT_3 = 8;
/*     */ 
/*     */   
/*     */   private static final int BIT_4 = 16;
/*     */ 
/*     */   
/*     */   private static final int BIT_5 = 32;
/*     */ 
/*     */   
/*     */   private static final int BIT_6 = 64;
/*     */ 
/*     */   
/*     */   private static final int BIT_7 = 128;
/*     */   
/*  70 */   private static final int[] BITS = new int[] { 1, 2, 4, 8, 16, 32, 64, 128 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] fromAscii(byte[] paramArrayOfbyte) {
/*  80 */     if (isEmpty(paramArrayOfbyte)) {
/*  81 */       return EMPTY_BYTE_ARRAY;
/*     */     }
/*     */     
/*  84 */     byte[] arrayOfByte = new byte[paramArrayOfbyte.length >> 3];
/*     */     
/*     */     byte b;
/*     */     
/*     */     int i;
/*  89 */     for (b = 0, i = paramArrayOfbyte.length - 1; b < arrayOfByte.length; b++, i -= 8) {
/*  90 */       for (byte b1 = 0; b1 < BITS.length; b1++) {
/*  91 */         if (paramArrayOfbyte[i - b1] == 49) {
/*  92 */           arrayOfByte[b] = (byte)(arrayOfByte[b] | BITS[b1]);
/*     */         }
/*     */       } 
/*     */     } 
/*  96 */     return arrayOfByte;
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
/*     */   public static byte[] fromAscii(char[] paramArrayOfchar) {
/* 112 */     if (paramArrayOfchar == null || paramArrayOfchar.length == 0) {
/* 113 */       return EMPTY_BYTE_ARRAY;
/*     */     }
/*     */     
/* 116 */     byte[] arrayOfByte = new byte[paramArrayOfchar.length >> 3];
/*     */     
/*     */     byte b;
/*     */     
/*     */     int i;
/* 121 */     for (b = 0, i = paramArrayOfchar.length - 1; b < arrayOfByte.length; b++, i -= 8) {
/* 122 */       for (byte b1 = 0; b1 < BITS.length; b1++) {
/* 123 */         if (paramArrayOfchar[i - b1] == '1') {
/* 124 */           arrayOfByte[b] = (byte)(arrayOfByte[b] | BITS[b1]);
/*     */         }
/*     */       } 
/*     */     } 
/* 128 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isEmpty(byte[] paramArrayOfbyte) {
/* 139 */     return (paramArrayOfbyte == null || paramArrayOfbyte.length == 0);
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
/*     */   public static byte[] toAsciiBytes(byte[] paramArrayOfbyte) {
/* 152 */     if (isEmpty(paramArrayOfbyte)) {
/* 153 */       return EMPTY_BYTE_ARRAY;
/*     */     }
/*     */     
/* 156 */     byte[] arrayOfByte = new byte[paramArrayOfbyte.length << 3];
/*     */     
/*     */     byte b;
/*     */     
/*     */     int i;
/* 161 */     for (b = 0, i = arrayOfByte.length - 1; b < paramArrayOfbyte.length; b++, i -= 8) {
/* 162 */       for (byte b1 = 0; b1 < BITS.length; b1++) {
/* 163 */         if ((paramArrayOfbyte[b] & BITS[b1]) == 0) {
/* 164 */           arrayOfByte[i - b1] = 48;
/*     */         } else {
/* 166 */           arrayOfByte[i - b1] = 49;
/*     */         } 
/*     */       } 
/*     */     } 
/* 170 */     return arrayOfByte;
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
/*     */   public static char[] toAsciiChars(byte[] paramArrayOfbyte) {
/* 182 */     if (isEmpty(paramArrayOfbyte)) {
/* 183 */       return EMPTY_CHAR_ARRAY;
/*     */     }
/*     */     
/* 186 */     char[] arrayOfChar = new char[paramArrayOfbyte.length << 3];
/*     */     
/*     */     byte b;
/*     */     
/*     */     int i;
/* 191 */     for (b = 0, i = arrayOfChar.length - 1; b < paramArrayOfbyte.length; b++, i -= 8) {
/* 192 */       for (byte b1 = 0; b1 < BITS.length; b1++) {
/* 193 */         if ((paramArrayOfbyte[b] & BITS[b1]) == 0) {
/* 194 */           arrayOfChar[i - b1] = '0';
/*     */         } else {
/* 196 */           arrayOfChar[i - b1] = '1';
/*     */         } 
/*     */       } 
/*     */     } 
/* 200 */     return arrayOfChar;
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
/*     */   public static String toAsciiString(byte[] paramArrayOfbyte) {
/* 212 */     return new String(toAsciiChars(paramArrayOfbyte));
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
/*     */   public byte[] decode(byte[] paramArrayOfbyte) {
/* 225 */     return fromAscii(paramArrayOfbyte);
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
/*     */   public Object decode(Object paramObject) throws DecoderException {
/* 240 */     if (paramObject == null) {
/* 241 */       return EMPTY_BYTE_ARRAY;
/*     */     }
/* 243 */     if (paramObject instanceof byte[]) {
/* 244 */       return fromAscii((byte[])paramObject);
/*     */     }
/* 246 */     if (paramObject instanceof char[]) {
/* 247 */       return fromAscii((char[])paramObject);
/*     */     }
/* 249 */     if (paramObject instanceof String) {
/* 250 */       return fromAscii(((String)paramObject).toCharArray());
/*     */     }
/* 252 */     throw new DecoderException("argument not a byte array");
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
/*     */   public byte[] encode(byte[] paramArrayOfbyte) {
/* 265 */     return toAsciiBytes(paramArrayOfbyte);
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
/* 280 */     if (!(paramObject instanceof byte[])) {
/* 281 */       throw new EncoderException("argument not a byte array");
/*     */     }
/* 283 */     return toAsciiChars((byte[])paramObject);
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
/*     */   public byte[] toByteArray(String paramString) {
/* 295 */     if (paramString == null) {
/* 296 */       return EMPTY_BYTE_ARRAY;
/*     */     }
/* 298 */     return fromAscii(paramString.toCharArray());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\binary\BinaryCodec.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */