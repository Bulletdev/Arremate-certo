/*    */ package ch.qos.logback.classic;
/*    */ 
/*    */ import ch.qos.logback.classic.layout.TTLLLayout;
/*    */ import ch.qos.logback.classic.spi.Configurator;
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*    */ import ch.qos.logback.core.Appender;
/*    */ import ch.qos.logback.core.ConsoleAppender;
/*    */ import ch.qos.logback.core.Context;
/*    */ import ch.qos.logback.core.Layout;
/*    */ import ch.qos.logback.core.encoder.Encoder;
/*    */ import ch.qos.logback.core.encoder.LayoutWrappingEncoder;
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
/*    */ public class BasicConfigurator
/*    */   extends ContextAwareBase
/*    */   implements Configurator
/*    */ {
/*    */   public void configure(LoggerContext paramLoggerContext) {
/* 36 */     addInfo("Setting up default configuration.");
/*    */     
/* 38 */     ConsoleAppender consoleAppender = new ConsoleAppender();
/* 39 */     consoleAppender.setContext((Context)paramLoggerContext);
/* 40 */     consoleAppender.setName("console");
/* 41 */     LayoutWrappingEncoder layoutWrappingEncoder = new LayoutWrappingEncoder();
/* 42 */     layoutWrappingEncoder.setContext((Context)paramLoggerContext);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 48 */     TTLLLayout tTLLLayout = new TTLLLayout();
/*    */     
/* 50 */     tTLLLayout.setContext((Context)paramLoggerContext);
/* 51 */     tTLLLayout.start();
/* 52 */     layoutWrappingEncoder.setLayout((Layout)tTLLLayout);
/*    */     
/* 54 */     consoleAppender.setEncoder((Encoder)layoutWrappingEncoder);
/* 55 */     consoleAppender.start();
/*    */     
/* 57 */     Logger logger = paramLoggerContext.getLogger("ROOT");
/* 58 */     logger.addAppender((Appender<ILoggingEvent>)consoleAppender);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\BasicConfigurator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */