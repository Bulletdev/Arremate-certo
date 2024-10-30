/*     */ package org.apache.poi.ss.formula.functions;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class StatsLib
/*     */ {
/*     */   public static double avedev(double[] paramArrayOfdouble) {
/*  39 */     double d1 = 0.0D;
/*  40 */     double d2 = 0.0D;
/*  41 */     double d3 = 0.0D; byte b; int i;
/*  42 */     for (b = 0, i = paramArrayOfdouble.length; b < i; b++) {
/*  43 */       d3 += paramArrayOfdouble[b];
/*     */     }
/*  45 */     d2 = d3 / paramArrayOfdouble.length;
/*  46 */     d3 = 0.0D;
/*  47 */     for (b = 0, i = paramArrayOfdouble.length; b < i; b++) {
/*  48 */       d3 += Math.abs(paramArrayOfdouble[b] - d2);
/*     */     }
/*  50 */     d1 = d3 / paramArrayOfdouble.length;
/*  51 */     return d1;
/*     */   }
/*     */   
/*     */   public static double stdev(double[] paramArrayOfdouble) {
/*  55 */     double d = Double.NaN;
/*  56 */     if (paramArrayOfdouble != null && paramArrayOfdouble.length > 1) {
/*  57 */       d = Math.sqrt(devsq(paramArrayOfdouble) / (paramArrayOfdouble.length - 1));
/*     */     }
/*  59 */     return d;
/*     */   }
/*     */   
/*     */   public static double var(double[] paramArrayOfdouble) {
/*  63 */     double d = Double.NaN;
/*  64 */     if (paramArrayOfdouble != null && paramArrayOfdouble.length > 1) {
/*  65 */       d = devsq(paramArrayOfdouble) / (paramArrayOfdouble.length - 1);
/*     */     }
/*  67 */     return d;
/*     */   }
/*     */   
/*     */   public static double varp(double[] paramArrayOfdouble) {
/*  71 */     double d = Double.NaN;
/*  72 */     if (paramArrayOfdouble != null && paramArrayOfdouble.length > 1) {
/*  73 */       d = devsq(paramArrayOfdouble) / paramArrayOfdouble.length;
/*     */     }
/*  75 */     return d;
/*     */   }
/*     */   
/*     */   public static double median(double[] paramArrayOfdouble) {
/*  79 */     double d = Double.NaN;
/*     */     
/*  81 */     if (paramArrayOfdouble != null && paramArrayOfdouble.length >= 1) {
/*  82 */       int i = paramArrayOfdouble.length;
/*  83 */       Arrays.sort(paramArrayOfdouble);
/*  84 */       d = (i % 2 == 0) ? ((paramArrayOfdouble[i / 2] + paramArrayOfdouble[i / 2 - 1]) / 2.0D) : paramArrayOfdouble[i / 2];
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  89 */     return d;
/*     */   }
/*     */ 
/*     */   
/*     */   public static double devsq(double[] paramArrayOfdouble) {
/*  94 */     double d = Double.NaN;
/*  95 */     if (paramArrayOfdouble != null && paramArrayOfdouble.length >= 1) {
/*  96 */       double d1 = 0.0D;
/*  97 */       double d2 = 0.0D;
/*  98 */       int i = paramArrayOfdouble.length; byte b;
/*  99 */       for (b = 0; b < i; b++) {
/* 100 */         d2 += paramArrayOfdouble[b];
/*     */       }
/* 102 */       d1 = d2 / i;
/* 103 */       d2 = 0.0D;
/* 104 */       for (b = 0; b < i; b++) {
/* 105 */         d2 += (paramArrayOfdouble[b] - d1) * (paramArrayOfdouble[b] - d1);
/*     */       }
/*     */       
/* 108 */       d = (i == 1) ? 0.0D : d2;
/*     */     } 
/*     */ 
/*     */     
/* 112 */     return d;
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
/*     */   public static double kthLargest(double[] paramArrayOfdouble, int paramInt) {
/* 124 */     double d = Double.NaN;
/* 125 */     int i = paramInt - 1;
/* 126 */     if (paramArrayOfdouble != null && paramArrayOfdouble.length > i && i >= 0) {
/* 127 */       Arrays.sort(paramArrayOfdouble);
/* 128 */       d = paramArrayOfdouble[paramArrayOfdouble.length - i - 1];
/*     */     } 
/* 130 */     return d;
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
/*     */   public static double kthSmallest(double[] paramArrayOfdouble, int paramInt) {
/* 144 */     double d = Double.NaN;
/* 145 */     int i = paramInt - 1;
/* 146 */     if (paramArrayOfdouble != null && paramArrayOfdouble.length > i && i >= 0) {
/* 147 */       Arrays.sort(paramArrayOfdouble);
/* 148 */       d = paramArrayOfdouble[i];
/*     */     } 
/* 150 */     return d;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\StatsLib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */