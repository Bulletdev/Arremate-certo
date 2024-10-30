/*    */ package org.apache.http.client.protocol;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.Collection;
/*    */ import org.apache.http.Header;
/*    */ import org.apache.http.HttpException;
/*    */ import org.apache.http.HttpRequest;
/*    */ import org.apache.http.HttpRequestInterceptor;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
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
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*    */ public class RequestDefaultHeaders
/*    */   implements HttpRequestInterceptor
/*    */ {
/*    */   private final Collection<? extends Header> defaultHeaders;
/*    */   
/*    */   public RequestDefaultHeaders(Collection<? extends Header> paramCollection) {
/* 59 */     this.defaultHeaders = paramCollection;
/*    */   }
/*    */   
/*    */   public RequestDefaultHeaders() {
/* 63 */     this(null);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException, IOException {
/* 69 */     Args.notNull(paramHttpRequest, "HTTP request");
/*    */     
/* 71 */     String str = paramHttpRequest.getRequestLine().getMethod();
/* 72 */     if (str.equalsIgnoreCase("CONNECT")) {
/*    */       return;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/* 78 */     Collection<? extends Header> collection = (Collection)paramHttpRequest.getParams().getParameter("http.default-headers");
/*    */     
/* 80 */     if (collection == null) {
/* 81 */       collection = this.defaultHeaders;
/*    */     }
/*    */     
/* 84 */     if (collection != null)
/* 85 */       for (Header header : collection)
/* 86 */         paramHttpRequest.addHeader(header);  
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\protocol\RequestDefaultHeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */