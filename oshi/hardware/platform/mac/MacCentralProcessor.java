/*     */ package oshi.hardware.platform.mac;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.platform.mac.IOKit;
/*     */ import com.sun.jna.platform.mac.IOKitUtil;
/*     */ import com.sun.jna.platform.mac.SystemB;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import com.sun.jna.ptr.PointerByReference;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.function.Supplier;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.CentralProcessor;
/*     */ import oshi.hardware.common.AbstractCentralProcessor;
/*     */ import oshi.util.FormatUtil;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.Util;
/*     */ import oshi.util.platform.mac.SysctlUtil;
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
/*     */ @ThreadSafe
/*     */ final class MacCentralProcessor
/*     */   extends AbstractCentralProcessor
/*     */ {
/*  62 */   private static final Logger LOG = LoggerFactory.getLogger(MacCentralProcessor.class);
/*     */   
/*  64 */   private final Supplier<String> vendor = Memoizer.memoize(MacCentralProcessor::platformExpert);
/*  65 */   private final Supplier<Triplet<Integer, Integer, Long>> typeFamilyFreq = Memoizer.memoize(MacCentralProcessor::queryArmCpu);
/*     */   
/*     */   private static final int ROSETTA_CPUTYPE = 7;
/*     */   
/*     */   private static final int ROSETTA_CPUFAMILY = 1463508716;
/*     */   private static final int M1_CPUTYPE = 16777228;
/*     */   private static final int M1_CPUFAMILY = 458787763;
/*     */   
/*     */   protected CentralProcessor.ProcessorIdentifier queryProcessorId() {
/*  74 */     String str2, str3, str4, str5, str6, str1 = SysctlUtil.sysctl("machdep.cpu.brand_string", "");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  80 */     long l = 0L;
/*  81 */     if (str1.startsWith("Apple")) {
/*     */       
/*  83 */       str2 = this.vendor.get();
/*  84 */       str3 = "0";
/*  85 */       str4 = "0";
/*  86 */       int i = SysctlUtil.sysctl("hw.cputype", 0);
/*  87 */       int j = SysctlUtil.sysctl("hw.cpufamily", 0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  93 */       if (j == 1463508716) {
/*  94 */         i = ((Integer)((Triplet)this.typeFamilyFreq.get()).getA()).intValue();
/*  95 */         j = ((Integer)((Triplet)this.typeFamilyFreq.get()).getB()).intValue();
/*     */       } 
/*  97 */       l = ((Long)((Triplet)this.typeFamilyFreq.get()).getC()).longValue();
/*     */       
/*  99 */       str5 = String.format("0x%08x", new Object[] { Integer.valueOf(j) });
/*     */       
/* 101 */       str6 = String.format("%08x%08x", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
/*     */     } else {
/*     */       
/* 104 */       str2 = SysctlUtil.sysctl("machdep.cpu.vendor", "");
/* 105 */       int i = SysctlUtil.sysctl("machdep.cpu.stepping", -1);
/* 106 */       str3 = (i < 0) ? "" : Integer.toString(i);
/* 107 */       i = SysctlUtil.sysctl("machdep.cpu.model", -1);
/* 108 */       str4 = (i < 0) ? "" : Integer.toString(i);
/* 109 */       i = SysctlUtil.sysctl("machdep.cpu.family", -1);
/* 110 */       str5 = (i < 0) ? "" : Integer.toString(i);
/* 111 */       long l1 = 0L;
/* 112 */       l1 |= SysctlUtil.sysctl("machdep.cpu.signature", 0);
/* 113 */       l1 |= (SysctlUtil.sysctl("machdep.cpu.feature_bits", 0L) & 0xFFFFFFFFFFFFFFFFL) << 32L;
/* 114 */       str6 = String.format("%016x", new Object[] { Long.valueOf(l1) });
/*     */     } 
/* 116 */     if (l == 0L) {
/* 117 */       l = SysctlUtil.sysctl("hw.cpufrequency", 0L);
/*     */     }
/* 119 */     boolean bool = (SysctlUtil.sysctl("hw.cpu64bit_capable", 0) != 0) ? true : false;
/*     */     
/* 121 */     return new CentralProcessor.ProcessorIdentifier(str2, str1, str5, str4, str3, str6, bool, l);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<CentralProcessor.LogicalProcessor> initProcessorCounts() {
/* 127 */     int i = SysctlUtil.sysctl("hw.logicalcpu", 1);
/* 128 */     int j = SysctlUtil.sysctl("hw.physicalcpu", 1);
/* 129 */     int k = SysctlUtil.sysctl("hw.packages", 1);
/* 130 */     ArrayList<CentralProcessor.LogicalProcessor> arrayList = new ArrayList(i);
/* 131 */     for (byte b = 0; b < i; b++) {
/* 132 */       arrayList.add(new CentralProcessor.LogicalProcessor(b, b * j / i, b * k / i));
/*     */     }
/*     */     
/* 135 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public long[] querySystemCpuLoadTicks() {
/* 140 */     long[] arrayOfLong = new long[(CentralProcessor.TickType.values()).length];
/* 141 */     int i = SystemB.INSTANCE.mach_host_self();
/* 142 */     SystemB.HostCpuLoadInfo hostCpuLoadInfo = new SystemB.HostCpuLoadInfo();
/* 143 */     if (0 != SystemB.INSTANCE.host_statistics(i, 3, (Structure)hostCpuLoadInfo, new IntByReference(hostCpuLoadInfo
/* 144 */           .size()))) {
/* 145 */       LOG.error("Failed to get System CPU ticks. Error code: {} ", Integer.valueOf(Native.getLastError()));
/* 146 */       return arrayOfLong;
/*     */     } 
/*     */     
/* 149 */     arrayOfLong[CentralProcessor.TickType.USER.getIndex()] = hostCpuLoadInfo.cpu_ticks[0];
/* 150 */     arrayOfLong[CentralProcessor.TickType.NICE.getIndex()] = hostCpuLoadInfo.cpu_ticks[3];
/* 151 */     arrayOfLong[CentralProcessor.TickType.SYSTEM.getIndex()] = hostCpuLoadInfo.cpu_ticks[1];
/* 152 */     arrayOfLong[CentralProcessor.TickType.IDLE.getIndex()] = hostCpuLoadInfo.cpu_ticks[2];
/*     */     
/* 154 */     return arrayOfLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public long[] queryCurrentFreq() {
/* 159 */     long[] arrayOfLong = new long[1];
/* 160 */     arrayOfLong[0] = SysctlUtil.sysctl("hw.cpufrequency", getProcessorIdentifier().getVendorFreq());
/* 161 */     return arrayOfLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public long queryMaxFreq() {
/* 166 */     return SysctlUtil.sysctl("hw.cpufrequency_max", getProcessorIdentifier().getVendorFreq());
/*     */   }
/*     */ 
/*     */   
/*     */   public double[] getSystemLoadAverage(int paramInt) {
/* 171 */     if (paramInt < 1 || paramInt > 3) {
/* 172 */       throw new IllegalArgumentException("Must include from one to three elements.");
/*     */     }
/* 174 */     double[] arrayOfDouble = new double[paramInt];
/* 175 */     int i = SystemB.INSTANCE.getloadavg(arrayOfDouble, paramInt);
/* 176 */     if (i < paramInt) {
/* 177 */       Arrays.fill(arrayOfDouble, -1.0D);
/*     */     }
/* 179 */     return arrayOfDouble;
/*     */   }
/*     */ 
/*     */   
/*     */   public long[][] queryProcessorCpuLoadTicks() {
/* 184 */     long[][] arrayOfLong = new long[getLogicalProcessorCount()][(CentralProcessor.TickType.values()).length];
/*     */     
/* 186 */     int i = SystemB.INSTANCE.mach_host_self();
/*     */     
/* 188 */     IntByReference intByReference1 = new IntByReference();
/* 189 */     PointerByReference pointerByReference = new PointerByReference();
/* 190 */     IntByReference intByReference2 = new IntByReference();
/* 191 */     if (0 != SystemB.INSTANCE.host_processor_info(i, 2, intByReference1, pointerByReference, intByReference2)) {
/*     */       
/* 193 */       LOG.error("Failed to update CPU Load. Error code: {}", Integer.valueOf(Native.getLastError()));
/* 194 */       return arrayOfLong;
/*     */     } 
/*     */     
/* 197 */     int[] arrayOfInt = pointerByReference.getValue().getIntArray(0L, intByReference2.getValue());
/* 198 */     for (byte b = 0; b < intByReference1.getValue(); b++) {
/* 199 */       int j = b * 4;
/* 200 */       arrayOfLong[b][CentralProcessor.TickType.USER.getIndex()] = FormatUtil.getUnsignedInt(arrayOfInt[j + 0]);
/* 201 */       arrayOfLong[b][CentralProcessor.TickType.NICE.getIndex()] = FormatUtil.getUnsignedInt(arrayOfInt[j + 3]);
/* 202 */       arrayOfLong[b][CentralProcessor.TickType.SYSTEM.getIndex()] = 
/* 203 */         FormatUtil.getUnsignedInt(arrayOfInt[j + 1]);
/* 204 */       arrayOfLong[b][CentralProcessor.TickType.IDLE.getIndex()] = FormatUtil.getUnsignedInt(arrayOfInt[j + 2]);
/*     */     } 
/* 206 */     return arrayOfLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long queryContextSwitches() {
/* 214 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long queryInterrupts() {
/* 222 */     return 0L;
/*     */   }
/*     */   
/*     */   private static String platformExpert() {
/* 226 */     String str = null;
/* 227 */     IOKit.IOService iOService = IOKitUtil.getMatchingService("IOPlatformExpertDevice");
/* 228 */     if (iOService != null) {
/*     */       
/* 230 */       byte[] arrayOfByte = iOService.getByteArrayProperty("manufacturer");
/* 231 */       if (arrayOfByte != null) {
/* 232 */         str = Native.toString(arrayOfByte, StandardCharsets.UTF_8);
/*     */       }
/* 234 */       iOService.release();
/*     */     } 
/* 236 */     return Util.isBlank(str) ? "Apple Inc." : str;
/*     */   }
/*     */   
/*     */   private static Triplet<Integer, Integer, Long> queryArmCpu() {
/* 240 */     int i = 7;
/* 241 */     int j = 1463508716;
/* 242 */     long l = 0L;
/*     */ 
/*     */     
/* 245 */     IOKit.IOIterator iOIterator = IOKitUtil.getMatchingServices("IOPlatformDevice");
/* 246 */     if (iOIterator != null) {
/* 247 */       HashSet<String> hashSet = new HashSet();
/* 248 */       IOKit.IORegistryEntry iORegistryEntry = iOIterator.next();
/* 249 */       while (iORegistryEntry != null) {
/* 250 */         if (iORegistryEntry.getName().startsWith("cpu")) {
/*     */           
/* 252 */           byte[] arrayOfByte = iORegistryEntry.getByteArrayProperty("clock-frequency");
/* 253 */           if (arrayOfByte != null) {
/* 254 */             long l1 = ParseUtil.byteArrayToLong(arrayOfByte, arrayOfByte.length, false) * 1000L;
/* 255 */             if (l1 > l) {
/* 256 */               l = l1;
/*     */             }
/*     */           } 
/*     */           
/* 260 */           arrayOfByte = iORegistryEntry.getByteArrayProperty("compatible");
/* 261 */           if (arrayOfByte != null) {
/* 262 */             for (String str : (new String(arrayOfByte, StandardCharsets.UTF_8)).split("\000")) {
/* 263 */               if (!str.isEmpty()) {
/* 264 */                 hashSet.add(str);
/*     */               }
/*     */             } 
/*     */           }
/*     */         } 
/* 269 */         iORegistryEntry.release();
/* 270 */         iORegistryEntry = iOIterator.next();
/*     */       } 
/* 272 */       iOIterator.release();
/*     */ 
/*     */ 
/*     */       
/* 276 */       List<String> list = Arrays.asList(new String[] { "ARM,v8", "apple,firestorm", "apple,icestorm" });
/* 277 */       hashSet.retainAll(list);
/* 278 */       if (hashSet.size() == list.size()) {
/* 279 */         i = 16777228;
/* 280 */         j = 458787763;
/*     */       } 
/*     */     } 
/* 283 */     return new Triplet(Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\mac\MacCentralProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */