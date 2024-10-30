/*    */ package ch.qos.logback.core.joran.action;
/*    */ 
/*    */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*    */ import ch.qos.logback.core.util.OptionHelper;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConversionRuleAction
/*    */   extends Action
/*    */ {
/*    */   boolean inError = false;
/*    */   
/*    */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) {
/* 35 */     this.inError = false;
/*    */ 
/*    */     
/* 38 */     String str1 = paramAttributes.getValue("conversionWord");
/* 39 */     String str2 = paramAttributes.getValue("converterClass");
/*    */     
/* 41 */     if (OptionHelper.isEmpty(str1)) {
/* 42 */       this.inError = true;
/* 43 */       String str = "No 'conversionWord' attribute in <conversionRule>";
/* 44 */       addError(str);
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 49 */     if (OptionHelper.isEmpty(str2)) {
/* 50 */       this.inError = true;
/* 51 */       String str = "No 'converterClass' attribute in <conversionRule>";
/* 52 */       paramInterpretationContext.addError(str);
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/*    */     try {
/* 58 */       Map<Object, Object> map = (Map)this.context.getObject("PATTERN_RULE_REGISTRY");
/* 59 */       if (map == null) {
/* 60 */         map = new HashMap<Object, Object>();
/* 61 */         this.context.putObject("PATTERN_RULE_REGISTRY", map);
/*    */       } 
/*    */       
/* 64 */       addInfo("registering conversion word " + str1 + " with class [" + str2 + "]");
/* 65 */       map.put(str1, str2);
/* 66 */     } catch (Exception exception) {
/* 67 */       this.inError = true;
/* 68 */       String str = "Could not add conversion rule to PatternLayout.";
/* 69 */       addError(str);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void end(InterpretationContext paramInterpretationContext, String paramString) {}
/*    */   
/*    */   public void finish(InterpretationContext paramInterpretationContext) {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\action\ConversionRuleAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */