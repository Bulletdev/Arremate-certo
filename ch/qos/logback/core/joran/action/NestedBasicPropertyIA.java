/*     */ package ch.qos.logback.core.joran.action;
/*     */ 
/*     */ import ch.qos.logback.core.joran.spi.ElementPath;
/*     */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*     */ import ch.qos.logback.core.joran.util.PropertySetter;
/*     */ import ch.qos.logback.core.joran.util.beans.BeanDescriptionCache;
/*     */ import ch.qos.logback.core.util.AggregationType;
/*     */ import java.util.Stack;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NestedBasicPropertyIA
/*     */   extends ImplicitAction
/*     */ {
/*  42 */   Stack<a> actionDataStack = new Stack<a>();
/*     */   
/*     */   private final BeanDescriptionCache beanDescriptionCache;
/*     */   
/*     */   public NestedBasicPropertyIA(BeanDescriptionCache paramBeanDescriptionCache) {
/*  47 */     this.beanDescriptionCache = paramBeanDescriptionCache;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isApplicable(ElementPath paramElementPath, Attributes paramAttributes, InterpretationContext paramInterpretationContext) {
/*     */     a a;
/*  53 */     String str = paramElementPath.peekLast();
/*     */ 
/*     */     
/*  56 */     if (paramInterpretationContext.isEmpty()) {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     Object object = paramInterpretationContext.peekObject();
/*  61 */     PropertySetter propertySetter = new PropertySetter(this.beanDescriptionCache, object);
/*  62 */     propertySetter.setContext(this.context);
/*     */     
/*  64 */     AggregationType aggregationType = propertySetter.computeAggregationType(str);
/*     */     
/*  66 */     switch (null.q[aggregationType.ordinal()]) {
/*     */       case 1:
/*     */       case 2:
/*     */       case 3:
/*  70 */         return false;
/*     */       
/*     */       case 4:
/*     */       case 5:
/*  74 */         a = new a(propertySetter, aggregationType, str);
/*  75 */         this.actionDataStack.push(a);
/*     */         
/*  77 */         return true;
/*     */     } 
/*  79 */     addError("PropertySetter.canContainComponent returned " + aggregationType);
/*  80 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void body(InterpretationContext paramInterpretationContext, String paramString) {
/*  90 */     String str = paramInterpretationContext.subst(paramString);
/*     */     
/*  92 */     a a = this.actionDataStack.peek();
/*  93 */     switch (null.q[a.aggregationType.ordinal()]) {
/*     */       case 4:
/*  95 */         a.parentBean.setProperty(a.propertyName, str);
/*     */         return;
/*     */       case 5:
/*  98 */         a.parentBean.addBasicProperty(a.propertyName, str);
/*     */         return;
/*     */     } 
/* 101 */     addError("Unexpected aggregationType " + a.aggregationType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void end(InterpretationContext paramInterpretationContext, String paramString) {
/* 107 */     this.actionDataStack.pop();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\action\NestedBasicPropertyIA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */