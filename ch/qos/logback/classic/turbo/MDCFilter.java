/*    */ package ch.qos.logback.classic.turbo;
/*    */ 
/*    */ import ch.qos.logback.classic.Level;
/*    */ import ch.qos.logback.classic.Logger;
/*    */ import ch.qos.logback.core.spi.FilterReply;
/*    */ import org.slf4j.MDC;
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
/*    */ public class MDCFilter
/*    */   extends MatchingFilter
/*    */ {
/*    */   String MDCKey;
/*    */   String value;
/*    */   
/*    */   public FilterReply decide(Marker paramMarker, Logger paramLogger, Level paramLevel, String paramString, Object[] paramArrayOfObject, Throwable paramThrowable) {
/* 53 */     if (this.MDCKey == null) {
/* 54 */       return FilterReply.NEUTRAL;
/*    */     }
/*    */     
/* 57 */     String str = MDC.get(this.MDCKey);
/* 58 */     if (this.value.equals(str)) {
/* 59 */       return this.onMatch;
/*    */     }
/* 61 */     return this.onMismatch;
/*    */   }
/*    */   
/*    */   public void setValue(String paramString) {
/* 65 */     this.value = paramString;
/*    */   }
/*    */   
/*    */   public void setMDCKey(String paramString) {
/* 69 */     this.MDCKey = paramString;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\turbo\MDCFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */