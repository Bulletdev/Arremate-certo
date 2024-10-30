/*     */ package oshi.hardware.platform.unix.solaris;
/*     */ 
/*     */ import java.util.function.Supplier;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.unix.solaris.kstat.SystemPages;
/*     */ import oshi.hardware.common.AbstractVirtualMemory;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
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
/*     */ @ThreadSafe
/*     */ final class SolarisVirtualMemory
/*     */   extends AbstractVirtualMemory
/*     */ {
/*  46 */   private static final Pattern SWAP_INFO = Pattern.compile(".+\\s(\\d+)K\\s+(\\d+)K$");
/*     */ 
/*     */   
/*     */   private final SolarisGlobalMemory global;
/*     */   
/*  51 */   private final Supplier<Pair<Long, Long>> availTotal = Memoizer.memoize(SystemPages::queryAvailableTotal, 
/*  52 */       Memoizer.defaultExpiration());
/*     */ 
/*     */   
/*  55 */   private final Supplier<Pair<Long, Long>> usedTotal = Memoizer.memoize(SolarisVirtualMemory::querySwapInfo, 
/*  56 */       Memoizer.defaultExpiration());
/*     */   
/*  58 */   private final Supplier<Long> pagesIn = Memoizer.memoize(SolarisVirtualMemory::queryPagesIn, Memoizer.defaultExpiration());
/*     */   
/*  60 */   private final Supplier<Long> pagesOut = Memoizer.memoize(SolarisVirtualMemory::queryPagesOut, Memoizer.defaultExpiration());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   SolarisVirtualMemory(SolarisGlobalMemory paramSolarisGlobalMemory) {
/*  69 */     this.global = paramSolarisGlobalMemory;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSwapUsed() {
/*  74 */     return ((Long)((Pair)this.usedTotal.get()).getA()).longValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSwapTotal() {
/*  79 */     return ((Long)((Pair)this.usedTotal.get()).getB()).longValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getVirtualMax() {
/*  84 */     return this.global.getPageSize() * ((Long)((Pair)this.availTotal.get()).getB()).longValue() + getSwapTotal();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getVirtualInUse() {
/*  89 */     return this.global.getPageSize() * (((Long)((Pair)this.availTotal.get()).getB()).longValue() - ((Long)((Pair)this.availTotal.get()).getA()).longValue()) + getSwapUsed();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSwapPagesIn() {
/*  94 */     return ((Long)this.pagesIn.get()).longValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSwapPagesOut() {
/*  99 */     return ((Long)this.pagesOut.get()).longValue();
/*     */   }
/*     */   
/*     */   private static long queryPagesIn() {
/* 103 */     long l = 0L;
/* 104 */     for (String str : ExecutingCommand.runNative("kstat -p cpu_stat:::pgswapin")) {
/* 105 */       l += ParseUtil.parseLastLong(str, 0L);
/*     */     }
/* 107 */     return l;
/*     */   }
/*     */   
/*     */   private static long queryPagesOut() {
/* 111 */     long l = 0L;
/* 112 */     for (String str : ExecutingCommand.runNative("kstat -p cpu_stat:::pgswapout")) {
/* 113 */       l += ParseUtil.parseLastLong(str, 0L);
/*     */     }
/* 115 */     return l;
/*     */   }
/*     */   
/*     */   private static Pair<Long, Long> querySwapInfo() {
/* 119 */     long l1 = 0L;
/* 120 */     long l2 = 0L;
/* 121 */     String str = ExecutingCommand.getAnswerAt("swap -lk", 1);
/* 122 */     Matcher matcher = SWAP_INFO.matcher(str);
/* 123 */     if (matcher.matches()) {
/* 124 */       l1 = ParseUtil.parseLongOrDefault(matcher.group(1), 0L) << 10L;
/* 125 */       l2 = l1 - (ParseUtil.parseLongOrDefault(matcher.group(2), 0L) << 10L);
/*     */     } 
/* 127 */     return new Pair(Long.valueOf(l2), Long.valueOf(l1));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\solaris\SolarisVirtualMemory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */