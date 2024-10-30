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
/*    */ public final class PagingFile
/*    */ {
/*    */   private static final String PAGING_FILE = "Paging File";
/*    */   private static final String WIN32_PERF_RAW_DATA_PERF_OS_PAGING_FILE = "Win32_PerfRawData_PerfOS_PagingFile";
/*    */   
/*    */   public enum PagingPercentProperty
/*    */     implements PerfCounterQuery.PdhCounterProperty
/*    */   {
/* 45 */     PERCENTUSAGE("_Total", "% Usage");
/*    */     
/*    */     private final String counter;
/*    */     private final String instance;
/*    */     
/*    */     PagingPercentProperty(String param1String1, String param1String2) {
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
/*    */   public static Map<PagingPercentProperty, Long> querySwapUsed() {
/* 75 */     return PerfCounterQuery.queryValues(PagingPercentProperty.class, "Paging File", "Win32_PerfRawData_PerfOS_PagingFile");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\perfmon\PagingFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */