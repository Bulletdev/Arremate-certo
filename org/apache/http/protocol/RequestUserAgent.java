/*    */ package org.apache.http.protocol;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.http.HttpException;
/*    */ import org.apache.http.HttpRequest;
/*    */ import org.apache.http.HttpRequestInterceptor;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.params.HttpParams;
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
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class RequestUserAgent
/*    */   implements HttpRequestInterceptor
/*    */ {
/*    */   private final String userAgent;
/*    */   
/*    */   public RequestUserAgent(String paramString) {
/* 55 */     this.userAgent = paramString;
/*    */   }
/*    */   
/*    */   public RequestUserAgent() {
/* 59 */     this(null);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException, IOException {
/* 65 */     Args.notNull(paramHttpRequest, "HTTP request");
/* 66 */     if (!paramHttpRequest.containsHeader("User-Agent")) {
/* 67 */       String str = null;
/* 68 */       HttpParams httpParams = paramHttpRequest.getParams();
/* 69 */       if (httpParams != null) {
/* 70 */         str = (String)httpParams.getParameter("http.useragent");
/*    */       }
/* 72 */       if (str == null) {
/* 73 */         str = this.userAgent;
/*    */       }
/* 75 */       if (str != null)
/* 76 */         paramHttpRequest.addHeader("User-Agent", str); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\RequestUserAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */