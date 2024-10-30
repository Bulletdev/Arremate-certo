/*     */ package oshi.software.os.unix.openbsd;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.stream.Collectors;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.jna.platform.unix.openbsd.OpenBsdLibc;
/*     */ import oshi.software.common.AbstractOperatingSystem;
/*     */ import oshi.software.os.FileSystem;
/*     */ import oshi.software.os.InternetProtocolStats;
/*     */ import oshi.software.os.NetworkParams;
/*     */ import oshi.software.os.OSProcess;
/*     */ import oshi.software.os.OSService;
/*     */ import oshi.software.os.OperatingSystem;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.unix.openbsd.OpenBsdSysctlUtil;
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
/*     */ public class OpenBsdOperatingSystem
/*     */   extends AbstractOperatingSystem
/*     */ {
/*  65 */   private static final Logger LOG = LoggerFactory.getLogger(OpenBsdOperatingSystem.class);
/*     */   
/*  67 */   private static final long BOOTTIME = querySystemBootTime();
/*     */ 
/*     */ 
/*     */   
/*     */   enum PsKeywords
/*     */   {
/*  73 */     STATE, PID, PPID, USER, UID, GROUP, GID, PRI, VSZ, RSS, ETIME, CPUTIME, COMM, MAJFLT, MINFLT, NVCSW, NIVCSW,
/*  74 */     ARGS;
/*     */   }
/*     */   
/*  77 */   static final String PS_COMMAND_ARGS = Arrays.<PsKeywords>stream(PsKeywords.values()).map(Enum::name).map(String::toLowerCase)
/*  78 */     .collect(Collectors.joining(","));
/*     */ 
/*     */   
/*     */   public String queryManufacturer() {
/*  82 */     return "Unix/BSD";
/*     */   }
/*     */ 
/*     */   
/*     */   public Pair<String, OperatingSystem.OSVersionInfo> queryFamilyVersionInfo() {
/*  87 */     int[] arrayOfInt = new int[2];
/*  88 */     arrayOfInt[0] = 1;
/*  89 */     arrayOfInt[1] = 1;
/*  90 */     String str1 = OpenBsdSysctlUtil.sysctl(arrayOfInt, "OpenBSD");
/*  91 */     arrayOfInt[1] = 2;
/*  92 */     String str2 = OpenBsdSysctlUtil.sysctl(arrayOfInt, "");
/*  93 */     arrayOfInt[1] = 4;
/*  94 */     String str3 = OpenBsdSysctlUtil.sysctl(arrayOfInt, "");
/*  95 */     String str4 = str3.split(":")[0].replace(str1, "").replace(str2, "").trim();
/*     */     
/*  97 */     return new Pair(str1, new OperatingSystem.OSVersionInfo(str2, null, str4));
/*     */   }
/*     */ 
/*     */   
/*     */   protected int queryBitness(int paramInt) {
/* 102 */     if (paramInt < 64 && ExecutingCommand.getFirstAnswer("uname -m").indexOf("64") == -1) {
/* 103 */       return paramInt;
/*     */     }
/* 105 */     return 64;
/*     */   }
/*     */ 
/*     */   
/*     */   public FileSystem getFileSystem() {
/* 110 */     return (FileSystem)new OpenBsdFileSystem();
/*     */   }
/*     */ 
/*     */   
/*     */   public InternetProtocolStats getInternetProtocolStats() {
/* 115 */     return (InternetProtocolStats)new OpenBsdInternetProtocolStats();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSProcess> queryAllProcesses() {
/* 120 */     return getProcessListFromPS(-1);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSProcess> queryChildProcesses(int paramInt) {
/* 125 */     List<OSProcess> list = queryAllProcesses();
/* 126 */     Set set = getChildrenOrDescendants(list, paramInt, false);
/* 127 */     return (List<OSProcess>)list.stream().filter(paramOSProcess -> paramSet.contains(Integer.valueOf(paramOSProcess.getProcessID()))).collect(Collectors.toList());
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSProcess> queryDescendantProcesses(int paramInt) {
/* 132 */     List<OSProcess> list = queryAllProcesses();
/* 133 */     Set set = getChildrenOrDescendants(list, paramInt, true);
/* 134 */     return (List<OSProcess>)list.stream().filter(paramOSProcess -> paramSet.contains(Integer.valueOf(paramOSProcess.getProcessID()))).collect(Collectors.toList());
/*     */   }
/*     */ 
/*     */   
/*     */   public OSProcess getProcess(int paramInt) {
/* 139 */     List<OSProcess> list = getProcessListFromPS(paramInt);
/* 140 */     if (list.isEmpty()) {
/* 141 */       return null;
/*     */     }
/* 143 */     return list.get(0);
/*     */   }
/*     */   
/*     */   private static List<OSProcess> getProcessListFromPS(int paramInt) {
/* 147 */     ArrayList<OSProcess> arrayList = new ArrayList();
/*     */ 
/*     */     
/* 150 */     String str = "ps -awwxo " + PS_COMMAND_ARGS;
/* 151 */     if (paramInt >= 0) {
/* 152 */       str = str + " -p " + paramInt;
/*     */     }
/* 154 */     List list = ExecutingCommand.runNative(str);
/* 155 */     if (list.isEmpty() || list.size() < 2) {
/* 156 */       return arrayList;
/*     */     }
/*     */     
/* 159 */     list.remove(0);
/*     */     
/* 161 */     for (String str1 : list) {
/* 162 */       Map<PsKeywords, String> map = ParseUtil.stringToEnumMap(PsKeywords.class, str1.trim(), ' ');
/*     */       
/* 164 */       if (map.containsKey(PsKeywords.ARGS)) {
/* 165 */         arrayList.add(new OpenBsdOSProcess(
/* 166 */               (paramInt < 0) ? ParseUtil.parseIntOrDefault((String)map.get(PsKeywords.PID), 0) : paramInt, map));
/*     */       }
/*     */     } 
/* 169 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getProcessId() {
/* 174 */     return OpenBsdLibc.INSTANCE.getpid();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getProcessCount() {
/* 179 */     List list = ExecutingCommand.runNative("ps -axo pid");
/* 180 */     if (!list.isEmpty())
/*     */     {
/* 182 */       return list.size() - 1;
/*     */     }
/* 184 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getThreadCount() {
/* 192 */     List list = ExecutingCommand.runNative("ps -axHo tid");
/* 193 */     if (!list.isEmpty())
/*     */     {
/* 195 */       return list.size() - 1;
/*     */     }
/* 197 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSystemUptime() {
/* 202 */     return System.currentTimeMillis() / 1000L - BOOTTIME;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSystemBootTime() {
/* 207 */     return BOOTTIME;
/*     */   }
/*     */ 
/*     */   
/*     */   private static long querySystemBootTime() {
/* 212 */     return ParseUtil.parseLongOrDefault(
/* 213 */         ExecutingCommand.getFirstAnswer("sysctl -n kern.boottime").split(",")[0].replaceAll("\\D", ""), 
/* 214 */         System.currentTimeMillis() / 1000L);
/*     */   }
/*     */ 
/*     */   
/*     */   public NetworkParams getNetworkParams() {
/* 219 */     return (NetworkParams)new OpenBsdNetworkParams();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public OSService[] getServices() {
/* 225 */     ArrayList<OSService> arrayList = new ArrayList();
/* 226 */     HashSet<String> hashSet = new HashSet();
/* 227 */     for (OSProcess oSProcess : getChildProcesses(1, OperatingSystem.ProcessFiltering.ALL_PROCESSES, OperatingSystem.ProcessSorting.PID_ASC, 0)) {
/* 228 */       OSService oSService = new OSService(oSProcess.getName(), oSProcess.getProcessID(), OSService.State.RUNNING);
/* 229 */       arrayList.add(oSService);
/* 230 */       hashSet.add(oSProcess.getName());
/*     */     } 
/*     */     
/* 233 */     File file = new File("/etc/rc.d");
/*     */     File[] arrayOfFile;
/* 235 */     if (file.exists() && file.isDirectory() && (arrayOfFile = file.listFiles()) != null) {
/* 236 */       for (File file1 : arrayOfFile) {
/* 237 */         String str = file1.getName();
/* 238 */         if (!hashSet.contains(str)) {
/* 239 */           OSService oSService = new OSService(str, 0, OSService.State.STOPPED);
/* 240 */           arrayList.add(oSService);
/*     */         } 
/*     */       } 
/*     */     } else {
/* 244 */       LOG.error("Directory: /etc/rc.d does not exist");
/*     */     } 
/* 246 */     return arrayList.<OSService>toArray(new OSService[0]);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\openbsd\OpenBsdOperatingSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */