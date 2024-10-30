/*    */ package ch.qos.logback.classic.net;
/*    */ 
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*    */ import ch.qos.logback.classic.spi.LoggingEventVO;
/*    */ import ch.qos.logback.core.spi.PreSerializationTransformer;
/*    */ import java.io.Serializable;
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
/*    */ public class LoggingEventPreSerializationTransformer
/*    */   implements PreSerializationTransformer<ILoggingEvent>
/*    */ {
/*    */   public Serializable transform(ILoggingEvent paramILoggingEvent) {
/* 26 */     if (paramILoggingEvent == null) {
/* 27 */       return null;
/*    */     }
/* 29 */     if (paramILoggingEvent instanceof ch.qos.logback.classic.spi.LoggingEvent)
/* 30 */       return (Serializable)LoggingEventVO.build(paramILoggingEvent); 
/* 31 */     if (paramILoggingEvent instanceof LoggingEventVO) {
/* 32 */       return (Serializable)paramILoggingEvent;
/*    */     }
/* 34 */     throw new IllegalArgumentException("Unsupported type " + paramILoggingEvent.getClass().getName());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\net\LoggingEventPreSerializationTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */