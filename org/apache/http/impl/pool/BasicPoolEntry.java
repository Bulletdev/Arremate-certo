/*    */ package org.apache.http.impl.pool;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.http.HttpClientConnection;
/*    */ import org.apache.http.HttpHost;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
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
/*    */ @Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/*    */ public class BasicPoolEntry
/*    */   extends PoolEntry<HttpHost, HttpClientConnection>
/*    */ {
/*    */   public BasicPoolEntry(String paramString, HttpHost paramHttpHost, HttpClientConnection paramHttpClientConnection) {
/* 49 */     super(paramString, paramHttpHost, paramHttpClientConnection);
/*    */   }
/*    */ 
/*    */   
/*    */   public void close() {
/*    */     try {
/* 55 */       HttpClientConnection httpClientConnection = (HttpClientConnection)getConnection();
/*    */       try {
/* 57 */         int i = httpClientConnection.getSocketTimeout();
/* 58 */         if (i <= 0 || i > 1000) {
/* 59 */           httpClientConnection.setSocketTimeout(1000);
/*    */         }
/* 61 */         httpClientConnection.close();
/* 62 */       } catch (IOException iOException) {
/* 63 */         httpClientConnection.shutdown();
/*    */       } 
/* 65 */     } catch (IOException iOException) {}
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isClosed() {
/* 71 */     return !((HttpClientConnection)getConnection()).isOpen();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\pool\BasicPoolEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */