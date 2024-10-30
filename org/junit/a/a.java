/*    */ package org.junit.a;
/*    */ 
/*    */ import java.util.concurrent.ExecutorService;
/*    */ import java.util.concurrent.Executors;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import org.junit.f.a.e;
/*    */ import org.junit.f.a.j;
/*    */ import org.junit.f.a.k;
/*    */ import org.junit.f.f;
/*    */ import org.junit.runner.a;
/*    */ import org.junit.runner.m;
/*    */ 
/*    */ public class a
/*    */   extends a
/*    */ {
/*    */   private final boolean df;
/*    */   private final boolean dg;
/*    */   
/*    */   public a(boolean paramBoolean1, boolean paramBoolean2) {
/* 20 */     this.df = paramBoolean1;
/* 21 */     this.dg = paramBoolean2;
/*    */   }
/*    */   
/*    */   public static a a() {
/* 25 */     return new a(true, false);
/*    */   }
/*    */   
/*    */   public static a b() {
/* 29 */     return new a(false, true);
/*    */   }
/*    */   
/*    */   private static m a(m paramm) {
/* 33 */     if (paramm instanceof f) {
/* 34 */       ((f)paramm).a(new k() {
/* 35 */             private final ExecutorService k = Executors.newCachedThreadPool();
/*    */             
/*    */             public void a(Runnable param1Runnable) {
/* 38 */               this.k.submit(param1Runnable);
/*    */             }
/*    */             
/*    */             public void finished() {
/*    */               try {
/* 43 */                 this.k.shutdown();
/* 44 */                 this.k.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
/* 45 */               } catch (InterruptedException interruptedException) {
/* 46 */                 interruptedException.printStackTrace(System.err);
/*    */               } 
/*    */             }
/*    */           });
/*    */     }
/* 51 */     return paramm;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public m a(j paramj, Class<?>[] paramArrayOfClass) throws e {
/* 57 */     m m = super.a(paramj, paramArrayOfClass);
/* 58 */     return this.df ? a(m) : m;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected m a(j paramj, Class<?> paramClass) throws Throwable {
/* 64 */     m m = super.a(paramj, paramClass);
/* 65 */     return this.dg ? a(m) : m;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\a\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */