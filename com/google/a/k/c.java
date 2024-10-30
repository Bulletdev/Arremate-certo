/*     */ package com.google.a.k;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.d;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.m.a;
/*     */ import com.google.b.a.a;
/*     */ import java.math.BigInteger;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.Iterator;
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
/*     */ public final class c
/*     */ {
/*     */   private static final double B = -2.147483648E9D;
/*     */   private static final double C = 2.147483647E9D;
/*     */   private static final double D = -9.223372036854776E18D;
/*     */   private static final double E = 9.223372036854776E18D;
/*     */   
/*     */   @com.google.a.a.c
/*     */   static double a(double paramDouble, RoundingMode paramRoundingMode) {
/*     */     double d;
/*  56 */     if (!d.e(paramDouble)) {
/*  57 */       throw new ArithmeticException("input is infinite or NaN");
/*     */     }
/*  59 */     switch (null.S[paramRoundingMode.ordinal()]) {
/*     */       case 1:
/*  61 */         h.af(d(paramDouble));
/*  62 */         return paramDouble;
/*     */       
/*     */       case 2:
/*  65 */         if (paramDouble >= 0.0D || d(paramDouble)) {
/*  66 */           return paramDouble;
/*     */         }
/*  68 */         return ((long)paramDouble - 1L);
/*     */ 
/*     */       
/*     */       case 3:
/*  72 */         if (paramDouble <= 0.0D || d(paramDouble)) {
/*  73 */           return paramDouble;
/*     */         }
/*  75 */         return ((long)paramDouble + 1L);
/*     */ 
/*     */       
/*     */       case 4:
/*  79 */         return paramDouble;
/*     */       
/*     */       case 5:
/*  82 */         if (d(paramDouble)) {
/*  83 */           return paramDouble;
/*     */         }
/*  85 */         return ((long)paramDouble + ((paramDouble > 0.0D) ? 1L : -1L));
/*     */ 
/*     */       
/*     */       case 6:
/*  89 */         return Math.rint(paramDouble);
/*     */ 
/*     */       
/*     */       case 7:
/*  93 */         d = Math.rint(paramDouble);
/*  94 */         if (Math.abs(paramDouble - d) == 0.5D) {
/*  95 */           return paramDouble + Math.copySign(0.5D, paramDouble);
/*     */         }
/*  97 */         return d;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 8:
/* 103 */         d = Math.rint(paramDouble);
/* 104 */         if (Math.abs(paramDouble - d) == 0.5D) {
/* 105 */           return paramDouble;
/*     */         }
/* 107 */         return d;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 112 */     throw new AssertionError();
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
/*     */   @com.google.a.a.c
/*     */   public static int a(double paramDouble, RoundingMode paramRoundingMode) {
/* 132 */     double d = a(paramDouble, paramRoundingMode);
/* 133 */     h.a(((d > -2.147483649E9D)) & ((d < 2.147483648E9D)), paramDouble, paramRoundingMode);
/*     */     
/* 135 */     return (int)d;
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
/*     */   @com.google.a.a.c
/*     */   public static long a(double paramDouble, RoundingMode paramRoundingMode) {
/* 157 */     double d = a(paramDouble, paramRoundingMode);
/* 158 */     h.a(((-9.223372036854776E18D - d < 1.0D)) & ((d < 9.223372036854776E18D)), paramDouble, paramRoundingMode);
/*     */     
/* 160 */     return (long)d;
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
/*     */   @com.google.a.a.c
/*     */   public static BigInteger b(double paramDouble, RoundingMode paramRoundingMode) {
/* 184 */     paramDouble = a(paramDouble, paramRoundingMode);
/* 185 */     if ((((-9.223372036854776E18D - paramDouble < 1.0D) ? 1 : 0) & ((paramDouble < 9.223372036854776E18D) ? 1 : 0)) != 0) {
/* 186 */       return BigInteger.valueOf((long)paramDouble);
/*     */     }
/* 188 */     int i = Math.getExponent(paramDouble);
/* 189 */     long l = d.a(paramDouble);
/* 190 */     BigInteger bigInteger = BigInteger.valueOf(l).shiftLeft(i - 52);
/* 191 */     return (paramDouble < 0.0D) ? bigInteger.negate() : bigInteger;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.c
/*     */   public static boolean c(double paramDouble) {
/* 200 */     if (paramDouble > 0.0D && d.e(paramDouble)) {
/* 201 */       long l = d.a(paramDouble);
/* 202 */       return ((l & l - 1L) == 0L);
/*     */     } 
/* 204 */     return false;
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
/*     */   public static double c(double paramDouble) {
/* 224 */     return Math.log(paramDouble) / A;
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
/*     */   @com.google.a.a.c
/*     */   public static int b(double paramDouble, RoundingMode paramRoundingMode) {
/*     */     int j;
/*     */     double d;
/* 239 */     D.a((paramDouble > 0.0D && d.e(paramDouble)), "x must be positive and finite");
/* 240 */     int i = Math.getExponent(paramDouble);
/* 241 */     if (!d.f(paramDouble)) {
/* 242 */       return b(paramDouble * 4.503599627370496E15D, paramRoundingMode) - 52;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 247 */     switch (null.S[paramRoundingMode.ordinal()]) {
/*     */       case 1:
/* 249 */         h.af(c(paramDouble));
/*     */       
/*     */       case 2:
/* 252 */         j = 0;
/*     */         break;
/*     */       case 3:
/* 255 */         j = !c(paramDouble) ? 1 : 0;
/*     */         break;
/*     */       case 4:
/* 258 */         j = ((i < 0) ? 1 : 0) & (!c(paramDouble) ? 1 : 0);
/*     */         break;
/*     */       case 5:
/* 261 */         j = ((i >= 0) ? 1 : 0) & (!c(paramDouble) ? 1 : 0);
/*     */         break;
/*     */       case 6:
/*     */       case 7:
/*     */       case 8:
/* 266 */         d = d.f(paramDouble);
/*     */ 
/*     */         
/* 269 */         j = (d * d > 2.0D) ? 1 : 0;
/*     */         break;
/*     */       default:
/* 272 */         throw new AssertionError();
/*     */     } 
/* 274 */     return (j != 0) ? (i + 1) : i;
/*     */   }
/*     */   
/* 277 */   private static final double A = Math.log(2.0D);
/*     */ 
/*     */   
/*     */   @d
/*     */   static final int fW = 170;
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.c
/*     */   public static boolean d(double paramDouble) {
/* 287 */     return (d.e(paramDouble) && (paramDouble == 0.0D || 52 - 
/*     */       
/* 289 */       Long.numberOfTrailingZeros(d.a(paramDouble)) <= Math.getExponent(paramDouble)));
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
/*     */   public static double factorial(int paramInt) {
/* 302 */     h.b("n", paramInt);
/* 303 */     if (paramInt > 170) {
/* 304 */       return Double.POSITIVE_INFINITY;
/*     */     }
/*     */ 
/*     */     
/* 308 */     double d = 1.0D;
/* 309 */     for (int i = 1 + (paramInt & 0xFFFFFFF0); i <= paramInt; i++) {
/* 310 */       d *= i;
/*     */     }
/* 312 */     return d * a[paramInt >> 4];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @d
/* 319 */   static final double[] a = new double[] { 1.0D, 2.0922789888E13D, 2.631308369336935E35D, 1.2413915592536073E61D, 1.2688693218588417E89D, 7.156945704626381E118D, 9.916779348709496E149D, 1.974506857221074E182D, 3.856204823625804E215D, 5.5502938327393044E249D, 4.7147236359920616E284D };
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
/*     */   public static boolean a(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 360 */     h.a("tolerance", paramDouble3);
/* 361 */     return (Math.copySign(paramDouble1 - paramDouble2, 1.0D) <= paramDouble3 || paramDouble1 == paramDouble2 || (
/*     */ 
/*     */       
/* 364 */       Double.isNaN(paramDouble1) && Double.isNaN(paramDouble2)));
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
/*     */   public static int a(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 381 */     if (a(paramDouble1, paramDouble2, paramDouble3))
/* 382 */       return 0; 
/* 383 */     if (paramDouble1 < paramDouble2)
/* 384 */       return -1; 
/* 385 */     if (paramDouble1 > paramDouble2) {
/* 386 */       return 1;
/*     */     }
/* 388 */     return a.compare(Double.isNaN(paramDouble1), Double.isNaN(paramDouble2));
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
/*     */   @Deprecated
/*     */   @com.google.a.a.c
/*     */   public static double a(double... paramVarArgs) {
/* 408 */     D.a((paramVarArgs.length > 0), "Cannot take mean of 0 values");
/* 409 */     long l = 1L;
/* 410 */     double d = d(paramVarArgs[0]);
/* 411 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 412 */       d(paramVarArgs[b]);
/* 413 */       l++;
/*     */       
/* 415 */       d += (paramVarArgs[b] - d) / l;
/*     */     } 
/* 417 */     return d;
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
/*     */   @Deprecated
/*     */   public static double a(int... paramVarArgs) {
/* 434 */     D.a((paramVarArgs.length > 0), "Cannot take mean of 0 values");
/*     */ 
/*     */ 
/*     */     
/* 438 */     long l = 0L;
/* 439 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/* 440 */       l += paramVarArgs[b];
/*     */     }
/* 442 */     return l / paramVarArgs.length;
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
/*     */   @Deprecated
/*     */   public static double a(long... paramVarArgs) {
/* 460 */     D.a((paramVarArgs.length > 0), "Cannot take mean of 0 values");
/* 461 */     long l = 1L;
/* 462 */     double d = paramVarArgs[0];
/* 463 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 464 */       l++;
/*     */       
/* 466 */       d += (paramVarArgs[b] - d) / l;
/*     */     } 
/* 468 */     return d;
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
/*     */   @Deprecated
/*     */   @com.google.a.a.c
/*     */   public static double a(Iterable<? extends Number> paramIterable) {
/* 488 */     return a(paramIterable.iterator());
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
/*     */   @Deprecated
/*     */   @com.google.a.a.c
/*     */   public static double a(Iterator<? extends Number> paramIterator) {
/* 508 */     D.a(paramIterator.hasNext(), "Cannot take mean of 0 values");
/* 509 */     long l = 1L;
/* 510 */     double d = d(((Number)paramIterator.next()).doubleValue());
/* 511 */     while (paramIterator.hasNext()) {
/* 512 */       double d1 = d(((Number)paramIterator.next()).doubleValue());
/* 513 */       l++;
/*     */       
/* 515 */       d += (d1 - d) / l;
/*     */     } 
/* 517 */     return d;
/*     */   }
/*     */   
/*     */   @com.google.a.a.c
/*     */   @a
/*     */   private static double d(double paramDouble) {
/* 523 */     D.checkArgument(d.e(paramDouble));
/* 524 */     return paramDouble;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\k\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */