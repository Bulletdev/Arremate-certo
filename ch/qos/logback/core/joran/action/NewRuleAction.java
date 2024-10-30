/*    */ package ch.qos.logback.core.joran.action;
/*    */ 
/*    */ import ch.qos.logback.core.joran.spi.ElementSelector;
/*    */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*    */ import ch.qos.logback.core.util.OptionHelper;
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
/*    */ public class NewRuleAction
/*    */   extends Action
/*    */ {
/*    */   boolean inError = false;
/*    */   
/*    */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) {
/* 30 */     this.inError = false;
/*    */     
/* 32 */     String str1 = paramAttributes.getValue("pattern");
/* 33 */     String str2 = paramAttributes.getValue("actionClass");
/*    */     
/* 35 */     if (OptionHelper.isEmpty(str1)) {
/* 36 */       this.inError = true;
/* 37 */       String str = "No 'pattern' attribute in <newRule>";
/* 38 */       addError(str);
/*    */       
/*    */       return;
/*    */     } 
/* 42 */     if (OptionHelper.isEmpty(str2)) {
/* 43 */       this.inError = true;
/* 44 */       String str = "No 'actionClass' attribute in <newRule>";
/* 45 */       addError(str);
/*    */       
/*    */       return;
/*    */     } 
/*    */     try {
/* 50 */       addInfo("About to add new Joran parsing rule [" + str1 + "," + str2 + "].");
/* 51 */       paramInterpretationContext.getJoranInterpreter().getRuleStore().addRule(new ElementSelector(str1), str2);
/* 52 */     } catch (Exception exception) {
/* 53 */       this.inError = true;
/* 54 */       String str = "Could not add new Joran parsing rule [" + str1 + "," + str2 + "]";
/* 55 */       addError(str);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void end(InterpretationContext paramInterpretationContext, String paramString) {}
/*    */   
/*    */   public void finish(InterpretationContext paramInterpretationContext) {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\action\NewRuleAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */