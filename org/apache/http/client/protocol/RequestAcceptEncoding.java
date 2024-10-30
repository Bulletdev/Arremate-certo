/*    */ package org.apache.http.client.protocol;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import org.apache.http.HttpException;
/*    */ import org.apache.http.HttpRequest;
/*    */ import org.apache.http.HttpRequestInterceptor;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.client.config.RequestConfig;
/*    */ import org.apache.http.protocol.HttpContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */ public class RequestAcceptEncoding
/*    */   implements HttpRequestInterceptor
/*    */ {
/*    */   private final String acceptEncoding;
/*    */   
/*    */   public RequestAcceptEncoding(List<String> paramList) {
/* 58 */     if (paramList != null && !paramList.isEmpty()) {
/* 59 */       StringBuilder stringBuilder = new StringBuilder();
/* 60 */       for (byte b = 0; b < paramList.size(); b++) {
/* 61 */         if (b > 0) {
/* 62 */           stringBuilder.append(",");
/*    */         }
/* 64 */         stringBuilder.append(paramList.get(b));
/*    */       } 
/* 66 */       this.acceptEncoding = stringBuilder.toString();
/*    */     } else {
/* 68 */       this.acceptEncoding = "gzip,deflate";
/*    */     } 
/*    */   }
/*    */   
/*    */   public RequestAcceptEncoding() {
/* 73 */     this(null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException, IOException {
/* 81 */     HttpClientContext httpClientContext = HttpClientContext.adapt(paramHttpContext);
/* 82 */     RequestConfig requestConfig = httpClientContext.getRequestConfig();
/*    */ 
/*    */     
/* 85 */     if (!paramHttpRequest.containsHeader("Accept-Encoding") && requestConfig.isContentCompressionEnabled())
/* 86 */       paramHttpRequest.addHeader("Accept-Encoding", this.acceptEncoding); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\protocol\RequestAcceptEncoding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */