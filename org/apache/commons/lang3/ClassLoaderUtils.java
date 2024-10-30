/*    */ package org.apache.commons.lang3;
/*    */ 
/*    */ import java.net.URLClassLoader;
/*    */ import java.util.Arrays;
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
/*    */ public class ClassLoaderUtils
/*    */ {
/*    */   public static String toString(ClassLoader paramClassLoader) {
/* 37 */     if (paramClassLoader instanceof URLClassLoader) {
/* 38 */       return toString((URLClassLoader)paramClassLoader);
/*    */     }
/* 40 */     return paramClassLoader.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String toString(URLClassLoader paramURLClassLoader) {
/* 51 */     return paramURLClassLoader + Arrays.toString((Object[])paramURLClassLoader.getURLs());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\ClassLoaderUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */