/*     */ package org.apache.http.client.fluent;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.security.KeyManagementException;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import javax.net.ssl.SSLContext;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.auth.AuthScheme;
/*     */ import org.apache.http.auth.AuthScope;
/*     */ import org.apache.http.auth.Credentials;
/*     */ import org.apache.http.auth.MalformedChallengeException;
/*     */ import org.apache.http.auth.NTCredentials;
/*     */ import org.apache.http.auth.UsernamePasswordCredentials;
/*     */ import org.apache.http.client.AuthCache;
/*     */ import org.apache.http.client.ClientProtocolException;
/*     */ import org.apache.http.client.CookieStore;
/*     */ import org.apache.http.client.CredentialsProvider;
/*     */ import org.apache.http.client.HttpClient;
/*     */ import org.apache.http.client.protocol.HttpClientContext;
/*     */ import org.apache.http.config.Registry;
/*     */ import org.apache.http.config.RegistryBuilder;
/*     */ import org.apache.http.conn.HttpClientConnectionManager;
/*     */ import org.apache.http.conn.scheme.Scheme;
/*     */ import org.apache.http.conn.socket.PlainConnectionSocketFactory;
/*     */ import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
/*     */ import org.apache.http.conn.ssl.SSLInitializationException;
/*     */ import org.apache.http.impl.auth.BasicScheme;
/*     */ import org.apache.http.impl.client.BasicAuthCache;
/*     */ import org.apache.http.impl.client.BasicCredentialsProvider;
/*     */ import org.apache.http.impl.client.HttpClientBuilder;
/*     */ import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
/*     */ import org.apache.http.message.BasicHeader;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Executor
/*     */ {
/*     */   static final PoolingHttpClientConnectionManager CONNMGR;
/*     */   
/*     */   static {
/*  76 */     SSLConnectionSocketFactory sSLConnectionSocketFactory = null;
/*     */     try {
/*  78 */       sSLConnectionSocketFactory = SSLConnectionSocketFactory.getSystemSocketFactory();
/*  79 */     } catch (SSLInitializationException sSLInitializationException) {
/*     */ 
/*     */       
/*  82 */       try { SSLContext sSLContext = SSLContext.getInstance("TLS");
/*  83 */         sSLContext.init(null, null, null);
/*  84 */         sSLConnectionSocketFactory = new SSLConnectionSocketFactory(sSLContext); }
/*  85 */       catch (SecurityException securityException) {  }
/*  86 */       catch (KeyManagementException keyManagementException) {  }
/*  87 */       catch (NoSuchAlgorithmException noSuchAlgorithmException) {}
/*     */     } 
/*     */ 
/*     */     
/*  91 */     Registry registry = RegistryBuilder.create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", (sSLConnectionSocketFactory != null) ? sSLConnectionSocketFactory : SSLConnectionSocketFactory.getSocketFactory()).build();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  96 */     CONNMGR = new PoolingHttpClientConnectionManager(registry);
/*  97 */     CONNMGR.setDefaultMaxPerRoute(100);
/*  98 */     CONNMGR.setMaxTotal(200);
/*  99 */     CONNMGR.setValidateAfterInactivity(1000);
/* 100 */   } static final HttpClient CLIENT = (HttpClient)HttpClientBuilder.create().setConnectionManager((HttpClientConnectionManager)CONNMGR).build(); private final HttpClient httpclient;
/*     */   private volatile AuthCache authCache;
/*     */   private volatile CredentialsProvider credentialsProvider;
/*     */   private volatile CookieStore cookieStore;
/*     */   
/*     */   public static Executor newInstance() {
/* 106 */     return new Executor(CLIENT);
/*     */   }
/*     */   
/*     */   public static Executor newInstance(HttpClient paramHttpClient) {
/* 110 */     return new Executor((paramHttpClient != null) ? paramHttpClient : CLIENT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Executor(HttpClient paramHttpClient) {
/* 120 */     this.httpclient = paramHttpClient;
/* 121 */     this.authCache = (AuthCache)new BasicAuthCache();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Executor use(CredentialsProvider paramCredentialsProvider) {
/* 128 */     this.credentialsProvider = paramCredentialsProvider;
/* 129 */     return this;
/*     */   }
/*     */   
/*     */   public Executor auth(AuthScope paramAuthScope, Credentials paramCredentials) {
/* 133 */     if (this.credentialsProvider == null) {
/* 134 */       this.credentialsProvider = (CredentialsProvider)new BasicCredentialsProvider();
/*     */     }
/* 136 */     this.credentialsProvider.setCredentials(paramAuthScope, paramCredentials);
/* 137 */     return this;
/*     */   }
/*     */   
/*     */   public Executor auth(HttpHost paramHttpHost, Credentials paramCredentials) {
/* 141 */     AuthScope authScope = (paramHttpHost != null) ? new AuthScope(paramHttpHost.getHostName(), paramHttpHost.getPort()) : AuthScope.ANY;
/*     */     
/* 143 */     return auth(authScope, paramCredentials);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Executor auth(String paramString, Credentials paramCredentials) {
/* 150 */     return auth(HttpHost.create(paramString), paramCredentials);
/*     */   }
/*     */   
/*     */   public Executor authPreemptive(HttpHost paramHttpHost) {
/* 154 */     BasicScheme basicScheme = new BasicScheme();
/*     */     try {
/* 156 */       basicScheme.processChallenge((Header)new BasicHeader("WWW-Authenticate", "BASIC "));
/* 157 */     } catch (MalformedChallengeException malformedChallengeException) {}
/*     */     
/* 159 */     this.authCache.put(paramHttpHost, (AuthScheme)basicScheme);
/* 160 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Executor authPreemptive(String paramString) {
/* 167 */     return authPreemptive(HttpHost.create(paramString));
/*     */   }
/*     */   
/*     */   public Executor authPreemptiveProxy(HttpHost paramHttpHost) {
/* 171 */     BasicScheme basicScheme = new BasicScheme();
/*     */     try {
/* 173 */       basicScheme.processChallenge((Header)new BasicHeader("Proxy-Authenticate", "BASIC "));
/* 174 */     } catch (MalformedChallengeException malformedChallengeException) {}
/*     */     
/* 176 */     this.authCache.put(paramHttpHost, (AuthScheme)basicScheme);
/* 177 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Executor authPreemptiveProxy(String paramString) {
/* 184 */     return authPreemptiveProxy(HttpHost.create(paramString));
/*     */   }
/*     */   
/*     */   public Executor auth(Credentials paramCredentials) {
/* 188 */     return auth(AuthScope.ANY, paramCredentials);
/*     */   }
/*     */   
/*     */   public Executor auth(String paramString1, String paramString2) {
/* 192 */     return auth((Credentials)new UsernamePasswordCredentials(paramString1, paramString2));
/*     */   }
/*     */ 
/*     */   
/*     */   public Executor auth(String paramString1, String paramString2, String paramString3, String paramString4) {
/* 197 */     return auth((Credentials)new NTCredentials(paramString1, paramString2, paramString3, paramString4));
/*     */   }
/*     */ 
/*     */   
/*     */   public Executor auth(HttpHost paramHttpHost, String paramString1, String paramString2) {
/* 202 */     return auth(paramHttpHost, (Credentials)new UsernamePasswordCredentials(paramString1, paramString2));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Executor auth(HttpHost paramHttpHost, String paramString1, String paramString2, String paramString3, String paramString4) {
/* 208 */     return auth(paramHttpHost, (Credentials)new NTCredentials(paramString1, paramString2, paramString3, paramString4));
/*     */   }
/*     */   
/*     */   public Executor clearAuth() {
/* 212 */     if (this.credentialsProvider != null) {
/* 213 */       this.credentialsProvider.clear();
/*     */     }
/* 215 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public Executor cookieStore(CookieStore paramCookieStore) {
/* 223 */     this.cookieStore = paramCookieStore;
/* 224 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Executor use(CookieStore paramCookieStore) {
/* 231 */     this.cookieStore = paramCookieStore;
/* 232 */     return this;
/*     */   }
/*     */   
/*     */   public Executor clearCookies() {
/* 236 */     if (this.cookieStore != null) {
/* 237 */       this.cookieStore.clear();
/*     */     }
/* 239 */     return this;
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
/*     */   public Response execute(Request paramRequest) throws ClientProtocolException, IOException {
/* 252 */     HttpClientContext httpClientContext = HttpClientContext.create();
/* 253 */     if (this.credentialsProvider != null) {
/* 254 */       httpClientContext.setAttribute("http.auth.credentials-provider", this.credentialsProvider);
/*     */     }
/* 256 */     if (this.authCache != null) {
/* 257 */       httpClientContext.setAttribute("http.auth.auth-cache", this.authCache);
/*     */     }
/* 259 */     if (this.cookieStore != null) {
/* 260 */       httpClientContext.setAttribute("http.cookie-store", this.cookieStore);
/*     */     }
/* 262 */     return new Response(paramRequest.internalExecute(this.httpclient, (HttpContext)httpClientContext));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static void registerScheme(Scheme paramScheme) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static void unregisterScheme(String paramString) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void closeIdleConnections() {
/* 284 */     CONNMGR.closeIdleConnections(0L, TimeUnit.MICROSECONDS);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\fluent\Executor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */