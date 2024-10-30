/*    */ package ch.qos.logback.core.util;
/*    */ 
/*    */ import ch.qos.logback.core.Context;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InterruptUtil
/*    */   extends ContextAwareBase
/*    */ {
/*    */   final boolean previouslyInterrupted;
/*    */   
/*    */   public InterruptUtil(Context paramContext) {
/* 34 */     setContext(paramContext);
/* 35 */     this.previouslyInterrupted = Thread.currentThread().isInterrupted();
/*    */   }
/*    */   
/*    */   public void maskInterruptFlag() {
/* 39 */     if (this.previouslyInterrupted) {
/* 40 */       Thread.interrupted();
/*    */     }
/*    */   }
/*    */   
/*    */   public void unmaskInterruptFlag() {
/* 45 */     if (this.previouslyInterrupted)
/*    */       try {
/* 47 */         Thread.currentThread().interrupt();
/* 48 */       } catch (SecurityException securityException) {
/* 49 */         addError("Failed to intrreupt current thread", securityException);
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\InterruptUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */