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
/*    */ public abstract class MinaMaxa
/*    */   extends MultiOperandNumericFunction
/*    */ {
/*    */   protected MinaMaxa() {
/* 27 */     super(true, true);
/*    */   }
/*    */   
/* 30 */   public static final Function MAXA = new MinaMaxa() {
/*    */       protected double evaluate(double[] param1ArrayOfdouble) {
/* 32 */         return (param1ArrayOfdouble.length > 0) ? MathX.max(param1ArrayOfdouble) : 0.0D;
/*    */       }
/*    */     };
/* 35 */   public static final Function MINA = new MinaMaxa() {
/*    */       protected double evaluate(double[] param1ArrayOfdouble) {
/* 37 */         return (param1ArrayOfdouble.length > 0) ? MathX.min(param1ArrayOfdouble) : 0.0D;
/*    */       }
/*    */     };
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\MinaMaxa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */