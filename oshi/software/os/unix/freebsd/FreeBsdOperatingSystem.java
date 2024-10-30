/*     */ package oshi.software.os.unix.freebsd;
/*     */ 
/*     */ import com.sun.jna.Structure;
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
/*     */ import oshi.driver.unix.freebsd.Who;
/*     */ import oshi.jna.platform.unix.freebsd.FreeBsdLibc;
/*     */ import oshi.software.common.AbstractOperatingSystem;
/*     */ import oshi.software.os.FileSystem;
/*     */ import oshi.software.os.InternetProtocolStats;
/*     */ import oshi.software.os.NetworkParams;
/*     */ import oshi.software.os.OSProcess;
/*     */ import oshi.software.os.OSService;
/*     */ import oshi.software.os.OSSession;
/*     */ import oshi.software.os.OperatingSystem;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.unix.freebsd.BsdSysctlUtil;
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
/*     */ public class FreeBsdOperatingSystem
/*     */   extends AbstractOperatingSystem
/*     */ {
/*  67 */   private static final Logger LOG = LoggerFactory.getLogger(FreeBsdOperatingSystem.class);
/*     */   
/*  69 */   private static final long BOOTTIME = querySystemBootTime();
/*     */ 
/*     */ 
/*     */   
/*     */   enum PsKeywords
/*     */   {
/*  75 */     STATE, PID, PPID, USER, UID, GROUP, GID, NLWP, PRI, VSZ, RSS, ETIMES, SYSTIME, TIME, COMM, MAJFLT, MINFLT,
/*  76 */     NVCSW, NIVCSW, ARGS;
/*     */   }
/*     */   
/*  79 */   static final String PS_COMMAND_ARGS = Arrays.<PsKeywords>stream(PsKeywords.values()).map(Enum::name).map(String::toLowerCase)
/*  80 */     .collect(Collectors.joining(","));
/*     */ 
/*     */   
/*     */   public String queryManufacturer() {
/*  84 */     return "Unix/BSD";
/*     */   }
/*     */ 
/*     */   
/*     */   public Pair<String, OperatingSystem.OSVersionInfo> queryFamilyVersionInfo() {
/*  89 */     String str1 = BsdSysctlUtil.sysctl("kern.ostype", "FreeBSD");
/*     */     
/*  91 */     String str2 = BsdSysctlUtil.sysctl("kern.osrelease", "");
/*  92 */     String str3 = BsdSysctlUtil.sysctl("kern.version", "");
/*  93 */     String str4 = str3.split(":")[0].replace(str1, "").replace(str2, "").trim();
/*     */     
/*  95 */     return new Pair(str1, new OperatingSystem.OSVersionInfo(str2, null, str4));
/*     */   }
/*     */ 
/*     */   
/*     */   protected int queryBitness(int paramInt) {
/* 100 */     if (paramInt < 64 && ExecutingCommand.getFirstAnswer("uname -m").indexOf("64") == -1) {
/* 101 */       return paramInt;
/*     */     }
/* 103 */     return 64;
/*     */   }
/*     */ 
/*     */   
/*     */   public FileSystem getFileSystem() {
/* 108 */     return (FileSystem)new FreeBsdFileSystem();
/*     */   }
/*     */ 
/*     */   
/*     */   public InternetProtocolStats getInternetProtocolStats() {
/* 113 */     return (InternetProtocolStats)new FreeBsdInternetProtocolStats();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSSession> getSessions() {
/* 118 */     return USE_WHO_COMMAND ? super.getSessions() : Who.queryUtxent();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSProcess> queryAllProcesses() {
/* 123 */     return getProcessListFromPS(-1);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSProcess> queryChildProcesses(int paramInt) {
/* 128 */     List<OSProcess> list = queryAllProcesses();
/* 129 */     Set set = getChildrenOrDescendants(list, paramInt, false);
/* 130 */     return (List<OSProcess>)list.stream().filter(paramOSProcess -> paramSet.contains(Integer.valueOf(paramOSProcess.getProcessID()))).collect(Collectors.toList());
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSProcess> queryDescendantProcesses(int paramInt) {
/* 135 */     List<OSProcess> list = queryAllProcesses();
/* 136 */     Set set = getChildrenOrDescendants(list, paramInt, true);
/* 137 */     return (List<OSProcess>)list.stream().filter(paramOSProcess -> paramSet.contains(Integer.valueOf(paramOSProcess.getProcessID()))).collect(Collectors.toList());
/*     */   }
/*     */ 
/*     */   
/*     */   public OSProcess getProcess(int paramInt) {
/* 142 */     List<OSProcess> list = getProcessListFromPS(paramInt);
/* 143 */     if (list.isEmpty()) {
/* 144 */       return null;
/*     */     }
/* 146 */     return list.get(0);
/*     */   }
/*     */   
/*     */   private static List<OSProcess> getProcessListFromPS(int paramInt) {
/* 150 */     ArrayList<OSProcess> arrayList = new ArrayList();
/* 151 */     String str = "ps -awwxo " + PS_COMMAND_ARGS;
/* 152 */     if (paramInt >= 0) {
/* 153 */       str = str + " -p " + paramInt;
/*     */     }
/* 155 */     List list = ExecutingCommand.runNative(str);
/* 156 */     if (list.isEmpty() || list.size() < 2) {
/* 157 */       return arrayList;
/*     */     }
/*     */     
/* 160 */     list.remove(0);
/*     */     
/* 162 */     for (String str1 : list) {
/* 163 */       Map<PsKeywords, String> map = ParseUtil.stringToEnumMap(PsKeywords.class, str1.trim(), ' ');
/*     */       
/* 165 */       if (map.containsKey(PsKeywords.ARGS)) {
/* 166 */         arrayList.add(new FreeBsdOSProcess(
/* 167 */               (paramInt < 0) ? ParseUtil.parseIntOrDefault((String)map.get(PsKeywords.PID), 0) : paramInt, map));
/*     */       }
/*     */     } 
/* 170 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getProcessId() {
/* 175 */     return FreeBsdLibc.INSTANCE.getpid();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getProcessCount() {
/* 180 */     List list = ExecutingCommand.runNative("ps -axo pid");
/* 181 */     if (!list.isEmpty())
/*     */     {
/* 183 */       return list.size() - 1;
/*     */     }
/* 185 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getThreadCount() {
/* 190 */     int i = 0;
/* 191 */     for (String str : ExecutingCommand.runNative("ps -axo nlwp")) {
/* 192 */       i += ParseUtil.parseIntOrDefault(str.trim(), 0);
/*     */     }
/* 194 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSystemUptime() {
/* 199 */     return System.currentTimeMillis() / 1000L - BOOTTIME;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSystemBootTime() {
/* 204 */     return BOOTTIME;
/*     */   }
/*     */   
/*     */   private static long querySystemBootTime() {
/* 208 */     FreeBsdLibc.Timeval timeval = new FreeBsdLibc.Timeval();
/* 209 */     if (!BsdSysctlUtil.sysctl("kern.boottime", (Structure)timeval) || timeval.tv_sec == 0L)
/*     */     {
/*     */       
/* 212 */       return ParseUtil.parseLongOrDefault(
/* 213 */           ExecutingCommand.getFirstAnswer("sysctl -n kern.boottime").split(",")[0].replaceAll("\\D", ""), 
/* 214 */           System.currentTimeMillis() / 1000L);
/*     */     }
/*     */ 
/*     */     
/* 218 */     return timeval.tv_sec;
/*     */   }
/*     */ 
/*     */   
/*     */   public NetworkParams getNetworkParams() {
/* 223 */     return (NetworkParams)new FreeBsdNetworkParams();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public OSService[] getServices() {
/* 229 */     ArrayList<OSService> arrayList = new ArrayList();
/* 230 */     HashSet<String> hashSet = new HashSet();
/* 231 */     for (OSProcess oSProcess : getChildProcesses(1, OperatingSystem.ProcessFiltering.ALL_PROCESSES, OperatingSystem.ProcessSorting.PID_ASC, 0)) {
/* 232 */       OSService oSService = new OSService(oSProcess.getName(), oSProcess.getProcessID(), OSService.State.RUNNING);
/* 233 */       arrayList.add(oSService);
/* 234 */       hashSet.add(oSProcess.getName());
/*     */     } 
/*     */     
/* 237 */     File file = new File("/etc/rc.d");
/*     */     File[] arrayOfFile;
/* 239 */     if (file.exists() && file.isDirectory() && (arrayOfFile = file.listFiles()) != null) {
/* 240 */       for (File file1 : arrayOfFile) {
/* 241 */         String str = file1.getName();
/* 242 */         if (!hashSet.contains(str)) {
/* 243 */           OSService oSService = new OSService(str, 0, OSService.State.STOPPED);
/* 244 */           arrayList.add(oSService);
/*     */         } 
/*     */       } 
/*     */     } else {
/* 248 */       LOG.error("Directory: /etc/init does not exist");
/*     */     } 
/* 250 */     return arrayList.<OSService>toArray(new OSService[0]);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\freebsd\FreeBsdOperatingSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */