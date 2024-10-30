/*    */ package org.apache.poi.ss.formula.functions;
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
/*    */ public final class Odd
/*    */   extends NumericFunction.OneArg
/*    */ {
/*    */   private static final long PARITY_MASK = -2L;
/*    */   
/*    */   protected double evaluate(double paramDouble) {
/* 28 */     if (paramDouble == 0.0D) {
/* 29 */       return 1.0D;
/*    */     }
/* 31 */     return (paramDouble > 0.0D) ? calcOdd(paramDouble) : -calcOdd(-paramDouble);
/*    */   }
/*    */   
/*    */   private static long calcOdd(double paramDouble) {
/* 35 */     double d = paramDouble + 1.0D;
/* 36 */     long l = (long)d & 0xFFFFFFFFFFFFFFFEL;
/* 37 */     return (Double.compare(l, d) == 0) ? (l - 1L) : (l + 1L);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Odd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */