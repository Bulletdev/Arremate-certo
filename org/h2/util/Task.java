/*     */ package org.h2.util;
/*     */ 
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Task
/*     */   implements Runnable
/*     */ {
/*  16 */   private static AtomicInteger counter = new AtomicInteger();
/*     */ 
/*     */ 
/*     */   
/*     */   public volatile boolean stop;
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object result;
/*     */ 
/*     */ 
/*     */   
/*     */   private volatile boolean finished;
/*     */ 
/*     */   
/*     */   private Thread thread;
/*     */ 
/*     */   
/*     */   private Exception ex;
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void call() throws Exception;
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/*  44 */       call();
/*  45 */     } catch (Exception exception) {
/*  46 */       this.ex = exception;
/*     */     } 
/*  48 */     this.finished = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Task execute() {
/*  57 */     return execute(getClass().getName() + ":" + counter.getAndIncrement());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Task execute(String paramString) {
/*  67 */     this.thread = new Thread(this, paramString);
/*  68 */     this.thread.setDaemon(true);
/*  69 */     this.thread.start();
/*  70 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object get() {
/*  81 */     Exception exception = getException();
/*  82 */     if (exception != null) {
/*  83 */       throw new RuntimeException(exception);
/*     */     }
/*  85 */     return this.result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFinished() {
/*  94 */     return this.finished;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void interruptThread() {
/* 101 */     if (this.thread == null) {
/* 102 */       throw new IllegalStateException("Thread not started");
/*     */     }
/* 104 */     this.thread.interrupt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Exception getException() {
/* 113 */     join();
/* 114 */     if (this.ex != null) {
/* 115 */       return this.ex;
/*     */     }
/* 117 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void join() {
/* 125 */     this.stop = true;
/* 126 */     if (this.thread == null) {
/* 127 */       throw new IllegalStateException("Thread not started");
/*     */     }
/*     */     try {
/* 130 */       this.thread.join();
/* 131 */     } catch (InterruptedException interruptedException) {}
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\Task.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */