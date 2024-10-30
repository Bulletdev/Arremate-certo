/*     */ package com.google.a.n;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.d.bh;
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.AnnotatedType;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.GenericDeclaration;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.lang.reflect.Type;
/*     */ import java.lang.reflect.TypeVariable;
/*     */ import java.util.Arrays;
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
/*     */ @a
/*     */ public abstract class e<T, R>
/*     */   extends c
/*     */   implements GenericDeclaration
/*     */ {
/*     */   <M extends java.lang.reflect.AccessibleObject & java.lang.reflect.Member> e(M paramM) {
/*  62 */     super(paramM);
/*     */   }
/*     */ 
/*     */   
/*     */   public static e<?, Object> a(Method paramMethod) {
/*  67 */     return new b(paramMethod);
/*     */   }
/*     */ 
/*     */   
/*     */   public static <T> e<T, T> a(Constructor<T> paramConstructor) {
/*  72 */     return new a<>(paramConstructor);
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
/*     */   @com.google.b.a.a
/*     */   public final R a(T paramT, Object... paramVarArgs) throws InvocationTargetException, IllegalAccessException {
/* 102 */     return (R)b(paramT, (Object[])D.checkNotNull(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final m<? extends R> b() {
/* 109 */     return (m)m.a(a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final bh<g> m() {
/* 118 */     Type[] arrayOfType = a();
/* 119 */     Annotation[][] arrayOfAnnotation = a();
/* 120 */     AnnotatedType[] arrayOfAnnotatedType = a();
/* 121 */     bh.a a = bh.a();
/* 122 */     for (byte b = 0; b < arrayOfType.length; b++) {
/* 123 */       a.a(new g(this, b, 
/*     */             
/* 125 */             m.a(arrayOfType[b]), arrayOfAnnotation[b], arrayOfAnnotatedType[b]));
/*     */     }
/* 127 */     return a.g();
/*     */   }
/*     */ 
/*     */   
/*     */   public final bh<m<? extends Throwable>> n() {
/* 132 */     bh.a a = bh.a();
/* 133 */     for (Type type : b()) {
/*     */ 
/*     */ 
/*     */       
/* 137 */       m<?> m = m.a(type);
/* 138 */       a.a(m);
/*     */     } 
/* 140 */     return a.g();
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
/*     */   public final <R1 extends R> e<T, R1> a(Class<R1> paramClass) {
/* 152 */     return a(m.a(paramClass));
/*     */   }
/*     */ 
/*     */   
/*     */   public final <R1 extends R> e<T, R1> a(m<R1> paramm) {
/* 157 */     if (!paramm.a(b())) {
/*     */       
/* 159 */       String str1 = String.valueOf(b()), str2 = String.valueOf(paramm); throw new IllegalArgumentException((new StringBuilder(35 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("Invokable is known to return ").append(str1).append(", not ").append(str2).toString());
/*     */     } 
/*     */     
/* 162 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Class<? super T> getDeclaringClass() {
/* 169 */     return (Class)super.getDeclaringClass();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public m<T> a() {
/* 177 */     return m.a((Class)getDeclaringClass());
/*     */   }
/*     */   
/*     */   public abstract boolean dr();
/*     */   
/*     */   public abstract boolean isVarArgs();
/*     */   
/*     */   abstract Object b(Object paramObject, Object[] paramArrayOfObject) throws InvocationTargetException, IllegalAccessException;
/*     */   
/*     */   abstract Type[] a();
/*     */   
/*     */   abstract AnnotatedType[] a();
/*     */   
/*     */   abstract Type[] b();
/*     */   
/*     */   abstract Annotation[][] a();
/*     */   
/*     */   abstract Type a();
/*     */   
/*     */   public abstract AnnotatedType a();
/*     */   
/*     */   static class b<T> extends e<T, Object> { final Method method;
/*     */     
/*     */     b(Method param1Method) {
/* 201 */       super(param1Method);
/* 202 */       this.method = param1Method;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     final Object b(Object param1Object, Object[] param1ArrayOfObject) throws InvocationTargetException, IllegalAccessException {
/* 208 */       return this.method.invoke(param1Object, param1ArrayOfObject);
/*     */     }
/*     */ 
/*     */     
/*     */     Type a() {
/* 213 */       return this.method.getGenericReturnType();
/*     */     }
/*     */ 
/*     */     
/*     */     Type[] a() {
/* 218 */       return this.method.getGenericParameterTypes();
/*     */     }
/*     */ 
/*     */     
/*     */     AnnotatedType[] a() {
/* 223 */       return this.method.getAnnotatedParameterTypes();
/*     */     }
/*     */ 
/*     */     
/*     */     public AnnotatedType a() {
/* 228 */       return this.method.getAnnotatedReturnType();
/*     */     }
/*     */ 
/*     */     
/*     */     Type[] b() {
/* 233 */       return this.method.getGenericExceptionTypes();
/*     */     }
/*     */ 
/*     */     
/*     */     final Annotation[][] a() {
/* 238 */       return this.method.getParameterAnnotations();
/*     */     }
/*     */ 
/*     */     
/*     */     public final TypeVariable<?>[] getTypeParameters() {
/* 243 */       return (TypeVariable<?>[])this.method.getTypeParameters();
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean dr() {
/* 248 */       return (!isFinal() && 
/* 249 */         !isPrivate() && 
/* 250 */         !isStatic() && 
/* 251 */         !Modifier.isFinal(getDeclaringClass().getModifiers()));
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean isVarArgs() {
/* 256 */       return this.method.isVarArgs();
/*     */     } }
/*     */ 
/*     */   
/*     */   static class a<T>
/*     */     extends e<T, T> {
/*     */     final Constructor<?> b;
/*     */     
/*     */     a(Constructor<?> param1Constructor) {
/* 265 */       super(param1Constructor);
/* 266 */       this.b = param1Constructor;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     final Object b(Object param1Object, Object[] param1ArrayOfObject) throws InvocationTargetException, IllegalAccessException {
/*     */       try {
/* 273 */         return this.b.newInstance(param1ArrayOfObject);
/* 274 */       } catch (InstantiationException instantiationException) {
/* 275 */         String str = String.valueOf(this.b); throw new RuntimeException((new StringBuilder(8 + String.valueOf(str).length())).append(str).append(" failed.").toString(), instantiationException);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Type a() {
/* 285 */       Class<? super T> clazz = getDeclaringClass();
/* 286 */       TypeVariable[] arrayOfTypeVariable = (TypeVariable[])clazz.getTypeParameters();
/* 287 */       if (arrayOfTypeVariable.length > 0) {
/* 288 */         return o.a(clazz, (Type[])arrayOfTypeVariable);
/*     */       }
/* 290 */       return clazz;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     Type[] a() {
/* 296 */       Type[] arrayOfType = this.b.getGenericParameterTypes();
/* 297 */       if (arrayOfType.length > 0 && ds()) {
/* 298 */         Class[] arrayOfClass = this.b.getParameterTypes();
/* 299 */         if (arrayOfType.length == arrayOfClass.length && arrayOfClass[0] == 
/* 300 */           getDeclaringClass().getEnclosingClass())
/*     */         {
/* 302 */           return Arrays.<Type>copyOfRange(arrayOfType, 1, arrayOfType.length);
/*     */         }
/*     */       } 
/* 305 */       return arrayOfType;
/*     */     }
/*     */ 
/*     */     
/*     */     AnnotatedType[] a() {
/* 310 */       return this.b.getAnnotatedParameterTypes();
/*     */     }
/*     */ 
/*     */     
/*     */     public AnnotatedType a() {
/* 315 */       return this.b.getAnnotatedReturnType();
/*     */     }
/*     */ 
/*     */     
/*     */     Type[] b() {
/* 320 */       return this.b.getGenericExceptionTypes();
/*     */     }
/*     */ 
/*     */     
/*     */     final Annotation[][] a() {
/* 325 */       return this.b.getParameterAnnotations();
/*     */     }
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
/*     */     public final TypeVariable<?>[] getTypeParameters() {
/* 339 */       TypeVariable[] arrayOfTypeVariable1 = (TypeVariable[])getDeclaringClass().getTypeParameters();
/* 340 */       TypeVariable[] arrayOfTypeVariable2 = (TypeVariable[])this.b.getTypeParameters();
/* 341 */       TypeVariable[] arrayOfTypeVariable3 = new TypeVariable[arrayOfTypeVariable1.length + arrayOfTypeVariable2.length];
/*     */       
/* 343 */       System.arraycopy(arrayOfTypeVariable1, 0, arrayOfTypeVariable3, 0, arrayOfTypeVariable1.length);
/* 344 */       System.arraycopy(arrayOfTypeVariable2, 0, arrayOfTypeVariable3, arrayOfTypeVariable1.length, arrayOfTypeVariable2.length);
/*     */       
/* 346 */       return (TypeVariable<?>[])arrayOfTypeVariable3;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean dr() {
/* 351 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean isVarArgs() {
/* 356 */       return this.b.isVarArgs();
/*     */     }
/*     */     
/*     */     private boolean ds() {
/* 360 */       Class<?> clazz = this.b.getDeclaringClass();
/* 361 */       if (clazz.getEnclosingConstructor() != null)
/*     */       {
/* 363 */         return true;
/*     */       }
/* 365 */       Method method = clazz.getEnclosingMethod();
/* 366 */       if (method != null)
/*     */       {
/* 368 */         return !Modifier.isStatic(method.getModifiers());
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 376 */       return (clazz.getEnclosingClass() != null && 
/* 377 */         !Modifier.isStatic(clazz.getModifiers()));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\n\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */