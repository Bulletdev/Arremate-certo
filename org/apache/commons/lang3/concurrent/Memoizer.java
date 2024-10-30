/*     */ package org.apache.commons.lang3.concurrent;
/*     */ 
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.CancellationException;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.FutureTask;
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
/*     */ public class Memoizer<I, O>
/*     */   implements Computable<I, O>
/*     */ {
/*  56 */   private final ConcurrentMap<I, Future<O>> cache = new ConcurrentHashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Computable<I, O> computable;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean recalculate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Memoizer(Computable<I, O> paramComputable) {
/*  74 */     this(paramComputable, false);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public Memoizer(Computable<I, O> paramComputable, boolean paramBoolean) {
/*  91 */     this.computable = paramComputable;
/*  92 */     this.recalculate = paramBoolean;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public O compute(I paramI) throws InterruptedException {
/*     */     while (true) {
/* 116 */       Future<O> future = this.cache.get(paramI);
/* 117 */       if (future == null) {
/* 118 */         Callable<?> callable = () -> this.computable.compute((I)paramObject);
/* 119 */         FutureTask<O> futureTask = new FutureTask(callable);
/* 120 */         future = this.cache.putIfAbsent(paramI, futureTask);
/* 121 */         if (future == null) {
/* 122 */           future = futureTask;
/* 123 */           futureTask.run();
/*     */         } 
/*     */       } 
/*     */       try {
/* 127 */         return future.get();
/* 128 */       } catch (CancellationException cancellationException) {
/* 129 */         this.cache.remove(paramI, future);
/* 130 */       } catch (ExecutionException executionException) {
/* 131 */         if (this.recalculate) {
/* 132 */           this.cache.remove(paramI, future);
/*     */         }
/*     */         
/* 135 */         throw launderException(executionException.getCause());
/*     */       } 
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
/*     */   private RuntimeException launderException(Throwable paramThrowable) {
/* 151 */     if (paramThrowable instanceof RuntimeException)
/* 152 */       return (RuntimeException)paramThrowable; 
/* 153 */     if (paramThrowable instanceof Error) {
/* 154 */       throw (Error)paramThrowable;
/*     */     }
/* 156 */     throw new IllegalStateException("Unchecked exception", paramThrowable);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\concurrent\Memoizer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */