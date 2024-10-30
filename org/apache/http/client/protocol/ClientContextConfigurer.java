/*    */ package org.apache.http.client.protocol;
/*    */ 
/*    */ import org.apache.http.auth.AuthSchemeRegistry;
/*    */ import org.apache.http.client.CookieStore;
/*    */ import org.apache.http.client.CredentialsProvider;
/*    */ import org.apache.http.cookie.CookieSpecRegistry;
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
/*    */ @Deprecated
/*    */ public class ClientContextConfigurer
/*    */   implements ClientContext
/*    */ {
/*    */   private final HttpContext context;
/*    */   
/*    */   public ClientContextConfigurer(HttpContext paramHttpContext) {
/* 50 */     Args.notNull(paramHttpContext, "HTTP context");
/* 51 */     this.context = paramHttpContext;
/*    */   }
/*    */   
/*    */   public void setCookieSpecRegistry(CookieSpecRegistry paramCookieSpecRegistry) {
/* 55 */     this.context.setAttribute("http.cookiespec-registry", paramCookieSpecRegistry);
/*    */   }
/*    */   
/*    */   public void setAuthSchemeRegistry(AuthSchemeRegistry paramAuthSchemeRegistry) {
/* 59 */     this.context.setAttribute("http.authscheme-registry", paramAuthSchemeRegistry);
/*    */   }
/*    */   
/*    */   public void setCookieStore(CookieStore paramCookieStore) {
/* 63 */     this.context.setAttribute("http.cookie-store", paramCookieStore);
/*    */   }
/*    */   
/*    */   public void setCredentialsProvider(CredentialsProvider paramCredentialsProvider) {
/* 67 */     this.context.setAttribute("http.auth.credentials-provider", paramCredentialsProvider);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\protocol\ClientContextConfigurer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */