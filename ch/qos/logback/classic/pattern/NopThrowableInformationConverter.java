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
/*    */ public class NopThrowableInformationConverter
/*    */   extends ThrowableHandlingConverter
/*    */ {
/*    */   public String convert(ILoggingEvent paramILoggingEvent) {
/* 38 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\pattern\NopThrowableInformationConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */