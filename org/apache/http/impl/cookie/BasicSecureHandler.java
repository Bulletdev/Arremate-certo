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
/*    */ public class BasicSecureHandler
/*    */   extends AbstractCookieAttributeHandler
/*    */   implements CommonCookieAttributeHandler
/*    */ {
/*    */   public void parse(SetCookie paramSetCookie, String paramString) throws MalformedCookieException {
/* 53 */     Args.notNull(paramSetCookie, "Cookie");
/* 54 */     paramSetCookie.setSecure(true);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin) {
/* 59 */     Args.notNull(paramCookie, "Cookie");
/* 60 */     Args.notNull(paramCookieOrigin, "Cookie origin");
/* 61 */     return (!paramCookie.isSecure() || paramCookieOrigin.isSecure());
/*    */   }
/*    */ 
/*    */   
/*    */   public String getAttributeName() {
/* 66 */     return "secure";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\BasicSecureHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */