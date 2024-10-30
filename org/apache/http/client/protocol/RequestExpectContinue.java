/*    */ package org.apache.http.client.protocol;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.http.HttpEntity;
/*    */ import org.apache.http.HttpEntityEnclosingRequest;
/*    */ import org.apache.http.HttpException;
/*    */ import org.apache.http.HttpRequest;
/*    */ import org.apache.http.HttpRequestInterceptor;
/*    */ import org.apache.http.HttpVersion;
/*    */ import org.apache.http.ProtocolVersion;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.client.config.RequestConfig;
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
/*    */ public class RequestExpectContinue
/*    */   implements HttpRequestInterceptor
/*    */ {
/*    */   public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException, IOException {
/* 66 */     Args.notNull(paramHttpRequest, "HTTP request");
/*    */     
/* 68 */     if (!paramHttpRequest.containsHeader("Expect") && 
/* 69 */       paramHttpRequest instanceof HttpEntityEnclosingRequest) {
/* 70 */       ProtocolVersion protocolVersion = paramHttpRequest.getRequestLine().getProtocolVersion();
/* 71 */       HttpEntity httpEntity = ((HttpEntityEnclosingRequest)paramHttpRequest).getEntity();
/*    */       
/* 73 */       if (httpEntity != null && httpEntity.getContentLength() != 0L && !protocolVersion.lessEquals((ProtocolVersion)HttpVersion.HTTP_1_0)) {
/*    */         
/* 75 */         HttpClientContext httpClientContext = HttpClientContext.adapt(paramHttpContext);
/* 76 */         RequestConfig requestConfig = httpClientContext.getRequestConfig();
/* 77 */         if (requestConfig.isExpectContinueEnabled())
/* 78 */           paramHttpRequest.addHeader("Expect", "100-continue"); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\protocol\RequestExpectContinue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */