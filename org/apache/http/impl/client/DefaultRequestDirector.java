/*      */ package org.apache.http.impl.client;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.InterruptedIOException;
/*      */ import java.net.URI;
/*      */ import java.net.URISyntaxException;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import org.apache.commons.logging.Log;
/*      */ import org.apache.commons.logging.LogFactory;
/*      */ import org.apache.http.ConnectionReuseStrategy;
/*      */ import org.apache.http.HttpClientConnection;
/*      */ import org.apache.http.HttpEntity;
/*      */ import org.apache.http.HttpEntityEnclosingRequest;
/*      */ import org.apache.http.HttpException;
/*      */ import org.apache.http.HttpHost;
/*      */ import org.apache.http.HttpRequest;
/*      */ import org.apache.http.HttpResponse;
/*      */ import org.apache.http.NoHttpResponseException;
/*      */ import org.apache.http.ProtocolException;
/*      */ import org.apache.http.ProtocolVersion;
/*      */ import org.apache.http.auth.AuthProtocolState;
/*      */ import org.apache.http.auth.AuthScheme;
/*      */ import org.apache.http.auth.AuthState;
/*      */ import org.apache.http.auth.Credentials;
/*      */ import org.apache.http.auth.UsernamePasswordCredentials;
/*      */ import org.apache.http.client.AuthenticationHandler;
/*      */ import org.apache.http.client.AuthenticationStrategy;
/*      */ import org.apache.http.client.HttpRequestRetryHandler;
/*      */ import org.apache.http.client.NonRepeatableRequestException;
/*      */ import org.apache.http.client.RedirectException;
/*      */ import org.apache.http.client.RedirectHandler;
/*      */ import org.apache.http.client.RedirectStrategy;
/*      */ import org.apache.http.client.RequestDirector;
/*      */ import org.apache.http.client.UserTokenHandler;
/*      */ import org.apache.http.client.methods.AbortableHttpRequest;
/*      */ import org.apache.http.client.methods.HttpUriRequest;
/*      */ import org.apache.http.client.params.HttpClientParams;
/*      */ import org.apache.http.client.utils.URIUtils;
/*      */ import org.apache.http.conn.BasicManagedEntity;
/*      */ import org.apache.http.conn.ClientConnectionManager;
/*      */ import org.apache.http.conn.ClientConnectionRequest;
/*      */ import org.apache.http.conn.ConnectionKeepAliveStrategy;
/*      */ import org.apache.http.conn.ConnectionReleaseTrigger;
/*      */ import org.apache.http.conn.ManagedClientConnection;
/*      */ import org.apache.http.conn.routing.BasicRouteDirector;
/*      */ import org.apache.http.conn.routing.HttpRoute;
/*      */ import org.apache.http.conn.routing.HttpRoutePlanner;
/*      */ import org.apache.http.conn.routing.RouteInfo;
/*      */ import org.apache.http.conn.scheme.Scheme;
/*      */ import org.apache.http.entity.BufferedHttpEntity;
/*      */ import org.apache.http.impl.auth.BasicScheme;
/*      */ import org.apache.http.impl.conn.ConnectionShutdownException;
/*      */ import org.apache.http.message.BasicHttpRequest;
/*      */ import org.apache.http.params.HttpConnectionParams;
/*      */ import org.apache.http.params.HttpParams;
/*      */ import org.apache.http.params.HttpProtocolParams;
/*      */ import org.apache.http.protocol.HttpContext;
/*      */ import org.apache.http.protocol.HttpProcessor;
/*      */ import org.apache.http.protocol.HttpRequestExecutor;
/*      */ import org.apache.http.util.Args;
/*      */ import org.apache.http.util.EntityUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @Deprecated
/*      */ public class DefaultRequestDirector
/*      */   implements RequestDirector
/*      */ {
/*      */   private final Log log;
/*      */   protected final ClientConnectionManager connManager;
/*      */   protected final HttpRoutePlanner routePlanner;
/*      */   protected final ConnectionReuseStrategy reuseStrategy;
/*      */   protected final ConnectionKeepAliveStrategy keepAliveStrategy;
/*      */   protected final HttpRequestExecutor requestExec;
/*      */   protected final HttpProcessor httpProcessor;
/*      */   protected final HttpRequestRetryHandler retryHandler;
/*      */   protected final RedirectHandler redirectHandler;
/*      */   protected final RedirectStrategy redirectStrategy;
/*      */   protected final AuthenticationHandler targetAuthHandler;
/*      */   protected final AuthenticationStrategy targetAuthStrategy;
/*      */   protected final AuthenticationHandler proxyAuthHandler;
/*      */   protected final AuthenticationStrategy proxyAuthStrategy;
/*      */   protected final UserTokenHandler userTokenHandler;
/*      */   protected final HttpParams params;
/*      */   protected ManagedClientConnection managedConn;
/*      */   protected final AuthState targetAuthState;
/*      */   protected final AuthState proxyAuthState;
/*      */   private final HttpAuthenticator authenticator;
/*      */   private int execCount;
/*      */   private int redirectCount;
/*      */   private final int maxRedirects;
/*      */   private HttpHost virtualHost;
/*      */   
/*      */   public DefaultRequestDirector(HttpRequestExecutor paramHttpRequestExecutor, ClientConnectionManager paramClientConnectionManager, ConnectionReuseStrategy paramConnectionReuseStrategy, ConnectionKeepAliveStrategy paramConnectionKeepAliveStrategy, HttpRoutePlanner paramHttpRoutePlanner, HttpProcessor paramHttpProcessor, HttpRequestRetryHandler paramHttpRequestRetryHandler, RedirectHandler paramRedirectHandler, AuthenticationHandler paramAuthenticationHandler1, AuthenticationHandler paramAuthenticationHandler2, UserTokenHandler paramUserTokenHandler, HttpParams paramHttpParams) {
/*  213 */     this(LogFactory.getLog(DefaultRequestDirector.class), paramHttpRequestExecutor, paramClientConnectionManager, paramConnectionReuseStrategy, paramConnectionKeepAliveStrategy, paramHttpRoutePlanner, paramHttpProcessor, paramHttpRequestRetryHandler, new DefaultRedirectStrategyAdaptor(paramRedirectHandler), new AuthenticationStrategyAdaptor(paramAuthenticationHandler1), new AuthenticationStrategyAdaptor(paramAuthenticationHandler2), paramUserTokenHandler, paramHttpParams);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DefaultRequestDirector(Log paramLog, HttpRequestExecutor paramHttpRequestExecutor, ClientConnectionManager paramClientConnectionManager, ConnectionReuseStrategy paramConnectionReuseStrategy, ConnectionKeepAliveStrategy paramConnectionKeepAliveStrategy, HttpRoutePlanner paramHttpRoutePlanner, HttpProcessor paramHttpProcessor, HttpRequestRetryHandler paramHttpRequestRetryHandler, RedirectStrategy paramRedirectStrategy, AuthenticationHandler paramAuthenticationHandler1, AuthenticationHandler paramAuthenticationHandler2, UserTokenHandler paramUserTokenHandler, HttpParams paramHttpParams) {
/*  237 */     this(LogFactory.getLog(DefaultRequestDirector.class), paramHttpRequestExecutor, paramClientConnectionManager, paramConnectionReuseStrategy, paramConnectionKeepAliveStrategy, paramHttpRoutePlanner, paramHttpProcessor, paramHttpRequestRetryHandler, paramRedirectStrategy, new AuthenticationStrategyAdaptor(paramAuthenticationHandler1), new AuthenticationStrategyAdaptor(paramAuthenticationHandler2), paramUserTokenHandler, paramHttpParams);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DefaultRequestDirector(Log paramLog, HttpRequestExecutor paramHttpRequestExecutor, ClientConnectionManager paramClientConnectionManager, ConnectionReuseStrategy paramConnectionReuseStrategy, ConnectionKeepAliveStrategy paramConnectionKeepAliveStrategy, HttpRoutePlanner paramHttpRoutePlanner, HttpProcessor paramHttpProcessor, HttpRequestRetryHandler paramHttpRequestRetryHandler, RedirectStrategy paramRedirectStrategy, AuthenticationStrategy paramAuthenticationStrategy1, AuthenticationStrategy paramAuthenticationStrategy2, UserTokenHandler paramUserTokenHandler, HttpParams paramHttpParams) {
/*  264 */     Args.notNull(paramLog, "Log");
/*  265 */     Args.notNull(paramHttpRequestExecutor, "Request executor");
/*  266 */     Args.notNull(paramClientConnectionManager, "Client connection manager");
/*  267 */     Args.notNull(paramConnectionReuseStrategy, "Connection reuse strategy");
/*  268 */     Args.notNull(paramConnectionKeepAliveStrategy, "Connection keep alive strategy");
/*  269 */     Args.notNull(paramHttpRoutePlanner, "Route planner");
/*  270 */     Args.notNull(paramHttpProcessor, "HTTP protocol processor");
/*  271 */     Args.notNull(paramHttpRequestRetryHandler, "HTTP request retry handler");
/*  272 */     Args.notNull(paramRedirectStrategy, "Redirect strategy");
/*  273 */     Args.notNull(paramAuthenticationStrategy1, "Target authentication strategy");
/*  274 */     Args.notNull(paramAuthenticationStrategy2, "Proxy authentication strategy");
/*  275 */     Args.notNull(paramUserTokenHandler, "User token handler");
/*  276 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*  277 */     this.log = paramLog;
/*  278 */     this.authenticator = new HttpAuthenticator(paramLog);
/*  279 */     this.requestExec = paramHttpRequestExecutor;
/*  280 */     this.connManager = paramClientConnectionManager;
/*  281 */     this.reuseStrategy = paramConnectionReuseStrategy;
/*  282 */     this.keepAliveStrategy = paramConnectionKeepAliveStrategy;
/*  283 */     this.routePlanner = paramHttpRoutePlanner;
/*  284 */     this.httpProcessor = paramHttpProcessor;
/*  285 */     this.retryHandler = paramHttpRequestRetryHandler;
/*  286 */     this.redirectStrategy = paramRedirectStrategy;
/*  287 */     this.targetAuthStrategy = paramAuthenticationStrategy1;
/*  288 */     this.proxyAuthStrategy = paramAuthenticationStrategy2;
/*  289 */     this.userTokenHandler = paramUserTokenHandler;
/*  290 */     this.params = paramHttpParams;
/*      */     
/*  292 */     if (paramRedirectStrategy instanceof DefaultRedirectStrategyAdaptor) {
/*  293 */       this.redirectHandler = ((DefaultRedirectStrategyAdaptor)paramRedirectStrategy).getHandler();
/*      */     } else {
/*  295 */       this.redirectHandler = null;
/*      */     } 
/*  297 */     if (paramAuthenticationStrategy1 instanceof AuthenticationStrategyAdaptor) {
/*  298 */       this.targetAuthHandler = ((AuthenticationStrategyAdaptor)paramAuthenticationStrategy1).getHandler();
/*      */     } else {
/*  300 */       this.targetAuthHandler = null;
/*      */     } 
/*  302 */     if (paramAuthenticationStrategy2 instanceof AuthenticationStrategyAdaptor) {
/*  303 */       this.proxyAuthHandler = ((AuthenticationStrategyAdaptor)paramAuthenticationStrategy2).getHandler();
/*      */     } else {
/*  305 */       this.proxyAuthHandler = null;
/*      */     } 
/*      */     
/*  308 */     this.managedConn = null;
/*      */     
/*  310 */     this.execCount = 0;
/*  311 */     this.redirectCount = 0;
/*  312 */     this.targetAuthState = new AuthState();
/*  313 */     this.proxyAuthState = new AuthState();
/*  314 */     this.maxRedirects = this.params.getIntParameter("http.protocol.max-redirects", 100);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private RequestWrapper wrapRequest(HttpRequest paramHttpRequest) throws ProtocolException {
/*  320 */     if (paramHttpRequest instanceof HttpEntityEnclosingRequest) {
/*  321 */       return new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest)paramHttpRequest);
/*      */     }
/*      */     
/*  324 */     return new RequestWrapper(paramHttpRequest);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void rewriteRequestURI(RequestWrapper paramRequestWrapper, HttpRoute paramHttpRoute) throws ProtocolException {
/*      */     try {
/*  335 */       URI uRI = paramRequestWrapper.getURI();
/*  336 */       if (paramHttpRoute.getProxyHost() != null && !paramHttpRoute.isTunnelled()) {
/*      */         
/*  338 */         if (!uRI.isAbsolute()) {
/*  339 */           HttpHost httpHost = paramHttpRoute.getTargetHost();
/*  340 */           uRI = URIUtils.rewriteURI(uRI, httpHost, URIUtils.DROP_FRAGMENT_AND_NORMALIZE);
/*      */         } else {
/*  342 */           uRI = URIUtils.rewriteURI(uRI);
/*      */         }
/*      */       
/*      */       }
/*  346 */       else if (uRI.isAbsolute()) {
/*  347 */         uRI = URIUtils.rewriteURI(uRI, null, URIUtils.DROP_FRAGMENT_AND_NORMALIZE);
/*      */       } else {
/*  349 */         uRI = URIUtils.rewriteURI(uRI);
/*      */       } 
/*      */       
/*  352 */       paramRequestWrapper.setURI(uRI);
/*      */     }
/*  354 */     catch (URISyntaxException uRISyntaxException) {
/*  355 */       throw new ProtocolException("Invalid URI: " + paramRequestWrapper.getRequestLine().getUri(), uRISyntaxException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException, IOException {
/*  367 */     paramHttpContext.setAttribute("http.auth.target-scope", this.targetAuthState);
/*  368 */     paramHttpContext.setAttribute("http.auth.proxy-scope", this.proxyAuthState);
/*      */     
/*  370 */     HttpHost httpHost = paramHttpHost;
/*      */     
/*  372 */     HttpRequest httpRequest = paramHttpRequest;
/*  373 */     RequestWrapper requestWrapper = wrapRequest(httpRequest);
/*  374 */     requestWrapper.setParams(this.params);
/*  375 */     HttpRoute httpRoute = determineRoute(httpHost, (HttpRequest)requestWrapper, paramHttpContext);
/*      */     
/*  377 */     this.virtualHost = (HttpHost)requestWrapper.getParams().getParameter("http.virtual-host");
/*      */ 
/*      */     
/*  380 */     if (this.virtualHost != null && this.virtualHost.getPort() == -1) {
/*  381 */       HttpHost httpHost1 = (httpHost != null) ? httpHost : httpRoute.getTargetHost();
/*  382 */       int i = httpHost1.getPort();
/*  383 */       if (i != -1) {
/*  384 */         this.virtualHost = new HttpHost(this.virtualHost.getHostName(), i, this.virtualHost.getSchemeName());
/*      */       }
/*      */     } 
/*      */     
/*  388 */     RoutedRequest routedRequest = new RoutedRequest(requestWrapper, httpRoute);
/*      */     
/*  390 */     boolean bool = false;
/*  391 */     boolean bool1 = false;
/*      */     try {
/*  393 */       HttpResponse httpResponse = null;
/*  394 */       while (!bool1) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  400 */         RequestWrapper requestWrapper1 = routedRequest.getRequest();
/*  401 */         HttpRoute httpRoute1 = routedRequest.getRoute();
/*  402 */         httpResponse = null;
/*      */ 
/*      */         
/*  405 */         Object object = paramHttpContext.getAttribute("http.user-token");
/*      */ 
/*      */         
/*  408 */         if (this.managedConn == null) {
/*  409 */           ClientConnectionRequest clientConnectionRequest = this.connManager.requestConnection(httpRoute1, object);
/*      */           
/*  411 */           if (httpRequest instanceof AbortableHttpRequest) {
/*  412 */             ((AbortableHttpRequest)httpRequest).setConnectionRequest(clientConnectionRequest);
/*      */           }
/*      */           
/*  415 */           long l = HttpClientParams.getConnectionManagerTimeout(this.params);
/*      */           try {
/*  417 */             this.managedConn = clientConnectionRequest.getConnection(l, TimeUnit.MILLISECONDS);
/*  418 */           } catch (InterruptedException interruptedException) {
/*  419 */             Thread.currentThread().interrupt();
/*  420 */             throw new InterruptedIOException();
/*      */           } 
/*      */           
/*  423 */           if (HttpConnectionParams.isStaleCheckingEnabled(this.params))
/*      */           {
/*  425 */             if (this.managedConn.isOpen()) {
/*  426 */               this.log.debug("Stale connection check");
/*  427 */               if (this.managedConn.isStale()) {
/*  428 */                 this.log.debug("Stale connection detected");
/*  429 */                 this.managedConn.close();
/*      */               } 
/*      */             } 
/*      */           }
/*      */         } 
/*      */         
/*  435 */         if (httpRequest instanceof AbortableHttpRequest) {
/*  436 */           ((AbortableHttpRequest)httpRequest).setReleaseTrigger((ConnectionReleaseTrigger)this.managedConn);
/*      */         }
/*      */         
/*      */         try {
/*  440 */           tryConnect(routedRequest, paramHttpContext);
/*  441 */         } catch (TunnelRefusedException tunnelRefusedException) {
/*  442 */           if (this.log.isDebugEnabled()) {
/*  443 */             this.log.debug(tunnelRefusedException.getMessage());
/*      */           }
/*  445 */           httpResponse = tunnelRefusedException.getResponse();
/*      */           
/*      */           break;
/*      */         } 
/*  449 */         String str = requestWrapper1.getURI().getUserInfo();
/*  450 */         if (str != null) {
/*  451 */           this.targetAuthState.update((AuthScheme)new BasicScheme(), (Credentials)new UsernamePasswordCredentials(str));
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*  456 */         if (this.virtualHost != null) {
/*  457 */           httpHost = this.virtualHost;
/*      */         } else {
/*  459 */           URI uRI = requestWrapper1.getURI();
/*  460 */           if (uRI.isAbsolute()) {
/*  461 */             httpHost = URIUtils.extractHost(uRI);
/*      */           }
/*      */         } 
/*  464 */         if (httpHost == null) {
/*  465 */           httpHost = httpRoute1.getTargetHost();
/*      */         }
/*      */ 
/*      */         
/*  469 */         requestWrapper1.resetHeaders();
/*      */         
/*  471 */         rewriteRequestURI(requestWrapper1, httpRoute1);
/*      */ 
/*      */         
/*  474 */         paramHttpContext.setAttribute("http.target_host", httpHost);
/*  475 */         paramHttpContext.setAttribute("http.route", httpRoute1);
/*  476 */         paramHttpContext.setAttribute("http.connection", this.managedConn);
/*      */ 
/*      */         
/*  479 */         this.requestExec.preProcess((HttpRequest)requestWrapper1, this.httpProcessor, paramHttpContext);
/*      */         
/*  481 */         httpResponse = tryExecute(routedRequest, paramHttpContext);
/*  482 */         if (httpResponse == null) {
/*      */           continue;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*  488 */         httpResponse.setParams(this.params);
/*  489 */         this.requestExec.postProcess(httpResponse, this.httpProcessor, paramHttpContext);
/*      */ 
/*      */ 
/*      */         
/*  493 */         bool = this.reuseStrategy.keepAlive(httpResponse, paramHttpContext);
/*  494 */         if (bool) {
/*      */           
/*  496 */           long l = this.keepAliveStrategy.getKeepAliveDuration(httpResponse, paramHttpContext);
/*  497 */           if (this.log.isDebugEnabled()) {
/*      */             String str1;
/*  499 */             if (l > 0L) {
/*  500 */               str1 = "for " + l + " " + TimeUnit.MILLISECONDS;
/*      */             } else {
/*  502 */               str1 = "indefinitely";
/*      */             } 
/*  504 */             this.log.debug("Connection can be kept alive " + str1);
/*      */           } 
/*  506 */           this.managedConn.setIdleDuration(l, TimeUnit.MILLISECONDS);
/*      */         } 
/*      */         
/*  509 */         RoutedRequest routedRequest1 = handleResponse(routedRequest, httpResponse, paramHttpContext);
/*  510 */         if (routedRequest1 == null) {
/*  511 */           bool1 = true;
/*      */         } else {
/*  513 */           if (bool) {
/*      */             
/*  515 */             HttpEntity httpEntity = httpResponse.getEntity();
/*  516 */             EntityUtils.consume(httpEntity);
/*      */ 
/*      */             
/*  519 */             this.managedConn.markReusable();
/*      */           } else {
/*  521 */             this.managedConn.close();
/*  522 */             if (this.proxyAuthState.getState().compareTo((Enum)AuthProtocolState.CHALLENGED) > 0 && this.proxyAuthState.getAuthScheme() != null && this.proxyAuthState.getAuthScheme().isConnectionBased()) {
/*      */ 
/*      */               
/*  525 */               this.log.debug("Resetting proxy auth state");
/*  526 */               this.proxyAuthState.reset();
/*      */             } 
/*  528 */             if (this.targetAuthState.getState().compareTo((Enum)AuthProtocolState.CHALLENGED) > 0 && this.targetAuthState.getAuthScheme() != null && this.targetAuthState.getAuthScheme().isConnectionBased()) {
/*      */ 
/*      */               
/*  531 */               this.log.debug("Resetting target auth state");
/*  532 */               this.targetAuthState.reset();
/*      */             } 
/*      */           } 
/*      */           
/*  536 */           if (!routedRequest1.getRoute().equals(routedRequest.getRoute())) {
/*  537 */             releaseConnection();
/*      */           }
/*  539 */           routedRequest = routedRequest1;
/*      */         } 
/*      */         
/*  542 */         if (this.managedConn != null) {
/*  543 */           if (object == null) {
/*  544 */             object = this.userTokenHandler.getUserToken(paramHttpContext);
/*  545 */             paramHttpContext.setAttribute("http.user-token", object);
/*      */           } 
/*  547 */           if (object != null) {
/*  548 */             this.managedConn.setState(object);
/*      */           }
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  556 */       if (httpResponse == null || httpResponse.getEntity() == null || !httpResponse.getEntity().isStreaming()) {
/*      */ 
/*      */         
/*  559 */         if (bool) {
/*  560 */           this.managedConn.markReusable();
/*      */         }
/*  562 */         releaseConnection();
/*      */       } else {
/*      */         
/*  565 */         HttpEntity httpEntity = httpResponse.getEntity();
/*  566 */         BasicManagedEntity basicManagedEntity = new BasicManagedEntity(httpEntity, this.managedConn, bool);
/*  567 */         httpResponse.setEntity((HttpEntity)basicManagedEntity);
/*      */       } 
/*      */       
/*  570 */       return httpResponse;
/*      */     }
/*  572 */     catch (ConnectionShutdownException connectionShutdownException) {
/*  573 */       InterruptedIOException interruptedIOException = new InterruptedIOException("Connection has been shut down");
/*      */       
/*  575 */       interruptedIOException.initCause((Throwable)connectionShutdownException);
/*  576 */       throw interruptedIOException;
/*  577 */     } catch (HttpException httpException) {
/*  578 */       abortConnection();
/*  579 */       throw httpException;
/*  580 */     } catch (IOException iOException) {
/*  581 */       abortConnection();
/*  582 */       throw iOException;
/*  583 */     } catch (RuntimeException runtimeException) {
/*  584 */       abortConnection();
/*  585 */       throw runtimeException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void tryConnect(RoutedRequest paramRoutedRequest, HttpContext paramHttpContext) throws HttpException, IOException {
/*  595 */     HttpRoute httpRoute = paramRoutedRequest.getRoute();
/*  596 */     RequestWrapper requestWrapper = paramRoutedRequest.getRequest();
/*      */     
/*  598 */     byte b = 0;
/*      */     while (true) {
/*  600 */       paramHttpContext.setAttribute("http.request", requestWrapper);
/*      */       
/*  602 */       b++;
/*      */       try {
/*  604 */         if (!this.managedConn.isOpen()) {
/*  605 */           this.managedConn.open(httpRoute, paramHttpContext, this.params);
/*      */         } else {
/*  607 */           this.managedConn.setSocketTimeout(HttpConnectionParams.getSoTimeout(this.params));
/*      */         } 
/*  609 */         establishRoute(httpRoute, paramHttpContext);
/*      */       }
/*  611 */       catch (IOException iOException) {
/*      */         try {
/*  613 */           this.managedConn.close();
/*  614 */         } catch (IOException iOException1) {}
/*      */         
/*  616 */         if (this.retryHandler.retryRequest(iOException, b, paramHttpContext)) {
/*  617 */           if (this.log.isInfoEnabled()) {
/*  618 */             this.log.info("I/O exception (" + iOException.getClass().getName() + ") caught when connecting to " + httpRoute + ": " + iOException.getMessage());
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  623 */             if (this.log.isDebugEnabled()) {
/*  624 */               this.log.debug(iOException.getMessage(), iOException);
/*      */             }
/*  626 */             this.log.info("Retrying connect to " + httpRoute);
/*      */           }  continue;
/*      */         } 
/*  629 */         throw iOException;
/*      */       } 
/*      */       break;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private HttpResponse tryExecute(RoutedRequest paramRoutedRequest, HttpContext paramHttpContext) throws HttpException, IOException {
/*  640 */     RequestWrapper requestWrapper = paramRoutedRequest.getRequest();
/*  641 */     HttpRoute httpRoute = paramRoutedRequest.getRoute();
/*  642 */     HttpResponse httpResponse = null;
/*      */     
/*  644 */     IOException iOException = null;
/*      */     
/*      */     while (true) {
/*  647 */       this.execCount++;
/*      */       
/*  649 */       requestWrapper.incrementExecCount();
/*  650 */       if (!requestWrapper.isRepeatable()) {
/*  651 */         this.log.debug("Cannot retry non-repeatable request");
/*  652 */         if (iOException != null) {
/*  653 */           throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.  The cause lists the reason the original request failed.", iOException);
/*      */         }
/*      */ 
/*      */         
/*  657 */         throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.");
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*      */       try {
/*  663 */         if (!this.managedConn.isOpen())
/*      */         {
/*      */           
/*  666 */           if (!httpRoute.isTunnelled()) {
/*  667 */             this.log.debug("Reopening the direct connection.");
/*  668 */             this.managedConn.open(httpRoute, paramHttpContext, this.params);
/*      */           } else {
/*      */             
/*  671 */             this.log.debug("Proxied connection. Need to start over.");
/*      */             
/*      */             break;
/*      */           } 
/*      */         }
/*  676 */         if (this.log.isDebugEnabled()) {
/*  677 */           this.log.debug("Attempt " + this.execCount + " to execute request");
/*      */         }
/*  679 */         httpResponse = this.requestExec.execute((HttpRequest)requestWrapper, (HttpClientConnection)this.managedConn, paramHttpContext);
/*      */       
/*      */       }
/*  682 */       catch (IOException iOException1) {
/*  683 */         this.log.debug("Closing the connection.");
/*      */         try {
/*  685 */           this.managedConn.close();
/*  686 */         } catch (IOException iOException2) {}
/*      */         
/*  688 */         if (this.retryHandler.retryRequest(iOException1, requestWrapper.getExecCount(), paramHttpContext)) {
/*  689 */           if (this.log.isInfoEnabled()) {
/*  690 */             this.log.info("I/O exception (" + iOException1.getClass().getName() + ") caught when processing request to " + httpRoute + ": " + iOException1.getMessage());
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  696 */           if (this.log.isDebugEnabled()) {
/*  697 */             this.log.debug(iOException1.getMessage(), iOException1);
/*      */           }
/*  699 */           if (this.log.isInfoEnabled()) {
/*  700 */             this.log.info("Retrying request to " + httpRoute);
/*      */           }
/*  702 */           iOException = iOException1; continue;
/*      */         } 
/*  704 */         if (iOException1 instanceof NoHttpResponseException) {
/*  705 */           NoHttpResponseException noHttpResponseException = new NoHttpResponseException(httpRoute.getTargetHost().toHostString() + " failed to respond");
/*      */           
/*  707 */           noHttpResponseException.setStackTrace(iOException1.getStackTrace());
/*  708 */           throw noHttpResponseException;
/*      */         } 
/*  710 */         throw iOException1;
/*      */       } 
/*      */       
/*      */       break;
/*      */     } 
/*  715 */     return httpResponse;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void releaseConnection() {
/*      */     try {
/*  728 */       this.managedConn.releaseConnection();
/*  729 */     } catch (IOException iOException) {
/*  730 */       this.log.debug("IOException releasing connection", iOException);
/*      */     } 
/*  732 */     this.managedConn = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected HttpRoute determineRoute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException {
/*  756 */     return this.routePlanner.determineRoute((paramHttpHost != null) ? paramHttpHost : (HttpHost)paramHttpRequest.getParams().getParameter("http.default-host"), paramHttpRequest, paramHttpContext);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void establishRoute(HttpRoute paramHttpRoute, HttpContext paramHttpContext) throws HttpException, IOException {
/*      */     int i;
/*  775 */     BasicRouteDirector basicRouteDirector = new BasicRouteDirector(); do {
/*      */       boolean bool1; int j;
/*      */       boolean bool2;
/*  778 */       HttpRoute httpRoute = this.managedConn.getRoute();
/*  779 */       i = basicRouteDirector.nextStep((RouteInfo)paramHttpRoute, (RouteInfo)httpRoute);
/*      */       
/*  781 */       switch (i) {
/*      */         
/*      */         case 1:
/*      */         case 2:
/*  785 */           this.managedConn.open(paramHttpRoute, paramHttpContext, this.params);
/*      */           break;
/*      */         
/*      */         case 3:
/*  789 */           bool1 = createTunnelToTarget(paramHttpRoute, paramHttpContext);
/*  790 */           this.log.debug("Tunnel to target created.");
/*  791 */           this.managedConn.tunnelTarget(bool1, this.params);
/*      */           break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 4:
/*  799 */           j = httpRoute.getHopCount() - 1;
/*  800 */           bool2 = createTunnelToProxy(paramHttpRoute, j, paramHttpContext);
/*  801 */           this.log.debug("Tunnel to proxy created.");
/*  802 */           this.managedConn.tunnelProxy(paramHttpRoute.getHopTarget(j), bool2, this.params);
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 5:
/*  808 */           this.managedConn.layerProtocol(paramHttpContext, this.params);
/*      */           break;
/*      */         
/*      */         case -1:
/*  812 */           throw new HttpException("Unable to establish route: planned = " + paramHttpRoute + "; current = " + httpRoute);
/*      */         
/*      */         case 0:
/*      */           break;
/*      */         
/*      */         default:
/*  818 */           throw new IllegalStateException("Unknown step indicator " + i + " from RouteDirector.");
/*      */       } 
/*      */ 
/*      */     
/*  822 */     } while (i > 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean createTunnelToTarget(HttpRoute paramHttpRoute, HttpContext paramHttpContext) throws HttpException, IOException {
/*  850 */     HttpHost httpHost1 = paramHttpRoute.getProxyHost();
/*  851 */     HttpHost httpHost2 = paramHttpRoute.getTargetHost();
/*  852 */     HttpResponse httpResponse = null;
/*      */     
/*      */     while (true) {
/*  855 */       if (!this.managedConn.isOpen()) {
/*  856 */         this.managedConn.open(paramHttpRoute, paramHttpContext, this.params);
/*      */       }
/*      */       
/*  859 */       HttpRequest httpRequest = createConnectRequest(paramHttpRoute, paramHttpContext);
/*  860 */       httpRequest.setParams(this.params);
/*      */ 
/*      */       
/*  863 */       paramHttpContext.setAttribute("http.target_host", httpHost2);
/*  864 */       paramHttpContext.setAttribute("http.route", paramHttpRoute);
/*  865 */       paramHttpContext.setAttribute("http.proxy_host", httpHost1);
/*  866 */       paramHttpContext.setAttribute("http.connection", this.managedConn);
/*  867 */       paramHttpContext.setAttribute("http.request", httpRequest);
/*      */       
/*  869 */       this.requestExec.preProcess(httpRequest, this.httpProcessor, paramHttpContext);
/*      */       
/*  871 */       httpResponse = this.requestExec.execute(httpRequest, (HttpClientConnection)this.managedConn, paramHttpContext);
/*      */       
/*  873 */       httpResponse.setParams(this.params);
/*  874 */       this.requestExec.postProcess(httpResponse, this.httpProcessor, paramHttpContext);
/*      */       
/*  876 */       int j = httpResponse.getStatusLine().getStatusCode();
/*  877 */       if (j < 200) {
/*  878 */         throw new HttpException("Unexpected response to CONNECT request: " + httpResponse.getStatusLine());
/*      */       }
/*      */ 
/*      */       
/*  882 */       if (HttpClientParams.isAuthenticating(this.params)) {
/*  883 */         if (this.authenticator.isAuthenticationRequested(httpHost1, httpResponse, this.proxyAuthStrategy, this.proxyAuthState, paramHttpContext))
/*      */         {
/*  885 */           if (this.authenticator.authenticate(httpHost1, httpResponse, this.proxyAuthStrategy, this.proxyAuthState, paramHttpContext)) {
/*      */ 
/*      */             
/*  888 */             if (this.reuseStrategy.keepAlive(httpResponse, paramHttpContext)) {
/*  889 */               this.log.debug("Connection kept alive");
/*      */               
/*  891 */               HttpEntity httpEntity = httpResponse.getEntity();
/*  892 */               EntityUtils.consume(httpEntity); continue;
/*      */             } 
/*  894 */             this.managedConn.close();
/*      */ 
/*      */             
/*      */             continue;
/*      */           } 
/*      */         }
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/*      */     
/*  905 */     int i = httpResponse.getStatusLine().getStatusCode();
/*      */     
/*  907 */     if (i > 299) {
/*      */ 
/*      */       
/*  910 */       HttpEntity httpEntity = httpResponse.getEntity();
/*  911 */       if (httpEntity != null) {
/*  912 */         httpResponse.setEntity((HttpEntity)new BufferedHttpEntity(httpEntity));
/*      */       }
/*      */       
/*  915 */       this.managedConn.close();
/*  916 */       throw new TunnelRefusedException("CONNECT refused by proxy: " + httpResponse.getStatusLine(), httpResponse);
/*      */     } 
/*      */ 
/*      */     
/*  920 */     this.managedConn.markReusable();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  926 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean createTunnelToProxy(HttpRoute paramHttpRoute, int paramInt, HttpContext paramHttpContext) throws HttpException, IOException {
/*  962 */     throw new HttpException("Proxy chains are not supported.");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected HttpRequest createConnectRequest(HttpRoute paramHttpRoute, HttpContext paramHttpContext) {
/*  982 */     HttpHost httpHost = paramHttpRoute.getTargetHost();
/*      */     
/*  984 */     String str1 = httpHost.getHostName();
/*  985 */     int i = httpHost.getPort();
/*  986 */     if (i < 0) {
/*  987 */       Scheme scheme = this.connManager.getSchemeRegistry().getScheme(httpHost.getSchemeName());
/*      */       
/*  989 */       i = scheme.getDefaultPort();
/*      */     } 
/*      */     
/*  992 */     StringBuilder stringBuilder = new StringBuilder(str1.length() + 6);
/*  993 */     stringBuilder.append(str1);
/*  994 */     stringBuilder.append(':');
/*  995 */     stringBuilder.append(Integer.toString(i));
/*      */     
/*  997 */     String str2 = stringBuilder.toString();
/*  998 */     ProtocolVersion protocolVersion = HttpProtocolParams.getVersion(this.params);
/*  999 */     return (HttpRequest)new BasicHttpRequest("CONNECT", str2, protocolVersion);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected RoutedRequest handleResponse(RoutedRequest paramRoutedRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws HttpException, IOException {
/* 1024 */     HttpRoute httpRoute = paramRoutedRequest.getRoute();
/* 1025 */     RequestWrapper requestWrapper = paramRoutedRequest.getRequest();
/*      */     
/* 1027 */     HttpParams httpParams = requestWrapper.getParams();
/*      */     
/* 1029 */     if (HttpClientParams.isAuthenticating(httpParams)) {
/* 1030 */       HttpHost httpHost1 = (HttpHost)paramHttpContext.getAttribute("http.target_host");
/* 1031 */       if (httpHost1 == null) {
/* 1032 */         httpHost1 = httpRoute.getTargetHost();
/*      */       }
/* 1034 */       if (httpHost1.getPort() < 0) {
/* 1035 */         Scheme scheme = this.connManager.getSchemeRegistry().getScheme(httpHost1);
/* 1036 */         httpHost1 = new HttpHost(httpHost1.getHostName(), scheme.getDefaultPort(), httpHost1.getSchemeName());
/*      */       } 
/*      */       
/* 1039 */       boolean bool1 = this.authenticator.isAuthenticationRequested(httpHost1, paramHttpResponse, this.targetAuthStrategy, this.targetAuthState, paramHttpContext);
/*      */ 
/*      */       
/* 1042 */       HttpHost httpHost2 = httpRoute.getProxyHost();
/*      */       
/* 1044 */       if (httpHost2 == null) {
/* 1045 */         httpHost2 = httpRoute.getTargetHost();
/*      */       }
/* 1047 */       boolean bool2 = this.authenticator.isAuthenticationRequested(httpHost2, paramHttpResponse, this.proxyAuthStrategy, this.proxyAuthState, paramHttpContext);
/*      */ 
/*      */       
/* 1050 */       if (bool1 && 
/* 1051 */         this.authenticator.authenticate(httpHost1, paramHttpResponse, this.targetAuthStrategy, this.targetAuthState, paramHttpContext))
/*      */       {
/*      */         
/* 1054 */         return paramRoutedRequest;
/*      */       }
/*      */       
/* 1057 */       if (bool2 && 
/* 1058 */         this.authenticator.authenticate(httpHost2, paramHttpResponse, this.proxyAuthStrategy, this.proxyAuthState, paramHttpContext))
/*      */       {
/*      */         
/* 1061 */         return paramRoutedRequest;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1066 */     if (HttpClientParams.isRedirecting(httpParams) && this.redirectStrategy.isRedirected((HttpRequest)requestWrapper, paramHttpResponse, paramHttpContext)) {
/*      */ 
/*      */       
/* 1069 */       if (this.redirectCount >= this.maxRedirects) {
/* 1070 */         throw new RedirectException("Maximum redirects (" + this.maxRedirects + ") exceeded");
/*      */       }
/*      */       
/* 1073 */       this.redirectCount++;
/*      */ 
/*      */       
/* 1076 */       this.virtualHost = null;
/*      */       
/* 1078 */       HttpUriRequest httpUriRequest = this.redirectStrategy.getRedirect((HttpRequest)requestWrapper, paramHttpResponse, paramHttpContext);
/* 1079 */       HttpRequest httpRequest = requestWrapper.getOriginal();
/* 1080 */       httpUriRequest.setHeaders(httpRequest.getAllHeaders());
/*      */       
/* 1082 */       URI uRI = httpUriRequest.getURI();
/* 1083 */       HttpHost httpHost = URIUtils.extractHost(uRI);
/* 1084 */       if (httpHost == null) {
/* 1085 */         throw new ProtocolException("Redirect URI does not specify a valid host name: " + uRI);
/*      */       }
/*      */ 
/*      */       
/* 1089 */       if (!httpRoute.getTargetHost().equals(httpHost)) {
/* 1090 */         this.log.debug("Resetting target auth state");
/* 1091 */         this.targetAuthState.reset();
/* 1092 */         AuthScheme authScheme = this.proxyAuthState.getAuthScheme();
/* 1093 */         if (authScheme != null && authScheme.isConnectionBased()) {
/* 1094 */           this.log.debug("Resetting proxy auth state");
/* 1095 */           this.proxyAuthState.reset();
/*      */         } 
/*      */       } 
/*      */       
/* 1099 */       RequestWrapper requestWrapper1 = wrapRequest((HttpRequest)httpUriRequest);
/* 1100 */       requestWrapper1.setParams(httpParams);
/*      */       
/* 1102 */       HttpRoute httpRoute1 = determineRoute(httpHost, (HttpRequest)requestWrapper1, paramHttpContext);
/* 1103 */       RoutedRequest routedRequest = new RoutedRequest(requestWrapper1, httpRoute1);
/*      */       
/* 1105 */       if (this.log.isDebugEnabled()) {
/* 1106 */         this.log.debug("Redirecting to '" + uRI + "' via " + httpRoute1);
/*      */       }
/*      */       
/* 1109 */       return routedRequest;
/*      */     } 
/*      */     
/* 1112 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void abortConnection() {
/* 1122 */     ManagedClientConnection managedClientConnection = this.managedConn;
/* 1123 */     if (managedClientConnection != null) {
/*      */ 
/*      */       
/* 1126 */       this.managedConn = null;
/*      */       try {
/* 1128 */         managedClientConnection.abortConnection();
/* 1129 */       } catch (IOException iOException) {
/* 1130 */         if (this.log.isDebugEnabled()) {
/* 1131 */           this.log.debug(iOException.getMessage(), iOException);
/*      */         }
/*      */       } 
/*      */       
/*      */       try {
/* 1136 */         managedClientConnection.releaseConnection();
/* 1137 */       } catch (IOException iOException) {
/* 1138 */         this.log.debug("Error releasing connection", iOException);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\DefaultRequestDirector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */