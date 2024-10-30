/*     */ package org.apache.commons.collections4.functors;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import org.apache.commons.collections4.FunctorException;
/*     */ import org.apache.commons.collections4.Transformer;
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
/*     */ public class InstantiateTransformer<T>
/*     */   implements Transformer<Class<? extends T>, T>
/*     */ {
/*  40 */   private static final Transformer NO_ARG_INSTANCE = new InstantiateTransformer();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Class<?>[] iParamTypes;
/*     */ 
/*     */ 
/*     */   
/*     */   private final Object[] iArgs;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Transformer<Class<? extends T>, T> instantiateTransformer() {
/*  55 */     return NO_ARG_INSTANCE;
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
/*     */   public static <T> Transformer<Class<? extends T>, T> instantiateTransformer(Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
/*  69 */     if ((paramArrayOfClass == null && paramArrayOfObject != null) || (paramArrayOfClass != null && paramArrayOfObject == null) || (paramArrayOfClass != null && paramArrayOfObject != null && paramArrayOfClass.length != paramArrayOfObject.length))
/*     */     {
/*     */       
/*  72 */       throw new IllegalArgumentException("Parameter types must match the arguments");
/*     */     }
/*     */     
/*  75 */     if (paramArrayOfClass == null || paramArrayOfClass.length == 0) {
/*  76 */       return new InstantiateTransformer<T>();
/*     */     }
/*  78 */     return new InstantiateTransformer<T>(paramArrayOfClass, paramArrayOfObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InstantiateTransformer() {
/*  86 */     this.iParamTypes = null;
/*  87 */     this.iArgs = null;
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
/*     */   public InstantiateTransformer(Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
/* 101 */     this.iParamTypes = (paramArrayOfClass != null) ? (Class[])paramArrayOfClass.clone() : null;
/* 102 */     this.iArgs = (paramArrayOfObject != null) ? (Object[])paramArrayOfObject.clone() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T transform(Class<? extends T> paramClass) {
/*     */     try {
/* 114 */       if (paramClass == null) {
/* 115 */         throw new FunctorException("InstantiateTransformer: Input object was not an instanceof Class, it was a null object");
/*     */       }
/*     */       
/* 118 */       Constructor<? extends T> constructor = paramClass.getConstructor(this.iParamTypes);
/* 119 */       return constructor.newInstance(this.iArgs);
/* 120 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 121 */       throw new FunctorException("InstantiateTransformer: The constructor must exist and be public ");
/* 122 */     } catch (InstantiationException instantiationException) {
/* 123 */       throw new FunctorException("InstantiateTransformer: InstantiationException", instantiationException);
/* 124 */     } catch (IllegalAccessException illegalAccessException) {
/* 125 */       throw new FunctorException("InstantiateTransformer: Constructor must be public", illegalAccessException);
/* 126 */     } catch (InvocationTargetException invocationTargetException) {
/* 127 */       throw new FunctorException("InstantiateTransformer: Constructor threw an exception", invocationTargetException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\InstantiateTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */