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
/*    */ 
/*    */ 
/*    */ public class MethodResultContext
/*    */   extends FunctionResultContext
/*    */ {
/*    */   private final Method method;
/*    */   
/*    */   MethodResultContext(Class<?> paramClass, Function paramFunction, Object[] paramArrayOfObject, Method paramMethod) {
/* 35 */     super(paramClass, paramFunction, paramArrayOfObject);
/* 36 */     this.method = paramMethod;
/*    */   }
/*    */ 
/*    */   
/*    */   public Method getMethod() {
/* 41 */     return this.method;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\MethodResultContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */