/*     */ package com.google.a.k;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.b.a.a;
/*     */ import java.math.BigInteger;
/*     */ import java.math.RoundingMode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b
/*     */ @a
/*     */ final class h
/*     */ {
/*     */   static int a(String paramString, int paramInt) {
/*  32 */     if (paramInt <= 0) {
/*  33 */       throw new IllegalArgumentException((new StringBuilder(26 + String.valueOf(paramString).length())).append(paramString).append(" (").append(paramInt).append(") must be > 0").toString());
/*     */     }
/*  35 */     return paramInt;
/*     */   }
/*     */   
/*     */   static long a(String paramString, long paramLong) {
/*  39 */     if (paramLong <= 0L) {
/*  40 */       throw new IllegalArgumentException((new StringBuilder(35 + String.valueOf(paramString).length())).append(paramString).append(" (").append(paramLong).append(") must be > 0").toString());
/*     */     }
/*  42 */     return paramLong;
/*     */   }
/*     */   
/*     */   static BigInteger a(String paramString, BigInteger paramBigInteger) {
/*  46 */     if (paramBigInteger.signum() <= 0) {
/*  47 */       String str = String.valueOf(paramBigInteger); throw new IllegalArgumentException((new StringBuilder(15 + String.valueOf(paramString).length() + String.valueOf(str).length())).append(paramString).append(" (").append(str).append(") must be > 0").toString());
/*     */     } 
/*  49 */     return paramBigInteger;
/*     */   }
/*     */   
/*     */   static int b(String paramString, int paramInt) {
/*  53 */     if (paramInt < 0) {
/*  54 */       throw new IllegalArgumentException((new StringBuilder(27 + String.valueOf(paramString).length())).append(paramString).append(" (").append(paramInt).append(") must be >= 0").toString());
/*     */     }
/*  56 */     return paramInt;
/*     */   }
/*     */   
/*     */   static long b(String paramString, long paramLong) {
/*  60 */     if (paramLong < 0L) {
/*  61 */       throw new IllegalArgumentException((new StringBuilder(36 + String.valueOf(paramString).length())).append(paramString).append(" (").append(paramLong).append(") must be >= 0").toString());
/*     */     }
/*  63 */     return paramLong;
/*     */   }
/*     */   
/*     */   static BigInteger b(String paramString, BigInteger paramBigInteger) {
/*  67 */     if (paramBigInteger.signum() < 0) {
/*  68 */       String str = String.valueOf(paramBigInteger); throw new IllegalArgumentException((new StringBuilder(16 + String.valueOf(paramString).length() + String.valueOf(str).length())).append(paramString).append(" (").append(str).append(") must be >= 0").toString());
/*     */     } 
/*  70 */     return paramBigInteger;
/*     */   }
/*     */   
/*     */   static double a(String paramString, double paramDouble) {
/*  74 */     if (paramDouble < 0.0D) {
/*  75 */       throw new IllegalArgumentException((new StringBuilder(40 + String.valueOf(paramString).length())).append(paramString).append(" (").append(paramDouble).append(") must be >= 0").toString());
/*     */     }
/*  77 */     return paramDouble;
/*     */   }
/*     */   
/*     */   static void af(boolean paramBoolean) {
/*  81 */     if (!paramBoolean) {
/*  82 */       throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
/*     */     }
/*     */   }
/*     */   
/*     */   static void a(boolean paramBoolean, double paramDouble, RoundingMode paramRoundingMode) {
/*  87 */     if (!paramBoolean) {
/*  88 */       String str = String.valueOf(paramRoundingMode); throw new ArithmeticException((new StringBuilder(83 + String.valueOf(str).length())).append("rounded value is out of range for input ").append(paramDouble).append(" and rounding mode ").append(str).toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static void d(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {
/*  94 */     if (!paramBoolean) {
/*  95 */       throw new ArithmeticException((new StringBuilder(36 + String.valueOf(paramString).length())).append("overflow: ").append(paramString).append("(").append(paramInt1).append(", ").append(paramInt2).append(")").toString());
/*     */     }
/*     */   }
/*     */   
/*     */   static void d(boolean paramBoolean, String paramString, long paramLong1, long paramLong2) {
/* 100 */     if (!paramBoolean)
/* 101 */       throw new ArithmeticException((new StringBuilder(54 + String.valueOf(paramString).length())).append("overflow: ").append(paramString).append("(").append(paramLong1).append(", ").append(paramLong2).append(")").toString()); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\k\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */