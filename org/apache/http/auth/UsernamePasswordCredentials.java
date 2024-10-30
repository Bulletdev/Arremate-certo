/*     */ package org.apache.http.auth;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.security.Principal;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.LangUtils;
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
/*     */ public class UsernamePasswordCredentials
/*     */   implements Serializable, Credentials
/*     */ {
/*     */   private static final long serialVersionUID = 243343858802739403L;
/*     */   private final BasicUserPrincipal principal;
/*     */   private final String password;
/*     */   
/*     */   @Deprecated
/*     */   public UsernamePasswordCredentials(String paramString) {
/*  61 */     Args.notNull(paramString, "Username:password string");
/*  62 */     int i = paramString.indexOf(':');
/*  63 */     if (i >= 0) {
/*  64 */       this.principal = new BasicUserPrincipal(paramString.substring(0, i));
/*  65 */       this.password = paramString.substring(i + 1);
/*     */     } else {
/*  67 */       this.principal = new BasicUserPrincipal(paramString);
/*  68 */       this.password = null;
/*     */     } 
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
/*     */   public UsernamePasswordCredentials(String paramString1, String paramString2) {
/*  81 */     Args.notNull(paramString1, "Username");
/*  82 */     this.principal = new BasicUserPrincipal(paramString1);
/*  83 */     this.password = paramString2;
/*     */   }
/*     */ 
/*     */   
/*     */   public Principal getUserPrincipal() {
/*  88 */     return this.principal;
/*     */   }
/*     */   
/*     */   public String getUserName() {
/*  92 */     return this.principal.getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPassword() {
/*  97 */     return this.password;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 102 */     return this.principal.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 107 */     if (this == paramObject) {
/* 108 */       return true;
/*     */     }
/* 110 */     if (paramObject instanceof UsernamePasswordCredentials) {
/* 111 */       UsernamePasswordCredentials usernamePasswordCredentials = (UsernamePasswordCredentials)paramObject;
/* 112 */       if (LangUtils.equals(this.principal, usernamePasswordCredentials.principal)) {
/* 113 */         return true;
/*     */       }
/*     */     } 
/* 116 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 121 */     return this.principal.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\auth\UsernamePasswordCredentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */