/*     */ package org.apache.http.conn.params;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public final class ConnManagerParams
/*     */   implements ConnManagerPNames
/*     */ {
/*     */   public static final int DEFAULT_MAX_TOTAL_CONNECTIONS = 20;
/*     */   
/*     */   @Deprecated
/*     */   public static long getTimeout(HttpParams paramHttpParams) {
/*  64 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*  65 */     return paramHttpParams.getLongParameter("http.conn-manager.timeout", 0L);
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
/*     */   @Deprecated
/*     */   public static void setTimeout(HttpParams paramHttpParams, long paramLong) {
/*  80 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*  81 */     paramHttpParams.setLongParameter("http.conn-manager.timeout", paramLong);
/*     */   }
/*     */ 
/*     */   
/*  85 */   private static final ConnPerRoute DEFAULT_CONN_PER_ROUTE = new ConnPerRoute()
/*     */     {
/*     */       public int getMaxForRoute(HttpRoute param1HttpRoute)
/*     */       {
/*  89 */         return 2;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setMaxConnectionsPerRoute(HttpParams paramHttpParams, ConnPerRoute paramConnPerRoute) {
/* 103 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 104 */     paramHttpParams.setParameter("http.conn-manager.max-per-route", paramConnPerRoute);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ConnPerRoute getMaxConnectionsPerRoute(HttpParams paramHttpParams) {
/* 115 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 116 */     ConnPerRoute connPerRoute = (ConnPerRoute)paramHttpParams.getParameter("http.conn-manager.max-per-route");
/* 117 */     if (connPerRoute == null) {
/* 118 */       connPerRoute = DEFAULT_CONN_PER_ROUTE;
/*     */     }
/* 120 */     return connPerRoute;
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
/*     */   public static void setMaxTotalConnections(HttpParams paramHttpParams, int paramInt) {
/* 132 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 133 */     paramHttpParams.setIntParameter("http.conn-manager.max-total", paramInt);
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
/*     */   public static int getMaxTotalConnections(HttpParams paramHttpParams) {
/* 145 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 146 */     return paramHttpParams.getIntParameter("http.conn-manager.max-total", 20);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\params\ConnManagerParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */