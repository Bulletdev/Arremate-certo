/*    */ package ch.qos.logback.classic.pattern;
/*    */ 
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*    */ import ch.qos.logback.core.util.CachingDateFormatter;
/*    */ import java.util.List;
/*    */ import java.util.TimeZone;
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
/*    */ public class DateConverter
/*    */   extends ClassicConverter
/*    */ {
/* 25 */   long lastTimestamp = -1L;
/* 26 */   String timestampStrCache = null;
/* 27 */   CachingDateFormatter cachingDateFormatter = null;
/*    */ 
/*    */   
/*    */   public void start() {
/* 31 */     String str = getFirstOption();
/* 32 */     if (str == null) {
/* 33 */       str = "yyyy-MM-dd HH:mm:ss,SSS";
/*    */     }
/*    */     
/* 36 */     if (str.equals("ISO8601")) {
/* 37 */       str = "yyyy-MM-dd HH:mm:ss,SSS";
/*    */     }
/*    */     
/*    */     try {
/* 41 */       this.cachingDateFormatter = new CachingDateFormatter(str);
/*    */     
/*    */     }
/* 44 */     catch (IllegalArgumentException illegalArgumentException) {
/* 45 */       addWarn("Could not instantiate SimpleDateFormat with pattern " + str, illegalArgumentException);
/*    */       
/* 47 */       this.cachingDateFormatter = new CachingDateFormatter("yyyy-MM-dd HH:mm:ss,SSS");
/*    */     } 
/*    */     
/* 50 */     List<String> list = getOptionList();
/*    */ 
/*    */     
/* 53 */     if (list != null && list.size() > 1) {
/* 54 */       TimeZone timeZone = TimeZone.getTimeZone(list.get(1));
/* 55 */       this.cachingDateFormatter.setTimeZone(timeZone);
/*    */     } 
/*    */   }
/*    */   
/*    */   public String convert(ILoggingEvent paramILoggingEvent) {
/* 60 */     long l = paramILoggingEvent.getTimeStamp();
/* 61 */     return this.cachingDateFormatter.format(l);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\pattern\DateConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */