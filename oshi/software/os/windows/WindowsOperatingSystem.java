/*     */ package oshi.software.os.windows;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.platform.win32.Advapi32;
/*     */ import com.sun.jna.platform.win32.Advapi32Util;
/*     */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*     */ import com.sun.jna.platform.win32.Kernel32;
/*     */ import com.sun.jna.platform.win32.Psapi;
/*     */ import com.sun.jna.platform.win32.Tlhelp32;
/*     */ import com.sun.jna.platform.win32.VersionHelpers;
/*     */ import com.sun.jna.platform.win32.W32ServiceManager;
/*     */ import com.sun.jna.platform.win32.Win32Exception;
/*     */ import com.sun.jna.platform.win32.WinBase;
/*     */ import com.sun.jna.platform.win32.WinDef;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import com.sun.jna.platform.win32.Winsvc;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.function.Supplier;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.windows.EnumWindows;
/*     */ import oshi.driver.windows.registry.HkeyUserData;
/*     */ import oshi.driver.windows.registry.NetSessionData;
/*     */ import oshi.driver.windows.registry.ProcessPerformanceData;
/*     */ import oshi.driver.windows.registry.ProcessWtsData;
/*     */ import oshi.driver.windows.registry.SessionWtsData;
/*     */ import oshi.driver.windows.registry.ThreadPerformanceData;
/*     */ import oshi.driver.windows.wmi.Win32OperatingSystem;
/*     */ import oshi.driver.windows.wmi.Win32Processor;
/*     */ import oshi.jna.platform.windows.WinNT;
/*     */ import oshi.software.common.AbstractOperatingSystem;
/*     */ import oshi.software.os.FileSystem;
/*     */ import oshi.software.os.InternetProtocolStats;
/*     */ import oshi.software.os.NetworkParams;
/*     */ import oshi.software.os.OSDesktopWindow;
/*     */ import oshi.software.os.OSProcess;
/*     */ import oshi.software.os.OSService;
/*     */ import oshi.software.os.OSSession;
/*     */ import oshi.software.os.OperatingSystem;
/*     */ import oshi.util.GlobalConfig;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.platform.windows.WmiUtil;
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
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public class WindowsOperatingSystem
/*     */   extends AbstractOperatingSystem
/*     */ {
/* 103 */   private static final Logger LOG = LoggerFactory.getLogger(WindowsOperatingSystem.class);
/*     */   
/*     */   public static final String OSHI_OS_WINDOWS_PROCSTATE_SUSPENDED = "oshi.os.windows.procstate.suspended";
/* 106 */   private static final boolean USE_PROCSTATE_SUSPENDED = GlobalConfig.get("oshi.os.windows.procstate.suspended", false);
/*     */   
/* 108 */   private static final boolean IS_VISTA_OR_GREATER = VersionHelpers.IsWindowsVistaOrGreater();
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int TOKENELEVATION = 20;
/*     */ 
/*     */   
/* 115 */   private static Supplier<String> systemLog = Memoizer.memoize(WindowsOperatingSystem::querySystemLog, TimeUnit.HOURS
/* 116 */       .toNanos(1L));
/*     */   
/* 118 */   private static final long BOOTTIME = querySystemBootTime();
/*     */   
/*     */   static {
/* 121 */     enableDebugPrivilege();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 127 */   private static final boolean X86 = isCurrentX86();
/* 128 */   private static final boolean WOW = isCurrentWow();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 134 */   private Supplier<Map<Integer, ProcessPerformanceData.PerfCounterBlock>> processMapFromRegistry = Memoizer.memoize(WindowsOperatingSystem::queryProcessMapFromRegistry, 
/* 135 */       Memoizer.defaultExpiration());
/* 136 */   private Supplier<Map<Integer, ProcessPerformanceData.PerfCounterBlock>> processMapFromPerfCounters = Memoizer.memoize(WindowsOperatingSystem::queryProcessMapFromPerfCounters, 
/* 137 */       Memoizer.defaultExpiration());
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 142 */   private Supplier<Map<Integer, ThreadPerformanceData.PerfCounterBlock>> threadMapFromRegistry = Memoizer.memoize(WindowsOperatingSystem::queryThreadMapFromRegistry, 
/* 143 */       Memoizer.defaultExpiration());
/* 144 */   private Supplier<Map<Integer, ThreadPerformanceData.PerfCounterBlock>> threadMapFromPerfCounters = Memoizer.memoize(WindowsOperatingSystem::queryThreadMapFromPerfCounters, 
/* 145 */       Memoizer.defaultExpiration());
/*     */ 
/*     */   
/*     */   public String queryManufacturer() {
/* 149 */     return "Microsoft";
/*     */   }
/*     */ 
/*     */   
/*     */   public Pair<String, OperatingSystem.OSVersionInfo> queryFamilyVersionInfo() {
/* 154 */     String str1 = System.getProperty("os.name");
/* 155 */     if (str1.startsWith("Windows ")) {
/* 156 */       str1 = str1.substring(8);
/*     */     }
/*     */     
/* 159 */     String str2 = null;
/* 160 */     int i = 0;
/* 161 */     String str3 = null;
/* 162 */     WbemcliUtil.WmiResult wmiResult = Win32OperatingSystem.queryOsVersion();
/* 163 */     if (wmiResult.getResultCount() > 0) {
/* 164 */       str2 = WmiUtil.getString(wmiResult, (Enum)Win32OperatingSystem.OSVersionProperty.CSDVERSION, 0);
/* 165 */       if (!str2.isEmpty() && !"unknown".equals(str2)) {
/* 166 */         str1 = str1 + " " + str2.replace("Service Pack ", "SP");
/*     */       }
/* 168 */       i = WmiUtil.getUint32(wmiResult, (Enum)Win32OperatingSystem.OSVersionProperty.SUITEMASK, 0);
/* 169 */       str3 = WmiUtil.getString(wmiResult, (Enum)Win32OperatingSystem.OSVersionProperty.BUILDNUMBER, 0);
/*     */     } 
/* 171 */     String str4 = parseCodeName(i);
/* 172 */     return new Pair("Windows", new OperatingSystem.OSVersionInfo(str1, str4, str3));
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
/*     */   private static String parseCodeName(int paramInt) {
/* 184 */     ArrayList<String> arrayList = new ArrayList();
/* 185 */     if ((paramInt & 0x2) != 0) {
/* 186 */       arrayList.add("Enterprise");
/*     */     }
/* 188 */     if ((paramInt & 0x4) != 0) {
/* 189 */       arrayList.add("BackOffice");
/*     */     }
/* 191 */     if ((paramInt & 0x8) != 0) {
/* 192 */       arrayList.add("Communications Server");
/*     */     }
/* 194 */     if ((paramInt & 0x80) != 0) {
/* 195 */       arrayList.add("Datacenter");
/*     */     }
/* 197 */     if ((paramInt & 0x200) != 0) {
/* 198 */       arrayList.add("Home");
/*     */     }
/* 200 */     if ((paramInt & 0x400) != 0) {
/* 201 */       arrayList.add("Web Server");
/*     */     }
/* 203 */     if ((paramInt & 0x2000) != 0) {
/* 204 */       arrayList.add("Storage Server");
/*     */     }
/* 206 */     if ((paramInt & 0x4000) != 0) {
/* 207 */       arrayList.add("Compute Cluster");
/*     */     }
/* 209 */     if ((paramInt & 0x8000) != 0) {
/* 210 */       arrayList.add("Home Server");
/*     */     }
/* 212 */     return String.join(",", (Iterable)arrayList);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int queryBitness(int paramInt) {
/* 217 */     if (paramInt < 64 && System.getenv("ProgramFiles(x86)") != null && IS_VISTA_OR_GREATER) {
/* 218 */       WbemcliUtil.WmiResult wmiResult = Win32Processor.queryBitness();
/* 219 */       if (wmiResult.getResultCount() > 0) {
/* 220 */         return WmiUtil.getUint16(wmiResult, (Enum)Win32Processor.BitnessProperty.ADDRESSWIDTH, 0);
/*     */       }
/*     */     } 
/* 223 */     return paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isElevated() {
/* 228 */     WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
/* 229 */     boolean bool = Advapi32.INSTANCE.OpenProcessToken(Kernel32.INSTANCE.GetCurrentProcess(), 8, hANDLEByReference);
/*     */     
/* 231 */     if (!bool) {
/* 232 */       LOG.error("OpenProcessToken failed. Error: {}", Integer.valueOf(Native.getLastError()));
/* 233 */       return false;
/*     */     } 
/*     */     try {
/* 236 */       WinNT.TOKEN_ELEVATION tOKEN_ELEVATION = new WinNT.TOKEN_ELEVATION();
/* 237 */       if (Advapi32.INSTANCE.GetTokenInformation(hANDLEByReference.getValue(), 20, (Structure)tOKEN_ELEVATION, tOKEN_ELEVATION.size(), new IntByReference()))
/*     */       {
/* 239 */         return (tOKEN_ELEVATION.TokenIsElevated > 0);
/*     */       }
/*     */     } finally {
/* 242 */       Kernel32.INSTANCE.CloseHandle(hANDLEByReference.getValue());
/*     */     } 
/* 244 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public FileSystem getFileSystem() {
/* 249 */     return (FileSystem)new WindowsFileSystem();
/*     */   }
/*     */ 
/*     */   
/*     */   public InternetProtocolStats getInternetProtocolStats() {
/* 254 */     return (InternetProtocolStats)new WindowsInternetProtocolStats();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSSession> getSessions() {
/* 259 */     List<OSSession> list = HkeyUserData.queryUserSessions();
/* 260 */     list.addAll(SessionWtsData.queryUserSessions());
/* 261 */     list.addAll(NetSessionData.queryUserSessions());
/* 262 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSProcess> getProcesses(Collection<Integer> paramCollection) {
/* 267 */     return processMapToList(paramCollection);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSProcess> queryAllProcesses() {
/* 272 */     return processMapToList(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSProcess> queryChildProcesses(int paramInt) {
/* 277 */     Set<Integer> set = getChildrenOrDescendants(getParentPidsFromSnapshot(), paramInt, false);
/* 278 */     return processMapToList(set);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSProcess> queryDescendantProcesses(int paramInt) {
/* 283 */     Set<Integer> set = getChildrenOrDescendants(getParentPidsFromSnapshot(), paramInt, true);
/* 284 */     return processMapToList(set);
/*     */   }
/*     */   
/*     */   private static Map<Integer, Integer> getParentPidsFromSnapshot() {
/* 288 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/* 290 */     Tlhelp32.PROCESSENTRY32.ByReference byReference = new Tlhelp32.PROCESSENTRY32.ByReference();
/* 291 */     WinNT.HANDLE hANDLE = Kernel32.INSTANCE.CreateToolhelp32Snapshot(Tlhelp32.TH32CS_SNAPPROCESS, new WinDef.DWORD(0L));
/*     */     try {
/* 293 */       while (Kernel32.INSTANCE.Process32Next(hANDLE, (Tlhelp32.PROCESSENTRY32)byReference)) {
/* 294 */         hashMap.put(Integer.valueOf(byReference.th32ProcessID.intValue()), Integer.valueOf(byReference.th32ParentProcessID.intValue()));
/*     */       }
/*     */     } finally {
/* 297 */       Kernel32.INSTANCE.CloseHandle(hANDLE);
/*     */     } 
/* 299 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */   
/*     */   public OSProcess getProcess(int paramInt) {
/* 304 */     List<OSProcess> list = processMapToList(Arrays.asList(new Integer[] { Integer.valueOf(paramInt) }));
/* 305 */     return list.isEmpty() ? null : list.get(0);
/*     */   }
/*     */ 
/*     */   
/*     */   private List<OSProcess> processMapToList(Collection<Integer> paramCollection) {
/* 310 */     Map<Integer, ProcessPerformanceData.PerfCounterBlock> map = this.processMapFromRegistry.get();
/*     */     
/* 312 */     if (map == null || map.isEmpty())
/*     */     {
/* 314 */       map = (paramCollection == null) ? this.processMapFromPerfCounters.get() : ProcessPerformanceData.buildProcessMapFromPerfCounters(paramCollection);
/*     */     }
/* 316 */     Map<Integer, ThreadPerformanceData.PerfCounterBlock> map1 = null;
/* 317 */     if (USE_PROCSTATE_SUSPENDED) {
/*     */       
/* 319 */       map1 = this.threadMapFromRegistry.get();
/*     */       
/* 321 */       if (map1 == null || map1.isEmpty())
/*     */       {
/* 323 */         map1 = (paramCollection == null) ? this.threadMapFromPerfCounters.get() : ThreadPerformanceData.buildThreadMapFromPerfCounters(paramCollection);
/*     */       }
/*     */     } 
/*     */     
/* 327 */     Map<Integer, ProcessWtsData.WtsInfo> map2 = ProcessWtsData.queryProcessWtsMap(paramCollection);
/*     */     
/* 329 */     HashSet hashSet = new HashSet(map2.keySet());
/* 330 */     hashSet.retainAll(map.keySet());
/*     */     
/* 332 */     ArrayList<WindowsOSProcess> arrayList = new ArrayList();
/* 333 */     for (Integer integer : hashSet) {
/* 334 */       arrayList.add(new WindowsOSProcess(integer.intValue(), this, map, map2, map1));
/*     */     }
/* 336 */     return (List)arrayList;
/*     */   }
/*     */   
/*     */   private static Map<Integer, ProcessPerformanceData.PerfCounterBlock> queryProcessMapFromRegistry() {
/* 340 */     return ProcessPerformanceData.buildProcessMapFromRegistry(null);
/*     */   }
/*     */   
/*     */   private static Map<Integer, ProcessPerformanceData.PerfCounterBlock> queryProcessMapFromPerfCounters() {
/* 344 */     return ProcessPerformanceData.buildProcessMapFromPerfCounters(null);
/*     */   }
/*     */   
/*     */   private static Map<Integer, ThreadPerformanceData.PerfCounterBlock> queryThreadMapFromRegistry() {
/* 348 */     return ThreadPerformanceData.buildThreadMapFromRegistry(null);
/*     */   }
/*     */   
/*     */   private static Map<Integer, ThreadPerformanceData.PerfCounterBlock> queryThreadMapFromPerfCounters() {
/* 352 */     return ThreadPerformanceData.buildThreadMapFromPerfCounters(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getProcessId() {
/* 357 */     return Kernel32.INSTANCE.GetCurrentProcessId();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getProcessCount() {
/* 362 */     Psapi.PERFORMANCE_INFORMATION pERFORMANCE_INFORMATION = new Psapi.PERFORMANCE_INFORMATION();
/* 363 */     if (!Psapi.INSTANCE.GetPerformanceInfo(pERFORMANCE_INFORMATION, pERFORMANCE_INFORMATION.size())) {
/* 364 */       LOG.error("Failed to get Performance Info. Error code: {}", Integer.valueOf(Kernel32.INSTANCE.GetLastError()));
/* 365 */       return 0;
/*     */     } 
/* 367 */     return pERFORMANCE_INFORMATION.ProcessCount.intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getThreadCount() {
/* 372 */     Psapi.PERFORMANCE_INFORMATION pERFORMANCE_INFORMATION = new Psapi.PERFORMANCE_INFORMATION();
/* 373 */     if (!Psapi.INSTANCE.GetPerformanceInfo(pERFORMANCE_INFORMATION, pERFORMANCE_INFORMATION.size())) {
/* 374 */       LOG.error("Failed to get Performance Info. Error code: {}", Integer.valueOf(Kernel32.INSTANCE.GetLastError()));
/* 375 */       return 0;
/*     */     } 
/* 377 */     return pERFORMANCE_INFORMATION.ThreadCount.intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSystemUptime() {
/* 382 */     return querySystemUptime();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static long querySystemUptime() {
/* 388 */     if (IS_VISTA_OR_GREATER) {
/* 389 */       return Kernel32.INSTANCE.GetTickCount64() / 1000L;
/*     */     }
/*     */     
/* 392 */     return Kernel32.INSTANCE.GetTickCount() / 1000L;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public long getSystemBootTime() {
/* 398 */     return BOOTTIME;
/*     */   }
/*     */   
/*     */   private static long querySystemBootTime() {
/* 402 */     String str = systemLog.get();
/* 403 */     if (str != null) {
/*     */       try {
/* 405 */         Advapi32Util.EventLogIterator eventLogIterator = new Advapi32Util.EventLogIterator(null, str, 8);
/*     */ 
/*     */ 
/*     */         
/* 409 */         long l = 0L;
/* 410 */         while (eventLogIterator.hasNext()) {
/* 411 */           Advapi32Util.EventLogRecord eventLogRecord = eventLogIterator.next();
/* 412 */           if (eventLogRecord.getStatusCode() == 12)
/*     */           {
/*     */             
/* 415 */             return (eventLogRecord.getRecord()).TimeGenerated.longValue(); } 
/* 416 */           if (eventLogRecord.getStatusCode() == 6005) {
/*     */ 
/*     */             
/* 419 */             if (l > 0L) {
/* 420 */               return l;
/*     */             }
/*     */             
/* 423 */             l = (eventLogRecord.getRecord()).TimeGenerated.longValue();
/*     */           } 
/*     */         } 
/*     */         
/* 427 */         if (l > 0L) {
/* 428 */           return l;
/*     */         }
/* 430 */       } catch (Win32Exception win32Exception) {
/* 431 */         LOG.warn("Can't open event log \"{}\".", str);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 436 */     return System.currentTimeMillis() / 1000L - querySystemUptime();
/*     */   }
/*     */ 
/*     */   
/*     */   public NetworkParams getNetworkParams() {
/* 441 */     return (NetworkParams)new WindowsNetworkParams();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean enableDebugPrivilege() {
/* 452 */     WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
/* 453 */     boolean bool = Advapi32.INSTANCE.OpenProcessToken(Kernel32.INSTANCE.GetCurrentProcess(), 40, hANDLEByReference);
/*     */     
/* 455 */     if (!bool) {
/* 456 */       LOG.error("OpenProcessToken failed. Error: {}", Integer.valueOf(Native.getLastError()));
/* 457 */       return false;
/*     */     } 
/*     */     try {
/* 460 */       WinNT.LUID lUID = new WinNT.LUID();
/* 461 */       bool = Advapi32.INSTANCE.LookupPrivilegeValue(null, "SeDebugPrivilege", lUID);
/* 462 */       if (!bool) {
/* 463 */         LOG.error("LookupPrivilegeValue failed. Error: {}", Integer.valueOf(Native.getLastError()));
/* 464 */         return false;
/*     */       } 
/* 466 */       WinNT.TOKEN_PRIVILEGES tOKEN_PRIVILEGES = new WinNT.TOKEN_PRIVILEGES(1);
/* 467 */       tOKEN_PRIVILEGES.Privileges[0] = new WinNT.LUID_AND_ATTRIBUTES(lUID, new WinDef.DWORD(2L));
/* 468 */       bool = Advapi32.INSTANCE.AdjustTokenPrivileges(hANDLEByReference.getValue(), false, tOKEN_PRIVILEGES, 0, null, null);
/* 469 */       int i = Native.getLastError();
/* 470 */       if (!bool) {
/* 471 */         LOG.error("AdjustTokenPrivileges failed. Error: {}", Integer.valueOf(i));
/* 472 */         return false;
/* 473 */       }  if (i == 1300) {
/* 474 */         LOG.debug("Debug privileges not enabled.");
/* 475 */         return false;
/*     */       } 
/*     */     } finally {
/* 478 */       Kernel32.INSTANCE.CloseHandle(hANDLEByReference.getValue());
/*     */     } 
/* 480 */     return true;
/*     */   }
/*     */   
/*     */   public OSService[] getServices() {
/*     */     
/* 485 */     try { W32ServiceManager w32ServiceManager = new W32ServiceManager(); 
/* 486 */       try { w32ServiceManager.open(4);
/* 487 */         Winsvc.ENUM_SERVICE_STATUS_PROCESS[] arrayOfENUM_SERVICE_STATUS_PROCESS = w32ServiceManager.enumServicesStatusExProcess(48, 3, null);
/*     */         
/* 489 */         OSService[] arrayOfOSService1 = new OSService[arrayOfENUM_SERVICE_STATUS_PROCESS.length];
/* 490 */         for (byte b = 0; b < arrayOfENUM_SERVICE_STATUS_PROCESS.length; b++) {
/*     */           OSService.State state;
/* 492 */           switch ((arrayOfENUM_SERVICE_STATUS_PROCESS[b]).ServiceStatusProcess.dwCurrentState) {
/*     */             case 1:
/* 494 */               state = OSService.State.STOPPED;
/*     */               break;
/*     */             case 4:
/* 497 */               state = OSService.State.RUNNING;
/*     */               break;
/*     */             default:
/* 500 */               state = OSService.State.OTHER;
/*     */               break;
/*     */           } 
/* 503 */           arrayOfOSService1[b] = new OSService((arrayOfENUM_SERVICE_STATUS_PROCESS[b]).lpDisplayName, (arrayOfENUM_SERVICE_STATUS_PROCESS[b]).ServiceStatusProcess.dwProcessId, state);
/*     */         } 
/*     */         
/* 506 */         OSService[] arrayOfOSService2 = arrayOfOSService1;
/* 507 */         w32ServiceManager.close(); return arrayOfOSService2; } catch (Throwable throwable) { try { w32ServiceManager.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  throw throwable; }  } catch (Win32Exception win32Exception)
/* 508 */     { LOG.error("Win32Exception: {}", win32Exception.getMessage());
/* 509 */       return new OSService[0]; }
/*     */   
/*     */   }
/*     */   
/*     */   private static String querySystemLog() {
/* 514 */     String str = GlobalConfig.get("oshi.os.windows.eventlog", "System");
/* 515 */     if (str.isEmpty())
/*     */     {
/* 517 */       return null;
/*     */     }
/*     */     
/* 520 */     WinNT.HANDLE hANDLE = Advapi32.INSTANCE.OpenEventLog(null, str);
/* 521 */     if (hANDLE == null) {
/* 522 */       LOG.warn("Unable to open configured system Event log \"{}\". Calculating boot time from uptime.", str);
/*     */       
/* 524 */       return null;
/*     */     } 
/* 526 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSDesktopWindow> getDesktopWindows(boolean paramBoolean) {
/* 531 */     return EnumWindows.queryDesktopWindows(paramBoolean);
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
/*     */   static boolean isX86() {
/* 544 */     return X86;
/*     */   }
/*     */   
/*     */   private static boolean isCurrentX86() {
/* 548 */     WinBase.SYSTEM_INFO sYSTEM_INFO = new WinBase.SYSTEM_INFO();
/* 549 */     Kernel32.INSTANCE.GetNativeSystemInfo(sYSTEM_INFO);
/* 550 */     return (0 == sYSTEM_INFO.processorArchitecture.pi.wProcessorArchitecture.intValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isWow() {
/* 559 */     return WOW;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isWow(WinNT.HANDLE paramHANDLE) {
/* 570 */     if (X86) {
/* 571 */       return true;
/*     */     }
/* 573 */     IntByReference intByReference = new IntByReference();
/* 574 */     Kernel32.INSTANCE.IsWow64Process(paramHANDLE, intByReference);
/* 575 */     return (intByReference.getValue() != 0);
/*     */   }
/*     */   
/*     */   private static boolean isCurrentWow() {
/* 579 */     if (X86) {
/* 580 */       return true;
/*     */     }
/* 582 */     WinNT.HANDLE hANDLE = Kernel32.INSTANCE.GetCurrentProcess();
/* 583 */     if (hANDLE != null) {
/*     */       try {
/* 585 */         return isWow(hANDLE);
/*     */       } finally {
/* 587 */         Kernel32.INSTANCE.CloseHandle(hANDLE);
/*     */       } 
/*     */     }
/* 590 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\windows\WindowsOperatingSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */