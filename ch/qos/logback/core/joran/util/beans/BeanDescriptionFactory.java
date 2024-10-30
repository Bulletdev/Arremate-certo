/*    */ package ch.qos.logback.core.joran.util.beans;
/*    */ 
/*    */ import ch.qos.logback.core.Context;
/*    */ import ch.qos.logback.core.spi.ContextAwareBase;
/*    */ import java.lang.reflect.Method;
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
/*    */ public class BeanDescriptionFactory
/*    */   extends ContextAwareBase
/*    */ {
/*    */   BeanDescriptionFactory(Context paramContext) {
/* 23 */     setContext(paramContext);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BeanDescription create(Class<?> paramClass) {
/* 32 */     HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
/* 33 */     HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
/* 34 */     HashMap<Object, Object> hashMap3 = new HashMap<Object, Object>();
/* 35 */     Method[] arrayOfMethod = paramClass.getMethods();
/* 36 */     for (Method method : arrayOfMethod) {
/* 37 */       if (!method.isBridge())
/*    */       {
/*    */ 
/*    */         
/* 41 */         if (BeanUtil.isGetter(method)) {
/* 42 */           String str = BeanUtil.getPropertyName(method);
/* 43 */           Method method1 = (Method)hashMap1.put(str, method);
/* 44 */           if (method1 != null) {
/* 45 */             if (method1.getName().startsWith("is")) {
/* 46 */               hashMap1.put(str, method1);
/*    */             }
/* 48 */             String str1 = String.format("Class '%s' contains multiple getters for the same property '%s'.", new Object[] { paramClass.getCanonicalName(), str });
/* 49 */             addWarn(str1);
/*    */           } 
/* 51 */         } else if (BeanUtil.isSetter(method)) {
/* 52 */           String str = BeanUtil.getPropertyName(method);
/* 53 */           Method method1 = (Method)hashMap2.put(str, method);
/* 54 */           if (method1 != null) {
/* 55 */             String str1 = String.format("Class '%s' contains multiple setters for the same property '%s'.", new Object[] { paramClass.getCanonicalName(), str });
/* 56 */             addWarn(str1);
/*    */           } 
/* 58 */         } else if (BeanUtil.isAdder(method)) {
/* 59 */           String str = BeanUtil.getPropertyName(method);
/* 60 */           Method method1 = (Method)hashMap3.put(str, method);
/* 61 */           if (method1 != null) {
/* 62 */             String str1 = String.format("Class '%s' contains multiple adders for the same property '%s'.", new Object[] { paramClass.getCanonicalName(), str });
/* 63 */             addWarn(str1);
/*    */           } 
/*    */         }  } 
/*    */     } 
/* 67 */     return new BeanDescription(paramClass, (Map)hashMap1, (Map)hashMap2, (Map)hashMap3);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\jora\\util\beans\BeanDescriptionFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */