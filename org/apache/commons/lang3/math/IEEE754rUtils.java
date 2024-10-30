/*     */ package org.apache.commons.lang3.math;
/*     */ 
/*     */ import org.apache.commons.lang3.Validate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IEEE754rUtils
/*     */ {
/*     */   public static double min(double... paramVarArgs) {
/*  40 */     Validate.notNull(paramVarArgs, "The Array must not be null", new Object[0]);
/*  41 */     Validate.isTrue((paramVarArgs.length != 0), "Array cannot be empty.", new Object[0]);
/*     */ 
/*     */     
/*  44 */     double d = paramVarArgs[0];
/*  45 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/*  46 */       d = min(paramVarArgs[b], d);
/*     */     }
/*     */     
/*  49 */     return d;
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
/*     */   public static float min(float... paramVarArgs) {
/*  62 */     Validate.notNull(paramVarArgs, "The Array must not be null", new Object[0]);
/*  63 */     Validate.isTrue((paramVarArgs.length != 0), "Array cannot be empty.", new Object[0]);
/*     */ 
/*     */     
/*  66 */     float f = paramVarArgs[0];
/*  67 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/*  68 */       f = min(paramVarArgs[b], f);
/*     */     }
/*     */     
/*  71 */     return f;
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
/*     */   public static double min(double paramDouble1, double paramDouble2, double paramDouble3) {
/*  85 */     return min(min(paramDouble1, paramDouble2), paramDouble3);
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
/*     */   public static double min(double paramDouble1, double paramDouble2) {
/*  98 */     if (Double.isNaN(paramDouble1)) {
/*  99 */       return paramDouble2;
/*     */     }
/* 101 */     if (Double.isNaN(paramDouble2)) {
/* 102 */       return paramDouble1;
/*     */     }
/* 104 */     return Math.min(paramDouble1, paramDouble2);
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
/*     */   public static float min(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 119 */     return min(min(paramFloat1, paramFloat2), paramFloat3);
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
/*     */   public static float min(float paramFloat1, float paramFloat2) {
/* 132 */     if (Float.isNaN(paramFloat1)) {
/* 133 */       return paramFloat2;
/*     */     }
/* 135 */     if (Float.isNaN(paramFloat2)) {
/* 136 */       return paramFloat1;
/*     */     }
/* 138 */     return Math.min(paramFloat1, paramFloat2);
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
/*     */   public static double max(double... paramVarArgs) {
/* 152 */     Validate.notNull(paramVarArgs, "The Array must not be null", new Object[0]);
/* 153 */     Validate.isTrue((paramVarArgs.length != 0), "Array cannot be empty.", new Object[0]);
/*     */ 
/*     */     
/* 156 */     double d = paramVarArgs[0];
/* 157 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 158 */       d = max(paramVarArgs[b], d);
/*     */     }
/*     */     
/* 161 */     return d;
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
/*     */   public static float max(float... paramVarArgs) {
/* 174 */     Validate.notNull(paramVarArgs, "The Array must not be null", new Object[0]);
/* 175 */     Validate.isTrue((paramVarArgs.length != 0), "Array cannot be empty.", new Object[0]);
/*     */ 
/*     */     
/* 178 */     float f = paramVarArgs[0];
/* 179 */     for (byte b = 1; b < paramVarArgs.length; b++) {
/* 180 */       f = max(paramVarArgs[b], f);
/*     */     }
/*     */     
/* 183 */     return f;
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
/*     */   public static double max(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 197 */     return max(max(paramDouble1, paramDouble2), paramDouble3);
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
/*     */   public static double max(double paramDouble1, double paramDouble2) {
/* 210 */     if (Double.isNaN(paramDouble1)) {
/* 211 */       return paramDouble2;
/*     */     }
/* 213 */     if (Double.isNaN(paramDouble2)) {
/* 214 */       return paramDouble1;
/*     */     }
/* 216 */     return Math.max(paramDouble1, paramDouble2);
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
/*     */   public static float max(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 231 */     return max(max(paramFloat1, paramFloat2), paramFloat3);
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
/*     */   public static float max(float paramFloat1, float paramFloat2) {
/* 244 */     if (Float.isNaN(paramFloat1)) {
/* 245 */       return paramFloat2;
/*     */     }
/* 247 */     if (Float.isNaN(paramFloat2)) {
/* 248 */       return paramFloat1;
/*     */     }
/* 250 */     return Math.max(paramFloat1, paramFloat2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\math\IEEE754rUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */