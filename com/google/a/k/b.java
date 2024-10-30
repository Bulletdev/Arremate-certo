/*     */ package com.google.a.k;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.a.d;
/*     */ import com.google.a.b.D;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b(cl = true)
/*     */ public final class b
/*     */ {
/*     */   @d
/*     */   static final int fV = 256;
/*     */   
/*     */   @com.google.a.a.a
/*     */   public static BigInteger c(BigInteger paramBigInteger) {
/*  61 */     return BigInteger.ZERO.setBit(a(paramBigInteger, RoundingMode.CEILING));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.a
/*     */   public static BigInteger d(BigInteger paramBigInteger) {
/*  73 */     return BigInteger.ZERO.setBit(a(paramBigInteger, RoundingMode.FLOOR));
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean a(BigInteger paramBigInteger) {
/*  78 */     D.checkNotNull(paramBigInteger);
/*  79 */     return (paramBigInteger.signum() > 0 && paramBigInteger.getLowestSetBit() == paramBigInteger.bitLength() - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a(BigInteger paramBigInteger, RoundingMode paramRoundingMode) {
/*     */     BigInteger bigInteger;
/*     */     int j;
/*  92 */     h.a("x", (BigInteger)D.checkNotNull(paramBigInteger));
/*  93 */     int i = paramBigInteger.bitLength() - 1;
/*  94 */     switch (null.S[paramRoundingMode.ordinal()]) {
/*     */       case 1:
/*  96 */         h.af(a(paramBigInteger));
/*     */       case 2:
/*     */       case 3:
/*  99 */         return i;
/*     */       
/*     */       case 4:
/*     */       case 5:
/* 103 */         return a(paramBigInteger) ? i : (i + 1);
/*     */       
/*     */       case 6:
/*     */       case 7:
/*     */       case 8:
/* 108 */         if (i < 256) {
/*     */           
/* 110 */           BigInteger bigInteger1 = c.shiftRight(256 - i);
/* 111 */           if (paramBigInteger.compareTo(bigInteger1) <= 0) {
/* 112 */             return i;
/*     */           }
/* 114 */           return i + 1;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 121 */         bigInteger = paramBigInteger.pow(2);
/* 122 */         j = bigInteger.bitLength() - 1;
/* 123 */         return (j < 2 * i + 1) ? i : (i + 1);
/*     */     } 
/*     */     
/* 126 */     throw new AssertionError();
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
/*     */   @d
/* 138 */   static final BigInteger c = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   public static int b(BigInteger paramBigInteger, RoundingMode paramRoundingMode) {
/*     */     BigInteger bigInteger3, bigInteger4;
/* 151 */     h.a("x", paramBigInteger);
/* 152 */     if (b(paramBigInteger)) {
/* 153 */       return g.b(paramBigInteger.longValue(), paramRoundingMode);
/*     */     }
/*     */     
/* 156 */     int i = (int)(a(paramBigInteger, RoundingMode.FLOOR) * A / z);
/* 157 */     BigInteger bigInteger1 = BigInteger.TEN.pow(i);
/* 158 */     int j = bigInteger1.compareTo(paramBigInteger);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 165 */     if (j > 0) {
/*     */ 
/*     */       
/*     */       do {
/*     */ 
/*     */ 
/*     */         
/* 172 */         i--;
/* 173 */         bigInteger1 = bigInteger1.divide(BigInteger.TEN);
/* 174 */         j = bigInteger1.compareTo(paramBigInteger);
/* 175 */       } while (j > 0);
/*     */     } else {
/* 177 */       BigInteger bigInteger = BigInteger.TEN.multiply(bigInteger1);
/* 178 */       int n = bigInteger.compareTo(paramBigInteger);
/* 179 */       while (n <= 0) {
/* 180 */         i++;
/* 181 */         bigInteger1 = bigInteger;
/* 182 */         j = n;
/* 183 */         bigInteger = BigInteger.TEN.multiply(bigInteger1);
/* 184 */         n = bigInteger.compareTo(paramBigInteger);
/*     */       } 
/*     */     } 
/*     */     
/* 188 */     int k = i;
/* 189 */     BigInteger bigInteger2 = bigInteger1;
/* 190 */     int m = j;
/*     */     
/* 192 */     switch (null.S[paramRoundingMode.ordinal()]) {
/*     */       case 1:
/* 194 */         h.af((m == 0));
/*     */       
/*     */       case 2:
/*     */       case 3:
/* 198 */         return k;
/*     */       
/*     */       case 4:
/*     */       case 5:
/* 202 */         return bigInteger2.equals(paramBigInteger) ? k : (k + 1);
/*     */ 
/*     */       
/*     */       case 6:
/*     */       case 7:
/*     */       case 8:
/* 208 */         bigInteger3 = paramBigInteger.pow(2);
/* 209 */         bigInteger4 = bigInteger2.pow(2).multiply(BigInteger.TEN);
/* 210 */         return (bigInteger3.compareTo(bigInteger4) <= 0) ? k : (k + 1);
/*     */     } 
/* 212 */     throw new AssertionError();
/*     */   }
/*     */ 
/*     */   
/* 216 */   private static final double z = Math.log(10.0D);
/* 217 */   private static final double A = Math.log(2.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   public static BigInteger a(BigInteger paramBigInteger, RoundingMode paramRoundingMode) {
/*     */     int i;
/*     */     boolean bool;
/*     */     BigInteger bigInteger2;
/* 229 */     h.b("x", paramBigInteger);
/* 230 */     if (b(paramBigInteger)) {
/* 231 */       return BigInteger.valueOf(g.a(paramBigInteger.longValue(), paramRoundingMode));
/*     */     }
/* 233 */     BigInteger bigInteger1 = e(paramBigInteger);
/* 234 */     switch (null.S[paramRoundingMode.ordinal()]) {
/*     */       case 1:
/* 236 */         h.af(bigInteger1.pow(2).equals(paramBigInteger));
/*     */       case 2:
/*     */       case 3:
/* 239 */         return bigInteger1;
/*     */       case 4:
/*     */       case 5:
/* 242 */         i = bigInteger1.intValue();
/*     */ 
/*     */         
/* 245 */         bool = (i * i == paramBigInteger.intValue() && bigInteger1.pow(2).equals(paramBigInteger)) ? true : false;
/* 246 */         return bool ? bigInteger1 : bigInteger1.add(BigInteger.ONE);
/*     */       case 6:
/*     */       case 7:
/*     */       case 8:
/* 250 */         bigInteger2 = bigInteger1.pow(2).add(bigInteger1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 256 */         return (bigInteger2.compareTo(paramBigInteger) >= 0) ? bigInteger1 : bigInteger1.add(BigInteger.ONE);
/*     */     } 
/* 258 */     throw new AssertionError();
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
/*     */   
/*     */   @c
/*     */   private static BigInteger e(BigInteger paramBigInteger) {
/*     */     BigInteger bigInteger1;
/* 284 */     int i = a(paramBigInteger, RoundingMode.FLOOR);
/* 285 */     if (i < 1023) {
/* 286 */       bigInteger1 = f(paramBigInteger);
/*     */     } else {
/* 288 */       int j = i - 52 & 0xFFFFFFFE;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 293 */       bigInteger1 = f(paramBigInteger.shiftRight(j)).shiftLeft(j >> 1);
/*     */     } 
/* 295 */     BigInteger bigInteger2 = bigInteger1.add(paramBigInteger.divide(bigInteger1)).shiftRight(1);
/* 296 */     if (bigInteger1.equals(bigInteger2)) {
/* 297 */       return bigInteger1;
/*     */     }
/*     */     while (true) {
/* 300 */       bigInteger1 = bigInteger2;
/* 301 */       bigInteger2 = bigInteger1.add(paramBigInteger.divide(bigInteger1)).shiftRight(1);
/* 302 */       if (bigInteger2.compareTo(bigInteger1) >= 0)
/* 303 */         return bigInteger1; 
/*     */     } 
/*     */   }
/*     */   @c
/*     */   private static BigInteger f(BigInteger paramBigInteger) {
/* 308 */     return c.b(Math.sqrt(d.b(paramBigInteger)), RoundingMode.HALF_EVEN);
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
/*     */ 
/*     */   
/*     */   @c
/*     */   public static double a(BigInteger paramBigInteger, RoundingMode paramRoundingMode) {
/* 334 */     return a.a.a(paramBigInteger, paramRoundingMode);
/*     */   }
/*     */   
/*     */   @c
/*     */   private static class a extends n<BigInteger> {
/* 339 */     static final a a = new a();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     double a(BigInteger param1BigInteger) {
/* 345 */       return d.b(param1BigInteger);
/*     */     }
/*     */ 
/*     */     
/*     */     int a(BigInteger param1BigInteger) {
/* 350 */       return param1BigInteger.signum();
/*     */     }
/*     */ 
/*     */     
/*     */     BigInteger a(double param1Double, RoundingMode param1RoundingMode) {
/* 355 */       return c.b(param1Double, param1RoundingMode);
/*     */     }
/*     */ 
/*     */     
/*     */     BigInteger a(BigInteger param1BigInteger1, BigInteger param1BigInteger2) {
/* 360 */       return param1BigInteger1.subtract(param1BigInteger2);
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
/*     */   @c
/*     */   public static BigInteger a(BigInteger paramBigInteger1, BigInteger paramBigInteger2, RoundingMode paramRoundingMode) {
/* 373 */     BigDecimal bigDecimal1 = new BigDecimal(paramBigInteger1);
/* 374 */     BigDecimal bigDecimal2 = new BigDecimal(paramBigInteger2);
/* 375 */     return bigDecimal1.divide(bigDecimal2, 0, paramRoundingMode).toBigIntegerExact();
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
/*     */   public static BigInteger factorial(int paramInt) {
/* 391 */     h.b("n", paramInt);
/*     */ 
/*     */     
/* 394 */     if (paramInt < g.f.length) {
/* 395 */       return BigInteger.valueOf(g.f[paramInt]);
/*     */     }
/*     */ 
/*     */     
/* 399 */     int i = e.a(paramInt * e.a(paramInt, RoundingMode.CEILING), 64, RoundingMode.CEILING);
/* 400 */     ArrayList<BigInteger> arrayList = new ArrayList(i);
/*     */ 
/*     */     
/* 403 */     int j = g.f.length;
/* 404 */     long l1 = g.f[j - 1];
/*     */     
/* 406 */     int k = Long.numberOfTrailingZeros(l1);
/* 407 */     l1 >>= k;
/*     */ 
/*     */     
/* 410 */     int m = g.a(l1, RoundingMode.FLOOR) + 1;
/* 411 */     int n = g.a(j, RoundingMode.FLOOR) + 1;
/*     */     
/* 413 */     int i1 = 1 << n - 1;
/*     */     
/*     */     long l2;
/* 416 */     for (l2 = j; l2 <= paramInt; l2++) {
/*     */       
/* 418 */       if ((l2 & i1) != 0L) {
/* 419 */         i1 <<= 1;
/* 420 */         n++;
/*     */       } 
/*     */       
/* 423 */       int i2 = Long.numberOfTrailingZeros(l2);
/* 424 */       long l = l2 >> i2;
/* 425 */       k += i2;
/*     */       
/* 427 */       int i3 = n - i2;
/*     */       
/* 429 */       if (i3 + m >= 64) {
/* 430 */         arrayList.add(BigInteger.valueOf(l1));
/* 431 */         l1 = 1L;
/* 432 */         m = 0;
/*     */       } 
/* 434 */       l1 *= l;
/* 435 */       m = g.a(l1, RoundingMode.FLOOR) + 1;
/*     */     } 
/*     */     
/* 438 */     if (l1 > 1L) {
/* 439 */       arrayList.add(BigInteger.valueOf(l1));
/*     */     }
/*     */     
/* 442 */     return a(arrayList).shiftLeft(k);
/*     */   }
/*     */   
/*     */   static BigInteger a(List<BigInteger> paramList) {
/* 446 */     return a(paramList, 0, paramList.size());
/*     */   }
/*     */   
/*     */   static BigInteger a(List<BigInteger> paramList, int paramInt1, int paramInt2) {
/* 450 */     switch (paramInt2 - paramInt1) {
/*     */       case 0:
/* 452 */         return BigInteger.ONE;
/*     */       case 1:
/* 454 */         return paramList.get(paramInt1);
/*     */       case 2:
/* 456 */         return ((BigInteger)paramList.get(paramInt1)).multiply(paramList.get(paramInt1 + 1));
/*     */       case 3:
/* 458 */         return ((BigInteger)paramList.get(paramInt1)).multiply(paramList.get(paramInt1 + 1)).multiply(paramList.get(paramInt1 + 2));
/*     */     } 
/*     */     
/* 461 */     int i = paramInt2 + paramInt1 >>> 1;
/* 462 */     return a(paramList, paramInt1, i).multiply(a(paramList, i, paramInt2));
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
/*     */   public static BigInteger a(int paramInt1, int paramInt2) {
/* 475 */     h.b("n", paramInt1);
/* 476 */     h.b("k", paramInt2);
/* 477 */     D.a((paramInt2 <= paramInt1), "k (%s) > n (%s)", paramInt2, paramInt1);
/* 478 */     if (paramInt2 > paramInt1 >> 1) {
/* 479 */       paramInt2 = paramInt1 - paramInt2;
/*     */     }
/* 481 */     if (paramInt2 < g.X.length && paramInt1 <= g.X[paramInt2]) {
/* 482 */       return BigInteger.valueOf(g.a(paramInt1, paramInt2));
/*     */     }
/*     */     
/* 485 */     BigInteger bigInteger = BigInteger.ONE;
/*     */     
/* 487 */     long l1 = paramInt1;
/* 488 */     long l2 = 1L;
/*     */     
/* 490 */     int i = g.a(paramInt1, RoundingMode.CEILING);
/*     */     
/* 492 */     int j = i;
/*     */     
/* 494 */     for (byte b1 = 1; b1 < paramInt2; b1++) {
/* 495 */       int k = paramInt1 - b1;
/* 496 */       int m = b1 + 1;
/*     */ 
/*     */ 
/*     */       
/* 500 */       if (j + i >= 63) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 506 */         bigInteger = bigInteger.multiply(BigInteger.valueOf(l1)).divide(BigInteger.valueOf(l2));
/* 507 */         l1 = k;
/* 508 */         l2 = m;
/* 509 */         j = i;
/*     */       } else {
/*     */         
/* 512 */         l1 *= k;
/* 513 */         l2 *= m;
/* 514 */         j += i;
/*     */       } 
/*     */     } 
/* 517 */     return bigInteger
/* 518 */       .multiply(BigInteger.valueOf(l1))
/* 519 */       .divide(BigInteger.valueOf(l2));
/*     */   }
/*     */ 
/*     */   
/*     */   @c
/*     */   static boolean b(BigInteger paramBigInteger) {
/* 525 */     return (paramBigInteger.bitLength() <= 63);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\k\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */