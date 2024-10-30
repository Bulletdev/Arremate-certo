/*    */ package ch.qos.logback.classic.net.server;
/*    */ 
/*    */ import ch.qos.logback.classic.net.LoggingEventPreSerializationTransformer;
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*    */ import ch.qos.logback.core.net.server.SSLServerSocketAppenderBase;
/*    */ import ch.qos.logback.core.spi.PreSerializationTransformer;
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
/*    */ public class SSLServerSocketAppender
/*    */   extends SSLServerSocketAppenderBase<ILoggingEvent>
/*    */ {
/* 28 */   private static final PreSerializationTransformer<ILoggingEvent> pst = (PreSerializationTransformer<ILoggingEvent>)new LoggingEventPreSerializationTransformer();
/*    */   
/*    */   private boolean includeCallerData;
/*    */ 
/*    */   
/*    */   protected void postProcessEvent(ILoggingEvent paramILoggingEvent) {
/* 34 */     if (isIncludeCallerData()) {
/* 35 */       paramILoggingEvent.getCallerData();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected PreSerializationTransformer<ILoggingEvent> getPST() {
/* 41 */     return pst;
/*    */   }
/*    */   
/*    */   public boolean isIncludeCallerData() {
/* 45 */     return this.includeCallerData;
/*    */   }
/*    */   
/*    */   public void setIncludeCallerData(boolean paramBoolean) {
/* 49 */     this.includeCallerData = paramBoolean;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\net\server\SSLServerSocketAppender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */