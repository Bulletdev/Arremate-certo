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
/*    */ 
/*    */ public class ClassOfCallerConverter
/*    */   extends NamedConverter
/*    */ {
/*    */   protected String getFullyQualifiedName(ILoggingEvent paramILoggingEvent) {
/* 23 */     StackTraceElement[] arrayOfStackTraceElement = paramILoggingEvent.getCallerData();
/* 24 */     if (arrayOfStackTraceElement != null && arrayOfStackTraceElement.length > 0) {
/* 25 */       return arrayOfStackTraceElement[0].getClassName();
/*    */     }
/* 27 */     return "?";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\pattern\ClassOfCallerConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */