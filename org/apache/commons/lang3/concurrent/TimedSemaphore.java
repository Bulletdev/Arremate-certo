/*     */ package org.apache.commons.lang3.concurrent;
/*     */ 
/*     */ import java.util.concurrent.ScheduledExecutorService;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import java.util.concurrent.ScheduledThreadPoolExecutor;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.commons.lang3.Validate;
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
/*     */ public class TimedSemaphore
/*     */ {
/*     */   public static final int NO_LIMIT = 0;
/*     */   private static final int THREAD_POOL_SIZE = 1;
/*     */   private final ScheduledExecutorService executorService;
/*     */   private final long period;
/*     */   private final TimeUnit unit;
/*     */   private final boolean ownExecutor;
/*     */   private ScheduledFuture<?> task;
/*     */   private long totalAcquireCount;
/*     */   private long periodCount;
/*     */   private int limit;
/*     */   private int acquireCount;
/*     */   private int lastCallsPerPeriod;
/*     */   private boolean shutdown;
/*     */   
/*     */   public TimedSemaphore(long paramLong, TimeUnit paramTimeUnit, int paramInt) {
/* 197 */     this(null, paramLong, paramTimeUnit, paramInt);
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
/*     */ 
/*     */   
/*     */   public TimedSemaphore(ScheduledExecutorService paramScheduledExecutorService, long paramLong, TimeUnit paramTimeUnit, int paramInt) {
/* 214 */     Validate.inclusiveBetween(1L, Long.MAX_VALUE, paramLong, "Time period must be greater than 0!");
/*     */     
/* 216 */     this.period = paramLong;
/* 217 */     this.unit = paramTimeUnit;
/*     */     
/* 219 */     if (paramScheduledExecutorService != null) {
/* 220 */       this.executorService = paramScheduledExecutorService;
/* 221 */       this.ownExecutor = false;
/*     */     } else {
/* 223 */       ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
/*     */       
/* 225 */       scheduledThreadPoolExecutor.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
/* 226 */       scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
/* 227 */       this.executorService = scheduledThreadPoolExecutor;
/* 228 */       this.ownExecutor = true;
/*     */     } 
/*     */     
/* 231 */     setLimit(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final synchronized int getLimit() {
/* 242 */     return this.limit;
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
/*     */   public final synchronized void setLimit(int paramInt) {
/* 256 */     this.limit = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void shutdown() {
/* 265 */     if (!this.shutdown) {
/*     */       
/* 267 */       if (this.ownExecutor)
/*     */       {
/*     */         
/* 270 */         getExecutorService().shutdownNow();
/*     */       }
/* 272 */       if (this.task != null) {
/* 273 */         this.task.cancel(false);
/*     */       }
/*     */       
/* 276 */       this.shutdown = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized boolean isShutdown() {
/* 288 */     return this.shutdown;
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
/*     */   public synchronized void acquire() throws InterruptedException {
/*     */     boolean bool;
/* 303 */     prepareAcquire();
/*     */ 
/*     */     
/*     */     do {
/* 307 */       bool = acquirePermit();
/* 308 */       if (bool)
/* 309 */         continue;  wait();
/*     */     }
/* 311 */     while (!bool);
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
/*     */   public synchronized boolean tryAcquire() {
/* 326 */     prepareAcquire();
/* 327 */     return acquirePermit();
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
/*     */   public synchronized int getLastAcquiresPerPeriod() {
/* 341 */     return this.lastCallsPerPeriod;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized int getAcquireCount() {
/* 351 */     return this.acquireCount;
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
/*     */   public synchronized int getAvailablePermits() {
/* 366 */     return getLimit() - getAcquireCount();
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
/*     */   public synchronized double getAverageCallsPerPeriod() {
/* 379 */     return (this.periodCount == 0L) ? 0.0D : (this.totalAcquireCount / this.periodCount);
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
/*     */   public long getPeriod() {
/* 391 */     return this.period;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TimeUnit getUnit() {
/* 400 */     return this.unit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ScheduledExecutorService getExecutorService() {
/* 409 */     return this.executorService;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ScheduledFuture<?> startTimer() {
/* 420 */     return getExecutorService().scheduleAtFixedRate(this::endOfPeriod, getPeriod(), getPeriod(), getUnit());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   synchronized void endOfPeriod() {
/* 429 */     this.lastCallsPerPeriod = this.acquireCount;
/* 430 */     this.totalAcquireCount += this.acquireCount;
/* 431 */     this.periodCount++;
/* 432 */     this.acquireCount = 0;
/* 433 */     notifyAll();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void prepareAcquire() {
/* 441 */     if (isShutdown()) {
/* 442 */       throw new IllegalStateException("TimedSemaphore is shut down!");
/*     */     }
/*     */     
/* 445 */     if (this.task == null) {
/* 446 */       this.task = startTimer();
/*     */     }
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
/*     */   private boolean acquirePermit() {
/* 459 */     if (getLimit() <= 0 || this.acquireCount < getLimit()) {
/* 460 */       this.acquireCount++;
/* 461 */       return true;
/*     */     } 
/* 463 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\concurrent\TimedSemaphore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */