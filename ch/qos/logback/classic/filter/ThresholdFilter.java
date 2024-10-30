/*    */ package ch.qos.logback.classic.filter;
/*    */ 
/*    */ import ch.qos.logback.classic.Level;
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*    */ import ch.qos.logback.core.filter.Filter;
/*    */ import ch.qos.logback.core.spi.FilterReply;
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
/*    */ public class ThresholdFilter
/*    */   extends Filter<ILoggingEvent>
/*    */ {
/*    */   Level level;
/*    */   
/*    */   public FilterReply decide(ILoggingEvent paramILoggingEvent) {
/* 41 */     if (!isStarted()) {
/* 42 */       return FilterReply.NEUTRAL;
/*    */     }
/*    */     
/* 45 */     if (paramILoggingEvent.getLevel().isGreaterOrEqual(this.level)) {
/* 46 */       return FilterReply.NEUTRAL;
/*    */     }
/* 48 */     return FilterReply.DENY;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setLevel(String paramString) {
/* 53 */     this.level = Level.toLevel(paramString);
/*    */   }
/*    */   
/*    */   public void start() {
/* 57 */     if (this.level != null)
/* 58 */       super.start(); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\filter\ThresholdFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */