/*     */ package com.google.a.b;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.c;
/*     */ import java.io.Serializable;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.EnumSet;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.WeakHashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b(cl = true)
/*     */ public final class k
/*     */ {
/*     */   @c
/*     */   public static Field a(Enum<?> paramEnum) {
/*  50 */     Class<?> clazz = paramEnum.getDeclaringClass();
/*     */     try {
/*  52 */       return clazz.getDeclaredField(paramEnum.name());
/*  53 */     } catch (NoSuchFieldException noSuchFieldException) {
/*  54 */       throw new AssertionError(noSuchFieldException);
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
/*     */   public static <T extends Enum<T>> z<T> a(Class<T> paramClass, String paramString) {
/*  67 */     D.checkNotNull(paramClass);
/*  68 */     D.checkNotNull(paramString);
/*  69 */     return C.b(paramClass, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   @c
/*  74 */   private static final Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> E = new WeakHashMap<>();
/*     */ 
/*     */   
/*     */   @c
/*     */   private static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> a(Class<T> paramClass) {
/*  79 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  80 */     for (Enum enum_ : EnumSet.<T>allOf(paramClass)) {
/*  81 */       hashMap.put(enum_.name(), new WeakReference<>(enum_));
/*     */     }
/*  83 */     E.put(paramClass, hashMap);
/*  84 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */   
/*     */   @c
/*     */   static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> b(Class<T> paramClass) {
/*  90 */     synchronized (E) {
/*  91 */       Map<String, WeakReference<? extends Enum<?>>> map = E.get(paramClass);
/*  92 */       if (map == null) {
/*  93 */         map = a(paramClass);
/*     */       }
/*  95 */       return map;
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
/*     */   public static <T extends Enum<T>> i<String, T> a(Class<T> paramClass) {
/* 108 */     return new a<>(paramClass);
/*     */   }
/*     */   
/*     */   private static final class a<T extends Enum<T>>
/*     */     extends i<String, T> implements Serializable {
/*     */     private final Class<T> a;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     a(Class<T> param1Class) {
/* 117 */       this.a = D.<Class<T>>checkNotNull(param1Class);
/*     */     }
/*     */ 
/*     */     
/*     */     protected T a(String param1String) {
/* 122 */       return Enum.valueOf(this.a, param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     protected String a(T param1T) {
/* 127 */       return param1T.name();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 132 */       if (param1Object instanceof a) {
/* 133 */         a a1 = (a)param1Object;
/* 134 */         return this.a.equals(a1.a);
/*     */       } 
/* 136 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 141 */       return this.a.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 146 */       String str = this.a.getName(); return (new StringBuilder(29 + String.valueOf(str).length())).append("Enums.stringConverter(").append(str).append(".class)").toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\b\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */