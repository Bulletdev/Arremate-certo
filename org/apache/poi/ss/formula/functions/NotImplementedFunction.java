/*    */ package org.apache.poi.ss.formula.functions;
/*    */ 
/*    */ import org.apache.poi.ss.formula.eval.NotImplementedFunctionException;
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
/*    */ public final class NotImplementedFunction
/*    */   implements Function
/*    */ {
/*    */   private final String _functionName;
/*    */   
/*    */   protected NotImplementedFunction() {
/* 33 */     this._functionName = getClass().getName();
/*    */   }
/*    */   public NotImplementedFunction(String paramString) {
/* 36 */     this._functionName = paramString;
/*    */   }
/*    */   
/*    */   public ValueEval evaluate(ValueEval[] paramArrayOfValueEval, int paramInt1, int paramInt2) {
/* 40 */     throw new NotImplementedFunctionException(this._functionName);
/*    */   }
/*    */   public String getFunctionName() {
/* 43 */     return this._functionName;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\functions\NotImplementedFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */