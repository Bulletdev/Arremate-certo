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
/*    */ 
/*    */ public final class Even
/*    */   extends NumericFunction.OneArg
/*    */ {
/*    */   private static final long PARITY_MASK = -2L;
/*    */   
/*    */   protected double evaluate(double paramDouble) {
/*    */     long l;
/* 30 */     if (paramDouble == 0.0D) {
/* 31 */       return 0.0D;
/*    */     }
/*    */     
/* 34 */     if (paramDouble > 0.0D) {
/* 35 */       l = calcEven(paramDouble);
/*    */     } else {
/* 37 */       l = -calcEven(-paramDouble);
/*    */     } 
/* 39 */     return l;
/*    */   }
/*    */   
/*    */   private static long calcEven(double paramDouble) {
/* 43 */     long l = (long)paramDouble & 0xFFFFFFFFFFFFFFFEL;
/* 44 */     if (l == paramDouble) {
/* 45 */       return l;
/*    */     }
/* 47 */     return l + 2L;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Even.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */