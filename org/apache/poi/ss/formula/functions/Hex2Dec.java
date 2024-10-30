/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.OperationEvaluationContext;
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.NumberEval;
/*    */ import org.apache.poi.ss.formula.eval.OperandResolver;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Hex2Dec
/*    */   extends Fixed1ArgFunction
/*    */   implements FreeRefFunction
/*    */ {
/* 40 */   public static final FreeRefFunction instance = new Hex2Dec();
/*    */   
/*    */   static final int HEXADECIMAL_BASE = 16;
/*    */   static final int MAX_NUMBER_OF_PLACES = 10;
/*    */   
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval) {
/*    */     String str;
/* 47 */     if (paramValueEval instanceof RefEval) {
/* 48 */       RefEval refEval = (RefEval)paramValueEval;
/* 49 */       str = OperandResolver.coerceValueToString(refEval.getInnerValueEval(refEval.getFirstSheetIndex()));
/*    */     } else {
/* 51 */       str = OperandResolver.coerceValueToString(paramValueEval);
/*    */     } 
/*    */     try {
/* 54 */       return (ValueEval)new NumberEval(BaseNumberUtils.convertToDecimal(str, 16, 10));
/* 55 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 56 */       return (ValueEval)ErrorEval.NUM_ERROR;
/*    */     } 
/*    */   }
/*    */   
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/* 61 */     if (paramArrayOfValueEval.length != 1) {
/* 62 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/* 64 */     return evaluate(paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex(), paramArrayOfValueEval[0]);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Hex2Dec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */