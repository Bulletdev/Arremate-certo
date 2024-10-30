/*     */ package oshi.hardware.platform.mac;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.platform.mac.SystemB;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import com.sun.jna.ptr.LongByReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.function.Supplier;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.PhysicalMemory;
/*     */ import oshi.hardware.VirtualMemory;
/*     */ import oshi.hardware.common.AbstractGlobalMemory;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.mac.SysctlUtil;
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
/*     */ final class MacGlobalMemory
/*     */   extends AbstractGlobalMemory
/*     */ {
/*  57 */   private static final Logger LOG = LoggerFactory.getLogger(MacGlobalMemory.class);
/*     */   
/*  59 */   private final Supplier<Long> available = Memoizer.memoize(this::queryVmStats, Memoizer.defaultExpiration());
/*     */   
/*  61 */   private final Supplier<Long> total = Memoizer.memoize(MacGlobalMemory::queryPhysMem);
/*     */   
/*  63 */   private final Supplier<Long> pageSize = Memoizer.memoize(MacGlobalMemory::queryPageSize);
/*     */   
/*  65 */   private final Supplier<VirtualMemory> vm = Memoizer.memoize(this::createVirtualMemory);
/*     */ 
/*     */   
/*     */   public long getAvailable() {
/*  69 */     return ((Long)this.available.get()).longValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTotal() {
/*  74 */     return ((Long)this.total.get()).longValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPageSize() {
/*  79 */     return ((Long)this.pageSize.get()).longValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public VirtualMemory getVirtualMemory() {
/*  84 */     return this.vm.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<PhysicalMemory> getPhysicalMemory() {
/*  89 */     ArrayList<PhysicalMemory> arrayList = new ArrayList();
/*  90 */     List list = ExecutingCommand.runNative("system_profiler SPMemoryDataType");
/*  91 */     byte b = 0;
/*  92 */     String str1 = "unknown";
/*  93 */     long l1 = 0L;
/*  94 */     long l2 = 0L;
/*  95 */     String str2 = "unknown";
/*  96 */     String str3 = "unknown";
/*  97 */     for (String str : list) {
/*  98 */       if (str.trim().startsWith("BANK")) {
/*     */         
/* 100 */         if (b++ > 0) {
/* 101 */           arrayList.add(new PhysicalMemory(str1, l1, l2, str2, str3));
/*     */         }
/* 103 */         str1 = str.trim();
/* 104 */         int i = str1.lastIndexOf(':');
/* 105 */         if (i > 0)
/* 106 */           str1 = str1.substring(0, i - 1);  continue;
/*     */       } 
/* 108 */       if (b > 0) {
/* 109 */         String[] arrayOfString = str.trim().split(":");
/* 110 */         if (arrayOfString.length == 2) {
/* 111 */           switch (arrayOfString[0]) {
/*     */             case "Size":
/* 113 */               l1 = ParseUtil.parseDecimalMemorySizeToBinary(arrayOfString[1].trim());
/*     */             
/*     */             case "Type":
/* 116 */               str3 = arrayOfString[1].trim();
/*     */             
/*     */             case "Speed":
/* 119 */               l2 = ParseUtil.parseHertz(arrayOfString[1]);
/*     */             
/*     */             case "Manufacturer":
/* 122 */               str2 = arrayOfString[1].trim();
/*     */           } 
/*     */ 
/*     */ 
/*     */         
/*     */         }
/*     */       } 
/*     */     } 
/* 130 */     arrayList.add(new PhysicalMemory(str1, l1, l2, str2, str3));
/*     */     
/* 132 */     return arrayList;
/*     */   }
/*     */   
/*     */   private long queryVmStats() {
/* 136 */     SystemB.VMStatistics vMStatistics = new SystemB.VMStatistics();
/* 137 */     if (0 != SystemB.INSTANCE.host_statistics(SystemB.INSTANCE.mach_host_self(), 2, (Structure)vMStatistics, new IntByReference(vMStatistics
/* 138 */           .size() / SystemB.INT_SIZE))) {
/* 139 */       LOG.error("Failed to get host VM info. Error code: {}", Integer.valueOf(Native.getLastError()));
/* 140 */       return 0L;
/*     */     } 
/* 142 */     return (vMStatistics.free_count + vMStatistics.inactive_count) * getPageSize();
/*     */   }
/*     */   
/*     */   private static long queryPhysMem() {
/* 146 */     return SysctlUtil.sysctl("hw.memsize", 0L);
/*     */   }
/*     */   
/*     */   private static long queryPageSize() {
/* 150 */     LongByReference longByReference = new LongByReference();
/* 151 */     if (0 == SystemB.INSTANCE.host_page_size(SystemB.INSTANCE.mach_host_self(), longByReference)) {
/* 152 */       return longByReference.getValue();
/*     */     }
/* 154 */     LOG.error("Failed to get host page size. Error code: {}", Integer.valueOf(Native.getLastError()));
/* 155 */     return 4098L;
/*     */   }
/*     */   
/*     */   private VirtualMemory createVirtualMemory() {
/* 159 */     return (VirtualMemory)new MacVirtualMemory(this);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\mac\MacGlobalMemory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */