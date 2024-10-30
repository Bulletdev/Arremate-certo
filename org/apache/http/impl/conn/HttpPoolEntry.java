/*    */ package org.apache.http.impl.conn;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.Date;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.http.conn.OperatedClientConnection;
/*    */ import org.apache.http.conn.routing.HttpRoute;
/*    */ import org.apache.http.conn.routing.RouteTracker;
/*    */ import org.apache.http.pool.PoolEntry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ class HttpPoolEntry
/*    */   extends PoolEntry<HttpRoute, OperatedClientConnection>
/*    */ {
/*    */   private final Log log;
/*    */   private final RouteTracker tracker;
/*    */   
/*    */   public HttpPoolEntry(Log paramLog, String paramString, HttpRoute paramHttpRoute, OperatedClientConnection paramOperatedClientConnection, long paramLong, TimeUnit paramTimeUnit) {
/* 56 */     super(paramString, paramHttpRoute, paramOperatedClientConnection, paramLong, paramTimeUnit);
/* 57 */     this.log = paramLog;
/* 58 */     this.tracker = new RouteTracker(paramHttpRoute);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isExpired(long paramLong) {
/* 63 */     boolean bool = super.isExpired(paramLong);
/* 64 */     if (bool && this.log.isDebugEnabled()) {
/* 65 */       this.log.debug("Connection " + this + " expired @ " + new Date(getExpiry()));
/*    */     }
/* 67 */     return bool;
/*    */   }
/*    */   
/*    */   RouteTracker getTracker() {
/* 71 */     return this.tracker;
/*    */   }
/*    */   
/*    */   HttpRoute getPlannedRoute() {
/* 75 */     return (HttpRoute)getRoute();
/*    */   }
/*    */   
/*    */   HttpRoute getEffectiveRoute() {
/* 79 */     return this.tracker.toRoute();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isClosed() {
/* 84 */     OperatedClientConnection operatedClientConnection = (OperatedClientConnection)getConnection();
/* 85 */     return !operatedClientConnection.isOpen();
/*    */   }
/*    */ 
/*    */   
/*    */   public void close() {
/* 90 */     OperatedClientConnection operatedClientConnection = (OperatedClientConnection)getConnection();
/*    */     try {
/* 92 */       operatedClientConnection.close();
/* 93 */     } catch (IOException iOException) {
/* 94 */       this.log.debug("I/O error closing connection", iOException);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\HttpPoolEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */