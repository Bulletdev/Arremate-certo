/*     */ package org.junit.c.e;
/*     */ 
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.TimeoutException;
/*     */ import org.junit.c.b;
/*     */ import org.junit.f.a.n;
/*     */ import org.junit.runner.b.a;
/*     */ import org.junit.runner.b.c;
/*     */ import org.junit.runner.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class g
/*     */ {
/*     */   private final Object aI;
/*     */   private final c a;
/*     */   private final c b;
/*     */   private k a;
/*     */   
/*     */   public g(Object paramObject, k paramk, c paramc, c paramc1) {
/*  33 */     this.aI = paramObject;
/*  34 */     this.a = (k)paramc;
/*  35 */     this.b = paramc1;
/*  36 */     this.a = paramk;
/*     */   }
/*     */   
/*     */   public void run() {
/*  40 */     if (this.a.gl()) {
/*  41 */       this.a.o(this.b);
/*     */       return;
/*     */     } 
/*  44 */     this.a.n(this.b);
/*     */     try {
/*  46 */       long l = this.a.getTimeout();
/*  47 */       if (l > 0L) {
/*  48 */         Z(l);
/*     */       } else {
/*  50 */         hg();
/*     */       } 
/*     */     } finally {
/*  53 */       this.a.p(this.b);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void Z(long paramLong) {
/*  58 */     b(new Runnable(this, paramLong)
/*     */         {
/*     */           public void run() {
/*  61 */             ExecutorService executorService = Executors.newSingleThreadExecutor();
/*  62 */             Callable<Object> callable = new Callable(this) {
/*     */                 public Object call() throws Exception {
/*  64 */                   this.a.a.iu();
/*  65 */                   return null;
/*     */                 }
/*     */               };
/*  68 */             Future future = executorService.submit(callable);
/*  69 */             executorService.shutdown();
/*     */             try {
/*  71 */               boolean bool = executorService.awaitTermination(this.bW, TimeUnit.MILLISECONDS);
/*     */               
/*  73 */               if (!bool) {
/*  74 */                 executorService.shutdownNow();
/*     */               }
/*  76 */               future.get(0L, TimeUnit.MILLISECONDS);
/*  77 */             } catch (TimeoutException timeoutException) {
/*  78 */               this.a.l((Throwable)new n(this.bW, TimeUnit.MILLISECONDS));
/*  79 */             } catch (Exception exception) {
/*  80 */               this.a.l(exception);
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void hg() {
/*  87 */     b(new Runnable(this) {
/*     */           public void run() {
/*  89 */             this.a.iu();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void b(Runnable paramRunnable) {
/*     */     
/*  96 */     try { is();
/*  97 */       paramRunnable.run(); }
/*  98 */     catch (c c1) {  }
/*  99 */     catch (Exception exception)
/* 100 */     { throw new RuntimeException("test should never throw an exception to this level"); }
/*     */     finally
/* 102 */     { it(); }
/*     */   
/*     */   }
/*     */   
/*     */   protected void iu() {
/*     */     try {
/* 108 */       this.a.H(this.aI);
/* 109 */       if (this.a.gm()) {
/* 110 */         l(new AssertionError("Expected exception: " + this.a.l().getName()));
/*     */       }
/* 112 */     } catch (InvocationTargetException invocationTargetException) {
/* 113 */       Throwable throwable = invocationTargetException.getTargetException();
/* 114 */       if (throwable instanceof b)
/*     */         return; 
/* 116 */       if (!this.a.gm()) {
/* 117 */         l(throwable);
/* 118 */       } else if (this.a.d(throwable)) {
/* 119 */         String str = "Unexpected exception, expected<" + this.a.l().getName() + "> but was<" + throwable.getClass().getName() + ">";
/*     */         
/* 121 */         l(new Exception(str, throwable));
/*     */       } 
/* 123 */     } catch (Throwable throwable) {
/* 124 */       l(throwable);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void is() throws c {
/*     */     try {
/*     */       try {
/* 131 */         List<Method> list = this.a.bl();
/* 132 */         for (Method method : list) {
/* 133 */           method.invoke(this.aI, new Object[0]);
/*     */         }
/* 135 */       } catch (InvocationTargetException invocationTargetException) {
/* 136 */         throw invocationTargetException.getTargetException();
/*     */       } 
/* 138 */     } catch (b b) {
/* 139 */       throw new c();
/* 140 */     } catch (Throwable throwable) {
/* 141 */       l(throwable);
/* 142 */       throw new c();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void it() {
/* 147 */     List<Method> list = this.a.bm();
/* 148 */     for (Method method : list) {
/*     */       try {
/* 150 */         method.invoke(this.aI, new Object[0]);
/* 151 */       } catch (InvocationTargetException invocationTargetException) {
/* 152 */         l(invocationTargetException.getTargetException());
/* 153 */       } catch (Throwable throwable) {
/* 154 */         l(throwable);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void l(Throwable paramThrowable) {
/* 160 */     this.a.c(new a(this.b, paramThrowable));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\e\g.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */