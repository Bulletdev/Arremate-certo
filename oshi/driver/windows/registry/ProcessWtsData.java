/*     */ package oshi.driver.windows.registry;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*     */ import com.sun.jna.platform.win32.Kernel32;
/*     */ import com.sun.jna.platform.win32.VersionHelpers;
/*     */ import com.sun.jna.platform.win32.Wtsapi32;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import com.sun.jna.ptr.PointerByReference;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.windows.wmi.Win32Process;
/*     */ import oshi.util.platform.windows.WmiUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class ProcessWtsData
/*     */ {
/*  55 */   private static final Logger LOG = LoggerFactory.getLogger(ProcessWtsData.class);
/*     */   
/*  57 */   private static final boolean IS_WINDOWS7_OR_GREATER = VersionHelpers.IsWindows7OrGreater();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Map<Integer, WtsInfo> queryProcessWtsMap(Collection<Integer> paramCollection) {
/*  72 */     if (IS_WINDOWS7_OR_GREATER)
/*     */     {
/*  74 */       return queryProcessWtsMapFromWTS(paramCollection);
/*     */     }
/*     */ 
/*     */     
/*  78 */     return queryProcessWtsMapFromPerfMon(paramCollection);
/*     */   }
/*     */   
/*     */   private static Map<Integer, WtsInfo> queryProcessWtsMapFromWTS(Collection<Integer> paramCollection) {
/*  82 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  83 */     IntByReference intByReference = new IntByReference(0);
/*  84 */     PointerByReference pointerByReference = new PointerByReference();
/*  85 */     if (!Wtsapi32.INSTANCE.WTSEnumerateProcessesEx(Wtsapi32.WTS_CURRENT_SERVER_HANDLE, new IntByReference(1), -2, pointerByReference, intByReference)) {
/*     */ 
/*     */       
/*  88 */       LOG.error("Failed to enumerate Processes. Error code: {}", Integer.valueOf(Kernel32.INSTANCE.GetLastError()));
/*  89 */       return (Map)hashMap;
/*     */     } 
/*     */     
/*  92 */     Pointer pointer = pointerByReference.getValue();
/*  93 */     Wtsapi32.WTS_PROCESS_INFO_EX wTS_PROCESS_INFO_EX = new Wtsapi32.WTS_PROCESS_INFO_EX(pointer);
/*  94 */     Wtsapi32.WTS_PROCESS_INFO_EX[] arrayOfWTS_PROCESS_INFO_EX = (Wtsapi32.WTS_PROCESS_INFO_EX[])wTS_PROCESS_INFO_EX.toArray(intByReference.getValue());
/*  95 */     for (byte b = 0; b < arrayOfWTS_PROCESS_INFO_EX.length; b++) {
/*  96 */       if (paramCollection == null || paramCollection.contains(Integer.valueOf((arrayOfWTS_PROCESS_INFO_EX[b]).ProcessId))) {
/*  97 */         hashMap.put(Integer.valueOf((arrayOfWTS_PROCESS_INFO_EX[b]).ProcessId), new WtsInfo((arrayOfWTS_PROCESS_INFO_EX[b]).pProcessName, "", (arrayOfWTS_PROCESS_INFO_EX[b]).NumberOfThreads, (arrayOfWTS_PROCESS_INFO_EX[b]).PagefileUsage & 0xFFFFFFFFL, (arrayOfWTS_PROCESS_INFO_EX[b]).KernelTime
/*     */ 
/*     */               
/* 100 */               .getValue() / 10000L, (arrayOfWTS_PROCESS_INFO_EX[b]).UserTime
/* 101 */               .getValue() / 10000L, (arrayOfWTS_PROCESS_INFO_EX[b]).HandleCount));
/*     */       }
/*     */     } 
/*     */     
/* 105 */     if (!Wtsapi32.INSTANCE.WTSFreeMemoryEx(1, pointer, intByReference.getValue())) {
/* 106 */       LOG.warn("Failed to Free Memory for Processes. Error code: {}", Integer.valueOf(Kernel32.INSTANCE.GetLastError()));
/*     */     }
/* 108 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   private static Map<Integer, WtsInfo> queryProcessWtsMapFromPerfMon(Collection<Integer> paramCollection) {
/* 112 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 113 */     WbemcliUtil.WmiResult wmiResult = Win32Process.queryProcesses(paramCollection);
/* 114 */     for (byte b = 0; b < wmiResult.getResultCount(); b++) {
/* 115 */       hashMap.put(Integer.valueOf(WmiUtil.getUint32(wmiResult, (Enum)Win32Process.ProcessXPProperty.PROCESSID, b)), new WtsInfo(
/* 116 */             WmiUtil.getString(wmiResult, (Enum)Win32Process.ProcessXPProperty.NAME, b), 
/* 117 */             WmiUtil.getString(wmiResult, (Enum)Win32Process.ProcessXPProperty.EXECUTABLEPATH, b), 
/* 118 */             WmiUtil.getUint32(wmiResult, (Enum)Win32Process.ProcessXPProperty.THREADCOUNT, b), 1024L * (
/*     */             
/* 120 */             WmiUtil.getUint32(wmiResult, (Enum)Win32Process.ProcessXPProperty.PAGEFILEUSAGE, b) & 0xFFFFFFFFL), 
/* 121 */             WmiUtil.getUint64(wmiResult, (Enum)Win32Process.ProcessXPProperty.KERNELMODETIME, b) / 10000L, 
/* 122 */             WmiUtil.getUint64(wmiResult, (Enum)Win32Process.ProcessXPProperty.USERMODETIME, b) / 10000L, 
/* 123 */             WmiUtil.getUint32(wmiResult, (Enum)Win32Process.ProcessXPProperty.HANDLECOUNT, b)));
/*     */     }
/* 125 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */   
/*     */   @Immutable
/*     */   public static class WtsInfo
/*     */   {
/*     */     private final String name;
/*     */     
/*     */     private final String path;
/*     */     
/*     */     private final int threadCount;
/*     */     private final long virtualSize;
/*     */     private final long kernelTime;
/*     */     private final long userTime;
/*     */     private final long openFiles;
/*     */     
/*     */     public WtsInfo(String param1String1, String param1String2, int param1Int, long param1Long1, long param1Long2, long param1Long3, long param1Long4) {
/* 143 */       this.name = param1String1;
/* 144 */       this.path = param1String2;
/* 145 */       this.threadCount = param1Int;
/* 146 */       this.virtualSize = param1Long1;
/* 147 */       this.kernelTime = param1Long2;
/* 148 */       this.userTime = param1Long3;
/* 149 */       this.openFiles = param1Long4;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/* 156 */       return this.name;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getPath() {
/* 163 */       return this.path;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getThreadCount() {
/* 170 */       return this.threadCount;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getVirtualSize() {
/* 177 */       return this.virtualSize;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getKernelTime() {
/* 184 */       return this.kernelTime;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getUserTime() {
/* 191 */       return this.userTime;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getOpenFiles() {
/* 198 */       return this.openFiles;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\registry\ProcessWtsData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */