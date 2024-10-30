/*     */ package org.apache.http.protocol;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpEntityEnclosingRequest;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpRequestInterceptor;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class RequestContent
/*     */   implements HttpRequestInterceptor
/*     */ {
/*     */   private final boolean overwrite;
/*     */   
/*     */   public RequestContent() {
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
/*     */   public RequestContent(boolean paramBoolean) {
/*  81 */     this.overwrite = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException, IOException {
/*  87 */     Args.notNull(paramHttpRequest, "HTTP request");
/*  88 */     if (paramHttpRequest instanceof HttpEntityEnclosingRequest) {
/*  89 */       if (this.overwrite) {
/*  90 */         paramHttpRequest.removeHeaders("Transfer-Encoding");
/*  91 */         paramHttpRequest.removeHeaders("Content-Length");
/*     */       } else {
/*  93 */         if (paramHttpRequest.containsHeader("Transfer-Encoding")) {
/*  94 */           throw new ProtocolException("Transfer-encoding header already present");
/*     */         }
/*  96 */         if (paramHttpRequest.containsHeader("Content-Length")) {
/*  97 */           throw new ProtocolException("Content-Length header already present");
/*     */         }
/*     */       } 
/* 100 */       ProtocolVersion protocolVersion = paramHttpRequest.getRequestLine().getProtocolVersion();
/* 101 */       HttpEntity httpEntity = ((HttpEntityEnclosingRequest)paramHttpRequest).getEntity();
/* 102 */       if (httpEntity == null) {
/* 103 */         paramHttpRequest.addHeader("Content-Length", "0");
/*     */         
/*     */         return;
/*     */       } 
/* 107 */       if (httpEntity.isChunked() || httpEntity.getContentLength() < 0L) {
/* 108 */         if (protocolVersion.lessEquals((ProtocolVersion)HttpVersion.HTTP_1_0)) {
/* 109 */           throw new ProtocolException("Chunked transfer encoding not allowed for " + protocolVersion);
/*     */         }
/*     */         
/* 112 */         paramHttpRequest.addHeader("Transfer-Encoding", "chunked");
/*     */       } else {
/* 114 */         paramHttpRequest.addHeader("Content-Length", Long.toString(httpEntity.getContentLength()));
/*     */       } 
/*     */       
/* 117 */       if (httpEntity.getContentType() != null && !paramHttpRequest.containsHeader("Content-Type"))
/*     */       {
/* 119 */         paramHttpRequest.addHeader(httpEntity.getContentType());
/*     */       }
/*     */       
/* 122 */       if (httpEntity.getContentEncoding() != null && !paramHttpRequest.containsHeader("Content-Encoding"))
/*     */       {
/* 124 */         paramHttpRequest.addHeader(httpEntity.getContentEncoding());
/*     */       }
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\RequestContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */