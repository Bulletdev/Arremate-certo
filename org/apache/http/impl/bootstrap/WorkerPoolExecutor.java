/*    */ package org.apache.http.impl.bootstrap;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.BlockingQueue;
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import java.util.concurrent.ThreadFactory;
/*    */ import java.util.concurrent.ThreadPoolExecutor;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class WorkerPoolExecutor
/*    */   extends ThreadPoolExecutor
/*    */ {
/*    */   private final Map<Worker, Boolean> workerSet;
/*    */   
/*    */   public WorkerPoolExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory) {
/* 52 */     super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
/* 53 */     this.workerSet = new ConcurrentHashMap<Worker, Boolean>();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void beforeExecute(Thread paramThread, Runnable paramRunnable) {
/* 58 */     if (paramRunnable instanceof Worker) {
/* 59 */       this.workerSet.put((Worker)paramRunnable, Boolean.TRUE);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable) {
/* 65 */     if (paramRunnable instanceof Worker) {
/* 66 */       this.workerSet.remove(paramRunnable);
/*    */     }
/*    */   }
/*    */   
/*    */   public Set<Worker> getWorkers() {
/* 71 */     return new HashSet<Worker>(this.workerSet.keySet());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\bootstrap\WorkerPoolExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */