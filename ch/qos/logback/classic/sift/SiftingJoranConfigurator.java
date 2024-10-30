/*    */ package ch.qos.logback.classic.sift;
/*    */ 
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*    */ import ch.qos.logback.classic.util.DefaultNestedComponentRules;
/*    */ import ch.qos.logback.core.Appender;
/*    */ import ch.qos.logback.core.joran.action.Action;
/*    */ import ch.qos.logback.core.joran.action.AppenderAction;
/*    */ import ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
/*    */ import ch.qos.logback.core.joran.spi.ElementPath;
/*    */ import ch.qos.logback.core.joran.spi.ElementSelector;
/*    */ import ch.qos.logback.core.joran.spi.RuleStore;
/*    */ import ch.qos.logback.core.sift.SiftingJoranConfiguratorBase;
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
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
/*    */ public class SiftingJoranConfigurator
/*    */   extends SiftingJoranConfiguratorBase<ILoggingEvent>
/*    */ {
/*    */   SiftingJoranConfigurator(String paramString1, String paramString2, Map<String, String> paramMap) {
/* 34 */     super(paramString1, paramString2, paramMap);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ElementPath initialElementPath() {
/* 39 */     return new ElementPath("configuration");
/*    */   }
/*    */ 
/*    */   
/*    */   protected void addInstanceRules(RuleStore paramRuleStore) {
/* 44 */     super.addInstanceRules(paramRuleStore);
/* 45 */     paramRuleStore.addRule(new ElementSelector("configuration/appender"), (Action)new AppenderAction());
/*    */   }
/*    */ 
/*    */   
/*    */   protected void addDefaultNestedComponentRegistryRules(DefaultNestedComponentRegistry paramDefaultNestedComponentRegistry) {
/* 50 */     DefaultNestedComponentRules.addDefaultNestedComponentRegistryRules(paramDefaultNestedComponentRegistry);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void buildInterpreter() {
/* 55 */     super.buildInterpreter();
/* 56 */     Map map = this.interpreter.getInterpretationContext().getObjectMap();
/* 57 */     map.put("APPENDER_BAG", new HashMap<Object, Object>());
/*    */     
/* 59 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 60 */     hashMap.putAll(this.parentPropertyMap);
/* 61 */     hashMap.put(this.key, this.value);
/* 62 */     this.interpreter.setInterpretationContextPropertiesMap(hashMap);
/*    */   }
/*    */ 
/*    */   
/*    */   public Appender<ILoggingEvent> getAppender() {
/* 67 */     Map map = this.interpreter.getInterpretationContext().getObjectMap();
/* 68 */     HashMap hashMap = (HashMap)map.get("APPENDER_BAG");
/* 69 */     oneAndOnlyOneCheck(hashMap);
/* 70 */     Collection<Appender<ILoggingEvent>> collection = hashMap.values();
/* 71 */     if (collection.size() == 0) {
/* 72 */       return null;
/*    */     }
/* 74 */     return collection.iterator().next();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\sift\SiftingJoranConfigurator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */