/*    */ package ch.qos.logback.classic.turbo;
/*    */ 
/*    */ import ch.qos.logback.classic.Level;
/*    */ import ch.qos.logback.classic.Logger;
/*    */ import ch.qos.logback.core.spi.FilterReply;
/*    */ import org.slf4j.Marker;
/*    */ import org.slf4j.MarkerFactory;
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
/*    */ public class MarkerFilter
/*    */   extends MatchingFilter
/*    */ {
/*    */   Marker markerToMatch;
/*    */   
/*    */   public void start() {
/* 33 */     if (this.markerToMatch != null) {
/* 34 */       super.start();
/*    */     } else {
/* 36 */       addError("The marker property must be set for [" + getName() + "]");
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public FilterReply decide(Marker paramMarker, Logger paramLogger, Level paramLevel, String paramString, Object[] paramArrayOfObject, Throwable paramThrowable) {
/* 42 */     if (!isStarted()) {
/* 43 */       return FilterReply.NEUTRAL;
/*    */     }
/*    */     
/* 46 */     if (paramMarker == null) {
/* 47 */       return this.onMismatch;
/*    */     }
/*    */     
/* 50 */     if (paramMarker.contains(this.markerToMatch)) {
/* 51 */       return this.onMatch;
/*    */     }
/* 53 */     return this.onMismatch;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setMarker(String paramString) {
/* 63 */     if (paramString != null)
/* 64 */       this.markerToMatch = MarkerFactory.getMarker(paramString); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\turbo\MarkerFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */