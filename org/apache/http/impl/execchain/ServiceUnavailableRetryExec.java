/*     */ package org.apache.http.impl.execchain;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InterruptedIOException;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.client.ServiceUnavailableRetryStrategy;
/*     */ import org.apache.http.client.methods.CloseableHttpResponse;
/*     */ import org.apache.http.client.methods.HttpExecutionAware;
/*     */ import org.apache.http.client.methods.HttpRequestWrapper;
/*     */ import org.apache.http.client.protocol.HttpClientContext;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.protocol.HttpContext;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*     */ public class ServiceUnavailableRetryExec
/*     */   implements ClientExecChain
/*     */ {
/*  62 */   private final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   
/*     */   private final ClientExecChain requestExecutor;
/*     */   
/*     */   private final ServiceUnavailableRetryStrategy retryStrategy;
/*     */ 
/*     */   
/*     */   public ServiceUnavailableRetryExec(ClientExecChain paramClientExecChain, ServiceUnavailableRetryStrategy paramServiceUnavailableRetryStrategy) {
/*  71 */     Args.notNull(paramClientExecChain, "HTTP request executor");
/*  72 */     Args.notNull(paramServiceUnavailableRetryStrategy, "Retry strategy");
/*  73 */     this.requestExecutor = paramClientExecChain;
/*  74 */     this.retryStrategy = paramServiceUnavailableRetryStrategy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CloseableHttpResponse execute(HttpRoute paramHttpRoute, HttpRequestWrapper paramHttpRequestWrapper, HttpClientContext paramHttpClientContext, HttpExecutionAware paramHttpExecutionAware) throws IOException, HttpException {
/*  83 */     Header[] arrayOfHeader = paramHttpRequestWrapper.getAllHeaders();
/*  84 */     for (byte b = 1;; b++) {
/*  85 */       CloseableHttpResponse closeableHttpResponse = this.requestExecutor.execute(paramHttpRoute, paramHttpRequestWrapper, paramHttpClientContext, paramHttpExecutionAware);
/*     */       
/*     */       try {
/*  88 */         if (this.retryStrategy.retryRequest((HttpResponse)closeableHttpResponse, b, (HttpContext)paramHttpClientContext) && RequestEntityProxy.isRepeatable((HttpRequest)paramHttpRequestWrapper)) {
/*     */           
/*  90 */           closeableHttpResponse.close();
/*  91 */           long l = this.retryStrategy.getRetryInterval();
/*  92 */           if (l > 0L) {
/*     */             try {
/*  94 */               this.log.trace("Wait for " + l);
/*  95 */               Thread.sleep(l);
/*  96 */             } catch (InterruptedException interruptedException) {
/*  97 */               Thread.currentThread().interrupt();
/*  98 */               throw new InterruptedIOException();
/*     */             } 
/*     */           }
/* 101 */           paramHttpRequestWrapper.setHeaders(arrayOfHeader);
/*     */         } else {
/* 103 */           return closeableHttpResponse;
/*     */         } 
/* 105 */       } catch (RuntimeException runtimeException) {
/* 106 */         closeableHttpResponse.close();
/* 107 */         throw runtimeException;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\execchain\ServiceUnavailableRetryExec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */