/*     */ package org.apache.commons.codec.net;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.BitSet;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PercentCodec
/*     */   implements BinaryDecoder, BinaryEncoder
/*     */ {
/*     */   private static final byte ESCAPE_CHAR = 37;
/*  50 */   private final BitSet alwaysEncodeChars = new BitSet();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean plusForSpace;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   private int alwaysEncodeCharsMin = Integer.MAX_VALUE, alwaysEncodeCharsMax = Integer.MIN_VALUE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PercentCodec() {
/*  68 */     this.plusForSpace = false;
/*  69 */     insertAlwaysEncodeChar((byte)37);
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
/*     */   public PercentCodec(byte[] paramArrayOfbyte, boolean paramBoolean) {
/*  81 */     this.plusForSpace = paramBoolean;
/*  82 */     insertAlwaysEncodeChars(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void insertAlwaysEncodeChars(byte[] paramArrayOfbyte) {
/*  91 */     if (paramArrayOfbyte != null) {
/*  92 */       for (byte b : paramArrayOfbyte) {
/*  93 */         insertAlwaysEncodeChar(b);
/*     */       }
/*     */     }
/*  96 */     insertAlwaysEncodeChar((byte)37);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void insertAlwaysEncodeChar(byte paramByte) {
/* 106 */     this.alwaysEncodeChars.set(paramByte);
/* 107 */     if (paramByte < this.alwaysEncodeCharsMin) {
/* 108 */       this.alwaysEncodeCharsMin = paramByte;
/*     */     }
/* 110 */     if (paramByte > this.alwaysEncodeCharsMax) {
/* 111 */       this.alwaysEncodeCharsMax = paramByte;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] encode(byte[] paramArrayOfbyte) throws EncoderException {
/* 121 */     if (paramArrayOfbyte == null) {
/* 122 */       return null;
/*     */     }
/*     */     
/* 125 */     int i = expectedEncodingBytes(paramArrayOfbyte);
/* 126 */     boolean bool = (i != paramArrayOfbyte.length) ? true : false;
/* 127 */     if (bool || (this.plusForSpace && containsSpace(paramArrayOfbyte))) {
/* 128 */       return doEncode(paramArrayOfbyte, i, bool);
/*     */     }
/* 130 */     return paramArrayOfbyte;
/*     */   }
/*     */   
/*     */   private byte[] doEncode(byte[] paramArrayOfbyte, int paramInt, boolean paramBoolean) {
/* 134 */     ByteBuffer byteBuffer = ByteBuffer.allocate(paramInt);
/* 135 */     for (byte b : paramArrayOfbyte) {
/* 136 */       if (paramBoolean && canEncode(b)) {
/* 137 */         byte b1 = b;
/* 138 */         if (b1 < 0) {
/* 139 */           b1 = (byte)(256 + b1);
/*     */         }
/* 141 */         char c1 = Utils.hexDigit(b1 >> 4);
/* 142 */         char c2 = Utils.hexDigit(b1);
/* 143 */         byteBuffer.put((byte)37);
/* 144 */         byteBuffer.put((byte)c1);
/* 145 */         byteBuffer.put((byte)c2);
/*     */       }
/* 147 */       else if (this.plusForSpace && b == 32) {
/* 148 */         byteBuffer.put((byte)43);
/*     */       } else {
/* 150 */         byteBuffer.put(b);
/*     */       } 
/*     */     } 
/*     */     
/* 154 */     return byteBuffer.array();
/*     */   }
/*     */   
/*     */   private int expectedEncodingBytes(byte[] paramArrayOfbyte) {
/* 158 */     int i = 0;
/* 159 */     for (byte b : paramArrayOfbyte) {
/* 160 */       i += canEncode(b) ? 3 : 1;
/*     */     }
/* 162 */     return i;
/*     */   }
/*     */   
/*     */   private boolean containsSpace(byte[] paramArrayOfbyte) {
/* 166 */     for (byte b : paramArrayOfbyte) {
/* 167 */       if (b == 32) {
/* 168 */         return true;
/*     */       }
/*     */     } 
/* 171 */     return false;
/*     */   }
/*     */   
/*     */   private boolean canEncode(byte paramByte) {
/* 175 */     return (!isAsciiChar(paramByte) || (inAlwaysEncodeCharsRange(paramByte) && this.alwaysEncodeChars.get(paramByte)));
/*     */   }
/*     */   
/*     */   private boolean inAlwaysEncodeCharsRange(byte paramByte) {
/* 179 */     return (paramByte >= this.alwaysEncodeCharsMin && paramByte <= this.alwaysEncodeCharsMax);
/*     */   }
/*     */   
/*     */   private boolean isAsciiChar(byte paramByte) {
/* 183 */     return (paramByte >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] decode(byte[] paramArrayOfbyte) throws DecoderException {
/* 192 */     if (paramArrayOfbyte == null) {
/* 193 */       return null;
/*     */     }
/*     */     
/* 196 */     ByteBuffer byteBuffer = ByteBuffer.allocate(expectedDecodingBytes(paramArrayOfbyte));
/* 197 */     for (byte b = 0; b < paramArrayOfbyte.length; b++) {
/* 198 */       byte b1 = paramArrayOfbyte[b];
/* 199 */       if (b1 == 37) {
/*     */         try {
/* 201 */           int i = Utils.digit16(paramArrayOfbyte[++b]);
/* 202 */           int j = Utils.digit16(paramArrayOfbyte[++b]);
/* 203 */           byteBuffer.put((byte)((i << 4) + j));
/* 204 */         } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
/* 205 */           throw new DecoderException("Invalid percent decoding: ", arrayIndexOutOfBoundsException);
/*     */         }
/*     */       
/* 208 */       } else if (this.plusForSpace && b1 == 43) {
/* 209 */         byteBuffer.put((byte)32);
/*     */       } else {
/* 211 */         byteBuffer.put(b1);
/*     */       } 
/*     */     } 
/*     */     
/* 215 */     return byteBuffer.array();
/*     */   }
/*     */   
/*     */   private int expectedDecodingBytes(byte[] paramArrayOfbyte) {
/* 219 */     byte b = 0;
/* 220 */     for (int i = 0; i < paramArrayOfbyte.length; ) {
/* 221 */       byte b1 = paramArrayOfbyte[i];
/* 222 */       i += (b1 == 37) ? 3 : 1;
/* 223 */       b++;
/*     */     } 
/* 225 */     return b;
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
/*     */   public Object encode(Object paramObject) throws EncoderException {
/* 237 */     if (paramObject == null)
/* 238 */       return null; 
/* 239 */     if (paramObject instanceof byte[]) {
/* 240 */       return encode((byte[])paramObject);
/*     */     }
/* 242 */     throw new EncoderException("Objects of type " + paramObject.getClass().getName() + " cannot be Percent encoded");
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
/*     */   public Object decode(Object paramObject) throws DecoderException {
/* 255 */     if (paramObject == null)
/* 256 */       return null; 
/* 257 */     if (paramObject instanceof byte[]) {
/* 258 */       return decode((byte[])paramObject);
/*     */     }
/* 260 */     throw new DecoderException("Objects of type " + paramObject.getClass().getName() + " cannot be Percent decoded");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\net\PercentCodec.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */