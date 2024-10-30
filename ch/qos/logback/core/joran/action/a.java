/*    */ package ch.qos.logback.core.joran.action;
/*    */ 
/*    */ import ch.qos.logback.core.joran.util.PropertySetter;
/*    */ import ch.qos.logback.core.util.AggregationType;
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
/*    */ class a
/*    */ {
/*    */   final PropertySetter parentBean;
/*    */   final AggregationType aggregationType;
/*    */   final String propertyName;
/*    */   boolean inError;
/*    */   
/*    */   a(PropertySetter paramPropertySetter, AggregationType paramAggregationType, String paramString) {
/* 31 */     this.parentBean = paramPropertySetter;
/* 32 */     this.aggregationType = paramAggregationType;
/* 33 */     this.propertyName = paramString;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\action\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */