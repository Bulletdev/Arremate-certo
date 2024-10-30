/*     */ package org.apache.http.client.protocol;
/*     */ 
/*     */ import java.util.Queue;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpRequestInterceptor;
/*     */ import org.apache.http.auth.AuthOption;
/*     */ import org.apache.http.auth.AuthProtocolState;
/*     */ import org.apache.http.auth.AuthScheme;
/*     */ import org.apache.http.auth.AuthState;
/*     */ import org.apache.http.auth.AuthenticationException;
/*     */ import org.apache.http.auth.ContextAwareAuthScheme;
/*     */ import org.apache.http.auth.Credentials;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.util.Asserts;
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
/*     */ @Deprecated
/*     */ abstract class RequestAuthenticationBase
/*     */   implements HttpRequestInterceptor
/*     */ {
/*  52 */   final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void process(AuthState paramAuthState, HttpRequest paramHttpRequest, HttpContext paramHttpContext) {
/*     */     Queue<AuthOption> queue;
/*  62 */     AuthScheme authScheme = paramAuthState.getAuthScheme();
/*  63 */     Credentials credentials = paramAuthState.getCredentials();
/*  64 */     switch (paramAuthState.getState()) {
/*     */       case FAILURE:
/*     */         return;
/*     */       case SUCCESS:
/*  68 */         ensureAuthScheme(authScheme);
/*  69 */         if (authScheme.isConnectionBased()) {
/*     */           return;
/*     */         }
/*     */         break;
/*     */       case CHALLENGED:
/*  74 */         queue = paramAuthState.getAuthOptions();
/*  75 */         if (queue != null) {
/*  76 */           while (!queue.isEmpty()) {
/*  77 */             AuthOption authOption = queue.remove();
/*  78 */             authScheme = authOption.getAuthScheme();
/*  79 */             credentials = authOption.getCredentials();
/*  80 */             paramAuthState.update(authScheme, credentials);
/*  81 */             if (this.log.isDebugEnabled()) {
/*  82 */               this.log.debug("Generating response to an authentication challenge using " + authScheme.getSchemeName() + " scheme");
/*     */             }
/*     */             
/*     */             try {
/*  86 */               Header header = authenticate(authScheme, credentials, paramHttpRequest, paramHttpContext);
/*  87 */               paramHttpRequest.addHeader(header);
/*     */               break;
/*  89 */             } catch (AuthenticationException authenticationException) {
/*  90 */               if (this.log.isWarnEnabled()) {
/*  91 */                 this.log.warn(authScheme + " authentication error: " + authenticationException.getMessage());
/*     */               }
/*     */             } 
/*     */           } 
/*     */           return;
/*     */         } 
/*  97 */         ensureAuthScheme(authScheme);
/*     */         break;
/*     */     } 
/* 100 */     if (authScheme != null) {
/*     */       try {
/* 102 */         Header header = authenticate(authScheme, credentials, paramHttpRequest, paramHttpContext);
/* 103 */         paramHttpRequest.addHeader(header);
/* 104 */       } catch (AuthenticationException authenticationException) {
/* 105 */         if (this.log.isErrorEnabled()) {
/* 106 */           this.log.error(authScheme + " authentication error: " + authenticationException.getMessage());
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void ensureAuthScheme(AuthScheme paramAuthScheme) {
/* 113 */     Asserts.notNull(paramAuthScheme, "Auth scheme");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Header authenticate(AuthScheme paramAuthScheme, Credentials paramCredentials, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws AuthenticationException {
/* 121 */     Asserts.notNull(paramAuthScheme, "Auth scheme");
/* 122 */     if (paramAuthScheme instanceof ContextAwareAuthScheme) {
/* 123 */       return ((ContextAwareAuthScheme)paramAuthScheme).authenticate(paramCredentials, paramHttpRequest, paramHttpContext);
/*     */     }
/* 125 */     return paramAuthScheme.authenticate(paramCredentials, paramHttpRequest);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\protocol\RequestAuthenticationBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */