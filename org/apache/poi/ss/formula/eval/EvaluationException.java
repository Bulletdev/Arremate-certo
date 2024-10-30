/*     */ package org.apache.poi.ss.formula.eval;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class EvaluationException
/*     */   extends Exception
/*     */ {
/*     */   private final ErrorEval _errorEval;
/*     */   
/*     */   public EvaluationException(ErrorEval paramErrorEval) {
/* 114 */     this._errorEval = paramErrorEval;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static EvaluationException invalidValue() {
/* 120 */     return new EvaluationException(ErrorEval.VALUE_INVALID);
/*     */   }
/*     */   
/*     */   public static EvaluationException invalidRef() {
/* 124 */     return new EvaluationException(ErrorEval.REF_INVALID);
/*     */   }
/*     */   
/*     */   public static EvaluationException numberError() {
/* 128 */     return new EvaluationException(ErrorEval.NUM_ERROR);
/*     */   }
/*     */   
/*     */   public ErrorEval getErrorEval() {
/* 132 */     return this._errorEval;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\EvaluationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */