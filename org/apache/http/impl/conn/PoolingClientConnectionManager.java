/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.TimeoutException;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.conn.ClientConnectionManager;
/*     */ import org.apache.http.conn.ClientConnectionOperator;
/*     */ import org.apache.http.conn.ClientConnectionRequest;
/*     */ import org.apache.http.conn.ConnectionPoolTimeoutException;
/*     */ import org.apache.http.conn.DnsResolver;
/*     */ import org.apache.http.conn.ManagedClientConnection;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.conn.scheme.SchemeRegistry;
/*     */ import org.apache.http.pool.ConnPoolControl;
/*     */ import org.apache.http.pool.PoolStats;
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
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/*     */ public class PoolingClientConnectionManager
/*     */   implements ClientConnectionManager, ConnPoolControl<HttpRoute>
/*     */ {
/*  76 */   private final Log log = LogFactory.getLog(getClass());
/*     */   
/*     */   private final SchemeRegistry schemeRegistry;
/*     */   
/*     */   private final HttpConnPool pool;
/*     */   
/*     */   private final ClientConnectionOperator operator;
/*     */   
/*     */   private final DnsResolver dnsResolver;
/*     */ 
/*     */   
/*     */   public PoolingClientConnectionManager(SchemeRegistry paramSchemeRegistry) {
/*  88 */     this(paramSchemeRegistry, -1L, TimeUnit.MILLISECONDS);
/*     */   }
/*     */   
/*     */   public PoolingClientConnectionManager(SchemeRegistry paramSchemeRegistry, DnsResolver paramDnsResolver) {
/*  92 */     this(paramSchemeRegistry, -1L, TimeUnit.MILLISECONDS, paramDnsResolver);
/*     */   }
/*     */   
/*     */   public PoolingClientConnectionManager() {
/*  96 */     this(SchemeRegistryFactory.createDefault());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PoolingClientConnectionManager(SchemeRegistry paramSchemeRegistry, long paramLong, TimeUnit paramTimeUnit) {
/* 102 */     this(paramSchemeRegistry, paramLong, paramTimeUnit, new SystemDefaultDnsResolver());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PoolingClientConnectionManager(SchemeRegistry paramSchemeRegistry, long paramLong, TimeUnit paramTimeUnit, DnsResolver paramDnsResolver) {
/* 109 */     Args.notNull(paramSchemeRegistry, "Scheme registry");
/* 110 */     Args.notNull(paramDnsResolver, "DNS resolver");
/* 111 */     this.schemeRegistry = paramSchemeRegistry;
/* 112 */     this.dnsResolver = paramDnsResolver;
/* 113 */     this.operator = createConnectionOperator(paramSchemeRegistry);
/* 114 */     this.pool = new HttpConnPool(this.log, this.operator, 2, 20, paramLong, paramTimeUnit);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void finalize() throws Throwable {
/*     */     try {
/* 120 */       shutdown();
/*     */     } finally {
/* 122 */       super.finalize();
/*     */     } 
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
/*     */   protected ClientConnectionOperator createConnectionOperator(SchemeRegistry paramSchemeRegistry) {
/* 139 */     return new DefaultClientConnectionOperator(paramSchemeRegistry, this.dnsResolver);
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemeRegistry getSchemeRegistry() {
/* 144 */     return this.schemeRegistry;
/*     */   }
/*     */   
/*     */   private String format(HttpRoute paramHttpRoute, Object paramObject) {
/* 148 */     StringBuilder stringBuilder = new StringBuilder();
/* 149 */     stringBuilder.append("[route: ").append(paramHttpRoute).append("]");
/* 150 */     if (paramObject != null) {
/* 151 */       stringBuilder.append("[state: ").append(paramObject).append("]");
/*     */     }
/* 153 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private String formatStats(HttpRoute paramHttpRoute) {
/* 157 */     StringBuilder stringBuilder = new StringBuilder();
/* 158 */     PoolStats poolStats1 = this.pool.getTotalStats();
/* 159 */     PoolStats poolStats2 = this.pool.getStats(paramHttpRoute);
/* 160 */     stringBuilder.append("[total kept alive: ").append(poolStats1.getAvailable()).append("; ");
/* 161 */     stringBuilder.append("route allocated: ").append(poolStats2.getLeased() + poolStats2.getAvailable());
/* 162 */     stringBuilder.append(" of ").append(poolStats2.getMax()).append("; ");
/* 163 */     stringBuilder.append("total allocated: ").append(poolStats1.getLeased() + poolStats1.getAvailable());
/* 164 */     stringBuilder.append(" of ").append(poolStats1.getMax()).append("]");
/* 165 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private String format(HttpPoolEntry paramHttpPoolEntry) {
/* 169 */     StringBuilder stringBuilder = new StringBuilder();
/* 170 */     stringBuilder.append("[id: ").append(paramHttpPoolEntry.getId()).append("]");
/* 171 */     stringBuilder.append("[route: ").append(paramHttpPoolEntry.getRoute()).append("]");
/* 172 */     Object object = paramHttpPoolEntry.getState();
/* 173 */     if (object != null) {
/* 174 */       stringBuilder.append("[state: ").append(object).append("]");
/*     */     }
/* 176 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClientConnectionRequest requestConnection(HttpRoute paramHttpRoute, Object paramObject) {
/* 183 */     Args.notNull(paramHttpRoute, "HTTP route");
/* 184 */     if (this.log.isDebugEnabled()) {
/* 185 */       this.log.debug("Connection request: " + format(paramHttpRoute, paramObject) + formatStats(paramHttpRoute));
/*     */     }
/* 187 */     final Future future = this.pool.lease(paramHttpRoute, paramObject);
/*     */     
/* 189 */     return new ClientConnectionRequest()
/*     */       {
/*     */         public void abortRequest()
/*     */         {
/* 193 */           future.cancel(true);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public ManagedClientConnection getConnection(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException, ConnectionPoolTimeoutException {
/* 200 */           return PoolingClientConnectionManager.this.leaseConnection(future, param1Long, param1TimeUnit);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ManagedClientConnection leaseConnection(Future<HttpPoolEntry> paramFuture, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, ConnectionPoolTimeoutException {
/*     */     try {
/* 213 */       HttpPoolEntry httpPoolEntry = paramFuture.get(paramLong, paramTimeUnit);
/* 214 */       if (httpPoolEntry == null || paramFuture.isCancelled()) {
/* 215 */         throw new InterruptedException();
/*     */       }
/* 217 */       Asserts.check((httpPoolEntry.getConnection() != null), "Pool entry with no connection");
/* 218 */       if (this.log.isDebugEnabled()) {
/* 219 */         this.log.debug("Connection leased: " + format(httpPoolEntry) + formatStats((HttpRoute)httpPoolEntry.getRoute()));
/*     */       }
/* 221 */       return new ManagedClientConnectionImpl(this, this.operator, httpPoolEntry);
/* 222 */     } catch (ExecutionException executionException) {
/* 223 */       Throwable throwable = executionException.getCause();
/* 224 */       if (throwable == null) {
/* 225 */         throwable = executionException;
/*     */       }
/* 227 */       this.log.error("Unexpected exception leasing connection from pool", throwable);
/*     */       
/* 229 */       throw new InterruptedException();
/* 230 */     } catch (TimeoutException timeoutException) {
/* 231 */       throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void releaseConnection(ManagedClientConnection paramManagedClientConnection, long paramLong, TimeUnit paramTimeUnit) {
/* 239 */     Args.check(paramManagedClientConnection instanceof ManagedClientConnectionImpl, "Connection class mismatch, connection not obtained from this manager");
/*     */     
/* 241 */     ManagedClientConnectionImpl managedClientConnectionImpl = (ManagedClientConnectionImpl)paramManagedClientConnection;
/* 242 */     Asserts.check((managedClientConnectionImpl.getManager() == this), "Connection not obtained from this manager");
/* 243 */     synchronized (managedClientConnectionImpl) {
/* 244 */       HttpPoolEntry httpPoolEntry = managedClientConnectionImpl.detach();
/* 245 */       if (httpPoolEntry == null) {
/*     */         return;
/*     */       }
/*     */       try {
/* 249 */         if (managedClientConnectionImpl.isOpen() && !managedClientConnectionImpl.isMarkedReusable()) {
/*     */           try {
/* 251 */             managedClientConnectionImpl.shutdown();
/* 252 */           } catch (IOException iOException) {
/* 253 */             if (this.log.isDebugEnabled()) {
/* 254 */               this.log.debug("I/O exception shutting down released connection", iOException);
/*     */             }
/*     */           } 
/*     */         }
/*     */         
/* 259 */         if (managedClientConnectionImpl.isMarkedReusable()) {
/* 260 */           httpPoolEntry.updateExpiry(paramLong, (paramTimeUnit != null) ? paramTimeUnit : TimeUnit.MILLISECONDS);
/* 261 */           if (this.log.isDebugEnabled()) {
/*     */             String str;
/* 263 */             if (paramLong > 0L) {
/* 264 */               str = "for " + paramLong + " " + paramTimeUnit;
/*     */             } else {
/* 266 */               str = "indefinitely";
/*     */             } 
/* 268 */             this.log.debug("Connection " + format(httpPoolEntry) + " can be kept alive " + str);
/*     */           } 
/*     */         } 
/*     */       } finally {
/* 272 */         this.pool.release(httpPoolEntry, managedClientConnectionImpl.isMarkedReusable());
/*     */       } 
/* 274 */       if (this.log.isDebugEnabled()) {
/* 275 */         this.log.debug("Connection released: " + format(httpPoolEntry) + formatStats((HttpRoute)httpPoolEntry.getRoute()));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void shutdown() {
/* 282 */     this.log.debug("Connection manager is shutting down");
/*     */     try {
/* 284 */       this.pool.shutdown();
/* 285 */     } catch (IOException iOException) {
/* 286 */       this.log.debug("I/O exception shutting down connection manager", iOException);
/*     */     } 
/* 288 */     this.log.debug("Connection manager shut down");
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeIdleConnections(long paramLong, TimeUnit paramTimeUnit) {
/* 293 */     if (this.log.isDebugEnabled()) {
/* 294 */       this.log.debug("Closing connections idle longer than " + paramLong + " " + paramTimeUnit);
/*     */     }
/* 296 */     this.pool.closeIdle(paramLong, paramTimeUnit);
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeExpiredConnections() {
/* 301 */     this.log.debug("Closing expired connections");
/* 302 */     this.pool.closeExpired();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxTotal() {
/* 307 */     return this.pool.getMaxTotal();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaxTotal(int paramInt) {
/* 312 */     this.pool.setMaxTotal(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDefaultMaxPerRoute() {
/* 317 */     return this.pool.getDefaultMaxPerRoute();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDefaultMaxPerRoute(int paramInt) {
/* 322 */     this.pool.setDefaultMaxPerRoute(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxPerRoute(HttpRoute paramHttpRoute) {
/* 327 */     return this.pool.getMaxPerRoute(paramHttpRoute);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaxPerRoute(HttpRoute paramHttpRoute, int paramInt) {
/* 332 */     this.pool.setMaxPerRoute(paramHttpRoute, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public PoolStats getTotalStats() {
/* 337 */     return this.pool.getTotalStats();
/*     */   }
/*     */ 
/*     */   
/*     */   public PoolStats getStats(HttpRoute paramHttpRoute) {
/* 342 */     return this.pool.getStats(paramHttpRoute);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\PoolingClientConnectionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */