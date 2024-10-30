/*     */ package org.apache.http.impl.conn;
/*     */ 
/*     */ import java.net.InetAddress;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.ProtocolException;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.client.protocol.HttpClientContext;
/*     */ import org.apache.http.conn.SchemePortResolver;
/*     */ import org.apache.http.conn.UnsupportedSchemeException;
/*     */ import org.apache.http.conn.routing.HttpRoute;
/*     */ import org.apache.http.conn.routing.HttpRoutePlanner;
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
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*     */ public class DefaultRoutePlanner
/*     */   implements HttpRoutePlanner
/*     */ {
/*     */   private final SchemePortResolver schemePortResolver;
/*     */   
/*     */   public DefaultRoutePlanner(SchemePortResolver paramSchemePortResolver) {
/*  60 */     this.schemePortResolver = (paramSchemePortResolver != null) ? paramSchemePortResolver : DefaultSchemePortResolver.INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpRoute determineRoute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException {
/*     */     HttpHost httpHost2;
/*  69 */     Args.notNull(paramHttpRequest, "Request");
/*  70 */     if (paramHttpHost == null) {
/*  71 */       throw new ProtocolException("Target host is not specified");
/*     */     }
/*  73 */     HttpClientContext httpClientContext = HttpClientContext.adapt(paramHttpContext);
/*  74 */     RequestConfig requestConfig = httpClientContext.getRequestConfig();
/*  75 */     InetAddress inetAddress = requestConfig.getLocalAddress();
/*  76 */     HttpHost httpHost1 = requestConfig.getProxy();
/*  77 */     if (httpHost1 == null) {
/*  78 */       httpHost1 = determineProxy(paramHttpHost, paramHttpRequest, paramHttpContext);
/*     */     }
/*     */ 
/*     */     
/*  82 */     if (paramHttpHost.getPort() <= 0) {
/*     */       try {
/*  84 */         httpHost2 = new HttpHost(paramHttpHost.getHostName(), this.schemePortResolver.resolve(paramHttpHost), paramHttpHost.getSchemeName());
/*     */ 
/*     */       
/*     */       }
/*  88 */       catch (UnsupportedSchemeException unsupportedSchemeException) {
/*  89 */         throw new HttpException(unsupportedSchemeException.getMessage());
/*     */       } 
/*     */     } else {
/*  92 */       httpHost2 = paramHttpHost;
/*     */     } 
/*  94 */     boolean bool = httpHost2.getSchemeName().equalsIgnoreCase("https");
/*  95 */     return (httpHost1 == null) ? new HttpRoute(httpHost2, inetAddress, bool) : new HttpRoute(httpHost2, inetAddress, httpHost1, bool);
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
/*     */   protected HttpHost determineProxy(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException {
/* 109 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\DefaultRoutePlanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */