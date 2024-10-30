/*     */ package org.apache.http.auth;
/*     */ 
/*     */ import java.util.Queue;
/*     */ import org.apache.http.util.Args;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AuthState
/*     */ {
/*  57 */   private AuthProtocolState state = AuthProtocolState.UNCHALLENGED;
/*     */   
/*     */   private AuthScheme authScheme;
/*     */   
/*     */   private AuthScope authScope;
/*     */   private Credentials credentials;
/*     */   private Queue<AuthOption> authOptions;
/*     */   
/*     */   public void reset() {
/*  66 */     this.state = AuthProtocolState.UNCHALLENGED;
/*  67 */     this.authOptions = null;
/*  68 */     this.authScheme = null;
/*  69 */     this.authScope = null;
/*  70 */     this.credentials = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AuthProtocolState getState() {
/*  77 */     return this.state;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setState(AuthProtocolState paramAuthProtocolState) {
/*  84 */     this.state = (paramAuthProtocolState != null) ? paramAuthProtocolState : AuthProtocolState.UNCHALLENGED;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AuthScheme getAuthScheme() {
/*  91 */     return this.authScheme;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Credentials getCredentials() {
/*  98 */     return this.credentials;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(AuthScheme paramAuthScheme, Credentials paramCredentials) {
/* 110 */     Args.notNull(paramAuthScheme, "Auth scheme");
/* 111 */     Args.notNull(paramCredentials, "Credentials");
/* 112 */     this.authScheme = paramAuthScheme;
/* 113 */     this.credentials = paramCredentials;
/* 114 */     this.authOptions = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Queue<AuthOption> getAuthOptions() {
/* 123 */     return this.authOptions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasAuthOptions() {
/* 133 */     return (this.authOptions != null && !this.authOptions.isEmpty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isConnectionBased() {
/* 142 */     return (this.authScheme != null && this.authScheme.isConnectionBased());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(Queue<AuthOption> paramQueue) {
/* 153 */     Args.notEmpty(paramQueue, "Queue of auth options");
/* 154 */     this.authOptions = paramQueue;
/* 155 */     this.authScheme = null;
/* 156 */     this.credentials = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void invalidate() {
/* 166 */     reset();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public boolean isValid() {
/* 174 */     return (this.authScheme != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setAuthScheme(AuthScheme paramAuthScheme) {
/* 186 */     if (paramAuthScheme == null) {
/* 187 */       reset();
/*     */       return;
/*     */     } 
/* 190 */     this.authScheme = paramAuthScheme;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setCredentials(Credentials paramCredentials) {
/* 202 */     this.credentials = paramCredentials;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public AuthScope getAuthScope() {
/* 214 */     return this.authScope;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setAuthScope(AuthScope paramAuthScope) {
/* 226 */     this.authScope = paramAuthScope;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 231 */     StringBuilder stringBuilder = new StringBuilder();
/* 232 */     stringBuilder.append("state:").append(this.state).append(";");
/* 233 */     if (this.authScheme != null) {
/* 234 */       stringBuilder.append("auth scheme:").append(this.authScheme.getSchemeName()).append(";");
/*     */     }
/* 236 */     if (this.credentials != null) {
/* 237 */       stringBuilder.append("credentials present");
/*     */     }
/* 239 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\auth\AuthState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */