/*     */ package org.h2.security;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AES
/*     */   implements BlockCipher
/*     */ {
/*  14 */   private static final int[] RCON = new int[10];
/*  15 */   private static final int[] FS = new int[256];
/*  16 */   private static final int[] FT0 = new int[256];
/*  17 */   private static final int[] FT1 = new int[256];
/*  18 */   private static final int[] FT2 = new int[256];
/*  19 */   private static final int[] FT3 = new int[256];
/*  20 */   private static final int[] RS = new int[256];
/*  21 */   private static final int[] RT0 = new int[256];
/*  22 */   private static final int[] RT1 = new int[256];
/*  23 */   private static final int[] RT2 = new int[256];
/*  24 */   private static final int[] RT3 = new int[256];
/*  25 */   private final int[] encKey = new int[44];
/*  26 */   private final int[] decKey = new int[44];
/*     */   
/*     */   private static int rot8(int paramInt) {
/*  29 */     return paramInt >>> 8 | paramInt << 24;
/*     */   }
/*     */   
/*     */   private static int xtime(int paramInt) {
/*  33 */     return (paramInt << 1 ^ (((paramInt & 0x80) != 0) ? 27 : 0)) & 0xFF;
/*     */   }
/*     */   
/*     */   private static int mul(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt1, int paramInt2) {
/*  37 */     return (paramInt1 != 0 && paramInt2 != 0) ? paramArrayOfint1[(paramArrayOfint2[paramInt1] + paramArrayOfint2[paramInt2]) % 255] : 0;
/*     */   }
/*     */   
/*     */   static {
/*  41 */     int[] arrayOfInt1 = new int[256];
/*  42 */     int[] arrayOfInt2 = new int[256]; byte b; int i;
/*  43 */     for (b = 0, i = 1; b < 'Ā'; b++, i ^= xtime(i)) {
/*  44 */       arrayOfInt1[b] = i;
/*  45 */       arrayOfInt2[i] = b;
/*     */     } 
/*  47 */     for (b = 0, i = 1; b < 10; b++, i = xtime(i)) {
/*  48 */       RCON[b] = i << 24;
/*     */     }
/*  50 */     FS[0] = 99;
/*  51 */     RS[99] = 0;
/*  52 */     for (b = 1; b < 'Ā'; b++) {
/*  53 */       int j = i = arrayOfInt1[255 - arrayOfInt2[b]];
/*  54 */       j = (j << 1 | j >> 7) & 0xFF;
/*  55 */       i ^= j;
/*  56 */       j = (j << 1 | j >> 7) & 0xFF;
/*  57 */       i ^= j;
/*  58 */       j = (j << 1 | j >> 7) & 0xFF;
/*  59 */       i ^= j;
/*  60 */       j = (j << 1 | j >> 7) & 0xFF;
/*  61 */       i ^= j ^ 0x63;
/*  62 */       FS[b] = i & 0xFF;
/*  63 */       RS[i] = b & 0xFF;
/*     */     } 
/*  65 */     for (b = 0; b < 'Ā'; b++) {
/*  66 */       i = FS[b]; int j = xtime(i);
/*  67 */       FT0[b] = i ^ j ^ i << 8 ^ i << 16 ^ j << 24;
/*  68 */       FT1[b] = rot8(FT0[b]);
/*  69 */       FT2[b] = rot8(FT1[b]);
/*  70 */       FT3[b] = rot8(FT2[b]);
/*  71 */       j = RS[b];
/*  72 */       RT0[b] = mul(arrayOfInt1, arrayOfInt2, 11, j) ^ mul(arrayOfInt1, arrayOfInt2, 13, j) << 8 ^ mul(arrayOfInt1, arrayOfInt2, 9, j) << 16 ^ mul(arrayOfInt1, arrayOfInt2, 14, j) << 24;
/*     */       
/*  74 */       RT1[b] = rot8(RT0[b]);
/*  75 */       RT2[b] = rot8(RT1[b]);
/*  76 */       RT3[b] = rot8(RT2[b]);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static int getDec(int paramInt) {
/*  81 */     return RT0[FS[paramInt >> 24 & 0xFF]] ^ RT1[FS[paramInt >> 16 & 0xFF]] ^ RT2[FS[paramInt >> 8 & 0xFF]] ^ RT3[FS[paramInt & 0xFF]];
/*     */   }
/*     */ 
/*     */   
/*     */   public void setKey(byte[] paramArrayOfbyte) {
/*     */     byte b1, b2;
/*  87 */     for (b1 = 0, b2 = 0; b1 < 4; b1++) {
/*  88 */       this.decKey[b1] = (paramArrayOfbyte[b2++] & 0xFF) << 24 | (paramArrayOfbyte[b2++] & 0xFF) << 16 | (paramArrayOfbyte[b2++] & 0xFF) << 8 | paramArrayOfbyte[b2++] & 0xFF; this.encKey[b1] = (paramArrayOfbyte[b2++] & 0xFF) << 24 | (paramArrayOfbyte[b2++] & 0xFF) << 16 | (paramArrayOfbyte[b2++] & 0xFF) << 8 | paramArrayOfbyte[b2++] & 0xFF;
/*     */     } 
/*     */ 
/*     */     
/*  92 */     b1 = 0;
/*  93 */     for (b2 = 0; b2 < 10; b2++, b1 += 4) {
/*  94 */       this.encKey[b1 + 4] = this.encKey[b1] ^ RCON[b2] ^ FS[this.encKey[b1 + 3] >> 16 & 0xFF] << 24 ^ FS[this.encKey[b1 + 3] >> 8 & 0xFF] << 16 ^ FS[this.encKey[b1 + 3] & 0xFF] << 8 ^ FS[this.encKey[b1 + 3] >> 24 & 0xFF];
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  99 */       this.encKey[b1 + 5] = this.encKey[b1 + 1] ^ this.encKey[b1 + 4];
/* 100 */       this.encKey[b1 + 6] = this.encKey[b1 + 2] ^ this.encKey[b1 + 5];
/* 101 */       this.encKey[b1 + 7] = this.encKey[b1 + 3] ^ this.encKey[b1 + 6];
/*     */     } 
/* 103 */     b2 = 0;
/* 104 */     this.decKey[b2++] = this.encKey[b1++];
/* 105 */     this.decKey[b2++] = this.encKey[b1++];
/* 106 */     this.decKey[b2++] = this.encKey[b1++];
/* 107 */     this.decKey[b2++] = this.encKey[b1++];
/* 108 */     for (byte b3 = 1; b3 < 10; b3++) {
/* 109 */       b1 -= 8;
/* 110 */       this.decKey[b2++] = getDec(this.encKey[b1++]);
/* 111 */       this.decKey[b2++] = getDec(this.encKey[b1++]);
/* 112 */       this.decKey[b2++] = getDec(this.encKey[b1++]);
/* 113 */       this.decKey[b2++] = getDec(this.encKey[b1++]);
/*     */     } 
/* 115 */     b1 -= 8;
/* 116 */     this.decKey[b2++] = this.encKey[b1++];
/* 117 */     this.decKey[b2++] = this.encKey[b1++];
/* 118 */     this.decKey[b2++] = this.encKey[b1++];
/* 119 */     this.decKey[b2] = this.encKey[b1];
/*     */   }
/*     */ 
/*     */   
/*     */   public void encrypt(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 124 */     for (int i = paramInt1; i < paramInt1 + paramInt2; i += 16) {
/* 125 */       encryptBlock(paramArrayOfbyte, paramArrayOfbyte, i);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void decrypt(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 131 */     for (int i = paramInt1; i < paramInt1 + paramInt2; i += 16) {
/* 132 */       decryptBlock(paramArrayOfbyte, paramArrayOfbyte, i);
/*     */     }
/*     */   }
/*     */   
/*     */   private void encryptBlock(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt) {
/* 137 */     int[] arrayOfInt = this.encKey;
/* 138 */     int i = (paramArrayOfbyte1[paramInt] << 24 | (paramArrayOfbyte1[paramInt + 1] & 0xFF) << 16 | (paramArrayOfbyte1[paramInt + 2] & 0xFF) << 8 | paramArrayOfbyte1[paramInt + 3] & 0xFF) ^ arrayOfInt[0];
/*     */     
/* 140 */     int j = (paramArrayOfbyte1[paramInt + 4] << 24 | (paramArrayOfbyte1[paramInt + 5] & 0xFF) << 16 | (paramArrayOfbyte1[paramInt + 6] & 0xFF) << 8 | paramArrayOfbyte1[paramInt + 7] & 0xFF) ^ arrayOfInt[1];
/*     */     
/* 142 */     int k = (paramArrayOfbyte1[paramInt + 8] << 24 | (paramArrayOfbyte1[paramInt + 9] & 0xFF) << 16 | (paramArrayOfbyte1[paramInt + 10] & 0xFF) << 8 | paramArrayOfbyte1[paramInt + 11] & 0xFF) ^ arrayOfInt[2];
/*     */     
/* 144 */     int m = (paramArrayOfbyte1[paramInt + 12] << 24 | (paramArrayOfbyte1[paramInt + 13] & 0xFF) << 16 | (paramArrayOfbyte1[paramInt + 14] & 0xFF) << 8 | paramArrayOfbyte1[paramInt + 15] & 0xFF) ^ arrayOfInt[3];
/*     */     
/* 146 */     int n = FT0[i >> 24 & 0xFF] ^ FT1[j >> 16 & 0xFF] ^ FT2[k >> 8 & 0xFF] ^ FT3[m & 0xFF] ^ arrayOfInt[4];
/*     */     
/* 148 */     int i1 = FT0[j >> 24 & 0xFF] ^ FT1[k >> 16 & 0xFF] ^ FT2[m >> 8 & 0xFF] ^ FT3[i & 0xFF] ^ arrayOfInt[5];
/*     */     
/* 150 */     int i2 = FT0[k >> 24 & 0xFF] ^ FT1[m >> 16 & 0xFF] ^ FT2[i >> 8 & 0xFF] ^ FT3[j & 0xFF] ^ arrayOfInt[6];
/*     */     
/* 152 */     int i3 = FT0[m >> 24 & 0xFF] ^ FT1[i >> 16 & 0xFF] ^ FT2[j >> 8 & 0xFF] ^ FT3[k & 0xFF] ^ arrayOfInt[7];
/*     */     
/* 154 */     i = FT0[n >> 24 & 0xFF] ^ FT1[i1 >> 16 & 0xFF] ^ FT2[i2 >> 8 & 0xFF] ^ FT3[i3 & 0xFF] ^ arrayOfInt[8];
/*     */     
/* 156 */     j = FT0[i1 >> 24 & 0xFF] ^ FT1[i2 >> 16 & 0xFF] ^ FT2[i3 >> 8 & 0xFF] ^ FT3[n & 0xFF] ^ arrayOfInt[9];
/*     */     
/* 158 */     k = FT0[i2 >> 24 & 0xFF] ^ FT1[i3 >> 16 & 0xFF] ^ FT2[n >> 8 & 0xFF] ^ FT3[i1 & 0xFF] ^ arrayOfInt[10];
/*     */     
/* 160 */     m = FT0[i3 >> 24 & 0xFF] ^ FT1[n >> 16 & 0xFF] ^ FT2[i1 >> 8 & 0xFF] ^ FT3[i2 & 0xFF] ^ arrayOfInt[11];
/*     */     
/* 162 */     n = FT0[i >> 24 & 0xFF] ^ FT1[j >> 16 & 0xFF] ^ FT2[k >> 8 & 0xFF] ^ FT3[m & 0xFF] ^ arrayOfInt[12];
/*     */     
/* 164 */     i1 = FT0[j >> 24 & 0xFF] ^ FT1[k >> 16 & 0xFF] ^ FT2[m >> 8 & 0xFF] ^ FT3[i & 0xFF] ^ arrayOfInt[13];
/*     */     
/* 166 */     i2 = FT0[k >> 24 & 0xFF] ^ FT1[m >> 16 & 0xFF] ^ FT2[i >> 8 & 0xFF] ^ FT3[j & 0xFF] ^ arrayOfInt[14];
/*     */     
/* 168 */     i3 = FT0[m >> 24 & 0xFF] ^ FT1[i >> 16 & 0xFF] ^ FT2[j >> 8 & 0xFF] ^ FT3[k & 0xFF] ^ arrayOfInt[15];
/*     */     
/* 170 */     i = FT0[n >> 24 & 0xFF] ^ FT1[i1 >> 16 & 0xFF] ^ FT2[i2 >> 8 & 0xFF] ^ FT3[i3 & 0xFF] ^ arrayOfInt[16];
/*     */     
/* 172 */     j = FT0[i1 >> 24 & 0xFF] ^ FT1[i2 >> 16 & 0xFF] ^ FT2[i3 >> 8 & 0xFF] ^ FT3[n & 0xFF] ^ arrayOfInt[17];
/*     */     
/* 174 */     k = FT0[i2 >> 24 & 0xFF] ^ FT1[i3 >> 16 & 0xFF] ^ FT2[n >> 8 & 0xFF] ^ FT3[i1 & 0xFF] ^ arrayOfInt[18];
/*     */     
/* 176 */     m = FT0[i3 >> 24 & 0xFF] ^ FT1[n >> 16 & 0xFF] ^ FT2[i1 >> 8 & 0xFF] ^ FT3[i2 & 0xFF] ^ arrayOfInt[19];
/*     */     
/* 178 */     n = FT0[i >> 24 & 0xFF] ^ FT1[j >> 16 & 0xFF] ^ FT2[k >> 8 & 0xFF] ^ FT3[m & 0xFF] ^ arrayOfInt[20];
/*     */     
/* 180 */     i1 = FT0[j >> 24 & 0xFF] ^ FT1[k >> 16 & 0xFF] ^ FT2[m >> 8 & 0xFF] ^ FT3[i & 0xFF] ^ arrayOfInt[21];
/*     */     
/* 182 */     i2 = FT0[k >> 24 & 0xFF] ^ FT1[m >> 16 & 0xFF] ^ FT2[i >> 8 & 0xFF] ^ FT3[j & 0xFF] ^ arrayOfInt[22];
/*     */     
/* 184 */     i3 = FT0[m >> 24 & 0xFF] ^ FT1[i >> 16 & 0xFF] ^ FT2[j >> 8 & 0xFF] ^ FT3[k & 0xFF] ^ arrayOfInt[23];
/*     */     
/* 186 */     i = FT0[n >> 24 & 0xFF] ^ FT1[i1 >> 16 & 0xFF] ^ FT2[i2 >> 8 & 0xFF] ^ FT3[i3 & 0xFF] ^ arrayOfInt[24];
/*     */     
/* 188 */     j = FT0[i1 >> 24 & 0xFF] ^ FT1[i2 >> 16 & 0xFF] ^ FT2[i3 >> 8 & 0xFF] ^ FT3[n & 0xFF] ^ arrayOfInt[25];
/*     */     
/* 190 */     k = FT0[i2 >> 24 & 0xFF] ^ FT1[i3 >> 16 & 0xFF] ^ FT2[n >> 8 & 0xFF] ^ FT3[i1 & 0xFF] ^ arrayOfInt[26];
/*     */     
/* 192 */     m = FT0[i3 >> 24 & 0xFF] ^ FT1[n >> 16 & 0xFF] ^ FT2[i1 >> 8 & 0xFF] ^ FT3[i2 & 0xFF] ^ arrayOfInt[27];
/*     */     
/* 194 */     n = FT0[i >> 24 & 0xFF] ^ FT1[j >> 16 & 0xFF] ^ FT2[k >> 8 & 0xFF] ^ FT3[m & 0xFF] ^ arrayOfInt[28];
/*     */     
/* 196 */     i1 = FT0[j >> 24 & 0xFF] ^ FT1[k >> 16 & 0xFF] ^ FT2[m >> 8 & 0xFF] ^ FT3[i & 0xFF] ^ arrayOfInt[29];
/*     */     
/* 198 */     i2 = FT0[k >> 24 & 0xFF] ^ FT1[m >> 16 & 0xFF] ^ FT2[i >> 8 & 0xFF] ^ FT3[j & 0xFF] ^ arrayOfInt[30];
/*     */     
/* 200 */     i3 = FT0[m >> 24 & 0xFF] ^ FT1[i >> 16 & 0xFF] ^ FT2[j >> 8 & 0xFF] ^ FT3[k & 0xFF] ^ arrayOfInt[31];
/*     */     
/* 202 */     i = FT0[n >> 24 & 0xFF] ^ FT1[i1 >> 16 & 0xFF] ^ FT2[i2 >> 8 & 0xFF] ^ FT3[i3 & 0xFF] ^ arrayOfInt[32];
/*     */     
/* 204 */     j = FT0[i1 >> 24 & 0xFF] ^ FT1[i2 >> 16 & 0xFF] ^ FT2[i3 >> 8 & 0xFF] ^ FT3[n & 0xFF] ^ arrayOfInt[33];
/*     */     
/* 206 */     k = FT0[i2 >> 24 & 0xFF] ^ FT1[i3 >> 16 & 0xFF] ^ FT2[n >> 8 & 0xFF] ^ FT3[i1 & 0xFF] ^ arrayOfInt[34];
/*     */     
/* 208 */     m = FT0[i3 >> 24 & 0xFF] ^ FT1[n >> 16 & 0xFF] ^ FT2[i1 >> 8 & 0xFF] ^ FT3[i2 & 0xFF] ^ arrayOfInt[35];
/*     */     
/* 210 */     n = FT0[i >> 24 & 0xFF] ^ FT1[j >> 16 & 0xFF] ^ FT2[k >> 8 & 0xFF] ^ FT3[m & 0xFF] ^ arrayOfInt[36];
/*     */     
/* 212 */     i1 = FT0[j >> 24 & 0xFF] ^ FT1[k >> 16 & 0xFF] ^ FT2[m >> 8 & 0xFF] ^ FT3[i & 0xFF] ^ arrayOfInt[37];
/*     */     
/* 214 */     i2 = FT0[k >> 24 & 0xFF] ^ FT1[m >> 16 & 0xFF] ^ FT2[i >> 8 & 0xFF] ^ FT3[j & 0xFF] ^ arrayOfInt[38];
/*     */     
/* 216 */     i3 = FT0[m >> 24 & 0xFF] ^ FT1[i >> 16 & 0xFF] ^ FT2[j >> 8 & 0xFF] ^ FT3[k & 0xFF] ^ arrayOfInt[39];
/*     */     
/* 218 */     i = (FS[n >> 24 & 0xFF] << 24 | FS[i1 >> 16 & 0xFF] << 16 | FS[i2 >> 8 & 0xFF] << 8 | FS[i3 & 0xFF]) ^ arrayOfInt[40];
/*     */     
/* 220 */     j = (FS[i1 >> 24 & 0xFF] << 24 | FS[i2 >> 16 & 0xFF] << 16 | FS[i3 >> 8 & 0xFF] << 8 | FS[n & 0xFF]) ^ arrayOfInt[41];
/*     */     
/* 222 */     k = (FS[i2 >> 24 & 0xFF] << 24 | FS[i3 >> 16 & 0xFF] << 16 | FS[n >> 8 & 0xFF] << 8 | FS[i1 & 0xFF]) ^ arrayOfInt[42];
/*     */     
/* 224 */     m = (FS[i3 >> 24 & 0xFF] << 24 | FS[n >> 16 & 0xFF] << 16 | FS[i1 >> 8 & 0xFF] << 8 | FS[i2 & 0xFF]) ^ arrayOfInt[43];
/*     */     
/* 226 */     paramArrayOfbyte2[paramInt] = (byte)(i >> 24); paramArrayOfbyte2[paramInt + 1] = (byte)(i >> 16);
/* 227 */     paramArrayOfbyte2[paramInt + 2] = (byte)(i >> 8); paramArrayOfbyte2[paramInt + 3] = (byte)i;
/* 228 */     paramArrayOfbyte2[paramInt + 4] = (byte)(j >> 24); paramArrayOfbyte2[paramInt + 5] = (byte)(j >> 16);
/* 229 */     paramArrayOfbyte2[paramInt + 6] = (byte)(j >> 8); paramArrayOfbyte2[paramInt + 7] = (byte)j;
/* 230 */     paramArrayOfbyte2[paramInt + 8] = (byte)(k >> 24); paramArrayOfbyte2[paramInt + 9] = (byte)(k >> 16);
/* 231 */     paramArrayOfbyte2[paramInt + 10] = (byte)(k >> 8); paramArrayOfbyte2[paramInt + 11] = (byte)k;
/* 232 */     paramArrayOfbyte2[paramInt + 12] = (byte)(m >> 24); paramArrayOfbyte2[paramInt + 13] = (byte)(m >> 16);
/* 233 */     paramArrayOfbyte2[paramInt + 14] = (byte)(m >> 8); paramArrayOfbyte2[paramInt + 15] = (byte)m;
/*     */   }
/*     */   
/*     */   private void decryptBlock(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt) {
/* 237 */     int[] arrayOfInt = this.decKey;
/* 238 */     int i = (paramArrayOfbyte1[paramInt] << 24 | (paramArrayOfbyte1[paramInt + 1] & 0xFF) << 16 | (paramArrayOfbyte1[paramInt + 2] & 0xFF) << 8 | paramArrayOfbyte1[paramInt + 3] & 0xFF) ^ arrayOfInt[0];
/*     */     
/* 240 */     int j = (paramArrayOfbyte1[paramInt + 4] << 24 | (paramArrayOfbyte1[paramInt + 5] & 0xFF) << 16 | (paramArrayOfbyte1[paramInt + 6] & 0xFF) << 8 | paramArrayOfbyte1[paramInt + 7] & 0xFF) ^ arrayOfInt[1];
/*     */     
/* 242 */     int k = (paramArrayOfbyte1[paramInt + 8] << 24 | (paramArrayOfbyte1[paramInt + 9] & 0xFF) << 16 | (paramArrayOfbyte1[paramInt + 10] & 0xFF) << 8 | paramArrayOfbyte1[paramInt + 11] & 0xFF) ^ arrayOfInt[2];
/*     */     
/* 244 */     int m = (paramArrayOfbyte1[paramInt + 12] << 24 | (paramArrayOfbyte1[paramInt + 13] & 0xFF) << 16 | (paramArrayOfbyte1[paramInt + 14] & 0xFF) << 8 | paramArrayOfbyte1[paramInt + 15] & 0xFF) ^ arrayOfInt[3];
/*     */     
/* 246 */     int n = RT0[i >> 24 & 0xFF] ^ RT1[m >> 16 & 0xFF] ^ RT2[k >> 8 & 0xFF] ^ RT3[j & 0xFF] ^ arrayOfInt[4];
/*     */     
/* 248 */     int i1 = RT0[j >> 24 & 0xFF] ^ RT1[i >> 16 & 0xFF] ^ RT2[m >> 8 & 0xFF] ^ RT3[k & 0xFF] ^ arrayOfInt[5];
/*     */     
/* 250 */     int i2 = RT0[k >> 24 & 0xFF] ^ RT1[j >> 16 & 0xFF] ^ RT2[i >> 8 & 0xFF] ^ RT3[m & 0xFF] ^ arrayOfInt[6];
/*     */     
/* 252 */     int i3 = RT0[m >> 24 & 0xFF] ^ RT1[k >> 16 & 0xFF] ^ RT2[j >> 8 & 0xFF] ^ RT3[i & 0xFF] ^ arrayOfInt[7];
/*     */     
/* 254 */     i = RT0[n >> 24 & 0xFF] ^ RT1[i3 >> 16 & 0xFF] ^ RT2[i2 >> 8 & 0xFF] ^ RT3[i1 & 0xFF] ^ arrayOfInt[8];
/*     */     
/* 256 */     j = RT0[i1 >> 24 & 0xFF] ^ RT1[n >> 16 & 0xFF] ^ RT2[i3 >> 8 & 0xFF] ^ RT3[i2 & 0xFF] ^ arrayOfInt[9];
/*     */     
/* 258 */     k = RT0[i2 >> 24 & 0xFF] ^ RT1[i1 >> 16 & 0xFF] ^ RT2[n >> 8 & 0xFF] ^ RT3[i3 & 0xFF] ^ arrayOfInt[10];
/*     */     
/* 260 */     m = RT0[i3 >> 24 & 0xFF] ^ RT1[i2 >> 16 & 0xFF] ^ RT2[i1 >> 8 & 0xFF] ^ RT3[n & 0xFF] ^ arrayOfInt[11];
/*     */     
/* 262 */     n = RT0[i >> 24 & 0xFF] ^ RT1[m >> 16 & 0xFF] ^ RT2[k >> 8 & 0xFF] ^ RT3[j & 0xFF] ^ arrayOfInt[12];
/*     */     
/* 264 */     i1 = RT0[j >> 24 & 0xFF] ^ RT1[i >> 16 & 0xFF] ^ RT2[m >> 8 & 0xFF] ^ RT3[k & 0xFF] ^ arrayOfInt[13];
/*     */     
/* 266 */     i2 = RT0[k >> 24 & 0xFF] ^ RT1[j >> 16 & 0xFF] ^ RT2[i >> 8 & 0xFF] ^ RT3[m & 0xFF] ^ arrayOfInt[14];
/*     */     
/* 268 */     i3 = RT0[m >> 24 & 0xFF] ^ RT1[k >> 16 & 0xFF] ^ RT2[j >> 8 & 0xFF] ^ RT3[i & 0xFF] ^ arrayOfInt[15];
/*     */     
/* 270 */     i = RT0[n >> 24 & 0xFF] ^ RT1[i3 >> 16 & 0xFF] ^ RT2[i2 >> 8 & 0xFF] ^ RT3[i1 & 0xFF] ^ arrayOfInt[16];
/*     */     
/* 272 */     j = RT0[i1 >> 24 & 0xFF] ^ RT1[n >> 16 & 0xFF] ^ RT2[i3 >> 8 & 0xFF] ^ RT3[i2 & 0xFF] ^ arrayOfInt[17];
/*     */     
/* 274 */     k = RT0[i2 >> 24 & 0xFF] ^ RT1[i1 >> 16 & 0xFF] ^ RT2[n >> 8 & 0xFF] ^ RT3[i3 & 0xFF] ^ arrayOfInt[18];
/*     */     
/* 276 */     m = RT0[i3 >> 24 & 0xFF] ^ RT1[i2 >> 16 & 0xFF] ^ RT2[i1 >> 8 & 0xFF] ^ RT3[n & 0xFF] ^ arrayOfInt[19];
/*     */     
/* 278 */     n = RT0[i >> 24 & 0xFF] ^ RT1[m >> 16 & 0xFF] ^ RT2[k >> 8 & 0xFF] ^ RT3[j & 0xFF] ^ arrayOfInt[20];
/*     */     
/* 280 */     i1 = RT0[j >> 24 & 0xFF] ^ RT1[i >> 16 & 0xFF] ^ RT2[m >> 8 & 0xFF] ^ RT3[k & 0xFF] ^ arrayOfInt[21];
/*     */     
/* 282 */     i2 = RT0[k >> 24 & 0xFF] ^ RT1[j >> 16 & 0xFF] ^ RT2[i >> 8 & 0xFF] ^ RT3[m & 0xFF] ^ arrayOfInt[22];
/*     */     
/* 284 */     i3 = RT0[m >> 24 & 0xFF] ^ RT1[k >> 16 & 0xFF] ^ RT2[j >> 8 & 0xFF] ^ RT3[i & 0xFF] ^ arrayOfInt[23];
/*     */     
/* 286 */     i = RT0[n >> 24 & 0xFF] ^ RT1[i3 >> 16 & 0xFF] ^ RT2[i2 >> 8 & 0xFF] ^ RT3[i1 & 0xFF] ^ arrayOfInt[24];
/*     */     
/* 288 */     j = RT0[i1 >> 24 & 0xFF] ^ RT1[n >> 16 & 0xFF] ^ RT2[i3 >> 8 & 0xFF] ^ RT3[i2 & 0xFF] ^ arrayOfInt[25];
/*     */     
/* 290 */     k = RT0[i2 >> 24 & 0xFF] ^ RT1[i1 >> 16 & 0xFF] ^ RT2[n >> 8 & 0xFF] ^ RT3[i3 & 0xFF] ^ arrayOfInt[26];
/*     */     
/* 292 */     m = RT0[i3 >> 24 & 0xFF] ^ RT1[i2 >> 16 & 0xFF] ^ RT2[i1 >> 8 & 0xFF] ^ RT3[n & 0xFF] ^ arrayOfInt[27];
/*     */     
/* 294 */     n = RT0[i >> 24 & 0xFF] ^ RT1[m >> 16 & 0xFF] ^ RT2[k >> 8 & 0xFF] ^ RT3[j & 0xFF] ^ arrayOfInt[28];
/*     */     
/* 296 */     i1 = RT0[j >> 24 & 0xFF] ^ RT1[i >> 16 & 0xFF] ^ RT2[m >> 8 & 0xFF] ^ RT3[k & 0xFF] ^ arrayOfInt[29];
/*     */     
/* 298 */     i2 = RT0[k >> 24 & 0xFF] ^ RT1[j >> 16 & 0xFF] ^ RT2[i >> 8 & 0xFF] ^ RT3[m & 0xFF] ^ arrayOfInt[30];
/*     */     
/* 300 */     i3 = RT0[m >> 24 & 0xFF] ^ RT1[k >> 16 & 0xFF] ^ RT2[j >> 8 & 0xFF] ^ RT3[i & 0xFF] ^ arrayOfInt[31];
/*     */     
/* 302 */     i = RT0[n >> 24 & 0xFF] ^ RT1[i3 >> 16 & 0xFF] ^ RT2[i2 >> 8 & 0xFF] ^ RT3[i1 & 0xFF] ^ arrayOfInt[32];
/*     */     
/* 304 */     j = RT0[i1 >> 24 & 0xFF] ^ RT1[n >> 16 & 0xFF] ^ RT2[i3 >> 8 & 0xFF] ^ RT3[i2 & 0xFF] ^ arrayOfInt[33];
/*     */     
/* 306 */     k = RT0[i2 >> 24 & 0xFF] ^ RT1[i1 >> 16 & 0xFF] ^ RT2[n >> 8 & 0xFF] ^ RT3[i3 & 0xFF] ^ arrayOfInt[34];
/*     */     
/* 308 */     m = RT0[i3 >> 24 & 0xFF] ^ RT1[i2 >> 16 & 0xFF] ^ RT2[i1 >> 8 & 0xFF] ^ RT3[n & 0xFF] ^ arrayOfInt[35];
/*     */     
/* 310 */     n = RT0[i >> 24 & 0xFF] ^ RT1[m >> 16 & 0xFF] ^ RT2[k >> 8 & 0xFF] ^ RT3[j & 0xFF] ^ arrayOfInt[36];
/*     */     
/* 312 */     i1 = RT0[j >> 24 & 0xFF] ^ RT1[i >> 16 & 0xFF] ^ RT2[m >> 8 & 0xFF] ^ RT3[k & 0xFF] ^ arrayOfInt[37];
/*     */     
/* 314 */     i2 = RT0[k >> 24 & 0xFF] ^ RT1[j >> 16 & 0xFF] ^ RT2[i >> 8 & 0xFF] ^ RT3[m & 0xFF] ^ arrayOfInt[38];
/*     */     
/* 316 */     i3 = RT0[m >> 24 & 0xFF] ^ RT1[k >> 16 & 0xFF] ^ RT2[j >> 8 & 0xFF] ^ RT3[i & 0xFF] ^ arrayOfInt[39];
/*     */     
/* 318 */     i = (RS[n >> 24 & 0xFF] << 24 | RS[i3 >> 16 & 0xFF] << 16 | RS[i2 >> 8 & 0xFF] << 8 | RS[i1 & 0xFF]) ^ arrayOfInt[40];
/*     */     
/* 320 */     j = (RS[i1 >> 24 & 0xFF] << 24 | RS[n >> 16 & 0xFF] << 16 | RS[i3 >> 8 & 0xFF] << 8 | RS[i2 & 0xFF]) ^ arrayOfInt[41];
/*     */     
/* 322 */     k = (RS[i2 >> 24 & 0xFF] << 24 | RS[i1 >> 16 & 0xFF] << 16 | RS[n >> 8 & 0xFF] << 8 | RS[i3 & 0xFF]) ^ arrayOfInt[42];
/*     */     
/* 324 */     m = (RS[i3 >> 24 & 0xFF] << 24 | RS[i2 >> 16 & 0xFF] << 16 | RS[i1 >> 8 & 0xFF] << 8 | RS[n & 0xFF]) ^ arrayOfInt[43];
/*     */     
/* 326 */     paramArrayOfbyte2[paramInt] = (byte)(i >> 24);
/* 327 */     paramArrayOfbyte2[paramInt + 1] = (byte)(i >> 16);
/* 328 */     paramArrayOfbyte2[paramInt + 2] = (byte)(i >> 8); paramArrayOfbyte2[paramInt + 3] = (byte)i;
/* 329 */     paramArrayOfbyte2[paramInt + 4] = (byte)(j >> 24); paramArrayOfbyte2[paramInt + 5] = (byte)(j >> 16);
/* 330 */     paramArrayOfbyte2[paramInt + 6] = (byte)(j >> 8); paramArrayOfbyte2[paramInt + 7] = (byte)j;
/* 331 */     paramArrayOfbyte2[paramInt + 8] = (byte)(k >> 24); paramArrayOfbyte2[paramInt + 9] = (byte)(k >> 16);
/* 332 */     paramArrayOfbyte2[paramInt + 10] = (byte)(k >> 8); paramArrayOfbyte2[paramInt + 11] = (byte)k;
/* 333 */     paramArrayOfbyte2[paramInt + 12] = (byte)(m >> 24); paramArrayOfbyte2[paramInt + 13] = (byte)(m >> 16);
/* 334 */     paramArrayOfbyte2[paramInt + 14] = (byte)(m >> 8); paramArrayOfbyte2[paramInt + 15] = (byte)m;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getKeyLength() {
/* 339 */     return 16;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\security\AES.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */