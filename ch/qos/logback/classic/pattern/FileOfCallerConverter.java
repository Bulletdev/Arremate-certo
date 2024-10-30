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
/*    */ public class FileOfCallerConverter
/*    */   extends ClassicConverter
/*    */ {
/*    */   public String convert(ILoggingEvent paramILoggingEvent) {
/* 22 */     StackTraceElement[] arrayOfStackTraceElement = paramILoggingEvent.getCallerData();
/* 23 */     if (arrayOfStackTraceElement != null && arrayOfStackTraceElement.length > 0) {
/* 24 */       return arrayOfStackTraceElement[0].getFileName();
/*    */     }
/* 26 */     return "?";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\pattern\FileOfCallerConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */