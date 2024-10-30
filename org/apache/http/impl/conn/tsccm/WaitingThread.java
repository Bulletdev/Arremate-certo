/*     */ package org.apache.http.impl.conn.tsccm;
/*     */ 
/*     */ import java.util.Date;
/*     */ import java.util.concurrent.locks.Condition;
/*     */ import org.apache.http.util.Args;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class WaitingThread
/*     */ {
/*     */   private final Condition cond;
/*     */   private final RouteSpecificPool pool;
/*     */   private Thread waiter;
/*     */   private boolean aborted;
/*     */   
/*     */   public WaitingThread(Condition paramCondition, RouteSpecificPool paramRouteSpecificPool) {
/*  78 */     Args.notNull(paramCondition, "Condition");
/*     */     
/*  80 */     this.cond = paramCondition;
/*  81 */     this.pool = paramRouteSpecificPool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Condition getCondition() {
/*  92 */     return this.cond;
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
/*     */   public final RouteSpecificPool getPool() {
/* 104 */     return this.pool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Thread getThread() {
/* 115 */     return this.waiter;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean await(Date paramDate) throws InterruptedException {
/* 144 */     if (this.waiter != null) {
/* 145 */       throw new IllegalStateException("A thread is already waiting on this object.\ncaller: " + Thread.currentThread() + "\nwaiter: " + this.waiter);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 151 */     if (this.aborted) {
/* 152 */       throw new InterruptedException("Operation interrupted");
/*     */     }
/*     */     
/* 155 */     this.waiter = Thread.currentThread();
/*     */     
/* 157 */     boolean bool = false;
/*     */     try {
/* 159 */       if (paramDate != null) {
/* 160 */         bool = this.cond.awaitUntil(paramDate);
/*     */       } else {
/* 162 */         this.cond.await();
/* 163 */         bool = true;
/*     */       } 
/* 165 */       if (this.aborted) {
/* 166 */         throw new InterruptedException("Operation interrupted");
/*     */       }
/*     */     } finally {
/* 169 */       this.waiter = null;
/*     */     } 
/* 171 */     return bool;
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
/*     */   public void wakeup() {
/* 186 */     if (this.waiter == null) {
/* 187 */       throw new IllegalStateException("Nobody waiting on this object.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 193 */     this.cond.signalAll();
/*     */   }
/*     */   
/*     */   public void interrupt() {
/* 197 */     this.aborted = true;
/* 198 */     this.cond.signalAll();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\conn\tsccm\WaitingThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */