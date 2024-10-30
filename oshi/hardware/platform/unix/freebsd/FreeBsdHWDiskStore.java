/*     */ package oshi.hardware.platform.unix.freebsd;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.stream.Collectors;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.unix.freebsd.disk.GeomDiskList;
/*     */ import oshi.driver.unix.freebsd.disk.GeomPartList;
/*     */ import oshi.hardware.HWDiskStore;
/*     */ import oshi.hardware.HWPartition;
/*     */ import oshi.hardware.common.AbstractHWDiskStore;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.unix.freebsd.BsdSysctlUtil;
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
/*     */ @ThreadSafe
/*     */ public final class FreeBsdHWDiskStore
/*     */   extends AbstractHWDiskStore
/*     */ {
/*  52 */   private long reads = 0L;
/*  53 */   private long readBytes = 0L;
/*  54 */   private long writes = 0L;
/*  55 */   private long writeBytes = 0L;
/*  56 */   private long currentQueueLength = 0L;
/*  57 */   private long transferTime = 0L;
/*  58 */   private long timeStamp = 0L;
/*     */   private List<HWPartition> partitionList;
/*     */   
/*     */   private FreeBsdHWDiskStore(String paramString1, String paramString2, String paramString3, long paramLong) {
/*  62 */     super(paramString1, paramString2, paramString3, paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getReads() {
/*  67 */     return this.reads;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getReadBytes() {
/*  72 */     return this.readBytes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getWrites() {
/*  77 */     return this.writes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getWriteBytes() {
/*  82 */     return this.writeBytes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getCurrentQueueLength() {
/*  87 */     return this.currentQueueLength;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTransferTime() {
/*  92 */     return this.transferTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeStamp() {
/*  97 */     return this.timeStamp;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<HWPartition> getPartitions() {
/* 102 */     return this.partitionList;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 107 */     List list = ExecutingCommand.runNative("iostat -Ix " + getName());
/* 108 */     long l = System.currentTimeMillis();
/* 109 */     boolean bool = false;
/* 110 */     for (String str : list) {
/* 111 */       String[] arrayOfString = ParseUtil.whitespaces.split(str);
/* 112 */       if (arrayOfString.length < 7 || !arrayOfString[0].equals(getName())) {
/*     */         continue;
/*     */       }
/* 115 */       bool = true;
/* 116 */       this.reads = (long)ParseUtil.parseDoubleOrDefault(arrayOfString[1], 0.0D);
/* 117 */       this.writes = (long)ParseUtil.parseDoubleOrDefault(arrayOfString[2], 0.0D);
/*     */       
/* 119 */       this.readBytes = (long)(ParseUtil.parseDoubleOrDefault(arrayOfString[3], 0.0D) * 1024.0D);
/* 120 */       this.writeBytes = (long)(ParseUtil.parseDoubleOrDefault(arrayOfString[4], 0.0D) * 1024.0D);
/*     */       
/* 122 */       this.currentQueueLength = ParseUtil.parseLongOrDefault(arrayOfString[5], 0L);
/*     */       
/* 124 */       this.transferTime = (long)(ParseUtil.parseDoubleOrDefault(arrayOfString[6], 0.0D) * 1000.0D);
/* 125 */       this.timeStamp = l;
/*     */     } 
/* 127 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<HWDiskStore> getDisks() {
/* 137 */     ArrayList<FreeBsdHWDiskStore> arrayList = new ArrayList();
/*     */ 
/*     */     
/* 140 */     Map map1 = GeomPartList.queryPartitions();
/*     */ 
/*     */     
/* 143 */     Map map2 = GeomDiskList.queryDisks();
/*     */ 
/*     */     
/* 146 */     List<String> list = Arrays.asList(ParseUtil.whitespaces.split(BsdSysctlUtil.sysctl("kern.disks", "")));
/*     */ 
/*     */     
/* 149 */     List list1 = ExecutingCommand.runNative("iostat -Ix");
/* 150 */     long l = System.currentTimeMillis();
/* 151 */     for (String str : list1) {
/* 152 */       String[] arrayOfString = ParseUtil.whitespaces.split(str);
/* 153 */       if (arrayOfString.length > 6 && list.contains(arrayOfString[0])) {
/* 154 */         Triplet triplet = (Triplet)map2.get(arrayOfString[0]);
/*     */ 
/*     */         
/* 157 */         FreeBsdHWDiskStore freeBsdHWDiskStore = (triplet == null) ? new FreeBsdHWDiskStore(arrayOfString[0], "unknown", "unknown", 0L) : new FreeBsdHWDiskStore(arrayOfString[0], (String)triplet.getA(), (String)triplet.getB(), ((Long)triplet.getC()).longValue());
/* 158 */         freeBsdHWDiskStore.reads = (long)ParseUtil.parseDoubleOrDefault(arrayOfString[1], 0.0D);
/* 159 */         freeBsdHWDiskStore.writes = (long)ParseUtil.parseDoubleOrDefault(arrayOfString[2], 0.0D);
/*     */         
/* 161 */         freeBsdHWDiskStore.readBytes = (long)(ParseUtil.parseDoubleOrDefault(arrayOfString[3], 0.0D) * 1024.0D);
/* 162 */         freeBsdHWDiskStore.writeBytes = (long)(ParseUtil.parseDoubleOrDefault(arrayOfString[4], 0.0D) * 1024.0D);
/*     */         
/* 164 */         freeBsdHWDiskStore.currentQueueLength = ParseUtil.parseLongOrDefault(arrayOfString[5], 0L);
/*     */         
/* 166 */         freeBsdHWDiskStore.transferTime = (long)(ParseUtil.parseDoubleOrDefault(arrayOfString[6], 0.0D) * 1000.0D);
/* 167 */         freeBsdHWDiskStore
/* 168 */           .partitionList = Collections.unmodifiableList((List<? extends HWPartition>)((List)map1.getOrDefault(arrayOfString[0], Collections.emptyList())).stream()
/* 169 */             .sorted(Comparator.comparing(HWPartition::getName)).collect(Collectors.toList()));
/* 170 */         freeBsdHWDiskStore.timeStamp = l;
/* 171 */         arrayList.add(freeBsdHWDiskStore);
/*     */       } 
/*     */     } 
/* 174 */     return (List)arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\freebsd\FreeBsdHWDiskStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */