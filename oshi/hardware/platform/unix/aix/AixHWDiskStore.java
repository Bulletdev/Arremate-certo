/*     */ package oshi.hardware.platform.unix.aix;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.platform.unix.aix.Perfstat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collectors;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.unix.aix.Ls;
/*     */ import oshi.driver.unix.aix.Lscfg;
/*     */ import oshi.driver.unix.aix.Lspv;
/*     */ import oshi.hardware.HWDiskStore;
/*     */ import oshi.hardware.HWPartition;
/*     */ import oshi.hardware.common.AbstractHWDiskStore;
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
/*     */ @ThreadSafe
/*     */ public final class AixHWDiskStore
/*     */   extends AbstractHWDiskStore
/*     */ {
/*     */   private final Supplier<Perfstat.perfstat_disk_t[]> diskStats;
/*  55 */   private long reads = 0L;
/*  56 */   private long readBytes = 0L;
/*  57 */   private long writes = 0L;
/*  58 */   private long writeBytes = 0L;
/*  59 */   private long currentQueueLength = 0L;
/*  60 */   private long transferTime = 0L;
/*  61 */   private long timeStamp = 0L;
/*     */   private List<HWPartition> partitionList;
/*     */   
/*     */   private AixHWDiskStore(String paramString1, String paramString2, String paramString3, long paramLong, Supplier<Perfstat.perfstat_disk_t[]> paramSupplier) {
/*  65 */     super(paramString1, paramString2, paramString3, paramLong);
/*  66 */     this.diskStats = paramSupplier;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getReads() {
/*  71 */     return this.reads;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getReadBytes() {
/*  76 */     return this.readBytes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getWrites() {
/*  81 */     return this.writes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getWriteBytes() {
/*  86 */     return this.writeBytes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getCurrentQueueLength() {
/*  91 */     return this.currentQueueLength;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTransferTime() {
/*  96 */     return this.transferTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeStamp() {
/* 101 */     return this.timeStamp;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<HWPartition> getPartitions() {
/* 106 */     return this.partitionList;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 111 */     for (Perfstat.perfstat_disk_t perfstat_disk_t : (Perfstat.perfstat_disk_t[])this.diskStats.get()) {
/* 112 */       String str = Native.toString(perfstat_disk_t.name);
/* 113 */       if (str.equals(getName())) {
/*     */         
/* 115 */         long l = perfstat_disk_t.rblks + perfstat_disk_t.wblks;
/* 116 */         this.reads = perfstat_disk_t.xfers;
/* 117 */         if (l > 0L) {
/* 118 */           this.writes = perfstat_disk_t.xfers * perfstat_disk_t.wblks / l;
/* 119 */           this.reads -= this.writes;
/*     */         } 
/* 121 */         this.readBytes = perfstat_disk_t.rblks * perfstat_disk_t.bsize;
/* 122 */         this.writeBytes = perfstat_disk_t.wblks * perfstat_disk_t.bsize;
/* 123 */         this.currentQueueLength = perfstat_disk_t.qdepth;
/* 124 */         this.transferTime = perfstat_disk_t.time;
/* 125 */         return true;
/*     */       } 
/*     */     } 
/* 128 */     return false;
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
/*     */   public static List<HWDiskStore> getDisks(Supplier<Perfstat.perfstat_disk_t[]> paramSupplier) {
/* 140 */     Map<String, Pair<Integer, Integer>> map = Ls.queryDeviceMajorMinor();
/* 141 */     ArrayList<AixHWDiskStore> arrayList = new ArrayList();
/* 142 */     for (Perfstat.perfstat_disk_t perfstat_disk_t : (Perfstat.perfstat_disk_t[])paramSupplier.get()) {
/* 143 */       String str1 = Native.toString(perfstat_disk_t.name);
/* 144 */       Pair pair = Lscfg.queryModelSerial(str1);
/* 145 */       String str2 = (pair.getA() == null) ? Native.toString(perfstat_disk_t.description) : (String)pair.getA();
/* 146 */       String str3 = (pair.getB() == null) ? "unknown" : (String)pair.getB();
/* 147 */       arrayList.add(createStore(str1, str2, str3, perfstat_disk_t.size << 20L, paramSupplier, map));
/*     */     } 
/* 149 */     return (List<HWDiskStore>)arrayList.stream()
/* 150 */       .sorted(Comparator.comparingInt(paramAixHWDiskStore -> paramAixHWDiskStore.getPartitions().isEmpty() ? Integer.MAX_VALUE : ((HWPartition)paramAixHWDiskStore.getPartitions().get(0)).getMajor()))
/*     */       
/* 152 */       .collect(Collectors.toList());
/*     */   }
/*     */ 
/*     */   
/*     */   private static AixHWDiskStore createStore(String paramString1, String paramString2, String paramString3, long paramLong, Supplier<Perfstat.perfstat_disk_t[]> paramSupplier, Map<String, Pair<Integer, Integer>> paramMap) {
/* 157 */     AixHWDiskStore aixHWDiskStore = new AixHWDiskStore(paramString1, paramString2.isEmpty() ? "unknown" : paramString2, paramString3, paramLong, paramSupplier);
/*     */     
/* 159 */     aixHWDiskStore.partitionList = Collections.unmodifiableList((List<? extends HWPartition>)Lspv.queryLogicalVolumes(paramString1, paramMap).stream()
/* 160 */         .sorted(Comparator.comparing(HWPartition::getMinor).thenComparing(HWPartition::getName))
/* 161 */         .collect(Collectors.toList()));
/* 162 */     aixHWDiskStore.updateAttributes();
/* 163 */     return aixHWDiskStore;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\aix\AixHWDiskStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */