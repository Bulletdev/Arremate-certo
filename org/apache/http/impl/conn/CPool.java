/*    */ package org.apache.http.impl.conn;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import java.util.concurrent.atomic.AtomicLong;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.conn.ManagedHttpClientConnection;
/*    */ import org.apache.http.conn.routing.HttpRoute;
/*    */ import org.apache.http.pool.AbstractConnPool;
/*    */ import org.apache.http.pool.ConnFactory;
/*    */ import org.apache.http.pool.PoolEntry;
/*    */ import org.apache.http.pool.PoolEntryCallback;
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
/*    */ class CPool
/*    */   extends AbstractConnPool<HttpRoute, ManagedHttpClientConnection, CPoolEntry>
/*    */ {
/* 48 */   private static final AtomicLong COUNTER = new AtomicLong();
/*    */   
/* 50 */   private final Log log = LogFactory.getLog(CPool.class);
/*    */   
/*    */   private final long timeToLive;
/*    */   
/*    */   private final TimeUnit timeUnit;
/*    */ 
/*    */   
/*    */   public CPool(ConnFactory<HttpRoute, ManagedHttpClientConnection> paramConnFactory, int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit) {
/* 58 */     super(paramConnFactory, paramInt1, paramInt2);
/* 59 */     this.timeToLive = paramLong;
/* 60 */     this.timeUnit = paramTimeUnit;
/*    */   }
/*    */ 
/*    */   
/*    */   protected CPoolEntry createEntry(HttpRoute paramHttpRoute, ManagedHttpClientConnection paramManagedHttpClientConnection) {
/* 65 */     String str = Long.toString(COUNTER.getAndIncrement());
/* 66 */     return new CPoolEntry(this.log, str, paramHttpRoute, paramManagedHttpClientConnection, this.timeToLive, this.timeUnit);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean validate(CPoolEntry paramCPoolEntry) {
/* 71 */     return !((ManagedHttpClientConnection)paramCPoolEntry.getConnection()).isStale();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void enumAvailable(PoolEntryCallback<HttpRoute, ManagedHttpClientConnection> paramPoolEntryCallback) {
/* 76 */     super.enumAvailable(paramPoolEntryCallback);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void enumLeased(PoolEntryCallback<HttpRoute, ManagedHttpClientConnection> paramPoolEntryCallback) {
/* 81 */     super.enumLeased(paramPoolEntryCallback);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\CPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */