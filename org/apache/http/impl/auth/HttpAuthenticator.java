/*     */ package org.apache.http.impl.auth;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Queue;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpException;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.HttpResponse;
/*     */ import org.apache.http.auth.AuthOption;
/*     */ import org.apache.http.auth.AuthProtocolState;
/*     */ import org.apache.http.auth.AuthScheme;
/*     */ import org.apache.http.auth.AuthState;
/*     */ import org.apache.http.auth.AuthenticationException;
/*     */ import org.apache.http.auth.ContextAwareAuthScheme;
/*     */ import org.apache.http.auth.Credentials;
/*     */ import org.apache.http.auth.MalformedChallengeException;
/*     */ import org.apache.http.client.AuthenticationStrategy;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HttpAuthenticator
/*     */ {
/*     */   private final Log log;
/*     */   
/*     */   public HttpAuthenticator(Log paramLog) {
/*  63 */     this.log = (paramLog != null) ? paramLog : LogFactory.getLog(getClass());
/*     */   }
/*     */   
/*     */   public HttpAuthenticator() {
/*  67 */     this(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAuthenticationRequested(HttpHost paramHttpHost, HttpResponse paramHttpResponse, AuthenticationStrategy paramAuthenticationStrategy, AuthState paramAuthState, HttpContext paramHttpContext) {
/*  76 */     if (paramAuthenticationStrategy.isAuthenticationRequested(paramHttpHost, paramHttpResponse, paramHttpContext)) {
/*  77 */       this.log.debug("Authentication required");
/*  78 */       if (paramAuthState.getState() == AuthProtocolState.SUCCESS) {
/*  79 */         paramAuthenticationStrategy.authFailed(paramHttpHost, paramAuthState.getAuthScheme(), paramHttpContext);
/*     */       }
/*  81 */       return true;
/*     */     } 
/*  83 */     switch (paramAuthState.getState()) {
/*     */       case CHALLENGED:
/*     */       case HANDSHAKE:
/*  86 */         this.log.debug("Authentication succeeded");
/*  87 */         paramAuthState.setState(AuthProtocolState.SUCCESS);
/*  88 */         paramAuthenticationStrategy.authSucceeded(paramHttpHost, paramAuthState.getAuthScheme(), paramHttpContext);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case SUCCESS:
/*  95 */         return false;
/*     */     } 
/*     */     paramAuthState.setState(AuthProtocolState.UNCHALLENGED);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean handleAuthChallenge(HttpHost paramHttpHost, HttpResponse paramHttpResponse, AuthenticationStrategy paramAuthenticationStrategy, AuthState paramAuthState, HttpContext paramHttpContext) {
/*     */     try {
/* 105 */       if (this.log.isDebugEnabled()) {
/* 106 */         this.log.debug(paramHttpHost.toHostString() + " requested authentication");
/*     */       }
/* 108 */       Map map = paramAuthenticationStrategy.getChallenges(paramHttpHost, paramHttpResponse, paramHttpContext);
/* 109 */       if (map.isEmpty()) {
/* 110 */         this.log.debug("Response contains no authentication challenges");
/* 111 */         return false;
/*     */       } 
/*     */       
/* 114 */       AuthScheme authScheme = paramAuthState.getAuthScheme();
/* 115 */       switch (paramAuthState.getState()) {
/*     */         case FAILURE:
/* 117 */           return false;
/*     */         case SUCCESS:
/* 119 */           paramAuthState.reset();
/*     */           break;
/*     */         case CHALLENGED:
/*     */         case HANDSHAKE:
/* 123 */           if (authScheme == null) {
/* 124 */             this.log.debug("Auth scheme is null");
/* 125 */             paramAuthenticationStrategy.authFailed(paramHttpHost, null, paramHttpContext);
/* 126 */             paramAuthState.reset();
/* 127 */             paramAuthState.setState(AuthProtocolState.FAILURE);
/* 128 */             return false;
/*     */           } 
/*     */         case UNCHALLENGED:
/* 131 */           if (authScheme != null) {
/* 132 */             String str = authScheme.getSchemeName();
/* 133 */             Header header = (Header)map.get(str.toLowerCase(Locale.ROOT));
/* 134 */             if (header != null) {
/* 135 */               this.log.debug("Authorization challenge processed");
/* 136 */               authScheme.processChallenge(header);
/* 137 */               if (authScheme.isComplete()) {
/* 138 */                 this.log.debug("Authentication failed");
/* 139 */                 paramAuthenticationStrategy.authFailed(paramHttpHost, paramAuthState.getAuthScheme(), paramHttpContext);
/* 140 */                 paramAuthState.reset();
/* 141 */                 paramAuthState.setState(AuthProtocolState.FAILURE);
/* 142 */                 return false;
/*     */               } 
/* 144 */               paramAuthState.setState(AuthProtocolState.HANDSHAKE);
/* 145 */               return true;
/*     */             } 
/* 147 */             paramAuthState.reset();
/*     */           } 
/*     */           break;
/*     */       } 
/* 151 */       Queue queue = paramAuthenticationStrategy.select(map, paramHttpHost, paramHttpResponse, paramHttpContext);
/* 152 */       if (queue != null && !queue.isEmpty()) {
/* 153 */         if (this.log.isDebugEnabled()) {
/* 154 */           this.log.debug("Selected authentication options: " + queue);
/*     */         }
/* 156 */         paramAuthState.setState(AuthProtocolState.CHALLENGED);
/* 157 */         paramAuthState.update(queue);
/* 158 */         return true;
/*     */       } 
/* 160 */       return false;
/* 161 */     } catch (MalformedChallengeException malformedChallengeException) {
/* 162 */       if (this.log.isWarnEnabled()) {
/* 163 */         this.log.warn("Malformed challenge: " + malformedChallengeException.getMessage());
/*     */       }
/* 165 */       paramAuthState.reset();
/* 166 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void generateAuthResponse(HttpRequest paramHttpRequest, AuthState paramAuthState, HttpContext paramHttpContext) throws HttpException, IOException {
/*     */     Queue<AuthOption> queue;
/* 174 */     AuthScheme authScheme = paramAuthState.getAuthScheme();
/* 175 */     Credentials credentials = paramAuthState.getCredentials();
/* 176 */     switch (paramAuthState.getState()) {
/*     */       case FAILURE:
/*     */         return;
/*     */       case SUCCESS:
/* 180 */         ensureAuthScheme(authScheme);
/* 181 */         if (authScheme.isConnectionBased()) {
/*     */           return;
/*     */         }
/*     */         break;
/*     */       case CHALLENGED:
/* 186 */         queue = paramAuthState.getAuthOptions();
/* 187 */         if (queue != null) {
/* 188 */           while (!queue.isEmpty()) {
/* 189 */             AuthOption authOption = queue.remove();
/* 190 */             authScheme = authOption.getAuthScheme();
/* 191 */             credentials = authOption.getCredentials();
/* 192 */             paramAuthState.update(authScheme, credentials);
/* 193 */             if (this.log.isDebugEnabled()) {
/* 194 */               this.log.debug("Generating response to an authentication challenge using " + authScheme.getSchemeName() + " scheme");
/*     */             }
/*     */             
/*     */             try {
/* 198 */               Header header = doAuth(authScheme, credentials, paramHttpRequest, paramHttpContext);
/* 199 */               paramHttpRequest.addHeader(header);
/*     */               break;
/* 201 */             } catch (AuthenticationException authenticationException) {
/* 202 */               if (this.log.isWarnEnabled()) {
/* 203 */                 this.log.warn(authScheme + " authentication error: " + authenticationException.getMessage());
/*     */               }
/*     */             } 
/*     */           } 
/*     */           return;
/*     */         } 
/* 209 */         ensureAuthScheme(authScheme); break;
/*     */     } 
/* 211 */     if (authScheme != null) {
/*     */       try {
/* 213 */         Header header = doAuth(authScheme, credentials, paramHttpRequest, paramHttpContext);
/* 214 */         paramHttpRequest.addHeader(header);
/* 215 */       } catch (AuthenticationException authenticationException) {
/* 216 */         if (this.log.isErrorEnabled()) {
/* 217 */           this.log.error(authScheme + " authentication error: " + authenticationException.getMessage());
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void ensureAuthScheme(AuthScheme paramAuthScheme) {
/* 224 */     Asserts.notNull(paramAuthScheme, "Auth scheme");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Header doAuth(AuthScheme paramAuthScheme, Credentials paramCredentials, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws AuthenticationException {
/* 233 */     return (paramAuthScheme instanceof ContextAwareAuthScheme) ? ((ContextAwareAuthScheme)paramAuthScheme).authenticate(paramCredentials, paramHttpRequest, paramHttpContext) : paramAuthScheme.authenticate(paramCredentials, paramHttpRequest);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\auth\HttpAuthenticator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */