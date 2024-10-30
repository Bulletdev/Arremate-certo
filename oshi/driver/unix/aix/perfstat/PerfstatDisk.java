/*    */ package oshi.driver.unix.aix.perfstat;
/*    */ 
/*    */ import com.sun.jna.platform.unix.aix.Perfstat;
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
/*    */ @ThreadSafe
/*    */ public final class PerfstatDisk
/*    */ {
/* 38 */   private static final Perfstat PERF = Perfstat.INSTANCE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Perfstat.perfstat_disk_t[] queryDiskStats() {
/* 49 */     Perfstat.perfstat_disk_t perfstat_disk_t = new Perfstat.perfstat_disk_t();
/*    */     
/* 51 */     int i = PERF.perfstat_disk(null, null, perfstat_disk_t.size(), 0);
/* 52 */     if (i > 0) {
/* 53 */       Perfstat.perfstat_disk_t[] arrayOfPerfstat_disk_t = (Perfstat.perfstat_disk_t[])perfstat_disk_t.toArray(i);
/* 54 */       Perfstat.perfstat_id_t perfstat_id_t = new Perfstat.perfstat_id_t();
/* 55 */       int j = PERF.perfstat_disk(perfstat_id_t, arrayOfPerfstat_disk_t, perfstat_disk_t.size(), i);
/* 56 */       if (j > 0) {
/* 57 */         return arrayOfPerfstat_disk_t;
/*    */       }
/*    */     } 
/* 60 */     return new Perfstat.perfstat_disk_t[0];
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\aix\perfstat\PerfstatDisk.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */