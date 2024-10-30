/*    */ package com.sun.jna;
/*    */ 
/*    */ import java.lang.reflect.Method;
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
/*    */ public class MethodParameterContext
/*    */   extends FunctionParameterContext
/*    */ {
/*    */   private Method method;
/*    */   
/*    */   MethodParameterContext(Function paramFunction, Object[] paramArrayOfObject, int paramInt, Method paramMethod) {
/* 33 */     super(paramFunction, paramArrayOfObject, paramInt);
/* 34 */     this.method = paramMethod;
/*    */   }
/*    */   public Method getMethod() {
/* 37 */     return this.method;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\MethodParameterContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */