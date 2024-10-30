/*     */ package org.junit.f;
/*     */ 
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Inherited;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.junit.f.a.e;
/*     */ import org.junit.f.a.j;
/*     */ import org.junit.runner.b.c;
/*     */ import org.junit.runner.c;
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
/*     */ public class h
/*     */   extends f<m>
/*     */ {
/*     */   private final List<m> aU;
/*     */   
/*     */   public static m c() {
/*     */     try {
/*  33 */       return new h((Class)null, new Class[0]);
/*  34 */     } catch (e e) {
/*  35 */       throw new RuntimeException("This shouldn't be possible");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Class<?>[] a(Class<?> paramClass) throws e {
/*  54 */     a a = paramClass.<a>getAnnotation(a.class);
/*  55 */     if (a == null) {
/*  56 */       throw new e(String.format("class '%s' must have a SuiteClasses annotation", new Object[] { paramClass.getName() }));
/*     */     }
/*  58 */     return a.d();
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
/*     */   public h(Class<?> paramClass, j paramj) throws e {
/*  70 */     this(paramj, paramClass, a(paramClass));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public h(j paramj, Class<?>[] paramArrayOfClass) throws e {
/*  81 */     this((Class<?>)null, paramj.a(null, paramArrayOfClass));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected h(Class<?> paramClass, Class<?>[] paramArrayOfClass) throws e {
/*  91 */     this((j)new org.junit.c.a.a(), paramClass, paramArrayOfClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected h(j paramj, Class<?> paramClass, Class<?>[] paramArrayOfClass) throws e {
/* 102 */     this(paramClass, paramj.a(paramClass, paramArrayOfClass));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected h(Class<?> paramClass, List<m> paramList) throws e {
/* 112 */     super(paramClass);
/* 113 */     this.aU = Collections.unmodifiableList(paramList);
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<m> getChildren() {
/* 118 */     return this.aU;
/*     */   }
/*     */ 
/*     */   
/*     */   protected c a(m paramm) {
/* 123 */     return paramm.a();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a(m paramm, c paramc) {
/* 128 */     paramm.a(paramc);
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   @Target({ElementType.TYPE})
/*     */   @Inherited
/*     */   public static @interface a {
/*     */     Class<?>[] d();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\f\h.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */