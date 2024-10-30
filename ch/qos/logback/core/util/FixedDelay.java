/*    */ package ch.qos.logback.core.util;
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
/*    */ public class FixedDelay
/*    */   implements DelayStrategy
/*    */ {
/*    */   private final long subsequentDelay;
/*    */   private long nextDelay;
/*    */   
/*    */   public FixedDelay(long paramLong1, long paramLong2) {
/* 35 */     this.nextDelay = paramLong1;
/* 36 */     this.subsequentDelay = paramLong2;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public FixedDelay(int paramInt) {
/* 46 */     this(paramInt, paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public long nextDelay() {
/* 53 */     long l = this.nextDelay;
/* 54 */     this.nextDelay = this.subsequentDelay;
/* 55 */     return l;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\FixedDelay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */