/*    */ package org.apache.poi.ss.util;
/*    */ 
/*    */ import java.math.BigInteger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class ExpandedDouble
/*    */ {
/* 38 */   private static final BigInteger BI_FRAC_MASK = BigInteger.valueOf(4503599627370495L);
/* 39 */   private static final BigInteger BI_IMPLIED_FRAC_MSB = BigInteger.valueOf(4503599627370496L); private final BigInteger _significand;
/*    */   
/*    */   private static BigInteger getFrac(long paramLong) {
/* 42 */     return BigInteger.valueOf(paramLong).and(BI_FRAC_MASK).or(BI_IMPLIED_FRAC_MSB).shiftLeft(11);
/*    */   }
/*    */   private final int _binaryExponent;
/*    */   
/*    */   public static ExpandedDouble fromRawBitsAndExponent(long paramLong, int paramInt) {
/* 47 */     return new ExpandedDouble(getFrac(paramLong), paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ExpandedDouble(long paramLong) {
/* 57 */     int i = (int)(paramLong >> 52L);
/* 58 */     if (i == 0) {
/*    */       
/* 60 */       BigInteger bigInteger = BigInteger.valueOf(paramLong).and(BI_FRAC_MASK);
/* 61 */       int j = 64 - bigInteger.bitLength();
/* 62 */       this._significand = bigInteger.shiftLeft(j);
/* 63 */       this._binaryExponent = (i & 0x7FF) - 1023 - j;
/*    */     } else {
/* 65 */       BigInteger bigInteger = getFrac(paramLong);
/* 66 */       this._significand = bigInteger;
/* 67 */       this._binaryExponent = (i & 0x7FF) - 1023;
/*    */     } 
/*    */   }
/*    */   
/*    */   ExpandedDouble(BigInteger paramBigInteger, int paramInt) {
/* 72 */     if (paramBigInteger.bitLength() != 64) {
/* 73 */       throw new IllegalArgumentException("bad bit length");
/*    */     }
/* 75 */     this._significand = paramBigInteger;
/* 76 */     this._binaryExponent = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NormalisedDecimal normaliseBaseTen() {
/* 85 */     return NormalisedDecimal.create(this._significand, this._binaryExponent);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getBinaryExponent() {
/* 92 */     return this._binaryExponent;
/*    */   }
/*    */   
/*    */   public BigInteger getSignificand() {
/* 96 */     return this._significand;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\ExpandedDouble.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */