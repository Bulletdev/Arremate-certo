/*     */ package org.junit.a.e.a;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.junit.a.e.b;
/*     */ import org.junit.a.e.d;
/*     */ import org.junit.a.e.e;
/*     */ import org.junit.a.e.g;
/*     */ import org.junit.d;
/*     */ import org.junit.f.a.b;
/*     */ import org.junit.f.a.d;
/*     */ import org.junit.f.a.m;
/*     */ 
/*     */ public class a
/*     */   extends e
/*     */ {
/*     */   private final m b;
/*     */   
/*     */   static class a
/*     */     extends g {
/*     */     private final d c;
/*     */     
/*     */     private a(d param1d) {
/*  28 */       this.c = param1d;
/*     */     }
/*     */ 
/*     */     
/*     */     public Object getValue() throws g.a {
/*     */       try {
/*  34 */         return this.c.c(null, new Object[0]);
/*  35 */       } catch (IllegalArgumentException illegalArgumentException) {
/*  36 */         throw new RuntimeException("unexpected: argument length is checked");
/*     */       }
/*  38 */       catch (IllegalAccessException illegalAccessException) {
/*  39 */         throw new RuntimeException("unexpected: getMethods returned an inaccessible method");
/*     */       }
/*  41 */       catch (Throwable throwable) {
/*  42 */         org.junit.a.e.a a1 = (org.junit.a.e.a)this.c.getAnnotation(org.junit.a.e.a.class);
/*  43 */         d.aM((a1 == null || !a.b(a1.f(), throwable)));
/*     */         
/*  45 */         throw new g.a(throwable);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public String getDescription() throws g.a {
/*  51 */       return this.c.getName();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a(m paramm) {
/*  61 */     this.b = paramm;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<g> a(d paramd) throws Throwable {
/*  66 */     ArrayList<g> arrayList = new ArrayList();
/*     */     
/*  68 */     d(paramd, arrayList);
/*  69 */     c(paramd, arrayList);
/*  70 */     b(paramd, arrayList);
/*  71 */     a(paramd, arrayList);
/*     */     
/*  73 */     return arrayList;
/*     */   }
/*     */   
/*     */   private void a(d paramd, List<g> paramList) throws Throwable {
/*  77 */     for (d d1 : a(paramd)) {
/*  78 */       Class<?> clazz = d1.getReturnType();
/*     */       
/*  80 */       if ((clazz.isArray() && paramd.i(clazz.getComponentType())) || Iterable.class.isAssignableFrom(clazz)) {
/*     */         
/*     */         try {
/*  83 */           a(clazz, paramd, d1.getName(), paramList, d1.c(null, new Object[0]));
/*     */         }
/*  85 */         catch (Throwable throwable) {
/*  86 */           b b = (b)d1.getAnnotation(b.class);
/*  87 */           if (b != null && a(b.f(), throwable)) {
/*     */             return;
/*     */           }
/*  90 */           throw throwable;
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void b(d paramd, List<g> paramList) {
/*  98 */     for (d d1 : d(paramd)) {
/*  99 */       if (paramd.h(d1.getType())) {
/* 100 */         paramList.add(new a(d1));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void c(d paramd, List<g> paramList) {
/* 106 */     for (Field field : c(paramd)) {
/* 107 */       Class<?> clazz = field.getType();
/* 108 */       a(clazz, paramd, field.getName(), paramList, a(field));
/*     */     } 
/*     */   }
/*     */   
/*     */   private void d(d paramd, List<g> paramList) {
/* 113 */     for (Field field : b(paramd)) {
/* 114 */       Object object = a(field);
/*     */       
/* 116 */       if (paramd.H(object)) {
/* 117 */         paramList.add(g.a(field.getName(), object));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(Class<?> paramClass, d paramd, String paramString, List<g> paramList, Object paramObject) {
/* 124 */     if (paramClass.isArray()) {
/* 125 */       a(paramd, paramString, paramList, paramObject);
/*     */     }
/* 127 */     else if (Iterable.class.isAssignableFrom(paramClass)) {
/* 128 */       a(paramd, paramString, paramList, (Iterable)paramObject);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(d paramd, String paramString, List<g> paramList, Object paramObject) {
/* 133 */     for (byte b = 0; b < Array.getLength(paramObject); b++) {
/* 134 */       Object object = Array.get(paramObject, b);
/* 135 */       if (paramd.H(object)) {
/* 136 */         paramList.add(g.a(paramString + "[" + b + "]", object));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(d paramd, String paramString, List<g> paramList, Iterable<?> paramIterable) {
/* 142 */     Iterator<?> iterator = paramIterable.iterator();
/* 143 */     byte b = 0;
/* 144 */     while (iterator.hasNext()) {
/* 145 */       Object object = iterator.next();
/* 146 */       if (paramd.H(object)) {
/* 147 */         paramList.add(g.a(paramString + "[" + b + "]", object));
/*     */       }
/* 149 */       b++;
/*     */     } 
/*     */   }
/*     */   
/*     */   private Object a(Field paramField) {
/*     */     try {
/* 155 */       return paramField.get(null);
/* 156 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 157 */       throw new RuntimeException("unexpected: field from getClass doesn't exist on object");
/*     */     }
/* 159 */     catch (IllegalAccessException illegalAccessException) {
/* 160 */       throw new RuntimeException("unexpected: getFields returned an inaccessible field");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean a(Class<?>[] paramArrayOfClass, Object paramObject) {
/* 166 */     for (Class<?> clazz : paramArrayOfClass) {
/* 167 */       if (clazz.isAssignableFrom(paramObject.getClass())) {
/* 168 */         return true;
/*     */       }
/*     */     } 
/* 171 */     return false;
/*     */   }
/*     */   
/*     */   protected Collection<d> a(d paramd) {
/* 175 */     return this.b.a(b.class);
/*     */   }
/*     */   
/*     */   protected Collection<Field> b(d paramd) {
/* 179 */     List list = this.b.c(org.junit.a.e.a.class);
/* 180 */     ArrayList<Field> arrayList = new ArrayList();
/*     */     
/* 182 */     for (b b : list) {
/* 183 */       arrayList.add(b.getField());
/*     */     }
/*     */     
/* 186 */     return arrayList;
/*     */   }
/*     */   
/*     */   protected Collection<Field> c(d paramd) {
/* 190 */     List list = this.b.c(b.class);
/* 191 */     ArrayList<Field> arrayList = new ArrayList();
/*     */     
/* 193 */     for (b b : list) {
/* 194 */       arrayList.add(b.getField());
/*     */     }
/*     */     
/* 197 */     return arrayList;
/*     */   }
/*     */   
/*     */   protected Collection<d> d(d paramd) {
/* 201 */     return this.b.a(org.junit.a.e.a.class);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\a\e\a\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */