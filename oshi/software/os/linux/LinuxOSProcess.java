/*     */ package oshi.software.os.linux;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.math.BigInteger;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.InvalidPathException;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collectors;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.linux.proc.ProcessStat;
/*     */ import oshi.driver.linux.proc.UserGroupInfo;
/*     */ import oshi.hardware.platform.linux.LinuxGlobalMemory;
/*     */ import oshi.software.common.AbstractOSProcess;
/*     */ import oshi.software.os.OSProcess;
/*     */ import oshi.software.os.OSThread;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.FileUtil;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.Util;
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
/*     */ 
/*     */ @ThreadSafe
/*     */ public class LinuxOSProcess
/*     */   extends AbstractOSProcess
/*     */ {
/*  65 */   private static final Logger LOG = LoggerFactory.getLogger(LinuxOSProcess.class);
/*     */ 
/*     */   
/*  68 */   private static final int[] PROC_PID_STAT_ORDERS = new int[(ProcPidStat.values()).length];
/*     */   static {
/*  70 */     for (ProcPidStat procPidStat : ProcPidStat.values())
/*     */     {
/*     */       
/*  73 */       PROC_PID_STAT_ORDERS[procPidStat.ordinal()] = procPidStat.getOrder() - 1;
/*     */     }
/*     */   }
/*     */   
/*  77 */   private Supplier<Integer> bitness = Memoizer.memoize(this::queryBitness);
/*  78 */   private Supplier<String> commandLine = Memoizer.memoize(this::queryCommandLine);
/*  79 */   private Supplier<List<String>> arguments = Memoizer.memoize(this::queryArguments);
/*  80 */   private Supplier<Map<String, String>> environmentVariables = Memoizer.memoize(this::queryEnvironmentVariables);
/*     */   
/*     */   private String name;
/*  83 */   private String path = "";
/*     */   private String user;
/*     */   private String userID;
/*     */   private String group;
/*     */   private String groupID;
/*  88 */   private OSProcess.State state = OSProcess.State.INVALID;
/*     */   private int parentProcessID;
/*     */   private int threadCount;
/*     */   private int priority;
/*     */   private long virtualSize;
/*     */   private long residentSetSize;
/*     */   private long kernelTime;
/*     */   private long userTime;
/*     */   private long startTime;
/*     */   private long upTime;
/*     */   private long bytesRead;
/*     */   private long bytesWritten;
/*     */   private long minorFaults;
/*     */   private long majorFaults;
/*     */   private long contextSwitches;
/*     */   
/*     */   public LinuxOSProcess(int paramInt) {
/* 105 */     super(paramInt);
/* 106 */     updateAttributes();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 111 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPath() {
/* 116 */     return this.path;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCommandLine() {
/* 121 */     return this.commandLine.get();
/*     */   }
/*     */   
/*     */   private String queryCommandLine() {
/* 125 */     return FileUtil.getStringFromFile(String.format(ProcPath.PID_CMDLINE, new Object[] { Integer.valueOf(getProcessID()) }));
/*     */   }
/*     */ 
/*     */   
/*     */   public List<String> getArguments() {
/* 130 */     return this.arguments.get();
/*     */   }
/*     */   
/*     */   private List<String> queryArguments() {
/* 134 */     return Collections.unmodifiableList(
/* 135 */         ParseUtil.parseByteArrayToStrings(FileUtil.readAllBytes(String.format(ProcPath.PID_CMDLINE, new Object[] { Integer.valueOf(getProcessID()) }))));
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, String> getEnvironmentVariables() {
/* 140 */     return this.environmentVariables.get();
/*     */   }
/*     */   
/*     */   private Map<String, String> queryEnvironmentVariables() {
/* 144 */     return Collections.unmodifiableMap(
/* 145 */         ParseUtil.parseByteArrayToStringMap(FileUtil.readAllBytes(String.format(ProcPath.PID_ENVIRON, new Object[] { Integer.valueOf(getProcessID()) }))));
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCurrentWorkingDirectory() {
/*     */     try {
/* 151 */       String str1 = String.format(ProcPath.PID_CWD, new Object[] { Integer.valueOf(getProcessID()) });
/* 152 */       String str2 = (new File(str1)).getCanonicalPath();
/* 153 */       if (!str2.equals(str1)) {
/* 154 */         return str2;
/*     */       }
/* 156 */     } catch (IOException iOException) {
/* 157 */       LOG.trace("Couldn't find cwd for pid {}: {}", Integer.valueOf(getProcessID()), iOException.getMessage());
/*     */     } 
/* 159 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUser() {
/* 164 */     return this.user;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUserID() {
/* 169 */     return this.userID;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getGroup() {
/* 174 */     return this.group;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getGroupID() {
/* 179 */     return this.groupID;
/*     */   }
/*     */ 
/*     */   
/*     */   public OSProcess.State getState() {
/* 184 */     return this.state;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getParentProcessID() {
/* 189 */     return this.parentProcessID;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getThreadCount() {
/* 194 */     return this.threadCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPriority() {
/* 199 */     return this.priority;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getVirtualSize() {
/* 204 */     return this.virtualSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getResidentSetSize() {
/* 209 */     return this.residentSetSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getKernelTime() {
/* 214 */     return this.kernelTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUserTime() {
/* 219 */     return this.userTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUpTime() {
/* 224 */     return this.upTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getStartTime() {
/* 229 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesRead() {
/* 234 */     return this.bytesRead;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesWritten() {
/* 239 */     return this.bytesWritten;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSThread> getThreadDetails() {
/* 244 */     return (List<OSThread>)ProcessStat.getThreadIds(getProcessID()).stream().map(paramInteger -> new LinuxOSThread(getProcessID(), paramInteger.intValue()))
/* 245 */       .collect(Collectors.toList());
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMinorFaults() {
/* 250 */     return this.minorFaults;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMajorFaults() {
/* 255 */     return this.majorFaults;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContextSwitches() {
/* 260 */     return this.contextSwitches;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getOpenFiles() {
/* 265 */     return (ProcessStat.getFileDescriptorFiles(getProcessID())).length;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBitness() {
/* 270 */     return ((Integer)this.bitness.get()).intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int queryBitness() {
/* 276 */     byte[] arrayOfByte = new byte[5];
/* 277 */     if (!this.path.isEmpty()) {
/* 278 */       try { FileInputStream fileInputStream = new FileInputStream(this.path); 
/* 279 */         try { if (fileInputStream.read(arrayOfByte) == arrayOfByte.length)
/* 280 */           { byte b = (arrayOfByte[4] == 1) ? 32 : 64;
/*     */             
/* 282 */             fileInputStream.close(); return b; }  fileInputStream.close(); } catch (Throwable throwable) { try { fileInputStream.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  throw throwable; }  } catch (IOException iOException)
/* 283 */       { LOG.warn("Failed to read process file: {}", this.path); }
/*     */     
/*     */     }
/* 286 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getAffinityMask() {
/* 293 */     String str = ExecutingCommand.getFirstAnswer("taskset -p " + getProcessID());
/*     */ 
/*     */ 
/*     */     
/* 297 */     String[] arrayOfString = ParseUtil.whitespaces.split(str);
/*     */     try {
/* 299 */       return (new BigInteger(arrayOfString[arrayOfString.length - 1], 16)).longValue();
/* 300 */     } catch (NumberFormatException numberFormatException) {
/* 301 */       return 0L;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 307 */     String str1 = String.format(ProcPath.PID_EXE, new Object[] { Integer.valueOf(getProcessID()) });
/*     */     try {
/* 309 */       Path path = Paths.get(str1, new String[0]);
/* 310 */       this.path = Files.readSymbolicLink(path).toString();
/*     */       
/* 312 */       int i = this.path.indexOf(" (deleted)");
/* 313 */       if (i != -1) {
/* 314 */         this.path = this.path.substring(0, i);
/*     */       }
/* 316 */     } catch (InvalidPathException|IOException|UnsupportedOperationException|SecurityException invalidPathException) {
/* 317 */       LOG.debug("Unable to open symbolic link {}", str1);
/*     */     } 
/*     */ 
/*     */     
/* 321 */     Map map = FileUtil.getKeyValueMapFromFile(String.format(ProcPath.PID_IO, new Object[] { Integer.valueOf(getProcessID()) }), ":");
/* 322 */     Map<String, String> map1 = FileUtil.getKeyValueMapFromFile(String.format(ProcPath.PID_STATUS, new Object[] { Integer.valueOf(getProcessID()) }), ":");
/*     */     
/* 324 */     String str2 = FileUtil.getStringFromFile(String.format(ProcPath.PID_STAT, new Object[] { Integer.valueOf(getProcessID()) }));
/* 325 */     if (str2.isEmpty()) {
/* 326 */       this.state = OSProcess.State.INVALID;
/* 327 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 331 */     getMissingDetails(map1, str2);
/*     */     
/* 333 */     long l1 = System.currentTimeMillis();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 338 */     long[] arrayOfLong = ParseUtil.parseStringToLongArray(str2, PROC_PID_STAT_ORDERS, ProcessStat.PROC_PID_STAT_LENGTH, ' ');
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 344 */     this
/* 345 */       .startTime = (LinuxOperatingSystem.BOOTTIME * LinuxOperatingSystem.getHz() + arrayOfLong[ProcPidStat.START_TIME.ordinal()]) * 1000L / LinuxOperatingSystem.getHz();
/*     */ 
/*     */ 
/*     */     
/* 349 */     if (this.startTime >= l1) {
/* 350 */       this.startTime = l1 - 1L;
/*     */     }
/* 352 */     this.parentProcessID = (int)arrayOfLong[ProcPidStat.PPID.ordinal()];
/* 353 */     this.threadCount = (int)arrayOfLong[ProcPidStat.THREAD_COUNT.ordinal()];
/* 354 */     this.priority = (int)arrayOfLong[ProcPidStat.PRIORITY.ordinal()];
/* 355 */     this.virtualSize = arrayOfLong[ProcPidStat.VSZ.ordinal()];
/* 356 */     this.residentSetSize = arrayOfLong[ProcPidStat.RSS.ordinal()] * LinuxGlobalMemory.PAGE_SIZE;
/* 357 */     this.kernelTime = arrayOfLong[ProcPidStat.KERNEL_TIME.ordinal()] * 1000L / LinuxOperatingSystem.getHz();
/* 358 */     this.userTime = arrayOfLong[ProcPidStat.USER_TIME.ordinal()] * 1000L / LinuxOperatingSystem.getHz();
/* 359 */     this.minorFaults = arrayOfLong[ProcPidStat.MINOR_FAULTS.ordinal()];
/* 360 */     this.majorFaults = arrayOfLong[ProcPidStat.MAJOR_FAULTS.ordinal()];
/* 361 */     long l2 = ParseUtil.parseLongOrDefault(map1.get("nonvoluntary_ctxt_switches"), 0L);
/* 362 */     long l3 = ParseUtil.parseLongOrDefault(map1.get("voluntary_ctxt_switches"), 0L);
/* 363 */     this.contextSwitches = l3 + l2;
/*     */     
/* 365 */     this.upTime = l1 - this.startTime;
/*     */ 
/*     */     
/* 368 */     this.bytesRead = ParseUtil.parseLongOrDefault((String)map.getOrDefault("read_bytes", ""), 0L);
/* 369 */     this.bytesWritten = ParseUtil.parseLongOrDefault((String)map.getOrDefault("write_bytes", ""), 0L);
/*     */ 
/*     */ 
/*     */     
/* 373 */     this.userID = ParseUtil.whitespaces.split((CharSequence)map1.getOrDefault("Uid", (V)""))[0];
/* 374 */     this.user = UserGroupInfo.getUser(this.userID);
/* 375 */     this.groupID = ParseUtil.whitespaces.split((CharSequence)map1.getOrDefault("Gid", (V)""))[0];
/* 376 */     this.group = UserGroupInfo.getGroupName(this.groupID);
/* 377 */     this.name = map1.getOrDefault("Name", "");
/* 378 */     this.state = ProcessStat.getState(((String)map1.getOrDefault("State", "U")).charAt(0));
/* 379 */     return true;
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
/*     */   private static void getMissingDetails(Map<String, String> paramMap, String paramString) {
/* 392 */     if (paramMap == null || paramString == null) {
/*     */       return;
/*     */     }
/*     */     
/* 396 */     int i = paramString.indexOf('(');
/* 397 */     int j = paramString.indexOf(')');
/* 398 */     if (Util.isBlank(paramMap.get("Name")) && i > 0 && i < j) {
/*     */       
/* 400 */       String str = paramString.substring(i + 1, j);
/* 401 */       paramMap.put("Name", str);
/*     */     } 
/*     */ 
/*     */     
/* 405 */     if (Util.isBlank(paramMap.get("State")) && j > 0 && paramString.length() > j + 2) {
/* 406 */       String str = String.valueOf(paramString.charAt(j + 2));
/* 407 */       paramMap.put("State", str);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private enum ProcPidStat
/*     */   {
/* 418 */     PPID(4), MINOR_FAULTS(10), MAJOR_FAULTS(12), USER_TIME(14), KERNEL_TIME(15), PRIORITY(18), THREAD_COUNT(20),
/* 419 */     START_TIME(22), VSZ(23), RSS(24);
/*     */     
/*     */     private int order;
/*     */     
/*     */     public int getOrder() {
/* 424 */       return this.order;
/*     */     }
/*     */     
/*     */     ProcPidStat(int param1Int1) {
/* 428 */       this.order = param1Int1;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\linux\LinuxOSProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */