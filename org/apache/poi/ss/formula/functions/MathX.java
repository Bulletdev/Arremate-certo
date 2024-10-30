/*     */ package org.apache.poi.ss.formula.functions;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import org.apache.poi.ss.util.NumberToTextConverter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class MathX
/*     */ {
/*     */   public static double round(double paramDouble, int paramInt) {
/*     */     double d;
/*  53 */     if (Double.isNaN(paramDouble) || Double.isInfinite(paramDouble)) {
/*  54 */       d = Double.NaN;
/*     */     } else {
/*     */       
/*  57 */       d = (new BigDecimal(NumberToTextConverter.toText(paramDouble))).setScale(paramInt, RoundingMode.HALF_UP).doubleValue();
/*     */     } 
/*     */     
/*  60 */     return d;
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
/*     */   public static double roundUp(double paramDouble, int paramInt) {
/*     */     double d;
/*  81 */     if (Double.isNaN(paramDouble) || Double.isInfinite(paramDouble)) {
/*  82 */       d = Double.NaN;
/*     */     } else {
/*     */       
/*  85 */       d = BigDecimal.valueOf(paramDouble).setScale(paramInt, RoundingMode.UP).doubleValue();
/*     */     } 
/*     */     
/*  88 */     return d;
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
/*     */   public static double roundDown(double paramDouble, int paramInt) {
/*     */     double d;
/* 109 */     if (Double.isNaN(paramDouble) || Double.isInfinite(paramDouble)) {
/* 110 */       d = Double.NaN;
/*     */     } else {
/*     */       
/* 113 */       d = BigDecimal.valueOf(paramDouble).setScale(paramInt, RoundingMode.DOWN).doubleValue();
/*     */     } 
/*     */     
/* 116 */     return d;
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
/*     */   public static short sign(double paramDouble) {
/* 131 */     return (short)((paramDouble == 0.0D) ? 0 : ((paramDouble < 0.0D) ? -1 : 1));
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
/*     */   public static double average(double[] paramArrayOfdouble) {
/* 143 */     double d1 = 0.0D;
/* 144 */     double d2 = 0.0D; byte b; int i;
/* 145 */     for (b = 0, i = paramArrayOfdouble.length; b < i; b++) {
/* 146 */       d2 += paramArrayOfdouble[b];
/*     */     }
/* 148 */     d1 = d2 / paramArrayOfdouble.length;
/* 149 */     return d1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double sum(double[] paramArrayOfdouble) {
/* 158 */     double d = 0.0D; byte b; int i;
/* 159 */     for (b = 0, i = paramArrayOfdouble.length; b < i; b++) {
/* 160 */       d += paramArrayOfdouble[b];
/*     */     }
/* 162 */     return d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double sumsq(double[] paramArrayOfdouble) {
/* 170 */     double d = 0.0D; byte b; int i;
/* 171 */     for (b = 0, i = paramArrayOfdouble.length; b < i; b++) {
/* 172 */       d += paramArrayOfdouble[b] * paramArrayOfdouble[b];
/*     */     }
/* 174 */     return d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double product(double[] paramArrayOfdouble) {
/* 183 */     double d = 0.0D;
/* 184 */     if (paramArrayOfdouble != null && paramArrayOfdouble.length > 0) {
/* 185 */       d = 1.0D; byte b; int i;
/* 186 */       for (b = 0, i = paramArrayOfdouble.length; b < i; b++) {
/* 187 */         d *= paramArrayOfdouble[b];
/*     */       }
/*     */     } 
/* 190 */     return d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double min(double[] paramArrayOfdouble) {
/* 199 */     double d = Double.POSITIVE_INFINITY; byte b; int i;
/* 200 */     for (b = 0, i = paramArrayOfdouble.length; b < i; b++) {
/* 201 */       d = Math.min(d, paramArrayOfdouble[b]);
/*     */     }
/* 203 */     return d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double max(double[] paramArrayOfdouble) {
/* 212 */     double d = Double.NEGATIVE_INFINITY; byte b; int i;
/* 213 */     for (b = 0, i = paramArrayOfdouble.length; b < i; b++) {
/* 214 */       d = Math.max(d, paramArrayOfdouble[b]);
/*     */     }
/* 216 */     return d;
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
/*     */   public static double floor(double paramDouble1, double paramDouble2) {
/*     */     double d;
/* 237 */     if ((paramDouble1 < 0.0D && paramDouble2 > 0.0D) || (paramDouble1 > 0.0D && paramDouble2 < 0.0D) || (paramDouble2 == 0.0D && paramDouble1 != 0.0D)) {
/* 238 */       d = Double.NaN;
/*     */     } else {
/*     */       
/* 241 */       d = (paramDouble1 == 0.0D || paramDouble2 == 0.0D) ? 0.0D : (Math.floor(paramDouble1 / paramDouble2) * paramDouble2);
/*     */     } 
/*     */     
/* 244 */     return d;
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
/*     */   public static double ceiling(double paramDouble1, double paramDouble2) {
/*     */     double d;
/* 265 */     if ((paramDouble1 < 0.0D && paramDouble2 > 0.0D) || (paramDouble1 > 0.0D && paramDouble2 < 0.0D)) {
/* 266 */       d = Double.NaN;
/*     */     } else {
/*     */       
/* 269 */       d = (paramDouble1 == 0.0D || paramDouble2 == 0.0D) ? 0.0D : (Math.ceil(paramDouble1 / paramDouble2) * paramDouble2);
/*     */     } 
/*     */     
/* 272 */     return d;
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
/*     */   public static double factorial(int paramInt) {
/* 286 */     double d = 1.0D;
/*     */     
/* 288 */     if (paramInt >= 0) {
/* 289 */       if (paramInt <= 170) {
/* 290 */         for (byte b = 1; b <= paramInt; b++) {
/* 291 */           d *= b;
/*     */         }
/*     */       } else {
/*     */         
/* 295 */         d = Double.POSITIVE_INFINITY;
/*     */       } 
/*     */     } else {
/*     */       
/* 299 */       d = Double.NaN;
/*     */     } 
/* 301 */     return d;
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
/*     */   public static double mod(double paramDouble1, double paramDouble2) {
/* 321 */     double d = 0.0D;
/*     */     
/* 323 */     if (paramDouble2 == 0.0D) {
/* 324 */       d = Double.NaN;
/*     */     }
/* 326 */     else if (sign(paramDouble1) == sign(paramDouble2)) {
/* 327 */       d = paramDouble1 % paramDouble2;
/*     */     } else {
/*     */       
/* 330 */       d = (paramDouble1 % paramDouble2 + paramDouble2) % paramDouble2;
/*     */     } 
/*     */     
/* 333 */     return d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double acosh(double paramDouble) {
/* 341 */     return Math.log(Math.sqrt(Math.pow(paramDouble, 2.0D) - 1.0D) + paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double asinh(double paramDouble) {
/* 349 */     return Math.log(Math.sqrt(paramDouble * paramDouble + 1.0D) + paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double atanh(double paramDouble) {
/* 357 */     return Math.log((1.0D + paramDouble) / (1.0D - paramDouble)) / 2.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double cosh(double paramDouble) {
/* 365 */     double d1 = Math.pow(Math.E, paramDouble);
/* 366 */     double d2 = Math.pow(Math.E, -paramDouble);
/* 367 */     return (d1 + d2) / 2.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double sinh(double paramDouble) {
/* 375 */     double d1 = Math.pow(Math.E, paramDouble);
/* 376 */     double d2 = Math.pow(Math.E, -paramDouble);
/* 377 */     return (d1 - d2) / 2.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double tanh(double paramDouble) {
/* 385 */     double d1 = Math.pow(Math.E, paramDouble);
/* 386 */     double d2 = Math.pow(Math.E, -paramDouble);
/* 387 */     return (d1 - d2) / (d1 + d2);
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
/*     */   public static double nChooseK(int paramInt1, int paramInt2) {
/* 402 */     double d = 1.0D;
/* 403 */     if (paramInt1 < 0 || paramInt2 < 0 || paramInt1 < paramInt2) {
/* 404 */       d = Double.NaN;
/*     */     } else {
/*     */       
/* 407 */       int i = Math.min(paramInt1 - paramInt2, paramInt2);
/* 408 */       int j = Math.max(paramInt1 - paramInt2, paramInt2);
/* 409 */       for (int k = j; k < paramInt1; k++) {
/* 410 */         d *= (k + 1);
/*     */       }
/* 412 */       d /= factorial(i);
/*     */     } 
/*     */     
/* 415 */     return d;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\MathX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */