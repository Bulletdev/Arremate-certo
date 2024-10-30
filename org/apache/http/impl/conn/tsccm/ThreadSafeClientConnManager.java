/*     */ package org.apache.http.impl.conn.tsccm;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.conn.ClientConnectionManager;
/*     */ import org.apache.http.conn.ClientConnectionOperator;
/*     */ import org.apache.http.conn.ClientConnectionRequest;
/*     */ import org.apache.http.conn.ConnectionPoolTimeoutException;
/*     */ import org.apache.http.conn.ManagedClientConnection;
/*     */ import org.apache.http.conn.params.ConnPerRoute;
/*     */ import org.apache.http.conn.params.ConnPerRouteBean;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.conn.scheme.SchemeRegistry;
/*     */ import org.apache.http.impl.conn.DefaultClientConnectionOperator;
/*     */ import org.apache.http.impl.conn.SchemeRegistryFactory;
/*     */ import org.apache.http.params.HttpParams;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/*     */ public class ThreadSafeClientConnManager
/*     */   implements ClientConnectionManager
/*     */ {
/*     */   private final Log log;
/*     */   protected final SchemeRegistry schemeRegistry;
/*     */   protected final AbstractConnPool connectionPool;
/*     */   protected final ConnPoolByRoute pool;
/*     */   protected final ClientConnectionOperator connOperator;
/*     */   protected final ConnPerRouteBean connPerRoute;
/*     */   
/*     */   public ThreadSafeClientConnManager(SchemeRegistry paramSchemeRegistry) {
/*  95 */     this(paramSchemeRegistry, -1L, TimeUnit.MILLISECONDS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ThreadSafeClientConnManager() {
/* 102 */     this(SchemeRegistryFactory.createDefault());
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
/*     */   public ThreadSafeClientConnManager(SchemeRegistry paramSchemeRegistry, long paramLong, TimeUnit paramTimeUnit) {
/* 116 */     this(paramSchemeRegistry, paramLong, paramTimeUnit, new ConnPerRouteBean());
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
/*     */   public ThreadSafeClientConnManager(SchemeRegistry paramSchemeRegistry, long paramLong, TimeUnit paramTimeUnit, ConnPerRouteBean paramConnPerRouteBean) {
/* 134 */     Args.notNull(paramSchemeRegistry, "Scheme registry");
/* 135 */     this.log = LogFactory.getLog(getClass());
/* 136 */     this.schemeRegistry = paramSchemeRegistry;
/* 137 */     this.connPerRoute = paramConnPerRouteBean;
/* 138 */     this.connOperator = createConnectionOperator(paramSchemeRegistry);
/* 139 */     this.pool = createConnectionPool(paramLong, paramTimeUnit);
/* 140 */     this.connectionPool = this.pool;
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
/*     */   @Deprecated
/*     */   public ThreadSafeClientConnManager(HttpParams paramHttpParams, SchemeRegistry paramSchemeRegistry) {
/* 154 */     Args.notNull(paramSchemeRegistry, "Scheme registry");
/* 155 */     this.log = LogFactory.getLog(getClass());
/* 156 */     this.schemeRegistry = paramSchemeRegistry;
/* 157 */     this.connPerRoute = new ConnPerRouteBean();
/* 158 */     this.connOperator = createConnectionOperator(paramSchemeRegistry);
/* 159 */     this.pool = (ConnPoolByRoute)createConnectionPool(paramHttpParams);
/* 160 */     this.connectionPool = this.pool;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void finalize() throws Throwable {
/*     */     try {
/* 166 */       shutdown();
/*     */     } finally {
/* 168 */       super.finalize();
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
/*     */   @Deprecated
/*     */   protected AbstractConnPool createConnectionPool(HttpParams paramHttpParams) {
/* 181 */     return new ConnPoolByRoute(this.connOperator, paramHttpParams);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ConnPoolByRoute createConnectionPool(long paramLong, TimeUnit paramTimeUnit) {
/* 192 */     return new ConnPoolByRoute(this.connOperator, (ConnPerRoute)this.connPerRoute, 20, paramLong, paramTimeUnit);
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
/*     */   protected ClientConnectionOperator createConnectionOperator(SchemeRegistry paramSchemeRegistry) {
/* 210 */     return (ClientConnectionOperator)new DefaultClientConnectionOperator(paramSchemeRegistry);
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemeRegistry getSchemeRegistry() {
/* 215 */     return this.schemeRegistry;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClientConnectionRequest requestConnection(final HttpRoute route, Object paramObject) {
/* 223 */     final PoolEntryRequest poolRequest = this.pool.requestPoolEntry(route, paramObject);
/*     */ 
/*     */     
/* 226 */     return new ClientConnectionRequest()
/*     */       {
/*     */         public void abortRequest()
/*     */         {
/* 230 */           poolRequest.abortRequest();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public ManagedClientConnection getConnection(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException, ConnectionPoolTimeoutException {
/* 237 */           Args.notNull(route, "Route");
/*     */           
/* 239 */           if (ThreadSafeClientConnManager.this.log.isDebugEnabled()) {
/* 240 */             ThreadSafeClientConnManager.this.log.debug("Get connection: " + route + ", timeout = " + param1Long);
/*     */           }
/*     */           
/* 243 */           BasicPoolEntry basicPoolEntry = poolRequest.getPoolEntry(param1Long, param1TimeUnit);
/* 244 */           return (ManagedClientConnection)new BasicPooledConnAdapter(ThreadSafeClientConnManager.this, basicPoolEntry);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void releaseConnection(ManagedClientConnection paramManagedClientConnection, long paramLong, TimeUnit paramTimeUnit) {
/* 253 */     Args.check(paramManagedClientConnection instanceof BasicPooledConnAdapter, "Connection class mismatch, connection not obtained from this manager");
/*     */     
/* 255 */     BasicPooledConnAdapter basicPooledConnAdapter = (BasicPooledConnAdapter)paramManagedClientConnection;
/* 256 */     if (basicPooledConnAdapter.getPoolEntry() != null) {
/* 257 */       Asserts.check((basicPooledConnAdapter.getManager() == this), "Connection not obtained from this manager");
/*     */     }
/* 259 */     synchronized (basicPooledConnAdapter) {
/* 260 */       BasicPoolEntry basicPoolEntry = (BasicPoolEntry)basicPooledConnAdapter.getPoolEntry();
/* 261 */       if (basicPoolEntry == null) {
/*     */         return;
/*     */       }
/*     */       
/*     */       try {
/* 266 */         if (basicPooledConnAdapter.isOpen() && !basicPooledConnAdapter.isMarkedReusable())
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 275 */           basicPooledConnAdapter.shutdown();
/*     */         }
/* 277 */       } catch (IOException iOException) {
/* 278 */         if (this.log.isDebugEnabled()) {
/* 279 */           this.log.debug("Exception shutting down released connection.", iOException);
/*     */         }
/*     */       } finally {
/*     */         
/* 283 */         boolean bool = basicPooledConnAdapter.isMarkedReusable();
/* 284 */         if (this.log.isDebugEnabled()) {
/* 285 */           if (bool) {
/* 286 */             this.log.debug("Released connection is reusable.");
/*     */           } else {
/* 288 */             this.log.debug("Released connection is not reusable.");
/*     */           } 
/*     */         }
/* 291 */         basicPooledConnAdapter.detach();
/* 292 */         this.pool.freeEntry(basicPoolEntry, bool, paramLong, paramTimeUnit);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void shutdown() {
/* 299 */     this.log.debug("Shutting down");
/* 300 */     this.pool.shutdown();
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
/*     */   public int getConnectionsInPool(HttpRoute paramHttpRoute) {
/* 314 */     return this.pool.getConnectionsInPool(paramHttpRoute);
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
/*     */   public int getConnectionsInPool() {
/* 326 */     return this.pool.getConnectionsInPool();
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeIdleConnections(long paramLong, TimeUnit paramTimeUnit) {
/* 331 */     if (this.log.isDebugEnabled()) {
/* 332 */       this.log.debug("Closing connections idle longer than " + paramLong + " " + paramTimeUnit);
/*     */     }
/* 334 */     this.pool.closeIdleConnections(paramLong, paramTimeUnit);
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeExpiredConnections() {
/* 339 */     this.log.debug("Closing expired connections");
/* 340 */     this.pool.closeExpiredConnections();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxTotal() {
/* 347 */     return this.pool.getMaxTotalConnections();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxTotal(int paramInt) {
/* 354 */     this.pool.setMaxTotalConnections(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDefaultMaxPerRoute() {
/* 361 */     return this.connPerRoute.getDefaultMaxPerRoute();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultMaxPerRoute(int paramInt) {
/* 368 */     this.connPerRoute.setDefaultMaxPerRoute(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxForRoute(HttpRoute paramHttpRoute) {
/* 375 */     return this.connPerRoute.getMaxForRoute(paramHttpRoute);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxForRoute(HttpRoute paramHttpRoute, int paramInt) {
/* 382 */     this.connPerRoute.setMaxForRoute(paramHttpRoute, paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\tsccm\ThreadSafeClientConnManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */