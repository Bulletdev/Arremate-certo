/*    */ package org.apache.http.impl.cookie;
/*    */ 
/*    */ import java.util.Date;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.client.utils.DateUtils;
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
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class BasicExpiresHandler
/*    */   extends AbstractCookieAttributeHandler
/*    */   implements CommonCookieAttributeHandler
/*    */ {
/*    */   private final String[] datePatterns;
/*    */   
/*    */   public BasicExpiresHandler(String[] paramArrayOfString) {
/* 51 */     Args.notNull(paramArrayOfString, "Array of date patterns");
/* 52 */     this.datePatterns = (String[])paramArrayOfString.clone();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void parse(SetCookie paramSetCookie, String paramString) throws MalformedCookieException {
/* 58 */     Args.notNull(paramSetCookie, "Cookie");
/* 59 */     if (paramString == null) {
/* 60 */       throw new MalformedCookieException("Missing value for 'expires' attribute");
/*    */     }
/* 62 */     Date date = DateUtils.parseDate(paramString, this.datePatterns);
/* 63 */     if (date == null) {
/* 64 */       throw new MalformedCookieException("Invalid 'expires' attribute: " + paramString);
/*    */     }
/*    */     
/* 67 */     paramSetCookie.setExpiryDate(date);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getAttributeName() {
/* 72 */     return "expires";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\BasicExpiresHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */