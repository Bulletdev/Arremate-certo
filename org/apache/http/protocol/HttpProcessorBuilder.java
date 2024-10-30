/*     */ package org.apache.http.protocol;
/*     */ 
/*     */ import org.apache.http.HttpRequestInterceptor;
/*     */ import org.apache.http.HttpResponseInterceptor;
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
/*     */ public class HttpProcessorBuilder
/*     */ {
/*     */   private ChainBuilder<HttpRequestInterceptor> requestChainBuilder;
/*     */   private ChainBuilder<HttpResponseInterceptor> responseChainBuilder;
/*     */   
/*     */   public static HttpProcessorBuilder create() {
/*  44 */     return new HttpProcessorBuilder();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ChainBuilder<HttpRequestInterceptor> getRequestChainBuilder() {
/*  52 */     if (this.requestChainBuilder == null) {
/*  53 */       this.requestChainBuilder = new ChainBuilder<HttpRequestInterceptor>();
/*     */     }
/*  55 */     return this.requestChainBuilder;
/*     */   }
/*     */   
/*     */   private ChainBuilder<HttpResponseInterceptor> getResponseChainBuilder() {
/*  59 */     if (this.responseChainBuilder == null) {
/*  60 */       this.responseChainBuilder = new ChainBuilder<HttpResponseInterceptor>();
/*     */     }
/*  62 */     return this.responseChainBuilder;
/*     */   }
/*     */   
/*     */   public HttpProcessorBuilder addFirst(HttpRequestInterceptor paramHttpRequestInterceptor) {
/*  66 */     if (paramHttpRequestInterceptor == null) {
/*  67 */       return this;
/*     */     }
/*  69 */     getRequestChainBuilder().addFirst(paramHttpRequestInterceptor);
/*  70 */     return this;
/*     */   }
/*     */   
/*     */   public HttpProcessorBuilder addLast(HttpRequestInterceptor paramHttpRequestInterceptor) {
/*  74 */     if (paramHttpRequestInterceptor == null) {
/*  75 */       return this;
/*     */     }
/*  77 */     getRequestChainBuilder().addLast(paramHttpRequestInterceptor);
/*  78 */     return this;
/*     */   }
/*     */   
/*     */   public HttpProcessorBuilder add(HttpRequestInterceptor paramHttpRequestInterceptor) {
/*  82 */     return addLast(paramHttpRequestInterceptor);
/*     */   }
/*     */   
/*     */   public HttpProcessorBuilder addAllFirst(HttpRequestInterceptor... paramVarArgs) {
/*  86 */     if (paramVarArgs == null) {
/*  87 */       return this;
/*     */     }
/*  89 */     getRequestChainBuilder().addAllFirst(paramVarArgs);
/*  90 */     return this;
/*     */   }
/*     */   
/*     */   public HttpProcessorBuilder addAllLast(HttpRequestInterceptor... paramVarArgs) {
/*  94 */     if (paramVarArgs == null) {
/*  95 */       return this;
/*     */     }
/*  97 */     getRequestChainBuilder().addAllLast(paramVarArgs);
/*  98 */     return this;
/*     */   }
/*     */   
/*     */   public HttpProcessorBuilder addAll(HttpRequestInterceptor... paramVarArgs) {
/* 102 */     return addAllLast(paramVarArgs);
/*     */   }
/*     */   
/*     */   public HttpProcessorBuilder addFirst(HttpResponseInterceptor paramHttpResponseInterceptor) {
/* 106 */     if (paramHttpResponseInterceptor == null) {
/* 107 */       return this;
/*     */     }
/* 109 */     getResponseChainBuilder().addFirst(paramHttpResponseInterceptor);
/* 110 */     return this;
/*     */   }
/*     */   
/*     */   public HttpProcessorBuilder addLast(HttpResponseInterceptor paramHttpResponseInterceptor) {
/* 114 */     if (paramHttpResponseInterceptor == null) {
/* 115 */       return this;
/*     */     }
/* 117 */     getResponseChainBuilder().addLast(paramHttpResponseInterceptor);
/* 118 */     return this;
/*     */   }
/*     */   
/*     */   public HttpProcessorBuilder add(HttpResponseInterceptor paramHttpResponseInterceptor) {
/* 122 */     return addLast(paramHttpResponseInterceptor);
/*     */   }
/*     */   
/*     */   public HttpProcessorBuilder addAllFirst(HttpResponseInterceptor... paramVarArgs) {
/* 126 */     if (paramVarArgs == null) {
/* 127 */       return this;
/*     */     }
/* 129 */     getResponseChainBuilder().addAllFirst(paramVarArgs);
/* 130 */     return this;
/*     */   }
/*     */   
/*     */   public HttpProcessorBuilder addAllLast(HttpResponseInterceptor... paramVarArgs) {
/* 134 */     if (paramVarArgs == null) {
/* 135 */       return this;
/*     */     }
/* 137 */     getResponseChainBuilder().addAllLast(paramVarArgs);
/* 138 */     return this;
/*     */   }
/*     */   
/*     */   public HttpProcessorBuilder addAll(HttpResponseInterceptor... paramVarArgs) {
/* 142 */     return addAllLast(paramVarArgs);
/*     */   }
/*     */   
/*     */   public HttpProcessor build() {
/* 146 */     return new ImmutableHttpProcessor((this.requestChainBuilder != null) ? this.requestChainBuilder.build() : null, (this.responseChainBuilder != null) ? this.responseChainBuilder.build() : null);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\HttpProcessorBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */