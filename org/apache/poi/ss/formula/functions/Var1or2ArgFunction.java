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
/*    */ 
/*    */ 
/*    */ abstract class Var1or2ArgFunction
/*    */   implements Function1Arg, Function2Arg
/*    */ {
/*    */   public final ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/* 32 */     switch (paramArrayOfValueEval.length) {
/*    */       case 1:
/* 34 */         return evaluate(paramInt1, paramInt2, paramArrayOfValueEval[0]);
/*    */       case 2:
/* 36 */         return evaluate(paramInt1, paramInt2, paramArrayOfValueEval[0], paramArrayOfValueEval[1]);
/*    */     } 
/* 38 */     return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Var1or2ArgFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */