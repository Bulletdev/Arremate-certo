/*     */ package org.apache.http.protocol;
/*     */ 
/*     */ import org.apache.http.HttpConnection;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HttpCoreContext
/*     */   implements HttpContext
/*     */ {
/*     */   public static final String HTTP_CONNECTION = "http.connection";
/*     */   public static final String HTTP_REQUEST = "http.request";
/*     */   public static final String HTTP_RESPONSE = "http.response";
/*     */   public static final String HTTP_TARGET_HOST = "http.target_host";
/*     */   public static final String HTTP_REQ_SENT = "http.request_sent";
/*     */   private final HttpContext context;
/*     */   
/*     */   public static HttpCoreContext create() {
/*  76 */     return new HttpCoreContext(new BasicHttpContext());
/*     */   }
/*     */   
/*     */   public static HttpCoreContext adapt(HttpContext paramHttpContext) {
/*  80 */     Args.notNull(paramHttpContext, "HTTP context");
/*  81 */     return (paramHttpContext instanceof HttpCoreContext) ? (HttpCoreContext)paramHttpContext : new HttpCoreContext(paramHttpContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpCoreContext(HttpContext paramHttpContext) {
/*  90 */     this.context = paramHttpContext;
/*     */   }
/*     */ 
/*     */   
/*     */   public HttpCoreContext() {
/*  95 */     this.context = new BasicHttpContext();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getAttribute(String paramString) {
/* 100 */     return this.context.getAttribute(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAttribute(String paramString, Object paramObject) {
/* 105 */     this.context.setAttribute(paramString, paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object removeAttribute(String paramString) {
/* 110 */     return this.context.removeAttribute(paramString);
/*     */   }
/*     */   
/*     */   public <T> T getAttribute(String paramString, Class<T> paramClass) {
/* 114 */     Args.notNull(paramClass, "Attribute class");
/* 115 */     Object object = getAttribute(paramString);
/* 116 */     if (object == null) {
/* 117 */       return null;
/*     */     }
/* 119 */     return paramClass.cast(object);
/*     */   }
/*     */   
/*     */   public <T extends HttpConnection> T getConnection(Class<T> paramClass) {
/* 123 */     return (T)getAttribute("http.connection", paramClass);
/*     */   }
/*     */   
/*     */   public HttpConnection getConnection() {
/* 127 */     return getAttribute("http.connection", HttpConnection.class);
/*     */   }
/*     */   
/*     */   public HttpRequest getRequest() {
/* 131 */     return getAttribute("http.request", HttpRequest.class);
/*     */   }
/*     */   
/*     */   public boolean isRequestSent() {
/* 135 */     Boolean bool = getAttribute("http.request_sent", Boolean.class);
/* 136 */     return (bool != null && bool.booleanValue());
/*     */   }
/*     */   
/*     */   public HttpResponse getResponse() {
/* 140 */     return getAttribute("http.response", HttpResponse.class);
/*     */   }
/*     */   
/*     */   public void setTargetHost(HttpHost paramHttpHost) {
/* 144 */     setAttribute("http.target_host", paramHttpHost);
/*     */   }
/*     */   
/*     */   public HttpHost getTargetHost() {
/* 148 */     return getAttribute("http.target_host", HttpHost.class);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\HttpCoreContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */