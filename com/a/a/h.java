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
/*     */ public class h
/*     */   extends o
/*     */ {
/*  77 */   private static int gF = 0;
/*  78 */   private static int gG = 0;
/*  79 */   private static double[][] a = new double[4][];
/*  80 */   private static double[] e = new double[4];
/*     */   
/*     */   private boolean bw = false;
/*     */   
/*     */   public h(f paramf, j paramj) {
/*  85 */     super(paramf, paramj);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void c(double[] paramArrayOfdouble) {
/*  90 */     double d1 = paramArrayOfdouble[paramArrayOfdouble.length - 1];
/*  91 */     double d2 = d1 * d1;
/*  92 */     double d3 = d2 * d1;
/*     */     
/*  94 */     double d4 = 1.0D - d1;
/*  95 */     double d5 = d4 * d4;
/*  96 */     double d6 = d5 * d4;
/*     */     
/*  98 */     if (gG == 4) {
/*  99 */       e[0] = d5 * d4;
/* 100 */       e[1] = 3.0D * d5 * d1;
/* 101 */       e[2] = 3.0D * d4 * d2;
/* 102 */       e[3] = d3;
/*     */     }
/* 104 */     else if (gG == 5) {
/* 105 */       if (gF == 0) {
/* 106 */         e[0] = d6;
/* 107 */         e[1] = 7.0D * d3 / 4.0D - 9.0D * d2 / 2.0D + 3.0D * d1;
/* 108 */         e[2] = -d3 + 3.0D * d2 / 2.0D;
/* 109 */         e[3] = d3 / 4.0D;
/*     */       } else {
/*     */         
/* 112 */         e[0] = d6 / 4.0D;
/* 113 */         e[1] = -d6 + 3.0D * d5 / 2.0D;
/* 114 */         e[2] = 7.0D * d6 / 4.0D - 9.0D * d5 / 2.0D + 3.0D * d4;
/* 115 */         e[3] = d3;
/*     */       }
/*     */     
/* 118 */     } else if (gG == 6) {
/* 119 */       if (gF == 0) {
/* 120 */         e[0] = d6;
/* 121 */         e[1] = 7.0D * d3 / 4.0D - 9.0D * d2 / 2.0D + 3.0D * d1;
/* 122 */         e[2] = -11.0D * d3 / 12.0D + 3.0D * d2 / 2.0D;
/* 123 */         e[3] = d3 / 6.0D;
/*     */       }
/* 125 */       else if (gF == 1) {
/* 126 */         e[0] = d6 / 4.0D;
/* 127 */         e[1] = 7.0D * d3 / 12.0D - 5.0D * d2 / 4.0D + d1 / 4.0D + 0.5833333333333334D;
/* 128 */         e[2] = -7.0D * d3 / 12.0D + d2 / 2.0D + d1 / 2.0D + 0.16666666666666666D;
/* 129 */         e[3] = d3 / 4.0D;
/*     */       } else {
/*     */         
/* 132 */         e[0] = d6 / 6.0D;
/* 133 */         e[1] = -11.0D * d6 / 12.0D + 3.0D * d5 / 2.0D;
/* 134 */         e[2] = 7.0D * d6 / 4.0D - 9.0D * d5 / 2.0D + 3.0D * d4;
/* 135 */         e[3] = d3;
/*     */       }
/*     */     
/*     */     }
/* 139 */     else if (gF == 0) {
/* 140 */       e[0] = d6;
/* 141 */       e[1] = 7.0D * d3 / 4.0D - 9.0D * d2 / 2.0D + 3.0D * d1;
/* 142 */       e[2] = -11.0D * d3 / 12.0D + 3.0D * d2 / 2.0D;
/* 143 */       e[3] = d3 / 6.0D;
/*     */     }
/* 145 */     else if (gF == 1) {
/* 146 */       e[0] = d6 / 4.0D;
/* 147 */       e[1] = 7.0D * d3 / 12.0D - 5.0D * d2 / 4.0D + d1 / 4.0D + 0.5833333333333334D;
/* 148 */       e[2] = -d3 / 2.0D + d2 / 2.0D + d1 / 2.0D + 0.16666666666666666D;
/* 149 */       e[3] = d3 / 6.0D;
/*     */     }
/* 151 */     else if (gF == 2) {
/* 152 */       e[0] = d6 / 6.0D;
/* 153 */       e[1] = d3 / 2.0D - d2 + 0.6666666666666666D;
/* 154 */       e[2] = (-d3 + d2 + d1) / 2.0D + 0.16666666666666666D;
/* 155 */       e[3] = d3 / 6.0D;
/*     */     }
/* 157 */     else if (gF == 3) {
/* 158 */       e[0] = d6 / 6.0D;
/* 159 */       e[1] = -d6 / 2.0D + d5 / 2.0D + d4 / 2.0D + 0.16666666666666666D;
/* 160 */       e[2] = 7.0D * d6 / 12.0D - 5.0D * d5 / 4.0D + d4 / 4.0D + 0.5833333333333334D;
/* 161 */       e[3] = d3 / 4.0D;
/*     */     } else {
/*     */       
/* 164 */       e[0] = d6 / 6.0D;
/* 165 */       e[1] = -11.0D * d6 / 12.0D + 3.0D * d5 / 2.0D;
/* 166 */       e[2] = 7.0D * d6 / 4.0D - 9.0D * d5 / 2.0D + 3.0D * d4;
/* 167 */       e[3] = d3;
/*     */     } 
/*     */ 
/*     */     
/* 171 */     for (byte b = 0; b < 4; b++) {
/* 172 */       for (byte b1 = 0; b1 < paramArrayOfdouble.length - 1; b1++) {
/* 173 */         paramArrayOfdouble[b1] = paramArrayOfdouble[b1] + a[b][b1] * e[b];
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int aA() {
/* 181 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ai(boolean paramBoolean) {
/* 191 */     this.bw = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean dK() {
/* 200 */     return this.bw;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(l paraml) {
/* 208 */     if (!this.a.isInRange(0, this.a.aE()))
/* 209 */       throw new IllegalArgumentException("Group iterator not in range"); 
/* 210 */     int i = this.a.aI();
/* 211 */     if (i < 4) {
/* 212 */       throw new IllegalArgumentException("Group iterator size < 4");
/*     */     }
/* 214 */     if (this.bw) {
/* 215 */       gG = i;
/* 216 */       gF = 0;
/*     */     } else {
/*     */       
/* 219 */       gG = -1;
/* 220 */       gF = 2;
/*     */     } 
/*     */     
/* 223 */     this.a.j(0, 0);
/* 224 */     int j = 0;
/* 225 */     int k = 0;
/*     */     
/* 227 */     for (byte b1 = 0; b1 < 4; b1++) {
/* 228 */       a[b1] = this.a.a(this.a.next()).b();
/*     */     }
/* 230 */     double[] arrayOfDouble = new double[paraml.aN() + 1];
/* 231 */     c(arrayOfDouble);
/*     */     
/* 233 */     if (this.bx) {
/* 234 */       paraml.d(arrayOfDouble);
/*     */     } else {
/* 236 */       paraml.e(arrayOfDouble);
/*     */     } 
/* 238 */     byte b2 = 3;
/*     */     
/*     */     while (true) {
/* 241 */       c.a(this, 0.0D, 1.0D, paraml);
/* 242 */       b2++;
/* 243 */       if (b2 == i)
/*     */         break; 
/* 245 */       this.a.j(j, k);
/* 246 */       this.a.next();
/* 247 */       j = this.a.aJ();
/* 248 */       k = this.a.aK();
/*     */       
/* 250 */       for (byte b = 0; b < 4; b++) {
/* 251 */         a[b] = this.a.a(this.a.next()).b();
/*     */       }
/* 253 */       if (this.bw) {
/* 254 */         if (i < 7) {
/* 255 */           gF++;
/*     */           continue;
/*     */         } 
/* 258 */         if (gF != 2) {
/* 259 */           gF++;
/*     */         }
/* 261 */         if (gF == 2 && b2 == i - 2)
/* 262 */           gF++; 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\a\h.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */