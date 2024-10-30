/*     */ package org.apache.commons.lang3.reflect;
/*     */ 
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Modifier;
/*     */ import org.apache.commons.lang3.ArrayUtils;
/*     */ import org.apache.commons.lang3.ClassUtils;
/*     */ import org.apache.commons.lang3.Validate;
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
/*     */ public class ConstructorUtils
/*     */ {
/*     */   public static <T> T invokeConstructor(Class<T> paramClass, Object... paramVarArgs) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
/*  83 */     paramVarArgs = ArrayUtils.nullToEmpty(paramVarArgs);
/*  84 */     Class[] arrayOfClass = ClassUtils.toClass(paramVarArgs);
/*  85 */     return invokeConstructor(paramClass, paramVarArgs, arrayOfClass);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> T invokeConstructor(Class<T> paramClass, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
/* 111 */     paramArrayOfObject = ArrayUtils.nullToEmpty(paramArrayOfObject);
/* 112 */     paramArrayOfClass = ArrayUtils.nullToEmpty(paramArrayOfClass);
/* 113 */     Constructor<T> constructor = getMatchingAccessibleConstructor(paramClass, paramArrayOfClass);
/* 114 */     if (constructor == null) {
/* 115 */       throw new NoSuchMethodException("No such accessible constructor on object: " + paramClass
/* 116 */           .getName());
/*     */     }
/* 118 */     if (constructor.isVarArgs()) {
/* 119 */       Class[] arrayOfClass = constructor.getParameterTypes();
/* 120 */       paramArrayOfObject = MethodUtils.getVarArgs(paramArrayOfObject, arrayOfClass);
/*     */     } 
/* 122 */     return constructor.newInstance(paramArrayOfObject);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> T invokeExactConstructor(Class<T> paramClass, Object... paramVarArgs) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
/* 147 */     paramVarArgs = ArrayUtils.nullToEmpty(paramVarArgs);
/* 148 */     Class[] arrayOfClass = ClassUtils.toClass(paramVarArgs);
/* 149 */     return invokeExactConstructor(paramClass, paramVarArgs, arrayOfClass);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> T invokeExactConstructor(Class<T> paramClass, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
/* 175 */     paramArrayOfObject = ArrayUtils.nullToEmpty(paramArrayOfObject);
/* 176 */     paramArrayOfClass = ArrayUtils.nullToEmpty(paramArrayOfClass);
/* 177 */     Constructor<T> constructor = getAccessibleConstructor(paramClass, paramArrayOfClass);
/* 178 */     if (constructor == null) {
/* 179 */       throw new NoSuchMethodException("No such accessible constructor on object: " + paramClass
/* 180 */           .getName());
/*     */     }
/* 182 */     return constructor.newInstance(paramArrayOfObject);
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
/*     */   public static <T> Constructor<T> getAccessibleConstructor(Class<T> paramClass, Class<?>... paramVarArgs) {
/* 202 */     Validate.notNull(paramClass, "class cannot be null", new Object[0]);
/*     */     try {
/* 204 */       return getAccessibleConstructor(paramClass.getConstructor(paramVarArgs));
/* 205 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 206 */       return null;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> Constructor<T> getAccessibleConstructor(Constructor<T> paramConstructor) {
/* 222 */     Validate.notNull(paramConstructor, "constructor cannot be null", new Object[0]);
/* 223 */     return (MemberUtils.isAccessible(paramConstructor) && 
/* 224 */       isAccessible(paramConstructor.getDeclaringClass())) ? paramConstructor : null;
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
/*     */   
/*     */   public static <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> paramClass, Class<?>... paramVarArgs) {
/* 247 */     Validate.notNull(paramClass, "class cannot be null", new Object[0]);
/*     */ 
/*     */     
/*     */     try {
/* 251 */       Constructor<T> constructor = paramClass.getConstructor(paramVarArgs);
/* 252 */       MemberUtils.setAccessibleWorkaround(constructor);
/* 253 */       return constructor;
/* 254 */     } catch (NoSuchMethodException noSuchMethodException) {
/*     */       Constructor<?> constructor;
/* 256 */       noSuchMethodException = null;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 261 */       Constructor[] arrayOfConstructor = (Constructor[])paramClass.getConstructors();
/*     */ 
/*     */       
/* 264 */       for (Constructor<?> constructor1 : arrayOfConstructor) {
/*     */         
/* 266 */         if (MemberUtils.isMatchingConstructor(constructor1, paramVarArgs)) {
/*     */           
/* 268 */           constructor1 = getAccessibleConstructor(constructor1);
/* 269 */           if (constructor1 != null) {
/* 270 */             MemberUtils.setAccessibleWorkaround(constructor1);
/* 271 */             if (noSuchMethodException == null || MemberUtils.compareConstructorFit(constructor1, (Constructor<?>)noSuchMethodException, paramVarArgs) < 0) {
/*     */ 
/*     */ 
/*     */               
/* 275 */               Constructor<?> constructor2 = constructor1;
/* 276 */               constructor = constructor2;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 281 */       return (Constructor)constructor;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isAccessible(Class<?> paramClass) {
/* 292 */     Class<?> clazz = paramClass;
/* 293 */     while (clazz != null) {
/* 294 */       if (!Modifier.isPublic(clazz.getModifiers())) {
/* 295 */         return false;
/*     */       }
/* 297 */       clazz = clazz.getEnclosingClass();
/*     */     } 
/* 299 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\reflect\ConstructorUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */