/*     */ package org.junit.e;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Callable;
/*     */ import org.d.k;
/*     */ import org.junit.b.a;
/*     */ import org.junit.c;
/*     */ import org.junit.f.a.h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends p
/*     */ {
/*  38 */   private List<Throwable> ak = new ArrayList<Throwable>();
/*     */ 
/*     */   
/*     */   protected void iF() throws Throwable {
/*  42 */     h.I(this.ak);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void m(Throwable paramThrowable) {
/*  49 */     if (paramThrowable == null) {
/*  50 */       throw new NullPointerException("Error cannot be null");
/*     */     }
/*  52 */     if (paramThrowable instanceof org.junit.c.b) {
/*  53 */       AssertionError assertionError = new AssertionError(paramThrowable.getMessage());
/*  54 */       assertionError.initCause(paramThrowable);
/*  55 */       this.ak.add(assertionError);
/*     */     } else {
/*  57 */       this.ak.add(paramThrowable);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> void c(T paramT, k<T> paramk) {
/*  66 */     c("", paramT, paramk);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> void c(String paramString, T paramT, k<T> paramk) {
/*  75 */     b(new Callable(this, paramString, paramT, paramk) {
/*     */           public Object call() throws Exception {
/*  77 */             c.a(this.mf, this.D, this.e);
/*  78 */             return this.D;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T b(Callable<T> paramCallable) {
/*     */     try {
/*  90 */       return paramCallable.call();
/*  91 */     } catch (org.junit.c.b b1) {
/*  92 */       AssertionError assertionError = new AssertionError("Callable threw AssumptionViolatedException");
/*  93 */       assertionError.initCause((Throwable)b1);
/*  94 */       m(assertionError);
/*  95 */       return null;
/*  96 */     } catch (Throwable throwable) {
/*  97 */       m(throwable);
/*  98 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(Class<? extends Throwable> paramClass, a parama) {
/*     */     try {
/* 114 */       c.a(paramClass, parama);
/* 115 */     } catch (AssertionError assertionError) {
/* 116 */       m(assertionError);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\e\b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */