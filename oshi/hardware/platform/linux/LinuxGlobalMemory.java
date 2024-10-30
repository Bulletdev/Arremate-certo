/*     */ package oshi.hardware.platform.linux;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.VirtualMemory;
/*     */ import oshi.hardware.common.AbstractGlobalMemory;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.FileUtil;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.linux.ProcPath;
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
/*     */ public final class LinuxGlobalMemory
/*     */   extends AbstractGlobalMemory
/*     */ {
/*  48 */   public static final long PAGE_SIZE = ParseUtil.parseLongOrDefault(ExecutingCommand.getFirstAnswer("getconf PAGE_SIZE"), 4096L);
/*     */   
/*  50 */   private final Supplier<Pair<Long, Long>> availTotal = Memoizer.memoize(LinuxGlobalMemory::readMemInfo, Memoizer.defaultExpiration());
/*     */   
/*  52 */   private final Supplier<VirtualMemory> vm = Memoizer.memoize(this::createVirtualMemory);
/*     */ 
/*     */   
/*     */   public long getAvailable() {
/*  56 */     return ((Long)((Pair)this.availTotal.get()).getA()).longValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTotal() {
/*  61 */     return ((Long)((Pair)this.availTotal.get()).getB()).longValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPageSize() {
/*  66 */     return PAGE_SIZE;
/*     */   }
/*     */ 
/*     */   
/*     */   public VirtualMemory getVirtualMemory() {
/*  71 */     return this.vm.get();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Pair<Long, Long> readMemInfo() {
/*  89 */     long l1 = 0L;
/*  90 */     long l2 = 0L;
/*  91 */     long l3 = 0L;
/*  92 */     long l4 = 0L;
/*     */     
/*  94 */     long l5 = 0L;
/*     */ 
/*     */     
/*  97 */     List list = FileUtil.readFile(ProcPath.MEMINFO);
/*  98 */     for (String str : list) {
/*  99 */       String[] arrayOfString = ParseUtil.whitespaces.split(str, 2);
/* 100 */       if (arrayOfString.length > 1) {
/* 101 */         long l; switch (arrayOfString[0]) {
/*     */           case "MemTotal:":
/* 103 */             l5 = ParseUtil.parseDecimalMemorySizeToBinary(arrayOfString[1]);
/*     */           
/*     */           case "MemAvailable:":
/* 106 */             l = ParseUtil.parseDecimalMemorySizeToBinary(arrayOfString[1]);
/*     */             
/* 108 */             return new Pair(Long.valueOf(l), Long.valueOf(l5));
/*     */           case "MemFree:":
/* 110 */             l1 = ParseUtil.parseDecimalMemorySizeToBinary(arrayOfString[1]);
/*     */           
/*     */           case "Active(file):":
/* 113 */             l2 = ParseUtil.parseDecimalMemorySizeToBinary(arrayOfString[1]);
/*     */           
/*     */           case "Inactive(file):":
/* 116 */             l3 = ParseUtil.parseDecimalMemorySizeToBinary(arrayOfString[1]);
/*     */           
/*     */           case "SReclaimable:":
/* 119 */             l4 = ParseUtil.parseDecimalMemorySizeToBinary(arrayOfString[1]);
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       } 
/*     */     } 
/* 128 */     return new Pair(Long.valueOf(l1 + l2 + l3 + l4), Long.valueOf(l5));
/*     */   }
/*     */   
/*     */   private VirtualMemory createVirtualMemory() {
/* 132 */     return (VirtualMemory)new LinuxVirtualMemory(this);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\linux\LinuxGlobalMemory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */