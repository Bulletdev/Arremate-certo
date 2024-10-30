/*    */ package ch.qos.logback.core.sift;
/*    */ 
/*    */ import ch.qos.logback.core.Appender;
/*    */ import ch.qos.logback.core.Context;
/*    */ import ch.qos.logback.core.helpers.NOPAppender;
/*    */ import ch.qos.logback.core.joran.spi.JoranException;
/*    */ import ch.qos.logback.core.spi.AbstractComponentTracker;
/*    */ import ch.qos.logback.core.spi.ContextAwareImpl;
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
/*    */ public class AppenderTracker<E>
/*    */   extends AbstractComponentTracker<Appender<E>>
/*    */ {
/* 34 */   int nopaWarningCount = 0;
/*    */   
/*    */   final Context context;
/*    */   
/*    */   final AppenderFactory<E> appenderFactory;
/*    */   final ContextAwareImpl contextAware;
/*    */   
/*    */   public AppenderTracker(Context paramContext, AppenderFactory<E> paramAppenderFactory) {
/* 42 */     this.context = paramContext;
/* 43 */     this.appenderFactory = paramAppenderFactory;
/* 44 */     this.contextAware = new ContextAwareImpl(paramContext, this);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void processPriorToRemoval(Appender<E> paramAppender) {
/* 49 */     paramAppender.stop();
/*    */   }
/*    */   
/*    */   protected Appender<E> buildComponent(String paramString) {
/*    */     NOPAppender<E> nOPAppender;
/* 54 */     Appender<E> appender = null;
/*    */     try {
/* 56 */       appender = this.appenderFactory.buildAppender(this.context, paramString);
/* 57 */     } catch (JoranException joranException) {
/* 58 */       this.contextAware.addError("Error while building appender with discriminating value [" + paramString + "]");
/*    */     } 
/* 60 */     if (appender == null) {
/* 61 */       nOPAppender = buildNOPAppender(paramString);
/*    */     }
/*    */     
/* 64 */     return (Appender<E>)nOPAppender;
/*    */   }
/*    */   
/*    */   private NOPAppender<E> buildNOPAppender(String paramString) {
/* 68 */     if (this.nopaWarningCount < 4) {
/* 69 */       this.nopaWarningCount++;
/* 70 */       this.contextAware.addError("Building NOPAppender for discriminating value [" + paramString + "]");
/*    */     } 
/* 72 */     NOPAppender<E> nOPAppender = new NOPAppender();
/* 73 */     nOPAppender.setContext(this.context);
/* 74 */     nOPAppender.start();
/* 75 */     return nOPAppender;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean isComponentStale(Appender<E> paramAppender) {
/* 80 */     return !paramAppender.isStarted();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\sift\AppenderTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */