/*     */ package org.apache.http.conn.params;
/*     */ 
/*     */ import java.net.InetAddress;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.params.HttpParams;
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
/*     */ 
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class ConnRouteParams
/*     */   implements ConnRoutePNames
/*     */ {
/*  55 */   public static final HttpHost NO_HOST = new HttpHost("127.0.0.255", 0, "no-host");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  62 */   public static final HttpRoute NO_ROUTE = new HttpRoute(NO_HOST);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static HttpHost getDefaultProxy(HttpParams paramHttpParams) {
/*  81 */     Args.notNull(paramHttpParams, "Parameters");
/*  82 */     HttpHost httpHost = (HttpHost)paramHttpParams.getParameter("http.route.default-proxy");
/*     */     
/*  84 */     if (httpHost != null && NO_HOST.equals(httpHost))
/*     */     {
/*  86 */       httpHost = null;
/*     */     }
/*  88 */     return httpHost;
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
/*     */   public static void setDefaultProxy(HttpParams paramHttpParams, HttpHost paramHttpHost) {
/* 103 */     Args.notNull(paramHttpParams, "Parameters");
/* 104 */     paramHttpParams.setParameter("http.route.default-proxy", paramHttpHost);
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
/*     */   public static HttpRoute getForcedRoute(HttpParams paramHttpParams) {
/* 119 */     Args.notNull(paramHttpParams, "Parameters");
/* 120 */     HttpRoute httpRoute = (HttpRoute)paramHttpParams.getParameter("http.route.forced-route");
/*     */     
/* 122 */     if (httpRoute != null && NO_ROUTE.equals(httpRoute))
/*     */     {
/* 124 */       httpRoute = null;
/*     */     }
/* 126 */     return httpRoute;
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
/*     */   public static void setForcedRoute(HttpParams paramHttpParams, HttpRoute paramHttpRoute) {
/* 141 */     Args.notNull(paramHttpParams, "Parameters");
/* 142 */     paramHttpParams.setParameter("http.route.forced-route", paramHttpRoute);
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
/*     */   public static InetAddress getLocalAddress(HttpParams paramHttpParams) {
/* 158 */     Args.notNull(paramHttpParams, "Parameters");
/* 159 */     return (InetAddress)paramHttpParams.getParameter("http.route.local-address");
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
/*     */   public static void setLocalAddress(HttpParams paramHttpParams, InetAddress paramInetAddress) {
/* 174 */     Args.notNull(paramHttpParams, "Parameters");
/* 175 */     paramHttpParams.setParameter("http.route.local-address", paramInetAddress);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\params\ConnRouteParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */