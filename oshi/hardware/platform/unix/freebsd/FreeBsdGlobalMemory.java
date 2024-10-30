/*    */ package oshi.hardware.platform.unix.freebsd;
/*    */ 
/*    */ import java.util.function.Supplier;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.hardware.VirtualMemory;
/*    */ import oshi.hardware.common.AbstractGlobalMemory;
/*    */ import oshi.util.ExecutingCommand;
/*    */ import oshi.util.Memoizer;
/*    */ import oshi.util.ParseUtil;
/*    */ import oshi.util.platform.unix.freebsd.BsdSysctlUtil;
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
/*    */ final class FreeBsdGlobalMemory
/*    */   extends AbstractGlobalMemory
/*    */ {
/* 44 */   private final Supplier<Long> available = Memoizer.memoize(this::queryVmStats, Memoizer.defaultExpiration());
/*    */   
/* 46 */   private final Supplier<Long> total = Memoizer.memoize(FreeBsdGlobalMemory::queryPhysMem);
/*    */   
/* 48 */   private final Supplier<Long> pageSize = Memoizer.memoize(FreeBsdGlobalMemory::queryPageSize);
/*    */   
/* 50 */   private final Supplier<VirtualMemory> vm = Memoizer.memoize(this::createVirtualMemory);
/*    */ 
/*    */   
/*    */   public long getAvailable() {
/* 54 */     return ((Long)this.available.get()).longValue();
/*    */   }
/*    */ 
/*    */   
/*    */   public long getTotal() {
/* 59 */     return ((Long)this.total.get()).longValue();
/*    */   }
/*    */ 
/*    */   
/*    */   public long getPageSize() {
/* 64 */     return ((Long)this.pageSize.get()).longValue();
/*    */   }
/*    */ 
/*    */   
/*    */   public VirtualMemory getVirtualMemory() {
/* 69 */     return this.vm.get();
/*    */   }
/*    */ 
/*    */   
/*    */   private long queryVmStats() {
/* 74 */     int i = BsdSysctlUtil.sysctl("vm.stats.vm.v_inactive_count", 0);
/* 75 */     int j = BsdSysctlUtil.sysctl("vm.stats.vm.v_free_count", 0);
/* 76 */     return (i + j) * getPageSize();
/*    */   }
/*    */   
/*    */   private static long queryPhysMem() {
/* 80 */     return BsdSysctlUtil.sysctl("hw.physmem", 0L);
/*    */   }
/*    */ 
/*    */   
/*    */   private static long queryPageSize() {
/* 85 */     return ParseUtil.parseLongOrDefault(ExecutingCommand.getFirstAnswer("sysconf PAGESIZE"), 4096L);
/*    */   }
/*    */   
/*    */   private VirtualMemory createVirtualMemory() {
/* 89 */     return (VirtualMemory)new FreeBsdVirtualMemory(this);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\freebsd\FreeBsdGlobalMemory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */