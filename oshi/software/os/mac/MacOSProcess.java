/*     */ package oshi.software.os.mac;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.platform.mac.SystemB;
/*     */ import com.sun.jna.platform.unix.LibCAPI;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.function.Supplier;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.mac.ThreadInfo;
/*     */ import oshi.software.common.AbstractOSProcess;
/*     */ import oshi.software.os.OSProcess;
/*     */ import oshi.software.os.OSThread;
/*     */ import oshi.util.Memoizer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public class MacOSProcess
/*     */   extends AbstractOSProcess
/*     */ {
/*  72 */   private static final Logger LOG = LoggerFactory.getLogger(MacOSProcess.class);
/*     */   
/*  74 */   private static final int ARGMAX = SysctlUtil.sysctl("kern.argmax", 0);
/*     */   
/*     */   private static final int P_LP64 = 4;
/*     */   
/*     */   private static final int SSLEEP = 1;
/*     */   
/*     */   private static final int SWAIT = 2;
/*     */   
/*     */   private static final int SRUN = 3;
/*     */   
/*     */   private static final int SIDL = 4;
/*     */   
/*     */   private static final int SZOMB = 5;
/*     */   
/*     */   private static final int SSTOP = 6;
/*     */   private int minorVersion;
/*  90 */   private Supplier<String> commandLine = Memoizer.memoize(this::queryCommandLine);
/*  91 */   private Supplier<Pair<List<String>, Map<String, String>>> argsEnviron = Memoizer.memoize(this::queryArgsAndEnvironment);
/*     */   
/*  93 */   private String name = "";
/*  94 */   private String path = "";
/*     */   private String currentWorkingDirectory;
/*     */   private String user;
/*     */   private String userID;
/*     */   private String group;
/*     */   private String groupID;
/* 100 */   private OSProcess.State state = OSProcess.State.INVALID;
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
/*     */   private long openFiles;
/*     */   private int bitness;
/*     */   private long minorFaults;
/*     */   private long majorFaults;
/*     */   private long contextSwitches;
/*     */   
/*     */   public MacOSProcess(int paramInt1, int paramInt2) {
/* 119 */     super(paramInt1);
/* 120 */     this.minorVersion = paramInt2;
/* 121 */     updateAttributes();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 126 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPath() {
/* 131 */     return this.path;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCommandLine() {
/* 136 */     return this.commandLine.get();
/*     */   }
/*     */   
/*     */   private String queryCommandLine() {
/* 140 */     return String.join("\000", (Iterable)getArguments());
/*     */   }
/*     */ 
/*     */   
/*     */   public List<String> getArguments() {
/* 145 */     return (List<String>)((Pair)this.argsEnviron.get()).getA();
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, String> getEnvironmentVariables() {
/* 150 */     return (Map<String, String>)((Pair)this.argsEnviron.get()).getB();
/*     */   }
/*     */ 
/*     */   
/*     */   private Pair<List<String>, Map<String, String>> queryArgsAndEnvironment() {
/* 155 */     ArrayList<String> arrayList = new ArrayList();
/*     */ 
/*     */     
/* 158 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/*     */ 
/*     */     
/* 161 */     int[] arrayOfInt = new int[3];
/* 162 */     arrayOfInt[0] = 1;
/* 163 */     arrayOfInt[1] = 49;
/* 164 */     arrayOfInt[2] = getProcessID();
/*     */     
/* 166 */     Memory memory = new Memory(ARGMAX);
/* 167 */     memory.clear();
/* 168 */     LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(ARGMAX);
/*     */     
/* 170 */     if (0 == SystemB.INSTANCE.sysctl(arrayOfInt, arrayOfInt.length, (Pointer)memory, byReference, null, LibCAPI.size_t.ZERO)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 177 */       int i = memory.getInt(0L);
/*     */       
/* 179 */       if (i > 0 && i <= 1024) {
/*     */         
/* 181 */         long l = SystemB.INT_SIZE;
/*     */         
/* 183 */         l += memory.getString(l).length();
/*     */ 
/*     */         
/* 186 */         while (l < byReference.longValue()) { do {
/*     */           
/* 188 */           } while (memory.getByte(l) == 0 && 
/* 189 */             ++l < byReference.longValue());
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 194 */           String str = memory.getString(l);
/* 195 */           if (i-- > 0) {
/*     */             
/* 197 */             arrayList.add(str);
/*     */           } else {
/*     */             
/* 200 */             int j = str.indexOf('=');
/* 201 */             if (j > 0) {
/* 202 */               linkedHashMap.put(str.substring(0, j), str.substring(j + 1));
/*     */             }
/*     */           } 
/*     */           
/* 206 */           l += str.length(); }
/*     */       
/*     */       } 
/*     */     } else {
/* 210 */       LOG.warn("Failed sysctl call for process arguments (kern.procargs2), process {} may not exist. Error code: {}", 
/*     */           
/* 212 */           Integer.valueOf(getProcessID()), Integer.valueOf(Native.getLastError()));
/*     */     } 
/* 214 */     return new Pair(Collections.unmodifiableList(arrayList), Collections.unmodifiableMap(linkedHashMap));
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCurrentWorkingDirectory() {
/* 219 */     return this.currentWorkingDirectory;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUser() {
/* 224 */     return this.user;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUserID() {
/* 229 */     return this.userID;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getGroup() {
/* 234 */     return this.group;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getGroupID() {
/* 239 */     return this.groupID;
/*     */   }
/*     */ 
/*     */   
/*     */   public OSProcess.State getState() {
/* 244 */     return this.state;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getParentProcessID() {
/* 249 */     return this.parentProcessID;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getThreadCount() {
/* 254 */     return this.threadCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSThread> getThreadDetails() {
/* 259 */     long l = System.currentTimeMillis();
/* 260 */     ArrayList<MacOSThread> arrayList = new ArrayList();
/* 261 */     List list = ThreadInfo.queryTaskThreads(getProcessID());
/* 262 */     for (ThreadInfo.ThreadStats threadStats : list) {
/*     */       
/* 264 */       long l1 = l - threadStats.getUpTime();
/* 265 */       if (l1 < getStartTime()) {
/* 266 */         l1 = getStartTime();
/*     */       }
/* 268 */       arrayList.add(new MacOSThread(getProcessID(), threadStats.getThreadId(), threadStats.getState(), threadStats.getSystemTime(), threadStats
/* 269 */             .getUserTime(), l1, l - l1, threadStats.getPriority()));
/*     */     } 
/* 271 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPriority() {
/* 276 */     return this.priority;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getVirtualSize() {
/* 281 */     return this.virtualSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getResidentSetSize() {
/* 286 */     return this.residentSetSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getKernelTime() {
/* 291 */     return this.kernelTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUserTime() {
/* 296 */     return this.userTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUpTime() {
/* 301 */     return this.upTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getStartTime() {
/* 306 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesRead() {
/* 311 */     return this.bytesRead;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesWritten() {
/* 316 */     return this.bytesWritten;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getOpenFiles() {
/* 321 */     return this.openFiles;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBitness() {
/* 326 */     return this.bitness;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long getAffinityMask() {
/* 332 */     int i = SysctlUtil.sysctl("hw.logicalcpu", 1);
/* 333 */     return (i < 64) ? ((1L << i) - 1L) : -1L;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMinorFaults() {
/* 338 */     return this.minorFaults;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMajorFaults() {
/* 343 */     return this.majorFaults;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContextSwitches() {
/* 348 */     return this.contextSwitches;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 353 */     long l = System.currentTimeMillis();
/* 354 */     SystemB.ProcTaskAllInfo procTaskAllInfo = new SystemB.ProcTaskAllInfo();
/* 355 */     if (0 > SystemB.INSTANCE.proc_pidinfo(getProcessID(), 2, 0L, (Structure)procTaskAllInfo, procTaskAllInfo
/* 356 */         .size()) || procTaskAllInfo.ptinfo.pti_threadnum < 1) {
/* 357 */       this.state = OSProcess.State.INVALID;
/* 358 */       return false;
/*     */     } 
/* 360 */     Memory memory = new Memory(4096L);
/* 361 */     if (0 < SystemB.INSTANCE.proc_pidpath(getProcessID(), (Pointer)memory, 4096)) {
/* 362 */       this.path = memory.getString(0L).trim();
/*     */       
/* 364 */       String[] arrayOfString = this.path.split("/");
/* 365 */       if (arrayOfString.length > 0) {
/* 366 */         this.name = arrayOfString[arrayOfString.length - 1];
/*     */       }
/*     */     } 
/* 369 */     if (this.name.isEmpty())
/*     */     {
/* 371 */       this.name = Native.toString(procTaskAllInfo.pbsd.pbi_comm, StandardCharsets.UTF_8);
/*     */     }
/*     */     
/* 374 */     switch (procTaskAllInfo.pbsd.pbi_status) {
/*     */       case 1:
/* 376 */         this.state = OSProcess.State.SLEEPING;
/*     */         break;
/*     */       case 2:
/* 379 */         this.state = OSProcess.State.WAITING;
/*     */         break;
/*     */       case 3:
/* 382 */         this.state = OSProcess.State.RUNNING;
/*     */         break;
/*     */       case 4:
/* 385 */         this.state = OSProcess.State.NEW;
/*     */         break;
/*     */       case 5:
/* 388 */         this.state = OSProcess.State.ZOMBIE;
/*     */         break;
/*     */       case 6:
/* 391 */         this.state = OSProcess.State.STOPPED;
/*     */         break;
/*     */       default:
/* 394 */         this.state = OSProcess.State.OTHER;
/*     */         break;
/*     */     } 
/* 397 */     this.parentProcessID = procTaskAllInfo.pbsd.pbi_ppid;
/* 398 */     this.userID = Integer.toString(procTaskAllInfo.pbsd.pbi_uid);
/* 399 */     SystemB.Passwd passwd = SystemB.INSTANCE.getpwuid(procTaskAllInfo.pbsd.pbi_uid);
/* 400 */     if (passwd != null) {
/* 401 */       this.user = passwd.pw_name;
/*     */     }
/* 403 */     this.groupID = Integer.toString(procTaskAllInfo.pbsd.pbi_gid);
/* 404 */     SystemB.Group group = SystemB.INSTANCE.getgrgid(procTaskAllInfo.pbsd.pbi_gid);
/* 405 */     if (group != null) {
/* 406 */       this.group = group.gr_name;
/*     */     }
/* 408 */     this.threadCount = procTaskAllInfo.ptinfo.pti_threadnum;
/* 409 */     this.priority = procTaskAllInfo.ptinfo.pti_priority;
/* 410 */     this.virtualSize = procTaskAllInfo.ptinfo.pti_virtual_size;
/* 411 */     this.residentSetSize = procTaskAllInfo.ptinfo.pti_resident_size;
/* 412 */     this.kernelTime = procTaskAllInfo.ptinfo.pti_total_system / 1000000L;
/* 413 */     this.userTime = procTaskAllInfo.ptinfo.pti_total_user / 1000000L;
/* 414 */     this.startTime = procTaskAllInfo.pbsd.pbi_start_tvsec * 1000L + procTaskAllInfo.pbsd.pbi_start_tvusec / 1000L;
/* 415 */     this.upTime = l - this.startTime;
/* 416 */     this.openFiles = procTaskAllInfo.pbsd.pbi_nfiles;
/* 417 */     this.bitness = ((procTaskAllInfo.pbsd.pbi_flags & 0x4) == 0) ? 32 : 64;
/* 418 */     this.majorFaults = procTaskAllInfo.ptinfo.pti_pageins;
/*     */     
/* 420 */     this.minorFaults = (procTaskAllInfo.ptinfo.pti_faults - procTaskAllInfo.ptinfo.pti_pageins);
/* 421 */     this.contextSwitches = procTaskAllInfo.ptinfo.pti_csw;
/* 422 */     if (this.minorVersion >= 9) {
/* 423 */       SystemB.RUsageInfoV2 rUsageInfoV2 = new SystemB.RUsageInfoV2();
/* 424 */       if (0 == SystemB.INSTANCE.proc_pid_rusage(getProcessID(), 2, rUsageInfoV2)) {
/* 425 */         this.bytesRead = rUsageInfoV2.ri_diskio_bytesread;
/* 426 */         this.bytesWritten = rUsageInfoV2.ri_diskio_byteswritten;
/*     */       } 
/*     */     } 
/* 429 */     SystemB.VnodePathInfo vnodePathInfo = new SystemB.VnodePathInfo();
/* 430 */     if (0 < SystemB.INSTANCE.proc_pidinfo(getProcessID(), 9, 0L, (Structure)vnodePathInfo, vnodePathInfo.size())) {
/* 431 */       this.currentWorkingDirectory = Native.toString(vnodePathInfo.pvi_cdir.vip_path, StandardCharsets.US_ASCII);
/*     */     }
/* 433 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\mac\MacOSProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */