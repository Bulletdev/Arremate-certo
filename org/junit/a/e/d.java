/*     */ package org.junit.a.e;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class d
/*     */ {
/*  15 */   private static final Map<Class<?>, Class<?>> az = U(); private final Class<?> type;
/*     */   
/*     */   private static Map<Class<?>, Class<?>> U() {
/*  18 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*     */     
/*  20 */     a(hashMap, boolean.class, Boolean.class);
/*  21 */     a(hashMap, byte.class, Byte.class);
/*  22 */     a(hashMap, short.class, Short.class);
/*  23 */     a(hashMap, char.class, Character.class);
/*  24 */     a(hashMap, int.class, Integer.class);
/*  25 */     a(hashMap, long.class, Long.class);
/*  26 */     a(hashMap, float.class, Float.class);
/*  27 */     a(hashMap, double.class, Double.class);
/*     */     
/*  29 */     return (Map)Collections.unmodifiableMap(hashMap);
/*     */   }
/*     */   private final Annotation[] a;
/*     */   private static <T> void a(Map<T, T> paramMap, T paramT1, T paramT2) {
/*  33 */     paramMap.put(paramT1, paramT2);
/*  34 */     paramMap.put(paramT2, paramT1);
/*     */   }
/*     */   
/*     */   public static ArrayList<d> a(Method paramMethod) {
/*  38 */     return a(paramMethod.getParameterTypes(), paramMethod.getParameterAnnotations());
/*     */   }
/*     */ 
/*     */   
/*     */   public static List<d> a(Constructor<?> paramConstructor) {
/*  43 */     return a(paramConstructor.getParameterTypes(), paramConstructor.getParameterAnnotations());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static ArrayList<d> a(Class<?>[] paramArrayOfClass, Annotation[][] paramArrayOfAnnotation) {
/*  49 */     ArrayList<d> arrayList = new ArrayList();
/*  50 */     for (byte b = 0; b < paramArrayOfClass.length; b++) {
/*  51 */       arrayList.add(new d(paramArrayOfClass[b], paramArrayOfAnnotation[b]));
/*     */     }
/*     */     
/*  54 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private d(Class<?> paramClass, Annotation[] paramArrayOfAnnotation) {
/*  62 */     this.type = paramClass;
/*  63 */     this.a = paramArrayOfAnnotation;
/*     */   }
/*     */   
/*     */   public boolean H(Object paramObject) {
/*  67 */     return (paramObject == null) ? (!this.type.isPrimitive()) : h(paramObject.getClass());
/*     */   }
/*     */   
/*     */   public boolean h(Class<?> paramClass) {
/*  71 */     return (this.type.isAssignableFrom(paramClass) || a(this.type, paramClass));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean i(Class<?> paramClass) {
/*  76 */     return (paramClass.isAssignableFrom(this.type) || a(paramClass, this.type) || h(paramClass));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean a(Class<?> paramClass1, Class<?> paramClass2) {
/*  82 */     if (az.containsKey(paramClass2)) {
/*  83 */       Class<?> clazz = az.get(paramClass2);
/*  84 */       return paramClass1.isAssignableFrom(clazz);
/*     */     } 
/*  86 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<?> getType() {
/*  91 */     return this.type;
/*     */   }
/*     */   
/*     */   public List<Annotation> be() {
/*  95 */     return Arrays.asList(this.a);
/*     */   }
/*     */   
/*     */   public boolean j(Class<? extends Annotation> paramClass) {
/*  99 */     return (getAnnotation(paramClass) != null);
/*     */   }
/*     */   
/*     */   public <T extends Annotation> T a(Class<T> paramClass) {
/* 103 */     Annotation[] arrayOfAnnotation = this.a;
/* 104 */     return a(arrayOfAnnotation, paramClass, 3);
/*     */   }
/*     */ 
/*     */   
/*     */   private <T extends Annotation> T a(Annotation[] paramArrayOfAnnotation, Class<T> paramClass, int paramInt) {
/* 109 */     if (paramInt == 0) {
/* 110 */       return null;
/*     */     }
/* 112 */     for (Annotation annotation : paramArrayOfAnnotation) {
/* 113 */       if (paramClass.isInstance(annotation)) {
/* 114 */         return paramClass.cast(annotation);
/*     */       }
/* 116 */       Object object = a(annotation.annotationType().getAnnotations(), (Class)paramClass, paramInt - 1);
/*     */       
/* 118 */       if (object != null) {
/* 119 */         return paramClass.cast(object);
/*     */       }
/*     */     } 
/*     */     
/* 123 */     return null;
/*     */   }
/*     */   
/*     */   public <T extends Annotation> T getAnnotation(Class<T> paramClass) {
/* 127 */     for (Annotation annotation : be()) {
/* 128 */       if (paramClass.isInstance(annotation)) {
/* 129 */         return paramClass.cast(annotation);
/*     */       }
/*     */     } 
/* 132 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\a\e\d.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */