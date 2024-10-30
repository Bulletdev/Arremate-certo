/*     */ package org.apache.http.impl.conn;
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
/*     */ import org.apache.http.conn.ManagedClientConnection;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.conn.routing.RouteTracker;
/*     */ import org.apache.http.conn.scheme.SchemeRegistry;
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
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public class SingleClientConnManager
/*     */   implements ClientConnectionManager
/*     */ {
/*  68 */   private final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String MISUSE_MESSAGE = "Invalid use of SingleClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.";
/*     */ 
/*     */ 
/*     */   
/*     */   protected final SchemeRegistry schemeRegistry;
/*     */ 
/*     */ 
/*     */   
/*     */   protected final ClientConnectionOperator connOperator;
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean alwaysShutDown;
/*     */ 
/*     */ 
/*     */   
/*     */   protected volatile PoolEntry uniquePoolEntry;
/*     */ 
/*     */ 
/*     */   
/*     */   protected volatile ConnAdapter managedConn;
/*     */ 
/*     */ 
/*     */   
/*     */   protected volatile long lastReleaseTime;
/*     */ 
/*     */ 
/*     */   
/*     */   protected volatile long connectionExpiresTime;
/*     */ 
/*     */ 
/*     */   
/*     */   protected volatile boolean isShutDown;
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public SingleClientConnManager(HttpParams paramHttpParams, SchemeRegistry paramSchemeRegistry) {
/* 110 */     this(paramSchemeRegistry);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SingleClientConnManager(SchemeRegistry paramSchemeRegistry) {
/* 118 */     Args.notNull(paramSchemeRegistry, "Scheme registry");
/* 119 */     this.schemeRegistry = paramSchemeRegistry;
/* 120 */     this.connOperator = createConnectionOperator(paramSchemeRegistry);
/* 121 */     this.uniquePoolEntry = new PoolEntry();
/* 122 */     this.managedConn = null;
/* 123 */     this.lastReleaseTime = -1L;
/* 124 */     this.alwaysShutDown = false;
/* 125 */     this.isShutDown = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SingleClientConnManager() {
/* 132 */     this(SchemeRegistryFactory.createDefault());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void finalize() throws Throwable {
/*     */     try {
/* 138 */       shutdown();
/*     */     } finally {
/* 140 */       super.finalize();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemeRegistry getSchemeRegistry() {
/* 146 */     return this.schemeRegistry;
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
/*     */   protected ClientConnectionOperator createConnectionOperator(SchemeRegistry paramSchemeRegistry) {
/* 163 */     return new DefaultClientConnectionOperator(paramSchemeRegistry);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void assertStillUp() throws IllegalStateException {
/* 172 */     Asserts.check(!this.isShutDown, "Manager is shut down");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ClientConnectionRequest requestConnection(final HttpRoute route, final Object state) {
/* 180 */     return new ClientConnectionRequest()
/*     */       {
/*     */         public void abortRequest() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public ManagedClientConnection getConnection(long param1Long, TimeUnit param1TimeUnit) {
/* 190 */           return SingleClientConnManager.this.getConnection(route, state);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ManagedClientConnection getConnection(HttpRoute paramHttpRoute, Object paramObject) {
/* 206 */     Args.notNull(paramHttpRoute, "Route");
/* 207 */     assertStillUp();
/*     */     
/* 209 */     if (this.log.isDebugEnabled()) {
/* 210 */       this.log.debug("Get connection for route " + paramHttpRoute);
/*     */     }
/*     */     
/* 213 */     synchronized (this) {
/*     */       
/* 215 */       Asserts.check((this.managedConn == null), "Invalid use of SingleClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.");
/*     */ 
/*     */       
/* 218 */       boolean bool1 = false;
/* 219 */       boolean bool2 = false;
/*     */ 
/*     */       
/* 222 */       closeExpiredConnections();
/*     */       
/* 224 */       if (this.uniquePoolEntry.connection.isOpen()) {
/* 225 */         RouteTracker routeTracker = this.uniquePoolEntry.tracker;
/* 226 */         bool2 = (routeTracker == null || !routeTracker.toRoute().equals(paramHttpRoute)) ? true : false;
/*     */ 
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */ 
/*     */         
/* 234 */         bool1 = true;
/*     */       } 
/*     */       
/* 237 */       if (bool2) {
/* 238 */         bool1 = true;
/*     */         try {
/* 240 */           this.uniquePoolEntry.shutdown();
/* 241 */         } catch (IOException iOException) {
/* 242 */           this.log.debug("Problem shutting down connection.", iOException);
/*     */         } 
/*     */       } 
/*     */       
/* 246 */       if (bool1) {
/* 247 */         this.uniquePoolEntry = new PoolEntry();
/*     */       }
/*     */       
/* 250 */       this.managedConn = new ConnAdapter(this.uniquePoolEntry, paramHttpRoute);
/*     */       
/* 252 */       return this.managedConn;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void releaseConnection(ManagedClientConnection paramManagedClientConnection, long paramLong, TimeUnit paramTimeUnit) {
/* 260 */     Args.check(paramManagedClientConnection instanceof ConnAdapter, "Connection class mismatch, connection not obtained from this manager");
/*     */     
/* 262 */     assertStillUp();
/*     */     
/* 264 */     if (this.log.isDebugEnabled()) {
/* 265 */       this.log.debug("Releasing connection " + paramManagedClientConnection);
/*     */     }
/*     */     
/* 268 */     ConnAdapter connAdapter = (ConnAdapter)paramManagedClientConnection;
/* 269 */     synchronized (connAdapter) {
/* 270 */       if (connAdapter.poolEntry == null) {
/*     */         return;
/*     */       }
/*     */       
/* 274 */       ClientConnectionManager clientConnectionManager = connAdapter.getManager();
/* 275 */       Asserts.check((clientConnectionManager == this), "Connection not obtained from this manager");
/*     */       
/*     */       try {
/* 278 */         if (connAdapter.isOpen() && (this.alwaysShutDown || !connAdapter.isMarkedReusable())) {
/*     */ 
/*     */           
/* 281 */           if (this.log.isDebugEnabled()) {
/* 282 */             this.log.debug("Released connection open but not reusable.");
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 289 */           connAdapter.shutdown();
/*     */         } 
/* 291 */       } catch (IOException iOException) {
/* 292 */         if (this.log.isDebugEnabled()) {
/* 293 */           this.log.debug("Exception shutting down released connection.", iOException);
/*     */         }
/*     */       } finally {
/*     */         
/* 297 */         connAdapter.detach();
/* 298 */         synchronized (this) {
/* 299 */           this.managedConn = null;
/* 300 */           this.lastReleaseTime = System.currentTimeMillis();
/* 301 */           if (paramLong > 0L) {
/* 302 */             this.connectionExpiresTime = paramTimeUnit.toMillis(paramLong) + this.lastReleaseTime;
/*     */           } else {
/* 304 */             this.connectionExpiresTime = Long.MAX_VALUE;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeExpiredConnections() {
/* 313 */     long l = this.connectionExpiresTime;
/* 314 */     if (System.currentTimeMillis() >= l) {
/* 315 */       closeIdleConnections(0L, TimeUnit.MILLISECONDS);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeIdleConnections(long paramLong, TimeUnit paramTimeUnit) {
/* 321 */     assertStillUp();
/*     */ 
/*     */     
/* 324 */     Args.notNull(paramTimeUnit, "Time unit");
/*     */     
/* 326 */     synchronized (this) {
/* 327 */       if (this.managedConn == null && this.uniquePoolEntry.connection.isOpen()) {
/* 328 */         long l = System.currentTimeMillis() - paramTimeUnit.toMillis(paramLong);
/*     */         
/* 330 */         if (this.lastReleaseTime <= l) {
/*     */           try {
/* 332 */             this.uniquePoolEntry.close();
/* 333 */           } catch (IOException iOException) {
/*     */             
/* 335 */             this.log.debug("Problem closing idle connection.", iOException);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void shutdown() {
/* 344 */     this.isShutDown = true;
/* 345 */     synchronized (this) {
/*     */       try {
/* 347 */         if (this.uniquePoolEntry != null) {
/* 348 */           this.uniquePoolEntry.shutdown();
/*     */         }
/* 350 */       } catch (IOException iOException) {
/*     */         
/* 352 */         this.log.debug("Problem while shutting down manager.", iOException);
/*     */       } finally {
/* 354 */         this.uniquePoolEntry = null;
/* 355 */         this.managedConn = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void revokeConnection() {
/* 361 */     ConnAdapter connAdapter = this.managedConn;
/* 362 */     if (connAdapter == null) {
/*     */       return;
/*     */     }
/* 365 */     connAdapter.detach();
/*     */     
/* 367 */     synchronized (this) {
/*     */       try {
/* 369 */         this.uniquePoolEntry.shutdown();
/* 370 */       } catch (IOException iOException) {
/*     */         
/* 372 */         this.log.debug("Problem while shutting down connection.", iOException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected class PoolEntry
/*     */     extends AbstractPoolEntry
/*     */   {
/*     */     protected PoolEntry() {
/* 387 */       super(SingleClientConnManager.this.connOperator, null);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void close() throws IOException {
/* 394 */       shutdownEntry();
/* 395 */       if (this.connection.isOpen()) {
/* 396 */         this.connection.close();
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void shutdown() throws IOException {
/* 404 */       shutdownEntry();
/* 405 */       if (this.connection.isOpen()) {
/* 406 */         this.connection.shutdown();
/*     */       }
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
/*     */   protected class ConnAdapter
/*     */     extends AbstractPooledConnAdapter
/*     */   {
/*     */     protected ConnAdapter(SingleClientConnManager.PoolEntry param1PoolEntry, HttpRoute param1HttpRoute) {
/* 424 */       super(SingleClientConnManager.this, param1PoolEntry);
/* 425 */       markReusable();
/* 426 */       param1PoolEntry.route = param1HttpRoute;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\SingleClientConnManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */