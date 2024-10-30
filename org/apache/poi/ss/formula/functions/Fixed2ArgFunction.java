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
/*    */ public abstract class Fixed2ArgFunction
/*    */   implements Function2Arg
/*    */ {
/*    */   public final ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/* 30 */     if (paramArrayOfValueEval.length != 2) {
/* 31 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/* 33 */     return evaluate(paramInt1, paramInt2, paramArrayOfValueEval[0], paramArrayOfValueEval[1]);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Fixed2ArgFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */