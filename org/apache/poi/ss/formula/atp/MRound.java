/*    */ package org.apache.poi.ss.formula.atp;
/*    */ 
/*    */ import org.apache.poi.ss.formula.OperationEvaluationContext;
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*    */ import org.apache.poi.ss.formula.eval.NumberEval;
/*    */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*    */ import org.apache.poi.ss.formula.eval.ValueEval;
/*    */ import org.apache.poi.ss.formula.functions.FreeRefFunction;
/*    */ import org.apache.poi.ss.formula.functions.NumericFunction;
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
/*    */ final class MRound
/*    */   implements FreeRefFunction
/*    */ {
/* 39 */   public static final FreeRefFunction instance = new MRound();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/* 48 */     if (paramArrayOfValueEval.length != 2) {
/* 49 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/*    */     
/*    */     try {
/* 53 */       double d3, d1 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(paramArrayOfValueEval[0], paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex()));
/* 54 */       double d2 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(paramArrayOfValueEval[1], paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex()));
/*    */       
/* 56 */       if (d2 == 0.0D) {
/* 57 */         d3 = 0.0D;
/*    */       } else {
/* 59 */         if (d1 * d2 < 0.0D)
/*    */         {
/* 61 */           throw new EvaluationException(ErrorEval.NUM_ERROR);
/*    */         }
/* 63 */         d3 = d2 * Math.round(d1 / d2);
/*    */       } 
/* 65 */       NumericFunction.checkValue(d3);
/* 66 */       return (ValueEval)new NumberEval(d3);
/* 67 */     } catch (EvaluationException evaluationException) {
/* 68 */       return (ValueEval)evaluationException.getErrorEval();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\atp\MRound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */