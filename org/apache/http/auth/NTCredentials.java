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
/*     */ public class NTCredentials
/*     */   implements Serializable, Credentials
/*     */ {
/*     */   private static final long serialVersionUID = -7385699315228907265L;
/*     */   private final NTUserPrincipal principal;
/*     */   private final String password;
/*     */   private final String workstation;
/*     */   
/*     */   @Deprecated
/*     */   public NTCredentials(String paramString) {
/*     */     String str;
/*  68 */     Args.notNull(paramString, "Username:password string");
/*     */     
/*  70 */     int i = paramString.indexOf(':');
/*  71 */     if (i >= 0) {
/*  72 */       str = paramString.substring(0, i);
/*  73 */       this.password = paramString.substring(i + 1);
/*     */     } else {
/*  75 */       str = paramString;
/*  76 */       this.password = null;
/*     */     } 
/*  78 */     int j = str.indexOf('/');
/*  79 */     if (j >= 0) {
/*  80 */       this.principal = new NTUserPrincipal(str.substring(0, j).toUpperCase(Locale.ROOT), str.substring(j + 1));
/*     */     }
/*     */     else {
/*     */       
/*  84 */       this.principal = new NTUserPrincipal(null, str.substring(j + 1));
/*     */     } 
/*     */ 
/*     */     
/*  88 */     this.workstation = null;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NTCredentials(String paramString1, String paramString2, String paramString3, String paramString4) {
/* 106 */     Args.notNull(paramString1, "User name");
/* 107 */     this.principal = new NTUserPrincipal(paramString4, paramString1);
/* 108 */     this.password = paramString2;
/* 109 */     if (paramString3 != null) {
/* 110 */       this.workstation = paramString3.toUpperCase(Locale.ROOT);
/*     */     } else {
/* 112 */       this.workstation = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Principal getUserPrincipal() {
/* 118 */     return this.principal;
/*     */   }
/*     */   
/*     */   public String getUserName() {
/* 122 */     return this.principal.getUsername();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPassword() {
/* 127 */     return this.password;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDomain() {
/* 136 */     return this.principal.getDomain();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWorkstation() {
/* 145 */     return this.workstation;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 150 */     int i = 17;
/* 151 */     i = LangUtils.hashCode(i, this.principal);
/* 152 */     i = LangUtils.hashCode(i, this.workstation);
/* 153 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 158 */     if (this == paramObject) {
/* 159 */       return true;
/*     */     }
/* 161 */     if (paramObject instanceof NTCredentials) {
/* 162 */       NTCredentials nTCredentials = (NTCredentials)paramObject;
/* 163 */       if (LangUtils.equals(this.principal, nTCredentials.principal) && LangUtils.equals(this.workstation, nTCredentials.workstation))
/*     */       {
/* 165 */         return true;
/*     */       }
/*     */     } 
/* 168 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 173 */     StringBuilder stringBuilder = new StringBuilder();
/* 174 */     stringBuilder.append("[principal: ");
/* 175 */     stringBuilder.append(this.principal);
/* 176 */     stringBuilder.append("][workstation: ");
/* 177 */     stringBuilder.append(this.workstation);
/* 178 */     stringBuilder.append("]");
/* 179 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\auth\NTCredentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */