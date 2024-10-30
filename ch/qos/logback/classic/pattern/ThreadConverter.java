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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ThreadConverter
/*    */   extends ClassicConverter
/*    */ {
/*    */   public String convert(ILoggingEvent paramILoggingEvent) {
/* 26 */     return paramILoggingEvent.getThreadName();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\pattern\ThreadConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */