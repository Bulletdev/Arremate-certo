/*     */ package com.a.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class d
/*     */   extends o
/*     */ {
/*  49 */   private static double[][] a = new double[4][];
/*     */   
/*  51 */   private double V = 0.5D;
/*     */   
/*     */   public d(f paramf, j paramj) {
/*  54 */     super(paramf, paramj);
/*     */   }
/*     */   
/*     */   protected void c(double[] paramArrayOfdouble) {
/*  58 */     double d1 = paramArrayOfdouble[paramArrayOfdouble.length - 1];
/*  59 */     double d2 = d1 * d1;
/*  60 */     double d3 = d2 * d1;
/*     */     
/*  62 */     double d4 = 2.0D * d3 - 3.0D * d2 + 1.0D;
/*  63 */     double d5 = -2.0D * d3 + 3.0D * d2;
/*  64 */     double d6 = this.V * (d3 - 2.0D * d2 + d1);
/*  65 */     double d7 = this.V * (d3 - d2);
/*     */     
/*  67 */     for (byte b = 0; b < paramArrayOfdouble.length - 1; b++) {
/*  68 */       paramArrayOfdouble[b] = d4 * a[1][b] + d5 * a[2][b] + d6 * (a[2][b] - a[0][b]) + d7 * (a[3][b] - a[1][b]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double R() {
/*  77 */     return this.V;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlpha(double paramDouble) {
/*  86 */     this.V = paramDouble;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int aA() {
/*  93 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(l paraml) {
/* 101 */     if (!this.a.isInRange(0, this.a.aE()))
/* 102 */       throw new IllegalArgumentException("group iterator not in range"); 
/* 103 */     if (this.a.aI() < 4) {
/* 104 */       throw new IllegalArgumentException("more than 4 groups required");
/*     */     }
/* 106 */     this.a.j(0, 0);
/*     */     
/* 108 */     for (byte b = 0; b < 4; b++) {
/* 109 */       a[b] = this.a.a(this.a.next()).b();
/*     */     }
/* 111 */     double[] arrayOfDouble = new double[paraml.aN() + 1];
/* 112 */     c(arrayOfDouble);
/*     */     
/* 114 */     if (this.bx) {
/* 115 */       paraml.d(arrayOfDouble);
/*     */     } else {
/* 117 */       paraml.e(arrayOfDouble);
/*     */     } 
/* 119 */     this.a.j(0, 0);
/*     */     
/*     */     while (true) {
/* 122 */       int i = this.a.aJ();
/* 123 */       int j = this.a.aK();
/*     */       
/* 125 */       for (byte b1 = 0; b1 < 4; b1++) {
/* 126 */         if (!this.a.hasNext())
/* 127 */           throw new IllegalArgumentException("Group iterator ended early"); 
/* 128 */         a[b1] = this.a.a(this.a.next()).b();
/*     */       } 
/*     */       
/* 131 */       this.a.j(i, j);
/* 132 */       this.a.next();
/*     */       
/* 134 */       c.a(this, 0.0D, 1.0D, paraml);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\a\d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */