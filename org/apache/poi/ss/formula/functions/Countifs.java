/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.OperationEvaluationContext;
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
/*    */ public class Countifs
/*    */   implements FreeRefFunction
/*    */ {
/* 34 */   public static final FreeRefFunction instance = new Countifs();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, OperationEvaluationContext paramOperationEvaluationContext) {
/* 40 */     if (paramArrayOfValueEval.length < 2 || paramArrayOfValueEval.length % 2 != 0) {
/* 41 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/*    */     
/* 44 */     Double double_ = null;
/*    */     
/* 46 */     for (byte b = 0; b < paramArrayOfValueEval.length; b += 2) {
/* 47 */       ValueEval valueEval1 = paramArrayOfValueEval[b];
/* 48 */       ValueEval valueEval2 = paramArrayOfValueEval[b + 1];
/* 49 */       NumberEval numberEval = (NumberEval)(new Countif()).evaluate(new ValueEval[] { valueEval1, valueEval2 }, paramOperationEvaluationContext.getRowIndex(), paramOperationEvaluationContext.getColumnIndex());
/*    */ 
/*    */ 
/*    */       
/* 53 */       if (double_ == null) {
/* 54 */         double_ = Double.valueOf(numberEval.getNumberValue());
/* 55 */       } else if (numberEval.getNumberValue() < double_.doubleValue()) {
/* 56 */         double_ = Double.valueOf(numberEval.getNumberValue());
/*    */       } 
/*    */     } 
/* 59 */     return (ValueEval)new NumberEval((double_ == null) ? 0.0D : double_.doubleValue());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Countifs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */