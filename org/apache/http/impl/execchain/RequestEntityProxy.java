/*     */ package org.apache.http.impl.execchain;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.HttpEntityEnclosingRequest;
/*     */ import org.apache.http.HttpRequest;
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
/*     */ class RequestEntityProxy
/*     */   implements HttpEntity
/*     */ {
/*     */   private final HttpEntity original;
/*     */   
/*     */   static void enhance(HttpEntityEnclosingRequest paramHttpEntityEnclosingRequest) {
/*  46 */     HttpEntity httpEntity = paramHttpEntityEnclosingRequest.getEntity();
/*  47 */     if (httpEntity != null && !httpEntity.isRepeatable() && !isEnhanced(httpEntity)) {
/*  48 */       paramHttpEntityEnclosingRequest.setEntity(new RequestEntityProxy(httpEntity));
/*     */     }
/*     */   }
/*     */   
/*     */   static boolean isEnhanced(HttpEntity paramHttpEntity) {
/*  53 */     return paramHttpEntity instanceof RequestEntityProxy;
/*     */   }
/*     */   
/*     */   static boolean isRepeatable(HttpRequest paramHttpRequest) {
/*  57 */     if (paramHttpRequest instanceof HttpEntityEnclosingRequest) {
/*  58 */       HttpEntity httpEntity = ((HttpEntityEnclosingRequest)paramHttpRequest).getEntity();
/*  59 */       if (httpEntity != null) {
/*  60 */         if (isEnhanced(httpEntity)) {
/*  61 */           RequestEntityProxy requestEntityProxy = (RequestEntityProxy)httpEntity;
/*  62 */           if (!requestEntityProxy.isConsumed()) {
/*  63 */             return true;
/*     */           }
/*     */         } 
/*  66 */         return httpEntity.isRepeatable();
/*     */       } 
/*     */     } 
/*  69 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean consumed = false;
/*     */ 
/*     */   
/*     */   RequestEntityProxy(HttpEntity paramHttpEntity) {
/*  77 */     this.original = paramHttpEntity;
/*     */   }
/*     */   
/*     */   public HttpEntity getOriginal() {
/*  81 */     return this.original;
/*     */   }
/*     */   
/*     */   public boolean isConsumed() {
/*  85 */     return this.consumed;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRepeatable() {
/*  90 */     return this.original.isRepeatable();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isChunked() {
/*  95 */     return this.original.isChunked();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContentLength() {
/* 100 */     return this.original.getContentLength();
/*     */   }
/*     */ 
/*     */   
/*     */   public Header getContentType() {
/* 105 */     return this.original.getContentType();
/*     */   }
/*     */ 
/*     */   
/*     */   public Header getContentEncoding() {
/* 110 */     return this.original.getContentEncoding();
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getContent() throws IOException, IllegalStateException {
/* 115 */     return this.original.getContent();
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 120 */     this.consumed = true;
/* 121 */     this.original.writeTo(paramOutputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStreaming() {
/* 126 */     return this.original.isStreaming();
/*     */   }
/*     */ 
/*     */   
/*     */   public void consumeContent() throws IOException {
/* 131 */     this.consumed = true;
/* 132 */     this.original.consumeContent();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 137 */     StringBuilder stringBuilder = new StringBuilder("RequestEntityProxy{");
/* 138 */     stringBuilder.append(this.original);
/* 139 */     stringBuilder.append('}');
/* 140 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\execchain\RequestEntityProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */