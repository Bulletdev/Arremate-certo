/*     */ package oshi.software.os.unix.freebsd;
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
/*     */ public class FreeBsdOSThread
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
/*     */   public FreeBsdOSThread(int paramInt, Map<FreeBsdOSProcess.PsThreadColumns, String> paramMap) {
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
/*     */   
/*     */   public boolean updateAttributes() {
/* 131 */     List list = ExecutingCommand.runNative("ps -awwxo " + FreeBsdOSProcess.PS_THREAD_COLUMNS + " -H -p " + getOwningProcessId());
/*     */     
/* 133 */     String str = Integer.toString(this.threadId);
/* 134 */     for (String str1 : list) {
/* 135 */       Map<FreeBsdOSProcess.PsThreadColumns, String> map = ParseUtil.stringToEnumMap(FreeBsdOSProcess.PsThreadColumns.class, str1.trim(), ' ');
/*     */       
/* 137 */       if (map.containsKey(FreeBsdOSProcess.PsThreadColumns.PRI) && str.equals(map.get(FreeBsdOSProcess.PsThreadColumns.LWP))) {
/* 138 */         return updateAttributes(map);
/*     */       }
/*     */     } 
/* 141 */     this.state = OSProcess.State.INVALID;
/* 142 */     return false;
/*     */   }
/*     */   
/*     */   private boolean updateAttributes(Map<FreeBsdOSProcess.PsThreadColumns, String> paramMap) {
/* 146 */     this.name = paramMap.get(FreeBsdOSProcess.PsThreadColumns.TDNAME);
/* 147 */     this.threadId = ParseUtil.parseIntOrDefault(paramMap.get(FreeBsdOSProcess.PsThreadColumns.LWP), 0);
/* 148 */     switch (((String)paramMap.get(FreeBsdOSProcess.PsThreadColumns.STATE)).charAt(0)) {
/*     */       case 'R':
/* 150 */         this.state = OSProcess.State.RUNNING;
/*     */         break;
/*     */       case 'I':
/*     */       case 'S':
/* 154 */         this.state = OSProcess.State.SLEEPING;
/*     */         break;
/*     */       case 'D':
/*     */       case 'L':
/*     */       case 'U':
/* 159 */         this.state = OSProcess.State.WAITING;
/*     */         break;
/*     */       case 'Z':
/* 162 */         this.state = OSProcess.State.ZOMBIE;
/*     */         break;
/*     */       case 'T':
/* 165 */         this.state = OSProcess.State.STOPPED;
/*     */         break;
/*     */       default:
/* 168 */         this.state = OSProcess.State.OTHER;
/*     */         break;
/*     */     } 
/* 171 */     long l1 = ParseUtil.parseDHMSOrDefault(paramMap.get(FreeBsdOSProcess.PsThreadColumns.ETIMES), 0L);
/*     */     
/* 173 */     this.upTime = (l1 < 1L) ? 1L : l1;
/* 174 */     long l2 = System.currentTimeMillis();
/* 175 */     this.startTime = l2 - this.upTime;
/* 176 */     this.kernelTime = ParseUtil.parseDHMSOrDefault(paramMap.get(FreeBsdOSProcess.PsThreadColumns.SYSTIME), 0L);
/* 177 */     this.userTime = ParseUtil.parseDHMSOrDefault(paramMap.get(FreeBsdOSProcess.PsThreadColumns.TIME), 0L) - this.kernelTime;
/* 178 */     this.startMemoryAddress = ParseUtil.hexStringToLong(paramMap.get(FreeBsdOSProcess.PsThreadColumns.TDADDR), 0L);
/* 179 */     long l3 = ParseUtil.parseLongOrDefault(paramMap.get(FreeBsdOSProcess.PsThreadColumns.NIVCSW), 0L);
/* 180 */     long l4 = ParseUtil.parseLongOrDefault(paramMap.get(FreeBsdOSProcess.PsThreadColumns.NVCSW), 0L);
/* 181 */     this.contextSwitches = l4 + l3;
/* 182 */     this.majorFaults = ParseUtil.parseLongOrDefault(paramMap.get(FreeBsdOSProcess.PsThreadColumns.MAJFLT), 0L);
/* 183 */     this.minorFaults = ParseUtil.parseLongOrDefault(paramMap.get(FreeBsdOSProcess.PsThreadColumns.MINFLT), 0L);
/* 184 */     this.priority = ParseUtil.parseIntOrDefault(paramMap.get(FreeBsdOSProcess.PsThreadColumns.PRI), 0);
/* 185 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\freebsd\FreeBsdOSThread.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */