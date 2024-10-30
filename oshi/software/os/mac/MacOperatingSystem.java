/*     */ package oshi.software.os.mac;
/*     */ 
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.platform.mac.SystemB;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import java.util.Set;
/*     */ import java.util.stream.Collectors;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.mac.Who;
/*     */ import oshi.driver.mac.WindowInfo;
/*     */ import oshi.software.common.AbstractOperatingSystem;
/*     */ import oshi.software.os.FileSystem;
/*     */ import oshi.software.os.InternetProtocolStats;
/*     */ import oshi.software.os.NetworkParams;
/*     */ import oshi.software.os.OSDesktopWindow;
/*     */ import oshi.software.os.OSProcess;
/*     */ import oshi.software.os.OSService;
/*     */ import oshi.software.os.OSSession;
/*     */ import oshi.software.os.OperatingSystem;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.FileUtil;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.Util;
/*     */ import oshi.util.platform.mac.SysctlUtil;
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
/*     */ public class MacOperatingSystem
/*     */   extends AbstractOperatingSystem
/*     */ {
/*  72 */   private static final Logger LOG = LoggerFactory.getLogger(MacOperatingSystem.class);
/*     */   
/*     */   public static final String MACOS_VERSIONS_PROPERTIES = "oshi.macos.versions.properties";
/*     */   
/*     */   private static final String SYSTEM_LIBRARY_LAUNCH_AGENTS = "/System/Library/LaunchAgents";
/*     */   
/*     */   private static final String SYSTEM_LIBRARY_LAUNCH_DAEMONS = "/System/Library/LaunchDaemons";
/*  79 */   private int maxProc = 1024;
/*     */   
/*     */   private final String osXVersion;
/*     */   private final int major;
/*     */   private final int minor;
/*     */   private static final long BOOTTIME;
/*     */   
/*     */   static {
/*  87 */     SystemB.Timeval timeval = new SystemB.Timeval();
/*  88 */     if (!SysctlUtil.sysctl("kern.boottime", (Structure)timeval) || timeval.tv_sec.longValue() == 0L) {
/*     */ 
/*     */       
/*  91 */       BOOTTIME = ParseUtil.parseLongOrDefault(
/*  92 */           ExecutingCommand.getFirstAnswer("sysctl -n kern.boottime").split(",")[0].replaceAll("\\D", ""), 
/*  93 */           System.currentTimeMillis() / 1000L);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  98 */       BOOTTIME = timeval.tv_sec.longValue();
/*     */     } 
/*     */   }
/*     */   
/*     */   public MacOperatingSystem() {
/* 103 */     String str = System.getProperty("os.version");
/* 104 */     int i = ParseUtil.getFirstIntValue(str);
/* 105 */     int j = ParseUtil.getNthIntValue(str, 2);
/*     */     
/* 107 */     if (i == 10 && j > 15) {
/* 108 */       String str1 = ExecutingCommand.getFirstAnswer("sw_vers -productVersion");
/* 109 */       if (!str1.isEmpty()) {
/* 110 */         str = str1;
/*     */       }
/* 112 */       i = ParseUtil.getFirstIntValue(str);
/* 113 */       j = ParseUtil.getNthIntValue(str, 2);
/*     */     } 
/* 115 */     this.osXVersion = str;
/* 116 */     this.major = i;
/* 117 */     this.minor = j;
/*     */     
/* 119 */     this.maxProc = SysctlUtil.sysctl("kern.maxproc", 4096);
/*     */   }
/*     */ 
/*     */   
/*     */   public String queryManufacturer() {
/* 124 */     return "Apple";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Pair<String, OperatingSystem.OSVersionInfo> queryFamilyVersionInfo() {
/* 130 */     String str1 = (this.major > 10 || (this.major == 10 && this.minor >= 12)) ? "macOS" : System.getProperty("os.name");
/* 131 */     String str2 = parseCodeName();
/* 132 */     String str3 = SysctlUtil.sysctl("kern.osversion", "");
/* 133 */     return new Pair(str1, new OperatingSystem.OSVersionInfo(this.osXVersion, str2, str3));
/*     */   }
/*     */   
/*     */   private String parseCodeName() {
/* 137 */     Properties properties = FileUtil.readPropertiesFromFilename("oshi.macos.versions.properties");
/* 138 */     String str = null;
/* 139 */     if (this.major > 10) {
/* 140 */       str = properties.getProperty(Integer.toString(this.major));
/* 141 */     } else if (this.major == 10) {
/* 142 */       str = properties.getProperty(this.major + "." + this.minor);
/*     */     } 
/* 144 */     if (Util.isBlank(str)) {
/* 145 */       LOG.warn("Unable to parse version {}.{} to a codename.", Integer.valueOf(this.major), Integer.valueOf(this.minor));
/*     */     }
/* 147 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int queryBitness(int paramInt) {
/* 152 */     if (paramInt == 64 || (this.major == 10 && this.minor > 6)) {
/* 153 */       return 64;
/*     */     }
/* 155 */     return ParseUtil.parseIntOrDefault(ExecutingCommand.getFirstAnswer("getconf LONG_BIT"), 32);
/*     */   }
/*     */ 
/*     */   
/*     */   public FileSystem getFileSystem() {
/* 160 */     return (FileSystem)new MacFileSystem();
/*     */   }
/*     */ 
/*     */   
/*     */   public InternetProtocolStats getInternetProtocolStats() {
/* 165 */     return (InternetProtocolStats)new MacInternetProtocolStats(isElevated());
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSSession> getSessions() {
/* 170 */     return USE_WHO_COMMAND ? super.getSessions() : Who.queryUtxent();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSProcess> queryAllProcesses() {
/* 175 */     ArrayList<OSProcess> arrayList = new ArrayList();
/* 176 */     int[] arrayOfInt = new int[this.maxProc];
/* 177 */     int i = SystemB.INSTANCE.proc_listpids(1, 0, arrayOfInt, arrayOfInt.length * SystemB.INT_SIZE) / SystemB.INT_SIZE;
/*     */     
/* 179 */     for (byte b = 0; b < i; b++) {
/*     */ 
/*     */       
/* 182 */       if (arrayOfInt[b] != 0) {
/* 183 */         OSProcess oSProcess = getProcess(arrayOfInt[b]);
/* 184 */         if (oSProcess != null) {
/* 185 */           arrayList.add(oSProcess);
/*     */         }
/*     */       } 
/*     */     } 
/* 189 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public OSProcess getProcess(int paramInt) {
/* 194 */     MacOSProcess macOSProcess = new MacOSProcess(paramInt, this.minor);
/* 195 */     return macOSProcess.getState().equals(OSProcess.State.INVALID) ? null : (OSProcess)macOSProcess;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSProcess> queryChildProcesses(int paramInt) {
/* 200 */     List<OSProcess> list = queryAllProcesses();
/* 201 */     Set set = getChildrenOrDescendants(list, paramInt, false);
/* 202 */     return (List<OSProcess>)list.stream().filter(paramOSProcess -> paramSet.contains(Integer.valueOf(paramOSProcess.getProcessID()))).collect(Collectors.toList());
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSProcess> queryDescendantProcesses(int paramInt) {
/* 207 */     List<OSProcess> list = queryAllProcesses();
/* 208 */     Set set = getChildrenOrDescendants(list, paramInt, true);
/* 209 */     return (List<OSProcess>)list.stream().filter(paramOSProcess -> paramSet.contains(Integer.valueOf(paramOSProcess.getProcessID()))).collect(Collectors.toList());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getProcessId() {
/* 214 */     return SystemB.INSTANCE.getpid();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getProcessCount() {
/* 219 */     return SystemB.INSTANCE.proc_listpids(1, 0, null, 0) / SystemB.INT_SIZE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getThreadCount() {
/* 226 */     int[] arrayOfInt = new int[getProcessCount() + 10];
/* 227 */     int i = SystemB.INSTANCE.proc_listpids(1, 0, arrayOfInt, arrayOfInt.length) / SystemB.INT_SIZE;
/*     */     
/* 229 */     int j = 0;
/* 230 */     SystemB.ProcTaskInfo procTaskInfo = new SystemB.ProcTaskInfo();
/* 231 */     for (byte b = 0; b < i; b++) {
/* 232 */       int k = SystemB.INSTANCE.proc_pidinfo(arrayOfInt[b], 4, 0L, (Structure)procTaskInfo, procTaskInfo.size());
/* 233 */       if (k != -1) {
/* 234 */         j += procTaskInfo.pti_threadnum;
/*     */       }
/*     */     } 
/* 237 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSystemUptime() {
/* 242 */     return System.currentTimeMillis() / 1000L - BOOTTIME;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSystemBootTime() {
/* 247 */     return BOOTTIME;
/*     */   }
/*     */ 
/*     */   
/*     */   public NetworkParams getNetworkParams() {
/* 252 */     return (NetworkParams)new MacNetworkParams();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public OSService[] getServices() {
/* 258 */     ArrayList<OSService> arrayList = new ArrayList();
/* 259 */     HashSet<String> hashSet = new HashSet();
/* 260 */     for (OSProcess oSProcess : getChildProcesses(1, OperatingSystem.ProcessFiltering.ALL_PROCESSES, OperatingSystem.ProcessSorting.PID_ASC, 0)) {
/* 261 */       OSService oSService = new OSService(oSProcess.getName(), oSProcess.getProcessID(), OSService.State.RUNNING);
/* 262 */       arrayList.add(oSService);
/* 263 */       hashSet.add(oSProcess.getName());
/*     */     } 
/*     */     
/* 266 */     ArrayList arrayList1 = new ArrayList();
/* 267 */     File file = new File("/System/Library/LaunchAgents");
/* 268 */     if (file.exists() && file.isDirectory()) {
/* 269 */       arrayList1.addAll(Arrays.asList(file.listFiles((paramFile, paramString) -> paramString.toLowerCase().endsWith(".plist"))));
/*     */     } else {
/* 271 */       LOG.error("Directory: /System/Library/LaunchAgents does not exist");
/*     */     } 
/* 273 */     file = new File("/System/Library/LaunchDaemons");
/* 274 */     if (file.exists() && file.isDirectory()) {
/* 275 */       arrayList1.addAll(Arrays.asList(file.listFiles((paramFile, paramString) -> paramString.toLowerCase().endsWith(".plist"))));
/*     */     } else {
/* 277 */       LOG.error("Directory: /System/Library/LaunchDaemons does not exist");
/*     */     } 
/* 279 */     for (File file1 : arrayList1) {
/*     */       
/* 281 */       String str1 = file1.getName().substring(0, file1.getName().length() - 6);
/* 282 */       int i = str1.lastIndexOf('.');
/* 283 */       String str2 = (i < 0 || i > str1.length() - 2) ? str1 : str1.substring(i + 1);
/* 284 */       if (!hashSet.contains(str1) && !hashSet.contains(str2)) {
/* 285 */         OSService oSService = new OSService(str1, 0, OSService.State.STOPPED);
/* 286 */         arrayList.add(oSService);
/*     */       } 
/*     */     } 
/* 289 */     return arrayList.<OSService>toArray(new OSService[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSDesktopWindow> getDesktopWindows(boolean paramBoolean) {
/* 294 */     return WindowInfo.queryDesktopWindows(paramBoolean);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\mac\MacOperatingSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */