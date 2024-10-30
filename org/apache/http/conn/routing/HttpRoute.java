/*     */ package org.apache.http.conn.routing;
/*     */ 
/*     */ import java.net.InetAddress;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.LangUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class HttpRoute
/*     */   implements Cloneable, RouteInfo
/*     */ {
/*     */   private final HttpHost targetHost;
/*     */   private final InetAddress localAddress;
/*     */   private final List<HttpHost> proxyChain;
/*     */   private final RouteInfo.TunnelType tunnelled;
/*     */   private final RouteInfo.LayerType layered;
/*     */   private final boolean secure;
/*     */   
/*     */   private HttpRoute(HttpHost paramHttpHost, InetAddress paramInetAddress, List<HttpHost> paramList, boolean paramBoolean, RouteInfo.TunnelType paramTunnelType, RouteInfo.LayerType paramLayerType) {
/*  74 */     Args.notNull(paramHttpHost, "Target host");
/*  75 */     this.targetHost = normalize(paramHttpHost);
/*  76 */     this.localAddress = paramInetAddress;
/*  77 */     if (paramList != null && !paramList.isEmpty()) {
/*  78 */       this.proxyChain = new ArrayList<HttpHost>(paramList);
/*     */     } else {
/*  80 */       this.proxyChain = null;
/*     */     } 
/*  82 */     if (paramTunnelType == RouteInfo.TunnelType.TUNNELLED) {
/*  83 */       Args.check((this.proxyChain != null), "Proxy required if tunnelled");
/*     */     }
/*  85 */     this.secure = paramBoolean;
/*  86 */     this.tunnelled = (paramTunnelType != null) ? paramTunnelType : RouteInfo.TunnelType.PLAIN;
/*  87 */     this.layered = (paramLayerType != null) ? paramLayerType : RouteInfo.LayerType.PLAIN;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int getDefaultPort(String paramString) {
/*  92 */     if ("http".equalsIgnoreCase(paramString))
/*  93 */       return 80; 
/*  94 */     if ("https".equalsIgnoreCase(paramString)) {
/*  95 */       return 443;
/*     */     }
/*  97 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static HttpHost normalize(HttpHost paramHttpHost) {
/* 104 */     if (paramHttpHost.getPort() >= 0) {
/* 105 */       return paramHttpHost;
/*     */     }
/* 107 */     InetAddress inetAddress = paramHttpHost.getAddress();
/* 108 */     String str = paramHttpHost.getSchemeName();
/* 109 */     return (inetAddress != null) ? new HttpHost(inetAddress, getDefaultPort(str), str) : new HttpHost(paramHttpHost.getHostName(), getDefaultPort(str), str);
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
/*     */   public HttpRoute(HttpHost paramHttpHost, InetAddress paramInetAddress, HttpHost[] paramArrayOfHttpHost, boolean paramBoolean, RouteInfo.TunnelType paramTunnelType, RouteInfo.LayerType paramLayerType) {
/* 130 */     this(paramHttpHost, paramInetAddress, (paramArrayOfHttpHost != null) ? Arrays.<HttpHost>asList(paramArrayOfHttpHost) : null, paramBoolean, paramTunnelType, paramLayerType);
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
/*     */   public HttpRoute(HttpHost paramHttpHost1, InetAddress paramInetAddress, HttpHost paramHttpHost2, boolean paramBoolean, RouteInfo.TunnelType paramTunnelType, RouteInfo.LayerType paramLayerType) {
/* 153 */     this(paramHttpHost1, paramInetAddress, (paramHttpHost2 != null) ? Collections.<HttpHost>singletonList(paramHttpHost2) : null, paramBoolean, paramTunnelType, paramLayerType);
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
/*     */   public HttpRoute(HttpHost paramHttpHost, InetAddress paramInetAddress, boolean paramBoolean) {
/* 168 */     this(paramHttpHost, paramInetAddress, Collections.emptyList(), paramBoolean, RouteInfo.TunnelType.PLAIN, RouteInfo.LayerType.PLAIN);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpRoute(HttpHost paramHttpHost) {
/* 178 */     this(paramHttpHost, (InetAddress)null, Collections.emptyList(), false, RouteInfo.TunnelType.PLAIN, RouteInfo.LayerType.PLAIN);
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
/*     */   public HttpRoute(HttpHost paramHttpHost1, InetAddress paramInetAddress, HttpHost paramHttpHost2, boolean paramBoolean) {
/* 197 */     this(paramHttpHost1, paramInetAddress, Collections.singletonList(Args.notNull(paramHttpHost2, "Proxy host")), paramBoolean, paramBoolean ? RouteInfo.TunnelType.TUNNELLED : RouteInfo.TunnelType.PLAIN, paramBoolean ? RouteInfo.LayerType.LAYERED : RouteInfo.LayerType.PLAIN);
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
/*     */   public HttpRoute(HttpHost paramHttpHost1, HttpHost paramHttpHost2) {
/* 211 */     this(paramHttpHost1, null, paramHttpHost2, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpHost getTargetHost() {
/* 216 */     return this.targetHost;
/*     */   }
/*     */ 
/*     */   
/*     */   public InetAddress getLocalAddress() {
/* 221 */     return this.localAddress;
/*     */   }
/*     */   
/*     */   public InetSocketAddress getLocalSocketAddress() {
/* 225 */     return (this.localAddress != null) ? new InetSocketAddress(this.localAddress, 0) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHopCount() {
/* 230 */     return (this.proxyChain != null) ? (this.proxyChain.size() + 1) : 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpHost getHopTarget(int paramInt) {
/* 235 */     Args.notNegative(paramInt, "Hop index");
/* 236 */     int i = getHopCount();
/* 237 */     Args.check((paramInt < i), "Hop index exceeds tracked route length");
/* 238 */     return (paramInt < i - 1) ? this.proxyChain.get(paramInt) : this.targetHost;
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpHost getProxyHost() {
/* 243 */     return (this.proxyChain != null && !this.proxyChain.isEmpty()) ? this.proxyChain.get(0) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public RouteInfo.TunnelType getTunnelType() {
/* 248 */     return this.tunnelled;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTunnelled() {
/* 253 */     return (this.tunnelled == RouteInfo.TunnelType.TUNNELLED);
/*     */   }
/*     */ 
/*     */   
/*     */   public RouteInfo.LayerType getLayerType() {
/* 258 */     return this.layered;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLayered() {
/* 263 */     return (this.layered == RouteInfo.LayerType.LAYERED);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSecure() {
/* 268 */     return this.secure;
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
/*     */   public boolean equals(Object paramObject) {
/* 281 */     if (this == paramObject) {
/* 282 */       return true;
/*     */     }
/* 284 */     if (paramObject instanceof HttpRoute) {
/* 285 */       HttpRoute httpRoute = (HttpRoute)paramObject;
/* 286 */       return (this.secure == httpRoute.secure && this.tunnelled == httpRoute.tunnelled && this.layered == httpRoute.layered && LangUtils.equals(this.targetHost, httpRoute.targetHost) && LangUtils.equals(this.localAddress, httpRoute.localAddress) && LangUtils.equals(this.proxyChain, httpRoute.proxyChain));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 295 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 306 */     int i = 17;
/* 307 */     i = LangUtils.hashCode(i, this.targetHost);
/* 308 */     i = LangUtils.hashCode(i, this.localAddress);
/* 309 */     if (this.proxyChain != null) {
/* 310 */       for (HttpHost httpHost : this.proxyChain) {
/* 311 */         i = LangUtils.hashCode(i, httpHost);
/*     */       }
/*     */     }
/* 314 */     i = LangUtils.hashCode(i, this.secure);
/* 315 */     i = LangUtils.hashCode(i, this.tunnelled);
/* 316 */     i = LangUtils.hashCode(i, this.layered);
/* 317 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 327 */     StringBuilder stringBuilder = new StringBuilder(50 + getHopCount() * 30);
/* 328 */     if (this.localAddress != null) {
/* 329 */       stringBuilder.append(this.localAddress);
/* 330 */       stringBuilder.append("->");
/*     */     } 
/* 332 */     stringBuilder.append('{');
/* 333 */     if (this.tunnelled == RouteInfo.TunnelType.TUNNELLED) {
/* 334 */       stringBuilder.append('t');
/*     */     }
/* 336 */     if (this.layered == RouteInfo.LayerType.LAYERED) {
/* 337 */       stringBuilder.append('l');
/*     */     }
/* 339 */     if (this.secure) {
/* 340 */       stringBuilder.append('s');
/*     */     }
/* 342 */     stringBuilder.append("}->");
/* 343 */     if (this.proxyChain != null) {
/* 344 */       for (HttpHost httpHost : this.proxyChain) {
/* 345 */         stringBuilder.append(httpHost);
/* 346 */         stringBuilder.append("->");
/*     */       } 
/*     */     }
/* 349 */     stringBuilder.append(this.targetHost);
/* 350 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object clone() throws CloneNotSupportedException {
/* 356 */     return super.clone();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\routing\HttpRoute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */