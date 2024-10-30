/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.eval.AreaEval;
/*    */ import org.apache.poi.ss.formula.eval.RefEval;
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
/*    */ public final class T
/*    */   extends Fixed1ArgFunction
/*    */ {
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval) {
/* 36 */     ValueEval valueEval = paramValueEval;
/* 37 */     if (valueEval instanceof RefEval) {
/*    */       
/* 39 */       RefEval refEval = (RefEval)valueEval;
/* 40 */       valueEval = refEval.getInnerValueEval(refEval.getFirstSheetIndex());
/* 41 */     } else if (valueEval instanceof AreaEval) {
/*    */       
/* 43 */       valueEval = ((AreaEval)valueEval).getRelativeValue(0, 0);
/*    */     } 
/*    */     
/* 46 */     if (valueEval instanceof StringEval)
/*    */     {
/* 48 */       return valueEval;
/*    */     }
/*    */     
/* 51 */     if (valueEval instanceof org.apache.poi.ss.formula.eval.ErrorEval)
/*    */     {
/* 53 */       return valueEval;
/*    */     }
/*    */     
/* 56 */     return (ValueEval)StringEval.EMPTY_INSTANCE;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\T.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */