/*     */ package oshi.hardware.platform.linux;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.stream.LongStream;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.linux.Lshw;
/*     */ import oshi.driver.linux.proc.CpuStat;
/*     */ import oshi.hardware.CentralProcessor;
/*     */ import oshi.hardware.common.AbstractCentralProcessor;
/*     */ import oshi.jna.platform.linux.LinuxLibc;
/*     */ import oshi.software.os.linux.LinuxOperatingSystem;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.FileUtil;
/*     */ import oshi.util.GlobalConfig;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.linux.ProcPath;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ final class LinuxCentralProcessor
/*     */   extends AbstractCentralProcessor
/*     */ {
/*     */   private static final String CPUFREQ_PATH = "oshi.cpu.freq.path";
/*     */   
/*     */   protected CentralProcessor.ProcessorIdentifier queryProcessorId() {
/*  58 */     String str1 = "";
/*  59 */     String str2 = "";
/*  60 */     String str3 = "";
/*  61 */     String str4 = "";
/*  62 */     String str5 = "";
/*     */     
/*  64 */     long l = 0L;
/*  65 */     boolean bool = false;
/*     */     
/*  67 */     StringBuilder stringBuilder = new StringBuilder();
/*  68 */     String[] arrayOfString = new String[0];
/*  69 */     List list = FileUtil.readFile(ProcPath.CPUINFO);
/*  70 */     for (String str : list) {
/*  71 */       String[] arrayOfString1 = ParseUtil.whitespacesColonWhitespace.split(str);
/*  72 */       if (arrayOfString1.length < 2) {
/*     */         
/*  74 */         if (str.startsWith("CPU architecture: ")) {
/*  75 */           str3 = str.replace("CPU architecture: ", "").trim();
/*     */         }
/*     */         continue;
/*     */       } 
/*  79 */       switch (arrayOfString1[0]) {
/*     */         case "vendor_id":
/*     */         case "CPU implementer":
/*  82 */           str1 = arrayOfString1[1];
/*     */         
/*     */         case "model name":
/*     */         case "Processor":
/*  86 */           str2 = arrayOfString1[1];
/*     */         
/*     */         case "flags":
/*  89 */           arrayOfString = arrayOfString1[1].toLowerCase().split(" ");
/*  90 */           for (String str7 : arrayOfString) {
/*  91 */             if ("lm".equals(str7)) {
/*  92 */               bool = true;
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         
/*     */         case "stepping":
/*  98 */           str5 = arrayOfString1[1];
/*     */         
/*     */         case "CPU variant":
/* 101 */           if (!stringBuilder.toString().startsWith("r")) {
/* 102 */             stringBuilder.insert(0, "r" + arrayOfString1[1]);
/*     */           }
/*     */         
/*     */         case "CPU revision":
/* 106 */           if (!stringBuilder.toString().contains("p")) {
/* 107 */             stringBuilder.append('p').append(arrayOfString1[1]);
/*     */           }
/*     */         
/*     */         case "model":
/*     */         case "CPU part":
/* 112 */           str4 = arrayOfString1[1];
/*     */         
/*     */         case "cpu family":
/* 115 */           str3 = arrayOfString1[1];
/*     */         
/*     */         case "cpu MHz":
/* 118 */           l = ParseUtil.parseHertz(arrayOfString1[1]);
/*     */       } 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 124 */     if (str2.contains("Hz")) {
/*     */       
/* 126 */       l = -1L;
/*     */     } else {
/*     */       
/* 129 */       long l1 = Lshw.queryCpuCapacity();
/* 130 */       if (l1 > l) {
/* 131 */         l = l1;
/*     */       }
/*     */     } 
/* 134 */     if (str5.isEmpty()) {
/* 135 */       str5 = stringBuilder.toString();
/*     */     }
/* 137 */     String str6 = getProcessorID(str1, str5, str4, str3, arrayOfString);
/* 138 */     if (str1.startsWith("0x")) {
/* 139 */       List list1 = ExecutingCommand.runNative("lscpu");
/* 140 */       for (String str : list1) {
/* 141 */         if (str.startsWith("Architecture:")) {
/* 142 */           str1 = str.replace("Architecture:", "").trim();
/*     */         }
/*     */       } 
/*     */     } 
/* 146 */     return new CentralProcessor.ProcessorIdentifier(str1, str2, str3, str4, str5, str6, bool, l);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<CentralProcessor.LogicalProcessor> initProcessorCounts() {
/* 152 */     Map<Integer, Integer> map = mapNumaNodes();
/* 153 */     List list = FileUtil.readFile(ProcPath.CPUINFO);
/* 154 */     ArrayList<CentralProcessor.LogicalProcessor> arrayList = new ArrayList();
/* 155 */     int i = 0;
/* 156 */     int j = 0;
/* 157 */     int k = 0;
/* 158 */     boolean bool = true;
/* 159 */     for (String str : list) {
/*     */       
/* 161 */       if (str.startsWith("processor")) {
/* 162 */         if (!bool) {
/* 163 */           arrayList.add(new CentralProcessor.LogicalProcessor(i, j, k, ((Integer)map
/* 164 */                 .getOrDefault(Integer.valueOf(i), Integer.valueOf(0))).intValue()));
/*     */         } else {
/* 166 */           bool = false;
/*     */         } 
/* 168 */         i = ParseUtil.parseLastInt(str, 0); continue;
/* 169 */       }  if (str.startsWith("core id") || str.startsWith("cpu number")) {
/*     */         
/* 171 */         j = ParseUtil.parseLastInt(str, 0); continue;
/* 172 */       }  if (str.startsWith("physical id")) {
/* 173 */         k = ParseUtil.parseLastInt(str, 0);
/*     */       }
/*     */     } 
/* 176 */     arrayList.add(new CentralProcessor.LogicalProcessor(i, j, k, ((Integer)map
/* 177 */           .getOrDefault(Integer.valueOf(i), Integer.valueOf(0))).intValue()));
/*     */     
/* 179 */     return arrayList;
/*     */   }
/*     */   
/*     */   private static Map<Integer, Integer> mapNumaNodes() {
/* 183 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/* 185 */     List list = ExecutingCommand.runNative("lscpu -p=cpu,node");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 191 */     for (String str : list) {
/* 192 */       if (str.startsWith("#")) {
/*     */         continue;
/*     */       }
/* 195 */       String[] arrayOfString = str.split(",");
/* 196 */       if (arrayOfString.length == 2) {
/* 197 */         hashMap.put(Integer.valueOf(ParseUtil.parseIntOrDefault(arrayOfString[0], 0)), Integer.valueOf(ParseUtil.parseIntOrDefault(arrayOfString[1], 0)));
/*     */       }
/*     */     } 
/* 200 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long[] querySystemCpuLoadTicks() {
/* 206 */     long[] arrayOfLong = CpuStat.getSystemCpuLoadTicks();
/*     */     
/* 208 */     if (LongStream.of(arrayOfLong).sum() == 0L) {
/* 209 */       arrayOfLong = CpuStat.getSystemCpuLoadTicks();
/*     */     }
/* 211 */     long l = LinuxOperatingSystem.getHz();
/* 212 */     for (byte b = 0; b < arrayOfLong.length; b++) {
/* 213 */       arrayOfLong[b] = arrayOfLong[b] * 1000L / l;
/*     */     }
/* 215 */     return arrayOfLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public long[] queryCurrentFreq() {
/* 220 */     String str = GlobalConfig.get("oshi.cpu.freq.path", "");
/* 221 */     long[] arrayOfLong = new long[getLogicalProcessorCount()];
/*     */     
/* 223 */     long l = 0L; byte b1;
/* 224 */     for (b1 = 0; b1 < arrayOfLong.length; b1++) {
/* 225 */       arrayOfLong[b1] = FileUtil.getLongFromFile(str + "/cpu" + b1 + "/cpufreq/scaling_cur_freq");
/* 226 */       if (arrayOfLong[b1] == 0L) {
/* 227 */         arrayOfLong[b1] = FileUtil.getLongFromFile(str + "/cpu" + b1 + "/cpufreq/cpuinfo_cur_freq");
/*     */       }
/* 229 */       if (l < arrayOfLong[b1]) {
/* 230 */         l = arrayOfLong[b1];
/*     */       }
/*     */     } 
/* 233 */     if (l > 0L) {
/*     */       
/* 235 */       for (b1 = 0; b1 < arrayOfLong.length; b1++) {
/* 236 */         arrayOfLong[b1] = arrayOfLong[b1] * 1000L;
/*     */       }
/* 238 */       return arrayOfLong;
/*     */     } 
/*     */     
/* 241 */     Arrays.fill(arrayOfLong, -1L);
/* 242 */     List list = FileUtil.readFile(ProcPath.CPUINFO);
/* 243 */     byte b2 = 0;
/* 244 */     for (String str1 : list) {
/* 245 */       if (str1.toLowerCase().contains("cpu mhz")) {
/* 246 */         arrayOfLong[b2] = Math.round(ParseUtil.parseLastDouble(str1, 0.0D) * 1000000.0D);
/* 247 */         if (++b2 >= arrayOfLong.length) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } 
/* 252 */     return arrayOfLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public long queryMaxFreq() {
/* 257 */     String str = GlobalConfig.get("oshi.cpu.freq.path", "");
/* 258 */     long l = Arrays.stream(getCurrentFreq()).max().orElse(-1L);
/*     */     
/* 260 */     if (l > 0L) {
/* 261 */       l /= 1000L;
/*     */     }
/*     */ 
/*     */     
/* 265 */     File file = new File(str + "/cpufreq");
/* 266 */     File[] arrayOfFile = file.listFiles();
/* 267 */     if (arrayOfFile != null) {
/* 268 */       for (byte b = 0; b < arrayOfFile.length; b++) {
/* 269 */         File file1 = arrayOfFile[b];
/* 270 */         if (file1.getName().startsWith("policy")) {
/* 271 */           long l1 = FileUtil.getLongFromFile(str + "/cpufreq/" + file1.getName() + "/scaling_max_freq");
/* 272 */           if (l1 == 0L) {
/* 273 */             l1 = FileUtil.getLongFromFile(str + "/cpufreq/" + file1.getName() + "/cpuinfo_max_freq");
/*     */           }
/* 275 */           if (l < l1) {
/* 276 */             l = l1;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/* 281 */     if (l > 0L) {
/*     */       
/* 283 */       l *= 1000L;
/*     */ 
/*     */       
/* 286 */       long l1 = Lshw.queryCpuCapacity();
/* 287 */       return (l1 > l) ? l1 : l;
/*     */     } 
/* 289 */     return -1L;
/*     */   }
/*     */ 
/*     */   
/*     */   public double[] getSystemLoadAverage(int paramInt) {
/* 294 */     if (paramInt < 1 || paramInt > 3) {
/* 295 */       throw new IllegalArgumentException("Must include from one to three elements.");
/*     */     }
/* 297 */     double[] arrayOfDouble = new double[paramInt];
/* 298 */     int i = LinuxLibc.INSTANCE.getloadavg(arrayOfDouble, paramInt);
/* 299 */     if (i < paramInt) {
/* 300 */       for (int j = Math.max(i, 0); j < arrayOfDouble.length; j++) {
/* 301 */         arrayOfDouble[j] = -1.0D;
/*     */       }
/*     */     }
/* 304 */     return arrayOfDouble;
/*     */   }
/*     */ 
/*     */   
/*     */   public long[][] queryProcessorCpuLoadTicks() {
/* 309 */     long[][] arrayOfLong = CpuStat.getProcessorCpuLoadTicks(getLogicalProcessorCount());
/*     */ 
/*     */ 
/*     */     
/* 313 */     if (LongStream.of(arrayOfLong[0]).sum() == 0L) {
/* 314 */       arrayOfLong = CpuStat.getProcessorCpuLoadTicks(getLogicalProcessorCount());
/*     */     }
/*     */     
/* 317 */     long l = LinuxOperatingSystem.getHz();
/* 318 */     for (byte b = 0; b < arrayOfLong.length; b++) {
/* 319 */       for (byte b1 = 0; b1 < (arrayOfLong[b]).length; b1++) {
/* 320 */         arrayOfLong[b][b1] = arrayOfLong[b][b1] * 1000L / l;
/*     */       }
/*     */     } 
/* 323 */     return arrayOfLong;
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
/*     */   private static String getProcessorID(String paramString1, String paramString2, String paramString3, String paramString4, String[] paramArrayOfString) {
/* 344 */     boolean bool = false;
/* 345 */     String str = "Processor Information";
/* 346 */     for (String str1 : ExecutingCommand.runNative("dmidecode -t 4")) {
/* 347 */       if (!bool && str1.contains(str)) {
/* 348 */         str = "ID:";
/* 349 */         bool = true; continue;
/* 350 */       }  if (bool && str1.contains(str)) {
/* 351 */         return str1.split(str)[1].trim();
/*     */       }
/*     */     } 
/*     */     
/* 355 */     str = "eax=";
/* 356 */     for (String str1 : ExecutingCommand.runNative("cpuid -1r")) {
/* 357 */       if (str1.contains(str) && str1.trim().startsWith("0x00000001")) {
/* 358 */         String str2 = "";
/* 359 */         String str3 = "";
/* 360 */         for (String str4 : ParseUtil.whitespaces.split(str1)) {
/* 361 */           if (str4.startsWith("eax=")) {
/* 362 */             str2 = ParseUtil.removeMatchingString(str4, "eax=0x");
/* 363 */           } else if (str4.startsWith("edx=")) {
/* 364 */             str3 = ParseUtil.removeMatchingString(str4, "edx=0x");
/*     */           } 
/*     */         } 
/* 367 */         return str3 + str2;
/*     */       } 
/*     */     } 
/*     */     
/* 371 */     if (paramString1.startsWith("0x")) {
/* 372 */       return createMIDR(paramString1, paramString2, paramString3, paramString4) + "00000000";
/*     */     }
/* 374 */     return createProcessorID(paramString2, paramString3, paramString4, paramArrayOfString);
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
/*     */   private static String createMIDR(String paramString1, String paramString2, String paramString3, String paramString4) {
/* 391 */     int i = 0;
/*     */     
/* 393 */     if (paramString2.startsWith("r") && paramString2.contains("p")) {
/* 394 */       String[] arrayOfString = paramString2.substring(1).split("p");
/*     */       
/* 396 */       i |= ParseUtil.parseLastInt(arrayOfString[1], 0);
/*     */       
/* 398 */       i |= ParseUtil.parseLastInt(arrayOfString[0], 0) << 20;
/*     */     } 
/*     */     
/* 401 */     i |= ParseUtil.parseLastInt(paramString3, 0) << 4;
/*     */     
/* 403 */     i |= ParseUtil.parseLastInt(paramString4, 0) << 16;
/*     */     
/* 405 */     i |= ParseUtil.parseLastInt(paramString1, 0) << 24;
/*     */     
/* 407 */     return String.format("%08X", new Object[] { Integer.valueOf(i) });
/*     */   }
/*     */ 
/*     */   
/*     */   public long queryContextSwitches() {
/* 412 */     return CpuStat.getContextSwitches();
/*     */   }
/*     */ 
/*     */   
/*     */   public long queryInterrupts() {
/* 417 */     return CpuStat.getInterrupts();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\linux\LinuxCentralProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */