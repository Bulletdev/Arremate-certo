/*    */ package ch.qos.logback.core.joran.util.beans;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ import java.util.Collections;
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
/*    */ public class BeanDescription
/*    */ {
/*    */   private final Class<?> clazz;
/*    */   private final Map<String, Method> propertyNameToGetter;
/*    */   private final Map<String, Method> propertyNameToSetter;
/*    */   private final Map<String, Method> propertyNameToAdder;
/*    */   
/*    */   protected BeanDescription(Class<?> paramClass, Map<String, Method> paramMap1, Map<String, Method> paramMap2, Map<String, Method> paramMap3) {
/* 37 */     this.clazz = paramClass;
/* 38 */     this.propertyNameToGetter = Collections.unmodifiableMap(paramMap1);
/* 39 */     this.propertyNameToSetter = Collections.unmodifiableMap(paramMap2);
/* 40 */     this.propertyNameToAdder = Collections.unmodifiableMap(paramMap3);
/*    */   }
/*    */   
/*    */   public Class<?> getClazz() {
/* 44 */     return this.clazz;
/*    */   }
/*    */   
/*    */   public Map<String, Method> getPropertyNameToGetter() {
/* 48 */     return this.propertyNameToGetter;
/*    */   }
/*    */   
/*    */   public Map<String, Method> getPropertyNameToSetter() {
/* 52 */     return this.propertyNameToSetter;
/*    */   }
/*    */   
/*    */   public Method getGetter(String paramString) {
/* 56 */     return this.propertyNameToGetter.get(paramString);
/*    */   }
/*    */   
/*    */   public Method getSetter(String paramString) {
/* 60 */     return this.propertyNameToSetter.get(paramString);
/*    */   }
/*    */   
/*    */   public Map<String, Method> getPropertyNameToAdder() {
/* 64 */     return this.propertyNameToAdder;
/*    */   }
/*    */   
/*    */   public Method getAdder(String paramString) {
/* 68 */     return this.propertyNameToAdder.get(paramString);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\jora\\util\beans\BeanDescription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */