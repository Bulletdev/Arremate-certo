/*     */ package oshi.hardware.platform.unix.openbsd;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.CentralProcessor;
/*     */ import oshi.hardware.common.AbstractCentralProcessor;
/*     */ import oshi.jna.platform.unix.openbsd.OpenBsdLibc;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.unix.openbsd.OpenBsdSysctlUtil;
/*     */ import oshi.util.tuples.Pair;
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
/*     */ public class OpenBsdCentralProcessor
/*     */   extends AbstractCentralProcessor
/*     */ {
/*  67 */   private final Supplier<Pair<Long, Long>> vmStats = Memoizer.memoize(OpenBsdCentralProcessor::queryVmStats, 
/*  68 */       Memoizer.defaultExpiration());
/*  69 */   private static final Pattern DMESG_CPU = Pattern.compile("cpu(\\d+): smt (\\d+), core (\\d+), package (\\d+)");
/*     */ 
/*     */   
/*     */   protected CentralProcessor.ProcessorIdentifier queryProcessorId() {
/*  73 */     String str1 = OpenBsdSysctlUtil.sysctl("machdep.cpuvendor", "");
/*  74 */     int[] arrayOfInt = new int[2];
/*  75 */     arrayOfInt[0] = 6;
/*  76 */     arrayOfInt[1] = 2;
/*  77 */     String str2 = OpenBsdSysctlUtil.sysctl(arrayOfInt, "");
/*     */     
/*  79 */     int i = ParseUtil.hexStringToInt(OpenBsdSysctlUtil.sysctl("machdep.cpuid", ""), 0);
/*  80 */     int j = ParseUtil.hexStringToInt(OpenBsdSysctlUtil.sysctl("machdep.cpufeature", ""), 0);
/*  81 */     Triplet<Integer, Integer, Integer> triplet = cpuidToFamilyModelStepping(i);
/*  82 */     String str3 = ((Integer)triplet.getA()).toString();
/*  83 */     String str4 = ((Integer)triplet.getB()).toString();
/*  84 */     String str5 = ((Integer)triplet.getC()).toString();
/*  85 */     long l = ParseUtil.parseHertz(str2);
/*  86 */     if (l < 0L) {
/*  87 */       l = queryMaxFreq();
/*     */     }
/*  89 */     arrayOfInt[1] = 1;
/*  90 */     String str6 = OpenBsdSysctlUtil.sysctl(arrayOfInt, "");
/*     */     
/*  92 */     boolean bool = ((str6 != null && str6.contains("64")) || ExecutingCommand.getFirstAnswer("uname -m").trim().contains("64")) ? true : false;
/*  93 */     String str7 = String.format("%08x%08x", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
/*     */     
/*  95 */     return new CentralProcessor.ProcessorIdentifier(str1, str2, str3, str4, str5, str7, bool, l);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Triplet<Integer, Integer, Integer> cpuidToFamilyModelStepping(int paramInt) {
/* 101 */     int i = paramInt >> 16 & 0xFF0 | paramInt >> 8 & 0xF;
/*     */     
/* 103 */     int j = paramInt >> 12 & 0xF0 | paramInt >> 4 & 0xF;
/*     */     
/* 105 */     int k = paramInt & 0xF;
/* 106 */     return new Triplet(Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k));
/*     */   }
/*     */ 
/*     */   
/*     */   protected long queryMaxFreq() {
/* 111 */     return queryCurrentFreq()[0];
/*     */   }
/*     */ 
/*     */   
/*     */   protected long[] queryCurrentFreq() {
/* 116 */     long[] arrayOfLong = new long[1];
/* 117 */     int[] arrayOfInt = new int[2];
/* 118 */     arrayOfInt[0] = 6;
/* 119 */     arrayOfInt[1] = 12;
/* 120 */     arrayOfLong[0] = OpenBsdSysctlUtil.sysctl(arrayOfInt, 0L) * 1000000L;
/* 121 */     return arrayOfLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<CentralProcessor.LogicalProcessor> initProcessorCounts() {
/* 129 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/* 130 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/* 131 */     for (String str : ExecutingCommand.runNative("dmesg")) {
/* 132 */       Matcher matcher = DMESG_CPU.matcher(str);
/* 133 */       if (matcher.matches()) {
/* 134 */         int j = ParseUtil.parseIntOrDefault(matcher.group(1), 0);
/* 135 */         hashMap1.put(Integer.valueOf(j), Integer.valueOf(ParseUtil.parseIntOrDefault(matcher.group(3), 0)));
/* 136 */         hashMap2.put(Integer.valueOf(j), Integer.valueOf(ParseUtil.parseIntOrDefault(matcher.group(4), 0)));
/*     */       } 
/*     */     } 
/*     */     
/* 140 */     int i = OpenBsdSysctlUtil.sysctl("hw.ncpuonline", 1);
/*     */     
/* 142 */     if (i < hashMap1.keySet().size()) {
/* 143 */       i = hashMap1.keySet().size();
/*     */     }
/* 145 */     ArrayList<CentralProcessor.LogicalProcessor> arrayList = new ArrayList(i);
/* 146 */     for (byte b = 0; b < i; b++) {
/* 147 */       arrayList.add(new CentralProcessor.LogicalProcessor(b, ((Integer)hashMap1.getOrDefault(Integer.valueOf(b), Integer.valueOf(0))).intValue(), ((Integer)hashMap2.getOrDefault(Integer.valueOf(b), Integer.valueOf(0))).intValue()));
/*     */     }
/* 149 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected long queryContextSwitches() {
/* 159 */     return ((Long)((Pair)this.vmStats.get()).getA()).longValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected long queryInterrupts() {
/* 169 */     return ((Long)((Pair)this.vmStats.get()).getB()).longValue();
/*     */   }
/*     */   
/*     */   private static Pair<Long, Long> queryVmStats() {
/* 173 */     long l1 = 0L;
/* 174 */     long l2 = 0L;
/* 175 */     List list = ExecutingCommand.runNative("vmstat -s");
/* 176 */     for (String str : list) {
/* 177 */       if (str.endsWith("cpu context switches")) {
/* 178 */         l1 = ParseUtil.getFirstIntValue(str); continue;
/* 179 */       }  if (str.endsWith("interrupts")) {
/* 180 */         l2 = ParseUtil.getFirstIntValue(str);
/*     */       }
/*     */     } 
/* 183 */     return new Pair(Long.valueOf(l1), Long.valueOf(l2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected long[] querySystemCpuLoadTicks() {
/* 193 */     long[] arrayOfLong1 = new long[(CentralProcessor.TickType.values()).length];
/* 194 */     int[] arrayOfInt = new int[2];
/* 195 */     arrayOfInt[0] = 1;
/* 196 */     arrayOfInt[1] = 40;
/* 197 */     Memory memory = OpenBsdSysctlUtil.sysctl(arrayOfInt);
/*     */     
/* 199 */     long[] arrayOfLong2 = cpTimeToTicks(memory, false);
/* 200 */     if (arrayOfLong2.length >= 5) {
/* 201 */       arrayOfLong1[CentralProcessor.TickType.USER.getIndex()] = arrayOfLong2[0];
/* 202 */       arrayOfLong1[CentralProcessor.TickType.NICE.getIndex()] = arrayOfLong2[1];
/* 203 */       arrayOfLong1[CentralProcessor.TickType.SYSTEM.getIndex()] = arrayOfLong2[2];
/* 204 */       byte b = (arrayOfLong2.length > 5) ? 1 : 0;
/* 205 */       arrayOfLong1[CentralProcessor.TickType.IRQ.getIndex()] = arrayOfLong2[3 + b];
/* 206 */       arrayOfLong1[CentralProcessor.TickType.IDLE.getIndex()] = arrayOfLong2[4 + b];
/*     */     } 
/* 208 */     return arrayOfLong1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected long[][] queryProcessorCpuLoadTicks() {
/* 218 */     long[][] arrayOfLong = new long[getLogicalProcessorCount()][(CentralProcessor.TickType.values()).length];
/* 219 */     int[] arrayOfInt = new int[3];
/* 220 */     arrayOfInt[0] = 1;
/* 221 */     arrayOfInt[1] = 71;
/* 222 */     for (byte b = 0; b < getLogicalProcessorCount(); b++) {
/* 223 */       arrayOfInt[2] = b;
/* 224 */       Memory memory = OpenBsdSysctlUtil.sysctl(arrayOfInt);
/*     */       
/* 226 */       long[] arrayOfLong1 = cpTimeToTicks(memory, true);
/* 227 */       if (arrayOfLong1.length >= 5) {
/* 228 */         arrayOfLong[b][CentralProcessor.TickType.USER.getIndex()] = arrayOfLong1[0];
/* 229 */         arrayOfLong[b][CentralProcessor.TickType.NICE.getIndex()] = arrayOfLong1[1];
/* 230 */         arrayOfLong[b][CentralProcessor.TickType.SYSTEM.getIndex()] = arrayOfLong1[2];
/* 231 */         byte b1 = (arrayOfLong1.length > 5) ? 1 : 0;
/* 232 */         arrayOfLong[b][CentralProcessor.TickType.IRQ.getIndex()] = arrayOfLong1[3 + b1];
/* 233 */         arrayOfLong[b][CentralProcessor.TickType.IDLE.getIndex()] = arrayOfLong1[4 + b1];
/*     */       } 
/*     */     } 
/* 236 */     return arrayOfLong;
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
/*     */   
/*     */   private static long[] cpTimeToTicks(Memory paramMemory, boolean paramBoolean) {
/* 255 */     long l = paramBoolean ? 8L : Native.LONG_SIZE;
/* 256 */     byte b1 = (paramMemory == null) ? 0 : (int)(paramMemory.size() / l);
/* 257 */     if (paramBoolean && paramMemory != null) {
/* 258 */       return paramMemory.getLongArray(0L, b1);
/*     */     }
/* 260 */     long[] arrayOfLong = new long[b1];
/* 261 */     for (byte b2 = 0; b2 < b1; b2++) {
/* 262 */       arrayOfLong[b2] = paramMemory.getNativeLong(b2 * l).longValue();
/*     */     }
/* 264 */     return arrayOfLong;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double[] getSystemLoadAverage(int paramInt) {
/* 289 */     if (paramInt < 1 || paramInt > 3) {
/* 290 */       throw new IllegalArgumentException("Must include from one to three elements.");
/*     */     }
/* 292 */     double[] arrayOfDouble = new double[paramInt];
/* 293 */     int i = OpenBsdLibc.INSTANCE.getloadavg(arrayOfDouble, paramInt);
/* 294 */     if (i < paramInt) {
/* 295 */       Arrays.fill(arrayOfDouble, -1.0D);
/*     */     }
/* 297 */     return arrayOfDouble;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\openbsd\OpenBsdCentralProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */