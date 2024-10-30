/*     */ package org.apache.commons.collections4;
/*     */ 
/*     */ import org.apache.commons.collections4.functors.ConstantFactory;
/*     */ import org.apache.commons.collections4.functors.ExceptionFactory;
/*     */ import org.apache.commons.collections4.functors.InstantiateFactory;
/*     */ import org.apache.commons.collections4.functors.PrototypeFactory;
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
/*     */ public class FactoryUtils
/*     */ {
/*     */   public static <T> Factory<T> exceptionFactory() {
/*  62 */     return ExceptionFactory.exceptionFactory();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Factory<T> nullFactory() {
/*  74 */     return ConstantFactory.constantFactory(null);
/*     */   }
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
/*     */   public static <T> Factory<T> constantFactory(T paramT) {
/*  90 */     return ConstantFactory.constantFactory(paramT);
/*     */   }
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
/*     */   public static <T> Factory<T> prototypeFactory(T paramT) {
/* 112 */     return PrototypeFactory.prototypeFactory(paramT);
/*     */   }
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
/*     */   public static <T> Factory<T> instantiateFactory(Class<T> paramClass) {
/* 127 */     return InstantiateFactory.instantiateFactory(paramClass, null, null);
/*     */   }
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
/*     */   public static <T> Factory<T> instantiateFactory(Class<T> paramClass, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
/* 147 */     return InstantiateFactory.instantiateFactory(paramClass, paramArrayOfClass, paramArrayOfObject);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\FactoryUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */