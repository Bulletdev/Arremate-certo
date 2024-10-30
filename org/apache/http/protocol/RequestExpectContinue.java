/*    */ package org.apache.http.protocol;
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
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class RequestExpectContinue
/*    */   implements HttpRequestInterceptor
/*    */ {
/*    */   private final boolean activeByDefault;
/*    */   
/*    */   @Deprecated
/*    */   public RequestExpectContinue() {
/* 62 */     this(false);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public RequestExpectContinue(boolean paramBoolean) {
/* 70 */     this.activeByDefault = paramBoolean;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException, IOException {
/* 76 */     Args.notNull(paramHttpRequest, "HTTP request");
/*    */     
/* 78 */     if (!paramHttpRequest.containsHeader("Expect") && 
/* 79 */       paramHttpRequest instanceof HttpEntityEnclosingRequest) {
/* 80 */       ProtocolVersion protocolVersion = paramHttpRequest.getRequestLine().getProtocolVersion();
/* 81 */       HttpEntity httpEntity = ((HttpEntityEnclosingRequest)paramHttpRequest).getEntity();
/*    */       
/* 83 */       if (httpEntity != null && httpEntity.getContentLength() != 0L && !protocolVersion.lessEquals((ProtocolVersion)HttpVersion.HTTP_1_0)) {
/*    */         
/* 85 */         boolean bool = paramHttpRequest.getParams().getBooleanParameter("http.protocol.expect-continue", this.activeByDefault);
/*    */         
/* 87 */         if (bool)
/* 88 */           paramHttpRequest.addHeader("Expect", "100-continue"); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\RequestExpectContinue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */