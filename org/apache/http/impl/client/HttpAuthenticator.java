/*    */ package org.apache.http.impl.client;
/*    */ 
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.http.HttpHost;
/*    */ import org.apache.http.HttpResponse;
/*    */ import org.apache.http.auth.AuthState;
/*    */ import org.apache.http.client.AuthenticationStrategy;
/*    */ import org.apache.http.impl.auth.HttpAuthenticator;
/*    */ import org.apache.http.protocol.HttpContext;
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
/*    */ public class HttpAuthenticator
/*    */   extends HttpAuthenticator
/*    */ {
/*    */   public HttpAuthenticator(Log paramLog) {
/* 45 */     super(paramLog);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public HttpAuthenticator() {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean authenticate(HttpHost paramHttpHost, HttpResponse paramHttpResponse, AuthenticationStrategy paramAuthenticationStrategy, AuthState paramAuthState, HttpContext paramHttpContext) {
/* 58 */     return handleAuthChallenge(paramHttpHost, paramHttpResponse, paramAuthenticationStrategy, paramAuthState, paramHttpContext);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\HttpAuthenticator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */