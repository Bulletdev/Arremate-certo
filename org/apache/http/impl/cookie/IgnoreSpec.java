/*    */ package org.apache.http.impl.cookie;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import org.apache.http.Header;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.cookie.Cookie;
/*    */ import org.apache.http.cookie.CookieOrigin;
/*    */ import org.apache.http.cookie.MalformedCookieException;
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
/*    */ public class IgnoreSpec
/*    */   extends CookieSpecBase
/*    */ {
/*    */   public int getVersion() {
/* 50 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public List<Cookie> parse(Header paramHeader, CookieOrigin paramCookieOrigin) throws MalformedCookieException {
/* 56 */     return Collections.emptyList();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean match(Cookie paramCookie, CookieOrigin paramCookieOrigin) {
/* 61 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Header> formatCookies(List<Cookie> paramList) {
/* 66 */     return Collections.emptyList();
/*    */   }
/*    */ 
/*    */   
/*    */   public Header getVersionHeader() {
/* 71 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\IgnoreSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */