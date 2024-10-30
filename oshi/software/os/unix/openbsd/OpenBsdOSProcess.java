/*     */ package oshi.software.os.unix.openbsd;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.platform.unix.LibCAPI;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collectors;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.jna.platform.unix.openbsd.OpenBsdLibc;
/*     */ import oshi.software.common.AbstractOSProcess;
/*     */ import oshi.software.os.OSProcess;
/*     */ import oshi.software.os.OSThread;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.unix.openbsd.FstatUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class OpenBsdOSProcess
/*     */   extends AbstractOSProcess
/*     */ {
/*  67 */   private static final Logger LOG = LoggerFactory.getLogger(OpenBsdOSProcess.class);
/*     */ 
/*     */ 
/*     */   
/*     */   enum PsThreadColumns
/*     */   {
/*  73 */     TID, STATE, ETIME, CPUTIME, NIVCSW, NVCSW, MAJFLT, MINFLT, PRI, ARGS;
/*     */   }
/*     */   
/*  76 */   static final String PS_THREAD_COLUMNS = Arrays.<PsThreadColumns>stream(PsThreadColumns.values()).map(Enum::name)
/*  77 */     .map(String::toLowerCase).collect(Collectors.joining(","));
/*     */   private static final int ARGMAX;
/*     */   
/*     */   static {
/*  81 */     int[] arrayOfInt = new int[2];
/*  82 */     arrayOfInt[0] = 1;
/*  83 */     arrayOfInt[1] = 8;
/*  84 */     Memory memory = new Memory(4L);
/*  85 */     LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(new LibCAPI.size_t(4L));
/*  86 */     if (OpenBsdLibc.INSTANCE.sysctl(arrayOfInt, arrayOfInt.length, (Pointer)memory, byReference, null, LibCAPI.size_t.ZERO) == 0) {
/*  87 */       ARGMAX = memory.getInt(0L);
/*     */     } else {
/*  89 */       LOG.warn("Failed sysctl call for process arguments max size (kern.argmax). Error code: {}", 
/*  90 */           Integer.valueOf(Native.getLastError()));
/*  91 */       ARGMAX = 0;
/*     */     } 
/*     */   }
/*     */   
/*  95 */   private Supplier<String> commandLine = Memoizer.memoize(this::queryCommandLine);
/*  96 */   private Supplier<List<String>> arguments = Memoizer.memoize(this::queryArguments);
/*  97 */   private Supplier<Map<String, String>> environmentVariables = Memoizer.memoize(this::queryEnvironmentVariables);
/*     */   
/*     */   private String name;
/* 100 */   private String path = "";
/*     */   private String user;
/*     */   private String userID;
/*     */   private String group;
/*     */   private String groupID;
/* 105 */   private OSProcess.State state = OSProcess.State.INVALID;
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
/*     */   private int bitness;
/*     */   private String commandLineBackup;
/*     */   
/*     */   public OpenBsdOSProcess(int paramInt, Map<OpenBsdOperatingSystem.PsKeywords, String> paramMap) {
/* 124 */     super(paramInt);
/*     */ 
/*     */     
/* 127 */     this.bitness = Native.LONG_SIZE * 8;
/* 128 */     updateThreadCount();
/* 129 */     updateAttributes(paramMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 134 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPath() {
/* 139 */     return this.path;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCommandLine() {
/* 144 */     return this.commandLine.get();
/*     */   }
/*     */   
/*     */   private String queryCommandLine() {
/* 148 */     String str = String.join(" ", (Iterable)getArguments());
/* 149 */     return str.isEmpty() ? this.commandLineBackup : str;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<String> getArguments() {
/* 154 */     return this.arguments.get();
/*     */   }
/*     */   
/*     */   private List<String> queryArguments() {
/* 158 */     if (ARGMAX > 0) {
/*     */       
/* 160 */       int[] arrayOfInt = new int[4];
/* 161 */       arrayOfInt[0] = 1;
/* 162 */       arrayOfInt[1] = 55;
/* 163 */       arrayOfInt[2] = getProcessID();
/* 164 */       arrayOfInt[3] = 1;
/*     */       
/* 166 */       Memory memory = new Memory(ARGMAX);
/* 167 */       LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(new LibCAPI.size_t(ARGMAX));
/*     */       
/* 169 */       if (OpenBsdLibc.INSTANCE.sysctl(arrayOfInt, arrayOfInt.length, (Pointer)memory, byReference, null, LibCAPI.size_t.ZERO) == 0) {
/*     */         
/* 171 */         ArrayList<String> arrayList = new ArrayList();
/*     */         
/* 173 */         long l1 = 0L;
/*     */         
/* 175 */         long l2 = Pointer.nativeValue((Pointer)memory);
/* 176 */         long l3 = l2 + byReference.getValue().longValue();
/*     */         
/* 178 */         long l4 = Pointer.nativeValue(memory.getPointer(l1));
/* 179 */         while (l4 > l2 && l4 < l3) {
/* 180 */           arrayList.add(memory.getString(l4 - l2));
/* 181 */           l1 += Native.POINTER_SIZE;
/* 182 */           l4 = Pointer.nativeValue(memory.getPointer(l1));
/*     */         } 
/* 184 */         return Collections.unmodifiableList(arrayList);
/*     */       } 
/*     */     } 
/* 187 */     return Collections.emptyList();
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, String> getEnvironmentVariables() {
/* 192 */     return this.environmentVariables.get();
/*     */   }
/*     */ 
/*     */   
/*     */   private Map<String, String> queryEnvironmentVariables() {
/* 197 */     int[] arrayOfInt = new int[4];
/* 198 */     arrayOfInt[0] = 1;
/* 199 */     arrayOfInt[1] = 55;
/* 200 */     arrayOfInt[2] = getProcessID();
/* 201 */     arrayOfInt[3] = 3;
/*     */     
/* 203 */     Memory memory = new Memory(ARGMAX);
/* 204 */     LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(new LibCAPI.size_t(ARGMAX));
/*     */     
/* 206 */     if (OpenBsdLibc.INSTANCE.sysctl(arrayOfInt, arrayOfInt.length, (Pointer)memory, byReference, null, LibCAPI.size_t.ZERO) == 0) {
/*     */       
/* 208 */       LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/*     */       
/* 210 */       long l1 = 0L;
/*     */       
/* 212 */       long l2 = Pointer.nativeValue((Pointer)memory);
/* 213 */       long l3 = l2 + byReference.longValue();
/*     */       
/* 215 */       long l4 = Pointer.nativeValue(memory.getPointer(l1));
/* 216 */       while (l4 > l2 && l4 < l3) {
/* 217 */         String str = memory.getString(l4 - l2);
/* 218 */         int i = str.indexOf('=');
/* 219 */         if (i > 0) {
/* 220 */           linkedHashMap.put(str.substring(0, i), str.substring(i + 1));
/*     */         }
/* 222 */         l1 += Native.POINTER_SIZE;
/* 223 */         l4 = Pointer.nativeValue(memory.getPointer(l1));
/*     */       } 
/* 225 */       return (Map)Collections.unmodifiableMap(linkedHashMap);
/*     */     } 
/* 227 */     return Collections.emptyMap();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCurrentWorkingDirectory() {
/* 232 */     return FstatUtil.getCwd(getProcessID());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUser() {
/* 237 */     return this.user;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUserID() {
/* 242 */     return this.userID;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getGroup() {
/* 247 */     return this.group;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getGroupID() {
/* 252 */     return this.groupID;
/*     */   }
/*     */ 
/*     */   
/*     */   public OSProcess.State getState() {
/* 257 */     return this.state;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getParentProcessID() {
/* 262 */     return this.parentProcessID;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getThreadCount() {
/* 267 */     return this.threadCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPriority() {
/* 272 */     return this.priority;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getVirtualSize() {
/* 277 */     return this.virtualSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getResidentSetSize() {
/* 282 */     return this.residentSetSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getKernelTime() {
/* 287 */     return this.kernelTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUserTime() {
/* 292 */     return this.userTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUpTime() {
/* 297 */     return this.upTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getStartTime() {
/* 302 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesRead() {
/* 307 */     return this.bytesRead;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesWritten() {
/* 312 */     return this.bytesWritten;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getOpenFiles() {
/* 317 */     return FstatUtil.getOpenFiles(getProcessID());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBitness() {
/* 322 */     return this.bitness;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getAffinityMask() {
/* 327 */     long l = 0L;
/*     */ 
/*     */     
/* 330 */     String str = ExecutingCommand.getFirstAnswer("cpuset -gp " + getProcessID());
/*     */ 
/*     */ 
/*     */     
/* 334 */     String[] arrayOfString = str.split(":");
/* 335 */     if (arrayOfString.length > 1) {
/* 336 */       String[] arrayOfString1 = arrayOfString[1].split(",");
/* 337 */       for (String str1 : arrayOfString1) {
/* 338 */         int i = ParseUtil.parseIntOrDefault(str1.trim(), -1);
/* 339 */         if (i >= 0) {
/* 340 */           l |= 1L << i;
/*     */         }
/*     */       } 
/*     */     } 
/* 344 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSThread> getThreadDetails() {
/* 349 */     ArrayList<OSThread> arrayList = new ArrayList();
/* 350 */     String str = "ps -aHwwxo " + PS_THREAD_COLUMNS;
/* 351 */     if (getProcessID() >= 0) {
/* 352 */       str = str + " -p " + getProcessID();
/*     */     }
/* 354 */     List list = ExecutingCommand.runNative(str);
/* 355 */     if (list.isEmpty() || list.size() < 2) {
/* 356 */       return arrayList;
/*     */     }
/*     */     
/* 359 */     list.remove(0);
/*     */     
/* 361 */     for (String str1 : list) {
/* 362 */       Map<PsThreadColumns, String> map = ParseUtil.stringToEnumMap(PsThreadColumns.class, str1.trim(), ' ');
/*     */       
/* 364 */       if (map.containsKey(PsThreadColumns.ARGS)) {
/* 365 */         arrayList.add(new OpenBsdOSThread(getProcessID(), map));
/*     */       }
/*     */     } 
/* 368 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMinorFaults() {
/* 373 */     return this.minorFaults;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMajorFaults() {
/* 378 */     return this.majorFaults;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContextSwitches() {
/* 383 */     return this.contextSwitches;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 389 */     String str = "ps -awwxo " + OpenBsdOperatingSystem.PS_COMMAND_ARGS + " -p " + getProcessID();
/* 390 */     List<String> list = ExecutingCommand.runNative(str);
/* 391 */     if (list.size() > 1) {
/*     */       
/* 393 */       Map<OpenBsdOperatingSystem.PsKeywords, String> map = ParseUtil.stringToEnumMap(OpenBsdOperatingSystem.PsKeywords.class, ((String)list.get(1)).trim(), ' ');
/*     */       
/* 395 */       if (map.containsKey(OpenBsdOperatingSystem.PsKeywords.ARGS)) {
/* 396 */         updateThreadCount();
/* 397 */         return updateAttributes(map);
/*     */       } 
/*     */     } 
/* 400 */     this.state = OSProcess.State.INVALID;
/* 401 */     return false;
/*     */   }
/*     */   
/*     */   private boolean updateAttributes(Map<OpenBsdOperatingSystem.PsKeywords, String> paramMap) {
/* 405 */     long l1 = System.currentTimeMillis();
/* 406 */     switch (((String)paramMap.get(OpenBsdOperatingSystem.PsKeywords.STATE)).charAt(0)) {
/*     */       case 'R':
/* 408 */         this.state = OSProcess.State.RUNNING;
/*     */         break;
/*     */       case 'I':
/*     */       case 'S':
/* 412 */         this.state = OSProcess.State.SLEEPING;
/*     */         break;
/*     */       case 'D':
/*     */       case 'L':
/*     */       case 'U':
/* 417 */         this.state = OSProcess.State.WAITING;
/*     */         break;
/*     */       case 'Z':
/* 420 */         this.state = OSProcess.State.ZOMBIE;
/*     */         break;
/*     */       case 'T':
/* 423 */         this.state = OSProcess.State.STOPPED;
/*     */         break;
/*     */       default:
/* 426 */         this.state = OSProcess.State.OTHER;
/*     */         break;
/*     */     } 
/* 429 */     this.parentProcessID = ParseUtil.parseIntOrDefault(paramMap.get(OpenBsdOperatingSystem.PsKeywords.PPID), 0);
/* 430 */     this.user = paramMap.get(OpenBsdOperatingSystem.PsKeywords.USER);
/* 431 */     this.userID = paramMap.get(OpenBsdOperatingSystem.PsKeywords.UID);
/* 432 */     this.group = paramMap.get(OpenBsdOperatingSystem.PsKeywords.GROUP);
/* 433 */     this.groupID = paramMap.get(OpenBsdOperatingSystem.PsKeywords.GID);
/* 434 */     this.priority = ParseUtil.parseIntOrDefault(paramMap.get(OpenBsdOperatingSystem.PsKeywords.PRI), 0);
/*     */     
/* 436 */     this.virtualSize = ParseUtil.parseLongOrDefault(paramMap.get(OpenBsdOperatingSystem.PsKeywords.VSZ), 0L) * 1024L;
/* 437 */     this.residentSetSize = ParseUtil.parseLongOrDefault(paramMap.get(OpenBsdOperatingSystem.PsKeywords.RSS), 0L) * 1024L;
/*     */     
/* 439 */     long l2 = ParseUtil.parseDHMSOrDefault(paramMap.get(OpenBsdOperatingSystem.PsKeywords.ETIME), 0L);
/* 440 */     this.upTime = (l2 < 1L) ? 1L : l2;
/* 441 */     this.startTime = l1 - this.upTime;
/* 442 */     this.userTime = ParseUtil.parseDHMSOrDefault(paramMap.get(OpenBsdOperatingSystem.PsKeywords.CPUTIME), 0L);
/*     */     
/* 444 */     this.kernelTime = 0L;
/* 445 */     this.path = paramMap.get(OpenBsdOperatingSystem.PsKeywords.COMM);
/* 446 */     this.name = this.path.substring(this.path.lastIndexOf('/') + 1);
/* 447 */     this.minorFaults = ParseUtil.parseLongOrDefault(paramMap.get(OpenBsdOperatingSystem.PsKeywords.MINFLT), 0L);
/* 448 */     this.majorFaults = ParseUtil.parseLongOrDefault(paramMap.get(OpenBsdOperatingSystem.PsKeywords.MAJFLT), 0L);
/* 449 */     long l3 = ParseUtil.parseLongOrDefault(paramMap.get(OpenBsdOperatingSystem.PsKeywords.NIVCSW), 0L);
/* 450 */     long l4 = ParseUtil.parseLongOrDefault(paramMap.get(OpenBsdOperatingSystem.PsKeywords.NVCSW), 0L);
/* 451 */     this.contextSwitches = l4 + l3;
/* 452 */     this.commandLineBackup = paramMap.get(OpenBsdOperatingSystem.PsKeywords.ARGS);
/* 453 */     return true;
/*     */   }
/*     */   
/*     */   private void updateThreadCount() {
/* 457 */     List list = ExecutingCommand.runNative("ps -axHo tid -p " + getProcessID());
/* 458 */     if (!list.isEmpty())
/*     */     {
/* 460 */       this.threadCount = list.size() - 1;
/*     */     }
/* 462 */     this.threadCount = 1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\openbsd\OpenBsdOSProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */