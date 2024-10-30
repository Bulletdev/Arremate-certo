/*    */ package org.apache.http.impl.client;
/*    */ 
/*    */ import java.net.URI;
/*    */ import org.apache.http.HttpRequest;
/*    */ import org.apache.http.HttpResponse;
/*    */ import org.apache.http.ProtocolException;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.client.RedirectHandler;
/*    */ import org.apache.http.client.RedirectStrategy;
/*    */ import org.apache.http.client.methods.HttpGet;
/*    */ import org.apache.http.client.methods.HttpHead;
/*    */ import org.apache.http.client.methods.HttpUriRequest;
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
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ class DefaultRedirectStrategyAdaptor
/*    */   implements RedirectStrategy
/*    */ {
/*    */   private final RedirectHandler handler;
/*    */   
/*    */   public DefaultRedirectStrategyAdaptor(RedirectHandler paramRedirectHandler) {
/* 55 */     this.handler = paramRedirectHandler;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isRedirected(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws ProtocolException {
/* 63 */     return this.handler.isRedirectRequested(paramHttpResponse, paramHttpContext);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public HttpUriRequest getRedirect(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws ProtocolException {
/* 71 */     URI uRI = this.handler.getLocationURI(paramHttpResponse, paramHttpContext);
/* 72 */     String str = paramHttpRequest.getRequestLine().getMethod();
/* 73 */     if (str.equalsIgnoreCase("HEAD")) {
/* 74 */       return (HttpUriRequest)new HttpHead(uRI);
/*    */     }
/* 76 */     return (HttpUriRequest)new HttpGet(uRI);
/*    */   }
/*    */ 
/*    */   
/*    */   public RedirectHandler getHandler() {
/* 81 */     return this.handler;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\DefaultRedirectStrategyAdaptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */