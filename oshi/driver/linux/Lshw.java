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
/*    */ @ThreadSafe
/*    */ public final class Lshw
/*    */ {
/*    */   public static String queryModel() {
/* 45 */     String str = "product:";
/* 46 */     for (String str1 : ExecutingCommand.runNative("lshw -C system")) {
/* 47 */       if (str1.contains(str)) {
/* 48 */         return str1.split(str)[1].trim();
/*    */       }
/*    */     } 
/* 51 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String querySerialNumber() {
/* 60 */     String str = "serial:";
/* 61 */     for (String str1 : ExecutingCommand.runNative("lshw -C system")) {
/* 62 */       if (str1.contains(str)) {
/* 63 */         return str1.split(str)[1].trim();
/*    */       }
/*    */     } 
/* 66 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String queryUUID() {
/* 75 */     String str = "uuid:";
/* 76 */     for (String str1 : ExecutingCommand.runNative("lshw -C system")) {
/* 77 */       if (str1.contains(str)) {
/* 78 */         return str1.split(str)[1].trim();
/*    */       }
/*    */     } 
/* 81 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long queryCpuCapacity() {
/* 90 */     String str = "capacity:";
/* 91 */     for (String str1 : ExecutingCommand.runNative("lshw -class processor")) {
/* 92 */       if (str1.contains(str)) {
/* 93 */         return ParseUtil.parseHertz(str1.split(str)[1].trim());
/*    */       }
/*    */     } 
/* 96 */     return -1L;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\linux\Lshw.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */