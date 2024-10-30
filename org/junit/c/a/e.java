/*    */ package org.junit.c.a;
/*    */ 
/*    */ import junit.b.j;
/*    */ import org.junit.f.a.j;
/*    */ import org.junit.runner.m;
/*    */ 
/*    */ public class e
/*    */   extends j {
/*    */   public m a(Class<?> paramClass) throws Throwable {
/* 10 */     if (k(paramClass)) {
/* 11 */       return (m)new org.junit.c.e.e(paramClass);
/*    */     }
/* 13 */     return null;
/*    */   }
/*    */   
/*    */   boolean k(Class<?> paramClass) {
/* 17 */     return j.class.isAssignableFrom(paramClass);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\a\e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */