/*     */ package org.apache.http.conn.routing;
/*     */ 
/*     */ import java.net.InetAddress;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.Asserts;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RouteTracker
/*     */   implements Cloneable, RouteInfo
/*     */ {
/*     */   private final HttpHost targetHost;
/*     */   private final InetAddress localAddress;
/*     */   private boolean connected;
/*     */   private HttpHost[] proxyChain;
/*     */   private RouteInfo.TunnelType tunnelled;
/*     */   private RouteInfo.LayerType layered;
/*     */   private boolean secure;
/*     */   
/*     */   public RouteTracker(HttpHost paramHttpHost, InetAddress paramInetAddress) {
/*  80 */     Args.notNull(paramHttpHost, "Target host");
/*  81 */     this.targetHost = paramHttpHost;
/*  82 */     this.localAddress = paramInetAddress;
/*  83 */     this.tunnelled = RouteInfo.TunnelType.PLAIN;
/*  84 */     this.layered = RouteInfo.LayerType.PLAIN;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/*  91 */     this.connected = false;
/*  92 */     this.proxyChain = null;
/*  93 */     this.tunnelled = RouteInfo.TunnelType.PLAIN;
/*  94 */     this.layered = RouteInfo.LayerType.PLAIN;
/*  95 */     this.secure = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RouteTracker(HttpRoute paramHttpRoute) {
/* 106 */     this(paramHttpRoute.getTargetHost(), paramHttpRoute.getLocalAddress());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void connectTarget(boolean paramBoolean) {
/* 116 */     Asserts.check(!this.connected, "Already connected");
/* 117 */     this.connected = true;
/* 118 */     this.secure = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void connectProxy(HttpHost paramHttpHost, boolean paramBoolean) {
/* 129 */     Args.notNull(paramHttpHost, "Proxy host");
/* 130 */     Asserts.check(!this.connected, "Already connected");
/* 131 */     this.connected = true;
/* 132 */     this.proxyChain = new HttpHost[] { paramHttpHost };
/* 133 */     this.secure = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void tunnelTarget(boolean paramBoolean) {
/* 143 */     Asserts.check(this.connected, "No tunnel unless connected");
/* 144 */     Asserts.notNull(this.proxyChain, "No tunnel without proxy");
/* 145 */     this.tunnelled = RouteInfo.TunnelType.TUNNELLED;
/* 146 */     this.secure = paramBoolean;
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
/*     */   public void tunnelProxy(HttpHost paramHttpHost, boolean paramBoolean) {
/* 159 */     Args.notNull(paramHttpHost, "Proxy host");
/* 160 */     Asserts.check(this.connected, "No tunnel unless connected");
/* 161 */     Asserts.notNull(this.proxyChain, "No tunnel without proxy");
/*     */     
/* 163 */     HttpHost[] arrayOfHttpHost = new HttpHost[this.proxyChain.length + 1];
/* 164 */     System.arraycopy(this.proxyChain, 0, arrayOfHttpHost, 0, this.proxyChain.length);
/*     */     
/* 166 */     arrayOfHttpHost[arrayOfHttpHost.length - 1] = paramHttpHost;
/*     */     
/* 168 */     this.proxyChain = arrayOfHttpHost;
/* 169 */     this.secure = paramBoolean;
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
/*     */   public void layerProtocol(boolean paramBoolean) {
/* 181 */     Asserts.check(this.connected, "No layered protocol unless connected");
/* 182 */     this.layered = RouteInfo.LayerType.LAYERED;
/* 183 */     this.secure = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpHost getTargetHost() {
/* 188 */     return this.targetHost;
/*     */   }
/*     */ 
/*     */   
/*     */   public InetAddress getLocalAddress() {
/* 193 */     return this.localAddress;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHopCount() {
/* 198 */     int i = 0;
/* 199 */     if (this.connected) {
/* 200 */       if (this.proxyChain == null) {
/* 201 */         i = 1;
/*     */       } else {
/* 203 */         i = this.proxyChain.length + 1;
/*     */       } 
/*     */     }
/* 206 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpHost getHopTarget(int paramInt) {
/* 211 */     Args.notNegative(paramInt, "Hop index");
/* 212 */     int i = getHopCount();
/* 213 */     Args.check((paramInt < i), "Hop index exceeds tracked route length");
/* 214 */     HttpHost httpHost = null;
/* 215 */     if (paramInt < i - 1) {
/* 216 */       httpHost = this.proxyChain[paramInt];
/*     */     } else {
/* 218 */       httpHost = this.targetHost;
/*     */     } 
/*     */     
/* 221 */     return httpHost;
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpHost getProxyHost() {
/* 226 */     return (this.proxyChain == null) ? null : this.proxyChain[0];
/*     */   }
/*     */   
/*     */   public boolean isConnected() {
/* 230 */     return this.connected;
/*     */   }
/*     */ 
/*     */   
/*     */   public RouteInfo.TunnelType getTunnelType() {
/* 235 */     return this.tunnelled;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTunnelled() {
/* 240 */     return (this.tunnelled == RouteInfo.TunnelType.TUNNELLED);
/*     */   }
/*     */ 
/*     */   
/*     */   public RouteInfo.LayerType getLayerType() {
/* 245 */     return this.layered;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLayered() {
/* 250 */     return (this.layered == RouteInfo.LayerType.LAYERED);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSecure() {
/* 255 */     return this.secure;
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
/*     */   public HttpRoute toRoute() {
/* 267 */     return !this.connected ? null : new HttpRoute(this.targetHost, this.localAddress, this.proxyChain, this.secure, this.tunnelled, this.layered);
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
/*     */   public boolean equals(Object paramObject) {
/* 283 */     if (paramObject == this) {
/* 284 */       return true;
/*     */     }
/* 286 */     if (!(paramObject instanceof RouteTracker)) {
/* 287 */       return false;
/*     */     }
/*     */     
/* 290 */     RouteTracker routeTracker = (RouteTracker)paramObject;
/* 291 */     return (this.connected == routeTracker.connected && this.secure == routeTracker.secure && this.tunnelled == routeTracker.tunnelled && this.layered == routeTracker.layered && LangUtils.equals(this.targetHost, routeTracker.targetHost) && LangUtils.equals(this.localAddress, routeTracker.localAddress) && LangUtils.equals((Object[])this.proxyChain, (Object[])routeTracker.proxyChain));
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
/*     */   public int hashCode() {
/* 312 */     int i = 17;
/* 313 */     i = LangUtils.hashCode(i, this.targetHost);
/* 314 */     i = LangUtils.hashCode(i, this.localAddress);
/* 315 */     if (this.proxyChain != null) {
/* 316 */       for (HttpHost httpHost : this.proxyChain) {
/* 317 */         i = LangUtils.hashCode(i, httpHost);
/*     */       }
/*     */     }
/* 320 */     i = LangUtils.hashCode(i, this.connected);
/* 321 */     i = LangUtils.hashCode(i, this.secure);
/* 322 */     i = LangUtils.hashCode(i, this.tunnelled);
/* 323 */     i = LangUtils.hashCode(i, this.layered);
/* 324 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 334 */     StringBuilder stringBuilder = new StringBuilder(50 + getHopCount() * 30);
/*     */     
/* 336 */     stringBuilder.append("RouteTracker[");
/* 337 */     if (this.localAddress != null) {
/* 338 */       stringBuilder.append(this.localAddress);
/* 339 */       stringBuilder.append("->");
/*     */     } 
/* 341 */     stringBuilder.append('{');
/* 342 */     if (this.connected) {
/* 343 */       stringBuilder.append('c');
/*     */     }
/* 345 */     if (this.tunnelled == RouteInfo.TunnelType.TUNNELLED) {
/* 346 */       stringBuilder.append('t');
/*     */     }
/* 348 */     if (this.layered == RouteInfo.LayerType.LAYERED) {
/* 349 */       stringBuilder.append('l');
/*     */     }
/* 351 */     if (this.secure) {
/* 352 */       stringBuilder.append('s');
/*     */     }
/* 354 */     stringBuilder.append("}->");
/* 355 */     if (this.proxyChain != null) {
/* 356 */       for (HttpHost httpHost : this.proxyChain) {
/* 357 */         stringBuilder.append(httpHost);
/* 358 */         stringBuilder.append("->");
/*     */       } 
/*     */     }
/* 361 */     stringBuilder.append(this.targetHost);
/* 362 */     stringBuilder.append(']');
/*     */     
/* 364 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object clone() throws CloneNotSupportedException {
/* 371 */     return super.clone();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\routing\RouteTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */