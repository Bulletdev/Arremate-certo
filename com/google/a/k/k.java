/*     */ package com.google.a.k;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.m.d;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ @c
/*     */ public final class k
/*     */ {
/*     */   public static b a() {
/* 135 */     return a(2).a(1);
/*     */   }
/*     */ 
/*     */   
/*     */   public static a a() {
/* 140 */     return a(4);
/*     */   }
/*     */ 
/*     */   
/*     */   public static a b() {
/* 145 */     return a(100);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static a a(int paramInt) {
/* 155 */     return new a(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class a
/*     */   {
/*     */     private final int scale;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private a(int param1Int) {
/* 169 */       D.a((param1Int > 0), "Quantile scale must be positive");
/* 170 */       this.scale = param1Int;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public k.b a(int param1Int) {
/* 179 */       return new k.b(this.scale, param1Int);
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
/*     */     
/*     */     public k.c a(int... param1VarArgs) {
/* 192 */       return new k.c(this.scale, (int[])param1VarArgs.clone());
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
/*     */     
/*     */     public k.c a(Collection<Integer> param1Collection) {
/* 205 */       return new k.c(this.scale, com.google.a.m.k.a(param1Collection));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class b
/*     */   {
/*     */     private final int scale;
/*     */ 
/*     */     
/*     */     private final int index;
/*     */ 
/*     */ 
/*     */     
/*     */     private b(int param1Int1, int param1Int2) {
/* 221 */       k.i(param1Int2, param1Int1);
/* 222 */       this.scale = param1Int1;
/* 223 */       this.index = param1Int2;
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
/*     */     public double a(Collection<? extends Number> param1Collection) {
/* 235 */       return c(d.a(param1Collection));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double b(double... param1VarArgs) {
/* 246 */       return c((double[])param1VarArgs.clone());
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
/*     */     public double b(long... param1VarArgs) {
/* 258 */       return c(k.b(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double b(int... param1VarArgs) {
/* 269 */       return c(k.b(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double c(double... param1VarArgs) {
/* 280 */       D.a((param1VarArgs.length > 0), "Cannot calculate quantiles of an empty dataset");
/* 281 */       if (k.b(param1VarArgs)) {
/* 282 */         return Double.NaN;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 292 */       long l = this.index * (param1VarArgs.length - 1);
/*     */ 
/*     */ 
/*     */       
/* 296 */       int i = (int)g.a(l, this.scale, RoundingMode.DOWN);
/* 297 */       int j = (int)(l - i * this.scale);
/* 298 */       k.b(i, param1VarArgs, 0, param1VarArgs.length - 1);
/* 299 */       if (j == 0) {
/* 300 */         return param1VarArgs[i];
/*     */       }
/* 302 */       k.b(i + 1, param1VarArgs, i + 1, param1VarArgs.length - 1);
/* 303 */       return k.b(param1VarArgs[i], param1VarArgs[i + 1], j, this.scale);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class c
/*     */   {
/*     */     private final int scale;
/*     */ 
/*     */     
/*     */     private final int[] Z;
/*     */ 
/*     */ 
/*     */     
/*     */     private c(int param1Int, int[] param1ArrayOfint) {
/* 320 */       for (int i : param1ArrayOfint) {
/* 321 */         k.i(i, param1Int);
/*     */       }
/* 323 */       D.a((param1ArrayOfint.length > 0), "Indexes must be a non empty array");
/* 324 */       this.scale = param1Int;
/* 325 */       this.Z = param1ArrayOfint;
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
/*     */ 
/*     */ 
/*     */     
/*     */     public Map<Integer, Double> a(Collection<? extends Number> param1Collection) {
/* 340 */       return b(d.a(param1Collection));
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
/*     */ 
/*     */     
/*     */     public Map<Integer, Double> a(double... param1VarArgs) {
/* 354 */       return b((double[])param1VarArgs.clone());
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
/*     */ 
/*     */ 
/*     */     
/*     */     public Map<Integer, Double> a(long... param1VarArgs) {
/* 369 */       return b(k.b(param1VarArgs));
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
/*     */ 
/*     */     
/*     */     public Map<Integer, Double> a(int... param1VarArgs) {
/* 383 */       return b(k.b(param1VarArgs));
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
/*     */ 
/*     */     
/*     */     public Map<Integer, Double> b(double... param1VarArgs) {
/* 397 */       D.a((param1VarArgs.length > 0), "Cannot calculate quantiles of an empty dataset");
/* 398 */       if (k.b(param1VarArgs)) {
/* 399 */         LinkedHashMap<Object, Object> linkedHashMap1 = new LinkedHashMap<>();
/* 400 */         for (int i : this.Z) {
/* 401 */           linkedHashMap1.put(Integer.valueOf(i), Double.valueOf(Double.NaN));
/*     */         }
/* 403 */         return (Map)Collections.unmodifiableMap(linkedHashMap1);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 411 */       int[] arrayOfInt1 = new int[this.Z.length];
/* 412 */       int[] arrayOfInt2 = new int[this.Z.length];
/*     */       
/* 414 */       int[] arrayOfInt3 = new int[this.Z.length * 2];
/* 415 */       byte b1 = 0;
/* 416 */       for (byte b2 = 0; b2 < this.Z.length; b2++) {
/*     */ 
/*     */         
/* 419 */         long l = this.Z[b2] * (param1VarArgs.length - 1);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 424 */         int i = (int)g.a(l, this.scale, RoundingMode.DOWN);
/* 425 */         int j = (int)(l - i * this.scale);
/* 426 */         arrayOfInt1[b2] = i;
/* 427 */         arrayOfInt2[b2] = j;
/* 428 */         arrayOfInt3[b1] = i;
/* 429 */         b1++;
/* 430 */         if (j != 0) {
/* 431 */           arrayOfInt3[b1] = i + 1;
/* 432 */           b1++;
/*     */         } 
/*     */       } 
/* 435 */       Arrays.sort(arrayOfInt3, 0, b1);
/* 436 */       k.b(arrayOfInt3, 0, b1 - 1, param1VarArgs, 0, param1VarArgs.length - 1);
/*     */       
/* 438 */       LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/* 439 */       for (byte b3 = 0; b3 < this.Z.length; b3++) {
/* 440 */         int i = arrayOfInt1[b3];
/* 441 */         int j = arrayOfInt2[b3];
/* 442 */         if (j == 0) {
/* 443 */           linkedHashMap.put(Integer.valueOf(this.Z[b3]), Double.valueOf(param1VarArgs[i]));
/*     */         } else {
/* 445 */           linkedHashMap.put(
/* 446 */               Integer.valueOf(this.Z[b3]), Double.valueOf(k.b(param1VarArgs[i], param1VarArgs[i + 1], j, this.scale)));
/*     */         } 
/*     */       } 
/* 449 */       return (Map)Collections.unmodifiableMap(linkedHashMap);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean a(double... paramVarArgs) {
/* 455 */     for (double d : paramVarArgs) {
/* 456 */       if (Double.isNaN(d)) {
/* 457 */         return true;
/*     */       }
/*     */     } 
/* 460 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
/* 469 */     if (paramDouble1 == Double.NEGATIVE_INFINITY) {
/* 470 */       if (paramDouble2 == Double.POSITIVE_INFINITY)
/*     */       {
/* 472 */         return Double.NaN;
/*     */       }
/*     */       
/* 475 */       return Double.NEGATIVE_INFINITY;
/*     */     } 
/* 477 */     if (paramDouble2 == Double.POSITIVE_INFINITY)
/*     */     {
/* 479 */       return Double.POSITIVE_INFINITY;
/*     */     }
/* 481 */     return paramDouble1 + (paramDouble2 - paramDouble1) * paramDouble3 / paramDouble4;
/*     */   }
/*     */   
/*     */   private static void h(int paramInt1, int paramInt2) {
/* 485 */     if (paramInt1 < 0 || paramInt1 > paramInt2) {
/* 486 */       throw new IllegalArgumentException((new StringBuilder(70)).append("Quantile indexes must be between 0 and the scale, which is ").append(paramInt2).toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static double[] a(long[] paramArrayOflong) {
/* 492 */     int i = paramArrayOflong.length;
/* 493 */     double[] arrayOfDouble = new double[i];
/* 494 */     for (byte b = 0; b < i; b++) {
/* 495 */       arrayOfDouble[b] = paramArrayOflong[b];
/*     */     }
/* 497 */     return arrayOfDouble;
/*     */   }
/*     */   
/*     */   private static double[] a(int[] paramArrayOfint) {
/* 501 */     int i = paramArrayOfint.length;
/* 502 */     double[] arrayOfDouble = new double[i];
/* 503 */     for (byte b = 0; b < i; b++) {
/* 504 */       arrayOfDouble[b] = paramArrayOfint[b];
/*     */     }
/* 506 */     return arrayOfDouble;
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
/*     */ 
/*     */   
/*     */   private static void a(int paramInt1, double[] paramArrayOfdouble, int paramInt2, int paramInt3) {
/* 533 */     if (paramInt1 == paramInt2) {
/* 534 */       int i = paramInt2;
/* 535 */       for (int j = paramInt2 + 1; j <= paramInt3; j++) {
/* 536 */         if (paramArrayOfdouble[i] > paramArrayOfdouble[j]) {
/* 537 */           i = j;
/*     */         }
/*     */       } 
/* 540 */       if (i != paramInt2) {
/* 541 */         swap(paramArrayOfdouble, i, paramInt2);
/*     */       }
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 548 */     while (paramInt3 > paramInt2) {
/* 549 */       int i = a(paramArrayOfdouble, paramInt2, paramInt3);
/* 550 */       if (i >= paramInt1) {
/* 551 */         paramInt3 = i - 1;
/*     */       }
/* 553 */       if (i <= paramInt1) {
/* 554 */         paramInt2 = i + 1;
/*     */       }
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
/*     */   private static int a(double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
/* 569 */     a(paramArrayOfdouble, paramInt1, paramInt2);
/* 570 */     double d = paramArrayOfdouble[paramInt1];
/*     */ 
/*     */ 
/*     */     
/* 574 */     int i = paramInt2;
/* 575 */     for (int j = paramInt2; j > paramInt1; j--) {
/* 576 */       if (paramArrayOfdouble[j] > d) {
/* 577 */         swap(paramArrayOfdouble, i, j);
/* 578 */         i--;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 585 */     swap(paramArrayOfdouble, paramInt1, i);
/* 586 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
/* 596 */     int i = paramInt1 + paramInt2 >>> 1;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 601 */     boolean bool1 = (paramArrayOfdouble[paramInt2] < paramArrayOfdouble[i]) ? true : false;
/* 602 */     boolean bool2 = (paramArrayOfdouble[i] < paramArrayOfdouble[paramInt1]) ? true : false;
/* 603 */     boolean bool3 = (paramArrayOfdouble[paramInt2] < paramArrayOfdouble[paramInt1]) ? true : false;
/* 604 */     if (bool1 == bool2) {
/*     */       
/* 606 */       swap(paramArrayOfdouble, i, paramInt1);
/* 607 */     } else if (bool1 != bool3) {
/*     */       
/* 609 */       swap(paramArrayOfdouble, paramInt1, paramInt2);
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
/*     */   private static void a(int[] paramArrayOfint, int paramInt1, int paramInt2, double[] paramArrayOfdouble, int paramInt3, int paramInt4) {
/* 622 */     int i = a(paramArrayOfint, paramInt1, paramInt2, paramInt3, paramInt4);
/* 623 */     int j = paramArrayOfint[i];
/*     */ 
/*     */     
/* 626 */     a(j, paramArrayOfdouble, paramInt3, paramInt4);
/*     */ 
/*     */     
/* 629 */     int m = i - 1;
/* 630 */     while (m >= paramInt1 && paramArrayOfint[m] == j) {
/* 631 */       m--;
/*     */     }
/* 633 */     if (m >= paramInt1) {
/* 634 */       a(paramArrayOfint, paramInt1, m, paramArrayOfdouble, paramInt3, j - 1);
/*     */     }
/*     */ 
/*     */     
/* 638 */     int n = i + 1;
/* 639 */     while (n <= paramInt2 && paramArrayOfint[n] == j) {
/* 640 */       n++;
/*     */     }
/* 642 */     if (n <= paramInt2) {
/* 643 */       a(paramArrayOfint, n, paramInt2, paramArrayOfdouble, j + 1, paramInt4);
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
/*     */   private static int a(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 658 */     if (paramInt1 == paramInt2) {
/* 659 */       return paramInt1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 664 */     int i = paramInt3 + paramInt4 >>> 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 671 */     int j = paramInt1;
/* 672 */     int m = paramInt2;
/* 673 */     while (m > j + 1) {
/* 674 */       int n = j + m >>> 1;
/* 675 */       if (paramArrayOfint[n] > i) {
/* 676 */         m = n; continue;
/* 677 */       }  if (paramArrayOfint[n] < i) {
/* 678 */         j = n; continue;
/*     */       } 
/* 680 */       return n;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 685 */     if (paramInt3 + paramInt4 - paramArrayOfint[j] - paramArrayOfint[m] > 0) {
/* 686 */       return m;
/*     */     }
/* 688 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void swap(double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
/* 694 */     double d = paramArrayOfdouble[paramInt1];
/* 695 */     paramArrayOfdouble[paramInt1] = paramArrayOfdouble[paramInt2];
/* 696 */     paramArrayOfdouble[paramInt2] = d;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\k\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */