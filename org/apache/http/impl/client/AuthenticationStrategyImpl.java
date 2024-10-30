/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Queue;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.FormattedHeader;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.auth.AuthOption;
/*     */ import org.apache.http.auth.AuthScheme;
/*     */ import org.apache.http.auth.AuthSchemeProvider;
/*     */ import org.apache.http.auth.AuthScope;
/*     */ import org.apache.http.auth.Credentials;
/*     */ import org.apache.http.auth.MalformedChallengeException;
/*     */ import org.apache.http.client.AuthCache;
/*     */ import org.apache.http.client.AuthenticationStrategy;
/*     */ import org.apache.http.client.CredentialsProvider;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.client.protocol.HttpClientContext;
/*     */ import org.apache.http.config.Lookup;
/*     */ import org.apache.http.protocol.HTTP;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.CharArrayBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ abstract class AuthenticationStrategyImpl
/*     */   implements AuthenticationStrategy
/*     */ {
/*  69 */   private final Log log = LogFactory.getLog(getClass());
/*     */   
/*  71 */   private static final List<String> DEFAULT_SCHEME_PRIORITY = Collections.unmodifiableList(Arrays.asList(new String[] { "Negotiate", "Kerberos", "NTLM", "CredSSP", "Digest", "Basic" }));
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int challengeCode;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String headerName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   AuthenticationStrategyImpl(int paramInt, String paramString) {
/*  88 */     this.challengeCode = paramInt;
/*  89 */     this.headerName = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAuthenticationRequested(HttpHost paramHttpHost, HttpResponse paramHttpResponse, HttpContext paramHttpContext) {
/*  97 */     Args.notNull(paramHttpResponse, "HTTP response");
/*  98 */     int i = paramHttpResponse.getStatusLine().getStatusCode();
/*  99 */     return (i == this.challengeCode);
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
/*     */   public Map<String, Header> getChallenges(HttpHost paramHttpHost, HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws MalformedChallengeException {
/* 112 */     Args.notNull(paramHttpResponse, "HTTP response");
/* 113 */     Header[] arrayOfHeader = paramHttpResponse.getHeaders(this.headerName);
/* 114 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>(arrayOfHeader.length);
/* 115 */     for (Header header : arrayOfHeader) {
/*     */       CharArrayBuffer charArrayBuffer;
/*     */       byte b1;
/* 118 */       if (header instanceof FormattedHeader) {
/* 119 */         charArrayBuffer = ((FormattedHeader)header).getBuffer();
/* 120 */         b1 = ((FormattedHeader)header).getValuePos();
/*     */       } else {
/* 122 */         String str1 = header.getValue();
/* 123 */         if (str1 == null) {
/* 124 */           throw new MalformedChallengeException("Header value is null");
/*     */         }
/* 126 */         charArrayBuffer = new CharArrayBuffer(str1.length());
/* 127 */         charArrayBuffer.append(str1);
/* 128 */         b1 = 0;
/*     */       } 
/* 130 */       while (b1 < charArrayBuffer.length() && HTTP.isWhitespace(charArrayBuffer.charAt(b1))) {
/* 131 */         b1++;
/*     */       }
/* 133 */       byte b2 = b1;
/* 134 */       while (b1 < charArrayBuffer.length() && !HTTP.isWhitespace(charArrayBuffer.charAt(b1))) {
/* 135 */         b1++;
/*     */       }
/* 137 */       byte b3 = b1;
/* 138 */       String str = charArrayBuffer.substring(b2, b3);
/* 139 */       hashMap.put(str.toLowerCase(Locale.ROOT), header);
/*     */     } 
/* 141 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   abstract Collection<String> getPreferredAuthSchemes(RequestConfig paramRequestConfig);
/*     */ 
/*     */ 
/*     */   
/*     */   public Queue<AuthOption> select(Map<String, Header> paramMap, HttpHost paramHttpHost, HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws MalformedChallengeException {
/* 152 */     Args.notNull(paramMap, "Map of auth challenges");
/* 153 */     Args.notNull(paramHttpHost, "Host");
/* 154 */     Args.notNull(paramHttpResponse, "HTTP response");
/* 155 */     Args.notNull(paramHttpContext, "HTTP context");
/* 156 */     HttpClientContext httpClientContext = HttpClientContext.adapt(paramHttpContext);
/*     */     
/* 158 */     LinkedList<AuthOption> linkedList = new LinkedList();
/* 159 */     Lookup lookup = httpClientContext.getAuthSchemeRegistry();
/* 160 */     if (lookup == null) {
/* 161 */       this.log.debug("Auth scheme registry not set in the context");
/* 162 */       return linkedList;
/*     */     } 
/* 164 */     CredentialsProvider credentialsProvider = httpClientContext.getCredentialsProvider();
/* 165 */     if (credentialsProvider == null) {
/* 166 */       this.log.debug("Credentials provider not set in the context");
/* 167 */       return linkedList;
/*     */     } 
/* 169 */     RequestConfig requestConfig = httpClientContext.getRequestConfig();
/* 170 */     Collection<String> collection = getPreferredAuthSchemes(requestConfig);
/* 171 */     if (collection == null) {
/* 172 */       collection = DEFAULT_SCHEME_PRIORITY;
/*     */     }
/* 174 */     if (this.log.isDebugEnabled()) {
/* 175 */       this.log.debug("Authentication schemes in the order of preference: " + collection);
/*     */     }
/*     */     
/* 178 */     for (String str : collection) {
/* 179 */       Header header = paramMap.get(str.toLowerCase(Locale.ROOT));
/* 180 */       if (header != null) {
/* 181 */         AuthSchemeProvider authSchemeProvider = (AuthSchemeProvider)lookup.lookup(str);
/* 182 */         if (authSchemeProvider == null) {
/* 183 */           if (this.log.isWarnEnabled()) {
/* 184 */             this.log.warn("Authentication scheme " + str + " not supported");
/*     */           }
/*     */           
/*     */           continue;
/*     */         } 
/* 189 */         AuthScheme authScheme = authSchemeProvider.create(paramHttpContext);
/* 190 */         authScheme.processChallenge(header);
/*     */         
/* 192 */         AuthScope authScope = new AuthScope(paramHttpHost, authScheme.getRealm(), authScheme.getSchemeName());
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 197 */         Credentials credentials = credentialsProvider.getCredentials(authScope);
/* 198 */         if (credentials != null)
/* 199 */           linkedList.add(new AuthOption(authScheme, credentials)); 
/*     */         continue;
/*     */       } 
/* 202 */       if (this.log.isDebugEnabled()) {
/* 203 */         this.log.debug("Challenge for " + str + " authentication scheme not available");
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 208 */     return linkedList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void authSucceeded(HttpHost paramHttpHost, AuthScheme paramAuthScheme, HttpContext paramHttpContext) {
/* 214 */     Args.notNull(paramHttpHost, "Host");
/* 215 */     Args.notNull(paramAuthScheme, "Auth scheme");
/* 216 */     Args.notNull(paramHttpContext, "HTTP context");
/*     */     
/* 218 */     HttpClientContext httpClientContext = HttpClientContext.adapt(paramHttpContext);
/*     */     
/* 220 */     if (isCachable(paramAuthScheme)) {
/* 221 */       AuthCache authCache = httpClientContext.getAuthCache();
/* 222 */       if (authCache == null) {
/* 223 */         authCache = new BasicAuthCache();
/* 224 */         httpClientContext.setAuthCache(authCache);
/*     */       } 
/* 226 */       if (this.log.isDebugEnabled()) {
/* 227 */         this.log.debug("Caching '" + paramAuthScheme.getSchemeName() + "' auth scheme for " + paramHttpHost);
/*     */       }
/*     */       
/* 230 */       authCache.put(paramHttpHost, paramAuthScheme);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected boolean isCachable(AuthScheme paramAuthScheme) {
/* 235 */     if (paramAuthScheme == null || !paramAuthScheme.isComplete()) {
/* 236 */       return false;
/*     */     }
/* 238 */     String str = paramAuthScheme.getSchemeName();
/* 239 */     return str.equalsIgnoreCase("Basic");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void authFailed(HttpHost paramHttpHost, AuthScheme paramAuthScheme, HttpContext paramHttpContext) {
/* 245 */     Args.notNull(paramHttpHost, "Host");
/* 246 */     Args.notNull(paramHttpContext, "HTTP context");
/*     */     
/* 248 */     HttpClientContext httpClientContext = HttpClientContext.adapt(paramHttpContext);
/*     */     
/* 250 */     AuthCache authCache = httpClientContext.getAuthCache();
/* 251 */     if (authCache != null) {
/* 252 */       if (this.log.isDebugEnabled()) {
/* 253 */         this.log.debug("Clearing cached auth scheme for " + paramHttpHost);
/*     */       }
/* 255 */       authCache.remove(paramHttpHost);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\AuthenticationStrategyImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */