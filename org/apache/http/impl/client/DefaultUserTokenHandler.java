/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.security.Principal;
/*     */ import javax.net.ssl.SSLSession;
/*     */ import org.apache.http.HttpConnection;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.auth.AuthScheme;
/*     */ import org.apache.http.auth.AuthState;
/*     */ import org.apache.http.auth.Credentials;
/*     */ import org.apache.http.client.UserTokenHandler;
/*     */ import org.apache.http.client.protocol.HttpClientContext;
/*     */ import org.apache.http.conn.ManagedHttpClientConnection;
/*     */ import org.apache.http.protocol.HttpContext;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class DefaultUserTokenHandler
/*     */   implements UserTokenHandler
/*     */ {
/*  61 */   public static final DefaultUserTokenHandler INSTANCE = new DefaultUserTokenHandler();
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getUserToken(HttpContext paramHttpContext) {
/*  66 */     HttpClientContext httpClientContext = HttpClientContext.adapt(paramHttpContext);
/*     */     
/*  68 */     Principal principal = null;
/*     */     
/*  70 */     AuthState authState = httpClientContext.getTargetAuthState();
/*  71 */     if (authState != null) {
/*  72 */       principal = getAuthPrincipal(authState);
/*  73 */       if (principal == null) {
/*  74 */         AuthState authState1 = httpClientContext.getProxyAuthState();
/*  75 */         principal = getAuthPrincipal(authState1);
/*     */       } 
/*     */     } 
/*     */     
/*  79 */     if (principal == null) {
/*  80 */       HttpConnection httpConnection = httpClientContext.getConnection();
/*  81 */       if (httpConnection.isOpen() && httpConnection instanceof ManagedHttpClientConnection) {
/*  82 */         SSLSession sSLSession = ((ManagedHttpClientConnection)httpConnection).getSSLSession();
/*  83 */         if (sSLSession != null) {
/*  84 */           principal = sSLSession.getLocalPrincipal();
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  89 */     return principal;
/*     */   }
/*     */   
/*     */   private static Principal getAuthPrincipal(AuthState paramAuthState) {
/*  93 */     AuthScheme authScheme = paramAuthState.getAuthScheme();
/*  94 */     if (authScheme != null && authScheme.isComplete() && authScheme.isConnectionBased()) {
/*  95 */       Credentials credentials = paramAuthState.getCredentials();
/*  96 */       if (credentials != null) {
/*  97 */         return credentials.getUserPrincipal();
/*     */       }
/*     */     } 
/* 100 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\DefaultUserTokenHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */