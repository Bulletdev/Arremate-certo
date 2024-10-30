/*    */ package oshi.driver.unix.aix;
/*    */ 
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.util.ExecutingCommand;
/*    */ import oshi.util.ParseUtil;
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
/*    */ @ThreadSafe
/*    */ public final class Uptime
/*    */ {
/*    */   private static final long MINUTE_MS = 60000L;
/*    */   private static final long HOUR_MS = 3600000L;
/*    */   private static final long DAY_MS = 86400000L;
/* 46 */   private static final Pattern UPTIME_FORMAT_AIX = Pattern.compile(".*\\sup\\s+((\\d+)\\s+days?,?\\s+)?\\b((\\d+):)?(\\d+)(\\s+min(utes?)?)?,\\s+\\d+\\s+user.+");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long queryUpTime() {
/* 57 */     long l = 0L;
/* 58 */     String str = ExecutingCommand.getFirstAnswer("/usr/bin/uptime");
/* 59 */     Matcher matcher = UPTIME_FORMAT_AIX.matcher(str);
/* 60 */     if (matcher.matches()) {
/* 61 */       if (matcher.group(2) != null) {
/* 62 */         l += ParseUtil.parseLongOrDefault(matcher.group(2), 0L) * 86400000L;
/*    */       }
/* 64 */       if (matcher.group(4) != null) {
/* 65 */         l += ParseUtil.parseLongOrDefault(matcher.group(4), 0L) * 3600000L;
/*    */       }
/* 67 */       l += ParseUtil.parseLongOrDefault(matcher.group(5), 0L) * 60000L;
/*    */     } 
/* 69 */     return l;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\aix\Uptime.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */