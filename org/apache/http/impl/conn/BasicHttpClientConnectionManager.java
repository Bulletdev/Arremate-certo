/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.util.Date;
/*     */ import java.util.concurrent.TimeUnit;
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
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.Asserts;
/*     */ import org.apache.http.util.LangUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class BasicHttpClientConnectionManager
/*     */   implements Closeable, HttpClientConnectionManager
/*     */ {
/*  85 */   private final Log log = LogFactory.getLog(getClass());
/*     */   
/*     */   private final HttpClientConnectionOperator connectionOperator;
/*     */   
/*     */   private final HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory;
/*     */   
/*     */   private ManagedHttpClientConnection conn;
/*     */   private HttpRoute route;
/*     */   private Object state;
/*     */   private long updated;
/*     */   private long expiry;
/*     */   private boolean leased;
/*     */   private SocketConfig socketConfig;
/*     */   private ConnectionConfig connConfig;
/*     */   private final AtomicBoolean isShutdown;
/*     */   
/*     */   private static Registry<ConnectionSocketFactory> getDefaultRegistry() {
/* 102 */     return RegistryBuilder.create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register("https", SSLConnectionSocketFactory.getSocketFactory()).build();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasicHttpClientConnectionManager(Lookup<ConnectionSocketFactory> paramLookup, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> paramHttpConnectionFactory, SchemePortResolver paramSchemePortResolver, DnsResolver paramDnsResolver) {
/* 113 */     this(new DefaultHttpClientConnectionOperator(paramLookup, paramSchemePortResolver, paramDnsResolver), paramHttpConnectionFactory);
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
/*     */   public BasicHttpClientConnectionManager(HttpClientConnectionOperator paramHttpClientConnectionOperator, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> paramHttpConnectionFactory) {
/* 126 */     this.connectionOperator = (HttpClientConnectionOperator)Args.notNull(paramHttpClientConnectionOperator, "Connection operator");
/* 127 */     this.connFactory = (paramHttpConnectionFactory != null) ? paramHttpConnectionFactory : ManagedHttpClientConnectionFactory.INSTANCE;
/* 128 */     this.expiry = Long.MAX_VALUE;
/* 129 */     this.socketConfig = SocketConfig.DEFAULT;
/* 130 */     this.connConfig = ConnectionConfig.DEFAULT;
/* 131 */     this.isShutdown = new AtomicBoolean(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BasicHttpClientConnectionManager(Lookup<ConnectionSocketFactory> paramLookup, HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> paramHttpConnectionFactory) {
/* 137 */     this(paramLookup, paramHttpConnectionFactory, null, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public BasicHttpClientConnectionManager(Lookup<ConnectionSocketFactory> paramLookup) {
/* 142 */     this(paramLookup, null, null, null);
/*     */   }
/*     */   
/*     */   public BasicHttpClientConnectionManager() {
/* 146 */     this((Lookup<ConnectionSocketFactory>)getDefaultRegistry(), null, null, null);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void finalize() throws Throwable {
/*     */     try {
/* 152 */       shutdown();
/*     */     } finally {
/* 154 */       super.finalize();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 160 */     if (this.isShutdown.compareAndSet(false, true)) {
/* 161 */       closeConnection();
/*     */     }
/*     */   }
/*     */   
/*     */   HttpRoute getRoute() {
/* 166 */     return this.route;
/*     */   }
/*     */   
/*     */   Object getState() {
/* 170 */     return this.state;
/*     */   }
/*     */   
/*     */   public synchronized SocketConfig getSocketConfig() {
/* 174 */     return this.socketConfig;
/*     */   }
/*     */   
/*     */   public synchronized void setSocketConfig(SocketConfig paramSocketConfig) {
/* 178 */     this.socketConfig = (paramSocketConfig != null) ? paramSocketConfig : SocketConfig.DEFAULT;
/*     */   }
/*     */   
/*     */   public synchronized ConnectionConfig getConnectionConfig() {
/* 182 */     return this.connConfig;
/*     */   }
/*     */   
/*     */   public synchronized void setConnectionConfig(ConnectionConfig paramConnectionConfig) {
/* 186 */     this.connConfig = (paramConnectionConfig != null) ? paramConnectionConfig : ConnectionConfig.DEFAULT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final ConnectionRequest requestConnection(final HttpRoute route, final Object state) {
/* 193 */     Args.notNull(route, "Route");
/* 194 */     return new ConnectionRequest()
/*     */       {
/*     */         
/*     */         public boolean cancel()
/*     */         {
/* 199 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public HttpClientConnection get(long param1Long, TimeUnit param1TimeUnit) {
/* 204 */           return BasicHttpClientConnectionManager.this.getConnection(route, state);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private synchronized void closeConnection() {
/* 212 */     if (this.conn != null) {
/* 213 */       this.log.debug("Closing connection");
/*     */       try {
/* 215 */         this.conn.close();
/* 216 */       } catch (IOException iOException) {
/* 217 */         if (this.log.isDebugEnabled()) {
/* 218 */           this.log.debug("I/O exception closing connection", iOException);
/*     */         }
/*     */       } 
/* 221 */       this.conn = null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void checkExpiry() {
/* 226 */     if (this.conn != null && System.currentTimeMillis() >= this.expiry) {
/* 227 */       if (this.log.isDebugEnabled()) {
/* 228 */         this.log.debug("Connection expired @ " + new Date(this.expiry));
/*     */       }
/* 230 */       closeConnection();
/*     */     } 
/*     */   }
/*     */   
/*     */   synchronized HttpClientConnection getConnection(HttpRoute paramHttpRoute, Object paramObject) {
/* 235 */     Asserts.check(!this.isShutdown.get(), "Connection manager has been shut down");
/* 236 */     if (this.log.isDebugEnabled()) {
/* 237 */       this.log.debug("Get connection for route " + paramHttpRoute);
/*     */     }
/* 239 */     Asserts.check(!this.leased, "Connection is still allocated");
/* 240 */     if (!LangUtils.equals(this.route, paramHttpRoute) || !LangUtils.equals(this.state, paramObject)) {
/* 241 */       closeConnection();
/*     */     }
/* 243 */     this.route = paramHttpRoute;
/* 244 */     this.state = paramObject;
/* 245 */     checkExpiry();
/* 246 */     if (this.conn == null) {
/* 247 */       this.conn = (ManagedHttpClientConnection)this.connFactory.create(paramHttpRoute, this.connConfig);
/*     */     }
/* 249 */     this.conn.setSocketTimeout(this.socketConfig.getSoTimeout());
/* 250 */     this.leased = true;
/* 251 */     return (HttpClientConnection)this.conn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void releaseConnection(HttpClientConnection paramHttpClientConnection, Object paramObject, long paramLong, TimeUnit paramTimeUnit) {
/* 259 */     Args.notNull(paramHttpClientConnection, "Connection");
/* 260 */     Asserts.check((paramHttpClientConnection == this.conn), "Connection not obtained from this manager");
/* 261 */     if (this.log.isDebugEnabled()) {
/* 262 */       this.log.debug("Releasing connection " + paramHttpClientConnection);
/*     */     }
/* 264 */     if (this.isShutdown.get()) {
/*     */       return;
/*     */     }
/*     */     try {
/* 268 */       this.updated = System.currentTimeMillis();
/* 269 */       if (!this.conn.isOpen()) {
/* 270 */         this.conn = null;
/* 271 */         this.route = null;
/* 272 */         this.conn = null;
/* 273 */         this.expiry = Long.MAX_VALUE;
/*     */       } else {
/* 275 */         this.state = paramObject;
/* 276 */         this.conn.setSocketTimeout(0);
/* 277 */         if (this.log.isDebugEnabled()) {
/*     */           String str;
/* 279 */           if (paramLong > 0L) {
/* 280 */             str = "for " + paramLong + " " + paramTimeUnit;
/*     */           } else {
/* 282 */             str = "indefinitely";
/*     */           } 
/* 284 */           this.log.debug("Connection can be kept alive " + str);
/*     */         } 
/* 286 */         if (paramLong > 0L) {
/* 287 */           this.expiry = this.updated + paramTimeUnit.toMillis(paramLong);
/*     */         } else {
/* 289 */           this.expiry = Long.MAX_VALUE;
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 293 */       this.leased = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void connect(HttpClientConnection paramHttpClientConnection, HttpRoute paramHttpRoute, int paramInt, HttpContext paramHttpContext) throws IOException {
/*     */     HttpHost httpHost;
/* 303 */     Args.notNull(paramHttpClientConnection, "Connection");
/* 304 */     Args.notNull(paramHttpRoute, "HTTP route");
/* 305 */     Asserts.check((paramHttpClientConnection == this.conn), "Connection not obtained from this manager");
/*     */     
/* 307 */     if (paramHttpRoute.getProxyHost() != null) {
/* 308 */       httpHost = paramHttpRoute.getProxyHost();
/*     */     } else {
/* 310 */       httpHost = paramHttpRoute.getTargetHost();
/*     */     } 
/* 312 */     InetSocketAddress inetSocketAddress = paramHttpRoute.getLocalSocketAddress();
/* 313 */     this.connectionOperator.connect(this.conn, httpHost, inetSocketAddress, paramInt, this.socketConfig, paramHttpContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void upgrade(HttpClientConnection paramHttpClientConnection, HttpRoute paramHttpRoute, HttpContext paramHttpContext) throws IOException {
/* 322 */     Args.notNull(paramHttpClientConnection, "Connection");
/* 323 */     Args.notNull(paramHttpRoute, "HTTP route");
/* 324 */     Asserts.check((paramHttpClientConnection == this.conn), "Connection not obtained from this manager");
/* 325 */     this.connectionOperator.upgrade(this.conn, paramHttpRoute.getTargetHost(), paramHttpContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void routeComplete(HttpClientConnection paramHttpClientConnection, HttpRoute paramHttpRoute, HttpContext paramHttpContext) throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void closeExpiredConnections() {
/* 337 */     if (this.isShutdown.get()) {
/*     */       return;
/*     */     }
/* 340 */     if (!this.leased) {
/* 341 */       checkExpiry();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void closeIdleConnections(long paramLong, TimeUnit paramTimeUnit) {
/* 347 */     Args.notNull(paramTimeUnit, "Time unit");
/* 348 */     if (this.isShutdown.get()) {
/*     */       return;
/*     */     }
/* 351 */     if (!this.leased) {
/* 352 */       long l1 = paramTimeUnit.toMillis(paramLong);
/* 353 */       if (l1 < 0L) {
/* 354 */         l1 = 0L;
/*     */       }
/* 356 */       long l2 = System.currentTimeMillis() - l1;
/* 357 */       if (this.updated <= l2) {
/* 358 */         closeConnection();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void shutdown() {
/* 365 */     if (this.isShutdown.compareAndSet(false, true) && 
/* 366 */       this.conn != null) {
/* 367 */       this.log.debug("Shutting down connection");
/*     */       try {
/* 369 */         this.conn.shutdown();
/* 370 */       } catch (IOException iOException) {
/* 371 */         if (this.log.isDebugEnabled()) {
/* 372 */           this.log.debug("I/O exception shutting down connection", iOException);
/*     */         }
/*     */       } 
/* 375 */       this.conn = null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\BasicHttpClientConnectionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */