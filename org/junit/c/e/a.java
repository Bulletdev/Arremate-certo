/*    */ package org.junit.c.e;
/*    */ 
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ import java.lang.reflect.Method;
/*    */ import java.util.List;
/*    */ import org.junit.c.b;
/*    */ import org.junit.runner.b.c;
/*    */ import org.junit.runner.c;
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
/*    */ public class a
/*    */ {
/*    */   private c a;
/*    */   private j a;
/*    */   private c b;
/*    */   private final Runnable f;
/*    */   
/*    */   public a(c paramc, j paramj, c paramc1, Runnable paramRunnable) {
/* 27 */     this.a = (j)paramc;
/* 28 */     this.a = paramj;
/* 29 */     this.b = paramc1;
/* 30 */     this.f = paramRunnable;
/*    */   }
/*    */   
/*    */   protected void iq() {
/* 34 */     this.f.run();
/*    */   }
/*    */   
/*    */   protected void l(Throwable paramThrowable) {
/* 38 */     this.a.c(new org.junit.runner.b.a(this.b, paramThrowable));
/*    */   }
/*    */   
/*    */   public void ir() {
/*    */     
/* 43 */     try { is();
/* 44 */       iq(); }
/* 45 */     catch (c c1) {  }
/*    */     finally
/* 47 */     { it(); }
/*    */   
/*    */   }
/*    */   
/*    */   private void is() throws c {
/*    */     try {
/*    */       try {
/* 54 */         List<Method> list = this.a.bl();
/* 55 */         for (Method method : list) {
/* 56 */           method.invoke(null, new Object[0]);
/*    */         }
/* 58 */       } catch (InvocationTargetException invocationTargetException) {
/* 59 */         throw invocationTargetException.getTargetException();
/*    */       } 
/* 61 */     } catch (b b) {
/* 62 */       throw new c();
/* 63 */     } catch (Throwable throwable) {
/* 64 */       l(throwable);
/* 65 */       throw new c();
/*    */     } 
/*    */   }
/*    */   
/*    */   private void it() {
/* 70 */     List<Method> list = this.a.bm();
/* 71 */     for (Method method : list) {
/*    */       try {
/* 73 */         method.invoke(null, new Object[0]);
/* 74 */       } catch (InvocationTargetException invocationTargetException) {
/* 75 */         l(invocationTargetException.getTargetException());
/* 76 */       } catch (Throwable throwable) {
/* 77 */         l(throwable);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\e\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */