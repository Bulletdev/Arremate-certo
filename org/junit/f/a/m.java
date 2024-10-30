/*     */ package org.junit.f.a;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.junit.c;
/*     */ import org.junit.c.i;
/*     */ import org.junit.f;
/*     */ import org.junit.g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class m
/*     */   implements a
/*     */ {
/*  32 */   private static final a a = new a();
/*  33 */   private static final b a = new b();
/*     */ 
/*     */   
/*     */   private final Class<?> clazz;
/*     */ 
/*     */   
/*     */   private final Map<Class<? extends Annotation>, List<d>> aA;
/*     */ 
/*     */   
/*     */   private final Map<Class<? extends Annotation>, List<b>> aB;
/*     */ 
/*     */   
/*     */   public m(Class<?> paramClass) {
/*  46 */     this.clazz = paramClass;
/*  47 */     if (paramClass != null && (paramClass.getConstructors()).length > 1) {
/*  48 */       throw new IllegalArgumentException("Test class can only have one constructor");
/*     */     }
/*     */ 
/*     */     
/*  52 */     LinkedHashMap<Object, Object> linkedHashMap1 = new LinkedHashMap<Object, Object>();
/*     */     
/*  54 */     LinkedHashMap<Object, Object> linkedHashMap2 = new LinkedHashMap<Object, Object>();
/*     */ 
/*     */     
/*  57 */     c((Map)linkedHashMap1, (Map)linkedHashMap2);
/*     */     
/*  59 */     this.aA = c((Map)linkedHashMap1);
/*  60 */     this.aB = c((Map)linkedHashMap2);
/*     */   }
/*     */   
/*     */   protected void c(Map<Class<? extends Annotation>, List<d>> paramMap, Map<Class<? extends Annotation>, List<b>> paramMap1) {
/*  64 */     for (Class<?> clazz : b(this.clazz)) {
/*  65 */       for (Method method : i.a(clazz)) {
/*  66 */         a(new d(method), paramMap);
/*     */       }
/*     */ 
/*     */       
/*  70 */       for (Field field : a(clazz)) {
/*  71 */         a(new b(field), paramMap1);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Field[] a(Class<?> paramClass) {
/*  77 */     Field[] arrayOfField = paramClass.getDeclaredFields();
/*  78 */     Arrays.sort(arrayOfField, a);
/*  79 */     return arrayOfField;
/*     */   }
/*     */ 
/*     */   
/*     */   protected static <T extends c<T>> void a(T paramT, Map<Class<? extends Annotation>, List<T>> paramMap) {
/*  84 */     for (Annotation annotation : paramT.getAnnotations()) {
/*  85 */       Class<? extends Annotation> clazz = annotation.annotationType();
/*  86 */       List<T> list = a(paramMap, clazz, true);
/*  87 */       T t = (T)paramT.a((List)list);
/*  88 */       if (t == null) {
/*     */         return;
/*     */       }
/*  91 */       if (m(clazz)) {
/*  92 */         list.add(0, t);
/*     */       } else {
/*  94 */         list.add(t);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static <T extends c<T>> Map<Class<? extends Annotation>, List<T>> c(Map<Class<? extends Annotation>, List<T>> paramMap) {
/* 101 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/*     */     
/* 103 */     for (Map.Entry<Class<? extends Annotation>, List<T>> entry : paramMap.entrySet()) {
/* 104 */       linkedHashMap.put(entry.getKey(), Collections.unmodifiableList((List)entry.getValue()));
/*     */     }
/* 106 */     return (Map)Collections.unmodifiableMap(linkedHashMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<d> bx() {
/* 116 */     List<d> list = a(this.aA);
/* 117 */     Collections.sort(list, a);
/* 118 */     return list;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<d> a(Class<? extends Annotation> paramClass) {
/* 127 */     return Collections.unmodifiableList(a(this.aA, paramClass, false));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<b> by() {
/* 137 */     return a(this.aB);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<b> c(Class<? extends Annotation> paramClass) {
/* 146 */     return Collections.unmodifiableList(a(this.aB, paramClass, false));
/*     */   }
/*     */   
/*     */   private <T> List<T> a(Map<?, List<T>> paramMap) {
/* 150 */     LinkedHashSet<? extends T> linkedHashSet = new LinkedHashSet();
/* 151 */     for (List<T> list : paramMap.values()) {
/* 152 */       linkedHashSet.addAll(list);
/*     */     }
/* 154 */     return new ArrayList<T>(linkedHashSet);
/*     */   }
/*     */ 
/*     */   
/*     */   private static <T> List<T> a(Map<Class<? extends Annotation>, List<T>> paramMap, Class<? extends Annotation> paramClass, boolean paramBoolean) {
/* 159 */     if (!paramMap.containsKey(paramClass) && paramBoolean) {
/* 160 */       paramMap.put(paramClass, new ArrayList<T>());
/*     */     }
/* 162 */     List<T> list = paramMap.get(paramClass);
/* 163 */     return (list == null) ? Collections.<T>emptyList() : list;
/*     */   }
/*     */   
/*     */   private static boolean m(Class<? extends Annotation> paramClass) {
/* 167 */     return (paramClass.equals(f.class) || paramClass.equals(g.class));
/*     */   }
/*     */ 
/*     */   
/*     */   private static List<Class<?>> b(Class<?> paramClass) {
/* 172 */     ArrayList<Class<?>> arrayList = new ArrayList();
/* 173 */     Class<?> clazz = paramClass;
/* 174 */     while (clazz != null) {
/* 175 */       arrayList.add(clazz);
/* 176 */       clazz = clazz.getSuperclass();
/*     */     } 
/* 178 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> getJavaClass() {
/* 185 */     return this.clazz;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 192 */     if (this.clazz == null) {
/* 193 */       return "null";
/*     */     }
/* 195 */     return this.clazz.getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Constructor<?> c() {
/* 204 */     Constructor[] arrayOfConstructor = (Constructor[])this.clazz.getConstructors();
/* 205 */     c.c(1L, arrayOfConstructor.length);
/* 206 */     return arrayOfConstructor[0];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Annotation[] getAnnotations() {
/* 213 */     if (this.clazz == null) {
/* 214 */       return new Annotation[0];
/*     */     }
/* 216 */     return this.clazz.getAnnotations();
/*     */   }
/*     */   
/*     */   public <T extends Annotation> T getAnnotation(Class<T> paramClass) {
/* 220 */     if (this.clazz == null) {
/* 221 */       return null;
/*     */     }
/* 223 */     return this.clazz.getAnnotation(paramClass);
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> List<T> a(Object paramObject, Class<? extends Annotation> paramClass, Class<T> paramClass1) {
/* 228 */     ArrayList<T> arrayList = new ArrayList();
/* 229 */     a(paramObject, paramClass, paramClass1, new g<T>(this, arrayList)
/*     */         {
/*     */           public void a(c<?> param1c, T param1T) {
/* 232 */             this.aV.add(param1T);
/*     */           }
/*     */         });
/* 235 */     return arrayList;
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
/*     */   public <T> void a(Object paramObject, Class<? extends Annotation> paramClass, Class<T> paramClass1, g<T> paramg) {
/* 247 */     for (b b1 : c(paramClass)) {
/*     */       try {
/* 249 */         Object object = b1.get(paramObject);
/* 250 */         if (paramClass1.isInstance(object)) {
/* 251 */           paramg.a(b1, paramClass1.cast(object));
/*     */         }
/* 253 */       } catch (IllegalAccessException illegalAccessException) {
/* 254 */         throw new RuntimeException("How did getFields return a field we couldn't access?", illegalAccessException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> List<T> b(Object paramObject, Class<? extends Annotation> paramClass, Class<T> paramClass1) {
/* 262 */     ArrayList<T> arrayList = new ArrayList();
/* 263 */     b(paramObject, paramClass, paramClass1, new g<T>(this, arrayList)
/*     */         {
/*     */           public void a(c<?> param1c, T param1T) {
/* 266 */             this.aV.add(param1T);
/*     */           }
/*     */         });
/* 269 */     return arrayList;
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
/*     */   public <T> void b(Object paramObject, Class<? extends Annotation> paramClass, Class<T> paramClass1, g<T> paramg) {
/* 281 */     for (d d : a(paramClass)) {
/*     */ 
/*     */       
/*     */       try {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 291 */         if (paramClass1.isAssignableFrom(d.getReturnType())) {
/* 292 */           Object object = d.c(paramObject, new Object[0]);
/* 293 */           paramg.a(d, paramClass1.cast(object));
/*     */         } 
/* 295 */       } catch (Throwable throwable) {
/* 296 */         throw new RuntimeException("Exception in " + d.getName(), throwable);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPublic() {
/* 303 */     return Modifier.isPublic(this.clazz.getModifiers());
/*     */   }
/*     */   
/*     */   public boolean gz() {
/* 307 */     return (this.clazz.isMemberClass() && !Modifier.isStatic(this.clazz.getModifiers()));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 312 */     return (this.clazz == null) ? 0 : this.clazz.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 317 */     if (this == paramObject) {
/* 318 */       return true;
/*     */     }
/* 320 */     if (paramObject == null) {
/* 321 */       return false;
/*     */     }
/* 323 */     if (getClass() != paramObject.getClass()) {
/* 324 */       return false;
/*     */     }
/* 326 */     m m1 = (m)paramObject;
/* 327 */     return (this.clazz == m1.clazz);
/*     */   }
/*     */   
/*     */   private static class a
/*     */     implements Comparator<Field> {
/*     */     private a() {}
/*     */     
/*     */     public int a(Field param1Field1, Field param1Field2) {
/* 335 */       return param1Field1.getName().compareTo(param1Field2.getName());
/*     */     }
/*     */   }
/*     */   
/*     */   private static class b
/*     */     implements Comparator<d>
/*     */   {
/*     */     private b() {}
/*     */     
/*     */     public int a(d param1d1, d param1d2) {
/* 345 */       return i.k.compare(param1d1.getMethod(), param1d2.getMethod());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\f\a\m.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */