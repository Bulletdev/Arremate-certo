/*    */ package oshi.driver.unix.solaris.disk;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
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
/*    */ 
/*    */ @ThreadSafe
/*    */ public final class Lshal
/*    */ {
/*    */   private static final String LSHAL_CMD = "lshal";
/*    */   
/*    */   public static Map<String, Integer> queryDiskToMajorMap() {
/* 52 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 53 */     List list = ExecutingCommand.runNative("lshal");
/* 54 */     String str = null;
/* 55 */     for (String str1 : list) {
/* 56 */       if (str1.startsWith("udi ")) {
/* 57 */         String str2 = ParseUtil.getSingleQuoteStringValue(str1);
/* 58 */         str = str2.substring(str2.lastIndexOf('/') + 1); continue;
/*    */       } 
/* 60 */       str1 = str1.trim();
/* 61 */       if (str1.startsWith("block.major") && str != null) {
/* 62 */         hashMap.put(str, Integer.valueOf(ParseUtil.getFirstIntValue(str1)));
/*    */       }
/*    */     } 
/*    */     
/* 66 */     return (Map)hashMap;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\solaris\disk\Lshal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */