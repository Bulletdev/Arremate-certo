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
/*    */ public class FunctionResultContext
/*    */   extends FromNativeContext
/*    */ {
/*    */   private Function function;
/*    */   private Object[] args;
/*    */   
/*    */   FunctionResultContext(Class<?> paramClass, Function paramFunction, Object[] paramArrayOfObject) {
/* 32 */     super(paramClass);
/* 33 */     this.function = paramFunction;
/* 34 */     this.args = paramArrayOfObject;
/*    */   }
/*    */ 
/*    */   
/*    */   public Function getFunction() {
/* 39 */     return this.function;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object[] getArguments() {
/* 44 */     return this.args;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\FunctionResultContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */