/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.OperationEvaluationContext;
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Quotient
/*    */   extends Fixed2ArgFunction
/*    */   implements FreeRefFunction
/*    */ {
/* 42 */   public static final FreeRefFunction instance = new Quotient();
/*    */ 
/*    */   
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/* 46 */     double d1 = 0.0D;
/*    */     try {
/* 48 */       d1 = OperandResolver.coerceValueToDouble(paramValueEval1);
/* 49 */     } catch (EvaluationException evaluationException) {
/* 50 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     } 
/*    */     
/* 53 */     double d2 = 0.0D;
/*    */     try {
/* 55 */       d2 = OperandResolver.coerceValueToDouble(paramValueEval2);
/* 56 */     } catch (EvaluationException evaluationException) {
/* 57 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     } 
/*    */     
/* 60 */     if (d2 == 0.0D) {
/* 61 */       return (ValueEval)ErrorEval.DIV_ZERO;
/*    */     }
/*    */     
/* 64 */     return (ValueEval)new NumberEval((int)(d1 / d2));
/*    */   }
/*    */   
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/* 68 */     if (paramArrayOfValueEval.length != 2) {
/* 69 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/* 71 */     return evaluate(paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex(), paramArrayOfValueEval[0], paramArrayOfValueEval[1]);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Quotient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */