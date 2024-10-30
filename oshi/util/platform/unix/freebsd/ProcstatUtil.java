/*    */ package oshi.util.platform.unix.freebsd;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @ThreadSafe
/*    */ public final class ProcstatUtil
/*    */ {
/*    */   public static Map<Integer, String> getCwdMap(int paramInt) {
/* 53 */     List list = ExecutingCommand.runNative("procstat -f " + ((paramInt < 0) ? "-a" : (String)Integer.valueOf(paramInt)));
/* 54 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 55 */     for (String str : list) {
/* 56 */       String[] arrayOfString = ParseUtil.whitespaces.split(str.trim(), 10);
/* 57 */       if (arrayOfString.length == 10 && arrayOfString[2].equals("cwd")) {
/* 58 */         hashMap.put(Integer.valueOf(ParseUtil.parseIntOrDefault(arrayOfString[0], -1)), arrayOfString[9]);
/*    */       }
/*    */     } 
/* 61 */     return (Map)hashMap;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getCwd(int paramInt) {
/* 72 */     List list = ExecutingCommand.runNative("procstat -f " + paramInt);
/* 73 */     for (String str : list) {
/* 74 */       String[] arrayOfString = ParseUtil.whitespaces.split(str.trim(), 10);
/* 75 */       if (arrayOfString.length == 10 && arrayOfString[2].equals("cwd")) {
/* 76 */         return arrayOfString[9];
/*    */       }
/*    */     } 
/* 79 */     return "";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long getOpenFiles(int paramInt) {
/* 90 */     long l = 0L;
/* 91 */     List list = ExecutingCommand.runNative("procstat -f " + paramInt);
/* 92 */     for (String str : list) {
/* 93 */       String[] arrayOfString = ParseUtil.whitespaces.split(str.trim(), 10);
/* 94 */       if (arrayOfString.length == 10 && !"Vd-".contains(arrayOfString[4])) {
/* 95 */         l++;
/*    */       }
/*    */     } 
/* 98 */     return l;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\platfor\\unix\freebsd\ProcstatUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */