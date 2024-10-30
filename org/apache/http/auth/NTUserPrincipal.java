/*     */ package org.apache.http.auth;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.security.Principal;
/*     */ import java.util.Locale;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class NTUserPrincipal
/*     */   implements Serializable, Principal
/*     */ {
/*     */   private static final long serialVersionUID = -6870169797924406894L;
/*     */   private final String username;
/*     */   private final String domain;
/*     */   private final String ntname;
/*     */   
/*     */   public NTUserPrincipal(String paramString1, String paramString2) {
/*  56 */     Args.notNull(paramString2, "User name");
/*  57 */     this.username = paramString2;
/*  58 */     if (paramString1 != null) {
/*  59 */       this.domain = paramString1.toUpperCase(Locale.ROOT);
/*     */     } else {
/*  61 */       this.domain = null;
/*     */     } 
/*  63 */     if (this.domain != null && !this.domain.isEmpty()) {
/*  64 */       StringBuilder stringBuilder = new StringBuilder();
/*  65 */       stringBuilder.append(this.domain);
/*  66 */       stringBuilder.append('\\');
/*  67 */       stringBuilder.append(this.username);
/*  68 */       this.ntname = stringBuilder.toString();
/*     */     } else {
/*  70 */       this.ntname = this.username;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/*  76 */     return this.ntname;
/*     */   }
/*     */   
/*     */   public String getDomain() {
/*  80 */     return this.domain;
/*     */   }
/*     */   
/*     */   public String getUsername() {
/*  84 */     return this.username;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  89 */     int i = 17;
/*  90 */     i = LangUtils.hashCode(i, this.username);
/*  91 */     i = LangUtils.hashCode(i, this.domain);
/*  92 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  97 */     if (this == paramObject) {
/*  98 */       return true;
/*     */     }
/* 100 */     if (paramObject instanceof NTUserPrincipal) {
/* 101 */       NTUserPrincipal nTUserPrincipal = (NTUserPrincipal)paramObject;
/* 102 */       if (LangUtils.equals(this.username, nTUserPrincipal.username) && LangUtils.equals(this.domain, nTUserPrincipal.domain))
/*     */       {
/* 104 */         return true;
/*     */       }
/*     */     } 
/* 107 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 112 */     return this.ntname;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\auth\NTUserPrincipal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */