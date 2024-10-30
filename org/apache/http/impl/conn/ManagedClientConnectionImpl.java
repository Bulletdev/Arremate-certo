/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InterruptedIOException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.Socket;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import javax.net.ssl.SSLSession;
/*     */ import javax.net.ssl.SSLSocket;
/*     */ import org.apache.http.HttpConnectionMetrics;
/*     */ import org.apache.http.HttpEntityEnclosingRequest;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.conn.ClientConnectionManager;
/*     */ import org.apache.http.conn.ClientConnectionOperator;
/*     */ import org.apache.http.conn.ManagedClientConnection;
/*     */ import org.apache.http.conn.OperatedClientConnection;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.conn.routing.RouteTracker;
/*     */ import org.apache.http.params.HttpParams;
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
/*     */ @Deprecated
/*     */ class ManagedClientConnectionImpl
/*     */   implements ManagedClientConnection
/*     */ {
/*     */   private final ClientConnectionManager manager;
/*     */   private final ClientConnectionOperator operator;
/*     */   private volatile HttpPoolEntry poolEntry;
/*     */   private volatile boolean reusable;
/*     */   private volatile long duration;
/*     */   
/*     */   ManagedClientConnectionImpl(ClientConnectionManager paramClientConnectionManager, ClientConnectionOperator paramClientConnectionOperator, HttpPoolEntry paramHttpPoolEntry) {
/*  74 */     Args.notNull(paramClientConnectionManager, "Connection manager");
/*  75 */     Args.notNull(paramClientConnectionOperator, "Connection operator");
/*  76 */     Args.notNull(paramHttpPoolEntry, "HTTP pool entry");
/*  77 */     this.manager = paramClientConnectionManager;
/*  78 */     this.operator = paramClientConnectionOperator;
/*  79 */     this.poolEntry = paramHttpPoolEntry;
/*  80 */     this.reusable = false;
/*  81 */     this.duration = Long.MAX_VALUE;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getId() {
/*  86 */     return null;
/*     */   }
/*     */   
/*     */   HttpPoolEntry getPoolEntry() {
/*  90 */     return this.poolEntry;
/*     */   }
/*     */   
/*     */   HttpPoolEntry detach() {
/*  94 */     HttpPoolEntry httpPoolEntry = this.poolEntry;
/*  95 */     this.poolEntry = null;
/*  96 */     return httpPoolEntry;
/*     */   }
/*     */   
/*     */   public ClientConnectionManager getManager() {
/* 100 */     return this.manager;
/*     */   }
/*     */   
/*     */   private OperatedClientConnection getConnection() {
/* 104 */     HttpPoolEntry httpPoolEntry = this.poolEntry;
/* 105 */     if (httpPoolEntry == null) {
/* 106 */       return null;
/*     */     }
/* 108 */     return (OperatedClientConnection)httpPoolEntry.getConnection();
/*     */   }
/*     */   
/*     */   private OperatedClientConnection ensureConnection() {
/* 112 */     HttpPoolEntry httpPoolEntry = this.poolEntry;
/* 113 */     if (httpPoolEntry == null) {
/* 114 */       throw new ConnectionShutdownException();
/*     */     }
/* 116 */     return (OperatedClientConnection)httpPoolEntry.getConnection();
/*     */   }
/*     */   
/*     */   private HttpPoolEntry ensurePoolEntry() {
/* 120 */     HttpPoolEntry httpPoolEntry = this.poolEntry;
/* 121 */     if (httpPoolEntry == null) {
/* 122 */       throw new ConnectionShutdownException();
/*     */     }
/* 124 */     return httpPoolEntry;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 129 */     HttpPoolEntry httpPoolEntry = this.poolEntry;
/* 130 */     if (httpPoolEntry != null) {
/* 131 */       OperatedClientConnection operatedClientConnection = (OperatedClientConnection)httpPoolEntry.getConnection();
/* 132 */       httpPoolEntry.getTracker().reset();
/* 133 */       operatedClientConnection.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void shutdown() throws IOException {
/* 139 */     HttpPoolEntry httpPoolEntry = this.poolEntry;
/* 140 */     if (httpPoolEntry != null) {
/* 141 */       OperatedClientConnection operatedClientConnection = (OperatedClientConnection)httpPoolEntry.getConnection();
/* 142 */       httpPoolEntry.getTracker().reset();
/* 143 */       operatedClientConnection.shutdown();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isOpen() {
/* 149 */     OperatedClientConnection operatedClientConnection = getConnection();
/* 150 */     if (operatedClientConnection != null) {
/* 151 */       return operatedClientConnection.isOpen();
/*     */     }
/* 153 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isStale() {
/* 159 */     OperatedClientConnection operatedClientConnection = getConnection();
/* 160 */     if (operatedClientConnection != null) {
/* 161 */       return operatedClientConnection.isStale();
/*     */     }
/* 163 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSocketTimeout(int paramInt) {
/* 169 */     OperatedClientConnection operatedClientConnection = ensureConnection();
/* 170 */     operatedClientConnection.setSocketTimeout(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSocketTimeout() {
/* 175 */     OperatedClientConnection operatedClientConnection = ensureConnection();
/* 176 */     return operatedClientConnection.getSocketTimeout();
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpConnectionMetrics getMetrics() {
/* 181 */     OperatedClientConnection operatedClientConnection = ensureConnection();
/* 182 */     return operatedClientConnection.getMetrics();
/*     */   }
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {
/* 187 */     OperatedClientConnection operatedClientConnection = ensureConnection();
/* 188 */     operatedClientConnection.flush();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isResponseAvailable(int paramInt) throws IOException {
/* 193 */     OperatedClientConnection operatedClientConnection = ensureConnection();
/* 194 */     return operatedClientConnection.isResponseAvailable(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void receiveResponseEntity(HttpResponse paramHttpResponse) throws HttpException, IOException {
/* 200 */     OperatedClientConnection operatedClientConnection = ensureConnection();
/* 201 */     operatedClientConnection.receiveResponseEntity(paramHttpResponse);
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpResponse receiveResponseHeader() throws HttpException, IOException {
/* 206 */     OperatedClientConnection operatedClientConnection = ensureConnection();
/* 207 */     return operatedClientConnection.receiveResponseHeader();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendRequestEntity(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest) throws HttpException, IOException {
/* 213 */     OperatedClientConnection operatedClientConnection = ensureConnection();
/* 214 */     operatedClientConnection.sendRequestEntity(paramHttpEntityEnclosingRequest);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendRequestHeader(HttpRequest paramHttpRequest) throws HttpException, IOException {
/* 220 */     OperatedClientConnection operatedClientConnection = ensureConnection();
/* 221 */     operatedClientConnection.sendRequestHeader(paramHttpRequest);
/*     */   }
/*     */ 
/*     */   
/*     */   public InetAddress getLocalAddress() {
/* 226 */     OperatedClientConnection operatedClientConnection = ensureConnection();
/* 227 */     return operatedClientConnection.getLocalAddress();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLocalPort() {
/* 232 */     OperatedClientConnection operatedClientConnection = ensureConnection();
/* 233 */     return operatedClientConnection.getLocalPort();
/*     */   }
/*     */ 
/*     */   
/*     */   public InetAddress getRemoteAddress() {
/* 238 */     OperatedClientConnection operatedClientConnection = ensureConnection();
/* 239 */     return operatedClientConnection.getRemoteAddress();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRemotePort() {
/* 244 */     OperatedClientConnection operatedClientConnection = ensureConnection();
/* 245 */     return operatedClientConnection.getRemotePort();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isSecure() {
/* 250 */     OperatedClientConnection operatedClientConnection = ensureConnection();
/* 251 */     return operatedClientConnection.isSecure();
/*     */   }
/*     */ 
/*     */   
/*     */   public void bind(Socket paramSocket) throws IOException {
/* 256 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Socket getSocket() {
/* 261 */     OperatedClientConnection operatedClientConnection = ensureConnection();
/* 262 */     return operatedClientConnection.getSocket();
/*     */   }
/*     */ 
/*     */   
/*     */   public SSLSession getSSLSession() {
/* 267 */     OperatedClientConnection operatedClientConnection = ensureConnection();
/* 268 */     SSLSession sSLSession = null;
/* 269 */     Socket socket = operatedClientConnection.getSocket();
/* 270 */     if (socket instanceof SSLSocket) {
/* 271 */       sSLSession = ((SSLSocket)socket).getSession();
/*     */     }
/* 273 */     return sSLSession;
/*     */   }
/*     */   
/*     */   public Object getAttribute(String paramString) {
/* 277 */     OperatedClientConnection operatedClientConnection = ensureConnection();
/* 278 */     if (operatedClientConnection instanceof HttpContext) {
/* 279 */       return ((HttpContext)operatedClientConnection).getAttribute(paramString);
/*     */     }
/* 281 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object removeAttribute(String paramString) {
/* 286 */     OperatedClientConnection operatedClientConnection = ensureConnection();
/* 287 */     if (operatedClientConnection instanceof HttpContext) {
/* 288 */       return ((HttpContext)operatedClientConnection).removeAttribute(paramString);
/*     */     }
/* 290 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAttribute(String paramString, Object paramObject) {
/* 295 */     OperatedClientConnection operatedClientConnection = ensureConnection();
/* 296 */     if (operatedClientConnection instanceof HttpContext) {
/* 297 */       ((HttpContext)operatedClientConnection).setAttribute(paramString, paramObject);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpRoute getRoute() {
/* 303 */     HttpPoolEntry httpPoolEntry = ensurePoolEntry();
/* 304 */     return httpPoolEntry.getEffectiveRoute();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void open(HttpRoute paramHttpRoute, HttpContext paramHttpContext, HttpParams paramHttpParams) throws IOException {
/*     */     OperatedClientConnection operatedClientConnection;
/* 312 */     Args.notNull(paramHttpRoute, "Route");
/* 313 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*     */     
/* 315 */     synchronized (this) {
/* 316 */       if (this.poolEntry == null) {
/* 317 */         throw new ConnectionShutdownException();
/*     */       }
/* 319 */       RouteTracker routeTracker = this.poolEntry.getTracker();
/* 320 */       Asserts.notNull(routeTracker, "Route tracker");
/* 321 */       Asserts.check(!routeTracker.isConnected(), "Connection already open");
/* 322 */       operatedClientConnection = (OperatedClientConnection)this.poolEntry.getConnection();
/*     */     } 
/*     */     
/* 325 */     HttpHost httpHost = paramHttpRoute.getProxyHost();
/* 326 */     this.operator.openConnection(operatedClientConnection, (httpHost != null) ? httpHost : paramHttpRoute.getTargetHost(), paramHttpRoute.getLocalAddress(), paramHttpContext, paramHttpParams);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 332 */     synchronized (this) {
/* 333 */       if (this.poolEntry == null) {
/* 334 */         throw new InterruptedIOException();
/*     */       }
/* 336 */       RouteTracker routeTracker = this.poolEntry.getTracker();
/* 337 */       if (httpHost == null) {
/* 338 */         routeTracker.connectTarget(operatedClientConnection.isSecure());
/*     */       } else {
/* 340 */         routeTracker.connectProxy(httpHost, operatedClientConnection.isSecure());
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void tunnelTarget(boolean paramBoolean, HttpParams paramHttpParams) throws IOException {
/*     */     HttpHost httpHost;
/*     */     OperatedClientConnection operatedClientConnection;
/* 348 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*     */ 
/*     */     
/* 351 */     synchronized (this) {
/* 352 */       if (this.poolEntry == null) {
/* 353 */         throw new ConnectionShutdownException();
/*     */       }
/* 355 */       RouteTracker routeTracker = this.poolEntry.getTracker();
/* 356 */       Asserts.notNull(routeTracker, "Route tracker");
/* 357 */       Asserts.check(routeTracker.isConnected(), "Connection not open");
/* 358 */       Asserts.check(!routeTracker.isTunnelled(), "Connection is already tunnelled");
/* 359 */       httpHost = routeTracker.getTargetHost();
/* 360 */       operatedClientConnection = (OperatedClientConnection)this.poolEntry.getConnection();
/*     */     } 
/*     */     
/* 363 */     operatedClientConnection.update(null, httpHost, paramBoolean, paramHttpParams);
/*     */     
/* 365 */     synchronized (this) {
/* 366 */       if (this.poolEntry == null) {
/* 367 */         throw new InterruptedIOException();
/*     */       }
/* 369 */       RouteTracker routeTracker = this.poolEntry.getTracker();
/* 370 */       routeTracker.tunnelTarget(paramBoolean);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void tunnelProxy(HttpHost paramHttpHost, boolean paramBoolean, HttpParams paramHttpParams) throws IOException {
/*     */     OperatedClientConnection operatedClientConnection;
/* 377 */     Args.notNull(paramHttpHost, "Next proxy");
/* 378 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*     */     
/* 380 */     synchronized (this) {
/* 381 */       if (this.poolEntry == null) {
/* 382 */         throw new ConnectionShutdownException();
/*     */       }
/* 384 */       RouteTracker routeTracker = this.poolEntry.getTracker();
/* 385 */       Asserts.notNull(routeTracker, "Route tracker");
/* 386 */       Asserts.check(routeTracker.isConnected(), "Connection not open");
/* 387 */       operatedClientConnection = (OperatedClientConnection)this.poolEntry.getConnection();
/*     */     } 
/*     */     
/* 390 */     operatedClientConnection.update(null, paramHttpHost, paramBoolean, paramHttpParams);
/*     */     
/* 392 */     synchronized (this) {
/* 393 */       if (this.poolEntry == null) {
/* 394 */         throw new InterruptedIOException();
/*     */       }
/* 396 */       RouteTracker routeTracker = this.poolEntry.getTracker();
/* 397 */       routeTracker.tunnelProxy(paramHttpHost, paramBoolean);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void layerProtocol(HttpContext paramHttpContext, HttpParams paramHttpParams) throws IOException {
/*     */     HttpHost httpHost;
/*     */     OperatedClientConnection operatedClientConnection;
/* 404 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*     */ 
/*     */     
/* 407 */     synchronized (this) {
/* 408 */       if (this.poolEntry == null) {
/* 409 */         throw new ConnectionShutdownException();
/*     */       }
/* 411 */       RouteTracker routeTracker = this.poolEntry.getTracker();
/* 412 */       Asserts.notNull(routeTracker, "Route tracker");
/* 413 */       Asserts.check(routeTracker.isConnected(), "Connection not open");
/* 414 */       Asserts.check(routeTracker.isTunnelled(), "Protocol layering without a tunnel not supported");
/* 415 */       Asserts.check(!routeTracker.isLayered(), "Multiple protocol layering not supported");
/* 416 */       httpHost = routeTracker.getTargetHost();
/* 417 */       operatedClientConnection = (OperatedClientConnection)this.poolEntry.getConnection();
/*     */     } 
/* 419 */     this.operator.updateSecureConnection(operatedClientConnection, httpHost, paramHttpContext, paramHttpParams);
/*     */     
/* 421 */     synchronized (this) {
/* 422 */       if (this.poolEntry == null) {
/* 423 */         throw new InterruptedIOException();
/*     */       }
/* 425 */       RouteTracker routeTracker = this.poolEntry.getTracker();
/* 426 */       routeTracker.layerProtocol(operatedClientConnection.isSecure());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getState() {
/* 432 */     HttpPoolEntry httpPoolEntry = ensurePoolEntry();
/* 433 */     return httpPoolEntry.getState();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setState(Object paramObject) {
/* 438 */     HttpPoolEntry httpPoolEntry = ensurePoolEntry();
/* 439 */     httpPoolEntry.setState(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public void markReusable() {
/* 444 */     this.reusable = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void unmarkReusable() {
/* 449 */     this.reusable = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isMarkedReusable() {
/* 454 */     return this.reusable;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setIdleDuration(long paramLong, TimeUnit paramTimeUnit) {
/* 459 */     if (paramLong > 0L) {
/* 460 */       this.duration = paramTimeUnit.toMillis(paramLong);
/*     */     } else {
/* 462 */       this.duration = -1L;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void releaseConnection() {
/* 468 */     synchronized (this) {
/* 469 */       if (this.poolEntry == null) {
/*     */         return;
/*     */       }
/* 472 */       this.manager.releaseConnection(this, this.duration, TimeUnit.MILLISECONDS);
/* 473 */       this.poolEntry = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void abortConnection() {
/* 479 */     synchronized (this) {
/* 480 */       if (this.poolEntry == null) {
/*     */         return;
/*     */       }
/* 483 */       this.reusable = false;
/* 484 */       OperatedClientConnection operatedClientConnection = (OperatedClientConnection)this.poolEntry.getConnection();
/*     */       try {
/* 486 */         operatedClientConnection.shutdown();
/* 487 */       } catch (IOException iOException) {}
/*     */       
/* 489 */       this.manager.releaseConnection(this, this.duration, TimeUnit.MILLISECONDS);
/* 490 */       this.poolEntry = null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\ManagedClientConnectionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */