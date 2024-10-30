/*    */ package org.apache.http.protocol;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.http.HttpException;
/*    */ import org.apache.http.HttpResponse;
/*    */ import org.apache.http.HttpResponseInterceptor;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
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
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class ResponseServer
/*    */   implements HttpResponseInterceptor
/*    */ {
/*    */   private final String originServer;
/*    */   
/*    */   public ResponseServer(String paramString) {
/* 55 */     this.originServer = paramString;
/*    */   }
/*    */   
/*    */   public ResponseServer() {
/* 59 */     this(null);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws HttpException, IOException {
/* 65 */     Args.notNull(paramHttpResponse, "HTTP response");
/* 66 */     if (!paramHttpResponse.containsHeader("Server") && 
/* 67 */       this.originServer != null)
/* 68 */       paramHttpResponse.addHeader("Server", this.originServer); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\ResponseServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */