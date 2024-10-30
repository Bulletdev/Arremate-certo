/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*    */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*    */ import org.apache.poi.ss.formula.eval.StringEval;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Rept
/*    */   extends Fixed2ArgFunction
/*    */ {
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/*    */     ValueEval valueEval;
/*    */     try {
/* 50 */       valueEval = OperandResolver.getSingleValue(paramValueEval1, paramInt1, paramInt2);
/* 51 */     } catch (EvaluationException evaluationException) {
/* 52 */       return (ValueEval)evaluationException.getErrorEval();
/*    */     } 
/* 54 */     String str = OperandResolver.coerceValueToString(valueEval);
/* 55 */     double d = 0.0D;
/*    */     try {
/* 57 */       d = OperandResolver.coerceValueToDouble(paramValueEval2);
/* 58 */     } catch (EvaluationException evaluationException) {
/* 59 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     } 
/*    */     
/* 62 */     int i = (int)d;
/* 63 */     StringBuffer stringBuffer = new StringBuffer(str.length() * i);
/* 64 */     for (byte b = 0; b < i; b++) {
/* 65 */       stringBuffer.append(str);
/*    */     }
/*    */     
/* 68 */     if (stringBuffer.toString().length() > 32767) {
/* 69 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/*    */     
/* 72 */     return (ValueEval)new StringEval(stringBuffer.toString());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Rept.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */