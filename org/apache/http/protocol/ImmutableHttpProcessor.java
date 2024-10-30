/*     */ package org.apache.http.protocol;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpRequestInterceptor;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.HttpResponseInterceptor;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*     */ public final class ImmutableHttpProcessor
/*     */   implements HttpProcessor
/*     */ {
/*     */   private final HttpRequestInterceptor[] requestInterceptors;
/*     */   private final HttpResponseInterceptor[] responseInterceptors;
/*     */   
/*     */   public ImmutableHttpProcessor(HttpRequestInterceptor[] paramArrayOfHttpRequestInterceptor, HttpResponseInterceptor[] paramArrayOfHttpResponseInterceptor) {
/*  55 */     if (paramArrayOfHttpRequestInterceptor != null) {
/*  56 */       int i = paramArrayOfHttpRequestInterceptor.length;
/*  57 */       this.requestInterceptors = new HttpRequestInterceptor[i];
/*  58 */       System.arraycopy(paramArrayOfHttpRequestInterceptor, 0, this.requestInterceptors, 0, i);
/*     */     } else {
/*  60 */       this.requestInterceptors = new HttpRequestInterceptor[0];
/*     */     } 
/*  62 */     if (paramArrayOfHttpResponseInterceptor != null) {
/*  63 */       int i = paramArrayOfHttpResponseInterceptor.length;
/*  64 */       this.responseInterceptors = new HttpResponseInterceptor[i];
/*  65 */       System.arraycopy(paramArrayOfHttpResponseInterceptor, 0, this.responseInterceptors, 0, i);
/*     */     } else {
/*  67 */       this.responseInterceptors = new HttpResponseInterceptor[0];
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ImmutableHttpProcessor(List<HttpRequestInterceptor> paramList, List<HttpResponseInterceptor> paramList1) {
/*  78 */     if (paramList != null) {
/*  79 */       int i = paramList.size();
/*  80 */       this.requestInterceptors = paramList.<HttpRequestInterceptor>toArray(new HttpRequestInterceptor[i]);
/*     */     } else {
/*  82 */       this.requestInterceptors = new HttpRequestInterceptor[0];
/*     */     } 
/*  84 */     if (paramList1 != null) {
/*  85 */       int i = paramList1.size();
/*  86 */       this.responseInterceptors = paramList1.<HttpResponseInterceptor>toArray(new HttpResponseInterceptor[i]);
/*     */     } else {
/*  88 */       this.responseInterceptors = new HttpResponseInterceptor[0];
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public ImmutableHttpProcessor(HttpRequestInterceptorList paramHttpRequestInterceptorList, HttpResponseInterceptorList paramHttpResponseInterceptorList) {
/* 100 */     if (paramHttpRequestInterceptorList != null) {
/* 101 */       int i = paramHttpRequestInterceptorList.getRequestInterceptorCount();
/* 102 */       this.requestInterceptors = new HttpRequestInterceptor[i];
/* 103 */       for (byte b = 0; b < i; b++) {
/* 104 */         this.requestInterceptors[b] = paramHttpRequestInterceptorList.getRequestInterceptor(b);
/*     */       }
/*     */     } else {
/* 107 */       this.requestInterceptors = new HttpRequestInterceptor[0];
/*     */     } 
/* 109 */     if (paramHttpResponseInterceptorList != null) {
/* 110 */       int i = paramHttpResponseInterceptorList.getResponseInterceptorCount();
/* 111 */       this.responseInterceptors = new HttpResponseInterceptor[i];
/* 112 */       for (byte b = 0; b < i; b++) {
/* 113 */         this.responseInterceptors[b] = paramHttpResponseInterceptorList.getResponseInterceptor(b);
/*     */       }
/*     */     } else {
/* 116 */       this.responseInterceptors = new HttpResponseInterceptor[0];
/*     */     } 
/*     */   }
/*     */   
/*     */   public ImmutableHttpProcessor(HttpRequestInterceptor... paramVarArgs) {
/* 121 */     this(paramVarArgs, (HttpResponseInterceptor[])null);
/*     */   }
/*     */   
/*     */   public ImmutableHttpProcessor(HttpResponseInterceptor... paramVarArgs) {
/* 125 */     this((HttpRequestInterceptor[])null, paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws IOException, HttpException {
/* 132 */     for (HttpRequestInterceptor httpRequestInterceptor : this.requestInterceptors) {
/* 133 */       httpRequestInterceptor.process(paramHttpRequest, paramHttpContext);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws IOException, HttpException {
/* 141 */     for (HttpResponseInterceptor httpResponseInterceptor : this.responseInterceptors)
/* 142 */       httpResponseInterceptor.process(paramHttpResponse, paramHttpContext); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\ImmutableHttpProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */