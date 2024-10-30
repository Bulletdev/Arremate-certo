/*     */ package org.apache.commons.codec.binary;
/*     */ 
/*     */ import org.apache.commons.codec.CodecPolicy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Base16
/*     */   extends BaseNCodec
/*     */ {
/*     */   private static final int BITS_PER_ENCODED_BYTE = 4;
/*     */   private static final int BYTES_PER_ENCODED_BLOCK = 2;
/*     */   private static final int BYTES_PER_UNENCODED_BLOCK = 1;
/*  60 */   private static final byte[] UPPER_CASE_DECODE_TABLE = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  73 */   private static final byte[] UPPER_CASE_ENCODE_TABLE = new byte[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  83 */   private static final byte[] LOWER_CASE_DECODE_TABLE = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  98 */   private static final byte[] LOWER_CASE_ENCODE_TABLE = new byte[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int MASK_4BITS = 15;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final byte[] decodeTable;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final byte[] encodeTable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Base16() {
/* 120 */     this(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Base16(boolean paramBoolean) {
/* 129 */     this(paramBoolean, DECODING_POLICY_DEFAULT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Base16(boolean paramBoolean, CodecPolicy paramCodecPolicy) {
/* 139 */     super(1, 2, 0, 0, (byte)61, paramCodecPolicy);
/*     */     
/* 141 */     if (paramBoolean) {
/* 142 */       this.encodeTable = LOWER_CASE_ENCODE_TABLE;
/* 143 */       this.decodeTable = LOWER_CASE_DECODE_TABLE;
/*     */     } else {
/* 145 */       this.encodeTable = UPPER_CASE_ENCODE_TABLE;
/* 146 */       this.decodeTable = UPPER_CASE_DECODE_TABLE;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, BaseNCodec.Context paramContext) {
/* 152 */     if (paramContext.eof || paramInt2 < 0) {
/* 153 */       paramContext.eof = true;
/* 154 */       if (paramContext.ibitWorkArea != 0) {
/* 155 */         validateTrailingCharacter();
/*     */       }
/*     */       
/*     */       return;
/*     */     } 
/* 160 */     int i = Math.min(paramArrayOfbyte.length - paramInt1, paramInt2);
/* 161 */     int j = ((paramContext.ibitWorkArea != 0) ? 1 : 0) + i;
/*     */ 
/*     */     
/* 164 */     if (j == 1 && j == i) {
/* 165 */       paramContext.ibitWorkArea = decodeOctet(paramArrayOfbyte[paramInt1]) + 1;
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 170 */     int k = (j % 2 == 0) ? j : (j - 1);
/*     */     
/* 172 */     byte[] arrayOfByte = ensureBufferSize(k / 2, paramContext);
/*     */ 
/*     */     
/* 175 */     byte b = 0;
/* 176 */     if (i < j) {
/*     */       
/* 178 */       int m = paramContext.ibitWorkArea - 1 << 4;
/* 179 */       m |= decodeOctet(paramArrayOfbyte[paramInt1++]);
/* 180 */       b = 2;
/*     */       
/* 182 */       arrayOfByte[paramContext.pos++] = (byte)m;
/*     */ 
/*     */       
/* 185 */       paramContext.ibitWorkArea = 0;
/*     */     } 
/*     */     
/* 188 */     while (b < k) {
/* 189 */       int m = decodeOctet(paramArrayOfbyte[paramInt1++]) << 4;
/* 190 */       m |= decodeOctet(paramArrayOfbyte[paramInt1++]);
/* 191 */       b += 2;
/* 192 */       arrayOfByte[paramContext.pos++] = (byte)m;
/*     */     } 
/*     */ 
/*     */     
/* 196 */     if (b < i) {
/* 197 */       paramContext.ibitWorkArea = decodeOctet(paramArrayOfbyte[b]) + 1;
/*     */     }
/*     */   }
/*     */   
/*     */   private int decodeOctet(byte paramByte) {
/* 202 */     byte b = -1;
/* 203 */     if ((paramByte & 0xFF) < this.decodeTable.length) {
/* 204 */       b = this.decodeTable[paramByte];
/*     */     }
/*     */     
/* 207 */     if (b == -1) {
/* 208 */       throw new IllegalArgumentException("Invalid octet in encoded value: " + paramByte);
/*     */     }
/*     */     
/* 211 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   void encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, BaseNCodec.Context paramContext) {
/* 216 */     if (paramContext.eof) {
/*     */       return;
/*     */     }
/*     */     
/* 220 */     if (paramInt2 < 0) {
/* 221 */       paramContext.eof = true;
/*     */       
/*     */       return;
/*     */     } 
/* 225 */     int i = paramInt2 * 2;
/* 226 */     if (i < 0) {
/* 227 */       throw new IllegalArgumentException("Input length exceeds maximum size for encoded data: " + paramInt2);
/*     */     }
/*     */     
/* 230 */     byte[] arrayOfByte = ensureBufferSize(i, paramContext);
/*     */     
/* 232 */     int j = paramInt1 + paramInt2;
/* 233 */     for (int k = paramInt1; k < j; k++) {
/* 234 */       byte b = paramArrayOfbyte[k];
/* 235 */       int m = b >> 4 & 0xF;
/* 236 */       int n = b & 0xF;
/* 237 */       arrayOfByte[paramContext.pos++] = this.encodeTable[m];
/* 238 */       arrayOfByte[paramContext.pos++] = this.encodeTable[n];
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
/*     */   public boolean isInAlphabet(byte paramByte) {
/* 251 */     return ((paramByte & 0xFF) < this.decodeTable.length && this.decodeTable[paramByte] != -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void validateTrailingCharacter() {
/* 261 */     if (isStrictDecoding())
/* 262 */       throw new IllegalArgumentException("Strict decoding: Last encoded character is a valid base 16 alphabetcharacter but not a possible encoding. Decoding requires at least two characters to create one byte."); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\binary\Base16.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */