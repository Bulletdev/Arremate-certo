/*    */ package oshi.hardware.platform.unix.aix;
/*    */ 
/*    */ import com.sun.jna.platform.unix.aix.Perfstat;
/*    */ import java.util.function.Supplier;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.hardware.common.AbstractVirtualMemory;
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
/*    */ final class AixVirtualMemory
/*    */   extends AbstractVirtualMemory
/*    */ {
/*    */   private final Supplier<Perfstat.perfstat_memory_total_t> perfstatMem;
/*    */   private static final long PAGESIZE = 4096L;
/*    */   
/*    */   AixVirtualMemory(Supplier<Perfstat.perfstat_memory_total_t> paramSupplier) {
/* 53 */     this.perfstatMem = paramSupplier;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getSwapUsed() {
/* 58 */     Perfstat.perfstat_memory_total_t perfstat_memory_total_t = this.perfstatMem.get();
/* 59 */     return (perfstat_memory_total_t.pgsp_total - perfstat_memory_total_t.pgsp_free) * 4096L;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getSwapTotal() {
/* 64 */     return ((Perfstat.perfstat_memory_total_t)this.perfstatMem.get()).pgsp_total * 4096L;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getVirtualMax() {
/* 69 */     return ((Perfstat.perfstat_memory_total_t)this.perfstatMem.get()).virt_total * 4096L;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getVirtualInUse() {
/* 74 */     return ((Perfstat.perfstat_memory_total_t)this.perfstatMem.get()).virt_active * 4096L;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getSwapPagesIn() {
/* 79 */     return ((Perfstat.perfstat_memory_total_t)this.perfstatMem.get()).pgspins;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getSwapPagesOut() {
/* 84 */     return ((Perfstat.perfstat_memory_total_t)this.perfstatMem.get()).pgspouts;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\aix\AixVirtualMemory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */