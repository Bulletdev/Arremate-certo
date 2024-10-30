/*    */ package ch.qos.logback.classic.layout;
/*    */ 
/*    */ import ch.qos.logback.classic.pattern.ThrowableProxyConverter;
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*    */ import ch.qos.logback.classic.spi.IThrowableProxy;
/*    */ import ch.qos.logback.core.CoreConstants;
/*    */ import ch.qos.logback.core.LayoutBase;
/*    */ import ch.qos.logback.core.util.CachingDateFormatter;
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
/*    */ public class TTLLLayout
/*    */   extends LayoutBase<ILoggingEvent>
/*    */ {
/* 25 */   CachingDateFormatter cachingDateFormatter = new CachingDateFormatter("HH:mm:ss.SSS");
/* 26 */   ThrowableProxyConverter tpc = new ThrowableProxyConverter();
/*    */ 
/*    */   
/*    */   public void start() {
/* 30 */     this.tpc.start();
/* 31 */     super.start();
/*    */   }
/*    */ 
/*    */   
/*    */   public String doLayout(ILoggingEvent paramILoggingEvent) {
/* 36 */     if (!isStarted()) {
/* 37 */       return "";
/*    */     }
/* 39 */     StringBuilder stringBuilder = new StringBuilder();
/*    */     
/* 41 */     long l = paramILoggingEvent.getTimeStamp();
/*    */     
/* 43 */     stringBuilder.append(this.cachingDateFormatter.format(l));
/* 44 */     stringBuilder.append(" [");
/* 45 */     stringBuilder.append(paramILoggingEvent.getThreadName());
/* 46 */     stringBuilder.append("] ");
/* 47 */     stringBuilder.append(paramILoggingEvent.getLevel().toString());
/* 48 */     stringBuilder.append(" ");
/* 49 */     stringBuilder.append(paramILoggingEvent.getLoggerName());
/* 50 */     stringBuilder.append(" - ");
/* 51 */     stringBuilder.append(paramILoggingEvent.getFormattedMessage());
/* 52 */     stringBuilder.append(CoreConstants.LINE_SEPARATOR);
/* 53 */     IThrowableProxy iThrowableProxy = paramILoggingEvent.getThrowableProxy();
/* 54 */     if (iThrowableProxy != null) {
/* 55 */       String str = this.tpc.convert(paramILoggingEvent);
/* 56 */       stringBuilder.append(str);
/*    */     } 
/* 58 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\layout\TTLLLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */