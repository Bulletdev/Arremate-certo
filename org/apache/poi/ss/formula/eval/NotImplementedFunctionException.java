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
/*    */ 
/*    */ public final class NotImplementedFunctionException
/*    */   extends NotImplementedException
/*    */ {
/*    */   private static final long serialVersionUID = 1208119411557559057L;
/*    */   private String functionName;
/*    */   
/*    */   public NotImplementedFunctionException(String paramString) {
/* 33 */     super(paramString);
/* 34 */     this.functionName = paramString;
/*    */   }
/*    */   public NotImplementedFunctionException(String paramString, NotImplementedException paramNotImplementedException) {
/* 37 */     super(paramString, paramNotImplementedException);
/* 38 */     this.functionName = paramString;
/*    */   }
/*    */   
/*    */   public String getFunctionName() {
/* 42 */     return this.functionName;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\eval\NotImplementedFunctionException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */