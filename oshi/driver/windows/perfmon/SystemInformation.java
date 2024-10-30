/*    */ package oshi.driver.windows.perfmon;
/*    */ 
/*    */ import java.util.Map;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.util.platform.windows.PerfCounterQuery;
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
/*    */ public final class SystemInformation
/*    */ {
/*    */   private static final String SYSTEM = "System";
/*    */   private static final String WIN32_PERF_RAW_DATA_PERF_OS_SYSTEM = "Win32_PerfRawData_PerfOS_System";
/*    */   
/*    */   public enum ContextSwitchProperty
/*    */     implements PerfCounterQuery.PdhCounterProperty
/*    */   {
/* 45 */     CONTEXTSWITCHESPERSEC(null, "Context Switches/sec");
/*    */     
/*    */     private final String counter;
/*    */     private final String instance;
/*    */     
/*    */     ContextSwitchProperty(String param1String1, String param1String2) {
/* 51 */       this.instance = param1String1;
/* 52 */       this.counter = param1String2;
/*    */     }
/*    */ 
/*    */     
/*    */     public String getInstance() {
/* 57 */       return this.instance;
/*    */     }
/*    */ 
/*    */     
/*    */     public String getCounter() {
/* 62 */       return this.counter;
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
/*    */   public static Map<ContextSwitchProperty, Long> queryContextSwitchCounters() {
/* 75 */     return PerfCounterQuery.queryValues(ContextSwitchProperty.class, "System", "Win32_PerfRawData_PerfOS_System");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\perfmon\SystemInformation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */