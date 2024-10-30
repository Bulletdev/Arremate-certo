/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.net.InetAddress;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.Proxy;
/*     */ import java.net.ProxySelector;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.util.List;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.conn.params.ConnRouteParams;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.conn.routing.HttpRoutePlanner;
/*     */ import org.apache.http.conn.scheme.Scheme;
/*     */ import org.apache.http.conn.scheme.SchemeRegistry;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.Asserts;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class ProxySelectorRoutePlanner
/*     */   implements HttpRoutePlanner
/*     */ {
/*     */   protected final SchemeRegistry schemeRegistry;
/*     */   protected ProxySelector proxySelector;
/*     */   
/*     */   public ProxySelectorRoutePlanner(SchemeRegistry paramSchemeRegistry, ProxySelector paramProxySelector) {
/*  91 */     Args.notNull(paramSchemeRegistry, "SchemeRegistry");
/*  92 */     this.schemeRegistry = paramSchemeRegistry;
/*  93 */     this.proxySelector = paramProxySelector;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ProxySelector getProxySelector() {
/* 102 */     return this.proxySelector;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProxySelector(ProxySelector paramProxySelector) {
/* 112 */     this.proxySelector = paramProxySelector;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpRoute determineRoute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException {
/* 121 */     Args.notNull(paramHttpRequest, "HTTP request");
/*     */ 
/*     */     
/* 124 */     HttpRoute httpRoute = ConnRouteParams.getForcedRoute(paramHttpRequest.getParams());
/*     */     
/* 126 */     if (httpRoute != null) {
/* 127 */       return httpRoute;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 133 */     Asserts.notNull(paramHttpHost, "Target host");
/*     */     
/* 135 */     InetAddress inetAddress = ConnRouteParams.getLocalAddress(paramHttpRequest.getParams());
/*     */     
/* 137 */     HttpHost httpHost = determineProxy(paramHttpHost, paramHttpRequest, paramHttpContext);
/*     */     
/* 139 */     Scheme scheme = this.schemeRegistry.getScheme(paramHttpHost.getSchemeName());
/*     */ 
/*     */ 
/*     */     
/* 143 */     boolean bool = scheme.isLayered();
/*     */     
/* 145 */     if (httpHost == null) {
/* 146 */       httpRoute = new HttpRoute(paramHttpHost, inetAddress, bool);
/*     */     } else {
/* 148 */       httpRoute = new HttpRoute(paramHttpHost, inetAddress, httpHost, bool);
/*     */     } 
/* 150 */     return httpRoute;
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
/*     */   protected HttpHost determineProxy(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException {
/* 171 */     ProxySelector proxySelector = this.proxySelector;
/* 172 */     if (proxySelector == null) {
/* 173 */       proxySelector = ProxySelector.getDefault();
/*     */     }
/* 175 */     if (proxySelector == null) {
/* 176 */       return null;
/*     */     }
/*     */     
/* 179 */     URI uRI = null;
/*     */     try {
/* 181 */       uRI = new URI(paramHttpHost.toURI());
/* 182 */     } catch (URISyntaxException uRISyntaxException) {
/* 183 */       throw new HttpException("Cannot convert host to URI: " + paramHttpHost, uRISyntaxException);
/*     */     } 
/*     */     
/* 186 */     List<Proxy> list = proxySelector.select(uRI);
/*     */     
/* 188 */     Proxy proxy = chooseProxy(list, paramHttpHost, paramHttpRequest, paramHttpContext);
/*     */     
/* 190 */     HttpHost httpHost = null;
/* 191 */     if (proxy.type() == Proxy.Type.HTTP) {
/*     */       
/* 193 */       if (!(proxy.address() instanceof InetSocketAddress)) {
/* 194 */         throw new HttpException("Unable to handle non-Inet proxy address: " + proxy.address());
/*     */       }
/*     */       
/* 197 */       InetSocketAddress inetSocketAddress = (InetSocketAddress)proxy.address();
/*     */       
/* 199 */       httpHost = new HttpHost(getHost(inetSocketAddress), inetSocketAddress.getPort());
/*     */     } 
/*     */     
/* 202 */     return httpHost;
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
/*     */   protected String getHost(InetSocketAddress paramInetSocketAddress) {
/* 221 */     return paramInetSocketAddress.isUnresolved() ? paramInetSocketAddress.getHostName() : paramInetSocketAddress.getAddress().getHostAddress();
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
/*     */   protected Proxy chooseProxy(List<Proxy> paramList, HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) {
/* 246 */     Args.notEmpty(paramList, "List of proxies");
/*     */     
/* 248 */     Proxy proxy = null;
/*     */ 
/*     */     
/* 251 */     for (byte b = 0; proxy == null && b < paramList.size(); b++) {
/*     */       
/* 253 */       Proxy proxy1 = paramList.get(b);
/* 254 */       switch (proxy1.type()) {
/*     */         
/*     */         case DIRECT:
/*     */         case HTTP:
/* 258 */           proxy = proxy1;
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 268 */     if (proxy == null)
/*     */     {
/*     */ 
/*     */       
/* 272 */       proxy = Proxy.NO_PROXY;
/*     */     }
/*     */     
/* 275 */     return proxy;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\ProxySelectorRoutePlanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */