/*     */ package org.apache.http.conn.params;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.conn.routing.HttpRoute;
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
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public final class ConnPerRouteBean
/*     */   implements ConnPerRoute
/*     */ {
/*     */   public static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 2;
/*     */   private final ConcurrentHashMap<HttpRoute, Integer> maxPerHostMap;
/*     */   private volatile int defaultMax;
/*     */   
/*     */   public ConnPerRouteBean(int paramInt) {
/*  60 */     this.maxPerHostMap = new ConcurrentHashMap<HttpRoute, Integer>();
/*  61 */     setDefaultMaxPerRoute(paramInt);
/*     */   }
/*     */   
/*     */   public ConnPerRouteBean() {
/*  65 */     this(2);
/*     */   }
/*     */   
/*     */   public int getDefaultMax() {
/*  69 */     return this.defaultMax;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDefaultMaxPerRoute() {
/*  76 */     return this.defaultMax;
/*     */   }
/*     */   
/*     */   public void setDefaultMaxPerRoute(int paramInt) {
/*  80 */     Args.positive(paramInt, "Default max per route");
/*  81 */     this.defaultMax = paramInt;
/*     */   }
/*     */   
/*     */   public void setMaxForRoute(HttpRoute paramHttpRoute, int paramInt) {
/*  85 */     Args.notNull(paramHttpRoute, "HTTP route");
/*  86 */     Args.positive(paramInt, "Max per route");
/*  87 */     this.maxPerHostMap.put(paramHttpRoute, Integer.valueOf(paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxForRoute(HttpRoute paramHttpRoute) {
/*  92 */     Args.notNull(paramHttpRoute, "HTTP route");
/*  93 */     Integer integer = this.maxPerHostMap.get(paramHttpRoute);
/*  94 */     if (integer != null) {
/*  95 */       return integer.intValue();
/*     */     }
/*  97 */     return this.defaultMax;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaxForRoutes(Map<HttpRoute, Integer> paramMap) {
/* 102 */     if (paramMap == null) {
/*     */       return;
/*     */     }
/* 105 */     this.maxPerHostMap.clear();
/* 106 */     this.maxPerHostMap.putAll(paramMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 111 */     return this.maxPerHostMap.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\params\ConnPerRouteBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */