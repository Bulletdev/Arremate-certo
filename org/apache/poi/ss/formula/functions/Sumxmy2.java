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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class Sumxmy2
/*    */   extends XYNumericFunction
/*    */ {
/* 33 */   private static final XYNumericFunction.Accumulator XMinusYSquaredAccumulator = new XYNumericFunction.Accumulator() {
/*    */       public double accumulate(double param1Double1, double param1Double2) {
/* 35 */         double d = param1Double1 - param1Double2;
/* 36 */         return d * d;
/*    */       }
/*    */     };
/*    */   
/*    */   protected XYNumericFunction.Accumulator createAccumulator() {
/* 41 */     return XMinusYSquaredAccumulator;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Sumxmy2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */