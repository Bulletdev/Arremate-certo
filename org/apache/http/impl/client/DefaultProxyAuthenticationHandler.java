/*    */ package org.apache.http.impl.client;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.apache.http.Header;
/*    */ import org.apache.http.HttpResponse;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.auth.MalformedChallengeException;
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
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class DefaultProxyAuthenticationHandler
/*    */   extends AbstractAuthenticationHandler
/*    */ {
/*    */   public boolean isAuthenticationRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext) {
/* 64 */     Args.notNull(paramHttpResponse, "HTTP response");
/* 65 */     int i = paramHttpResponse.getStatusLine().getStatusCode();
/* 66 */     return (i == 407);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Map<String, Header> getChallenges(HttpResponse paramHttpResponse, HttpContext paramHttpContext) throws MalformedChallengeException {
/* 73 */     Args.notNull(paramHttpResponse, "HTTP response");
/* 74 */     Header[] arrayOfHeader = paramHttpResponse.getHeaders("Proxy-Authenticate");
/* 75 */     return parseChallenges(arrayOfHeader);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected List<String> getAuthPreferences(HttpResponse paramHttpResponse, HttpContext paramHttpContext) {
/* 84 */     List<String> list = (List)paramHttpResponse.getParams().getParameter("http.auth.proxy-scheme-pref");
/*    */     
/* 86 */     if (list != null) {
/* 87 */       return list;
/*    */     }
/* 89 */     return super.getAuthPreferences(paramHttpResponse, paramHttpContext);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\DefaultProxyAuthenticationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */