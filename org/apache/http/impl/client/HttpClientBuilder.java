/*      */ package org.apache.http.impl.client;
/*      */ 
/*      */ import java.io.Closeable;
/*      */ import java.io.IOException;
/*      */ import java.net.ProxySelector;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import javax.net.ssl.HostnameVerifier;
/*      */ import javax.net.ssl.SSLContext;
/*      */ import javax.net.ssl.SSLSocketFactory;
/*      */ import org.apache.http.ConnectionReuseStrategy;
/*      */ import org.apache.http.Header;
/*      */ import org.apache.http.HttpHost;
/*      */ import org.apache.http.HttpRequestInterceptor;
/*      */ import org.apache.http.HttpResponseInterceptor;
/*      */ import org.apache.http.auth.AuthSchemeProvider;
/*      */ import org.apache.http.client.AuthenticationStrategy;
/*      */ import org.apache.http.client.BackoffManager;
/*      */ import org.apache.http.client.ConnectionBackoffStrategy;
/*      */ import org.apache.http.client.CookieStore;
/*      */ import org.apache.http.client.CredentialsProvider;
/*      */ import org.apache.http.client.HttpRequestRetryHandler;
/*      */ import org.apache.http.client.RedirectStrategy;
/*      */ import org.apache.http.client.ServiceUnavailableRetryStrategy;
/*      */ import org.apache.http.client.UserTokenHandler;
/*      */ import org.apache.http.client.config.RequestConfig;
/*      */ import org.apache.http.client.entity.InputStreamFactory;
/*      */ import org.apache.http.client.protocol.RequestAcceptEncoding;
/*      */ import org.apache.http.client.protocol.RequestAddCookies;
/*      */ import org.apache.http.client.protocol.RequestAuthCache;
/*      */ import org.apache.http.client.protocol.RequestClientConnControl;
/*      */ import org.apache.http.client.protocol.RequestDefaultHeaders;
/*      */ import org.apache.http.client.protocol.RequestExpectContinue;
/*      */ import org.apache.http.client.protocol.ResponseContentEncoding;
/*      */ import org.apache.http.client.protocol.ResponseProcessCookies;
/*      */ import org.apache.http.config.ConnectionConfig;
/*      */ import org.apache.http.config.Lookup;
/*      */ import org.apache.http.config.Registry;
/*      */ import org.apache.http.config.RegistryBuilder;
/*      */ import org.apache.http.config.SocketConfig;
/*      */ import org.apache.http.conn.ConnectionKeepAliveStrategy;
/*      */ import org.apache.http.conn.DnsResolver;
/*      */ import org.apache.http.conn.HttpClientConnectionManager;
/*      */ import org.apache.http.conn.SchemePortResolver;
/*      */ import org.apache.http.conn.routing.HttpRoutePlanner;
/*      */ import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
/*      */ import org.apache.http.conn.socket.PlainConnectionSocketFactory;
/*      */ import org.apache.http.conn.ssl.DefaultHostnameVerifier;
/*      */ import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
/*      */ import org.apache.http.conn.ssl.X509HostnameVerifier;
/*      */ import org.apache.http.conn.util.PublicSuffixMatcher;
/*      */ import org.apache.http.conn.util.PublicSuffixMatcherLoader;
/*      */ import org.apache.http.cookie.CookieSpecProvider;
/*      */ import org.apache.http.impl.NoConnectionReuseStrategy;
/*      */ import org.apache.http.impl.auth.BasicSchemeFactory;
/*      */ import org.apache.http.impl.auth.DigestSchemeFactory;
/*      */ import org.apache.http.impl.auth.KerberosSchemeFactory;
/*      */ import org.apache.http.impl.auth.NTLMSchemeFactory;
/*      */ import org.apache.http.impl.auth.SPNegoSchemeFactory;
/*      */ import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
/*      */ import org.apache.http.impl.conn.DefaultRoutePlanner;
/*      */ import org.apache.http.impl.conn.DefaultSchemePortResolver;
/*      */ import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
/*      */ import org.apache.http.impl.conn.SystemDefaultRoutePlanner;
/*      */ import org.apache.http.impl.execchain.BackoffStrategyExec;
/*      */ import org.apache.http.impl.execchain.ClientExecChain;
/*      */ import org.apache.http.impl.execchain.MainClientExec;
/*      */ import org.apache.http.impl.execchain.ProtocolExec;
/*      */ import org.apache.http.impl.execchain.RedirectExec;
/*      */ import org.apache.http.impl.execchain.RetryExec;
/*      */ import org.apache.http.impl.execchain.ServiceUnavailableRetryExec;
/*      */ import org.apache.http.protocol.HttpProcessor;
/*      */ import org.apache.http.protocol.HttpProcessorBuilder;
/*      */ import org.apache.http.protocol.HttpRequestExecutor;
/*      */ import org.apache.http.protocol.ImmutableHttpProcessor;
/*      */ import org.apache.http.protocol.RequestContent;
/*      */ import org.apache.http.protocol.RequestTargetHost;
/*      */ import org.apache.http.protocol.RequestUserAgent;
/*      */ import org.apache.http.ssl.SSLContexts;
/*      */ import org.apache.http.util.TextUtils;
/*      */ import org.apache.http.util.VersionInfo;
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
/*      */ public class HttpClientBuilder
/*      */ {
/*      */   private HttpRequestExecutor requestExec;
/*      */   private HostnameVerifier hostnameVerifier;
/*      */   private LayeredConnectionSocketFactory sslSocketFactory;
/*      */   private SSLContext sslContext;
/*      */   private HttpClientConnectionManager connManager;
/*      */   private boolean connManagerShared;
/*      */   private SchemePortResolver schemePortResolver;
/*      */   private ConnectionReuseStrategy reuseStrategy;
/*      */   private ConnectionKeepAliveStrategy keepAliveStrategy;
/*      */   private AuthenticationStrategy targetAuthStrategy;
/*      */   private AuthenticationStrategy proxyAuthStrategy;
/*      */   private UserTokenHandler userTokenHandler;
/*      */   private HttpProcessor httpprocessor;
/*      */   private DnsResolver dnsResolver;
/*      */   private LinkedList<HttpRequestInterceptor> requestFirst;
/*      */   private LinkedList<HttpRequestInterceptor> requestLast;
/*      */   private LinkedList<HttpResponseInterceptor> responseFirst;
/*      */   private LinkedList<HttpResponseInterceptor> responseLast;
/*      */   private HttpRequestRetryHandler retryHandler;
/*      */   private HttpRoutePlanner routePlanner;
/*      */   private RedirectStrategy redirectStrategy;
/*      */   private ConnectionBackoffStrategy connectionBackoffStrategy;
/*      */   private BackoffManager backoffManager;
/*      */   private ServiceUnavailableRetryStrategy serviceUnavailStrategy;
/*      */   private Lookup<AuthSchemeProvider> authSchemeRegistry;
/*      */   private Lookup<CookieSpecProvider> cookieSpecRegistry;
/*      */   private Map<String, InputStreamFactory> contentDecoderMap;
/*      */   private CookieStore cookieStore;
/*      */   private CredentialsProvider credentialsProvider;
/*      */   private String userAgent;
/*      */   private HttpHost proxy;
/*      */   private Collection<? extends Header> defaultHeaders;
/*      */   private SocketConfig defaultSocketConfig;
/*      */   private ConnectionConfig defaultConnectionConfig;
/*      */   private RequestConfig defaultRequestConfig;
/*      */   private boolean evictExpiredConnections;
/*      */   private boolean evictIdleConnections;
/*      */   private long maxIdleTime;
/*      */   private TimeUnit maxIdleTimeUnit;
/*      */   private boolean systemProperties;
/*      */   private boolean redirectHandlingDisabled;
/*      */   private boolean automaticRetriesDisabled;
/*      */   private boolean contentCompressionDisabled;
/*      */   private boolean cookieManagementDisabled;
/*      */   private boolean authCachingDisabled;
/*      */   private boolean connectionStateDisabled;
/*      */   private boolean defaultUserAgentDisabled;
/*  214 */   private int maxConnTotal = 0;
/*  215 */   private int maxConnPerRoute = 0;
/*      */   
/*  217 */   private long connTimeToLive = -1L;
/*  218 */   private TimeUnit connTimeToLiveTimeUnit = TimeUnit.MILLISECONDS;
/*      */   
/*      */   private List<Closeable> closeables;
/*      */   
/*      */   private PublicSuffixMatcher publicSuffixMatcher;
/*      */   
/*      */   public static HttpClientBuilder create() {
/*  225 */     return new HttpClientBuilder();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setRequestExecutor(HttpRequestExecutor paramHttpRequestExecutor) {
/*  236 */     this.requestExec = paramHttpRequestExecutor;
/*  237 */     return this;
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
/*      */   @Deprecated
/*      */   public final HttpClientBuilder setHostnameVerifier(X509HostnameVerifier paramX509HostnameVerifier) {
/*  252 */     this.hostnameVerifier = (HostnameVerifier)paramX509HostnameVerifier;
/*  253 */     return this;
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
/*      */   public final HttpClientBuilder setSSLHostnameVerifier(HostnameVerifier paramHostnameVerifier) {
/*  267 */     this.hostnameVerifier = paramHostnameVerifier;
/*  268 */     return this;
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
/*      */   public final HttpClientBuilder setPublicSuffixMatcher(PublicSuffixMatcher paramPublicSuffixMatcher) {
/*  281 */     this.publicSuffixMatcher = paramPublicSuffixMatcher;
/*  282 */     return this;
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
/*      */   @Deprecated
/*      */   public final HttpClientBuilder setSslcontext(SSLContext paramSSLContext) {
/*  297 */     return setSSLContext(paramSSLContext);
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
/*      */   public final HttpClientBuilder setSSLContext(SSLContext paramSSLContext) {
/*  309 */     this.sslContext = paramSSLContext;
/*  310 */     return this;
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
/*      */   public final HttpClientBuilder setSSLSocketFactory(LayeredConnectionSocketFactory paramLayeredConnectionSocketFactory) {
/*  322 */     this.sslSocketFactory = paramLayeredConnectionSocketFactory;
/*  323 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setMaxConnTotal(int paramInt) {
/*  334 */     this.maxConnTotal = paramInt;
/*  335 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setMaxConnPerRoute(int paramInt) {
/*  346 */     this.maxConnPerRoute = paramInt;
/*  347 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setDefaultSocketConfig(SocketConfig paramSocketConfig) {
/*  358 */     this.defaultSocketConfig = paramSocketConfig;
/*  359 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setDefaultConnectionConfig(ConnectionConfig paramConnectionConfig) {
/*  370 */     this.defaultConnectionConfig = paramConnectionConfig;
/*  371 */     return this;
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
/*      */   public final HttpClientBuilder setConnectionTimeToLive(long paramLong, TimeUnit paramTimeUnit) {
/*  384 */     this.connTimeToLive = paramLong;
/*  385 */     this.connTimeToLiveTimeUnit = paramTimeUnit;
/*  386 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setConnectionManager(HttpClientConnectionManager paramHttpClientConnectionManager) {
/*  394 */     this.connManager = paramHttpClientConnectionManager;
/*  395 */     return this;
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
/*      */   public final HttpClientBuilder setConnectionManagerShared(boolean paramBoolean) {
/*  414 */     this.connManagerShared = paramBoolean;
/*  415 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setConnectionReuseStrategy(ConnectionReuseStrategy paramConnectionReuseStrategy) {
/*  423 */     this.reuseStrategy = paramConnectionReuseStrategy;
/*  424 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setKeepAliveStrategy(ConnectionKeepAliveStrategy paramConnectionKeepAliveStrategy) {
/*  432 */     this.keepAliveStrategy = paramConnectionKeepAliveStrategy;
/*  433 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setTargetAuthenticationStrategy(AuthenticationStrategy paramAuthenticationStrategy) {
/*  442 */     this.targetAuthStrategy = paramAuthenticationStrategy;
/*  443 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setProxyAuthenticationStrategy(AuthenticationStrategy paramAuthenticationStrategy) {
/*  452 */     this.proxyAuthStrategy = paramAuthenticationStrategy;
/*  453 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setUserTokenHandler(UserTokenHandler paramUserTokenHandler) {
/*  464 */     this.userTokenHandler = paramUserTokenHandler;
/*  465 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder disableConnectionState() {
/*  472 */     this.connectionStateDisabled = true;
/*  473 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setSchemePortResolver(SchemePortResolver paramSchemePortResolver) {
/*  481 */     this.schemePortResolver = paramSchemePortResolver;
/*  482 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setUserAgent(String paramString) {
/*  493 */     this.userAgent = paramString;
/*  494 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setDefaultHeaders(Collection<? extends Header> paramCollection) {
/*  505 */     this.defaultHeaders = paramCollection;
/*  506 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder addInterceptorFirst(HttpResponseInterceptor paramHttpResponseInterceptor) {
/*  517 */     if (paramHttpResponseInterceptor == null) {
/*  518 */       return this;
/*      */     }
/*  520 */     if (this.responseFirst == null) {
/*  521 */       this.responseFirst = new LinkedList<HttpResponseInterceptor>();
/*      */     }
/*  523 */     this.responseFirst.addFirst(paramHttpResponseInterceptor);
/*  524 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder addInterceptorLast(HttpResponseInterceptor paramHttpResponseInterceptor) {
/*  535 */     if (paramHttpResponseInterceptor == null) {
/*  536 */       return this;
/*      */     }
/*  538 */     if (this.responseLast == null) {
/*  539 */       this.responseLast = new LinkedList<HttpResponseInterceptor>();
/*      */     }
/*  541 */     this.responseLast.addLast(paramHttpResponseInterceptor);
/*  542 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder addInterceptorFirst(HttpRequestInterceptor paramHttpRequestInterceptor) {
/*  552 */     if (paramHttpRequestInterceptor == null) {
/*  553 */       return this;
/*      */     }
/*  555 */     if (this.requestFirst == null) {
/*  556 */       this.requestFirst = new LinkedList<HttpRequestInterceptor>();
/*      */     }
/*  558 */     this.requestFirst.addFirst(paramHttpRequestInterceptor);
/*  559 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder addInterceptorLast(HttpRequestInterceptor paramHttpRequestInterceptor) {
/*  569 */     if (paramHttpRequestInterceptor == null) {
/*  570 */       return this;
/*      */     }
/*  572 */     if (this.requestLast == null) {
/*  573 */       this.requestLast = new LinkedList<HttpRequestInterceptor>();
/*      */     }
/*  575 */     this.requestLast.addLast(paramHttpRequestInterceptor);
/*  576 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder disableCookieManagement() {
/*  586 */     this.cookieManagementDisabled = true;
/*  587 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder disableContentCompression() {
/*  597 */     this.contentCompressionDisabled = true;
/*  598 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder disableAuthCaching() {
/*  608 */     this.authCachingDisabled = true;
/*  609 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setHttpProcessor(HttpProcessor paramHttpProcessor) {
/*  616 */     this.httpprocessor = paramHttpProcessor;
/*  617 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setDnsResolver(DnsResolver paramDnsResolver) {
/*  626 */     this.dnsResolver = paramDnsResolver;
/*  627 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setRetryHandler(HttpRequestRetryHandler paramHttpRequestRetryHandler) {
/*  637 */     this.retryHandler = paramHttpRequestRetryHandler;
/*  638 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder disableAutomaticRetries() {
/*  645 */     this.automaticRetriesDisabled = true;
/*  646 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setProxy(HttpHost paramHttpHost) {
/*  656 */     this.proxy = paramHttpHost;
/*  657 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setRoutePlanner(HttpRoutePlanner paramHttpRoutePlanner) {
/*  664 */     this.routePlanner = paramHttpRoutePlanner;
/*  665 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setRedirectStrategy(RedirectStrategy paramRedirectStrategy) {
/*  676 */     this.redirectStrategy = paramRedirectStrategy;
/*  677 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder disableRedirectHandling() {
/*  684 */     this.redirectHandlingDisabled = true;
/*  685 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setConnectionBackoffStrategy(ConnectionBackoffStrategy paramConnectionBackoffStrategy) {
/*  693 */     this.connectionBackoffStrategy = paramConnectionBackoffStrategy;
/*  694 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setBackoffManager(BackoffManager paramBackoffManager) {
/*  701 */     this.backoffManager = paramBackoffManager;
/*  702 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setServiceUnavailableRetryStrategy(ServiceUnavailableRetryStrategy paramServiceUnavailableRetryStrategy) {
/*  710 */     this.serviceUnavailStrategy = paramServiceUnavailableRetryStrategy;
/*  711 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setDefaultCookieStore(CookieStore paramCookieStore) {
/*  719 */     this.cookieStore = paramCookieStore;
/*  720 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setDefaultCredentialsProvider(CredentialsProvider paramCredentialsProvider) {
/*  730 */     this.credentialsProvider = paramCredentialsProvider;
/*  731 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setDefaultAuthSchemeRegistry(Lookup<AuthSchemeProvider> paramLookup) {
/*  741 */     this.authSchemeRegistry = paramLookup;
/*  742 */     return this;
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
/*      */   public final HttpClientBuilder setDefaultCookieSpecRegistry(Lookup<CookieSpecProvider> paramLookup) {
/*  755 */     this.cookieSpecRegistry = paramLookup;
/*  756 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setContentDecoderRegistry(Map<String, InputStreamFactory> paramMap) {
/*  766 */     this.contentDecoderMap = paramMap;
/*  767 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder setDefaultRequestConfig(RequestConfig paramRequestConfig) {
/*  776 */     this.defaultRequestConfig = paramRequestConfig;
/*  777 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder useSystemProperties() {
/*  785 */     this.systemProperties = true;
/*  786 */     return this;
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
/*      */   public final HttpClientBuilder evictExpiredConnections() {
/*  808 */     this.evictExpiredConnections = true;
/*  809 */     return this;
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
/*      */   @Deprecated
/*      */   public final HttpClientBuilder evictIdleConnections(Long paramLong, TimeUnit paramTimeUnit) {
/*  839 */     return evictIdleConnections(paramLong.longValue(), paramTimeUnit);
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
/*      */   public final HttpClientBuilder evictIdleConnections(long paramLong, TimeUnit paramTimeUnit) {
/*  866 */     this.evictIdleConnections = true;
/*  867 */     this.maxIdleTime = paramLong;
/*  868 */     this.maxIdleTimeUnit = paramTimeUnit;
/*  869 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final HttpClientBuilder disableDefaultUserAgent() {
/*  878 */     this.defaultUserAgentDisabled = true;
/*  879 */     return this;
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
/*      */   protected ClientExecChain createMainExec(HttpRequestExecutor paramHttpRequestExecutor, HttpClientConnectionManager paramHttpClientConnectionManager, ConnectionReuseStrategy paramConnectionReuseStrategy, ConnectionKeepAliveStrategy paramConnectionKeepAliveStrategy, HttpProcessor paramHttpProcessor, AuthenticationStrategy paramAuthenticationStrategy1, AuthenticationStrategy paramAuthenticationStrategy2, UserTokenHandler paramUserTokenHandler) {
/*  903 */     return (ClientExecChain)new MainClientExec(paramHttpRequestExecutor, paramHttpClientConnectionManager, paramConnectionReuseStrategy, paramConnectionKeepAliveStrategy, paramHttpProcessor, paramAuthenticationStrategy1, paramAuthenticationStrategy2, paramUserTokenHandler);
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
/*      */   protected ClientExecChain decorateMainExec(ClientExecChain paramClientExecChain) {
/*  918 */     return paramClientExecChain;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected ClientExecChain decorateProtocolExec(ClientExecChain paramClientExecChain) {
/*  925 */     return paramClientExecChain;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void addCloseable(Closeable paramCloseable) {
/*  932 */     if (paramCloseable == null) {
/*      */       return;
/*      */     }
/*  935 */     if (this.closeables == null) {
/*  936 */       this.closeables = new ArrayList<Closeable>();
/*      */     }
/*  938 */     this.closeables.add(paramCloseable);
/*      */   }
/*      */   
/*      */   private static String[] split(String paramString) {
/*  942 */     if (TextUtils.isBlank(paramString)) {
/*  943 */       return null;
/*      */     }
/*  945 */     return paramString.split(" *, *"); } public CloseableHttpClient build() { PoolingHttpClientConnectionManager poolingHttpClientConnectionManager; DefaultClientConnectionReuseStrategy defaultClientConnectionReuseStrategy; RetryExec retryExec;
/*      */     ServiceUnavailableRetryExec serviceUnavailableRetryExec;
/*      */     RedirectExec redirectExec;
/*      */     BackoffStrategyExec backoffStrategyExec;
/*      */     DefaultRoutePlanner defaultRoutePlanner;
/*      */     Registry registry;
/*  951 */     PublicSuffixMatcher publicSuffixMatcher = this.publicSuffixMatcher;
/*  952 */     if (publicSuffixMatcher == null) {
/*  953 */       publicSuffixMatcher = PublicSuffixMatcherLoader.getDefault();
/*      */     }
/*      */     
/*  956 */     HttpRequestExecutor httpRequestExecutor = this.requestExec;
/*  957 */     if (httpRequestExecutor == null) {
/*  958 */       httpRequestExecutor = new HttpRequestExecutor();
/*      */     }
/*  960 */     HttpClientConnectionManager httpClientConnectionManager = this.connManager;
/*  961 */     if (httpClientConnectionManager == null) {
/*  962 */       SSLConnectionSocketFactory sSLConnectionSocketFactory; LayeredConnectionSocketFactory layeredConnectionSocketFactory = this.sslSocketFactory;
/*  963 */       if (layeredConnectionSocketFactory == null) {
/*  964 */         DefaultHostnameVerifier defaultHostnameVerifier; String[] arrayOfString1 = this.systemProperties ? split(System.getProperty("https.protocols")) : null;
/*      */         
/*  966 */         String[] arrayOfString2 = this.systemProperties ? split(System.getProperty("https.cipherSuites")) : null;
/*      */         
/*  968 */         HostnameVerifier hostnameVerifier = this.hostnameVerifier;
/*  969 */         if (hostnameVerifier == null) {
/*  970 */           defaultHostnameVerifier = new DefaultHostnameVerifier(publicSuffixMatcher);
/*      */         }
/*  972 */         if (this.sslContext != null) {
/*  973 */           sSLConnectionSocketFactory = new SSLConnectionSocketFactory(this.sslContext, arrayOfString1, arrayOfString2, (HostnameVerifier)defaultHostnameVerifier);
/*      */         
/*      */         }
/*  976 */         else if (this.systemProperties) {
/*  977 */           sSLConnectionSocketFactory = new SSLConnectionSocketFactory((SSLSocketFactory)SSLSocketFactory.getDefault(), arrayOfString1, arrayOfString2, (HostnameVerifier)defaultHostnameVerifier);
/*      */         }
/*      */         else {
/*      */           
/*  981 */           sSLConnectionSocketFactory = new SSLConnectionSocketFactory(SSLContexts.createDefault(), (HostnameVerifier)defaultHostnameVerifier);
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  988 */       final PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(RegistryBuilder.create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", sSLConnectionSocketFactory).build(), null, null, this.dnsResolver, this.connTimeToLive, (this.connTimeToLiveTimeUnit != null) ? this.connTimeToLiveTimeUnit : TimeUnit.MILLISECONDS);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  998 */       if (this.defaultSocketConfig != null) {
/*  999 */         poolingHttpClientConnectionManager1.setDefaultSocketConfig(this.defaultSocketConfig);
/*      */       }
/* 1001 */       if (this.defaultConnectionConfig != null) {
/* 1002 */         poolingHttpClientConnectionManager1.setDefaultConnectionConfig(this.defaultConnectionConfig);
/*      */       }
/* 1004 */       if (this.systemProperties) {
/* 1005 */         String str1 = System.getProperty("http.keepAlive", "true");
/* 1006 */         if ("true".equalsIgnoreCase(str1)) {
/* 1007 */           str1 = System.getProperty("http.maxConnections", "5");
/* 1008 */           int i = Integer.parseInt(str1);
/* 1009 */           poolingHttpClientConnectionManager1.setDefaultMaxPerRoute(i);
/* 1010 */           poolingHttpClientConnectionManager1.setMaxTotal(2 * i);
/*      */         } 
/*      */       } 
/* 1013 */       if (this.maxConnTotal > 0) {
/* 1014 */         poolingHttpClientConnectionManager1.setMaxTotal(this.maxConnTotal);
/*      */       }
/* 1016 */       if (this.maxConnPerRoute > 0) {
/* 1017 */         poolingHttpClientConnectionManager1.setDefaultMaxPerRoute(this.maxConnPerRoute);
/*      */       }
/* 1019 */       poolingHttpClientConnectionManager = poolingHttpClientConnectionManager1;
/*      */     } 
/* 1021 */     ConnectionReuseStrategy connectionReuseStrategy = this.reuseStrategy;
/* 1022 */     if (connectionReuseStrategy == null) {
/* 1023 */       if (this.systemProperties) {
/* 1024 */         String str1 = System.getProperty("http.keepAlive", "true");
/* 1025 */         if ("true".equalsIgnoreCase(str1)) {
/* 1026 */           defaultClientConnectionReuseStrategy = DefaultClientConnectionReuseStrategy.INSTANCE;
/*      */         } else {
/* 1028 */           NoConnectionReuseStrategy noConnectionReuseStrategy = NoConnectionReuseStrategy.INSTANCE;
/*      */         } 
/*      */       } else {
/* 1031 */         defaultClientConnectionReuseStrategy = DefaultClientConnectionReuseStrategy.INSTANCE;
/*      */       } 
/*      */     }
/* 1034 */     ConnectionKeepAliveStrategy connectionKeepAliveStrategy = this.keepAliveStrategy;
/* 1035 */     if (connectionKeepAliveStrategy == null) {
/* 1036 */       connectionKeepAliveStrategy = DefaultConnectionKeepAliveStrategy.INSTANCE;
/*      */     }
/* 1038 */     AuthenticationStrategy authenticationStrategy1 = this.targetAuthStrategy;
/* 1039 */     if (authenticationStrategy1 == null) {
/* 1040 */       authenticationStrategy1 = TargetAuthenticationStrategy.INSTANCE;
/*      */     }
/* 1042 */     AuthenticationStrategy authenticationStrategy2 = this.proxyAuthStrategy;
/* 1043 */     if (authenticationStrategy2 == null) {
/* 1044 */       authenticationStrategy2 = ProxyAuthenticationStrategy.INSTANCE;
/*      */     }
/* 1046 */     UserTokenHandler userTokenHandler = this.userTokenHandler;
/* 1047 */     if (userTokenHandler == null) {
/* 1048 */       if (!this.connectionStateDisabled) {
/* 1049 */         userTokenHandler = DefaultUserTokenHandler.INSTANCE;
/*      */       } else {
/* 1051 */         userTokenHandler = NoopUserTokenHandler.INSTANCE;
/*      */       } 
/*      */     }
/*      */     
/* 1055 */     String str = this.userAgent;
/* 1056 */     if (str == null) {
/* 1057 */       if (this.systemProperties) {
/* 1058 */         str = System.getProperty("http.agent");
/*      */       }
/* 1060 */       if (str == null && !this.defaultUserAgentDisabled) {
/* 1061 */         str = VersionInfo.getUserAgent("Apache-HttpClient", "org.apache.http.client", getClass());
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1066 */     ClientExecChain clientExecChain2 = createMainExec(httpRequestExecutor, (HttpClientConnectionManager)poolingHttpClientConnectionManager, (ConnectionReuseStrategy)defaultClientConnectionReuseStrategy, connectionKeepAliveStrategy, (HttpProcessor)new ImmutableHttpProcessor(new HttpRequestInterceptor[] { (HttpRequestInterceptor)new RequestTargetHost(), (HttpRequestInterceptor)new RequestUserAgent(str) }, ), authenticationStrategy1, authenticationStrategy2, userTokenHandler);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1076 */     clientExecChain2 = decorateMainExec(clientExecChain2);
/*      */     
/* 1078 */     HttpProcessor httpProcessor = this.httpprocessor;
/* 1079 */     if (httpProcessor == null) {
/*      */       
/* 1081 */       HttpProcessorBuilder httpProcessorBuilder = HttpProcessorBuilder.create();
/* 1082 */       if (this.requestFirst != null) {
/* 1083 */         for (HttpRequestInterceptor httpRequestInterceptor : this.requestFirst) {
/* 1084 */           httpProcessorBuilder.addFirst(httpRequestInterceptor);
/*      */         }
/*      */       }
/* 1087 */       if (this.responseFirst != null) {
/* 1088 */         for (HttpResponseInterceptor httpResponseInterceptor : this.responseFirst) {
/* 1089 */           httpProcessorBuilder.addFirst(httpResponseInterceptor);
/*      */         }
/*      */       }
/* 1092 */       httpProcessorBuilder.addAll(new HttpRequestInterceptor[] { (HttpRequestInterceptor)new RequestDefaultHeaders(this.defaultHeaders), (HttpRequestInterceptor)new RequestContent(), (HttpRequestInterceptor)new RequestTargetHost(), (HttpRequestInterceptor)new RequestClientConnControl(), (HttpRequestInterceptor)new RequestUserAgent(str), (HttpRequestInterceptor)new RequestExpectContinue() });
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1099 */       if (!this.cookieManagementDisabled) {
/* 1100 */         httpProcessorBuilder.add((HttpRequestInterceptor)new RequestAddCookies());
/*      */       }
/* 1102 */       if (!this.contentCompressionDisabled) {
/* 1103 */         if (this.contentDecoderMap != null) {
/* 1104 */           ArrayList<Comparable> arrayList1 = new ArrayList(this.contentDecoderMap.keySet());
/* 1105 */           Collections.sort(arrayList1);
/* 1106 */           httpProcessorBuilder.add((HttpRequestInterceptor)new RequestAcceptEncoding(arrayList1));
/*      */         } else {
/* 1108 */           httpProcessorBuilder.add((HttpRequestInterceptor)new RequestAcceptEncoding());
/*      */         } 
/*      */       }
/* 1111 */       if (!this.authCachingDisabled) {
/* 1112 */         httpProcessorBuilder.add((HttpRequestInterceptor)new RequestAuthCache());
/*      */       }
/* 1114 */       if (!this.cookieManagementDisabled) {
/* 1115 */         httpProcessorBuilder.add((HttpResponseInterceptor)new ResponseProcessCookies());
/*      */       }
/* 1117 */       if (!this.contentCompressionDisabled) {
/* 1118 */         if (this.contentDecoderMap != null) {
/* 1119 */           RegistryBuilder registryBuilder = RegistryBuilder.create();
/* 1120 */           for (Map.Entry<String, InputStreamFactory> entry : this.contentDecoderMap.entrySet()) {
/* 1121 */             registryBuilder.register((String)entry.getKey(), entry.getValue());
/*      */           }
/* 1123 */           httpProcessorBuilder.add((HttpResponseInterceptor)new ResponseContentEncoding((Lookup)registryBuilder.build()));
/*      */         } else {
/* 1125 */           httpProcessorBuilder.add((HttpResponseInterceptor)new ResponseContentEncoding());
/*      */         } 
/*      */       }
/* 1128 */       if (this.requestLast != null) {
/* 1129 */         for (HttpRequestInterceptor httpRequestInterceptor : this.requestLast) {
/* 1130 */           httpProcessorBuilder.addLast(httpRequestInterceptor);
/*      */         }
/*      */       }
/* 1133 */       if (this.responseLast != null) {
/* 1134 */         for (HttpResponseInterceptor httpResponseInterceptor : this.responseLast) {
/* 1135 */           httpProcessorBuilder.addLast(httpResponseInterceptor);
/*      */         }
/*      */       }
/* 1138 */       httpProcessor = httpProcessorBuilder.build();
/*      */     } 
/* 1140 */     ProtocolExec protocolExec = new ProtocolExec(clientExecChain2, httpProcessor);
/*      */     
/* 1142 */     ClientExecChain clientExecChain1 = decorateProtocolExec((ClientExecChain)protocolExec);
/*      */ 
/*      */     
/* 1145 */     if (!this.automaticRetriesDisabled) {
/* 1146 */       HttpRequestRetryHandler httpRequestRetryHandler = this.retryHandler;
/* 1147 */       if (httpRequestRetryHandler == null) {
/* 1148 */         httpRequestRetryHandler = DefaultHttpRequestRetryHandler.INSTANCE;
/*      */       }
/* 1150 */       retryExec = new RetryExec(clientExecChain1, httpRequestRetryHandler);
/*      */     } 
/*      */     
/* 1153 */     HttpRoutePlanner httpRoutePlanner = this.routePlanner;
/* 1154 */     if (httpRoutePlanner == null) {
/* 1155 */       DefaultSchemePortResolver defaultSchemePortResolver; SchemePortResolver schemePortResolver = this.schemePortResolver;
/* 1156 */       if (schemePortResolver == null) {
/* 1157 */         defaultSchemePortResolver = DefaultSchemePortResolver.INSTANCE;
/*      */       }
/* 1159 */       if (this.proxy != null) {
/* 1160 */         DefaultProxyRoutePlanner defaultProxyRoutePlanner = new DefaultProxyRoutePlanner(this.proxy, (SchemePortResolver)defaultSchemePortResolver);
/* 1161 */       } else if (this.systemProperties) {
/* 1162 */         SystemDefaultRoutePlanner systemDefaultRoutePlanner = new SystemDefaultRoutePlanner((SchemePortResolver)defaultSchemePortResolver, ProxySelector.getDefault());
/*      */       } else {
/*      */         
/* 1165 */         defaultRoutePlanner = new DefaultRoutePlanner((SchemePortResolver)defaultSchemePortResolver);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1170 */     ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy = this.serviceUnavailStrategy;
/* 1171 */     if (serviceUnavailableRetryStrategy != null) {
/* 1172 */       serviceUnavailableRetryExec = new ServiceUnavailableRetryExec((ClientExecChain)retryExec, serviceUnavailableRetryStrategy);
/*      */     }
/*      */ 
/*      */     
/* 1176 */     if (!this.redirectHandlingDisabled) {
/* 1177 */       RedirectStrategy redirectStrategy = this.redirectStrategy;
/* 1178 */       if (redirectStrategy == null) {
/* 1179 */         redirectStrategy = DefaultRedirectStrategy.INSTANCE;
/*      */       }
/* 1181 */       redirectExec = new RedirectExec((ClientExecChain)serviceUnavailableRetryExec, (HttpRoutePlanner)defaultRoutePlanner, redirectStrategy);
/*      */     } 
/*      */ 
/*      */     
/* 1185 */     if (this.backoffManager != null && this.connectionBackoffStrategy != null) {
/* 1186 */       backoffStrategyExec = new BackoffStrategyExec((ClientExecChain)redirectExec, this.connectionBackoffStrategy, this.backoffManager);
/*      */     }
/*      */     
/* 1189 */     Lookup<AuthSchemeProvider> lookup = this.authSchemeRegistry;
/* 1190 */     if (lookup == null) {
/* 1191 */       registry = RegistryBuilder.create().register("Basic", new BasicSchemeFactory()).register("Digest", new DigestSchemeFactory()).register("NTLM", new NTLMSchemeFactory()).register("Negotiate", new SPNegoSchemeFactory()).register("Kerberos", new KerberosSchemeFactory()).build();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1199 */     Lookup<CookieSpecProvider> lookup1 = this.cookieSpecRegistry;
/* 1200 */     if (lookup1 == null) {
/* 1201 */       lookup1 = CookieSpecRegistries.createDefault(publicSuffixMatcher);
/*      */     }
/*      */     
/* 1204 */     CookieStore cookieStore = this.cookieStore;
/* 1205 */     if (cookieStore == null) {
/* 1206 */       cookieStore = new BasicCookieStore();
/*      */     }
/*      */     
/* 1209 */     CredentialsProvider credentialsProvider = this.credentialsProvider;
/* 1210 */     if (credentialsProvider == null) {
/* 1211 */       if (this.systemProperties) {
/* 1212 */         credentialsProvider = new SystemDefaultCredentialsProvider();
/*      */       } else {
/* 1214 */         credentialsProvider = new BasicCredentialsProvider();
/*      */       } 
/*      */     }
/*      */     
/* 1218 */     ArrayList<Closeable> arrayList = (this.closeables != null) ? new ArrayList<Closeable>(this.closeables) : null;
/* 1219 */     if (!this.connManagerShared) {
/* 1220 */       if (arrayList == null) {
/* 1221 */         arrayList = new ArrayList(1);
/*      */       }
/* 1223 */       final PoolingHttpClientConnectionManager cm = poolingHttpClientConnectionManager;
/*      */       
/* 1225 */       if (this.evictExpiredConnections || this.evictIdleConnections) {
/* 1226 */         final IdleConnectionEvictor connectionEvictor = new IdleConnectionEvictor((HttpClientConnectionManager)poolingHttpClientConnectionManager1, (this.maxIdleTime > 0L) ? this.maxIdleTime : 10L, (this.maxIdleTimeUnit != null) ? this.maxIdleTimeUnit : TimeUnit.SECONDS, this.maxIdleTime, this.maxIdleTimeUnit);
/*      */ 
/*      */         
/* 1229 */         arrayList.add(new Closeable()
/*      */             {
/*      */               public void close() throws IOException
/*      */               {
/* 1233 */                 connectionEvictor.shutdown();
/*      */                 try {
/* 1235 */                   connectionEvictor.awaitTermination(1L, TimeUnit.SECONDS);
/* 1236 */                 } catch (InterruptedException interruptedException) {
/* 1237 */                   Thread.currentThread().interrupt();
/*      */                 } 
/*      */               }
/*      */             });
/*      */         
/* 1242 */         idleConnectionEvictor.start();
/*      */       } 
/* 1244 */       arrayList.add(new Closeable()
/*      */           {
/*      */             public void close() throws IOException
/*      */             {
/* 1248 */               cm.shutdown();
/*      */             }
/*      */           });
/*      */     } 
/*      */ 
/*      */     
/* 1254 */     return new InternalHttpClient((ClientExecChain)backoffStrategyExec, (HttpClientConnectionManager)poolingHttpClientConnectionManager, (HttpRoutePlanner)defaultRoutePlanner, lookup1, (Lookup<AuthSchemeProvider>)registry, cookieStore, credentialsProvider, (this.defaultRequestConfig != null) ? this.defaultRequestConfig : RequestConfig.DEFAULT, arrayList); }
/*      */ 
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\HttpClientBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */