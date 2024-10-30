/*     */ package org.apache.http.client.fluent;
/*     */ 
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.concurrent.Future;
/*     */ import org.apache.http.client.ResponseHandler;
/*     */ import org.apache.http.concurrent.BasicFuture;
/*     */ import org.apache.http.concurrent.FutureCallback;
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
/*     */ public class Async
/*     */ {
/*     */   private Executor executor;
/*     */   private Executor concurrentExec;
/*     */   
/*     */   public static Async newInstance() {
/*  41 */     return new Async();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Async use(Executor paramExecutor) {
/*  49 */     this.executor = paramExecutor;
/*  50 */     return this;
/*     */   }
/*     */   
/*     */   public Async use(Executor paramExecutor) {
/*  54 */     this.concurrentExec = paramExecutor;
/*  55 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   static class ExecRunnable<T>
/*     */     implements Runnable
/*     */   {
/*     */     private final BasicFuture<T> future;
/*     */     
/*     */     private final Request request;
/*     */     
/*     */     private final Executor executor;
/*     */     
/*     */     private final ResponseHandler<T> handler;
/*     */     
/*     */     ExecRunnable(BasicFuture<T> param1BasicFuture, Request param1Request, Executor param1Executor, ResponseHandler<T> param1ResponseHandler) {
/*  71 */       this.future = param1BasicFuture;
/*  72 */       this.request = param1Request;
/*  73 */       this.executor = param1Executor;
/*  74 */       this.handler = param1ResponseHandler;
/*     */     }
/*     */ 
/*     */     
/*     */     public void run() {
/*     */       try {
/*  80 */         Response response = this.executor.execute(this.request);
/*  81 */         Object object = response.handleResponse((ResponseHandler)this.handler);
/*  82 */         this.future.completed(object);
/*  83 */       } catch (Exception exception) {
/*  84 */         this.future.failed(exception);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> Future<T> execute(Request paramRequest, ResponseHandler<T> paramResponseHandler, FutureCallback<T> paramFutureCallback) {
/*  92 */     BasicFuture<T> basicFuture = new BasicFuture(paramFutureCallback);
/*  93 */     ExecRunnable<T> execRunnable = new ExecRunnable<T>(basicFuture, paramRequest, (this.executor != null) ? this.executor : Executor.newInstance(), paramResponseHandler);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  98 */     if (this.concurrentExec != null) {
/*  99 */       this.concurrentExec.execute(execRunnable);
/*     */     } else {
/* 101 */       Thread thread = new Thread(execRunnable);
/* 102 */       thread.setDaemon(true);
/* 103 */       thread.start();
/*     */     } 
/* 105 */     return (Future<T>)basicFuture;
/*     */   }
/*     */   
/*     */   public <T> Future<T> execute(Request paramRequest, ResponseHandler<T> paramResponseHandler) {
/* 109 */     return execute(paramRequest, paramResponseHandler, null);
/*     */   }
/*     */   
/*     */   public Future<Content> execute(Request paramRequest, FutureCallback<Content> paramFutureCallback) {
/* 113 */     return execute(paramRequest, (ResponseHandler<Content>)new ContentResponseHandler(), paramFutureCallback);
/*     */   }
/*     */   
/*     */   public Future<Content> execute(Request paramRequest) {
/* 117 */     return execute(paramRequest, (ResponseHandler<Content>)new ContentResponseHandler(), null);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\fluent\Async.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */