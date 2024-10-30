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
/*    */ 
/*    */ 
/*    */ public final class RangeEval
/*    */   extends Fixed2ArgFunction
/*    */ {
/* 30 */   public static final Function instance = (Function)new RangeEval();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/*    */     try {
/* 39 */       AreaEval areaEval1 = evaluateRef(paramValueEval1);
/* 40 */       AreaEval areaEval2 = evaluateRef(paramValueEval2);
/* 41 */       return (ValueEval)resolveRange(areaEval1, areaEval2);
/* 42 */     } catch (EvaluationException evaluationException) {
/* 43 */       return evaluationException.getErrorEval();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static AreaEval resolveRange(AreaEval paramAreaEval1, AreaEval paramAreaEval2) {
/* 52 */     int i = paramAreaEval1.getFirstRow();
/* 53 */     int j = paramAreaEval1.getFirstColumn();
/*    */     
/* 55 */     int k = Math.min(i, paramAreaEval2.getFirstRow());
/* 56 */     int m = Math.max(paramAreaEval1.getLastRow(), paramAreaEval2.getLastRow());
/* 57 */     int n = Math.min(j, paramAreaEval2.getFirstColumn());
/* 58 */     int i1 = Math.max(paramAreaEval1.getLastColumn(), paramAreaEval2.getLastColumn());
/*    */     
/* 60 */     return paramAreaEval1.offset(k - i, m - i, n - j, i1 - j);
/*    */   }
/*    */   
/*    */   private static AreaEval evaluateRef(ValueEval paramValueEval) throws EvaluationException {
/* 64 */     if (paramValueEval instanceof AreaEval) {
/* 65 */       return (AreaEval)paramValueEval;
/*    */     }
/* 67 */     if (paramValueEval instanceof RefEval) {
/* 68 */       return ((RefEval)paramValueEval).offset(0, 0, 0, 0);
/*    */     }
/* 70 */     if (paramValueEval instanceof ErrorEval) {
/* 71 */       throw new EvaluationException((ErrorEval)paramValueEval);
/*    */     }
/* 73 */     throw new IllegalArgumentException("Unexpected ref arg class (" + paramValueEval.getClass().getName() + ")");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\RangeEval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */