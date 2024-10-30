/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.TwoDEval;
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.NumberEval;
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
/*    */ public final class Rows
/*    */   extends Fixed1ArgFunction
/*    */ {
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval) {
/*    */     boolean bool;
/* 36 */     if (paramValueEval instanceof TwoDEval) {
/* 37 */       bool = ((TwoDEval)paramValueEval).getHeight();
/* 38 */     } else if (paramValueEval instanceof org.apache.poi.ss.formula.eval.RefEval) {
/* 39 */       bool = true;
/*    */     } else {
/* 41 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     } 
/* 43 */     return (ValueEval)new NumberEval(bool);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Rows.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */