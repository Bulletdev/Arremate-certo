/*    */ package ch.qos.logback.classic.pattern;
/*    */ 
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*    */ import ch.qos.logback.classic.spi.LoggerContextVO;
/*    */ import java.util.Map;
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
/*    */ public final class PropertyConverter
/*    */   extends ClassicConverter
/*    */ {
/*    */   String key;
/*    */   
/*    */   public void start() {
/* 26 */     String str = getFirstOption();
/* 27 */     if (str != null) {
/* 28 */       this.key = str;
/* 29 */       super.start();
/*    */     } 
/*    */   }
/*    */   
/*    */   public String getKey() {
/* 34 */     return this.key;
/*    */   }
/*    */   
/*    */   public String convert(ILoggingEvent paramILoggingEvent) {
/* 38 */     if (this.key == null) {
/* 39 */       return "Property_HAS_NO_KEY";
/*    */     }
/* 41 */     LoggerContextVO loggerContextVO = paramILoggingEvent.getLoggerContextVO();
/* 42 */     Map map = loggerContextVO.getPropertyMap();
/* 43 */     String str = (String)map.get(this.key);
/* 44 */     if (str != null) {
/* 45 */       return str;
/*    */     }
/* 47 */     return System.getProperty(this.key);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\pattern\PropertyConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */