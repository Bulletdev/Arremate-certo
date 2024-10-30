/*     */ package oshi.software.os.unix.openbsd;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.software.common.AbstractOSThread;
/*     */ import oshi.software.os.OSProcess;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.ParseUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class OpenBsdOSThread
/*     */   extends AbstractOSThread
/*     */ {
/*     */   private int threadId;
/*  51 */   private String name = "";
/*  52 */   private OSProcess.State state = OSProcess.State.INVALID;
/*     */   private long minorFaults;
/*     */   private long majorFaults;
/*     */   private long startMemoryAddress;
/*     */   private long contextSwitches;
/*     */   private long kernelTime;
/*     */   private long userTime;
/*     */   private long startTime;
/*     */   private long upTime;
/*     */   private int priority;
/*     */   
/*     */   public OpenBsdOSThread(int paramInt, Map<OpenBsdOSProcess.PsThreadColumns, String> paramMap) {
/*  64 */     super(paramInt);
/*  65 */     updateAttributes(paramMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getThreadId() {
/*  70 */     return this.threadId;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/*  75 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public OSProcess.State getState() {
/*  80 */     return this.state;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getStartMemoryAddress() {
/*  85 */     return this.startMemoryAddress;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContextSwitches() {
/*  90 */     return this.contextSwitches;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMinorFaults() {
/*  95 */     return this.minorFaults;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMajorFaults() {
/* 100 */     return this.majorFaults;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getKernelTime() {
/* 105 */     return this.kernelTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUserTime() {
/* 110 */     return this.userTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUpTime() {
/* 115 */     return this.upTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getStartTime() {
/* 120 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPriority() {
/* 125 */     return this.priority;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 130 */     String str1 = "ps -aHwwxo " + OpenBsdOSProcess.PS_THREAD_COLUMNS + " -p " + getOwningProcessId();
/*     */     
/* 132 */     List list = ExecutingCommand.runNative(str1);
/* 133 */     String str2 = Integer.toString(this.threadId);
/* 134 */     for (String str : list) {
/* 135 */       Map<OpenBsdOSProcess.PsThreadColumns, String> map = ParseUtil.stringToEnumMap(OpenBsdOSProcess.PsThreadColumns.class, str.trim(), ' ');
/*     */       
/* 137 */       if (map.containsKey(OpenBsdOSProcess.PsThreadColumns.ARGS) && str2.equals(map.get(OpenBsdOSProcess.PsThreadColumns.TID))) {
/* 138 */         return updateAttributes(map);
/*     */       }
/*     */     } 
/* 141 */     this.state = OSProcess.State.INVALID;
/* 142 */     return false;
/*     */   }
/*     */   
/*     */   private boolean updateAttributes(Map<OpenBsdOSProcess.PsThreadColumns, String> paramMap) {
/* 146 */     this.threadId = ParseUtil.parseIntOrDefault(paramMap.get(OpenBsdOSProcess.PsThreadColumns.TID), 0);
/* 147 */     switch (((String)paramMap.get(OpenBsdOSProcess.PsThreadColumns.STATE)).charAt(0)) {
/*     */       case 'R':
/* 149 */         this.state = OSProcess.State.RUNNING;
/*     */         break;
/*     */       case 'I':
/*     */       case 'S':
/* 153 */         this.state = OSProcess.State.SLEEPING;
/*     */         break;
/*     */       case 'D':
/*     */       case 'L':
/*     */       case 'U':
/* 158 */         this.state = OSProcess.State.WAITING;
/*     */         break;
/*     */       case 'Z':
/* 161 */         this.state = OSProcess.State.ZOMBIE;
/*     */         break;
/*     */       case 'T':
/* 164 */         this.state = OSProcess.State.STOPPED;
/*     */         break;
/*     */       default:
/* 167 */         this.state = OSProcess.State.OTHER;
/*     */         break;
/*     */     } 
/*     */     
/* 171 */     long l1 = ParseUtil.parseDHMSOrDefault(paramMap.get(OpenBsdOSProcess.PsThreadColumns.ETIME), 0L);
/* 172 */     this.upTime = (l1 < 1L) ? 1L : l1;
/* 173 */     long l2 = System.currentTimeMillis();
/* 174 */     this.startTime = l2 - this.upTime;
/*     */     
/* 176 */     this.kernelTime = 0L;
/* 177 */     this.userTime = ParseUtil.parseDHMSOrDefault(paramMap.get(OpenBsdOSProcess.PsThreadColumns.CPUTIME), 0L);
/* 178 */     this.startMemoryAddress = 0L;
/* 179 */     long l3 = ParseUtil.parseLongOrDefault(paramMap.get(OpenBsdOSProcess.PsThreadColumns.NIVCSW), 0L);
/* 180 */     long l4 = ParseUtil.parseLongOrDefault(paramMap.get(OpenBsdOSProcess.PsThreadColumns.NVCSW), 0L);
/* 181 */     this.contextSwitches = l4 + l3;
/* 182 */     this.majorFaults = ParseUtil.parseLongOrDefault(paramMap.get(OpenBsdOSProcess.PsThreadColumns.MAJFLT), 0L);
/* 183 */     this.minorFaults = ParseUtil.parseLongOrDefault(paramMap.get(OpenBsdOSProcess.PsThreadColumns.MINFLT), 0L);
/* 184 */     this.priority = ParseUtil.parseIntOrDefault(paramMap.get(OpenBsdOSProcess.PsThreadColumns.PRI), 0);
/* 185 */     this.name = paramMap.get(OpenBsdOSProcess.PsThreadColumns.ARGS);
/* 186 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\openbsd\OpenBsdOSThread.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */