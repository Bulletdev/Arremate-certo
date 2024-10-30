/*    */ package org.apache.commons.net.util;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ import javax.net.ssl.SSLSocket;
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
/*    */ public class SSLSocketUtils
/*    */ {
/*    */   public static boolean enableEndpointNameVerification(SSLSocket paramSSLSocket) {
/*    */     try {
/* 44 */       Class<?> clazz = Class.forName("javax.net.ssl.SSLParameters");
/*    */       
/* 46 */       Method method1 = clazz.getDeclaredMethod("setEndpointIdentificationAlgorithm", new Class[] { String.class });
/* 47 */       Method method2 = SSLSocket.class.getDeclaredMethod("getSSLParameters", new Class[0]);
/* 48 */       Method method3 = SSLSocket.class.getDeclaredMethod("setSSLParameters", new Class[] { clazz });
/* 49 */       if (method1 != null && method2 != null && method3 != null) {
/* 50 */         Object object = method2.invoke(paramSSLSocket, new Object[0]);
/* 51 */         if (object != null) {
/* 52 */           method1.invoke(object, new Object[] { "HTTPS" });
/* 53 */           method3.invoke(paramSSLSocket, new Object[] { object });
/* 54 */           return true;
/*    */         } 
/*    */       } 
/* 57 */     } catch (SecurityException|ClassNotFoundException|NoSuchMethodException|IllegalArgumentException|IllegalAccessException|java.lang.reflect.InvocationTargetException securityException) {}
/*    */ 
/*    */     
/* 60 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\ne\\util\SSLSocketUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */