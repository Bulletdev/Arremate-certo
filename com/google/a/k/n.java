/*     */ package com.google.a.k;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import java.math.RoundingMode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ abstract class n<X extends Number & Comparable<X>>
/*     */ {
/*     */   abstract double a(X paramX);
/*     */   
/*     */   abstract int a(X paramX);
/*     */   
/*     */   abstract X a(double paramDouble, RoundingMode paramRoundingMode);
/*     */   
/*     */   abstract X a(X paramX1, X paramX2);
/*     */   
/*     */   final double a(X paramX, RoundingMode paramRoundingMode) {
/*     */     X x2;
/*     */     double d2;
/*     */     X x3;
/*     */     double d3;
/*     */     X x4, x5;
/*     */     int j;
/*  46 */     D.b(paramX, "x");
/*  47 */     D.b(paramRoundingMode, "mode");
/*  48 */     double d1 = a(paramX);
/*  49 */     if (Double.isInfinite(d1)) {
/*  50 */       String str; switch (null.S[paramRoundingMode.ordinal()]) {
/*     */         case 1:
/*     */         case 2:
/*     */         case 3:
/*     */         case 4:
/*  55 */           return Double.MAX_VALUE * a(paramX);
/*     */         case 5:
/*  57 */           return (d1 == Double.POSITIVE_INFINITY) ? 
/*  58 */             Double.MAX_VALUE : 
/*  59 */             Double.NEGATIVE_INFINITY;
/*     */         case 6:
/*  61 */           return (d1 == Double.POSITIVE_INFINITY) ? 
/*  62 */             Double.POSITIVE_INFINITY : 
/*  63 */             -1.7976931348623157E308D;
/*     */         case 7:
/*  65 */           return d1;
/*     */         case 8:
/*  67 */           str = String.valueOf(paramX); throw new ArithmeticException((new StringBuilder(44 + String.valueOf(str).length())).append(str).append(" cannot be represented precisely as a double").toString());
/*     */       } 
/*     */     } 
/*  70 */     X x1 = a(d1, RoundingMode.UNNECESSARY);
/*  71 */     int i = ((Comparable<X>)paramX).compareTo(x1);
/*  72 */     switch (null.S[paramRoundingMode.ordinal()]) {
/*     */       case 8:
/*  74 */         h.af((i == 0));
/*  75 */         return d1;
/*     */       case 5:
/*  77 */         return (i >= 0) ? 
/*  78 */           d1 : 
/*  79 */           d.e(d1);
/*     */       case 6:
/*  81 */         return (i <= 0) ? d1 : Math.nextUp(d1);
/*     */       case 1:
/*  83 */         if (a(paramX) >= 0) {
/*  84 */           return (i >= 0) ? 
/*  85 */             d1 : 
/*  86 */             d.e(d1);
/*     */         }
/*  88 */         return (i <= 0) ? d1 : Math.nextUp(d1);
/*     */       
/*     */       case 7:
/*  91 */         if (a(paramX) >= 0) {
/*  92 */           return (i <= 0) ? d1 : Math.nextUp(d1);
/*     */         }
/*  94 */         return (i >= 0) ? 
/*  95 */           d1 : 
/*  96 */           d.e(d1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/* 107 */         if (i >= 0) {
/* 108 */           d2 = d1;
/* 109 */           X x6 = x1;
/* 110 */           d3 = Math.nextUp(d1);
/* 111 */           if (d3 == Double.POSITIVE_INFINITY) {
/* 112 */             return d2;
/*     */           }
/* 114 */           X x7 = a(d3, RoundingMode.CEILING);
/*     */         } else {
/* 116 */           d3 = d1;
/* 117 */           x3 = x1;
/* 118 */           d2 = d.e(d1);
/* 119 */           if (d2 == Double.NEGATIVE_INFINITY) {
/* 120 */             return d3;
/*     */           }
/* 122 */           x2 = a(d2, RoundingMode.FLOOR);
/*     */         } 
/*     */         
/* 125 */         x4 = a(paramX, x2);
/* 126 */         x5 = a(x3, paramX);
/* 127 */         j = ((Comparable<X>)x4).compareTo(x5);
/* 128 */         if (j < 0)
/* 129 */           return d2; 
/* 130 */         if (j > 0) {
/* 131 */           return d3;
/*     */         }
/*     */         
/* 134 */         switch (null.S[paramRoundingMode.ordinal()]) {
/*     */ 
/*     */           
/*     */           case 2:
/* 138 */             return ((Double.doubleToRawLongBits(d2) & 0x1L) == 0L) ? 
/* 139 */               d2 : 
/* 140 */               d3;
/*     */           case 3:
/* 142 */             return (a(paramX) >= 0) ? d2 : d3;
/*     */           case 4:
/* 144 */             return (a(paramX) >= 0) ? d3 : d2;
/*     */         } 
/* 146 */         throw new AssertionError("impossible");
/*     */     } 
/*     */ 
/*     */     
/* 150 */     throw new AssertionError("impossible");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\k\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */