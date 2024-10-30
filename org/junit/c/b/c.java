/*    */ package org.junit.c.b;
/*    */ 
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ import org.junit.c.d;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class c
/*    */ {
/*    */   private static final class a
/*    */   {
/*    */     private static final Class<?> l;
/*    */     
/*    */     static {
/* 15 */       Class<?> clazz = null;
/*    */       try {
/* 17 */         clazz = d.getClass("java.lang.management.ManagementFactory");
/* 18 */       } catch (ClassNotFoundException classNotFoundException) {}
/*    */ 
/*    */       
/* 21 */       l = clazz;
/*    */     }
/*    */     
/*    */     static Object h(String param1String) {
/* 25 */       if (l != null) {
/*    */         try {
/* 27 */           return l.getMethod(param1String, new Class[0]).invoke(null, new Object[0]);
/* 28 */         } catch (IllegalAccessException illegalAccessException) {
/*    */         
/* 30 */         } catch (IllegalArgumentException illegalArgumentException) {
/*    */         
/* 32 */         } catch (InvocationTargetException invocationTargetException) {
/*    */         
/* 34 */         } catch (NoSuchMethodException noSuchMethodException) {
/*    */         
/* 36 */         } catch (SecurityException securityException) {}
/*    */       }
/*    */ 
/*    */       
/* 40 */       return null;
/*    */     }
/*    */   }
/*    */   
/*    */   private static final class b {
/* 45 */     private static final f a = a(c.a.h("getRuntimeMXBean"));
/*    */ 
/*    */     
/*    */     private static final f a(Object param1Object) {
/* 49 */       return (param1Object != null) ? new d(param1Object) : new a();
/*    */     }
/*    */   }
/*    */   
/*    */   private static final class c
/*    */   {
/* 55 */     private static final g a = a(c.a.h("getThreadMXBean"));
/*    */ 
/*    */     
/*    */     private static final g a(Object param1Object) {
/* 59 */       return (param1Object != null) ? new e(param1Object) : new b();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static f a() {
/* 68 */     return b.b();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static g a() {
/* 75 */     return c.b();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\b\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */