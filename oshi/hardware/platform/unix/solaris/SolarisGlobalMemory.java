/*    */ package oshi.hardware.platform.unix.solaris;
/*    */ 
/*    */ import java.util.function.Supplier;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.driver.unix.solaris.kstat.SystemPages;
/*    */ import oshi.hardware.VirtualMemory;
/*    */ import oshi.hardware.common.AbstractGlobalMemory;
/*    */ import oshi.util.ExecutingCommand;
/*    */ import oshi.util.Memoizer;
/*    */ import oshi.util.ParseUtil;
/*    */ import oshi.util.tuples.Pair;
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
/*    */ final class SolarisGlobalMemory
/*    */   extends AbstractGlobalMemory
/*    */ {
/* 45 */   private final Supplier<Pair<Long, Long>> availTotal = Memoizer.memoize(SystemPages::queryAvailableTotal, 
/* 46 */       Memoizer.defaultExpiration());
/*    */   
/* 48 */   private final Supplier<Long> pageSize = Memoizer.memoize(SolarisGlobalMemory::queryPageSize);
/*    */   
/* 50 */   private final Supplier<VirtualMemory> vm = Memoizer.memoize(this::createVirtualMemory);
/*    */ 
/*    */   
/*    */   public long getAvailable() {
/* 54 */     return ((Long)((Pair)this.availTotal.get()).getA()).longValue() * getPageSize();
/*    */   }
/*    */ 
/*    */   
/*    */   public long getTotal() {
/* 59 */     return ((Long)((Pair)this.availTotal.get()).getB()).longValue() * getPageSize();
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
/*    */   private static long queryPageSize() {
/* 73 */     return ParseUtil.parseLongOrDefault(ExecutingCommand.getFirstAnswer("pagesize"), 4096L);
/*    */   }
/*    */   
/*    */   private VirtualMemory createVirtualMemory() {
/* 77 */     return (VirtualMemory)new SolarisVirtualMemory(this);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\solaris\SolarisGlobalMemory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */