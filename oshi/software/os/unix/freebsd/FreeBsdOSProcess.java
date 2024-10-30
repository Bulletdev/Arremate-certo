/*     */ package oshi.software.os.unix.freebsd;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.platform.unix.LibCAPI;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collectors;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.jna.platform.unix.freebsd.FreeBsdLibc;
/*     */ import oshi.software.common.AbstractOSProcess;
/*     */ import oshi.software.os.OSProcess;
/*     */ import oshi.software.os.OSThread;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.unix.freebsd.BsdSysctlUtil;
/*     */ import oshi.util.platform.unix.freebsd.ProcstatUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class FreeBsdOSProcess
/*     */   extends AbstractOSProcess
/*     */ {
/*  67 */   private static final Logger LOG = LoggerFactory.getLogger(FreeBsdOSProcess.class);
/*     */   
/*  69 */   private static final int ARGMAX = BsdSysctlUtil.sysctl("kern.argmax", 0);
/*     */ 
/*     */ 
/*     */   
/*     */   enum PsThreadColumns
/*     */   {
/*  75 */     TDNAME, LWP, STATE, ETIMES, SYSTIME, TIME, TDADDR, NIVCSW, NVCSW, MAJFLT, MINFLT, PRI;
/*     */   }
/*     */   
/*  78 */   static final String PS_THREAD_COLUMNS = Arrays.<PsThreadColumns>stream(PsThreadColumns.values()).map(Enum::name)
/*  79 */     .map(String::toLowerCase).collect(Collectors.joining(","));
/*     */   
/*  81 */   private Supplier<Integer> bitness = Memoizer.memoize(this::queryBitness);
/*  82 */   private Supplier<String> commandLine = Memoizer.memoize(this::queryCommandLine);
/*  83 */   private Supplier<List<String>> arguments = Memoizer.memoize(this::queryArguments);
/*  84 */   private Supplier<Map<String, String>> environmentVariables = Memoizer.memoize(this::queryEnvironmentVariables);
/*     */   
/*     */   private String name;
/*  87 */   private String path = "";
/*     */   private String user;
/*     */   private String userID;
/*     */   private String group;
/*     */   private String groupID;
/*  92 */   private OSProcess.State state = OSProcess.State.INVALID;
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
/*     */   private String commandLineBackup;
/*     */   
/*     */   public FreeBsdOSProcess(int paramInt, Map<FreeBsdOperatingSystem.PsKeywords, String> paramMap) {
/* 110 */     super(paramInt);
/* 111 */     updateAttributes(paramMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 116 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPath() {
/* 121 */     return this.path;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCommandLine() {
/* 126 */     return this.commandLine.get();
/*     */   }
/*     */   
/*     */   private String queryCommandLine() {
/* 130 */     String str = String.join(" ", (Iterable)getArguments());
/* 131 */     return str.isEmpty() ? this.commandLineBackup : str;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<String> getArguments() {
/* 136 */     return this.arguments.get();
/*     */   }
/*     */   
/*     */   private List<String> queryArguments() {
/* 140 */     if (ARGMAX > 0) {
/*     */       
/* 142 */       int[] arrayOfInt = new int[4];
/* 143 */       arrayOfInt[0] = 1;
/* 144 */       arrayOfInt[1] = 14;
/* 145 */       arrayOfInt[2] = 7;
/* 146 */       arrayOfInt[3] = getProcessID();
/*     */       
/* 148 */       Memory memory = new Memory(ARGMAX);
/* 149 */       LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(new LibCAPI.size_t(ARGMAX));
/*     */       
/* 151 */       if (FreeBsdLibc.INSTANCE.sysctl(arrayOfInt, arrayOfInt.length, (Pointer)memory, byReference, null, LibCAPI.size_t.ZERO) == 0) {
/* 152 */         return Collections.unmodifiableList(
/* 153 */             ParseUtil.parseByteArrayToStrings(memory.getByteArray(0L, byReference.getValue().intValue())));
/*     */       }
/*     */       
/* 156 */       LOG.warn("Failed sysctl call for process arguments (kern.proc.args), process {} may not exist. Error code: {}", 
/*     */           
/* 158 */           Integer.valueOf(getProcessID()), Integer.valueOf(Native.getLastError()));
/*     */     } 
/*     */     
/* 161 */     return Collections.emptyList();
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, String> getEnvironmentVariables() {
/* 166 */     return this.environmentVariables.get();
/*     */   }
/*     */   
/*     */   private Map<String, String> queryEnvironmentVariables() {
/* 170 */     if (ARGMAX > 0) {
/*     */       
/* 172 */       int[] arrayOfInt = new int[4];
/* 173 */       arrayOfInt[0] = 1;
/* 174 */       arrayOfInt[1] = 14;
/* 175 */       arrayOfInt[2] = 35;
/* 176 */       arrayOfInt[3] = getProcessID();
/*     */       
/* 178 */       Memory memory = new Memory(ARGMAX);
/* 179 */       LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(new LibCAPI.size_t(ARGMAX));
/*     */       
/* 181 */       if (FreeBsdLibc.INSTANCE.sysctl(arrayOfInt, arrayOfInt.length, (Pointer)memory, byReference, null, LibCAPI.size_t.ZERO) == 0) {
/* 182 */         return Collections.unmodifiableMap(
/* 183 */             ParseUtil.parseByteArrayToStringMap(memory.getByteArray(0L, byReference.getValue().intValue())));
/*     */       }
/* 185 */       LOG.warn("Failed sysctl call for process environment variables (kern.proc.env), process {} may not exist. Error code: {}", 
/*     */           
/* 187 */           Integer.valueOf(getProcessID()), Integer.valueOf(Native.getLastError()));
/*     */     } 
/*     */     
/* 190 */     return Collections.emptyMap();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCurrentWorkingDirectory() {
/* 195 */     return ProcstatUtil.getCwd(getProcessID());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUser() {
/* 200 */     return this.user;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUserID() {
/* 205 */     return this.userID;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getGroup() {
/* 210 */     return this.group;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getGroupID() {
/* 215 */     return this.groupID;
/*     */   }
/*     */ 
/*     */   
/*     */   public OSProcess.State getState() {
/* 220 */     return this.state;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getParentProcessID() {
/* 225 */     return this.parentProcessID;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getThreadCount() {
/* 230 */     return this.threadCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPriority() {
/* 235 */     return this.priority;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getVirtualSize() {
/* 240 */     return this.virtualSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getResidentSetSize() {
/* 245 */     return this.residentSetSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getKernelTime() {
/* 250 */     return this.kernelTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUserTime() {
/* 255 */     return this.userTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUpTime() {
/* 260 */     return this.upTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getStartTime() {
/* 265 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesRead() {
/* 270 */     return this.bytesRead;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesWritten() {
/* 275 */     return this.bytesWritten;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getOpenFiles() {
/* 280 */     return ProcstatUtil.getOpenFiles(getProcessID());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBitness() {
/* 285 */     return ((Integer)this.bitness.get()).intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getAffinityMask() {
/* 290 */     long l = 0L;
/*     */ 
/*     */     
/* 293 */     String str = ExecutingCommand.getFirstAnswer("cpuset -gp " + getProcessID());
/*     */ 
/*     */ 
/*     */     
/* 297 */     String[] arrayOfString = str.split(":");
/* 298 */     if (arrayOfString.length > 1) {
/* 299 */       String[] arrayOfString1 = arrayOfString[1].split(",");
/* 300 */       for (String str1 : arrayOfString1) {
/* 301 */         int i = ParseUtil.parseIntOrDefault(str1.trim(), -1);
/* 302 */         if (i >= 0) {
/* 303 */           l |= 1L << i;
/*     */         }
/*     */       } 
/*     */     } 
/* 307 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   private int queryBitness() {
/* 312 */     int[] arrayOfInt = new int[4];
/* 313 */     arrayOfInt[0] = 1;
/* 314 */     arrayOfInt[1] = 14;
/* 315 */     arrayOfInt[2] = 9;
/* 316 */     arrayOfInt[3] = getProcessID();
/*     */     
/* 318 */     Memory memory = new Memory(32L);
/* 319 */     LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(new LibCAPI.size_t(32L));
/*     */     
/* 321 */     if (0 == FreeBsdLibc.INSTANCE.sysctl(arrayOfInt, arrayOfInt.length, (Pointer)memory, byReference, null, LibCAPI.size_t.ZERO)) {
/* 322 */       String str = memory.getString(0L);
/* 323 */       if (str.contains("ELF32"))
/* 324 */         return 32; 
/* 325 */       if (str.contains("ELF64")) {
/* 326 */         return 64;
/*     */       }
/*     */     } 
/* 329 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSThread> getThreadDetails() {
/* 334 */     ArrayList<FreeBsdOSThread> arrayList = new ArrayList();
/* 335 */     String str = "ps -awwxo " + PS_THREAD_COLUMNS + " -H";
/* 336 */     if (getProcessID() >= 0) {
/* 337 */       str = str + " -p " + getProcessID();
/*     */     }
/* 339 */     List list = ExecutingCommand.runNative(str);
/* 340 */     if (list.size() > 1) {
/*     */       
/* 342 */       list.remove(0);
/*     */       
/* 344 */       for (String str1 : list) {
/* 345 */         Map<PsThreadColumns, String> map = ParseUtil.stringToEnumMap(PsThreadColumns.class, str1.trim(), ' ');
/*     */         
/* 347 */         if (map.containsKey(PsThreadColumns.PRI)) {
/* 348 */           arrayList.add(new FreeBsdOSThread(getProcessID(), map));
/*     */         }
/*     */       } 
/*     */     } 
/* 352 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMinorFaults() {
/* 357 */     return this.minorFaults;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMajorFaults() {
/* 362 */     return this.majorFaults;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContextSwitches() {
/* 367 */     return this.contextSwitches;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 372 */     String str = "ps -awwxo " + FreeBsdOperatingSystem.PS_COMMAND_ARGS + " -p " + getProcessID();
/* 373 */     List<String> list = ExecutingCommand.runNative(str);
/* 374 */     if (list.size() > 1) {
/*     */       
/* 376 */       Map<FreeBsdOperatingSystem.PsKeywords, String> map = ParseUtil.stringToEnumMap(FreeBsdOperatingSystem.PsKeywords.class, ((String)list.get(1)).trim(), ' ');
/*     */       
/* 378 */       if (map.containsKey(FreeBsdOperatingSystem.PsKeywords.ARGS)) {
/* 379 */         return updateAttributes(map);
/*     */       }
/*     */     } 
/* 382 */     this.state = OSProcess.State.INVALID;
/* 383 */     return false;
/*     */   }
/*     */   
/*     */   private boolean updateAttributes(Map<FreeBsdOperatingSystem.PsKeywords, String> paramMap) {
/* 387 */     long l1 = System.currentTimeMillis();
/* 388 */     switch (((String)paramMap.get(FreeBsdOperatingSystem.PsKeywords.STATE)).charAt(0)) {
/*     */       case 'R':
/* 390 */         this.state = OSProcess.State.RUNNING;
/*     */         break;
/*     */       case 'I':
/*     */       case 'S':
/* 394 */         this.state = OSProcess.State.SLEEPING;
/*     */         break;
/*     */       case 'D':
/*     */       case 'L':
/*     */       case 'U':
/* 399 */         this.state = OSProcess.State.WAITING;
/*     */         break;
/*     */       case 'Z':
/* 402 */         this.state = OSProcess.State.ZOMBIE;
/*     */         break;
/*     */       case 'T':
/* 405 */         this.state = OSProcess.State.STOPPED;
/*     */         break;
/*     */       default:
/* 408 */         this.state = OSProcess.State.OTHER;
/*     */         break;
/*     */     } 
/* 411 */     this.parentProcessID = ParseUtil.parseIntOrDefault(paramMap.get(FreeBsdOperatingSystem.PsKeywords.PPID), 0);
/* 412 */     this.user = paramMap.get(FreeBsdOperatingSystem.PsKeywords.USER);
/* 413 */     this.userID = paramMap.get(FreeBsdOperatingSystem.PsKeywords.UID);
/* 414 */     this.group = paramMap.get(FreeBsdOperatingSystem.PsKeywords.GROUP);
/* 415 */     this.groupID = paramMap.get(FreeBsdOperatingSystem.PsKeywords.GID);
/* 416 */     this.threadCount = ParseUtil.parseIntOrDefault(paramMap.get(FreeBsdOperatingSystem.PsKeywords.NLWP), 0);
/* 417 */     this.priority = ParseUtil.parseIntOrDefault(paramMap.get(FreeBsdOperatingSystem.PsKeywords.PRI), 0);
/*     */     
/* 419 */     this.virtualSize = ParseUtil.parseLongOrDefault(paramMap.get(FreeBsdOperatingSystem.PsKeywords.VSZ), 0L) * 1024L;
/* 420 */     this.residentSetSize = ParseUtil.parseLongOrDefault(paramMap.get(FreeBsdOperatingSystem.PsKeywords.RSS), 0L) * 1024L;
/*     */     
/* 422 */     long l2 = ParseUtil.parseDHMSOrDefault(paramMap.get(FreeBsdOperatingSystem.PsKeywords.ETIMES), 0L);
/* 423 */     this.upTime = (l2 < 1L) ? 1L : l2;
/* 424 */     this.startTime = l1 - this.upTime;
/* 425 */     this.kernelTime = ParseUtil.parseDHMSOrDefault(paramMap.get(FreeBsdOperatingSystem.PsKeywords.SYSTIME), 0L);
/* 426 */     this.userTime = ParseUtil.parseDHMSOrDefault(paramMap.get(FreeBsdOperatingSystem.PsKeywords.TIME), 0L) - this.kernelTime;
/* 427 */     this.path = paramMap.get(FreeBsdOperatingSystem.PsKeywords.COMM);
/* 428 */     this.name = this.path.substring(this.path.lastIndexOf('/') + 1);
/* 429 */     this.minorFaults = ParseUtil.parseLongOrDefault(paramMap.get(FreeBsdOperatingSystem.PsKeywords.MAJFLT), 0L);
/* 430 */     this.majorFaults = ParseUtil.parseLongOrDefault(paramMap.get(FreeBsdOperatingSystem.PsKeywords.MINFLT), 0L);
/* 431 */     long l3 = ParseUtil.parseLongOrDefault(paramMap.get(FreeBsdOperatingSystem.PsKeywords.NVCSW), 0L);
/* 432 */     long l4 = ParseUtil.parseLongOrDefault(paramMap.get(FreeBsdOperatingSystem.PsKeywords.NIVCSW), 0L);
/* 433 */     this.contextSwitches = l4 + l3;
/* 434 */     this.commandLineBackup = paramMap.get(FreeBsdOperatingSystem.PsKeywords.ARGS);
/* 435 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\freebsd\FreeBsdOSProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */