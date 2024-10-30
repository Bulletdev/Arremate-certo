/*      */ package com.google.a.k;
/*      */ 
/*      */ import com.google.a.a.b;
/*      */ import com.google.a.a.c;
/*      */ import com.google.a.a.d;
/*      */ import com.google.a.b.D;
/*      */ import com.google.a.m.m;
/*      */ import com.google.a.m.x;
/*      */ import java.math.RoundingMode;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @b(cl = true)
/*      */ public final class g
/*      */ {
/*      */   @d
/*      */   static final long bk = 4611686018427387904L;
/*      */   @d
/*      */   static final long bl = -5402926248376769404L;
/*      */   
/*      */   @com.google.a.a.a
/*      */   public static long g(long paramLong) {
/*   68 */     h.a("x", paramLong);
/*   69 */     if (paramLong > 4611686018427387904L) {
/*   70 */       throw new ArithmeticException((new StringBuilder(70)).append("ceilingPowerOfTwo(").append(paramLong).append(") is not representable as a long").toString());
/*      */     }
/*   72 */     return 1L << -Long.numberOfLeadingZeros(paramLong - 1L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.a
/*      */   public static long h(long paramLong) {
/*   84 */     h.a("x", paramLong);
/*      */ 
/*      */ 
/*      */     
/*   88 */     return 1L << 63 - Long.numberOfLeadingZeros(paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean f(long paramLong) {
/*   98 */     return ((paramLong > 0L)) & (((paramLong & paramLong - 1L) == 0L));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @d
/*      */   static int b(long paramLong1, long paramLong2) {
/*  109 */     return (int)((paramLong1 - paramLong2 ^ 0xFFFFFFFFFFFFFFFFL ^ 0xFFFFFFFFFFFFFFFFL) >>> 63L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int a(long paramLong, RoundingMode paramRoundingMode) {
/*      */     int i;
/*      */     long l;
/*      */     int j;
/*  122 */     h.a("x", paramLong);
/*  123 */     switch (null.S[paramRoundingMode.ordinal()]) {
/*      */       case 1:
/*  125 */         h.af(f(paramLong));
/*      */       
/*      */       case 2:
/*      */       case 3:
/*  129 */         return 63 - Long.numberOfLeadingZeros(paramLong);
/*      */       
/*      */       case 4:
/*      */       case 5:
/*  133 */         return 64 - Long.numberOfLeadingZeros(paramLong - 1L);
/*      */ 
/*      */       
/*      */       case 6:
/*      */       case 7:
/*      */       case 8:
/*  139 */         i = Long.numberOfLeadingZeros(paramLong);
/*  140 */         l = -5402926248376769404L >>> i;
/*      */         
/*  142 */         j = 63 - i;
/*  143 */         return j + b(l, paramLong);
/*      */     } 
/*      */     
/*  146 */     throw new AssertionError("impossible");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @c
/*      */   public static int b(long paramLong, RoundingMode paramRoundingMode) {
/*  164 */     h.a("x", paramLong);
/*  165 */     int i = a(paramLong);
/*  166 */     long l = d[i];
/*  167 */     switch (null.S[paramRoundingMode.ordinal()]) {
/*      */       case 1:
/*  169 */         h.af((paramLong == l));
/*      */       
/*      */       case 2:
/*      */       case 3:
/*  173 */         return i;
/*      */       case 4:
/*      */       case 5:
/*  176 */         return i + b(l, paramLong);
/*      */       
/*      */       case 6:
/*      */       case 7:
/*      */       case 8:
/*  181 */         return i + b(e[i], paramLong);
/*      */     } 
/*  183 */     throw new AssertionError();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @c
/*      */   static int a(long paramLong) {
/*  196 */     byte b = c[Long.numberOfLeadingZeros(paramLong)];
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  201 */     return b - b(paramLong, d[b]);
/*      */   }
/*      */ 
/*      */   
/*      */   @d
/*  206 */   static final byte[] c = new byte[] { 19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @c
/*      */   @d
/*  214 */   static final long[] d = new long[] { 1L, 10L, 100L, 1000L, 10000L, 100000L, 1000000L, 10000000L, 100000000L, 1000000000L, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @c
/*      */   @d
/*  239 */   static final long[] e = new long[] { 3L, 31L, 316L, 3162L, 31622L, 316227L, 3162277L, 31622776L, 316227766L, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @d
/*      */   static final long bm = 3037000499L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @c
/*      */   public static long a(long paramLong, int paramInt) {
/*  270 */     h.b("exponent", paramInt);
/*  271 */     if (-2L <= paramLong && paramLong <= 2L) {
/*  272 */       switch ((int)paramLong) {
/*      */         case 0:
/*  274 */           return (paramInt == 0) ? 1L : 0L;
/*      */         case 1:
/*  276 */           return 1L;
/*      */         case -1:
/*  278 */           return ((paramInt & 0x1) == 0) ? 1L : -1L;
/*      */         case 2:
/*  280 */           return (paramInt < 64) ? (1L << paramInt) : 0L;
/*      */         case -2:
/*  282 */           if (paramInt < 64) {
/*  283 */             return ((paramInt & 0x1) == 0) ? (1L << paramInt) : -(1L << paramInt);
/*      */           }
/*  285 */           return 0L;
/*      */       } 
/*      */       
/*  288 */       throw new AssertionError();
/*      */     } 
/*      */     
/*  291 */     for (long l = 1L;; paramInt >>= 1) {
/*  292 */       switch (paramInt) {
/*      */         case 0:
/*  294 */           return l;
/*      */         case 1:
/*  296 */           return l * paramLong;
/*      */       } 
/*  298 */       l *= ((paramInt & 0x1) == 0) ? 1L : paramLong;
/*  299 */       paramLong *= paramLong;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @c
/*      */   public static long a(long paramLong, RoundingMode paramRoundingMode) {
/*      */     long l3, l4;
/*  314 */     h.b("x", paramLong);
/*  315 */     if (g(paramLong)) {
/*  316 */       return e.c((int)paramLong, paramRoundingMode);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  333 */     long l1 = (long)Math.sqrt(paramLong);
/*      */     
/*  335 */     long l2 = l1 * l1;
/*      */ 
/*      */     
/*  338 */     switch (null.S[paramRoundingMode.ordinal()]) {
/*      */       case 1:
/*  340 */         h.af((l2 == paramLong));
/*  341 */         return l1;
/*      */       case 2:
/*      */       case 3:
/*  344 */         if (paramLong < l2) {
/*  345 */           return l1 - 1L;
/*      */         }
/*  347 */         return l1;
/*      */       case 4:
/*      */       case 5:
/*  350 */         if (paramLong > l2) {
/*  351 */           return l1 + 1L;
/*      */         }
/*  353 */         return l1;
/*      */       case 6:
/*      */       case 7:
/*      */       case 8:
/*  357 */         l3 = l1 - ((paramLong < l2) ? 1L : 0L);
/*  358 */         l4 = l3 * l3 + l3;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  370 */         return l3 + b(l4, paramLong);
/*      */     } 
/*  372 */     throw new AssertionError();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @c
/*      */   public static long a(long paramLong1, long paramLong2, RoundingMode paramRoundingMode) {
/*      */     int j;
/*      */     long l3, l4;
/*  386 */     D.checkNotNull(paramRoundingMode);
/*  387 */     long l1 = paramLong1 / paramLong2;
/*  388 */     long l2 = paramLong1 - paramLong2 * l1;
/*      */     
/*  390 */     if (l2 == 0L) {
/*  391 */       return l1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  401 */     int i = 0x1 | (int)((paramLong1 ^ paramLong2) >> 63L);
/*      */     
/*  403 */     switch (null.S[paramRoundingMode.ordinal()]) {
/*      */       case 1:
/*  405 */         h.af((l2 == 0L));
/*      */       
/*      */       case 2:
/*  408 */         j = 0;
/*      */         break;
/*      */       case 4:
/*  411 */         j = 1;
/*      */         break;
/*      */       case 5:
/*  414 */         j = (i > 0) ? 1 : 0;
/*      */         break;
/*      */       case 3:
/*  417 */         j = (i < 0) ? 1 : 0;
/*      */         break;
/*      */       case 6:
/*      */       case 7:
/*      */       case 8:
/*  422 */         l3 = Math.abs(l2);
/*  423 */         l4 = l3 - Math.abs(paramLong2) - l3;
/*      */ 
/*      */         
/*  426 */         if (l4 == 0L) {
/*  427 */           j = ((paramRoundingMode == RoundingMode.HALF_UP) ? 1 : 0) | ((paramRoundingMode == RoundingMode.HALF_EVEN) ? 1 : 0) & (((l1 & 0x1L) != 0L) ? 1 : 0); break;
/*      */         } 
/*  429 */         j = (l4 > 0L) ? 1 : 0;
/*      */         break;
/*      */       
/*      */       default:
/*  433 */         throw new AssertionError();
/*      */     } 
/*  435 */     return (j != 0) ? (l1 + i) : l1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @c
/*      */   public static int b(long paramLong, int paramInt) {
/*  459 */     return (int)b(paramLong, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @c
/*      */   public static long b(long paramLong1, long paramLong2) {
/*  482 */     if (paramLong2 <= 0L) {
/*  483 */       throw new ArithmeticException("Modulus must be positive");
/*      */     }
/*  485 */     long l = paramLong1 % paramLong2;
/*  486 */     return (l >= 0L) ? l : (l + paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long c(long paramLong1, long paramLong2) {
/*  501 */     h.b("a", paramLong1);
/*  502 */     h.b("b", paramLong2);
/*  503 */     if (paramLong1 == 0L)
/*      */     {
/*      */       
/*  506 */       return paramLong2; } 
/*  507 */     if (paramLong2 == 0L) {
/*  508 */       return paramLong1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  514 */     int i = Long.numberOfTrailingZeros(paramLong1);
/*  515 */     paramLong1 >>= i;
/*  516 */     int j = Long.numberOfTrailingZeros(paramLong2);
/*  517 */     paramLong2 >>= j;
/*  518 */     while (paramLong1 != paramLong2) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  526 */       long l1 = paramLong1 - paramLong2;
/*      */       
/*  528 */       long l2 = l1 & l1 >> 63L;
/*      */ 
/*      */       
/*  531 */       paramLong1 = l1 - l2 - l2;
/*      */ 
/*      */       
/*  534 */       paramLong2 += l2;
/*  535 */       paramLong1 >>= Long.numberOfTrailingZeros(paramLong1);
/*      */     } 
/*  537 */     return paramLong1 << Math.min(i, j);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @c
/*      */   public static long d(long paramLong1, long paramLong2) {
/*  547 */     long l = paramLong1 + paramLong2;
/*  548 */     h.d((((paramLong1 ^ paramLong2) < 0L)) | (((paramLong1 ^ l) >= 0L)), "checkedAdd", paramLong1, paramLong2);
/*  549 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @c
/*      */   public static long e(long paramLong1, long paramLong2) {
/*  559 */     long l = paramLong1 - paramLong2;
/*  560 */     h.d((((paramLong1 ^ paramLong2) >= 0L)) | (((paramLong1 ^ l) >= 0L)), "checkedSubtract", paramLong1, paramLong2);
/*  561 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long f(long paramLong1, long paramLong2) {
/*  575 */     int i = Long.numberOfLeadingZeros(paramLong1) + Long.numberOfLeadingZeros(paramLong1 ^ 0xFFFFFFFFFFFFFFFFL) + Long.numberOfLeadingZeros(paramLong2) + Long.numberOfLeadingZeros(paramLong2 ^ 0xFFFFFFFFFFFFFFFFL);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  586 */     if (i > 65) {
/*  587 */       return paramLong1 * paramLong2;
/*      */     }
/*  589 */     h.d((i >= 64), "checkedMultiply", paramLong1, paramLong2);
/*  590 */     h.d(((paramLong1 >= 0L)) | ((paramLong2 != Long.MIN_VALUE)), "checkedMultiply", paramLong1, paramLong2);
/*  591 */     long l = paramLong1 * paramLong2;
/*  592 */     h.d((paramLong1 == 0L || l / paramLong1 == paramLong2), "checkedMultiply", paramLong1, paramLong2);
/*  593 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @c
/*      */   public static long b(long paramLong, int paramInt) {
/*  604 */     h.b("exponent", paramInt);
/*  605 */     if ((((paramLong >= -2L) ? 1 : 0) & ((paramLong <= 2L) ? 1 : 0)) != 0) {
/*  606 */       switch ((int)paramLong) {
/*      */         case 0:
/*  608 */           return (paramInt == 0) ? 1L : 0L;
/*      */         case 1:
/*  610 */           return 1L;
/*      */         case -1:
/*  612 */           return ((paramInt & 0x1) == 0) ? 1L : -1L;
/*      */         case 2:
/*  614 */           h.d((paramInt < 63), "checkedPow", paramLong, paramInt);
/*  615 */           return 1L << paramInt;
/*      */         case -2:
/*  617 */           h.d((paramInt < 64), "checkedPow", paramLong, paramInt);
/*  618 */           return ((paramInt & 0x1) == 0) ? (1L << paramInt) : (-1L << paramInt);
/*      */       } 
/*  620 */       throw new AssertionError();
/*      */     } 
/*      */     
/*  623 */     long l = 1L;
/*      */     while (true) {
/*  625 */       switch (paramInt) {
/*      */         case 0:
/*  627 */           return l;
/*      */         case 1:
/*  629 */           return f(l, paramLong);
/*      */       } 
/*  631 */       if ((paramInt & 0x1) != 0) {
/*  632 */         l = f(l, paramLong);
/*      */       }
/*  634 */       paramInt >>= 1;
/*  635 */       if (paramInt > 0) {
/*  636 */         h.d((-3037000499L <= paramLong && paramLong <= 3037000499L), "checkedPow", paramLong, paramInt);
/*      */         
/*  638 */         paramLong *= paramLong;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.a
/*      */   public static long g(long paramLong1, long paramLong2) {
/*  652 */     long l = paramLong1 + paramLong2;
/*  653 */     if (((((paramLong1 ^ paramLong2) < 0L) ? 1 : 0) | (((paramLong1 ^ l) >= 0L) ? 1 : 0)) != 0)
/*      */     {
/*      */       
/*  656 */       return l;
/*      */     }
/*      */     
/*  659 */     return Long.MAX_VALUE + (l >>> 63L ^ 0x1L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.a
/*      */   public static long h(long paramLong1, long paramLong2) {
/*  670 */     long l = paramLong1 - paramLong2;
/*  671 */     if (((((paramLong1 ^ paramLong2) >= 0L) ? 1 : 0) | (((paramLong1 ^ l) >= 0L) ? 1 : 0)) != 0)
/*      */     {
/*      */       
/*  674 */       return l;
/*      */     }
/*      */     
/*  677 */     return Long.MAX_VALUE + (l >>> 63L ^ 0x1L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.a
/*      */   public static long i(long paramLong1, long paramLong2) {
/*  693 */     int i = Long.numberOfLeadingZeros(paramLong1) + Long.numberOfLeadingZeros(paramLong1 ^ 0xFFFFFFFFFFFFFFFFL) + Long.numberOfLeadingZeros(paramLong2) + Long.numberOfLeadingZeros(paramLong2 ^ 0xFFFFFFFFFFFFFFFFL);
/*  694 */     if (i > 65) {
/*  695 */       return paramLong1 * paramLong2;
/*      */     }
/*      */     
/*  698 */     long l1 = Long.MAX_VALUE + ((paramLong1 ^ paramLong2) >>> 63L);
/*  699 */     if ((((i < 64) ? 1 : 0) | ((paramLong1 < 0L) ? 1 : 0) & ((paramLong2 == Long.MIN_VALUE) ? 1 : 0)) != 0)
/*      */     {
/*  701 */       return l1;
/*      */     }
/*  703 */     long l2 = paramLong1 * paramLong2;
/*  704 */     if (paramLong1 == 0L || l2 / paramLong1 == paramLong2) {
/*  705 */       return l2;
/*      */     }
/*  707 */     return l1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.a
/*      */   public static long c(long paramLong, int paramInt) {
/*  718 */     h.b("exponent", paramInt);
/*  719 */     if ((((paramLong >= -2L) ? 1 : 0) & ((paramLong <= 2L) ? 1 : 0)) != 0) {
/*  720 */       switch ((int)paramLong) {
/*      */         case 0:
/*  722 */           return (paramInt == 0) ? 1L : 0L;
/*      */         case 1:
/*  724 */           return 1L;
/*      */         case -1:
/*  726 */           return ((paramInt & 0x1) == 0) ? 1L : -1L;
/*      */         case 2:
/*  728 */           if (paramInt >= 63) {
/*  729 */             return Long.MAX_VALUE;
/*      */           }
/*  731 */           return 1L << paramInt;
/*      */         case -2:
/*  733 */           if (paramInt >= 64) {
/*  734 */             return Long.MAX_VALUE + (paramInt & 0x1);
/*      */           }
/*  736 */           return ((paramInt & 0x1) == 0) ? (1L << paramInt) : (-1L << paramInt);
/*      */       } 
/*  738 */       throw new AssertionError();
/*      */     } 
/*      */     
/*  741 */     long l1 = 1L;
/*      */     
/*  743 */     long l2 = Long.MAX_VALUE + (paramLong >>> 63L & (paramInt & 0x1));
/*      */     while (true) {
/*  745 */       switch (paramInt) {
/*      */         case 0:
/*  747 */           return l1;
/*      */         case 1:
/*  749 */           return i(l1, paramLong);
/*      */       } 
/*  751 */       if ((paramInt & 0x1) != 0) {
/*  752 */         l1 = i(l1, paramLong);
/*      */       }
/*  754 */       paramInt >>= 1;
/*  755 */       if (paramInt > 0) {
/*  756 */         if ((((-3037000499L > paramLong) ? 1 : 0) | ((paramLong > 3037000499L) ? 1 : 0)) != 0) {
/*  757 */           return l2;
/*      */         }
/*  759 */         paramLong *= paramLong;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @c
/*      */   public static long factorial(int paramInt) {
/*  775 */     h.b("n", paramInt);
/*  776 */     return (paramInt < f.length) ? f[paramInt] : Long.MAX_VALUE;
/*      */   }
/*      */   
/*  779 */   static final long[] f = new long[] { 1L, 1L, 2L, 6L, 24L, 120L, 720L, 5040L, 40320L, 362880L, 3628800L, 39916800L, 479001600L, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long a(int paramInt1, int paramInt2) {
/*  810 */     h.b("n", paramInt1);
/*  811 */     h.b("k", paramInt2);
/*  812 */     D.a((paramInt2 <= paramInt1), "k (%s) > n (%s)", paramInt2, paramInt1);
/*  813 */     if (paramInt2 > paramInt1 >> 1) {
/*  814 */       paramInt2 = paramInt1 - paramInt2;
/*      */     }
/*  816 */     switch (paramInt2) {
/*      */       case 0:
/*  818 */         return 1L;
/*      */       case 1:
/*  820 */         return paramInt1;
/*      */     } 
/*  822 */     if (paramInt1 < f.length)
/*  823 */       return f[paramInt1] / f[paramInt2] * f[paramInt1 - paramInt2]; 
/*  824 */     if (paramInt2 >= X.length || paramInt1 > X[paramInt2])
/*  825 */       return Long.MAX_VALUE; 
/*  826 */     if (paramInt2 < Y.length && paramInt1 <= Y[paramInt2]) {
/*      */       
/*  828 */       long l = paramInt1--;
/*  829 */       for (byte b1 = 2; b1 <= paramInt2; paramInt1--, b1++) {
/*  830 */         l *= paramInt1;
/*  831 */         l /= b1;
/*      */       } 
/*  833 */       return l;
/*      */     } 
/*  835 */     int i = a(paramInt1, RoundingMode.CEILING);
/*      */     
/*  837 */     long l1 = 1L;
/*  838 */     long l2 = paramInt1--;
/*  839 */     long l3 = 1L;
/*      */     
/*  841 */     int j = i;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  849 */     for (byte b = 2; b <= paramInt2; b++, paramInt1--) {
/*  850 */       if (j + i < 63) {
/*      */         
/*  852 */         l2 *= paramInt1;
/*  853 */         l3 *= b;
/*  854 */         j += i;
/*      */       }
/*      */       else {
/*      */         
/*  858 */         l1 = b(l1, l2, l3);
/*  859 */         l2 = paramInt1;
/*  860 */         l3 = b;
/*  861 */         j = i;
/*      */       } 
/*      */     } 
/*  864 */     return b(l1, l2, l3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static long b(long paramLong1, long paramLong2, long paramLong3) {
/*  871 */     if (paramLong1 == 1L) {
/*  872 */       return paramLong2 / paramLong3;
/*      */     }
/*  874 */     long l = c(paramLong1, paramLong3);
/*  875 */     paramLong1 /= l;
/*  876 */     paramLong3 /= l;
/*      */ 
/*      */     
/*  879 */     return paramLong1 * paramLong2 / paramLong3;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  885 */   static final int[] X = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @d
/*  927 */   static final int[] Y = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int gb = -545925251;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static boolean g(long paramLong) {
/*  964 */     return ((int)paramLong == paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long j(long paramLong1, long paramLong2) {
/*  977 */     return (paramLong1 & paramLong2) + ((paramLong1 ^ paramLong2) >> 1L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @c
/*      */   @com.google.a.a.a
/*      */   public static boolean h(long paramLong) {
/* 1004 */     if (paramLong < 2L) {
/* 1005 */       h.b("n", paramLong);
/* 1006 */       return false;
/*      */     } 
/* 1008 */     if (paramLong < 66L) {
/*      */       
/* 1010 */       long l = 722865708377213483L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1030 */       return ((l >> (int)paramLong - 2 & 0x1L) != 0L);
/*      */     } 
/*      */     
/* 1033 */     if ((0xDF75D77D & 1 << (int)(paramLong % 30L)) != 0) {
/* 1034 */       return false;
/*      */     }
/* 1036 */     if (paramLong % 7L == 0L || paramLong % 11L == 0L || paramLong % 13L == 0L) {
/* 1037 */       return false;
/*      */     }
/* 1039 */     if (paramLong < 289L) {
/* 1040 */       return true;
/*      */     }
/*      */     
/* 1043 */     for (long[] arrayOfLong : a) {
/* 1044 */       if (paramLong <= arrayOfLong[0]) {
/* 1045 */         for (byte b = 1; b < arrayOfLong.length; b++) {
/* 1046 */           if (!a.c(arrayOfLong[b], paramLong)) {
/* 1047 */             return false;
/*      */           }
/*      */         } 
/* 1050 */         return true;
/*      */       } 
/*      */     } 
/* 1053 */     throw new AssertionError();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1063 */   private static final long[][] a = new long[][] { { 291830L, 126401071349994536L }, { 885594168L, 725270293939359937L, 3569819667048198375L }, { 273919523040L, 15L, 7363882082L, 992620450144556L }, { 47636622961200L, 2L, 2570940L, 211991001L, 3749873356L }, { 7999252175582850L, 2L, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L }, { 585226005592931976L, 2L, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L }, { Long.MAX_VALUE, 2L, 325L, 9375L, 28178L, 450775L, 9780504L, 1795265022L } };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private enum a
/*      */   {
/* 1090 */     a
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       long c(long param2Long1, long param2Long2, long param2Long3)
/*      */       {
/* 1099 */         return param2Long1 * param2Long2 % param2Long3;
/*      */       }
/*      */ 
/*      */       
/*      */       long k(long param2Long1, long param2Long2) {
/* 1104 */         return param2Long1 * param2Long1 % param2Long2;
/*      */       }
/*      */     },
/*      */     
/* 1108 */     b
/*      */     {
/*      */       private long e(long param2Long1, long param2Long2, long param2Long3) {
/* 1111 */         return (param2Long1 >= param2Long3 - param2Long2) ? (param2Long1 + param2Long2 - param2Long3) : (param2Long1 + param2Long2);
/*      */       }
/*      */ 
/*      */       
/*      */       private long l(long param2Long1, long param2Long2) {
/* 1116 */         int i = 32;
/*      */         while (true) {
/* 1118 */           int j = Math.min(i, Long.numberOfLeadingZeros(param2Long1));
/*      */ 
/*      */           
/* 1121 */           param2Long1 = x.n(param2Long1 << j, param2Long2);
/* 1122 */           i -= j;
/* 1123 */           if (i <= 0)
/* 1124 */             return param2Long1; 
/*      */         } 
/*      */       }
/*      */       
/*      */       long c(long param2Long1, long param2Long2, long param2Long3) {
/* 1129 */         long l1 = param2Long1 >>> 32L;
/* 1130 */         long l2 = param2Long2 >>> 32L;
/* 1131 */         long l3 = param2Long1 & 0xFFFFFFFFL;
/* 1132 */         long l4 = param2Long2 & 0xFFFFFFFFL;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1142 */         long l5 = l(l1 * l2, param2Long3);
/* 1143 */         l5 += l1 * l4;
/* 1144 */         if (l5 < 0L) {
/* 1145 */           l5 = x.n(l5, param2Long3);
/*      */         }
/*      */         
/* 1148 */         l5 += l3 * l2;
/* 1149 */         l5 = l(l5, param2Long3);
/* 1150 */         return e(l5, x.n(l3 * l4, param2Long3), param2Long3);
/*      */       }
/*      */ 
/*      */       
/*      */       long k(long param2Long1, long param2Long2) {
/* 1155 */         long l1 = param2Long1 >>> 32L;
/* 1156 */         long l2 = param2Long1 & 0xFFFFFFFFL;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1165 */         long l3 = l(l1 * l1, param2Long2);
/* 1166 */         long l4 = l1 * l2 * 2L;
/* 1167 */         if (l4 < 0L) {
/* 1168 */           l4 = x.n(l4, param2Long2);
/*      */         }
/*      */         
/* 1171 */         l3 += l4;
/* 1172 */         l3 = l(l3, param2Long2);
/* 1173 */         return e(l3, x.n(l2 * l2, param2Long2), param2Long2);
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */     
/*      */     static boolean c(long param1Long1, long param1Long2) {
/* 1180 */       return ((param1Long2 <= 3037000499L) ? a : b).d(param1Long1, param1Long2);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private long d(long param1Long1, long param1Long2, long param1Long3) {
/* 1191 */       long l = 1L;
/* 1192 */       for (; param1Long2 != 0L; param1Long2 >>= 1L) {
/* 1193 */         if ((param1Long2 & 0x1L) != 0L) {
/* 1194 */           l = c(l, param1Long1, param1Long3);
/*      */         }
/* 1196 */         param1Long1 = k(param1Long1, param1Long3);
/*      */       } 
/* 1198 */       return l;
/*      */     }
/*      */ 
/*      */     
/*      */     private boolean d(long param1Long1, long param1Long2) {
/* 1203 */       int i = Long.numberOfTrailingZeros(param1Long2 - 1L);
/* 1204 */       long l1 = param1Long2 - 1L >> i;
/* 1205 */       param1Long1 %= param1Long2;
/* 1206 */       if (param1Long1 == 0L) {
/* 1207 */         return true;
/*      */       }
/*      */       
/* 1210 */       long l2 = d(param1Long1, l1, param1Long2);
/*      */ 
/*      */ 
/*      */       
/* 1214 */       if (l2 == 1L) {
/* 1215 */         return true;
/*      */       }
/* 1217 */       byte b = 0;
/* 1218 */       while (l2 != param1Long2 - 1L) {
/* 1219 */         if (++b == i) {
/* 1220 */           return false;
/*      */         }
/* 1222 */         l2 = k(l2, param1Long2);
/*      */       } 
/* 1224 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     abstract long c(long param1Long1, long param1Long2, long param1Long3);
/*      */ 
/*      */ 
/*      */     
/*      */     abstract long k(long param1Long1, long param1Long2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @c
/*      */   public static double a(long paramLong, RoundingMode paramRoundingMode) {
/*      */     int i;
/*      */     long l2;
/*      */     double d2;
/*      */     long l3;
/*      */     double d3;
/*      */     long l4, l5;
/*      */     int j;
/* 1248 */     double d1 = paramLong;
/* 1249 */     long l1 = (long)d1;
/*      */ 
/*      */     
/* 1252 */     if (l1 == Long.MAX_VALUE) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1263 */       i = -1;
/*      */     } else {
/* 1265 */       i = m.compare(paramLong, l1);
/*      */     } 
/*      */     
/* 1268 */     switch (null.S[paramRoundingMode.ordinal()]) {
/*      */       case 1:
/* 1270 */         h.af((i == 0));
/* 1271 */         return d1;
/*      */       case 3:
/* 1273 */         return (i >= 0) ? 
/* 1274 */           d1 : 
/* 1275 */           d.e(d1);
/*      */       case 5:
/* 1277 */         return (i <= 0) ? d1 : Math.nextUp(d1);
/*      */       case 2:
/* 1279 */         if (paramLong >= 0L) {
/* 1280 */           return (i >= 0) ? 
/* 1281 */             d1 : 
/* 1282 */             d.e(d1);
/*      */         }
/* 1284 */         return (i <= 0) ? d1 : Math.nextUp(d1);
/*      */       
/*      */       case 4:
/* 1287 */         if (paramLong >= 0L) {
/* 1288 */           return (i <= 0) ? d1 : Math.nextUp(d1);
/*      */         }
/* 1290 */         return (i >= 0) ? 
/* 1291 */           d1 : 
/* 1292 */           d.e(d1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 6:
/*      */       case 7:
/*      */       case 8:
/* 1303 */         if (i >= 0) {
/* 1304 */           d2 = d1;
/* 1305 */           l2 = l1;
/* 1306 */           d3 = Math.nextUp(d1);
/* 1307 */           l3 = (long)Math.ceil(d3);
/*      */         } else {
/* 1309 */           d3 = d1;
/* 1310 */           l3 = l1;
/* 1311 */           d2 = d.e(d1);
/* 1312 */           l2 = (long)Math.floor(d2);
/*      */         } 
/*      */         
/* 1315 */         l4 = paramLong - l2;
/* 1316 */         l5 = l3 - paramLong;
/*      */         
/* 1318 */         if (l3 == Long.MAX_VALUE)
/*      */         {
/*      */           
/* 1321 */           l5++;
/*      */         }
/*      */         
/* 1324 */         j = m.compare(l4, l5);
/* 1325 */         if (j < 0)
/* 1326 */           return d2; 
/* 1327 */         if (j > 0) {
/* 1328 */           return d3;
/*      */         }
/*      */         
/* 1331 */         switch (null.S[paramRoundingMode.ordinal()]) {
/*      */           case 8:
/* 1333 */             return ((d.a(d2) & 0x1L) == 0L) ? 
/* 1334 */               d2 : 
/* 1335 */               d3;
/*      */           case 6:
/* 1337 */             return (paramLong >= 0L) ? d2 : d3;
/*      */           case 7:
/* 1339 */             return (paramLong >= 0L) ? d3 : d2;
/*      */         } 
/* 1341 */         throw new AssertionError("impossible");
/*      */     } 
/*      */ 
/*      */     
/* 1345 */     throw new AssertionError("impossible");
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\k\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */