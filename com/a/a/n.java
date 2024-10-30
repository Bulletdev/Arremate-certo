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
/*     */ public class n
/*     */   extends o
/*     */ {
/*  64 */   private static double[][] a = new double[0][];
/*  65 */   private static double[][] c = new double[0][];
/*  66 */   private static int gM = 0;
/*     */   
/*     */   private boolean closed = false;
/*     */   
/*     */   public n(f paramf, j paramj) {
/*  71 */     super(paramf, paramj);
/*     */   }
/*     */   
/*     */   protected void c(double[] paramArrayOfdouble) {
/*  75 */     int i = paramArrayOfdouble.length - 1;
/*     */     
/*  77 */     double d1 = paramArrayOfdouble[i];
/*  78 */     double d2 = d1 * d1;
/*  79 */     double d3 = d2 * d1;
/*     */     
/*  81 */     byte b1 = 0;
/*  82 */     for (byte b2 = 0; b2 < i; b2++) {
/*  83 */       paramArrayOfdouble[b2] = c[b1++][gM] + c[b1++][gM] * d1 + c[b1++][gM] * d2 + c[b1++][gM] * d3;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static void a(int paramInt1, int paramInt2, boolean paramBoolean) {
/*  89 */     paramInt1--;
/*     */     
/*  91 */     double[] arrayOfDouble1 = c[4 * paramInt2];
/*  92 */     double[] arrayOfDouble2 = c[4 * paramInt2 + 1];
/*  93 */     double[] arrayOfDouble3 = c[4 * paramInt2 + 2];
/*  94 */     byte b = 0;
/*     */     
/*  96 */     if (paramBoolean) {
/*  97 */       double[] arrayOfDouble = c[4 * paramInt2 + 3];
/*     */ 
/*     */       
/* 100 */       for (byte b1 = 0; b1 < paramInt2; b1++) {
/* 101 */         double d1 = 0.25D; arrayOfDouble[1] = d1 = 0.25D;
/* 102 */         arrayOfDouble2[0] = d1 * 3.0D * (a[1][b1] - a[paramInt1][b1]);
/* 103 */         double d4 = 4.0D;
/* 104 */         double d2 = 3.0D * (a[0][b1] - a[paramInt1 - 1][b1]);
/* 105 */         double d3 = 1.0D; int i;
/* 106 */         for (i = 1; i < paramInt1; i++) {
/* 107 */           arrayOfDouble1[i + 1] = d1 = 1.0D / (4.0D - arrayOfDouble1[i]);
/* 108 */           arrayOfDouble[i + 1] = -d1 * arrayOfDouble[i];
/* 109 */           arrayOfDouble2[i] = d1 * (3.0D * (a[i + 1][b1] - a[i - 1][b1]) - arrayOfDouble2[i - 1]);
/* 110 */           d4 -= d3 * arrayOfDouble[i];
/* 111 */           d2 -= d3 * arrayOfDouble2[i - 1];
/* 112 */           d3 = -arrayOfDouble1[i] * d3;
/*     */         } 
/* 114 */         d4 -= (d3 + 1.0D) * (arrayOfDouble1[paramInt1] + arrayOfDouble[paramInt1]);
/* 115 */         arrayOfDouble2[paramInt1] = d2 - (d3 + 1.0D) * arrayOfDouble2[paramInt1 - 1];
/*     */         
/* 117 */         arrayOfDouble3[paramInt1] = arrayOfDouble2[paramInt1] / d4;
/* 118 */         arrayOfDouble3[paramInt1 - 1] = arrayOfDouble2[paramInt1 - 1] - (arrayOfDouble1[paramInt1] + arrayOfDouble[paramInt1]) * arrayOfDouble3[paramInt1];
/* 119 */         for (i = paramInt1 - 2; i >= 0; i--) {
/* 120 */           arrayOfDouble3[i] = arrayOfDouble2[i] - arrayOfDouble1[i + 1] * arrayOfDouble3[i + 1] - arrayOfDouble[i + 1] * arrayOfDouble3[paramInt1];
/*     */         }
/*     */         
/* 123 */         double[] arrayOfDouble4 = c[b++];
/* 124 */         double[] arrayOfDouble5 = c[b++];
/* 125 */         double[] arrayOfDouble6 = c[b++];
/* 126 */         double[] arrayOfDouble7 = c[b++];
/*     */         
/* 128 */         for (byte b2 = 0; b2 < paramInt1; b2++) {
/* 129 */           arrayOfDouble4[b2] = a[b2][b1];
/* 130 */           arrayOfDouble5[b2] = arrayOfDouble3[b2];
/* 131 */           arrayOfDouble6[b2] = 3.0D * (a[b2 + 1][b1] - a[b2][b1]) - 2.0D * arrayOfDouble3[b2] - arrayOfDouble3[b2 + 1];
/* 132 */           arrayOfDouble7[b2] = 2.0D * (a[b2][b1] - a[b2 + 1][b1]) + arrayOfDouble3[b2] + arrayOfDouble3[b2 + 1];
/*     */         } 
/*     */         
/* 135 */         arrayOfDouble4[paramInt1] = a[paramInt1][b1];
/* 136 */         arrayOfDouble5[paramInt1] = arrayOfDouble3[paramInt1];
/* 137 */         arrayOfDouble6[paramInt1] = 3.0D * (a[0][b1] - a[paramInt1][b1]) - 2.0D * arrayOfDouble3[paramInt1] - arrayOfDouble3[0];
/* 138 */         arrayOfDouble7[paramInt1] = 2.0D * (a[paramInt1][b1] - a[0][b1]) + arrayOfDouble3[paramInt1] + arrayOfDouble3[0];
/*     */       } 
/*     */     } else {
/*     */       
/* 142 */       for (byte b1 = 0; b1 < paramInt2; b1++) {
/* 143 */         arrayOfDouble1[0] = 0.5D; int i;
/* 144 */         for (i = 1; i < paramInt1; i++) {
/* 145 */           arrayOfDouble1[i] = 1.0D / (4.0D - arrayOfDouble1[i - 1]);
/*     */         }
/* 147 */         arrayOfDouble1[paramInt1] = 1.0D / (2.0D - arrayOfDouble1[paramInt1 - 1]);
/*     */         
/* 149 */         arrayOfDouble2[0] = arrayOfDouble1[0] * 3.0D * (a[1][b1] - a[0][b1]);
/* 150 */         for (i = 1; i < paramInt1; i++) {
/* 151 */           arrayOfDouble2[i] = arrayOfDouble1[i] * (3.0D * (a[i + 1][b1] - a[i - 1][b1]) - arrayOfDouble2[i - 1]);
/*     */         }
/* 153 */         arrayOfDouble2[paramInt1] = arrayOfDouble1[paramInt1] * (3.0D * (a[paramInt1][b1] - a[paramInt1 - 1][b1]) - arrayOfDouble2[paramInt1 - 1]);
/*     */         
/* 155 */         arrayOfDouble3[paramInt1] = arrayOfDouble2[paramInt1];
/* 156 */         for (i = paramInt1 - 1; i >= 0; i--) {
/* 157 */           arrayOfDouble3[i] = arrayOfDouble2[i] - arrayOfDouble1[i] * arrayOfDouble3[i + 1];
/*     */         }
/*     */         
/* 160 */         double[] arrayOfDouble4 = c[b++];
/* 161 */         double[] arrayOfDouble5 = c[b++];
/* 162 */         double[] arrayOfDouble6 = c[b++];
/* 163 */         double[] arrayOfDouble7 = c[b++];
/*     */         
/* 165 */         for (byte b2 = 0; b2 < paramInt1; b2++) {
/* 166 */           arrayOfDouble4[b2] = a[b2][b1];
/* 167 */           arrayOfDouble5[b2] = arrayOfDouble3[b2];
/* 168 */           arrayOfDouble6[b2] = 3.0D * (a[b2 + 1][b1] - a[b2][b1]) - 2.0D * arrayOfDouble3[b2] - arrayOfDouble3[b2 + 1];
/* 169 */           arrayOfDouble7[b2] = 2.0D * (a[b2][b1] - a[b2 + 1][b1]) + arrayOfDouble3[b2] + arrayOfDouble3[b2 + 1];
/*     */         } 
/*     */         
/* 172 */         arrayOfDouble4[paramInt1] = a[paramInt1][b1];
/* 173 */         arrayOfDouble5[paramInt1] = 0.0D;
/* 174 */         arrayOfDouble6[paramInt1] = 0.0D;
/* 175 */         arrayOfDouble7[paramInt1] = 0.0D;
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
/*     */   public void an(boolean paramBoolean) {
/* 187 */     this.closed = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean dP() {
/* 196 */     return this.closed;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int aA() {
/* 203 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(l paraml) {
/* 211 */     if (!this.a.isInRange(0, this.a.aE())) {
/* 212 */       throw new IllegalArgumentException("Group iterator not in range");
/*     */     }
/* 214 */     int i = this.a.aI();
/* 215 */     if (i < 2) {
/* 216 */       throw new IllegalArgumentException("Group iterator size < 2");
/*     */     }
/* 218 */     int j = paraml.aN();
/*     */ 
/*     */ 
/*     */     
/* 222 */     int k = 3 + 4 * j + 1;
/*     */     
/* 224 */     if (c.length < k) {
/* 225 */       double[][] arrayOfDouble1 = new double[k][];
/*     */       
/* 227 */       for (byte b = 0; b < c.length; b++) {
/* 228 */         arrayOfDouble1[b] = c[b];
/*     */       }
/* 230 */       c = arrayOfDouble1;
/*     */     } 
/*     */     
/* 233 */     if (a.length < i) {
/* 234 */       int m = 2 * i;
/*     */       
/* 236 */       a = new double[m][];
/*     */       
/* 238 */       for (byte b = 0; b < c.length; b++) {
/* 239 */         c[b] = new double[m];
/*     */       }
/*     */     } 
/*     */     
/* 243 */     this.a.j(0, 0);
/*     */     
/* 245 */     for (byte b1 = 0; b1 < i; b1++) {
/* 246 */       a[b1] = this.a.a(this.a.next()).b();
/*     */     }
/* 248 */     a(i, j, this.closed);
/*     */     
/* 250 */     gM = 0;
/*     */     
/* 252 */     double[] arrayOfDouble = new double[j + 1];
/* 253 */     c(arrayOfDouble);
/*     */     
/* 255 */     if (this.bx) {
/* 256 */       paraml.d(arrayOfDouble);
/*     */     } else {
/* 258 */       paraml.e(arrayOfDouble);
/*     */     } 
/*     */     
/* 261 */     for (byte b2 = 0; b2 < i; b2++) {
/* 262 */       gM = b2;
/* 263 */       c.a(this, 0.0D, 1.0D, paraml);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void go() {
/* 268 */     if (a.length > 0) {
/* 269 */       a = new double[0][];
/*     */     }
/* 271 */     if (c.length > 0)
/* 272 */       c = new double[0][]; 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\a\n.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */