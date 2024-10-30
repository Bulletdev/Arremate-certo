/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Arrays;
/*     */ import org.apache.commons.lang3.builder.ToStringBuilder;
/*     */ import org.apache.commons.lang3.builder.ToStringStyle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AnnotationUtils
/*     */ {
/*  50 */   private static final ToStringStyle TO_STRING_STYLE = new ToStringStyle()
/*     */     {
/*     */       private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected String getShortClassName(Class<?> param1Class) {
/*  72 */         for (Class<?> clazz : ClassUtils.getAllInterfaces(param1Class)) {
/*  73 */           if (Annotation.class.isAssignableFrom(clazz)) {
/*  74 */             return "@" + clazz.getName();
/*     */           }
/*     */         } 
/*  77 */         return "";
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected void appendDetail(StringBuffer param1StringBuffer, String param1String, Object param1Object) {
/*  85 */         if (param1Object instanceof Annotation) {
/*  86 */           param1Object = AnnotationUtils.toString((Annotation)param1Object);
/*     */         }
/*  88 */         super.appendDetail(param1StringBuffer, param1String, param1Object);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean equals(Annotation paramAnnotation1, Annotation paramAnnotation2) {
/* 116 */     if (paramAnnotation1 == paramAnnotation2) {
/* 117 */       return true;
/*     */     }
/* 119 */     if (paramAnnotation1 == null || paramAnnotation2 == null) {
/* 120 */       return false;
/*     */     }
/* 122 */     Class<? extends Annotation> clazz1 = paramAnnotation1.annotationType();
/* 123 */     Class<? extends Annotation> clazz2 = paramAnnotation2.annotationType();
/* 124 */     Validate.notNull(clazz1, "Annotation %s with null annotationType()", new Object[] { paramAnnotation1 });
/* 125 */     Validate.notNull(clazz2, "Annotation %s with null annotationType()", new Object[] { paramAnnotation2 });
/* 126 */     if (!clazz1.equals(clazz2)) {
/* 127 */       return false;
/*     */     }
/*     */     try {
/* 130 */       for (Method method : clazz1.getDeclaredMethods()) {
/* 131 */         if ((method.getParameterTypes()).length == 0 && 
/* 132 */           isValidAnnotationMemberType(method.getReturnType())) {
/* 133 */           Object object1 = method.invoke(paramAnnotation1, new Object[0]);
/* 134 */           Object object2 = method.invoke(paramAnnotation2, new Object[0]);
/* 135 */           if (!memberEquals(method.getReturnType(), object1, object2)) {
/* 136 */             return false;
/*     */           }
/*     */         } 
/*     */       } 
/* 140 */     } catch (IllegalAccessException|java.lang.reflect.InvocationTargetException illegalAccessException) {
/* 141 */       return false;
/*     */     } 
/* 143 */     return true;
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
/*     */   public static int hashCode(Annotation paramAnnotation) {
/* 159 */     int i = 0;
/* 160 */     Class<? extends Annotation> clazz = paramAnnotation.annotationType();
/* 161 */     for (Method method : clazz.getDeclaredMethods()) {
/*     */       try {
/* 163 */         Object object = method.invoke(paramAnnotation, new Object[0]);
/* 164 */         if (object == null) {
/* 165 */           throw new IllegalStateException(
/* 166 */               String.format("Annotation method %s returned null", new Object[] { method }));
/*     */         }
/* 168 */         i += hashMember(method.getName(), object);
/* 169 */       } catch (RuntimeException runtimeException) {
/* 170 */         throw runtimeException;
/* 171 */       } catch (Exception exception) {
/* 172 */         throw new RuntimeException(exception);
/*     */       } 
/*     */     } 
/* 175 */     return i;
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
/*     */   public static String toString(Annotation paramAnnotation) {
/* 187 */     ToStringBuilder toStringBuilder = new ToStringBuilder(paramAnnotation, TO_STRING_STYLE);
/* 188 */     for (Method method : paramAnnotation.annotationType().getDeclaredMethods()) {
/* 189 */       if ((method.getParameterTypes()).length <= 0)
/*     */         
/*     */         try {
/*     */           
/* 193 */           toStringBuilder.append(method.getName(), method.invoke(paramAnnotation, new Object[0]));
/* 194 */         } catch (RuntimeException runtimeException) {
/* 195 */           throw runtimeException;
/* 196 */         } catch (Exception exception) {
/* 197 */           throw new RuntimeException(exception);
/*     */         }  
/*     */     } 
/* 200 */     return toStringBuilder.build();
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
/*     */   public static boolean isValidAnnotationMemberType(Class<?> paramClass) {
/* 215 */     if (paramClass == null) {
/* 216 */       return false;
/*     */     }
/* 218 */     if (paramClass.isArray()) {
/* 219 */       paramClass = paramClass.getComponentType();
/*     */     }
/* 221 */     return (paramClass.isPrimitive() || paramClass.isEnum() || paramClass.isAnnotation() || String.class
/* 222 */       .equals(paramClass) || Class.class.equals(paramClass));
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
/*     */   private static int hashMember(String paramString, Object paramObject) {
/* 234 */     int i = paramString.hashCode() * 127;
/* 235 */     if (paramObject.getClass().isArray()) {
/* 236 */       return i ^ arrayMemberHash(paramObject.getClass().getComponentType(), paramObject);
/*     */     }
/* 238 */     if (paramObject instanceof Annotation) {
/* 239 */       return i ^ hashCode((Annotation)paramObject);
/*     */     }
/* 241 */     return i ^ paramObject.hashCode();
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
/*     */   private static boolean memberEquals(Class<?> paramClass, Object paramObject1, Object paramObject2) {
/* 255 */     if (paramObject1 == paramObject2) {
/* 256 */       return true;
/*     */     }
/* 258 */     if (paramObject1 == null || paramObject2 == null) {
/* 259 */       return false;
/*     */     }
/* 261 */     if (paramClass.isArray()) {
/* 262 */       return arrayMemberEquals(paramClass.getComponentType(), paramObject1, paramObject2);
/*     */     }
/* 264 */     if (paramClass.isAnnotation()) {
/* 265 */       return equals((Annotation)paramObject1, (Annotation)paramObject2);
/*     */     }
/* 267 */     return paramObject1.equals(paramObject2);
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
/*     */   private static boolean arrayMemberEquals(Class<?> paramClass, Object paramObject1, Object paramObject2) {
/* 279 */     if (paramClass.isAnnotation()) {
/* 280 */       return annotationArrayMemberEquals((Annotation[])paramObject1, (Annotation[])paramObject2);
/*     */     }
/* 282 */     if (paramClass.equals(byte.class)) {
/* 283 */       return Arrays.equals((byte[])paramObject1, (byte[])paramObject2);
/*     */     }
/* 285 */     if (paramClass.equals(short.class)) {
/* 286 */       return Arrays.equals((short[])paramObject1, (short[])paramObject2);
/*     */     }
/* 288 */     if (paramClass.equals(int.class)) {
/* 289 */       return Arrays.equals((int[])paramObject1, (int[])paramObject2);
/*     */     }
/* 291 */     if (paramClass.equals(char.class)) {
/* 292 */       return Arrays.equals((char[])paramObject1, (char[])paramObject2);
/*     */     }
/* 294 */     if (paramClass.equals(long.class)) {
/* 295 */       return Arrays.equals((long[])paramObject1, (long[])paramObject2);
/*     */     }
/* 297 */     if (paramClass.equals(float.class)) {
/* 298 */       return Arrays.equals((float[])paramObject1, (float[])paramObject2);
/*     */     }
/* 300 */     if (paramClass.equals(double.class)) {
/* 301 */       return Arrays.equals((double[])paramObject1, (double[])paramObject2);
/*     */     }
/* 303 */     if (paramClass.equals(boolean.class)) {
/* 304 */       return Arrays.equals((boolean[])paramObject1, (boolean[])paramObject2);
/*     */     }
/* 306 */     return Arrays.equals((Object[])paramObject1, (Object[])paramObject2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean annotationArrayMemberEquals(Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2) {
/* 317 */     if (paramArrayOfAnnotation1.length != paramArrayOfAnnotation2.length) {
/* 318 */       return false;
/*     */     }
/* 320 */     for (byte b = 0; b < paramArrayOfAnnotation1.length; b++) {
/* 321 */       if (!equals(paramArrayOfAnnotation1[b], paramArrayOfAnnotation2[b])) {
/* 322 */         return false;
/*     */       }
/*     */     } 
/* 325 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int arrayMemberHash(Class<?> paramClass, Object paramObject) {
/* 336 */     if (paramClass.equals(byte.class)) {
/* 337 */       return Arrays.hashCode((byte[])paramObject);
/*     */     }
/* 339 */     if (paramClass.equals(short.class)) {
/* 340 */       return Arrays.hashCode((short[])paramObject);
/*     */     }
/* 342 */     if (paramClass.equals(int.class)) {
/* 343 */       return Arrays.hashCode((int[])paramObject);
/*     */     }
/* 345 */     if (paramClass.equals(char.class)) {
/* 346 */       return Arrays.hashCode((char[])paramObject);
/*     */     }
/* 348 */     if (paramClass.equals(long.class)) {
/* 349 */       return Arrays.hashCode((long[])paramObject);
/*     */     }
/* 351 */     if (paramClass.equals(float.class)) {
/* 352 */       return Arrays.hashCode((float[])paramObject);
/*     */     }
/* 354 */     if (paramClass.equals(double.class)) {
/* 355 */       return Arrays.hashCode((double[])paramObject);
/*     */     }
/* 357 */     if (paramClass.equals(boolean.class)) {
/* 358 */       return Arrays.hashCode((boolean[])paramObject);
/*     */     }
/* 360 */     return Arrays.hashCode((Object[])paramObject);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\AnnotationUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */