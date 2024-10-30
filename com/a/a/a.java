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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends o
/*     */ {
/*     */   public static final int gx = 0;
/*     */   public static final int gy = 1;
/*     */   public static final int gz = 2;
/*  81 */   private static int[] af = new int[0];
/*  82 */   private static int[] D = new int[0];
/*  83 */   private static double[] c = new double[0];
/*     */   
/*  85 */   private t a = new t(new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D, 1.0D }, 8);
/*  86 */   private double T = 0.0D;
/*  87 */   private double U = 1.0D;
/*  88 */   private int gA = 1;
/*  89 */   private int gB = 4;
/*  90 */   private int gC = 0;
/*     */   private boolean bv = true;
/*     */   
/*     */   public a(f paramf, j paramj) {
/*  94 */     super(paramf, paramj);
/*     */   }
/*     */   
/*     */   protected void c(double[] paramArrayOfdouble) {
/*  98 */     int i = paramArrayOfdouble.length - 1;
/*  99 */     double d = paramArrayOfdouble[i];
/* 100 */     int j = this.a.aI();
/* 101 */     this.a.j(0, 0);
/*     */     
/* 103 */     for (byte b = 0; b < j; b++) {
/* 104 */       double d1 = b(d, b);
/*     */ 
/*     */       
/* 107 */       double[] arrayOfDouble = this.a.a(this.a.next()).b();
/*     */       
/* 109 */       for (byte b1 = 0; b1 < i; b1++) {
/* 110 */         paramArrayOfdouble[b1] = paramArrayOfdouble[b1] + arrayOfDouble[b1] * d1;
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
/*     */   public void c(double paramDouble1, double paramDouble2) {
/* 124 */     if (paramDouble1 > paramDouble2) {
/* 125 */       throw new IllegalArgumentException("t_min <= t_max required.");
/*     */     }
/* 127 */     this.T = paramDouble1;
/* 128 */     this.U = paramDouble2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double P() {
/* 138 */     return this.T;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double Q() {
/* 148 */     return this.U;
/*     */   }
/*     */   
/*     */   public int aA() {
/* 152 */     return this.gA;
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
/* 164 */     if (paramInt < 0) {
/* 165 */       throw new IllegalArgumentException("Sample-limit >= 0 required.");
/*     */     }
/* 167 */     this.gA = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int aB() {
/* 176 */     return this.gB - 1;
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
/*     */   public void aI(int paramInt) {
/* 190 */     if (paramInt <= 0) {
/* 191 */       throw new IllegalArgumentException("Degree > 0 required.");
/*     */     }
/* 193 */     this.gB = paramInt + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public t a() {
/* 202 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(t paramt) {
/* 213 */     if (paramt == null)
/* 214 */       throw new IllegalArgumentException("Knot-vector cannot be null."); 
/* 215 */     this.a = paramt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean dJ() {
/* 224 */     return this.bv;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ah(boolean paramBoolean) {
/* 235 */     this.bv = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int aC() {
/* 244 */     return this.gC;
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
/*     */   public void aJ(int paramInt) {
/* 256 */     if (paramInt < 0 || paramInt > 2) {
/* 257 */       throw new IllegalArgumentException("Unknown knot-vector type.");
/*     */     }
/* 259 */     this.gC = paramInt;
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
/*     */   public void a(l paraml) {
/* 275 */     if (!this.a.isInRange(0, this.a.aE())) {
/* 276 */       throw new IllegalArgumentException("Group iterator not in range");
/*     */     }
/* 278 */     int i = this.a.aI();
/* 279 */     int j = i - this.gB;
/* 280 */     if (j < 0) {
/* 281 */       throw new IllegalArgumentException("group iterator size - degree < 0");
/*     */     }
/* 283 */     int k = i + this.gB;
/*     */     
/* 285 */     if (c.length < k) {
/* 286 */       c = new double[2 * k];
/*     */     }
/* 288 */     double d1 = this.T;
/* 289 */     double d2 = this.U;
/*     */     
/* 291 */     if (this.gC == 2) {
/* 292 */       if (this.a.size() != k) {
/* 293 */         throw new IllegalArgumentException("knotVector.size(" + this.a.size() + ") != " + k);
/*     */       }
/* 295 */       c[0] = this.a.a(0);
/*     */       
/* 297 */       for (byte b = 1; b < k; b++) {
/* 298 */         c[b] = this.a.a(b);
/* 299 */         if (c[b] < c[b - 1]) {
/* 300 */           throw new IllegalArgumentException("Knot not in sorted order! (knot[" + b + "] < knot[" + b + "-1])");
/*     */         }
/*     */       } 
/* 303 */     } else if (this.gC == 1) {
/*     */       
/* 305 */       double d = 1.0D / (k - 1);
/*     */       
/* 307 */       for (byte b = 0; b < k; b++) {
/* 308 */         c[b] = b * d;
/*     */       }
/* 310 */       if (this.bv) {
/* 311 */         d1 = (this.gB - 1) * d;
/* 312 */         d2 = 1.0D - (this.gB - 1) * d;
/*     */       }
/*     */     
/* 315 */     } else if (this.gC == 0) {
/* 316 */       double d = 1.0D / (j + 1);
/*     */       int m;
/* 318 */       for (m = 0; m < this.gB; m++) {
/* 319 */         c[m] = 0.0D;
/*     */       }
/* 321 */       m = this.gB; int n;
/* 322 */       for (n = 1; n <= j; n++) {
/* 323 */         c[m++] = n * d;
/*     */       }
/* 325 */       for (n = m; n < k; n++) {
/* 326 */         c[n] = 1.0D;
/*     */       }
/* 328 */       if (this.bv) {
/* 329 */         d1 = 0.0D;
/* 330 */         d2 = 1.0D;
/*     */       } 
/*     */     } 
/*     */     
/* 334 */     if (af.length < this.gB) {
/* 335 */       af = new int[2 * this.gB];
/* 336 */       D = new int[2 * this.gB];
/*     */     } 
/*     */     
/* 339 */     double[] arrayOfDouble = new double[paraml.aN() + 1];
/* 340 */     arrayOfDouble[paraml.aN()] = d1;
/* 341 */     c(arrayOfDouble);
/*     */     
/* 343 */     if (this.bx) {
/* 344 */       paraml.d(arrayOfDouble);
/*     */     } else {
/* 346 */       paraml.e(arrayOfDouble);
/*     */     } 
/* 348 */     c.a(this, d1, d2, paraml);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double b(double paramDouble, int paramInt) {
/* 356 */     double d = 0.0D;
/*     */     byte b;
/* 358 */     label69: for (b = 0; b < this.gB; b++) {
/* 359 */       double d1 = c[paramInt + b];
/* 360 */       double d2 = c[paramInt + b + 1];
/*     */       
/* 362 */       if (paramDouble >= d1 && paramDouble <= d2 && d1 != d2) {
/*     */         
/* 364 */         int i = this.gB - 2;
/*     */         int j;
/* 366 */         for (j = this.gB - b - 1; j >= 0; j--) {
/* 367 */           af[j] = 0;
/*     */         }
/* 369 */         if (b > 0) {
/* 370 */           for (j = 0; j < b; j++)
/* 371 */             D[j] = j; 
/* 372 */           D[b] = Integer.MAX_VALUE;
/*     */         } else {
/*     */           
/* 375 */           D[0] = i;
/* 376 */           D[1] = this.gB;
/*     */         } 
/*     */         
/* 379 */         j = 0;
/*     */         
/*     */         while (true) {
/* 382 */           while (D[j] < D[j + 1] - 1) {
/* 383 */             double d3 = 1.0D;
/* 384 */             byte b1 = 0;
/* 385 */             int k = i - b;
/* 386 */             int m = b - 1;
/*     */             int n, i1;
/* 388 */             for (n = i, i1 = this.gB; n >= 0; n--, i1--) {
/* 389 */               if (m >= 0 && D[m] == n) {
/* 390 */                 int i2 = paramInt + b1;
/* 391 */                 double d4 = c[i2 + i1];
/* 392 */                 d3 *= (d4 - paramDouble) / (d4 - c[i2 + 1]);
/* 393 */                 b1++;
/* 394 */                 m--;
/*     */               } else {
/*     */                 
/* 397 */                 int i2 = paramInt + af[k];
/* 398 */                 double d4 = c[i2];
/* 399 */                 d3 *= (paramDouble - d4) / (c[i2 + i1 - 1] - d4);
/* 400 */                 k--;
/*     */               } 
/*     */             } 
/*     */ 
/*     */             
/* 405 */             if (b > 0) {
/* 406 */               n = 0;
/* 407 */               i1 = 0;
/*     */               
/*     */               while (true) {
/* 410 */                 af[n] = af[n] + 1;
/*     */                 
/* 412 */                 if (af[n] > b) {
/* 413 */                   n++;
/* 414 */                   i1 = 1; continue;
/*     */                 }  break;
/*     */               } 
/* 417 */               if (i1 != 0) {
/* 418 */                 for (int i2 = n - 1; i2 >= 0; i2--) {
/* 419 */                   af[i2] = af[n];
/*     */                 }
/*     */               }
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 426 */             d += d3;
/*     */ 
/*     */             
/* 429 */             D[j] = D[j] + 1;
/* 430 */             if (D[j] > i)
/*     */               break label69; 
/* 432 */             for (n = 0; n < j; n++)
/* 433 */               D[n] = n; 
/* 434 */             j = 0;
/*     */           } 
/*     */           
/* 437 */           j++;
/*     */         } 
/*     */ 
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 445 */     return d;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void go() {
/* 481 */     if (af.length > 0) {
/* 482 */       af = new int[0];
/* 483 */       D = new int[0];
/*     */     } 
/*     */     
/* 486 */     if (c.length > 0)
/* 487 */       c = new double[0]; 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\a\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */