/*    */ package org.apache.http.client.utils;
/*    */ 
/*    */ import java.lang.reflect.InvocationTargetException;
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
/*    */ public class CloneUtils
/*    */ {
/*    */   public static <T> T cloneObject(T paramT) throws CloneNotSupportedException {
/* 43 */     if (paramT == null) {
/* 44 */       return null;
/*    */     }
/* 46 */     if (paramT instanceof Cloneable) {
/* 47 */       Method method; Class<?> clazz = paramT.getClass();
/*    */       
/*    */       try {
/* 50 */         method = clazz.getMethod("clone", (Class[])null);
/* 51 */       } catch (NoSuchMethodException noSuchMethodException) {
/* 52 */         throw new NoSuchMethodError(noSuchMethodException.getMessage());
/*    */       } 
/*    */       
/*    */       try {
/* 56 */         return (T)method.invoke(paramT, (Object[])null);
/*    */       }
/* 58 */       catch (InvocationTargetException invocationTargetException) {
/* 59 */         Throwable throwable = invocationTargetException.getCause();
/* 60 */         if (throwable instanceof CloneNotSupportedException) {
/* 61 */           throw (CloneNotSupportedException)throwable;
/*    */         }
/* 63 */         throw new Error("Unexpected exception", throwable);
/* 64 */       } catch (IllegalAccessException illegalAccessException) {
/* 65 */         throw new IllegalAccessError(illegalAccessException.getMessage());
/*    */       } 
/*    */     } 
/* 68 */     throw new CloneNotSupportedException();
/*    */   }
/*    */   
/*    */   public static Object clone(Object paramObject) throws CloneNotSupportedException {
/* 72 */     return cloneObject(paramObject);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\clien\\utils\CloneUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */