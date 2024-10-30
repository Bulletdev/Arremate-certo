/*    */ package ch.qos.logback.classic.sift;
/*    */ 
/*    */ import ch.qos.logback.classic.ClassicConstants;
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*    */ import ch.qos.logback.core.joran.spi.DefaultClass;
/*    */ import ch.qos.logback.core.sift.Discriminator;
/*    */ import ch.qos.logback.core.sift.SiftingAppenderBase;
/*    */ import org.slf4j.Marker;
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
/*    */ public class SiftingAppender
/*    */   extends SiftingAppenderBase<ILoggingEvent>
/*    */ {
/*    */   protected long getTimestamp(ILoggingEvent paramILoggingEvent) {
/* 37 */     return paramILoggingEvent.getTimeStamp();
/*    */   }
/*    */ 
/*    */   
/*    */   @DefaultClass(MDCBasedDiscriminator.class)
/*    */   public void setDiscriminator(Discriminator<ILoggingEvent> paramDiscriminator) {
/* 43 */     super.setDiscriminator(paramDiscriminator);
/*    */   }
/*    */   
/*    */   protected boolean eventMarksEndOfLife(ILoggingEvent paramILoggingEvent) {
/* 47 */     Marker marker = paramILoggingEvent.getMarker();
/* 48 */     if (marker == null) {
/* 49 */       return false;
/*    */     }
/* 51 */     return marker.contains(ClassicConstants.FINALIZE_SESSION_MARKER);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\sift\SiftingAppender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */