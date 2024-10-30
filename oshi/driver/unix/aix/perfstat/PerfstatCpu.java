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
/*    */ 
/*    */ @ThreadSafe
/*    */ public final class PerfstatCpu
/*    */ {
/* 39 */   private static final Perfstat PERF = Perfstat.INSTANCE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Perfstat.perfstat_cpu_total_t queryCpuTotal() {
/* 50 */     Perfstat.perfstat_cpu_total_t perfstat_cpu_total_t = new Perfstat.perfstat_cpu_total_t();
/* 51 */     int i = PERF.perfstat_cpu_total(null, perfstat_cpu_total_t, perfstat_cpu_total_t.size(), 1);
/* 52 */     if (i > 0) {
/* 53 */       return perfstat_cpu_total_t;
/*    */     }
/* 55 */     return new Perfstat.perfstat_cpu_total_t();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Perfstat.perfstat_cpu_t[] queryCpu() {
/* 64 */     Perfstat.perfstat_cpu_t perfstat_cpu_t = new Perfstat.perfstat_cpu_t();
/*    */     
/* 66 */     int i = PERF.perfstat_cpu(null, null, perfstat_cpu_t.size(), 0);
/* 67 */     if (i > 0) {
/* 68 */       Perfstat.perfstat_cpu_t[] arrayOfPerfstat_cpu_t = (Perfstat.perfstat_cpu_t[])perfstat_cpu_t.toArray(i);
/* 69 */       Perfstat.perfstat_id_t perfstat_id_t = new Perfstat.perfstat_id_t();
/* 70 */       int j = PERF.perfstat_cpu(perfstat_id_t, arrayOfPerfstat_cpu_t, perfstat_cpu_t.size(), i);
/* 71 */       if (j > 0) {
/* 72 */         return arrayOfPerfstat_cpu_t;
/*    */       }
/*    */     } 
/* 75 */     return new Perfstat.perfstat_cpu_t[0];
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long queryCpuAffinityMask() {
/* 84 */     int i = (queryCpuTotal()).ncpus;
/* 85 */     if (i < 63) {
/* 86 */       return (1L << i) - 1L;
/*    */     }
/* 88 */     return (i == 63) ? Long.MAX_VALUE : -1L;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\aix\perfstat\PerfstatCpu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */