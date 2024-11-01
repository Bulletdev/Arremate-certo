/*    */ package ch.qos.logback.classic.pattern;
/*    */ 
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
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
/*    */ public class LineOfCallerConverter
/*    */   extends ClassicConverter
/*    */ {
/*    */   public String convert(ILoggingEvent paramILoggingEvent) {
/* 22 */     StackTraceElement[] arrayOfStackTraceElement = paramILoggingEvent.getCallerData();
/* 23 */     if (arrayOfStackTraceElement != null && arrayOfStackTraceElement.length > 0) {
/* 24 */       return Integer.toString(arrayOfStackTraceElement[0].getLineNumber());
/*    */     }
/* 26 */     return "?";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\pattern\LineOfCallerConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */