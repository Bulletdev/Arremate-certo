/*     */ package org.apache.poi.ss.format;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SimpleFraction
/*     */ {
/*     */   private final int denominator;
/*     */   private final int numerator;
/*     */   
/*     */   public static SimpleFraction buildFractionExactDenominator(double paramDouble, int paramInt) {
/*  35 */     int i = (int)Math.round(paramDouble * paramInt);
/*  36 */     return new SimpleFraction(i, paramInt);
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
/*     */   public static SimpleFraction buildFractionMaxDenominator(double paramDouble, int paramInt) {
/*  51 */     return buildFractionMaxDenominator(paramDouble, 0.0D, paramInt, 100);
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
/*     */   private static SimpleFraction buildFractionMaxDenominator(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2) {
/*  78 */     long l7, l8, l1 = 2147483647L;
/*  79 */     double d = paramDouble1;
/*  80 */     long l2 = (long)Math.floor(d);
/*  81 */     if (l2 > l1) {
/*  82 */       throw new IllegalArgumentException("Overflow trying to convert " + paramDouble1 + " to fraction (" + l2 + "/" + 1L + ")");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  87 */     if (Math.abs(l2 - paramDouble1) < paramDouble2) {
/*  88 */       return new SimpleFraction((int)l2, 1);
/*     */     }
/*     */     
/*  91 */     long l3 = 1L;
/*  92 */     long l4 = 0L;
/*  93 */     long l5 = l2;
/*  94 */     long l6 = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  99 */     byte b = 0;
/* 100 */     boolean bool = false;
/*     */     do {
/* 102 */       b++;
/* 103 */       double d1 = 1.0D / (d - l2);
/* 104 */       long l = (long)Math.floor(d1);
/* 105 */       l7 = l * l5 + l3;
/* 106 */       l8 = l * l6 + l4;
/*     */       
/* 108 */       if (paramDouble2 == 0.0D && paramInt1 > 0 && Math.abs(l8) > paramInt1 && Math.abs(l6) < paramInt1)
/*     */       {
/*     */         
/* 111 */         return new SimpleFraction((int)l5, (int)l6);
/*     */       }
/* 113 */       if (l7 > l1 || l8 > l1) {
/* 114 */         throw new RuntimeException("Overflow trying to convert " + paramDouble1 + " to fraction (" + l7 + "/" + l8 + ")");
/*     */       }
/*     */       
/* 117 */       double d2 = l7 / l8;
/* 118 */       if (b < paramInt2 && Math.abs(d2 - paramDouble1) > paramDouble2 && l8 < paramInt1) {
/* 119 */         l3 = l5;
/* 120 */         l5 = l7;
/* 121 */         l4 = l6;
/* 122 */         l6 = l8;
/* 123 */         l2 = l;
/* 124 */         d = d1;
/*     */       } else {
/* 126 */         bool = true;
/*     */       } 
/* 128 */     } while (!bool);
/*     */     
/* 130 */     if (b >= paramInt2) {
/* 131 */       throw new RuntimeException("Unable to convert " + paramDouble1 + " to fraction after " + paramInt2 + " iterations");
/*     */     }
/*     */     
/* 134 */     if (l8 < paramInt1) {
/* 135 */       return new SimpleFraction((int)l7, (int)l8);
/*     */     }
/* 137 */     return new SimpleFraction((int)l5, (int)l6);
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
/*     */   public SimpleFraction(int paramInt1, int paramInt2) {
/* 149 */     this.numerator = paramInt1;
/* 150 */     this.denominator = paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDenominator() {
/* 158 */     return this.denominator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getNumerator() {
/* 166 */     return this.numerator;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\format\SimpleFraction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */