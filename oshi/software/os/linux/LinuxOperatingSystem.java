/*     */ package oshi.software.os.linux;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.platform.linux.LibC;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.Set;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.linux.Who;
/*     */ import oshi.driver.linux.proc.CpuStat;
/*     */ import oshi.driver.linux.proc.ProcessStat;
/*     */ import oshi.driver.linux.proc.UpTime;
/*     */ import oshi.jna.platform.linux.LinuxLibc;
/*     */ import oshi.software.common.AbstractOperatingSystem;
/*     */ import oshi.software.os.FileSystem;
/*     */ import oshi.software.os.InternetProtocolStats;
/*     */ import oshi.software.os.NetworkParams;
/*     */ import oshi.software.os.OSProcess;
/*     */ import oshi.software.os.OSService;
/*     */ import oshi.software.os.OSSession;
/*     */ import oshi.software.os.OperatingSystem;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.FileUtil;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.linux.ProcPath;
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
/*     */ @ThreadSafe
/*     */ public class LinuxOperatingSystem
/*     */   extends AbstractOperatingSystem
/*     */ {
/*  75 */   private static final Logger LOG = LoggerFactory.getLogger(LinuxOperatingSystem.class);
/*     */   
/*     */   private static final String OS_RELEASE_LOG = "os-release: {}";
/*     */   
/*     */   private static final String LSB_RELEASE_A_LOG = "lsb_release -a: {}";
/*     */   
/*     */   private static final String LSB_RELEASE_LOG = "lsb-release: {}";
/*     */   
/*     */   private static final String RELEASE_DELIM = " release ";
/*     */   
/*     */   private static final String DOUBLE_QUOTES = "(?:^\")|(?:\"$)";
/*     */   private static final String FILENAME_PROPERTIES = "oshi.linux.filename.properties";
/*  87 */   private static final long USER_HZ = ParseUtil.parseLongOrDefault(ExecutingCommand.getFirstAnswer("getconf CLK_TCK"), 100L);
/*     */   
/*     */   static final long BOOTTIME;
/*     */ 
/*     */   
/*     */   static {
/*  93 */     long l = CpuStat.getBootTime();
/*     */     
/*  95 */     if (l == 0L) {
/*  96 */       l = System.currentTimeMillis() / 1000L - (long)UpTime.getSystemUptimeSeconds();
/*     */     }
/*  98 */     BOOTTIME = l;
/*     */   }
/*     */ 
/*     */   
/* 102 */   private static final int[] PPID_INDEX = new int[] { 3 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LinuxOperatingSystem() {
/* 110 */     getVersionInfo();
/*     */   }
/*     */ 
/*     */   
/*     */   public String queryManufacturer() {
/* 115 */     return "GNU/Linux";
/*     */   }
/*     */ 
/*     */   
/*     */   public Pair<String, OperatingSystem.OSVersionInfo> queryFamilyVersionInfo() {
/* 120 */     Triplet<String, String, String> triplet = queryFamilyVersionCodenameFromReleaseFiles();
/* 121 */     String str = null;
/* 122 */     List<CharSequence> list = FileUtil.readFile(ProcPath.VERSION);
/* 123 */     if (!list.isEmpty()) {
/* 124 */       String[] arrayOfString = ParseUtil.whitespaces.split(list.get(0));
/* 125 */       for (String str1 : arrayOfString) {
/* 126 */         if (!"Linux".equals(str1) && !"version".equals(str1)) {
/* 127 */           str = str1;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 132 */     OperatingSystem.OSVersionInfo oSVersionInfo = new OperatingSystem.OSVersionInfo((String)triplet.getB(), (String)triplet.getC(), str);
/*     */     
/* 134 */     return new Pair(triplet.getA(), oSVersionInfo);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int queryBitness(int paramInt) {
/* 139 */     if (paramInt < 64 && ExecutingCommand.getFirstAnswer("uname -m").indexOf("64") == -1) {
/* 140 */       return paramInt;
/*     */     }
/* 142 */     return 64;
/*     */   }
/*     */ 
/*     */   
/*     */   public FileSystem getFileSystem() {
/* 147 */     return (FileSystem)new LinuxFileSystem();
/*     */   }
/*     */ 
/*     */   
/*     */   public InternetProtocolStats getInternetProtocolStats() {
/* 152 */     return (InternetProtocolStats)new LinuxInternetProtocolStats();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSSession> getSessions() {
/* 157 */     return USE_WHO_COMMAND ? super.getSessions() : Who.queryUtxent();
/*     */   }
/*     */ 
/*     */   
/*     */   public OSProcess getProcess(int paramInt) {
/* 162 */     LinuxOSProcess linuxOSProcess = new LinuxOSProcess(paramInt);
/* 163 */     if (!linuxOSProcess.getState().equals(OSProcess.State.INVALID)) {
/* 164 */       return (OSProcess)linuxOSProcess;
/*     */     }
/* 166 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSProcess> queryAllProcesses() {
/* 171 */     return queryChildProcesses(-1);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSProcess> queryChildProcesses(int paramInt) {
/* 176 */     File[] arrayOfFile = ProcessStat.getPidFiles();
/* 177 */     if (paramInt >= 0)
/*     */     {
/* 179 */       return queryProcessList(getChildrenOrDescendants(getParentPidsFromProcFiles(arrayOfFile), paramInt, false));
/*     */     }
/* 181 */     HashSet<Integer> hashSet = new HashSet();
/*     */     
/* 183 */     for (File file : arrayOfFile) {
/* 184 */       int i = ParseUtil.parseIntOrDefault(file.getName(), -2);
/* 185 */       if (i != -2) {
/* 186 */         hashSet.add(Integer.valueOf(i));
/*     */       }
/*     */     } 
/* 189 */     return queryProcessList(hashSet);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSProcess> queryDescendantProcesses(int paramInt) {
/* 194 */     File[] arrayOfFile = ProcessStat.getPidFiles();
/* 195 */     return queryProcessList(getChildrenOrDescendants(getParentPidsFromProcFiles(arrayOfFile), paramInt, true));
/*     */   }
/*     */   
/*     */   private static List<OSProcess> queryProcessList(Set<Integer> paramSet) {
/* 199 */     ArrayList<LinuxOSProcess> arrayList = new ArrayList();
/* 200 */     for (Iterator<Integer> iterator = paramSet.iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/* 201 */       LinuxOSProcess linuxOSProcess = new LinuxOSProcess(i);
/* 202 */       if (!linuxOSProcess.getState().equals(OSProcess.State.INVALID)) {
/* 203 */         arrayList.add(linuxOSProcess);
/*     */       } }
/*     */     
/* 206 */     return (List)arrayList;
/*     */   }
/*     */   
/*     */   private static Map<Integer, Integer> getParentPidsFromProcFiles(File[] paramArrayOfFile) {
/* 210 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 211 */     for (File file : paramArrayOfFile) {
/* 212 */       int i = ParseUtil.parseIntOrDefault(file.getName(), 0);
/* 213 */       hashMap.put(Integer.valueOf(i), Integer.valueOf(getParentPidFromProcFile(i)));
/*     */     } 
/* 215 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   private static int getParentPidFromProcFile(int paramInt) {
/* 219 */     String str = FileUtil.getStringFromFile(String.format("/proc/%d/stat", new Object[] { Integer.valueOf(paramInt) }));
/*     */     
/* 221 */     if (str.isEmpty()) {
/* 222 */       return 0;
/*     */     }
/*     */     
/* 225 */     long[] arrayOfLong = ParseUtil.parseStringToLongArray(str, PPID_INDEX, ProcessStat.PROC_PID_STAT_LENGTH, ' ');
/* 226 */     return (int)arrayOfLong[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public int getProcessId() {
/* 231 */     return LinuxLibc.INSTANCE.getpid();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getProcessCount() {
/* 236 */     return (ProcessStat.getPidFiles()).length;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getThreadCount() {
/*     */     try {
/* 242 */       LibC.Sysinfo sysinfo = new LibC.Sysinfo();
/* 243 */       if (0 != LibC.INSTANCE.sysinfo(sysinfo)) {
/* 244 */         LOG.error("Failed to get process thread count. Error code: {}", Integer.valueOf(Native.getLastError()));
/* 245 */         return 0;
/*     */       } 
/* 247 */       return sysinfo.procs;
/* 248 */     } catch (UnsatisfiedLinkError|NoClassDefFoundError unsatisfiedLinkError) {
/* 249 */       LOG.error("Failed to get procs from sysinfo. {}", unsatisfiedLinkError.getMessage());
/*     */       
/* 251 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public long getSystemUptime() {
/* 256 */     return (long)UpTime.getSystemUptimeSeconds();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSystemBootTime() {
/* 261 */     return BOOTTIME;
/*     */   }
/*     */ 
/*     */   
/*     */   public NetworkParams getNetworkParams() {
/* 266 */     return (NetworkParams)new LinuxNetworkParams();
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
/*     */   private static Triplet<String, String, String> queryFamilyVersionCodenameFromReleaseFiles() {
/*     */     Triplet<String, String, String> triplet;
/* 285 */     if ((triplet = readDistribRelease("/etc/system-release")) != null)
/*     */     {
/*     */       
/* 288 */       return triplet;
/*     */     }
/*     */ 
/*     */     
/* 292 */     if ((triplet = readOsRelease()) != null)
/*     */     {
/*     */       
/* 295 */       return triplet;
/*     */     }
/*     */ 
/*     */     
/* 299 */     if ((triplet = execLsbRelease()) != null)
/*     */     {
/*     */       
/* 302 */       return triplet;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 308 */     if ((triplet = readLsbRelease()) != null)
/*     */     {
/*     */       
/* 311 */       return triplet;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 318 */     String str1 = getReleaseFilename();
/* 319 */     if ((triplet = readDistribRelease(str1)) != null)
/*     */     {
/*     */       
/* 322 */       return triplet;
/*     */     }
/*     */ 
/*     */     
/* 326 */     String str2 = filenameToFamily(str1.replace("/etc/", "").replace("release", "")
/* 327 */         .replace("version", "").replace("-", "").replace("_", ""));
/* 328 */     return new Triplet(str2, "unknown", "unknown");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Triplet<String, String, String> readOsRelease() {
/* 338 */     String str1 = null;
/* 339 */     String str2 = "unknown";
/* 340 */     String str3 = "unknown";
/* 341 */     List list = FileUtil.readFile("/etc/os-release");
/*     */     
/* 343 */     for (String str : list) {
/* 344 */       if (str.startsWith("VERSION=")) {
/* 345 */         LOG.debug("os-release: {}", str);
/*     */ 
/*     */ 
/*     */         
/* 349 */         str = str.replace("VERSION=", "").replaceAll("(?:^\")|(?:\"$)", "").trim();
/* 350 */         String[] arrayOfString = str.split("[()]");
/* 351 */         if (arrayOfString.length <= 1)
/*     */         {
/* 353 */           arrayOfString = str.split(", ");
/*     */         }
/* 355 */         if (arrayOfString.length > 0) {
/* 356 */           str2 = arrayOfString[0].trim();
/*     */         }
/* 358 */         if (arrayOfString.length > 1)
/* 359 */           str3 = arrayOfString[1].trim();  continue;
/*     */       } 
/* 361 */       if (str.startsWith("NAME=") && str1 == null) {
/* 362 */         LOG.debug("os-release: {}", str);
/*     */ 
/*     */         
/* 365 */         str1 = str.replace("NAME=", "").replaceAll("(?:^\")|(?:\"$)", "").trim(); continue;
/* 366 */       }  if (str.startsWith("VERSION_ID=") && str2.equals("unknown")) {
/* 367 */         LOG.debug("os-release: {}", str);
/*     */ 
/*     */         
/* 370 */         str2 = str.replace("VERSION_ID=", "").replaceAll("(?:^\")|(?:\"$)", "").trim();
/*     */       } 
/*     */     } 
/* 373 */     return (str1 == null) ? null : new Triplet(str1, str2, str3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Triplet<String, String, String> execLsbRelease() {
/* 384 */     String str1 = null;
/* 385 */     String str2 = "unknown";
/* 386 */     String str3 = "unknown";
/*     */ 
/*     */ 
/*     */     
/* 390 */     for (String str : ExecutingCommand.runNative("lsb_release -a")) {
/* 391 */       if (str.startsWith("Description:")) {
/* 392 */         LOG.debug("lsb_release -a: {}", str);
/* 393 */         str = str.replace("Description:", "").trim();
/* 394 */         if (str.contains(" release ")) {
/* 395 */           Triplet<String, String, String> triplet = parseRelease(str, " release ");
/* 396 */           str1 = (String)triplet.getA();
/* 397 */           if (str2.equals("unknown")) {
/* 398 */             str2 = (String)triplet.getB();
/*     */           }
/* 400 */           if (str3.equals("unknown"))
/* 401 */             str3 = (String)triplet.getC(); 
/*     */         }  continue;
/*     */       } 
/* 404 */       if (str.startsWith("Distributor ID:") && str1 == null) {
/* 405 */         LOG.debug("lsb_release -a: {}", str);
/* 406 */         str1 = str.replace("Distributor ID:", "").trim(); continue;
/* 407 */       }  if (str.startsWith("Release:") && str2.equals("unknown")) {
/* 408 */         LOG.debug("lsb_release -a: {}", str);
/* 409 */         str2 = str.replace("Release:", "").trim(); continue;
/* 410 */       }  if (str.startsWith("Codename:") && str3.equals("unknown")) {
/* 411 */         LOG.debug("lsb_release -a: {}", str);
/* 412 */         str3 = str.replace("Codename:", "").trim();
/*     */       } 
/*     */     } 
/* 415 */     return (str1 == null) ? null : new Triplet(str1, str2, str3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Triplet<String, String, String> readLsbRelease() {
/* 426 */     String str1 = null;
/* 427 */     String str2 = "unknown";
/* 428 */     String str3 = "unknown";
/* 429 */     List list = FileUtil.readFile("/etc/lsb-release");
/*     */     
/* 431 */     for (String str : list) {
/* 432 */       if (str.startsWith("DISTRIB_DESCRIPTION=")) {
/* 433 */         LOG.debug("lsb-release: {}", str);
/* 434 */         str = str.replace("DISTRIB_DESCRIPTION=", "").replaceAll("(?:^\")|(?:\"$)", "").trim();
/* 435 */         if (str.contains(" release ")) {
/* 436 */           Triplet<String, String, String> triplet = parseRelease(str, " release ");
/* 437 */           str1 = (String)triplet.getA();
/* 438 */           if (str2.equals("unknown")) {
/* 439 */             str2 = (String)triplet.getB();
/*     */           }
/* 441 */           if (str3.equals("unknown"))
/* 442 */             str3 = (String)triplet.getC(); 
/*     */         }  continue;
/*     */       } 
/* 445 */       if (str.startsWith("DISTRIB_ID=") && str1 == null) {
/* 446 */         LOG.debug("lsb-release: {}", str);
/* 447 */         str1 = str.replace("DISTRIB_ID=", "").replaceAll("(?:^\")|(?:\"$)", "").trim(); continue;
/* 448 */       }  if (str.startsWith("DISTRIB_RELEASE=") && str2.equals("unknown")) {
/* 449 */         LOG.debug("lsb-release: {}", str);
/* 450 */         str2 = str.replace("DISTRIB_RELEASE=", "").replaceAll("(?:^\")|(?:\"$)", "").trim(); continue;
/* 451 */       }  if (str.startsWith("DISTRIB_CODENAME=") && str3.equals("unknown")) {
/* 452 */         LOG.debug("lsb-release: {}", str);
/* 453 */         str3 = str.replace("DISTRIB_CODENAME=", "").replaceAll("(?:^\")|(?:\"$)", "").trim();
/*     */       } 
/*     */     } 
/* 456 */     return (str1 == null) ? null : new Triplet(str1, str2, str3);
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
/*     */   private static Triplet<String, String, String> readDistribRelease(String paramString) {
/* 469 */     if ((new File(paramString)).exists()) {
/* 470 */       List list = FileUtil.readFile(paramString);
/*     */       
/* 472 */       for (String str : list) {
/* 473 */         LOG.debug("{}: {}", paramString, str);
/* 474 */         if (str.contains(" release "))
/*     */         {
/* 476 */           return parseRelease(str, " release "); } 
/* 477 */         if (str.contains(" VERSION "))
/*     */         {
/* 479 */           return parseRelease(str, " VERSION ");
/*     */         }
/*     */       } 
/*     */     } 
/* 483 */     return null;
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
/*     */   private static Triplet<String, String, String> parseRelease(String paramString1, String paramString2) {
/* 496 */     String[] arrayOfString = paramString1.split(paramString2);
/* 497 */     String str1 = arrayOfString[0].trim();
/* 498 */     String str2 = "unknown";
/* 499 */     String str3 = "unknown";
/* 500 */     if (arrayOfString.length > 1) {
/* 501 */       arrayOfString = arrayOfString[1].split("[()]");
/* 502 */       if (arrayOfString.length > 0) {
/* 503 */         str2 = arrayOfString[0].trim();
/*     */       }
/* 505 */       if (arrayOfString.length > 1) {
/* 506 */         str3 = arrayOfString[1].trim();
/*     */       }
/*     */     } 
/* 509 */     return new Triplet(str1, str2, str3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String getReleaseFilename() {
/* 519 */     File file = new File("/etc");
/*     */     
/* 521 */     File[] arrayOfFile = file.listFiles(paramFile -> 
/* 522 */         ((paramFile.getName().endsWith("-release") || paramFile.getName().endsWith("-version") || paramFile.getName().endsWith("_release") || paramFile.getName().endsWith("_version")) && !paramFile.getName().endsWith("os-release") && !paramFile.getName().endsWith("lsb-release") && !paramFile.getName().endsWith("system-release")));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 529 */     if (arrayOfFile != null && arrayOfFile.length > 0) {
/* 530 */       return arrayOfFile[0].getPath();
/*     */     }
/* 532 */     if ((new File("/etc/release")).exists()) {
/* 533 */       return "/etc/release";
/*     */     }
/*     */     
/* 536 */     return "/etc/issue";
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
/*     */   private static String filenameToFamily(String paramString) {
/* 549 */     if (paramString.isEmpty())
/* 550 */       return "Solaris"; 
/* 551 */     if ("issue".equalsIgnoreCase(paramString))
/*     */     {
/* 553 */       return "Unknown";
/*     */     }
/* 555 */     Properties properties = FileUtil.readPropertiesFromFilename("oshi.linux.filename.properties");
/* 556 */     String str = properties.getProperty(paramString.toLowerCase());
/* 557 */     return (str != null) ? str : (paramString.substring(0, 1).toUpperCase() + paramString.substring(1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OSService[] getServices() {
/* 564 */     ArrayList<OSService> arrayList = new ArrayList();
/* 565 */     HashSet<String> hashSet = new HashSet();
/* 566 */     for (OSProcess oSProcess : getChildProcesses(1, OperatingSystem.ProcessFiltering.ALL_PROCESSES, OperatingSystem.ProcessSorting.PID_ASC, 0)) {
/* 567 */       OSService oSService = new OSService(oSProcess.getName(), oSProcess.getProcessID(), OSService.State.RUNNING);
/* 568 */       arrayList.add(oSService);
/* 569 */       hashSet.add(oSProcess.getName());
/*     */     } 
/* 571 */     boolean bool = false;
/* 572 */     List list = ExecutingCommand.runNative("systemctl list-unit-files");
/* 573 */     for (String str : list) {
/* 574 */       String[] arrayOfString = ParseUtil.whitespaces.split(str);
/* 575 */       if (arrayOfString.length >= 2 && arrayOfString[0].endsWith(".service") && "enabled".equals(arrayOfString[1])) {
/*     */         
/* 577 */         String str1 = arrayOfString[0].substring(0, arrayOfString[0].length() - 8);
/* 578 */         int i = str1.lastIndexOf('.');
/* 579 */         String str2 = (i < 0 || i > str1.length() - 2) ? str1 : str1.substring(i + 1);
/* 580 */         if (!hashSet.contains(str1) && !hashSet.contains(str2)) {
/* 581 */           OSService oSService = new OSService(str1, 0, OSService.State.STOPPED);
/* 582 */           arrayList.add(oSService);
/* 583 */           bool = true;
/*     */         } 
/*     */       } 
/*     */     } 
/* 587 */     if (!bool) {
/*     */       
/* 589 */       File file = new File("/etc/init");
/* 590 */       if (file.exists() && file.isDirectory()) {
/* 591 */         for (File file1 : file.listFiles((paramFile, paramString) -> paramString.toLowerCase().endsWith(".conf"))) {
/*     */           
/* 593 */           String str1 = file1.getName().substring(0, file1.getName().length() - 5);
/* 594 */           int i = str1.lastIndexOf('.');
/* 595 */           String str2 = (i < 0 || i > str1.length() - 2) ? str1 : str1.substring(i + 1);
/* 596 */           if (!hashSet.contains(str1) && !hashSet.contains(str2)) {
/* 597 */             OSService oSService = new OSService(str1, 0, OSService.State.STOPPED);
/* 598 */             arrayList.add(oSService);
/*     */           } 
/*     */         } 
/*     */       } else {
/* 602 */         LOG.error("Directory: /etc/init does not exist");
/*     */       } 
/*     */     } 
/* 605 */     return arrayList.<OSService>toArray(new OSService[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getHz() {
/* 615 */     return USER_HZ;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\linux\LinuxOperatingSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */