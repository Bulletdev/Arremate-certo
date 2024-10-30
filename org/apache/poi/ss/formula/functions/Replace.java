/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
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
/*    */ public final class Replace
/*    */   extends Fixed4ArgFunction
/*    */ {
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2, ValueEval paramValueEval3, ValueEval paramValueEval4) {
/*    */     String str1;
/*    */     int i, j;
/*    */     String str2;
/*    */     try {
/* 50 */       str1 = TextFunction.evaluateStringArg(paramValueEval1, paramInt1, paramInt2);
/* 51 */       i = TextFunction.evaluateIntArg(paramValueEval2, paramInt1, paramInt2);
/* 52 */       j = TextFunction.evaluateIntArg(paramValueEval3, paramInt1, paramInt2);
/* 53 */       str2 = TextFunction.evaluateStringArg(paramValueEval4, paramInt1, paramInt2);
/* 54 */     } catch (EvaluationException evaluationException) {
/* 55 */       return (ValueEval)evaluationException.getErrorEval();
/*    */     } 
/*    */     
/* 58 */     if (i < 1 || j < 0) {
/* 59 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/* 61 */     StringBuffer stringBuffer = new StringBuffer(str1);
/*    */     
/* 63 */     if (i <= str1.length() && j != 0) {
/* 64 */       stringBuffer.delete(i - 1, i - 1 + j);
/*    */     }
/*    */     
/* 67 */     if (i > stringBuffer.length()) {
/* 68 */       stringBuffer.append(str2);
/*    */     } else {
/* 70 */       stringBuffer.insert(i - 1, str2);
/*    */     } 
/* 72 */     return (ValueEval)new StringEval(stringBuffer.toString());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Replace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */