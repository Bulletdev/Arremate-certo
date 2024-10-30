/*     */ package oshi.hardware.platform.unix.aix;
/*     */ 
/*     */ import com.sun.jna.platform.unix.aix.Perfstat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.unix.aix.perfstat.PerfstatMemory;
/*     */ import oshi.hardware.PhysicalMemory;
/*     */ import oshi.hardware.VirtualMemory;
/*     */ import oshi.hardware.common.AbstractGlobalMemory;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
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
/*     */ final class AixGlobalMemory
/*     */   extends AbstractGlobalMemory
/*     */ {
/*  49 */   private final Supplier<Perfstat.perfstat_memory_total_t> perfstatMem = Memoizer.memoize(AixGlobalMemory::queryPerfstat, 
/*  50 */       Memoizer.defaultExpiration());
/*     */ 
/*     */   
/*     */   private final Supplier<List<String>> lscfg;
/*     */   
/*     */   private static final long PAGESIZE = 4096L;
/*     */   
/*  57 */   private final Supplier<VirtualMemory> vm = Memoizer.memoize(this::createVirtualMemory);
/*     */   
/*     */   AixGlobalMemory(Supplier<List<String>> paramSupplier) {
/*  60 */     this.lscfg = paramSupplier;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getAvailable() {
/*  65 */     return ((Perfstat.perfstat_memory_total_t)this.perfstatMem.get()).real_avail * 4096L;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTotal() {
/*  70 */     return ((Perfstat.perfstat_memory_total_t)this.perfstatMem.get()).real_total * 4096L;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPageSize() {
/*  75 */     return 4096L;
/*     */   }
/*     */ 
/*     */   
/*     */   public VirtualMemory getVirtualMemory() {
/*  80 */     return this.vm.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<PhysicalMemory> getPhysicalMemory() {
/*  85 */     ArrayList<PhysicalMemory> arrayList = new ArrayList();
/*  86 */     boolean bool = false;
/*  87 */     String str1 = "unknown";
/*  88 */     String str2 = "";
/*  89 */     long l = 0L;
/*  90 */     for (String str3 : this.lscfg.get()) {
/*  91 */       String str4 = str3.trim();
/*  92 */       if (str4.endsWith("memory-module")) {
/*  93 */         bool = true; continue;
/*  94 */       }  if (bool) {
/*  95 */         if (str4.startsWith("Node:")) {
/*  96 */           str1 = str4.substring(5).trim();
/*  97 */           if (str1.startsWith("IBM,"))
/*  98 */             str1 = str1.substring(4);  continue;
/*     */         } 
/* 100 */         if (str4.startsWith("Physical Location:")) {
/* 101 */           str2 = "/" + str4.substring(18).trim(); continue;
/* 102 */         }  if (str4.startsWith("Size")) {
/* 103 */           l = ParseUtil.parseLongOrDefault(ParseUtil.removeLeadingDots(str4.substring(4).trim()), 0L) << 20L; continue;
/*     */         } 
/* 105 */         if (str4.startsWith("Hardware Location Code")) {
/*     */           
/* 107 */           if (l > 0L) {
/* 108 */             arrayList.add(new PhysicalMemory(str1 + str2, l, 0L, "IBM", "unknown"));
/*     */           }
/* 110 */           str1 = "unknown";
/* 111 */           str2 = "";
/* 112 */           l = 0L;
/* 113 */           bool = false;
/*     */         } 
/*     */       } 
/*     */     } 
/* 117 */     return arrayList;
/*     */   }
/*     */   
/*     */   private static Perfstat.perfstat_memory_total_t queryPerfstat() {
/* 121 */     return PerfstatMemory.queryMemoryTotal();
/*     */   }
/*     */   
/*     */   private VirtualMemory createVirtualMemory() {
/* 125 */     return (VirtualMemory)new AixVirtualMemory(this.perfstatMem);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\aix\AixGlobalMemory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */