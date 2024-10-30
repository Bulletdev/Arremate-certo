/*    */ package org.apache.poi.ss.formula.eval;
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
/*    */ public final class FunctionNameEval
/*    */   implements ValueEval
/*    */ {
/*    */   private final String _functionName;
/*    */   
/*    */   public FunctionNameEval(String paramString) {
/* 31 */     this._functionName = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getFunctionName() {
/* 36 */     return this._functionName;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 40 */     StringBuffer stringBuffer = new StringBuffer(64);
/* 41 */     stringBuffer.append(getClass().getName()).append(" [");
/* 42 */     stringBuffer.append(this._functionName);
/* 43 */     stringBuffer.append("]");
/* 44 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\FunctionNameEval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */