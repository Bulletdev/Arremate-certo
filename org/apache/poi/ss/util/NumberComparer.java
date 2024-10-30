/*     */ package org.apache.poi.ss.util;
/*     */ 
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class NumberComparer
/*     */ {
/*     */   public static int compare(double paramDouble1, double paramDouble2) {
/*  62 */     long l1 = Double.doubleToLongBits(paramDouble1);
/*  63 */     long l2 = Double.doubleToLongBits(paramDouble2);
/*     */     
/*  65 */     int i = IEEEDouble.getBiasedExponent(l1);
/*  66 */     int j = IEEEDouble.getBiasedExponent(l2);
/*     */     
/*  68 */     if (i == 2047) {
/*  69 */       throw new IllegalArgumentException("Special double values are not allowed: " + toHex(paramDouble1));
/*     */     }
/*  71 */     if (j == 2047) {
/*  72 */       throw new IllegalArgumentException("Special double values are not allowed: " + toHex(paramDouble1));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  78 */     boolean bool1 = (l1 < 0L) ? true : false;
/*  79 */     boolean bool2 = (l2 < 0L) ? true : false;
/*     */ 
/*     */     
/*  82 */     if (bool1 != bool2)
/*     */     {
/*     */       
/*  85 */       return bool1 ? -1 : 1;
/*     */     }
/*     */ 
/*     */     
/*  89 */     int k = i - j;
/*  90 */     int m = Math.abs(k);
/*  91 */     if (m > 1) {
/*  92 */       return bool1 ? -k : k;
/*     */     }
/*     */     
/*  95 */     if (m != 1)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 100 */       if (l1 == l2)
/*     */       {
/* 102 */         return 0;
/*     */       }
/*     */     }
/* 105 */     if (i == 0) {
/* 106 */       if (j == 0) {
/* 107 */         return compareSubnormalNumbers(l1 & 0xFFFFFFFFFFFFFL, l2 & 0xFFFFFFFFFFFFFL, bool1);
/*     */       }
/*     */       
/* 110 */       return -compareAcrossSubnormalThreshold(l2, l1, bool1);
/*     */     } 
/* 112 */     if (j == 0)
/*     */     {
/* 114 */       return compareAcrossSubnormalThreshold(l1, l2, bool1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 119 */     ExpandedDouble expandedDouble1 = ExpandedDouble.fromRawBitsAndExponent(l1, i - 1023);
/* 120 */     ExpandedDouble expandedDouble2 = ExpandedDouble.fromRawBitsAndExponent(l2, j - 1023);
/* 121 */     NormalisedDecimal normalisedDecimal1 = expandedDouble1.normaliseBaseTen().roundUnits();
/* 122 */     NormalisedDecimal normalisedDecimal2 = expandedDouble2.normaliseBaseTen().roundUnits();
/* 123 */     k = normalisedDecimal1.compareNormalised(normalisedDecimal2);
/* 124 */     if (bool1) {
/* 125 */       return -k;
/*     */     }
/* 127 */     return k;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int compareSubnormalNumbers(long paramLong1, long paramLong2, boolean paramBoolean) {
/* 134 */     byte b = (paramLong1 > paramLong2) ? 1 : ((paramLong1 < paramLong2) ? -1 : 0);
/*     */     
/* 136 */     return paramBoolean ? -b : b;
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
/*     */   private static int compareAcrossSubnormalThreshold(long paramLong1, long paramLong2, boolean paramBoolean) {
/* 148 */     long l1 = paramLong2 & 0xFFFFFFFFFFFFFL;
/* 149 */     if (l1 == 0L)
/*     */     {
/* 151 */       return paramBoolean ? -1 : 1;
/*     */     }
/* 153 */     long l2 = paramLong1 & 0xFFFFFFFFFFFFFL;
/* 154 */     if (l2 <= 7L && l1 >= 4503599627370490L) {
/*     */       
/* 156 */       if (l2 == 7L && l1 == 4503599627370490L)
/*     */       {
/* 158 */         return 0;
/*     */       }
/*     */       
/* 161 */       return paramBoolean ? 1 : -1;
/*     */     } 
/*     */     
/* 164 */     return paramBoolean ? -1 : 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String toHex(double paramDouble) {
/* 173 */     return "0x" + Long.toHexString(Double.doubleToLongBits(paramDouble)).toUpperCase(Locale.ROOT);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\NumberComparer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */