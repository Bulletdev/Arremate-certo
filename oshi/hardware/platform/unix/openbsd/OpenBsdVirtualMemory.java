/*     */ package oshi.hardware.platform.unix.openbsd;
/*     */ 
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.common.AbstractVirtualMemory;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
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
/*     */ final class OpenBsdVirtualMemory
/*     */   extends AbstractVirtualMemory
/*     */ {
/*     */   OpenBsdGlobalMemory global;
/*  45 */   private final Supplier<Triplet<Integer, Integer, Integer>> usedTotalPgin = Memoizer.memoize(OpenBsdVirtualMemory::queryVmstat, 
/*  46 */       Memoizer.defaultExpiration());
/*  47 */   private final Supplier<Integer> pgout = Memoizer.memoize(OpenBsdVirtualMemory::queryUvm, Memoizer.defaultExpiration());
/*     */   
/*     */   OpenBsdVirtualMemory(OpenBsdGlobalMemory paramOpenBsdGlobalMemory) {
/*  50 */     this.global = paramOpenBsdGlobalMemory;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSwapUsed() {
/*  55 */     return ((Integer)((Triplet)this.usedTotalPgin.get()).getA()).intValue() * this.global.getPageSize();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSwapTotal() {
/*  60 */     return ((Integer)((Triplet)this.usedTotalPgin.get()).getB()).intValue() * this.global.getPageSize();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getVirtualMax() {
/*  65 */     return this.global.getTotal() + getSwapTotal();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getVirtualInUse() {
/*  70 */     return this.global.getTotal() - this.global.getAvailable() + getSwapUsed();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSwapPagesIn() {
/*  75 */     return ((Integer)((Triplet)this.usedTotalPgin.get()).getC()).intValue() * this.global.getPageSize();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSwapPagesOut() {
/*  80 */     return ((Integer)this.pgout.get()).intValue() * this.global.getPageSize();
/*     */   }
/*     */   
/*     */   private static Triplet<Integer, Integer, Integer> queryVmstat() {
/*  84 */     int i = 0;
/*  85 */     int j = 0;
/*  86 */     int k = 0;
/*  87 */     for (String str : ExecutingCommand.runNative("vmstat -s")) {
/*  88 */       if (str.contains("swap pages in use")) {
/*  89 */         i = ParseUtil.getFirstIntValue(str); continue;
/*  90 */       }  if (str.contains("swap pages")) {
/*  91 */         j = ParseUtil.getFirstIntValue(str); continue;
/*  92 */       }  if (str.contains("pagein operations")) {
/*  93 */         k = ParseUtil.getFirstIntValue(str);
/*     */       }
/*     */     } 
/*  96 */     return new Triplet(Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k));
/*     */   }
/*     */   
/*     */   private static int queryUvm() {
/* 100 */     for (String str : ExecutingCommand.runNative("systat -ab uvm")) {
/* 101 */       if (str.contains("pdpageouts"))
/*     */       {
/* 103 */         return ParseUtil.getFirstIntValue(str);
/*     */       }
/*     */     } 
/* 106 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\openbsd\OpenBsdVirtualMemory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */