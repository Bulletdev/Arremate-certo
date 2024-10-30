/*    */ package org.apache.http.auth;
/*    */ 
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
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
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public final class AuthOption
/*    */ {
/*    */   private final AuthScheme authScheme;
/*    */   private final Credentials creds;
/*    */   
/*    */   public AuthOption(AuthScheme paramAuthScheme, Credentials paramCredentials) {
/* 44 */     Args.notNull(paramAuthScheme, "Auth scheme");
/* 45 */     Args.notNull(paramCredentials, "User credentials");
/* 46 */     this.authScheme = paramAuthScheme;
/* 47 */     this.creds = paramCredentials;
/*    */   }
/*    */   
/*    */   public AuthScheme getAuthScheme() {
/* 51 */     return this.authScheme;
/*    */   }
/*    */   
/*    */   public Credentials getCredentials() {
/* 55 */     return this.creds;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 60 */     return this.authScheme.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\auth\AuthOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */