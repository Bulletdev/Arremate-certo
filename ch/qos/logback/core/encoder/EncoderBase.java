/*    */ package ch.qos.logback.core.encoder;
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
/*    */ public abstract class EncoderBase<E>
/*    */   extends ContextAwareBase
/*    */   implements Encoder<E>
/*    */ {
/*    */   protected boolean started;
/*    */   
/*    */   public boolean isStarted() {
/* 23 */     return this.started;
/*    */   }
/*    */   
/*    */   public void start() {
/* 27 */     this.started = true;
/*    */   }
/*    */   
/*    */   public void stop() {
/* 31 */     this.started = false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\encoder\EncoderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */