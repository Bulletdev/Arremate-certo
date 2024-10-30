/*     */ package oshi.driver.windows.registry;
/*     */ 
/*     */ import com.sun.jna.platform.win32.WinBase;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.windows.perfmon.ProcessInformation;
/*     */ import oshi.util.GlobalConfig;
/*     */ import oshi.util.tuples.Pair;
/*     */ import oshi.util.tuples.Triplet;
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
/*     */ public final class ProcessPerformanceData
/*     */ {
/*     */   private static final String PROCESS = "Process";
/*     */   public static final String WIN_HKEY_PERFDATA = "oshi.os.windows.hkeyperfdata";
/*  50 */   private static final boolean PERFDATA = GlobalConfig.get("oshi.os.windows.hkeyperfdata", true);
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
/*     */   public static Map<Integer, PerfCounterBlock> buildProcessMapFromRegistry(Collection<Integer> paramCollection) {
/*  67 */     Triplet<List<Map<ProcessInformation.ProcessPerformanceProperty, Object>>, Long, Long> triplet = null;
/*  68 */     if (PERFDATA) {
/*  69 */       triplet = HkeyPerformanceDataUtil.readPerfDataFromRegistry("Process", ProcessInformation.ProcessPerformanceProperty.class);
/*     */     }
/*  71 */     if (triplet == null) {
/*  72 */       return null;
/*     */     }
/*  74 */     List list = (List)triplet.getA();
/*  75 */     long l = ((Long)triplet.getC()).longValue();
/*     */ 
/*     */     
/*  78 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/*  80 */     for (Map map : list) {
/*  81 */       int i = ((Integer)map.get(ProcessInformation.ProcessPerformanceProperty.IDPROCESS)).intValue();
/*  82 */       String str = (String)map.get(ProcessInformation.ProcessPerformanceProperty.NAME);
/*  83 */       if ((paramCollection == null || paramCollection.contains(Integer.valueOf(i))) && !"_Total".equals(str)) {
/*     */         
/*  85 */         long l1 = ((Long)map.get(ProcessInformation.ProcessPerformanceProperty.ELAPSEDTIME)).longValue();
/*     */ 
/*     */         
/*  88 */         if (l1 > l) {
/*  89 */           l1 = WinBase.FILETIME.filetimeToDate((int)(l1 >> 32L), (int)(l1 & 0xFFFFFFFFL)).getTime();
/*     */         }
/*  91 */         long l2 = l - l1;
/*  92 */         if (l2 < 1L) {
/*  93 */           l2 = 1L;
/*     */         }
/*  95 */         hashMap.put(Integer.valueOf(i), new PerfCounterBlock(str, ((Integer)map
/*     */               
/*  97 */               .get(ProcessInformation.ProcessPerformanceProperty.CREATINGPROCESSID)).intValue(), ((Integer)map
/*  98 */               .get(ProcessInformation.ProcessPerformanceProperty.PRIORITYBASE)).intValue(), ((Long)map
/*  99 */               .get(ProcessInformation.ProcessPerformanceProperty.PRIVATEBYTES)).longValue(), l1, l2, ((Long)map
/* 100 */               .get(ProcessInformation.ProcessPerformanceProperty.IOREADBYTESPERSEC)).longValue(), ((Long)map
/* 101 */               .get(ProcessInformation.ProcessPerformanceProperty.IOWRITEBYTESPERSEC)).longValue(), ((Integer)map
/* 102 */               .get(ProcessInformation.ProcessPerformanceProperty.PAGEFAULTSPERSEC)).intValue()));
/*     */       } 
/*     */     } 
/* 105 */     return (Map)hashMap;
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
/*     */   
/*     */   public static Map<Integer, PerfCounterBlock> buildProcessMapFromPerfCounters(Collection<Integer> paramCollection) {
/* 118 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/* 120 */     Pair pair = ProcessInformation.queryProcessCounters();
/* 121 */     long l = System.currentTimeMillis();
/* 122 */     List<String> list = (List)pair.getA();
/* 123 */     Map map = (Map)pair.getB();
/* 124 */     List<Long> list1 = (List)map.get(ProcessInformation.ProcessPerformanceProperty.IDPROCESS);
/* 125 */     List<Long> list2 = (List)map.get(ProcessInformation.ProcessPerformanceProperty.CREATINGPROCESSID);
/* 126 */     List<Long> list3 = (List)map.get(ProcessInformation.ProcessPerformanceProperty.PRIORITYBASE);
/* 127 */     List<Long> list4 = (List)map.get(ProcessInformation.ProcessPerformanceProperty.IOREADBYTESPERSEC);
/* 128 */     List<Long> list5 = (List)map.get(ProcessInformation.ProcessPerformanceProperty.IOWRITEBYTESPERSEC);
/* 129 */     List<Long> list6 = (List)map.get(ProcessInformation.ProcessPerformanceProperty.PRIVATEBYTES);
/* 130 */     List<Long> list7 = (List)map.get(ProcessInformation.ProcessPerformanceProperty.ELAPSEDTIME);
/* 131 */     List<Long> list8 = (List)map.get(ProcessInformation.ProcessPerformanceProperty.PAGEFAULTSPERSEC);
/*     */     
/* 133 */     for (byte b = 0; b < list.size(); b++) {
/* 134 */       int i = ((Long)list1.get(b)).intValue();
/* 135 */       if (paramCollection == null || paramCollection.contains(Integer.valueOf(i))) {
/*     */         
/* 137 */         long l1 = ((Long)list7.get(b)).longValue();
/*     */ 
/*     */         
/* 140 */         if (l1 > l) {
/* 141 */           l1 = WinBase.FILETIME.filetimeToDate((int)(l1 >> 32L), (int)(l1 & 0xFFFFFFFFL)).getTime();
/*     */         }
/* 143 */         long l2 = l - l1;
/* 144 */         if (l2 < 1L) {
/* 145 */           l2 = 1L;
/*     */         }
/* 147 */         hashMap.put(Integer.valueOf(i), new PerfCounterBlock(list
/* 148 */               .get(b), ((Long)list2.get(b)).intValue(), ((Long)list3
/* 149 */               .get(b)).intValue(), ((Long)list6.get(b)).longValue(), l1, l2, ((Long)list4
/* 150 */               .get(b)).longValue(), ((Long)list5.get(b)).longValue(), ((Long)list8.get(b)).intValue()));
/*     */       } 
/*     */     } 
/* 153 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */   
/*     */   @Immutable
/*     */   public static class PerfCounterBlock
/*     */   {
/*     */     private final String name;
/*     */     
/*     */     private final int parentProcessID;
/*     */     
/*     */     private final int priority;
/*     */     private final long residentSetSize;
/*     */     private final long startTime;
/*     */     private final long upTime;
/*     */     private final long bytesRead;
/*     */     private final long bytesWritten;
/*     */     private final int pageFaults;
/*     */     
/*     */     public PerfCounterBlock(String param1String, int param1Int1, int param1Int2, long param1Long1, long param1Long2, long param1Long3, long param1Long4, long param1Long5, int param1Int3) {
/* 173 */       this.name = param1String;
/* 174 */       this.parentProcessID = param1Int1;
/* 175 */       this.priority = param1Int2;
/* 176 */       this.residentSetSize = param1Long1;
/* 177 */       this.startTime = param1Long2;
/* 178 */       this.upTime = param1Long3;
/* 179 */       this.bytesRead = param1Long4;
/* 180 */       this.bytesWritten = param1Long5;
/* 181 */       this.pageFaults = param1Int3;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/* 188 */       return this.name;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getParentProcessID() {
/* 195 */       return this.parentProcessID;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getPriority() {
/* 202 */       return this.priority;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getResidentSetSize() {
/* 209 */       return this.residentSetSize;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getStartTime() {
/* 216 */       return this.startTime;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getUpTime() {
/* 223 */       return this.upTime;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getBytesRead() {
/* 230 */       return this.bytesRead;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getBytesWritten() {
/* 237 */       return this.bytesWritten;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getPageFaults() {
/* 244 */       return this.pageFaults;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\registry\ProcessPerformanceData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */