/*     */ package oshi.software.os.unix.aix;
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
/*     */ @ThreadSafe
/*     */ public class AixOSThread
/*     */   extends AbstractOSThread
/*     */ {
/*     */   private int threadId;
/*  43 */   private OSProcess.State state = OSProcess.State.INVALID;
/*     */   private long contextSwitches;
/*     */   private long kernelTime;
/*     */   private long userTime;
/*     */   private long startTime;
/*     */   private long upTime;
/*     */   private int priority;
/*     */   
/*     */   public AixOSThread(int paramInt, Map<AixOSProcess.PsThreadColumns, String> paramMap) {
/*  52 */     super(paramInt);
/*  53 */     updateAttributes(paramMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getThreadId() {
/*  58 */     return this.threadId;
/*     */   }
/*     */ 
/*     */   
/*     */   public OSProcess.State getState() {
/*  63 */     return this.state;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContextSwitches() {
/*  68 */     return this.contextSwitches;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getKernelTime() {
/*  73 */     return this.kernelTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUserTime() {
/*  78 */     return this.userTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUpTime() {
/*  83 */     return this.upTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getStartTime() {
/*  88 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPriority() {
/*  93 */     return this.priority;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/*  98 */     List list = ExecutingCommand.runNative("ps -m -o THREAD -p " + getOwningProcessId());
/*     */     
/* 100 */     if (list.size() > 2) {
/* 101 */       list.remove(0);
/* 102 */       list.remove(0);
/* 103 */       String str = Integer.toString(getThreadId());
/* 104 */       for (String str1 : list) {
/* 105 */         Map<AixOSProcess.PsThreadColumns, String> map = ParseUtil.stringToEnumMap(AixOSProcess.PsThreadColumns.class, str1
/* 106 */             .trim(), ' ');
/* 107 */         if (map.containsKey(AixOSProcess.PsThreadColumns.COMMAND) && str
/* 108 */           .equals(map.get(AixOSProcess.PsThreadColumns.TID))) {
/* 109 */           return updateAttributes(map);
/*     */         }
/*     */       } 
/*     */     } 
/* 113 */     this.state = OSProcess.State.INVALID;
/* 114 */     return false;
/*     */   }
/*     */   
/*     */   private boolean updateAttributes(Map<AixOSProcess.PsThreadColumns, String> paramMap) {
/* 118 */     this.threadId = ParseUtil.parseIntOrDefault(paramMap.get(AixOSProcess.PsThreadColumns.TID), 0);
/* 119 */     this.state = AixOSProcess.getStateFromOutput(((String)paramMap.get(AixOSProcess.PsThreadColumns.ST)).charAt(0));
/* 120 */     this.priority = ParseUtil.parseIntOrDefault(paramMap.get(AixOSProcess.PsThreadColumns.PRI), 0);
/* 121 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\aix\AixOSThread.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */