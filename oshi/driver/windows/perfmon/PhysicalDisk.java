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
/*    */ public final class PhysicalDisk
/*    */ {
/*    */   private static final String PHYSICAL_DISK = "PhysicalDisk";
/*    */   private static final String WIN32_PERF_RAW_DATA_PERF_DISK_PHYSICAL_DISK_WHERE_NOT_NAME_TOTAL = "Win32_PerfRawData_PerfDisk_PhysicalDisk WHERE NOT Name=\"_Total\"";
/*    */   
/*    */   public enum PhysicalDiskProperty
/*    */     implements PerfCounterWildcardQuery.PdhCounterWildcardProperty
/*    */   {
/* 49 */     NAME("^_Total"),
/*    */     
/* 51 */     DISKREADSPERSEC("Disk Reads/sec"),
/* 52 */     DISKREADBYTESPERSEC("Disk Read Bytes/sec"),
/* 53 */     DISKWRITESPERSEC("Disk Writes/sec"),
/* 54 */     DISKWRITEBYTESPERSEC("Disk Write Bytes/sec"),
/* 55 */     CURRENTDISKQUEUELENGTH("Current Disk Queue Length"),
/* 56 */     PERCENTDISKTIME("% Disk Time");
/*    */     
/*    */     private final String counter;
/*    */     
/*    */     PhysicalDiskProperty(String param1String1) {
/* 61 */       this.counter = param1String1;
/*    */     }
/*    */ 
/*    */     
/*    */     public String getCounter() {
/* 66 */       return this.counter;
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
/*    */   public static Pair<List<String>, Map<PhysicalDiskProperty, List<Long>>> queryDiskCounters() {
/* 79 */     return PerfCounterWildcardQuery.queryInstancesAndValues(PhysicalDiskProperty.class, "PhysicalDisk", "Win32_PerfRawData_PerfDisk_PhysicalDisk WHERE NOT Name=\"_Total\"");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\perfmon\PhysicalDisk.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */