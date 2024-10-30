/*    */ package org.apache.http.impl.client;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Map;
/*    */ import java.util.Queue;
/*    */ import org.apache.http.Header;
/*    */ import org.apache.http.HttpHost;
/*    */ import org.apache.http.HttpResponse;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.auth.AuthScheme;
/*    */ import org.apache.http.auth.MalformedChallengeException;
/*    */ import org.apache.http.client.config.RequestConfig;
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
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class TargetAuthenticationStrategy
/*    */   extends AuthenticationStrategyImpl
/*    */ {
/* 47 */   public static final TargetAuthenticationStrategy INSTANCE = new TargetAuthenticationStrategy();
/*    */   
/*    */   public TargetAuthenticationStrategy() {
/* 50 */     super(401, "WWW-Authenticate");
/*    */   }
/*    */ 
/*    */   
/*    */   Collection<String> getPreferredAuthSchemes(RequestConfig paramRequestConfig) {
/* 55 */     return paramRequestConfig.getTargetPreferredAuthSchemes();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\TargetAuthenticationStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */