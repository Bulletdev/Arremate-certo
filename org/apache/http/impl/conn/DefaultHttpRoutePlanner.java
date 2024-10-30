/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.net.InetAddress;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
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
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public class DefaultHttpRoutePlanner
/*     */   implements HttpRoutePlanner
/*     */ {
/*     */   protected final SchemeRegistry schemeRegistry;
/*     */   
/*     */   public DefaultHttpRoutePlanner(SchemeRegistry paramSchemeRegistry) {
/*  78 */     Args.notNull(paramSchemeRegistry, "Scheme registry");
/*  79 */     this.schemeRegistry = paramSchemeRegistry;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpRoute determineRoute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException {
/*     */     Scheme scheme;
/*  88 */     Args.notNull(paramHttpRequest, "HTTP request");
/*     */ 
/*     */     
/*  91 */     HttpRoute httpRoute = ConnRouteParams.getForcedRoute(paramHttpRequest.getParams());
/*     */     
/*  93 */     if (httpRoute != null) {
/*  94 */       return httpRoute;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 100 */     Asserts.notNull(paramHttpHost, "Target host");
/*     */     
/* 102 */     InetAddress inetAddress = ConnRouteParams.getLocalAddress(paramHttpRequest.getParams());
/*     */     
/* 104 */     HttpHost httpHost = ConnRouteParams.getDefaultProxy(paramHttpRequest.getParams());
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 109 */       scheme = this.schemeRegistry.getScheme(paramHttpHost.getSchemeName());
/* 110 */     } catch (IllegalStateException illegalStateException) {
/* 111 */       throw new HttpException(illegalStateException.getMessage());
/*     */     } 
/*     */ 
/*     */     
/* 115 */     boolean bool = scheme.isLayered();
/*     */     
/* 117 */     if (httpHost == null) {
/* 118 */       httpRoute = new HttpRoute(paramHttpHost, inetAddress, bool);
/*     */     } else {
/* 120 */       httpRoute = new HttpRoute(paramHttpHost, inetAddress, httpHost, bool);
/*     */     } 
/* 122 */     return httpRoute;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\DefaultHttpRoutePlanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */