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
/*    */ public class RelativeTimeConverter
/*    */   extends ClassicConverter
/*    */ {
/* 20 */   long lastTimestamp = -1L;
/* 21 */   String timesmapCache = null;
/*    */   
/*    */   public String convert(ILoggingEvent paramILoggingEvent) {
/* 24 */     long l = paramILoggingEvent.getTimeStamp();
/*    */     
/* 26 */     synchronized (this) {
/*    */       
/* 28 */       if (l != this.lastTimestamp) {
/* 29 */         this.lastTimestamp = l;
/* 30 */         this.timesmapCache = Long.toString(l - paramILoggingEvent.getLoggerContextVO().getBirthTime());
/*    */       } 
/* 32 */       return this.timesmapCache;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\pattern\RelativeTimeConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */