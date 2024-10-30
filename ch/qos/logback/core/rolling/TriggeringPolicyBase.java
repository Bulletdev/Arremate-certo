/*    */ package ch.qos.logback.core.rolling;
/*    */ 
/*    */ import ch.qos.logback.core.spi.ContextAwareBase;
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
/*    */ public abstract class TriggeringPolicyBase<E>
/*    */   extends ContextAwareBase
/*    */   implements TriggeringPolicy<E>
/*    */ {
/*    */   private boolean start;
/*    */   
/*    */   public void start() {
/* 30 */     this.start = true;
/*    */   }
/*    */   
/*    */   public void stop() {
/* 34 */     this.start = false;
/*    */   }
/*    */   
/*    */   public boolean isStarted() {
/* 38 */     return this.start;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\rolling\TriggeringPolicyBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */