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
/*    */ @ThreadSafe
/*    */ public final class PerfstatConfig
/*    */ {
/* 37 */   private static final Perfstat PERF = Perfstat.INSTANCE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Perfstat.perfstat_partition_config_t queryConfig() {
/* 48 */     Perfstat.perfstat_partition_config_t perfstat_partition_config_t = new Perfstat.perfstat_partition_config_t();
/* 49 */     int i = PERF.perfstat_partition_config(null, perfstat_partition_config_t, perfstat_partition_config_t.size(), 1);
/* 50 */     if (i > 0) {
/* 51 */       return perfstat_partition_config_t;
/*    */     }
/* 53 */     return new Perfstat.perfstat_partition_config_t();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\aix\perfstat\PerfstatConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */