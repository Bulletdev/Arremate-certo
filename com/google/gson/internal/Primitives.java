/*     */ package com.google.gson.internal;
/*     */ 
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Primitives
/*     */ {
/*     */   private static final Map<Class<?>, Class<?>> PRIMITIVE_TO_WRAPPER_TYPE;
/*     */   private static final Map<Class<?>, Class<?>> WRAPPER_TO_PRIMITIVE_TYPE;
/*     */   
/*     */   private Primitives() {
/*  33 */     throw new UnsupportedOperationException();
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
/*     */   static {
/*  45 */     HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>(16);
/*  46 */     HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>(16);
/*     */     
/*  48 */     add((Map)hashMap1, (Map)hashMap2, boolean.class, Boolean.class);
/*  49 */     add((Map)hashMap1, (Map)hashMap2, byte.class, Byte.class);
/*  50 */     add((Map)hashMap1, (Map)hashMap2, char.class, Character.class);
/*  51 */     add((Map)hashMap1, (Map)hashMap2, double.class, Double.class);
/*  52 */     add((Map)hashMap1, (Map)hashMap2, float.class, Float.class);
/*  53 */     add((Map)hashMap1, (Map)hashMap2, int.class, Integer.class);
/*  54 */     add((Map)hashMap1, (Map)hashMap2, long.class, Long.class);
/*  55 */     add((Map)hashMap1, (Map)hashMap2, short.class, Short.class);
/*  56 */     add((Map)hashMap1, (Map)hashMap2, void.class, Void.class);
/*     */     
/*  58 */     PRIMITIVE_TO_WRAPPER_TYPE = Collections.unmodifiableMap(hashMap1);
/*  59 */     WRAPPER_TO_PRIMITIVE_TYPE = Collections.unmodifiableMap(hashMap2);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void add(Map<Class<?>, Class<?>> paramMap1, Map<Class<?>, Class<?>> paramMap2, Class<?> paramClass1, Class<?> paramClass2) {
/*  64 */     paramMap1.put(paramClass1, paramClass2);
/*  65 */     paramMap2.put(paramClass2, paramClass1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isPrimitive(Type paramType) {
/*  72 */     return PRIMITIVE_TO_WRAPPER_TYPE.containsKey(paramType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isWrapperType(Type paramType) {
/*  82 */     return WRAPPER_TO_PRIMITIVE_TYPE.containsKey(
/*  83 */         $Gson$Preconditions.checkNotNull(paramType));
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
/*     */   public static <T> Class<T> wrap(Class<T> paramClass) {
/*  98 */     Class<T> clazz = (Class)PRIMITIVE_TO_WRAPPER_TYPE.get(
/*  99 */         $Gson$Preconditions.checkNotNull(paramClass));
/* 100 */     return (clazz == null) ? paramClass : clazz;
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
/*     */   public static <T> Class<T> unwrap(Class<T> paramClass) {
/* 115 */     Class<T> clazz = (Class)WRAPPER_TO_PRIMITIVE_TYPE.get(
/* 116 */         $Gson$Preconditions.checkNotNull(paramClass));
/* 117 */     return (clazz == null) ? paramClass : clazz;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\Primitives.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */