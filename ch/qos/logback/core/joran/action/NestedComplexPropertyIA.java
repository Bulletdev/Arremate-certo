/*     */ package ch.qos.logback.core.joran.action;
/*     */ 
/*     */ import ch.qos.logback.core.joran.spi.ElementPath;
/*     */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*     */ import ch.qos.logback.core.joran.spi.NoAutoStartUtil;
/*     */ import ch.qos.logback.core.joran.util.PropertySetter;
/*     */ import ch.qos.logback.core.joran.util.beans.BeanDescriptionCache;
/*     */ import ch.qos.logback.core.spi.ContextAware;
/*     */ import ch.qos.logback.core.spi.LifeCycle;
/*     */ import ch.qos.logback.core.util.AggregationType;
/*     */ import ch.qos.logback.core.util.Loader;
/*     */ import ch.qos.logback.core.util.OptionHelper;
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
/*     */ public class NestedComplexPropertyIA
/*     */   extends ImplicitAction
/*     */ {
/*  47 */   Stack<IADataForComplexProperty> actionDataStack = new Stack<IADataForComplexProperty>();
/*     */   
/*     */   private final BeanDescriptionCache beanDescriptionCache;
/*     */   
/*     */   public NestedComplexPropertyIA(BeanDescriptionCache paramBeanDescriptionCache) {
/*  52 */     this.beanDescriptionCache = paramBeanDescriptionCache;
/*     */   }
/*     */   
/*     */   public boolean isApplicable(ElementPath paramElementPath, Attributes paramAttributes, InterpretationContext paramInterpretationContext) {
/*     */     IADataForComplexProperty iADataForComplexProperty;
/*  57 */     String str = paramElementPath.peekLast();
/*     */ 
/*     */     
/*  60 */     if (paramInterpretationContext.isEmpty()) {
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     Object object = paramInterpretationContext.peekObject();
/*  65 */     PropertySetter propertySetter = new PropertySetter(this.beanDescriptionCache, object);
/*  66 */     propertySetter.setContext(this.context);
/*     */     
/*  68 */     AggregationType aggregationType = propertySetter.computeAggregationType(str);
/*     */     
/*  70 */     switch (null.q[aggregationType.ordinal()]) {
/*     */       case 1:
/*     */       case 2:
/*     */       case 3:
/*  74 */         return false;
/*     */ 
/*     */       
/*     */       case 4:
/*     */       case 5:
/*  79 */         iADataForComplexProperty = new IADataForComplexProperty(propertySetter, aggregationType, str);
/*  80 */         this.actionDataStack.push(iADataForComplexProperty);
/*     */         
/*  82 */         return true;
/*     */     } 
/*  84 */     addError("PropertySetter.computeAggregationType returned " + aggregationType);
/*  85 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) {
/*  92 */     IADataForComplexProperty iADataForComplexProperty = this.actionDataStack.peek();
/*     */     
/*  94 */     String str = paramAttributes.getValue("class");
/*     */     
/*  96 */     str = paramInterpretationContext.subst(str);
/*     */     
/*  98 */     Class clazz = null;
/*     */     
/*     */     try {
/* 101 */       if (!OptionHelper.isEmpty(str)) {
/* 102 */         clazz = Loader.loadClass(str, this.context);
/*     */       } else {
/*     */         
/* 105 */         PropertySetter propertySetter = iADataForComplexProperty.parentBean;
/* 106 */         clazz = propertySetter.getClassNameViaImplicitRules(iADataForComplexProperty.getComplexPropertyName(), iADataForComplexProperty.getAggregationType(), paramInterpretationContext
/* 107 */             .getDefaultNestedComponentRegistry());
/*     */       } 
/*     */       
/* 110 */       if (clazz == null) {
/* 111 */         iADataForComplexProperty.inError = true;
/* 112 */         String str1 = "Could not find an appropriate class for property [" + paramString + "]";
/* 113 */         addError(str1);
/*     */         
/*     */         return;
/*     */       } 
/* 117 */       if (OptionHelper.isEmpty(str)) {
/* 118 */         addInfo("Assuming default type [" + clazz.getName() + "] for [" + paramString + "] property");
/*     */       }
/*     */       
/* 121 */       iADataForComplexProperty.setNestedComplexProperty(clazz.newInstance());
/*     */ 
/*     */       
/* 124 */       if (iADataForComplexProperty.getNestedComplexProperty() instanceof ContextAware) {
/* 125 */         ((ContextAware)iADataForComplexProperty.getNestedComplexProperty()).setContext(this.context);
/*     */       }
/*     */ 
/*     */       
/* 129 */       paramInterpretationContext.pushObject(iADataForComplexProperty.getNestedComplexProperty());
/*     */     }
/* 131 */     catch (Exception exception) {
/* 132 */       iADataForComplexProperty.inError = true;
/* 133 */       String str1 = "Could not create component [" + paramString + "] of type [" + str + "]";
/* 134 */       addError(str1, exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void end(InterpretationContext paramInterpretationContext, String paramString) {
/* 143 */     IADataForComplexProperty iADataForComplexProperty = this.actionDataStack.pop();
/*     */     
/* 145 */     if (iADataForComplexProperty.inError) {
/*     */       return;
/*     */     }
/*     */     
/* 149 */     PropertySetter propertySetter = new PropertySetter(this.beanDescriptionCache, iADataForComplexProperty.getNestedComplexProperty());
/* 150 */     propertySetter.setContext(this.context);
/*     */ 
/*     */     
/* 153 */     if (propertySetter.computeAggregationType("parent") == AggregationType.AS_COMPLEX_PROPERTY) {
/* 154 */       propertySetter.setComplexProperty("parent", iADataForComplexProperty.parentBean.getObj());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 159 */     Object object1 = iADataForComplexProperty.getNestedComplexProperty();
/* 160 */     if (object1 instanceof LifeCycle && NoAutoStartUtil.notMarkedWithNoAutoStart(object1)) {
/* 161 */       ((LifeCycle)object1).start();
/*     */     }
/*     */     
/* 164 */     Object object2 = paramInterpretationContext.peekObject();
/*     */     
/* 166 */     if (object2 != iADataForComplexProperty.getNestedComplexProperty()) {
/* 167 */       addError("The object on the top the of the stack is not the component pushed earlier.");
/*     */     } else {
/* 169 */       paramInterpretationContext.popObject();
/*     */       
/* 171 */       switch (null.q[iADataForComplexProperty.aggregationType.ordinal()]) {
/*     */         case 5:
/* 173 */           iADataForComplexProperty.parentBean.setComplexProperty(paramString, iADataForComplexProperty.getNestedComplexProperty());
/*     */           return;
/*     */         
/*     */         case 4:
/* 177 */           iADataForComplexProperty.parentBean.addComplexProperty(paramString, iADataForComplexProperty.getNestedComplexProperty());
/*     */           return;
/*     */       } 
/* 180 */       addError("Unexpected aggregationType " + iADataForComplexProperty.aggregationType);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\action\NestedComplexPropertyIA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */