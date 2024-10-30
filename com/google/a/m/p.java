/*     */ package com.google.a.m;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @c
/*     */ public final class p
/*     */ {
/*     */   private static final Map<Class<?>, Class<?>> PRIMITIVE_TO_WRAPPER_TYPE;
/*     */   private static final Map<Class<?>, Class<?>> WRAPPER_TO_PRIMITIVE_TYPE;
/*     */   
/*     */   static {
/*  45 */     LinkedHashMap<Object, Object> linkedHashMap1 = new LinkedHashMap<>(16);
/*  46 */     LinkedHashMap<Object, Object> linkedHashMap2 = new LinkedHashMap<>(16);
/*     */     
/*  48 */     add((Map)linkedHashMap1, (Map)linkedHashMap2, boolean.class, Boolean.class);
/*  49 */     add((Map)linkedHashMap1, (Map)linkedHashMap2, byte.class, Byte.class);
/*  50 */     add((Map)linkedHashMap1, (Map)linkedHashMap2, char.class, Character.class);
/*  51 */     add((Map)linkedHashMap1, (Map)linkedHashMap2, double.class, Double.class);
/*  52 */     add((Map)linkedHashMap1, (Map)linkedHashMap2, float.class, Float.class);
/*  53 */     add((Map)linkedHashMap1, (Map)linkedHashMap2, int.class, Integer.class);
/*  54 */     add((Map)linkedHashMap1, (Map)linkedHashMap2, long.class, Long.class);
/*  55 */     add((Map)linkedHashMap1, (Map)linkedHashMap2, short.class, Short.class);
/*  56 */     add((Map)linkedHashMap1, (Map)linkedHashMap2, void.class, Void.class);
/*     */     
/*  58 */     PRIMITIVE_TO_WRAPPER_TYPE = Collections.unmodifiableMap(linkedHashMap1);
/*  59 */     WRAPPER_TO_PRIMITIVE_TYPE = Collections.unmodifiableMap(linkedHashMap2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void add(Map<Class<?>, Class<?>> paramMap1, Map<Class<?>, Class<?>> paramMap2, Class<?> paramClass1, Class<?> paramClass2) {
/*  67 */     paramMap1.put(paramClass1, paramClass2);
/*  68 */     paramMap2.put(paramClass2, paramClass1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Set<Class<?>> E() {
/*  79 */     return PRIMITIVE_TO_WRAPPER_TYPE.keySet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Set<Class<?>> F() {
/*  88 */     return WRAPPER_TO_PRIMITIVE_TYPE.keySet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean b(Class<?> paramClass) {
/*  98 */     return WRAPPER_TO_PRIMITIVE_TYPE.containsKey(D.checkNotNull(paramClass));
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
/*     */   public static <T> Class<T> wrap(Class<T> paramClass) {
/* 112 */     D.checkNotNull(paramClass);
/*     */ 
/*     */ 
/*     */     
/* 116 */     Class<T> clazz = (Class)PRIMITIVE_TO_WRAPPER_TYPE.get(paramClass);
/* 117 */     return (clazz == null) ? paramClass : clazz;
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
/*     */   public static <T> Class<T> unwrap(Class<T> paramClass) {
/* 131 */     D.checkNotNull(paramClass);
/*     */ 
/*     */ 
/*     */     
/* 135 */     Class<T> clazz = (Class)WRAPPER_TO_PRIMITIVE_TYPE.get(paramClass);
/* 136 */     return (clazz == null) ? paramClass : clazz;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\m\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */