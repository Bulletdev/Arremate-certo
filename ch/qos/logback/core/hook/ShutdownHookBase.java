/*    */ package ch.qos.logback.core.hook;
/*    */ 
/*    */ import ch.qos.logback.core.Context;
/*    */ import ch.qos.logback.core.ContextBase;
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
/*    */ public abstract class ShutdownHookBase
/*    */   extends ContextAwareBase
/*    */   implements ShutdownHook
/*    */ {
/*    */   protected void stop() {
/* 34 */     addInfo("Logback context being closed via shutdown hook");
/*    */     
/* 36 */     Context context = getContext();
/* 37 */     if (context instanceof ContextBase) {
/* 38 */       ContextBase contextBase = (ContextBase)context;
/* 39 */       contextBase.stop();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\hook\ShutdownHookBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */