/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.http.client.BackoffManager;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.pool.ConnPoolControl;
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
/*     */ public class AIMDBackoffManager
/*     */   implements BackoffManager
/*     */ {
/*     */   private final ConnPoolControl<HttpRoute> connPerRoute;
/*     */   private final Clock clock;
/*     */   private final Map<HttpRoute, Long> lastRouteProbes;
/*     */   private final Map<HttpRoute, Long> lastRouteBackoffs;
/*  63 */   private long coolDown = 5000L;
/*  64 */   private double backoffFactor = 0.5D;
/*  65 */   private int cap = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AIMDBackoffManager(ConnPoolControl<HttpRoute> paramConnPoolControl) {
/*  75 */     this(paramConnPoolControl, new SystemClock());
/*     */   }
/*     */   
/*     */   AIMDBackoffManager(ConnPoolControl<HttpRoute> paramConnPoolControl, Clock paramClock) {
/*  79 */     this.clock = paramClock;
/*  80 */     this.connPerRoute = paramConnPoolControl;
/*  81 */     this.lastRouteProbes = new HashMap<HttpRoute, Long>();
/*  82 */     this.lastRouteBackoffs = new HashMap<HttpRoute, Long>();
/*     */   }
/*     */ 
/*     */   
/*     */   public void backOff(HttpRoute paramHttpRoute) {
/*  87 */     synchronized (this.connPerRoute) {
/*  88 */       int i = this.connPerRoute.getMaxPerRoute(paramHttpRoute);
/*  89 */       Long long_ = getLastUpdate(this.lastRouteBackoffs, paramHttpRoute);
/*  90 */       long l = this.clock.getCurrentTime();
/*  91 */       if (l - long_.longValue() < this.coolDown) {
/*     */         return;
/*     */       }
/*  94 */       this.connPerRoute.setMaxPerRoute(paramHttpRoute, getBackedOffPoolSize(i));
/*  95 */       this.lastRouteBackoffs.put(paramHttpRoute, Long.valueOf(l));
/*     */     } 
/*     */   }
/*     */   
/*     */   private int getBackedOffPoolSize(int paramInt) {
/* 100 */     if (paramInt <= 1) {
/* 101 */       return 1;
/*     */     }
/* 103 */     return (int)Math.floor(this.backoffFactor * paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void probe(HttpRoute paramHttpRoute) {
/* 108 */     synchronized (this.connPerRoute) {
/* 109 */       int i = this.connPerRoute.getMaxPerRoute(paramHttpRoute);
/* 110 */       int j = (i >= this.cap) ? this.cap : (i + 1);
/* 111 */       Long long_1 = getLastUpdate(this.lastRouteProbes, paramHttpRoute);
/* 112 */       Long long_2 = getLastUpdate(this.lastRouteBackoffs, paramHttpRoute);
/* 113 */       long l = this.clock.getCurrentTime();
/* 114 */       if (l - long_1.longValue() < this.coolDown || l - long_2.longValue() < this.coolDown) {
/*     */         return;
/*     */       }
/* 117 */       this.connPerRoute.setMaxPerRoute(paramHttpRoute, j);
/* 118 */       this.lastRouteProbes.put(paramHttpRoute, Long.valueOf(l));
/*     */     } 
/*     */   }
/*     */   
/*     */   private Long getLastUpdate(Map<HttpRoute, Long> paramMap, HttpRoute paramHttpRoute) {
/* 123 */     Long long_ = paramMap.get(paramHttpRoute);
/* 124 */     if (long_ == null) {
/* 125 */       long_ = Long.valueOf(0L);
/*     */     }
/* 127 */     return long_;
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
/*     */   public void setBackoffFactor(double paramDouble) {
/* 140 */     Args.check((paramDouble > 0.0D && paramDouble < 1.0D), "Backoff factor must be 0.0 < f < 1.0");
/* 141 */     this.backoffFactor = paramDouble;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCooldownMillis(long paramLong) {
/* 152 */     Args.positive(this.coolDown, "Cool down");
/* 153 */     this.coolDown = paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPerHostConnectionCap(int paramInt) {
/* 162 */     Args.positive(paramInt, "Per host connection cap");
/* 163 */     this.cap = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\AIMDBackoffManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */