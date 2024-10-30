/*    */ package org.apache.http.protocol;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.http.HttpException;
/*    */ import org.apache.http.HttpRequest;
/*    */ import org.apache.http.HttpRequestInterceptor;
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
/*    */ @Contract(threading = ThreadingBehavior.SAFE)
/*    */ public class RequestDate
/*    */   implements HttpRequestInterceptor
/*    */ {
/* 50 */   private static final HttpDateGenerator DATE_GENERATOR = new HttpDateGenerator();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException, IOException {
/* 59 */     Args.notNull(paramHttpRequest, "HTTP request");
/* 60 */     if (paramHttpRequest instanceof org.apache.http.HttpEntityEnclosingRequest && !paramHttpRequest.containsHeader("Date")) {
/*    */       
/* 62 */       String str = DATE_GENERATOR.getCurrentDate();
/* 63 */       paramHttpRequest.setHeader("Date", str);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\RequestDate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */