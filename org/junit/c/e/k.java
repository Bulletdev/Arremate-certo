/*    */ package org.junit.c.e;
/*    */ 
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ import java.lang.reflect.Method;
/*    */ import java.util.List;
/*    */ import org.junit.a;
/*    */ import org.junit.f;
/*    */ import org.junit.m;
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
/*    */ public class k
/*    */ {
/*    */   private final Method method;
/*    */   private j a;
/*    */   
/*    */   public k(Method paramMethod, j paramj) {
/* 25 */     this.method = paramMethod;
/* 26 */     this.a = paramj;
/*    */   }
/*    */   
/*    */   public boolean gl() {
/* 30 */     return (this.method.getAnnotation(org.junit.k.class) != null);
/*    */   }
/*    */   
/*    */   public long getTimeout() {
/* 34 */     m m = this.method.<m>getAnnotation(m.class);
/* 35 */     if (m == null) {
/* 36 */       return 0L;
/*    */     }
/* 38 */     return m.am();
/*    */   }
/*    */ 
/*    */   
/*    */   protected Class<? extends Throwable> l() {
/* 43 */     m m = this.method.<m>getAnnotation(m.class);
/* 44 */     if (m == null || m.k() == m.a.class) {
/* 45 */       return null;
/*    */     }
/* 47 */     return m.k();
/*    */   }
/*    */ 
/*    */   
/*    */   boolean d(Throwable paramThrowable) {
/* 52 */     return !l().isAssignableFrom(paramThrowable.getClass());
/*    */   }
/*    */   
/*    */   boolean gm() {
/* 56 */     return (l() != null);
/*    */   }
/*    */   
/*    */   List<Method> bl() {
/* 60 */     return this.a.a((Class)f.class);
/*    */   }
/*    */   
/*    */   List<Method> bm() {
/* 64 */     return this.a.a((Class)a.class);
/*    */   }
/*    */   
/*    */   public void H(Object paramObject) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
/* 68 */     this.method.invoke(paramObject, new Object[0]);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\e\k.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */