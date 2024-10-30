/*     */ package org.apache.http.impl;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.HttpResponseFactory;
/*     */ import org.apache.http.ProtocolVersion;
/*     */ import org.apache.http.ReasonPhraseCatalog;
/*     */ import org.apache.http.StatusLine;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.message.BasicHttpResponse;
/*     */ import org.apache.http.message.BasicStatusLine;
/*     */ import org.apache.http.protocol.HttpContext;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*     */ public class DefaultHttpResponseFactory
/*     */   implements HttpResponseFactory
/*     */ {
/*  52 */   public static final DefaultHttpResponseFactory INSTANCE = new DefaultHttpResponseFactory();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final ReasonPhraseCatalog reasonCatalog;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultHttpResponseFactory(ReasonPhraseCatalog paramReasonPhraseCatalog) {
/*  64 */     this.reasonCatalog = (ReasonPhraseCatalog)Args.notNull(paramReasonPhraseCatalog, "Reason phrase catalog");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultHttpResponseFactory() {
/*  72 */     this(EnglishReasonPhraseCatalog.INSTANCE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpResponse newHttpResponse(ProtocolVersion paramProtocolVersion, int paramInt, HttpContext paramHttpContext) {
/*  82 */     Args.notNull(paramProtocolVersion, "HTTP version");
/*  83 */     Locale locale = determineLocale(paramHttpContext);
/*  84 */     String str = this.reasonCatalog.getReason(paramInt, locale);
/*  85 */     BasicStatusLine basicStatusLine = new BasicStatusLine(paramProtocolVersion, paramInt, str);
/*  86 */     return (HttpResponse)new BasicHttpResponse((StatusLine)basicStatusLine, this.reasonCatalog, locale);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpResponse newHttpResponse(StatusLine paramStatusLine, HttpContext paramHttpContext) {
/*  95 */     Args.notNull(paramStatusLine, "Status line");
/*  96 */     return (HttpResponse)new BasicHttpResponse(paramStatusLine, this.reasonCatalog, determineLocale(paramHttpContext));
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
/*     */   protected Locale determineLocale(HttpContext paramHttpContext) {
/* 109 */     return Locale.getDefault();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\DefaultHttpResponseFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */