/*     */ package org.apache.http.impl.execchain;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InterruptedIOException;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.ConnectionReuseStrategy;
/*     */ import org.apache.http.HttpClientConnection;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpEntityEnclosingRequest;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpRequestInterceptor;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.auth.AuthProtocolState;
/*     */ import org.apache.http.auth.AuthState;
/*     */ import org.apache.http.client.AuthenticationStrategy;
/*     */ import org.apache.http.client.NonRepeatableRequestException;
/*     */ import org.apache.http.client.UserTokenHandler;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.client.methods.CloseableHttpResponse;
/*     */ import org.apache.http.client.methods.HttpExecutionAware;
/*     */ import org.apache.http.client.methods.HttpRequestWrapper;
/*     */ import org.apache.http.client.protocol.HttpClientContext;
/*     */ import org.apache.http.concurrent.Cancellable;
/*     */ import org.apache.http.conn.ConnectionKeepAliveStrategy;
/*     */ import org.apache.http.conn.ConnectionRequest;
/*     */ import org.apache.http.conn.HttpClientConnectionManager;
/*     */ import org.apache.http.conn.routing.BasicRouteDirector;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.conn.routing.HttpRouteDirector;
/*     */ import org.apache.http.conn.routing.RouteInfo;
/*     */ import org.apache.http.conn.routing.RouteTracker;
/*     */ import org.apache.http.entity.BufferedHttpEntity;
/*     */ import org.apache.http.impl.auth.HttpAuthenticator;
/*     */ import org.apache.http.impl.conn.ConnectionShutdownException;
/*     */ import org.apache.http.message.BasicHttpRequest;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.protocol.HttpProcessor;
/*     */ import org.apache.http.protocol.HttpRequestExecutor;
/*     */ import org.apache.http.protocol.ImmutableHttpProcessor;
/*     */ import org.apache.http.protocol.RequestTargetHost;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*     */ public class MainClientExec
/*     */   implements ClientExecChain
/*     */ {
/*  91 */   private final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   
/*     */   private final HttpRequestExecutor requestExecutor;
/*     */   
/*     */   private final HttpClientConnectionManager connManager;
/*     */   
/*     */   private final ConnectionReuseStrategy reuseStrategy;
/*     */   
/*     */   private final ConnectionKeepAliveStrategy keepAliveStrategy;
/*     */   
/*     */   private final HttpProcessor proxyHttpProcessor;
/*     */   
/*     */   private final AuthenticationStrategy targetAuthStrategy;
/*     */   
/*     */   private final AuthenticationStrategy proxyAuthStrategy;
/*     */   
/*     */   private final HttpAuthenticator authenticator;
/*     */   
/*     */   private final UserTokenHandler userTokenHandler;
/*     */   
/*     */   private final HttpRouteDirector routeDirector;
/*     */ 
/*     */   
/*     */   public MainClientExec(HttpRequestExecutor paramHttpRequestExecutor, HttpClientConnectionManager paramHttpClientConnectionManager, ConnectionReuseStrategy paramConnectionReuseStrategy, ConnectionKeepAliveStrategy paramConnectionKeepAliveStrategy, HttpProcessor paramHttpProcessor, AuthenticationStrategy paramAuthenticationStrategy1, AuthenticationStrategy paramAuthenticationStrategy2, UserTokenHandler paramUserTokenHandler) {
/* 116 */     Args.notNull(paramHttpRequestExecutor, "HTTP request executor");
/* 117 */     Args.notNull(paramHttpClientConnectionManager, "Client connection manager");
/* 118 */     Args.notNull(paramConnectionReuseStrategy, "Connection reuse strategy");
/* 119 */     Args.notNull(paramConnectionKeepAliveStrategy, "Connection keep alive strategy");
/* 120 */     Args.notNull(paramHttpProcessor, "Proxy HTTP processor");
/* 121 */     Args.notNull(paramAuthenticationStrategy1, "Target authentication strategy");
/* 122 */     Args.notNull(paramAuthenticationStrategy2, "Proxy authentication strategy");
/* 123 */     Args.notNull(paramUserTokenHandler, "User token handler");
/* 124 */     this.authenticator = new HttpAuthenticator();
/* 125 */     this.routeDirector = (HttpRouteDirector)new BasicRouteDirector();
/* 126 */     this.requestExecutor = paramHttpRequestExecutor;
/* 127 */     this.connManager = paramHttpClientConnectionManager;
/* 128 */     this.reuseStrategy = paramConnectionReuseStrategy;
/* 129 */     this.keepAliveStrategy = paramConnectionKeepAliveStrategy;
/* 130 */     this.proxyHttpProcessor = paramHttpProcessor;
/* 131 */     this.targetAuthStrategy = paramAuthenticationStrategy1;
/* 132 */     this.proxyAuthStrategy = paramAuthenticationStrategy2;
/* 133 */     this.userTokenHandler = paramUserTokenHandler;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MainClientExec(HttpRequestExecutor paramHttpRequestExecutor, HttpClientConnectionManager paramHttpClientConnectionManager, ConnectionReuseStrategy paramConnectionReuseStrategy, ConnectionKeepAliveStrategy paramConnectionKeepAliveStrategy, AuthenticationStrategy paramAuthenticationStrategy1, AuthenticationStrategy paramAuthenticationStrategy2, UserTokenHandler paramUserTokenHandler) {
/* 144 */     this(paramHttpRequestExecutor, paramHttpClientConnectionManager, paramConnectionReuseStrategy, paramConnectionKeepAliveStrategy, (HttpProcessor)new ImmutableHttpProcessor(new HttpRequestInterceptor[] { (HttpRequestInterceptor)new RequestTargetHost() }, ), paramAuthenticationStrategy1, paramAuthenticationStrategy2, paramUserTokenHandler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CloseableHttpResponse execute(HttpRoute paramHttpRoute, HttpRequestWrapper paramHttpRequestWrapper, HttpClientContext paramHttpClientContext, HttpExecutionAware paramHttpExecutionAware) throws IOException, HttpException {
/*     */     HttpClientConnection httpClientConnection;
/* 155 */     Args.notNull(paramHttpRoute, "HTTP route");
/* 156 */     Args.notNull(paramHttpRequestWrapper, "HTTP request");
/* 157 */     Args.notNull(paramHttpClientContext, "HTTP context");
/*     */     
/* 159 */     AuthState authState1 = paramHttpClientContext.getTargetAuthState();
/* 160 */     if (authState1 == null) {
/* 161 */       authState1 = new AuthState();
/* 162 */       paramHttpClientContext.setAttribute("http.auth.target-scope", authState1);
/*     */     } 
/* 164 */     AuthState authState2 = paramHttpClientContext.getProxyAuthState();
/* 165 */     if (authState2 == null) {
/* 166 */       authState2 = new AuthState();
/* 167 */       paramHttpClientContext.setAttribute("http.auth.proxy-scope", authState2);
/*     */     } 
/*     */     
/* 170 */     if (paramHttpRequestWrapper instanceof HttpEntityEnclosingRequest) {
/* 171 */       RequestEntityProxy.enhance((HttpEntityEnclosingRequest)paramHttpRequestWrapper);
/*     */     }
/*     */     
/* 174 */     Object object = paramHttpClientContext.getUserToken();
/*     */     
/* 176 */     ConnectionRequest connectionRequest = this.connManager.requestConnection(paramHttpRoute, object);
/* 177 */     if (paramHttpExecutionAware != null) {
/* 178 */       if (paramHttpExecutionAware.isAborted()) {
/* 179 */         connectionRequest.cancel();
/* 180 */         throw new RequestAbortedException("Request aborted");
/*     */       } 
/* 182 */       paramHttpExecutionAware.setCancellable((Cancellable)connectionRequest);
/*     */     } 
/*     */     
/* 185 */     RequestConfig requestConfig = paramHttpClientContext.getRequestConfig();
/*     */ 
/*     */     
/*     */     try {
/* 189 */       int i = requestConfig.getConnectionRequestTimeout();
/* 190 */       httpClientConnection = connectionRequest.get((i > 0) ? i : 0L, TimeUnit.MILLISECONDS);
/* 191 */     } catch (InterruptedException interruptedException) {
/* 192 */       Thread.currentThread().interrupt();
/* 193 */       throw new RequestAbortedException("Request aborted", interruptedException);
/* 194 */     } catch (ExecutionException executionException) {
/* 195 */       Throwable throwable = executionException.getCause();
/* 196 */       if (throwable == null) {
/* 197 */         throwable = executionException;
/*     */       }
/* 199 */       throw new RequestAbortedException("Request execution failed", throwable);
/*     */     } 
/*     */     
/* 202 */     paramHttpClientContext.setAttribute("http.connection", httpClientConnection);
/*     */     
/* 204 */     if (requestConfig.isStaleConnectionCheckEnabled())
/*     */     {
/* 206 */       if (httpClientConnection.isOpen()) {
/* 207 */         this.log.debug("Stale connection check");
/* 208 */         if (httpClientConnection.isStale()) {
/* 209 */           this.log.debug("Stale connection detected");
/* 210 */           httpClientConnection.close();
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 215 */     ConnectionHolder connectionHolder = new ConnectionHolder(this.log, this.connManager, httpClientConnection); try {
/*     */       HttpResponse httpResponse;
/* 217 */       if (paramHttpExecutionAware != null) {
/* 218 */         paramHttpExecutionAware.setCancellable(connectionHolder);
/*     */       }
/*     */ 
/*     */       
/* 222 */       byte b = 1;
/*     */       while (true) {
/* 224 */         if (b > 1 && !RequestEntityProxy.isRepeatable((HttpRequest)paramHttpRequestWrapper)) {
/* 225 */           throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.");
/*     */         }
/*     */ 
/*     */         
/* 229 */         if (paramHttpExecutionAware != null && paramHttpExecutionAware.isAborted()) {
/* 230 */           throw new RequestAbortedException("Request aborted");
/*     */         }
/*     */         
/* 233 */         if (!httpClientConnection.isOpen()) {
/* 234 */           this.log.debug("Opening connection " + paramHttpRoute);
/*     */           try {
/* 236 */             establishRoute(authState2, httpClientConnection, paramHttpRoute, (HttpRequest)paramHttpRequestWrapper, paramHttpClientContext);
/* 237 */           } catch (TunnelRefusedException tunnelRefusedException) {
/* 238 */             if (this.log.isDebugEnabled()) {
/* 239 */               this.log.debug(tunnelRefusedException.getMessage());
/*     */             }
/* 241 */             HttpResponse httpResponse1 = tunnelRefusedException.getResponse();
/*     */             break;
/*     */           } 
/*     */         } 
/* 245 */         int i = requestConfig.getSocketTimeout();
/* 246 */         if (i >= 0) {
/* 247 */           httpClientConnection.setSocketTimeout(i);
/*     */         }
/*     */         
/* 250 */         if (paramHttpExecutionAware != null && paramHttpExecutionAware.isAborted()) {
/* 251 */           throw new RequestAbortedException("Request aborted");
/*     */         }
/*     */         
/* 254 */         if (this.log.isDebugEnabled()) {
/* 255 */           this.log.debug("Executing request " + paramHttpRequestWrapper.getRequestLine());
/*     */         }
/*     */         
/* 258 */         if (!paramHttpRequestWrapper.containsHeader("Authorization")) {
/* 259 */           if (this.log.isDebugEnabled()) {
/* 260 */             this.log.debug("Target auth state: " + authState1.getState());
/*     */           }
/* 262 */           this.authenticator.generateAuthResponse((HttpRequest)paramHttpRequestWrapper, authState1, (HttpContext)paramHttpClientContext);
/*     */         } 
/* 264 */         if (!paramHttpRequestWrapper.containsHeader("Proxy-Authorization") && !paramHttpRoute.isTunnelled()) {
/* 265 */           if (this.log.isDebugEnabled()) {
/* 266 */             this.log.debug("Proxy auth state: " + authState2.getState());
/*     */           }
/* 268 */           this.authenticator.generateAuthResponse((HttpRequest)paramHttpRequestWrapper, authState2, (HttpContext)paramHttpClientContext);
/*     */         } 
/*     */         
/* 271 */         paramHttpClientContext.setAttribute("http.request", paramHttpRequestWrapper);
/* 272 */         httpResponse = this.requestExecutor.execute((HttpRequest)paramHttpRequestWrapper, httpClientConnection, (HttpContext)paramHttpClientContext);
/*     */ 
/*     */         
/* 275 */         if (this.reuseStrategy.keepAlive(httpResponse, (HttpContext)paramHttpClientContext)) {
/*     */           
/* 277 */           long l = this.keepAliveStrategy.getKeepAliveDuration(httpResponse, (HttpContext)paramHttpClientContext);
/* 278 */           if (this.log.isDebugEnabled()) {
/*     */             String str;
/* 280 */             if (l > 0L) {
/* 281 */               str = "for " + l + " " + TimeUnit.MILLISECONDS;
/*     */             } else {
/* 283 */               str = "indefinitely";
/*     */             } 
/* 285 */             this.log.debug("Connection can be kept alive " + str);
/*     */           } 
/* 287 */           connectionHolder.setValidFor(l, TimeUnit.MILLISECONDS);
/* 288 */           connectionHolder.markReusable();
/*     */         } else {
/* 290 */           connectionHolder.markNonReusable();
/*     */         } 
/*     */         
/* 293 */         if (needAuthentication(authState1, authState2, paramHttpRoute, httpResponse, paramHttpClientContext)) {
/*     */ 
/*     */           
/* 296 */           HttpEntity httpEntity1 = httpResponse.getEntity();
/* 297 */           if (connectionHolder.isReusable()) {
/* 298 */             EntityUtils.consume(httpEntity1);
/*     */           } else {
/* 300 */             httpClientConnection.close();
/* 301 */             if (authState2.getState() == AuthProtocolState.SUCCESS && authState2.isConnectionBased()) {
/*     */               
/* 303 */               this.log.debug("Resetting proxy auth state");
/* 304 */               authState2.reset();
/*     */             } 
/* 306 */             if (authState1.getState() == AuthProtocolState.SUCCESS && authState1.isConnectionBased()) {
/*     */               
/* 308 */               this.log.debug("Resetting target auth state");
/* 309 */               authState1.reset();
/*     */             } 
/*     */           } 
/*     */           
/* 313 */           HttpRequest httpRequest = paramHttpRequestWrapper.getOriginal();
/* 314 */           if (!httpRequest.containsHeader("Authorization")) {
/* 315 */             paramHttpRequestWrapper.removeHeaders("Authorization");
/*     */           }
/* 317 */           if (!httpRequest.containsHeader("Proxy-Authorization")) {
/* 318 */             paramHttpRequestWrapper.removeHeaders("Proxy-Authorization");
/*     */           }
/*     */           
/*     */           b++;
/*     */         } 
/*     */         break;
/*     */       } 
/* 325 */       if (object == null) {
/* 326 */         object = this.userTokenHandler.getUserToken((HttpContext)paramHttpClientContext);
/* 327 */         paramHttpClientContext.setAttribute("http.user-token", object);
/*     */       } 
/* 329 */       if (object != null) {
/* 330 */         connectionHolder.setState(object);
/*     */       }
/*     */ 
/*     */       
/* 334 */       HttpEntity httpEntity = httpResponse.getEntity();
/* 335 */       if (httpEntity == null || !httpEntity.isStreaming()) {
/*     */         
/* 337 */         connectionHolder.releaseConnection();
/* 338 */         return new HttpResponseProxy(httpResponse, null);
/*     */       } 
/* 340 */       return new HttpResponseProxy(httpResponse, connectionHolder);
/* 341 */     } catch (ConnectionShutdownException connectionShutdownException) {
/* 342 */       InterruptedIOException interruptedIOException = new InterruptedIOException("Connection has been shut down");
/*     */       
/* 344 */       interruptedIOException.initCause((Throwable)connectionShutdownException);
/* 345 */       throw interruptedIOException;
/* 346 */     } catch (HttpException httpException) {
/* 347 */       connectionHolder.abortConnection();
/* 348 */       throw httpException;
/* 349 */     } catch (IOException iOException) {
/* 350 */       connectionHolder.abortConnection();
/* 351 */       if (authState2.isConnectionBased()) {
/* 352 */         authState2.reset();
/*     */       }
/* 354 */       if (authState1.isConnectionBased()) {
/* 355 */         authState1.reset();
/*     */       }
/* 357 */       throw iOException;
/* 358 */     } catch (RuntimeException runtimeException) {
/* 359 */       connectionHolder.abortConnection();
/* 360 */       if (authState2.isConnectionBased()) {
/* 361 */         authState2.reset();
/*     */       }
/* 363 */       if (authState1.isConnectionBased()) {
/* 364 */         authState1.reset();
/*     */       }
/* 366 */       throw runtimeException;
/* 367 */     } catch (Error error) {
/* 368 */       this.connManager.shutdown();
/* 369 */       throw error;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void establishRoute(AuthState paramAuthState, HttpClientConnection paramHttpClientConnection, HttpRoute paramHttpRoute, HttpRequest paramHttpRequest, HttpClientContext paramHttpClientContext) throws HttpException, IOException {
/*     */     int j;
/* 382 */     RequestConfig requestConfig = paramHttpClientContext.getRequestConfig();
/* 383 */     int i = requestConfig.getConnectTimeout();
/* 384 */     RouteTracker routeTracker = new RouteTracker(paramHttpRoute); do {
/*     */       HttpHost httpHost; boolean bool1; int k;
/*     */       boolean bool2;
/* 387 */       HttpRoute httpRoute = routeTracker.toRoute();
/* 388 */       j = this.routeDirector.nextStep((RouteInfo)paramHttpRoute, (RouteInfo)httpRoute);
/*     */       
/* 390 */       switch (j) {
/*     */         
/*     */         case 1:
/* 393 */           this.connManager.connect(paramHttpClientConnection, paramHttpRoute, (i > 0) ? i : 0, (HttpContext)paramHttpClientContext);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 398 */           routeTracker.connectTarget(paramHttpRoute.isSecure());
/*     */           break;
/*     */         case 2:
/* 401 */           this.connManager.connect(paramHttpClientConnection, paramHttpRoute, (i > 0) ? i : 0, (HttpContext)paramHttpClientContext);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 406 */           httpHost = paramHttpRoute.getProxyHost();
/* 407 */           routeTracker.connectProxy(httpHost, (paramHttpRoute.isSecure() && !paramHttpRoute.isTunnelled()));
/*     */           break;
/*     */         case 3:
/* 410 */           bool1 = createTunnelToTarget(paramAuthState, paramHttpClientConnection, paramHttpRoute, paramHttpRequest, paramHttpClientContext);
/*     */           
/* 412 */           this.log.debug("Tunnel to target created.");
/* 413 */           routeTracker.tunnelTarget(bool1);
/*     */           break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         case 4:
/* 421 */           k = httpRoute.getHopCount() - 1;
/* 422 */           bool2 = createTunnelToProxy(paramHttpRoute, k, paramHttpClientContext);
/* 423 */           this.log.debug("Tunnel to proxy created.");
/* 424 */           routeTracker.tunnelProxy(paramHttpRoute.getHopTarget(k), bool2);
/*     */           break;
/*     */         
/*     */         case 5:
/* 428 */           this.connManager.upgrade(paramHttpClientConnection, paramHttpRoute, (HttpContext)paramHttpClientContext);
/* 429 */           routeTracker.layerProtocol(paramHttpRoute.isSecure());
/*     */           break;
/*     */         
/*     */         case -1:
/* 433 */           throw new HttpException("Unable to establish route: planned = " + paramHttpRoute + "; current = " + httpRoute);
/*     */         
/*     */         case 0:
/* 436 */           this.connManager.routeComplete(paramHttpClientConnection, paramHttpRoute, (HttpContext)paramHttpClientContext);
/*     */           break;
/*     */         default:
/* 439 */           throw new IllegalStateException("Unknown step indicator " + j + " from RouteDirector.");
/*     */       } 
/*     */ 
/*     */     
/* 443 */     } while (j > 0);
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
/*     */   private boolean createTunnelToTarget(AuthState paramAuthState, HttpClientConnection paramHttpClientConnection, HttpRoute paramHttpRoute, HttpRequest paramHttpRequest, HttpClientContext paramHttpClientContext) throws HttpException, IOException {
/* 461 */     RequestConfig requestConfig = paramHttpClientContext.getRequestConfig();
/* 462 */     int i = requestConfig.getConnectTimeout();
/*     */     
/* 464 */     HttpHost httpHost1 = paramHttpRoute.getTargetHost();
/* 465 */     HttpHost httpHost2 = paramHttpRoute.getProxyHost();
/* 466 */     HttpResponse httpResponse = null;
/*     */     
/* 468 */     String str = httpHost1.toHostString();
/* 469 */     BasicHttpRequest basicHttpRequest = new BasicHttpRequest("CONNECT", str, paramHttpRequest.getProtocolVersion());
/*     */     
/* 471 */     this.requestExecutor.preProcess((HttpRequest)basicHttpRequest, this.proxyHttpProcessor, (HttpContext)paramHttpClientContext);
/*     */     
/* 473 */     while (httpResponse == null) {
/* 474 */       if (!paramHttpClientConnection.isOpen()) {
/* 475 */         this.connManager.connect(paramHttpClientConnection, paramHttpRoute, (i > 0) ? i : 0, (HttpContext)paramHttpClientContext);
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 482 */       basicHttpRequest.removeHeaders("Proxy-Authorization");
/* 483 */       this.authenticator.generateAuthResponse((HttpRequest)basicHttpRequest, paramAuthState, (HttpContext)paramHttpClientContext);
/*     */       
/* 485 */       httpResponse = this.requestExecutor.execute((HttpRequest)basicHttpRequest, paramHttpClientConnection, (HttpContext)paramHttpClientContext);
/* 486 */       this.requestExecutor.postProcess(httpResponse, this.proxyHttpProcessor, (HttpContext)paramHttpClientContext);
/*     */       
/* 488 */       int k = httpResponse.getStatusLine().getStatusCode();
/* 489 */       if (k < 200) {
/* 490 */         throw new HttpException("Unexpected response to CONNECT request: " + httpResponse.getStatusLine());
/*     */       }
/*     */ 
/*     */       
/* 494 */       if (requestConfig.isAuthenticationEnabled() && 
/* 495 */         this.authenticator.isAuthenticationRequested(httpHost2, httpResponse, this.proxyAuthStrategy, paramAuthState, (HttpContext)paramHttpClientContext))
/*     */       {
/* 497 */         if (this.authenticator.handleAuthChallenge(httpHost2, httpResponse, this.proxyAuthStrategy, paramAuthState, (HttpContext)paramHttpClientContext)) {
/*     */ 
/*     */           
/* 500 */           if (this.reuseStrategy.keepAlive(httpResponse, (HttpContext)paramHttpClientContext)) {
/* 501 */             this.log.debug("Connection kept alive");
/*     */             
/* 503 */             HttpEntity httpEntity = httpResponse.getEntity();
/* 504 */             EntityUtils.consume(httpEntity);
/*     */           } else {
/* 506 */             paramHttpClientConnection.close();
/*     */           } 
/* 508 */           httpResponse = null;
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 514 */     int j = httpResponse.getStatusLine().getStatusCode();
/*     */     
/* 516 */     if (j > 299) {
/*     */ 
/*     */       
/* 519 */       HttpEntity httpEntity = httpResponse.getEntity();
/* 520 */       if (httpEntity != null) {
/* 521 */         httpResponse.setEntity((HttpEntity)new BufferedHttpEntity(httpEntity));
/*     */       }
/*     */       
/* 524 */       paramHttpClientConnection.close();
/* 525 */       throw new TunnelRefusedException("CONNECT refused by proxy: " + httpResponse.getStatusLine(), httpResponse);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 533 */     return false;
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
/*     */   private boolean createTunnelToProxy(HttpRoute paramHttpRoute, int paramInt, HttpClientContext paramHttpClientContext) throws HttpException {
/* 555 */     throw new HttpException("Proxy chains are not supported.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean needAuthentication(AuthState paramAuthState1, AuthState paramAuthState2, HttpRoute paramHttpRoute, HttpResponse paramHttpResponse, HttpClientContext paramHttpClientContext) {
/* 564 */     RequestConfig requestConfig = paramHttpClientContext.getRequestConfig();
/* 565 */     if (requestConfig.isAuthenticationEnabled()) {
/* 566 */       HttpHost httpHost1 = paramHttpClientContext.getTargetHost();
/* 567 */       if (httpHost1 == null) {
/* 568 */         httpHost1 = paramHttpRoute.getTargetHost();
/*     */       }
/* 570 */       if (httpHost1.getPort() < 0) {
/* 571 */         httpHost1 = new HttpHost(httpHost1.getHostName(), paramHttpRoute.getTargetHost().getPort(), httpHost1.getSchemeName());
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 576 */       boolean bool1 = this.authenticator.isAuthenticationRequested(httpHost1, paramHttpResponse, this.targetAuthStrategy, paramAuthState1, (HttpContext)paramHttpClientContext);
/*     */ 
/*     */       
/* 579 */       HttpHost httpHost2 = paramHttpRoute.getProxyHost();
/*     */       
/* 581 */       if (httpHost2 == null) {
/* 582 */         httpHost2 = paramHttpRoute.getTargetHost();
/*     */       }
/* 584 */       boolean bool2 = this.authenticator.isAuthenticationRequested(httpHost2, paramHttpResponse, this.proxyAuthStrategy, paramAuthState2, (HttpContext)paramHttpClientContext);
/*     */ 
/*     */       
/* 587 */       if (bool1) {
/* 588 */         return this.authenticator.handleAuthChallenge(httpHost1, paramHttpResponse, this.targetAuthStrategy, paramAuthState1, (HttpContext)paramHttpClientContext);
/*     */       }
/*     */       
/* 591 */       if (bool2) {
/* 592 */         return this.authenticator.handleAuthChallenge(httpHost2, paramHttpResponse, this.proxyAuthStrategy, paramAuthState2, (HttpContext)paramHttpClientContext);
/*     */       }
/*     */     } 
/*     */     
/* 596 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\execchain\MainClientExec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */