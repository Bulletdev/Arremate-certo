/*    */ package org.apache.http.client.protocol;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import org.apache.http.HttpException;
/*    */ import org.apache.http.HttpRequest;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.auth.AuthState;
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
/*    */ @Deprecated
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class RequestTargetAuthentication
/*    */   extends RequestAuthenticationBase
/*    */ {
/*    */   public void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws HttpException, IOException {
/* 60 */     Args.notNull(paramHttpRequest, "HTTP request");
/* 61 */     Args.notNull(paramHttpContext, "HTTP context");
/*    */     
/* 63 */     String str = paramHttpRequest.getRequestLine().getMethod();
/* 64 */     if (str.equalsIgnoreCase("CONNECT")) {
/*    */       return;
/*    */     }
/*    */     
/* 68 */     if (paramHttpRequest.containsHeader("Authorization")) {
/*    */       return;
/*    */     }
/*    */ 
/*    */     
/* 73 */     AuthState authState = (AuthState)paramHttpContext.getAttribute("http.auth.target-scope");
/*    */     
/* 75 */     if (authState == null) {
/* 76 */       this.log.debug("Target auth state not set in the context");
/*    */       return;
/*    */     } 
/* 79 */     if (this.log.isDebugEnabled()) {
/* 80 */       this.log.debug("Target auth state: " + authState.getState());
/*    */     }
/* 82 */     process(authState, paramHttpRequest, paramHttpContext);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\protocol\RequestTargetAuthentication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */