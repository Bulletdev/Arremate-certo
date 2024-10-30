/*    */ package ch.qos.logback.core.joran.action;
/*    */ 
/*    */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*    */ import ch.qos.logback.core.joran.util.PropertySetter;
/*    */ import ch.qos.logback.core.joran.util.beans.BeanDescriptionCache;
/*    */ import org.xml.sax.Attributes;
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
/*    */ public class ParamAction
/*    */   extends Action
/*    */ {
/* 23 */   static String NO_NAME = "No name attribute in <param> element";
/* 24 */   static String NO_VALUE = "No value attribute in <param> element";
/*    */   boolean inError = false;
/*    */   private final BeanDescriptionCache beanDescriptionCache;
/*    */   
/*    */   public ParamAction(BeanDescriptionCache paramBeanDescriptionCache) {
/* 29 */     this.beanDescriptionCache = paramBeanDescriptionCache;
/*    */   }
/*    */   
/*    */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) {
/* 33 */     String str1 = paramAttributes.getValue("name");
/* 34 */     String str2 = paramAttributes.getValue("value");
/*    */     
/* 36 */     if (str1 == null) {
/* 37 */       this.inError = true;
/* 38 */       addError(NO_NAME);
/*    */       
/*    */       return;
/*    */     } 
/* 42 */     if (str2 == null) {
/* 43 */       this.inError = true;
/* 44 */       addError(NO_VALUE);
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 49 */     str2 = str2.trim();
/*    */     
/* 51 */     Object object = paramInterpretationContext.peekObject();
/* 52 */     PropertySetter propertySetter = new PropertySetter(this.beanDescriptionCache, object);
/* 53 */     propertySetter.setContext(this.context);
/* 54 */     str2 = paramInterpretationContext.subst(str2);
/*    */ 
/*    */     
/* 57 */     str1 = paramInterpretationContext.subst(str1);
/*    */ 
/*    */ 
/*    */     
/* 61 */     propertySetter.setProperty(str1, str2);
/*    */   }
/*    */   
/*    */   public void end(InterpretationContext paramInterpretationContext, String paramString) {}
/*    */   
/*    */   public void finish(InterpretationContext paramInterpretationContext) {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\action\ParamAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */