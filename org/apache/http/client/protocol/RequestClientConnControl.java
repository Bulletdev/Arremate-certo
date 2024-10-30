/*    */ package org.apache.http.client.protocol;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.apache.http.HttpException;
/*    */ import org.apache.http.HttpRequest;
/*    */ import org.apache.http.HttpRequestInterceptor;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.conn.routing.RouteInfo;
/*    */ import org.apache.http.protocol.HttpContext;
/*    */ import org.apache.http.util.Args;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class RequestClientConnControl
/*    */   implements HttpRequestInterceptor
/*    */ {
/* 54 */   private final Log log = LogFactory.getLog(getClass());
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static final String PROXY_CONN_DIRECTIVE = "Proxy-Connection";
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException, IOException {
/* 65 */     Args.notNull(paramHttpRequest, "HTTP request");
/*    */     
/* 67 */     String str = paramHttpRequest.getRequestLine().getMethod();
/* 68 */     if (str.equalsIgnoreCase("CONNECT")) {
/* 69 */       paramHttpRequest.setHeader("Proxy-Connection", "Keep-Alive");
/*    */       
/*    */       return;
/*    */     } 
/* 73 */     HttpClientContext httpClientContext = HttpClientContext.adapt(paramHttpContext);
/*    */ 
/*    */     
/* 76 */     RouteInfo routeInfo = httpClientContext.getHttpRoute();
/* 77 */     if (routeInfo == null) {
/* 78 */       this.log.debug("Connection route not set in the context");
/*    */       
/*    */       return;
/*    */     } 
/* 82 */     if ((routeInfo.getHopCount() == 1 || routeInfo.isTunnelled()) && 
/* 83 */       !paramHttpRequest.containsHeader("Connection")) {
/* 84 */       paramHttpRequest.addHeader("Connection", "Keep-Alive");
/*    */     }
/*    */     
/* 87 */     if (routeInfo.getHopCount() == 2 && !routeInfo.isTunnelled() && 
/* 88 */       !paramHttpRequest.containsHeader("Proxy-Connection"))
/* 89 */       paramHttpRequest.addHeader("Proxy-Connection", "Keep-Alive"); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\protocol\RequestClientConnControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */