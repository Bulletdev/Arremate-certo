/*    */ package ch.qos.logback.classic;
/*    */ 
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*    */ import ch.qos.logback.core.AsyncAppenderBase;
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
/*    */ public class AsyncAppender
/*    */   extends AsyncAppenderBase<ILoggingEvent>
/*    */ {
/*    */   boolean includeCallerData = false;
/*    */   
/*    */   protected boolean isDiscardable(ILoggingEvent paramILoggingEvent) {
/* 38 */     Level level = paramILoggingEvent.getLevel();
/* 39 */     return (level.toInt() <= 20000);
/*    */   }
/*    */   
/*    */   protected void preprocess(ILoggingEvent paramILoggingEvent) {
/* 43 */     paramILoggingEvent.prepareForDeferredProcessing();
/* 44 */     if (this.includeCallerData)
/* 45 */       paramILoggingEvent.getCallerData(); 
/*    */   }
/*    */   
/*    */   public boolean isIncludeCallerData() {
/* 49 */     return this.includeCallerData;
/*    */   }
/*    */   
/*    */   public void setIncludeCallerData(boolean paramBoolean) {
/* 53 */     this.includeCallerData = paramBoolean;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\AsyncAppender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */