/*    */ package com.google.a.n;
/*    */ 
/*    */ import com.google.a.a.a;
/*    */ import com.google.a.b.D;
/*    */ import java.lang.reflect.InvocationHandler;
/*    */ import java.lang.reflect.Proxy;
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
/*    */ @a
/*    */ public final class h
/*    */ {
/*    */   public static String getPackageName(Class<?> paramClass) {
/* 38 */     return getPackageName(paramClass.getName());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getPackageName(String paramString) {
/* 47 */     int i = paramString.lastIndexOf('.');
/* 48 */     return (i < 0) ? "" : paramString.substring(0, i);
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
/*    */   
/*    */   public static void a(Class<?>... paramVarArgs) {
/* 63 */     for (Class<?> clazz : paramVarArgs) {
/*    */       try {
/* 65 */         Class.forName(clazz.getName(), true, clazz.getClassLoader());
/* 66 */       } catch (ClassNotFoundException classNotFoundException) {
/* 67 */         throw new AssertionError(classNotFoundException);
/*    */       } 
/*    */     } 
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
/*    */   public static <T> T a(Class<T> paramClass, InvocationHandler paramInvocationHandler) {
/* 82 */     D.checkNotNull(paramInvocationHandler);
/* 83 */     D.a(paramClass.isInterface(), "%s is not an interface", paramClass);
/*    */     
/* 85 */     Object object = Proxy.newProxyInstance(paramClass
/* 86 */         .getClassLoader(), new Class[] { paramClass }, paramInvocationHandler);
/* 87 */     return paramClass.cast(object);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\n\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */