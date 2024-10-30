/*     */ package com.a.b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class a
/*     */ {
/*  39 */   public static final Object au = new Object();
/*  40 */   public static final Object av = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double c(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
/*  55 */     double d1 = paramDouble3 - paramDouble1;
/*  56 */     double d2 = paramDouble4 - paramDouble2;
/*  57 */     double d3 = 0.0D;
/*     */     
/*  59 */     if (d1 == 0.0D) {
/*  60 */       if (d2 == 0.0D) return 0.0D; 
/*  61 */       d3 = 1.5707963267948966D;
/*     */     } else {
/*     */       
/*  64 */       d3 = Math.atan(d2 / d1);
/*  65 */       if (d3 < 0.0D) d3 = -d3;
/*     */     
/*     */     } 
/*  68 */     if (paramDouble3 >= paramDouble1)
/*  69 */     { if (paramDouble4 < paramDouble2) d3 = 6.283185307179586D - d3;
/*     */        }
/*     */     
/*  72 */     else if (paramDouble4 < paramDouble2) { d3 = Math.PI + d3; }
/*  73 */     else { d3 = Math.PI - d3; }
/*     */     
/*  75 */     return d3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double a(b paramb1, b paramb2) {
/*  84 */     return c(paramb1.getX(), paramb1.getY(), paramb2.getX(), paramb2.getY());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double[] paramArrayOfdouble) {
/*  94 */     double d1 = paramDouble3 - paramDouble1;
/*  95 */     double d2 = paramDouble4 - paramDouble2;
/*  96 */     double d3 = 0.0D;
/*  97 */     double d4 = d1 * d1 + d2 * d2;
/*     */     
/*  99 */     if (d4 != 0.0D) {
/* 100 */       d3 = (d1 * (paramDouble5 - paramDouble1) + d2 * (paramDouble6 - paramDouble2)) / d4;
/*     */     }
/* 102 */     double d5 = paramDouble1 + d3 * d1;
/* 103 */     double d6 = paramDouble2 + d3 * d2;
/*     */     
/* 105 */     if (paramArrayOfdouble != null) {
/* 106 */       paramArrayOfdouble[0] = d5;
/* 107 */       paramArrayOfdouble[1] = d6;
/* 108 */       paramArrayOfdouble[2] = d3;
/*     */     } 
/*     */     
/* 111 */     double d7 = paramDouble5 - d5;
/* 112 */     double d8 = paramDouble6 - d6;
/* 113 */     return d7 * d7 + d8 * d8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double[] paramArrayOfdouble) {
/* 123 */     double d1 = paramDouble3 - paramDouble1;
/* 124 */     double d2 = paramDouble4 - paramDouble2;
/* 125 */     double d3 = 0.0D;
/* 126 */     double d4 = d1 * d1 + d2 * d2;
/*     */     
/* 128 */     if (d4 != 0.0D) {
/* 129 */       d3 = (d1 * (paramDouble5 - paramDouble1) + d2 * (paramDouble6 - paramDouble2)) / d4;
/*     */     }
/* 131 */     if (d3 < 0.0D) { d3 = 0.0D; }
/* 132 */     else if (d3 > 1.0D) { d3 = 1.0D; }
/*     */     
/* 134 */     double d5 = paramDouble1 + d3 * d1;
/* 135 */     double d6 = paramDouble2 + d3 * d2;
/*     */     
/* 137 */     if (paramArrayOfdouble != null) {
/* 138 */       paramArrayOfdouble[0] = d5;
/* 139 */       paramArrayOfdouble[1] = d6;
/* 140 */       paramArrayOfdouble[2] = d3;
/*     */     } 
/*     */     
/* 143 */     double d7 = paramDouble5 - d5;
/* 144 */     double d8 = paramDouble6 - d6;
/* 145 */     return d7 * d7 + d8 * d8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double a(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2, double[] paramArrayOfdouble3, double[] paramArrayOfdouble4, int paramInt) {
/* 155 */     for (byte b1 = 0; b1 < paramInt; b1++) {
/* 156 */       paramArrayOfdouble4[b1] = paramArrayOfdouble2[b1] - paramArrayOfdouble1[b1];
/*     */     }
/* 158 */     double d1 = 0.0D;
/* 159 */     for (byte b2 = 0; b2 < paramInt; b2++) {
/* 160 */       d1 += paramArrayOfdouble4[b2] * paramArrayOfdouble4[b2];
/*     */     }
/* 162 */     double d2 = 0.0D;
/*     */     
/* 164 */     if (d1 != 0.0D) {
/* 165 */       double d = 0.0D;
/* 166 */       for (byte b = 0; b < paramInt; b++) {
/* 167 */         d += paramArrayOfdouble4[b] * (paramArrayOfdouble3[b] - paramArrayOfdouble1[b]);
/*     */       }
/* 169 */       d2 = d / d1;
/*     */     } 
/*     */     
/* 172 */     for (byte b3 = 0; b3 < paramInt; b3++) {
/* 173 */       paramArrayOfdouble4[b3] = paramArrayOfdouble1[b3] + d2 * paramArrayOfdouble4[b3];
/*     */     }
/* 175 */     paramArrayOfdouble4[paramInt] = d2;
/*     */     
/* 177 */     double d3 = 0.0D;
/* 178 */     for (byte b4 = 0; b4 < paramInt; b4++) {
/* 179 */       double d = paramArrayOfdouble3[b4] - paramArrayOfdouble4[b4];
/* 180 */       d3 += d * d;
/*     */     } 
/*     */     
/* 183 */     return d3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double b(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2, double[] paramArrayOfdouble3, double[] paramArrayOfdouble4, int paramInt) {
/* 193 */     for (byte b1 = 0; b1 < paramInt; b1++) {
/* 194 */       paramArrayOfdouble4[b1] = paramArrayOfdouble2[b1] - paramArrayOfdouble1[b1];
/*     */     }
/* 196 */     double d1 = 0.0D;
/* 197 */     for (byte b2 = 0; b2 < paramInt; b2++) {
/* 198 */       d1 += paramArrayOfdouble4[b2] * paramArrayOfdouble4[b2];
/*     */     }
/* 200 */     double d2 = 0.0D;
/*     */     
/* 202 */     if (d1 != 0.0D) {
/* 203 */       double d = 0.0D;
/* 204 */       for (byte b = 0; b < paramInt; b++) {
/* 205 */         d += paramArrayOfdouble4[b] * (paramArrayOfdouble3[b] - paramArrayOfdouble1[b]);
/*     */       }
/* 207 */       d2 = d / d1;
/*     */     } 
/*     */     
/* 210 */     if (d2 < 0.0D) { d2 = 0.0D; }
/* 211 */     else if (d2 > 1.0D) { d2 = 1.0D; }
/*     */     
/* 213 */     for (byte b3 = 0; b3 < paramInt; b3++) {
/* 214 */       paramArrayOfdouble4[b3] = paramArrayOfdouble1[b3] + d2 * paramArrayOfdouble4[b3];
/*     */     }
/* 216 */     paramArrayOfdouble4[paramInt] = d2;
/*     */     
/* 218 */     double d3 = 0.0D;
/* 219 */     for (byte b4 = 0; b4 < paramInt; b4++) {
/* 220 */       double d = paramArrayOfdouble3[b4] - paramArrayOfdouble4[b4];
/* 221 */       d3 += d * d;
/*     */     } 
/*     */     
/* 224 */     return d3;
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
/*     */   public static Object a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double[] paramArrayOfdouble) {
/* 236 */     double d1 = paramDouble3 - paramDouble1;
/* 237 */     double d2 = paramDouble4 - paramDouble2;
/* 238 */     double d3 = paramDouble7 - paramDouble5;
/* 239 */     double d4 = paramDouble8 - paramDouble6;
/*     */     
/* 241 */     double d5 = d1 * d4 - d2 * d3;
/*     */     
/* 243 */     if (d5 == 0.0D) {
/* 244 */       return au;
/*     */     }
/* 246 */     double d6 = paramDouble5 - paramDouble1;
/* 247 */     double d7 = paramDouble6 - paramDouble2;
/*     */     
/* 249 */     double d8 = (d6 * d4 - d7 * d3) / d5;
/*     */     
/* 251 */     if (paramArrayOfdouble != null) {
/* 252 */       paramArrayOfdouble[0] = paramDouble1 + d8 * d1;
/* 253 */       paramArrayOfdouble[1] = paramDouble2 + d8 * d2;
/* 254 */       paramArrayOfdouble[2] = d8;
/*     */     } 
/*     */     
/* 257 */     return av;
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
/*     */   public static Object b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double[] paramArrayOfdouble) {
/* 269 */     double d1 = paramDouble3 - paramDouble1;
/* 270 */     double d2 = paramDouble4 - paramDouble2;
/* 271 */     double d3 = paramDouble7 - paramDouble5;
/* 272 */     double d4 = paramDouble8 - paramDouble6;
/*     */     
/* 274 */     double d5 = d1 * d4 - d2 * d3;
/*     */     
/* 276 */     if (d5 == 0.0D) {
/* 277 */       return au;
/*     */     }
/* 279 */     double d6 = paramDouble5 - paramDouble1;
/* 280 */     double d7 = paramDouble6 - paramDouble2;
/*     */     
/* 282 */     double d8 = (d6 * d2 - d7 * d1) / d5;
/* 283 */     if (d8 < 0.0D || d8 > 1.0D) return null;
/*     */     
/* 285 */     if (paramArrayOfdouble != null) {
/* 286 */       paramArrayOfdouble[0] = paramDouble5 + d8 * d3;
/* 287 */       paramArrayOfdouble[1] = paramDouble6 + d8 * d4;
/* 288 */       paramArrayOfdouble[2] = d8;
/*     */     } 
/*     */     
/* 291 */     return av;
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
/*     */   public static Object c(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double[] paramArrayOfdouble) {
/* 304 */     double d1 = paramDouble3 - paramDouble1;
/* 305 */     double d2 = paramDouble4 - paramDouble2;
/* 306 */     double d3 = paramDouble7 - paramDouble5;
/* 307 */     double d4 = paramDouble8 - paramDouble6;
/*     */     
/* 309 */     double d5 = d1 * d4 - d2 * d3;
/*     */     
/* 311 */     if (d5 == 0.0D) {
/* 312 */       return au;
/*     */     }
/* 314 */     double d6 = paramDouble5 - paramDouble1;
/* 315 */     double d7 = paramDouble6 - paramDouble2;
/*     */     
/* 317 */     double d8 = (d6 * d4 - d7 * d3) / d5;
/*     */     
/* 319 */     if (d8 < 0.0D || d8 > 1.0D) return null;
/*     */     
/* 321 */     double d9 = (d6 * d2 - d7 * d1) / d5;
/*     */     
/* 323 */     if (d9 < 0.0D || d9 > 1.0D) return null;
/*     */     
/* 325 */     if (paramArrayOfdouble != null) {
/* 326 */       paramArrayOfdouble[0] = paramDouble1 + d8 * d1;
/* 327 */       paramArrayOfdouble[1] = paramDouble2 + d8 * d2;
/* 328 */       paramArrayOfdouble[2] = d8;
/*     */     } 
/*     */     
/* 331 */     return av;
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
/*     */   public static boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double[] paramArrayOfdouble) {
/* 346 */     double d1 = paramDouble3 - paramDouble1;
/* 347 */     double d2 = paramDouble4 - paramDouble2;
/* 348 */     double d3 = paramDouble1 - paramDouble5;
/* 349 */     double d4 = paramDouble2 - paramDouble6;
/*     */     
/* 351 */     double d5 = d1 * d4 - d2 * d3;
/*     */     
/* 353 */     if (d5 == 0.0D) {
/* 354 */       return false;
/*     */     }
/* 356 */     double d6 = paramDouble5 - paramDouble3;
/* 357 */     double d7 = paramDouble6 - paramDouble4;
/* 358 */     double d8 = d6 * d3 + d7 * d4;
/*     */     
/* 360 */     double d9 = d8 / d5;
/* 361 */     double d10 = paramDouble1 + (d1 - d9 * d2) / 2.0D;
/* 362 */     double d11 = paramDouble2 + (d2 + d9 * d1) / 2.0D;
/*     */     
/* 364 */     double d12 = paramDouble1 - d10;
/* 365 */     double d13 = paramDouble2 - d11;
/* 366 */     double d14 = d12 * d12 + d13 * d13;
/*     */     
/* 368 */     if (paramArrayOfdouble != null) {
/* 369 */       paramArrayOfdouble[0] = d10;
/* 370 */       paramArrayOfdouble[1] = d11;
/* 371 */       paramArrayOfdouble[2] = d14;
/*     */     } 
/*     */     
/* 374 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6) {
/* 382 */     double d1 = paramDouble1 - paramDouble3;
/* 383 */     double d2 = paramDouble2 - paramDouble4;
/*     */     
/* 385 */     double d3 = paramDouble3 - paramDouble5;
/* 386 */     double d4 = paramDouble4 - paramDouble6;
/*     */     
/* 388 */     double d5 = paramDouble5 - paramDouble1;
/* 389 */     double d6 = paramDouble6 - paramDouble2;
/*     */     
/* 391 */     double d7 = (d1 * d1 + d2 * d2) / 2.0D;
/* 392 */     double d8 = (d3 * d3 + d4 * d4) / 2.0D;
/* 393 */     double d9 = (d5 * d5 + d6 * d6) / 2.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 398 */     if (d8 < d7) {
/* 399 */       double d = d7;
/* 400 */       d7 = d8;
/* 401 */       d8 = d;
/*     */     } 
/*     */     
/* 404 */     if (d9 < d7) {
/* 405 */       double d = d7;
/* 406 */       d7 = d9;
/* 407 */       d9 = d;
/*     */     } 
/*     */     
/* 410 */     double d10 = (d7 + d8 - d9) / 2.0D;
/* 411 */     return d7 * d8 - d10 * d10;
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
/*     */   public static double b(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 425 */     if (paramDouble1 < 0.0D)
/* 426 */       throw new IllegalArgumentException("a >= 0 required"); 
/* 427 */     if (paramDouble2 < 0.0D)
/* 428 */       throw new IllegalArgumentException("b >= 0 required"); 
/* 429 */     if (paramDouble3 < 0.0D) {
/* 430 */       throw new IllegalArgumentException("c >= 0 required");
/*     */     }
/* 432 */     if (paramDouble1 > paramDouble2 + paramDouble3)
/* 433 */       throw new IllegalArgumentException("a <= b + c required"); 
/* 434 */     if (paramDouble2 > paramDouble1 + paramDouble3)
/* 435 */       throw new IllegalArgumentException("b <= a + c required"); 
/* 436 */     if (paramDouble3 > paramDouble1 + paramDouble2) {
/* 437 */       throw new IllegalArgumentException("c <= a + b required");
/*     */     }
/* 439 */     if (paramDouble1 < paramDouble3) {
/* 440 */       double d = paramDouble3;
/* 441 */       paramDouble3 = paramDouble1;
/* 442 */       paramDouble1 = d;
/*     */     } 
/*     */     
/* 445 */     if (paramDouble2 < paramDouble3) {
/* 446 */       double d = paramDouble3;
/* 447 */       paramDouble3 = paramDouble2;
/* 448 */       paramDouble2 = d;
/*     */     } 
/*     */     
/* 451 */     if (paramDouble1 < paramDouble2) {
/* 452 */       double d = paramDouble2;
/* 453 */       paramDouble2 = paramDouble1;
/* 454 */       paramDouble1 = d;
/*     */     } 
/*     */     
/* 457 */     return (paramDouble1 + paramDouble2 + paramDouble3) * (paramDouble3 - paramDouble1 - paramDouble2) * (paramDouble3 + paramDouble1 - paramDouble2) * (paramDouble1 + paramDouble2 - paramDouble3) / 16.0D;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\b\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */