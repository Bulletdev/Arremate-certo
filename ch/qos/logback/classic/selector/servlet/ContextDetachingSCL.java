/*    */ package ch.qos.logback.classic.selector.servlet;
/*    */ 
/*    */ import ch.qos.logback.classic.Logger;
/*    */ import ch.qos.logback.classic.LoggerContext;
/*    */ import ch.qos.logback.classic.selector.ContextSelector;
/*    */ import ch.qos.logback.classic.util.ContextSelectorStaticBinder;
/*    */ import ch.qos.logback.core.util.JNDIUtil;
/*    */ import ch.qos.logback.core.util.OptionHelper;
/*    */ import javax.naming.Context;
/*    */ import javax.naming.NamingException;
/*    */ import javax.servlet.ServletContextEvent;
/*    */ import javax.servlet.ServletContextListener;
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
/*    */ public class ContextDetachingSCL
/*    */   implements ServletContextListener
/*    */ {
/*    */   public void contextInitialized(ServletContextEvent paramServletContextEvent) {}
/*    */   
/*    */   public void contextDestroyed(ServletContextEvent paramServletContextEvent) {
/* 39 */     String str = null;
/*    */     
/*    */     try {
/* 42 */       Context context = JNDIUtil.getInitialContext();
/* 43 */       str = JNDIUtil.lookupString(context, "java:comp/env/logback/context-name");
/* 44 */     } catch (NamingException namingException) {}
/*    */ 
/*    */     
/* 47 */     if (!OptionHelper.isEmpty(str)) {
/* 48 */       System.out.println("About to detach context named " + str);
/*    */       
/* 50 */       ContextSelector contextSelector = ContextSelectorStaticBinder.getSingleton().getContextSelector();
/* 51 */       if (contextSelector == null) {
/* 52 */         System.out.println("Selector is null, cannot detach context. Skipping.");
/*    */         return;
/*    */       } 
/* 55 */       LoggerContext loggerContext = contextSelector.getLoggerContext(str);
/* 56 */       if (loggerContext != null) {
/* 57 */         Logger logger = loggerContext.getLogger("ROOT");
/* 58 */         logger.warn("Stopping logger context " + str);
/* 59 */         contextSelector.detachLoggerContext(str);
/*    */         
/* 61 */         loggerContext.stop();
/*    */       } else {
/* 63 */         System.out.println("No context named " + str + " was found.");
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\selector\servlet\ContextDetachingSCL.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */