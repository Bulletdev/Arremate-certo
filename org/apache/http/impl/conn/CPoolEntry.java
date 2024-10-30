/*    */ package org.apache.http.impl.conn;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.Date;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.http.HttpClientConnection;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.conn.ManagedHttpClientConnection;
/*    */ import org.apache.http.conn.routing.HttpRoute;
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
/*    */ @Contract(threading = ThreadingBehavior.SAFE)
/*    */ class CPoolEntry
/*    */   extends PoolEntry<HttpRoute, ManagedHttpClientConnection>
/*    */ {
/*    */   private final Log log;
/*    */   private volatile boolean routeComplete;
/*    */   
/*    */   public CPoolEntry(Log paramLog, String paramString, HttpRoute paramHttpRoute, ManagedHttpClientConnection paramManagedHttpClientConnection, long paramLong, TimeUnit paramTimeUnit) {
/* 56 */     super(paramString, paramHttpRoute, paramManagedHttpClientConnection, paramLong, paramTimeUnit);
/* 57 */     this.log = paramLog;
/*    */   }
/*    */   
/*    */   public void markRouteComplete() {
/* 61 */     this.routeComplete = true;
/*    */   }
/*    */   
/*    */   public boolean isRouteComplete() {
/* 65 */     return this.routeComplete;
/*    */   }
/*    */   
/*    */   public void closeConnection() throws IOException {
/* 69 */     HttpClientConnection httpClientConnection = (HttpClientConnection)getConnection();
/* 70 */     httpClientConnection.close();
/*    */   }
/*    */   
/*    */   public void shutdownConnection() throws IOException {
/* 74 */     HttpClientConnection httpClientConnection = (HttpClientConnection)getConnection();
/* 75 */     httpClientConnection.shutdown();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isExpired(long paramLong) {
/* 80 */     boolean bool = super.isExpired(paramLong);
/* 81 */     if (bool && this.log.isDebugEnabled()) {
/* 82 */       this.log.debug("Connection " + this + " expired @ " + new Date(getExpiry()));
/*    */     }
/* 84 */     return bool;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isClosed() {
/* 89 */     HttpClientConnection httpClientConnection = (HttpClientConnection)getConnection();
/* 90 */     return !httpClientConnection.isOpen();
/*    */   }
/*    */ 
/*    */   
/*    */   public void close() {
/*    */     try {
/* 96 */       closeConnection();
/* 97 */     } catch (IOException iOException) {
/* 98 */       this.log.debug("I/O error closing connection", iOException);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\CPoolEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */