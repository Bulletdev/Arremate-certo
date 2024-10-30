/*    */ package ch.qos.logback.classic;
/*    */ 
/*    */ import ch.qos.logback.core.status.StatusManager;
/*    */ import ch.qos.logback.core.status.ViewStatusMessagesServletBase;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
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
/*    */ public class ViewStatusMessagesServlet
/*    */   extends ViewStatusMessagesServletBase
/*    */ {
/*    */   private static final long serialVersionUID = 443878494348593337L;
/*    */   
/*    */   protected StatusManager getStatusManager(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) {
/* 30 */     LoggerContext loggerContext = (LoggerContext)LoggerFactory.getILoggerFactory();
/* 31 */     return loggerContext.getStatusManager();
/*    */   }
/*    */ 
/*    */   
/*    */   protected String getPageTitle(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) {
/* 36 */     LoggerContext loggerContext = (LoggerContext)LoggerFactory.getILoggerFactory();
/* 37 */     return "<h2>Status messages for LoggerContext named [" + loggerContext.getName() + "]</h2>\r\n";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\ViewStatusMessagesServlet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */