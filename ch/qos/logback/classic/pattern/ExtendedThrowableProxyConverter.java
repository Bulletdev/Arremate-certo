/*    */ package ch.qos.logback.classic.pattern;
/*    */ 
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*    */ import ch.qos.logback.classic.spi.StackTraceElementProxy;
/*    */ import ch.qos.logback.classic.spi.ThrowableProxyUtil;
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
/*    */ public class ExtendedThrowableProxyConverter
/*    */   extends ThrowableProxyConverter
/*    */ {
/*    */   protected void extraData(StringBuilder paramStringBuilder, StackTraceElementProxy paramStackTraceElementProxy) {
/* 24 */     ThrowableProxyUtil.subjoinPackagingData(paramStringBuilder, paramStackTraceElementProxy);
/*    */   }
/*    */   
/*    */   protected void prepareLoggingEvent(ILoggingEvent paramILoggingEvent) {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\pattern\ExtendedThrowableProxyConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */