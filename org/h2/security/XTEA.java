/*     */ package org.h2.security;
/*     */ 
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ 
/*     */ public class XTEA
/*     */   implements BlockCipher
/*     */ {
/*     */   private static final int DELTA = -1640531527;
/*     */   private int k0;
/*     */   private int k1;
/*     */   private int k2;
/*     */   private int k3;
/*     */   private int k4;
/*     */   private int k5;
/*     */   private int k6;
/*     */   private int k7;
/*     */   private int k8;
/*     */   private int k9;
/*     */   private int k10;
/*     */   private int k11;
/*     */   private int k12;
/*     */   private int k13;
/*     */   private int k14;
/*     */   
/*     */   public void setKey(byte[] paramArrayOfbyte) {
/*  27 */     int[] arrayOfInt1 = new int[4];
/*  28 */     for (byte b1 = 0; b1 < 16;) {
/*  29 */       arrayOfInt1[b1 / 4] = (paramArrayOfbyte[b1++] << 24) + ((paramArrayOfbyte[b1++] & 0xFF) << 16) + ((paramArrayOfbyte[b1++] & 0xFF) << 8) + (paramArrayOfbyte[b1++] & 0xFF);
/*     */     }
/*     */     
/*  32 */     int[] arrayOfInt2 = new int[32]; byte b2; int i;
/*  33 */     for (b2 = 0, i = 0; b2 < 32; ) {
/*  34 */       arrayOfInt2[b2++] = i + arrayOfInt1[i & 0x3];
/*  35 */       i -= 1640531527;
/*  36 */       arrayOfInt2[b2++] = i + arrayOfInt1[i >>> 11 & 0x3];
/*     */     } 
/*  38 */     this.k0 = arrayOfInt2[0]; this.k1 = arrayOfInt2[1]; this.k2 = arrayOfInt2[2]; this.k3 = arrayOfInt2[3];
/*  39 */     this.k4 = arrayOfInt2[4]; this.k5 = arrayOfInt2[5]; this.k6 = arrayOfInt2[6]; this.k7 = arrayOfInt2[7];
/*  40 */     this.k8 = arrayOfInt2[8]; this.k9 = arrayOfInt2[9]; this.k10 = arrayOfInt2[10]; this.k11 = arrayOfInt2[11];
/*  41 */     this.k12 = arrayOfInt2[12]; this.k13 = arrayOfInt2[13]; this.k14 = arrayOfInt2[14]; this.k15 = arrayOfInt2[15];
/*  42 */     this.k16 = arrayOfInt2[16]; this.k17 = arrayOfInt2[17]; this.k18 = arrayOfInt2[18]; this.k19 = arrayOfInt2[19];
/*  43 */     this.k20 = arrayOfInt2[20]; this.k21 = arrayOfInt2[21]; this.k22 = arrayOfInt2[22]; this.k23 = arrayOfInt2[23];
/*  44 */     this.k24 = arrayOfInt2[24]; this.k25 = arrayOfInt2[25]; this.k26 = arrayOfInt2[26]; this.k27 = arrayOfInt2[27];
/*  45 */     this.k28 = arrayOfInt2[28]; this.k29 = arrayOfInt2[29]; this.k30 = arrayOfInt2[30]; this.k31 = arrayOfInt2[31];
/*     */   }
/*     */   private int k15; private int k16; private int k17; private int k18; private int k19; private int k20; private int k21; private int k22; private int k23; private int k24; private int k25; private int k26; private int k27; private int k28; private int k29; private int k30; private int k31;
/*     */   
/*     */   public void encrypt(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  50 */     if (SysProperties.CHECK && 
/*  51 */       paramInt2 % 16 != 0) {
/*  52 */       DbException.throwInternalError("unaligned len " + paramInt2);
/*     */     }
/*     */     
/*  55 */     for (int i = paramInt1; i < paramInt1 + paramInt2; i += 8) {
/*  56 */       encryptBlock(paramArrayOfbyte, paramArrayOfbyte, i);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void decrypt(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  62 */     if (SysProperties.CHECK && 
/*  63 */       paramInt2 % 16 != 0) {
/*  64 */       DbException.throwInternalError("unaligned len " + paramInt2);
/*     */     }
/*     */     
/*  67 */     for (int i = paramInt1; i < paramInt1 + paramInt2; i += 8) {
/*  68 */       decryptBlock(paramArrayOfbyte, paramArrayOfbyte, i);
/*     */     }
/*     */   }
/*     */   
/*     */   private void encryptBlock(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt) {
/*  73 */     int i = paramArrayOfbyte1[paramInt] << 24 | (paramArrayOfbyte1[paramInt + 1] & 0xFF) << 16 | (paramArrayOfbyte1[paramInt + 2] & 0xFF) << 8 | paramArrayOfbyte1[paramInt + 3] & 0xFF;
/*     */     
/*  75 */     int j = paramArrayOfbyte1[paramInt + 4] << 24 | (paramArrayOfbyte1[paramInt + 5] & 0xFF) << 16 | (paramArrayOfbyte1[paramInt + 6] & 0xFF) << 8 | paramArrayOfbyte1[paramInt + 7] & 0xFF;
/*     */     
/*  77 */     i += (j << 4 ^ j >>> 5) + j ^ this.k0;
/*  78 */     j += (i >>> 5 ^ i << 4) + i ^ this.k1;
/*  79 */     i += (j << 4 ^ j >>> 5) + j ^ this.k2;
/*  80 */     j += (i >>> 5 ^ i << 4) + i ^ this.k3;
/*  81 */     i += (j << 4 ^ j >>> 5) + j ^ this.k4;
/*  82 */     j += (i >>> 5 ^ i << 4) + i ^ this.k5;
/*  83 */     i += (j << 4 ^ j >>> 5) + j ^ this.k6;
/*  84 */     j += (i >>> 5 ^ i << 4) + i ^ this.k7;
/*  85 */     i += (j << 4 ^ j >>> 5) + j ^ this.k8;
/*  86 */     j += (i >>> 5 ^ i << 4) + i ^ this.k9;
/*  87 */     i += (j << 4 ^ j >>> 5) + j ^ this.k10;
/*  88 */     j += (i >>> 5 ^ i << 4) + i ^ this.k11;
/*  89 */     i += (j << 4 ^ j >>> 5) + j ^ this.k12;
/*  90 */     j += (i >>> 5 ^ i << 4) + i ^ this.k13;
/*  91 */     i += (j << 4 ^ j >>> 5) + j ^ this.k14;
/*  92 */     j += (i >>> 5 ^ i << 4) + i ^ this.k15;
/*  93 */     i += (j << 4 ^ j >>> 5) + j ^ this.k16;
/*  94 */     j += (i >>> 5 ^ i << 4) + i ^ this.k17;
/*  95 */     i += (j << 4 ^ j >>> 5) + j ^ this.k18;
/*  96 */     j += (i >>> 5 ^ i << 4) + i ^ this.k19;
/*  97 */     i += (j << 4 ^ j >>> 5) + j ^ this.k20;
/*  98 */     j += (i >>> 5 ^ i << 4) + i ^ this.k21;
/*  99 */     i += (j << 4 ^ j >>> 5) + j ^ this.k22;
/* 100 */     j += (i >>> 5 ^ i << 4) + i ^ this.k23;
/* 101 */     i += (j << 4 ^ j >>> 5) + j ^ this.k24;
/* 102 */     j += (i >>> 5 ^ i << 4) + i ^ this.k25;
/* 103 */     i += (j << 4 ^ j >>> 5) + j ^ this.k26;
/* 104 */     j += (i >>> 5 ^ i << 4) + i ^ this.k27;
/* 105 */     i += (j << 4 ^ j >>> 5) + j ^ this.k28;
/* 106 */     j += (i >>> 5 ^ i << 4) + i ^ this.k29;
/* 107 */     i += (j << 4 ^ j >>> 5) + j ^ this.k30;
/* 108 */     j += (i >>> 5 ^ i << 4) + i ^ this.k31;
/* 109 */     paramArrayOfbyte2[paramInt] = (byte)(i >> 24);
/* 110 */     paramArrayOfbyte2[paramInt + 1] = (byte)(i >> 16);
/* 111 */     paramArrayOfbyte2[paramInt + 2] = (byte)(i >> 8);
/* 112 */     paramArrayOfbyte2[paramInt + 3] = (byte)i;
/* 113 */     paramArrayOfbyte2[paramInt + 4] = (byte)(j >> 24);
/* 114 */     paramArrayOfbyte2[paramInt + 5] = (byte)(j >> 16);
/* 115 */     paramArrayOfbyte2[paramInt + 6] = (byte)(j >> 8);
/* 116 */     paramArrayOfbyte2[paramInt + 7] = (byte)j;
/*     */   }
/*     */   
/*     */   private void decryptBlock(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, int paramInt) {
/* 120 */     int i = paramArrayOfbyte1[paramInt] << 24 | (paramArrayOfbyte1[paramInt + 1] & 0xFF) << 16 | (paramArrayOfbyte1[paramInt + 2] & 0xFF) << 8 | paramArrayOfbyte1[paramInt + 3] & 0xFF;
/*     */     
/* 122 */     int j = paramArrayOfbyte1[paramInt + 4] << 24 | (paramArrayOfbyte1[paramInt + 5] & 0xFF) << 16 | (paramArrayOfbyte1[paramInt + 6] & 0xFF) << 8 | paramArrayOfbyte1[paramInt + 7] & 0xFF;
/*     */     
/* 124 */     j -= (i >>> 5 ^ i << 4) + i ^ this.k31;
/* 125 */     i -= (j << 4 ^ j >>> 5) + j ^ this.k30;
/* 126 */     j -= (i >>> 5 ^ i << 4) + i ^ this.k29;
/* 127 */     i -= (j << 4 ^ j >>> 5) + j ^ this.k28;
/* 128 */     j -= (i >>> 5 ^ i << 4) + i ^ this.k27;
/* 129 */     i -= (j << 4 ^ j >>> 5) + j ^ this.k26;
/* 130 */     j -= (i >>> 5 ^ i << 4) + i ^ this.k25;
/* 131 */     i -= (j << 4 ^ j >>> 5) + j ^ this.k24;
/* 132 */     j -= (i >>> 5 ^ i << 4) + i ^ this.k23;
/* 133 */     i -= (j << 4 ^ j >>> 5) + j ^ this.k22;
/* 134 */     j -= (i >>> 5 ^ i << 4) + i ^ this.k21;
/* 135 */     i -= (j << 4 ^ j >>> 5) + j ^ this.k20;
/* 136 */     j -= (i >>> 5 ^ i << 4) + i ^ this.k19;
/* 137 */     i -= (j << 4 ^ j >>> 5) + j ^ this.k18;
/* 138 */     j -= (i >>> 5 ^ i << 4) + i ^ this.k17;
/* 139 */     i -= (j << 4 ^ j >>> 5) + j ^ this.k16;
/* 140 */     j -= (i >>> 5 ^ i << 4) + i ^ this.k15;
/* 141 */     i -= (j << 4 ^ j >>> 5) + j ^ this.k14;
/* 142 */     j -= (i >>> 5 ^ i << 4) + i ^ this.k13;
/* 143 */     i -= (j << 4 ^ j >>> 5) + j ^ this.k12;
/* 144 */     j -= (i >>> 5 ^ i << 4) + i ^ this.k11;
/* 145 */     i -= (j << 4 ^ j >>> 5) + j ^ this.k10;
/* 146 */     j -= (i >>> 5 ^ i << 4) + i ^ this.k9;
/* 147 */     i -= (j << 4 ^ j >>> 5) + j ^ this.k8;
/* 148 */     j -= (i >>> 5 ^ i << 4) + i ^ this.k7;
/* 149 */     i -= (j << 4 ^ j >>> 5) + j ^ this.k6;
/* 150 */     j -= (i >>> 5 ^ i << 4) + i ^ this.k5;
/* 151 */     i -= (j << 4 ^ j >>> 5) + j ^ this.k4;
/* 152 */     j -= (i >>> 5 ^ i << 4) + i ^ this.k3;
/* 153 */     i -= (j << 4 ^ j >>> 5) + j ^ this.k2;
/* 154 */     j -= (i >>> 5 ^ i << 4) + i ^ this.k1;
/* 155 */     i -= (j << 4 ^ j >>> 5) + j ^ this.k0;
/* 156 */     paramArrayOfbyte2[paramInt] = (byte)(i >> 24);
/* 157 */     paramArrayOfbyte2[paramInt + 1] = (byte)(i >> 16);
/* 158 */     paramArrayOfbyte2[paramInt + 2] = (byte)(i >> 8);
/* 159 */     paramArrayOfbyte2[paramInt + 3] = (byte)i;
/* 160 */     paramArrayOfbyte2[paramInt + 4] = (byte)(j >> 24);
/* 161 */     paramArrayOfbyte2[paramInt + 5] = (byte)(j >> 16);
/* 162 */     paramArrayOfbyte2[paramInt + 6] = (byte)(j >> 8);
/* 163 */     paramArrayOfbyte2[paramInt + 7] = (byte)j;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getKeyLength() {
/* 168 */     return 16;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\security\XTEA.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */