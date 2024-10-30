/*     */ package ch.qos.logback.core.joran.action;
/*     */ 
/*     */ import ch.qos.logback.core.boolex.EventEvaluator;
/*     */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*     */ import ch.qos.logback.core.util.OptionHelper;
/*     */ import java.util.Map;
/*     */ import org.xml.sax.Attributes;
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
/*     */ public abstract class AbstractEventEvaluatorAction
/*     */   extends Action
/*     */ {
/*     */   EventEvaluator<?> evaluator;
/*     */   boolean inError = false;
/*     */   
/*     */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) {
/*  36 */     this.inError = false;
/*  37 */     this.evaluator = null;
/*     */     
/*  39 */     String str1 = paramAttributes.getValue("class");
/*  40 */     if (OptionHelper.isEmpty(str1)) {
/*  41 */       str1 = defaultClassName();
/*  42 */       addInfo("Assuming default evaluator class [" + str1 + "]");
/*     */     } 
/*     */     
/*  45 */     if (OptionHelper.isEmpty(str1)) {
/*  46 */       str1 = defaultClassName();
/*  47 */       this.inError = true;
/*  48 */       addError("Mandatory \"class\" attribute not set for <evaluator>");
/*     */       
/*     */       return;
/*     */     } 
/*  52 */     String str2 = paramAttributes.getValue("name");
/*  53 */     if (OptionHelper.isEmpty(str2)) {
/*  54 */       this.inError = true;
/*  55 */       addError("Mandatory \"name\" attribute not set for <evaluator>");
/*     */       return;
/*     */     } 
/*     */     try {
/*  59 */       this.evaluator = (EventEvaluator)OptionHelper.instantiateByClassName(str1, EventEvaluator.class, this.context);
/*     */       
/*  61 */       this.evaluator.setContext(this.context);
/*  62 */       this.evaluator.setName(str2);
/*     */       
/*  64 */       paramInterpretationContext.pushObject(this.evaluator);
/*  65 */       addInfo("Adding evaluator named [" + str2 + "] to the object stack");
/*     */     }
/*  67 */     catch (Exception exception) {
/*  68 */       this.inError = true;
/*  69 */       addError("Could not create evaluator of type " + str1 + "].", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract String defaultClassName();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void end(InterpretationContext paramInterpretationContext, String paramString) {
/*  86 */     if (this.inError) {
/*     */       return;
/*     */     }
/*     */     
/*  90 */     if (this.evaluator instanceof ch.qos.logback.core.spi.LifeCycle) {
/*  91 */       this.evaluator.start();
/*  92 */       addInfo("Starting evaluator named [" + this.evaluator.getName() + "]");
/*     */     } 
/*     */     
/*  95 */     Object object = paramInterpretationContext.peekObject();
/*     */     
/*  97 */     if (object != this.evaluator) {
/*  98 */       addWarn("The object on the top the of the stack is not the evaluator pushed earlier.");
/*     */     } else {
/* 100 */       paramInterpretationContext.popObject();
/*     */       
/*     */       try {
/* 103 */         Map<String, EventEvaluator<?>> map = (Map)this.context.getObject("EVALUATOR_MAP");
/* 104 */         if (map == null) {
/* 105 */           addError("Could not find EvaluatorMap");
/*     */         } else {
/* 107 */           map.put(this.evaluator.getName(), this.evaluator);
/*     */         } 
/* 109 */       } catch (Exception exception) {
/* 110 */         addError("Could not set evaluator named [" + this.evaluator + "].", exception);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void finish(InterpretationContext paramInterpretationContext) {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\action\AbstractEventEvaluatorAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */