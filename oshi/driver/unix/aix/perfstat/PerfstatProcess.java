/*    */ package oshi.driver.unix.aix.perfstat;
/*    */ 
/*    */ import com.sun.jna.platform.unix.aix.Perfstat;
/*    */ import java.util.Arrays;
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
/*    */ public final class PerfstatProcess
/*    */ {
/* 40 */   private static final Perfstat PERF = Perfstat.INSTANCE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Perfstat.perfstat_process_t[] queryProcesses() {
/* 51 */     Perfstat.perfstat_process_t perfstat_process_t = new Perfstat.perfstat_process_t();
/*    */     
/* 53 */     int i = PERF.perfstat_process(null, null, perfstat_process_t.size(), 0);
/* 54 */     if (i > 0) {
/* 55 */       Perfstat.perfstat_process_t[] arrayOfPerfstat_process_t = (Perfstat.perfstat_process_t[])perfstat_process_t.toArray(i);
/* 56 */       Perfstat.perfstat_id_t perfstat_id_t = new Perfstat.perfstat_id_t();
/* 57 */       int j = PERF.perfstat_process(perfstat_id_t, arrayOfPerfstat_process_t, perfstat_process_t.size(), i);
/* 58 */       if (j > 0) {
/* 59 */         return Arrays.<Perfstat.perfstat_process_t>copyOf(arrayOfPerfstat_process_t, j);
/*    */       }
/*    */     } 
/* 62 */     return new Perfstat.perfstat_process_t[0];
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\aix\perfstat\PerfstatProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */