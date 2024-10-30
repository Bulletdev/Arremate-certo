/*    */ package oshi.util.platform.unix.openbsd;
/*    */ 
/*    */ import java.util.List;
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
/*    */ public final class FstatUtil
/*    */ {
/*    */   public static String getCwd(int paramInt) {
/* 48 */     List<String> list = ExecutingCommand.runNative("ps -axwwo cwd -p " + paramInt);
/* 49 */     if (!list.isEmpty()) {
/* 50 */       return list.get(1);
/*    */     }
/* 52 */     return "";
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
/* 63 */     long l = 0L;
/* 64 */     List list = ExecutingCommand.runNative("fstat -sp " + paramInt);
/* 65 */     for (String str : list) {
/* 66 */       String[] arrayOfString = ParseUtil.whitespaces.split(str.trim(), 11);
/* 67 */       if (arrayOfString.length == 11 && !"pipe".contains(arrayOfString[4]) && !"unix".contains(arrayOfString[4])) {
/* 68 */         l++;
/*    */       }
/*    */     } 
/*    */     
/* 72 */     return l - 1L;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\platfor\\unix\openbsd\FstatUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */