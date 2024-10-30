/*     */ package org.apache.http.impl.conn.tsccm;
/*     */ 
/*     */ import java.lang.ref.ReferenceQueue;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.http.conn.ClientConnectionOperator;
/*     */ import org.apache.http.conn.OperatedClientConnection;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.impl.conn.AbstractPoolEntry;
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
/*     */ @Deprecated
/*     */ public class BasicPoolEntry
/*     */   extends AbstractPoolEntry
/*     */ {
/*     */   private final long created;
/*     */   private long updated;
/*     */   private final long validUntil;
/*     */   private long expiry;
/*     */   
/*     */   public BasicPoolEntry(ClientConnectionOperator paramClientConnectionOperator, HttpRoute paramHttpRoute, ReferenceQueue<Object> paramReferenceQueue) {
/*  57 */     super(paramClientConnectionOperator, paramHttpRoute);
/*  58 */     Args.notNull(paramHttpRoute, "HTTP route");
/*  59 */     this.created = System.currentTimeMillis();
/*  60 */     this.validUntil = Long.MAX_VALUE;
/*  61 */     this.expiry = this.validUntil;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasicPoolEntry(ClientConnectionOperator paramClientConnectionOperator, HttpRoute paramHttpRoute) {
/*  72 */     this(paramClientConnectionOperator, paramHttpRoute, -1L, TimeUnit.MILLISECONDS);
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
/*     */   public BasicPoolEntry(ClientConnectionOperator paramClientConnectionOperator, HttpRoute paramHttpRoute, long paramLong, TimeUnit paramTimeUnit) {
/*  87 */     super(paramClientConnectionOperator, paramHttpRoute);
/*  88 */     Args.notNull(paramHttpRoute, "HTTP route");
/*  89 */     this.created = System.currentTimeMillis();
/*  90 */     if (paramLong > 0L) {
/*  91 */       this.validUntil = this.created + paramTimeUnit.toMillis(paramLong);
/*     */     } else {
/*  93 */       this.validUntil = Long.MAX_VALUE;
/*     */     } 
/*  95 */     this.expiry = this.validUntil;
/*     */   }
/*     */   
/*     */   protected final OperatedClientConnection getConnection() {
/*  99 */     return this.connection;
/*     */   }
/*     */   
/*     */   protected final HttpRoute getPlannedRoute() {
/* 103 */     return this.route;
/*     */   }
/*     */   
/*     */   protected final BasicPoolEntryRef getWeakRef() {
/* 107 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void shutdownEntry() {
/* 112 */     super.shutdownEntry();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getCreated() {
/* 119 */     return this.created;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getUpdated() {
/* 126 */     return this.updated;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getExpiry() {
/* 133 */     return this.expiry;
/*     */   }
/*     */   
/*     */   public long getValidUntil() {
/* 137 */     return this.validUntil;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateExpiry(long paramLong, TimeUnit paramTimeUnit) {
/*     */     long l;
/* 144 */     this.updated = System.currentTimeMillis();
/*     */     
/* 146 */     if (paramLong > 0L) {
/* 147 */       l = this.updated + paramTimeUnit.toMillis(paramLong);
/*     */     } else {
/* 149 */       l = Long.MAX_VALUE;
/*     */     } 
/* 151 */     this.expiry = Math.min(this.validUntil, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isExpired(long paramLong) {
/* 158 */     return (paramLong >= this.expiry);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\tsccm\BasicPoolEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */