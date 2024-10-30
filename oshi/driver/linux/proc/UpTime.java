/*    */ package oshi.driver.linux.proc;
/*    */ 
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.util.FileUtil;
/*    */ import oshi.util.platform.linux.ProcPath;
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
/*    */ @ThreadSafe
/*    */ public final class UpTime
/*    */ {
/*    */   public static double getSystemUptimeSeconds() {
/* 45 */     String str = FileUtil.getStringFromFile(ProcPath.UPTIME);
/* 46 */     int i = str.indexOf(' ');
/*    */     try {
/* 48 */       if (i < 0)
/*    */       {
/* 50 */         return 0.0D;
/*    */       }
/* 52 */       return Double.parseDouble(str.substring(0, i));
/*    */     }
/* 54 */     catch (NumberFormatException numberFormatException) {
/* 55 */       return 0.0D;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\linux\proc\UpTime.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */