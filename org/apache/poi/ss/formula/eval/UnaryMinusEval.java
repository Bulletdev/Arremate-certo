/*    */ package org.apache.poi.ss.formula.eval;
/*    */ 
/*    */ import org.apache.poi.ss.formula.functions.Fixed1ArgFunction;
/*    */ import org.apache.poi.ss.formula.functions.Function;
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
/*    */ public final class UnaryMinusEval
/*    */   extends Fixed1ArgFunction
/*    */ {
/* 28 */   public static final Function instance = (Function)new UnaryMinusEval();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval) {
/*    */     double d;
/*    */     try {
/* 37 */       ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/* 38 */       d = OperandResolver.coerceValueToDouble(valueEval);
/* 39 */     } catch (EvaluationException evaluationException) {
/* 40 */       return evaluationException.getErrorEval();
/*    */     } 
/* 42 */     if (d == 0.0D) {
/* 43 */       return NumberEval.ZERO;
/*    */     }
/* 45 */     return new NumberEval(-d);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\UnaryMinusEval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */