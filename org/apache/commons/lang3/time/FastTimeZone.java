/*    */ package org.apache.commons.lang3.time;
/*    */ 
/*    */ import java.util.TimeZone;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
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
/*    */ public class FastTimeZone
/*    */ {
/* 30 */   private static final Pattern GMT_PATTERN = Pattern.compile("^(?:(?i)GMT)?([+-])?(\\d\\d?)?(:?(\\d\\d?))?$");
/*    */   
/* 32 */   private static final TimeZone GREENWICH = new GmtTimeZone(false, 0, 0);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static TimeZone getGmtTimeZone() {
/* 39 */     return GREENWICH;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static TimeZone getGmtTimeZone(String paramString) {
/* 50 */     if ("Z".equals(paramString) || "UTC".equals(paramString)) {
/* 51 */       return GREENWICH;
/*    */     }
/*    */     
/* 54 */     Matcher matcher = GMT_PATTERN.matcher(paramString);
/* 55 */     if (matcher.matches()) {
/* 56 */       int i = parseInt(matcher.group(2));
/* 57 */       int j = parseInt(matcher.group(4));
/* 58 */       if (i == 0 && j == 0) {
/* 59 */         return GREENWICH;
/*    */       }
/* 61 */       return new GmtTimeZone(parseSign(matcher.group(1)), i, j);
/*    */     } 
/* 63 */     return null;
/*    */   }
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
/*    */   public static TimeZone getTimeZone(String paramString) {
/* 76 */     TimeZone timeZone = getGmtTimeZone(paramString);
/* 77 */     if (timeZone != null) {
/* 78 */       return timeZone;
/*    */     }
/* 80 */     return TimeZone.getTimeZone(paramString);
/*    */   }
/*    */   
/*    */   private static int parseInt(String paramString) {
/* 84 */     return (paramString != null) ? Integer.parseInt(paramString) : 0;
/*    */   }
/*    */   
/*    */   private static boolean parseSign(String paramString) {
/* 88 */     return (paramString != null && paramString.charAt(0) == '-');
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\time\FastTimeZone.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */