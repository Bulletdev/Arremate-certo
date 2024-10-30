/*    */ package ch.qos.logback.classic.servlet;
/*    */ 
/*    */ import ch.qos.logback.classic.util.StatusViaSLF4JLoggerFactory;
/*    */ import ch.qos.logback.core.util.OptionHelper;
/*    */ import java.util.EventListener;
/*    */ import java.util.Set;
/*    */ import javax.servlet.ServletContainerInitializer;
/*    */ import javax.servlet.ServletContext;
/*    */ import javax.servlet.ServletException;
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
/*    */ public class LogbackServletContainerInitializer
/*    */   implements ServletContainerInitializer
/*    */ {
/*    */   public void onStartup(Set<Class<?>> paramSet, ServletContext paramServletContext) throws ServletException {
/* 25 */     if (isDisabledByConfiguration(paramServletContext)) {
/* 26 */       StatusViaSLF4JLoggerFactory.addInfo("Due to deployment instructions will NOT register an instance of " + LogbackServletContextListener.class + " to the current web-app", this);
/*    */ 
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 32 */     StatusViaSLF4JLoggerFactory.addInfo("Adding an instance of  " + LogbackServletContextListener.class + " to the current web-app", this);
/* 33 */     LogbackServletContextListener logbackServletContextListener = new LogbackServletContextListener();
/* 34 */     paramServletContext.addListener((EventListener)logbackServletContextListener);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   boolean isDisabledByConfiguration(ServletContext paramServletContext) {
/* 45 */     String str1 = null;
/* 46 */     String str2 = paramServletContext.getInitParameter("logbackDisableServletContainerInitializer");
/* 47 */     if (str2 instanceof String) {
/* 48 */       str1 = str2;
/*    */     }
/*    */     
/* 51 */     if (OptionHelper.isEmpty(str1)) {
/* 52 */       str1 = OptionHelper.getSystemProperty("logbackDisableServletContainerInitializer");
/*    */     }
/*    */     
/* 55 */     if (OptionHelper.isEmpty(str1)) {
/* 56 */       str1 = OptionHelper.getEnv("logbackDisableServletContainerInitializer");
/*    */     }
/*    */     
/* 59 */     if (OptionHelper.isEmpty(str1)) {
/* 60 */       return false;
/*    */     }
/* 62 */     return str1.equalsIgnoreCase("true");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\servlet\LogbackServletContainerInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */