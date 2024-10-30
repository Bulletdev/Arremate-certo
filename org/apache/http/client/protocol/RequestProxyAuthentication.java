/*    */ package org.apache.http.client.protocol;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.http.HttpException;
/*    */ import org.apache.http.HttpRequest;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.auth.AuthState;
/*    */ import org.apache.http.conn.HttpRoutedConnection;
/*    */ import org.apache.http.conn.routing.HttpRoute;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class RequestProxyAuthentication
/*    */   extends RequestAuthenticationBase
/*    */ {
/*    */   public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException, IOException {
/* 63 */     Args.notNull(paramHttpRequest, "HTTP request");
/* 64 */     Args.notNull(paramHttpContext, "HTTP context");
/*    */     
/* 66 */     if (paramHttpRequest.containsHeader("Proxy-Authorization")) {
/*    */       return;
/*    */     }
/*    */     
/* 70 */     HttpRoutedConnection httpRoutedConnection = (HttpRoutedConnection)paramHttpContext.getAttribute("http.connection");
/*    */     
/* 72 */     if (httpRoutedConnection == null) {
/* 73 */       this.log.debug("HTTP connection not set in the context");
/*    */       return;
/*    */     } 
/* 76 */     HttpRoute httpRoute = httpRoutedConnection.getRoute();
/* 77 */     if (httpRoute.isTunnelled()) {
/*    */       return;
/*    */     }
/*    */ 
/*    */     
/* 82 */     AuthState authState = (AuthState)paramHttpContext.getAttribute("http.auth.proxy-scope");
/*    */     
/* 84 */     if (authState == null) {
/* 85 */       this.log.debug("Proxy auth state not set in the context");
/*    */       return;
/*    */     } 
/* 88 */     if (this.log.isDebugEnabled()) {
/* 89 */       this.log.debug("Proxy auth state: " + authState.getState());
/*    */     }
/* 91 */     process(authState, paramHttpRequest, paramHttpContext);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\protocol\RequestProxyAuthentication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */