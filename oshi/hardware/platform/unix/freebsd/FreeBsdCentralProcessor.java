/*     */ package oshi.hardware.platform.unix.freebsd;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.platform.unix.LibCAPI;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.CentralProcessor;
/*     */ import oshi.hardware.common.AbstractCentralProcessor;
/*     */ import oshi.jna.platform.unix.freebsd.FreeBsdLibc;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.FileUtil;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.unix.freebsd.BsdSysctlUtil;
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
/*     */ final class FreeBsdCentralProcessor
/*     */   extends AbstractCentralProcessor
/*     */ {
/*  54 */   private static final Logger LOG = LoggerFactory.getLogger(FreeBsdCentralProcessor.class);
/*     */   
/*  56 */   private static final Pattern CPUMASK = Pattern.compile(".*<cpu\\s.*mask=\"(?:0x)?(\\p{XDigit}+)\".*>.*</cpu>.*");
/*     */ 
/*     */ 
/*     */   
/*     */   protected CentralProcessor.ProcessorIdentifier queryProcessorId() {
/*  61 */     Pattern pattern1 = Pattern.compile("Origin=\"([^\"]*)\".*Id=(\\S+).*Family=(\\S+).*Model=(\\S+).*Stepping=(\\S+).*");
/*  62 */     Pattern pattern2 = Pattern.compile("Features=(\\S+)<.*");
/*     */     
/*  64 */     String str1 = "";
/*  65 */     String str2 = BsdSysctlUtil.sysctl("hw.model", "");
/*  66 */     String str3 = "";
/*  67 */     String str4 = "";
/*  68 */     String str5 = "";
/*     */     
/*  70 */     long l1 = BsdSysctlUtil.sysctl("hw.clockrate", 0L) * 1000000L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  76 */     long l2 = 0L;
/*  77 */     List list = FileUtil.readFile("/var/run/dmesg.boot");
/*  78 */     for (String str : list) {
/*  79 */       str = str.trim();
/*     */       
/*  81 */       if (str.startsWith("CPU:") && str2.isEmpty()) {
/*  82 */         str2 = str.replace("CPU:", "").trim(); continue;
/*  83 */       }  if (str.startsWith("Origin=")) {
/*  84 */         Matcher matcher = pattern1.matcher(str);
/*  85 */         if (matcher.matches()) {
/*  86 */           str1 = matcher.group(1);
/*  87 */           l2 |= Long.decode(matcher.group(2)).longValue();
/*  88 */           str3 = Integer.decode(matcher.group(3)).toString();
/*  89 */           str4 = Integer.decode(matcher.group(4)).toString();
/*  90 */           str5 = Integer.decode(matcher.group(5)).toString();
/*     */         }  continue;
/*  92 */       }  if (str.startsWith("Features=")) {
/*  93 */         Matcher matcher = pattern2.matcher(str);
/*  94 */         if (matcher.matches()) {
/*  95 */           l2 |= Long.decode(matcher.group(1)).longValue() << 32L;
/*     */         }
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 101 */     boolean bool = ExecutingCommand.getFirstAnswer("uname -m").trim().contains("64");
/* 102 */     String str6 = getProcessorIDfromDmiDecode(l2);
/*     */     
/* 104 */     return new CentralProcessor.ProcessorIdentifier(str1, str2, str3, str4, str5, str6, bool, l1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<CentralProcessor.LogicalProcessor> initProcessorCounts() {
/* 110 */     List<CentralProcessor.LogicalProcessor> list = parseTopology();
/*     */     
/* 112 */     if (list.isEmpty()) {
/* 113 */       list.add(new CentralProcessor.LogicalProcessor(0, 0, 0));
/*     */     }
/* 115 */     return list;
/*     */   }
/*     */   
/*     */   private static List<CentralProcessor.LogicalProcessor> parseTopology() {
/* 119 */     String[] arrayOfString = BsdSysctlUtil.sysctl("kern.sched.topology_spec", "").split("\\n|\\r");
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
/* 142 */     long l = 1L;
/* 143 */     ArrayList<Long> arrayList1 = new ArrayList();
/* 144 */     ArrayList<Long> arrayList2 = new ArrayList();
/* 145 */     byte b = 0;
/* 146 */     for (String str : arrayOfString) {
/* 147 */       if (str.contains("<group level=")) {
/* 148 */         b++;
/* 149 */       } else if (str.contains("</group>")) {
/* 150 */         b--;
/* 151 */       } else if (str.contains("<cpu")) {
/*     */         
/* 153 */         Matcher matcher = CPUMASK.matcher(str);
/* 154 */         if (matcher.matches())
/*     */         {
/*     */           
/* 157 */           switch (b) {
/*     */             case 1:
/* 159 */               l = Long.parseLong(matcher.group(1), 16);
/*     */               break;
/*     */             case 2:
/* 162 */               arrayList1.add(Long.valueOf(Long.parseLong(matcher.group(1), 16)));
/*     */               break;
/*     */             case 3:
/* 165 */               arrayList2.add(Long.valueOf(Long.parseLong(matcher.group(1), 16)));
/*     */               break;
/*     */           } 
/*     */ 
/*     */         
/*     */         }
/*     */       } 
/*     */     } 
/* 173 */     return matchBitmasks(l, arrayList1, arrayList2);
/*     */   }
/*     */   
/*     */   private static List<CentralProcessor.LogicalProcessor> matchBitmasks(long paramLong, List<Long> paramList1, List<Long> paramList2) {
/* 177 */     ArrayList<CentralProcessor.LogicalProcessor> arrayList = new ArrayList();
/*     */     
/* 179 */     int i = Long.numberOfTrailingZeros(paramLong);
/* 180 */     int j = 63 - Long.numberOfLeadingZeros(paramLong);
/*     */     
/* 182 */     for (int k = i; k <= j; k++) {
/* 183 */       if ((paramLong & 1L << k) > 0L) {
/* 184 */         boolean bool = false;
/*     */         
/* 186 */         CentralProcessor.LogicalProcessor logicalProcessor = new CentralProcessor.LogicalProcessor(k, getMatchingBitmask(paramList2, k), getMatchingBitmask(paramList1, k), bool);
/* 187 */         arrayList.add(logicalProcessor);
/*     */       } 
/*     */     } 
/* 190 */     return arrayList;
/*     */   }
/*     */   
/*     */   private static int getMatchingBitmask(List<Long> paramList, int paramInt) {
/* 194 */     for (byte b = 0; b < paramList.size(); b++) {
/* 195 */       if ((((Long)paramList.get(b)).longValue() & 1L << paramInt) != 0L) {
/* 196 */         return b;
/*     */       }
/*     */     } 
/* 199 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public long[] querySystemCpuLoadTicks() {
/* 204 */     long[] arrayOfLong = new long[(CentralProcessor.TickType.values()).length];
/* 205 */     FreeBsdLibc.CpTime cpTime = new FreeBsdLibc.CpTime();
/* 206 */     BsdSysctlUtil.sysctl("kern.cp_time", (Structure)cpTime);
/* 207 */     arrayOfLong[CentralProcessor.TickType.USER.getIndex()] = cpTime.cpu_ticks[0];
/* 208 */     arrayOfLong[CentralProcessor.TickType.NICE.getIndex()] = cpTime.cpu_ticks[1];
/* 209 */     arrayOfLong[CentralProcessor.TickType.SYSTEM.getIndex()] = cpTime.cpu_ticks[2];
/* 210 */     arrayOfLong[CentralProcessor.TickType.IRQ.getIndex()] = cpTime.cpu_ticks[3];
/* 211 */     arrayOfLong[CentralProcessor.TickType.IDLE.getIndex()] = cpTime.cpu_ticks[4];
/* 212 */     return arrayOfLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public long[] queryCurrentFreq() {
/* 217 */     long[] arrayOfLong = new long[1];
/* 218 */     arrayOfLong[0] = BsdSysctlUtil.sysctl("dev.cpu.0.freq", -1L);
/* 219 */     if (arrayOfLong[0] > 0L) {
/*     */       
/* 221 */       arrayOfLong[0] = arrayOfLong[0] * 1000000L;
/*     */     } else {
/* 223 */       arrayOfLong[0] = BsdSysctlUtil.sysctl("machdep.tsc_freq", -1L);
/*     */     } 
/* 225 */     return arrayOfLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public long queryMaxFreq() {
/* 230 */     long l = -1L;
/* 231 */     String str = BsdSysctlUtil.sysctl("dev.cpu.0.freq_levels", "");
/*     */     
/* 233 */     for (String str1 : ParseUtil.whitespaces.split(str)) {
/* 234 */       long l1 = ParseUtil.parseLongOrDefault(str1.split("/")[0], -1L);
/* 235 */       if (l < l1) {
/* 236 */         l = l1;
/*     */       }
/*     */     } 
/* 239 */     if (l > 0L) {
/*     */       
/* 241 */       l *= 1000000L;
/*     */     } else {
/* 243 */       l = BsdSysctlUtil.sysctl("machdep.tsc_freq", -1L);
/*     */     } 
/* 245 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public double[] getSystemLoadAverage(int paramInt) {
/* 250 */     if (paramInt < 1 || paramInt > 3) {
/* 251 */       throw new IllegalArgumentException("Must include from one to three elements.");
/*     */     }
/* 253 */     double[] arrayOfDouble = new double[paramInt];
/* 254 */     int i = FreeBsdLibc.INSTANCE.getloadavg(arrayOfDouble, paramInt);
/* 255 */     if (i < paramInt) {
/* 256 */       for (int j = Math.max(i, 0); j < arrayOfDouble.length; j++) {
/* 257 */         arrayOfDouble[j] = -1.0D;
/*     */       }
/*     */     }
/* 260 */     return arrayOfDouble;
/*     */   }
/*     */ 
/*     */   
/*     */   public long[][] queryProcessorCpuLoadTicks() {
/* 265 */     long[][] arrayOfLong = new long[getLogicalProcessorCount()][(CentralProcessor.TickType.values()).length];
/*     */ 
/*     */     
/* 268 */     long l1 = (new FreeBsdLibc.CpTime()).size();
/* 269 */     long l2 = l1 * getLogicalProcessorCount();
/* 270 */     Memory memory = new Memory(l2);
/* 271 */     String str = "kern.cp_times";
/*     */     
/* 273 */     if (0 != FreeBsdLibc.INSTANCE.sysctlbyname(str, (Pointer)memory, new LibCAPI.size_t.ByReference(new LibCAPI.size_t(l2)), null, LibCAPI.size_t.ZERO)) {
/*     */       
/* 275 */       LOG.error("Failed sysctl call: {}, Error code: {}", str, Integer.valueOf(Native.getLastError()));
/* 276 */       return arrayOfLong;
/*     */     } 
/*     */     
/* 279 */     for (byte b = 0; b < getLogicalProcessorCount(); b++) {
/* 280 */       arrayOfLong[b][CentralProcessor.TickType.USER.getIndex()] = memory
/* 281 */         .getLong(l1 * b + (0 * FreeBsdLibc.UINT64_SIZE));
/* 282 */       arrayOfLong[b][CentralProcessor.TickType.NICE.getIndex()] = memory
/* 283 */         .getLong(l1 * b + (1 * FreeBsdLibc.UINT64_SIZE));
/* 284 */       arrayOfLong[b][CentralProcessor.TickType.SYSTEM.getIndex()] = memory
/* 285 */         .getLong(l1 * b + (2 * FreeBsdLibc.UINT64_SIZE));
/* 286 */       arrayOfLong[b][CentralProcessor.TickType.IRQ.getIndex()] = memory.getLong(l1 * b + (3 * FreeBsdLibc.UINT64_SIZE));
/* 287 */       arrayOfLong[b][CentralProcessor.TickType.IDLE.getIndex()] = memory
/* 288 */         .getLong(l1 * b + (4 * FreeBsdLibc.UINT64_SIZE));
/*     */     } 
/* 290 */     return arrayOfLong;
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
/*     */   private static String getProcessorIDfromDmiDecode(long paramLong) {
/* 302 */     boolean bool = false;
/* 303 */     String str = "Processor Information";
/* 304 */     for (String str1 : ExecutingCommand.runNative("dmidecode -t system")) {
/* 305 */       if (!bool && str1.contains(str)) {
/* 306 */         str = "ID:";
/* 307 */         bool = true; continue;
/* 308 */       }  if (bool && str1.contains(str)) {
/* 309 */         return str1.split(str)[1].trim();
/*     */       }
/*     */     } 
/*     */     
/* 313 */     return String.format("%016X", new Object[] { Long.valueOf(paramLong) });
/*     */   }
/*     */ 
/*     */   
/*     */   public long queryContextSwitches() {
/* 318 */     String str = "vm.stats.sys.v_swtch";
/* 319 */     LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(new LibCAPI.size_t(FreeBsdLibc.INT_SIZE));
/* 320 */     Memory memory = new Memory(byReference.longValue());
/* 321 */     if (0 != FreeBsdLibc.INSTANCE.sysctlbyname(str, (Pointer)memory, byReference, null, LibCAPI.size_t.ZERO)) {
/* 322 */       return 0L;
/*     */     }
/* 324 */     return ParseUtil.unsignedIntToLong(memory.getInt(0L));
/*     */   }
/*     */ 
/*     */   
/*     */   public long queryInterrupts() {
/* 329 */     String str = "vm.stats.sys.v_intr";
/* 330 */     LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(new LibCAPI.size_t(FreeBsdLibc.INT_SIZE));
/* 331 */     Memory memory = new Memory(byReference.longValue());
/* 332 */     if (0 != FreeBsdLibc.INSTANCE.sysctlbyname(str, (Pointer)memory, byReference, null, LibCAPI.size_t.ZERO)) {
/* 333 */       return 0L;
/*     */     }
/* 335 */     return ParseUtil.unsignedIntToLong(memory.getInt(0L));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\freebsd\FreeBsdCentralProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */