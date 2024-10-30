/*    */ package ch.qos.logback.classic.spi;
/*    */ 
/*    */ import ch.qos.logback.classic.LoggerContext;
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
/*    */ public class LoggerContextAwareBase
/*    */   extends ContextAwareBase
/*    */   implements LoggerContextAware
/*    */ {
/*    */   public void setLoggerContext(LoggerContext paramLoggerContext) {
/* 27 */     super.setContext((Context)paramLoggerContext);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setContext(Context paramContext) {
/* 33 */     if (paramContext instanceof LoggerContext || paramContext == null) {
/* 34 */       super.setContext(paramContext);
/*    */     } else {
/* 36 */       throw new IllegalArgumentException("LoggerContextAwareBase only accepts contexts of type c.l.classic.LoggerContext");
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public LoggerContext getLoggerContext() {
/* 46 */     return (LoggerContext)this.context;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\spi\LoggerContextAwareBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */