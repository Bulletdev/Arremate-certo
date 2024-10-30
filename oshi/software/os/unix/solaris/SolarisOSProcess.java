/*     */ package oshi.software.os.unix.solaris;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collectors;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.unix.solaris.PsInfo;
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
/*     */ @ThreadSafe
/*     */ public class SolarisOSProcess
/*     */   extends AbstractOSProcess
/*     */ {
/*     */   enum PsThreadColumns
/*     */   {
/*  62 */     LWP, S, ETIME, TIME, ADDR, PRI;
/*     */   }
/*     */   
/*  65 */   static final String PS_THREAD_COLUMNS = Arrays.<PsThreadColumns>stream(PsThreadColumns.values()).map(Enum::name)
/*  66 */     .map(String::toLowerCase).collect(Collectors.joining(","));
/*     */   
/*  68 */   private Supplier<Integer> bitness = Memoizer.memoize(this::queryBitness);
/*  69 */   private Supplier<String> commandLine = Memoizer.memoize(this::queryCommandLine);
/*  70 */   private Supplier<Pair<List<String>, Map<String, String>>> cmdEnv = Memoizer.memoize(this::queryCommandlineEnvironment);
/*     */   
/*     */   private String name;
/*  73 */   private String path = "";
/*     */   private String commandLineBackup;
/*     */   private String user;
/*     */   private String userID;
/*     */   private String group;
/*     */   private String groupID;
/*  79 */   private OSProcess.State state = OSProcess.State.INVALID;
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
/*  91 */   private long contextSwitches = 0L;
/*     */   
/*     */   public SolarisOSProcess(int paramInt, Map<SolarisOperatingSystem.PsKeywords, String> paramMap, Map<SolarisOperatingSystem.PrstatKeywords, String> paramMap1) {
/*  94 */     super(paramInt);
/*  95 */     updateAttributes(paramMap, paramMap1);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 100 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPath() {
/* 105 */     return this.path;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCommandLine() {
/* 110 */     return this.commandLine.get();
/*     */   }
/*     */   
/*     */   private String queryCommandLine() {
/* 114 */     String str = String.join(" ", (Iterable)getArguments());
/* 115 */     return str.isEmpty() ? this.commandLineBackup : str;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<String> getArguments() {
/* 120 */     return (List<String>)((Pair)this.cmdEnv.get()).getA();
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, String> getEnvironmentVariables() {
/* 125 */     return (Map<String, String>)((Pair)this.cmdEnv.get()).getB();
/*     */   }
/*     */   
/*     */   private Pair<List<String>, Map<String, String>> queryCommandlineEnvironment() {
/* 129 */     return PsInfo.queryArgsEnv(getProcessID());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCurrentWorkingDirectory() {
/* 134 */     return LsofUtil.getCwd(getProcessID());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUser() {
/* 139 */     return this.user;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUserID() {
/* 144 */     return this.userID;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getGroup() {
/* 149 */     return this.group;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getGroupID() {
/* 154 */     return this.groupID;
/*     */   }
/*     */ 
/*     */   
/*     */   public OSProcess.State getState() {
/* 159 */     return this.state;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getParentProcessID() {
/* 164 */     return this.parentProcessID;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getThreadCount() {
/* 169 */     return this.threadCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPriority() {
/* 174 */     return this.priority;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getVirtualSize() {
/* 179 */     return this.virtualSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getResidentSetSize() {
/* 184 */     return this.residentSetSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getKernelTime() {
/* 189 */     return this.kernelTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUserTime() {
/* 194 */     return this.userTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUpTime() {
/* 199 */     return this.upTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getStartTime() {
/* 204 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesRead() {
/* 209 */     return this.bytesRead;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesWritten() {
/* 214 */     return this.bytesWritten;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContextSwitches() {
/* 219 */     return this.contextSwitches;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getOpenFiles() {
/* 224 */     return LsofUtil.getOpenFiles(getProcessID());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBitness() {
/* 229 */     return ((Integer)this.bitness.get()).intValue();
/*     */   }
/*     */   
/*     */   private int queryBitness() {
/* 233 */     List list = ExecutingCommand.runNative("pflags " + getProcessID());
/* 234 */     for (String str : list) {
/* 235 */       if (str.contains("data model")) {
/* 236 */         if (str.contains("LP32"))
/* 237 */           return 32; 
/* 238 */         if (str.contains("LP64")) {
/* 239 */           return 64;
/*     */         }
/*     */       } 
/*     */     } 
/* 243 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getAffinityMask() {
/* 248 */     long l = 0L;
/* 249 */     String str = ExecutingCommand.getFirstAnswer("pbind -q " + getProcessID());
/*     */ 
/*     */ 
/*     */     
/* 253 */     if (str.isEmpty()) {
/* 254 */       List list = ExecutingCommand.runNative("psrinfo");
/* 255 */       for (String str1 : list) {
/* 256 */         String[] arrayOfString = ParseUtil.whitespaces.split(str1);
/* 257 */         int i = ParseUtil.parseIntOrDefault(arrayOfString[0], -1);
/* 258 */         if (i >= 0) {
/* 259 */           l |= 1L << i;
/*     */         }
/*     */       } 
/* 262 */       return l;
/* 263 */     }  if (str.endsWith(".") && str.contains("strongly bound to processor(s)")) {
/* 264 */       String str1 = str.substring(0, str.length() - 1);
/* 265 */       String[] arrayOfString = ParseUtil.whitespaces.split(str1);
/* 266 */       for (int i = arrayOfString.length - 1; i >= 0; ) {
/* 267 */         int j = ParseUtil.parseIntOrDefault(arrayOfString[i], -1);
/* 268 */         if (j >= 0) {
/* 269 */           l |= 1L << j;
/*     */           
/*     */           i--;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 276 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSThread> getThreadDetails() {
/* 281 */     ArrayList<SolarisOSThread> arrayList = new ArrayList();
/* 282 */     List list = ExecutingCommand.runNative("ps -o " + PS_THREAD_COLUMNS + " -p " + getProcessID());
/* 283 */     if (list.size() > 1) {
/*     */       
/* 285 */       List list1 = ExecutingCommand.runNative("prstat -L -v -p " + getProcessID() + " 1 1");
/* 286 */       HashMap<Object, Object> hashMap = new HashMap<>();
/* 287 */       for (String str1 : list1) {
/* 288 */         String str2 = str1.trim();
/*     */         
/* 290 */         int i = str2.lastIndexOf('/');
/* 291 */         if (i > 0) {
/* 292 */           hashMap.put(str2.substring(i + 1), str2);
/*     */         }
/*     */       } 
/*     */       
/* 296 */       list.remove(0);
/* 297 */       for (String str : list) {
/* 298 */         Map<PsThreadColumns, String> map = ParseUtil.stringToEnumMap(PsThreadColumns.class, str.trim(), ' ');
/*     */ 
/*     */         
/* 301 */         if (map.containsKey(PsThreadColumns.PRI)) {
/* 302 */           String str1 = (String)map.get(PsThreadColumns.LWP);
/* 303 */           Map<SolarisOperatingSystem.PrstatKeywords, String> map1 = ParseUtil.stringToEnumMap(SolarisOperatingSystem.PrstatKeywords.class, (String)hashMap
/* 304 */               .getOrDefault(str1, ""), ' ');
/* 305 */           arrayList.add(new SolarisOSThread(getProcessID(), map, map1));
/*     */         } 
/*     */       } 
/*     */     } 
/* 309 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 314 */     int i = getProcessID();
/*     */     
/* 316 */     List<String> list = ExecutingCommand.runNative("ps -o " + SolarisOperatingSystem.PS_COMMAND_ARGS + " -p " + i);
/* 317 */     if (list.size() > 1) {
/* 318 */       Map<SolarisOperatingSystem.PsKeywords, String> map = ParseUtil.stringToEnumMap(SolarisOperatingSystem.PsKeywords.class, ((String)list.get(1)).trim(), ' ');
/*     */       
/* 320 */       if (map.containsKey(SolarisOperatingSystem.PsKeywords.ARGS)) {
/* 321 */         String str1 = (String)map.get(SolarisOperatingSystem.PsKeywords.PID);
/* 322 */         List list1 = ExecutingCommand.runNative("prstat -v -p " + str1 + " 1 1");
/* 323 */         String str2 = "";
/* 324 */         for (String str3 : list1) {
/* 325 */           String str4 = str3.trim();
/* 326 */           if (str4.startsWith(str1 + " ")) {
/* 327 */             str2 = str4;
/*     */             break;
/*     */           } 
/*     */         } 
/* 331 */         Map<SolarisOperatingSystem.PrstatKeywords, String> map1 = ParseUtil.stringToEnumMap(SolarisOperatingSystem.PrstatKeywords.class, str2, ' ');
/* 332 */         return updateAttributes(map, map1);
/*     */       } 
/*     */     } 
/* 335 */     this.state = OSProcess.State.INVALID;
/* 336 */     return false;
/*     */   }
/*     */   
/*     */   private boolean updateAttributes(Map<SolarisOperatingSystem.PsKeywords, String> paramMap, Map<SolarisOperatingSystem.PrstatKeywords, String> paramMap1) {
/* 340 */     long l1 = System.currentTimeMillis();
/* 341 */     this.state = getStateFromOutput(((String)paramMap.get(SolarisOperatingSystem.PsKeywords.S)).charAt(0));
/* 342 */     this.parentProcessID = ParseUtil.parseIntOrDefault(paramMap.get(SolarisOperatingSystem.PsKeywords.PPID), 0);
/* 343 */     this.user = paramMap.get(SolarisOperatingSystem.PsKeywords.USER);
/* 344 */     this.userID = paramMap.get(SolarisOperatingSystem.PsKeywords.UID);
/* 345 */     this.group = paramMap.get(SolarisOperatingSystem.PsKeywords.GROUP);
/* 346 */     this.groupID = paramMap.get(SolarisOperatingSystem.PsKeywords.GID);
/* 347 */     this.threadCount = ParseUtil.parseIntOrDefault(paramMap.get(SolarisOperatingSystem.PsKeywords.NLWP), 0);
/* 348 */     this.priority = ParseUtil.parseIntOrDefault(paramMap.get(SolarisOperatingSystem.PsKeywords.PRI), 0);
/*     */     
/* 350 */     this.virtualSize = ParseUtil.parseLongOrDefault(paramMap.get(SolarisOperatingSystem.PsKeywords.VSZ), 0L) * 1024L;
/* 351 */     this.residentSetSize = ParseUtil.parseLongOrDefault(paramMap.get(SolarisOperatingSystem.PsKeywords.RSS), 0L) * 1024L;
/*     */     
/* 353 */     long l2 = ParseUtil.parseDHMSOrDefault(paramMap.get(SolarisOperatingSystem.PsKeywords.ETIME), 0L);
/* 354 */     this.upTime = (l2 < 1L) ? 1L : l2;
/* 355 */     this.startTime = l1 - this.upTime;
/* 356 */     this.kernelTime = 0L;
/* 357 */     this.userTime = ParseUtil.parseDHMSOrDefault(paramMap.get(SolarisOperatingSystem.PsKeywords.TIME), 0L);
/* 358 */     this.path = paramMap.get(SolarisOperatingSystem.PsKeywords.COMM);
/* 359 */     this.name = this.path.substring(this.path.lastIndexOf('/') + 1);
/* 360 */     this.commandLineBackup = paramMap.get(SolarisOperatingSystem.PsKeywords.ARGS);
/* 361 */     if (paramMap1.containsKey(SolarisOperatingSystem.PrstatKeywords.ICX)) {
/* 362 */       long l3 = ParseUtil.parseLongOrDefault(paramMap1.get(SolarisOperatingSystem.PrstatKeywords.ICX), 0L);
/* 363 */       long l4 = ParseUtil.parseLongOrDefault(paramMap1.get(SolarisOperatingSystem.PrstatKeywords.VCX), 0L);
/* 364 */       this.contextSwitches = l4 + l3;
/*     */     } 
/* 366 */     return true;
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
/* 379 */     switch (paramChar)
/*     */     { case 'O':
/* 381 */         state = OSProcess.State.RUNNING;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 400 */         return state;case 'S': state = OSProcess.State.SLEEPING; return state;case 'R': case 'W': state = OSProcess.State.WAITING; return state;case 'Z': state = OSProcess.State.ZOMBIE; return state;case 'T': state = OSProcess.State.STOPPED; return state; }  OSProcess.State state = OSProcess.State.OTHER; return state;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\solaris\SolarisOSProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */