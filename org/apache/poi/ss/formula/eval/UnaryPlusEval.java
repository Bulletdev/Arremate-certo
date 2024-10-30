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
/*    */ public final class UnaryPlusEval
/*    */   extends Fixed1ArgFunction
/*    */ {
/* 29 */   public static final Function instance = (Function)new UnaryPlusEval();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval) {
/*    */     double d;
/*    */     try {
/* 38 */       ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/* 39 */       if (valueEval instanceof StringEval)
/*    */       {
/*    */ 
/*    */         
/* 43 */         return valueEval;
/*    */       }
/* 45 */       d = OperandResolver.coerceValueToDouble(valueEval);
/* 46 */     } catch (EvaluationException evaluationException) {
/* 47 */       return evaluationException.getErrorEval();
/*    */     } 
/* 49 */     return new NumberEval(d);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\UnaryPlusEval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */