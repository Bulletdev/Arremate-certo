/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InterruptedIOException;
/*     */ import java.net.URI;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.client.HttpClient;
/*     */ import org.apache.http.client.ResponseHandler;
/*     */ import org.apache.http.client.ServiceUnavailableRetryStrategy;
/*     */ import org.apache.http.client.methods.HttpUriRequest;
/*     */ import org.apache.http.conn.ClientConnectionManager;
/*     */ import org.apache.http.params.HttpParams;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.EntityUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/*     */ public class AutoRetryHttpClient
/*     */   implements HttpClient
/*     */ {
/*     */   private final HttpClient backend;
/*     */   private final ServiceUnavailableRetryStrategy retryStrategy;
/*  67 */   private final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */ 
/*     */   
/*     */   public AutoRetryHttpClient(HttpClient paramHttpClient, ServiceUnavailableRetryStrategy paramServiceUnavailableRetryStrategy) {
/*  72 */     Args.notNull(paramHttpClient, "HttpClient");
/*  73 */     Args.notNull(paramServiceUnavailableRetryStrategy, "ServiceUnavailableRetryStrategy");
/*  74 */     this.backend = paramHttpClient;
/*  75 */     this.retryStrategy = paramServiceUnavailableRetryStrategy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AutoRetryHttpClient() {
/*  84 */     this(new DefaultHttpClient(), new DefaultServiceUnavailableRetryStrategy());
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
/*     */   public AutoRetryHttpClient(ServiceUnavailableRetryStrategy paramServiceUnavailableRetryStrategy) {
/*  96 */     this(new DefaultHttpClient(), paramServiceUnavailableRetryStrategy);
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
/*     */   public AutoRetryHttpClient(HttpClient paramHttpClient) {
/* 108 */     this(paramHttpClient, new DefaultServiceUnavailableRetryStrategy());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest) throws IOException {
/* 114 */     HttpContext httpContext = null;
/* 115 */     return execute(paramHttpHost, paramHttpRequest, httpContext);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler) throws IOException {
/* 121 */     return execute(paramHttpHost, paramHttpRequest, paramResponseHandler, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext) throws IOException {
/* 128 */     HttpResponse httpResponse = execute(paramHttpHost, paramHttpRequest, paramHttpContext);
/* 129 */     return (T)paramResponseHandler.handleResponse(httpResponse);
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpResponse execute(HttpUriRequest paramHttpUriRequest) throws IOException {
/* 134 */     HttpContext httpContext = null;
/* 135 */     return execute(paramHttpUriRequest, httpContext);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpResponse execute(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext) throws IOException {
/* 141 */     URI uRI = paramHttpUriRequest.getURI();
/* 142 */     HttpHost httpHost = new HttpHost(uRI.getHost(), uRI.getPort(), uRI.getScheme());
/*     */     
/* 144 */     return execute(httpHost, (HttpRequest)paramHttpUriRequest, paramHttpContext);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler) throws IOException {
/* 150 */     return execute(paramHttpUriRequest, paramResponseHandler, (HttpContext)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext) throws IOException {
/* 157 */     HttpResponse httpResponse = execute(paramHttpUriRequest, paramHttpContext);
/* 158 */     return (T)paramResponseHandler.handleResponse(httpResponse);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws IOException {
/* 164 */     for (byte b = 1;; b++) {
/* 165 */       HttpResponse httpResponse = this.backend.execute(paramHttpHost, paramHttpRequest, paramHttpContext);
/*     */       try {
/* 167 */         if (this.retryStrategy.retryRequest(httpResponse, b, paramHttpContext)) {
/* 168 */           EntityUtils.consume(httpResponse.getEntity());
/* 169 */           long l = this.retryStrategy.getRetryInterval();
/*     */           try {
/* 171 */             this.log.trace("Wait for " + l);
/* 172 */             Thread.sleep(l);
/* 173 */           } catch (InterruptedException interruptedException) {
/* 174 */             Thread.currentThread().interrupt();
/* 175 */             throw new InterruptedIOException();
/*     */           } 
/*     */         } else {
/* 178 */           return httpResponse;
/*     */         } 
/* 180 */       } catch (RuntimeException runtimeException) {
/*     */         try {
/* 182 */           EntityUtils.consume(httpResponse.getEntity());
/* 183 */         } catch (IOException iOException) {
/* 184 */           this.log.warn("I/O error consuming response content", iOException);
/*     */         } 
/* 186 */         throw runtimeException;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ClientConnectionManager getConnectionManager() {
/* 193 */     return this.backend.getConnectionManager();
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpParams getParams() {
/* 198 */     return this.backend.getParams();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\AutoRetryHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */