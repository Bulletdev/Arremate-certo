/*     */ package com.a.d.a.a.a.a;
/*     */ 
/*     */ import java.awt.Shape;
/*     */ import java.awt.geom.PathIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ {
/*     */   static final double Y = 1.0E-5D;
/*     */   static final double Z = 1.0E-10D;
/*     */   public static final int gS = 255;
/*     */   static final int UNKNOWN = 254;
/*     */   
/*     */   public static int c(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2) {
/*  54 */     double d1 = paramArrayOfdouble1[2];
/*  55 */     double d2 = paramArrayOfdouble1[1];
/*  56 */     double d3 = paramArrayOfdouble1[0];
/*  57 */     byte b = 0;
/*  58 */     if (d1 == 0.0D) {
/*  59 */       if (d2 == 0.0D) {
/*  60 */         return -1;
/*     */       }
/*  62 */       paramArrayOfdouble2[b++] = -d3 / d2;
/*     */     } else {
/*  64 */       double d = d2 * d2 - 4.0D * d1 * d3;
/*     */       
/*  66 */       if (d < 0.0D) {
/*  67 */         return 0;
/*     */       }
/*  69 */       d = Math.sqrt(d);
/*  70 */       paramArrayOfdouble2[b++] = (-d2 + d) / d1 * 2.0D;
/*     */       
/*  72 */       if (d != 0.0D) {
/*  73 */         paramArrayOfdouble2[b++] = (-d2 - d) / d1 * 2.0D;
/*     */       }
/*     */     } 
/*  76 */     return a(paramArrayOfdouble2, b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int d(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2) {
/*  86 */     double d1 = paramArrayOfdouble1[3];
/*  87 */     if (d1 == 0.0D) {
/*  88 */       return c(paramArrayOfdouble1, paramArrayOfdouble2);
/*     */     }
/*  90 */     double d2 = paramArrayOfdouble1[2] / d1;
/*  91 */     double d3 = paramArrayOfdouble1[1] / d1;
/*  92 */     double d4 = paramArrayOfdouble1[0] / d1;
/*  93 */     byte b = 0;
/*     */     
/*  95 */     double d5 = (d2 * d2 - 3.0D * d3) / 9.0D;
/*  96 */     double d6 = (2.0D * d2 * d2 * d2 - 9.0D * d2 * d3 + 27.0D * d4) / 54.0D;
/*  97 */     double d7 = d5 * d5 * d5;
/*  98 */     double d8 = d6 * d6;
/*  99 */     double d9 = -d2 / 3.0D;
/*     */     
/* 101 */     if (d8 < d7) {
/* 102 */       double d10 = Math.acos(d6 / Math.sqrt(d7)) / 3.0D;
/* 103 */       double d11 = 2.0943951023931953D;
/* 104 */       double d12 = -2.0D * Math.sqrt(d5);
/* 105 */       paramArrayOfdouble2[b++] = d12 * Math.cos(d10) + d9;
/* 106 */       paramArrayOfdouble2[b++] = d12 * Math.cos(d10 + d11) + d9;
/* 107 */       paramArrayOfdouble2[b++] = d12 * Math.cos(d10 - d11) + d9;
/*     */     } else {
/*     */       
/* 110 */       double d = Math.pow(Math.abs(d6) + Math.sqrt(d8 - d7), 0.3333333333333333D);
/* 111 */       if (d6 > 0.0D) {
/* 112 */         d = -d;
/*     */       }
/*     */       
/* 115 */       if (-1.0E-10D < d && d < 1.0E-10D) {
/* 116 */         paramArrayOfdouble2[b++] = d9;
/*     */       } else {
/* 118 */         double d10 = d5 / d;
/* 119 */         paramArrayOfdouble2[b++] = d + d10 + d9;
/*     */         
/* 121 */         double d11 = d8 - d7;
/* 122 */         if (-1.0E-10D < d11 && d11 < 1.0E-10D) {
/* 123 */           paramArrayOfdouble2[b++] = -(d + d10) / 2.0D + d9;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 128 */     return a(paramArrayOfdouble2, b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static int a(double[] paramArrayOfdouble, int paramInt) {
/* 138 */     byte b1 = 0;
/* 139 */     for (byte b2 = 0; b2 < paramInt; b2++) {
/*     */       
/* 141 */       int i = b2 + 1; while (true) { if (i < paramInt) {
/* 142 */           if (h(paramArrayOfdouble[b2] - paramArrayOfdouble[i]))
/*     */             break;  i++;
/*     */           continue;
/*     */         } 
/* 146 */         paramArrayOfdouble[b1++] = paramArrayOfdouble[b2]; break; }
/*     */     
/*     */     } 
/* 149 */     return b1;
/*     */   }
/*     */   public static class b { double aa;
/*     */     double ab;
/*     */     double ac;
/*     */     double ad;
/*     */     double ag;
/*     */     double ah;
/*     */     double ai;
/*     */     double aj;
/*     */     
/*     */     public b(double param1Double1, double param1Double2, double param1Double3, double param1Double4, double param1Double5, double param1Double6) {
/* 161 */       this.aa = param1Double5 - param1Double1;
/* 162 */       this.ab = param1Double6 - param1Double2;
/* 163 */       this.ac = param1Double3 - param1Double1;
/* 164 */       this.ad = param1Double4 - param1Double2;
/*     */       
/* 166 */       this.ai = this.ac + this.ac;
/* 167 */       this.ag = this.aa - this.ai;
/*     */       
/* 169 */       this.aj = this.ad + this.ad;
/* 170 */       this.ah = this.ab - this.aj;
/*     */     }
/*     */     
/*     */     int b(double[] param1ArrayOfdouble, int param1Int, double param1Double1, double param1Double2) {
/* 174 */       int i = 0;
/*     */       
/* 176 */       for (byte b1 = 0; b1 < param1Int; b1++) {
/* 177 */         double d = param1ArrayOfdouble[b1];
/*     */ 
/*     */         
/* 180 */         if (d >= -1.0E-5D && d <= 1.00001D)
/*     */         {
/*     */ 
/*     */           
/* 184 */           if (d < 1.0E-5D) {
/* 185 */             if (param1Double1 < 0.0D && ((this.ac != 0.0D) ? this.ac : (this.aa - this.ac)) < 0.0D) {
/* 186 */               i--;
/*     */             
/*     */             }
/*     */           
/*     */           }
/* 191 */           else if (d > 0.99999D) {
/* 192 */             if (param1Double1 < this.ab && ((this.aa != this.ac) ? (this.aa - this.ac) : this.ac) > 0.0D) {
/* 193 */               i++;
/*     */             }
/*     */           }
/*     */           else {
/*     */             
/* 198 */             double d1 = d * (d * this.ah + this.aj);
/*     */             
/* 200 */             if (d1 > param1Double2) {
/* 201 */               double d2 = d * this.ag + this.ac;
/*     */               
/* 203 */               if (d2 <= -1.0E-5D || d2 >= 1.0E-5D)
/*     */               {
/*     */                 
/* 206 */                 i += (d2 > 0.0D) ? 1 : -1; } 
/*     */             } 
/*     */           }  } 
/*     */       } 
/* 210 */       return i;
/*     */     }
/*     */     
/*     */     int a(double[] param1ArrayOfdouble, double param1Double) {
/* 214 */       double[] arrayOfDouble = { -param1Double, this.ai, this.ag };
/* 215 */       return a.c(arrayOfDouble, param1ArrayOfdouble);
/*     */     }
/*     */     
/*     */     int c(double[] param1ArrayOfdouble) {
/* 219 */       byte b1 = 0;
/* 220 */       if (this.ag != 0.0D) {
/* 221 */         param1ArrayOfdouble[b1++] = -this.ai / (this.ag + this.ag);
/*     */       }
/* 223 */       if (this.ah != 0.0D) {
/* 224 */         param1ArrayOfdouble[b1++] = -this.aj / (this.ah + this.ah);
/*     */       }
/* 226 */       return b1;
/*     */     }
/*     */     
/*     */     int a(double[] param1ArrayOfdouble1, int param1Int1, double[] param1ArrayOfdouble2, int param1Int2, double param1Double1, double param1Double2, boolean param1Boolean, int param1Int3) {
/* 230 */       for (byte b1 = 0; b1 < param1Int2; b1++) {
/* 231 */         double d = param1ArrayOfdouble2[b1];
/* 232 */         if (d > -1.0E-5D && d < 1.00001D) {
/* 233 */           double d1 = d * (d * this.ag + this.ai);
/* 234 */           if (param1Double1 <= d1 && d1 <= param1Double2) {
/* 235 */             param1ArrayOfdouble1[param1Int1++] = d;
/* 236 */             param1ArrayOfdouble1[param1Int1++] = d1;
/* 237 */             param1ArrayOfdouble1[param1Int1++] = d * (d * this.ah + this.aj);
/* 238 */             param1ArrayOfdouble1[param1Int1++] = param1Int3;
/* 239 */             if (param1Boolean) {
/* 240 */               param1Int3++;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/* 245 */       return param1Int1;
/*     */     } }
/*     */ 
/*     */   
/*     */   public static class a
/*     */   {
/*     */     double aa;
/*     */     double ab;
/*     */     double ac;
/*     */     double ad;
/*     */     double ae;
/*     */     double af;
/*     */     double ag;
/*     */     
/*     */     public a(double param1Double1, double param1Double2, double param1Double3, double param1Double4, double param1Double5, double param1Double6, double param1Double7, double param1Double8) {
/* 260 */       this.aa = param1Double7 - param1Double1;
/* 261 */       this.ab = param1Double8 - param1Double2;
/* 262 */       this.ac = param1Double3 - param1Double1;
/* 263 */       this.ad = param1Double4 - param1Double2;
/* 264 */       this.ae = param1Double5 - param1Double1;
/* 265 */       this.af = param1Double6 - param1Double2;
/*     */       
/* 267 */       this.ak = this.ac + this.ac + this.ac;
/* 268 */       this.ai = this.ae + this.ae + this.ae - this.ak - this.ak;
/* 269 */       this.ag = this.aa - this.ai - this.ak;
/*     */       
/* 271 */       this.al = this.ad + this.ad + this.ad;
/* 272 */       this.aj = this.af + this.af + this.af - this.al - this.al;
/* 273 */       this.ah = this.ab - this.aj - this.al;
/*     */       
/* 275 */       this.am = this.ag + this.ag + this.ag;
/* 276 */       this.an = this.ai + this.ai;
/*     */     }
/*     */     double ah; double ai; double aj; double ak; double al; double am; double an;
/*     */     int b(double[] param1ArrayOfdouble, int param1Int, double param1Double1, double param1Double2) {
/* 280 */       int i = 0;
/* 281 */       for (byte b = 0; b < param1Int; b++) {
/* 282 */         double d1 = param1ArrayOfdouble[b];
/*     */ 
/*     */         
/* 285 */         if (d1 < -1.0E-5D || d1 > 1.00001D) {
/*     */           continue;
/*     */         }
/*     */         
/* 289 */         if (d1 < 1.0E-5D) {
/* 290 */           if (param1Double1 < 0.0D) if (((this.ac != 0.0D) ? this.ac : ((this.ae != this.ac) ? (this.ae - this.ac) : (this.aa - this.ae))) < 0.0D) {
/* 291 */               i--;
/*     */             }
/*     */           
/*     */           continue;
/*     */         } 
/* 296 */         if (d1 > 0.99999D) {
/* 297 */           if (param1Double1 < this.ab) if (((this.aa != this.ae) ? (this.aa - this.ae) : ((this.ae != this.ac) ? (this.ae - this.ac) : this.ac)) > 0.0D) {
/* 298 */               i++;
/*     */             }
/*     */           
/*     */           continue;
/*     */         } 
/* 303 */         double d2 = d1 * (d1 * (d1 * this.ah + this.aj) + this.al);
/*     */         
/* 305 */         if (d2 > param1Double2) {
/* 306 */           double d = d1 * (d1 * this.am + this.an) + this.ak;
/*     */           
/* 308 */           if (d > -1.0E-5D && d < 1.0E-5D) {
/* 309 */             d = d1 * (this.am + this.am) + this.an;
/*     */             
/* 311 */             if (d < -1.0E-5D || d > 1.0E-5D) {
/*     */               continue;
/*     */             }
/*     */             
/* 315 */             d = this.aa;
/*     */           } 
/* 317 */           i += (d > 0.0D) ? 1 : -1;
/*     */         } 
/*     */         continue;
/*     */       } 
/* 321 */       return i;
/*     */     }
/*     */     
/*     */     int a(double[] param1ArrayOfdouble, double param1Double) {
/* 325 */       double[] arrayOfDouble = { -param1Double, this.ak, this.ai, this.ag };
/* 326 */       return a.d(arrayOfDouble, param1ArrayOfdouble);
/*     */     }
/*     */     
/*     */     int a(double[] param1ArrayOfdouble) {
/* 330 */       double[] arrayOfDouble = { this.ak, this.an, this.am };
/* 331 */       return a.c(arrayOfDouble, param1ArrayOfdouble);
/*     */     }
/*     */     
/*     */     int b(double[] param1ArrayOfdouble) {
/* 335 */       double[] arrayOfDouble = { this.al, this.aj + this.aj, this.ah + this.ah + this.ah };
/* 336 */       return a.c(arrayOfDouble, param1ArrayOfdouble);
/*     */     }
/*     */     
/*     */     int a(double[] param1ArrayOfdouble1, int param1Int1, double[] param1ArrayOfdouble2, int param1Int2, double param1Double1, double param1Double2, boolean param1Boolean, int param1Int3) {
/* 340 */       for (byte b = 0; b < param1Int2; b++) {
/* 341 */         double d = param1ArrayOfdouble2[b];
/* 342 */         if (d > -1.0E-5D && d < 1.00001D) {
/* 343 */           double d1 = d * (d * (d * this.ag + this.ai) + this.ak);
/* 344 */           if (param1Double1 <= d1 && d1 <= param1Double2) {
/* 345 */             param1ArrayOfdouble1[param1Int1++] = d;
/* 346 */             param1ArrayOfdouble1[param1Int1++] = d1;
/* 347 */             param1ArrayOfdouble1[param1Int1++] = d * (d * (d * this.ah + this.aj) + this.al);
/* 348 */             param1ArrayOfdouble1[param1Int1++] = param1Int3;
/* 349 */             if (param1Boolean) {
/* 350 */               param1Int3++;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/* 355 */       return param1Int1;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6) {
/* 366 */     if ((paramDouble5 < paramDouble1 && paramDouble5 < paramDouble3) || (paramDouble5 > paramDouble1 && paramDouble5 > paramDouble3) || (paramDouble6 > paramDouble2 && paramDouble6 > paramDouble4) || paramDouble1 == paramDouble3)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 371 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 375 */     if (paramDouble6 >= paramDouble2 || paramDouble6 >= paramDouble4)
/*     */     {
/*     */       
/* 378 */       if ((paramDouble4 - paramDouble2) * (paramDouble5 - paramDouble1) / (paramDouble3 - paramDouble1) <= paramDouble6 - paramDouble2)
/*     */       {
/* 380 */         return 0;
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 385 */     if (paramDouble5 == paramDouble1) {
/* 386 */       return (paramDouble1 < paramDouble3) ? 0 : -1;
/*     */     }
/*     */ 
/*     */     
/* 390 */     if (paramDouble5 == paramDouble3) {
/* 391 */       return (paramDouble1 < paramDouble3) ? 1 : 0;
/*     */     }
/*     */ 
/*     */     
/* 395 */     return (paramDouble1 < paramDouble3) ? 1 : -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8) {
/* 404 */     if ((paramDouble7 < paramDouble1 && paramDouble7 < paramDouble3 && paramDouble7 < paramDouble5) || (paramDouble7 > paramDouble1 && paramDouble7 > paramDouble3 && paramDouble7 > paramDouble5) || (paramDouble8 > paramDouble2 && paramDouble8 > paramDouble4 && paramDouble8 > paramDouble6) || (paramDouble1 == paramDouble3 && paramDouble3 == paramDouble5))
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 409 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 413 */     if (paramDouble8 < paramDouble2 && paramDouble8 < paramDouble4 && paramDouble8 < paramDouble6 && paramDouble7 != paramDouble1 && paramDouble7 != paramDouble5) {
/* 414 */       if (paramDouble1 < paramDouble5) {
/* 415 */         return (paramDouble1 < paramDouble7 && paramDouble7 < paramDouble5) ? 1 : 0;
/*     */       }
/* 417 */       return (paramDouble5 < paramDouble7 && paramDouble7 < paramDouble1) ? -1 : 0;
/*     */     } 
/*     */ 
/*     */     
/* 421 */     b b = new b(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6);
/* 422 */     double d1 = paramDouble7 - paramDouble1;
/* 423 */     double d2 = paramDouble8 - paramDouble2;
/* 424 */     double[] arrayOfDouble = new double[3];
/* 425 */     int i = b.a(arrayOfDouble, d1);
/*     */     
/* 427 */     return b.b(arrayOfDouble, i, d2, d2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9, double paramDouble10) {
/* 436 */     if ((paramDouble9 < paramDouble1 && paramDouble9 < paramDouble3 && paramDouble9 < paramDouble5 && paramDouble9 < paramDouble7) || (paramDouble9 > paramDouble1 && paramDouble9 > paramDouble3 && paramDouble9 > paramDouble5 && paramDouble9 > paramDouble7) || (paramDouble10 > paramDouble2 && paramDouble10 > paramDouble4 && paramDouble10 > paramDouble6 && paramDouble10 > paramDouble8) || (paramDouble1 == paramDouble3 && paramDouble3 == paramDouble5 && paramDouble5 == paramDouble7))
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 441 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 445 */     if (paramDouble10 < paramDouble2 && paramDouble10 < paramDouble4 && paramDouble10 < paramDouble6 && paramDouble10 < paramDouble8 && paramDouble9 != paramDouble1 && paramDouble9 != paramDouble7) {
/* 446 */       if (paramDouble1 < paramDouble7) {
/* 447 */         return (paramDouble1 < paramDouble9 && paramDouble9 < paramDouble7) ? 1 : 0;
/*     */       }
/* 449 */       return (paramDouble7 < paramDouble9 && paramDouble9 < paramDouble1) ? -1 : 0;
/*     */     } 
/*     */ 
/*     */     
/* 453 */     a a1 = new a(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramDouble7, paramDouble8);
/* 454 */     double d1 = paramDouble9 - paramDouble1;
/* 455 */     double d2 = paramDouble10 - paramDouble2;
/* 456 */     double[] arrayOfDouble = new double[3];
/* 457 */     int i = a1.a(arrayOfDouble, d1);
/* 458 */     return a1.b(arrayOfDouble, i, d2, d2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a(PathIterator paramPathIterator, double paramDouble1, double paramDouble2) {
/* 465 */     int i = 0;
/*     */     
/* 467 */     double d4 = 0.0D, d3 = d4, d2 = d3, d1 = d2;
/* 468 */     double[] arrayOfDouble = new double[6];
/*     */     
/* 470 */     while (!paramPathIterator.isDone()) {
/* 471 */       switch (paramPathIterator.currentSegment(arrayOfDouble)) {
/*     */         case 0:
/* 473 */           if (d3 != d1 || d4 != d2) {
/* 474 */             i += a(d3, d4, d1, d2, paramDouble1, paramDouble2);
/*     */           }
/* 476 */           d1 = d3 = arrayOfDouble[0];
/* 477 */           d2 = d4 = arrayOfDouble[1];
/*     */         
/*     */         case 1:
/* 480 */           i += a(d3, d4, d3 = arrayOfDouble[0], d4 = arrayOfDouble[1], paramDouble1, paramDouble2);
/*     */         
/*     */         case 2:
/* 483 */           i += a(d3, d4, arrayOfDouble[0], arrayOfDouble[1], d3 = arrayOfDouble[2], d4 = arrayOfDouble[3], paramDouble1, paramDouble2);
/*     */         
/*     */         case 3:
/* 486 */           i += a(d3, d4, arrayOfDouble[0], arrayOfDouble[1], arrayOfDouble[2], arrayOfDouble[3], d3 = arrayOfDouble[4], d4 = arrayOfDouble[5], paramDouble1, paramDouble2);
/*     */         
/*     */         case 4:
/* 489 */           if (d4 != d2 || d3 != d1) {
/* 490 */             i += a(d3, d4, d3 = d1, d4 = d2, paramDouble1, paramDouble2);
/*     */           }
/*     */           break;
/*     */       } 
/*     */ 
/*     */       
/* 496 */       if (paramDouble1 == d3 && paramDouble2 == d4) {
/* 497 */         i = 0;
/* 498 */         d4 = d2;
/*     */         break;
/*     */       } 
/* 501 */       paramPathIterator.next();
/*     */     } 
/* 503 */     if (d4 != d2) {
/* 504 */       i += a(d3, d4, d1, d2, paramDouble1, paramDouble2);
/*     */     }
/* 506 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a(Shape paramShape, double paramDouble1, double paramDouble2) {
/* 513 */     if (!paramShape.getBounds2D().contains(paramDouble1, paramDouble2)) {
/* 514 */       return 0;
/*     */     }
/* 516 */     return a(paramShape.getPathIterator(null), paramDouble1, paramDouble2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean h(double paramDouble) {
/* 523 */     return (-1.0E-5D < paramDouble && paramDouble < 1.0E-5D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void a(double[] paramArrayOfdouble, int paramInt) {
/* 530 */     for (byte b = 0; b < paramInt - 4; b += 4) {
/* 531 */       int i = b;
/* 532 */       for (int j = b + 4; j < paramInt; j += 4) {
/* 533 */         if (paramArrayOfdouble[i] > paramArrayOfdouble[j]) {
/* 534 */           i = j;
/*     */         }
/*     */       } 
/* 537 */       if (i != b) {
/* 538 */         double d = paramArrayOfdouble[b];
/* 539 */         paramArrayOfdouble[b] = paramArrayOfdouble[i];
/* 540 */         paramArrayOfdouble[i] = d;
/* 541 */         d = paramArrayOfdouble[b + 1];
/* 542 */         paramArrayOfdouble[b + 1] = paramArrayOfdouble[i + 1];
/* 543 */         paramArrayOfdouble[i + 1] = d;
/* 544 */         d = paramArrayOfdouble[b + 2];
/* 545 */         paramArrayOfdouble[b + 2] = paramArrayOfdouble[i + 2];
/* 546 */         paramArrayOfdouble[i + 2] = d;
/* 547 */         d = paramArrayOfdouble[b + 3];
/* 548 */         paramArrayOfdouble[b + 3] = paramArrayOfdouble[i + 3];
/* 549 */         paramArrayOfdouble[i + 3] = d;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static int a(double[] paramArrayOfdouble, int paramInt, double paramDouble1, double paramDouble2) {
/* 560 */     if (paramInt == 0) {
/* 561 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 565 */     byte b1 = 0;
/* 566 */     byte b2 = 0; byte b3;
/* 567 */     for (b3 = 2; b3 < paramInt; b3 += 4) {
/* 568 */       if (paramArrayOfdouble[b3] < paramDouble1) {
/* 569 */         b1++;
/*     */       
/*     */       }
/* 572 */       else if (paramArrayOfdouble[b3] > paramDouble2) {
/* 573 */         b2++;
/*     */       } else {
/*     */         
/* 576 */         return 255;
/*     */       } 
/*     */     } 
/*     */     
/* 580 */     if (b2 == 0) {
/* 581 */       return 0;
/*     */     }
/*     */     
/* 584 */     if (b1 != 0) {
/*     */       
/* 586 */       a(paramArrayOfdouble, paramInt);
/* 587 */       b3 = (paramArrayOfdouble[2] > paramDouble2) ? 1 : 0;
/* 588 */       for (byte b = 6; b < paramInt; b += 4) {
/* 589 */         byte b4 = (paramArrayOfdouble[b] > paramDouble2) ? 1 : 0;
/* 590 */         if (b3 != b4 && paramArrayOfdouble[b + 1] != paramArrayOfdouble[b - 3]) {
/* 591 */           return 255;
/*     */         }
/* 593 */         b3 = b4;
/*     */       } 
/*     */     } 
/* 596 */     return 254;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8) {
/* 605 */     if ((paramDouble7 < paramDouble1 && paramDouble7 < paramDouble3) || (paramDouble5 > paramDouble1 && paramDouble5 > paramDouble3) || (paramDouble6 > paramDouble2 && paramDouble6 > paramDouble4))
/*     */     {
/*     */ 
/*     */       
/* 609 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 613 */     if (paramDouble8 >= paramDouble2 || paramDouble8 >= paramDouble4) {
/*     */       double d1, d2;
/*     */ 
/*     */       
/* 617 */       if (paramDouble1 == paramDouble3) {
/* 618 */         return 255;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 623 */       if (paramDouble1 < paramDouble3) {
/* 624 */         d1 = (paramDouble1 < paramDouble5) ? paramDouble5 : paramDouble1;
/* 625 */         d2 = (paramDouble3 < paramDouble7) ? paramDouble3 : paramDouble7;
/*     */       } else {
/* 627 */         d1 = (paramDouble3 < paramDouble5) ? paramDouble5 : paramDouble3;
/* 628 */         d2 = (paramDouble1 < paramDouble7) ? paramDouble1 : paramDouble7;
/*     */       } 
/* 630 */       double d3 = (paramDouble4 - paramDouble2) / (paramDouble3 - paramDouble1);
/* 631 */       double d4 = d3 * (d1 - paramDouble1) + paramDouble2;
/* 632 */       double d5 = d3 * (d2 - paramDouble1) + paramDouble2;
/*     */ 
/*     */       
/* 635 */       if (d4 < paramDouble6 && d5 < paramDouble6) {
/* 636 */         return 0;
/*     */       }
/*     */ 
/*     */       
/* 640 */       if (d4 <= paramDouble8 || d5 <= paramDouble8)
/*     */       {
/* 642 */         return 255;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 647 */     if (paramDouble1 == paramDouble3) {
/* 648 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 652 */     if (paramDouble5 == paramDouble1) {
/* 653 */       return (paramDouble1 < paramDouble3) ? 0 : -1;
/*     */     }
/*     */ 
/*     */     
/* 657 */     if (paramDouble5 == paramDouble3) {
/* 658 */       return (paramDouble1 < paramDouble3) ? 1 : 0;
/*     */     }
/*     */     
/* 661 */     if (paramDouble1 < paramDouble3) {
/* 662 */       return (paramDouble1 < paramDouble5 && paramDouble5 < paramDouble3) ? 1 : 0;
/*     */     }
/* 664 */     return (paramDouble3 < paramDouble5 && paramDouble5 < paramDouble1) ? -1 : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9, double paramDouble10) {
/* 674 */     if ((paramDouble9 < paramDouble1 && paramDouble9 < paramDouble3 && paramDouble9 < paramDouble5) || (paramDouble7 > paramDouble1 && paramDouble7 > paramDouble3 && paramDouble7 > paramDouble5) || (paramDouble8 > paramDouble2 && paramDouble8 > paramDouble4 && paramDouble8 > paramDouble6))
/*     */     {
/*     */ 
/*     */       
/* 678 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 682 */     if (paramDouble10 < paramDouble2 && paramDouble10 < paramDouble4 && paramDouble10 < paramDouble6 && paramDouble7 != paramDouble1 && paramDouble7 != paramDouble5) {
/* 683 */       if (paramDouble1 < paramDouble5) {
/* 684 */         return (paramDouble1 < paramDouble7 && paramDouble7 < paramDouble5) ? 1 : 0;
/*     */       }
/* 686 */       return (paramDouble5 < paramDouble7 && paramDouble7 < paramDouble1) ? -1 : 0;
/*     */     } 
/*     */ 
/*     */     
/* 690 */     b b = new b(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6);
/* 691 */     double d1 = paramDouble7 - paramDouble1;
/* 692 */     double d2 = paramDouble8 - paramDouble2;
/* 693 */     double d3 = paramDouble9 - paramDouble1;
/* 694 */     double d4 = paramDouble10 - paramDouble2;
/*     */     
/* 696 */     double[] arrayOfDouble1 = new double[3];
/* 697 */     double[] arrayOfDouble2 = new double[3];
/* 698 */     int i = b.a(arrayOfDouble1, d1);
/* 699 */     int j = b.a(arrayOfDouble2, d3);
/*     */ 
/*     */     
/* 702 */     if (i == 0 && j == 0) {
/* 703 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 707 */     double d5 = d1 - 1.0E-5D;
/* 708 */     double d6 = d3 + 1.0E-5D;
/* 709 */     double[] arrayOfDouble3 = new double[28];
/* 710 */     int k = 0;
/*     */     
/* 712 */     k = b.a(arrayOfDouble3, k, arrayOfDouble1, i, d5, d6, false, 0);
/* 713 */     k = b.a(arrayOfDouble3, k, arrayOfDouble2, j, d5, d6, false, 1);
/*     */     
/* 715 */     j = b.c(arrayOfDouble2);
/* 716 */     k = b.a(arrayOfDouble3, k, arrayOfDouble2, j, d5, d6, true, 2);
/*     */     
/* 718 */     if (paramDouble7 < paramDouble1 && paramDouble1 < paramDouble9) {
/* 719 */       arrayOfDouble3[k++] = 0.0D;
/* 720 */       arrayOfDouble3[k++] = 0.0D;
/* 721 */       arrayOfDouble3[k++] = 0.0D;
/* 722 */       arrayOfDouble3[k++] = 4.0D;
/*     */     } 
/* 724 */     if (paramDouble7 < paramDouble5 && paramDouble5 < paramDouble9) {
/* 725 */       arrayOfDouble3[k++] = 1.0D;
/* 726 */       arrayOfDouble3[k++] = b.aa;
/* 727 */       arrayOfDouble3[k++] = b.ab;
/* 728 */       arrayOfDouble3[k++] = 5.0D;
/*     */     } 
/*     */ 
/*     */     
/* 732 */     int m = a(arrayOfDouble3, k, d2, d4);
/* 733 */     if (m != 254) {
/* 734 */       return m;
/*     */     }
/* 736 */     return b.b(arrayOfDouble1, i, d2, d4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9, double paramDouble10, double paramDouble11, double paramDouble12) {
/* 745 */     if ((paramDouble11 < paramDouble1 && paramDouble11 < paramDouble3 && paramDouble11 < paramDouble5 && paramDouble11 < paramDouble7) || (paramDouble9 > paramDouble1 && paramDouble9 > paramDouble3 && paramDouble9 > paramDouble5 && paramDouble9 > paramDouble7) || (paramDouble10 > paramDouble2 && paramDouble10 > paramDouble4 && paramDouble10 > paramDouble6 && paramDouble10 > paramDouble8))
/*     */     {
/*     */ 
/*     */       
/* 749 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 753 */     if (paramDouble12 < paramDouble2 && paramDouble12 < paramDouble4 && paramDouble12 < paramDouble6 && paramDouble12 < paramDouble8 && paramDouble9 != paramDouble1 && paramDouble9 != paramDouble7) {
/* 754 */       if (paramDouble1 < paramDouble7) {
/* 755 */         return (paramDouble1 < paramDouble9 && paramDouble9 < paramDouble7) ? 1 : 0;
/*     */       }
/* 757 */       return (paramDouble7 < paramDouble9 && paramDouble9 < paramDouble1) ? -1 : 0;
/*     */     } 
/*     */ 
/*     */     
/* 761 */     a a1 = new a(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramDouble7, paramDouble8);
/* 762 */     double d1 = paramDouble9 - paramDouble1;
/* 763 */     double d2 = paramDouble10 - paramDouble2;
/* 764 */     double d3 = paramDouble11 - paramDouble1;
/* 765 */     double d4 = paramDouble12 - paramDouble2;
/*     */     
/* 767 */     double[] arrayOfDouble1 = new double[3];
/* 768 */     double[] arrayOfDouble2 = new double[3];
/* 769 */     int i = a1.a(arrayOfDouble1, d1);
/* 770 */     int j = a1.a(arrayOfDouble2, d3);
/*     */ 
/*     */     
/* 773 */     if (i == 0 && j == 0) {
/* 774 */       return 0;
/*     */     }
/*     */     
/* 777 */     double d5 = d1 - 1.0E-5D;
/* 778 */     double d6 = d3 + 1.0E-5D;
/*     */ 
/*     */     
/* 781 */     double[] arrayOfDouble3 = new double[40];
/* 782 */     int k = 0;
/*     */     
/* 784 */     k = a1.a(arrayOfDouble3, k, arrayOfDouble1, i, d5, d6, false, 0);
/* 785 */     k = a1.a(arrayOfDouble3, k, arrayOfDouble2, j, d5, d6, false, 1);
/*     */     
/* 787 */     j = a1.a(arrayOfDouble2);
/* 788 */     k = a1.a(arrayOfDouble3, k, arrayOfDouble2, j, d5, d6, true, 2);
/* 789 */     j = a1.b(arrayOfDouble2);
/* 790 */     k = a1.a(arrayOfDouble3, k, arrayOfDouble2, j, d5, d6, true, 4);
/*     */     
/* 792 */     if (paramDouble9 < paramDouble1 && paramDouble1 < paramDouble11) {
/* 793 */       arrayOfDouble3[k++] = 0.0D;
/* 794 */       arrayOfDouble3[k++] = 0.0D;
/* 795 */       arrayOfDouble3[k++] = 0.0D;
/* 796 */       arrayOfDouble3[k++] = 6.0D;
/*     */     } 
/* 798 */     if (paramDouble9 < paramDouble7 && paramDouble7 < paramDouble11) {
/* 799 */       arrayOfDouble3[k++] = 1.0D;
/* 800 */       arrayOfDouble3[k++] = a1.aa;
/* 801 */       arrayOfDouble3[k++] = a1.ab;
/* 802 */       arrayOfDouble3[k++] = 7.0D;
/*     */     } 
/*     */ 
/*     */     
/* 806 */     int m = a(arrayOfDouble3, k, d2, d4);
/* 807 */     if (m != 254) {
/* 808 */       return m;
/*     */     }
/* 810 */     return a1.b(arrayOfDouble1, i, d2, d4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a(PathIterator paramPathIterator, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
/* 818 */     int i = 0;
/*     */ 
/*     */     
/* 821 */     double d4 = 0.0D, d3 = d4, d2 = d3, d1 = d2;
/* 822 */     double[] arrayOfDouble = new double[6];
/*     */     
/* 824 */     double d5 = paramDouble1;
/* 825 */     double d6 = paramDouble2;
/* 826 */     double d7 = paramDouble1 + paramDouble3;
/* 827 */     double d8 = paramDouble2 + paramDouble4;
/*     */     
/* 829 */     while (!paramPathIterator.isDone()) {
/* 830 */       int j = 0;
/* 831 */       switch (paramPathIterator.currentSegment(arrayOfDouble)) {
/*     */         case 0:
/* 833 */           if (d3 != d1 || d4 != d2) {
/* 834 */             j = b(d3, d4, d1, d2, d5, d6, d7, d8);
/*     */           }
/* 836 */           d1 = d3 = arrayOfDouble[0];
/* 837 */           d2 = d4 = arrayOfDouble[1];
/*     */         
/*     */         case 1:
/* 840 */           j = b(d3, d4, d3 = arrayOfDouble[0], d4 = arrayOfDouble[1], d5, d6, d7, d8);
/*     */         
/*     */         case 2:
/* 843 */           j = b(d3, d4, arrayOfDouble[0], arrayOfDouble[1], d3 = arrayOfDouble[2], d4 = arrayOfDouble[3], d5, d6, d7, d8);
/*     */         
/*     */         case 3:
/* 846 */           j = a(d3, d4, arrayOfDouble[0], arrayOfDouble[1], arrayOfDouble[2], arrayOfDouble[3], d3 = arrayOfDouble[4], d4 = arrayOfDouble[5], d5, d6, d7, d8);
/*     */         
/*     */         case 4:
/* 849 */           if (d4 != d2 || d3 != d1) {
/* 850 */             j = b(d3, d4, d1, d2, d5, d6, d7, d8);
/*     */           }
/* 852 */           d3 = d1;
/* 853 */           d4 = d2;
/*     */           break;
/*     */       } 
/* 856 */       if (j == 255) {
/* 857 */         return 255;
/*     */       }
/* 859 */       i += j;
/* 860 */       paramPathIterator.next();
/*     */     } 
/* 862 */     if (d4 != d2) {
/* 863 */       int j = b(d3, d4, d1, d2, d5, d6, d7, d8);
/* 864 */       if (j == 255) {
/* 865 */         return 255;
/*     */       }
/* 867 */       i += j;
/*     */     } 
/* 869 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a(Shape paramShape, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
/* 876 */     if (!paramShape.getBounds2D().intersects(paramDouble1, paramDouble2, paramDouble3, paramDouble4)) {
/* 877 */       return 0;
/*     */     }
/* 879 */     return a(paramShape.getPathIterator(null), paramDouble1, paramDouble2, paramDouble3, paramDouble4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean u(int paramInt) {
/* 886 */     return (paramInt != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean v(int paramInt) {
/* 893 */     return ((paramInt & 0x1) != 0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\d\a\a\a\a\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */