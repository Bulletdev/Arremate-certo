/*     */ package oshi.hardware.common;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.function.Supplier;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.CentralProcessor;
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
/*     */ public abstract class AbstractCentralProcessor
/*     */   implements CentralProcessor
/*     */ {
/*  49 */   private static final Logger LOG = LoggerFactory.getLogger(AbstractCentralProcessor.class);
/*     */   
/*  51 */   private final Supplier<CentralProcessor.ProcessorIdentifier> cpuid = Memoizer.memoize(this::queryProcessorId);
/*  52 */   private final Supplier<Long> maxFreq = Memoizer.memoize(this::queryMaxFreq, Memoizer.defaultExpiration());
/*  53 */   private final Supplier<long[]> currentFreq = Memoizer.memoize(this::queryCurrentFreq, Memoizer.defaultExpiration());
/*  54 */   private final Supplier<Long> contextSwitches = Memoizer.memoize(this::queryContextSwitches, Memoizer.defaultExpiration());
/*  55 */   private final Supplier<Long> interrupts = Memoizer.memoize(this::queryInterrupts, Memoizer.defaultExpiration());
/*     */   
/*  57 */   private final Supplier<long[]> systemCpuLoadTicks = Memoizer.memoize(this::querySystemCpuLoadTicks, Memoizer.defaultExpiration());
/*  58 */   private final Supplier<long[][]> processorCpuLoadTicks = Memoizer.memoize(this::queryProcessorCpuLoadTicks, 
/*  59 */       Memoizer.defaultExpiration());
/*     */ 
/*     */   
/*     */   private final int physicalPackageCount;
/*     */ 
/*     */   
/*     */   private final int physicalProcessorCount;
/*     */ 
/*     */   
/*     */   private final int logicalProcessorCount;
/*     */   
/*     */   private final List<CentralProcessor.LogicalProcessor> logicalProcessors;
/*     */ 
/*     */   
/*     */   protected AbstractCentralProcessor() {
/*  74 */     this.logicalProcessors = Collections.unmodifiableList(initProcessorCounts());
/*     */     
/*  76 */     HashSet<String> hashSet = new HashSet();
/*  77 */     HashSet<Integer> hashSet1 = new HashSet();
/*  78 */     for (CentralProcessor.LogicalProcessor logicalProcessor : this.logicalProcessors) {
/*  79 */       int i = logicalProcessor.getPhysicalPackageNumber();
/*  80 */       hashSet.add(logicalProcessor.getPhysicalProcessorNumber() + ":" + i);
/*  81 */       hashSet1.add(Integer.valueOf(i));
/*     */     } 
/*  83 */     this.logicalProcessorCount = this.logicalProcessors.size();
/*  84 */     this.physicalProcessorCount = hashSet.size();
/*  85 */     this.physicalPackageCount = hashSet1.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract List<CentralProcessor.LogicalProcessor> initProcessorCounts();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract CentralProcessor.ProcessorIdentifier queryProcessorId();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CentralProcessor.ProcessorIdentifier getProcessorIdentifier() {
/* 104 */     return this.cpuid.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMaxFreq() {
/* 109 */     return ((Long)this.maxFreq.get()).longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract long queryMaxFreq();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long[] getCurrentFreq() {
/* 121 */     long[] arrayOfLong1 = this.currentFreq.get();
/* 122 */     if (arrayOfLong1.length == getLogicalProcessorCount()) {
/* 123 */       return arrayOfLong1;
/*     */     }
/* 125 */     long[] arrayOfLong2 = new long[getLogicalProcessorCount()];
/* 126 */     Arrays.fill(arrayOfLong2, arrayOfLong1[0]);
/* 127 */     return arrayOfLong2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract long[] queryCurrentFreq();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getContextSwitches() {
/* 139 */     return ((Long)this.contextSwitches.get()).longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract long queryContextSwitches();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getInterrupts() {
/* 151 */     return ((Long)this.interrupts.get()).longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract long queryInterrupts();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<CentralProcessor.LogicalProcessor> getLogicalProcessors() {
/* 163 */     return this.logicalProcessors;
/*     */   }
/*     */ 
/*     */   
/*     */   public long[] getSystemCpuLoadTicks() {
/* 168 */     return this.systemCpuLoadTicks.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract long[] querySystemCpuLoadTicks();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long[][] getProcessorCpuLoadTicks() {
/* 180 */     return this.processorCpuLoadTicks.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract long[][] queryProcessorCpuLoadTicks();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getSystemCpuLoadBetweenTicks(long[] paramArrayOflong) {
/* 192 */     if (paramArrayOflong.length != (CentralProcessor.TickType.values()).length) {
/* 193 */       throw new IllegalArgumentException("Tick array " + paramArrayOflong.length + " should have " + (
/* 194 */           CentralProcessor.TickType.values()).length + " elements");
/*     */     }
/* 196 */     long[] arrayOfLong = getSystemCpuLoadTicks();
/*     */     
/* 198 */     long l1 = 0L;
/* 199 */     for (byte b = 0; b < arrayOfLong.length; b++) {
/* 200 */       l1 += arrayOfLong[b] - paramArrayOflong[b];
/*     */     }
/*     */ 
/*     */     
/* 204 */     long l2 = arrayOfLong[CentralProcessor.TickType.IDLE.getIndex()] + arrayOfLong[CentralProcessor.TickType.IOWAIT.getIndex()] - paramArrayOflong[CentralProcessor.TickType.IDLE.getIndex()] - paramArrayOflong[CentralProcessor.TickType.IOWAIT.getIndex()];
/* 205 */     LOG.trace("Total ticks: {}  Idle ticks: {}", Long.valueOf(l1), Long.valueOf(l2));
/*     */     
/* 207 */     return (l1 > 0L && l2 >= 0L) ? ((l1 - l2) / l1) : 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double[] getProcessorCpuLoadBetweenTicks(long[][] paramArrayOflong) {
/* 212 */     if (paramArrayOflong.length != this.logicalProcessorCount || (paramArrayOflong[0]).length != (CentralProcessor.TickType.values()).length) {
/* 213 */       throw new IllegalArgumentException("Tick array " + paramArrayOflong.length + " should have " + this.logicalProcessorCount + " arrays, each of which has " + (
/*     */           
/* 215 */           CentralProcessor.TickType.values()).length + " elements");
/*     */     }
/* 217 */     long[][] arrayOfLong = getProcessorCpuLoadTicks();
/* 218 */     double[] arrayOfDouble = new double[this.logicalProcessorCount];
/* 219 */     for (byte b = 0; b < this.logicalProcessorCount; b++) {
/* 220 */       long l1 = 0L;
/* 221 */       for (byte b1 = 0; b1 < (arrayOfLong[b]).length; b1++) {
/* 222 */         l1 += arrayOfLong[b][b1] - paramArrayOflong[b][b1];
/*     */       }
/*     */ 
/*     */       
/* 226 */       long l2 = arrayOfLong[b][CentralProcessor.TickType.IDLE.getIndex()] + arrayOfLong[b][CentralProcessor.TickType.IOWAIT.getIndex()] - paramArrayOflong[b][CentralProcessor.TickType.IDLE.getIndex()] - paramArrayOflong[b][CentralProcessor.TickType.IOWAIT.getIndex()];
/* 227 */       LOG.trace("CPU: {}  Total ticks: {}  Idle ticks: {}", new Object[] { Integer.valueOf(b), Long.valueOf(l1), Long.valueOf(l2) });
/*     */       
/* 229 */       arrayOfDouble[b] = (l1 > 0L && l2 >= 0L) ? ((l1 - l2) / l1) : 0.0D;
/*     */     } 
/* 231 */     return arrayOfDouble;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLogicalProcessorCount() {
/* 236 */     return this.logicalProcessorCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPhysicalProcessorCount() {
/* 241 */     return this.physicalProcessorCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPhysicalPackageCount() {
/* 246 */     return this.physicalPackageCount;
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
/*     */   protected static String createProcessorID(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString) {
/* 264 */     long l1 = 0L;
/* 265 */     long l2 = ParseUtil.parseLongOrDefault(paramString1, 0L);
/* 266 */     long l3 = ParseUtil.parseLongOrDefault(paramString2, 0L);
/* 267 */     long l4 = ParseUtil.parseLongOrDefault(paramString3, 0L);
/*     */     
/* 269 */     l1 |= l2 & 0xFL;
/*     */     
/* 271 */     l1 |= (l3 & 0xFL) << 4L;
/* 272 */     l1 |= (l3 & 0xF0L) << 16L;
/*     */     
/* 274 */     l1 |= (l4 & 0xFL) << 8L;
/* 275 */     l1 |= (l4 & 0xF0L) << 20L;
/*     */     
/* 277 */     for (String str : paramArrayOfString) {
/* 278 */       switch (str) {
/*     */         case "fpu":
/* 280 */           l1 |= 0x100000000L;
/*     */           break;
/*     */         case "vme":
/* 283 */           l1 |= 0x200000000L;
/*     */           break;
/*     */         case "de":
/* 286 */           l1 |= 0x400000000L;
/*     */           break;
/*     */         case "pse":
/* 289 */           l1 |= 0x800000000L;
/*     */           break;
/*     */         case "tsc":
/* 292 */           l1 |= 0x1000000000L;
/*     */           break;
/*     */         case "msr":
/* 295 */           l1 |= 0x2000000000L;
/*     */           break;
/*     */         case "pae":
/* 298 */           l1 |= 0x4000000000L;
/*     */           break;
/*     */         case "mce":
/* 301 */           l1 |= 0x8000000000L;
/*     */           break;
/*     */         case "cx8":
/* 304 */           l1 |= 0x10000000000L;
/*     */           break;
/*     */         case "apic":
/* 307 */           l1 |= 0x20000000000L;
/*     */           break;
/*     */         case "sep":
/* 310 */           l1 |= 0x80000000000L;
/*     */           break;
/*     */         case "mtrr":
/* 313 */           l1 |= 0x100000000000L;
/*     */           break;
/*     */         case "pge":
/* 316 */           l1 |= 0x200000000000L;
/*     */           break;
/*     */         case "mca":
/* 319 */           l1 |= 0x400000000000L;
/*     */           break;
/*     */         case "cmov":
/* 322 */           l1 |= 0x800000000000L;
/*     */           break;
/*     */         case "pat":
/* 325 */           l1 |= 0x1000000000000L;
/*     */           break;
/*     */         case "pse-36":
/* 328 */           l1 |= 0x2000000000000L;
/*     */           break;
/*     */         case "psn":
/* 331 */           l1 |= 0x4000000000000L;
/*     */           break;
/*     */         case "clfsh":
/* 334 */           l1 |= 0x8000000000000L;
/*     */           break;
/*     */         case "ds":
/* 337 */           l1 |= 0x20000000000000L;
/*     */           break;
/*     */         case "acpi":
/* 340 */           l1 |= 0x40000000000000L;
/*     */           break;
/*     */         case "mmx":
/* 343 */           l1 |= 0x80000000000000L;
/*     */           break;
/*     */         case "fxsr":
/* 346 */           l1 |= 0x100000000000000L;
/*     */           break;
/*     */         case "sse":
/* 349 */           l1 |= 0x200000000000000L;
/*     */           break;
/*     */         case "sse2":
/* 352 */           l1 |= 0x400000000000000L;
/*     */           break;
/*     */         case "ss":
/* 355 */           l1 |= 0x800000000000000L;
/*     */           break;
/*     */         case "htt":
/* 358 */           l1 |= 0x1000000000000000L;
/*     */           break;
/*     */         case "tm":
/* 361 */           l1 |= 0x2000000000000000L;
/*     */           break;
/*     */         case "ia64":
/* 364 */           l1 |= 0x4000000000000000L;
/*     */           break;
/*     */         case "pbe":
/* 367 */           l1 |= Long.MIN_VALUE;
/*     */           break;
/*     */       } 
/*     */ 
/*     */     
/*     */     } 
/* 373 */     return String.format("%016X", new Object[] { Long.valueOf(l1) });
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 378 */     StringBuilder stringBuilder = new StringBuilder(getProcessorIdentifier().getName());
/* 379 */     stringBuilder.append("\n ").append(getPhysicalPackageCount()).append(" physical CPU package(s)");
/* 380 */     stringBuilder.append("\n ").append(getPhysicalProcessorCount()).append(" physical CPU core(s)");
/* 381 */     stringBuilder.append("\n ").append(getLogicalProcessorCount()).append(" logical CPU(s)");
/* 382 */     stringBuilder.append('\n').append("Identifier: ").append(getProcessorIdentifier().getIdentifier());
/* 383 */     stringBuilder.append('\n').append("ProcessorID: ").append(getProcessorIdentifier().getProcessorID());
/* 384 */     stringBuilder.append('\n').append("Microarchitecture: ").append(getProcessorIdentifier().getMicroarchitecture());
/* 385 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\common\AbstractCentralProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */