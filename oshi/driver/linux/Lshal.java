/*    */ package oshi.driver.linux;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ThreadSafe
/*    */ public final class Lshal
/*    */ {
/*    */   public static String querySerialNumber() {
/* 46 */     String str = "system.hardware.serial =";
/* 47 */     for (String str1 : ExecutingCommand.runNative("lshal")) {
/* 48 */       if (str1.contains(str)) {
/* 49 */         return ParseUtil.getSingleQuoteStringValue(str1);
/*    */       }
/*    */     } 
/* 52 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String queryUUID() {
/* 62 */     String str = "system.hardware.uuid =";
/* 63 */     for (String str1 : ExecutingCommand.runNative("lshal")) {
/* 64 */       if (str1.contains(str)) {
/* 65 */         return ParseUtil.getSingleQuoteStringValue(str1);
/*    */       }
/*    */     } 
/* 68 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\linux\Lshal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */