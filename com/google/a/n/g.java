/*     */ package com.google.a.n;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.d.ap;
/*     */ import com.google.a.d.bh;
/*     */ import com.google.a.d.dj;
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.AnnotatedElement;
/*     */ import java.lang.reflect.AnnotatedType;
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
/*     */ @a
/*     */ public final class g
/*     */   implements AnnotatedElement
/*     */ {
/*     */   private final e<?, ?> a;
/*     */   private final int position;
/*     */   private final m<?> a;
/*     */   private final bh<Annotation> r;
/*     */   private final AnnotatedType a;
/*     */   
/*     */   g(e<?, ?> parame, int paramInt, m<?> paramm, Annotation[] paramArrayOfAnnotation, AnnotatedType paramAnnotatedType) {
/*  48 */     this.a = (AnnotatedType)parame;
/*  49 */     this.position = paramInt;
/*  50 */     this.a = (AnnotatedType)paramm;
/*  51 */     this.r = bh.a((Object[])paramArrayOfAnnotation);
/*  52 */     this.a = paramAnnotatedType;
/*     */   }
/*     */ 
/*     */   
/*     */   public m<?> c() {
/*  57 */     return (m<?>)this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public e<?, ?> a() {
/*  62 */     return (e<?, ?>)this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isAnnotationPresent(Class<? extends Annotation> paramClass) {
/*  67 */     return (getAnnotation(paramClass) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public <A extends Annotation> A getAnnotation(Class<A> paramClass) {
/*  72 */     D.checkNotNull(paramClass);
/*  73 */     for (dj<Annotation> dj = this.r.b(); dj.hasNext(); ) { Annotation annotation = dj.next();
/*  74 */       if (paramClass.isInstance(annotation)) {
/*  75 */         return paramClass.cast(annotation);
/*     */       } }
/*     */     
/*  78 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Annotation[] getAnnotations() {
/*  83 */     return getDeclaredAnnotations();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <A extends Annotation> A[] getAnnotationsByType(Class<A> paramClass) {
/*  90 */     return getDeclaredAnnotationsByType(paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Annotation[] getDeclaredAnnotations() {
/*  97 */     return (Annotation[])this.r.toArray((Object[])new Annotation[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <A extends Annotation> A getDeclaredAnnotation(Class<A> paramClass) {
/* 104 */     D.checkNotNull(paramClass);
/* 105 */     return (A)ap.a((Iterable)this.r).a(paramClass).c().a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> paramClass) {
/* 112 */     return (A[])ap.a((Iterable)this.r).a(paramClass).toArray(paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotatedType b() {
/* 118 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 123 */     if (paramObject instanceof g) {
/* 124 */       g g1 = (g)paramObject;
/* 125 */       return (this.position == g1.position && this.a.equals(g1.a));
/*     */     } 
/* 127 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 132 */     return this.position;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 137 */     String str = String.valueOf(this.a); int i = this.position; return (new StringBuilder(15 + String.valueOf(str).length())).append(str).append(" arg").append(i).toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\n\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */