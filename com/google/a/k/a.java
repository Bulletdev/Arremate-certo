/*    */ package com.google.a.k;
/*    */ 
/*    */ import com.google.a.a.c;
/*    */ import java.math.BigDecimal;
/*    */ import java.math.RoundingMode;
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
/*    */ @c
/*    */ public class a
/*    */ {
/*    */   public static double a(BigDecimal paramBigDecimal, RoundingMode paramRoundingMode) {
/* 53 */     return a.a.a(paramBigDecimal, paramRoundingMode);
/*    */   }
/*    */   
/*    */   private static class a extends n<BigDecimal> {
/* 57 */     static final a a = new a();
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     double a(BigDecimal param1BigDecimal) {
/* 63 */       return param1BigDecimal.doubleValue();
/*    */     }
/*    */ 
/*    */     
/*    */     int a(BigDecimal param1BigDecimal) {
/* 68 */       return param1BigDecimal.signum();
/*    */     }
/*    */ 
/*    */     
/*    */     BigDecimal a(double param1Double, RoundingMode param1RoundingMode) {
/* 73 */       return new BigDecimal(param1Double);
/*    */     }
/*    */ 
/*    */     
/*    */     BigDecimal a(BigDecimal param1BigDecimal1, BigDecimal param1BigDecimal2) {
/* 78 */       return param1BigDecimal1.subtract(param1BigDecimal2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\k\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */