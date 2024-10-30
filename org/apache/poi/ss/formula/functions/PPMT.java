/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
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
/*    */ public class PPMT
/*    */   extends NumericFunction
/*    */ {
/*    */   public double eval(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) throws EvaluationException {
/* 34 */     if (paramArrayOfValueEval.length < 4) {
/* 35 */       throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*    */     }
/*    */ 
/*    */     
/* 39 */     ValueEval valueEval1 = OperandResolver.getSingleValue(paramArrayOfValueEval[0], paramInt1, paramInt2);
/* 40 */     ValueEval valueEval2 = OperandResolver.getSingleValue(paramArrayOfValueEval[1], paramInt1, paramInt2);
/* 41 */     ValueEval valueEval3 = OperandResolver.getSingleValue(paramArrayOfValueEval[2], paramInt1, paramInt2);
/* 42 */     ValueEval valueEval4 = OperandResolver.getSingleValue(paramArrayOfValueEval[3], paramInt1, paramInt2);
/*    */     
/* 44 */     double d2 = OperandResolver.coerceValueToDouble(valueEval1);
/* 45 */     int i = OperandResolver.coerceValueToInt(valueEval2);
/* 46 */     int j = OperandResolver.coerceValueToInt(valueEval3);
/* 47 */     double d3 = OperandResolver.coerceValueToDouble(valueEval4);
/*    */     
/* 49 */     double d1 = Finance.ppmt(d2, i, j, d3);
/*    */     
/* 51 */     checkValue(d1);
/*    */     
/* 53 */     return d1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\PPMT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */