/*     */ package org.junit.c.a;
/*     */ 
/*     */ import java.lang.reflect.Modifier;
/*     */ import org.junit.f.a.e;
/*     */ import org.junit.f.a.j;
/*     */ import org.junit.runner.l;
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
/*     */ public class b
/*     */   extends j
/*     */ {
/*     */   private static final String mc = "Custom runner class %s should have a public constructor with signature %s(Class testClass)";
/*     */   private final j a;
/*     */   
/*     */   public b(j paramj) {
/*  77 */     this.a = paramj;
/*     */   }
/*     */ 
/*     */   
/*     */   public m a(Class<?> paramClass) throws Exception {
/*  82 */     for (Class<?> clazz = paramClass; clazz != null; 
/*  83 */       clazz = g(clazz)) {
/*  84 */       l l = clazz.<l>getAnnotation(l.class);
/*  85 */       if (l != null) {
/*  86 */         return a(l.value(), paramClass);
/*     */       }
/*     */     } 
/*     */     
/*  90 */     return null;
/*     */   }
/*     */   
/*     */   private Class<?> g(Class<?> paramClass) {
/*  94 */     if (paramClass.isMemberClass() && !Modifier.isStatic(paramClass.getModifiers())) {
/*  95 */       return paramClass.getEnclosingClass();
/*     */     }
/*  97 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public m a(Class<? extends m> paramClass, Class<?> paramClass1) throws Exception {
/*     */     try {
/* 104 */       return paramClass.getConstructor(new Class[] { Class.class }).newInstance(new Object[] { paramClass1 });
/* 105 */     } catch (NoSuchMethodException noSuchMethodException) {
/*     */       try {
/* 107 */         return paramClass.getConstructor(new Class[] { Class.class, j.class }).newInstance(new Object[] { paramClass1, this.a });
/*     */       }
/* 109 */       catch (NoSuchMethodException noSuchMethodException1) {
/* 110 */         String str = paramClass.getSimpleName();
/* 111 */         throw new e(String.format("Custom runner class %s should have a public constructor with signature %s(Class testClass)", new Object[] { str, str }));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c\a\b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */