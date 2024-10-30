/*     */ package oshi.hardware.platform.mac;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.platform.mac.SystemB;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import java.util.function.Supplier;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.common.AbstractVirtualMemory;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.mac.SysctlUtil;
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
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ final class MacVirtualMemory
/*     */   extends AbstractVirtualMemory
/*     */ {
/*  52 */   private static final Logger LOG = LoggerFactory.getLogger(MacVirtualMemory.class);
/*     */   
/*     */   private final MacGlobalMemory global;
/*     */   
/*  56 */   private final Supplier<Pair<Long, Long>> usedTotal = Memoizer.memoize(MacVirtualMemory::querySwapUsage, Memoizer.defaultExpiration());
/*     */   
/*  58 */   private final Supplier<Pair<Long, Long>> inOut = Memoizer.memoize(MacVirtualMemory::queryVmStat, Memoizer.defaultExpiration());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   MacVirtualMemory(MacGlobalMemory paramMacGlobalMemory) {
/*  67 */     this.global = paramMacGlobalMemory;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSwapUsed() {
/*  72 */     return ((Long)((Pair)this.usedTotal.get()).getA()).longValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSwapTotal() {
/*  77 */     return ((Long)((Pair)this.usedTotal.get()).getB()).longValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getVirtualMax() {
/*  82 */     return this.global.getTotal() + getSwapTotal();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getVirtualInUse() {
/*  87 */     return this.global.getTotal() - this.global.getAvailable() + getSwapUsed();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSwapPagesIn() {
/*  92 */     return ((Long)((Pair)this.inOut.get()).getA()).longValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSwapPagesOut() {
/*  97 */     return ((Long)((Pair)this.inOut.get()).getB()).longValue();
/*     */   }
/*     */   
/*     */   private static Pair<Long, Long> querySwapUsage() {
/* 101 */     long l1 = 0L;
/* 102 */     long l2 = 0L;
/* 103 */     SystemB.XswUsage xswUsage = new SystemB.XswUsage();
/* 104 */     if (SysctlUtil.sysctl("vm.swapusage", (Structure)xswUsage)) {
/* 105 */       l1 = xswUsage.xsu_used;
/* 106 */       l2 = xswUsage.xsu_total;
/*     */     } 
/* 108 */     return new Pair(Long.valueOf(l1), Long.valueOf(l2));
/*     */   }
/*     */   
/*     */   private static Pair<Long, Long> queryVmStat() {
/* 112 */     long l1 = 0L;
/* 113 */     long l2 = 0L;
/* 114 */     SystemB.VMStatistics vMStatistics = new SystemB.VMStatistics();
/* 115 */     if (0 == SystemB.INSTANCE.host_statistics(SystemB.INSTANCE.mach_host_self(), 2, (Structure)vMStatistics, new IntByReference(vMStatistics
/* 116 */           .size() / SystemB.INT_SIZE))) {
/* 117 */       l1 = ParseUtil.unsignedIntToLong(vMStatistics.pageins);
/* 118 */       l2 = ParseUtil.unsignedIntToLong(vMStatistics.pageouts);
/*     */     } else {
/* 120 */       LOG.error("Failed to get host VM info. Error code: {}", Integer.valueOf(Native.getLastError()));
/*     */     } 
/* 122 */     return new Pair(Long.valueOf(l1), Long.valueOf(l2));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\mac\MacVirtualMemory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */