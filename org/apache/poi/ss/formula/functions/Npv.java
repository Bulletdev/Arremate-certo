/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*    */ import org.apache.poi.ss.formula.eval.NumberEval;
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
/*    */ 
/*    */ 
/*    */ public final class Npv
/*    */   implements Function
/*    */ {
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/* 38 */     int i = paramArrayOfValueEval.length;
/* 39 */     if (i < 2) {
/* 40 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/*    */     
/*    */     try {
/* 44 */       double d1 = NumericFunction.singleOperandEvaluate(paramArrayOfValueEval[0], paramInt1, paramInt2);
/*    */       
/* 46 */       ValueEval[] arrayOfValueEval = new ValueEval[paramArrayOfValueEval.length - 1];
/* 47 */       System.arraycopy(paramArrayOfValueEval, 1, arrayOfValueEval, 0, arrayOfValueEval.length);
/* 48 */       double[] arrayOfDouble = AggregateFunction.ValueCollector.collectValues(arrayOfValueEval);
/*    */       
/* 50 */       double d2 = FinanceLib.npv(d1, arrayOfDouble);
/* 51 */       NumericFunction.checkValue(d2);
/* 52 */       return (ValueEval)new NumberEval(d2);
/* 53 */     } catch (EvaluationException evaluationException) {
/* 54 */       return (ValueEval)evaluationException.getErrorEval();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Npv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */