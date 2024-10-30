/*     */ package org.apache.commons.lang3.reflect;
/*     */ 
/*     */ import java.lang.reflect.AccessibleObject;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Member;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import org.apache.commons.lang3.ClassUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class MemberUtils
/*     */ {
/*     */   private static final int ACCESS_TEST = 7;
/*  39 */   private static final Class<?>[] ORDERED_PRIMITIVE_TYPES = new Class[] { byte.class, short.class, char.class, int.class, long.class, float.class, double.class };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean setAccessibleWorkaround(AccessibleObject paramAccessibleObject) {
/*  56 */     if (paramAccessibleObject == null || paramAccessibleObject.isAccessible()) {
/*  57 */       return false;
/*     */     }
/*  59 */     Member member = (Member)paramAccessibleObject;
/*  60 */     if (!paramAccessibleObject.isAccessible() && Modifier.isPublic(member.getModifiers()) && isPackageAccess(member.getDeclaringClass().getModifiers())) {
/*     */       try {
/*  62 */         paramAccessibleObject.setAccessible(true);
/*  63 */         return true;
/*  64 */       } catch (SecurityException securityException) {}
/*     */     }
/*     */ 
/*     */     
/*  68 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isPackageAccess(int paramInt) {
/*  77 */     return ((paramInt & 0x7) == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isAccessible(Member paramMember) {
/*  86 */     return (paramMember != null && Modifier.isPublic(paramMember.getModifiers()) && !paramMember.isSynthetic());
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
/*     */   static int compareConstructorFit(Constructor<?> paramConstructor1, Constructor<?> paramConstructor2, Class<?>[] paramArrayOfClass) {
/* 103 */     return compareParameterTypes(Executable.of(paramConstructor1), Executable.of(paramConstructor2), paramArrayOfClass);
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
/*     */   static int compareMethodFit(Method paramMethod1, Method paramMethod2, Class<?>[] paramArrayOfClass) {
/* 120 */     return compareParameterTypes(Executable.of(paramMethod1), Executable.of(paramMethod2), paramArrayOfClass);
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
/*     */   private static int compareParameterTypes(Executable paramExecutable1, Executable paramExecutable2, Class<?>[] paramArrayOfClass) {
/* 136 */     float f1 = getTotalTransformationCost(paramArrayOfClass, paramExecutable1);
/* 137 */     float f2 = getTotalTransformationCost(paramArrayOfClass, paramExecutable2);
/* 138 */     return Float.compare(f1, f2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static float getTotalTransformationCost(Class<?>[] paramArrayOfClass, Executable paramExecutable) {
/* 149 */     Class[] arrayOfClass = paramExecutable.getParameterTypes();
/* 150 */     boolean bool = paramExecutable.isVarArgs();
/*     */ 
/*     */     
/* 153 */     float f = 0.0F;
/* 154 */     long l = bool ? (arrayOfClass.length - 1) : arrayOfClass.length;
/* 155 */     if (paramArrayOfClass.length < l)
/* 156 */       return Float.MAX_VALUE; 
/*     */     byte b;
/* 158 */     for (b = 0; b < l; b++) {
/* 159 */       f += getObjectTransformationCost(paramArrayOfClass[b], arrayOfClass[b]);
/*     */     }
/* 161 */     if (bool) {
/*     */ 
/*     */       
/* 164 */       b = (paramArrayOfClass.length < arrayOfClass.length) ? 1 : 0;
/* 165 */       boolean bool1 = (paramArrayOfClass.length == arrayOfClass.length && paramArrayOfClass[paramArrayOfClass.length - 1] != null && paramArrayOfClass[paramArrayOfClass.length - 1].isArray()) ? true : false;
/*     */       
/* 167 */       float f1 = 0.001F;
/* 168 */       Class<?> clazz = arrayOfClass[arrayOfClass.length - 1].getComponentType();
/* 169 */       if (b != 0) {
/*     */         
/* 171 */         f += getObjectTransformationCost(clazz, Object.class) + 0.001F;
/* 172 */       } else if (bool1) {
/* 173 */         Class<?> clazz1 = paramArrayOfClass[paramArrayOfClass.length - 1].getComponentType();
/* 174 */         f += getObjectTransformationCost(clazz1, clazz) + 0.001F;
/*     */       } else {
/*     */         
/* 177 */         for (int i = arrayOfClass.length - 1; i < paramArrayOfClass.length; i++) {
/* 178 */           Class<?> clazz1 = paramArrayOfClass[i];
/* 179 */           f += getObjectTransformationCost(clazz1, clazz) + 0.001F;
/*     */         } 
/*     */       } 
/*     */     } 
/* 183 */     return f;
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
/*     */   private static float getObjectTransformationCost(Class<?> paramClass1, Class<?> paramClass2) {
/* 195 */     if (paramClass2.isPrimitive()) {
/* 196 */       return getPrimitivePromotionCost(paramClass1, paramClass2);
/*     */     }
/* 198 */     float f = 0.0F;
/* 199 */     while (paramClass1 != null && !paramClass2.equals(paramClass1)) {
/* 200 */       if (paramClass2.isInterface() && ClassUtils.isAssignable(paramClass1, paramClass2)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 206 */         f += 0.25F;
/*     */         break;
/*     */       } 
/* 209 */       f++;
/* 210 */       paramClass1 = paramClass1.getSuperclass();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 216 */     if (paramClass1 == null) {
/* 217 */       f += 1.5F;
/*     */     }
/* 219 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static float getPrimitivePromotionCost(Class<?> paramClass1, Class<?> paramClass2) {
/* 230 */     if (paramClass1 == null) {
/* 231 */       return 1.5F;
/*     */     }
/* 233 */     float f = 0.0F;
/* 234 */     Class<?> clazz = paramClass1;
/* 235 */     if (!clazz.isPrimitive()) {
/*     */       
/* 237 */       f += 0.1F;
/* 238 */       clazz = ClassUtils.wrapperToPrimitive(clazz);
/*     */     } 
/* 240 */     for (byte b = 0; clazz != paramClass2 && b < ORDERED_PRIMITIVE_TYPES.length; b++) {
/* 241 */       if (clazz == ORDERED_PRIMITIVE_TYPES[b]) {
/* 242 */         f += 0.1F;
/* 243 */         if (b < ORDERED_PRIMITIVE_TYPES.length - 1) {
/* 244 */           clazz = ORDERED_PRIMITIVE_TYPES[b + 1];
/*     */         }
/*     */       } 
/*     */     } 
/* 248 */     return f;
/*     */   }
/*     */   
/*     */   static boolean isMatchingMethod(Method paramMethod, Class<?>[] paramArrayOfClass) {
/* 252 */     return isMatchingExecutable(Executable.of(paramMethod), paramArrayOfClass);
/*     */   }
/*     */   
/*     */   static boolean isMatchingConstructor(Constructor<?> paramConstructor, Class<?>[] paramArrayOfClass) {
/* 256 */     return isMatchingExecutable(Executable.of(paramConstructor), paramArrayOfClass);
/*     */   }
/*     */   
/*     */   private static boolean isMatchingExecutable(Executable paramExecutable, Class<?>[] paramArrayOfClass) {
/* 260 */     Class[] arrayOfClass = paramExecutable.getParameterTypes();
/* 261 */     if (ClassUtils.isAssignable(paramArrayOfClass, arrayOfClass, true)) {
/* 262 */       return true;
/*     */     }
/*     */     
/* 265 */     if (paramExecutable.isVarArgs()) {
/*     */       byte b;
/* 267 */       for (b = 0; b < arrayOfClass.length - 1 && b < paramArrayOfClass.length; b++) {
/* 268 */         if (!ClassUtils.isAssignable(paramArrayOfClass[b], arrayOfClass[b], true)) {
/* 269 */           return false;
/*     */         }
/*     */       } 
/* 272 */       Class<?> clazz = arrayOfClass[arrayOfClass.length - 1].getComponentType();
/* 273 */       for (; b < paramArrayOfClass.length; b++) {
/* 274 */         if (!ClassUtils.isAssignable(paramArrayOfClass[b], clazz, true)) {
/* 275 */           return false;
/*     */         }
/*     */       } 
/* 278 */       return true;
/*     */     } 
/*     */     
/* 281 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class Executable
/*     */   {
/*     */     private final Class<?>[] parameterTypes;
/*     */     
/*     */     private final boolean isVarArgs;
/*     */ 
/*     */     
/*     */     private static Executable of(Method param1Method) {
/* 293 */       return new Executable(param1Method);
/*     */     }
/*     */     
/*     */     private static Executable of(Constructor<?> param1Constructor) {
/* 297 */       return new Executable(param1Constructor);
/*     */     }
/*     */     
/*     */     private Executable(Method param1Method) {
/* 301 */       this.parameterTypes = param1Method.getParameterTypes();
/* 302 */       this.isVarArgs = param1Method.isVarArgs();
/*     */     }
/*     */     
/*     */     private Executable(Constructor<?> param1Constructor) {
/* 306 */       this.parameterTypes = param1Constructor.getParameterTypes();
/* 307 */       this.isVarArgs = param1Constructor.isVarArgs();
/*     */     }
/*     */     
/*     */     public Class<?>[] getParameterTypes() {
/* 311 */       return this.parameterTypes;
/*     */     }
/*     */     
/*     */     public boolean isVarArgs() {
/* 315 */       return this.isVarArgs;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\reflect\MemberUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */