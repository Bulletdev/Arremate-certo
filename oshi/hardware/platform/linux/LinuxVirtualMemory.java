/*     */ package oshi.hardware.platform.linux;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.common.AbstractVirtualMemory;
/*     */ import oshi.util.FileUtil;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.linux.ProcPath;
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
/*     */ @ThreadSafe
/*     */ final class LinuxVirtualMemory
/*     */   extends AbstractVirtualMemory
/*     */ {
/*     */   private final LinuxGlobalMemory global;
/*  48 */   private final Supplier<Triplet<Long, Long, Long>> usedTotalCommitLim = Memoizer.memoize(LinuxVirtualMemory::queryMemInfo, 
/*  49 */       Memoizer.defaultExpiration());
/*     */   
/*  51 */   private final Supplier<Pair<Long, Long>> inOut = Memoizer.memoize(LinuxVirtualMemory::queryVmStat, Memoizer.defaultExpiration());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   LinuxVirtualMemory(LinuxGlobalMemory paramLinuxGlobalMemory) {
/*  60 */     this.global = paramLinuxGlobalMemory;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSwapUsed() {
/*  65 */     return ((Long)((Triplet)this.usedTotalCommitLim.get()).getA()).longValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSwapTotal() {
/*  70 */     return ((Long)((Triplet)this.usedTotalCommitLim.get()).getB()).longValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getVirtualMax() {
/*  75 */     return ((Long)((Triplet)this.usedTotalCommitLim.get()).getC()).longValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getVirtualInUse() {
/*  80 */     return this.global.getTotal() - this.global.getAvailable() + getSwapUsed();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSwapPagesIn() {
/*  85 */     return ((Long)((Pair)this.inOut.get()).getA()).longValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSwapPagesOut() {
/*  90 */     return ((Long)((Pair)this.inOut.get()).getB()).longValue();
/*     */   }
/*     */   
/*     */   private static Triplet<Long, Long, Long> queryMemInfo() {
/*  94 */     long l1 = 0L;
/*  95 */     long l2 = 0L;
/*  96 */     long l3 = 0L;
/*     */     
/*  98 */     List list = FileUtil.readFile(ProcPath.MEMINFO);
/*  99 */     for (String str : list) {
/* 100 */       String[] arrayOfString = ParseUtil.whitespaces.split(str);
/* 101 */       if (arrayOfString.length > 1) {
/* 102 */         switch (arrayOfString[0]) {
/*     */           case "SwapTotal:":
/* 104 */             l2 = parseMeminfo(arrayOfString);
/*     */           
/*     */           case "SwapFree:":
/* 107 */             l1 = parseMeminfo(arrayOfString);
/*     */           
/*     */           case "CommitLimit:":
/* 110 */             l3 = parseMeminfo(arrayOfString);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */     } 
/* 118 */     return new Triplet(Long.valueOf(l2 - l1), Long.valueOf(l2), Long.valueOf(l3));
/*     */   }
/*     */   
/*     */   private static Pair<Long, Long> queryVmStat() {
/* 122 */     long l1 = 0L;
/* 123 */     long l2 = 0L;
/* 124 */     List list = FileUtil.readFile(ProcPath.VMSTAT);
/* 125 */     for (String str : list) {
/* 126 */       String[] arrayOfString = ParseUtil.whitespaces.split(str);
/* 127 */       if (arrayOfString.length > 1) {
/* 128 */         switch (arrayOfString[0]) {
/*     */           case "pswpin":
/* 130 */             l1 = ParseUtil.parseLongOrDefault(arrayOfString[1], 0L);
/*     */           
/*     */           case "pswpout":
/* 133 */             l2 = ParseUtil.parseLongOrDefault(arrayOfString[1], 0L);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */     } 
/* 141 */     return new Pair(Long.valueOf(l1), Long.valueOf(l2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static long parseMeminfo(String[] paramArrayOfString) {
/* 152 */     if (paramArrayOfString.length < 2) {
/* 153 */       return 0L;
/*     */     }
/* 155 */     long l = ParseUtil.parseLongOrDefault(paramArrayOfString[1], 0L);
/* 156 */     if (paramArrayOfString.length > 2 && "kB".equals(paramArrayOfString[2])) {
/* 157 */       l *= 1024L;
/*     */     }
/* 159 */     return l;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\linux\LinuxVirtualMemory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */