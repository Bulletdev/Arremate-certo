/*    */ package org.apache.poi.ss.formula.atp;
/*    */ 
/*    */ import org.apache.poi.ss.formula.OperationEvaluationContext;
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*    */ import org.apache.poi.ss.formula.eval.NumberEval;
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
/*    */ final class NetworkdaysFunction
/*    */   implements FreeRefFunction
/*    */ {
/* 41 */   public static final FreeRefFunction instance = new NetworkdaysFunction(ArgumentsEvaluator.instance);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private ArgumentsEvaluator evaluator;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private NetworkdaysFunction(ArgumentsEvaluator paramArgumentsEvaluator) {
/* 52 */     this.evaluator = paramArgumentsEvaluator;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/* 62 */     if (paramArrayOfValueEval.length < 2 || paramArrayOfValueEval.length > 3) {
/* 63 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/*    */     
/* 66 */     int i = paramOperationEvaluationContext.getRowIndex();
/* 67 */     int j = paramOperationEvaluationContext.getColumnIndex();
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 72 */       double d1 = this.evaluator.evaluateDateArg(paramArrayOfValueEval[0], i, j);
/* 73 */       double d2 = this.evaluator.evaluateDateArg(paramArrayOfValueEval[1], i, j);
/* 74 */       if (d1 > d2) {
/* 75 */         return (ValueEval)ErrorEval.NAME_INVALID;
/*    */       }
/* 77 */       ValueEval valueEval = (paramArrayOfValueEval.length == 3) ? paramArrayOfValueEval[2] : null;
/* 78 */       double[] arrayOfDouble = this.evaluator.evaluateDatesArg(valueEval, i, j);
/* 79 */       return (ValueEval)new NumberEval(WorkdayCalculator.instance.calculateWorkdays(d1, d2, arrayOfDouble));
/* 80 */     } catch (EvaluationException evaluationException) {
/* 81 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\atp\NetworkdaysFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */