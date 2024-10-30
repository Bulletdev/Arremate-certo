/*     */ package org.apache.http.impl;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.http.HttpConnectionMetrics;
/*     */ import org.apache.http.io.HttpTransportMetrics;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HttpConnectionMetricsImpl
/*     */   implements HttpConnectionMetrics
/*     */ {
/*     */   public static final String REQUEST_COUNT = "http.request-count";
/*     */   public static final String RESPONSE_COUNT = "http.response-count";
/*     */   public static final String SENT_BYTES_COUNT = "http.sent-bytes-count";
/*     */   public static final String RECEIVED_BYTES_COUNT = "http.received-bytes-count";
/*     */   private final HttpTransportMetrics inTransportMetric;
/*     */   private final HttpTransportMetrics outTransportMetric;
/*  50 */   private long requestCount = 0L;
/*  51 */   private long responseCount = 0L;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<String, Object> metricsCache;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpConnectionMetricsImpl(HttpTransportMetrics paramHttpTransportMetrics1, HttpTransportMetrics paramHttpTransportMetrics2) {
/*  62 */     this.inTransportMetric = paramHttpTransportMetrics1;
/*  63 */     this.outTransportMetric = paramHttpTransportMetrics2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getReceivedBytesCount() {
/*  70 */     return (this.inTransportMetric != null) ? this.inTransportMetric.getBytesTransferred() : -1L;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSentBytesCount() {
/*  75 */     return (this.outTransportMetric != null) ? this.outTransportMetric.getBytesTransferred() : -1L;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRequestCount() {
/*  80 */     return this.requestCount;
/*     */   }
/*     */   
/*     */   public void incrementRequestCount() {
/*  84 */     this.requestCount++;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getResponseCount() {
/*  89 */     return this.responseCount;
/*     */   }
/*     */   
/*     */   public void incrementResponseCount() {
/*  93 */     this.responseCount++;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getMetric(String paramString) {
/*  98 */     Object object = null;
/*  99 */     if (this.metricsCache != null) {
/* 100 */       object = this.metricsCache.get(paramString);
/*     */     }
/* 102 */     if (object == null) {
/* 103 */       if ("http.request-count".equals(paramString))
/* 104 */       { object = Long.valueOf(this.requestCount); }
/* 105 */       else if ("http.response-count".equals(paramString))
/* 106 */       { object = Long.valueOf(this.responseCount); }
/* 107 */       else { if ("http.received-bytes-count".equals(paramString)) {
/* 108 */           return (this.inTransportMetric != null) ? Long.valueOf(this.inTransportMetric.getBytesTransferred()) : null;
/*     */         }
/*     */         
/* 111 */         if ("http.sent-bytes-count".equals(paramString)) {
/* 112 */           return (this.outTransportMetric != null) ? Long.valueOf(this.outTransportMetric.getBytesTransferred()) : null;
/*     */         } }
/*     */     
/*     */     }
/*     */     
/* 117 */     return object;
/*     */   }
/*     */   
/*     */   public void setMetric(String paramString, Object paramObject) {
/* 121 */     if (this.metricsCache == null) {
/* 122 */       this.metricsCache = new HashMap<String, Object>();
/*     */     }
/* 124 */     this.metricsCache.put(paramString, paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/* 129 */     if (this.outTransportMetric != null) {
/* 130 */       this.outTransportMetric.reset();
/*     */     }
/* 132 */     if (this.inTransportMetric != null) {
/* 133 */       this.inTransportMetric.reset();
/*     */     }
/* 135 */     this.requestCount = 0L;
/* 136 */     this.responseCount = 0L;
/* 137 */     this.metricsCache = null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\HttpConnectionMetricsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */