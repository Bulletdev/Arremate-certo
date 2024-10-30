/*    */ package org.junit.c.a;
/*    */ 
/*    */ import org.junit.c.e.i;
/*    */ import org.junit.f.a.j;
/*    */ import org.junit.runner.m;
/*    */ 
/*    */ public class h
/*    */   extends j {
/*    */   public m a(Class<?> paramClass) throws Throwable {
/* 10 */     if (l(paramClass)) {
/* 11 */       return (m)new i(paramClass);
/*    */     }
/* 13 */     return null;
/*    */   }
/*    */   
/*    */   public boolean l(Class<?> paramClass) {
/*    */     try {
/* 18 */       paramClass.getMethod("suite", new Class[0]);
/* 19 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 20 */       return false;
/*    */     } 
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\a\h.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */