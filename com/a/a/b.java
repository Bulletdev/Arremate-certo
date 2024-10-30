/*     */ package com.a.a;
/*     */ 
/*     */ import com.a.c.j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends o
/*     */ {
/*  58 */   private static double[] d = new double[0];
/*     */   
/*  60 */   private double T = 0.0D;
/*  61 */   private double U = 1.0D;
/*  62 */   private int gA = 1;
/*     */   
/*     */   public b(f paramf, j paramj) {
/*  65 */     super(paramf, paramj);
/*     */   }
/*     */   
/*     */   public void c(double[] paramArrayOfdouble) {
/*  69 */     double d1 = paramArrayOfdouble[paramArrayOfdouble.length - 1];
/*     */     
/*  71 */     int i = this.a.aI();
/*     */     
/*  73 */     if (i > d.length) {
/*  74 */       d = new double[2 * i];
/*     */     }
/*  76 */     d[i - 1] = 1.0D;
/*  77 */     double d2 = 1.0D;
/*  78 */     double d3 = 1.0D - d1;
/*     */     int j;
/*  80 */     for (j = i - 2; j >= 0; j--) {
/*  81 */       d[j] = d[j + 1] * d3;
/*     */     }
/*  83 */     this.a.j(0, 0);
/*     */     
/*  85 */     j = 0;
/*     */     
/*  87 */     while (j < i) {
/*  88 */       double d = j.a(i - 1, j);
/*     */       
/*  90 */       if (!Double.isInfinite(d) && !Double.isNaN(d)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  96 */         double d4 = d[j] * d2 * d;
/*  97 */         double[] arrayOfDouble = this.a.a(this.a.next()).b();
/*     */         
/*  99 */         for (byte b1 = 0; b1 < paramArrayOfdouble.length - 1; b1++) {
/* 100 */           paramArrayOfdouble[b1] = paramArrayOfdouble[b1] + arrayOfDouble[b1] * d4;
/*     */         }
/*     */       } 
/* 103 */       d2 *= d1;
/* 104 */       j++;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int aA() {
/* 109 */     return this.gA;
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
/*     */   public void aH(int paramInt) {
/* 121 */     if (paramInt < 0) {
/* 122 */       throw new IllegalArgumentException("Sample-limit >= 0 required.");
/*     */     }
/* 124 */     this.gA = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void c(double paramDouble1, double paramDouble2) {
/* 135 */     if (paramDouble1 > paramDouble2) {
/* 136 */       throw new IllegalArgumentException("t_min <= t_max required.");
/*     */     }
/* 138 */     this.T = paramDouble1;
/* 139 */     this.U = paramDouble2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double P() {
/* 149 */     return this.T;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double Q() {
/* 159 */     return this.U;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(l paraml) {
/* 166 */     if (!this.a.isInRange(0, this.a.aE())) {
/* 167 */       throw new IllegalArgumentException("group iterator not in range");
/*     */     }
/* 169 */     int i = paraml.aN();
/*     */     
/* 171 */     double[] arrayOfDouble = new double[i + 1];
/* 172 */     arrayOfDouble[i] = this.T;
/* 173 */     c(arrayOfDouble);
/*     */     
/* 175 */     if (this.bx) {
/* 176 */       paraml.d(arrayOfDouble);
/*     */     } else {
/* 178 */       paraml.e(arrayOfDouble);
/*     */     } 
/* 180 */     c.a(this, this.T, this.U, paraml);
/*     */   }
/*     */   
/*     */   public void go() {
/* 184 */     if (d.length > 0)
/* 185 */       d = new double[0]; 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\a\b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */