/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.CancellationException;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.TimeoutException;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.HttpClientConnection;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.config.ConnectionConfig;
/*     */ import org.apache.http.config.Lookup;
/*     */ import org.apache.http.config.Registry;
/*     */ import org.apache.http.config.RegistryBuilder;
/*     */ import org.apache.http.config.SocketConfig;
/*     */ import org.apache.http.conn.ConnectionPoolTimeoutException;
/*     */ import org.apache.http.conn.ConnectionRequest;
/*     */ import org.apache.http.conn.DnsResolver;
/*     */ import org.apache.http.conn.HttpClientConnectionManager;
/*     */ import org.apache.http.conn.HttpClientConnectionOperator;
/*     */ import org.apache.http.conn.HttpConnectionFactory;
/*     */ import org.apache.http.conn.ManagedHttpClientConnection;
/*     */ import org.apache.http.conn.SchemePortResolver;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.conn.socket.ConnectionSocketFactory;
/*     */ import org.apache.http.conn.socket.PlainConnectionSocketFactory;
/*     */ import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
/*     */ import org.apache.http.pool.ConnFactory;
/*     */ import org.apache.http.pool.ConnPoolControl;
/*     */ import org.apache.http.pool.PoolEntry;
/*     */ import org.apache.http.pool.PoolEntryCallback;
/*     */ import org.apache.http.pool.PoolStats;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/*     */ public class PoolingHttpClientConnectionManager
/*     */   implements Closeable, HttpClientConnectionManager, ConnPoolControl<HttpRoute>
/*     */ {
/* 108 */   private final Log log = LogFactory.getLog(getClass());
/*     */   
/*     */   private final ConfigData configData;
/*     */   private final CPool pool;
/*     */   private final HttpClientConnectionOperator connectionOperator;
/*     */   private final AtomicBoolean isShutDown;
/*     */   
/*     */   private static Registry<ConnectionSocketFactory> getDefaultRegistry() {
/* 116 */     return RegistryBuilder.create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", SSLConnectionSocketFactory.getSocketFactory()).build();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PoolingHttpClientConnectionManager() {
/* 123 */     this(getDefaultRegistry());
/*     */   }
/*     */   
/*     */   public PoolingHttpClientConnectionManager(long paramLong, TimeUnit paramTimeUnit) {
/* 127 */     this(getDefaultRegistry(), null, null, null, paramLong, paramTimeUnit);
/*     */   }
/*     */ 
/*     */   
/*     */   public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> paramRegistry) {
/* 132 */     this(paramRegistry, null, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> paramRegistry, DnsResolver paramDnsResolver) {
/* 138 */     this(paramRegistry, null, paramDnsResolver);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> paramRegistry, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> paramHttpConnectionFactory) {
/* 144 */     this(paramRegistry, paramHttpConnectionFactory, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public PoolingHttpClientConnectionManager(HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> paramHttpConnectionFactory) {
/* 149 */     this(getDefaultRegistry(), paramHttpConnectionFactory, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> paramRegistry, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> paramHttpConnectionFactory, DnsResolver paramDnsResolver) {
/* 156 */     this(paramRegistry, paramHttpConnectionFactory, null, paramDnsResolver, -1L, TimeUnit.MILLISECONDS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PoolingHttpClientConnectionManager(Registry<ConnectionSocketFactory> paramRegistry, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> paramHttpConnectionFactory, SchemePortResolver paramSchemePortResolver, DnsResolver paramDnsResolver, long paramLong, TimeUnit paramTimeUnit) {
/* 165 */     this(new DefaultHttpClientConnectionOperator((Lookup<ConnectionSocketFactory>)paramRegistry, paramSchemePortResolver, paramDnsResolver), paramHttpConnectionFactory, paramLong, paramTimeUnit);
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
/*     */   public PoolingHttpClientConnectionManager(HttpClientConnectionOperator paramHttpClientConnectionOperator, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> paramHttpConnectionFactory, long paramLong, TimeUnit paramTimeUnit) {
/* 180 */     this.configData = new ConfigData();
/* 181 */     this.pool = new CPool(new InternalConnectionFactory(this.configData, paramHttpConnectionFactory), 2, 20, paramLong, paramTimeUnit);
/*     */     
/* 183 */     this.pool.setValidateAfterInactivity(2000);
/* 184 */     this.connectionOperator = (HttpClientConnectionOperator)Args.notNull(paramHttpClientConnectionOperator, "HttpClientConnectionOperator");
/* 185 */     this.isShutDown = new AtomicBoolean(false);
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
/*     */   PoolingHttpClientConnectionManager(CPool paramCPool, Lookup<ConnectionSocketFactory> paramLookup, SchemePortResolver paramSchemePortResolver, DnsResolver paramDnsResolver) {
/* 197 */     this.configData = new ConfigData();
/* 198 */     this.pool = paramCPool;
/* 199 */     this.connectionOperator = new DefaultHttpClientConnectionOperator(paramLookup, paramSchemePortResolver, paramDnsResolver);
/*     */     
/* 201 */     this.isShutDown = new AtomicBoolean(false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void finalize() throws Throwable {
/*     */     try {
/* 207 */       shutdown();
/*     */     } finally {
/* 209 */       super.finalize();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 215 */     shutdown();
/*     */   }
/*     */   
/*     */   private String format(HttpRoute paramHttpRoute, Object paramObject) {
/* 219 */     StringBuilder stringBuilder = new StringBuilder();
/* 220 */     stringBuilder.append("[route: ").append(paramHttpRoute).append("]");
/* 221 */     if (paramObject != null) {
/* 222 */       stringBuilder.append("[state: ").append(paramObject).append("]");
/*     */     }
/* 224 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private String formatStats(HttpRoute paramHttpRoute) {
/* 228 */     StringBuilder stringBuilder = new StringBuilder();
/* 229 */     PoolStats poolStats1 = this.pool.getTotalStats();
/* 230 */     PoolStats poolStats2 = this.pool.getStats(paramHttpRoute);
/* 231 */     stringBuilder.append("[total available: ").append(poolStats1.getAvailable()).append("; ");
/* 232 */     stringBuilder.append("route allocated: ").append(poolStats2.getLeased() + poolStats2.getAvailable());
/* 233 */     stringBuilder.append(" of ").append(poolStats2.getMax()).append("; ");
/* 234 */     stringBuilder.append("total allocated: ").append(poolStats1.getLeased() + poolStats1.getAvailable());
/* 235 */     stringBuilder.append(" of ").append(poolStats1.getMax()).append("]");
/* 236 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private String format(CPoolEntry paramCPoolEntry) {
/* 240 */     StringBuilder stringBuilder = new StringBuilder();
/* 241 */     stringBuilder.append("[id: ").append(paramCPoolEntry.getId()).append("]");
/* 242 */     stringBuilder.append("[route: ").append(paramCPoolEntry.getRoute()).append("]");
/* 243 */     Object object = paramCPoolEntry.getState();
/* 244 */     if (object != null) {
/* 245 */       stringBuilder.append("[state: ").append(object).append("]");
/*     */     }
/* 247 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private SocketConfig resolveSocketConfig(HttpHost paramHttpHost) {
/* 251 */     SocketConfig socketConfig = this.configData.getSocketConfig(paramHttpHost);
/* 252 */     if (socketConfig == null) {
/* 253 */       socketConfig = this.configData.getDefaultSocketConfig();
/*     */     }
/* 255 */     if (socketConfig == null) {
/* 256 */       socketConfig = SocketConfig.DEFAULT;
/*     */     }
/* 258 */     return socketConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ConnectionRequest requestConnection(final HttpRoute route, Object paramObject) {
/* 265 */     Args.notNull(route, "HTTP route");
/* 266 */     if (this.log.isDebugEnabled()) {
/* 267 */       this.log.debug("Connection request: " + format(route, paramObject) + formatStats(route));
/*     */     }
/* 269 */     Asserts.check(!this.isShutDown.get(), "Connection pool shut down");
/* 270 */     final Future future = this.pool.lease(route, paramObject, null);
/* 271 */     return new ConnectionRequest()
/*     */       {
/*     */         public boolean cancel()
/*     */         {
/* 275 */           return future.cancel(true);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public HttpClientConnection get(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException, ExecutionException, ConnectionPoolTimeoutException {
/* 282 */           HttpClientConnection httpClientConnection = PoolingHttpClientConnectionManager.this.leaseConnection(future, param1Long, param1TimeUnit);
/* 283 */           if (httpClientConnection.isOpen()) {
/*     */             HttpHost httpHost;
/* 285 */             if (route.getProxyHost() != null) {
/* 286 */               httpHost = route.getProxyHost();
/*     */             } else {
/* 288 */               httpHost = route.getTargetHost();
/*     */             } 
/* 290 */             SocketConfig socketConfig = PoolingHttpClientConnectionManager.this.resolveSocketConfig(httpHost);
/* 291 */             httpClientConnection.setSocketTimeout(socketConfig.getSoTimeout());
/*     */           } 
/* 293 */           return httpClientConnection;
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
/*     */   protected HttpClientConnection leaseConnection(Future<CPoolEntry> paramFuture, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, ExecutionException, ConnectionPoolTimeoutException {
/*     */     try {
/* 306 */       CPoolEntry cPoolEntry = paramFuture.get(paramLong, paramTimeUnit);
/* 307 */       if (cPoolEntry == null || paramFuture.isCancelled()) {
/* 308 */         throw new ExecutionException(new CancellationException("Operation cancelled"));
/*     */       }
/* 310 */       Asserts.check((cPoolEntry.getConnection() != null), "Pool entry with no connection");
/* 311 */       if (this.log.isDebugEnabled()) {
/* 312 */         this.log.debug("Connection leased: " + format(cPoolEntry) + formatStats((HttpRoute)cPoolEntry.getRoute()));
/*     */       }
/* 314 */       return CPoolProxy.newProxy(cPoolEntry);
/* 315 */     } catch (TimeoutException timeoutException) {
/* 316 */       throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void releaseConnection(HttpClientConnection paramHttpClientConnection, Object paramObject, long paramLong, TimeUnit paramTimeUnit) {
/* 325 */     Args.notNull(paramHttpClientConnection, "Managed connection");
/* 326 */     synchronized (paramHttpClientConnection) {
/* 327 */       CPoolEntry cPoolEntry = CPoolProxy.detach(paramHttpClientConnection);
/* 328 */       if (cPoolEntry == null) {
/*     */         return;
/*     */       }
/* 331 */       ManagedHttpClientConnection managedHttpClientConnection = (ManagedHttpClientConnection)cPoolEntry.getConnection();
/*     */       try {
/* 333 */         if (managedHttpClientConnection.isOpen()) {
/* 334 */           TimeUnit timeUnit = (paramTimeUnit != null) ? paramTimeUnit : TimeUnit.MILLISECONDS;
/* 335 */           cPoolEntry.setState(paramObject);
/* 336 */           cPoolEntry.updateExpiry(paramLong, timeUnit);
/* 337 */           if (this.log.isDebugEnabled()) {
/*     */             String str;
/* 339 */             if (paramLong > 0L) {
/* 340 */               str = "for " + (timeUnit.toMillis(paramLong) / 1000.0D) + " seconds";
/*     */             } else {
/* 342 */               str = "indefinitely";
/*     */             } 
/* 344 */             this.log.debug("Connection " + format(cPoolEntry) + " can be kept alive " + str);
/*     */           } 
/* 346 */           managedHttpClientConnection.setSocketTimeout(0);
/*     */         } 
/*     */       } finally {
/* 349 */         this.pool.release(cPoolEntry, (managedHttpClientConnection.isOpen() && cPoolEntry.isRouteComplete()));
/* 350 */         if (this.log.isDebugEnabled()) {
/* 351 */           this.log.debug("Connection released: " + format(cPoolEntry) + formatStats((HttpRoute)cPoolEntry.getRoute()));
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void connect(HttpClientConnection paramHttpClientConnection, HttpRoute paramHttpRoute, int paramInt, HttpContext paramHttpContext) throws IOException {
/*     */     ManagedHttpClientConnection managedHttpClientConnection;
/*     */     HttpHost httpHost;
/* 363 */     Args.notNull(paramHttpClientConnection, "Managed Connection");
/* 364 */     Args.notNull(paramHttpRoute, "HTTP route");
/*     */     
/* 366 */     synchronized (paramHttpClientConnection) {
/* 367 */       CPoolEntry cPoolEntry = CPoolProxy.getPoolEntry(paramHttpClientConnection);
/* 368 */       managedHttpClientConnection = (ManagedHttpClientConnection)cPoolEntry.getConnection();
/*     */     } 
/*     */     
/* 371 */     if (paramHttpRoute.getProxyHost() != null) {
/* 372 */       httpHost = paramHttpRoute.getProxyHost();
/*     */     } else {
/* 374 */       httpHost = paramHttpRoute.getTargetHost();
/*     */     } 
/* 376 */     this.connectionOperator.connect(managedHttpClientConnection, httpHost, paramHttpRoute.getLocalSocketAddress(), paramInt, resolveSocketConfig(httpHost), paramHttpContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void upgrade(HttpClientConnection paramHttpClientConnection, HttpRoute paramHttpRoute, HttpContext paramHttpContext) throws IOException {
/*     */     ManagedHttpClientConnection managedHttpClientConnection;
/* 385 */     Args.notNull(paramHttpClientConnection, "Managed Connection");
/* 386 */     Args.notNull(paramHttpRoute, "HTTP route");
/*     */     
/* 388 */     synchronized (paramHttpClientConnection) {
/* 389 */       CPoolEntry cPoolEntry = CPoolProxy.getPoolEntry(paramHttpClientConnection);
/* 390 */       managedHttpClientConnection = (ManagedHttpClientConnection)cPoolEntry.getConnection();
/*     */     } 
/* 392 */     this.connectionOperator.upgrade(managedHttpClientConnection, paramHttpRoute.getTargetHost(), paramHttpContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void routeComplete(HttpClientConnection paramHttpClientConnection, HttpRoute paramHttpRoute, HttpContext paramHttpContext) throws IOException {
/* 400 */     Args.notNull(paramHttpClientConnection, "Managed Connection");
/* 401 */     Args.notNull(paramHttpRoute, "HTTP route");
/* 402 */     synchronized (paramHttpClientConnection) {
/* 403 */       CPoolEntry cPoolEntry = CPoolProxy.getPoolEntry(paramHttpClientConnection);
/* 404 */       cPoolEntry.markRouteComplete();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void shutdown() {
/* 410 */     if (this.isShutDown.compareAndSet(false, true)) {
/* 411 */       this.log.debug("Connection manager is shutting down");
/*     */       try {
/* 413 */         this.pool.enumLeased(new PoolEntryCallback<HttpRoute, ManagedHttpClientConnection>()
/*     */             {
/*     */               public void process(PoolEntry<HttpRoute, ManagedHttpClientConnection> param1PoolEntry)
/*     */               {
/* 417 */                 ManagedHttpClientConnection managedHttpClientConnection = (ManagedHttpClientConnection)param1PoolEntry.getConnection();
/* 418 */                 if (managedHttpClientConnection != null) {
/*     */                   try {
/* 420 */                     managedHttpClientConnection.shutdown();
/* 421 */                   } catch (IOException iOException) {
/* 422 */                     if (PoolingHttpClientConnectionManager.this.log.isDebugEnabled()) {
/* 423 */                       PoolingHttpClientConnectionManager.this.log.debug("I/O exception shutting down connection", iOException);
/*     */                     }
/*     */                   } 
/*     */                 }
/*     */               }
/*     */             });
/*     */         
/* 430 */         this.pool.shutdown();
/* 431 */       } catch (IOException iOException) {
/* 432 */         this.log.debug("I/O exception shutting down connection manager", iOException);
/*     */       } 
/* 434 */       this.log.debug("Connection manager shut down");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeIdleConnections(long paramLong, TimeUnit paramTimeUnit) {
/* 440 */     if (this.log.isDebugEnabled()) {
/* 441 */       this.log.debug("Closing connections idle longer than " + paramLong + " " + paramTimeUnit);
/*     */     }
/* 443 */     this.pool.closeIdle(paramLong, paramTimeUnit);
/*     */   }
/*     */ 
/*     */   
/*     */   public void closeExpiredConnections() {
/* 448 */     this.log.debug("Closing expired connections");
/* 449 */     this.pool.closeExpired();
/*     */   }
/*     */   
/*     */   protected void enumAvailable(PoolEntryCallback<HttpRoute, ManagedHttpClientConnection> paramPoolEntryCallback) {
/* 453 */     this.pool.enumAvailable(paramPoolEntryCallback);
/*     */   }
/*     */   
/*     */   protected void enumLeased(PoolEntryCallback<HttpRoute, ManagedHttpClientConnection> paramPoolEntryCallback) {
/* 457 */     this.pool.enumLeased(paramPoolEntryCallback);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxTotal() {
/* 462 */     return this.pool.getMaxTotal();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaxTotal(int paramInt) {
/* 467 */     this.pool.setMaxTotal(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDefaultMaxPerRoute() {
/* 472 */     return this.pool.getDefaultMaxPerRoute();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDefaultMaxPerRoute(int paramInt) {
/* 477 */     this.pool.setDefaultMaxPerRoute(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxPerRoute(HttpRoute paramHttpRoute) {
/* 482 */     return this.pool.getMaxPerRoute(paramHttpRoute);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaxPerRoute(HttpRoute paramHttpRoute, int paramInt) {
/* 487 */     this.pool.setMaxPerRoute(paramHttpRoute, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public PoolStats getTotalStats() {
/* 492 */     return this.pool.getTotalStats();
/*     */   }
/*     */ 
/*     */   
/*     */   public PoolStats getStats(HttpRoute paramHttpRoute) {
/* 497 */     return this.pool.getStats(paramHttpRoute);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<HttpRoute> getRoutes() {
/* 504 */     return this.pool.getRoutes();
/*     */   }
/*     */   
/*     */   public SocketConfig getDefaultSocketConfig() {
/* 508 */     return this.configData.getDefaultSocketConfig();
/*     */   }
/*     */   
/*     */   public void setDefaultSocketConfig(SocketConfig paramSocketConfig) {
/* 512 */     this.configData.setDefaultSocketConfig(paramSocketConfig);
/*     */   }
/*     */   
/*     */   public ConnectionConfig getDefaultConnectionConfig() {
/* 516 */     return this.configData.getDefaultConnectionConfig();
/*     */   }
/*     */   
/*     */   public void setDefaultConnectionConfig(ConnectionConfig paramConnectionConfig) {
/* 520 */     this.configData.setDefaultConnectionConfig(paramConnectionConfig);
/*     */   }
/*     */   
/*     */   public SocketConfig getSocketConfig(HttpHost paramHttpHost) {
/* 524 */     return this.configData.getSocketConfig(paramHttpHost);
/*     */   }
/*     */   
/*     */   public void setSocketConfig(HttpHost paramHttpHost, SocketConfig paramSocketConfig) {
/* 528 */     this.configData.setSocketConfig(paramHttpHost, paramSocketConfig);
/*     */   }
/*     */   
/*     */   public ConnectionConfig getConnectionConfig(HttpHost paramHttpHost) {
/* 532 */     return this.configData.getConnectionConfig(paramHttpHost);
/*     */   }
/*     */   
/*     */   public void setConnectionConfig(HttpHost paramHttpHost, ConnectionConfig paramConnectionConfig) {
/* 536 */     this.configData.setConnectionConfig(paramHttpHost, paramConnectionConfig);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getValidateAfterInactivity() {
/* 545 */     return this.pool.getValidateAfterInactivity();
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
/*     */   public void setValidateAfterInactivity(int paramInt) {
/* 560 */     this.pool.setValidateAfterInactivity(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class ConfigData
/*     */   {
/* 572 */     private final Map<HttpHost, SocketConfig> socketConfigMap = new ConcurrentHashMap<HttpHost, SocketConfig>();
/* 573 */     private final Map<HttpHost, ConnectionConfig> connectionConfigMap = new ConcurrentHashMap<HttpHost, ConnectionConfig>();
/*     */     private volatile SocketConfig defaultSocketConfig;
/*     */     
/*     */     public SocketConfig getDefaultSocketConfig() {
/* 577 */       return this.defaultSocketConfig;
/*     */     }
/*     */     private volatile ConnectionConfig defaultConnectionConfig;
/*     */     public void setDefaultSocketConfig(SocketConfig param1SocketConfig) {
/* 581 */       this.defaultSocketConfig = param1SocketConfig;
/*     */     }
/*     */     
/*     */     public ConnectionConfig getDefaultConnectionConfig() {
/* 585 */       return this.defaultConnectionConfig;
/*     */     }
/*     */     
/*     */     public void setDefaultConnectionConfig(ConnectionConfig param1ConnectionConfig) {
/* 589 */       this.defaultConnectionConfig = param1ConnectionConfig;
/*     */     }
/*     */     
/*     */     public SocketConfig getSocketConfig(HttpHost param1HttpHost) {
/* 593 */       return this.socketConfigMap.get(param1HttpHost);
/*     */     }
/*     */     
/*     */     public void setSocketConfig(HttpHost param1HttpHost, SocketConfig param1SocketConfig) {
/* 597 */       this.socketConfigMap.put(param1HttpHost, param1SocketConfig);
/*     */     }
/*     */     
/*     */     public ConnectionConfig getConnectionConfig(HttpHost param1HttpHost) {
/* 601 */       return this.connectionConfigMap.get(param1HttpHost);
/*     */     }
/*     */     
/*     */     public void setConnectionConfig(HttpHost param1HttpHost, ConnectionConfig param1ConnectionConfig) {
/* 605 */       this.connectionConfigMap.put(param1HttpHost, param1ConnectionConfig);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class InternalConnectionFactory
/*     */     implements ConnFactory<HttpRoute, ManagedHttpClientConnection>
/*     */   {
/*     */     private final PoolingHttpClientConnectionManager.ConfigData configData;
/*     */     
/*     */     private final HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory;
/*     */ 
/*     */     
/*     */     InternalConnectionFactory(PoolingHttpClientConnectionManager.ConfigData param1ConfigData, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> param1HttpConnectionFactory) {
/* 619 */       this.configData = (param1ConfigData != null) ? param1ConfigData : new PoolingHttpClientConnectionManager.ConfigData();
/* 620 */       this.connFactory = (param1HttpConnectionFactory != null) ? param1HttpConnectionFactory : ManagedHttpClientConnectionFactory.INSTANCE;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public ManagedHttpClientConnection create(HttpRoute param1HttpRoute) throws IOException {
/* 626 */       ConnectionConfig connectionConfig = null;
/* 627 */       if (param1HttpRoute.getProxyHost() != null) {
/* 628 */         connectionConfig = this.configData.getConnectionConfig(param1HttpRoute.getProxyHost());
/*     */       }
/* 630 */       if (connectionConfig == null) {
/* 631 */         connectionConfig = this.configData.getConnectionConfig(param1HttpRoute.getTargetHost());
/*     */       }
/* 633 */       if (connectionConfig == null) {
/* 634 */         connectionConfig = this.configData.getDefaultConnectionConfig();
/*     */       }
/* 636 */       if (connectionConfig == null) {
/* 637 */         connectionConfig = ConnectionConfig.DEFAULT;
/*     */       }
/* 639 */       return (ManagedHttpClientConnection)this.connFactory.create(param1HttpRoute, connectionConfig);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\PoolingHttpClientConnectionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */