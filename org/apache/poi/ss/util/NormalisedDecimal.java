/*     */ package org.apache.poi.ss.util;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class NormalisedDecimal
/*     */ {
/*     */   private static final int EXPONENT_OFFSET = 14;
/*  51 */   private static final BigDecimal BD_2_POW_24 = new BigDecimal(BigInteger.ONE.shiftLeft(24));
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int LOG_BASE_10_OF_2_TIMES_2_POW_20 = 315653;
/*     */ 
/*     */   
/*     */   private static final int C_2_POW_19 = 524288;
/*     */ 
/*     */   
/*     */   private static final int FRAC_HALF = 8388608;
/*     */ 
/*     */   
/*     */   private static final long MAX_REP_WHOLE_PART = 1000000000000000L;
/*     */ 
/*     */   
/*     */   private final int _relativeDecimalExponent;
/*     */ 
/*     */   
/*     */   private final long _wholePart;
/*     */ 
/*     */   
/*     */   private final int _fractionalPart;
/*     */ 
/*     */ 
/*     */   
/*     */   public static NormalisedDecimal create(BigInteger paramBigInteger, int paramInt) {
/*     */     byte b;
/*  79 */     if (paramInt > 49 || paramInt < 46) {
/*     */ 
/*     */ 
/*     */       
/*  83 */       int i = 15204352 - paramInt * 315653;
/*  84 */       i += 524288;
/*  85 */       b = -(i >> 20);
/*     */     } else {
/*  87 */       b = 0;
/*     */     } 
/*  89 */     MutableFPNumber mutableFPNumber = new MutableFPNumber(paramBigInteger, paramInt);
/*  90 */     if (b) {
/*  91 */       mutableFPNumber.multiplyByPowerOfTen(-b);
/*     */     }
/*     */     
/*  94 */     switch (mutableFPNumber.get64BitNormalisedExponent()) {
/*     */       case 46:
/*  96 */         if (mutableFPNumber.isAboveMinRep())
/*     */         
/*     */         { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 119 */           mutableFPNumber.normalise64bit();
/*     */           
/* 121 */           return mutableFPNumber.createNormalisedDecimal(b); } case 44: case 45: mutableFPNumber.multiplyByPowerOfTen(1); b--;case 47: case 48: mutableFPNumber.normalise64bit(); return mutableFPNumber.createNormalisedDecimal(b);case 49: if (mutableFPNumber.isBelowMaxRep()) { mutableFPNumber.normalise64bit(); return mutableFPNumber.createNormalisedDecimal(b); }
/*     */       
/*     */       case 50:
/*     */         mutableFPNumber.multiplyByPowerOfTen(-1);
/*     */         b++;
/*     */     } 
/*     */     throw new IllegalStateException("Bad binary exp " + mutableFPNumber.get64BitNormalisedExponent() + "."); } public NormalisedDecimal roundUnits() {
/* 128 */     long l = this._wholePart;
/* 129 */     if (this._fractionalPart >= 8388608) {
/* 130 */       l++;
/*     */     }
/*     */     
/* 133 */     int i = this._relativeDecimalExponent;
/*     */     
/* 135 */     if (l < 1000000000000000L) {
/* 136 */       return new NormalisedDecimal(l, 0, i);
/*     */     }
/* 138 */     return new NormalisedDecimal(l / 10L, 0, i + 1);
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
/*     */ 
/*     */   
/*     */   NormalisedDecimal(long paramLong, int paramInt1, int paramInt2) {
/* 160 */     this._wholePart = paramLong;
/* 161 */     this._fractionalPart = paramInt1;
/* 162 */     this._relativeDecimalExponent = paramInt2;
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
/*     */   public ExpandedDouble normaliseBaseTwo() {
/* 177 */     MutableFPNumber mutableFPNumber = new MutableFPNumber(composeFrac(), 39);
/* 178 */     mutableFPNumber.multiplyByPowerOfTen(this._relativeDecimalExponent);
/* 179 */     mutableFPNumber.normalise64bit();
/* 180 */     return mutableFPNumber.createExpandedDouble();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BigInteger composeFrac() {
/* 187 */     long l = this._wholePart;
/* 188 */     int i = this._fractionalPart;
/* 189 */     return new BigInteger(new byte[] { (byte)(int)(l >> 56L), (byte)(int)(l >> 48L), (byte)(int)(l >> 40L), (byte)(int)(l >> 32L), (byte)(int)(l >> 24L), (byte)(int)(l >> 16L), (byte)(int)(l >> 8L), (byte)(int)(l >> 0L), (byte)(i >> 16), (byte)(i >> 8), (byte)(i >> 0) });
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
/*     */   public String getSignificantDecimalDigits() {
/* 205 */     return Long.toString(this._wholePart);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSignificantDecimalDigitsLastDigitRounded() {
/* 213 */     long l = this._wholePart + 5L;
/* 214 */     StringBuilder stringBuilder = new StringBuilder(24);
/* 215 */     stringBuilder.append(l);
/* 216 */     stringBuilder.setCharAt(stringBuilder.length() - 1, '0');
/* 217 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDecimalExponent() {
/* 224 */     return this._relativeDecimalExponent + 14;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareNormalised(NormalisedDecimal paramNormalisedDecimal) {
/* 231 */     int i = this._relativeDecimalExponent - paramNormalisedDecimal._relativeDecimalExponent;
/* 232 */     if (i != 0) {
/* 233 */       return i;
/*     */     }
/* 235 */     if (this._wholePart > paramNormalisedDecimal._wholePart) {
/* 236 */       return 1;
/*     */     }
/* 238 */     if (this._wholePart < paramNormalisedDecimal._wholePart) {
/* 239 */       return -1;
/*     */     }
/* 241 */     return this._fractionalPart - paramNormalisedDecimal._fractionalPart;
/*     */   }
/*     */   public BigDecimal getFractionalPart() {
/* 244 */     return (new BigDecimal(this._fractionalPart)).divide(BD_2_POW_24);
/*     */   }
/*     */   
/*     */   private String getFractionalDigits() {
/* 248 */     if (this._fractionalPart == 0) {
/* 249 */       return "0";
/*     */     }
/* 251 */     return getFractionalPart().toString().substring(2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 257 */     StringBuilder stringBuilder = new StringBuilder();
/* 258 */     stringBuilder.append(getClass().getName());
/* 259 */     stringBuilder.append(" [");
/* 260 */     String str = String.valueOf(this._wholePart);
/* 261 */     stringBuilder.append(str.charAt(0));
/* 262 */     stringBuilder.append('.');
/* 263 */     stringBuilder.append(str.substring(1));
/* 264 */     stringBuilder.append(' ');
/* 265 */     stringBuilder.append(getFractionalDigits());
/* 266 */     stringBuilder.append("E");
/* 267 */     stringBuilder.append(getDecimalExponent());
/* 268 */     stringBuilder.append("]");
/* 269 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\NormalisedDecimal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */