/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.UndeclaredThrowableException;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.ConnectionReuseStrategy;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpRequestInterceptor;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.HttpResponseInterceptor;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.auth.AuthSchemeFactory;
/*     */ import org.apache.http.auth.AuthSchemeRegistry;
/*     */ import org.apache.http.client.AuthenticationHandler;
/*     */ import org.apache.http.client.AuthenticationStrategy;
/*     */ import org.apache.http.client.BackoffManager;
/*     */ import org.apache.http.client.ClientProtocolException;
/*     */ import org.apache.http.client.ConnectionBackoffStrategy;
/*     */ import org.apache.http.client.CookieStore;
/*     */ import org.apache.http.client.CredentialsProvider;
/*     */ import org.apache.http.client.HttpRequestRetryHandler;
/*     */ import org.apache.http.client.RedirectHandler;
/*     */ import org.apache.http.client.RedirectStrategy;
/*     */ import org.apache.http.client.RequestDirector;
/*     */ import org.apache.http.client.UserTokenHandler;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.client.methods.CloseableHttpResponse;
/*     */ import org.apache.http.client.params.HttpClientParamConfig;
/*     */ import org.apache.http.conn.ClientConnectionManager;
/*     */ import org.apache.http.conn.ClientConnectionManagerFactory;
/*     */ import org.apache.http.conn.ConnectionKeepAliveStrategy;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.conn.routing.HttpRoutePlanner;
/*     */ import org.apache.http.conn.scheme.SchemeRegistry;
/*     */ import org.apache.http.cookie.CookieSpecFactory;
/*     */ import org.apache.http.cookie.CookieSpecRegistry;
/*     */ import org.apache.http.impl.DefaultConnectionReuseStrategy;
/*     */ import org.apache.http.impl.auth.BasicSchemeFactory;
/*     */ import org.apache.http.impl.auth.DigestSchemeFactory;
/*     */ import org.apache.http.impl.auth.KerberosSchemeFactory;
/*     */ import org.apache.http.impl.auth.NTLMSchemeFactory;
/*     */ import org.apache.http.impl.auth.SPNegoSchemeFactory;
/*     */ import org.apache.http.impl.conn.BasicClientConnectionManager;
/*     */ import org.apache.http.impl.conn.DefaultHttpRoutePlanner;
/*     */ import org.apache.http.impl.conn.SchemeRegistryFactory;
/*     */ import org.apache.http.impl.cookie.BestMatchSpecFactory;
/*     */ import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
/*     */ import org.apache.http.impl.cookie.IgnoreSpecFactory;
/*     */ import org.apache.http.impl.cookie.NetscapeDraftSpecFactory;
/*     */ import org.apache.http.impl.cookie.RFC2109SpecFactory;
/*     */ import org.apache.http.impl.cookie.RFC2965SpecFactory;
/*     */ import org.apache.http.params.HttpParams;
/*     */ import org.apache.http.protocol.BasicHttpContext;
/*     */ import org.apache.http.protocol.BasicHttpProcessor;
/*     */ import org.apache.http.protocol.DefaultedHttpContext;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.protocol.HttpProcessor;
/*     */ import org.apache.http.protocol.HttpRequestExecutor;
/*     */ import org.apache.http.protocol.ImmutableHttpProcessor;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public abstract class AbstractHttpClient
/*     */   extends CloseableHttpClient
/*     */ {
/* 201 */   private final Log log = LogFactory.getLog(getClass());
/*     */   
/*     */   private HttpParams defaultParams;
/*     */   
/*     */   private HttpRequestExecutor requestExec;
/*     */   
/*     */   private ClientConnectionManager connManager;
/*     */   
/*     */   private ConnectionReuseStrategy reuseStrategy;
/*     */   
/*     */   private ConnectionKeepAliveStrategy keepAliveStrategy;
/*     */   
/*     */   private CookieSpecRegistry supportedCookieSpecs;
/*     */   
/*     */   private AuthSchemeRegistry supportedAuthSchemes;
/*     */   
/*     */   private BasicHttpProcessor mutableProcessor;
/*     */   
/*     */   private ImmutableHttpProcessor protocolProcessor;
/*     */   
/*     */   private HttpRequestRetryHandler retryHandler;
/*     */   private RedirectStrategy redirectStrategy;
/*     */   private AuthenticationStrategy targetAuthStrategy;
/*     */   private AuthenticationStrategy proxyAuthStrategy;
/*     */   private CookieStore cookieStore;
/*     */   private CredentialsProvider credsProvider;
/*     */   private HttpRoutePlanner routePlanner;
/*     */   private UserTokenHandler userTokenHandler;
/*     */   private ConnectionBackoffStrategy connectionBackoffStrategy;
/*     */   private BackoffManager backoffManager;
/*     */   
/*     */   protected AbstractHttpClient(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams) {
/* 233 */     this.defaultParams = paramHttpParams;
/* 234 */     this.connManager = paramClientConnectionManager;
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract HttpParams createHttpParams();
/*     */ 
/*     */   
/*     */   protected abstract BasicHttpProcessor createHttpProcessor();
/*     */ 
/*     */   
/*     */   protected HttpContext createHttpContext() {
/* 245 */     BasicHttpContext basicHttpContext = new BasicHttpContext();
/* 246 */     basicHttpContext.setAttribute("http.scheme-registry", getConnectionManager().getSchemeRegistry());
/*     */ 
/*     */     
/* 249 */     basicHttpContext.setAttribute("http.authscheme-registry", getAuthSchemes());
/*     */ 
/*     */     
/* 252 */     basicHttpContext.setAttribute("http.cookiespec-registry", getCookieSpecs());
/*     */ 
/*     */     
/* 255 */     basicHttpContext.setAttribute("http.cookie-store", getCookieStore());
/*     */ 
/*     */     
/* 258 */     basicHttpContext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
/*     */ 
/*     */     
/* 261 */     return (HttpContext)basicHttpContext;
/*     */   }
/*     */   
/*     */   protected ClientConnectionManager createClientConnectionManager() {
/*     */     BasicClientConnectionManager basicClientConnectionManager;
/* 266 */     SchemeRegistry schemeRegistry = SchemeRegistryFactory.createDefault();
/*     */     
/* 268 */     ClientConnectionManager clientConnectionManager = null;
/* 269 */     HttpParams httpParams = getParams();
/*     */     
/* 271 */     ClientConnectionManagerFactory clientConnectionManagerFactory = null;
/*     */     
/* 273 */     String str = (String)httpParams.getParameter("http.connection-manager.factory-class-name");
/*     */     
/* 275 */     ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
/* 276 */     if (str != null) {
/*     */       try {
/*     */         Class<?> clazz;
/* 279 */         if (classLoader != null) {
/* 280 */           clazz = Class.forName(str, true, classLoader);
/*     */         } else {
/* 282 */           clazz = Class.forName(str);
/*     */         } 
/* 284 */         clientConnectionManagerFactory = (ClientConnectionManagerFactory)clazz.newInstance();
/* 285 */       } catch (ClassNotFoundException classNotFoundException) {
/* 286 */         throw new IllegalStateException("Invalid class name: " + str);
/* 287 */       } catch (IllegalAccessException illegalAccessException) {
/* 288 */         throw new IllegalAccessError(illegalAccessException.getMessage());
/* 289 */       } catch (InstantiationException instantiationException) {
/* 290 */         throw new InstantiationError(instantiationException.getMessage());
/*     */       } 
/*     */     }
/* 293 */     if (clientConnectionManagerFactory != null) {
/* 294 */       clientConnectionManager = clientConnectionManagerFactory.newInstance(httpParams, schemeRegistry);
/*     */     } else {
/* 296 */       basicClientConnectionManager = new BasicClientConnectionManager(schemeRegistry);
/*     */     } 
/*     */     
/* 299 */     return (ClientConnectionManager)basicClientConnectionManager;
/*     */   }
/*     */ 
/*     */   
/*     */   protected AuthSchemeRegistry createAuthSchemeRegistry() {
/* 304 */     AuthSchemeRegistry authSchemeRegistry = new AuthSchemeRegistry();
/* 305 */     authSchemeRegistry.register("Basic", (AuthSchemeFactory)new BasicSchemeFactory());
/*     */ 
/*     */     
/* 308 */     authSchemeRegistry.register("Digest", (AuthSchemeFactory)new DigestSchemeFactory());
/*     */ 
/*     */     
/* 311 */     authSchemeRegistry.register("NTLM", (AuthSchemeFactory)new NTLMSchemeFactory());
/*     */ 
/*     */     
/* 314 */     authSchemeRegistry.register("Negotiate", (AuthSchemeFactory)new SPNegoSchemeFactory());
/*     */ 
/*     */     
/* 317 */     authSchemeRegistry.register("Kerberos", (AuthSchemeFactory)new KerberosSchemeFactory());
/*     */ 
/*     */     
/* 320 */     return authSchemeRegistry;
/*     */   }
/*     */ 
/*     */   
/*     */   protected CookieSpecRegistry createCookieSpecRegistry() {
/* 325 */     CookieSpecRegistry cookieSpecRegistry = new CookieSpecRegistry();
/* 326 */     cookieSpecRegistry.register("default", (CookieSpecFactory)new BestMatchSpecFactory());
/*     */ 
/*     */     
/* 329 */     cookieSpecRegistry.register("best-match", (CookieSpecFactory)new BestMatchSpecFactory());
/*     */ 
/*     */     
/* 332 */     cookieSpecRegistry.register("compatibility", (CookieSpecFactory)new BrowserCompatSpecFactory());
/*     */ 
/*     */     
/* 335 */     cookieSpecRegistry.register("netscape", (CookieSpecFactory)new NetscapeDraftSpecFactory());
/*     */ 
/*     */     
/* 338 */     cookieSpecRegistry.register("rfc2109", (CookieSpecFactory)new RFC2109SpecFactory());
/*     */ 
/*     */     
/* 341 */     cookieSpecRegistry.register("rfc2965", (CookieSpecFactory)new RFC2965SpecFactory());
/*     */ 
/*     */     
/* 344 */     cookieSpecRegistry.register("ignoreCookies", (CookieSpecFactory)new IgnoreSpecFactory());
/*     */ 
/*     */     
/* 347 */     return cookieSpecRegistry;
/*     */   }
/*     */   
/*     */   protected HttpRequestExecutor createRequestExecutor() {
/* 351 */     return new HttpRequestExecutor();
/*     */   }
/*     */   
/*     */   protected ConnectionReuseStrategy createConnectionReuseStrategy() {
/* 355 */     return (ConnectionReuseStrategy)new DefaultConnectionReuseStrategy();
/*     */   }
/*     */   
/*     */   protected ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
/* 359 */     return new DefaultConnectionKeepAliveStrategy();
/*     */   }
/*     */   
/*     */   protected HttpRequestRetryHandler createHttpRequestRetryHandler() {
/* 363 */     return new DefaultHttpRequestRetryHandler();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected RedirectHandler createRedirectHandler() {
/* 371 */     return new DefaultRedirectHandler();
/*     */   }
/*     */   
/*     */   protected AuthenticationStrategy createTargetAuthenticationStrategy() {
/* 375 */     return new TargetAuthenticationStrategy();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected AuthenticationHandler createTargetAuthenticationHandler() {
/* 383 */     return new DefaultTargetAuthenticationHandler();
/*     */   }
/*     */   
/*     */   protected AuthenticationStrategy createProxyAuthenticationStrategy() {
/* 387 */     return new ProxyAuthenticationStrategy();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected AuthenticationHandler createProxyAuthenticationHandler() {
/* 395 */     return new DefaultProxyAuthenticationHandler();
/*     */   }
/*     */   
/*     */   protected CookieStore createCookieStore() {
/* 399 */     return new BasicCookieStore();
/*     */   }
/*     */   
/*     */   protected CredentialsProvider createCredentialsProvider() {
/* 403 */     return new BasicCredentialsProvider();
/*     */   }
/*     */   
/*     */   protected HttpRoutePlanner createHttpRoutePlanner() {
/* 407 */     return (HttpRoutePlanner)new DefaultHttpRoutePlanner(getConnectionManager().getSchemeRegistry());
/*     */   }
/*     */   
/*     */   protected UserTokenHandler createUserTokenHandler() {
/* 411 */     return new DefaultUserTokenHandler();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final synchronized HttpParams getParams() {
/* 417 */     if (this.defaultParams == null) {
/* 418 */       this.defaultParams = createHttpParams();
/*     */     }
/* 420 */     return this.defaultParams;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void setParams(HttpParams paramHttpParams) {
/* 430 */     this.defaultParams = paramHttpParams;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final synchronized ClientConnectionManager getConnectionManager() {
/* 436 */     if (this.connManager == null) {
/* 437 */       this.connManager = createClientConnectionManager();
/*     */     }
/* 439 */     return this.connManager;
/*     */   }
/*     */ 
/*     */   
/*     */   public final synchronized HttpRequestExecutor getRequestExecutor() {
/* 444 */     if (this.requestExec == null) {
/* 445 */       this.requestExec = createRequestExecutor();
/*     */     }
/* 447 */     return this.requestExec;
/*     */   }
/*     */ 
/*     */   
/*     */   public final synchronized AuthSchemeRegistry getAuthSchemes() {
/* 452 */     if (this.supportedAuthSchemes == null) {
/* 453 */       this.supportedAuthSchemes = createAuthSchemeRegistry();
/*     */     }
/* 455 */     return this.supportedAuthSchemes;
/*     */   }
/*     */   
/*     */   public synchronized void setAuthSchemes(AuthSchemeRegistry paramAuthSchemeRegistry) {
/* 459 */     this.supportedAuthSchemes = paramAuthSchemeRegistry;
/*     */   }
/*     */   
/*     */   public final synchronized ConnectionBackoffStrategy getConnectionBackoffStrategy() {
/* 463 */     return this.connectionBackoffStrategy;
/*     */   }
/*     */   
/*     */   public synchronized void setConnectionBackoffStrategy(ConnectionBackoffStrategy paramConnectionBackoffStrategy) {
/* 467 */     this.connectionBackoffStrategy = paramConnectionBackoffStrategy;
/*     */   }
/*     */   
/*     */   public final synchronized CookieSpecRegistry getCookieSpecs() {
/* 471 */     if (this.supportedCookieSpecs == null) {
/* 472 */       this.supportedCookieSpecs = createCookieSpecRegistry();
/*     */     }
/* 474 */     return this.supportedCookieSpecs;
/*     */   }
/*     */   
/*     */   public final synchronized BackoffManager getBackoffManager() {
/* 478 */     return this.backoffManager;
/*     */   }
/*     */   
/*     */   public synchronized void setBackoffManager(BackoffManager paramBackoffManager) {
/* 482 */     this.backoffManager = paramBackoffManager;
/*     */   }
/*     */   
/*     */   public synchronized void setCookieSpecs(CookieSpecRegistry paramCookieSpecRegistry) {
/* 486 */     this.supportedCookieSpecs = paramCookieSpecRegistry;
/*     */   }
/*     */   
/*     */   public final synchronized ConnectionReuseStrategy getConnectionReuseStrategy() {
/* 490 */     if (this.reuseStrategy == null) {
/* 491 */       this.reuseStrategy = createConnectionReuseStrategy();
/*     */     }
/* 493 */     return this.reuseStrategy;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void setReuseStrategy(ConnectionReuseStrategy paramConnectionReuseStrategy) {
/* 498 */     this.reuseStrategy = paramConnectionReuseStrategy;
/*     */   }
/*     */ 
/*     */   
/*     */   public final synchronized ConnectionKeepAliveStrategy getConnectionKeepAliveStrategy() {
/* 503 */     if (this.keepAliveStrategy == null) {
/* 504 */       this.keepAliveStrategy = createConnectionKeepAliveStrategy();
/*     */     }
/* 506 */     return this.keepAliveStrategy;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void setKeepAliveStrategy(ConnectionKeepAliveStrategy paramConnectionKeepAliveStrategy) {
/* 511 */     this.keepAliveStrategy = paramConnectionKeepAliveStrategy;
/*     */   }
/*     */ 
/*     */   
/*     */   public final synchronized HttpRequestRetryHandler getHttpRequestRetryHandler() {
/* 516 */     if (this.retryHandler == null) {
/* 517 */       this.retryHandler = createHttpRequestRetryHandler();
/*     */     }
/* 519 */     return this.retryHandler;
/*     */   }
/*     */   
/*     */   public synchronized void setHttpRequestRetryHandler(HttpRequestRetryHandler paramHttpRequestRetryHandler) {
/* 523 */     this.retryHandler = paramHttpRequestRetryHandler;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public final synchronized RedirectHandler getRedirectHandler() {
/* 531 */     return createRedirectHandler();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public synchronized void setRedirectHandler(RedirectHandler paramRedirectHandler) {
/* 539 */     this.redirectStrategy = new DefaultRedirectStrategyAdaptor(paramRedirectHandler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final synchronized RedirectStrategy getRedirectStrategy() {
/* 546 */     if (this.redirectStrategy == null) {
/* 547 */       this.redirectStrategy = new DefaultRedirectStrategy();
/*     */     }
/* 549 */     return this.redirectStrategy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void setRedirectStrategy(RedirectStrategy paramRedirectStrategy) {
/* 556 */     this.redirectStrategy = paramRedirectStrategy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public final synchronized AuthenticationHandler getTargetAuthenticationHandler() {
/* 564 */     return createTargetAuthenticationHandler();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public synchronized void setTargetAuthenticationHandler(AuthenticationHandler paramAuthenticationHandler) {
/* 572 */     this.targetAuthStrategy = new AuthenticationStrategyAdaptor(paramAuthenticationHandler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final synchronized AuthenticationStrategy getTargetAuthenticationStrategy() {
/* 579 */     if (this.targetAuthStrategy == null) {
/* 580 */       this.targetAuthStrategy = createTargetAuthenticationStrategy();
/*     */     }
/* 582 */     return this.targetAuthStrategy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void setTargetAuthenticationStrategy(AuthenticationStrategy paramAuthenticationStrategy) {
/* 589 */     this.targetAuthStrategy = paramAuthenticationStrategy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public final synchronized AuthenticationHandler getProxyAuthenticationHandler() {
/* 597 */     return createProxyAuthenticationHandler();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public synchronized void setProxyAuthenticationHandler(AuthenticationHandler paramAuthenticationHandler) {
/* 605 */     this.proxyAuthStrategy = new AuthenticationStrategyAdaptor(paramAuthenticationHandler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final synchronized AuthenticationStrategy getProxyAuthenticationStrategy() {
/* 612 */     if (this.proxyAuthStrategy == null) {
/* 613 */       this.proxyAuthStrategy = createProxyAuthenticationStrategy();
/*     */     }
/* 615 */     return this.proxyAuthStrategy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void setProxyAuthenticationStrategy(AuthenticationStrategy paramAuthenticationStrategy) {
/* 622 */     this.proxyAuthStrategy = paramAuthenticationStrategy;
/*     */   }
/*     */   
/*     */   public final synchronized CookieStore getCookieStore() {
/* 626 */     if (this.cookieStore == null) {
/* 627 */       this.cookieStore = createCookieStore();
/*     */     }
/* 629 */     return this.cookieStore;
/*     */   }
/*     */   
/*     */   public synchronized void setCookieStore(CookieStore paramCookieStore) {
/* 633 */     this.cookieStore = paramCookieStore;
/*     */   }
/*     */   
/*     */   public final synchronized CredentialsProvider getCredentialsProvider() {
/* 637 */     if (this.credsProvider == null) {
/* 638 */       this.credsProvider = createCredentialsProvider();
/*     */     }
/* 640 */     return this.credsProvider;
/*     */   }
/*     */   
/*     */   public synchronized void setCredentialsProvider(CredentialsProvider paramCredentialsProvider) {
/* 644 */     this.credsProvider = paramCredentialsProvider;
/*     */   }
/*     */   
/*     */   public final synchronized HttpRoutePlanner getRoutePlanner() {
/* 648 */     if (this.routePlanner == null) {
/* 649 */       this.routePlanner = createHttpRoutePlanner();
/*     */     }
/* 651 */     return this.routePlanner;
/*     */   }
/*     */   
/*     */   public synchronized void setRoutePlanner(HttpRoutePlanner paramHttpRoutePlanner) {
/* 655 */     this.routePlanner = paramHttpRoutePlanner;
/*     */   }
/*     */   
/*     */   public final synchronized UserTokenHandler getUserTokenHandler() {
/* 659 */     if (this.userTokenHandler == null) {
/* 660 */       this.userTokenHandler = createUserTokenHandler();
/*     */     }
/* 662 */     return this.userTokenHandler;
/*     */   }
/*     */   
/*     */   public synchronized void setUserTokenHandler(UserTokenHandler paramUserTokenHandler) {
/* 666 */     this.userTokenHandler = paramUserTokenHandler;
/*     */   }
/*     */   
/*     */   protected final synchronized BasicHttpProcessor getHttpProcessor() {
/* 670 */     if (this.mutableProcessor == null) {
/* 671 */       this.mutableProcessor = createHttpProcessor();
/*     */     }
/* 673 */     return this.mutableProcessor;
/*     */   }
/*     */   
/*     */   private synchronized HttpProcessor getProtocolProcessor() {
/* 677 */     if (this.protocolProcessor == null) {
/*     */       
/* 679 */       BasicHttpProcessor basicHttpProcessor = getHttpProcessor();
/*     */       
/* 681 */       int i = basicHttpProcessor.getRequestInterceptorCount();
/* 682 */       HttpRequestInterceptor[] arrayOfHttpRequestInterceptor = new HttpRequestInterceptor[i]; int j;
/* 683 */       for (j = 0; j < i; j++) {
/* 684 */         arrayOfHttpRequestInterceptor[j] = basicHttpProcessor.getRequestInterceptor(j);
/*     */       }
/* 686 */       j = basicHttpProcessor.getResponseInterceptorCount();
/* 687 */       HttpResponseInterceptor[] arrayOfHttpResponseInterceptor = new HttpResponseInterceptor[j];
/* 688 */       for (byte b = 0; b < j; b++) {
/* 689 */         arrayOfHttpResponseInterceptor[b] = basicHttpProcessor.getResponseInterceptor(b);
/*     */       }
/* 691 */       this.protocolProcessor = new ImmutableHttpProcessor(arrayOfHttpRequestInterceptor, arrayOfHttpResponseInterceptor);
/*     */     } 
/* 693 */     return (HttpProcessor)this.protocolProcessor;
/*     */   }
/*     */   
/*     */   public synchronized int getResponseInterceptorCount() {
/* 697 */     return getHttpProcessor().getResponseInterceptorCount();
/*     */   }
/*     */   
/*     */   public synchronized HttpResponseInterceptor getResponseInterceptor(int paramInt) {
/* 701 */     return getHttpProcessor().getResponseInterceptor(paramInt);
/*     */   }
/*     */   
/*     */   public synchronized HttpRequestInterceptor getRequestInterceptor(int paramInt) {
/* 705 */     return getHttpProcessor().getRequestInterceptor(paramInt);
/*     */   }
/*     */   
/*     */   public synchronized int getRequestInterceptorCount() {
/* 709 */     return getHttpProcessor().getRequestInterceptorCount();
/*     */   }
/*     */   
/*     */   public synchronized void addResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor) {
/* 713 */     getHttpProcessor().addInterceptor(paramHttpResponseInterceptor);
/* 714 */     this.protocolProcessor = null;
/*     */   }
/*     */   
/*     */   public synchronized void addResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor, int paramInt) {
/* 718 */     getHttpProcessor().addInterceptor(paramHttpResponseInterceptor, paramInt);
/* 719 */     this.protocolProcessor = null;
/*     */   }
/*     */   
/*     */   public synchronized void clearResponseInterceptors() {
/* 723 */     getHttpProcessor().clearResponseInterceptors();
/* 724 */     this.protocolProcessor = null;
/*     */   }
/*     */   
/*     */   public synchronized void removeResponseInterceptorByClass(Class<? extends HttpResponseInterceptor> paramClass) {
/* 728 */     getHttpProcessor().removeResponseInterceptorByClass(paramClass);
/* 729 */     this.protocolProcessor = null;
/*     */   }
/*     */   
/*     */   public synchronized void addRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor) {
/* 733 */     getHttpProcessor().addInterceptor(paramHttpRequestInterceptor);
/* 734 */     this.protocolProcessor = null;
/*     */   }
/*     */   
/*     */   public synchronized void addRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor, int paramInt) {
/* 738 */     getHttpProcessor().addInterceptor(paramHttpRequestInterceptor, paramInt);
/* 739 */     this.protocolProcessor = null;
/*     */   }
/*     */   
/*     */   public synchronized void clearRequestInterceptors() {
/* 743 */     getHttpProcessor().clearRequestInterceptors();
/* 744 */     this.protocolProcessor = null;
/*     */   }
/*     */   
/*     */   public synchronized void removeRequestInterceptorByClass(Class<? extends HttpRequestInterceptor> paramClass) {
/* 748 */     getHttpProcessor().removeRequestInterceptorByClass(paramClass);
/* 749 */     this.protocolProcessor = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final CloseableHttpResponse doExecute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws IOException, ClientProtocolException {
/*     */     DefaultedHttpContext defaultedHttpContext;
/* 757 */     Args.notNull(paramHttpRequest, "HTTP request");
/*     */ 
/*     */ 
/*     */     
/* 761 */     HttpContext httpContext = null;
/* 762 */     RequestDirector requestDirector = null;
/* 763 */     HttpRoutePlanner httpRoutePlanner = null;
/* 764 */     ConnectionBackoffStrategy connectionBackoffStrategy = null;
/* 765 */     BackoffManager backoffManager = null;
/*     */ 
/*     */ 
/*     */     
/* 769 */     synchronized (this) {
/*     */       
/* 771 */       HttpContext httpContext1 = createHttpContext();
/* 772 */       if (paramHttpContext == null) {
/* 773 */         httpContext = httpContext1;
/*     */       } else {
/* 775 */         defaultedHttpContext = new DefaultedHttpContext(paramHttpContext, httpContext1);
/*     */       } 
/* 777 */       HttpParams httpParams = determineParams(paramHttpRequest);
/* 778 */       RequestConfig requestConfig = HttpClientParamConfig.getRequestConfig(httpParams);
/* 779 */       defaultedHttpContext.setAttribute("http.request-config", requestConfig);
/*     */ 
/*     */       
/* 782 */       requestDirector = createClientRequestDirector(getRequestExecutor(), getConnectionManager(), getConnectionReuseStrategy(), getConnectionKeepAliveStrategy(), getRoutePlanner(), getProtocolProcessor(), getHttpRequestRetryHandler(), getRedirectStrategy(), getTargetAuthenticationStrategy(), getProxyAuthenticationStrategy(), getUserTokenHandler(), httpParams);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 795 */       httpRoutePlanner = getRoutePlanner();
/* 796 */       connectionBackoffStrategy = getConnectionBackoffStrategy();
/* 797 */       backoffManager = getBackoffManager();
/*     */     } 
/*     */     
/*     */     try {
/* 801 */       if (connectionBackoffStrategy != null && backoffManager != null) {
/* 802 */         CloseableHttpResponse closeableHttpResponse; HttpHost httpHost = (paramHttpHost != null) ? paramHttpHost : (HttpHost)determineParams(paramHttpRequest).getParameter("http.default-host");
/*     */ 
/*     */         
/* 805 */         HttpRoute httpRoute = httpRoutePlanner.determineRoute(httpHost, paramHttpRequest, (HttpContext)defaultedHttpContext);
/*     */ 
/*     */         
/*     */         try {
/* 809 */           closeableHttpResponse = CloseableHttpResponseProxy.newProxy(requestDirector.execute(paramHttpHost, paramHttpRequest, (HttpContext)defaultedHttpContext));
/*     */         }
/* 811 */         catch (RuntimeException runtimeException) {
/* 812 */           if (connectionBackoffStrategy.shouldBackoff(runtimeException)) {
/* 813 */             backoffManager.backOff(httpRoute);
/*     */           }
/* 815 */           throw runtimeException;
/* 816 */         } catch (Exception exception) {
/* 817 */           if (connectionBackoffStrategy.shouldBackoff(exception)) {
/* 818 */             backoffManager.backOff(httpRoute);
/*     */           }
/* 820 */           if (exception instanceof HttpException) {
/* 821 */             throw (HttpException)exception;
/*     */           }
/* 823 */           if (exception instanceof IOException) {
/* 824 */             throw (IOException)exception;
/*     */           }
/* 826 */           throw new UndeclaredThrowableException(exception);
/*     */         } 
/* 828 */         if (connectionBackoffStrategy.shouldBackoff((HttpResponse)closeableHttpResponse)) {
/* 829 */           backoffManager.backOff(httpRoute);
/*     */         } else {
/* 831 */           backoffManager.probe(httpRoute);
/*     */         } 
/* 833 */         return closeableHttpResponse;
/*     */       } 
/* 835 */       return CloseableHttpResponseProxy.newProxy(requestDirector.execute(paramHttpHost, paramHttpRequest, (HttpContext)defaultedHttpContext));
/*     */     
/*     */     }
/* 838 */     catch (HttpException httpException) {
/* 839 */       throw new ClientProtocolException(httpException);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected RequestDirector createClientRequestDirector(HttpRequestExecutor paramHttpRequestExecutor, ClientConnectionManager paramClientConnectionManager, ConnectionReuseStrategy paramConnectionReuseStrategy, ConnectionKeepAliveStrategy paramConnectionKeepAliveStrategy, HttpRoutePlanner paramHttpRoutePlanner, HttpProcessor paramHttpProcessor, HttpRequestRetryHandler paramHttpRequestRetryHandler, RedirectHandler paramRedirectHandler, AuthenticationHandler paramAuthenticationHandler1, AuthenticationHandler paramAuthenticationHandler2, UserTokenHandler paramUserTokenHandler, HttpParams paramHttpParams) {
/* 860 */     return new DefaultRequestDirector(paramHttpRequestExecutor, paramClientConnectionManager, paramConnectionReuseStrategy, paramConnectionKeepAliveStrategy, paramHttpRoutePlanner, paramHttpProcessor, paramHttpRequestRetryHandler, paramRedirectHandler, paramAuthenticationHandler1, paramAuthenticationHandler2, paramUserTokenHandler, paramHttpParams);
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
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   protected RequestDirector createClientRequestDirector(HttpRequestExecutor paramHttpRequestExecutor, ClientConnectionManager paramClientConnectionManager, ConnectionReuseStrategy paramConnectionReuseStrategy, ConnectionKeepAliveStrategy paramConnectionKeepAliveStrategy, HttpRoutePlanner paramHttpRoutePlanner, HttpProcessor paramHttpProcessor, HttpRequestRetryHandler paramHttpRequestRetryHandler, RedirectStrategy paramRedirectStrategy, AuthenticationHandler paramAuthenticationHandler1, AuthenticationHandler paramAuthenticationHandler2, UserTokenHandler paramUserTokenHandler, HttpParams paramHttpParams) {
/* 892 */     return new DefaultRequestDirector(this.log, paramHttpRequestExecutor, paramClientConnectionManager, paramConnectionReuseStrategy, paramConnectionKeepAliveStrategy, paramHttpRoutePlanner, paramHttpProcessor, paramHttpRequestRetryHandler, paramRedirectStrategy, paramAuthenticationHandler1, paramAuthenticationHandler2, paramUserTokenHandler, paramHttpParams);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected RequestDirector createClientRequestDirector(HttpRequestExecutor paramHttpRequestExecutor, ClientConnectionManager paramClientConnectionManager, ConnectionReuseStrategy paramConnectionReuseStrategy, ConnectionKeepAliveStrategy paramConnectionKeepAliveStrategy, HttpRoutePlanner paramHttpRoutePlanner, HttpProcessor paramHttpProcessor, HttpRequestRetryHandler paramHttpRequestRetryHandler, RedirectStrategy paramRedirectStrategy, AuthenticationStrategy paramAuthenticationStrategy1, AuthenticationStrategy paramAuthenticationStrategy2, UserTokenHandler paramUserTokenHandler, HttpParams paramHttpParams) {
/* 925 */     return new DefaultRequestDirector(this.log, paramHttpRequestExecutor, paramClientConnectionManager, paramConnectionReuseStrategy, paramConnectionKeepAliveStrategy, paramHttpRoutePlanner, paramHttpProcessor, paramHttpRequestRetryHandler, paramRedirectStrategy, paramAuthenticationStrategy1, paramAuthenticationStrategy2, paramUserTokenHandler, paramHttpParams);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected HttpParams determineParams(HttpRequest paramHttpRequest) {
/* 958 */     return (HttpParams)new ClientParamsStack(null, getParams(), paramHttpRequest.getParams(), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 965 */     getConnectionManager().shutdown();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\AbstractHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */