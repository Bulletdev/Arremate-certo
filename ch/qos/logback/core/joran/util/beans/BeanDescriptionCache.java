/*    */ package ch.qos.logback.core.joran.util.beans;
/*    */ 
/*    */ import ch.qos.logback.core.Context;
/*    */ import ch.qos.logback.core.spi.ContextAwareBase;
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
/*    */ public class BeanDescriptionCache
/*    */   extends ContextAwareBase
/*    */ {
/* 22 */   private Map<Class<?>, BeanDescription> classToBeanDescription = new HashMap<Class<?>, BeanDescription>();
/*    */   private BeanDescriptionFactory beanDescriptionFactory;
/*    */   
/*    */   public BeanDescriptionCache(Context paramContext) {
/* 26 */     setContext(paramContext);
/*    */   }
/*    */   
/*    */   private BeanDescriptionFactory getBeanDescriptionFactory() {
/* 30 */     if (this.beanDescriptionFactory == null) {
/* 31 */       this.beanDescriptionFactory = new BeanDescriptionFactory(getContext());
/*    */     }
/* 33 */     return this.beanDescriptionFactory;
/*    */   }
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
/*    */   public BeanDescription getBeanDescription(Class<?> paramClass) {
/* 46 */     if (!this.classToBeanDescription.containsKey(paramClass)) {
/* 47 */       BeanDescription beanDescription = getBeanDescriptionFactory().create(paramClass);
/* 48 */       this.classToBeanDescription.put(paramClass, beanDescription);
/*    */     } 
/* 50 */     return this.classToBeanDescription.get(paramClass);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\jora\\util\beans\BeanDescriptionCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */