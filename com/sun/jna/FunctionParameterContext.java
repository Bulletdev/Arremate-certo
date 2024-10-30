/*    */ package com.sun.jna;
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
/*    */ public class FunctionParameterContext
/*    */   extends ToNativeContext
/*    */ {
/*    */   private Function function;
/*    */   private Object[] args;
/*    */   private int index;
/*    */   
/*    */   FunctionParameterContext(Function paramFunction, Object[] paramArrayOfObject, int paramInt) {
/* 34 */     this.function = paramFunction;
/* 35 */     this.args = paramArrayOfObject;
/* 36 */     this.index = paramInt;
/*    */   }
/*    */   public Function getFunction() {
/* 39 */     return this.function;
/*    */   }
/* 41 */   public Object[] getParameters() { return this.args; } public int getParameterIndex() {
/* 42 */     return this.index;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\FunctionParameterContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */