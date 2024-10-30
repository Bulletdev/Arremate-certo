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
/*    */ public final class IntersectionEval
/*    */   extends Fixed2ArgFunction
/*    */ {
/* 28 */   public static final Function instance = (Function)new IntersectionEval();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval1, ValueEval paramValueEval2) {
/*    */     try {
/* 37 */       AreaEval areaEval1 = evaluateRef(paramValueEval1);
/* 38 */       AreaEval areaEval2 = evaluateRef(paramValueEval2);
/* 39 */       AreaEval areaEval3 = resolveRange(areaEval1, areaEval2);
/* 40 */       if (areaEval3 == null) {
/* 41 */         return ErrorEval.NULL_INTERSECTION;
/*    */       }
/* 43 */       return (ValueEval)areaEval3;
/* 44 */     } catch (EvaluationException evaluationException) {
/* 45 */       return evaluationException.getErrorEval();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static AreaEval resolveRange(AreaEval paramAreaEval1, AreaEval paramAreaEval2) {
/* 55 */     int i = paramAreaEval1.getFirstRow();
/* 56 */     int j = paramAreaEval1.getFirstColumn();
/* 57 */     int k = paramAreaEval2.getLastColumn();
/* 58 */     if (j > k) {
/* 59 */       return null;
/*    */     }
/* 61 */     int m = paramAreaEval2.getFirstColumn();
/* 62 */     if (m > paramAreaEval1.getLastColumn()) {
/* 63 */       return null;
/*    */     }
/* 65 */     int n = paramAreaEval2.getLastRow();
/* 66 */     if (i > n) {
/* 67 */       return null;
/*    */     }
/* 69 */     int i1 = paramAreaEval2.getFirstRow();
/* 70 */     int i2 = paramAreaEval1.getLastRow();
/* 71 */     if (i1 > i2) {
/* 72 */       return null;
/*    */     }
/*    */ 
/*    */     
/* 76 */     int i3 = Math.max(i, i1);
/* 77 */     int i4 = Math.min(i2, n);
/* 78 */     int i5 = Math.max(j, m);
/* 79 */     int i6 = Math.min(paramAreaEval1.getLastColumn(), k);
/*    */     
/* 81 */     return paramAreaEval1.offset(i3 - i, i4 - i, i5 - j, i6 - j);
/*    */   }
/*    */   
/*    */   private static AreaEval evaluateRef(ValueEval paramValueEval) throws EvaluationException {
/* 85 */     if (paramValueEval instanceof AreaEval) {
/* 86 */       return (AreaEval)paramValueEval;
/*    */     }
/* 88 */     if (paramValueEval instanceof RefEval) {
/* 89 */       return ((RefEval)paramValueEval).offset(0, 0, 0, 0);
/*    */     }
/* 91 */     if (paramValueEval instanceof ErrorEval) {
/* 92 */       throw new EvaluationException((ErrorEval)paramValueEval);
/*    */     }
/* 94 */     throw new IllegalArgumentException("Unexpected ref arg class (" + paramValueEval.getClass().getName() + ")");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\IntersectionEval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */