/*    */ package org.apache.poi.ss.util;
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
/*    */ final class IEEEDouble
/*    */ {
/*    */   private static final long EXPONENT_MASK = 9218868437227405312L;
/*    */   private static final int EXPONENT_SHIFT = 52;
/*    */   public static final long FRAC_MASK = 4503599627370495L;
/*    */   public static final int EXPONENT_BIAS = 1023;
/*    */   public static final long FRAC_ASSUMED_HIGH_BIT = 4503599627370496L;
/*    */   public static final int BIASED_EXPONENT_SPECIAL_VALUE = 2047;
/*    */   
/*    */   public static int getBiasedExponent(long paramLong) {
/* 42 */     return (int)((paramLong & 0x7FF0000000000000L) >> 52L);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\IEEEDouble.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */