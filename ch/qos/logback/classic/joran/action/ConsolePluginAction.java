/*    */ package ch.qos.logback.classic.joran.action;
/*    */ 
/*    */ import ch.qos.logback.classic.Logger;
/*    */ import ch.qos.logback.classic.LoggerContext;
/*    */ import ch.qos.logback.classic.net.SocketAppender;
/*    */ import ch.qos.logback.core.Appender;
/*    */ import ch.qos.logback.core.Context;
/*    */ import ch.qos.logback.core.joran.action.Action;
/*    */ import ch.qos.logback.core.joran.spi.ActionException;
/*    */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*    */ import org.xml.sax.Attributes;
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
/*    */ public class ConsolePluginAction
/*    */   extends Action
/*    */ {
/*    */   private static final String PORT_ATTR = "port";
/* 28 */   private static final Integer DEFAULT_PORT = Integer.valueOf(4321);
/*    */ 
/*    */   
/*    */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) throws ActionException {
/* 32 */     String str = paramAttributes.getValue("port");
/* 33 */     Integer integer = null;
/*    */     
/* 35 */     if (str == null) {
/* 36 */       integer = DEFAULT_PORT;
/*    */     } else {
/*    */       try {
/* 39 */         integer = Integer.valueOf(str);
/* 40 */       } catch (NumberFormatException numberFormatException) {
/* 41 */         addError("Port " + str + " in ConsolePlugin config is not a correct number");
/*    */       } 
/*    */     } 
/*    */     
/* 45 */     LoggerContext loggerContext = (LoggerContext)paramInterpretationContext.getContext();
/* 46 */     SocketAppender socketAppender = new SocketAppender();
/* 47 */     socketAppender.setContext((Context)loggerContext);
/* 48 */     socketAppender.setIncludeCallerData(true);
/* 49 */     socketAppender.setRemoteHost("localhost");
/* 50 */     socketAppender.setPort(integer.intValue());
/* 51 */     socketAppender.start();
/* 52 */     Logger logger = loggerContext.getLogger("ROOT");
/* 53 */     logger.addAppender((Appender)socketAppender);
/*    */     
/* 55 */     addInfo("Sending LoggingEvents to the plugin using port " + integer);
/*    */   }
/*    */   
/*    */   public void end(InterpretationContext paramInterpretationContext, String paramString) throws ActionException {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\joran\action\ConsolePluginAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */