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
/*    */ public class CallbackParameterContext
/*    */   extends FromNativeContext
/*    */ {
/*    */   private Method method;
/*    */   private Object[] args;
/*    */   private int index;
/*    */   
/*    */   CallbackParameterContext(Class<?> paramClass, Method paramMethod, Object[] paramArrayOfObject, int paramInt) {
/* 34 */     super(paramClass);
/* 35 */     this.method = paramMethod;
/* 36 */     this.args = paramArrayOfObject;
/* 37 */     this.index = paramInt;
/*    */   }
/* 39 */   public Method getMethod() { return this.method; }
/* 40 */   public Object[] getArguments() { return this.args; } public int getIndex() {
/* 41 */     return this.index;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\CallbackParameterContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */