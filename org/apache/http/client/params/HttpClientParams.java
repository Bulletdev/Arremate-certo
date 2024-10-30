/*     */ package org.apache.http.client.params;
/*     */ 
/*     */ import org.apache.http.params.HttpConnectionParams;
/*     */ import org.apache.http.params.HttpParams;
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
/*     */ @Deprecated
/*     */ public class HttpClientParams
/*     */ {
/*     */   public static boolean isRedirecting(HttpParams paramHttpParams) {
/*  48 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*  49 */     return paramHttpParams.getBooleanParameter("http.protocol.handle-redirects", true);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setRedirecting(HttpParams paramHttpParams, boolean paramBoolean) {
/*  54 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*  55 */     paramHttpParams.setBooleanParameter("http.protocol.handle-redirects", paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isAuthenticating(HttpParams paramHttpParams) {
/*  60 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*  61 */     return paramHttpParams.getBooleanParameter("http.protocol.handle-authentication", true);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setAuthenticating(HttpParams paramHttpParams, boolean paramBoolean) {
/*  66 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*  67 */     paramHttpParams.setBooleanParameter("http.protocol.handle-authentication", paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getCookiePolicy(HttpParams paramHttpParams) {
/*  72 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*  73 */     String str = (String)paramHttpParams.getParameter("http.protocol.cookie-policy");
/*     */     
/*  75 */     if (str == null) {
/*  76 */       return "best-match";
/*     */     }
/*  78 */     return str;
/*     */   }
/*     */   
/*     */   public static void setCookiePolicy(HttpParams paramHttpParams, String paramString) {
/*  82 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*  83 */     paramHttpParams.setParameter("http.protocol.cookie-policy", paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setConnectionManagerTimeout(HttpParams paramHttpParams, long paramLong) {
/*  92 */     Args.notNull(paramHttpParams, "HTTP parameters");
/*  93 */     paramHttpParams.setLongParameter("http.conn-manager.timeout", paramLong);
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
/*     */   public static long getConnectionManagerTimeout(HttpParams paramHttpParams) {
/* 106 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 107 */     Long long_ = (Long)paramHttpParams.getParameter("http.conn-manager.timeout");
/* 108 */     if (long_ != null) {
/* 109 */       return long_.longValue();
/*     */     }
/* 111 */     return HttpConnectionParams.getConnectionTimeout(paramHttpParams);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\params\HttpClientParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */