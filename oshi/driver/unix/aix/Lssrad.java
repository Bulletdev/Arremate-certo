/*    */ package oshi.driver.unix.aix;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ThreadSafe
/*    */ public final class Lssrad
/*    */ {
/*    */   public static Map<Integer, Pair<Integer, Integer>> queryNodesPackages() {
/* 64 */     int i = 0;
/* 65 */     int j = 0;
/* 66 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 67 */     List list = ExecutingCommand.runNative("lssrad -av");
/*    */     
/* 69 */     if (!list.isEmpty()) {
/* 70 */       list.remove(0);
/*    */     }
/* 72 */     for (String str1 : list) {
/* 73 */       String str2 = str1.trim();
/* 74 */       if (!str2.isEmpty()) {
/* 75 */         if (Character.isDigit(str1.charAt(0))) {
/* 76 */           i = ParseUtil.parseIntOrDefault(str2, 0); continue;
/*    */         } 
/* 78 */         if (str2.contains(".")) {
/* 79 */           String[] arrayOfString = ParseUtil.whitespaces.split(str2, 3);
/* 80 */           j = ParseUtil.parseIntOrDefault(arrayOfString[0], 0);
/* 81 */           str2 = (arrayOfString.length > 2) ? arrayOfString[2] : "";
/*    */         } 
/* 83 */         for (Integer integer : ParseUtil.parseHyphenatedIntList(str2)) {
/* 84 */           hashMap.put(integer, new Pair(Integer.valueOf(i), Integer.valueOf(j)));
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 89 */     return (Map)hashMap;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\aix\Lssrad.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */