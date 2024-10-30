/*     */ package org.apache.http.protocol;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.HttpResponseInterceptor;
/*     */ import org.apache.http.HttpVersion;
/*     */ import org.apache.http.ProtocolException;
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
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class ResponseContent
/*     */   implements HttpResponseInterceptor
/*     */ {
/*     */   private final boolean overwrite;
/*     */   
/*     */   public ResponseContent() {
/*  65 */     this(false);
/*     */   }
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
/*     */   public ResponseContent(boolean paramBoolean) {
/*  81 */     this.overwrite = paramBoolean;
/*     */   }
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
/*     */   public void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws HttpException, IOException {
/*  94 */     Args.notNull(paramHttpResponse, "HTTP response");
/*  95 */     if (this.overwrite) {
/*  96 */       paramHttpResponse.removeHeaders("Transfer-Encoding");
/*  97 */       paramHttpResponse.removeHeaders("Content-Length");
/*     */     } else {
/*  99 */       if (paramHttpResponse.containsHeader("Transfer-Encoding")) {
/* 100 */         throw new ProtocolException("Transfer-encoding header already present");
/*     */       }
/* 102 */       if (paramHttpResponse.containsHeader("Content-Length")) {
/* 103 */         throw new ProtocolException("Content-Length header already present");
/*     */       }
/*     */     } 
/* 106 */     ProtocolVersion protocolVersion = paramHttpResponse.getStatusLine().getProtocolVersion();
/* 107 */     HttpEntity httpEntity = paramHttpResponse.getEntity();
/* 108 */     if (httpEntity != null) {
/* 109 */       long l = httpEntity.getContentLength();
/* 110 */       if (httpEntity.isChunked() && !protocolVersion.lessEquals((ProtocolVersion)HttpVersion.HTTP_1_0)) {
/* 111 */         paramHttpResponse.addHeader("Transfer-Encoding", "chunked");
/* 112 */       } else if (l >= 0L) {
/* 113 */         paramHttpResponse.addHeader("Content-Length", Long.toString(httpEntity.getContentLength()));
/*     */       } 
/*     */       
/* 116 */       if (httpEntity.getContentType() != null && !paramHttpResponse.containsHeader("Content-Type"))
/*     */       {
/* 118 */         paramHttpResponse.addHeader(httpEntity.getContentType());
/*     */       }
/*     */       
/* 121 */       if (httpEntity.getContentEncoding() != null && !paramHttpResponse.containsHeader("Content-Encoding"))
/*     */       {
/* 123 */         paramHttpResponse.addHeader(httpEntity.getContentEncoding());
/*     */       }
/*     */     } else {
/* 126 */       int i = paramHttpResponse.getStatusLine().getStatusCode();
/* 127 */       if (i != 204 && i != 304 && i != 205)
/*     */       {
/*     */         
/* 130 */         paramHttpResponse.addHeader("Content-Length", "0");
/*     */       }
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\ResponseContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */