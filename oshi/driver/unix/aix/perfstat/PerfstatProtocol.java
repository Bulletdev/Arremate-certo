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
/*    */ public final class PerfstatProtocol
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
/*    */   public static Perfstat.perfstat_protocol_t[] queryProtocols() {
/* 49 */     Perfstat.perfstat_protocol_t perfstat_protocol_t = new Perfstat.perfstat_protocol_t();
/*    */     
/* 51 */     int i = PERF.perfstat_protocol(null, null, perfstat_protocol_t.size(), 0);
/* 52 */     if (i > 0) {
/* 53 */       Perfstat.perfstat_protocol_t[] arrayOfPerfstat_protocol_t = (Perfstat.perfstat_protocol_t[])perfstat_protocol_t.toArray(i);
/* 54 */       Perfstat.perfstat_id_t perfstat_id_t = new Perfstat.perfstat_id_t();
/* 55 */       int j = PERF.perfstat_protocol(perfstat_id_t, arrayOfPerfstat_protocol_t, perfstat_protocol_t.size(), i);
/* 56 */       if (j > 0) {
/* 57 */         return arrayOfPerfstat_protocol_t;
/*    */       }
/*    */     } 
/* 60 */     return new Perfstat.perfstat_protocol_t[0];
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\aix\perfstat\PerfstatProtocol.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */