/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RandomUtils
/*     */ {
/*  40 */   private static final Random RANDOM = new Random();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean nextBoolean() {
/*  67 */     return RANDOM.nextBoolean();
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
/*     */   public static byte[] nextBytes(int paramInt) {
/*  81 */     Validate.isTrue((paramInt >= 0), "Count cannot be negative.", new Object[0]);
/*     */     
/*  83 */     byte[] arrayOfByte = new byte[paramInt];
/*  84 */     RANDOM.nextBytes(arrayOfByte);
/*  85 */     return arrayOfByte;
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
/*     */   public static int nextInt(int paramInt1, int paramInt2) {
/* 103 */     Validate.isTrue((paramInt2 >= paramInt1), "Start value must be smaller or equal to end value.", new Object[0]);
/*     */     
/* 105 */     Validate.isTrue((paramInt1 >= 0), "Both range values must be non-negative.", new Object[0]);
/*     */     
/* 107 */     if (paramInt1 == paramInt2) {
/* 108 */       return paramInt1;
/*     */     }
/*     */     
/* 111 */     return paramInt1 + RANDOM.nextInt(paramInt2 - paramInt1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nextInt() {
/* 122 */     return nextInt(0, 2147483647);
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
/*     */   public static long nextLong(long paramLong1, long paramLong2) {
/* 140 */     Validate.isTrue((paramLong2 >= paramLong1), "Start value must be smaller or equal to end value.", new Object[0]);
/*     */     
/* 142 */     Validate.isTrue((paramLong1 >= 0L), "Both range values must be non-negative.", new Object[0]);
/*     */     
/* 144 */     if (paramLong1 == paramLong2) {
/* 145 */       return paramLong1;
/*     */     }
/*     */     
/* 148 */     return (long)nextDouble(paramLong1, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nextLong() {
/* 159 */     return nextLong(0L, Long.MAX_VALUE);
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
/*     */   public static double nextDouble(double paramDouble1, double paramDouble2) {
/* 177 */     Validate.isTrue((paramDouble2 >= paramDouble1), "Start value must be smaller or equal to end value.", new Object[0]);
/*     */     
/* 179 */     Validate.isTrue((paramDouble1 >= 0.0D), "Both range values must be non-negative.", new Object[0]);
/*     */     
/* 181 */     if (paramDouble1 == paramDouble2) {
/* 182 */       return paramDouble1;
/*     */     }
/*     */     
/* 185 */     return paramDouble1 + (paramDouble2 - paramDouble1) * RANDOM.nextDouble();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double nextDouble() {
/* 196 */     return nextDouble(0.0D, Double.MAX_VALUE);
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
/*     */   public static float nextFloat(float paramFloat1, float paramFloat2) {
/* 214 */     Validate.isTrue((paramFloat2 >= paramFloat1), "Start value must be smaller or equal to end value.", new Object[0]);
/*     */     
/* 216 */     Validate.isTrue((paramFloat1 >= 0.0F), "Both range values must be non-negative.", new Object[0]);
/*     */     
/* 218 */     if (paramFloat1 == paramFloat2) {
/* 219 */       return paramFloat1;
/*     */     }
/*     */     
/* 222 */     return paramFloat1 + (paramFloat2 - paramFloat1) * RANDOM.nextFloat();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static float nextFloat() {
/* 233 */     return nextFloat(0.0F, Float.MAX_VALUE);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\RandomUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */