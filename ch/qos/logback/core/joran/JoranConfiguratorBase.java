/*     */ package ch.qos.logback.core.joran;
/*     */ 
/*     */ import ch.qos.logback.core.joran.action.Action;
/*     */ import ch.qos.logback.core.joran.action.AppenderAction;
/*     */ import ch.qos.logback.core.joran.action.AppenderRefAction;
/*     */ import ch.qos.logback.core.joran.action.ContextPropertyAction;
/*     */ import ch.qos.logback.core.joran.action.ConversionRuleAction;
/*     */ import ch.qos.logback.core.joran.action.DefinePropertyAction;
/*     */ import ch.qos.logback.core.joran.action.ImplicitAction;
/*     */ import ch.qos.logback.core.joran.action.NestedBasicPropertyIA;
/*     */ import ch.qos.logback.core.joran.action.NestedComplexPropertyIA;
/*     */ import ch.qos.logback.core.joran.action.NewRuleAction;
/*     */ import ch.qos.logback.core.joran.action.ParamAction;
/*     */ import ch.qos.logback.core.joran.action.PropertyAction;
/*     */ import ch.qos.logback.core.joran.action.ShutdownHookAction;
/*     */ import ch.qos.logback.core.joran.action.StatusListenerAction;
/*     */ import ch.qos.logback.core.joran.action.TimestampAction;
/*     */ import ch.qos.logback.core.joran.spi.ElementSelector;
/*     */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*     */ import ch.qos.logback.core.joran.spi.Interpreter;
/*     */ import ch.qos.logback.core.joran.spi.RuleStore;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class JoranConfiguratorBase<E>
/*     */   extends GenericConfigurator
/*     */ {
/*     */   protected void addInstanceRules(RuleStore paramRuleStore) {
/*  58 */     paramRuleStore.addRule(new ElementSelector("configuration/variable"), (Action)new PropertyAction());
/*  59 */     paramRuleStore.addRule(new ElementSelector("configuration/property"), (Action)new PropertyAction());
/*     */     
/*  61 */     paramRuleStore.addRule(new ElementSelector("configuration/substitutionProperty"), (Action)new PropertyAction());
/*     */     
/*  63 */     paramRuleStore.addRule(new ElementSelector("configuration/timestamp"), (Action)new TimestampAction());
/*  64 */     paramRuleStore.addRule(new ElementSelector("configuration/shutdownHook"), (Action)new ShutdownHookAction());
/*  65 */     paramRuleStore.addRule(new ElementSelector("configuration/define"), (Action)new DefinePropertyAction());
/*     */ 
/*     */ 
/*     */     
/*  69 */     paramRuleStore.addRule(new ElementSelector("configuration/contextProperty"), (Action)new ContextPropertyAction());
/*     */     
/*  71 */     paramRuleStore.addRule(new ElementSelector("configuration/conversionRule"), (Action)new ConversionRuleAction());
/*     */     
/*  73 */     paramRuleStore.addRule(new ElementSelector("configuration/statusListener"), (Action)new StatusListenerAction());
/*     */     
/*  75 */     paramRuleStore.addRule(new ElementSelector("configuration/appender"), (Action)new AppenderAction());
/*  76 */     paramRuleStore.addRule(new ElementSelector("configuration/appender/appender-ref"), (Action)new AppenderRefAction());
/*  77 */     paramRuleStore.addRule(new ElementSelector("configuration/newRule"), (Action)new NewRuleAction());
/*  78 */     paramRuleStore.addRule(new ElementSelector("*/param"), (Action)new ParamAction(getBeanDescriptionCache()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addImplicitRules(Interpreter paramInterpreter) {
/*  84 */     NestedComplexPropertyIA nestedComplexPropertyIA = new NestedComplexPropertyIA(getBeanDescriptionCache());
/*  85 */     nestedComplexPropertyIA.setContext(this.context);
/*  86 */     paramInterpreter.addImplicitAction((ImplicitAction)nestedComplexPropertyIA);
/*     */     
/*  88 */     NestedBasicPropertyIA nestedBasicPropertyIA = new NestedBasicPropertyIA(getBeanDescriptionCache());
/*  89 */     nestedBasicPropertyIA.setContext(this.context);
/*  90 */     paramInterpreter.addImplicitAction((ImplicitAction)nestedBasicPropertyIA);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void buildInterpreter() {
/*  95 */     super.buildInterpreter();
/*  96 */     Map map = this.interpreter.getInterpretationContext().getObjectMap();
/*  97 */     map.put("APPENDER_BAG", new HashMap<Object, Object>());
/*     */   }
/*     */ 
/*     */   
/*     */   public InterpretationContext getInterpretationContext() {
/* 102 */     return this.interpreter.getInterpretationContext();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\JoranConfiguratorBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */