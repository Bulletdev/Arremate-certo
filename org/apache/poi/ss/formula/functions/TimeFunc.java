/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*    */ import org.apache.poi.ss.formula.eval.MissingArgEval;
/*    */ import org.apache.poi.ss.formula.eval.NumberEval;
/*    */ import org.apache.poi.ss.formula.eval.OperandResolver;
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
/*    */ public final class TimeFunc
/*    */   extends Fixed3ArgFunction
/*    */ {
/*    */   private static final int SECONDS_PER_MINUTE = 60;
/*    */   private static final int SECONDS_PER_HOUR = 3600;
/*    */   private static final int HOURS_PER_DAY = 24;
/*    */   private static final int SECONDS_PER_DAY = 86400;
/*    */   
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3) {
/*    */     double d;
/*    */     try {
/* 46 */       d = evaluate(evalArg(paramValueEval1, paramInt1, paramInt2), evalArg(paramValueEval2, paramInt1, paramInt2), evalArg(paramValueEval3, paramInt1, paramInt2));
/* 47 */     } catch (EvaluationException evaluationException) {
/* 48 */       return (ValueEval)evaluationException.getErrorEval();
/*    */     } 
/* 50 */     return (ValueEval)new NumberEval(d);
/*    */   }
/*    */   private static int evalArg(ValueEval paramValueEval, int paramInt1, int paramInt2) throws EvaluationException {
/* 53 */     if (paramValueEval == MissingArgEval.instance) {
/* 54 */       return 0;
/*    */     }
/* 56 */     ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/*    */     
/* 58 */     return OperandResolver.coerceValueToInt(valueEval);
/*    */   }
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
/*    */   private static double evaluate(int paramInt1, int paramInt2, int paramInt3) throws EvaluationException {
/* 77 */     if (paramInt1 > 32767 || paramInt2 > 32767 || paramInt3 > 32767) {
/* 78 */       throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*    */     }
/* 80 */     int i = paramInt1 * 3600 + paramInt2 * 60 + paramInt3;
/*    */     
/* 82 */     if (i < 0) {
/* 83 */       throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*    */     }
/* 85 */     return (i % 86400) / 86400.0D;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\TimeFunc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */