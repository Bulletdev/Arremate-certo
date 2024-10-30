/*     */ package oshi.software.os.unix.aix;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.platform.unix.aix.Perfstat;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collectors;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.unix.aix.Uptime;
/*     */ import oshi.driver.unix.aix.Who;
/*     */ import oshi.driver.unix.aix.perfstat.PerfstatConfig;
/*     */ import oshi.driver.unix.aix.perfstat.PerfstatProcess;
/*     */ import oshi.jna.platform.unix.aix.AixLibc;
/*     */ import oshi.software.common.AbstractOperatingSystem;
/*     */ import oshi.software.os.FileSystem;
/*     */ import oshi.software.os.InternetProtocolStats;
/*     */ import oshi.software.os.NetworkParams;
/*     */ import oshi.software.os.OSProcess;
/*     */ import oshi.software.os.OSService;
/*     */ import oshi.software.os.OperatingSystem;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.Util;
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
/*     */ @ThreadSafe
/*     */ public class AixOperatingSystem
/*     */   extends AbstractOperatingSystem
/*     */ {
/*  71 */   private final Supplier<Perfstat.perfstat_partition_config_t> config = Memoizer.memoize(PerfstatConfig::queryConfig);
/*  72 */   Supplier<Perfstat.perfstat_process_t[]> procCpu = Memoizer.memoize(PerfstatProcess::queryProcesses, Memoizer.defaultExpiration());
/*     */   
/*  74 */   private static final long BOOTTIME = querySystemBootTimeMillis() / 1000L;
/*     */ 
/*     */ 
/*     */   
/*     */   enum PsKeywords
/*     */   {
/*  80 */     ST, PID, PPID, USER, UID, GROUP, GID, THCOUNT, PRI, VSIZE, RSSIZE, ETIME, TIME, COMM, PAGEIN, ARGS;
/*     */   }
/*     */ 
/*     */   
/*  84 */   static final String PS_COMMAND_ARGS = Arrays.<PsKeywords>stream(PsKeywords.values()).map(Enum::name).map(String::toLowerCase)
/*  85 */     .collect(Collectors.joining(","));
/*     */ 
/*     */   
/*     */   public String queryManufacturer() {
/*  89 */     return "IBM";
/*     */   }
/*     */ 
/*     */   
/*     */   public Pair<String, OperatingSystem.OSVersionInfo> queryFamilyVersionInfo() {
/*  94 */     Perfstat.perfstat_partition_config_t perfstat_partition_config_t = this.config.get();
/*     */     
/*  96 */     String str1 = System.getProperty("os.name");
/*  97 */     String str2 = System.getProperty("os.arch");
/*  98 */     String str3 = System.getProperty("os.version");
/*  99 */     if (Util.isBlank(str3)) {
/* 100 */       str3 = ExecutingCommand.getFirstAnswer("oslevel");
/*     */     }
/* 102 */     String str4 = Native.toString(perfstat_partition_config_t.OSBuild);
/* 103 */     if (Util.isBlank(str4)) {
/* 104 */       str4 = ExecutingCommand.getFirstAnswer("oslevel -s");
/*     */     } else {
/*     */       
/* 107 */       int i = str4.lastIndexOf(' ');
/* 108 */       if (i > 0 && i < str4.length()) {
/* 109 */         str4 = str4.substring(i + 1);
/*     */       }
/*     */     } 
/* 112 */     return new Pair(str1, new OperatingSystem.OSVersionInfo(str3, str2, str4));
/*     */   }
/*     */ 
/*     */   
/*     */   protected int queryBitness(int paramInt) {
/* 117 */     if (paramInt == 64) {
/* 118 */       return 64;
/*     */     }
/*     */     
/* 121 */     return ((((Perfstat.perfstat_partition_config_t)this.config.get()).conf & 0x800000) > 0) ? 64 : 32;
/*     */   }
/*     */ 
/*     */   
/*     */   public FileSystem getFileSystem() {
/* 126 */     return (FileSystem)new AixFileSystem();
/*     */   }
/*     */ 
/*     */   
/*     */   public InternetProtocolStats getInternetProtocolStats() {
/* 131 */     return (InternetProtocolStats)new AixInternetProtocolStats();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSProcess> queryAllProcesses() {
/* 136 */     return getProcessListFromPS("ps -A -o " + PS_COMMAND_ARGS, -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSProcess> queryChildProcesses(int paramInt) {
/* 141 */     List<OSProcess> list = queryAllProcesses();
/* 142 */     Set set = getChildrenOrDescendants(list, paramInt, false);
/* 143 */     return (List<OSProcess>)list.stream().filter(paramOSProcess -> paramSet.contains(Integer.valueOf(paramOSProcess.getProcessID()))).collect(Collectors.toList());
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSProcess> queryDescendantProcesses(int paramInt) {
/* 148 */     List<OSProcess> list = queryAllProcesses();
/* 149 */     Set set = getChildrenOrDescendants(list, paramInt, true);
/* 150 */     return (List<OSProcess>)list.stream().filter(paramOSProcess -> paramSet.contains(Integer.valueOf(paramOSProcess.getProcessID()))).collect(Collectors.toList());
/*     */   }
/*     */ 
/*     */   
/*     */   public OSProcess getProcess(int paramInt) {
/* 155 */     List<OSProcess> list = getProcessListFromPS("ps -o " + PS_COMMAND_ARGS + " -p ", paramInt);
/* 156 */     if (list.isEmpty()) {
/* 157 */       return null;
/*     */     }
/* 159 */     return list.get(0);
/*     */   }
/*     */   
/*     */   private List<OSProcess> getProcessListFromPS(String paramString, int paramInt) {
/* 163 */     Perfstat.perfstat_process_t[] arrayOfPerfstat_process_t = this.procCpu.get();
/* 164 */     List list = ExecutingCommand.runNative(paramString + ((paramInt < 0) ? "" : (String)Integer.valueOf(paramInt)));
/* 165 */     if (list.isEmpty() || list.size() < 2) {
/* 166 */       return Collections.emptyList();
/*     */     }
/*     */     
/* 169 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 170 */     for (Perfstat.perfstat_process_t perfstat_process_t : arrayOfPerfstat_process_t) {
/* 171 */       hashMap.put(Integer.valueOf((int)perfstat_process_t.pid), new Pair(Long.valueOf((long)perfstat_process_t.ucpu_time), Long.valueOf((long)perfstat_process_t.scpu_time)));
/*     */     }
/*     */     
/* 174 */     list.remove(0);
/*     */     
/* 176 */     ArrayList<AixOSProcess> arrayList = new ArrayList();
/* 177 */     for (String str : list) {
/* 178 */       Map<PsKeywords, String> map = ParseUtil.stringToEnumMap(PsKeywords.class, str.trim(), ' ');
/*     */       
/* 180 */       if (map.containsKey(PsKeywords.ARGS)) {
/* 181 */         arrayList.add(new AixOSProcess((paramInt < 0) ? ParseUtil.parseIntOrDefault((String)map.get(PsKeywords.PID), 0) : paramInt, map, (Map)hashMap, this.procCpu));
/*     */       }
/*     */     } 
/*     */     
/* 185 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getProcessId() {
/* 190 */     return AixLibc.INSTANCE.getpid();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getProcessCount() {
/* 195 */     return ((Perfstat.perfstat_process_t[])this.procCpu.get()).length;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getThreadCount() {
/* 200 */     long l = 0L;
/* 201 */     for (Perfstat.perfstat_process_t perfstat_process_t : (Perfstat.perfstat_process_t[])this.procCpu.get()) {
/* 202 */       l += perfstat_process_t.num_threads;
/*     */     }
/* 204 */     return (int)l;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSystemUptime() {
/* 209 */     return System.currentTimeMillis() / 1000L - BOOTTIME;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSystemBootTime() {
/* 214 */     return BOOTTIME;
/*     */   }
/*     */   
/*     */   private static long querySystemBootTimeMillis() {
/* 218 */     long l = Who.queryBootTime();
/* 219 */     if (l >= 1000L) {
/* 220 */       return l;
/*     */     }
/* 222 */     return System.currentTimeMillis() - Uptime.queryUpTime();
/*     */   }
/*     */ 
/*     */   
/*     */   public NetworkParams getNetworkParams() {
/* 227 */     return (NetworkParams)new AixNetworkParams();
/*     */   }
/*     */ 
/*     */   
/*     */   public OSService[] getServices() {
/* 232 */     ArrayList<OSService> arrayList = new ArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 247 */     List list = ExecutingCommand.runNative("lssrc -a");
/* 248 */     if (list.size() > 1) {
/* 249 */       list.remove(0);
/* 250 */       for (String str : list) {
/* 251 */         String[] arrayOfString = ParseUtil.whitespaces.split(str.trim());
/* 252 */         if (str.contains("active")) {
/* 253 */           if (arrayOfString.length == 4) {
/* 254 */             arrayList.add(new OSService(arrayOfString[0], ParseUtil.parseIntOrDefault(arrayOfString[2], 0), OSService.State.RUNNING)); continue;
/*     */           } 
/* 256 */           if (arrayOfString.length == 3)
/* 257 */             arrayList.add(new OSService(arrayOfString[0], ParseUtil.parseIntOrDefault(arrayOfString[1], 0), OSService.State.RUNNING)); 
/*     */           continue;
/*     */         } 
/* 260 */         if (str.contains("inoperative")) {
/* 261 */           arrayList.add(new OSService(arrayOfString[0], 0, OSService.State.STOPPED));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 266 */     File file = new File("/etc/rc.d/init.d");
/*     */     File[] arrayOfFile;
/* 268 */     if (file.exists() && file.isDirectory() && (arrayOfFile = file.listFiles()) != null) {
/* 269 */       for (File file1 : arrayOfFile) {
/* 270 */         String str = ExecutingCommand.getFirstAnswer(file1.getAbsolutePath() + " status");
/*     */         
/* 272 */         if (str.contains("running")) {
/* 273 */           arrayList.add(new OSService(file1.getName(), ParseUtil.parseLastInt(str, 0), OSService.State.RUNNING));
/*     */         } else {
/* 275 */           arrayList.add(new OSService(file1.getName(), 0, OSService.State.STOPPED));
/*     */         } 
/*     */       } 
/*     */     }
/* 279 */     return arrayList.<OSService>toArray(new OSService[0]);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\aix\AixOperatingSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */