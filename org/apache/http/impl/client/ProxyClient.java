/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.Socket;
/*     */ import org.apache.http.ConnectionReuseStrategy;
/*     */ import org.apache.http.HttpClientConnection;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpRequestInterceptor;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.HttpVersion;
/*     */ import org.apache.http.ProtocolVersion;
/*     */ import org.apache.http.auth.AuthSchemeFactory;
/*     */ import org.apache.http.auth.AuthSchemeRegistry;
/*     */ import org.apache.http.auth.AuthScope;
/*     */ import org.apache.http.auth.AuthState;
/*     */ import org.apache.http.auth.Credentials;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.client.params.HttpClientParamConfig;
/*     */ import org.apache.http.client.protocol.RequestClientConnControl;
/*     */ import org.apache.http.config.ConnectionConfig;
/*     */ import org.apache.http.conn.HttpConnectionFactory;
/*     */ import org.apache.http.conn.ManagedHttpClientConnection;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.conn.routing.RouteInfo;
/*     */ import org.apache.http.entity.BufferedHttpEntity;
/*     */ import org.apache.http.impl.DefaultConnectionReuseStrategy;
/*     */ import org.apache.http.impl.auth.BasicSchemeFactory;
/*     */ import org.apache.http.impl.auth.DigestSchemeFactory;
/*     */ import org.apache.http.impl.auth.HttpAuthenticator;
/*     */ import org.apache.http.impl.auth.KerberosSchemeFactory;
/*     */ import org.apache.http.impl.auth.NTLMSchemeFactory;
/*     */ import org.apache.http.impl.auth.SPNegoSchemeFactory;
/*     */ import org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
/*     */ import org.apache.http.impl.execchain.TunnelRefusedException;
/*     */ import org.apache.http.message.BasicHttpRequest;
/*     */ import org.apache.http.params.BasicHttpParams;
/*     */ import org.apache.http.params.HttpParamConfig;
/*     */ import org.apache.http.params.HttpParams;
/*     */ import org.apache.http.protocol.BasicHttpContext;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.protocol.HttpProcessor;
/*     */ import org.apache.http.protocol.HttpRequestExecutor;
/*     */ import org.apache.http.protocol.ImmutableHttpProcessor;
/*     */ import org.apache.http.protocol.RequestTargetHost;
/*     */ import org.apache.http.protocol.RequestUserAgent;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ProxyClient
/*     */ {
/*     */   private final HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory;
/*     */   private final ConnectionConfig connectionConfig;
/*     */   private final RequestConfig requestConfig;
/*     */   private final HttpProcessor httpProcessor;
/*     */   private final HttpRequestExecutor requestExec;
/*     */   private final ProxyAuthenticationStrategy proxyAuthStrategy;
/*     */   private final HttpAuthenticator authenticator;
/*     */   private final AuthState proxyAuthState;
/*     */   private final AuthSchemeRegistry authSchemeRegistry;
/*     */   private final ConnectionReuseStrategy reuseStrategy;
/*     */   
/*     */   public ProxyClient(HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> paramHttpConnectionFactory, ConnectionConfig paramConnectionConfig, RequestConfig paramRequestConfig) {
/* 106 */     this.connFactory = (paramHttpConnectionFactory != null) ? paramHttpConnectionFactory : (HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection>)ManagedHttpClientConnectionFactory.INSTANCE;
/* 107 */     this.connectionConfig = (paramConnectionConfig != null) ? paramConnectionConfig : ConnectionConfig.DEFAULT;
/* 108 */     this.requestConfig = (paramRequestConfig != null) ? paramRequestConfig : RequestConfig.DEFAULT;
/* 109 */     this.httpProcessor = (HttpProcessor)new ImmutableHttpProcessor(new HttpRequestInterceptor[] { (HttpRequestInterceptor)new RequestTargetHost(), (HttpRequestInterceptor)new RequestClientConnControl(), (HttpRequestInterceptor)new RequestUserAgent() });
/*     */     
/* 111 */     this.requestExec = new HttpRequestExecutor();
/* 112 */     this.proxyAuthStrategy = new ProxyAuthenticationStrategy();
/* 113 */     this.authenticator = new HttpAuthenticator();
/* 114 */     this.proxyAuthState = new AuthState();
/* 115 */     this.authSchemeRegistry = new AuthSchemeRegistry();
/* 116 */     this.authSchemeRegistry.register("Basic", (AuthSchemeFactory)new BasicSchemeFactory());
/* 117 */     this.authSchemeRegistry.register("Digest", (AuthSchemeFactory)new DigestSchemeFactory());
/* 118 */     this.authSchemeRegistry.register("NTLM", (AuthSchemeFactory)new NTLMSchemeFactory());
/* 119 */     this.authSchemeRegistry.register("Negotiate", (AuthSchemeFactory)new SPNegoSchemeFactory());
/* 120 */     this.authSchemeRegistry.register("Kerberos", (AuthSchemeFactory)new KerberosSchemeFactory());
/* 121 */     this.reuseStrategy = (ConnectionReuseStrategy)new DefaultConnectionReuseStrategy();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public ProxyClient(HttpParams paramHttpParams) {
/* 129 */     this(null, HttpParamConfig.getConnectionConfig(paramHttpParams), HttpClientParamConfig.getRequestConfig(paramHttpParams));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ProxyClient(RequestConfig paramRequestConfig) {
/* 138 */     this(null, null, paramRequestConfig);
/*     */   }
/*     */   
/*     */   public ProxyClient() {
/* 142 */     this(null, null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public HttpParams getParams() {
/* 150 */     return (HttpParams)new BasicHttpParams();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public AuthSchemeRegistry getAuthSchemeRegistry() {
/* 158 */     return this.authSchemeRegistry;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Socket tunnel(HttpHost paramHttpHost1, HttpHost paramHttpHost2, Credentials paramCredentials) throws IOException, HttpException {
/*     */     HttpResponse httpResponse;
/* 165 */     Args.notNull(paramHttpHost1, "Proxy host");
/* 166 */     Args.notNull(paramHttpHost2, "Target host");
/* 167 */     Args.notNull(paramCredentials, "Credentials");
/* 168 */     HttpHost httpHost = paramHttpHost2;
/* 169 */     if (httpHost.getPort() <= 0) {
/* 170 */       httpHost = new HttpHost(httpHost.getHostName(), 80, httpHost.getSchemeName());
/*     */     }
/* 172 */     HttpRoute httpRoute = new HttpRoute(httpHost, this.requestConfig.getLocalAddress(), paramHttpHost1, false, RouteInfo.TunnelType.TUNNELLED, RouteInfo.LayerType.PLAIN);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 177 */     ManagedHttpClientConnection managedHttpClientConnection = (ManagedHttpClientConnection)this.connFactory.create(httpRoute, this.connectionConfig);
/*     */     
/* 179 */     BasicHttpContext basicHttpContext = new BasicHttpContext();
/*     */ 
/*     */     
/* 182 */     BasicHttpRequest basicHttpRequest = new BasicHttpRequest("CONNECT", httpHost.toHostString(), (ProtocolVersion)HttpVersion.HTTP_1_1);
/*     */ 
/*     */     
/* 185 */     BasicCredentialsProvider basicCredentialsProvider = new BasicCredentialsProvider();
/* 186 */     basicCredentialsProvider.setCredentials(new AuthScope(paramHttpHost1), paramCredentials);
/*     */ 
/*     */     
/* 189 */     basicHttpContext.setAttribute("http.target_host", paramHttpHost2);
/* 190 */     basicHttpContext.setAttribute("http.connection", managedHttpClientConnection);
/* 191 */     basicHttpContext.setAttribute("http.request", basicHttpRequest);
/* 192 */     basicHttpContext.setAttribute("http.route", httpRoute);
/* 193 */     basicHttpContext.setAttribute("http.auth.proxy-scope", this.proxyAuthState);
/* 194 */     basicHttpContext.setAttribute("http.auth.credentials-provider", basicCredentialsProvider);
/* 195 */     basicHttpContext.setAttribute("http.authscheme-registry", this.authSchemeRegistry);
/* 196 */     basicHttpContext.setAttribute("http.request-config", this.requestConfig);
/*     */     
/* 198 */     this.requestExec.preProcess((HttpRequest)basicHttpRequest, this.httpProcessor, (HttpContext)basicHttpContext);
/*     */     
/*     */     while (true) {
/* 201 */       if (!managedHttpClientConnection.isOpen()) {
/* 202 */         Socket socket = new Socket(paramHttpHost1.getHostName(), paramHttpHost1.getPort());
/* 203 */         managedHttpClientConnection.bind(socket);
/*     */       } 
/*     */       
/* 206 */       this.authenticator.generateAuthResponse((HttpRequest)basicHttpRequest, this.proxyAuthState, (HttpContext)basicHttpContext);
/*     */       
/* 208 */       httpResponse = this.requestExec.execute((HttpRequest)basicHttpRequest, (HttpClientConnection)managedHttpClientConnection, (HttpContext)basicHttpContext);
/*     */       
/* 210 */       int j = httpResponse.getStatusLine().getStatusCode();
/* 211 */       if (j < 200) {
/* 212 */         throw new HttpException("Unexpected response to CONNECT request: " + httpResponse.getStatusLine());
/*     */       }
/*     */       
/* 215 */       if (this.authenticator.isAuthenticationRequested(paramHttpHost1, httpResponse, this.proxyAuthStrategy, this.proxyAuthState, (HttpContext)basicHttpContext))
/*     */       {
/* 217 */         if (this.authenticator.handleAuthChallenge(paramHttpHost1, httpResponse, this.proxyAuthStrategy, this.proxyAuthState, (HttpContext)basicHttpContext)) {
/*     */ 
/*     */           
/* 220 */           if (this.reuseStrategy.keepAlive(httpResponse, (HttpContext)basicHttpContext)) {
/*     */             
/* 222 */             HttpEntity httpEntity = httpResponse.getEntity();
/* 223 */             EntityUtils.consume(httpEntity);
/*     */           } else {
/* 225 */             managedHttpClientConnection.close();
/*     */           } 
/*     */           
/* 228 */           basicHttpRequest.removeHeaders("Proxy-Authorization");
/*     */           
/*     */           continue;
/*     */         } 
/*     */       }
/*     */       
/*     */       break;
/*     */     } 
/*     */     
/* 237 */     int i = httpResponse.getStatusLine().getStatusCode();
/*     */     
/* 239 */     if (i > 299) {
/*     */ 
/*     */       
/* 242 */       HttpEntity httpEntity = httpResponse.getEntity();
/* 243 */       if (httpEntity != null) {
/* 244 */         httpResponse.setEntity((HttpEntity)new BufferedHttpEntity(httpEntity));
/*     */       }
/*     */       
/* 247 */       managedHttpClientConnection.close();
/* 248 */       throw new TunnelRefusedException("CONNECT refused by proxy: " + httpResponse.getStatusLine(), httpResponse);
/*     */     } 
/*     */     
/* 251 */     return managedHttpClientConnection.getSocket();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\ProxyClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */