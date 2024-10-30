/*    */ package ch.qos.logback.classic.boolex;
/*    */ 
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*    */ import ch.qos.logback.core.boolex.EvaluationException;
/*    */ import ch.qos.logback.core.boolex.EventEvaluatorBase;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public class OnMarkerEvaluator
/*    */   extends EventEvaluatorBase<ILoggingEvent>
/*    */ {
/* 33 */   List<String> markerList = new ArrayList<String>();
/*    */   
/*    */   public void addMarker(String paramString) {
/* 36 */     this.markerList.add(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean evaluate(ILoggingEvent paramILoggingEvent) throws NullPointerException, EvaluationException {
/* 45 */     Marker marker = paramILoggingEvent.getMarker();
/* 46 */     if (marker == null) {
/* 47 */       return false;
/*    */     }
/*    */     
/* 50 */     for (String str : this.markerList) {
/* 51 */       if (marker.contains(str)) {
/* 52 */         return true;
/*    */       }
/*    */     } 
/* 55 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\boolex\OnMarkerEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */