/*     */ package oshi.software.os.windows;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.windows.registry.ThreadPerformanceData;
/*     */ import oshi.software.common.AbstractOSThread;
/*     */ import oshi.software.os.OSProcess;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class WindowsOSThread
/*     */   extends AbstractOSThread
/*     */ {
/*     */   private final int threadId;
/*     */   private String name;
/*     */   private OSProcess.State state;
/*     */   private long startMemoryAddress;
/*     */   private long contextSwitches;
/*     */   private long kernelTime;
/*     */   private long userTime;
/*     */   private long startTime;
/*     */   private long upTime;
/*     */   private int priority;
/*     */   
/*     */   public WindowsOSThread(int paramInt1, int paramInt2, String paramString, ThreadPerformanceData.PerfCounterBlock paramPerfCounterBlock) {
/*  63 */     super(paramInt1);
/*  64 */     this.threadId = paramInt2;
/*  65 */     updateAttributes(paramString, paramPerfCounterBlock);
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
/*     */   public long getKernelTime() {
/*  95 */     return this.kernelTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUserTime() {
/* 100 */     return this.userTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getStartTime() {
/* 105 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUpTime() {
/* 110 */     return this.upTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPriority() {
/* 115 */     return this.priority;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 120 */     Set<Integer> set = Collections.singleton(Integer.valueOf(getOwningProcessId()));
/*     */ 
/*     */     
/* 123 */     Map map = ThreadPerformanceData.buildThreadMapFromRegistry(set);
/*     */     
/* 125 */     if (map == null) {
/* 126 */       map = ThreadPerformanceData.buildThreadMapFromPerfCounters(set);
/*     */     }
/* 128 */     return updateAttributes(this.name.split("/")[0], (ThreadPerformanceData.PerfCounterBlock)map.get(Integer.valueOf(getThreadId())));
/*     */   }
/*     */   
/*     */   private boolean updateAttributes(String paramString, ThreadPerformanceData.PerfCounterBlock paramPerfCounterBlock) {
/* 132 */     if (paramPerfCounterBlock == null) {
/* 133 */       this.state = OSProcess.State.INVALID;
/* 134 */       return false;
/* 135 */     }  if (paramPerfCounterBlock.getName().contains("/") || paramString.isEmpty()) {
/* 136 */       this.name = paramPerfCounterBlock.getName();
/*     */     } else {
/* 138 */       this.name = paramString + "/" + paramPerfCounterBlock.getName();
/*     */     } 
/* 140 */     if (paramPerfCounterBlock.getThreadWaitReason() == 5)
/* 141 */     { this.state = OSProcess.State.SUSPENDED; }
/*     */     else
/* 143 */     { switch (paramPerfCounterBlock.getThreadState())
/*     */       { case 0:
/* 145 */           this.state = OSProcess.State.NEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 166 */           this.startMemoryAddress = paramPerfCounterBlock.getStartAddress();
/* 167 */           this.contextSwitches = paramPerfCounterBlock.getContextSwitches();
/* 168 */           this.kernelTime = paramPerfCounterBlock.getKernelTime();
/* 169 */           this.userTime = paramPerfCounterBlock.getUserTime();
/* 170 */           this.startTime = paramPerfCounterBlock.getStartTime();
/* 171 */           this.upTime = System.currentTimeMillis() - paramPerfCounterBlock.getStartTime();
/* 172 */           this.priority = paramPerfCounterBlock.getPriority();
/* 173 */           return true;case 2: case 3: this.state = OSProcess.State.RUNNING; this.startMemoryAddress = paramPerfCounterBlock.getStartAddress(); this.contextSwitches = paramPerfCounterBlock.getContextSwitches(); this.kernelTime = paramPerfCounterBlock.getKernelTime(); this.userTime = paramPerfCounterBlock.getUserTime(); this.startTime = paramPerfCounterBlock.getStartTime(); this.upTime = System.currentTimeMillis() - paramPerfCounterBlock.getStartTime(); this.priority = paramPerfCounterBlock.getPriority(); return true;case 4: this.state = OSProcess.State.STOPPED; this.startMemoryAddress = paramPerfCounterBlock.getStartAddress(); this.contextSwitches = paramPerfCounterBlock.getContextSwitches(); this.kernelTime = paramPerfCounterBlock.getKernelTime(); this.userTime = paramPerfCounterBlock.getUserTime(); this.startTime = paramPerfCounterBlock.getStartTime(); this.upTime = System.currentTimeMillis() - paramPerfCounterBlock.getStartTime(); this.priority = paramPerfCounterBlock.getPriority(); return true;case 5: this.state = OSProcess.State.SLEEPING; this.startMemoryAddress = paramPerfCounterBlock.getStartAddress(); this.contextSwitches = paramPerfCounterBlock.getContextSwitches(); this.kernelTime = paramPerfCounterBlock.getKernelTime(); this.userTime = paramPerfCounterBlock.getUserTime(); this.startTime = paramPerfCounterBlock.getStartTime(); this.upTime = System.currentTimeMillis() - paramPerfCounterBlock.getStartTime(); this.priority = paramPerfCounterBlock.getPriority(); return true;case 1: case 6: this.state = OSProcess.State.WAITING; this.startMemoryAddress = paramPerfCounterBlock.getStartAddress(); this.contextSwitches = paramPerfCounterBlock.getContextSwitches(); this.kernelTime = paramPerfCounterBlock.getKernelTime(); this.userTime = paramPerfCounterBlock.getUserTime(); this.startTime = paramPerfCounterBlock.getStartTime(); this.upTime = System.currentTimeMillis() - paramPerfCounterBlock.getStartTime(); this.priority = paramPerfCounterBlock.getPriority(); return true; }  this.state = OSProcess.State.OTHER; }  this.startMemoryAddress = paramPerfCounterBlock.getStartAddress(); this.contextSwitches = paramPerfCounterBlock.getContextSwitches(); this.kernelTime = paramPerfCounterBlock.getKernelTime(); this.userTime = paramPerfCounterBlock.getUserTime(); this.startTime = paramPerfCounterBlock.getStartTime(); this.upTime = System.currentTimeMillis() - paramPerfCounterBlock.getStartTime(); this.priority = paramPerfCounterBlock.getPriority(); return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\windows\WindowsOSThread.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */