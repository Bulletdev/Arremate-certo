/*     */ package oshi.driver.windows.perfmon;
/*     */ 
/*     */ import com.sun.jna.platform.win32.VersionHelpers;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.util.platform.windows.PerfCounterQuery;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public final class ProcessorInformation
/*     */ {
/*     */   private static final String PROCESSOR = "Processor";
/*     */   private static final String PROCESSOR_INFORMATION = "Processor Information";
/*     */   private static final String WIN32_PERF_RAW_DATA_COUNTERS_PROCESSOR_INFORMATION_WHERE_NOT_NAME_LIKE_TOTAL = "Win32_PerfRawData_Counters_ProcessorInformation WHERE NOT Name LIKE \"%_Total\"";
/*     */   private static final String WIN32_PERF_RAW_DATA_PERF_OS_PROCESSOR_WHERE_NOT_NAME_TOTAL = "Win32_PerfRawData_PerfOS_Processor WHERE NOT Name=\"_Total\"";
/*     */   private static final String WIN32_PERF_RAW_DATA_PERF_OS_PROCESSOR_WHERE_NAME_TOTAL = "Win32_PerfRawData_PerfOS_Processor WHERE Name=\"_Total\"";
/*  54 */   private static final boolean IS_WIN7_OR_GREATER = VersionHelpers.IsWindows7OrGreater();
/*     */ 
/*     */ 
/*     */   
/*     */   public enum ProcessorTickCountProperty
/*     */     implements PerfCounterWildcardQuery.PdhCounterWildcardProperty
/*     */   {
/*  61 */     NAME("^*_Total"),
/*     */     
/*  63 */     PERCENTDPCTIME("% DPC Time"),
/*  64 */     PERCENTINTERRUPTTIME("% Interrupt Time"),
/*  65 */     PERCENTPRIVILEGEDTIME("% Privileged Time"),
/*  66 */     PERCENTPROCESSORTIME("% Processor Time"),
/*  67 */     PERCENTUSERTIME("% User Time");
/*     */     
/*     */     private final String counter;
/*     */     
/*     */     ProcessorTickCountProperty(String param1String1) {
/*  72 */       this.counter = param1String1;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getCounter() {
/*  77 */       return this.counter;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public enum InterruptsProperty
/*     */     implements PerfCounterQuery.PdhCounterProperty
/*     */   {
/*  85 */     INTERRUPTSPERSEC("_Total", "Interrupts/sec");
/*     */     
/*     */     private final String counter;
/*     */     private final String instance;
/*     */     
/*     */     InterruptsProperty(String param1String1, String param1String2) {
/*  91 */       this.instance = param1String1;
/*  92 */       this.counter = param1String2;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getInstance() {
/*  97 */       return this.instance;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getCounter() {
/* 102 */       return this.counter;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public enum ProcessorFrequencyProperty
/*     */     implements PerfCounterWildcardQuery.PdhCounterWildcardProperty
/*     */   {
/* 111 */     NAME("^*_Total"),
/*     */     
/* 113 */     PERCENTOFMAXIMUMFREQUENCY("% of Maximum Frequency");
/*     */     
/*     */     private final String counter;
/*     */     
/*     */     ProcessorFrequencyProperty(String param1String1) {
/* 118 */       this.counter = param1String1;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getCounter() {
/* 123 */       return this.counter;
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
/*     */   public static Pair<List<String>, Map<ProcessorTickCountProperty, List<Long>>> queryProcessorCounters() {
/* 136 */     return IS_WIN7_OR_GREATER ? PerfCounterWildcardQuery.queryInstancesAndValues(ProcessorTickCountProperty.class, "Processor Information", "Win32_PerfRawData_Counters_ProcessorInformation WHERE NOT Name LIKE \"%_Total\"") : 
/*     */       
/* 138 */       PerfCounterWildcardQuery.queryInstancesAndValues(ProcessorTickCountProperty.class, "Processor", "Win32_PerfRawData_PerfOS_Processor WHERE NOT Name=\"_Total\"");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Map<InterruptsProperty, Long> queryInterruptCounters() {
/* 148 */     return PerfCounterQuery.queryValues(InterruptsProperty.class, "Processor", "Win32_PerfRawData_PerfOS_Processor WHERE Name=\"_Total\"");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Pair<List<String>, Map<ProcessorFrequencyProperty, List<Long>>> queryFrequencyCounters() {
/* 158 */     return PerfCounterWildcardQuery.queryInstancesAndValues(ProcessorFrequencyProperty.class, "Processor Information", "Win32_PerfRawData_Counters_ProcessorInformation WHERE NOT Name LIKE \"%_Total\"");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\perfmon\ProcessorInformation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */