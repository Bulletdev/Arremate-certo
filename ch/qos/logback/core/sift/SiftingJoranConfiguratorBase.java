/*    */ package ch.qos.logback.core.sift;
/*    */ 
/*    */ import ch.qos.logback.core.Appender;
/*    */ import ch.qos.logback.core.joran.GenericConfigurator;
/*    */ import ch.qos.logback.core.joran.action.Action;
/*    */ import ch.qos.logback.core.joran.action.DefinePropertyAction;
/*    */ import ch.qos.logback.core.joran.action.ImplicitAction;
/*    */ import ch.qos.logback.core.joran.action.NestedBasicPropertyIA;
/*    */ import ch.qos.logback.core.joran.action.NestedComplexPropertyIA;
/*    */ import ch.qos.logback.core.joran.action.PropertyAction;
/*    */ import ch.qos.logback.core.joran.action.TimestampAction;
/*    */ import ch.qos.logback.core.joran.event.SaxEvent;
/*    */ import ch.qos.logback.core.joran.spi.ElementSelector;
/*    */ import ch.qos.logback.core.joran.spi.Interpreter;
/*    */ import ch.qos.logback.core.joran.spi.JoranException;
/*    */ import ch.qos.logback.core.joran.spi.RuleStore;
/*    */ import java.util.List;
/*    */ import java.util.Map;
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
/*    */ public abstract class SiftingJoranConfiguratorBase<E>
/*    */   extends GenericConfigurator
/*    */ {
/*    */   protected final String key;
/*    */   protected final String value;
/*    */   protected final Map<String, String> parentPropertyMap;
/*    */   static final String ONE_AND_ONLY_ONE_URL = "http://logback.qos.ch/codes.html#1andOnly1";
/*    */   int errorEmmissionCount;
/*    */   
/*    */   protected void addImplicitRules(Interpreter paramInterpreter) {
/*    */     NestedComplexPropertyIA nestedComplexPropertyIA = new NestedComplexPropertyIA(getBeanDescriptionCache());
/*    */     nestedComplexPropertyIA.setContext(this.context);
/*    */     paramInterpreter.addImplicitAction((ImplicitAction)nestedComplexPropertyIA);
/*    */     NestedBasicPropertyIA nestedBasicPropertyIA = new NestedBasicPropertyIA(getBeanDescriptionCache());
/*    */     nestedBasicPropertyIA.setContext(this.context);
/*    */     paramInterpreter.addImplicitAction((ImplicitAction)nestedBasicPropertyIA);
/*    */   }
/*    */   
/*    */   protected SiftingJoranConfiguratorBase(String paramString1, String paramString2, Map<String, String> paramMap) {
/* 64 */     this.errorEmmissionCount = 0;
/*    */     this.key = paramString1;
/*    */     this.value = paramString2;
/* 67 */     this.parentPropertyMap = paramMap; } protected void oneAndOnlyOneCheck(Map<?, ?> paramMap) { String str = null;
/* 68 */     if (paramMap.size() == 0) {
/* 69 */       this.errorEmmissionCount++;
/* 70 */       str = "No nested appenders found within the <sift> element in SiftingAppender.";
/* 71 */     } else if (paramMap.size() > 1) {
/* 72 */       this.errorEmmissionCount++;
/* 73 */       str = "Only and only one appender can be nested the <sift> element in SiftingAppender. See also http://logback.qos.ch/codes.html#1andOnly1";
/*    */     } 
/*    */     
/* 76 */     if (str != null && this.errorEmmissionCount < 4) {
/* 77 */       addError(str);
/*    */     } }
/*    */ 
/*    */   
/*    */   public void doConfigure(List<SaxEvent> paramList) throws JoranException {
/* 82 */     super.doConfigure(paramList); } protected void addInstanceRules(RuleStore paramRuleStore) {
/*    */     paramRuleStore.addRule(new ElementSelector("configuration/property"), (Action)new PropertyAction());
/*    */     paramRuleStore.addRule(new ElementSelector("configuration/timestamp"), (Action)new TimestampAction());
/*    */     paramRuleStore.addRule(new ElementSelector("configuration/define"), (Action)new DefinePropertyAction());
/*    */   } public abstract Appender<E> getAppender(); public String toString() {
/* 87 */     return getClass().getName() + "{" + this.key + "=" + this.value + '}';
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\sift\SiftingJoranConfiguratorBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */