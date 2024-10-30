/*    */ package org.apache.http.impl.conn;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import java.util.concurrent.atomic.AtomicLong;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.http.conn.ClientConnectionOperator;
/*    */ import org.apache.http.conn.OperatedClientConnection;
/*    */ import org.apache.http.conn.routing.HttpRoute;
/*    */ import org.apache.http.pool.AbstractConnPool;
/*    */ import org.apache.http.pool.ConnFactory;
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
/*    */ @Deprecated
/*    */ class HttpConnPool
/*    */   extends AbstractConnPool<HttpRoute, OperatedClientConnection, HttpPoolEntry>
/*    */ {
/* 48 */   private static final AtomicLong COUNTER = new AtomicLong();
/*    */   
/*    */   private final Log log;
/*    */   
/*    */   private final long timeToLive;
/*    */   
/*    */   private final TimeUnit timeUnit;
/*    */ 
/*    */   
/*    */   public HttpConnPool(Log paramLog, ClientConnectionOperator paramClientConnectionOperator, int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit) {
/* 58 */     super(new InternalConnFactory(paramClientConnectionOperator), paramInt1, paramInt2);
/* 59 */     this.log = paramLog;
/* 60 */     this.timeToLive = paramLong;
/* 61 */     this.timeUnit = paramTimeUnit;
/*    */   }
/*    */ 
/*    */   
/*    */   protected HttpPoolEntry createEntry(HttpRoute paramHttpRoute, OperatedClientConnection paramOperatedClientConnection) {
/* 66 */     String str = Long.toString(COUNTER.getAndIncrement());
/* 67 */     return new HttpPoolEntry(this.log, str, paramHttpRoute, paramOperatedClientConnection, this.timeToLive, this.timeUnit);
/*    */   }
/*    */   
/*    */   static class InternalConnFactory
/*    */     implements ConnFactory<HttpRoute, OperatedClientConnection> {
/*    */     private final ClientConnectionOperator connOperator;
/*    */     
/*    */     InternalConnFactory(ClientConnectionOperator param1ClientConnectionOperator) {
/* 75 */       this.connOperator = param1ClientConnectionOperator;
/*    */     }
/*    */ 
/*    */     
/*    */     public OperatedClientConnection create(HttpRoute param1HttpRoute) throws IOException {
/* 80 */       return this.connOperator.createConnection();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\HttpConnPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */