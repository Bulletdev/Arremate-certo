/*     */ package org.apache.http.pool;
/*     */ 
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/*     */ public abstract class PoolEntry<T, C>
/*     */ {
/*     */   private final String id;
/*     */   private final T route;
/*     */   private final C conn;
/*     */   private final long created;
/*     */   private final long validityDeadline;
/*     */   private long updated;
/*     */   private long expiry;
/*     */   private volatile Object state;
/*     */   
/*     */   public PoolEntry(String paramString, T paramT, C paramC, long paramLong, TimeUnit paramTimeUnit) {
/*  79 */     Args.notNull(paramT, "Route");
/*  80 */     Args.notNull(paramC, "Connection");
/*  81 */     Args.notNull(paramTimeUnit, "Time unit");
/*  82 */     this.id = paramString;
/*  83 */     this.route = paramT;
/*  84 */     this.conn = paramC;
/*  85 */     this.created = System.currentTimeMillis();
/*  86 */     this.updated = this.created;
/*  87 */     if (paramLong > 0L) {
/*  88 */       long l = this.created + paramTimeUnit.toMillis(paramLong);
/*     */       
/*  90 */       this.validityDeadline = (l > 0L) ? l : Long.MAX_VALUE;
/*     */     } else {
/*  92 */       this.validityDeadline = Long.MAX_VALUE;
/*     */     } 
/*  94 */     this.expiry = this.validityDeadline;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PoolEntry(String paramString, T paramT, C paramC) {
/* 105 */     this(paramString, paramT, paramC, 0L, TimeUnit.MILLISECONDS);
/*     */   }
/*     */   
/*     */   public String getId() {
/* 109 */     return this.id;
/*     */   }
/*     */   
/*     */   public T getRoute() {
/* 113 */     return this.route;
/*     */   }
/*     */   
/*     */   public C getConnection() {
/* 117 */     return this.conn;
/*     */   }
/*     */   
/*     */   public long getCreated() {
/* 121 */     return this.created;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getValidityDeadline() {
/* 128 */     return this.validityDeadline;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public long getValidUnit() {
/* 136 */     return this.validityDeadline;
/*     */   }
/*     */   
/*     */   public Object getState() {
/* 140 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setState(Object paramObject) {
/* 144 */     this.state = paramObject;
/*     */   }
/*     */   
/*     */   public synchronized long getUpdated() {
/* 148 */     return this.updated;
/*     */   }
/*     */   
/*     */   public synchronized long getExpiry() {
/* 152 */     return this.expiry;
/*     */   }
/*     */   public synchronized void updateExpiry(long paramLong, TimeUnit paramTimeUnit) {
/*     */     long l;
/* 156 */     Args.notNull(paramTimeUnit, "Time unit");
/* 157 */     this.updated = System.currentTimeMillis();
/*     */     
/* 159 */     if (paramLong > 0L) {
/* 160 */       l = this.updated + paramTimeUnit.toMillis(paramLong);
/*     */     } else {
/* 162 */       l = Long.MAX_VALUE;
/*     */     } 
/* 164 */     this.expiry = Math.min(l, this.validityDeadline);
/*     */   }
/*     */   
/*     */   public synchronized boolean isExpired(long paramLong) {
/* 168 */     return (paramLong >= this.expiry);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void close();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean isClosed();
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 184 */     StringBuilder stringBuilder = new StringBuilder();
/* 185 */     stringBuilder.append("[id:");
/* 186 */     stringBuilder.append(this.id);
/* 187 */     stringBuilder.append("][route:");
/* 188 */     stringBuilder.append(this.route);
/* 189 */     stringBuilder.append("][state:");
/* 190 */     stringBuilder.append(this.state);
/* 191 */     stringBuilder.append("]");
/* 192 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\pool\PoolEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */