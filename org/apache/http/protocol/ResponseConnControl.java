/*     */ package org.apache.http.protocol;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.HttpResponseInterceptor;
/*     */ import org.apache.http.HttpVersion;
/*     */ import org.apache.http.ProtocolVersion;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.util.Args;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class ResponseConnControl
/*     */   implements HttpResponseInterceptor
/*     */ {
/*     */   public void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws HttpException, IOException {
/*  63 */     Args.notNull(paramHttpResponse, "HTTP response");
/*     */     
/*  65 */     HttpCoreContext httpCoreContext = HttpCoreContext.adapt(paramHttpContext);
/*     */ 
/*     */     
/*  68 */     int i = paramHttpResponse.getStatusLine().getStatusCode();
/*  69 */     if (i == 400 || i == 408 || i == 411 || i == 413 || i == 414 || i == 503 || i == 501) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  76 */       paramHttpResponse.setHeader("Connection", "Close");
/*     */       return;
/*     */     } 
/*  79 */     Header header = paramHttpResponse.getFirstHeader("Connection");
/*  80 */     if (header != null && "Close".equalsIgnoreCase(header.getValue())) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  86 */     HttpEntity httpEntity = paramHttpResponse.getEntity();
/*  87 */     if (httpEntity != null) {
/*  88 */       ProtocolVersion protocolVersion = paramHttpResponse.getStatusLine().getProtocolVersion();
/*  89 */       if (httpEntity.getContentLength() < 0L && (!httpEntity.isChunked() || protocolVersion.lessEquals((ProtocolVersion)HttpVersion.HTTP_1_0))) {
/*     */         
/*  91 */         paramHttpResponse.setHeader("Connection", "Close");
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*  96 */     HttpRequest httpRequest = httpCoreContext.getRequest();
/*  97 */     if (httpRequest != null) {
/*  98 */       Header header1 = httpRequest.getFirstHeader("Connection");
/*  99 */       if (header1 != null) {
/* 100 */         paramHttpResponse.setHeader("Connection", header1.getValue());
/* 101 */       } else if (httpRequest.getProtocolVersion().lessEquals((ProtocolVersion)HttpVersion.HTTP_1_0)) {
/* 102 */         paramHttpResponse.setHeader("Connection", "Close");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\ResponseConnControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */