/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import org.apache.http.client.HttpClient;
/*     */ import org.apache.http.client.ResponseHandler;
/*     */ import org.apache.http.client.methods.HttpUriRequest;
/*     */ import org.apache.http.concurrent.FutureCallback;
/*     */ import org.apache.http.protocol.HttpContext;
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
/*     */ class HttpRequestTaskCallable<V>
/*     */   implements Callable<V>
/*     */ {
/*     */   private final HttpUriRequest request;
/*     */   private final HttpClient httpclient;
/*  42 */   private final AtomicBoolean cancelled = new AtomicBoolean(false);
/*     */   
/*  44 */   private final long scheduled = System.currentTimeMillis();
/*  45 */   private long started = -1L;
/*  46 */   private long ended = -1L;
/*     */ 
/*     */   
/*     */   private final HttpContext context;
/*     */ 
/*     */   
/*     */   private final ResponseHandler<V> responseHandler;
/*     */ 
/*     */   
/*     */   private final FutureCallback<V> callback;
/*     */   
/*     */   private final FutureRequestExecutionMetrics metrics;
/*     */ 
/*     */   
/*     */   HttpRequestTaskCallable(HttpClient paramHttpClient, HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext, ResponseHandler<V> paramResponseHandler, FutureCallback<V> paramFutureCallback, FutureRequestExecutionMetrics paramFutureRequestExecutionMetrics) {
/*  61 */     this.httpclient = paramHttpClient;
/*  62 */     this.responseHandler = paramResponseHandler;
/*  63 */     this.request = paramHttpUriRequest;
/*  64 */     this.context = paramHttpContext;
/*  65 */     this.callback = paramFutureCallback;
/*  66 */     this.metrics = paramFutureRequestExecutionMetrics;
/*     */   }
/*     */   
/*     */   public long getScheduled() {
/*  70 */     return this.scheduled;
/*     */   }
/*     */   
/*     */   public long getStarted() {
/*  74 */     return this.started;
/*     */   }
/*     */   
/*     */   public long getEnded() {
/*  78 */     return this.ended;
/*     */   }
/*     */ 
/*     */   
/*     */   public V call() throws Exception {
/*  83 */     if (!this.cancelled.get()) {
/*     */       
/*     */       try {
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
/*     */       } finally {
/*     */         
/* 105 */         this.metrics.getRequests().increment(this.started);
/* 106 */         this.metrics.getTasks().increment(this.started);
/* 107 */         this.metrics.getActiveConnections().decrementAndGet();
/*     */       } 
/*     */     }
/* 110 */     throw new IllegalStateException("call has been cancelled for request " + this.request.getURI());
/*     */   }
/*     */   
/*     */   public void cancel() {
/* 114 */     this.cancelled.set(true);
/* 115 */     if (this.callback != null)
/* 116 */       this.callback.cancelled(); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\HttpRequestTaskCallable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */