/*     */ package org.apache.http.impl.execchain;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InterruptedIOException;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.ConnectionReuseStrategy;
/*     */ import org.apache.http.HttpClientConnection;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpRequestInterceptor;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.ProtocolException;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.client.methods.CloseableHttpResponse;
/*     */ import org.apache.http.client.methods.HttpExecutionAware;
/*     */ import org.apache.http.client.methods.HttpRequestWrapper;
/*     */ import org.apache.http.client.methods.HttpUriRequest;
/*     */ import org.apache.http.client.protocol.HttpClientContext;
/*     */ import org.apache.http.client.protocol.RequestClientConnControl;
/*     */ import org.apache.http.client.utils.URIUtils;
/*     */ import org.apache.http.concurrent.Cancellable;
/*     */ import org.apache.http.conn.ConnectionKeepAliveStrategy;
/*     */ import org.apache.http.conn.ConnectionRequest;
/*     */ import org.apache.http.conn.HttpClientConnectionManager;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.impl.conn.ConnectionShutdownException;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.protocol.HttpProcessor;
/*     */ import org.apache.http.protocol.HttpRequestExecutor;
/*     */ import org.apache.http.protocol.ImmutableHttpProcessor;
/*     */ import org.apache.http.protocol.RequestContent;
/*     */ import org.apache.http.protocol.RequestTargetHost;
/*     */ import org.apache.http.protocol.RequestUserAgent;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.VersionInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class MinimalClientExec
/*     */   implements ClientExecChain
/*     */ {
/*  87 */   private final Log log = LogFactory.getLog(getClass());
/*     */   
/*     */   private final HttpRequestExecutor requestExecutor;
/*     */   
/*     */   private final HttpClientConnectionManager connManager;
/*     */   
/*     */   private final ConnectionReuseStrategy reuseStrategy;
/*     */   
/*     */   private final ConnectionKeepAliveStrategy keepAliveStrategy;
/*     */   
/*     */   private final HttpProcessor httpProcessor;
/*     */   
/*     */   public MinimalClientExec(HttpRequestExecutor paramHttpRequestExecutor, HttpClientConnectionManager paramHttpClientConnectionManager, ConnectionReuseStrategy paramConnectionReuseStrategy, ConnectionKeepAliveStrategy paramConnectionKeepAliveStrategy) {
/* 100 */     Args.notNull(paramHttpRequestExecutor, "HTTP request executor");
/* 101 */     Args.notNull(paramHttpClientConnectionManager, "Client connection manager");
/* 102 */     Args.notNull(paramConnectionReuseStrategy, "Connection reuse strategy");
/* 103 */     Args.notNull(paramConnectionKeepAliveStrategy, "Connection keep alive strategy");
/* 104 */     this.httpProcessor = (HttpProcessor)new ImmutableHttpProcessor(new HttpRequestInterceptor[] { (HttpRequestInterceptor)new RequestContent(), (HttpRequestInterceptor)new RequestTargetHost(), (HttpRequestInterceptor)new RequestClientConnControl(), (HttpRequestInterceptor)new RequestUserAgent(VersionInfo.getUserAgent("Apache-HttpClient", "org.apache.http.client", getClass())) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 110 */     this.requestExecutor = paramHttpRequestExecutor;
/* 111 */     this.connManager = paramHttpClientConnectionManager;
/* 112 */     this.reuseStrategy = paramConnectionReuseStrategy;
/* 113 */     this.keepAliveStrategy = paramConnectionKeepAliveStrategy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void rewriteRequestURI(HttpRequestWrapper paramHttpRequestWrapper, HttpRoute paramHttpRoute, boolean paramBoolean) throws ProtocolException {
/*     */     try {
/* 121 */       URI uRI = paramHttpRequestWrapper.getURI();
/* 122 */       if (uRI != null) {
/*     */         
/* 124 */         if (uRI.isAbsolute()) {
/* 125 */           uRI = URIUtils.rewriteURI(uRI, null, paramBoolean ? URIUtils.DROP_FRAGMENT_AND_NORMALIZE : URIUtils.DROP_FRAGMENT);
/*     */         } else {
/* 127 */           uRI = URIUtils.rewriteURI(uRI);
/*     */         } 
/* 129 */         paramHttpRequestWrapper.setURI(uRI);
/*     */       } 
/* 131 */     } catch (URISyntaxException uRISyntaxException) {
/* 132 */       throw new ProtocolException("Invalid URI: " + paramHttpRequestWrapper.getRequestLine().getUri(), uRISyntaxException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CloseableHttpResponse execute(HttpRoute paramHttpRoute, HttpRequestWrapper paramHttpRequestWrapper, HttpClientContext paramHttpClientContext, HttpExecutionAware paramHttpExecutionAware) throws IOException, HttpException {
/*     */     HttpClientConnection httpClientConnection;
/* 142 */     Args.notNull(paramHttpRoute, "HTTP route");
/* 143 */     Args.notNull(paramHttpRequestWrapper, "HTTP request");
/* 144 */     Args.notNull(paramHttpClientContext, "HTTP context");
/*     */     
/* 146 */     rewriteRequestURI(paramHttpRequestWrapper, paramHttpRoute, paramHttpClientContext.getRequestConfig().isNormalizeUri());
/*     */     
/* 148 */     ConnectionRequest connectionRequest = this.connManager.requestConnection(paramHttpRoute, null);
/* 149 */     if (paramHttpExecutionAware != null) {
/* 150 */       if (paramHttpExecutionAware.isAborted()) {
/* 151 */         connectionRequest.cancel();
/* 152 */         throw new RequestAbortedException("Request aborted");
/*     */       } 
/* 154 */       paramHttpExecutionAware.setCancellable((Cancellable)connectionRequest);
/*     */     } 
/*     */     
/* 157 */     RequestConfig requestConfig = paramHttpClientContext.getRequestConfig();
/*     */ 
/*     */     
/*     */     try {
/* 161 */       int i = requestConfig.getConnectionRequestTimeout();
/* 162 */       httpClientConnection = connectionRequest.get((i > 0) ? i : 0L, TimeUnit.MILLISECONDS);
/* 163 */     } catch (InterruptedException interruptedException) {
/* 164 */       Thread.currentThread().interrupt();
/* 165 */       throw new RequestAbortedException("Request aborted", interruptedException);
/* 166 */     } catch (ExecutionException executionException) {
/* 167 */       Throwable throwable = executionException.getCause();
/* 168 */       if (throwable == null) {
/* 169 */         throwable = executionException;
/*     */       }
/* 171 */       throw new RequestAbortedException("Request execution failed", throwable);
/*     */     } 
/*     */     
/* 174 */     ConnectionHolder connectionHolder = new ConnectionHolder(this.log, this.connManager, httpClientConnection);
/*     */     try {
/* 176 */       if (paramHttpExecutionAware != null) {
/* 177 */         if (paramHttpExecutionAware.isAborted()) {
/* 178 */           connectionHolder.close();
/* 179 */           throw new RequestAbortedException("Request aborted");
/*     */         } 
/* 181 */         paramHttpExecutionAware.setCancellable(connectionHolder);
/*     */       } 
/*     */       
/* 184 */       if (!httpClientConnection.isOpen()) {
/* 185 */         int j = requestConfig.getConnectTimeout();
/* 186 */         this.connManager.connect(httpClientConnection, paramHttpRoute, (j > 0) ? j : 0, (HttpContext)paramHttpClientContext);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 191 */         this.connManager.routeComplete(httpClientConnection, paramHttpRoute, (HttpContext)paramHttpClientContext);
/*     */       } 
/* 193 */       int i = requestConfig.getSocketTimeout();
/* 194 */       if (i >= 0) {
/* 195 */         httpClientConnection.setSocketTimeout(i);
/*     */       }
/*     */       
/* 198 */       HttpHost httpHost = null;
/* 199 */       HttpRequest httpRequest = paramHttpRequestWrapper.getOriginal();
/* 200 */       if (httpRequest instanceof HttpUriRequest) {
/* 201 */         URI uRI = ((HttpUriRequest)httpRequest).getURI();
/* 202 */         if (uRI.isAbsolute()) {
/* 203 */           httpHost = new HttpHost(uRI.getHost(), uRI.getPort(), uRI.getScheme());
/*     */         }
/*     */       } 
/* 206 */       if (httpHost == null) {
/* 207 */         httpHost = paramHttpRoute.getTargetHost();
/*     */       }
/*     */       
/* 210 */       paramHttpClientContext.setAttribute("http.target_host", httpHost);
/* 211 */       paramHttpClientContext.setAttribute("http.request", paramHttpRequestWrapper);
/* 212 */       paramHttpClientContext.setAttribute("http.connection", httpClientConnection);
/* 213 */       paramHttpClientContext.setAttribute("http.route", paramHttpRoute);
/*     */       
/* 215 */       this.httpProcessor.process((HttpRequest)paramHttpRequestWrapper, (HttpContext)paramHttpClientContext);
/* 216 */       HttpResponse httpResponse = this.requestExecutor.execute((HttpRequest)paramHttpRequestWrapper, httpClientConnection, (HttpContext)paramHttpClientContext);
/* 217 */       this.httpProcessor.process(httpResponse, (HttpContext)paramHttpClientContext);
/*     */ 
/*     */       
/* 220 */       if (this.reuseStrategy.keepAlive(httpResponse, (HttpContext)paramHttpClientContext)) {
/*     */         
/* 222 */         long l = this.keepAliveStrategy.getKeepAliveDuration(httpResponse, (HttpContext)paramHttpClientContext);
/* 223 */         connectionHolder.setValidFor(l, TimeUnit.MILLISECONDS);
/* 224 */         connectionHolder.markReusable();
/*     */       } else {
/* 226 */         connectionHolder.markNonReusable();
/*     */       } 
/*     */ 
/*     */       
/* 230 */       HttpEntity httpEntity = httpResponse.getEntity();
/* 231 */       if (httpEntity == null || !httpEntity.isStreaming()) {
/*     */         
/* 233 */         connectionHolder.releaseConnection();
/* 234 */         return new HttpResponseProxy(httpResponse, null);
/*     */       } 
/* 236 */       return new HttpResponseProxy(httpResponse, connectionHolder);
/* 237 */     } catch (ConnectionShutdownException connectionShutdownException) {
/* 238 */       InterruptedIOException interruptedIOException = new InterruptedIOException("Connection has been shut down");
/*     */       
/* 240 */       interruptedIOException.initCause((Throwable)connectionShutdownException);
/* 241 */       throw interruptedIOException;
/* 242 */     } catch (HttpException httpException) {
/* 243 */       connectionHolder.abortConnection();
/* 244 */       throw httpException;
/* 245 */     } catch (IOException iOException) {
/* 246 */       connectionHolder.abortConnection();
/* 247 */       throw iOException;
/* 248 */     } catch (RuntimeException runtimeException) {
/* 249 */       connectionHolder.abortConnection();
/* 250 */       throw runtimeException;
/* 251 */     } catch (Error error) {
/* 252 */       this.connManager.shutdown();
/* 253 */       throw error;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\execchain\MinimalClientExec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */