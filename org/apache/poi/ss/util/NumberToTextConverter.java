/*     */ package org.apache.poi.ss.util;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class NumberToTextConverter
/*     */ {
/*     */   private static final long EXCEL_NAN_BITS = -276939487313920L;
/*     */   private static final int MAX_TEXT_LEN = 20;
/*     */   
/*     */   public static String toText(double paramDouble) {
/* 129 */     return rawDoubleBitsToText(Double.doubleToLongBits(paramDouble));
/*     */   }
/*     */   
/*     */   static String rawDoubleBitsToText(long paramLong) {
/* 133 */     long l = paramLong;
/* 134 */     boolean bool = (l < 0L) ? true : false;
/* 135 */     if (bool) {
/* 136 */       l &= Long.MAX_VALUE;
/*     */     }
/* 138 */     if (l == 0L) {
/* 139 */       return bool ? "-0" : "0";
/*     */     }
/* 141 */     ExpandedDouble expandedDouble = new ExpandedDouble(l);
/* 142 */     if (expandedDouble.getBinaryExponent() < -1022)
/*     */     {
/*     */       
/* 145 */       return bool ? "-0" : "0";
/*     */     }
/* 147 */     if (expandedDouble.getBinaryExponent() == 1024) {
/*     */ 
/*     */ 
/*     */       
/* 151 */       if (l == -276939487313920L) {
/* 152 */         return "3.484840871308E+308";
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 157 */       bool = false;
/*     */     } 
/* 159 */     NormalisedDecimal normalisedDecimal = expandedDouble.normaliseBaseTen();
/* 160 */     StringBuilder stringBuilder = new StringBuilder(21);
/* 161 */     if (bool) {
/* 162 */       stringBuilder.append('-');
/*     */     }
/* 164 */     convertToText(stringBuilder, normalisedDecimal);
/* 165 */     return stringBuilder.toString();
/*     */   } private static void convertToText(StringBuilder paramStringBuilder, NormalisedDecimal paramNormalisedDecimal) {
/*     */     String str;
/* 168 */     NormalisedDecimal normalisedDecimal = paramNormalisedDecimal.roundUnits();
/* 169 */     int i = normalisedDecimal.getDecimalExponent();
/*     */     
/* 171 */     if (Math.abs(i) > 98) {
/* 172 */       str = normalisedDecimal.getSignificantDecimalDigitsLastDigitRounded();
/* 173 */       if (str.length() == 16)
/*     */       {
/* 175 */         i++;
/*     */       }
/*     */     } else {
/* 178 */       str = normalisedDecimal.getSignificantDecimalDigits();
/*     */     } 
/* 180 */     int j = countSignifantDigits(str);
/* 181 */     if (i < 0) {
/* 182 */       formatLessThanOne(paramStringBuilder, str, i, j);
/*     */     } else {
/* 184 */       formatGreaterThanOne(paramStringBuilder, str, i, j);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void formatLessThanOne(StringBuilder paramStringBuilder, String paramString, int paramInt1, int paramInt2) {
/* 190 */     int i = -paramInt1 - 1;
/* 191 */     int j = 2 + i + paramInt2;
/*     */     
/* 193 */     if (needsScientificNotation(j)) {
/* 194 */       paramStringBuilder.append(paramString.charAt(0));
/* 195 */       if (paramInt2 > 1) {
/* 196 */         paramStringBuilder.append('.');
/* 197 */         paramStringBuilder.append(paramString.subSequence(1, paramInt2));
/*     */       } 
/* 199 */       paramStringBuilder.append("E-");
/* 200 */       appendExp(paramStringBuilder, -paramInt1);
/*     */       return;
/*     */     } 
/* 203 */     paramStringBuilder.append("0.");
/* 204 */     for (int k = i; k > 0; k--) {
/* 205 */       paramStringBuilder.append('0');
/*     */     }
/* 207 */     paramStringBuilder.append(paramString.subSequence(0, paramInt2));
/*     */   }
/*     */ 
/*     */   
/*     */   private static void formatGreaterThanOne(StringBuilder paramStringBuilder, String paramString, int paramInt1, int paramInt2) {
/* 212 */     if (paramInt1 > 19) {
/*     */       
/* 214 */       paramStringBuilder.append(paramString.charAt(0));
/* 215 */       if (paramInt2 > 1) {
/* 216 */         paramStringBuilder.append('.');
/* 217 */         paramStringBuilder.append(paramString.subSequence(1, paramInt2));
/*     */       } 
/* 219 */       paramStringBuilder.append("E+");
/* 220 */       appendExp(paramStringBuilder, paramInt1);
/*     */       return;
/*     */     } 
/* 223 */     int i = paramInt2 - paramInt1 - 1;
/* 224 */     if (i > 0) {
/* 225 */       paramStringBuilder.append(paramString.subSequence(0, paramInt1 + 1));
/* 226 */       paramStringBuilder.append('.');
/* 227 */       paramStringBuilder.append(paramString.subSequence(paramInt1 + 1, paramInt2));
/*     */       return;
/*     */     } 
/* 230 */     paramStringBuilder.append(paramString.subSequence(0, paramInt2));
/* 231 */     for (int j = -i; j > 0; j--) {
/* 232 */       paramStringBuilder.append('0');
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean needsScientificNotation(int paramInt) {
/* 237 */     return (paramInt > 20);
/*     */   }
/*     */   
/*     */   private static int countSignifantDigits(String paramString) {
/* 241 */     int i = paramString.length() - 1;
/* 242 */     while (paramString.charAt(i) == '0') {
/* 243 */       i--;
/* 244 */       if (i < 0) {
/* 245 */         throw new RuntimeException("No non-zero digits found");
/*     */       }
/*     */     } 
/* 248 */     return i + 1;
/*     */   }
/*     */   
/*     */   private static void appendExp(StringBuilder paramStringBuilder, int paramInt) {
/* 252 */     if (paramInt < 10) {
/* 253 */       paramStringBuilder.append('0');
/* 254 */       paramStringBuilder.append((char)(48 + paramInt));
/*     */       return;
/*     */     } 
/* 257 */     paramStringBuilder.append(paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\NumberToTextConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */