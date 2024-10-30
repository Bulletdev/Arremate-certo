/*    */ package ch.qos.logback.classic.pattern.color;
/*    */ 
/*    */ import ch.qos.logback.classic.Level;
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*    */ import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;
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
/*    */ public class HighlightingCompositeConverter
/*    */   extends ForegroundCompositeConverterBase<ILoggingEvent>
/*    */ {
/*    */   protected String getForegroundColorCode(ILoggingEvent paramILoggingEvent) {
/* 29 */     Level level = paramILoggingEvent.getLevel();
/* 30 */     switch (level.toInt()) {
/*    */       case 40000:
/* 32 */         return "1;31";
/*    */       case 30000:
/* 34 */         return "31";
/*    */       case 20000:
/* 36 */         return "34";
/*    */     } 
/* 38 */     return "39";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\pattern\color\HighlightingCompositeConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */