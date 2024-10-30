/*    */ package ch.qos.logback.classic.html;
/*    */ 
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*    */ import ch.qos.logback.classic.spi.IThrowableProxy;
/*    */ import ch.qos.logback.classic.spi.StackTraceElementProxy;
/*    */ import ch.qos.logback.core.CoreConstants;
/*    */ import ch.qos.logback.core.helpers.Transform;
/*    */ import ch.qos.logback.core.html.IThrowableRenderer;
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
/*    */ public class DefaultThrowableRenderer
/*    */   implements IThrowableRenderer<ILoggingEvent>
/*    */ {
/*    */   static final String TRACE_PREFIX = "<br />&nbsp;&nbsp;&nbsp;&nbsp;";
/*    */   
/*    */   public void render(StringBuilder paramStringBuilder, ILoggingEvent paramILoggingEvent) {
/* 28 */     IThrowableProxy iThrowableProxy = paramILoggingEvent.getThrowableProxy();
/* 29 */     paramStringBuilder.append("<tr><td class=\"Exception\" colspan=\"6\">");
/* 30 */     while (iThrowableProxy != null) {
/* 31 */       render(paramStringBuilder, iThrowableProxy);
/* 32 */       iThrowableProxy = iThrowableProxy.getCause();
/*    */     } 
/* 34 */     paramStringBuilder.append("</td></tr>");
/*    */   }
/*    */   
/*    */   void render(StringBuilder paramStringBuilder, IThrowableProxy paramIThrowableProxy) {
/* 38 */     printFirstLine(paramStringBuilder, paramIThrowableProxy);
/*    */     
/* 40 */     int i = paramIThrowableProxy.getCommonFrames();
/* 41 */     StackTraceElementProxy[] arrayOfStackTraceElementProxy = paramIThrowableProxy.getStackTraceElementProxyArray();
/*    */     
/* 43 */     for (byte b = 0; b < arrayOfStackTraceElementProxy.length - i; b++) {
/* 44 */       StackTraceElementProxy stackTraceElementProxy = arrayOfStackTraceElementProxy[b];
/* 45 */       paramStringBuilder.append("<br />&nbsp;&nbsp;&nbsp;&nbsp;");
/* 46 */       paramStringBuilder.append(Transform.escapeTags(stackTraceElementProxy.toString()));
/* 47 */       paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*    */     } 
/*    */     
/* 50 */     if (i > 0) {
/* 51 */       paramStringBuilder.append("<br />&nbsp;&nbsp;&nbsp;&nbsp;");
/* 52 */       paramStringBuilder.append("\t... ").append(i).append(" common frames omitted").append(CoreConstants.LINE_SEPARATOR);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void printFirstLine(StringBuilder paramStringBuilder, IThrowableProxy paramIThrowableProxy) {
/* 57 */     int i = paramIThrowableProxy.getCommonFrames();
/* 58 */     if (i > 0) {
/* 59 */       paramStringBuilder.append("<br />").append("Caused by: ");
/*    */     }
/* 61 */     paramStringBuilder.append(paramIThrowableProxy.getClassName()).append(": ").append(Transform.escapeTags(paramIThrowableProxy.getMessage()));
/* 62 */     paramStringBuilder.append(CoreConstants.LINE_SEPARATOR);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\html\DefaultThrowableRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */