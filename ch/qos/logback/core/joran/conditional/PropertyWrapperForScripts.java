/*    */ package ch.qos.logback.core.joran.conditional;
/*    */ 
/*    */ import ch.qos.logback.core.spi.PropertyContainer;
/*    */ import ch.qos.logback.core.util.OptionHelper;
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
/*    */ public class PropertyWrapperForScripts
/*    */ {
/*    */   PropertyContainer local;
/*    */   PropertyContainer context;
/*    */   
/*    */   public void setPropertyContainers(PropertyContainer paramPropertyContainer1, PropertyContainer paramPropertyContainer2) {
/* 26 */     this.local = paramPropertyContainer1;
/* 27 */     this.context = paramPropertyContainer2;
/*    */   }
/*    */   
/*    */   public boolean isNull(String paramString) {
/* 31 */     String str = OptionHelper.propertyLookup(paramString, this.local, this.context);
/* 32 */     return (str == null);
/*    */   }
/*    */   
/*    */   public boolean isDefined(String paramString) {
/* 36 */     String str = OptionHelper.propertyLookup(paramString, this.local, this.context);
/* 37 */     return (str != null);
/*    */   }
/*    */   
/*    */   public String p(String paramString) {
/* 41 */     return property(paramString);
/*    */   }
/*    */   
/*    */   public String property(String paramString) {
/* 45 */     String str = OptionHelper.propertyLookup(paramString, this.local, this.context);
/* 46 */     if (str != null) {
/* 47 */       return str;
/*    */     }
/* 49 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\conditional\PropertyWrapperForScripts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */