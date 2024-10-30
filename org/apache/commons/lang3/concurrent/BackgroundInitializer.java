/*     */ package org.apache.commons.lang3.concurrent;
/*     */ 
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
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
/*     */ public abstract class BackgroundInitializer<T>
/*     */   implements ConcurrentInitializer<T>
/*     */ {
/*     */   private ExecutorService externalExecutor;
/*     */   private ExecutorService executor;
/*     */   private Future<T> future;
/*     */   
/*     */   protected BackgroundInitializer() {
/* 101 */     this(null);
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
/*     */   protected BackgroundInitializer(ExecutorService paramExecutorService) {
/* 115 */     setExternalExecutor(paramExecutorService);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final synchronized ExecutorService getExternalExecutor() {
/* 124 */     return this.externalExecutor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized boolean isStarted() {
/* 135 */     return (this.future != null);
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
/*     */   public final synchronized void setExternalExecutor(ExecutorService paramExecutorService) {
/* 154 */     if (isStarted()) {
/* 155 */       throw new IllegalStateException("Cannot set ExecutorService after start()!");
/*     */     }
/*     */ 
/*     */     
/* 159 */     this.externalExecutor = paramExecutorService;
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
/*     */   public synchronized boolean start() {
/* 174 */     if (!isStarted()) {
/*     */       ExecutorService executorService;
/*     */ 
/*     */ 
/*     */       
/* 179 */       this.executor = getExternalExecutor();
/* 180 */       if (this.executor == null) {
/* 181 */         this.executor = executorService = createExecutor();
/*     */       } else {
/* 183 */         executorService = null;
/*     */       } 
/*     */       
/* 186 */       this.future = this.executor.submit(createTask(executorService));
/*     */       
/* 188 */       return true;
/*     */     } 
/*     */     
/* 191 */     return false;
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
/*     */   public T get() throws ConcurrentException {
/*     */     try {
/* 211 */       return getFuture().get();
/* 212 */     } catch (ExecutionException executionException) {
/* 213 */       ConcurrentUtils.handleCause(executionException);
/* 214 */       return null;
/* 215 */     } catch (InterruptedException interruptedException) {
/*     */       
/* 217 */       Thread.currentThread().interrupt();
/* 218 */       throw new ConcurrentException(interruptedException);
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
/*     */   public synchronized Future<T> getFuture() {
/* 231 */     if (this.future == null) {
/* 232 */       throw new IllegalStateException("start() must be called first!");
/*     */     }
/*     */     
/* 235 */     return this.future;
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
/*     */   protected final synchronized ExecutorService getActiveExecutor() {
/* 248 */     return this.executor;
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
/*     */   protected int getTaskCount() {
/* 263 */     return 1;
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
/*     */   protected abstract T initialize() throws Exception;
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
/*     */   private Callable<T> createTask(ExecutorService paramExecutorService) {
/* 290 */     return new InitializationTask(paramExecutorService);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ExecutorService createExecutor() {
/* 300 */     return Executors.newFixedThreadPool(getTaskCount());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class InitializationTask
/*     */     implements Callable<T>
/*     */   {
/*     */     private final ExecutorService execFinally;
/*     */ 
/*     */ 
/*     */     
/*     */     InitializationTask(ExecutorService param1ExecutorService) {
/* 314 */       this.execFinally = param1ExecutorService;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public T call() throws Exception {
/*     */       try {
/* 326 */         return (T)BackgroundInitializer.this.initialize();
/*     */       } finally {
/* 328 */         if (this.execFinally != null)
/* 329 */           this.execFinally.shutdown(); 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\concurrent\BackgroundInitializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */