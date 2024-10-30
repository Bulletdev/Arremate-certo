/*    */ package ch.qos.logback.classic.util;
/*    */ 
/*    */ import ch.qos.logback.core.util.Loader;
/*    */ import java.util.Iterator;
/*    */ import java.util.ServiceLoader;
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
/*    */ public class EnvUtil
/*    */ {
/* 31 */   static ClassLoader testServiceLoaderClassLoader = null;
/*    */   
/*    */   public static boolean isGroovyAvailable() {
/* 34 */     ClassLoader classLoader = Loader.getClassLoaderOfClass(EnvUtil.class);
/*    */     try {
/* 36 */       Class<?> clazz = classLoader.loadClass("groovy.lang.Binding");
/* 37 */       return (clazz != null);
/* 38 */     } catch (ClassNotFoundException classNotFoundException) {
/* 39 */       return false;
/*    */     } 
/*    */   }
/*    */   
/*    */   private static ClassLoader getServiceLoaderClassLoader() {
/* 44 */     return (testServiceLoaderClassLoader == null) ? Loader.getClassLoaderOfClass(EnvUtil.class) : testServiceLoaderClassLoader;
/*    */   }
/*    */   
/*    */   public static <T> T loadFromServiceLoader(Class<T> paramClass) {
/* 48 */     ServiceLoader<T> serviceLoader = ServiceLoader.load(paramClass, getServiceLoaderClassLoader());
/* 49 */     Iterator<T> iterator = serviceLoader.iterator();
/* 50 */     if (iterator.hasNext())
/* 51 */       return iterator.next(); 
/* 52 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classi\\util\EnvUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */