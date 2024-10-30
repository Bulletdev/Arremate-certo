/*    */ package com.sun.jna;
/*    */ 
/*    */ import java.lang.reflect.InvocationTargetException;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ abstract class Klass
/*    */ {
/*    */   public static <T> T newInstance(Class<T> paramClass) {
/*    */     try {
/* 48 */       return paramClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
/* 49 */     } catch (IllegalAccessException illegalAccessException) {
/* 50 */       String str = "Can't create an instance of " + paramClass + ", requires a public no-arg constructor: " + illegalAccessException;
/*    */       
/* 52 */       throw new IllegalArgumentException(str, illegalAccessException);
/* 53 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 54 */       String str = "Can't create an instance of " + paramClass + ", requires a public no-arg constructor: " + illegalArgumentException;
/*    */       
/* 56 */       throw new IllegalArgumentException(str, illegalArgumentException);
/* 57 */     } catch (InstantiationException instantiationException) {
/* 58 */       String str = "Can't create an instance of " + paramClass + ", requires a public no-arg constructor: " + instantiationException;
/*    */       
/* 60 */       throw new IllegalArgumentException(str, instantiationException);
/* 61 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 62 */       String str = "Can't create an instance of " + paramClass + ", requires a public no-arg constructor: " + noSuchMethodException;
/*    */       
/* 64 */       throw new IllegalArgumentException(str, noSuchMethodException);
/* 65 */     } catch (SecurityException securityException) {
/* 66 */       String str = "Can't create an instance of " + paramClass + ", requires a public no-arg constructor: " + securityException;
/*    */       
/* 68 */       throw new IllegalArgumentException(str, securityException);
/* 69 */     } catch (InvocationTargetException invocationTargetException) {
/* 70 */       if (invocationTargetException.getCause() instanceof RuntimeException) {
/* 71 */         throw (RuntimeException)invocationTargetException.getCause();
/*    */       }
/* 73 */       String str = "Can't create an instance of " + paramClass + ", requires a public no-arg constructor: " + invocationTargetException;
/*    */       
/* 75 */       throw new IllegalArgumentException(str, invocationTargetException);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\Klass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */