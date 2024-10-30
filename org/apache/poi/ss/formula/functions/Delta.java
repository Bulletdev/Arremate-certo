/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import java.math.BigDecimal;
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
/*    */ public final class Delta
/*    */   extends Fixed2ArgFunction
/*    */   implements FreeRefFunction
/*    */ {
/* 43 */   public static final FreeRefFunction instance = new Delta();
/*    */   
/* 45 */   private static final NumberEval ONE = new NumberEval(1.0D);
/* 46 */   private static final NumberEval ZERO = new NumberEval(0.0D);
/*    */   
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/*    */     ValueEval valueEval1, valueEval2;
/*    */     try {
/* 51 */       valueEval1 = OperandResolver.getSingleValue(paramValueEval1, paramInt1, paramInt2);
/* 52 */     } catch (EvaluationException evaluationException) {
/* 53 */       return (ValueEval)evaluationException.getErrorEval();
/*    */     } 
/* 55 */     String str1 = OperandResolver.coerceValueToString(valueEval1);
/* 56 */     Double double_1 = OperandResolver.parseDouble(str1);
/* 57 */     if (double_1 == null) {
/* 58 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/*    */ 
/*    */     
/*    */     try {
/* 63 */       valueEval2 = OperandResolver.getSingleValue(paramValueEval2, paramInt1, paramInt2);
/* 64 */     } catch (EvaluationException evaluationException) {
/* 65 */       return (ValueEval)evaluationException.getErrorEval();
/*    */     } 
/*    */     
/* 68 */     String str2 = OperandResolver.coerceValueToString(valueEval2);
/* 69 */     Double double_2 = OperandResolver.parseDouble(str2);
/* 70 */     if (double_2 == null) {
/* 71 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/*    */     
/* 74 */     int i = (new BigDecimal(double_1.doubleValue())).compareTo(new BigDecimal(double_2.doubleValue()));
/* 75 */     return (i == 0) ? (ValueEval)ONE : (ValueEval)ZERO;
/*    */   }
/*    */   
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/* 79 */     if (paramArrayOfValueEval.length == 2) {
/* 80 */       return evaluate(paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex(), paramArrayOfValueEval[0], paramArrayOfValueEval[1]);
/*    */     }
/*    */     
/* 83 */     return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Delta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */