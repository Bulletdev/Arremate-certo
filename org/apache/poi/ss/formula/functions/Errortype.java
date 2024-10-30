/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.eval.ErrorEval;
/*    */ import org.apache.poi.ss.formula.eval.EvaluationException;
/*    */ import org.apache.poi.ss.formula.eval.NumberEval;
/*    */ import org.apache.poi.ss.formula.eval.OperandResolver;
/*    */ import org.apache.poi.ss.formula.eval.ValueEval;
/*    */ import org.apache.poi.ss.usermodel.FormulaError;
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
/*    */ public final class Errortype
/*    */   extends Fixed1ArgFunction
/*    */ {
/*    */   public ValueEval evaluate(int paramInt1, int paramInt2, ValueEval paramValueEval) {
/*    */     try {
/* 58 */       OperandResolver.getSingleValue(paramValueEval, paramInt1, paramInt2);
/* 59 */       return (ValueEval)ErrorEval.NA;
/* 60 */     } catch (EvaluationException evaluationException) {
/* 61 */       int i = translateErrorCodeToErrorTypeValue(evaluationException.getErrorEval().getErrorCode());
/* 62 */       return (ValueEval)new NumberEval(i);
/*    */     } 
/*    */   }
/*    */   
/*    */   private int translateErrorCodeToErrorTypeValue(int paramInt) {
/* 67 */     switch (FormulaError.forInt(paramInt)) { case NULL:
/* 68 */         return 1;
/* 69 */       case DIV0: return 2;
/* 70 */       case VALUE: return 3;
/* 71 */       case REF: return 4;
/* 72 */       case NAME: return 5;
/* 73 */       case NUM: return 6;
/* 74 */       case NA: return 7; }
/*    */     
/* 76 */     throw new IllegalArgumentException("Invalid error code (" + paramInt + ")");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\Errortype.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */