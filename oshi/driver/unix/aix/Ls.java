/*    */ package oshi.driver.unix.aix;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.util.ExecutingCommand;
/*    */ import oshi.util.ParseUtil;
/*    */ import oshi.util.tuples.Pair;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ThreadSafe
/*    */ public final class Ls
/*    */ {
/*    */   public static Map<String, Pair<Integer, Integer>> queryDeviceMajorMinor() {
/* 55 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 56 */     for (String str : ExecutingCommand.runNative("ls -l /dev")) {
/*    */       
/* 58 */       if (!str.isEmpty() && str.charAt(0) == 'b') {
/*    */         
/* 60 */         int i = str.lastIndexOf(' ');
/* 61 */         if (i > 0 && i < str.length()) {
/* 62 */           String str1 = str.substring(i + 1);
/* 63 */           int j = ParseUtil.getNthIntValue(str, 2);
/* 64 */           int k = ParseUtil.getNthIntValue(str, 3);
/* 65 */           hashMap.put(str1, new Pair(Integer.valueOf(j), Integer.valueOf(k)));
/*    */         } 
/*    */       } 
/*    */     } 
/* 69 */     return (Map)hashMap;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\aix\Ls.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */