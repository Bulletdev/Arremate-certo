/*    */ package org.apache.poi.ss.formula.atp;
/*    */ 
/*    */ import org.apache.poi.ss.formula.OperationEvaluationContext;
/*    */ import org.apache.poi.ss.formula.eval.BoolEval;
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
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
/*    */ final class ParityFunction
/*    */   implements FreeRefFunction
/*    */ {
/* 34 */   public static final FreeRefFunction IS_EVEN = new ParityFunction(0);
/* 35 */   public static final FreeRefFunction IS_ODD = new ParityFunction(1);
/*    */   private final int _desiredParity;
/*    */   
/*    */   private ParityFunction(int paramInt) {
/* 39 */     this._desiredParity = paramInt;
/*    */   }
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/*    */     int i;
/* 43 */     if (paramArrayOfValueEval.length != 1) {
/* 44 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 49 */       i = evaluateArgParity(paramArrayOfValueEval[0], paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex());
/* 50 */     } catch (EvaluationException evaluationException) {
/* 51 */       return (ValueEval)evaluationException.getErrorEval();
/*    */     } 
/*    */     
/* 54 */     return (ValueEval)BoolEval.valueOf((i == this._desiredParity));
/*    */   }
/*    */   
/*    */   private static int evaluateArgParity(ValueEval paramValueEval, int paramInt1, int paramInt2) throws EvaluationException {
/* 58 */     ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, (short)paramInt2);
/*    */     
/* 60 */     double d = OperandResolver.coerceValueToDouble(valueEval);
/* 61 */     if (d < 0.0D) {
/* 62 */       d = -d;
/*    */     }
/* 64 */     long l = (long)Math.floor(d);
/* 65 */     return (int)(l & 0x1L);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\atp\ParityFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */