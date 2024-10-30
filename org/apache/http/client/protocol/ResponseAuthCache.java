/*     */ package org.apache.http.client.protocol;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.HttpResponseInterceptor;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.auth.AuthProtocolState;
/*     */ import org.apache.http.auth.AuthScheme;
/*     */ import org.apache.http.auth.AuthState;
/*     */ import org.apache.http.client.AuthCache;
/*     */ import org.apache.http.conn.scheme.Scheme;
/*     */ import org.apache.http.conn.scheme.SchemeRegistry;
/*     */ import org.apache.http.impl.client.BasicAuthCache;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class ResponseAuthCache
/*     */   implements HttpResponseInterceptor
/*     */ {
/*  65 */   private final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws HttpException, IOException {
/*     */     BasicAuthCache basicAuthCache;
/*  74 */     Args.notNull(paramHttpResponse, "HTTP request");
/*  75 */     Args.notNull(paramHttpContext, "HTTP context");
/*  76 */     AuthCache authCache = (AuthCache)paramHttpContext.getAttribute("http.auth.auth-cache");
/*     */     
/*  78 */     HttpHost httpHost1 = (HttpHost)paramHttpContext.getAttribute("http.target_host");
/*  79 */     AuthState authState1 = (AuthState)paramHttpContext.getAttribute("http.auth.target-scope");
/*  80 */     if (httpHost1 != null && authState1 != null) {
/*  81 */       if (this.log.isDebugEnabled()) {
/*  82 */         this.log.debug("Target auth state: " + authState1.getState());
/*     */       }
/*  84 */       if (isCachable(authState1)) {
/*  85 */         SchemeRegistry schemeRegistry = (SchemeRegistry)paramHttpContext.getAttribute("http.scheme-registry");
/*     */         
/*  87 */         if (httpHost1.getPort() < 0) {
/*  88 */           Scheme scheme = schemeRegistry.getScheme(httpHost1);
/*  89 */           httpHost1 = new HttpHost(httpHost1.getHostName(), scheme.resolvePort(httpHost1.getPort()), httpHost1.getSchemeName());
/*     */         } 
/*     */         
/*  92 */         if (authCache == null) {
/*  93 */           basicAuthCache = new BasicAuthCache();
/*  94 */           paramHttpContext.setAttribute("http.auth.auth-cache", basicAuthCache);
/*     */         } 
/*  96 */         switch (authState1.getState()) {
/*     */           case CHALLENGED:
/*  98 */             cache((AuthCache)basicAuthCache, httpHost1, authState1.getAuthScheme());
/*     */             break;
/*     */           case FAILURE:
/* 101 */             uncache((AuthCache)basicAuthCache, httpHost1, authState1.getAuthScheme());
/*     */             break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 106 */     HttpHost httpHost2 = (HttpHost)paramHttpContext.getAttribute("http.proxy_host");
/* 107 */     AuthState authState2 = (AuthState)paramHttpContext.getAttribute("http.auth.proxy-scope");
/* 108 */     if (httpHost2 != null && authState2 != null) {
/* 109 */       if (this.log.isDebugEnabled()) {
/* 110 */         this.log.debug("Proxy auth state: " + authState2.getState());
/*     */       }
/* 112 */       if (isCachable(authState2)) {
/* 113 */         if (basicAuthCache == null) {
/* 114 */           basicAuthCache = new BasicAuthCache();
/* 115 */           paramHttpContext.setAttribute("http.auth.auth-cache", basicAuthCache);
/*     */         } 
/* 117 */         switch (authState2.getState()) {
/*     */           case CHALLENGED:
/* 119 */             cache((AuthCache)basicAuthCache, httpHost2, authState2.getAuthScheme());
/*     */             break;
/*     */           case FAILURE:
/* 122 */             uncache((AuthCache)basicAuthCache, httpHost2, authState2.getAuthScheme());
/*     */             break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   private boolean isCachable(AuthState paramAuthState) {
/* 129 */     AuthScheme authScheme = paramAuthState.getAuthScheme();
/* 130 */     if (authScheme == null || !authScheme.isComplete()) {
/* 131 */       return false;
/*     */     }
/* 133 */     String str = authScheme.getSchemeName();
/* 134 */     return (str.equalsIgnoreCase("Basic") || str.equalsIgnoreCase("Digest"));
/*     */   }
/*     */ 
/*     */   
/*     */   private void cache(AuthCache paramAuthCache, HttpHost paramHttpHost, AuthScheme paramAuthScheme) {
/* 139 */     if (this.log.isDebugEnabled()) {
/* 140 */       this.log.debug("Caching '" + paramAuthScheme.getSchemeName() + "' auth scheme for " + paramHttpHost);
/*     */     }
/*     */     
/* 143 */     paramAuthCache.put(paramHttpHost, paramAuthScheme);
/*     */   }
/*     */   
/*     */   private void uncache(AuthCache paramAuthCache, HttpHost paramHttpHost, AuthScheme paramAuthScheme) {
/* 147 */     if (this.log.isDebugEnabled()) {
/* 148 */       this.log.debug("Removing from cache '" + paramAuthScheme.getSchemeName() + "' auth scheme for " + paramHttpHost);
/*     */     }
/*     */     
/* 151 */     paramAuthCache.remove(paramHttpHost);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\protocol\ResponseAuthCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */