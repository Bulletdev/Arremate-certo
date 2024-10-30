/*    */ package org.apache.poi.ss.formula.atp;
/*    */ 
/*    */ import org.apache.poi.ss.formula.OperationEvaluationContext;
/*    */ import org.apache.poi.ss.formula.WorkbookEvaluator;
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
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
/*    */ final class IfError
/*    */   implements FreeRefFunction
/*    */ {
/* 38 */   public static final FreeRefFunction instance = new IfError();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/*    */     ValueEval valueEval;
/* 45 */     if (paramArrayOfValueEval.length != 2) {
/* 46 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 51 */       valueEval = evaluateInternal(paramArrayOfValueEval[0], paramArrayOfValueEval[1], paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex());
/* 52 */     } catch (EvaluationException evaluationException) {
/* 53 */       return (ValueEval)evaluationException.getErrorEval();
/*    */     } 
/*    */     
/* 56 */     return valueEval;
/*    */   }
/*    */   
/*    */   private static ValueEval evaluateInternal(ValueEval paramValueEval1, ValueEval paramValueEval2, int paramInt1, int paramInt2) throws EvaluationException {
/* 60 */     paramValueEval1 = WorkbookEvaluator.dereferenceResult(paramValueEval1, paramInt1, paramInt2);
/* 61 */     if (paramValueEval1 instanceof ErrorEval) {
/* 62 */       return paramValueEval2;
/*    */     }
/* 64 */     return paramValueEval1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\atp\IfError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */