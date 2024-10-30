/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.net.URI;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.client.ClientProtocolException;
/*     */ import org.apache.http.client.HttpClient;
/*     */ import org.apache.http.client.ResponseHandler;
/*     */ import org.apache.http.client.methods.CloseableHttpResponse;
/*     */ import org.apache.http.client.methods.HttpUriRequest;
/*     */ import org.apache.http.client.utils.URIUtils;
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
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public abstract class CloseableHttpClient
/*     */   implements Closeable, HttpClient
/*     */ {
/*  59 */   private final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CloseableHttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws IOException, ClientProtocolException {
/*  72 */     return doExecute(paramHttpHost, paramHttpRequest, paramHttpContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CloseableHttpResponse execute(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext) throws IOException, ClientProtocolException {
/*  82 */     Args.notNull(paramHttpUriRequest, "HTTP request");
/*  83 */     return doExecute(determineTarget(paramHttpUriRequest), (HttpRequest)paramHttpUriRequest, paramHttpContext);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static HttpHost determineTarget(HttpUriRequest paramHttpUriRequest) throws ClientProtocolException {
/*  89 */     HttpHost httpHost = null;
/*     */     
/*  91 */     URI uRI = paramHttpUriRequest.getURI();
/*  92 */     if (uRI.isAbsolute()) {
/*  93 */       httpHost = URIUtils.extractHost(uRI);
/*  94 */       if (httpHost == null) {
/*  95 */         throw new ClientProtocolException("URI does not specify a valid host name: " + uRI);
/*     */       }
/*     */     } 
/*     */     
/*  99 */     return httpHost;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CloseableHttpResponse execute(HttpUriRequest paramHttpUriRequest) throws IOException, ClientProtocolException {
/* 108 */     return execute(paramHttpUriRequest, (HttpContext)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CloseableHttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest) throws IOException, ClientProtocolException {
/* 118 */     return doExecute(paramHttpHost, paramHttpRequest, null);
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
/*     */   public <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler) throws IOException, ClientProtocolException {
/* 140 */     return execute(paramHttpUriRequest, paramResponseHandler, (HttpContext)null);
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
/*     */   public <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext) throws IOException, ClientProtocolException {
/* 164 */     HttpHost httpHost = determineTarget(paramHttpUriRequest);
/* 165 */     return execute(httpHost, (HttpRequest)paramHttpUriRequest, paramResponseHandler, paramHttpContext);
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
/*     */ 
/*     */   
/*     */   public <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler) throws IOException, ClientProtocolException {
/* 191 */     return execute(paramHttpHost, paramHttpRequest, paramResponseHandler, null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext) throws IOException, ClientProtocolException {
/* 219 */     Args.notNull(paramResponseHandler, "Response handler");
/*     */     
/* 221 */     CloseableHttpResponse closeableHttpResponse = execute(paramHttpHost, paramHttpRequest, paramHttpContext);
/*     */     try {
/* 223 */       Object object = paramResponseHandler.handleResponse((HttpResponse)closeableHttpResponse);
/* 224 */       HttpEntity httpEntity = closeableHttpResponse.getEntity();
/* 225 */       EntityUtils.consume(httpEntity);
/* 226 */       return (T)object;
/* 227 */     } catch (ClientProtocolException clientProtocolException) {
/*     */       
/* 229 */       HttpEntity httpEntity = closeableHttpResponse.getEntity();
/*     */       try {
/* 231 */         EntityUtils.consume(httpEntity);
/* 232 */       } catch (Exception exception) {
/*     */ 
/*     */         
/* 235 */         this.log.warn("Error consuming content after an exception.", exception);
/*     */       } 
/* 237 */       throw clientProtocolException;
/*     */     } finally {
/* 239 */       closeableHttpResponse.close();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected abstract CloseableHttpResponse doExecute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws IOException, ClientProtocolException;
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\CloseableHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */