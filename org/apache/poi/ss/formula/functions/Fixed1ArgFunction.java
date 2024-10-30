/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
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
/*    */ public abstract class Fixed1ArgFunction
/*    */   implements Function1Arg
/*    */ {
/*    */   public final ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/* 30 */     if (paramArrayOfValueEval.length != 1) {
/* 31 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/* 33 */     return evaluate(paramInt1, paramInt2, paramArrayOfValueEval[0]);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Fixed1ArgFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */