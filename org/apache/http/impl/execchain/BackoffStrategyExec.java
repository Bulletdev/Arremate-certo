/*     */ package org.apache.http.impl.execchain;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.UndeclaredThrowableException;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.client.BackoffManager;
/*     */ import org.apache.http.client.ConnectionBackoffStrategy;
/*     */ import org.apache.http.client.methods.CloseableHttpResponse;
/*     */ import org.apache.http.client.methods.HttpExecutionAware;
/*     */ import org.apache.http.client.methods.HttpRequestWrapper;
/*     */ import org.apache.http.client.protocol.HttpClientContext;
/*     */ import org.apache.http.conn.routing.HttpRoute;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*     */ public class BackoffStrategyExec
/*     */   implements ClientExecChain
/*     */ {
/*     */   private final ClientExecChain requestExecutor;
/*     */   private final ConnectionBackoffStrategy connectionBackoffStrategy;
/*     */   private final BackoffManager backoffManager;
/*     */   
/*     */   public BackoffStrategyExec(ClientExecChain paramClientExecChain, ConnectionBackoffStrategy paramConnectionBackoffStrategy, BackoffManager paramBackoffManager) {
/*  60 */     Args.notNull(paramClientExecChain, "HTTP client request executor");
/*  61 */     Args.notNull(paramConnectionBackoffStrategy, "Connection backoff strategy");
/*  62 */     Args.notNull(paramBackoffManager, "Backoff manager");
/*  63 */     this.requestExecutor = paramClientExecChain;
/*  64 */     this.connectionBackoffStrategy = paramConnectionBackoffStrategy;
/*  65 */     this.backoffManager = paramBackoffManager;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CloseableHttpResponse execute(HttpRoute paramHttpRoute, HttpRequestWrapper paramHttpRequestWrapper, HttpClientContext paramHttpClientContext, HttpExecutionAware paramHttpExecutionAware) throws IOException, HttpException {
/*  74 */     Args.notNull(paramHttpRoute, "HTTP route");
/*  75 */     Args.notNull(paramHttpRequestWrapper, "HTTP request");
/*  76 */     Args.notNull(paramHttpClientContext, "HTTP context");
/*  77 */     CloseableHttpResponse closeableHttpResponse = null;
/*     */     try {
/*  79 */       closeableHttpResponse = this.requestExecutor.execute(paramHttpRoute, paramHttpRequestWrapper, paramHttpClientContext, paramHttpExecutionAware);
/*  80 */     } catch (Exception exception) {
/*  81 */       if (closeableHttpResponse != null) {
/*  82 */         closeableHttpResponse.close();
/*     */       }
/*  84 */       if (this.connectionBackoffStrategy.shouldBackoff(exception)) {
/*  85 */         this.backoffManager.backOff(paramHttpRoute);
/*     */       }
/*  87 */       if (exception instanceof RuntimeException) {
/*  88 */         throw (RuntimeException)exception;
/*     */       }
/*  90 */       if (exception instanceof HttpException) {
/*  91 */         throw (HttpException)exception;
/*     */       }
/*  93 */       if (exception instanceof IOException) {
/*  94 */         throw (IOException)exception;
/*     */       }
/*  96 */       throw new UndeclaredThrowableException(exception);
/*     */     } 
/*  98 */     if (this.connectionBackoffStrategy.shouldBackoff((HttpResponse)closeableHttpResponse)) {
/*  99 */       this.backoffManager.backOff(paramHttpRoute);
/*     */     } else {
/* 101 */       this.backoffManager.probe(paramHttpRoute);
/*     */     } 
/* 103 */     return closeableHttpResponse;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\execchain\BackoffStrategyExec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */