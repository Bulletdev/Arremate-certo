/*    */ package org.apache.http.impl.cookie;
/*    */ 
/*    */ import java.util.Date;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.cookie.CommonCookieAttributeHandler;
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
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class LaxMaxAgeHandler
/*    */   extends AbstractCookieAttributeHandler
/*    */   implements CommonCookieAttributeHandler
/*    */ {
/* 49 */   private static final Pattern MAX_AGE_PATTERN = Pattern.compile("^\\-?[0-9]+$");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void parse(SetCookie paramSetCookie, String paramString) throws MalformedCookieException {
/* 57 */     Args.notNull(paramSetCookie, "Cookie");
/* 58 */     if (TextUtils.isBlank(paramString)) {
/*    */       return;
/*    */     }
/* 61 */     Matcher matcher = MAX_AGE_PATTERN.matcher(paramString);
/* 62 */     if (matcher.matches()) {
/*    */       int i;
/*    */       try {
/* 65 */         i = Integer.parseInt(paramString);
/* 66 */       } catch (NumberFormatException numberFormatException) {
/*    */         return;
/*    */       } 
/* 69 */       Date date = (i >= 0) ? new Date(System.currentTimeMillis() + i * 1000L) : new Date(Long.MIN_VALUE);
/*    */       
/* 71 */       paramSetCookie.setExpiryDate(date);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String getAttributeName() {
/* 77 */     return "max-age";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\LaxMaxAgeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */