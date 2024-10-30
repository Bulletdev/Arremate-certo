/*    */ package oshi.driver.windows.perfmon;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.util.platform.windows.PerfCounterWildcardQuery;
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
/*    */ @ThreadSafe
/*    */ public final class ThreadInformation
/*    */ {
/*    */   private static final String THREAD = "Thread";
/*    */   private static final String WIN32_PERF_RAW_DATA_PERF_PROC_THREAD = "Win32_PerfRawData_PerfProc_Thread WHERE NOT Name LIKE \"%_Total\"";
/*    */   
/*    */   public enum ThreadPerformanceProperty
/*    */     implements PerfCounterWildcardQuery.PdhCounterWildcardProperty
/*    */   {
/* 49 */     NAME("^*_Total"),
/*    */     
/* 51 */     PERCENTUSERTIME("% User Time"),
/* 52 */     PERCENTPRIVILEGEDTIME("% Privileged Time"),
/* 53 */     ELAPSEDTIME("Elapsed Time"),
/* 54 */     PRIORITYCURRENT("Priority Current"),
/* 55 */     STARTADDRESS("Start Address"),
/* 56 */     THREADSTATE("Thread State"),
/* 57 */     THREADWAITREASON("Thread Wait Reason"),
/* 58 */     IDPROCESS("ID Process"),
/* 59 */     IDTHREAD("ID Thread"),
/* 60 */     CONTEXTSWITCHESPERSEC("Context Switches/sec");
/*    */     
/*    */     private final String counter;
/*    */     
/*    */     ThreadPerformanceProperty(String param1String1) {
/* 65 */       this.counter = param1String1;
/*    */     }
/*    */ 
/*    */     
/*    */     public String getCounter() {
/* 70 */       return this.counter;
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Pair<List<String>, Map<ThreadPerformanceProperty, List<Long>>> queryThreadCounters() {
/* 83 */     return PerfCounterWildcardQuery.queryInstancesAndValues(ThreadPerformanceProperty.class, "Thread", "Win32_PerfRawData_PerfProc_Thread WHERE NOT Name LIKE \"%_Total\"");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\perfmon\ThreadInformation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */