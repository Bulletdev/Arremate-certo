/*     */ package com.google.a.h;
/*     */ 
/*     */ import com.google.a.a.d;
/*     */ import com.google.a.b.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class k
/*     */   extends e
/*     */ {
/*  42 */   static final o b = new k();
/*     */   
/*     */   private static final long aQ = -4348849565147123417L;
/*     */   
/*     */   private static final long aR = -5435081209227447693L;
/*     */   
/*     */   private static final long aS = -7286425919675154353L;
/*     */   
/*     */   public n a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  51 */     D.a(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
/*  52 */     return n.b(a(paramArrayOfbyte, paramInt1, paramInt2));
/*     */   }
/*     */ 
/*     */   
/*     */   public int av() {
/*  57 */     return 64;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  62 */     return "Hashing.farmHashFingerprint64()";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @d
/*     */   static long a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  69 */     if (paramInt2 <= 32) {
/*  70 */       if (paramInt2 <= 16) {
/*  71 */         return b(paramArrayOfbyte, paramInt1, paramInt2);
/*     */       }
/*  73 */       return c(paramArrayOfbyte, paramInt1, paramInt2);
/*     */     } 
/*  75 */     if (paramInt2 <= 64) {
/*  76 */       return d(paramArrayOfbyte, paramInt1, paramInt2);
/*     */     }
/*  78 */     return e(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   private static long d(long paramLong) {
/*  83 */     return paramLong ^ paramLong >>> 47L;
/*     */   }
/*     */   
/*     */   private static long a(long paramLong1, long paramLong2, long paramLong3) {
/*  87 */     long l1 = (paramLong1 ^ paramLong2) * paramLong3;
/*  88 */     l1 ^= l1 >>> 47L;
/*  89 */     long l2 = (paramLong2 ^ l1) * paramLong3;
/*  90 */     l2 ^= l2 >>> 47L;
/*  91 */     l2 *= paramLong3;
/*  92 */     return l2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(byte[] paramArrayOfbyte, int paramInt, long paramLong1, long paramLong2, long[] paramArrayOflong) {
/* 102 */     long l1 = v.a(paramArrayOfbyte, paramInt);
/* 103 */     long l2 = v.a(paramArrayOfbyte, paramInt + 8);
/* 104 */     long l3 = v.a(paramArrayOfbyte, paramInt + 16);
/* 105 */     long l4 = v.a(paramArrayOfbyte, paramInt + 24);
/*     */     
/* 107 */     paramLong1 += l1;
/* 108 */     paramLong2 = Long.rotateRight(paramLong2 + paramLong1 + l4, 21);
/* 109 */     long l5 = paramLong1;
/* 110 */     paramLong1 += l2;
/* 111 */     paramLong1 += l3;
/* 112 */     paramLong2 += Long.rotateRight(paramLong1, 44);
/* 113 */     paramArrayOflong[0] = paramLong1 + l4;
/* 114 */     paramArrayOflong[1] = paramLong2 + l5;
/*     */   }
/*     */   
/*     */   private static long b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 118 */     if (paramInt2 >= 8) {
/* 119 */       long l1 = -7286425919675154353L + (paramInt2 * 2);
/* 120 */       long l2 = v.a(paramArrayOfbyte, paramInt1) + -7286425919675154353L;
/* 121 */       long l3 = v.a(paramArrayOfbyte, paramInt1 + paramInt2 - 8);
/* 122 */       long l4 = Long.rotateRight(l3, 37) * l1 + l2;
/* 123 */       long l5 = (Long.rotateRight(l2, 25) + l3) * l1;
/* 124 */       return a(l4, l5, l1);
/*     */     } 
/* 126 */     if (paramInt2 >= 4) {
/* 127 */       long l1 = -7286425919675154353L + (paramInt2 * 2);
/* 128 */       long l2 = v.a(paramArrayOfbyte, paramInt1) & 0xFFFFFFFFL;
/* 129 */       return a(paramInt2 + (l2 << 3L), v.a(paramArrayOfbyte, paramInt1 + paramInt2 - 4) & 0xFFFFFFFFL, l1);
/*     */     } 
/* 131 */     if (paramInt2 > 0) {
/* 132 */       byte b1 = paramArrayOfbyte[paramInt1];
/* 133 */       byte b2 = paramArrayOfbyte[paramInt1 + (paramInt2 >> 1)];
/* 134 */       byte b3 = paramArrayOfbyte[paramInt1 + paramInt2 - 1];
/* 135 */       int i = (b1 & 0xFF) + ((b2 & 0xFF) << 8);
/* 136 */       int j = paramInt2 + ((b3 & 0xFF) << 2);
/* 137 */       return d(i * -7286425919675154353L ^ j * -4348849565147123417L) * -7286425919675154353L;
/*     */     } 
/* 139 */     return -7286425919675154353L;
/*     */   }
/*     */   
/*     */   private static long c(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 143 */     long l1 = -7286425919675154353L + (paramInt2 * 2);
/* 144 */     long l2 = v.a(paramArrayOfbyte, paramInt1) * -5435081209227447693L;
/* 145 */     long l3 = v.a(paramArrayOfbyte, paramInt1 + 8);
/* 146 */     long l4 = v.a(paramArrayOfbyte, paramInt1 + paramInt2 - 8) * l1;
/* 147 */     long l5 = v.a(paramArrayOfbyte, paramInt1 + paramInt2 - 16) * -7286425919675154353L;
/* 148 */     return a(
/* 149 */         Long.rotateRight(l2 + l3, 43) + Long.rotateRight(l4, 30) + l5, l2 + Long.rotateRight(l3 + -7286425919675154353L, 18) + l4, l1);
/*     */   }
/*     */   
/*     */   private static long d(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 153 */     long l1 = -7286425919675154353L + (paramInt2 * 2);
/* 154 */     long l2 = v.a(paramArrayOfbyte, paramInt1) * -7286425919675154353L;
/* 155 */     long l3 = v.a(paramArrayOfbyte, paramInt1 + 8);
/* 156 */     long l4 = v.a(paramArrayOfbyte, paramInt1 + paramInt2 - 8) * l1;
/* 157 */     long l5 = v.a(paramArrayOfbyte, paramInt1 + paramInt2 - 16) * -7286425919675154353L;
/* 158 */     long l6 = Long.rotateRight(l2 + l3, 43) + Long.rotateRight(l4, 30) + l5;
/* 159 */     long l7 = a(l6, l2 + Long.rotateRight(l3 + -7286425919675154353L, 18) + l4, l1);
/* 160 */     long l8 = v.a(paramArrayOfbyte, paramInt1 + 16) * l1;
/* 161 */     long l9 = v.a(paramArrayOfbyte, paramInt1 + 24);
/* 162 */     long l10 = (l6 + v.a(paramArrayOfbyte, paramInt1 + paramInt2 - 32)) * l1;
/* 163 */     long l11 = (l7 + v.a(paramArrayOfbyte, paramInt1 + paramInt2 - 24)) * l1;
/* 164 */     return a(
/* 165 */         Long.rotateRight(l8 + l9, 43) + Long.rotateRight(l10, 30) + l11, l8 + Long.rotateRight(l9 + l2, 18) + l10, l1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static long e(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 172 */     byte b = 81;
/*     */     
/* 174 */     long l1 = 81L;
/*     */     
/* 176 */     long l2 = 2480279821605975764L;
/* 177 */     long l3 = d(l2 * -7286425919675154353L + 113L) * -7286425919675154353L;
/* 178 */     long[] arrayOfLong1 = new long[2];
/* 179 */     long[] arrayOfLong2 = new long[2];
/* 180 */     l1 = l1 * -7286425919675154353L + v.a(paramArrayOfbyte, paramInt1);
/*     */ 
/*     */     
/* 183 */     int i = paramInt1 + (paramInt2 - 1) / 64 * 64;
/* 184 */     int j = i + (paramInt2 - 1 & 0x3F) - 63;
/*     */     while (true) {
/* 186 */       l1 = Long.rotateRight(l1 + l2 + arrayOfLong1[0] + v.a(paramArrayOfbyte, paramInt1 + 8), 37) * -5435081209227447693L;
/* 187 */       l2 = Long.rotateRight(l2 + arrayOfLong1[1] + v.a(paramArrayOfbyte, paramInt1 + 48), 42) * -5435081209227447693L;
/* 188 */       l1 ^= arrayOfLong2[1];
/* 189 */       l2 += arrayOfLong1[0] + v.a(paramArrayOfbyte, paramInt1 + 40);
/* 190 */       l3 = Long.rotateRight(l3 + arrayOfLong2[0], 33) * -5435081209227447693L;
/* 191 */       a(paramArrayOfbyte, paramInt1, arrayOfLong1[1] * -5435081209227447693L, l1 + arrayOfLong2[0], arrayOfLong1);
/* 192 */       a(paramArrayOfbyte, paramInt1 + 32, l3 + arrayOfLong2[1], l2 + v.a(paramArrayOfbyte, paramInt1 + 16), arrayOfLong2);
/* 193 */       long l = l1;
/* 194 */       l1 = l3;
/* 195 */       l3 = l;
/* 196 */       paramInt1 += 64;
/* 197 */       if (paramInt1 == i) {
/* 198 */         l = -5435081209227447693L + ((l3 & 0xFFL) << 1L);
/*     */         
/* 200 */         paramInt1 = j;
/* 201 */         arrayOfLong2[0] = arrayOfLong2[0] + (paramInt2 - 1 & 0x3F);
/* 202 */         arrayOfLong1[0] = arrayOfLong1[0] + arrayOfLong2[0];
/* 203 */         arrayOfLong2[0] = arrayOfLong2[0] + arrayOfLong1[0];
/* 204 */         l1 = Long.rotateRight(l1 + l2 + arrayOfLong1[0] + v.a(paramArrayOfbyte, paramInt1 + 8), 37) * l;
/* 205 */         l2 = Long.rotateRight(l2 + arrayOfLong1[1] + v.a(paramArrayOfbyte, paramInt1 + 48), 42) * l;
/* 206 */         l1 ^= arrayOfLong2[1] * 9L;
/* 207 */         l2 += arrayOfLong1[0] * 9L + v.a(paramArrayOfbyte, paramInt1 + 40);
/* 208 */         l3 = Long.rotateRight(l3 + arrayOfLong2[0], 33) * l;
/* 209 */         a(paramArrayOfbyte, paramInt1, arrayOfLong1[1] * l, l1 + arrayOfLong2[0], arrayOfLong1);
/* 210 */         a(paramArrayOfbyte, paramInt1 + 32, l3 + arrayOfLong2[1], l2 + v.a(paramArrayOfbyte, paramInt1 + 16), arrayOfLong2);
/* 211 */         return a(
/* 212 */             a(arrayOfLong1[0], arrayOfLong2[0], l) + d(l2) * -4348849565147123417L + l1, 
/* 213 */             a(arrayOfLong1[1], arrayOfLong2[1], l) + l3, l);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\h\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */