/*     */ package org.apache.http.auth;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import org.apache.http.HttpHost;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class AuthScope
/*     */ {
/*  53 */   public static final String ANY_HOST = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int ANY_PORT = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   public static final String ANY_REALM = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  68 */   public static final String ANY_SCHEME = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  75 */   public static final AuthScope ANY = new AuthScope(ANY_HOST, -1, ANY_REALM, ANY_SCHEME);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String scheme;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String realm;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String host;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int port;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final HttpHost origin;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AuthScope(String paramString1, int paramInt, String paramString2, String paramString3) {
/* 110 */     this.host = (paramString1 == null) ? ANY_HOST : paramString1.toLowerCase(Locale.ROOT);
/* 111 */     this.port = (paramInt < 0) ? -1 : paramInt;
/* 112 */     this.realm = (paramString2 == null) ? ANY_REALM : paramString2;
/* 113 */     this.scheme = (paramString3 == null) ? ANY_SCHEME : paramString3.toUpperCase(Locale.ROOT);
/* 114 */     this.origin = null;
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
/*     */   public AuthScope(HttpHost paramHttpHost, String paramString1, String paramString2) {
/* 132 */     Args.notNull(paramHttpHost, "Host");
/* 133 */     this.host = paramHttpHost.getHostName().toLowerCase(Locale.ROOT);
/* 134 */     this.port = (paramHttpHost.getPort() < 0) ? -1 : paramHttpHost.getPort();
/* 135 */     this.realm = (paramString1 == null) ? ANY_REALM : paramString1;
/* 136 */     this.scheme = (paramString2 == null) ? ANY_SCHEME : paramString2.toUpperCase(Locale.ROOT);
/* 137 */     this.origin = paramHttpHost;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AuthScope(HttpHost paramHttpHost) {
/* 148 */     this(paramHttpHost, ANY_REALM, ANY_SCHEME);
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
/*     */   public AuthScope(String paramString1, int paramInt, String paramString2) {
/* 162 */     this(paramString1, paramInt, paramString2, ANY_SCHEME);
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
/*     */   public AuthScope(String paramString, int paramInt) {
/* 174 */     this(paramString, paramInt, ANY_REALM, ANY_SCHEME);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AuthScope(AuthScope paramAuthScope) {
/* 182 */     Args.notNull(paramAuthScope, "Scope");
/* 183 */     this.host = paramAuthScope.getHost();
/* 184 */     this.port = paramAuthScope.getPort();
/* 185 */     this.realm = paramAuthScope.getRealm();
/* 186 */     this.scheme = paramAuthScope.getScheme();
/* 187 */     this.origin = paramAuthScope.getOrigin();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpHost getOrigin() {
/* 196 */     return this.origin;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHost() {
/* 203 */     return this.host;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPort() {
/* 210 */     return this.port;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRealm() {
/* 217 */     return this.realm;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getScheme() {
/* 224 */     return this.scheme;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int match(AuthScope paramAuthScope) {
/* 235 */     byte b = 0;
/* 236 */     if (LangUtils.equals(this.scheme, paramAuthScope.scheme)) {
/* 237 */       b++;
/*     */     }
/* 239 */     else if (this.scheme != ANY_SCHEME && paramAuthScope.scheme != ANY_SCHEME) {
/* 240 */       return -1;
/*     */     } 
/*     */     
/* 243 */     if (LangUtils.equals(this.realm, paramAuthScope.realm)) {
/* 244 */       b += 2;
/*     */     }
/* 246 */     else if (this.realm != ANY_REALM && paramAuthScope.realm != ANY_REALM) {
/* 247 */       return -1;
/*     */     } 
/*     */     
/* 250 */     if (this.port == paramAuthScope.port) {
/* 251 */       b += 4;
/*     */     }
/* 253 */     else if (this.port != -1 && paramAuthScope.port != -1) {
/* 254 */       return -1;
/*     */     } 
/*     */     
/* 257 */     if (LangUtils.equals(this.host, paramAuthScope.host)) {
/* 258 */       b += 8;
/*     */     }
/* 260 */     else if (this.host != ANY_HOST && paramAuthScope.host != ANY_HOST) {
/* 261 */       return -1;
/*     */     } 
/*     */     
/* 264 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 272 */     if (paramObject == null) {
/* 273 */       return false;
/*     */     }
/* 275 */     if (paramObject == this) {
/* 276 */       return true;
/*     */     }
/* 278 */     if (!(paramObject instanceof AuthScope)) {
/* 279 */       return super.equals(paramObject);
/*     */     }
/* 281 */     AuthScope authScope = (AuthScope)paramObject;
/* 282 */     return (LangUtils.equals(this.host, authScope.host) && this.port == authScope.port && LangUtils.equals(this.realm, authScope.realm) && LangUtils.equals(this.scheme, authScope.scheme));
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
/*     */   public String toString() {
/* 294 */     StringBuilder stringBuilder = new StringBuilder();
/* 295 */     if (this.scheme != null) {
/* 296 */       stringBuilder.append(this.scheme.toUpperCase(Locale.ROOT));
/* 297 */       stringBuilder.append(' ');
/*     */     } 
/* 299 */     if (this.realm != null) {
/* 300 */       stringBuilder.append('\'');
/* 301 */       stringBuilder.append(this.realm);
/* 302 */       stringBuilder.append('\'');
/*     */     } else {
/* 304 */       stringBuilder.append("<any realm>");
/*     */     } 
/* 306 */     if (this.host != null) {
/* 307 */       stringBuilder.append('@');
/* 308 */       stringBuilder.append(this.host);
/* 309 */       if (this.port >= 0) {
/* 310 */         stringBuilder.append(':');
/* 311 */         stringBuilder.append(this.port);
/*     */       } 
/*     */     } 
/* 314 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 322 */     int i = 17;
/* 323 */     i = LangUtils.hashCode(i, this.host);
/* 324 */     i = LangUtils.hashCode(i, this.port);
/* 325 */     i = LangUtils.hashCode(i, this.realm);
/* 326 */     i = LangUtils.hashCode(i, this.scheme);
/* 327 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\auth\AuthScope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */