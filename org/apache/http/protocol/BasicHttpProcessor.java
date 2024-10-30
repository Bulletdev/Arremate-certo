/*     */ package org.apache.http.protocol;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpRequestInterceptor;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.HttpResponseInterceptor;
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
/*     */ @Deprecated
/*     */ public final class BasicHttpProcessor
/*     */   implements Cloneable, HttpProcessor, HttpRequestInterceptorList, HttpResponseInterceptorList
/*     */ {
/*  57 */   protected final List<HttpRequestInterceptor> requestInterceptors = new ArrayList<HttpRequestInterceptor>();
/*  58 */   protected final List<HttpResponseInterceptor> responseInterceptors = new ArrayList<HttpResponseInterceptor>();
/*     */ 
/*     */   
/*     */   public void addRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor) {
/*  62 */     if (paramHttpRequestInterceptor == null) {
/*     */       return;
/*     */     }
/*  65 */     this.requestInterceptors.add(paramHttpRequestInterceptor);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor, int paramInt) {
/*  71 */     if (paramHttpRequestInterceptor == null) {
/*     */       return;
/*     */     }
/*  74 */     this.requestInterceptors.add(paramInt, paramHttpRequestInterceptor);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor, int paramInt) {
/*  80 */     if (paramHttpResponseInterceptor == null) {
/*     */       return;
/*     */     }
/*  83 */     this.responseInterceptors.add(paramInt, paramHttpResponseInterceptor);
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeRequestInterceptorByClass(Class<? extends HttpRequestInterceptor> paramClass) {
/*  88 */     Iterator<HttpRequestInterceptor> iterator = this.requestInterceptors.iterator();
/*  89 */     while (iterator.hasNext()) {
/*  90 */       Object object = iterator.next();
/*  91 */       if (object.getClass().equals(paramClass)) {
/*  92 */         iterator.remove();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeResponseInterceptorByClass(Class<? extends HttpResponseInterceptor> paramClass) {
/*  99 */     Iterator<HttpResponseInterceptor> iterator = this.responseInterceptors.iterator();
/* 100 */     while (iterator.hasNext()) {
/* 101 */       Object object = iterator.next();
/* 102 */       if (object.getClass().equals(paramClass)) {
/* 103 */         iterator.remove();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor) {
/* 109 */     addRequestInterceptor(paramHttpRequestInterceptor);
/*     */   }
/*     */   
/*     */   public void addInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor, int paramInt) {
/* 113 */     addRequestInterceptor(paramHttpRequestInterceptor, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRequestInterceptorCount() {
/* 118 */     return this.requestInterceptors.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpRequestInterceptor getRequestInterceptor(int paramInt) {
/* 123 */     if (paramInt < 0 || paramInt >= this.requestInterceptors.size()) {
/* 124 */       return null;
/*     */     }
/* 126 */     return this.requestInterceptors.get(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearRequestInterceptors() {
/* 131 */     this.requestInterceptors.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor) {
/* 136 */     if (paramHttpResponseInterceptor == null) {
/*     */       return;
/*     */     }
/* 139 */     this.responseInterceptors.add(paramHttpResponseInterceptor);
/*     */   }
/*     */   
/*     */   public void addInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor) {
/* 143 */     addResponseInterceptor(paramHttpResponseInterceptor);
/*     */   }
/*     */   
/*     */   public void addInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor, int paramInt) {
/* 147 */     addResponseInterceptor(paramHttpResponseInterceptor, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getResponseInterceptorCount() {
/* 152 */     return this.responseInterceptors.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpResponseInterceptor getResponseInterceptor(int paramInt) {
/* 157 */     if (paramInt < 0 || paramInt >= this.responseInterceptors.size()) {
/* 158 */       return null;
/*     */     }
/* 160 */     return this.responseInterceptors.get(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clearResponseInterceptors() {
/* 165 */     this.responseInterceptors.clear();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInterceptors(List<?> paramList) {
/* 187 */     Args.notNull(paramList, "Inteceptor list");
/* 188 */     this.requestInterceptors.clear();
/* 189 */     this.responseInterceptors.clear();
/* 190 */     for (Object object : paramList) {
/* 191 */       if (object instanceof HttpRequestInterceptor) {
/* 192 */         addInterceptor((HttpRequestInterceptor)object);
/*     */       }
/* 194 */       if (object instanceof HttpResponseInterceptor) {
/* 195 */         addInterceptor((HttpResponseInterceptor)object);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearInterceptors() {
/* 204 */     clearRequestInterceptors();
/* 205 */     clearResponseInterceptors();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws IOException, HttpException {
/* 213 */     for (HttpRequestInterceptor httpRequestInterceptor : this.requestInterceptors) {
/* 214 */       httpRequestInterceptor.process(paramHttpRequest, paramHttpContext);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws IOException, HttpException {
/* 223 */     for (HttpResponseInterceptor httpResponseInterceptor : this.responseInterceptors) {
/* 224 */       httpResponseInterceptor.process(paramHttpResponse, paramHttpContext);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void copyInterceptors(BasicHttpProcessor paramBasicHttpProcessor) {
/* 235 */     paramBasicHttpProcessor.requestInterceptors.clear();
/* 236 */     paramBasicHttpProcessor.requestInterceptors.addAll(this.requestInterceptors);
/* 237 */     paramBasicHttpProcessor.responseInterceptors.clear();
/* 238 */     paramBasicHttpProcessor.responseInterceptors.addAll(this.responseInterceptors);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasicHttpProcessor copy() {
/* 247 */     BasicHttpProcessor basicHttpProcessor = new BasicHttpProcessor();
/* 248 */     copyInterceptors(basicHttpProcessor);
/* 249 */     return basicHttpProcessor;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object clone() throws CloneNotSupportedException {
/* 254 */     BasicHttpProcessor basicHttpProcessor = (BasicHttpProcessor)super.clone();
/* 255 */     copyInterceptors(basicHttpProcessor);
/* 256 */     return basicHttpProcessor;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\BasicHttpProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */