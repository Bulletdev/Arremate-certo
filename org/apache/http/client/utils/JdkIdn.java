/*    */ package org.apache.http.client.utils;
/*    */ 
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ import java.lang.reflect.Method;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
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
/*    */ @Deprecated
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class JdkIdn
/*    */   implements Idn
/*    */ {
/*    */   private final Method toUnicode;
/*    */   
/*    */   public JdkIdn() throws ClassNotFoundException {
/* 52 */     Class<?> clazz = Class.forName("java.net.IDN");
/*    */     try {
/* 54 */       this.toUnicode = clazz.getMethod("toUnicode", new Class[] { String.class });
/* 55 */     } catch (SecurityException securityException) {
/*    */       
/* 57 */       throw new IllegalStateException(securityException.getMessage(), securityException);
/* 58 */     } catch (NoSuchMethodException noSuchMethodException) {
/*    */       
/* 60 */       throw new IllegalStateException(noSuchMethodException.getMessage(), noSuchMethodException);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String toUnicode(String paramString) {
/*    */     try {
/* 67 */       return (String)this.toUnicode.invoke(null, new Object[] { paramString });
/* 68 */     } catch (IllegalAccessException illegalAccessException) {
/* 69 */       throw new IllegalStateException(illegalAccessException.getMessage(), illegalAccessException);
/* 70 */     } catch (InvocationTargetException invocationTargetException) {
/* 71 */       Throwable throwable = invocationTargetException.getCause();
/* 72 */       throw new RuntimeException(throwable.getMessage(), throwable);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\clien\\utils\JdkIdn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */