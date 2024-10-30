/*    */ package ch.qos.logback.core.boolex;
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
/*    */ public abstract class EventEvaluatorBase<E>
/*    */   extends ContextAwareBase
/*    */   implements EventEvaluator<E>
/*    */ {
/*    */   String name;
/*    */   boolean started;
/*    */   
/*    */   public String getName() {
/* 24 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String paramString) {
/* 28 */     if (this.name != null) {
/* 29 */       throw new IllegalStateException("name has been already set");
/*    */     }
/* 31 */     this.name = paramString;
/*    */   }
/*    */   
/*    */   public boolean isStarted() {
/* 35 */     return this.started;
/*    */   }
/*    */   
/*    */   public void start() {
/* 39 */     this.started = true;
/*    */   }
/*    */   
/*    */   public void stop() {
/* 43 */     this.started = false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\boolex\EventEvaluatorBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */