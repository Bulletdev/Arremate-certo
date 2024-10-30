/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*    */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*    */ import org.apache.poi.ss.formula.eval.StringEval;
/*    */ import org.apache.poi.ss.formula.eval.ValueEval;
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
/*    */ public class Code
/*    */   extends Fixed1ArgFunction
/*    */ {
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval) {
/*    */     ValueEval valueEval;
/*    */     try {
/* 39 */       valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/* 40 */     } catch (EvaluationException evaluationException) {
/* 41 */       return (ValueEval)evaluationException.getErrorEval();
/*    */     } 
/* 43 */     String str = OperandResolver.coerceValueToString(valueEval);
/*    */     
/* 45 */     if (str.length() == 0) {
/* 46 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/*    */     
/* 49 */     char c = str.charAt(0);
/*    */     
/* 51 */     return (ValueEval)new StringEval(String.valueOf(c));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Code.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */