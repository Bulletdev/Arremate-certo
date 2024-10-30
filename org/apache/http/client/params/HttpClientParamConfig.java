/*     */ package org.apache.http.client.params;
/*     */ 
/*     */ import java.net.InetAddress;
/*     */ import java.util.Collection;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.params.HttpParams;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class HttpClientParamConfig
/*     */ {
/*     */   public static RequestConfig getRequestConfig(HttpParams paramHttpParams) {
/*  54 */     return getRequestConfig(paramHttpParams, RequestConfig.DEFAULT);
/*     */   }
/*     */ 
/*     */   
/*     */   public static RequestConfig getRequestConfig(HttpParams paramHttpParams, RequestConfig paramRequestConfig) {
/*  59 */     RequestConfig.Builder builder = RequestConfig.copy(paramRequestConfig).setSocketTimeout(paramHttpParams.getIntParameter("http.socket.timeout", paramRequestConfig.getSocketTimeout())).setStaleConnectionCheckEnabled(paramHttpParams.getBooleanParameter("http.connection.stalecheck", paramRequestConfig.isStaleConnectionCheckEnabled())).setConnectTimeout(paramHttpParams.getIntParameter("http.connection.timeout", paramRequestConfig.getConnectTimeout())).setExpectContinueEnabled(paramHttpParams.getBooleanParameter("http.protocol.expect-continue", paramRequestConfig.isExpectContinueEnabled())).setAuthenticationEnabled(paramHttpParams.getBooleanParameter("http.protocol.handle-authentication", paramRequestConfig.isAuthenticationEnabled())).setCircularRedirectsAllowed(paramHttpParams.getBooleanParameter("http.protocol.allow-circular-redirects", paramRequestConfig.isCircularRedirectsAllowed())).setConnectionRequestTimeout((int)paramHttpParams.getLongParameter("http.conn-manager.timeout", paramRequestConfig.getConnectionRequestTimeout())).setMaxRedirects(paramHttpParams.getIntParameter("http.protocol.max-redirects", paramRequestConfig.getMaxRedirects())).setRedirectsEnabled(paramHttpParams.getBooleanParameter("http.protocol.handle-redirects", paramRequestConfig.isRedirectsEnabled())).setRelativeRedirectsAllowed(!paramHttpParams.getBooleanParameter("http.protocol.reject-relative-redirect", !paramRequestConfig.isRelativeRedirectsAllowed()));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  81 */     HttpHost httpHost = (HttpHost)paramHttpParams.getParameter("http.route.default-proxy");
/*  82 */     if (httpHost != null) {
/*  83 */       builder.setProxy(httpHost);
/*     */     }
/*  85 */     InetAddress inetAddress = (InetAddress)paramHttpParams.getParameter("http.route.local-address");
/*  86 */     if (inetAddress != null) {
/*  87 */       builder.setLocalAddress(inetAddress);
/*     */     }
/*  89 */     Collection collection1 = (Collection)paramHttpParams.getParameter("http.auth.target-scheme-pref");
/*  90 */     if (collection1 != null) {
/*  91 */       builder.setTargetPreferredAuthSchemes(collection1);
/*     */     }
/*  93 */     Collection collection2 = (Collection)paramHttpParams.getParameter("http.auth.proxy-scheme-pref");
/*  94 */     if (collection2 != null) {
/*  95 */       builder.setProxyPreferredAuthSchemes(collection2);
/*     */     }
/*  97 */     String str = (String)paramHttpParams.getParameter("http.protocol.cookie-policy");
/*  98 */     if (str != null) {
/*  99 */       builder.setCookieSpec(str);
/*     */     }
/* 101 */     return builder.build();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\params\HttpClientParamConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */