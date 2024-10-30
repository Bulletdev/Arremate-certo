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
/*    */ public class IADataForComplexProperty
/*    */ {
/*    */   final PropertySetter parentBean;
/*    */   final AggregationType aggregationType;
/*    */   final String complexPropertyName;
/*    */   private Object nestedComplexProperty;
/*    */   boolean inError;
/*    */   
/*    */   public IADataForComplexProperty(PropertySetter paramPropertySetter, AggregationType paramAggregationType, String paramString) {
/* 32 */     this.parentBean = paramPropertySetter;
/* 33 */     this.aggregationType = paramAggregationType;
/* 34 */     this.complexPropertyName = paramString;
/*    */   }
/*    */   
/*    */   public AggregationType getAggregationType() {
/* 38 */     return this.aggregationType;
/*    */   }
/*    */   
/*    */   public Object getNestedComplexProperty() {
/* 42 */     return this.nestedComplexProperty;
/*    */   }
/*    */   
/*    */   public String getComplexPropertyName() {
/* 46 */     return this.complexPropertyName;
/*    */   }
/*    */   
/*    */   public void setNestedComplexProperty(Object paramObject) {
/* 50 */     this.nestedComplexProperty = paramObject;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\action\IADataForComplexProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */