/*     */ package com.google.a.n;
/*     */ 
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.F;
/*     */ import com.google.a.b.s;
/*     */ import com.google.a.b.w;
/*     */ import com.google.a.b.y;
/*     */ import com.google.a.d.bG;
/*     */ import com.google.a.d.bh;
/*     */ import com.google.a.d.bj;
/*     */ import com.google.a.d.dj;
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.AnnotatedElement;
/*     */ import java.lang.reflect.Array;
/*     */ import java.lang.reflect.GenericArrayType;
/*     */ import java.lang.reflect.GenericDeclaration;
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Proxy;
/*     */ import java.lang.reflect.Type;
/*     */ import java.lang.reflect.TypeVariable;
/*     */ import java.lang.reflect.WildcardType;
/*     */ import java.security.AccessControlException;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.atomic.AtomicReference;
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
/*     */ final class o
/*     */ {
/*  57 */   private static final s<Type, String> l = new s<Type, String>()
/*     */     {
/*     */       public String a(Type param1Type)
/*     */       {
/*  61 */         return o.c.e.b(param1Type);
/*     */       }
/*     */     };
/*     */   
/*  65 */   private static final w d = w.a(", ").b("null");
/*     */ 
/*     */   
/*     */   static Type f(Type paramType) {
/*  69 */     if (paramType instanceof WildcardType) {
/*  70 */       WildcardType wildcardType = (WildcardType)paramType;
/*  71 */       Type[] arrayOfType1 = wildcardType.getLowerBounds();
/*  72 */       D.a((arrayOfType1.length <= 1), "Wildcard cannot have more than one lower bounds.");
/*  73 */       if (arrayOfType1.length == 1) {
/*  74 */         return supertypeOf(f(arrayOfType1[0]));
/*     */       }
/*  76 */       Type[] arrayOfType2 = wildcardType.getUpperBounds();
/*  77 */       D.a((arrayOfType2.length == 1), "Wildcard should have only one upper bound.");
/*  78 */       return subtypeOf(f(arrayOfType2[0]));
/*     */     } 
/*     */     
/*  81 */     return c.e.f(paramType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static ParameterizedType a(Type paramType, Class<?> paramClass, Type... paramVarArgs) {
/*  90 */     if (paramType == null) {
/*  91 */       return a(paramClass, paramVarArgs);
/*     */     }
/*     */     
/*  94 */     D.checkNotNull(paramVarArgs);
/*  95 */     D.a((paramClass.getEnclosingClass() != null), "Owner type for unenclosed %s", paramClass);
/*  96 */     return new e(paramType, paramClass, paramVarArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   static ParameterizedType a(Class<?> paramClass, Type... paramVarArgs) {
/* 101 */     return new e(a.c
/* 102 */         .d(paramClass), paramClass, paramVarArgs);
/*     */   }
/*     */   
/*     */   private enum a
/*     */   {
/* 107 */     a
/*     */     {
/*     */       Class<?> d(Class<?> param2Class)
/*     */       {
/* 111 */         return param2Class.getEnclosingClass();
/*     */       }
/*     */     },
/* 114 */     b
/*     */     {
/*     */       Class<?> d(Class<?> param2Class)
/*     */       {
/* 118 */         if (param2Class.isLocalClass()) {
/* 119 */           return null;
/*     */         }
/* 121 */         return param2Class.getEnclosingClass();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 128 */     static final a c = a();
/*     */ 
/*     */     
/*     */     private static a a() {
/* 132 */       Class<?> clazz = (new a<String>() {  }).getClass();
/* 133 */       ParameterizedType parameterizedType = (ParameterizedType)clazz.getGenericSuperclass();
/* 134 */       for (a a1 : values()) {
/* 135 */         if (a1.d(a.class) == parameterizedType.getOwnerType()) {
/* 136 */           return a1;
/*     */         }
/*     */       } 
/* 139 */       throw new AssertionError();
/*     */     }
/*     */     static {
/*     */     
/*     */     }
/*     */     
/*     */     class a<T> {}
/*     */     
/*     */     abstract Class<?> d(Class<?> param1Class); }
/*     */   
/*     */   static <D extends GenericDeclaration> TypeVariable<D> a(D paramD, String paramString, Type... paramVarArgs) {
/* 150 */     (new Type[1])[0] = Object.class; return b(paramD, paramString, (paramVarArgs.length == 0) ? new Type[1] : paramVarArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.a.a.d
/*     */   static WildcardType subtypeOf(Type paramType) {
/* 156 */     return new h(new Type[0], new Type[] { paramType });
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.a.a.d
/*     */   static WildcardType supertypeOf(Type paramType) {
/* 162 */     return new h(new Type[] { paramType }, new Type[] { Object.class });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static String toString(Type paramType) {
/* 171 */     return (paramType instanceof Class) ? ((Class)paramType).getName() : paramType.toString();
/*     */   }
/*     */   
/*     */   static Type g(Type paramType) {
/* 175 */     D.checkNotNull(paramType);
/* 176 */     AtomicReference<Type> atomicReference = new AtomicReference();
/* 177 */     (new n(atomicReference)
/*     */       {
/*     */         void a(TypeVariable<?> param1TypeVariable) {
/* 180 */           this.a.set(o.b(param1TypeVariable.getBounds()));
/*     */         }
/*     */ 
/*     */         
/*     */         void a(WildcardType param1WildcardType) {
/* 185 */           this.a.set(o.b(param1WildcardType.getUpperBounds()));
/*     */         }
/*     */ 
/*     */         
/*     */         void a(GenericArrayType param1GenericArrayType) {
/* 190 */           this.a.set(param1GenericArrayType.getGenericComponentType());
/*     */         }
/*     */ 
/*     */         
/*     */         void a(Class<?> param1Class) {
/* 195 */           this.a.set(param1Class.getComponentType());
/*     */         }
/* 197 */       }).a(new Type[] { paramType });
/* 198 */     return atomicReference.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Type a(Type[] paramArrayOfType) {
/* 206 */     for (Type type1 : paramArrayOfType) {
/* 207 */       Type type2 = g(type1);
/* 208 */       if (type2 != null) {
/*     */ 
/*     */         
/* 211 */         if (type2 instanceof Class) {
/* 212 */           Class clazz = (Class)type2;
/* 213 */           if (clazz.isPrimitive()) {
/* 214 */             return clazz;
/*     */           }
/*     */         } 
/* 217 */         return subtypeOf(type2);
/*     */       } 
/*     */     } 
/* 220 */     return null;
/*     */   }
/*     */   
/*     */   private static final class b implements Serializable, GenericArrayType {
/*     */     private final Type componentType;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     b(Type param1Type) {
/* 228 */       this.componentType = o.c.e.h(param1Type);
/*     */     }
/*     */ 
/*     */     
/*     */     public Type getGenericComponentType() {
/* 233 */       return this.componentType;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 238 */       return String.valueOf(o.toString(this.componentType)).concat("[]");
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 243 */       return this.componentType.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 248 */       if (param1Object instanceof GenericArrayType) {
/* 249 */         GenericArrayType genericArrayType = (GenericArrayType)param1Object;
/* 250 */         return y.equal(getGenericComponentType(), genericArrayType.getGenericComponentType());
/*     */       } 
/* 252 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class e
/*     */     implements Serializable, ParameterizedType
/*     */   {
/*     */     private final Type ownerType;
/*     */     private final bh<Type> s;
/*     */     private final Class<?> rawType;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     e(Type param1Type, Class<?> param1Class, Type[] param1ArrayOfType) {
/* 265 */       D.checkNotNull(param1Class);
/* 266 */       D.checkArgument((param1ArrayOfType.length == (param1Class.getTypeParameters()).length));
/* 267 */       o.b(param1ArrayOfType, "type parameter");
/* 268 */       this.ownerType = param1Type;
/* 269 */       this.rawType = param1Class;
/* 270 */       this.s = o.c.e.b(param1ArrayOfType);
/*     */     }
/*     */ 
/*     */     
/*     */     public Type[] getActualTypeArguments() {
/* 275 */       return o.b((Collection)this.s);
/*     */     }
/*     */ 
/*     */     
/*     */     public Type getRawType() {
/* 280 */       return this.rawType;
/*     */     }
/*     */ 
/*     */     
/*     */     public Type getOwnerType() {
/* 285 */       return this.ownerType;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 290 */       StringBuilder stringBuilder = new StringBuilder();
/* 291 */       if (this.ownerType != null && o.c.e.dv()) {
/* 292 */         stringBuilder.append(o.c.e.b(this.ownerType)).append('.');
/*     */       }
/* 294 */       return stringBuilder
/* 295 */         .append(this.rawType.getName())
/* 296 */         .append('<')
/* 297 */         .append(o.b().a(bG.a((Iterable)this.s, o.m())))
/* 298 */         .append('>')
/* 299 */         .toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 304 */       return ((this.ownerType == null) ? 0 : this.ownerType.hashCode()) ^ this.s
/* 305 */         .hashCode() ^ this.rawType
/* 306 */         .hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 311 */       if (!(param1Object instanceof ParameterizedType)) {
/* 312 */         return false;
/*     */       }
/* 314 */       ParameterizedType parameterizedType = (ParameterizedType)param1Object;
/* 315 */       return (getRawType().equals(parameterizedType.getRawType()) && 
/* 316 */         y.equal(getOwnerType(), parameterizedType.getOwnerType()) && 
/* 317 */         Arrays.equals((Object[])getActualTypeArguments(), (Object[])parameterizedType.getActualTypeArguments()));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static <D extends GenericDeclaration> TypeVariable<D> b(D paramD, String paramString, Type[] paramArrayOfType) {
/* 325 */     f<D> f = new f<>(paramD, paramString, paramArrayOfType);
/*     */ 
/*     */ 
/*     */     
/* 329 */     return h.<TypeVariable>a(TypeVariable.class, new g(f));
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
/*     */   private static final class g
/*     */     implements InvocationHandler
/*     */   {
/*     */     private static final bj<String, Method> o;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final o.f<?> a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static {
/* 364 */       bj.a a = bj.a();
/* 365 */       for (Method method : o.f.class.getMethods()) {
/* 366 */         if (method.getDeclaringClass().equals(o.f.class)) {
/*     */           try {
/* 368 */             method.setAccessible(true);
/* 369 */           } catch (AccessControlException accessControlException) {}
/*     */ 
/*     */ 
/*     */           
/* 373 */           a.a(method.getName(), method);
/*     */         } 
/*     */       } 
/* 376 */       o = a.e();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     g(o.f<?> param1f) {
/* 382 */       this.a = param1f;
/*     */     }
/*     */ 
/*     */     
/*     */     public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) throws Throwable {
/* 387 */       String str = param1Method.getName();
/* 388 */       Method method = (Method)o.get(str);
/* 389 */       if (method == null) {
/* 390 */         throw new UnsupportedOperationException(str);
/*     */       }
/*     */       try {
/* 393 */         return method.invoke(this.a, param1ArrayOfObject);
/* 394 */       } catch (InvocationTargetException invocationTargetException) {
/* 395 */         throw invocationTargetException.getCause();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class f<D extends GenericDeclaration>
/*     */   {
/*     */     private final D a;
/*     */     private final String name;
/*     */     private final bh<Type> t;
/*     */     
/*     */     f(D param1D, String param1String, Type[] param1ArrayOfType) {
/* 408 */       o.b(param1ArrayOfType, "bound for type variable");
/* 409 */       this.a = (D)D.checkNotNull(param1D);
/* 410 */       this.name = (String)D.checkNotNull(param1String);
/* 411 */       this.t = bh.a((Object[])param1ArrayOfType);
/*     */     }
/*     */     
/*     */     public Type[] c() {
/* 415 */       return o.b((Collection)this.t);
/*     */     }
/*     */     
/*     */     public D a() {
/* 419 */       return this.a;
/*     */     }
/*     */     
/*     */     public String getName() {
/* 423 */       return this.name;
/*     */     }
/*     */     
/*     */     public String getTypeName() {
/* 427 */       return this.name;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 432 */       return this.name;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 437 */       return this.a.hashCode() ^ this.name.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 442 */       if (o.d.bi) {
/*     */         
/* 444 */         if (param1Object != null && 
/* 445 */           Proxy.isProxyClass(param1Object.getClass()) && 
/* 446 */           Proxy.getInvocationHandler(param1Object) instanceof o.g) {
/*     */           
/* 448 */           o.g g = (o.g)Proxy.getInvocationHandler(param1Object);
/* 449 */           f f1 = o.g.a(g);
/* 450 */           return (this.name.equals(f1.getName()) && this.a
/* 451 */             .equals(f1.a()) && this.t
/* 452 */             .equals(f1.t));
/*     */         } 
/* 454 */         return false;
/*     */       } 
/*     */       
/* 457 */       if (param1Object instanceof TypeVariable) {
/* 458 */         TypeVariable typeVariable = (TypeVariable)param1Object;
/* 459 */         return (this.name.equals(typeVariable.getName()) && this.a
/* 460 */           .equals(typeVariable.getGenericDeclaration()));
/*     */       } 
/* 462 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   static final class h
/*     */     implements Serializable, WildcardType {
/*     */     private final bh<Type> u;
/*     */     private final bh<Type> v;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     h(Type[] param1ArrayOfType1, Type[] param1ArrayOfType2) {
/* 473 */       o.b(param1ArrayOfType1, "lower bound for wildcard");
/* 474 */       o.b(param1ArrayOfType2, "upper bound for wildcard");
/* 475 */       this.u = o.c.e.b(param1ArrayOfType1);
/* 476 */       this.v = o.c.e.b(param1ArrayOfType2);
/*     */     }
/*     */ 
/*     */     
/*     */     public Type[] getLowerBounds() {
/* 481 */       return o.b((Collection)this.u);
/*     */     }
/*     */ 
/*     */     
/*     */     public Type[] getUpperBounds() {
/* 486 */       return o.b((Collection)this.v);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 491 */       if (param1Object instanceof WildcardType) {
/* 492 */         WildcardType wildcardType = (WildcardType)param1Object;
/* 493 */         return (this.u.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.v
/* 494 */           .equals(Arrays.asList(wildcardType.getUpperBounds())));
/*     */       } 
/* 496 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 501 */       return this.u.hashCode() ^ this.v.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 506 */       StringBuilder stringBuilder = new StringBuilder("?");
/* 507 */       for (dj<Type> dj = this.u.b(); dj.hasNext(); ) { Type type = dj.next();
/* 508 */         stringBuilder.append(" super ").append(o.c.e.b(type)); }
/*     */       
/* 510 */       for (Type type : o.k((Iterable)this.v)) {
/* 511 */         stringBuilder.append(" extends ").append(o.c.e.b(type));
/*     */       }
/* 513 */       return stringBuilder.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Type[] a(Collection<Type> paramCollection) {
/* 520 */     return paramCollection.<Type>toArray(new Type[0]);
/*     */   }
/*     */   
/*     */   private static Iterable<Type> j(Iterable<Type> paramIterable) {
/* 524 */     return bG.a(paramIterable, F.a(F.b(Object.class)));
/*     */   }
/*     */   
/*     */   private static void a(Type[] paramArrayOfType, String paramString) {
/* 528 */     for (Type type : paramArrayOfType) {
/* 529 */       if (type instanceof Class) {
/* 530 */         Class clazz = (Class)type;
/* 531 */         D.a(!clazz.isPrimitive(), "Primitive type '%s' used as %s", clazz, paramString);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Class<?> c(Class<?> paramClass) {
/* 541 */     return Array.newInstance(paramClass, 0).getClass();
/*     */   }
/*     */   
/*     */   enum c
/*     */   {
/* 546 */     a
/*     */     {
/*     */       GenericArrayType a(Type param2Type) {
/* 549 */         return new o.b(param2Type);
/*     */       }
/*     */ 
/*     */       
/*     */       Type h(Type param2Type) {
/* 554 */         D.checkNotNull(param2Type);
/* 555 */         if (param2Type instanceof Class) {
/* 556 */           Class clazz = (Class)param2Type;
/* 557 */           if (clazz.isArray()) {
/* 558 */             return new o.b(clazz.getComponentType());
/*     */           }
/*     */         } 
/* 561 */         return param2Type;
/*     */       }
/*     */     },
/* 564 */     b
/*     */     {
/*     */       Type f(Type param2Type) {
/* 567 */         if (param2Type instanceof Class) {
/* 568 */           return o.c((Class)param2Type);
/*     */         }
/* 570 */         return new o.b(param2Type);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       Type h(Type param2Type) {
/* 576 */         return (Type)D.checkNotNull(param2Type);
/*     */       }
/*     */     },
/* 579 */     c
/*     */     {
/*     */       Type f(Type param2Type) {
/* 582 */         return b.f(param2Type);
/*     */       }
/*     */ 
/*     */       
/*     */       Type h(Type param2Type) {
/* 587 */         return b.h(param2Type);
/*     */       }
/*     */ 
/*     */       
/*     */       String b(Type param2Type) {
/*     */         try {
/* 593 */           Method method = Type.class.getMethod("getTypeName", new Class[0]);
/* 594 */           return (String)method.invoke(param2Type, new Object[0]);
/* 595 */         } catch (NoSuchMethodException noSuchMethodException) {
/* 596 */           throw new AssertionError("Type.getTypeName should be available in Java 8");
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         }
/* 602 */         catch (InvocationTargetException invocationTargetException) {
/* 603 */           throw new RuntimeException(invocationTargetException);
/* 604 */         } catch (IllegalAccessException illegalAccessException) {
/* 605 */           throw new RuntimeException(illegalAccessException);
/*     */         } 
/*     */       }
/*     */     },
/* 609 */     d
/*     */     {
/*     */       Type f(Type param2Type) {
/* 612 */         return c.f(param2Type);
/*     */       }
/*     */ 
/*     */       
/*     */       Type h(Type param2Type) {
/* 617 */         return c.h(param2Type);
/*     */       }
/*     */ 
/*     */       
/*     */       String b(Type param2Type) {
/* 622 */         return c.b(param2Type);
/*     */       }
/*     */ 
/*     */       
/*     */       boolean dv() {
/* 627 */         return false;
/*     */       }
/*     */     };
/*     */     
/*     */     static final c e;
/*     */     
/*     */     static {
/* 634 */       if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
/* 635 */         if ((new i<Map.Entry<String, int[][]>>() {  }).b()
/* 636 */           .toString()
/* 637 */           .contains("java.util.Map.java.util.Map")) {
/* 638 */           e = c;
/*     */         } else {
/* 640 */           e = d;
/*     */         } 
/* 642 */       } else if ((new i<int[]>() {  }).b() instanceof Class) {
/* 643 */         e = b;
/*     */       } else {
/* 645 */         e = (c)a;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     final bh<Type> b(Type[] param1ArrayOfType) {
/* 654 */       bh.a a = bh.a();
/* 655 */       for (Type type : param1ArrayOfType) {
/* 656 */         a.a(h(type));
/*     */       }
/* 658 */       return a.g();
/*     */     }
/*     */     
/*     */     String b(Type param1Type) {
/* 662 */       return o.toString(param1Type);
/*     */     }
/*     */     
/*     */     boolean dv() {
/* 666 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     abstract Type f(Type param1Type);
/*     */ 
/*     */ 
/*     */     
/*     */     abstract Type h(Type param1Type);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static final class d<X>
/*     */   {
/* 682 */     static final boolean bi = !d.class.getTypeParameters()[0].equals(
/* 683 */         o.a(d.class, "X", new Type[0]));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\n\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */