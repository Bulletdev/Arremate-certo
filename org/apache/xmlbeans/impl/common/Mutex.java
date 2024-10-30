/*    */ package org.apache.xmlbeans.impl.common;
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
/*    */ public class Mutex
/*    */ {
/* 20 */   private Thread owner = null;
/* 21 */   private int lock_count = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public synchronized void acquire() throws InterruptedException {
/* 31 */     while (!tryToAcquire())
/*    */     {
/* 33 */       wait();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public synchronized boolean tryToAcquire() {
/* 46 */     if (this.owner == null) {
/*    */       
/* 48 */       this.owner = Thread.currentThread();
/* 49 */       this.lock_count = 1;
/* 50 */       return true;
/*    */     } 
/*    */     
/* 53 */     if (this.owner == Thread.currentThread()) {
/*    */       
/* 55 */       this.lock_count++;
/* 56 */       return true;
/*    */     } 
/*    */     
/* 59 */     return false;
/*    */   }
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
/*    */   public synchronized void release() {
/* 73 */     if (this.owner != Thread.currentThread()) {
/* 74 */       throw new IllegalStateException("Thread calling release() doesn't own mutex");
/*    */     }
/* 76 */     if (--this.lock_count <= 0) {
/*    */       
/* 78 */       this.owner = null;
/* 79 */       notify();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\Mutex.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */