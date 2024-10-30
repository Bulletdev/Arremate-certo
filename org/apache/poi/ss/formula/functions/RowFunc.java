/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.eval.AreaEval;
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.NumberEval;
/*    */ import org.apache.poi.ss.formula.eval.RefEval;
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
/*    */ public final class RowFunc
/*    */   implements Function0Arg, Function1Arg
/*    */ {
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2) {
/* 34 */     return (ValueEval)new NumberEval((paramInt1 + 1));
/*    */   }
/*    */   
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval) {
/*    */     int i;
/* 39 */     if (paramValueEval instanceof AreaEval) {
/* 40 */       i = ((AreaEval)paramValueEval).getFirstRow();
/* 41 */     } else if (paramValueEval instanceof RefEval) {
/* 42 */       i = ((RefEval)paramValueEval).getRow();
/*    */     } else {
/*    */       
/* 45 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     } 
/*    */     
/* 48 */     return (ValueEval)new NumberEval((i + 1));
/*    */   }
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/* 51 */     switch (paramArrayOfValueEval.length) {
/*    */       case 1:
/* 53 */         return evaluate(paramInt1, paramInt2, paramArrayOfValueEval[0]);
/*    */       case 0:
/* 55 */         return (ValueEval)new NumberEval((paramInt1 + 1));
/*    */     } 
/* 57 */     return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\RowFunc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */