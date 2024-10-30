/*     */ package oshi.driver.windows.perfmon;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.util.platform.windows.PerfCounterWildcardQuery;
/*     */ import oshi.util.tuples.Pair;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public final class ProcessInformation
/*     */ {
/*     */   private static final String WIN32_PERFPROC_PROCESS = "Win32_PerfRawData_PerfProc_Process";
/*     */   private static final String PROCESS = "Process";
/*     */   private static final String WIN32_PROCESS_WHERE_NOT_NAME_LIKE_TOTAL = "Win32_PerfRawData_PerfProc_ProcessWin32_Process WHERE NOT Name LIKE\"%_Total\"";
/*     */   
/*     */   public enum ProcessPerformanceProperty
/*     */     implements PerfCounterWildcardQuery.PdhCounterWildcardProperty
/*     */   {
/*  51 */     NAME("^*_Total"),
/*     */     
/*  53 */     PRIORITYBASE("Priority Base"),
/*  54 */     ELAPSEDTIME("Elapsed Time"),
/*  55 */     IDPROCESS("ID Process"),
/*  56 */     CREATINGPROCESSID("Creating Process ID"),
/*  57 */     IOREADBYTESPERSEC("IO Read Bytes/sec"),
/*  58 */     IOWRITEBYTESPERSEC("IO Write Bytes/sec"),
/*  59 */     PRIVATEBYTES("Working Set - Private"),
/*  60 */     PAGEFAULTSPERSEC("Page Faults/sec");
/*     */     
/*     */     private final String counter;
/*     */     
/*     */     ProcessPerformanceProperty(String param1String1) {
/*  65 */       this.counter = param1String1;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getCounter() {
/*  70 */       return this.counter;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public enum HandleCountProperty
/*     */     implements PerfCounterWildcardQuery.PdhCounterWildcardProperty
/*     */   {
/*  79 */     NAME("_Total"),
/*     */     
/*  81 */     HANDLECOUNT("Handle Count");
/*     */     
/*     */     private final String counter;
/*     */     
/*     */     HandleCountProperty(String param1String1) {
/*  86 */       this.counter = param1String1;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getCounter() {
/*  91 */       return this.counter;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Pair<List<String>, Map<ProcessPerformanceProperty, List<Long>>> queryProcessCounters() {
/* 104 */     return PerfCounterWildcardQuery.queryInstancesAndValues(ProcessPerformanceProperty.class, "Process", "Win32_PerfRawData_PerfProc_ProcessWin32_Process WHERE NOT Name LIKE\"%_Total\"");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Pair<List<String>, Map<HandleCountProperty, List<Long>>> queryHandles() {
/* 114 */     return PerfCounterWildcardQuery.queryInstancesAndValues(HandleCountProperty.class, "Process", "Win32_PerfRawData_PerfProc_Process");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\perfmon\ProcessInformation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */