/*    */ package org.apache.http.impl.cookie;
/*    */ 
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.cookie.CommonCookieAttributeHandler;
/*    */ import org.apache.http.cookie.Cookie;
/*    */ import org.apache.http.cookie.CookieOrigin;
/*    */ import org.apache.http.cookie.MalformedCookieException;
/*    */ import org.apache.http.cookie.SetCookie;
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
/*    */ 
/*    */ 
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class BasicPathHandler
/*    */   implements CommonCookieAttributeHandler
/*    */ {
/*    */   public void parse(SetCookie paramSetCookie, String paramString) throws MalformedCookieException {
/* 54 */     Args.notNull(paramSetCookie, "Cookie");
/* 55 */     paramSetCookie.setPath(!TextUtils.isBlank(paramString) ? paramString : "/");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin) throws MalformedCookieException {}
/*    */ 
/*    */   
/*    */   static boolean pathMatch(String paramString1, String paramString2) {
/* 64 */     String str = paramString2;
/* 65 */     if (str == null) {
/* 66 */       str = "/";
/*    */     }
/* 68 */     if (str.length() > 1 && str.endsWith("/")) {
/* 69 */       str = str.substring(0, str.length() - 1);
/*    */     }
/* 71 */     if (paramString1.startsWith(str)) {
/* 72 */       if (str.equals("/")) {
/* 73 */         return true;
/*    */       }
/* 75 */       if (paramString1.length() == str.length()) {
/* 76 */         return true;
/*    */       }
/* 78 */       if (paramString1.charAt(str.length()) == '/') {
/* 79 */         return true;
/*    */       }
/*    */     } 
/* 82 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin) {
/* 87 */     Args.notNull(paramCookie, "Cookie");
/* 88 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/* 89 */     return pathMatch(paramCookieOrigin.getPath(), paramCookie.getPath());
/*    */   }
/*    */ 
/*    */   
/*    */   public String getAttributeName() {
/* 94 */     return "path";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\BasicPathHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */