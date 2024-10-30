/*     */ package oshi.software.os.unix.solaris;
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
/*     */ @ThreadSafe
/*     */ public class SolarisOSThread
/*     */   extends AbstractOSThread
/*     */ {
/*     */   private int threadId;
/*  45 */   private OSProcess.State state = OSProcess.State.INVALID;
/*     */   private long startMemoryAddress;
/*     */   private long contextSwitches;
/*     */   private long kernelTime;
/*     */   private long userTime;
/*     */   private long startTime;
/*     */   private long upTime;
/*     */   private int priority;
/*     */   
/*     */   public SolarisOSThread(int paramInt, Map<SolarisOSProcess.PsThreadColumns, String> paramMap, Map<SolarisOperatingSystem.PrstatKeywords, String> paramMap1) {
/*  55 */     super(paramInt);
/*  56 */     updateAttributes(paramMap, paramMap1);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getThreadId() {
/*  61 */     return this.threadId;
/*     */   }
/*     */ 
/*     */   
/*     */   public OSProcess.State getState() {
/*  66 */     return this.state;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getStartMemoryAddress() {
/*  71 */     return this.startMemoryAddress;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContextSwitches() {
/*  76 */     return this.contextSwitches;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getKernelTime() {
/*  81 */     return this.kernelTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUserTime() {
/*  86 */     return this.userTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getUpTime() {
/*  91 */     return this.upTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getStartTime() {
/*  96 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPriority() {
/* 101 */     return this.priority;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 106 */     int i = getOwningProcessId();
/*     */     
/* 108 */     List list = ExecutingCommand.runNative("ps -o " + SolarisOSProcess.PS_THREAD_COLUMNS + " -p " + i);
/* 109 */     if (list.size() > 1) {
/*     */       
/* 111 */       String str = Integer.toString(this.threadId);
/* 112 */       for (String str1 : list) {
/* 113 */         Map<SolarisOSProcess.PsThreadColumns, String> map = ParseUtil.stringToEnumMap(SolarisOSProcess.PsThreadColumns.class, str1
/* 114 */             .trim(), ' ');
/* 115 */         if (map.containsKey(SolarisOSProcess.PsThreadColumns.PRI) && str.equals(map.get(SolarisOSProcess.PsThreadColumns.LWP))) {
/* 116 */           List list1 = ExecutingCommand.runNative("prstat -L -v -p " + i + " 1 1");
/* 117 */           String str2 = "";
/* 118 */           for (String str3 : list1) {
/* 119 */             String str4 = str3.trim();
/* 120 */             if (str4.endsWith("/" + str)) {
/* 121 */               str2 = str4;
/*     */               break;
/*     */             } 
/*     */           } 
/* 125 */           Map<SolarisOperatingSystem.PrstatKeywords, String> map1 = ParseUtil.stringToEnumMap(SolarisOperatingSystem.PrstatKeywords.class, str2, ' ');
/*     */           
/* 127 */           return updateAttributes(map, map1);
/*     */         } 
/*     */       } 
/*     */     } 
/* 131 */     this.state = OSProcess.State.INVALID;
/* 132 */     return false;
/*     */   }
/*     */   
/*     */   private boolean updateAttributes(Map<SolarisOSProcess.PsThreadColumns, String> paramMap, Map<SolarisOperatingSystem.PrstatKeywords, String> paramMap1) {
/* 136 */     this.threadId = ParseUtil.parseIntOrDefault(paramMap.get(SolarisOSProcess.PsThreadColumns.LWP), 0);
/* 137 */     this.state = SolarisOSProcess.getStateFromOutput(((String)paramMap.get(SolarisOSProcess.PsThreadColumns.S)).charAt(0));
/*     */     
/* 139 */     long l1 = ParseUtil.parseDHMSOrDefault(paramMap.get(SolarisOSProcess.PsThreadColumns.ETIME), 0L);
/* 140 */     this.upTime = (l1 < 1L) ? 1L : l1;
/* 141 */     long l2 = System.currentTimeMillis();
/* 142 */     this.startTime = l2 - this.upTime;
/* 143 */     this.kernelTime = 0L;
/* 144 */     this.userTime = ParseUtil.parseDHMSOrDefault(paramMap.get(SolarisOSProcess.PsThreadColumns.TIME), 0L);
/* 145 */     this.startMemoryAddress = ParseUtil.hexStringToLong(paramMap.get(SolarisOSProcess.PsThreadColumns.ADDR), 0L);
/* 146 */     this.priority = ParseUtil.parseIntOrDefault(paramMap.get(SolarisOSProcess.PsThreadColumns.PRI), 0);
/* 147 */     long l3 = ParseUtil.parseLongOrDefault(paramMap1.get(SolarisOperatingSystem.PrstatKeywords.ICX), 0L);
/* 148 */     long l4 = ParseUtil.parseLongOrDefault(paramMap1.get(SolarisOperatingSystem.PrstatKeywords.VCX), 0L);
/* 149 */     this.contextSwitches = l4 + l3;
/* 150 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\solaris\SolarisOSThread.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */