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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GlobalLock
/*    */ {
/* 25 */   private static final Mutex GLOBAL_MUTEX = new Mutex();
/*    */   
/* 27 */   public static void acquire() throws InterruptedException { GLOBAL_MUTEX.acquire(); }
/* 28 */   public static void tryToAcquire() { GLOBAL_MUTEX.tryToAcquire(); } public static void release() {
/* 29 */     GLOBAL_MUTEX.release();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\GlobalLock.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */