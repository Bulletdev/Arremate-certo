/*     */ package com.google.a.n;
/*     */ 
/*     */ import com.google.a.b.D;
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.AccessibleObject;
/*     */ import java.lang.reflect.Member;
/*     */ import java.lang.reflect.Modifier;
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
/*     */ class c
/*     */   extends AccessibleObject
/*     */   implements Member
/*     */ {
/*     */   private final AccessibleObject a;
/*     */   private final Member a;
/*     */   
/*     */   <M extends AccessibleObject & Member> c(M paramM) {
/*  40 */     D.checkNotNull(paramM);
/*  41 */     this.a = (Member)paramM;
/*  42 */     this.a = (Member)paramM;
/*     */   }
/*     */   
/*     */   public m<?> a() {
/*  46 */     return m.a(getDeclaringClass());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isAnnotationPresent(Class<? extends Annotation> paramClass) {
/*  51 */     return this.a.isAnnotationPresent(paramClass);
/*     */   }
/*     */ 
/*     */   
/*     */   public final <A extends Annotation> A getAnnotation(Class<A> paramClass) {
/*  56 */     return this.a.getAnnotation(paramClass);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Annotation[] getAnnotations() {
/*  61 */     return this.a.getAnnotations();
/*     */   }
/*     */ 
/*     */   
/*     */   public final Annotation[] getDeclaredAnnotations() {
/*  66 */     return this.a.getDeclaredAnnotations();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setAccessible(boolean paramBoolean) throws SecurityException {
/*  71 */     this.a.setAccessible(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isAccessible() {
/*  76 */     return this.a.isAccessible();
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<?> getDeclaringClass() {
/*  81 */     return this.a.getDeclaringClass();
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getName() {
/*  86 */     return this.a.getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public final int getModifiers() {
/*  91 */     return this.a.getModifiers();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isSynthetic() {
/*  96 */     return this.a.isSynthetic();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isPublic() {
/* 101 */     return Modifier.isPublic(getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isProtected() {
/* 106 */     return Modifier.isProtected(getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isPackagePrivate() {
/* 111 */     return (!isPrivate() && !isPublic() && !isProtected());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isPrivate() {
/* 116 */     return Modifier.isPrivate(getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isStatic() {
/* 121 */     return Modifier.isStatic(getModifiers());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isFinal() {
/* 132 */     return Modifier.isFinal(getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isAbstract() {
/* 137 */     return Modifier.isAbstract(getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isNative() {
/* 142 */     return Modifier.isNative(getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isSynchronized() {
/* 147 */     return Modifier.isSynchronized(getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   final boolean isVolatile() {
/* 152 */     return Modifier.isVolatile(getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   final boolean isTransient() {
/* 157 */     return Modifier.isTransient(getModifiers());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 162 */     if (paramObject instanceof c) {
/* 163 */       c c1 = (c)paramObject;
/* 164 */       return (a().equals(c1.a()) && this.a.equals(c1.a));
/*     */     } 
/* 166 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 171 */     return this.a.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 176 */     return this.a.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\n\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */