/*    */ package oshi.driver.unix.freebsd.disk;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.util.ExecutingCommand;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */ public final class Mount
/*    */ {
/*    */   private static final String MOUNT_CMD = "mount";
/* 41 */   private static final Pattern MOUNT_PATTERN = Pattern.compile("/dev/(\\S+p\\d+) on (\\S+) .*");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Map<String, String> queryPartitionToMountMap() {
/* 53 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 54 */     for (String str : ExecutingCommand.runNative("mount")) {
/* 55 */       Matcher matcher = MOUNT_PATTERN.matcher(str);
/* 56 */       if (matcher.matches()) {
/* 57 */         hashMap.put(matcher.group(1), matcher.group(2));
/*    */       }
/*    */     } 
/* 60 */     return (Map)hashMap;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\freebsd\disk\Mount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */