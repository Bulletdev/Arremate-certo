/*     */ package org.apache.http.protocol;
/*     */ 
/*     */ import org.apache.http.HttpRequest;
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
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public class UriHttpRequestHandlerMapper
/*     */   implements HttpRequestHandlerMapper
/*     */ {
/*     */   private final UriPatternMatcher<HttpRequestHandler> matcher;
/*     */   
/*     */   protected UriHttpRequestHandlerMapper(UriPatternMatcher<HttpRequestHandler> paramUriPatternMatcher) {
/*  59 */     this.matcher = (UriPatternMatcher<HttpRequestHandler>)Args.notNull(paramUriPatternMatcher, "Pattern matcher");
/*     */   }
/*     */   
/*     */   public UriHttpRequestHandlerMapper() {
/*  63 */     this(new UriPatternMatcher<HttpRequestHandler>());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void register(String paramString, HttpRequestHandler paramHttpRequestHandler) {
/*  74 */     Args.notNull(paramString, "Pattern");
/*  75 */     Args.notNull(paramHttpRequestHandler, "Handler");
/*  76 */     this.matcher.register(paramString, paramHttpRequestHandler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregister(String paramString) {
/*  85 */     this.matcher.unregister(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getRequestPath(HttpRequest paramHttpRequest) {
/*  92 */     String str = paramHttpRequest.getRequestLine().getUri();
/*  93 */     int i = str.indexOf('?');
/*  94 */     if (i != -1) {
/*  95 */       str = str.substring(0, i);
/*     */     } else {
/*  97 */       i = str.indexOf('#');
/*  98 */       if (i != -1) {
/*  99 */         str = str.substring(0, i);
/*     */       }
/*     */     } 
/* 102 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpRequestHandler lookup(HttpRequest paramHttpRequest) {
/* 113 */     Args.notNull(paramHttpRequest, "HTTP request");
/* 114 */     return this.matcher.lookup(getRequestPath(paramHttpRequest));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\UriHttpRequestHandlerMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */