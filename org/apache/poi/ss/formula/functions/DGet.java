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
/*    */ public final class DGet
/*    */   implements IDStarAlgorithm
/*    */ {
/*    */   private ValueEval result;
/*    */   
/*    */   public boolean processMatch(ValueEval paramValueEval) {
/* 35 */     if (this.result == null) {
/*    */       
/* 37 */       this.result = paramValueEval;
/*    */     }
/*    */     else {
/*    */       
/* 41 */       this.result = (ValueEval)ErrorEval.NUM_ERROR;
/* 42 */       return false;
/*    */     } 
/*    */     
/* 45 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public ValueEval getResult() {
/* 50 */     if (this.result == null)
/* 51 */       return (ValueEval)ErrorEval.VALUE_INVALID; 
/* 52 */     if (this.result instanceof org.apache.poi.ss.formula.eval.BlankEval) {
/* 53 */       return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */     }
/*    */     try {
/* 56 */       if (OperandResolver.coerceValueToString(OperandResolver.getSingleValue(this.result, 0, 0)).equals("")) {
/* 57 */         return (ValueEval)ErrorEval.VALUE_INVALID;
/*    */       }
/*    */       
/* 60 */       return this.result;
/*    */     }
/* 62 */     catch (EvaluationException evaluationException) {
/* 63 */       return (ValueEval)evaluationException.getErrorEval();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\DGet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */