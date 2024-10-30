/*     */ package org.apache.http.protocol;
/*     */ 
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public class HttpRequestHandlerRegistry
/*     */   implements HttpRequestHandlerResolver
/*     */ {
/*  61 */   private final UriPatternMatcher<HttpRequestHandler> matcher = new UriPatternMatcher<HttpRequestHandler>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void register(String paramString, HttpRequestHandler paramHttpRequestHandler) {
/*  72 */     Args.notNull(paramString, "URI request pattern");
/*  73 */     Args.notNull(paramHttpRequestHandler, "Request handler");
/*  74 */     this.matcher.register(paramString, paramHttpRequestHandler);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregister(String paramString) {
/*  83 */     this.matcher.unregister(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHandlers(Map<String, HttpRequestHandler> paramMap) {
/*  91 */     this.matcher.setObjects(paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, HttpRequestHandler> getHandlers() {
/* 101 */     return this.matcher.getObjects();
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpRequestHandler lookup(String paramString) {
/* 106 */     return this.matcher.lookup(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\HttpRequestHandlerRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */