/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.O;
/*     */ import com.google.a.d.bh;
/*     */ import com.google.b.a.a;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.TimeoutException;
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
/*     */ @a
/*     */ @c
/*     */ abstract class ax
/*     */   implements ExecutorService
/*     */ {
/*     */   private final ExecutorService j;
/*     */   
/*     */   protected ax(ExecutorService paramExecutorService) {
/*  49 */     this.j = (ExecutorService)D.checkNotNull(paramExecutorService);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract <T> Callable<T> a(Callable<T> paramCallable);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Runnable a(Runnable paramRunnable) {
/*  63 */     Callable<?> callable = a(Executors.callable(paramRunnable, null));
/*  64 */     return new Runnable(this, callable)
/*     */       {
/*     */         public void run() {
/*     */           try {
/*  68 */             this.e.call();
/*  69 */           } catch (Exception exception) {
/*  70 */             O.a(exception);
/*  71 */             throw new RuntimeException(exception);
/*     */           } 
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private <T> bh<Callable<T>> b(Collection<? extends Callable<T>> paramCollection) {
/*  83 */     bh.a a = bh.a();
/*  84 */     for (Callable<?> callable : paramCollection) {
/*  85 */       a.a(a(callable));
/*     */     }
/*  87 */     return a.g();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void execute(Runnable paramRunnable) {
/*  93 */     this.j.execute(a(paramRunnable));
/*     */   }
/*     */ 
/*     */   
/*     */   public final <T> Future<T> submit(Callable<T> paramCallable) {
/*  98 */     return this.j.submit(a((Callable<T>)D.checkNotNull(paramCallable)));
/*     */   }
/*     */ 
/*     */   
/*     */   public final Future<?> submit(Runnable paramRunnable) {
/* 103 */     return this.j.submit(a(paramRunnable));
/*     */   }
/*     */ 
/*     */   
/*     */   public final <T> Future<T> submit(Runnable paramRunnable, T paramT) {
/* 108 */     return this.j.submit(a(paramRunnable), paramT);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection) throws InterruptedException {
/* 114 */     return this.j.invokeAll((Collection<? extends Callable<T>>)b(paramCollection));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
/* 121 */     return this.j.invokeAll((Collection<? extends Callable<T>>)b(paramCollection), paramLong, paramTimeUnit);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final <T> T invokeAny(Collection<? extends Callable<T>> paramCollection) throws InterruptedException, ExecutionException {
/* 127 */     return this.j.invokeAny((Collection<? extends Callable<T>>)b(paramCollection));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final <T> T invokeAny(Collection<? extends Callable<T>> paramCollection, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
/* 133 */     return this.j.invokeAny((Collection<? extends Callable<T>>)b(paramCollection), paramLong, paramTimeUnit);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void shutdown() {
/* 140 */     this.j.shutdown();
/*     */   }
/*     */ 
/*     */   
/*     */   public final List<Runnable> shutdownNow() {
/* 145 */     return this.j.shutdownNow();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isShutdown() {
/* 150 */     return this.j.isShutdown();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isTerminated() {
/* 155 */     return this.j.isTerminated();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
/* 160 */     return this.j.awaitTermination(paramLong, paramTimeUnit);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\ax.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */