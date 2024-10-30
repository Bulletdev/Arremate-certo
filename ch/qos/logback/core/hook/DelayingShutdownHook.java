/*    */ package ch.qos.logback.core.hook;
/*    */ 
/*    */ import ch.qos.logback.core.util.Duration;
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
/*    */ public class DelayingShutdownHook
/*    */   extends ShutdownHookBase
/*    */ {
/* 28 */   public static final Duration DEFAULT_DELAY = Duration.buildByMilliseconds(0.0D);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 33 */   private Duration delay = DEFAULT_DELAY;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Duration getDelay() {
/* 39 */     return this.delay;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setDelay(Duration paramDuration) {
/* 48 */     this.delay = paramDuration;
/*    */   }
/*    */   
/*    */   public void run() {
/* 52 */     addInfo("Sleeping for " + this.delay);
/*    */     try {
/* 54 */       Thread.sleep(this.delay.getMilliseconds());
/* 55 */     } catch (InterruptedException interruptedException) {}
/*    */     
/* 57 */     stop();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\hook\DelayingShutdownHook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */