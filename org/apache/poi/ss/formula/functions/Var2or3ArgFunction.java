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
/*    */ abstract class Var2or3ArgFunction
/*    */   implements Function2Arg, Function3Arg
/*    */ {
/*    */   public final ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/* 32 */     switch (paramArrayOfValueEval.length) {
/*    */       case 2:
/* 34 */         return evaluate(paramInt1, paramInt2, paramArrayOfValueEval[0], paramArrayOfValueEval[1]);
/*    */       case 3:
/* 36 */         return evaluate(paramInt1, paramInt2, paramArrayOfValueEval[0], paramArrayOfValueEval[1], paramArrayOfValueEval[2]);
/*    */     } 
/* 38 */     return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Var2or3ArgFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */