/*    */ package ch.qos.logback.classic.joran;
/*    */ 
/*    */ import ch.qos.logback.classic.joran.action.ConfigurationAction;
/*    */ import ch.qos.logback.classic.joran.action.ConsolePluginAction;
/*    */ import ch.qos.logback.classic.joran.action.ContextNameAction;
/*    */ import ch.qos.logback.classic.joran.action.EvaluatorAction;
/*    */ import ch.qos.logback.classic.joran.action.InsertFromJNDIAction;
/*    */ import ch.qos.logback.classic.joran.action.JMXConfiguratorAction;
/*    */ import ch.qos.logback.classic.joran.action.LevelAction;
/*    */ import ch.qos.logback.classic.joran.action.LoggerAction;
/*    */ import ch.qos.logback.classic.joran.action.LoggerContextListenerAction;
/*    */ import ch.qos.logback.classic.joran.action.ReceiverAction;
/*    */ import ch.qos.logback.classic.joran.action.RootLoggerAction;
/*    */ import ch.qos.logback.classic.sift.SiftAction;
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
/*    */ import ch.qos.logback.classic.spi.PlatformInfo;
/*    */ import ch.qos.logback.classic.util.DefaultNestedComponentRules;
/*    */ import ch.qos.logback.core.joran.JoranConfiguratorBase;
/*    */ import ch.qos.logback.core.joran.action.Action;
/*    */ import ch.qos.logback.core.joran.action.AppenderRefAction;
/*    */ import ch.qos.logback.core.joran.action.IncludeAction;
/*    */ import ch.qos.logback.core.joran.action.NOPAction;
/*    */ import ch.qos.logback.core.joran.conditional.ElseAction;
/*    */ import ch.qos.logback.core.joran.conditional.IfAction;
/*    */ import ch.qos.logback.core.joran.conditional.ThenAction;
/*    */ import ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
/*    */ import ch.qos.logback.core.joran.spi.ElementSelector;
/*    */ import ch.qos.logback.core.joran.spi.RuleStore;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JoranConfigurator
/*    */   extends JoranConfiguratorBase<ILoggingEvent>
/*    */ {
/*    */   public void addInstanceRules(RuleStore paramRuleStore) {
/* 42 */     super.addInstanceRules(paramRuleStore);
/*    */     
/* 44 */     paramRuleStore.addRule(new ElementSelector("configuration"), (Action)new ConfigurationAction());
/*    */     
/* 46 */     paramRuleStore.addRule(new ElementSelector("configuration/contextName"), (Action)new ContextNameAction());
/* 47 */     paramRuleStore.addRule(new ElementSelector("configuration/contextListener"), (Action)new LoggerContextListenerAction());
/* 48 */     paramRuleStore.addRule(new ElementSelector("configuration/insertFromJNDI"), (Action)new InsertFromJNDIAction());
/* 49 */     paramRuleStore.addRule(new ElementSelector("configuration/evaluator"), (Action)new EvaluatorAction());
/*    */     
/* 51 */     paramRuleStore.addRule(new ElementSelector("configuration/appender/sift"), (Action)new SiftAction());
/* 52 */     paramRuleStore.addRule(new ElementSelector("configuration/appender/sift/*"), (Action)new NOPAction());
/*    */     
/* 54 */     paramRuleStore.addRule(new ElementSelector("configuration/logger"), (Action)new LoggerAction());
/* 55 */     paramRuleStore.addRule(new ElementSelector("configuration/logger/level"), (Action)new LevelAction());
/*    */     
/* 57 */     paramRuleStore.addRule(new ElementSelector("configuration/root"), (Action)new RootLoggerAction());
/* 58 */     paramRuleStore.addRule(new ElementSelector("configuration/root/level"), (Action)new LevelAction());
/* 59 */     paramRuleStore.addRule(new ElementSelector("configuration/logger/appender-ref"), (Action)new AppenderRefAction());
/* 60 */     paramRuleStore.addRule(new ElementSelector("configuration/root/appender-ref"), (Action)new AppenderRefAction());
/*    */ 
/*    */     
/* 63 */     paramRuleStore.addRule(new ElementSelector("*/if"), (Action)new IfAction());
/* 64 */     paramRuleStore.addRule(new ElementSelector("*/if/then"), (Action)new ThenAction());
/* 65 */     paramRuleStore.addRule(new ElementSelector("*/if/then/*"), (Action)new NOPAction());
/* 66 */     paramRuleStore.addRule(new ElementSelector("*/if/else"), (Action)new ElseAction());
/* 67 */     paramRuleStore.addRule(new ElementSelector("*/if/else/*"), (Action)new NOPAction());
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 72 */     if (PlatformInfo.hasJMXObjectName()) {
/* 73 */       paramRuleStore.addRule(new ElementSelector("configuration/jmxConfigurator"), (Action)new JMXConfiguratorAction());
/*    */     }
/* 75 */     paramRuleStore.addRule(new ElementSelector("configuration/include"), (Action)new IncludeAction());
/*    */     
/* 77 */     paramRuleStore.addRule(new ElementSelector("configuration/consolePlugin"), (Action)new ConsolePluginAction());
/*    */     
/* 79 */     paramRuleStore.addRule(new ElementSelector("configuration/receiver"), (Action)new ReceiverAction());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void addDefaultNestedComponentRegistryRules(DefaultNestedComponentRegistry paramDefaultNestedComponentRegistry) {
/* 85 */     DefaultNestedComponentRules.addDefaultNestedComponentRegistryRules(paramDefaultNestedComponentRegistry);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\joran\JoranConfigurator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */