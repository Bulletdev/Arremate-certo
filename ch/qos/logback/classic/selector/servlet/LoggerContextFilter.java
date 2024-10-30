/*    */ package ch.qos.logback.classic.selector.servlet;
/*    */ 
/*    */ import ch.qos.logback.classic.LoggerContext;
/*    */ import ch.qos.logback.classic.selector.ContextJNDISelector;
/*    */ import ch.qos.logback.classic.selector.ContextSelector;
/*    */ import ch.qos.logback.classic.util.ContextSelectorStaticBinder;
/*    */ import java.io.IOException;
/*    */ import javax.servlet.Filter;
/*    */ import javax.servlet.FilterChain;
/*    */ import javax.servlet.FilterConfig;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import org.slf4j.LoggerFactory;
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
/*    */ public class LoggerContextFilter
/*    */   implements Filter
/*    */ {
/*    */   public void destroy() {}
/*    */   
/*    */   public void doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse, FilterChain paramFilterChain) throws IOException, ServletException {
/* 59 */     LoggerContext loggerContext = (LoggerContext)LoggerFactory.getILoggerFactory();
/* 60 */     ContextSelector contextSelector = ContextSelectorStaticBinder.getSingleton().getContextSelector();
/* 61 */     ContextJNDISelector contextJNDISelector = null;
/*    */     
/* 63 */     if (contextSelector instanceof ContextJNDISelector) {
/* 64 */       contextJNDISelector = (ContextJNDISelector)contextSelector;
/* 65 */       contextJNDISelector.setLocalContext(loggerContext);
/*    */     } 
/*    */     
/*    */     try {
/* 69 */       paramFilterChain.doFilter(paramServletRequest, paramServletResponse);
/*    */     } finally {
/* 71 */       if (contextJNDISelector != null)
/* 72 */         contextJNDISelector.removeLocalContext(); 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void init(FilterConfig paramFilterConfig) throws ServletException {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\selector\servlet\LoggerContextFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */