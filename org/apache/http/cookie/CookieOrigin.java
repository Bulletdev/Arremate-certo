/*    */ package org.apache.http.cookie;
/*    */ 
/*    */ import java.util.Locale;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.util.Args;
/*    */ import org.apache.http.util.TextUtils;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public final class CookieOrigin
/*    */ {
/*    */   private final String host;
/*    */   private final int port;
/*    */   private final String path;
/*    */   private final boolean secure;
/*    */   
/*    */   public CookieOrigin(String paramString1, int paramInt, String paramString2, boolean paramBoolean) {
/* 52 */     Args.notBlank(paramString1, "Host");
/* 53 */     Args.notNegative(paramInt, "Port");
/* 54 */     Args.notNull(paramString2, "Path");
/* 55 */     this.host = paramString1.toLowerCase(Locale.ROOT);
/* 56 */     this.port = paramInt;
/* 57 */     if (!TextUtils.isBlank(paramString2)) {
/* 58 */       this.path = paramString2;
/*    */     } else {
/* 60 */       this.path = "/";
/*    */     } 
/* 62 */     this.secure = paramBoolean;
/*    */   }
/*    */   
/*    */   public String getHost() {
/* 66 */     return this.host;
/*    */   }
/*    */   
/*    */   public String getPath() {
/* 70 */     return this.path;
/*    */   }
/*    */   
/*    */   public int getPort() {
/* 74 */     return this.port;
/*    */   }
/*    */   
/*    */   public boolean isSecure() {
/* 78 */     return this.secure;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder stringBuilder = new StringBuilder();
/* 84 */     stringBuilder.append('[');
/* 85 */     if (this.secure) {
/* 86 */       stringBuilder.append("(secure)");
/*    */     }
/* 88 */     stringBuilder.append(this.host);
/* 89 */     stringBuilder.append(':');
/* 90 */     stringBuilder.append(Integer.toString(this.port));
/* 91 */     stringBuilder.append(this.path);
/* 92 */     stringBuilder.append(']');
/* 93 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\cookie\CookieOrigin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */