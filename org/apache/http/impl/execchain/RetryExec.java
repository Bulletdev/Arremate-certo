/*     */ package org.apache.http.impl.execchain;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.NoHttpResponseException;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.client.HttpRequestRetryHandler;
/*     */ import org.apache.http.client.NonRepeatableRequestException;
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
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*     */ public class RetryExec
/*     */   implements ClientExecChain
/*     */ {
/*  63 */   private final Log log = LogFactory.getLog(getClass());
/*     */   
/*     */   private final ClientExecChain requestExecutor;
/*     */   
/*     */   private final HttpRequestRetryHandler retryHandler;
/*     */ 
/*     */   
/*     */   public RetryExec(ClientExecChain paramClientExecChain, HttpRequestRetryHandler paramHttpRequestRetryHandler) {
/*  71 */     Args.notNull(paramClientExecChain, "HTTP request executor");
/*  72 */     Args.notNull(paramHttpRequestRetryHandler, "HTTP request retry handler");
/*  73 */     this.requestExecutor = paramClientExecChain;
/*  74 */     this.retryHandler = paramHttpRequestRetryHandler;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CloseableHttpResponse execute(HttpRoute paramHttpRoute, HttpRequestWrapper paramHttpRequestWrapper, HttpClientContext paramHttpClientContext, HttpExecutionAware paramHttpExecutionAware) throws IOException, HttpException {
/*  83 */     Args.notNull(paramHttpRoute, "HTTP route");
/*  84 */     Args.notNull(paramHttpRequestWrapper, "HTTP request");
/*  85 */     Args.notNull(paramHttpClientContext, "HTTP context");
/*  86 */     Header[] arrayOfHeader = paramHttpRequestWrapper.getAllHeaders();
/*  87 */     for (byte b = 1;; b++) {
/*     */       try {
/*  89 */         return this.requestExecutor.execute(paramHttpRoute, paramHttpRequestWrapper, paramHttpClientContext, paramHttpExecutionAware);
/*  90 */       } catch (IOException iOException) {
/*  91 */         if (paramHttpExecutionAware != null && paramHttpExecutionAware.isAborted()) {
/*  92 */           this.log.debug("Request has been aborted");
/*  93 */           throw iOException;
/*     */         } 
/*  95 */         if (this.retryHandler.retryRequest(iOException, b, (HttpContext)paramHttpClientContext)) {
/*  96 */           if (this.log.isInfoEnabled()) {
/*  97 */             this.log.info("I/O exception (" + iOException.getClass().getName() + ") caught when processing request to " + paramHttpRoute + ": " + iOException.getMessage());
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 103 */           if (this.log.isDebugEnabled()) {
/* 104 */             this.log.debug(iOException.getMessage(), iOException);
/*     */           }
/* 106 */           if (!RequestEntityProxy.isRepeatable((HttpRequest)paramHttpRequestWrapper)) {
/* 107 */             this.log.debug("Cannot retry non-repeatable request");
/* 108 */             throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity", iOException);
/*     */           } 
/*     */           
/* 111 */           paramHttpRequestWrapper.setHeaders(arrayOfHeader);
/* 112 */           if (this.log.isInfoEnabled()) {
/* 113 */             this.log.info("Retrying request to " + paramHttpRoute);
/*     */           }
/*     */         } else {
/* 116 */           if (iOException instanceof NoHttpResponseException) {
/* 117 */             NoHttpResponseException noHttpResponseException = new NoHttpResponseException(paramHttpRoute.getTargetHost().toHostString() + " failed to respond");
/*     */             
/* 119 */             noHttpResponseException.setStackTrace(iOException.getStackTrace());
/* 120 */             throw noHttpResponseException;
/*     */           } 
/* 122 */           throw iOException;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\execchain\RetryExec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */