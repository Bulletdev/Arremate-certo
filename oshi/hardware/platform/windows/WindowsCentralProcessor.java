/*     */ package oshi.hardware.platform.windows;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.platform.win32.Advapi32Util;
/*     */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*     */ import com.sun.jna.platform.win32.Kernel32;
/*     */ import com.sun.jna.platform.win32.VersionHelpers;
/*     */ import com.sun.jna.platform.win32.Win32Exception;
/*     */ import com.sun.jna.platform.win32.WinBase;
/*     */ import com.sun.jna.platform.win32.WinReg;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.windows.LogicalProcessorInformation;
/*     */ import oshi.driver.windows.perfmon.ProcessorInformation;
/*     */ import oshi.driver.windows.perfmon.SystemInformation;
/*     */ import oshi.driver.windows.wmi.Win32Processor;
/*     */ import oshi.hardware.CentralProcessor;
/*     */ import oshi.hardware.common.AbstractCentralProcessor;
/*     */ import oshi.jna.platform.windows.PowrProf;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.windows.WmiUtil;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ final class WindowsCentralProcessor
/*     */   extends AbstractCentralProcessor
/*     */ {
/*  68 */   private static final Logger LOG = LoggerFactory.getLogger(WindowsCentralProcessor.class);
/*     */ 
/*     */ 
/*     */   
/*     */   private Map<String, Integer> numaNodeProcToLogicalProcMap;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected CentralProcessor.ProcessorIdentifier queryProcessorId() {
/*  78 */     String str7, str1 = "";
/*  79 */     String str2 = "";
/*  80 */     String str3 = "";
/*  81 */     String str4 = "";
/*  82 */     String str5 = "";
/*  83 */     String str6 = "";
/*  84 */     long l = 0L;
/*     */     
/*  86 */     boolean bool = false;
/*     */     
/*  88 */     String str8 = "HARDWARE\\DESCRIPTION\\System\\CentralProcessor\\";
/*  89 */     String[] arrayOfString = Advapi32Util.registryGetKeys(WinReg.HKEY_LOCAL_MACHINE, "HARDWARE\\DESCRIPTION\\System\\CentralProcessor\\");
/*  90 */     if (arrayOfString.length > 0) {
/*  91 */       String str = "HARDWARE\\DESCRIPTION\\System\\CentralProcessor\\" + arrayOfString[0];
/*  92 */       str1 = Advapi32Util.registryGetStringValue(WinReg.HKEY_LOCAL_MACHINE, str, "VendorIdentifier");
/*     */       
/*  94 */       str2 = Advapi32Util.registryGetStringValue(WinReg.HKEY_LOCAL_MACHINE, str, "ProcessorNameString");
/*     */       
/*  96 */       str3 = Advapi32Util.registryGetStringValue(WinReg.HKEY_LOCAL_MACHINE, str, "Identifier");
/*     */       
/*     */       try {
/*  99 */         l = Advapi32Util.registryGetIntValue(WinReg.HKEY_LOCAL_MACHINE, str, "~MHz") * 1000000L;
/*     */       }
/* 101 */       catch (Win32Exception win32Exception) {}
/*     */     } 
/*     */ 
/*     */     
/* 105 */     if (!str3.isEmpty()) {
/* 106 */       str4 = parseIdentifier(str3, "Family");
/* 107 */       str5 = parseIdentifier(str3, "Model");
/* 108 */       str6 = parseIdentifier(str3, "Stepping");
/*     */     } 
/* 110 */     WinBase.SYSTEM_INFO sYSTEM_INFO = new WinBase.SYSTEM_INFO();
/* 111 */     Kernel32.INSTANCE.GetNativeSystemInfo(sYSTEM_INFO);
/* 112 */     int i = sYSTEM_INFO.processorArchitecture.pi.wProcessorArchitecture.intValue();
/* 113 */     if (i == 9 || i == 12 || i == 6)
/*     */     {
/*     */       
/* 116 */       bool = true;
/*     */     }
/* 118 */     WbemcliUtil.WmiResult wmiResult = Win32Processor.queryProcessorId();
/* 119 */     if (wmiResult.getResultCount() > 0) {
/* 120 */       str7 = WmiUtil.getString(wmiResult, (Enum)Win32Processor.ProcessorIdProperty.PROCESSORID, 0);
/*     */     } else {
/*     */       
/* 123 */       (new String[1])[0] = "ia64"; str7 = createProcessorID(str6, str5, str4, bool ? new String[1] : new String[0]);
/*     */     } 
/* 125 */     return new CentralProcessor.ProcessorIdentifier(str1, str2, str4, str5, str6, str7, bool, l);
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
/*     */   private static String parseIdentifier(String paramString1, String paramString2) {
/* 139 */     String[] arrayOfString = ParseUtil.whitespaces.split(paramString1);
/* 140 */     boolean bool = false;
/* 141 */     for (String str : arrayOfString) {
/*     */       
/* 143 */       if (bool) {
/* 144 */         return str;
/*     */       }
/* 146 */       bool = str.equals(paramString2);
/*     */     } 
/*     */     
/* 149 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<CentralProcessor.LogicalProcessor> initProcessorCounts() {
/* 154 */     if (VersionHelpers.IsWindows7OrGreater()) {
/* 155 */       List<CentralProcessor.LogicalProcessor> list = LogicalProcessorInformation.getLogicalProcessorInformationEx();
/*     */ 
/*     */ 
/*     */       
/* 159 */       int i = -1;
/* 160 */       byte b1 = 0;
/*     */       
/* 162 */       byte b2 = 0;
/* 163 */       this.numaNodeProcToLogicalProcMap = new HashMap<>();
/* 164 */       for (CentralProcessor.LogicalProcessor logicalProcessor : list) {
/* 165 */         int j = logicalProcessor.getNumaNode();
/*     */         
/* 167 */         if (j != i) {
/* 168 */           i = j;
/* 169 */           b1 = 0;
/*     */         } 
/* 171 */         this.numaNodeProcToLogicalProcMap.put(String.format("%d,%d", new Object[] { Integer.valueOf(logicalProcessor.getNumaNode()), Integer.valueOf(b1++) }), Integer.valueOf(b2++));
/*     */       } 
/* 173 */       return list;
/*     */     } 
/* 175 */     return LogicalProcessorInformation.getLogicalProcessorInformation();
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
/*     */   public long[] querySystemCpuLoadTicks() {
/* 187 */     long[] arrayOfLong = new long[(CentralProcessor.TickType.values()).length];
/*     */     
/* 189 */     long[][] arrayOfLong1 = getProcessorCpuLoadTicks();
/* 190 */     for (byte b = 0; b < arrayOfLong.length; b++) {
/* 191 */       for (long[] arrayOfLong2 : arrayOfLong1) {
/* 192 */         arrayOfLong[b] = arrayOfLong[b] + arrayOfLong2[b];
/*     */       }
/*     */     } 
/* 195 */     return arrayOfLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public long[] queryCurrentFreq() {
/* 200 */     if (VersionHelpers.IsWindows7OrGreater()) {
/*     */       
/* 202 */       Pair pair = ProcessorInformation.queryFrequencyCounters();
/* 203 */       List<String> list = (List)pair.getA();
/* 204 */       Map map = (Map)pair.getB();
/* 205 */       List list1 = (List)map.get(ProcessorInformation.ProcessorFrequencyProperty.PERCENTOFMAXIMUMFREQUENCY);
/* 206 */       if (!list.isEmpty()) {
/* 207 */         long l = getMaxFreq();
/* 208 */         long[] arrayOfLong = new long[getLogicalProcessorCount()];
/* 209 */         for (byte b = 0; b < list.size(); b++) {
/*     */ 
/*     */           
/* 212 */           int i = ((String)list.get(b)).contains(",") ? ((Integer)this.numaNodeProcToLogicalProcMap.getOrDefault(list.get(b), Integer.valueOf(0))).intValue() : ParseUtil.parseIntOrDefault(list.get(b), 0);
/* 213 */           if (i < getLogicalProcessorCount())
/*     */           {
/*     */             
/* 216 */             arrayOfLong[i] = ((Long)list1.get(i)).longValue() * l / 100L; } 
/*     */         } 
/* 218 */         return arrayOfLong;
/*     */       } 
/*     */     } 
/*     */     
/* 222 */     return queryNTPower(2);
/*     */   }
/*     */ 
/*     */   
/*     */   public long queryMaxFreq() {
/* 227 */     long[] arrayOfLong = queryNTPower(1);
/* 228 */     return Arrays.stream(arrayOfLong).max().orElse(-1L);
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
/*     */   private long[] queryNTPower(int paramInt) {
/* 241 */     PowrProf.ProcessorPowerInformation processorPowerInformation = new PowrProf.ProcessorPowerInformation();
/* 242 */     long[] arrayOfLong = new long[getLogicalProcessorCount()];
/* 243 */     int i = processorPowerInformation.size() * arrayOfLong.length;
/* 244 */     Memory memory = new Memory(i);
/* 245 */     if (0 != PowrProf.INSTANCE.CallNtPowerInformation(11, null, 0, (Pointer)memory, i)) {
/*     */       
/* 247 */       LOG.error("Unable to get Processor Information");
/* 248 */       Arrays.fill(arrayOfLong, -1L);
/* 249 */       return arrayOfLong;
/*     */     } 
/* 251 */     for (byte b = 0; b < arrayOfLong.length; b++) {
/* 252 */       processorPowerInformation = new PowrProf.ProcessorPowerInformation(memory.share(b * processorPowerInformation.size()));
/* 253 */       if (paramInt == 1) {
/* 254 */         arrayOfLong[b] = processorPowerInformation.maxMhz * 1000000L;
/* 255 */       } else if (paramInt == 2) {
/* 256 */         arrayOfLong[b] = processorPowerInformation.currentMhz * 1000000L;
/*     */       } else {
/* 258 */         arrayOfLong[b] = -1L;
/*     */       } 
/*     */     } 
/* 261 */     return arrayOfLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public double[] getSystemLoadAverage(int paramInt) {
/* 266 */     if (paramInt < 1 || paramInt > 3) {
/* 267 */       throw new IllegalArgumentException("Must include from one to three elements.");
/*     */     }
/* 269 */     double[] arrayOfDouble = new double[paramInt];
/*     */     
/* 271 */     for (byte b = 0; b < arrayOfDouble.length; b++) {
/* 272 */       arrayOfDouble[b] = -1.0D;
/*     */     }
/* 274 */     return arrayOfDouble;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long[][] queryProcessorCpuLoadTicks() {
/* 280 */     Pair pair = ProcessorInformation.queryProcessorCounters();
/* 281 */     List<String> list = (List)pair.getA();
/* 282 */     Map map = (Map)pair.getB();
/* 283 */     List list1 = (List)map.get(ProcessorInformation.ProcessorTickCountProperty.PERCENTPRIVILEGEDTIME);
/* 284 */     List list2 = (List)map.get(ProcessorInformation.ProcessorTickCountProperty.PERCENTUSERTIME);
/* 285 */     List list3 = (List)map.get(ProcessorInformation.ProcessorTickCountProperty.PERCENTINTERRUPTTIME);
/* 286 */     List list4 = (List)map.get(ProcessorInformation.ProcessorTickCountProperty.PERCENTDPCTIME);
/*     */     
/* 288 */     List list5 = (List)map.get(ProcessorInformation.ProcessorTickCountProperty.PERCENTPROCESSORTIME);
/*     */     
/* 290 */     long[][] arrayOfLong = new long[getLogicalProcessorCount()][(CentralProcessor.TickType.values()).length];
/* 291 */     if (list.isEmpty() || list1 == null || list2 == null || list3 == null || list4 == null || list5 == null)
/*     */     {
/* 293 */       return arrayOfLong;
/*     */     }
/* 295 */     for (byte b = 0; b < list.size(); b++) {
/*     */       
/* 297 */       int i = ((String)list.get(b)).contains(",") ? ((Integer)this.numaNodeProcToLogicalProcMap.getOrDefault(list.get(b), Integer.valueOf(0))).intValue() : ParseUtil.parseIntOrDefault(list.get(b), 0);
/* 298 */       if (i < getLogicalProcessorCount()) {
/*     */ 
/*     */         
/* 301 */         arrayOfLong[i][CentralProcessor.TickType.SYSTEM.getIndex()] = ((Long)list1.get(i)).longValue();
/* 302 */         arrayOfLong[i][CentralProcessor.TickType.USER.getIndex()] = ((Long)list2.get(i)).longValue();
/* 303 */         arrayOfLong[i][CentralProcessor.TickType.IRQ.getIndex()] = ((Long)list3.get(i)).longValue();
/* 304 */         arrayOfLong[i][CentralProcessor.TickType.SOFTIRQ.getIndex()] = ((Long)list4.get(i)).longValue();
/* 305 */         arrayOfLong[i][CentralProcessor.TickType.IDLE.getIndex()] = ((Long)list5.get(i)).longValue();
/*     */ 
/*     */ 
/*     */         
/* 309 */         arrayOfLong[i][CentralProcessor.TickType.SYSTEM.getIndex()] = arrayOfLong[i][CentralProcessor.TickType.SYSTEM.getIndex()] - arrayOfLong[i][CentralProcessor.TickType.IRQ.getIndex()] + arrayOfLong[i][CentralProcessor.TickType.SOFTIRQ
/* 310 */             .getIndex()];
/*     */ 
/*     */ 
/*     */         
/* 314 */         arrayOfLong[i][CentralProcessor.TickType.SYSTEM.getIndex()] = arrayOfLong[i][CentralProcessor.TickType.SYSTEM.getIndex()] / 10000L;
/* 315 */         arrayOfLong[i][CentralProcessor.TickType.USER.getIndex()] = arrayOfLong[i][CentralProcessor.TickType.USER.getIndex()] / 10000L;
/* 316 */         arrayOfLong[i][CentralProcessor.TickType.IRQ.getIndex()] = arrayOfLong[i][CentralProcessor.TickType.IRQ.getIndex()] / 10000L;
/* 317 */         arrayOfLong[i][CentralProcessor.TickType.SOFTIRQ.getIndex()] = arrayOfLong[i][CentralProcessor.TickType.SOFTIRQ.getIndex()] / 10000L;
/* 318 */         arrayOfLong[i][CentralProcessor.TickType.IDLE.getIndex()] = arrayOfLong[i][CentralProcessor.TickType.IDLE.getIndex()] / 10000L;
/*     */       } 
/*     */     } 
/* 321 */     return arrayOfLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public long queryContextSwitches() {
/* 326 */     return ((Long)SystemInformation.queryContextSwitchCounters().getOrDefault(SystemInformation.ContextSwitchProperty.CONTEXTSWITCHESPERSEC, 
/* 327 */         Long.valueOf(0L))).longValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public long queryInterrupts() {
/* 332 */     return ((Long)ProcessorInformation.queryInterruptCounters().getOrDefault(ProcessorInformation.InterruptsProperty.INTERRUPTSPERSEC, Long.valueOf(0L))).longValue();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\windows\WindowsCentralProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */