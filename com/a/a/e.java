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
/*     */ public class e
/*     */   extends o
/*     */ {
/*  43 */   private static double[][] a = new double[4][];
/*     */   
/*     */   public e(f paramf, j paramj) {
/*  46 */     super(paramf, paramj);
/*     */   }
/*     */   
/*     */   protected void c(double[] paramArrayOfdouble) {
/*  50 */     double d1 = paramArrayOfdouble[paramArrayOfdouble.length - 1];
/*  51 */     double d2 = d1 * d1;
/*  52 */     double d3 = d2 * d1;
/*     */ 
/*     */ 
/*     */     
/*  56 */     for (byte b = 0; b < paramArrayOfdouble.length - 1; b++) {
/*  57 */       paramArrayOfdouble[b] = 0.5D * ((a[3][b] - a[0][b] + 3.0D * (a[1][b] - a[2][b])) * d3 + (2.0D * (a[0][b] + 2.0D * a[2][b]) - 5.0D * a[1][b] - a[3][b]) * d2 + (a[2][b] - a[0][b]) * d1) + a[1][b];
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int aA() {
/*  67 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(l paraml) {
/*  75 */     if (!this.a.isInRange(0, this.a.aE()))
/*  76 */       throw new IllegalArgumentException("Group iterator not in range"); 
/*  77 */     if (this.a.aI() < 4) {
/*  78 */       throw new IllegalArgumentException("Group iterator size < 4");
/*     */     }
/*  80 */     this.a.j(0, 0);
/*     */     
/*  82 */     for (byte b = 0; b < 4; b++) {
/*  83 */       a[b] = this.a.a(this.a.next()).b();
/*     */     }
/*  85 */     double[] arrayOfDouble = new double[paraml.aN() + 1];
/*  86 */     c(arrayOfDouble);
/*     */     
/*  88 */     if (this.bx) {
/*  89 */       paraml.d(arrayOfDouble);
/*     */     } else {
/*  91 */       paraml.e(arrayOfDouble);
/*     */     } 
/*  93 */     this.a.j(0, 0);
/*     */     
/*     */     while (true) {
/*  96 */       int i = this.a.aJ();
/*  97 */       int j = this.a.aK();
/*     */       
/*  99 */       for (byte b1 = 0; b1 < 4; b1++) {
/* 100 */         if (!this.a.hasNext())
/* 101 */           throw new IllegalArgumentException("Group iterator ended early"); 
/* 102 */         a[b1] = this.a.a(this.a.next()).b();
/*     */       } 
/*     */       
/* 105 */       this.a.j(i, j);
/* 106 */       this.a.next();
/*     */       
/* 108 */       c.a(this, 0.0D, 1.0D, paraml);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\a\e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */