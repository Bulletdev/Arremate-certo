/*     */ package oshi.hardware.platform.unix.solaris;
/*     */ 
/*     */ import com.sun.jna.platform.unix.solaris.LibKstat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.stream.Collectors;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.unix.solaris.disk.Iostat;
/*     */ import oshi.driver.unix.solaris.disk.Lshal;
/*     */ import oshi.driver.unix.solaris.disk.Prtvtoc;
/*     */ import oshi.hardware.HWDiskStore;
/*     */ import oshi.hardware.HWPartition;
/*     */ import oshi.hardware.common.AbstractHWDiskStore;
/*     */ import oshi.util.platform.unix.solaris.KstatUtil;
/*     */ import oshi.util.tuples.Quintet;
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
/*     */ public final class SolarisHWDiskStore
/*     */   extends AbstractHWDiskStore
/*     */ {
/*  54 */   private long reads = 0L;
/*  55 */   private long readBytes = 0L;
/*  56 */   private long writes = 0L;
/*  57 */   private long writeBytes = 0L;
/*  58 */   private long currentQueueLength = 0L;
/*  59 */   private long transferTime = 0L;
/*  60 */   private long timeStamp = 0L;
/*     */   private List<HWPartition> partitionList;
/*     */   
/*     */   private SolarisHWDiskStore(String paramString1, String paramString2, String paramString3, long paramLong) {
/*  64 */     super(paramString1, paramString2, paramString3, paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getReads() {
/*  69 */     return this.reads;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getReadBytes() {
/*  74 */     return this.readBytes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getWrites() {
/*  79 */     return this.writes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getWriteBytes() {
/*  84 */     return this.writeBytes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getCurrentQueueLength() {
/*  89 */     return this.currentQueueLength;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTransferTime() {
/*  94 */     return this.transferTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeStamp() {
/*  99 */     return this.timeStamp;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<HWPartition> getPartitions() {
/* 104 */     return this.partitionList;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 109 */     KstatUtil.KstatChain kstatChain = KstatUtil.openChain(); 
/* 110 */     try { LibKstat.Kstat kstat = KstatUtil.KstatChain.lookup(null, 0, getName());
/* 111 */       if (kstat != null && KstatUtil.KstatChain.read(kstat))
/* 112 */       { LibKstat.KstatIO kstatIO = new LibKstat.KstatIO(kstat.ks_data);
/* 113 */         this.reads = kstatIO.reads;
/* 114 */         this.writes = kstatIO.writes;
/* 115 */         this.readBytes = kstatIO.nread;
/* 116 */         this.writeBytes = kstatIO.nwritten;
/* 117 */         this.currentQueueLength = kstatIO.wcnt + kstatIO.rcnt;
/*     */         
/* 119 */         this.transferTime = kstatIO.rtime / 1000000L;
/* 120 */         this.timeStamp = kstat.ks_snaptime / 1000000L;
/* 121 */         boolean bool = true;
/*     */         
/* 123 */         if (kstatChain != null) kstatChain.close();  return bool; }  if (kstatChain != null) kstatChain.close();  } catch (Throwable throwable) { if (kstatChain != null)
/* 124 */         try { kstatChain.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<HWDiskStore> getDisks() {
/* 135 */     Map map1 = Iostat.queryPartitionToMountMap();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 140 */     Map map2 = Lshal.queryDiskToMajorMap();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 145 */     Map map3 = Iostat.queryDeviceStrings(map1.keySet());
/*     */     
/* 147 */     ArrayList<SolarisHWDiskStore> arrayList = new ArrayList();
/* 148 */     for (Map.Entry entry : map3.entrySet()) {
/* 149 */       String str = (String)entry.getKey();
/* 150 */       Quintet quintet = (Quintet)entry.getValue();
/* 151 */       arrayList.add(createStore(str, (String)quintet.getA(), (String)quintet.getB(), (String)quintet.getC(), (String)quintet.getD(), ((Long)quintet.getE()).longValue(), (String)map1
/* 152 */             .getOrDefault(str, ""), ((Integer)map2.getOrDefault(str, Integer.valueOf(0))).intValue()));
/*     */     } 
/*     */     
/* 155 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static SolarisHWDiskStore createStore(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong, String paramString6, int paramInt) {
/* 161 */     SolarisHWDiskStore solarisHWDiskStore = new SolarisHWDiskStore(paramString1, paramString2.isEmpty() ? (paramString3 + " " + paramString4).trim() : paramString2, paramString5, paramLong);
/* 162 */     solarisHWDiskStore.partitionList = Collections.unmodifiableList((List<? extends HWPartition>)Prtvtoc.queryPartitions(paramString6, paramInt).stream()
/* 163 */         .sorted(Comparator.comparing(HWPartition::getName)).collect(Collectors.toList()));
/* 164 */     solarisHWDiskStore.updateAttributes();
/* 165 */     return solarisHWDiskStore;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\solaris\SolarisHWDiskStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */