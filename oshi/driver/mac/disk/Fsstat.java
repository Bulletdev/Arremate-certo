/*    */ package oshi.driver.mac.disk;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import com.sun.jna.platform.mac.SystemB;
/*    */ import java.nio.charset.StandardCharsets;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */ public final class Fsstat
/*    */ {
/*    */   public static Map<String, String> queryPartitionToMountMap() {
/* 51 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*    */     
/* 53 */     int i = SystemB.INSTANCE.getfsstat64(null, 0, 0);
/*    */     
/* 55 */     SystemB.Statfs[] arrayOfStatfs = new SystemB.Statfs[i];
/*    */     
/* 57 */     SystemB.INSTANCE.getfsstat64(arrayOfStatfs, i * (new SystemB.Statfs()).size(), 16);
/*    */     
/* 59 */     for (SystemB.Statfs statfs : arrayOfStatfs) {
/* 60 */       String str = Native.toString(statfs.f_mntfromname, StandardCharsets.UTF_8);
/* 61 */       hashMap.put(str.replace("/dev/", ""), Native.toString(statfs.f_mntonname, StandardCharsets.UTF_8));
/*    */     } 
/* 63 */     return (Map)hashMap;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\mac\disk\Fsstat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */