/*     */ package org.junit.c.e;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.junit.b;
/*     */ import org.junit.c.i;
/*     */ import org.junit.f;
/*     */ import org.junit.g;
/*     */ import org.junit.m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public class j
/*     */ {
/*     */   private final Class<?> n;
/*     */   
/*     */   public j(Class<?> paramClass) {
/*  27 */     this.n = paramClass;
/*     */   }
/*     */   
/*     */   public List<Method> bj() {
/*  31 */     return a((Class)m.class);
/*     */   }
/*     */   
/*     */   List<Method> bl() {
/*  35 */     return a((Class)g.class);
/*     */   }
/*     */   
/*     */   List<Method> bm() {
/*  39 */     return a((Class)b.class);
/*     */   }
/*     */   
/*     */   public List<Method> a(Class<? extends Annotation> paramClass) {
/*  43 */     ArrayList<Method> arrayList = new ArrayList();
/*  44 */     for (Class<?> clazz : b(this.n)) {
/*  45 */       Method[] arrayOfMethod = i.a(clazz);
/*  46 */       for (Method method : arrayOfMethod) {
/*  47 */         Object object = method.getAnnotation((Class)paramClass);
/*  48 */         if (object != null && !a(method, arrayList)) {
/*  49 */           arrayList.add(method);
/*     */         }
/*     */       } 
/*     */     } 
/*  53 */     if (m(paramClass)) {
/*  54 */       Collections.reverse(arrayList);
/*     */     }
/*  56 */     return arrayList;
/*     */   }
/*     */   
/*     */   private boolean m(Class<? extends Annotation> paramClass) {
/*  60 */     return (paramClass.equals(f.class) || paramClass.equals(g.class));
/*     */   }
/*     */   
/*     */   private boolean a(Method paramMethod, List<Method> paramList) {
/*  64 */     for (Method method : paramList) {
/*  65 */       if (a(paramMethod, method)) {
/*  66 */         return true;
/*     */       }
/*     */     } 
/*  69 */     return false;
/*     */   }
/*     */   
/*     */   private boolean a(Method paramMethod1, Method paramMethod2) {
/*  73 */     if (!paramMethod2.getName().equals(paramMethod1.getName())) {
/*  74 */       return false;
/*     */     }
/*  76 */     if ((paramMethod2.getParameterTypes()).length != (paramMethod1.getParameterTypes()).length) {
/*  77 */       return false;
/*     */     }
/*  79 */     for (byte b = 0; b < (paramMethod2.getParameterTypes()).length; b++) {
/*  80 */       if (!paramMethod2.getParameterTypes()[b].equals(paramMethod1.getParameterTypes()[b])) {
/*  81 */         return false;
/*     */       }
/*     */     } 
/*  84 */     return true;
/*     */   }
/*     */   
/*     */   private List<Class<?>> b(Class<?> paramClass) {
/*  88 */     ArrayList<Class<?>> arrayList = new ArrayList();
/*  89 */     Class<?> clazz = paramClass;
/*  90 */     while (clazz != null) {
/*  91 */       arrayList.add(clazz);
/*  92 */       clazz = clazz.getSuperclass();
/*     */     } 
/*  94 */     return arrayList;
/*     */   }
/*     */   
/*     */   public Constructor<?> b() throws SecurityException, NoSuchMethodException {
/*  98 */     return this.n.getConstructor(new Class[0]);
/*     */   }
/*     */   
/*     */   public Class<?> getJavaClass() {
/* 102 */     return this.n;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 106 */     return this.n.getName();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\e\j.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */