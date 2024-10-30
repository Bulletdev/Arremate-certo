/*    */ package org.junit.c.b;
/*    */ 
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ import java.lang.reflect.Method;
/*    */ import org.junit.c.d;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class e
/*    */   implements g
/*    */ {
/*    */   private final Object aH;
/*    */   
/*    */   private static final class a
/*    */   {
/*    */     static final Method i;
/*    */     static final Method j;
/*    */     private static final String md = "Unable to access ThreadMXBean";
/*    */     
/*    */     static {
/* 22 */       Method method1 = null;
/* 23 */       Method method2 = null;
/*    */       try {
/* 25 */         Class clazz = d.getClass("java.lang.management.ThreadMXBean");
/* 26 */         method1 = clazz.getMethod("getThreadCpuTime", new Class[] { long.class });
/* 27 */         method2 = clazz.getMethod("isThreadCpuTimeSupported", new Class[0]);
/* 28 */       } catch (ClassNotFoundException classNotFoundException) {
/*    */       
/* 30 */       } catch (NoSuchMethodException noSuchMethodException) {
/*    */       
/* 32 */       } catch (SecurityException securityException) {}
/*    */ 
/*    */       
/* 35 */       i = method1;
/* 36 */       j = method2;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   e(Object paramObject) {
/* 42 */     this.aH = paramObject;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public long m(long paramLong) {
/* 49 */     if (a.i != null) {
/* 50 */       InvocationTargetException invocationTargetException; ClassCastException classCastException = null;
/*    */       try {
/* 52 */         return ((Long)a.i.invoke(this.aH, new Object[] { Long.valueOf(paramLong) })).longValue();
/* 53 */       } catch (ClassCastException classCastException1) {
/* 54 */         classCastException = classCastException1;
/*    */       }
/* 56 */       catch (IllegalAccessException illegalAccessException2) {
/* 57 */         IllegalAccessException illegalAccessException1 = illegalAccessException2;
/*    */       }
/* 59 */       catch (IllegalArgumentException illegalArgumentException2) {
/* 60 */         IllegalArgumentException illegalArgumentException1 = illegalArgumentException2;
/*    */       }
/* 62 */       catch (InvocationTargetException invocationTargetException1) {
/* 63 */         invocationTargetException = invocationTargetException1;
/*    */       } 
/*    */       
/* 66 */       throw new UnsupportedOperationException("Unable to access ThreadMXBean", invocationTargetException);
/*    */     } 
/* 68 */     throw new UnsupportedOperationException("Unable to access ThreadMXBean");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean gk() {
/* 75 */     if (a.j != null) {
/*    */       try {
/* 77 */         return ((Boolean)a.j.invoke(this.aH, new Object[0])).booleanValue();
/* 78 */       } catch (ClassCastException classCastException) {
/*    */       
/* 80 */       } catch (IllegalAccessException illegalAccessException) {
/*    */       
/* 82 */       } catch (IllegalArgumentException illegalArgumentException) {
/*    */       
/* 84 */       } catch (InvocationTargetException invocationTargetException) {}
/*    */     }
/*    */ 
/*    */     
/* 88 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\b\e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */