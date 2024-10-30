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
/*    */ public class IPMT
/*    */   extends NumericFunction
/*    */ {
/*    */   public double eval(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) throws EvaluationException {
/* 32 */     if (paramArrayOfValueEval.length != 4) {
/* 33 */       throw new EvaluationException(ErrorEval.VALUE_INVALID);
/*    */     }
/*    */ 
/*    */     
/* 37 */     ValueEval valueEval1 = OperandResolver.getSingleValue(paramArrayOfValueEval[0], paramInt1, paramInt2);
/* 38 */     ValueEval valueEval2 = OperandResolver.getSingleValue(paramArrayOfValueEval[1], paramInt1, paramInt2);
/* 39 */     ValueEval valueEval3 = OperandResolver.getSingleValue(paramArrayOfValueEval[2], paramInt1, paramInt2);
/* 40 */     ValueEval valueEval4 = OperandResolver.getSingleValue(paramArrayOfValueEval[3], paramInt1, paramInt2);
/*    */     
/* 42 */     double d2 = OperandResolver.coerceValueToDouble(valueEval1);
/* 43 */     int i = OperandResolver.coerceValueToInt(valueEval2);
/* 44 */     int j = OperandResolver.coerceValueToInt(valueEval3);
/* 45 */     double d3 = OperandResolver.coerceValueToDouble(valueEval4);
/*    */     
/* 47 */     double d1 = Finance.ipmt(d2, i, j, d3);
/*    */     
/* 49 */     checkValue(d1);
/*    */     
/* 51 */     return d1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\IPMT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */