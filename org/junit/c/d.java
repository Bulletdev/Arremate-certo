/*    */ package org.junit.c;
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
/*    */ public class d
/*    */ {
/*    */   public static Class<?> getClass(String paramString) throws ClassNotFoundException {
/* 27 */     return a(paramString, d.class);
/*    */   }
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
/*    */   public static Class<?> a(String paramString, Class<?> paramClass) throws ClassNotFoundException {
/* 41 */     ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
/* 42 */     return Class.forName(paramString, true, (classLoader == null) ? paramClass.getClassLoader() : classLoader);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */