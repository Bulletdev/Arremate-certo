/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public class FutureRequestExecutionService
/*     */   implements Closeable
/*     */ {
/*     */   private final HttpClient httpclient;
/*     */   private final ExecutorService executorService;
/*  51 */   private final FutureRequestExecutionMetrics metrics = new FutureRequestExecutionMetrics();
/*  52 */   private final AtomicBoolean closed = new AtomicBoolean(false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FutureRequestExecutionService(HttpClient paramHttpClient, ExecutorService paramExecutorService) {
/*  70 */     this.httpclient = paramHttpClient;
/*  71 */     this.executorService = paramExecutorService;
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
/*     */   public <T> HttpRequestFutureTask<T> execute(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext, ResponseHandler<T> paramResponseHandler) {
/*  89 */     return execute(paramHttpUriRequest, paramHttpContext, paramResponseHandler, null);
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
/*     */   
/*     */   public <T> HttpRequestFutureTask<T> execute(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext, ResponseHandler<T> paramResponseHandler, FutureCallback<T> paramFutureCallback) {
/* 113 */     if (this.closed.get()) {
/* 114 */       throw new IllegalStateException("Close has been called on this httpclient instance.");
/*     */     }
/* 116 */     this.metrics.getScheduledConnections().incrementAndGet();
/* 117 */     HttpRequestTaskCallable<T> httpRequestTaskCallable = new HttpRequestTaskCallable<T>(this.httpclient, paramHttpUriRequest, paramHttpContext, paramResponseHandler, paramFutureCallback, this.metrics);
/*     */     
/* 119 */     HttpRequestFutureTask<T> httpRequestFutureTask = new HttpRequestFutureTask<T>(paramHttpUriRequest, httpRequestTaskCallable);
/*     */     
/* 121 */     this.executorService.execute(httpRequestFutureTask);
/*     */     
/* 123 */     return httpRequestFutureTask;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FutureRequestExecutionMetrics metrics() {
/* 131 */     return this.metrics;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 136 */     this.closed.set(true);
/* 137 */     this.executorService.shutdownNow();
/* 138 */     if (this.httpclient instanceof Closeable)
/* 139 */       ((Closeable)this.httpclient).close(); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\FutureRequestExecutionService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */