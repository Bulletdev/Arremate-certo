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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class m
/*     */   extends a
/*     */ {
/*  53 */   private static double[] f = new double[0];
/*  54 */   private static double[] g = new double[0];
/*     */   
/*  56 */   private t b = new t(new double[] { 1.0D, 1.0D, 1.0D, 1.0D }, 4);
/*     */   private boolean bA = true;
/*     */   
/*     */   public m(f paramf, j paramj) {
/*  60 */     super(paramf, paramj);
/*     */   }
/*     */   
/*     */   protected void c(double[] paramArrayOfdouble) {
/*  64 */     int i = paramArrayOfdouble.length - 1;
/*  65 */     double d1 = paramArrayOfdouble[i];
/*  66 */     double d2 = 0.0D;
/*     */     
/*  68 */     int j = this.a.aI();
/*     */     byte b;
/*  70 */     for (b = 0; b < j; b++) {
/*  71 */       f[b] = b(d1, b) * g[b];
/*  72 */       d2 += f[b];
/*     */     } 
/*     */     
/*  75 */     if (d2 == 0.0D) d2 = 1.0D;
/*     */     
/*  77 */     for (b = 0; b < i; b++) {
/*  78 */       double d = 0.0D;
/*  79 */       this.a.j(0, 0);
/*     */       
/*  81 */       for (byte b1 = 0; b1 < j; b1++) {
/*  82 */         d += f[b1] * this.a.a(this.a.next()).b()[b];
/*     */       }
/*  84 */       paramArrayOfdouble[b] = d / d2;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public t b() {
/*  94 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void b(t paramt) {
/* 104 */     if (paramt == null) {
/* 105 */       throw new IllegalArgumentException("Weight-vector cannot be null.");
/*     */     }
/* 107 */     this.b = paramt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean dO() {
/* 116 */     return this.bA;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void am(boolean paramBoolean) {
/* 126 */     this.bA = paramBoolean;
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
/*     */   public void a(l paraml) {
/* 138 */     if (!this.a.isInRange(0, this.a.aE()))
/* 139 */       throw new IllegalArgumentException("Group iterator not in range"); 
/* 140 */     int i = this.a.aI();
/*     */     
/* 142 */     if (f.length < i) {
/* 143 */       f = new double[2 * i];
/* 144 */       g = new double[2 * i];
/*     */     } 
/*     */     
/* 147 */     if (this.bA) {
/* 148 */       if (this.b.size() != i) {
/* 149 */         throw new IllegalArgumentException("weightVector.size(" + this.b.size() + ") != group iterator size(" + i + ")");
/*     */       }
/* 151 */       for (byte b = 0; b < i; b++) {
/* 152 */         g[b] = this.b.a(b);
/* 153 */         if (g[b] < 0.0D) {
/* 154 */           throw new IllegalArgumentException("Negative weight not allowed");
/*     */         }
/*     */       } 
/*     */     } else {
/* 158 */       for (byte b = 0; b < i; b++) {
/* 159 */         g[b] = 1.0D;
/*     */       }
/*     */     } 
/* 162 */     super.a(paraml);
/*     */   }
/*     */   
/*     */   public void go() {
/* 166 */     super.go();
/* 167 */     if (f.length > 0) {
/* 168 */       f = new double[0];
/* 169 */       g = new double[0];
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\a\m.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */