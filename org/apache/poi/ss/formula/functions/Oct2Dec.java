/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.OperationEvaluationContext;
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.NumberEval;
/*    */ import org.apache.poi.ss.formula.eval.OperandResolver;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Oct2Dec
/*    */   extends Fixed1ArgFunction
/*    */   implements FreeRefFunction
/*    */ {
/* 44 */   public static final FreeRefFunction instance = new Oct2Dec();
/*    */   
/*    */   static final int MAX_NUMBER_OF_PLACES = 10;
/*    */   static final int OCTAL_BASE = 8;
/*    */   
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval) {
/* 50 */     String str = OperandResolver.coerceValueToString(paramValueEval);
/*    */     try {
/* 52 */       return (ValueEval)new NumberEval(BaseNumberUtils.convertToDecimal(str, 8, 10));
/* 53 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 54 */       return (ValueEval)ErrorEval.NUM_ERROR;
/*    */     } 
/*    */   }
/*    */   
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/* 59 */     if (paramArrayOfValueEval.length != 1) {
/* 60 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/* 62 */     return evaluate(paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex(), paramArrayOfValueEval[0]);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Oct2Dec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */