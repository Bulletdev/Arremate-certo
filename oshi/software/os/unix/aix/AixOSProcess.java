/*     */ package oshi.software.os.unix.aix;
/*     */ 
/*     */ import com.sun.jna.platform.unix.aix.Perfstat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.unix.aix.PsInfo;
/*     */ import oshi.driver.unix.aix.perfstat.PerfstatCpu;
/*     */ import oshi.software.common.AbstractOSProcess;
/*     */ import oshi.software.os.OSProcess;
/*     */ import oshi.software.os.OSThread;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.LsofUtil;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
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
/*     */ @ThreadSafe
/*     */ public class AixOSProcess
/*     */   extends AbstractOSProcess
/*     */ {
/*     */   enum PsThreadColumns
/*     */   {
/*  65 */     USER, PID, PPID, TID, ST, CP, PRI, SC, WCHAN, F, TT, BND, COMMAND;
/*     */   }
/*     */   
/*  68 */   private Supplier<Integer> bitness = Memoizer.memoize(this::queryBitness);
/*  69 */   private Supplier<String> commandLine = Memoizer.memoize(this::queryCommandLine);
/*  70 */   private Supplier<Pair<List<String>, Map<String, String>>> cmdEnv = Memoizer.memoize(this::queryCommandlineEnvironment);
/*  71 */   private final Supplier<Long> affinityMask = Memoizer.memoize(PerfstatCpu::queryCpuAffinityMask, Memoizer.defaultExpiration());
/*     */   
/*     */   private String name;
/*  74 */   private String path = "";
/*     */   private String commandLineBackup;
/*     */   private String user;
/*     */   private String userID;
/*     */   private String group;
/*     */   private String groupID;
/*  80 */   private OSProcess.State state = OSProcess.State.INVALID;
/*     */   
/*     */   private int parentProcessID;
/*     */   
/*     */   private int threadCount;
/*     */   
/*     */   private int priority;
/*     */   private long virtualSize;
/*     */   private long residentSetSize;
/*     */   private long kernelTime;
/*     */   private long userTime;
/*     */   private long startTime;
/*     */   private long upTime;
/*     */   private long bytesRead;
/*     */   private long bytesWritten;
/*     */   private long majorFaults;
/*     */   private Supplier<Perfstat.perfstat_process_t[]> procCpu;
/*     */   
/*     */   public AixOSProcess(int paramInt, Map<AixOperatingSystem.PsKeywords, String> paramMap, Map<Integer, Pair<Long, Long>> paramMap1, Supplier<Perfstat.perfstat_process_t[]> paramSupplier) {
/*  99 */     super(paramInt);
/* 100 */     this.procCpu = paramSupplier;
/* 101 */     updateAttributes(paramMap, paramMap1);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 106 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPath() {
/* 111 */     return this.path;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCommandLine() {
/* 116 */     return this.commandLine.get();
/*     */   }
/*     */   
/*     */   private String queryCommandLine() {
/* 120 */     String str = String.join(" ", (Iterable)getArguments());
/* 121 */     return str.isEmpty() ? this.commandLineBackup : str;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<String> getArguments() {
/* 126 */     return (List<String>)((Pair)this.cmdEnv.get()).getA();
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, String> getEnvironmentVariables() {
/* 131 */     return (Map<String, String>)((Pair)this.cmdEnv.get()).getB();
/*     */   }
/*     */   
/*     */   private Pair<List<String>, Map<String, String>> queryCommandlineEnvironment() {
/* 135 */     return PsInfo.queryArgsEnv(getProcessID());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCurrentWorkingDirectory() {
/* 140 */     return LsofUtil.getCwd(getProcessID());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUser() {
/* 145 */     return this.user;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUserID() {
/* 150 */     return this.userID;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getGroup() {
/* 155 */     return this.group;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getGroupID() {
/* 160 */     return this.groupID;
/*     */   }
/*     */ 
/*     */   
/*     */   public OSProcess.State getState() {
/* 165 */     return this.state;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getParentProcessID() {
/* 170 */     return this.parentProcessID;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getThreadCount() {
/* 175 */     return this.threadCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPriority() {
/* 180 */     return this.priority;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getVirtualSize() {
/* 185 */     return this.virtualSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getResidentSetSize() {
/* 190 */     return this.residentSetSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getKernelTime() {
/* 195 */     return this.kernelTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUserTime() {
/* 200 */     return this.userTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUpTime() {
/* 205 */     return this.upTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getStartTime() {
/* 210 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesRead() {
/* 215 */     return this.bytesRead;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesWritten() {
/* 220 */     return this.bytesWritten;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getOpenFiles() {
/* 225 */     return LsofUtil.getOpenFiles(getProcessID());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBitness() {
/* 230 */     return ((Integer)this.bitness.get()).intValue();
/*     */   }
/*     */   
/*     */   private int queryBitness() {
/* 234 */     List list = ExecutingCommand.runNative("pflags " + getProcessID());
/* 235 */     for (String str : list) {
/* 236 */       if (str.contains("data model")) {
/* 237 */         if (str.contains("LP32"))
/* 238 */           return 32; 
/* 239 */         if (str.contains("LP64")) {
/* 240 */           return 64;
/*     */         }
/*     */       } 
/*     */     } 
/* 244 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getAffinityMask() {
/* 253 */     long l = 0L;
/* 254 */     List list = ExecutingCommand.runNative("ps -m -o THREAD -p " + getProcessID());
/* 255 */     if (list.size() > 2) {
/* 256 */       list.remove(0);
/* 257 */       list.remove(0);
/* 258 */       for (String str : list) {
/* 259 */         Map map = ParseUtil.stringToEnumMap(PsThreadColumns.class, str
/* 260 */             .trim(), ' ');
/* 261 */         if (map.containsKey(PsThreadColumns.COMMAND) && ((String)map
/* 262 */           .get(PsThreadColumns.ST)).charAt(0) != 'Z') {
/* 263 */           String str1 = (String)map.get(PsThreadColumns.BND);
/* 264 */           if (str1.charAt(0) == '-') {
/* 265 */             return ((Long)this.affinityMask.get()).longValue();
/*     */           }
/* 267 */           int i = ParseUtil.parseIntOrDefault(str1, 0);
/* 268 */           l |= 1L << i;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 273 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSThread> getThreadDetails() {
/* 278 */     List list = ExecutingCommand.runNative("ps -m -o THREAD -p " + getProcessID());
/*     */     
/* 280 */     if (list.size() > 2) {
/* 281 */       ArrayList<AixOSThread> arrayList = new ArrayList();
/* 282 */       list.remove(0);
/* 283 */       list.remove(0);
/* 284 */       for (String str : list) {
/* 285 */         Map<PsThreadColumns, String> map = ParseUtil.stringToEnumMap(PsThreadColumns.class, str
/* 286 */             .trim(), ' ');
/* 287 */         if (map.containsKey(PsThreadColumns.COMMAND)) {
/* 288 */           arrayList.add(new AixOSThread(getProcessID(), map));
/*     */         }
/*     */       } 
/* 291 */       return (List)arrayList;
/*     */     } 
/* 293 */     return Collections.emptyList();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMajorFaults() {
/* 298 */     return this.majorFaults;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 303 */     Perfstat.perfstat_process_t[] arrayOfPerfstat_process_t = this.procCpu.get();
/*     */     
/* 305 */     List<String> list = ExecutingCommand.runNative("ps -o " + AixOperatingSystem.PS_COMMAND_ARGS + " -p " + getProcessID());
/*     */     
/* 307 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 308 */     for (Perfstat.perfstat_process_t perfstat_process_t : arrayOfPerfstat_process_t) {
/* 309 */       hashMap.put(Integer.valueOf((int)perfstat_process_t.pid), new Pair(Long.valueOf((long)perfstat_process_t.ucpu_time), Long.valueOf((long)perfstat_process_t.scpu_time)));
/*     */     }
/* 311 */     if (list.size() > 1) {
/* 312 */       Map<AixOperatingSystem.PsKeywords, String> map = ParseUtil.stringToEnumMap(AixOperatingSystem.PsKeywords.class, ((String)list.get(1)).trim(), ' ');
/*     */       
/* 314 */       if (map.containsKey(AixOperatingSystem.PsKeywords.ARGS)) {
/* 315 */         return updateAttributes(map, (Map)hashMap);
/*     */       }
/*     */     } 
/* 318 */     this.state = OSProcess.State.INVALID;
/* 319 */     return false;
/*     */   }
/*     */   
/*     */   private boolean updateAttributes(Map<AixOperatingSystem.PsKeywords, String> paramMap, Map<Integer, Pair<Long, Long>> paramMap1) {
/* 323 */     long l1 = System.currentTimeMillis();
/* 324 */     this.state = getStateFromOutput(((String)paramMap.get(AixOperatingSystem.PsKeywords.ST)).charAt(0));
/* 325 */     this.parentProcessID = ParseUtil.parseIntOrDefault(paramMap.get(AixOperatingSystem.PsKeywords.PPID), 0);
/* 326 */     this.user = paramMap.get(AixOperatingSystem.PsKeywords.USER);
/* 327 */     this.userID = paramMap.get(AixOperatingSystem.PsKeywords.UID);
/* 328 */     this.group = paramMap.get(AixOperatingSystem.PsKeywords.GROUP);
/* 329 */     this.groupID = paramMap.get(AixOperatingSystem.PsKeywords.GID);
/* 330 */     this.threadCount = ParseUtil.parseIntOrDefault(paramMap.get(AixOperatingSystem.PsKeywords.THCOUNT), 0);
/* 331 */     this.priority = ParseUtil.parseIntOrDefault(paramMap.get(AixOperatingSystem.PsKeywords.PRI), 0);
/*     */     
/* 333 */     this.virtualSize = ParseUtil.parseLongOrDefault(paramMap.get(AixOperatingSystem.PsKeywords.VSIZE), 0L) << 10L;
/* 334 */     this.residentSetSize = ParseUtil.parseLongOrDefault(paramMap.get(AixOperatingSystem.PsKeywords.RSSIZE), 0L) << 10L;
/* 335 */     long l2 = ParseUtil.parseDHMSOrDefault(paramMap.get(AixOperatingSystem.PsKeywords.ETIME), 0L);
/* 336 */     if (paramMap1.containsKey(Integer.valueOf(getProcessID()))) {
/* 337 */       Pair pair = paramMap1.get(Integer.valueOf(getProcessID()));
/* 338 */       this.userTime = ((Long)pair.getA()).longValue();
/* 339 */       this.kernelTime = ((Long)pair.getB()).longValue();
/*     */     } else {
/* 341 */       this.userTime = ParseUtil.parseDHMSOrDefault(paramMap.get(AixOperatingSystem.PsKeywords.TIME), 0L);
/* 342 */       this.kernelTime = 0L;
/*     */     } 
/*     */     
/* 345 */     this.upTime = (l2 < 1L) ? 1L : l2;
/* 346 */     while (this.upTime < this.userTime + this.kernelTime) {
/* 347 */       this.upTime += 500L;
/*     */     }
/* 349 */     this.startTime = l1 - this.upTime;
/* 350 */     this.name = paramMap.get(AixOperatingSystem.PsKeywords.COMM);
/* 351 */     this.majorFaults = ParseUtil.parseLongOrDefault(paramMap.get(AixOperatingSystem.PsKeywords.PAGEIN), 0L);
/* 352 */     this.commandLineBackup = paramMap.get(AixOperatingSystem.PsKeywords.ARGS);
/* 353 */     this.path = ParseUtil.whitespaces.split(this.commandLineBackup)[0];
/* 354 */     return true;
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
/*     */   static OSProcess.State getStateFromOutput(char paramChar) {
/* 367 */     switch (paramChar)
/*     */     { case 'O':
/* 369 */         state = OSProcess.State.INVALID;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 392 */         return state;case 'A': case 'R': state = OSProcess.State.RUNNING; return state;case 'I': state = OSProcess.State.WAITING; return state;case 'S': case 'W': state = OSProcess.State.SLEEPING; return state;case 'Z': state = OSProcess.State.ZOMBIE; return state;case 'T': state = OSProcess.State.STOPPED; return state; }  OSProcess.State state = OSProcess.State.OTHER; return state;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\aix\AixOSProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */