/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.auth.AuthSchemeProvider;
/*     */ import org.apache.http.auth.AuthState;
/*     */ import org.apache.http.client.ClientProtocolException;
/*     */ import org.apache.http.client.CookieStore;
/*     */ import org.apache.http.client.CredentialsProvider;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.client.methods.CloseableHttpResponse;
/*     */ import org.apache.http.client.methods.Configurable;
/*     */ import org.apache.http.client.methods.HttpExecutionAware;
/*     */ import org.apache.http.client.methods.HttpRequestWrapper;
/*     */ import org.apache.http.client.params.HttpClientParamConfig;
/*     */ import org.apache.http.client.protocol.HttpClientContext;
/*     */ import org.apache.http.config.Lookup;
/*     */ import org.apache.http.conn.ClientConnectionManager;
/*     */ import org.apache.http.conn.ClientConnectionRequest;
/*     */ import org.apache.http.conn.HttpClientConnectionManager;
/*     */ import org.apache.http.conn.ManagedClientConnection;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.conn.routing.HttpRoutePlanner;
/*     */ import org.apache.http.conn.scheme.SchemeRegistry;
/*     */ import org.apache.http.cookie.CookieSpecProvider;
/*     */ import org.apache.http.impl.execchain.ClientExecChain;
/*     */ import org.apache.http.params.HttpParams;
/*     */ import org.apache.http.params.HttpParamsNames;
/*     */ import org.apache.http.protocol.BasicHttpContext;
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
/*     */ @Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/*     */ class InternalHttpClient
/*     */   extends CloseableHttpClient
/*     */   implements Configurable
/*     */ {
/*  80 */   private final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   
/*     */   private final ClientExecChain execChain;
/*     */   
/*     */   private final HttpClientConnectionManager connManager;
/*     */   
/*     */   private final HttpRoutePlanner routePlanner;
/*     */   
/*     */   private final Lookup<CookieSpecProvider> cookieSpecRegistry;
/*     */   
/*     */   private final Lookup<AuthSchemeProvider> authSchemeRegistry;
/*     */   
/*     */   private final CookieStore cookieStore;
/*     */   
/*     */   private final CredentialsProvider credentialsProvider;
/*     */   
/*     */   private final RequestConfig defaultConfig;
/*     */   
/*     */   private final List<Closeable> closeables;
/*     */ 
/*     */   
/*     */   public InternalHttpClient(ClientExecChain paramClientExecChain, HttpClientConnectionManager paramHttpClientConnectionManager, HttpRoutePlanner paramHttpRoutePlanner, Lookup<CookieSpecProvider> paramLookup, Lookup<AuthSchemeProvider> paramLookup1, CookieStore paramCookieStore, CredentialsProvider paramCredentialsProvider, RequestConfig paramRequestConfig, List<Closeable> paramList) {
/* 103 */     Args.notNull(paramClientExecChain, "HTTP client exec chain");
/* 104 */     Args.notNull(paramHttpClientConnectionManager, "HTTP connection manager");
/* 105 */     Args.notNull(paramHttpRoutePlanner, "HTTP route planner");
/* 106 */     this.execChain = paramClientExecChain;
/* 107 */     this.connManager = paramHttpClientConnectionManager;
/* 108 */     this.routePlanner = paramHttpRoutePlanner;
/* 109 */     this.cookieSpecRegistry = paramLookup;
/* 110 */     this.authSchemeRegistry = paramLookup1;
/* 111 */     this.cookieStore = paramCookieStore;
/* 112 */     this.credentialsProvider = paramCredentialsProvider;
/* 113 */     this.defaultConfig = paramRequestConfig;
/* 114 */     this.closeables = paramList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private HttpRoute determineRoute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException {
/* 121 */     HttpHost httpHost = paramHttpHost;
/* 122 */     if (httpHost == null) {
/* 123 */       httpHost = (HttpHost)paramHttpRequest.getParams().getParameter("http.default-host");
/*     */     }
/* 125 */     return this.routePlanner.determineRoute(httpHost, paramHttpRequest, paramHttpContext);
/*     */   }
/*     */   
/*     */   private void setupContext(HttpClientContext paramHttpClientContext) {
/* 129 */     if (paramHttpClientContext.getAttribute("http.auth.target-scope") == null) {
/* 130 */       paramHttpClientContext.setAttribute("http.auth.target-scope", new AuthState());
/*     */     }
/* 132 */     if (paramHttpClientContext.getAttribute("http.auth.proxy-scope") == null) {
/* 133 */       paramHttpClientContext.setAttribute("http.auth.proxy-scope", new AuthState());
/*     */     }
/* 135 */     if (paramHttpClientContext.getAttribute("http.authscheme-registry") == null) {
/* 136 */       paramHttpClientContext.setAttribute("http.authscheme-registry", this.authSchemeRegistry);
/*     */     }
/* 138 */     if (paramHttpClientContext.getAttribute("http.cookiespec-registry") == null) {
/* 139 */       paramHttpClientContext.setAttribute("http.cookiespec-registry", this.cookieSpecRegistry);
/*     */     }
/* 141 */     if (paramHttpClientContext.getAttribute("http.cookie-store") == null) {
/* 142 */       paramHttpClientContext.setAttribute("http.cookie-store", this.cookieStore);
/*     */     }
/* 144 */     if (paramHttpClientContext.getAttribute("http.auth.credentials-provider") == null) {
/* 145 */       paramHttpClientContext.setAttribute("http.auth.credentials-provider", this.credentialsProvider);
/*     */     }
/* 147 */     if (paramHttpClientContext.getAttribute("http.request-config") == null) {
/* 148 */       paramHttpClientContext.setAttribute("http.request-config", this.defaultConfig);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CloseableHttpResponse doExecute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws IOException, ClientProtocolException {
/* 157 */     Args.notNull(paramHttpRequest, "HTTP request");
/* 158 */     HttpExecutionAware httpExecutionAware = null;
/* 159 */     if (paramHttpRequest instanceof HttpExecutionAware) {
/* 160 */       httpExecutionAware = (HttpExecutionAware)paramHttpRequest;
/*     */     }
/*     */     try {
/* 163 */       HttpRequestWrapper httpRequestWrapper = HttpRequestWrapper.wrap(paramHttpRequest, paramHttpHost);
/* 164 */       HttpClientContext httpClientContext = HttpClientContext.adapt((paramHttpContext != null) ? paramHttpContext : (HttpContext)new BasicHttpContext());
/*     */       
/* 166 */       RequestConfig requestConfig = null;
/* 167 */       if (paramHttpRequest instanceof Configurable) {
/* 168 */         requestConfig = ((Configurable)paramHttpRequest).getConfig();
/*     */       }
/* 170 */       if (requestConfig == null) {
/* 171 */         HttpParams httpParams = paramHttpRequest.getParams();
/* 172 */         if (httpParams instanceof HttpParamsNames) {
/* 173 */           if (!((HttpParamsNames)httpParams).getNames().isEmpty()) {
/* 174 */             requestConfig = HttpClientParamConfig.getRequestConfig(httpParams, this.defaultConfig);
/*     */           }
/*     */         } else {
/* 177 */           requestConfig = HttpClientParamConfig.getRequestConfig(httpParams, this.defaultConfig);
/*     */         } 
/*     */       } 
/* 180 */       if (requestConfig != null) {
/* 181 */         httpClientContext.setRequestConfig(requestConfig);
/*     */       }
/* 183 */       setupContext(httpClientContext);
/* 184 */       HttpRoute httpRoute = determineRoute(paramHttpHost, (HttpRequest)httpRequestWrapper, (HttpContext)httpClientContext);
/* 185 */       return this.execChain.execute(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware);
/* 186 */     } catch (HttpException httpException) {
/* 187 */       throw new ClientProtocolException(httpException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public RequestConfig getConfig() {
/* 193 */     return this.defaultConfig;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 198 */     if (this.closeables != null) {
/* 199 */       for (Closeable closeable : this.closeables) {
/*     */         try {
/* 201 */           closeable.close();
/* 202 */         } catch (IOException iOException) {
/* 203 */           this.log.error(iOException.getMessage(), iOException);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpParams getParams() {
/* 211 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ClientConnectionManager getConnectionManager() {
/* 217 */     return new ClientConnectionManager()
/*     */       {
/*     */         public void shutdown()
/*     */         {
/* 221 */           InternalHttpClient.this.connManager.shutdown();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public ClientConnectionRequest requestConnection(HttpRoute param1HttpRoute, Object param1Object) {
/* 227 */           throw new UnsupportedOperationException();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void releaseConnection(ManagedClientConnection param1ManagedClientConnection, long param1Long, TimeUnit param1TimeUnit) {
/* 234 */           throw new UnsupportedOperationException();
/*     */         }
/*     */ 
/*     */         
/*     */         public SchemeRegistry getSchemeRegistry() {
/* 239 */           throw new UnsupportedOperationException();
/*     */         }
/*     */ 
/*     */         
/*     */         public void closeIdleConnections(long param1Long, TimeUnit param1TimeUnit) {
/* 244 */           InternalHttpClient.this.connManager.closeIdleConnections(param1Long, param1TimeUnit);
/*     */         }
/*     */ 
/*     */         
/*     */         public void closeExpiredConnections() {
/* 249 */           InternalHttpClient.this.connManager.closeExpiredConnections();
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\InternalHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */