/*    */ package ch.qos.logback.core.recovery;
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
/*    */ public class RecoveryCoordinator
/*    */ {
/*    */   public static final long BACKOFF_COEFFICIENT_MIN = 20L;
/*    */   public static final long BACKOFF_MULTIPLIER = 4L;
/* 20 */   static long BACKOFF_COEFFICIENT_MAX = 327680L;
/*    */   
/* 22 */   private long backOffCoefficient = 20L;
/*    */   
/* 24 */   private static long UNSET = -1L;
/*    */   
/* 26 */   private long currentTime = UNSET;
/*    */   private long next;
/*    */   
/*    */   public RecoveryCoordinator() {
/* 30 */     this.next = getCurrentTime() + getBackoffCoefficient();
/*    */   }
/*    */   
/*    */   public RecoveryCoordinator(long paramLong) {
/* 34 */     this.currentTime = paramLong;
/* 35 */     this.next = getCurrentTime() + getBackoffCoefficient();
/*    */   }
/*    */   
/*    */   public boolean isTooSoon() {
/* 39 */     long l = getCurrentTime();
/* 40 */     if (l > this.next) {
/* 41 */       this.next = l + getBackoffCoefficient();
/* 42 */       return false;
/*    */     } 
/* 44 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   void setCurrentTime(long paramLong) {
/* 49 */     this.currentTime = paramLong;
/*    */   }
/*    */   
/*    */   private long getCurrentTime() {
/* 53 */     if (this.currentTime != UNSET) {
/* 54 */       return this.currentTime;
/*    */     }
/* 56 */     return System.currentTimeMillis();
/*    */   }
/*    */   
/*    */   private long getBackoffCoefficient() {
/* 60 */     long l = this.backOffCoefficient;
/* 61 */     if (this.backOffCoefficient < BACKOFF_COEFFICIENT_MAX) {
/* 62 */       this.backOffCoefficient *= 4L;
/*    */     }
/* 64 */     return l;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\recovery\RecoveryCoordinator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */