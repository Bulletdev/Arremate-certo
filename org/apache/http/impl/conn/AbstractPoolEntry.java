/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InterruptedIOException;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.conn.ClientConnectionOperator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public abstract class AbstractPoolEntry
/*     */ {
/*     */   protected final ClientConnectionOperator connOperator;
/*     */   protected final OperatedClientConnection connection;
/*     */   protected volatile HttpRoute route;
/*     */   protected volatile Object state;
/*     */   protected volatile RouteTracker tracker;
/*     */   
/*     */   protected AbstractPoolEntry(ClientConnectionOperator paramClientConnectionOperator, HttpRoute paramHttpRoute) {
/*  92 */     Args.notNull(paramClientConnectionOperator, "Connection operator");
/*  93 */     this.connOperator = paramClientConnectionOperator;
/*  94 */     this.connection = paramClientConnectionOperator.createConnection();
/*  95 */     this.route = paramHttpRoute;
/*  96 */     this.tracker = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getState() {
/* 105 */     return this.state;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setState(Object paramObject) {
/* 114 */     this.state = paramObject;
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
/*     */   public void open(HttpRoute paramHttpRoute, HttpContext paramHttpContext, HttpParams paramHttpParams) throws IOException {
/* 130 */     Args.notNull(paramHttpRoute, "Route");
/* 131 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 132 */     if (this.tracker != null) {
/* 133 */       Asserts.check(!this.tracker.isConnected(), "Connection already open");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 141 */     this.tracker = new RouteTracker(paramHttpRoute);
/* 142 */     HttpHost httpHost = paramHttpRoute.getProxyHost();
/*     */     
/* 144 */     this.connOperator.openConnection(this.connection, (httpHost != null) ? httpHost : paramHttpRoute.getTargetHost(), paramHttpRoute.getLocalAddress(), paramHttpContext, paramHttpParams);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 150 */     RouteTracker routeTracker = this.tracker;
/*     */ 
/*     */ 
/*     */     
/* 154 */     if (routeTracker == null) {
/* 155 */       throw new InterruptedIOException("Request aborted");
/*     */     }
/*     */     
/* 158 */     if (httpHost == null) {
/* 159 */       routeTracker.connectTarget(this.connection.isSecure());
/*     */     } else {
/* 161 */       routeTracker.connectProxy(httpHost, this.connection.isSecure());
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
/*     */ 
/*     */   
/*     */   public void tunnelTarget(boolean paramBoolean, HttpParams paramHttpParams) throws IOException {
/* 180 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 181 */     Asserts.notNull(this.tracker, "Route tracker");
/* 182 */     Asserts.check(this.tracker.isConnected(), "Connection not open");
/* 183 */     Asserts.check(!this.tracker.isTunnelled(), "Connection is already tunnelled");
/*     */     
/* 185 */     this.connection.update(null, this.tracker.getTargetHost(), paramBoolean, paramHttpParams);
/*     */     
/* 187 */     this.tracker.tunnelTarget(paramBoolean);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void tunnelProxy(HttpHost paramHttpHost, boolean paramBoolean, HttpParams paramHttpParams) throws IOException {
/* 208 */     Args.notNull(paramHttpHost, "Next proxy");
/* 209 */     Args.notNull(paramHttpParams, "Parameters");
/*     */     
/* 211 */     Asserts.notNull(this.tracker, "Route tracker");
/* 212 */     Asserts.check(this.tracker.isConnected(), "Connection not open");
/*     */     
/* 214 */     this.connection.update(null, paramHttpHost, paramBoolean, paramHttpParams);
/* 215 */     this.tracker.tunnelProxy(paramHttpHost, paramBoolean);
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
/*     */   public void layerProtocol(HttpContext paramHttpContext, HttpParams paramHttpParams) throws IOException {
/* 230 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 231 */     Asserts.notNull(this.tracker, "Route tracker");
/* 232 */     Asserts.check(this.tracker.isConnected(), "Connection not open");
/* 233 */     Asserts.check(this.tracker.isTunnelled(), "Protocol layering without a tunnel not supported");
/* 234 */     Asserts.check(!this.tracker.isLayered(), "Multiple protocol layering not supported");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 241 */     HttpHost httpHost = this.tracker.getTargetHost();
/*     */     
/* 243 */     this.connOperator.updateSecureConnection(this.connection, httpHost, paramHttpContext, paramHttpParams);
/*     */ 
/*     */     
/* 246 */     this.tracker.layerProtocol(this.connection.isSecure());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void shutdownEntry() {
/* 257 */     this.tracker = null;
/* 258 */     this.state = null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\AbstractPoolEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */