/*    */ package org.apache.http.impl.client;
/*    */ 
/*    */ import java.util.Locale;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import org.apache.http.HttpRequest;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
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
/*    */ public class StandardHttpRequestRetryHandler
/*    */   extends DefaultHttpRequestRetryHandler
/*    */ {
/*    */   private final Map<String, Boolean> idempotentMethods;
/*    */   
/*    */   public StandardHttpRequestRetryHandler(int paramInt, boolean paramBoolean) {
/* 58 */     super(paramInt, paramBoolean);
/* 59 */     this.idempotentMethods = new ConcurrentHashMap<String, Boolean>();
/* 60 */     this.idempotentMethods.put("GET", Boolean.TRUE);
/* 61 */     this.idempotentMethods.put("HEAD", Boolean.TRUE);
/* 62 */     this.idempotentMethods.put("PUT", Boolean.TRUE);
/* 63 */     this.idempotentMethods.put("DELETE", Boolean.TRUE);
/* 64 */     this.idempotentMethods.put("OPTIONS", Boolean.TRUE);
/* 65 */     this.idempotentMethods.put("TRACE", Boolean.TRUE);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public StandardHttpRequestRetryHandler() {
/* 72 */     this(3, false);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean handleAsIdempotent(HttpRequest paramHttpRequest) {
/* 77 */     String str = paramHttpRequest.getRequestLine().getMethod().toUpperCase(Locale.ROOT);
/* 78 */     Boolean bool = this.idempotentMethods.get(str);
/* 79 */     return (bool != null && bool.booleanValue());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\StandardHttpRequestRetryHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */