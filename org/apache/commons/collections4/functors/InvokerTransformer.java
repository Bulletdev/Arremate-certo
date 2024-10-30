/*     */ package org.apache.commons.collections4.functors;
/*     */ 
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
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
/*     */ public class InvokerTransformer<I, O>
/*     */   implements Transformer<I, O>
/*     */ {
/*     */   private final String iMethodName;
/*     */   private final Class<?>[] iParamTypes;
/*     */   private final Object[] iArgs;
/*     */   
/*     */   public static <I, O> Transformer<I, O> invokerTransformer(String paramString) {
/*  56 */     if (paramString == null) {
/*  57 */       throw new NullPointerException("The method to invoke must not be null");
/*     */     }
/*  59 */     return new InvokerTransformer<I, O>(paramString);
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
/*     */   public static <I, O> Transformer<I, O> invokerTransformer(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
/*  76 */     if (paramString == null) {
/*  77 */       throw new NullPointerException("The method to invoke must not be null");
/*     */     }
/*  79 */     if ((paramArrayOfClass == null && paramArrayOfObject != null) || (paramArrayOfClass != null && paramArrayOfObject == null) || (paramArrayOfClass != null && paramArrayOfObject != null && paramArrayOfClass.length != paramArrayOfObject.length))
/*     */     {
/*     */       
/*  82 */       throw new IllegalArgumentException("The parameter types must match the arguments");
/*     */     }
/*  84 */     if (paramArrayOfClass == null || paramArrayOfClass.length == 0) {
/*  85 */       return new InvokerTransformer<I, O>(paramString);
/*     */     }
/*  87 */     return new InvokerTransformer<I, O>(paramString, paramArrayOfClass, paramArrayOfObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private InvokerTransformer(String paramString) {
/*  97 */     this.iMethodName = paramString;
/*  98 */     this.iParamTypes = null;
/*  99 */     this.iArgs = null;
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
/*     */   public InvokerTransformer(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
/* 114 */     this.iMethodName = paramString;
/* 115 */     this.iParamTypes = (paramArrayOfClass != null) ? (Class[])paramArrayOfClass.clone() : null;
/* 116 */     this.iArgs = (paramArrayOfObject != null) ? (Object[])paramArrayOfObject.clone() : null;
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
/*     */   public O transform(Object paramObject) {
/* 128 */     if (paramObject == null) {
/* 129 */       return null;
/*     */     }
/*     */     try {
/* 132 */       Class<?> clazz = paramObject.getClass();
/* 133 */       Method method = clazz.getMethod(this.iMethodName, this.iParamTypes);
/* 134 */       return (O)method.invoke(paramObject, this.iArgs);
/* 135 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 136 */       throw new FunctorException("InvokerTransformer: The method '" + this.iMethodName + "' on '" + paramObject.getClass() + "' does not exist");
/*     */     }
/* 138 */     catch (IllegalAccessException illegalAccessException) {
/* 139 */       throw new FunctorException("InvokerTransformer: The method '" + this.iMethodName + "' on '" + paramObject.getClass() + "' cannot be accessed");
/*     */     }
/* 141 */     catch (InvocationTargetException invocationTargetException) {
/* 142 */       throw new FunctorException("InvokerTransformer: The method '" + this.iMethodName + "' on '" + paramObject.getClass() + "' threw an exception", invocationTargetException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\InvokerTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */