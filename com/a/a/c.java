/*     */ package com.a.a;
/*     */ 
/*     */ import com.a.b.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class c
/*     */ {
/*     */   public static void a(o paramo, double paramDouble1, double paramDouble2, l paraml) {
/*  90 */     if (paramDouble1 > paramDouble2) {
/*  91 */       throw new IllegalArgumentException("t_min <= t_max required.");
/*     */     }
/*  93 */     int i = paraml.aN();
/*     */     
/*  95 */     double d1 = paramDouble1;
/*  96 */     double d2 = paramDouble2;
/*  97 */     double[][] arrayOfDouble1 = new double[10][];
/*  98 */     byte b = 0;
/*     */     
/* 100 */     double[] arrayOfDouble2 = new double[i + 1];
/* 101 */     arrayOfDouble2[i] = d1;
/* 102 */     paramo.c(arrayOfDouble2);
/*     */     
/* 104 */     double[] arrayOfDouble3 = new double[i + 1];
/* 105 */     arrayOfDouble3[i] = d2;
/* 106 */     paramo.c(arrayOfDouble3);
/*     */     
/* 108 */     arrayOfDouble1[b++] = arrayOfDouble3;
/*     */     
/* 110 */     double[][] arrayOfDouble4 = new double[paramo.aA()][];
/* 111 */     double d3 = paraml.S() * paraml.S();
/*     */     
/* 113 */     double[] arrayOfDouble5 = new double[i + 1];
/*     */     
/*     */     while (true) {
/* 116 */       double d4 = (d1 + d2) / 2.0D;
/*     */       
/* 118 */       double[] arrayOfDouble = new double[i + 1];
/* 119 */       arrayOfDouble[i] = d4;
/* 120 */       paramo.c(arrayOfDouble);
/*     */       
/* 122 */       double d5 = a.b(arrayOfDouble2, arrayOfDouble1[b - 1], arrayOfDouble, arrayOfDouble5, i);
/*     */ 
/*     */       
/* 125 */       if (Double.isNaN(d5) || Double.isInfinite(d5)) {
/*     */         
/* 127 */         String str = "NaN or infinity resulted from calling the eval method of the " + paramo.getClass().getName() + " class.";
/* 128 */         throw new RuntimeException(str);
/*     */       } 
/*     */       
/* 131 */       boolean bool = false;
/*     */       
/* 133 */       if (d5 < d3) {
/* 134 */         byte b1 = 0;
/* 135 */         double d = 0.0D;
/*     */         
/* 137 */         for (; b1 < arrayOfDouble4.length; b1++) {
/* 138 */           d = (d1 + d4) / 2.0D;
/*     */           
/* 140 */           double[] arrayOfDouble6 = new double[i + 1];
/* 141 */           arrayOfDouble4[b1] = arrayOfDouble6;
/* 142 */           arrayOfDouble6[i] = d;
/* 143 */           paramo.c(arrayOfDouble6);
/*     */           
/* 145 */           if (a.b(arrayOfDouble2, arrayOfDouble, arrayOfDouble6, arrayOfDouble5, i) >= d3) {
/*     */             break;
/*     */           }
/* 148 */           d4 = d;
/*     */         } 
/*     */         
/* 151 */         if (b1 == arrayOfDouble4.length) {
/* 152 */           bool = true;
/*     */         } else {
/* 154 */           arrayOfDouble1 = a(arrayOfDouble1, b);
/* 155 */           arrayOfDouble1[b++] = arrayOfDouble;
/*     */           
/* 157 */           for (byte b2 = 0; b2 <= b1; b2++) {
/* 158 */             arrayOfDouble1 = a(arrayOfDouble1, b);
/* 159 */             arrayOfDouble1[b++] = arrayOfDouble4[b2];
/*     */           } 
/* 161 */           d2 = d;
/*     */         } 
/*     */       } 
/*     */       
/* 165 */       if (bool) {
/* 166 */         paraml.d(arrayOfDouble2);
/* 167 */         paraml.d(arrayOfDouble);
/* 168 */         arrayOfDouble2 = arrayOfDouble1[--b];
/*     */         
/* 170 */         if (b == 0)
/*     */           break; 
/* 172 */         arrayOfDouble = arrayOfDouble1[b - 1];
/* 173 */         d1 = d2;
/* 174 */         d2 = arrayOfDouble[i]; continue;
/*     */       } 
/* 176 */       if (d2 > d4) {
/* 177 */         arrayOfDouble1 = a(arrayOfDouble1, b);
/* 178 */         arrayOfDouble1[b++] = arrayOfDouble;
/* 179 */         d2 = d4;
/*     */       } 
/*     */     } 
/*     */     
/* 183 */     paraml.d(arrayOfDouble2);
/*     */   }
/*     */   
/*     */   private static double[][] a(double[][] paramArrayOfdouble, int paramInt) {
/* 187 */     if (paramInt == paramArrayOfdouble.length) {
/* 188 */       double[][] arrayOfDouble = new double[2 * paramInt][];
/* 189 */       for (byte b = 0; b < paramInt; b++)
/* 190 */         arrayOfDouble[b] = paramArrayOfdouble[b]; 
/* 191 */       return arrayOfDouble;
/*     */     } 
/* 193 */     return paramArrayOfdouble;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\a\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */