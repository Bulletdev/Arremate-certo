/*    */ package ch.qos.logback.core.joran.spi;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DefaultNestedComponentRegistry
/*    */ {
/* 27 */   Map<HostClassAndPropertyDouble, Class<?>> defaultComponentMap = new HashMap<HostClassAndPropertyDouble, Class<?>>();
/*    */   
/*    */   public void add(Class<?> paramClass1, String paramString, Class<?> paramClass2) {
/* 30 */     HostClassAndPropertyDouble hostClassAndPropertyDouble = new HostClassAndPropertyDouble(paramClass1, paramString.toLowerCase());
/* 31 */     this.defaultComponentMap.put(hostClassAndPropertyDouble, paramClass2);
/*    */   }
/*    */   
/*    */   public Class<?> findDefaultComponentType(Class<?> paramClass, String paramString) {
/* 35 */     paramString = paramString.toLowerCase();
/* 36 */     while (paramClass != null) {
/* 37 */       Class<?> clazz = oneShotFind(paramClass, paramString);
/* 38 */       if (clazz != null) {
/* 39 */         return clazz;
/*    */       }
/* 41 */       paramClass = paramClass.getSuperclass();
/*    */     } 
/* 43 */     return null;
/*    */   }
/*    */   
/*    */   private Class<?> oneShotFind(Class<?> paramClass, String paramString) {
/* 47 */     HostClassAndPropertyDouble hostClassAndPropertyDouble = new HostClassAndPropertyDouble(paramClass, paramString);
/* 48 */     return this.defaultComponentMap.get(hostClassAndPropertyDouble);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\spi\DefaultNestedComponentRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */