/*    */ package org.apache.poi.ss.formula.atp;
/*    */ 
/*    */ import org.apache.poi.ss.formula.OperationEvaluationContext;
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*    */ import org.apache.poi.ss.formula.eval.NumberEval;
/*    */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*    */ import org.apache.poi.ss.formula.eval.ValueEval;
/*    */ import org.apache.poi.ss.formula.functions.FreeRefFunction;
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
/*    */ final class RandBetween
/*    */   implements FreeRefFunction
/*    */ {
/* 42 */   public static final FreeRefFunction instance = new RandBetween();
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
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/* 59 */     if (paramArrayOfValueEval.length != 2) {
/* 60 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/*    */     
/*    */     try {
/* 64 */       d1 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(paramArrayOfValueEval[0], paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex()));
/* 65 */       d2 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(paramArrayOfValueEval[1], paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex()));
/* 66 */       if (d1 > d2) {
/* 67 */         return (ValueEval)ErrorEval.NUM_ERROR;
/*    */       }
/* 69 */     } catch (EvaluationException evaluationException) {
/* 70 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     } 
/*    */     
/* 73 */     double d1 = Math.ceil(d1);
/* 74 */     double d2 = Math.floor(d2);
/*    */     
/* 76 */     if (d1 > d2) {
/* 77 */       d2 = d1;
/*    */     }
/*    */     
/* 80 */     return (ValueEval)new NumberEval(d1 + (int)(Math.random() * (d2 - d1 + 1.0D)));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\atp\RandBetween.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */