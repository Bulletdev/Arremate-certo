/*     */ package org.junit.f.a;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.junit.c.e.b;
/*     */ import org.junit.runner.a.d;
/*     */ import org.junit.runner.a.h;
/*     */ import org.junit.runner.c;
/*     */ import org.junit.runner.h;
/*     */ import org.junit.runner.m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class j
/*     */ {
/*  44 */   private final Set<Class<?>> L = new HashSet<Class<?>>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract m a(Class<?> paramClass) throws Throwable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public m b(Class<?> paramClass) {
/*     */     try {
/*  70 */       m m = a(paramClass);
/*  71 */       if (m != null) {
/*  72 */         a(m);
/*     */       }
/*  74 */       return m;
/*  75 */     } catch (Throwable throwable) {
/*  76 */       return (m)new b(paramClass, throwable);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(m paramm) throws d {
/*  81 */     c c = paramm.a();
/*  82 */     h h = (h)c.getAnnotation(h.class);
/*  83 */     if (h != null) {
/*  84 */       h h1 = h.a(h.value(), c);
/*  85 */       h1.I(paramm);
/*     */     } 
/*     */   }
/*     */   
/*     */   Class<?> h(Class<?> paramClass) throws e {
/*  90 */     if (!this.L.add(paramClass)) {
/*  91 */       throw new e(String.format("class '%s' (possibly indirectly) contains itself as a SuiteClass", new Object[] { paramClass.getName() }));
/*     */     }
/*  93 */     return paramClass;
/*     */   }
/*     */   
/*     */   void h(Class<?> paramClass) {
/*  97 */     this.L.remove(paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<m> a(Class<?> paramClass, Class<?>[] paramArrayOfClass) throws e {
/* 108 */     h(paramClass);
/*     */     
/*     */     try {
/* 111 */       return a(paramArrayOfClass);
/*     */     } finally {
/* 113 */       h(paramClass);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<m> a(Class<?> paramClass, List<Class<?>> paramList) throws e {
/* 119 */     return a(paramClass, (Class[])paramList.<Class<?>[]>toArray((Class<?>[][])new Class[0]));
/*     */   }
/*     */   
/*     */   private List<m> a(Class<?>[] paramArrayOfClass) {
/* 123 */     ArrayList<m> arrayList = new ArrayList();
/* 124 */     for (Class<?> clazz : paramArrayOfClass) {
/* 125 */       m m = b(clazz);
/* 126 */       if (m != null) {
/* 127 */         arrayList.add(m);
/*     */       }
/*     */     } 
/* 130 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\f\a\j.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */