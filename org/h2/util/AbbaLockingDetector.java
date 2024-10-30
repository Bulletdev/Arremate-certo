/*     */ package org.h2.util;
/*     */ 
/*     */ import java.lang.management.ManagementFactory;
/*     */ import java.lang.management.MonitorInfo;
/*     */ import java.lang.management.ThreadInfo;
/*     */ import java.lang.management.ThreadMXBean;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.WeakHashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AbbaLockingDetector
/*     */   implements Runnable
/*     */ {
/*  26 */   private int tickIntervalMs = 2;
/*     */   
/*     */   private volatile boolean stop;
/*  29 */   private final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
/*     */ 
/*     */ 
/*     */   
/*     */   private Thread thread;
/*     */ 
/*     */ 
/*     */   
/*  37 */   private final Map<String, Map<String, String>> lockOrdering = new WeakHashMap<>();
/*     */   
/*  39 */   private final Set<String> knownDeadlocks = new HashSet<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AbbaLockingDetector startCollecting() {
/*  47 */     this.thread = new Thread(this, "AbbaLockingDetector");
/*  48 */     this.thread.setDaemon(true);
/*  49 */     this.thread.start();
/*  50 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void reset() {
/*  57 */     this.lockOrdering.clear();
/*  58 */     this.knownDeadlocks.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AbbaLockingDetector stopCollecting() {
/*  67 */     this.stop = true;
/*  68 */     if (this.thread != null) {
/*     */       try {
/*  70 */         this.thread.join();
/*  71 */       } catch (InterruptedException interruptedException) {}
/*     */ 
/*     */       
/*  74 */       this.thread = null;
/*     */     } 
/*  76 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*  81 */     while (!this.stop) {
/*     */       try {
/*  83 */         tick();
/*  84 */       } catch (Throwable throwable) {
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void tick() {
/*  91 */     if (this.tickIntervalMs > 0) {
/*     */       try {
/*  93 */         Thread.sleep(this.tickIntervalMs);
/*  94 */       } catch (InterruptedException interruptedException) {}
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  99 */     ThreadInfo[] arrayOfThreadInfo = this.threadMXBean.dumpAllThreads(true, false);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 104 */     processThreadList(arrayOfThreadInfo);
/*     */   }
/*     */   
/*     */   private void processThreadList(ThreadInfo[] paramArrayOfThreadInfo) {
/* 108 */     ArrayList<String> arrayList = new ArrayList();
/* 109 */     for (ThreadInfo threadInfo : paramArrayOfThreadInfo) {
/* 110 */       arrayList.clear();
/* 111 */       generateOrdering(arrayList, threadInfo);
/* 112 */       if (arrayList.size() > 1) {
/* 113 */         markHigher(arrayList, threadInfo);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void generateOrdering(List<String> paramList, ThreadInfo paramThreadInfo) {
/* 124 */     MonitorInfo[] arrayOfMonitorInfo = paramThreadInfo.getLockedMonitors();
/* 125 */     Arrays.sort(arrayOfMonitorInfo, new Comparator<MonitorInfo>()
/*     */         {
/*     */           public int compare(MonitorInfo param1MonitorInfo1, MonitorInfo param1MonitorInfo2) {
/* 128 */             return param1MonitorInfo2.getLockedStackDepth() - param1MonitorInfo1.getLockedStackDepth();
/*     */           }
/*     */         });
/* 131 */     for (MonitorInfo monitorInfo : arrayOfMonitorInfo) {
/* 132 */       String str = getObjectName(monitorInfo);
/* 133 */       if (!str.equals("sun.misc.Launcher$AppClassLoader"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 139 */         if (!paramList.contains(str)) {
/* 140 */           paramList.add(str);
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private synchronized void markHigher(List<String> paramList, ThreadInfo paramThreadInfo) {
/* 147 */     String str1 = paramList.get(paramList.size() - 1);
/* 148 */     Map<Object, Object> map = (Map)this.lockOrdering.get(str1);
/* 149 */     if (map == null) {
/* 150 */       map = new WeakHashMap<>();
/* 151 */       this.lockOrdering.put(str1, map);
/*     */     } 
/* 153 */     String str2 = null;
/* 154 */     for (byte b = 0; b < paramList.size() - 1; b++) {
/* 155 */       String str = paramList.get(b);
/* 156 */       Map map1 = this.lockOrdering.get(str);
/* 157 */       boolean bool = false;
/* 158 */       if (map1 != null) {
/* 159 */         String str3 = (String)map1.get(str1);
/* 160 */         if (str3 != null) {
/* 161 */           bool = true;
/* 162 */           String str4 = str1 + " " + str;
/* 163 */           if (!this.knownDeadlocks.contains(str4)) {
/* 164 */             System.out.println(str1 + " synchronized after \n " + str + ", but in the past before\n" + "AFTER\n" + getStackTraceForThread(paramThreadInfo) + "BEFORE\n" + str3);
/*     */ 
/*     */ 
/*     */             
/* 168 */             this.knownDeadlocks.add(str4);
/*     */           } 
/*     */         } 
/*     */       } 
/* 172 */       if (!bool && !map.containsKey(str)) {
/* 173 */         if (str2 == null) {
/* 174 */           str2 = getStackTraceForThread(paramThreadInfo);
/*     */         }
/* 176 */         map.put(str, str2);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String getStackTraceForThread(ThreadInfo paramThreadInfo) {
/* 187 */     StringBuilder stringBuilder = new StringBuilder("\"" + paramThreadInfo.getThreadName() + "\"" + " Id=" + paramThreadInfo.getThreadId() + " " + paramThreadInfo.getThreadState());
/*     */ 
/*     */     
/* 190 */     if (paramThreadInfo.getLockName() != null) {
/* 191 */       stringBuilder.append(" on " + paramThreadInfo.getLockName());
/*     */     }
/* 193 */     if (paramThreadInfo.getLockOwnerName() != null) {
/* 194 */       stringBuilder.append(" owned by \"" + paramThreadInfo.getLockOwnerName() + "\" Id=" + paramThreadInfo.getLockOwnerId());
/*     */     }
/*     */     
/* 197 */     if (paramThreadInfo.isSuspended()) {
/* 198 */       stringBuilder.append(" (suspended)");
/*     */     }
/* 200 */     if (paramThreadInfo.isInNative()) {
/* 201 */       stringBuilder.append(" (in native)");
/*     */     }
/* 203 */     stringBuilder.append('\n');
/* 204 */     StackTraceElement[] arrayOfStackTraceElement = paramThreadInfo.getStackTrace();
/* 205 */     MonitorInfo[] arrayOfMonitorInfo = paramThreadInfo.getLockedMonitors();
/* 206 */     boolean bool = false;
/* 207 */     for (byte b = 0; b < arrayOfStackTraceElement.length; b++) {
/* 208 */       StackTraceElement stackTraceElement = arrayOfStackTraceElement[b];
/* 209 */       if (bool) {
/* 210 */         dumpStackTraceElement(paramThreadInfo, stringBuilder, b, stackTraceElement);
/*     */       }
/*     */       
/* 213 */       for (MonitorInfo monitorInfo : arrayOfMonitorInfo) {
/* 214 */         if (monitorInfo.getLockedStackDepth() == b) {
/*     */ 
/*     */ 
/*     */           
/* 218 */           if (!bool) {
/* 219 */             dumpStackTraceElement(paramThreadInfo, stringBuilder, b, stackTraceElement);
/* 220 */             bool = true;
/*     */           } 
/* 222 */           stringBuilder.append("\t-  locked " + monitorInfo);
/* 223 */           stringBuilder.append('\n');
/*     */         } 
/*     */       } 
/*     */     } 
/* 227 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void dumpStackTraceElement(ThreadInfo paramThreadInfo, StringBuilder paramStringBuilder, int paramInt, StackTraceElement paramStackTraceElement) {
/* 232 */     paramStringBuilder.append('\t').append("at ").append(paramStackTraceElement.toString());
/* 233 */     paramStringBuilder.append('\n');
/* 234 */     if (paramInt == 0 && paramThreadInfo.getLockInfo() != null) {
/* 235 */       Thread.State state = paramThreadInfo.getThreadState();
/* 236 */       switch (state) {
/*     */         case BLOCKED:
/* 238 */           paramStringBuilder.append("\t-  blocked on " + paramThreadInfo.getLockInfo());
/* 239 */           paramStringBuilder.append('\n');
/*     */           break;
/*     */         case WAITING:
/* 242 */           paramStringBuilder.append("\t-  waiting on " + paramThreadInfo.getLockInfo());
/* 243 */           paramStringBuilder.append('\n');
/*     */           break;
/*     */         case TIMED_WAITING:
/* 246 */           paramStringBuilder.append("\t-  waiting on " + paramThreadInfo.getLockInfo());
/* 247 */           paramStringBuilder.append('\n');
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getObjectName(MonitorInfo paramMonitorInfo) {
/* 255 */     return paramMonitorInfo.getClassName() + "@" + Integer.toHexString(paramMonitorInfo.getIdentityHashCode());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\AbbaLockingDetector.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */