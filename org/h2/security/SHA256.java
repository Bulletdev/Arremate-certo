/*     */ package org.h2.security;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SHA256
/*     */ {
/*  19 */   private static final int[] K = new int[] { 1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  34 */   private static final int[] HH = new int[] { 1779033703, -1150833019, 1013904242, -1521486534, 1359893119, -1694144372, 528734635, 1541459225 };
/*     */ 
/*     */   
/*  37 */   private final byte[] result = new byte[32];
/*  38 */   private final int[] w = new int[64];
/*  39 */   private final int[] hh = new int[8];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] getHashWithSalt(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  53 */     byte[] arrayOfByte = new byte[paramArrayOfbyte1.length + paramArrayOfbyte2.length];
/*  54 */     System.arraycopy(paramArrayOfbyte1, 0, arrayOfByte, 0, paramArrayOfbyte1.length);
/*  55 */     System.arraycopy(paramArrayOfbyte2, 0, arrayOfByte, paramArrayOfbyte1.length, paramArrayOfbyte2.length);
/*  56 */     return getHash(arrayOfByte, true);
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
/*     */   public static byte[] getKeyPasswordHash(String paramString, char[] paramArrayOfchar) {
/*  72 */     String str = paramString + "@";
/*  73 */     byte[] arrayOfByte = new byte[2 * (str.length() + paramArrayOfchar.length)];
/*  74 */     byte b1 = 0;
/*  75 */     for (byte b2 = 0; b2 < null; b2++) {
/*  76 */       char c = str.charAt(b2);
/*  77 */       arrayOfByte[b1++] = (byte)(c >> 8);
/*  78 */       arrayOfByte[b1++] = (byte)c;
/*     */     } 
/*  80 */     for (char c : paramArrayOfchar) {
/*  81 */       arrayOfByte[b1++] = (byte)(c >> 8);
/*  82 */       arrayOfByte[b1++] = (byte)c;
/*     */     } 
/*  84 */     Arrays.fill(paramArrayOfchar, false);
/*  85 */     return getHash(arrayOfByte, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] getHMAC(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  96 */     paramArrayOfbyte1 = normalizeKeyForHMAC(paramArrayOfbyte1);
/*  97 */     int i = paramArrayOfbyte2.length;
/*  98 */     int j = 64 + Math.max(32, i);
/*  99 */     int k = getIntCount(j);
/* 100 */     byte[] arrayOfByte1 = new byte[k * 4];
/* 101 */     int[] arrayOfInt = new int[k];
/* 102 */     SHA256 sHA256 = new SHA256();
/* 103 */     byte[] arrayOfByte2 = new byte[64 + i];
/* 104 */     byte[] arrayOfByte3 = new byte[96];
/* 105 */     sHA256.calculateHMAC(paramArrayOfbyte1, paramArrayOfbyte2, i, arrayOfByte2, arrayOfByte3, arrayOfByte1, arrayOfInt);
/* 106 */     return sHA256.result;
/*     */   }
/*     */ 
/*     */   
/*     */   private void calculateHMAC(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt, byte[] paramArrayOfbyte3, byte[] paramArrayOfbyte4, byte[] paramArrayOfbyte5, int[] paramArrayOfint) {
/* 111 */     Arrays.fill(paramArrayOfbyte3, 0, 64, (byte)54);
/* 112 */     xor(paramArrayOfbyte3, paramArrayOfbyte1, 64);
/* 113 */     System.arraycopy(paramArrayOfbyte2, 0, paramArrayOfbyte3, 64, paramInt);
/* 114 */     calculateHash(paramArrayOfbyte3, 64 + paramInt, paramArrayOfbyte5, paramArrayOfint);
/* 115 */     Arrays.fill(paramArrayOfbyte4, 0, 64, (byte)92);
/* 116 */     xor(paramArrayOfbyte4, paramArrayOfbyte1, 64);
/* 117 */     System.arraycopy(this.result, 0, paramArrayOfbyte4, 64, 32);
/* 118 */     calculateHash(paramArrayOfbyte4, 96, paramArrayOfbyte5, paramArrayOfint);
/*     */   }
/*     */   
/*     */   private static byte[] normalizeKeyForHMAC(byte[] paramArrayOfbyte) {
/* 122 */     if (paramArrayOfbyte.length > 64) {
/* 123 */       paramArrayOfbyte = getHash(paramArrayOfbyte, false);
/*     */     }
/* 125 */     if (paramArrayOfbyte.length < 64) {
/* 126 */       paramArrayOfbyte = Arrays.copyOf(paramArrayOfbyte, 64);
/*     */     }
/* 128 */     return paramArrayOfbyte;
/*     */   }
/*     */   
/*     */   private static void xor(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt) {
/* 132 */     for (byte b = 0; b < paramInt; b++) {
/* 133 */       paramArrayOfbyte1[b] = (byte)(paramArrayOfbyte1[b] ^ paramArrayOfbyte2[b]);
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
/*     */   public static byte[] getPBKDF2(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt1, int paramInt2) {
/* 148 */     byte[] arrayOfByte1 = new byte[paramInt2];
/* 149 */     byte[] arrayOfByte2 = normalizeKeyForHMAC(paramArrayOfbyte1);
/* 150 */     SHA256 sHA256 = new SHA256();
/* 151 */     int i = 64 + Math.max(32, paramArrayOfbyte2.length + 4);
/* 152 */     byte[] arrayOfByte3 = new byte[i];
/* 153 */     int j = getIntCount(i);
/* 154 */     byte[] arrayOfByte4 = new byte[j * 4];
/* 155 */     int[] arrayOfInt = new int[j];
/* 156 */     byte[] arrayOfByte5 = new byte[64 + i];
/* 157 */     byte[] arrayOfByte6 = new byte[96];
/* 158 */     for (byte b1 = 1, b2 = 0; b2 < paramInt2; b1++, b2 += 32) {
/* 159 */       for (byte b = 0; b < paramInt1; b++) {
/* 160 */         if (b == 0) {
/* 161 */           System.arraycopy(paramArrayOfbyte2, 0, arrayOfByte3, 0, paramArrayOfbyte2.length);
/* 162 */           writeInt(arrayOfByte3, paramArrayOfbyte2.length, b1);
/* 163 */           i = paramArrayOfbyte2.length + 4;
/*     */         } else {
/* 165 */           System.arraycopy(sHA256.result, 0, arrayOfByte3, 0, 32);
/* 166 */           i = 32;
/*     */         } 
/* 168 */         sHA256.calculateHMAC(arrayOfByte2, arrayOfByte3, i, arrayOfByte5, arrayOfByte6, arrayOfByte4, arrayOfInt);
/* 169 */         for (byte b3 = 0; b3 < 32 && b3 + b2 < paramInt2; b3++) {
/* 170 */           arrayOfByte1[b3 + b2] = (byte)(arrayOfByte1[b3 + b2] ^ sHA256.result[b3]);
/*     */         }
/*     */       } 
/*     */     } 
/* 174 */     Arrays.fill(paramArrayOfbyte1, (byte)0);
/* 175 */     Arrays.fill(arrayOfByte2, (byte)0);
/* 176 */     return arrayOfByte1;
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
/*     */   public static byte[] getHash(byte[] paramArrayOfbyte, boolean paramBoolean) {
/* 188 */     int i = paramArrayOfbyte.length;
/* 189 */     int j = getIntCount(i);
/* 190 */     byte[] arrayOfByte = new byte[j * 4];
/* 191 */     int[] arrayOfInt = new int[j];
/* 192 */     SHA256 sHA256 = new SHA256();
/* 193 */     sHA256.calculateHash(paramArrayOfbyte, i, arrayOfByte, arrayOfInt);
/* 194 */     if (paramBoolean) {
/* 195 */       sHA256.fillWithNull();
/* 196 */       Arrays.fill(arrayOfInt, 0);
/* 197 */       Arrays.fill(arrayOfByte, (byte)0);
/* 198 */       Arrays.fill(paramArrayOfbyte, (byte)0);
/*     */     } 
/* 200 */     return sHA256.result;
/*     */   }
/*     */   
/*     */   private static int getIntCount(int paramInt) {
/* 204 */     return (paramInt + 9 + 63) / 64 * 16;
/*     */   }
/*     */   
/*     */   private void fillWithNull() {
/* 208 */     Arrays.fill(this.w, 0);
/* 209 */     Arrays.fill(this.hh, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   private void calculateHash(byte[] paramArrayOfbyte1, int paramInt, byte[] paramArrayOfbyte2, int[] paramArrayOfint) {
/* 214 */     int[] arrayOfInt1 = this.w;
/* 215 */     int[] arrayOfInt2 = this.hh;
/* 216 */     byte[] arrayOfByte = this.result;
/* 217 */     int i = getIntCount(paramInt);
/* 218 */     System.arraycopy(paramArrayOfbyte1, 0, paramArrayOfbyte2, 0, paramInt);
/* 219 */     paramArrayOfbyte2[paramInt] = Byte.MIN_VALUE;
/* 220 */     Arrays.fill(paramArrayOfbyte2, paramInt + 1, i * 4, (byte)0); byte b; int j;
/* 221 */     for (b = 0, j = 0; j < i; b += true, j++) {
/* 222 */       paramArrayOfint[j] = readInt(paramArrayOfbyte2, b);
/*     */     }
/* 224 */     paramArrayOfint[i - 2] = paramInt >>> 29;
/* 225 */     paramArrayOfint[i - 1] = paramInt << 3;
/* 226 */     System.arraycopy(HH, 0, arrayOfInt2, 0, 8);
/* 227 */     for (b = 0; b < i; b += 16) {
/* 228 */       for (j = 0; j < 16; j++) {
/* 229 */         arrayOfInt1[j] = paramArrayOfint[b + j];
/*     */       }
/* 231 */       for (j = 16; j < 64; j++) {
/* 232 */         int i5 = arrayOfInt1[j - 2];
/* 233 */         int i6 = rot(i5, 17) ^ rot(i5, 19) ^ i5 >>> 10;
/* 234 */         i5 = arrayOfInt1[j - 15];
/* 235 */         int i7 = rot(i5, 7) ^ rot(i5, 18) ^ i5 >>> 3;
/* 236 */         arrayOfInt1[j] = i6 + arrayOfInt1[j - 7] + i7 + arrayOfInt1[j - 16];
/*     */       } 
/*     */       
/* 239 */       j = arrayOfInt2[0]; int k = arrayOfInt2[1], m = arrayOfInt2[2], n = arrayOfInt2[3];
/* 240 */       int i1 = arrayOfInt2[4], i2 = arrayOfInt2[5], i3 = arrayOfInt2[6], i4 = arrayOfInt2[7];
/*     */       
/* 242 */       for (byte b1 = 0; b1 < 64; b1++) {
/* 243 */         int i5 = i4 + (rot(i1, 6) ^ rot(i1, 11) ^ rot(i1, 25)) + (i1 & i2 ^ (i1 ^ 0xFFFFFFFF) & i3) + K[b1] + arrayOfInt1[b1];
/*     */         
/* 245 */         int i6 = (rot(j, 2) ^ rot(j, 13) ^ rot(j, 22)) + (j & k ^ j & m ^ k & m);
/*     */         
/* 247 */         i4 = i3;
/* 248 */         i3 = i2;
/* 249 */         i2 = i1;
/* 250 */         i1 = n + i5;
/* 251 */         n = m;
/* 252 */         m = k;
/* 253 */         k = j;
/* 254 */         j = i5 + i6;
/*     */       } 
/* 256 */       arrayOfInt2[0] = arrayOfInt2[0] + j;
/* 257 */       arrayOfInt2[1] = arrayOfInt2[1] + k;
/* 258 */       arrayOfInt2[2] = arrayOfInt2[2] + m;
/* 259 */       arrayOfInt2[3] = arrayOfInt2[3] + n;
/* 260 */       arrayOfInt2[4] = arrayOfInt2[4] + i1;
/* 261 */       arrayOfInt2[5] = arrayOfInt2[5] + i2;
/* 262 */       arrayOfInt2[6] = arrayOfInt2[6] + i3;
/* 263 */       arrayOfInt2[7] = arrayOfInt2[7] + i4;
/*     */     } 
/* 265 */     for (b = 0; b < 8; b++) {
/* 266 */       writeInt(arrayOfByte, b * 4, arrayOfInt2[b]);
/*     */     }
/*     */   }
/*     */   
/*     */   private static int rot(int paramInt1, int paramInt2) {
/* 271 */     return Integer.rotateRight(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   private static int readInt(byte[] paramArrayOfbyte, int paramInt) {
/* 275 */     return ((paramArrayOfbyte[paramInt] & 0xFF) << 24) + ((paramArrayOfbyte[paramInt + 1] & 0xFF) << 16) + ((paramArrayOfbyte[paramInt + 2] & 0xFF) << 8) + (paramArrayOfbyte[paramInt + 3] & 0xFF);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void writeInt(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 280 */     paramArrayOfbyte[paramInt1] = (byte)(paramInt2 >> 24);
/* 281 */     paramArrayOfbyte[paramInt1 + 1] = (byte)(paramInt2 >> 16);
/* 282 */     paramArrayOfbyte[paramInt1 + 2] = (byte)(paramInt2 >> 8);
/* 283 */     paramArrayOfbyte[paramInt1 + 3] = (byte)paramInt2;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\security\SHA256.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */