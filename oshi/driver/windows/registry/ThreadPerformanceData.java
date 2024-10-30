/*     */ package oshi.driver.windows.registry;
/*     */ 
/*     */ import com.sun.jna.platform.win32.WinBase;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.windows.perfmon.ThreadInformation;
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
/*     */ public final class ThreadPerformanceData
/*     */ {
/*     */   private static final String THREAD = "Thread";
/*     */   
/*     */   public static Map<Integer, PerfCounterBlock> buildThreadMapFromRegistry(Collection<Integer> paramCollection) {
/*  65 */     Triplet<List<Map<ThreadInformation.ThreadPerformanceProperty, Object>>, Long, Long> triplet = HkeyPerformanceDataUtil.readPerfDataFromRegistry("Thread", ThreadInformation.ThreadPerformanceProperty.class);
/*  66 */     if (triplet == null) {
/*  67 */       return null;
/*     */     }
/*  69 */     List list = (List)triplet.getA();
/*  70 */     long l1 = ((Long)triplet.getB()).longValue();
/*  71 */     long l2 = ((Long)triplet.getC()).longValue();
/*     */ 
/*     */     
/*  74 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/*  76 */     for (Map map : list) {
/*  77 */       int i = ((Integer)map.get(ThreadInformation.ThreadPerformanceProperty.IDPROCESS)).intValue();
/*  78 */       if ((paramCollection == null || paramCollection.contains(Integer.valueOf(i))) && i > 0) {
/*  79 */         int j = ((Integer)map.get(ThreadInformation.ThreadPerformanceProperty.IDTHREAD)).intValue();
/*  80 */         String str = (String)map.get(ThreadInformation.ThreadPerformanceProperty.NAME);
/*  81 */         long l3 = (l1 - ((Long)map.get(ThreadInformation.ThreadPerformanceProperty.ELAPSEDTIME)).longValue()) / 10000L;
/*     */         
/*  83 */         if (l3 < 1L) {
/*  84 */           l3 = 1L;
/*     */         }
/*  86 */         long l4 = ((Long)map.get(ThreadInformation.ThreadPerformanceProperty.PERCENTUSERTIME)).longValue() / 10000L;
/*     */ 
/*     */         
/*  89 */         long l5 = ((Long)map.get(ThreadInformation.ThreadPerformanceProperty.PERCENTPRIVILEGEDTIME)).longValue() / 10000L;
/*  90 */         int k = ((Integer)map.get(ThreadInformation.ThreadPerformanceProperty.PRIORITYCURRENT)).intValue();
/*  91 */         int m = ((Integer)map.get(ThreadInformation.ThreadPerformanceProperty.THREADSTATE)).intValue();
/*     */         
/*  93 */         int n = ((Integer)map.get(ThreadInformation.ThreadPerformanceProperty.THREADWAITREASON)).intValue();
/*     */ 
/*     */         
/*  96 */         Object object = map.get(ThreadInformation.ThreadPerformanceProperty.STARTADDRESS);
/*     */         
/*  98 */         long l6 = object.getClass().equals(Long.class) ? ((Long)object).longValue() : Integer.toUnsignedLong(((Integer)object).intValue());
/*     */         
/* 100 */         int i1 = ((Integer)map.get(ThreadInformation.ThreadPerformanceProperty.CONTEXTSWITCHESPERSEC)).intValue();
/* 101 */         hashMap.put(Integer.valueOf(j), new PerfCounterBlock(str, j, i, l2 - l3, l4, l5, k, m, n, l6, i1));
/*     */       } 
/*     */     } 
/*     */     
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
/*     */   public static Map<Integer, PerfCounterBlock> buildThreadMapFromPerfCounters(Collection<Integer> paramCollection) {
/* 118 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/* 120 */     Pair pair = ThreadInformation.queryThreadCounters();
/* 121 */     long l = System.currentTimeMillis();
/* 122 */     List list = (List)pair.getA();
/* 123 */     Map map = (Map)pair.getB();
/* 124 */     List<Long> list1 = (List)map.get(ThreadInformation.ThreadPerformanceProperty.IDTHREAD);
/* 125 */     List<Long> list2 = (List)map.get(ThreadInformation.ThreadPerformanceProperty.IDPROCESS);
/* 126 */     List<Long> list3 = (List)map.get(ThreadInformation.ThreadPerformanceProperty.PERCENTUSERTIME);
/* 127 */     List<Long> list4 = (List)map.get(ThreadInformation.ThreadPerformanceProperty.PERCENTPRIVILEGEDTIME);
/* 128 */     List<Long> list5 = (List)map.get(ThreadInformation.ThreadPerformanceProperty.ELAPSEDTIME);
/* 129 */     List<Long> list6 = (List)map.get(ThreadInformation.ThreadPerformanceProperty.PRIORITYCURRENT);
/* 130 */     List<Long> list7 = (List)map.get(ThreadInformation.ThreadPerformanceProperty.THREADSTATE);
/* 131 */     List<Long> list8 = (List)map.get(ThreadInformation.ThreadPerformanceProperty.THREADWAITREASON);
/* 132 */     List<Long> list9 = (List)map.get(ThreadInformation.ThreadPerformanceProperty.STARTADDRESS);
/* 133 */     List<Long> list10 = (List)map.get(ThreadInformation.ThreadPerformanceProperty.CONTEXTSWITCHESPERSEC);
/*     */     
/* 135 */     byte b1 = 0;
/* 136 */     for (byte b2 = 0; b2 < list.size(); b2++) {
/* 137 */       int i = ((Long)list2.get(b2)).intValue();
/* 138 */       if (paramCollection == null || paramCollection.contains(Integer.valueOf(i))) {
/* 139 */         int j = ((Long)list1.get(b2)).intValue();
/* 140 */         String str = Integer.toString(b1++);
/* 141 */         long l1 = ((Long)list5.get(b2)).longValue();
/* 142 */         l1 = WinBase.FILETIME.filetimeToDate((int)(l1 >> 32L), (int)(l1 & 0xFFFFFFFFL)).getTime();
/* 143 */         if (l1 > l) {
/* 144 */           l1 = l - 1L;
/*     */         }
/* 146 */         long l2 = ((Long)list3.get(b2)).longValue() / 10000L;
/* 147 */         long l3 = ((Long)list4.get(b2)).longValue() / 10000L;
/* 148 */         int k = ((Long)list6.get(b2)).intValue();
/* 149 */         int m = ((Long)list7.get(b2)).intValue();
/* 150 */         int n = ((Long)list8.get(b2)).intValue();
/* 151 */         long l4 = ((Long)list9.get(b2)).longValue();
/* 152 */         int i1 = ((Long)list10.get(b2)).intValue();
/*     */ 
/*     */ 
/*     */         
/* 156 */         hashMap.put(Integer.valueOf(j), new PerfCounterBlock(str, j, i, l1, l2, l3, k, m, n, l4, i1));
/*     */       } 
/*     */     } 
/*     */     
/* 160 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */   
/*     */   @Immutable
/*     */   public static class PerfCounterBlock
/*     */   {
/*     */     private final String name;
/*     */     
/*     */     private final int threadID;
/*     */     
/*     */     private final int owningProcessID;
/*     */     
/*     */     private final long startTime;
/*     */     private final long userTime;
/*     */     private final long kernelTime;
/*     */     private final int priority;
/*     */     private final int threadState;
/*     */     private final int threadWaitReason;
/*     */     private final long startAddress;
/*     */     private final int contextSwitches;
/*     */     
/*     */     public PerfCounterBlock(String param1String, int param1Int1, int param1Int2, long param1Long1, long param1Long2, long param1Long3, int param1Int3, int param1Int4, int param1Int5, long param1Long4, int param1Int6) {
/* 183 */       this.name = param1String;
/* 184 */       this.threadID = param1Int1;
/* 185 */       this.owningProcessID = param1Int2;
/* 186 */       this.startTime = param1Long1;
/* 187 */       this.userTime = param1Long2;
/* 188 */       this.kernelTime = param1Long3;
/* 189 */       this.priority = param1Int3;
/* 190 */       this.threadState = param1Int4;
/* 191 */       this.threadWaitReason = param1Int5;
/* 192 */       this.startAddress = param1Long4;
/* 193 */       this.contextSwitches = param1Int6;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/* 200 */       return this.name;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getThreadID() {
/* 207 */       return this.threadID;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getOwningProcessID() {
/* 214 */       return this.owningProcessID;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getStartTime() {
/* 221 */       return this.startTime;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getUserTime() {
/* 228 */       return this.userTime;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getKernelTime() {
/* 235 */       return this.kernelTime;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getPriority() {
/* 242 */       return this.priority;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getThreadState() {
/* 249 */       return this.threadState;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getThreadWaitReason() {
/* 256 */       return this.threadWaitReason;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getStartAddress() {
/* 263 */       return this.startAddress;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getContextSwitches() {
/* 270 */       return this.contextSwitches;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\registry\ThreadPerformanceData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */