/*    */ package org.apache.http.impl.cookie;
/*    */ 
/*    */ import java.util.Date;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.cookie.CommonCookieAttributeHandler;
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
/*    */ public class BasicMaxAgeHandler
/*    */   extends AbstractCookieAttributeHandler
/*    */   implements CommonCookieAttributeHandler
/*    */ {
/*    */   public void parse(SetCookie paramSetCookie, String paramString) throws MalformedCookieException {
/*    */     int i;
/* 53 */     Args.notNull(paramSetCookie, "Cookie");
/* 54 */     if (paramString == null) {
/* 55 */       throw new MalformedCookieException("Missing value for 'max-age' attribute");
/*    */     }
/*    */     
/*    */     try {
/* 59 */       i = Integer.parseInt(paramString);
/* 60 */     } catch (NumberFormatException numberFormatException) {
/* 61 */       throw new MalformedCookieException("Invalid 'max-age' attribute: " + paramString);
/*    */     } 
/*    */     
/* 64 */     if (i < 0) {
/* 65 */       throw new MalformedCookieException("Negative 'max-age' attribute: " + paramString);
/*    */     }
/*    */     
/* 68 */     paramSetCookie.setExpiryDate(new Date(System.currentTimeMillis() + i * 1000L));
/*    */   }
/*    */ 
/*    */   
/*    */   public String getAttributeName() {
/* 73 */     return "max-age";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\BasicMaxAgeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */