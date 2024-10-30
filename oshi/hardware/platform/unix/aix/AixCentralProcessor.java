/*     */ package oshi.hardware.platform.unix.aix;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.platform.unix.aix.Perfstat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.unix.aix.Lssrad;
/*     */ import oshi.driver.unix.aix.perfstat.PerfstatConfig;
/*     */ import oshi.driver.unix.aix.perfstat.PerfstatCpu;
/*     */ import oshi.hardware.CentralProcessor;
/*     */ import oshi.hardware.common.AbstractCentralProcessor;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.FileUtil;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ final class AixCentralProcessor
/*     */   extends AbstractCentralProcessor
/*     */ {
/*  57 */   private final Supplier<Perfstat.perfstat_cpu_total_t> cpuTotal = Memoizer.memoize(PerfstatCpu::queryCpuTotal, Memoizer.defaultExpiration());
/*  58 */   private final Supplier<Perfstat.perfstat_cpu_t[]> cpuProc = Memoizer.memoize(PerfstatCpu::queryCpu, Memoizer.defaultExpiration());
/*  59 */   private static final int SBITS = querySbits();
/*     */ 
/*     */ 
/*     */   
/*     */   private Perfstat.perfstat_partition_config_t config;
/*     */ 
/*     */   
/*  66 */   private static final long USER_HZ = ParseUtil.parseLongOrDefault(ExecutingCommand.getFirstAnswer("getconf CLK_TCK"), 100L);
/*     */ 
/*     */ 
/*     */   
/*     */   protected CentralProcessor.ProcessorIdentifier queryProcessorId() {
/*  71 */     String str1 = "unknown";
/*  72 */     String str2 = "";
/*  73 */     String str3 = "";
/*  74 */     boolean bool = false;
/*     */     
/*  76 */     String str4 = "Processor Type:";
/*  77 */     String str5 = "Processor Version:";
/*  78 */     String str6 = "CPU Type:";
/*  79 */     for (String str : ExecutingCommand.runNative("prtconf")) {
/*  80 */       if (str.startsWith("Processor Type:")) {
/*  81 */         str2 = str.split("Processor Type:")[1].trim();
/*  82 */         if (str2.startsWith("P")) {
/*  83 */           str1 = "IBM"; continue;
/*  84 */         }  if (str2.startsWith("I"))
/*  85 */           str1 = "Intel";  continue;
/*     */       } 
/*  87 */       if (str.startsWith("Processor Version:")) {
/*  88 */         str3 = str.split("Processor Version:")[1].trim(); continue;
/*  89 */       }  if (str.startsWith("CPU Type:")) {
/*  90 */         bool = str.split("CPU Type:")[1].contains("64");
/*     */       }
/*     */     } 
/*     */     
/*  94 */     String str7 = "";
/*  95 */     String str8 = "";
/*  96 */     String str9 = Native.toString(this.config.machineID);
/*  97 */     if (str9.isEmpty()) {
/*  98 */       str9 = ExecutingCommand.getFirstAnswer("uname -m");
/*     */     }
/*     */     
/* 101 */     if (str9.length() > 10) {
/* 102 */       int i = str9.length() - 4;
/* 103 */       int j = str9.length() - 2;
/* 104 */       str7 = str9.substring(i, j);
/* 105 */       str8 = str9.substring(j);
/*     */     } 
/*     */     
/* 108 */     return new CentralProcessor.ProcessorIdentifier(str1, str2, str3, str7, str8, str9, bool, (long)(this.config.processorMHz * 1000000.0D));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<CentralProcessor.LogicalProcessor> initProcessorCounts() {
/* 114 */     this.config = PerfstatConfig.queryConfig();
/*     */     
/* 116 */     int i = (int)this.config.numProcessors.max;
/* 117 */     if (i < 1) {
/* 118 */       i = 1;
/*     */     }
/* 120 */     int j = this.config.lcpus;
/* 121 */     if (j < 1) {
/* 122 */       j = 1;
/*     */     }
/*     */     
/* 125 */     Map map = Lssrad.queryNodesPackages();
/* 126 */     ArrayList<CentralProcessor.LogicalProcessor> arrayList = new ArrayList();
/* 127 */     for (byte b = 0; b < j; b++) {
/* 128 */       Pair pair = (Pair)map.get(Integer.valueOf(b));
/* 129 */       arrayList.add(new CentralProcessor.LogicalProcessor(b, b / i, (pair == null) ? 0 : ((Integer)pair.getB()).intValue(), 
/* 130 */             (pair == null) ? 0 : ((Integer)pair.getA()).intValue()));
/*     */     } 
/* 132 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public long[] querySystemCpuLoadTicks() {
/* 137 */     Perfstat.perfstat_cpu_total_t perfstat_cpu_total_t = this.cpuTotal.get();
/* 138 */     long[] arrayOfLong = new long[(CentralProcessor.TickType.values()).length];
/* 139 */     arrayOfLong[CentralProcessor.TickType.USER.ordinal()] = perfstat_cpu_total_t.user * 1000L / USER_HZ;
/*     */     
/* 141 */     arrayOfLong[CentralProcessor.TickType.SYSTEM.ordinal()] = perfstat_cpu_total_t.sys * 1000L / USER_HZ;
/* 142 */     arrayOfLong[CentralProcessor.TickType.IDLE.ordinal()] = perfstat_cpu_total_t.idle * 1000L / USER_HZ;
/* 143 */     arrayOfLong[CentralProcessor.TickType.IOWAIT.ordinal()] = perfstat_cpu_total_t.wait * 1000L / USER_HZ;
/* 144 */     arrayOfLong[CentralProcessor.TickType.IRQ.ordinal()] = perfstat_cpu_total_t.devintrs * 1000L / USER_HZ;
/* 145 */     arrayOfLong[CentralProcessor.TickType.SOFTIRQ.ordinal()] = perfstat_cpu_total_t.softintrs * 1000L / USER_HZ;
/* 146 */     arrayOfLong[CentralProcessor.TickType.STEAL.ordinal()] = (perfstat_cpu_total_t.idle_stolen_purr + perfstat_cpu_total_t.busy_stolen_purr) * 1000L / USER_HZ;
/* 147 */     return arrayOfLong;
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
/*     */   public long[] queryCurrentFreq() {
/* 159 */     long[] arrayOfLong = new long[getLogicalProcessorCount()];
/* 160 */     Arrays.fill(arrayOfLong, -1L);
/* 161 */     String str = "runs at";
/* 162 */     byte b = 0;
/* 163 */     for (String str1 : ExecutingCommand.runNative("pmcycles -m")) {
/* 164 */       if (str1.contains(str)) {
/* 165 */         arrayOfLong[b++] = ParseUtil.parseHertz(str1.split(str)[1].trim());
/* 166 */         if (b >= arrayOfLong.length) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } 
/* 171 */     return arrayOfLong;
/*     */   }
/*     */ 
/*     */   
/*     */   protected long queryMaxFreq() {
/* 176 */     Perfstat.perfstat_cpu_total_t perfstat_cpu_total_t = this.cpuTotal.get();
/* 177 */     return perfstat_cpu_total_t.processorHZ;
/*     */   }
/*     */ 
/*     */   
/*     */   public double[] getSystemLoadAverage(int paramInt) {
/* 182 */     if (paramInt < 1 || paramInt > 3) {
/* 183 */       throw new IllegalArgumentException("Must include from one to three elements.");
/*     */     }
/* 185 */     double[] arrayOfDouble = new double[paramInt];
/* 186 */     long[] arrayOfLong = ((Perfstat.perfstat_cpu_total_t)this.cpuTotal.get()).loadavg;
/* 187 */     for (byte b = 0; b < paramInt; b++) {
/* 188 */       arrayOfDouble[b] = arrayOfLong[b] / (1L << SBITS);
/*     */     }
/* 190 */     return arrayOfDouble;
/*     */   }
/*     */ 
/*     */   
/*     */   public long[][] queryProcessorCpuLoadTicks() {
/* 195 */     Perfstat.perfstat_cpu_t[] arrayOfPerfstat_cpu_t = this.cpuProc.get();
/* 196 */     long[][] arrayOfLong = new long[arrayOfPerfstat_cpu_t.length][(CentralProcessor.TickType.values()).length];
/* 197 */     for (byte b = 0; b < arrayOfPerfstat_cpu_t.length; b++) {
/* 198 */       arrayOfLong[b] = new long[(CentralProcessor.TickType.values()).length];
/* 199 */       arrayOfLong[b][CentralProcessor.TickType.USER.ordinal()] = (arrayOfPerfstat_cpu_t[b]).user * 1000L / USER_HZ;
/*     */       
/* 201 */       arrayOfLong[b][CentralProcessor.TickType.SYSTEM.ordinal()] = (arrayOfPerfstat_cpu_t[b]).sys * 1000L / USER_HZ;
/* 202 */       arrayOfLong[b][CentralProcessor.TickType.IDLE.ordinal()] = (arrayOfPerfstat_cpu_t[b]).idle * 1000L / USER_HZ;
/* 203 */       arrayOfLong[b][CentralProcessor.TickType.IOWAIT.ordinal()] = (arrayOfPerfstat_cpu_t[b]).wait * 1000L / USER_HZ;
/* 204 */       arrayOfLong[b][CentralProcessor.TickType.IRQ.ordinal()] = (arrayOfPerfstat_cpu_t[b]).devintrs * 1000L / USER_HZ;
/* 205 */       arrayOfLong[b][CentralProcessor.TickType.SOFTIRQ.ordinal()] = (arrayOfPerfstat_cpu_t[b]).softintrs * 1000L / USER_HZ;
/* 206 */       arrayOfLong[b][CentralProcessor.TickType.STEAL.ordinal()] = ((arrayOfPerfstat_cpu_t[b]).idle_stolen_purr + (arrayOfPerfstat_cpu_t[b]).busy_stolen_purr) * 1000L / USER_HZ;
/*     */     } 
/* 208 */     return arrayOfLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public long queryContextSwitches() {
/* 213 */     return ((Perfstat.perfstat_cpu_total_t)this.cpuTotal.get()).pswitch;
/*     */   }
/*     */ 
/*     */   
/*     */   public long queryInterrupts() {
/* 218 */     Perfstat.perfstat_cpu_total_t perfstat_cpu_total_t = this.cpuTotal.get();
/* 219 */     return perfstat_cpu_total_t.devintrs + perfstat_cpu_total_t.softintrs;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int querySbits() {
/* 224 */     for (String str : FileUtil.readFile("/usr/include/sys/proc.h")) {
/* 225 */       if (str.contains("SBITS") && str.contains("#define")) {
/* 226 */         return ParseUtil.parseLastInt(str, 16);
/*     */       }
/*     */     } 
/* 229 */     return 16;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\aix\AixCentralProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */