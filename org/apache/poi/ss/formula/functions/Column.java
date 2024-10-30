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
/*    */ public final class Column
/*    */   implements Function0Arg, Function1Arg
/*    */ {
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2) {
/* 29 */     return (ValueEval)new NumberEval((paramInt2 + 1));
/*    */   }
/*    */   
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval) {
/*    */     int i;
/* 34 */     if (paramValueEval instanceof AreaEval) {
/* 35 */       i = ((AreaEval)paramValueEval).getFirstColumn();
/* 36 */     } else if (paramValueEval instanceof RefEval) {
/* 37 */       i = ((RefEval)paramValueEval).getColumn();
/*    */     } else {
/*    */       
/* 40 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     } 
/*    */     
/* 43 */     return (ValueEval)new NumberEval((i + 1));
/*    */   }
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/* 46 */     switch (paramArrayOfValueEval.length) {
/*    */       case 1:
/* 48 */         return evaluate(paramInt1, paramInt2, paramArrayOfValueEval[0]);
/*    */       case 0:
/* 50 */         return (ValueEval)new NumberEval((paramInt2 + 1));
/*    */     } 
/* 52 */     return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Column.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */