/*    */ package org.apache.poi.ss.formula.eval;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public final class ErrorEval
/*    */   implements ValueEval
/*    */ {
/* 29 */   private static final Map<FormulaError, ErrorEval> evals = new HashMap<FormulaError, ErrorEval>();
/*    */ 
/*    */   
/* 32 */   public static final ErrorEval NULL_INTERSECTION = new ErrorEval(FormulaError.NULL);
/*    */   
/* 34 */   public static final ErrorEval DIV_ZERO = new ErrorEval(FormulaError.DIV0);
/*    */   
/* 36 */   public static final ErrorEval VALUE_INVALID = new ErrorEval(FormulaError.VALUE);
/*    */   
/* 38 */   public static final ErrorEval REF_INVALID = new ErrorEval(FormulaError.REF);
/*    */   
/* 40 */   public static final ErrorEval NAME_INVALID = new ErrorEval(FormulaError.NAME);
/*    */   
/* 42 */   public static final ErrorEval NUM_ERROR = new ErrorEval(FormulaError.NUM);
/*    */   
/* 44 */   public static final ErrorEval NA = new ErrorEval(FormulaError.NA);
/*    */ 
/*    */   
/* 47 */   public static final ErrorEval FUNCTION_NOT_IMPLEMENTED = new ErrorEval(FormulaError.FUNCTION_NOT_IMPLEMENTED);
/*    */ 
/*    */   
/* 50 */   public static final ErrorEval CIRCULAR_REF_ERROR = new ErrorEval(FormulaError.CIRCULAR_REF);
/*    */ 
/*    */   
/*    */   private FormulaError _error;
/*    */ 
/*    */   
/*    */   public static ErrorEval valueOf(int paramInt) {
/* 57 */     FormulaError formulaError = FormulaError.forInt(paramInt);
/* 58 */     ErrorEval errorEval = evals.get(formulaError);
/* 59 */     if (errorEval != null) {
/* 60 */       return errorEval;
/*    */     }
/* 62 */     throw new RuntimeException("Unhandled error type for code " + paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getText(int paramInt) {
/* 72 */     if (FormulaError.isValidCode(paramInt)) {
/* 73 */       return FormulaError.forInt(paramInt).getString();
/*    */     }
/*    */     
/* 76 */     return "~non~std~err(" + paramInt + ")~";
/*    */   }
/*    */ 
/*    */   
/*    */   private ErrorEval(FormulaError paramFormulaError) {
/* 81 */     this._error = paramFormulaError;
/* 82 */     evals.put(paramFormulaError, this);
/*    */   }
/*    */   
/*    */   public int getErrorCode() {
/* 86 */     return this._error.getLongCode();
/*    */   }
/*    */   public String getErrorString() {
/* 89 */     return this._error.getString();
/*    */   }
/*    */   public String toString() {
/* 92 */     StringBuffer stringBuffer = new StringBuffer(64);
/* 93 */     stringBuffer.append(getClass().getName()).append(" [");
/* 94 */     stringBuffer.append(this._error.getString());
/* 95 */     stringBuffer.append("]");
/* 96 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\ErrorEval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */