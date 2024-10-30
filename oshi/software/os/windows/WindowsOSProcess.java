/*     */ package oshi.software.os.windows;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.platform.win32.Advapi32;
/*     */ import com.sun.jna.platform.win32.Advapi32Util;
/*     */ import com.sun.jna.platform.win32.BaseTSD;
/*     */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*     */ import com.sun.jna.platform.win32.Kernel32;
/*     */ import com.sun.jna.platform.win32.Kernel32Util;
/*     */ import com.sun.jna.platform.win32.Shell32Util;
/*     */ import com.sun.jna.platform.win32.VersionHelpers;
/*     */ import com.sun.jna.platform.win32.Win32Exception;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import java.io.File;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collectors;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.windows.registry.ProcessPerformanceData;
/*     */ import oshi.driver.windows.registry.ProcessWtsData;
/*     */ import oshi.driver.windows.registry.ThreadPerformanceData;
/*     */ import oshi.driver.windows.wmi.Win32Process;
/*     */ import oshi.driver.windows.wmi.Win32ProcessCached;
/*     */ import oshi.jna.platform.windows.NtDll;
/*     */ import oshi.software.common.AbstractOSProcess;
/*     */ import oshi.software.os.OSProcess;
/*     */ import oshi.software.os.OSThread;
/*     */ import oshi.util.GlobalConfig;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.windows.WmiUtil;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public class WindowsOSProcess
/*     */   extends AbstractOSProcess
/*     */ {
/*  86 */   private static final Logger LOG = LoggerFactory.getLogger(WindowsOSProcess.class);
/*     */   
/*     */   public static final String OSHI_OS_WINDOWS_COMMANDLINE_BATCH = "oshi.os.windows.commandline.batch";
/*     */   
/*  90 */   private static final boolean USE_BATCH_COMMANDLINE = GlobalConfig.get("oshi.os.windows.commandline.batch", false);
/*     */ 
/*     */   
/*  93 */   private static final boolean USE_PROCSTATE_SUSPENDED = GlobalConfig.get("oshi.os.windows.procstate.suspended", false);
/*     */   
/*  95 */   private static final boolean IS_VISTA_OR_GREATER = VersionHelpers.IsWindowsVistaOrGreater();
/*  96 */   private static final boolean IS_WINDOWS7_OR_GREATER = VersionHelpers.IsWindows7OrGreater();
/*     */ 
/*     */   
/*     */   private final WindowsOperatingSystem os;
/*     */   
/* 101 */   private Supplier<Pair<String, String>> userInfo = Memoizer.memoize(this::queryUserInfo);
/* 102 */   private Supplier<Pair<String, String>> groupInfo = Memoizer.memoize(this::queryGroupInfo);
/* 103 */   private Supplier<String> currentWorkingDirectory = Memoizer.memoize(this::queryCwd);
/* 104 */   private Supplier<String> commandLine = Memoizer.memoize(this::queryCommandLine);
/* 105 */   private Supplier<List<String>> args = Memoizer.memoize(this::queryArguments);
/* 106 */   private Supplier<Triplet<String, String, Map<String, String>>> cwdCmdEnv = Memoizer.memoize(this::queryCwdCommandlineEnvironment);
/*     */   
/*     */   private String name;
/*     */   
/*     */   private String path;
/* 111 */   private OSProcess.State state = OSProcess.State.INVALID;
/*     */   
/*     */   private int parentProcessID;
/*     */   
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
/*     */   private long pageFaults;
/*     */   
/*     */   public WindowsOSProcess(int paramInt, WindowsOperatingSystem paramWindowsOperatingSystem, Map<Integer, ProcessPerformanceData.PerfCounterBlock> paramMap, Map<Integer, ProcessWtsData.WtsInfo> paramMap1, Map<Integer, ThreadPerformanceData.PerfCounterBlock> paramMap2) {
/* 130 */     super(paramInt);
/*     */     
/* 132 */     this.os = paramWindowsOperatingSystem;
/*     */     
/* 134 */     this.bitness = paramWindowsOperatingSystem.getBitness();
/* 135 */     updateAttributes(paramMap.get(Integer.valueOf(paramInt)), paramMap1.get(Integer.valueOf(paramInt)), paramMap2);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 140 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPath() {
/* 145 */     return this.path;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCommandLine() {
/* 150 */     return this.commandLine.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<String> getArguments() {
/* 155 */     return this.args.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, String> getEnvironmentVariables() {
/* 160 */     return (Map<String, String>)((Triplet)this.cwdCmdEnv.get()).getC();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCurrentWorkingDirectory() {
/* 165 */     return this.currentWorkingDirectory.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUser() {
/* 170 */     return (String)((Pair)this.userInfo.get()).getA();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUserID() {
/* 175 */     return (String)((Pair)this.userInfo.get()).getB();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getGroup() {
/* 180 */     return (String)((Pair)this.groupInfo.get()).getA();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getGroupID() {
/* 185 */     return (String)((Pair)this.groupInfo.get()).getB();
/*     */   }
/*     */ 
/*     */   
/*     */   public OSProcess.State getState() {
/* 190 */     return this.state;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getParentProcessID() {
/* 195 */     return this.parentProcessID;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getThreadCount() {
/* 200 */     return this.threadCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPriority() {
/* 205 */     return this.priority;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getVirtualSize() {
/* 210 */     return this.virtualSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getResidentSetSize() {
/* 215 */     return this.residentSetSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getKernelTime() {
/* 220 */     return this.kernelTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUserTime() {
/* 225 */     return this.userTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUpTime() {
/* 230 */     return this.upTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getStartTime() {
/* 235 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesRead() {
/* 240 */     return this.bytesRead;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getBytesWritten() {
/* 245 */     return this.bytesWritten;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getOpenFiles() {
/* 250 */     return this.openFiles;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBitness() {
/* 255 */     return this.bitness;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getAffinityMask() {
/* 260 */     WinNT.HANDLE hANDLE = Kernel32.INSTANCE.OpenProcess(1024, false, getProcessID());
/* 261 */     if (hANDLE != null) {
/*     */       try {
/* 263 */         BaseTSD.ULONG_PTRByReference uLONG_PTRByReference1 = new BaseTSD.ULONG_PTRByReference();
/* 264 */         BaseTSD.ULONG_PTRByReference uLONG_PTRByReference2 = new BaseTSD.ULONG_PTRByReference();
/* 265 */         if (Kernel32.INSTANCE.GetProcessAffinityMask(hANDLE, uLONG_PTRByReference1, uLONG_PTRByReference2)) {
/* 266 */           return Pointer.nativeValue(uLONG_PTRByReference1.getValue().toPointer());
/*     */         }
/*     */       } finally {
/* 269 */         Kernel32.INSTANCE.CloseHandle(hANDLE);
/*     */       } 
/* 271 */       Kernel32.INSTANCE.CloseHandle(hANDLE);
/*     */     } 
/* 273 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMinorFaults() {
/* 278 */     return this.pageFaults;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<OSThread> getThreadDetails() {
/* 285 */     Map map = ThreadPerformanceData.buildThreadMapFromRegistry(Collections.singleton(Integer.valueOf(getProcessID())));
/*     */     
/* 287 */     if (map != null) {
/* 288 */       map = ThreadPerformanceData.buildThreadMapFromPerfCounters(Collections.singleton(Integer.valueOf(getProcessID())));
/*     */     }
/* 290 */     if (map == null) {
/* 291 */       return Collections.emptyList();
/*     */     }
/* 293 */     return (List<OSThread>)map.entrySet().stream()
/* 294 */       .map(paramEntry -> new WindowsOSThread(getProcessID(), ((Integer)paramEntry.getKey()).intValue(), this.name, (ThreadPerformanceData.PerfCounterBlock)paramEntry.getValue()))
/* 295 */       .collect(Collectors.toList());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 300 */     Set<Integer> set = Collections.singleton(Integer.valueOf(getProcessID()));
/*     */ 
/*     */     
/* 303 */     Map map1 = ProcessPerformanceData.buildProcessMapFromRegistry(null);
/*     */     
/* 305 */     if (map1 == null) {
/* 306 */       map1 = ProcessPerformanceData.buildProcessMapFromPerfCounters(set);
/*     */     }
/* 308 */     Map<Integer, ThreadPerformanceData.PerfCounterBlock> map = null;
/* 309 */     if (USE_PROCSTATE_SUSPENDED) {
/* 310 */       map = ThreadPerformanceData.buildThreadMapFromRegistry(null);
/*     */       
/* 312 */       if (map == null) {
/* 313 */         map = ThreadPerformanceData.buildThreadMapFromPerfCounters(null);
/*     */       }
/*     */     } 
/* 316 */     Map map2 = ProcessWtsData.queryProcessWtsMap(set);
/* 317 */     return updateAttributes((ProcessPerformanceData.PerfCounterBlock)map1.get(Integer.valueOf(getProcessID())), (ProcessWtsData.WtsInfo)map2.get(Integer.valueOf(getProcessID())), map);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean updateAttributes(ProcessPerformanceData.PerfCounterBlock paramPerfCounterBlock, ProcessWtsData.WtsInfo paramWtsInfo, Map<Integer, ThreadPerformanceData.PerfCounterBlock> paramMap) {
/* 322 */     this.name = paramPerfCounterBlock.getName();
/* 323 */     this.path = paramWtsInfo.getPath();
/* 324 */     this.parentProcessID = paramPerfCounterBlock.getParentProcessID();
/* 325 */     this.threadCount = paramWtsInfo.getThreadCount();
/* 326 */     this.priority = paramPerfCounterBlock.getPriority();
/* 327 */     this.virtualSize = paramWtsInfo.getVirtualSize();
/* 328 */     this.residentSetSize = paramPerfCounterBlock.getResidentSetSize();
/* 329 */     this.kernelTime = paramWtsInfo.getKernelTime();
/* 330 */     this.userTime = paramWtsInfo.getUserTime();
/* 331 */     this.startTime = paramPerfCounterBlock.getStartTime();
/* 332 */     this.upTime = paramPerfCounterBlock.getUpTime();
/* 333 */     this.bytesRead = paramPerfCounterBlock.getBytesRead();
/* 334 */     this.bytesWritten = paramPerfCounterBlock.getBytesWritten();
/* 335 */     this.openFiles = paramWtsInfo.getOpenFiles();
/* 336 */     this.pageFaults = paramPerfCounterBlock.getPageFaults();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 341 */     this.state = OSProcess.State.RUNNING;
/* 342 */     if (paramMap != null) {
/*     */       
/* 344 */       int i = getProcessID();
/*     */       
/* 346 */       for (ThreadPerformanceData.PerfCounterBlock perfCounterBlock : paramMap.values()) {
/* 347 */         if (perfCounterBlock.getOwningProcessID() == i) {
/* 348 */           if (perfCounterBlock.getThreadWaitReason() == 5) {
/* 349 */             this.state = OSProcess.State.SUSPENDED; continue;
/*     */           } 
/* 351 */           this.state = OSProcess.State.RUNNING;
/*     */ 
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 360 */     WinNT.HANDLE hANDLE = Kernel32.INSTANCE.OpenProcess(1024, false, getProcessID());
/* 361 */     if (hANDLE != null) {
/*     */       
/*     */       try {
/* 364 */         if (IS_VISTA_OR_GREATER && this.bitness == 64) {
/* 365 */           IntByReference intByReference = new IntByReference(0);
/* 366 */           if (Kernel32.INSTANCE.IsWow64Process(hANDLE, intByReference) && intByReference.getValue() > 0) {
/* 367 */             this.bitness = 32;
/*     */           }
/*     */         } 
/*     */         
/* 371 */         WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
/*     */         try {
/* 373 */           if (IS_WINDOWS7_OR_GREATER) {
/* 374 */             this.path = Kernel32Util.QueryFullProcessImageName(hANDLE, 0);
/*     */           }
/* 376 */         } catch (Win32Exception win32Exception) {
/* 377 */           this.state = OSProcess.State.INVALID;
/*     */         } finally {
/* 379 */           WinNT.HANDLE hANDLE1 = hANDLEByReference.getValue();
/* 380 */           if (hANDLE1 != null) {
/* 381 */             Kernel32.INSTANCE.CloseHandle(hANDLE1);
/*     */           }
/*     */         } 
/*     */       } finally {
/* 385 */         Kernel32.INSTANCE.CloseHandle(hANDLE);
/*     */       } 
/*     */     }
/*     */     
/* 389 */     return !this.state.equals(OSProcess.State.INVALID);
/*     */   }
/*     */ 
/*     */   
/*     */   private String queryCommandLine() {
/* 394 */     if (!((String)((Triplet)this.cwdCmdEnv.get()).getB()).isEmpty()) {
/* 395 */       return (String)((Triplet)this.cwdCmdEnv.get()).getB();
/*     */     }
/*     */     
/* 398 */     if (USE_BATCH_COMMANDLINE) {
/* 399 */       return Win32ProcessCached.getInstance().getCommandLine(getProcessID(), getStartTime());
/*     */     }
/*     */ 
/*     */     
/* 403 */     WbemcliUtil.WmiResult wmiResult = Win32Process.queryCommandLines(Collections.singleton(Integer.valueOf(getProcessID())));
/* 404 */     if (wmiResult.getResultCount() > 0) {
/* 405 */       return WmiUtil.getString(wmiResult, (Enum)Win32Process.CommandLineProperty.COMMANDLINE, 0);
/*     */     }
/* 407 */     return "";
/*     */   }
/*     */   
/*     */   private List<String> queryArguments() {
/* 411 */     String str = getCommandLine();
/* 412 */     if (!str.isEmpty()) {
/* 413 */       return Arrays.asList(Shell32Util.CommandLineToArgv(str));
/*     */     }
/* 415 */     return Collections.emptyList();
/*     */   }
/*     */ 
/*     */   
/*     */   private String queryCwd() {
/* 420 */     if (!((String)((Triplet)this.cwdCmdEnv.get()).getA()).isEmpty()) {
/* 421 */       return (String)((Triplet)this.cwdCmdEnv.get()).getA();
/*     */     }
/*     */     
/* 424 */     if (getProcessID() == this.os.getProcessId()) {
/* 425 */       String str = (new File(".")).getAbsolutePath();
/*     */       
/* 427 */       if (!str.isEmpty()) {
/* 428 */         return str.substring(0, str.length() - 1);
/*     */       }
/*     */     } 
/* 431 */     return "";
/*     */   }
/*     */   
/*     */   private Pair<String, String> queryUserInfo() {
/* 435 */     Pair<String, String> pair = null;
/* 436 */     WinNT.HANDLE hANDLE = Kernel32.INSTANCE.OpenProcess(1024, false, getProcessID());
/* 437 */     if (hANDLE != null) {
/* 438 */       WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
/*     */       try {
/* 440 */         if (Advapi32.INSTANCE.OpenProcessToken(hANDLE, 10, hANDLEByReference)) {
/* 441 */           Advapi32Util.Account account = Advapi32Util.getTokenAccount(hANDLEByReference.getValue());
/* 442 */           pair = new Pair(account.name, account.sidString);
/*     */         } else {
/* 444 */           int i = Kernel32.INSTANCE.GetLastError();
/*     */           
/* 446 */           if (i != 5) {
/* 447 */             LOG.error("Failed to get process token for process {}: {}", Integer.valueOf(getProcessID()), 
/* 448 */                 Integer.valueOf(Kernel32.INSTANCE.GetLastError()));
/*     */           }
/*     */         } 
/* 451 */       } catch (Win32Exception win32Exception) {
/* 452 */         LOG.warn("Failed to query user info for process {} ({}): {}", new Object[] { Integer.valueOf(getProcessID()), getName(), win32Exception
/* 453 */               .getMessage() });
/*     */       } finally {
/* 455 */         WinNT.HANDLE hANDLE1 = hANDLEByReference.getValue();
/* 456 */         if (hANDLE1 != null) {
/* 457 */           Kernel32.INSTANCE.CloseHandle(hANDLE1);
/*     */         }
/* 459 */         Kernel32.INSTANCE.CloseHandle(hANDLE);
/*     */       } 
/*     */     } 
/* 462 */     if (pair == null) {
/* 463 */       return new Pair("unknown", "unknown");
/*     */     }
/* 465 */     return pair;
/*     */   }
/*     */   
/*     */   private Pair<String, String> queryGroupInfo() {
/* 469 */     Pair<String, String> pair = null;
/* 470 */     WinNT.HANDLE hANDLE = Kernel32.INSTANCE.OpenProcess(1024, false, getProcessID());
/* 471 */     if (hANDLE != null) {
/* 472 */       WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
/* 473 */       if (Advapi32.INSTANCE.OpenProcessToken(hANDLE, 10, hANDLEByReference)) {
/* 474 */         Advapi32Util.Account account = Advapi32Util.getTokenPrimaryGroup(hANDLEByReference.getValue());
/* 475 */         pair = new Pair(account.name, account.sidString);
/*     */       } else {
/* 477 */         int i = Kernel32.INSTANCE.GetLastError();
/*     */         
/* 479 */         if (i != 5) {
/* 480 */           LOG.error("Failed to get process token for process {}: {}", Integer.valueOf(getProcessID()), 
/* 481 */               Integer.valueOf(Kernel32.INSTANCE.GetLastError()));
/*     */         }
/*     */       } 
/* 484 */       WinNT.HANDLE hANDLE1 = hANDLEByReference.getValue();
/* 485 */       if (hANDLE1 != null) {
/* 486 */         Kernel32.INSTANCE.CloseHandle(hANDLE1);
/*     */       }
/* 488 */       Kernel32.INSTANCE.CloseHandle(hANDLE);
/*     */     } 
/* 490 */     if (pair == null) {
/* 491 */       return new Pair("unknown", "unknown");
/*     */     }
/* 493 */     return pair;
/*     */   }
/*     */ 
/*     */   
/*     */   private Triplet<String, String, Map<String, String>> queryCwdCommandlineEnvironment() {
/* 498 */     WinNT.HANDLE hANDLE = Kernel32.INSTANCE.OpenProcess(1040, false, 
/* 499 */         getProcessID());
/* 500 */     if (hANDLE != null) {
/*     */       
/*     */       try {
/* 503 */         if (WindowsOperatingSystem.isX86() == WindowsOperatingSystem.isWow(hANDLE)) {
/*     */           
/* 505 */           IntByReference intByReference = new IntByReference();
/*     */ 
/*     */           
/* 508 */           NtDll.PROCESS_BASIC_INFORMATION pROCESS_BASIC_INFORMATION = new NtDll.PROCESS_BASIC_INFORMATION();
/* 509 */           int i = NtDll.INSTANCE.NtQueryInformationProcess(hANDLE, 0, pROCESS_BASIC_INFORMATION
/* 510 */               .getPointer(), pROCESS_BASIC_INFORMATION.size(), intByReference);
/* 511 */           if (i != 0) {
/* 512 */             return defaultCwdCommandlineEnvironment();
/*     */           }
/* 514 */           pROCESS_BASIC_INFORMATION.read();
/*     */ 
/*     */           
/* 517 */           NtDll.PEB pEB = new NtDll.PEB();
/* 518 */           Kernel32.INSTANCE.ReadProcessMemory(hANDLE, pROCESS_BASIC_INFORMATION.PebBaseAddress, pEB.getPointer(), pEB.size(), intByReference);
/* 519 */           if (intByReference.getValue() == 0) {
/* 520 */             return defaultCwdCommandlineEnvironment();
/*     */           }
/* 522 */           pEB.read();
/*     */ 
/*     */           
/* 525 */           NtDll.RTL_USER_PROCESS_PARAMETERS rTL_USER_PROCESS_PARAMETERS = new NtDll.RTL_USER_PROCESS_PARAMETERS();
/* 526 */           Kernel32.INSTANCE.ReadProcessMemory(hANDLE, pEB.ProcessParameters, rTL_USER_PROCESS_PARAMETERS.getPointer(), rTL_USER_PROCESS_PARAMETERS.size(), intByReference);
/* 527 */           if (intByReference.getValue() == 0) {
/* 528 */             return defaultCwdCommandlineEnvironment();
/*     */           }
/* 530 */           rTL_USER_PROCESS_PARAMETERS.read();
/*     */ 
/*     */           
/* 533 */           String str1 = readUnicodeString(hANDLE, rTL_USER_PROCESS_PARAMETERS.CurrentDirectory.DosPath);
/* 534 */           String str2 = readUnicodeString(hANDLE, rTL_USER_PROCESS_PARAMETERS.CommandLine);
/*     */ 
/*     */           
/* 537 */           int j = rTL_USER_PROCESS_PARAMETERS.EnvironmentSize.intValue();
/* 538 */           if (j > 0) {
/* 539 */             Memory memory = new Memory(j);
/* 540 */             Kernel32.INSTANCE.ReadProcessMemory(hANDLE, rTL_USER_PROCESS_PARAMETERS.Environment, (Pointer)memory, j, intByReference);
/* 541 */             if (intByReference.getValue() > 0) {
/* 542 */               char[] arrayOfChar = memory.getCharArray(0L, j / 2);
/* 543 */               Map<?, ?> map = ParseUtil.parseCharArrayToStringMap(arrayOfChar);
/*     */               
/* 545 */               map.remove("");
/* 546 */               return new Triplet(str1, str2, Collections.unmodifiableMap(map));
/*     */             } 
/*     */           } 
/* 549 */           return new Triplet(str1, str2, Collections.emptyMap());
/*     */         } 
/*     */       } finally {
/* 552 */         Kernel32.INSTANCE.CloseHandle(hANDLE);
/*     */       } 
/*     */     }
/* 555 */     return defaultCwdCommandlineEnvironment();
/*     */   }
/*     */   
/*     */   private static Triplet<String, String, Map<String, String>> defaultCwdCommandlineEnvironment() {
/* 559 */     return new Triplet("", "", Collections.emptyMap());
/*     */   }
/*     */   
/*     */   private static String readUnicodeString(WinNT.HANDLE paramHANDLE, NtDll.UNICODE_STRING paramUNICODE_STRING) {
/* 563 */     IntByReference intByReference = new IntByReference();
/* 564 */     if (paramUNICODE_STRING.Length > 0) {
/*     */       
/* 566 */       Memory memory = new Memory(paramUNICODE_STRING.Length + 2L);
/* 567 */       memory.clear();
/* 568 */       Kernel32.INSTANCE.ReadProcessMemory(paramHANDLE, paramUNICODE_STRING.Buffer, (Pointer)memory, paramUNICODE_STRING.Length, intByReference);
/* 569 */       if (intByReference.getValue() > 0) {
/* 570 */         return memory.getWideString(0L);
/*     */       }
/*     */     } 
/* 573 */     return "";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\windows\WindowsOSProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */