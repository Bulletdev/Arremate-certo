/*     */ package oshi.hardware.platform.unix.openbsd;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Pointer;
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.VirtualMemory;
/*     */ import oshi.hardware.common.AbstractGlobalMemory;
/*     */ import oshi.jna.platform.unix.openbsd.OpenBsdLibc;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.unix.openbsd.OpenBsdSysctlUtil;
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
/*     */ final class OpenBsdGlobalMemory
/*     */   extends AbstractGlobalMemory
/*     */ {
/*  50 */   private final Supplier<Long> available = Memoizer.memoize(OpenBsdGlobalMemory::queryAvailable, Memoizer.defaultExpiration());
/*     */   
/*  52 */   private final Supplier<Long> total = Memoizer.memoize(OpenBsdGlobalMemory::queryPhysMem);
/*     */   
/*  54 */   private final Supplier<Long> pageSize = Memoizer.memoize(OpenBsdGlobalMemory::queryPageSize);
/*     */   
/*  56 */   private final Supplier<VirtualMemory> vm = Memoizer.memoize(this::createVirtualMemory);
/*     */ 
/*     */   
/*     */   public long getAvailable() {
/*  60 */     return ((Long)this.available.get()).longValue() * getPageSize();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTotal() {
/*  65 */     return ((Long)this.total.get()).longValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPageSize() {
/*  70 */     return ((Long)this.pageSize.get()).longValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public VirtualMemory getVirtualMemory() {
/*  75 */     return this.vm.get();
/*     */   }
/*     */   
/*     */   private static long queryAvailable() {
/*  79 */     long l1 = 0L;
/*  80 */     long l2 = 0L;
/*  81 */     for (String str : ExecutingCommand.runNative("vmstat -s")) {
/*  82 */       if (str.endsWith("pages free")) {
/*  83 */         l1 = ParseUtil.getFirstIntValue(str); continue;
/*  84 */       }  if (str.endsWith("pages inactive")) {
/*  85 */         l2 = ParseUtil.getFirstIntValue(str);
/*     */       }
/*     */     } 
/*  88 */     int[] arrayOfInt = new int[3];
/*  89 */     arrayOfInt[0] = 10;
/*  90 */     arrayOfInt[1] = 0;
/*  91 */     arrayOfInt[2] = 3;
/*  92 */     Memory memory = OpenBsdSysctlUtil.sysctl(arrayOfInt);
/*  93 */     OpenBsdLibc.Bcachestats bcachestats = new OpenBsdLibc.Bcachestats((Pointer)memory);
/*  94 */     return bcachestats.numbufpages + l1 + l2;
/*     */   }
/*     */   
/*     */   private static long queryPhysMem() {
/*  98 */     return OpenBsdSysctlUtil.sysctl("hw.physmem", 0L);
/*     */   }
/*     */   
/*     */   private static long queryPageSize() {
/* 102 */     return OpenBsdSysctlUtil.sysctl("hw.pagesize", 4096L);
/*     */   }
/*     */   
/*     */   private VirtualMemory createVirtualMemory() {
/* 106 */     return (VirtualMemory)new OpenBsdVirtualMemory(this);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\openbsd\OpenBsdGlobalMemory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */