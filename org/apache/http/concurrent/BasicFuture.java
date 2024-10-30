/*     */ package org.apache.http.concurrent;
/*     */ 
/*     */ import java.util.concurrent.CancellationException;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.TimeoutException;
/*     */ import org.apache.http.util.Args;
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
/*     */ public class BasicFuture<T>
/*     */   implements Future<T>, Cancellable
/*     */ {
/*     */   private final FutureCallback<T> callback;
/*     */   private volatile boolean completed;
/*     */   private volatile boolean cancelled;
/*     */   private volatile T result;
/*     */   private volatile Exception ex;
/*     */   
/*     */   public BasicFuture(FutureCallback<T> paramFutureCallback) {
/*  56 */     this.callback = paramFutureCallback;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCancelled() {
/*  61 */     return this.cancelled;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDone() {
/*  66 */     return this.completed;
/*     */   }
/*     */   
/*     */   private T getResult() throws ExecutionException {
/*  70 */     if (this.ex != null) {
/*  71 */       throw new ExecutionException(this.ex);
/*     */     }
/*  73 */     if (this.cancelled) {
/*  74 */       throw new CancellationException();
/*     */     }
/*  76 */     return this.result;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized T get() throws InterruptedException, ExecutionException {
/*  81 */     while (!this.completed) {
/*  82 */       wait();
/*     */     }
/*  84 */     return getResult();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized T get(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
/*  90 */     Args.notNull(paramTimeUnit, "Time unit");
/*  91 */     long l1 = paramTimeUnit.toMillis(paramLong);
/*  92 */     long l2 = (l1 <= 0L) ? 0L : System.currentTimeMillis();
/*  93 */     long l3 = l1;
/*  94 */     if (this.completed)
/*  95 */       return getResult(); 
/*  96 */     if (l3 <= 0L) {
/*  97 */       throw new TimeoutException();
/*     */     }
/*     */     while (true) {
/* 100 */       wait(l3);
/* 101 */       if (this.completed) {
/* 102 */         return getResult();
/*     */       }
/* 104 */       l3 = l1 - System.currentTimeMillis() - l2;
/* 105 */       if (l3 <= 0L) {
/* 106 */         throw new TimeoutException();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean completed(T paramT) {
/* 113 */     synchronized (this) {
/* 114 */       if (this.completed) {
/* 115 */         return false;
/*     */       }
/* 117 */       this.completed = true;
/* 118 */       this.result = paramT;
/* 119 */       notifyAll();
/*     */     } 
/* 121 */     if (this.callback != null) {
/* 122 */       this.callback.completed(paramT);
/*     */     }
/* 124 */     return true;
/*     */   }
/*     */   
/*     */   public boolean failed(Exception paramException) {
/* 128 */     synchronized (this) {
/* 129 */       if (this.completed) {
/* 130 */         return false;
/*     */       }
/* 132 */       this.completed = true;
/* 133 */       this.ex = paramException;
/* 134 */       notifyAll();
/*     */     } 
/* 136 */     if (this.callback != null) {
/* 137 */       this.callback.failed(paramException);
/*     */     }
/* 139 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean cancel(boolean paramBoolean) {
/* 144 */     synchronized (this) {
/* 145 */       if (this.completed) {
/* 146 */         return false;
/*     */       }
/* 148 */       this.completed = true;
/* 149 */       this.cancelled = true;
/* 150 */       notifyAll();
/*     */     } 
/* 152 */     if (this.callback != null) {
/* 153 */       this.callback.cancelled();
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean cancel() {
/* 160 */     return cancel(true);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\concurrent\BasicFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */