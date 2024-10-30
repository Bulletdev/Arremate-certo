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
/*    */ 
/*    */ public final class Sumx2py2
/*    */   extends XYNumericFunction
/*    */ {
/* 34 */   private static final XYNumericFunction.Accumulator XSquaredPlusYSquaredAccumulator = new XYNumericFunction.Accumulator() {
/*    */       public double accumulate(double param1Double1, double param1Double2) {
/* 36 */         return param1Double1 * param1Double1 + param1Double2 * param1Double2;
/*    */       }
/*    */     };
/*    */   
/*    */   protected XYNumericFunction.Accumulator createAccumulator() {
/* 41 */     return XSquaredPlusYSquaredAccumulator;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Sumx2py2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */