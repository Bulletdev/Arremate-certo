/*     */ package com.google.a.k;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import java.math.BigInteger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @c
/*     */ final class d
/*     */ {
/*     */   static final long bg = 4503599627370495L;
/*     */   static final long EXPONENT_MASK = 9218868437227405312L;
/*     */   static final long bh = -9223372036854775808L;
/*     */   static final int fX = 52;
/*     */   static final int EXPONENT_BIAS = 1023;
/*     */   static final long bi = 4503599627370496L;
/*     */   @com.google.a.a.d
/*     */   static final long bj = 4607182418800017408L;
/*     */   
/*     */   static double e(double paramDouble) {
/*  40 */     return -Math.nextUp(-paramDouble);
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
/*     */ 
/*     */ 
/*     */   
/*     */   static long a(double paramDouble) {
/*  63 */     D.a(e(paramDouble), "not a normal value");
/*  64 */     int i = Math.getExponent(paramDouble);
/*  65 */     long l = Double.doubleToRawLongBits(paramDouble);
/*  66 */     l &= 0xFFFFFFFFFFFFFL;
/*  67 */     return (i == -1023) ? (l << 1L) : (l | 0x10000000000000L);
/*     */   }
/*     */   
/*     */   static boolean e(double paramDouble) {
/*  71 */     return (Math.getExponent(paramDouble) <= 1023);
/*     */   }
/*     */   
/*     */   static boolean f(double paramDouble) {
/*  75 */     return (Math.getExponent(paramDouble) >= -1022);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static double f(double paramDouble) {
/*  83 */     long l = Double.doubleToRawLongBits(paramDouble) & 0xFFFFFFFFFFFFFL;
/*  84 */     return Double.longBitsToDouble(l | 0x3FF0000000000000L);
/*     */   }
/*     */ 
/*     */   
/*     */   static double b(BigInteger paramBigInteger) {
/*  89 */     BigInteger bigInteger = paramBigInteger.abs();
/*  90 */     int i = bigInteger.bitLength() - 1;
/*     */     
/*  92 */     if (i < 63)
/*  93 */       return paramBigInteger.longValue(); 
/*  94 */     if (i > 1023) {
/*  95 */       return paramBigInteger.signum() * Double.POSITIVE_INFINITY;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     int j = i - 52 - 1;
/* 107 */     long l1 = bigInteger.shiftRight(j).longValue();
/* 108 */     long l2 = l1 >> 1L;
/* 109 */     l2 &= 0xFFFFFFFFFFFFFL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 117 */     boolean bool = ((l1 & 0x1L) != 0L && ((l2 & 0x1L) != 0L || bigInteger.getLowestSetBit() < j)) ? true : false;
/* 118 */     long l3 = bool ? (l2 + 1L) : l2;
/* 119 */     long l4 = (i + 1023) << 52L;
/* 120 */     l4 += l3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 127 */     l4 |= paramBigInteger.signum() & Long.MIN_VALUE;
/* 128 */     return Double.longBitsToDouble(l4);
/*     */   }
/*     */ 
/*     */   
/*     */   static double g(double paramDouble) {
/* 133 */     D.checkArgument(!Double.isNaN(paramDouble));
/* 134 */     return Math.max(paramDouble, 0.0D);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\k\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */