/*    */ package org.junit.c.b;
/*    */ 
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ import java.lang.reflect.Method;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ final class d
/*    */   implements f
/*    */ {
/*    */   private final Object aG;
/*    */   
/*    */   private static final class a
/*    */   {
/*    */     private static final Method h;
/*    */     
/*    */     static {
/* 19 */       Method method = null;
/*    */       try {
/* 21 */         Class clazz = org.junit.c.d.getClass("java.lang.management.RuntimeMXBean");
/* 22 */         method = clazz.getMethod("getInputArguments", new Class[0]);
/* 23 */       } catch (ClassNotFoundException classNotFoundException) {
/*    */       
/* 25 */       } catch (NoSuchMethodException noSuchMethodException) {
/*    */       
/* 27 */       } catch (SecurityException securityException) {}
/*    */ 
/*    */       
/* 30 */       h = method;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   d(Object paramObject) {
/* 36 */     this.aG = paramObject;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<String> bh() {
/* 44 */     if (a.c() != null) {
/*    */       try {
/* 46 */         return (List<String>)a.c().invoke(this.aG, new Object[0]);
/* 47 */       } catch (ClassCastException classCastException) {
/*    */       
/* 49 */       } catch (IllegalAccessException illegalAccessException) {
/*    */       
/* 51 */       } catch (IllegalArgumentException illegalArgumentException) {
/*    */       
/* 53 */       } catch (InvocationTargetException invocationTargetException) {}
/*    */     }
/*    */ 
/*    */     
/* 57 */     return Collections.emptyList();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\b\d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */