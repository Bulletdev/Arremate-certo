/*     */ package org.apache.commons.io;
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
/*     */ 
/*     */ class ThreadMonitor
/*     */   implements Runnable
/*     */ {
/*     */   private final Thread thread;
/*     */   private final long timeout;
/*     */   
/*     */   public static Thread start(long paramLong) {
/*  54 */     return start(Thread.currentThread(), paramLong);
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
/*     */   public static Thread start(Thread paramThread, long paramLong) {
/*  67 */     Thread thread = null;
/*  68 */     if (paramLong > 0L) {
/*  69 */       ThreadMonitor threadMonitor = new ThreadMonitor(paramThread, paramLong);
/*  70 */       thread = new Thread(threadMonitor, ThreadMonitor.class.getSimpleName());
/*  71 */       thread.setDaemon(true);
/*  72 */       thread.start();
/*     */     } 
/*  74 */     return thread;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void stop(Thread paramThread) {
/*  83 */     if (paramThread != null) {
/*  84 */       paramThread.interrupt();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ThreadMonitor(Thread paramThread, long paramLong) {
/*  95 */     this.thread = paramThread;
/*  96 */     this.timeout = paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/* 108 */       sleep(this.timeout);
/* 109 */       this.thread.interrupt();
/* 110 */     } catch (InterruptedException interruptedException) {}
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
/*     */ 
/*     */   
/*     */   private static void sleep(long paramLong) throws InterruptedException {
/* 125 */     long l1 = System.currentTimeMillis() + paramLong;
/* 126 */     long l2 = paramLong;
/*     */     do {
/* 128 */       Thread.sleep(l2);
/* 129 */       l2 = l1 - System.currentTimeMillis();
/* 130 */     } while (l2 > 0L);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\ThreadMonitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */