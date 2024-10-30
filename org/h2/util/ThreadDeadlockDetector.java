/*     */ package org.h2.util;
/*     */ 
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.lang.management.LockInfo;
/*     */ import java.lang.management.ManagementFactory;
/*     */ import java.lang.management.MonitorInfo;
/*     */ import java.lang.management.ThreadInfo;
/*     */ import java.lang.management.ThreadMXBean;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import org.h2.mvstore.db.MVTable;
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
/*     */ public class ThreadDeadlockDetector
/*     */ {
/*     */   private static final String INDENT = "    ";
/*     */   private static ThreadDeadlockDetector detector;
/*     */   private final ThreadMXBean threadBean;
/*  35 */   private final Timer threadCheck = new Timer("ThreadDeadlockDetector", true);
/*     */   
/*     */   private ThreadDeadlockDetector() {
/*  38 */     this.threadBean = ManagementFactory.getThreadMXBean();
/*     */ 
/*     */     
/*  41 */     this.threadCheck.schedule(new TimerTask()
/*     */         {
/*     */           public void run() {
/*  44 */             ThreadDeadlockDetector.this.checkForDeadlocks();
/*     */           }
/*     */         },  10L, 10000L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized void init() {
/*  53 */     if (detector == null) {
/*  54 */       detector = new ThreadDeadlockDetector();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void checkForDeadlocks() {
/*  63 */     long[] arrayOfLong = this.threadBean.findDeadlockedThreads();
/*  64 */     if (arrayOfLong == null) {
/*     */       return;
/*     */     }
/*     */     
/*  68 */     StringWriter stringWriter = new StringWriter();
/*  69 */     PrintWriter printWriter = new PrintWriter(stringWriter);
/*     */     
/*  71 */     printWriter.println("ThreadDeadlockDetector - deadlock found :");
/*  72 */     ThreadInfo[] arrayOfThreadInfo = this.threadBean.getThreadInfo(arrayOfLong, true, true);
/*  73 */     HashMap hashMap1 = MVTable.WAITING_FOR_LOCK.getSnapshotOfAllThreads();
/*     */     
/*  75 */     HashMap hashMap2 = MVTable.EXCLUSIVE_LOCKS.getSnapshotOfAllThreads();
/*     */     
/*  77 */     HashMap hashMap3 = MVTable.SHARED_LOCKS.getSnapshotOfAllThreads();
/*     */     
/*  79 */     for (ThreadInfo threadInfo : arrayOfThreadInfo) {
/*  80 */       printThreadInfo(printWriter, threadInfo);
/*  81 */       printLockInfo(printWriter, threadInfo.getLockedSynchronizers(), (String)hashMap1.get(Long.valueOf(threadInfo.getThreadId())), (ArrayList<String>)hashMap2.get(Long.valueOf(threadInfo.getThreadId())), (ArrayList<String>)hashMap3.get(Long.valueOf(threadInfo.getThreadId())));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  87 */     printWriter.flush();
/*     */ 
/*     */     
/*  90 */     System.out.println(stringWriter.getBuffer());
/*     */   }
/*     */ 
/*     */   
/*     */   private static void printThreadInfo(PrintWriter paramPrintWriter, ThreadInfo paramThreadInfo) {
/*  95 */     printThread(paramPrintWriter, paramThreadInfo);
/*     */ 
/*     */     
/*  98 */     StackTraceElement[] arrayOfStackTraceElement = paramThreadInfo.getStackTrace();
/*  99 */     MonitorInfo[] arrayOfMonitorInfo = paramThreadInfo.getLockedMonitors();
/* 100 */     for (byte b = 0; b < arrayOfStackTraceElement.length; b++) {
/* 101 */       StackTraceElement stackTraceElement = arrayOfStackTraceElement[b];
/* 102 */       paramPrintWriter.println("    at " + stackTraceElement.toString());
/* 103 */       for (MonitorInfo monitorInfo : arrayOfMonitorInfo) {
/* 104 */         if (monitorInfo.getLockedStackDepth() == b) {
/* 105 */           paramPrintWriter.println("      - locked " + monitorInfo);
/*     */         }
/*     */       } 
/*     */     } 
/* 109 */     paramPrintWriter.println();
/*     */   }
/*     */   
/*     */   private static void printThread(PrintWriter paramPrintWriter, ThreadInfo paramThreadInfo) {
/* 113 */     paramPrintWriter.print("\"" + paramThreadInfo.getThreadName() + "\"" + " Id=" + paramThreadInfo.getThreadId() + " in " + paramThreadInfo.getThreadState());
/*     */     
/* 115 */     if (paramThreadInfo.getLockName() != null) {
/* 116 */       paramPrintWriter.append(" on lock=" + paramThreadInfo.getLockName());
/*     */     }
/* 118 */     if (paramThreadInfo.isSuspended()) {
/* 119 */       paramPrintWriter.append(" (suspended)");
/*     */     }
/* 121 */     if (paramThreadInfo.isInNative()) {
/* 122 */       paramPrintWriter.append(" (running in native)");
/*     */     }
/* 124 */     paramPrintWriter.println();
/* 125 */     if (paramThreadInfo.getLockOwnerName() != null) {
/* 126 */       paramPrintWriter.println("     owned by " + paramThreadInfo.getLockOwnerName() + " Id=" + paramThreadInfo.getLockOwnerId());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void printLockInfo(PrintWriter paramPrintWriter, LockInfo[] paramArrayOfLockInfo, String paramString, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2) {
/* 135 */     paramPrintWriter.println("    Locked synchronizers: count = " + paramArrayOfLockInfo.length);
/* 136 */     for (LockInfo lockInfo : paramArrayOfLockInfo) {
/* 137 */       paramPrintWriter.println("      - " + lockInfo);
/*     */     }
/* 139 */     if (paramString != null) {
/* 140 */       paramPrintWriter.println("    Waiting for table: " + paramString);
/*     */     }
/* 142 */     if (paramArrayList1 != null) {
/* 143 */       paramPrintWriter.println("    Exclusive table locks: count = " + paramArrayList1.size());
/* 144 */       for (String str : paramArrayList1) {
/* 145 */         paramPrintWriter.println("      - " + str);
/*     */       }
/*     */     } 
/* 148 */     if (paramArrayList2 != null) {
/* 149 */       paramPrintWriter.println("    Shared table locks: count = " + paramArrayList2.size());
/* 150 */       for (String str : paramArrayList2) {
/* 151 */         paramPrintWriter.println("      - " + str);
/*     */       }
/*     */     } 
/* 154 */     paramPrintWriter.println();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\ThreadDeadlockDetector.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */