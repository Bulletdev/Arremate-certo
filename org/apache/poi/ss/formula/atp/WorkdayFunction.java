/*    */ package org.apache.poi.ss.formula.atp;
/*    */ 
/*    */ import org.apache.poi.ss.formula.OperationEvaluationContext;
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*    */ import org.apache.poi.ss.formula.eval.NumberEval;
/*    */ import org.apache.poi.ss.formula.eval.ValueEval;
/*    */ import org.apache.poi.ss.formula.functions.FreeRefFunction;
/*    */ import org.apache.poi.ss.usermodel.DateUtil;
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
/*    */ final class WorkdayFunction
/*    */   implements FreeRefFunction
/*    */ {
/* 41 */   public static final FreeRefFunction instance = new WorkdayFunction(ArgumentsEvaluator.instance);
/*    */   
/*    */   private ArgumentsEvaluator evaluator;
/*    */ 
/*    */   
/*    */   private WorkdayFunction(ArgumentsEvaluator paramArgumentsEvaluator) {
/* 47 */     this.evaluator = paramArgumentsEvaluator;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/* 57 */     if (paramArrayOfValueEval.length < 2 || paramArrayOfValueEval.length > 3) {
/* 58 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/*    */     
/* 61 */     int i = paramOperationEvaluationContext.getRowIndex();
/* 62 */     int j = paramOperationEvaluationContext.getColumnIndex();
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 68 */       double d = this.evaluator.evaluateDateArg(paramArrayOfValueEval[0], i, j);
/* 69 */       int k = (int)Math.floor(this.evaluator.evaluateNumberArg(paramArrayOfValueEval[1], i, j));
/* 70 */       ValueEval valueEval = (paramArrayOfValueEval.length == 3) ? paramArrayOfValueEval[2] : null;
/* 71 */       double[] arrayOfDouble = this.evaluator.evaluateDatesArg(valueEval, i, j);
/* 72 */       return (ValueEval)new NumberEval(DateUtil.getExcelDate(WorkdayCalculator.instance.calculateWorkdays(d, k, arrayOfDouble)));
/* 73 */     } catch (EvaluationException evaluationException) {
/* 74 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\atp\WorkdayFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */