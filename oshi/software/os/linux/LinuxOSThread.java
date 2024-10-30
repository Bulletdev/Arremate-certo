/*     */ package oshi.software.os.linux;
/*     */ 
/*     */ import java.util.Map;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.linux.proc.ProcessStat;
/*     */ import oshi.software.common.AbstractOSThread;
/*     */ import oshi.software.os.OSProcess;
/*     */ import oshi.util.FileUtil;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.linux.ProcPath;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class LinuxOSThread
/*     */   extends AbstractOSThread
/*     */ {
/*  42 */   private static final int[] PROC_TASK_STAT_ORDERS = new int[(ThreadPidStat.values()).length];
/*     */   static {
/*  44 */     for (ThreadPidStat threadPidStat : ThreadPidStat.values())
/*     */     {
/*     */       
/*  47 */       PROC_TASK_STAT_ORDERS[threadPidStat.ordinal()] = threadPidStat.getOrder() - 1;
/*     */     }
/*     */   }
/*     */   
/*     */   private final int threadId;
/*     */   private String name;
/*  53 */   private OSProcess.State state = OSProcess.State.INVALID;
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
/*     */   public LinuxOSThread(int paramInt1, int paramInt2) {
/*  65 */     super(paramInt1);
/*  66 */     this.threadId = paramInt2;
/*  67 */     updateAttributes();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getThreadId() {
/*  72 */     return this.threadId;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/*  77 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public OSProcess.State getState() {
/*  82 */     return this.state;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getStartTime() {
/*  87 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getStartMemoryAddress() {
/*  92 */     return this.startMemoryAddress;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContextSwitches() {
/*  97 */     return this.contextSwitches;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMinorFaults() {
/* 102 */     return this.minorFaults;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getMajorFaults() {
/* 107 */     return this.majorFaults;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getKernelTime() {
/* 112 */     return this.kernelTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUserTime() {
/* 117 */     return this.userTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUpTime() {
/* 122 */     return this.upTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPriority() {
/* 127 */     return this.priority;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 132 */     this
/* 133 */       .name = FileUtil.getStringFromFile(String.format(ProcPath.TASK_COMM, new Object[] { Integer.valueOf(getOwningProcessId()), Integer.valueOf(this.threadId) }));
/* 134 */     Map map = FileUtil.getKeyValueMapFromFile(
/* 135 */         String.format(ProcPath.TASK_STATUS, new Object[] { Integer.valueOf(getOwningProcessId()), Integer.valueOf(this.threadId) }), ":");
/*     */     
/* 137 */     String str = FileUtil.getStringFromFile(String.format(ProcPath.TASK_STAT, new Object[] { Integer.valueOf(getOwningProcessId()), Integer.valueOf(this.threadId) }));
/* 138 */     if (str.isEmpty()) {
/* 139 */       this.state = OSProcess.State.INVALID;
/* 140 */       return false;
/*     */     } 
/* 142 */     long l1 = System.currentTimeMillis();
/* 143 */     long[] arrayOfLong = ParseUtil.parseStringToLongArray(str, PROC_TASK_STAT_ORDERS, ProcessStat.PROC_PID_STAT_LENGTH, ' ');
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 149 */     this
/* 150 */       .startTime = (LinuxOperatingSystem.BOOTTIME * LinuxOperatingSystem.getHz() + arrayOfLong[ThreadPidStat.START_TIME.ordinal()]) * 1000L / LinuxOperatingSystem.getHz();
/*     */ 
/*     */ 
/*     */     
/* 154 */     if (this.startTime >= l1) {
/* 155 */       this.startTime = l1 - 1L;
/*     */     }
/* 157 */     this.minorFaults = arrayOfLong[ThreadPidStat.MINOR_FAULTS.ordinal()];
/* 158 */     this.majorFaults = arrayOfLong[ThreadPidStat.MAJOR_FAULT.ordinal()];
/* 159 */     this.startMemoryAddress = arrayOfLong[ThreadPidStat.START_CODE.ordinal()];
/* 160 */     long l2 = ParseUtil.parseLongOrDefault((String)map.get("voluntary_ctxt_switches"), 0L);
/* 161 */     long l3 = ParseUtil.parseLongOrDefault((String)map.get("nonvoluntary_ctxt_switches"), 0L);
/* 162 */     this.contextSwitches = l2 + l3;
/* 163 */     this.state = ProcessStat.getState(((String)map.getOrDefault("State", "U")).charAt(0));
/* 164 */     this.kernelTime = arrayOfLong[ThreadPidStat.KERNEL_TIME.ordinal()] * 1000L / LinuxOperatingSystem.getHz();
/* 165 */     this.userTime = arrayOfLong[ThreadPidStat.USER_TIME.ordinal()] * 1000L / LinuxOperatingSystem.getHz();
/* 166 */     this.upTime = l1 - this.startTime;
/* 167 */     this.priority = (int)arrayOfLong[ThreadPidStat.PRIORITY.ordinal()];
/* 168 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private enum ThreadPidStat
/*     */   {
/* 178 */     PPID(4), MINOR_FAULTS(10), MAJOR_FAULT(12), USER_TIME(14), KERNEL_TIME(15), PRIORITY(18), THREAD_COUNT(20),
/* 179 */     START_TIME(22), VSZ(23), RSS(24), START_CODE(26);
/*     */     
/*     */     private final int order;
/*     */     
/*     */     ThreadPidStat(int param1Int1) {
/* 184 */       this.order = param1Int1;
/*     */     }
/*     */     
/*     */     public int getOrder() {
/* 188 */       return this.order;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\linux\LinuxOSThread.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */