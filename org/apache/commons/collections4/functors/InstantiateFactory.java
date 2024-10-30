/*     */ package org.apache.commons.collections4.functors;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import org.apache.commons.collections4.Factory;
/*     */ import org.apache.commons.collections4.FunctorException;
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
/*     */ public class InstantiateFactory<T>
/*     */   implements Factory<T>
/*     */ {
/*     */   private final Class<T> iClassToInstantiate;
/*     */   private final Class<?>[] iParamTypes;
/*     */   private final Object[] iArgs;
/*  45 */   private transient Constructor<T> iConstructor = null;
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
/*  61 */     if (paramClass == null) {
/*  62 */       throw new NullPointerException("Class to instantiate must not be null");
/*     */     }
/*  64 */     if ((paramArrayOfClass == null && paramArrayOfObject != null) || (paramArrayOfClass != null && paramArrayOfObject == null) || (paramArrayOfClass != null && paramArrayOfObject != null && paramArrayOfClass.length != paramArrayOfObject.length))
/*     */     {
/*     */       
/*  67 */       throw new IllegalArgumentException("Parameter types must match the arguments");
/*     */     }
/*     */     
/*  70 */     if (paramArrayOfClass == null || paramArrayOfClass.length == 0) {
/*  71 */       return new InstantiateFactory<T>(paramClass);
/*     */     }
/*  73 */     return new InstantiateFactory<T>(paramClass, paramArrayOfClass, paramArrayOfObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InstantiateFactory(Class<T> paramClass) {
/*  84 */     this.iClassToInstantiate = paramClass;
/*  85 */     this.iParamTypes = null;
/*  86 */     this.iArgs = null;
/*  87 */     findConstructor();
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
/*     */   public InstantiateFactory(Class<T> paramClass, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
/* 100 */     this.iClassToInstantiate = paramClass;
/* 101 */     this.iParamTypes = (Class[])paramArrayOfClass.clone();
/* 102 */     this.iArgs = (Object[])paramArrayOfObject.clone();
/* 103 */     findConstructor();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void findConstructor() {
/*     */     try {
/* 111 */       this.iConstructor = this.iClassToInstantiate.getConstructor(this.iParamTypes);
/* 112 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 113 */       throw new IllegalArgumentException("InstantiateFactory: The constructor must exist and be public ");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T create() {
/* 125 */     if (this.iConstructor == null) {
/* 126 */       findConstructor();
/*     */     }
/*     */     
/*     */     try {
/* 130 */       return this.iConstructor.newInstance(this.iArgs);
/* 131 */     } catch (InstantiationException instantiationException) {
/* 132 */       throw new FunctorException("InstantiateFactory: InstantiationException", instantiationException);
/* 133 */     } catch (IllegalAccessException illegalAccessException) {
/* 134 */       throw new FunctorException("InstantiateFactory: Constructor must be public", illegalAccessException);
/* 135 */     } catch (InvocationTargetException invocationTargetException) {
/* 136 */       throw new FunctorException("InstantiateFactory: Constructor threw an exception", invocationTargetException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\InstantiateFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */