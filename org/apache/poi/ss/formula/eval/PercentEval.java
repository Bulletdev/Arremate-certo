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
/*    */ 
/*    */ 
/*    */ public final class PercentEval
/*    */   extends Fixed1ArgFunction
/*    */ {
/* 30 */   public static final Function instance = (Function)new PercentEval();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval) {
/*    */     double d;
/*    */     try {
/* 39 */       ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/* 40 */       d = OperandResolver.coerceValueToDouble(valueEval);
/* 41 */     } catch (EvaluationException evaluationException) {
/* 42 */       return evaluationException.getErrorEval();
/*    */     } 
/* 44 */     if (d == 0.0D) {
/* 45 */       return NumberEval.ZERO;
/*    */     }
/* 47 */     return new NumberEval(d / 100.0D);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\PercentEval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */