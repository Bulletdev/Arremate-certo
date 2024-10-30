/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.eval.BlankEval;
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*    */ import org.apache.poi.ss.formula.eval.MissingArgEval;
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
/*    */ public final class Choose
/*    */   implements Function
/*    */ {
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/* 33 */     if (paramArrayOfValueEval.length < 2) {
/* 34 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/*    */     
/*    */     try {
/* 38 */       int i = evaluateFirstArg(paramArrayOfValueEval[0], paramInt1, paramInt2);
/* 39 */       if (i < 1 || i >= paramArrayOfValueEval.length) {
/* 40 */         return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */       }
/* 42 */       ValueEval valueEval = OperandResolver.getSingleValue(paramArrayOfValueEval[i], paramInt1, paramInt2);
/* 43 */       if (valueEval == MissingArgEval.instance) {
/* 44 */         return (ValueEval)BlankEval.instance;
/*    */       }
/* 46 */       return valueEval;
/* 47 */     } catch (EvaluationException evaluationException) {
/* 48 */       return (ValueEval)evaluationException.getErrorEval();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static int evaluateFirstArg(ValueEval paramValueEval, int paramInt1, int paramInt2) throws EvaluationException {
/* 54 */     ValueEval valueEval = OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/* 55 */     return OperandResolver.coerceValueToInt(valueEval);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Choose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */