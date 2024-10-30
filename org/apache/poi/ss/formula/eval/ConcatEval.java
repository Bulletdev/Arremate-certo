/*    */ package org.apache.poi.ss.formula.eval;
/*    */ 
/*    */ import org.apache.poi.ss.formula.functions.Fixed2ArgFunction;
/*    */ import org.apache.poi.ss.formula.functions.Function;
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
/*    */ public final class ConcatEval
/*    */   extends Fixed2ArgFunction
/*    */ {
/* 28 */   public static final Function instance = (Function)new ConcatEval();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/*    */     ValueEval valueEval1, valueEval2;
/*    */     try {
/* 38 */       valueEval1 = OperandResolver.getSingleValue(paramValueEval1, paramInt1, paramInt2);
/* 39 */       valueEval2 = OperandResolver.getSingleValue(paramValueEval2, paramInt1, paramInt2);
/* 40 */     } catch (EvaluationException evaluationException) {
/* 41 */       return evaluationException.getErrorEval();
/*    */     } 
/* 43 */     StringBuilder stringBuilder = new StringBuilder();
/* 44 */     stringBuilder.append(getText(valueEval1));
/* 45 */     stringBuilder.append(getText(valueEval2));
/* 46 */     return new StringEval(stringBuilder.toString());
/*    */   }
/*    */   
/*    */   private Object getText(ValueEval paramValueEval) {
/* 50 */     if (paramValueEval instanceof StringValueEval) {
/* 51 */       StringValueEval stringValueEval = (StringValueEval)paramValueEval;
/* 52 */       return stringValueEval.getStringValue();
/*    */     } 
/* 54 */     if (paramValueEval == BlankEval.instance) {
/* 55 */       return "";
/*    */     }
/* 57 */     throw new IllegalAccessError("Unexpected value type (" + paramValueEval.getClass().getName() + ")");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\ConcatEval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */