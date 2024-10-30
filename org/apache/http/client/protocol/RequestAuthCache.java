/*     */ package org.apache.http.client.protocol;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpRequestInterceptor;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.auth.AuthProtocolState;
/*     */ import org.apache.http.auth.AuthScheme;
/*     */ import org.apache.http.auth.AuthScope;
/*     */ import org.apache.http.auth.AuthState;
/*     */ import org.apache.http.auth.Credentials;
/*     */ import org.apache.http.client.AuthCache;
/*     */ import org.apache.http.client.CredentialsProvider;
/*     */ import org.apache.http.conn.routing.RouteInfo;
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
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class RequestAuthCache
/*     */   implements HttpRequestInterceptor
/*     */ {
/*  61 */   private final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException, IOException {
/*  70 */     Args.notNull(paramHttpRequest, "HTTP request");
/*  71 */     Args.notNull(paramHttpContext, "HTTP context");
/*     */     
/*  73 */     HttpClientContext httpClientContext = HttpClientContext.adapt(paramHttpContext);
/*     */     
/*  75 */     AuthCache authCache = httpClientContext.getAuthCache();
/*  76 */     if (authCache == null) {
/*  77 */       this.log.debug("Auth cache not set in the context");
/*     */       
/*     */       return;
/*     */     } 
/*  81 */     CredentialsProvider credentialsProvider = httpClientContext.getCredentialsProvider();
/*  82 */     if (credentialsProvider == null) {
/*  83 */       this.log.debug("Credentials provider not set in the context");
/*     */       
/*     */       return;
/*     */     } 
/*  87 */     RouteInfo routeInfo = httpClientContext.getHttpRoute();
/*  88 */     if (routeInfo == null) {
/*  89 */       this.log.debug("Route info not set in the context");
/*     */       
/*     */       return;
/*     */     } 
/*  93 */     HttpHost httpHost1 = httpClientContext.getTargetHost();
/*  94 */     if (httpHost1 == null) {
/*  95 */       this.log.debug("Target host not set in the context");
/*     */       
/*     */       return;
/*     */     } 
/*  99 */     if (httpHost1.getPort() < 0) {
/* 100 */       httpHost1 = new HttpHost(httpHost1.getHostName(), routeInfo.getTargetHost().getPort(), httpHost1.getSchemeName());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     AuthState authState1 = httpClientContext.getTargetAuthState();
/* 107 */     if (authState1 != null && authState1.getState() == AuthProtocolState.UNCHALLENGED) {
/* 108 */       AuthScheme authScheme = authCache.get(httpHost1);
/* 109 */       if (authScheme != null) {
/* 110 */         doPreemptiveAuth(httpHost1, authScheme, authState1, credentialsProvider);
/*     */       }
/*     */     } 
/*     */     
/* 114 */     HttpHost httpHost2 = routeInfo.getProxyHost();
/* 115 */     AuthState authState2 = httpClientContext.getProxyAuthState();
/* 116 */     if (httpHost2 != null && authState2 != null && authState2.getState() == AuthProtocolState.UNCHALLENGED) {
/* 117 */       AuthScheme authScheme = authCache.get(httpHost2);
/* 118 */       if (authScheme != null) {
/* 119 */         doPreemptiveAuth(httpHost2, authScheme, authState2, credentialsProvider);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void doPreemptiveAuth(HttpHost paramHttpHost, AuthScheme paramAuthScheme, AuthState paramAuthState, CredentialsProvider paramCredentialsProvider) {
/* 129 */     String str = paramAuthScheme.getSchemeName();
/* 130 */     if (this.log.isDebugEnabled()) {
/* 131 */       this.log.debug("Re-using cached '" + str + "' auth scheme for " + paramHttpHost);
/*     */     }
/*     */     
/* 134 */     AuthScope authScope = new AuthScope(paramHttpHost, AuthScope.ANY_REALM, str);
/* 135 */     Credentials credentials = paramCredentialsProvider.getCredentials(authScope);
/*     */     
/* 137 */     if (credentials != null) {
/* 138 */       paramAuthState.update(paramAuthScheme, credentials);
/*     */     } else {
/* 140 */       this.log.debug("No credentials for preemptive authentication");
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\protocol\RequestAuthCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */