/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.util.LinkedList;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Queue;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.auth.AuthOption;
/*     */ import org.apache.http.auth.AuthScheme;
/*     */ import org.apache.http.auth.AuthScope;
/*     */ import org.apache.http.auth.AuthenticationException;
/*     */ import org.apache.http.auth.Credentials;
/*     */ import org.apache.http.auth.MalformedChallengeException;
/*     */ import org.apache.http.client.AuthCache;
/*     */ import org.apache.http.client.AuthenticationHandler;
/*     */ import org.apache.http.client.AuthenticationStrategy;
/*     */ import org.apache.http.client.CredentialsProvider;
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
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ class AuthenticationStrategyAdaptor
/*     */   implements AuthenticationStrategy
/*     */ {
/*  64 */   private final Log log = LogFactory.getLog(getClass());
/*     */   
/*     */   private final AuthenticationHandler handler;
/*     */ 
/*     */   
/*     */   public AuthenticationStrategyAdaptor(AuthenticationHandler paramAuthenticationHandler) {
/*  70 */     this.handler = paramAuthenticationHandler;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAuthenticationRequested(HttpHost paramHttpHost, HttpResponse paramHttpResponse, HttpContext paramHttpContext) {
/*  78 */     return this.handler.isAuthenticationRequested(paramHttpResponse, paramHttpContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, Header> getChallenges(HttpHost paramHttpHost, HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws MalformedChallengeException {
/*  86 */     return this.handler.getChallenges(paramHttpResponse, paramHttpContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Queue<AuthOption> select(Map<String, Header> paramMap, HttpHost paramHttpHost, HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws MalformedChallengeException {
/*     */     AuthScheme authScheme;
/*  95 */     Args.notNull(paramMap, "Map of auth challenges");
/*  96 */     Args.notNull(paramHttpHost, "Host");
/*  97 */     Args.notNull(paramHttpResponse, "HTTP response");
/*  98 */     Args.notNull(paramHttpContext, "HTTP context");
/*     */     
/* 100 */     LinkedList<AuthOption> linkedList = new LinkedList();
/* 101 */     CredentialsProvider credentialsProvider = (CredentialsProvider)paramHttpContext.getAttribute("http.auth.credentials-provider");
/*     */     
/* 103 */     if (credentialsProvider == null) {
/* 104 */       this.log.debug("Credentials provider not set in the context");
/* 105 */       return linkedList;
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 110 */       authScheme = this.handler.selectScheme(paramMap, paramHttpResponse, paramHttpContext);
/* 111 */     } catch (AuthenticationException authenticationException) {
/* 112 */       if (this.log.isWarnEnabled()) {
/* 113 */         this.log.warn(authenticationException.getMessage(), (Throwable)authenticationException);
/*     */       }
/* 115 */       return linkedList;
/*     */     } 
/* 117 */     String str = authScheme.getSchemeName();
/* 118 */     Header header = paramMap.get(str.toLowerCase(Locale.ROOT));
/* 119 */     authScheme.processChallenge(header);
/*     */     
/* 121 */     AuthScope authScope = new AuthScope(paramHttpHost.getHostName(), paramHttpHost.getPort(), authScheme.getRealm(), authScheme.getSchemeName());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 127 */     Credentials credentials = credentialsProvider.getCredentials(authScope);
/* 128 */     if (credentials != null) {
/* 129 */       linkedList.add(new AuthOption(authScheme, credentials));
/*     */     }
/* 131 */     return linkedList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void authSucceeded(HttpHost paramHttpHost, AuthScheme paramAuthScheme, HttpContext paramHttpContext) {
/* 137 */     AuthCache authCache = (AuthCache)paramHttpContext.getAttribute("http.auth.auth-cache");
/* 138 */     if (isCachable(paramAuthScheme)) {
/* 139 */       if (authCache == null) {
/* 140 */         authCache = new BasicAuthCache();
/* 141 */         paramHttpContext.setAttribute("http.auth.auth-cache", authCache);
/*     */       } 
/* 143 */       if (this.log.isDebugEnabled()) {
/* 144 */         this.log.debug("Caching '" + paramAuthScheme.getSchemeName() + "' auth scheme for " + paramHttpHost);
/*     */       }
/*     */       
/* 147 */       authCache.put(paramHttpHost, paramAuthScheme);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void authFailed(HttpHost paramHttpHost, AuthScheme paramAuthScheme, HttpContext paramHttpContext) {
/* 154 */     AuthCache authCache = (AuthCache)paramHttpContext.getAttribute("http.auth.auth-cache");
/* 155 */     if (authCache == null) {
/*     */       return;
/*     */     }
/* 158 */     if (this.log.isDebugEnabled()) {
/* 159 */       this.log.debug("Removing from cache '" + paramAuthScheme.getSchemeName() + "' auth scheme for " + paramHttpHost);
/*     */     }
/*     */     
/* 162 */     authCache.remove(paramHttpHost);
/*     */   }
/*     */   
/*     */   private boolean isCachable(AuthScheme paramAuthScheme) {
/* 166 */     if (paramAuthScheme == null || !paramAuthScheme.isComplete()) {
/* 167 */       return false;
/*     */     }
/* 169 */     String str = paramAuthScheme.getSchemeName();
/* 170 */     return str.equalsIgnoreCase("Basic");
/*     */   }
/*     */   
/*     */   public AuthenticationHandler getHandler() {
/* 174 */     return this.handler;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\AuthenticationStrategyAdaptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */