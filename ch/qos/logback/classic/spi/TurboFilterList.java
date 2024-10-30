/*    */ package ch.qos.logback.classic.spi;
/*    */ 
/*    */ import ch.qos.logback.classic.Level;
/*    */ import ch.qos.logback.classic.Logger;
/*    */ import ch.qos.logback.classic.turbo.TurboFilter;
/*    */ import ch.qos.logback.core.spi.FilterReply;
/*    */ import java.util.concurrent.CopyOnWriteArrayList;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class TurboFilterList
/*    */   extends CopyOnWriteArrayList<TurboFilter>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public FilterReply getTurboFilterChainDecision(Marker paramMarker, Logger paramLogger, Level paramLevel, String paramString, Object[] paramArrayOfObject, Throwable paramThrowable) {
/* 42 */     int i = size();
/*    */ 
/*    */ 
/*    */     
/* 46 */     if (i == 1) {
/*    */       try {
/* 48 */         TurboFilter turboFilter = get(0);
/* 49 */         return turboFilter.decide(paramMarker, paramLogger, paramLevel, paramString, paramArrayOfObject, paramThrowable);
/* 50 */       } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
/* 51 */         return FilterReply.NEUTRAL;
/*    */       } 
/*    */     }
/*    */     
/* 55 */     Object[] arrayOfObject = toArray();
/* 56 */     int j = arrayOfObject.length;
/* 57 */     for (byte b = 0; b < j; b++) {
/*    */       
/* 59 */       TurboFilter turboFilter = (TurboFilter)arrayOfObject[b];
/* 60 */       FilterReply filterReply = turboFilter.decide(paramMarker, paramLogger, paramLevel, paramString, paramArrayOfObject, paramThrowable);
/* 61 */       if (filterReply == FilterReply.DENY || filterReply == FilterReply.ACCEPT) {
/* 62 */         return filterReply;
/*    */       }
/*    */     } 
/* 65 */     return FilterReply.NEUTRAL;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\spi\TurboFilterList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */