/*    */ package org.apache.http.impl.cookie;
/*    */ 
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.cookie.CommonCookieAttributeHandler;
/*    */ import org.apache.http.cookie.Cookie;
/*    */ import org.apache.http.cookie.CookieOrigin;
/*    */ import org.apache.http.cookie.MalformedCookieException;
/*    */ import org.apache.http.cookie.SetCookie;
/*    */ import org.apache.http.cookie.SetCookie2;
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
/*    */ 
/*    */ 
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class RFC2965DiscardAttributeHandler
/*    */   implements CommonCookieAttributeHandler
/*    */ {
/*    */   public void parse(SetCookie paramSetCookie, String paramString) throws MalformedCookieException {
/* 55 */     if (paramSetCookie instanceof SetCookie2) {
/* 56 */       SetCookie2 setCookie2 = (SetCookie2)paramSetCookie;
/* 57 */       setCookie2.setDiscard(true);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void validate(Cookie paramCookie, CookieOrigin paramCookieOrigin) throws MalformedCookieException {}
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin) {
/* 68 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getAttributeName() {
/* 73 */     return "discard";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\RFC2965DiscardAttributeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */