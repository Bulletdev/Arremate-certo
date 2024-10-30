/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.URI;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpEntityEnclosingRequest;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpRequestInterceptor;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.HttpResponseInterceptor;
/*     */ import org.apache.http.client.ClientProtocolException;
/*     */ import org.apache.http.client.HttpClient;
/*     */ import org.apache.http.client.ResponseHandler;
/*     */ import org.apache.http.client.methods.HttpUriRequest;
/*     */ import org.apache.http.client.protocol.RequestAcceptEncoding;
/*     */ import org.apache.http.client.protocol.ResponseContentEncoding;
/*     */ import org.apache.http.client.utils.URIUtils;
/*     */ import org.apache.http.conn.ClientConnectionManager;
/*     */ import org.apache.http.params.HttpParams;
/*     */ import org.apache.http.protocol.BasicHttpContext;
/*     */ import org.apache.http.protocol.HttpContext;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class DecompressingHttpClient
/*     */   implements HttpClient
/*     */ {
/*     */   private final HttpClient backend;
/*     */   private final HttpRequestInterceptor acceptEncodingInterceptor;
/*     */   private final HttpResponseInterceptor contentEncodingInterceptor;
/*     */   
/*     */   public DecompressingHttpClient() {
/*  89 */     this(new DefaultHttpClient());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DecompressingHttpClient(HttpClient paramHttpClient) {
/*  99 */     this(paramHttpClient, (HttpRequestInterceptor)new RequestAcceptEncoding(), (HttpResponseInterceptor)new ResponseContentEncoding());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   DecompressingHttpClient(HttpClient paramHttpClient, HttpRequestInterceptor paramHttpRequestInterceptor, HttpResponseInterceptor paramHttpResponseInterceptor) {
/* 105 */     this.backend = paramHttpClient;
/* 106 */     this.acceptEncodingInterceptor = paramHttpRequestInterceptor;
/* 107 */     this.contentEncodingInterceptor = paramHttpResponseInterceptor;
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpParams getParams() {
/* 112 */     return this.backend.getParams();
/*     */   }
/*     */ 
/*     */   
/*     */   public ClientConnectionManager getConnectionManager() {
/* 117 */     return this.backend.getConnectionManager();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpResponse execute(HttpUriRequest paramHttpUriRequest) throws IOException, ClientProtocolException {
/* 123 */     return execute(getHttpHost(paramHttpUriRequest), (HttpRequest)paramHttpUriRequest, (HttpContext)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpClient getHttpClient() {
/* 132 */     return this.backend;
/*     */   }
/*     */   
/*     */   HttpHost getHttpHost(HttpUriRequest paramHttpUriRequest) {
/* 136 */     URI uRI = paramHttpUriRequest.getURI();
/* 137 */     return URIUtils.extractHost(uRI);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpResponse execute(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext) throws IOException, ClientProtocolException {
/* 143 */     return execute(getHttpHost(paramHttpUriRequest), (HttpRequest)paramHttpUriRequest, paramHttpContext);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest) throws IOException, ClientProtocolException {
/* 149 */     return execute(paramHttpHost, paramHttpRequest, (HttpContext)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws IOException, ClientProtocolException {
/*     */     try {
/*     */       RequestWrapper requestWrapper;
/* 156 */       HttpContext httpContext = (HttpContext)((paramHttpContext != null) ? paramHttpContext : new BasicHttpContext());
/*     */       
/* 158 */       if (paramHttpRequest instanceof HttpEntityEnclosingRequest) {
/* 159 */         requestWrapper = new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest)paramHttpRequest);
/*     */       } else {
/* 161 */         requestWrapper = new RequestWrapper(paramHttpRequest);
/*     */       } 
/* 163 */       this.acceptEncodingInterceptor.process((HttpRequest)requestWrapper, httpContext);
/* 164 */       HttpResponse httpResponse = this.backend.execute(paramHttpHost, (HttpRequest)requestWrapper, httpContext);
/*     */       try {
/* 166 */         this.contentEncodingInterceptor.process(httpResponse, httpContext);
/* 167 */         if (Boolean.TRUE.equals(httpContext.getAttribute("http.client.response.uncompressed"))) {
/* 168 */           httpResponse.removeHeaders("Content-Length");
/* 169 */           httpResponse.removeHeaders("Content-Encoding");
/* 170 */           httpResponse.removeHeaders("Content-MD5");
/*     */         } 
/* 172 */         return httpResponse;
/* 173 */       } catch (HttpException httpException) {
/* 174 */         EntityUtils.consume(httpResponse.getEntity());
/* 175 */         throw httpException;
/* 176 */       } catch (IOException iOException) {
/* 177 */         EntityUtils.consume(httpResponse.getEntity());
/* 178 */         throw iOException;
/* 179 */       } catch (RuntimeException runtimeException) {
/* 180 */         EntityUtils.consume(httpResponse.getEntity());
/* 181 */         throw runtimeException;
/*     */       } 
/* 183 */     } catch (HttpException httpException) {
/* 184 */       throw new ClientProtocolException(httpException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler) throws IOException, ClientProtocolException {
/* 192 */     return execute(getHttpHost(paramHttpUriRequest), (HttpRequest)paramHttpUriRequest, paramResponseHandler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T execute(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext) throws IOException, ClientProtocolException {
/* 199 */     return execute(getHttpHost(paramHttpUriRequest), (HttpRequest)paramHttpUriRequest, paramResponseHandler, paramHttpContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler) throws IOException, ClientProtocolException {
/* 206 */     return execute(paramHttpHost, paramHttpRequest, paramResponseHandler, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext) throws IOException, ClientProtocolException {
/* 213 */     HttpResponse httpResponse = execute(paramHttpHost, paramHttpRequest, paramHttpContext);
/*     */     try {
/* 215 */       return (T)paramResponseHandler.handleResponse(httpResponse);
/*     */     } finally {
/* 217 */       HttpEntity httpEntity = httpResponse.getEntity();
/* 218 */       if (httpEntity != null)
/* 219 */         EntityUtils.consume(httpEntity); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\DecompressingHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */