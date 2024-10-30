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
/*    */ @Contract(threading = ThreadingBehavior.SAFE)
/*    */ public class ResponseDate
/*    */   implements HttpResponseInterceptor
/*    */ {
/* 50 */   private static final HttpDateGenerator DATE_GENERATOR = new HttpDateGenerator();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws HttpException, IOException {
/* 59 */     Args.notNull(paramHttpResponse, "HTTP response");
/* 60 */     int i = paramHttpResponse.getStatusLine().getStatusCode();
/* 61 */     if (i >= 200 && !paramHttpResponse.containsHeader("Date")) {
/*    */       
/* 63 */       String str = DATE_GENERATOR.getCurrentDate();
/* 64 */       paramHttpResponse.setHeader("Date", str);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\ResponseDate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */