/*    */ package org.apache.http.impl.client;
/*    */ 
/*    */ import org.apache.http.HttpResponse;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.client.ServiceUnavailableRetryStrategy;
/*    */ import org.apache.http.protocol.HttpContext;
/*    */ import org.apache.http.util.Args;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class DefaultServiceUnavailableRetryStrategy
/*    */   implements ServiceUnavailableRetryStrategy
/*    */ {
/*    */   private final int maxRetries;
/*    */   private final long retryInterval;
/*    */   
/*    */   public DefaultServiceUnavailableRetryStrategy(int paramInt1, int paramInt2) {
/* 62 */     Args.positive(paramInt1, "Max retries");
/* 63 */     Args.positive(paramInt2, "Retry interval");
/* 64 */     this.maxRetries = paramInt1;
/* 65 */     this.retryInterval = paramInt2;
/*    */   }
/*    */   
/*    */   public DefaultServiceUnavailableRetryStrategy() {
/* 69 */     this(1, 1000);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean retryRequest(HttpResponse paramHttpResponse, int paramInt, HttpContext paramHttpContext) {
/* 74 */     return (paramInt <= this.maxRetries && paramHttpResponse.getStatusLine().getStatusCode() == 503);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public long getRetryInterval() {
/* 80 */     return this.retryInterval;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\DefaultServiceUnavailableRetryStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */