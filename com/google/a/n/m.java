/*      */ package com.google.a.n;
/*      */ 
/*      */ import com.google.a.a.a;
/*      */ import com.google.a.b.D;
/*      */ import com.google.a.b.E;
/*      */ import com.google.a.b.w;
/*      */ import com.google.a.d.aK;
/*      */ import com.google.a.d.ap;
/*      */ import com.google.a.d.bh;
/*      */ import com.google.a.d.bj;
/*      */ import com.google.a.d.bt;
/*      */ import com.google.a.d.cj;
/*      */ import com.google.a.d.dj;
/*      */ import com.google.a.m.p;
/*      */ import java.io.Serializable;
/*      */ import java.lang.reflect.Constructor;
/*      */ import java.lang.reflect.GenericArrayType;
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.lang.reflect.ParameterizedType;
/*      */ import java.lang.reflect.Type;
/*      */ import java.lang.reflect.TypeVariable;
/*      */ import java.lang.reflect.WildcardType;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Comparator;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @a
/*      */ public abstract class m<T>
/*      */   extends i<T>
/*      */   implements Serializable
/*      */ {
/*      */   private final Type b;
/*      */   private transient k a;
/*      */   private transient k b;
/*      */   private static final long serialVersionUID = 3637540370352322684L;
/*      */   
/*      */   protected m() {
/*  124 */     this.b = (k)b();
/*  125 */     D.b(!(this.b instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", this.b);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected m(Class<?> paramClass) {
/*  155 */     Type type = b();
/*  156 */     if (type instanceof Class) {
/*  157 */       this.b = (k)type;
/*      */     } else {
/*  159 */       this.b = (k)k.a(paramClass).a(type);
/*      */     } 
/*      */   }
/*      */   
/*      */   private m(Type paramType) {
/*  164 */     this.b = (k)D.checkNotNull(paramType);
/*      */   }
/*      */ 
/*      */   
/*      */   public static <T> m<T> a(Class<T> paramClass) {
/*  169 */     return new d<>(paramClass);
/*      */   }
/*      */ 
/*      */   
/*      */   public static m<?> a(Type paramType) {
/*  174 */     return new d(paramType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Class<? super T> getRawType() {
/*  194 */     Class<? super T> clazz = (Class)x().b().next();
/*      */     
/*  196 */     return clazz;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Type getType() {
/*  202 */     return (Type)this.b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final <X> m<T> a(j<X> paramj, m<X> paramm) {
/*  226 */     k k1 = (new k()).a(
/*  227 */         (Map<k.c, ? extends Type>)bj.a(new k.c(paramj.a), paramm.b));
/*      */ 
/*      */     
/*  230 */     return new d<>(k1.a((Type)this.b));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final <X> m<T> a(j<X> paramj, Class<X> paramClass) {
/*  252 */     return a(paramj, a(paramClass));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final m<?> b(Type paramType) {
/*  265 */     D.checkNotNull(paramType);
/*      */ 
/*      */     
/*  268 */     return a(b().a(paramType));
/*      */   }
/*      */   
/*      */   private m<?> c(Type paramType) {
/*  272 */     m<?> m1 = a(a().a(paramType));
/*      */     
/*  274 */     m1.b = this.b;
/*  275 */     m1.a = this.a;
/*  276 */     return m1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final m<? super T> d() {
/*  292 */     if (this.b instanceof TypeVariable)
/*      */     {
/*  294 */       return d(((TypeVariable)this.b).getBounds()[0]);
/*      */     }
/*  296 */     if (this.b instanceof WildcardType)
/*      */     {
/*  298 */       return d(((WildcardType)this.b).getUpperBounds()[0]);
/*      */     }
/*  300 */     Type type = getRawType().getGenericSuperclass();
/*  301 */     if (type == null) {
/*  302 */       return null;
/*      */     }
/*      */     
/*  305 */     return (m)c(type);
/*      */   }
/*      */ 
/*      */   
/*      */   private m<? super T> d(Type paramType) {
/*  310 */     m<?> m1 = a(paramType);
/*  311 */     if (m1.getRawType().isInterface()) {
/*  312 */       return null;
/*      */     }
/*      */     
/*  315 */     return (m)m1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final bh<m<? super T>> o() {
/*  332 */     if (this.b instanceof TypeVariable) {
/*  333 */       return a(((TypeVariable)this.b).getBounds());
/*      */     }
/*  335 */     if (this.b instanceof WildcardType) {
/*  336 */       return a(((WildcardType)this.b).getUpperBounds());
/*      */     }
/*  338 */     bh.a a = bh.a();
/*  339 */     for (Type type : getRawType().getGenericInterfaces()) {
/*      */ 
/*      */       
/*  342 */       m<?> m1 = c(type);
/*  343 */       a.a(m1);
/*      */     } 
/*  345 */     return a.g();
/*      */   }
/*      */   
/*      */   private bh<m<? super T>> a(Type[] paramArrayOfType) {
/*  349 */     bh.a a = bh.a();
/*  350 */     for (Type type : paramArrayOfType) {
/*      */       
/*  352 */       m<?> m1 = a(type);
/*  353 */       if (m1.getRawType().isInterface()) {
/*  354 */         a.a(m1);
/*      */       }
/*      */     } 
/*  357 */     return a.g();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final g a() {
/*  372 */     return new g(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final m<? super T> b(Class<? super T> paramClass) {
/*  381 */     D.a(
/*  382 */         c(paramClass), "%s is not a super class of %s", paramClass, this);
/*      */ 
/*      */ 
/*      */     
/*  386 */     if (this.b instanceof TypeVariable) {
/*  387 */       return a(paramClass, ((TypeVariable)this.b).getBounds());
/*      */     }
/*  389 */     if (this.b instanceof WildcardType) {
/*  390 */       return a(paramClass, ((WildcardType)this.b).getUpperBounds());
/*      */     }
/*  392 */     if (paramClass.isArray()) {
/*  393 */       return e(paramClass);
/*      */     }
/*      */ 
/*      */     
/*  397 */     return (m)c((Type)(d((Class)paramClass)).b);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final m<? extends T> c(Class<?> paramClass) {
/*  407 */     D.a(!(this.b instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
/*      */     
/*  409 */     if (this.b instanceof WildcardType) {
/*  410 */       return b(paramClass, ((WildcardType)this.b).getLowerBounds());
/*      */     }
/*      */     
/*  413 */     if (isArray()) {
/*  414 */       return f(paramClass);
/*      */     }
/*      */     
/*  417 */     D.a(
/*  418 */         getRawType().isAssignableFrom(paramClass), "%s isn't a subclass of %s", paramClass, this);
/*  419 */     Type type = a(paramClass);
/*      */     
/*  421 */     m<?> m1 = a(type);
/*  422 */     D.a(m1
/*  423 */         .b(this), "%s does not appear to be a subtype of %s", m1, this);
/*  424 */     return (m)m1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean a(m<?> paramm) {
/*  436 */     return paramm.c(getType());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean b(Type paramType) {
/*  448 */     return a(paramType).c(getType());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean b(m<?> paramm) {
/*  460 */     return c(paramm.getType());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean c(Type paramType) {
/*  472 */     D.checkNotNull(paramType);
/*  473 */     if (paramType instanceof WildcardType)
/*      */     {
/*      */ 
/*      */       
/*  477 */       return b(((WildcardType)paramType).getLowerBounds()).b((Type)this.b);
/*      */     }
/*      */ 
/*      */     
/*  481 */     if (this.b instanceof WildcardType)
/*      */     {
/*  483 */       return b(((WildcardType)this.b).getUpperBounds()).c(paramType);
/*      */     }
/*      */ 
/*      */     
/*  487 */     if (this.b instanceof TypeVariable) {
/*  488 */       return (this.b.equals(paramType) || 
/*  489 */         b(((TypeVariable)this.b).getBounds()).c(paramType));
/*      */     }
/*  491 */     if (this.b instanceof GenericArrayType) {
/*  492 */       return a(paramType).b((GenericArrayType)this.b);
/*      */     }
/*      */     
/*  495 */     if (paramType instanceof Class)
/*  496 */       return c((Class)paramType); 
/*  497 */     if (paramType instanceof ParameterizedType)
/*  498 */       return a((ParameterizedType)paramType); 
/*  499 */     if (paramType instanceof GenericArrayType) {
/*  500 */       return a((GenericArrayType)paramType);
/*      */     }
/*  502 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean isArray() {
/*  511 */     return (g() != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean dt() {
/*  520 */     return (this.b instanceof Class && ((Class)this.b).isPrimitive());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final m<T> e() {
/*  530 */     if (dt()) {
/*      */       
/*  532 */       Class clazz = (Class)this.b;
/*  533 */       return a(p.wrap(clazz));
/*      */     } 
/*  535 */     return this;
/*      */   }
/*      */   
/*      */   private boolean du() {
/*  539 */     return p.F().contains(this.b);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final m<T> f() {
/*  549 */     if (du()) {
/*      */       
/*  551 */       Class clazz = (Class)this.b;
/*  552 */       return a(p.unwrap(clazz));
/*      */     } 
/*  554 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final m<?> g() {
/*  562 */     Type type = o.g((Type)this.b);
/*  563 */     if (type == null) {
/*  564 */       return null;
/*      */     }
/*  566 */     return a(type);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final e<T, Object> b(Method paramMethod) {
/*  575 */     D.a(
/*  576 */         c(paramMethod.getDeclaringClass()), "%s not declared by %s", paramMethod, this);
/*      */ 
/*      */ 
/*      */     
/*  580 */     return new e.b<T>(this, paramMethod)
/*      */       {
/*      */         Type a() {
/*  583 */           return m.a(this.b).a(super.a());
/*      */         }
/*      */ 
/*      */         
/*      */         Type[] a() {
/*  588 */           return m.b(this.b).a(super.a());
/*      */         }
/*      */ 
/*      */         
/*      */         Type[] b() {
/*  593 */           return m.a(this.b).a(super.b());
/*      */         }
/*      */ 
/*      */         
/*      */         public m<T> a() {
/*  598 */           return this.b;
/*      */         }
/*      */ 
/*      */         
/*      */         public String toString() {
/*  603 */           String str1 = String.valueOf(a()), str2 = super.toString(); return (new StringBuilder(1 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(".").append(str2).toString();
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final e<T, T> b(Constructor<?> paramConstructor) {
/*  614 */     D.a(
/*  615 */         (paramConstructor.getDeclaringClass() == getRawType()), "%s not declared by %s", paramConstructor, 
/*      */ 
/*      */         
/*  618 */         getRawType());
/*  619 */     return new e.a<T>(this, paramConstructor)
/*      */       {
/*      */         Type a() {
/*  622 */           return m.a(this.b).a(super.a());
/*      */         }
/*      */ 
/*      */         
/*      */         Type[] a() {
/*  627 */           return m.b(this.b).a(super.a());
/*      */         }
/*      */ 
/*      */         
/*      */         Type[] b() {
/*  632 */           return m.a(this.b).a(super.b());
/*      */         }
/*      */ 
/*      */         
/*      */         public m<T> a() {
/*  637 */           return this.b;
/*      */         }
/*      */ 
/*      */         
/*      */         public String toString() {
/*  642 */           String str1 = String.valueOf(a()), str2 = w.a(", ").join((Object[])a()); return (new StringBuilder(2 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append("(").append(str2).append(")").toString();
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */   
/*      */   public class g
/*      */     extends aK<m<? super T>>
/*      */     implements Serializable
/*      */   {
/*      */     private transient bt<m<? super T>> k;
/*      */     
/*      */     private static final long serialVersionUID = 0L;
/*      */ 
/*      */     
/*      */     g(m this$0) {}
/*      */ 
/*      */     
/*      */     public g c() {
/*  661 */       return new m.c(this.b, this);
/*      */     }
/*      */ 
/*      */     
/*      */     public g b() {
/*  666 */       return new m.b();
/*      */     }
/*      */ 
/*      */     
/*      */     protected Set<m<? super T>> a() {
/*  671 */       bt<m<? super T>> bt1 = this.k;
/*  672 */       if (bt1 == null) {
/*      */ 
/*      */ 
/*      */         
/*  676 */         bh<m<?>> bh = m.e.a.d(this.b);
/*  677 */         return 
/*      */ 
/*      */           
/*  680 */           (Set<m<? super T>>)(this.k = ap.a((Iterable)bh).a((E)m.f.a).e());
/*      */       } 
/*  682 */       return (Set<m<? super T>>)bt1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Set<Class<? super T>> G() {
/*  691 */       bh<Class<?>> bh = m.e.b.d((Iterable<? extends Class<?>>)m.a(this.b));
/*  692 */       return (Set<Class<? super T>>)bt.a((Collection)bh);
/*      */     }
/*      */   }
/*      */   
/*      */   private final class c
/*      */     extends g {
/*      */     private final transient m<T>.g a;
/*      */     private transient bt<m<? super T>> j;
/*      */     private static final long serialVersionUID = 0L;
/*      */     
/*      */     c(m this$0, m<T>.g param1g) {
/*  703 */       super(this$0);
/*  704 */       this.a = param1g;
/*      */     }
/*      */ 
/*      */     
/*      */     protected Set<m<? super T>> a() {
/*  709 */       bt<m<? super T>> bt1 = this.j;
/*  710 */       if (bt1 == null) {
/*  711 */         return 
/*  712 */           (Set<m<? super T>>)(this.j = ap.a((Iterable)this.a).a(m.f.b).e());
/*      */       }
/*  714 */       return (Set<m<? super T>>)bt1;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public m<T>.g c() {
/*  720 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Set<Class<? super T>> G() {
/*  728 */       bh<Class<?>> bh = m.e.b.d((Iterable<? extends Class<?>>)m.a(this.b));
/*  729 */       return (Set<Class<? super T>>)ap.a((Iterable)bh)
/*  730 */         .a(new E<Class<?>>(this)
/*      */           {
/*      */             public boolean a(Class<?> param2Class)
/*      */             {
/*  734 */               return param2Class.isInterface();
/*      */             }
/*  737 */           }).e();
/*      */     }
/*      */ 
/*      */     
/*      */     public m<T>.g b() {
/*  742 */       throw new UnsupportedOperationException("interfaces().classes() not supported.");
/*      */     }
/*      */     
/*      */     private Object readResolve() {
/*  746 */       return this.b.a().c();
/*      */     }
/*      */   }
/*      */   
/*      */   private final class b
/*      */     extends g {
/*      */     private transient bt<m<? super T>> i;
/*      */     private static final long serialVersionUID = 0L;
/*      */     
/*      */     private b(m this$0) {}
/*      */     
/*      */     protected Set<m<? super T>> a() {
/*  758 */       bt<m<? super T>> bt1 = this.i;
/*  759 */       if (bt1 == null) {
/*      */ 
/*      */ 
/*      */         
/*  763 */         bh<m> bh = m.e.a.a().d(this.b);
/*  764 */         return 
/*      */ 
/*      */           
/*  767 */           (Set<m<? super T>>)(this.i = ap.a((Iterable)bh).a((E)m.f.a).e());
/*      */       } 
/*  769 */       return (Set<m<? super T>>)bt1;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public m<T>.g b() {
/*  775 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Set<Class<? super T>> G() {
/*  783 */       bh bh = m.e.b.a().d((Iterable)m.a(this.b));
/*  784 */       return (Set<Class<? super T>>)bt.a((Collection)bh);
/*      */     }
/*      */ 
/*      */     
/*      */     public m<T>.g c() {
/*  789 */       throw new UnsupportedOperationException("classes().interfaces() not supported.");
/*      */     }
/*      */     
/*      */     private Object readResolve() {
/*  793 */       return this.b.a().b();
/*      */     }
/*      */   }
/*      */   
/*      */   private enum f
/*      */     implements E<m<?>>
/*      */   {
/*  800 */     a
/*      */     {
/*      */       public boolean c(m<?> param2m) {
/*  803 */         return (!(m.a(param2m) instanceof TypeVariable) && 
/*  804 */           !(m.a(param2m) instanceof WildcardType));
/*      */       }
/*      */     },
/*  807 */     b
/*      */     {
/*      */       public boolean c(m<?> param2m) {
/*  810 */         return param2m.getRawType().isInterface();
/*      */       }
/*      */     };
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(Object paramObject) {
/*  820 */     if (paramObject instanceof m) {
/*  821 */       m m1 = (m)paramObject;
/*  822 */       return this.b.equals(m1.b);
/*      */     } 
/*  824 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public int hashCode() {
/*  829 */     return this.b.hashCode();
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/*  834 */     return o.toString((Type)this.b);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Object writeReplace() {
/*  841 */     return a((new k()).a((Type)this.b));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.b.a.a
/*      */   final m<T> h() {
/*  850 */     (new n(this)
/*      */       {
/*      */         void a(TypeVariable<?> param1TypeVariable)
/*      */         {
/*  854 */           String str = String.valueOf(m.a(this.b)); throw new IllegalArgumentException((new StringBuilder(58 + String.valueOf(str).length())).append(str).append("contains a type variable and is not safe for the operation").toString());
/*      */         }
/*      */ 
/*      */         
/*      */         void a(WildcardType param1WildcardType) {
/*  859 */           a(param1WildcardType.getLowerBounds());
/*  860 */           a(param1WildcardType.getUpperBounds());
/*      */         }
/*      */ 
/*      */         
/*      */         void a(ParameterizedType param1ParameterizedType) {
/*  865 */           a(param1ParameterizedType.getActualTypeArguments());
/*  866 */           a(new Type[] { param1ParameterizedType.getOwnerType() });
/*      */         }
/*      */ 
/*      */         
/*      */         void a(GenericArrayType param1GenericArrayType) {
/*  871 */           a(new Type[] { param1GenericArrayType.getGenericComponentType() });
/*      */         }
/*  873 */       }).a(new Type[] { (Type)this.b });
/*  874 */     return this;
/*      */   }
/*      */   
/*      */   private boolean c(Class<?> paramClass) {
/*  878 */     for (dj<Class<?>> dj = x().b(); dj.hasNext(); ) { Class<?> clazz = dj.next();
/*  879 */       if (paramClass.isAssignableFrom(clazz)) {
/*  880 */         return true;
/*      */       } }
/*      */     
/*  883 */     return false;
/*      */   }
/*      */   
/*      */   private boolean a(ParameterizedType paramParameterizedType) {
/*  887 */     Class<?> clazz = a(paramParameterizedType).getRawType();
/*  888 */     if (!c(clazz)) {
/*  889 */       return false;
/*      */     }
/*  891 */     TypeVariable[] arrayOfTypeVariable = (TypeVariable[])clazz.getTypeParameters();
/*  892 */     Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
/*  893 */     for (byte b = 0; b < arrayOfTypeVariable.length; b++) {
/*  894 */       Type type = a().a(arrayOfTypeVariable[b]);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  899 */       if (!a(type).a(arrayOfType[b], arrayOfTypeVariable[b])) {
/*  900 */         return false;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  906 */     return (Modifier.isStatic(((Class)paramParameterizedType.getRawType()).getModifiers()) || paramParameterizedType
/*  907 */       .getOwnerType() == null || 
/*  908 */       d(paramParameterizedType.getOwnerType()));
/*      */   }
/*      */   
/*      */   private boolean a(GenericArrayType paramGenericArrayType) {
/*  912 */     if (this.b instanceof Class) {
/*  913 */       Class clazz = (Class)this.b;
/*  914 */       if (!clazz.isArray()) {
/*  915 */         return false;
/*      */       }
/*  917 */       return a(clazz.getComponentType()).c(paramGenericArrayType.getGenericComponentType());
/*  918 */     }  if (this.b instanceof GenericArrayType) {
/*  919 */       GenericArrayType genericArrayType = (GenericArrayType)this.b;
/*  920 */       return a(genericArrayType.getGenericComponentType())
/*  921 */         .c(paramGenericArrayType.getGenericComponentType());
/*      */     } 
/*  923 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean b(GenericArrayType paramGenericArrayType) {
/*  928 */     if (this.b instanceof Class) {
/*  929 */       Class clazz = (Class)this.b;
/*  930 */       if (!clazz.isArray()) {
/*  931 */         return clazz.isAssignableFrom(Object[].class);
/*      */       }
/*  933 */       return a(paramGenericArrayType.getGenericComponentType()).c(clazz.getComponentType());
/*  934 */     }  if (this.b instanceof GenericArrayType) {
/*  935 */       return a(paramGenericArrayType.getGenericComponentType())
/*  936 */         .c(((GenericArrayType)this.b).getGenericComponentType());
/*      */     }
/*  938 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean a(Type paramType, TypeVariable<?> paramTypeVariable) {
/*  969 */     if (this.b.equals(paramType)) {
/*  970 */       return true;
/*      */     }
/*  972 */     if (paramType instanceof WildcardType) {
/*  973 */       WildcardType wildcardType = a(paramTypeVariable, (WildcardType)paramType);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  979 */       return (a(wildcardType.getUpperBounds()).b((Type)this.b) && 
/*  980 */         a(wildcardType.getLowerBounds()).c((Type)this.b));
/*      */     } 
/*  982 */     return d((Type)this.b).equals(d(paramType));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Type a(TypeVariable<?> paramTypeVariable, Type paramType) {
/* 1004 */     return (paramType instanceof WildcardType) ? 
/* 1005 */       a(paramTypeVariable, (WildcardType)paramType) : 
/* 1006 */       d(paramType);
/*      */   }
/*      */   
/*      */   private static Type d(Type paramType) {
/* 1010 */     if (paramType instanceof ParameterizedType) {
/* 1011 */       return b((ParameterizedType)paramType);
/*      */     }
/* 1013 */     if (paramType instanceof GenericArrayType) {
/* 1014 */       return o.f(
/* 1015 */           d(((GenericArrayType)paramType).getGenericComponentType()));
/*      */     }
/* 1017 */     return paramType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static WildcardType a(TypeVariable<?> paramTypeVariable, WildcardType paramWildcardType) {
/* 1025 */     Type[] arrayOfType = paramTypeVariable.getBounds();
/* 1026 */     ArrayList<Type> arrayList = new ArrayList();
/* 1027 */     for (Type type : paramWildcardType.getUpperBounds()) {
/* 1028 */       if (!b(arrayOfType).c(type)) {
/* 1029 */         arrayList.add(d(type));
/*      */       }
/*      */     } 
/* 1032 */     return new o.h(paramWildcardType.getLowerBounds(), arrayList.<Type>toArray(new Type[0]));
/*      */   }
/*      */ 
/*      */   
/*      */   private static ParameterizedType b(ParameterizedType paramParameterizedType) {
/* 1037 */     Class<?> clazz = (Class)paramParameterizedType.getRawType();
/* 1038 */     TypeVariable[] arrayOfTypeVariable = clazz.getTypeParameters();
/* 1039 */     Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
/* 1040 */     for (byte b = 0; b < arrayOfType.length; b++) {
/* 1041 */       arrayOfType[b] = a(arrayOfTypeVariable[b], arrayOfType[b]);
/*      */     }
/* 1043 */     return o.a(paramParameterizedType.getOwnerType(), clazz, arrayOfType);
/*      */   }
/*      */ 
/*      */   
/*      */   private static a a(Type[] paramArrayOfType) {
/* 1048 */     return new a(paramArrayOfType, false);
/*      */   }
/*      */ 
/*      */   
/*      */   private static a b(Type[] paramArrayOfType) {
/* 1053 */     return new a(paramArrayOfType, true);
/*      */   }
/*      */   
/*      */   private static class a {
/*      */     private final Type[] a;
/*      */     private final boolean bh;
/*      */     
/*      */     a(Type[] param1ArrayOfType, boolean param1Boolean) {
/* 1061 */       this.a = param1ArrayOfType;
/* 1062 */       this.bh = param1Boolean;
/*      */     }
/*      */     
/*      */     boolean c(Type param1Type) {
/* 1066 */       for (Type type : this.a) {
/* 1067 */         if (m.a(type).c(param1Type) == this.bh) {
/* 1068 */           return this.bh;
/*      */         }
/*      */       } 
/* 1071 */       return !this.bh;
/*      */     }
/*      */     
/*      */     boolean b(Type param1Type) {
/* 1075 */       m<?> m = m.a(param1Type);
/* 1076 */       for (Type type : this.a) {
/* 1077 */         if (m.c(type) == this.bh) {
/* 1078 */           return this.bh;
/*      */         }
/*      */       } 
/* 1081 */       return !this.bh;
/*      */     }
/*      */   }
/*      */   
/*      */   private bt<Class<? super T>> x() {
/* 1086 */     bt.a a = bt.a();
/* 1087 */     (new n(this, a)
/*      */       {
/*      */         void a(TypeVariable<?> param1TypeVariable) {
/* 1090 */           a(param1TypeVariable.getBounds());
/*      */         }
/*      */ 
/*      */         
/*      */         void a(WildcardType param1WildcardType) {
/* 1095 */           a(param1WildcardType.getUpperBounds());
/*      */         }
/*      */ 
/*      */         
/*      */         void a(ParameterizedType param1ParameterizedType) {
/* 1100 */           this.a.a(param1ParameterizedType.getRawType());
/*      */         }
/*      */ 
/*      */         
/*      */         void a(Class<?> param1Class) {
/* 1105 */           this.a.a(param1Class);
/*      */         }
/*      */ 
/*      */         
/*      */         void a(GenericArrayType param1GenericArrayType) {
/* 1110 */           this.a.a(o.c(m.a(param1GenericArrayType.getGenericComponentType()).getRawType()));
/*      */         }
/* 1112 */       }).a(new Type[] { (Type)this.b });
/*      */ 
/*      */     
/* 1115 */     return a.o();
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean d(Type paramType) {
/* 1120 */     for (m m1 : a()) {
/* 1121 */       Type type = m1.c();
/* 1122 */       if (type != null && a(type).c(paramType)) {
/* 1123 */         return true;
/*      */       }
/*      */     } 
/* 1126 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Type c() {
/* 1134 */     if (this.b instanceof ParameterizedType)
/* 1135 */       return ((ParameterizedType)this.b).getOwnerType(); 
/* 1136 */     if (this.b instanceof Class) {
/* 1137 */       return ((Class)this.b).getEnclosingClass();
/*      */     }
/* 1139 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.d
/*      */   static <T> m<? extends T> d(Class<T> paramClass) {
/* 1152 */     if (paramClass.isArray()) {
/*      */       
/* 1154 */       Type type = o.f(
/*      */           
/* 1156 */           (Type)(d((Class)paramClass.getComponentType())).b);
/*      */       
/* 1158 */       return (m)a(type);
/*      */     } 
/*      */     
/* 1161 */     TypeVariable[] arrayOfTypeVariable = (TypeVariable[])paramClass.getTypeParameters();
/*      */ 
/*      */ 
/*      */     
/* 1165 */     k k1 = (paramClass.isMemberClass() && !Modifier.isStatic(paramClass.getModifiers())) ? (d((Class)paramClass.getEnclosingClass())).b : null;
/*      */     
/* 1167 */     if (arrayOfTypeVariable.length > 0 || (k1 != null && k1 != paramClass.getEnclosingClass()))
/*      */     {
/*      */ 
/*      */       
/* 1171 */       return (m)a(o.a((Type)k1, paramClass, (Type[])arrayOfTypeVariable));
/*      */     }
/*      */     
/* 1174 */     return a(paramClass);
/*      */   }
/*      */ 
/*      */   
/*      */   private k a() {
/* 1179 */     k k1 = this.b;
/* 1180 */     if (k1 == null) {
/* 1181 */       k1 = this.b = k.a((Type)this.b);
/*      */     }
/* 1183 */     return k1;
/*      */   }
/*      */   
/*      */   private k b() {
/* 1187 */     k k1 = this.a;
/* 1188 */     if (k1 == null) {
/* 1189 */       k1 = this.a = k.b((Type)this.b);
/*      */     }
/* 1191 */     return k1;
/*      */   }
/*      */ 
/*      */   
/*      */   private m<? super T> a(Class<? super T> paramClass, Type[] paramArrayOfType) {
/* 1196 */     for (Type type : paramArrayOfType) {
/*      */       
/* 1198 */       m<?> m1 = a(type);
/* 1199 */       if (m1.c(paramClass))
/*      */       {
/* 1201 */         return (m)m1.b(paramClass);
/*      */       }
/*      */     } 
/*      */     
/* 1205 */     String str1 = String.valueOf(paramClass), str2 = String.valueOf(this); throw new IllegalArgumentException((new StringBuilder(23 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(" isn't a super type of ").append(str2).toString());
/*      */   }
/*      */   
/*      */   private m<? extends T> b(Class<?> paramClass, Type[] paramArrayOfType) {
/* 1209 */     if (paramArrayOfType.length > 0) {
/*      */       
/* 1211 */       m<?> m1 = a(paramArrayOfType[0]);
/*      */       
/* 1213 */       return (m)m1.c(paramClass);
/*      */     } 
/* 1215 */     String str1 = String.valueOf(paramClass), str2 = String.valueOf(this); throw new IllegalArgumentException((new StringBuilder(21 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(" isn't a subclass of ").append(str2).toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private m<? super T> e(Class<? super T> paramClass) {
/* 1223 */     m<?> m1 = (m)D.a(g(), "%s isn't a super type of %s", paramClass, this);
/*      */ 
/*      */     
/* 1226 */     m<?> m2 = m1.b(paramClass.getComponentType());
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1231 */     return (m)a(e((Type)m2.b));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private m<? extends T> f(Class<?> paramClass) {
/* 1237 */     m<?> m1 = g().c(paramClass.getComponentType());
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1242 */     return (m)a(e((Type)m1.b));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Type a(Class<?> paramClass) {
/* 1251 */     if (this.b instanceof Class && ((paramClass
/* 1252 */       .getTypeParameters()).length == 0 || (
/* 1253 */       getRawType().getTypeParameters()).length != 0))
/*      */     {
/* 1255 */       return paramClass;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1264 */     m<?> m1 = d(paramClass);
/*      */ 
/*      */     
/* 1267 */     k k1 = (m1.b(getRawType())).b;
/* 1268 */     return (new k())
/* 1269 */       .a((Type)k1, (Type)this.b)
/* 1270 */       .a((Type)m1.b);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Type e(Type paramType) {
/* 1278 */     return o.c.b.f(paramType);
/*      */   }
/*      */   
/*      */   private static final class d<T> extends m<T> { private static final long serialVersionUID = 0L;
/*      */     
/*      */     d(Type param1Type) {
/* 1284 */       super(param1Type);
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static abstract class e<K>
/*      */   {
/*      */     private e() {}
/*      */ 
/*      */ 
/*      */     
/* 1297 */     static final e<m<?>> a = new e<m<?>>()
/*      */       {
/*      */         Class<?> a(m<?> param2m)
/*      */         {
/* 1301 */           return param2m.getRawType();
/*      */         }
/*      */ 
/*      */         
/*      */         Iterable<? extends m<?>> a(m<?> param2m) {
/* 1306 */           return (Iterable<? extends m<?>>)param2m.o();
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         m<?> a(m<?> param2m) {
/* 1312 */           return param2m.d();
/*      */         }
/*      */       };
/*      */     
/* 1316 */     static final e<Class<?>> b = new e<Class<?>>()
/*      */       {
/*      */         Class<?> a(Class<?> param2Class)
/*      */         {
/* 1320 */           return param2Class;
/*      */         }
/*      */ 
/*      */         
/*      */         Iterable<? extends Class<?>> a(Class<?> param2Class) {
/* 1325 */           return Arrays.asList(param2Class.getInterfaces());
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         Class<?> b(Class<?> param2Class) {
/* 1331 */           return param2Class.getSuperclass();
/*      */         }
/*      */       };
/*      */ 
/*      */     
/*      */     final e<K> a() {
/* 1337 */       return new a<K>(this, this)
/*      */         {
/*      */           Iterable<? extends K> g(K param2K) {
/* 1340 */             return (Iterable<? extends K>)bt.n();
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           bh<K> d(Iterable<? extends K> param2Iterable) {
/*      */             // Byte code:
/*      */             //   0: invokestatic a : ()Lcom/google/a/d/bh$a;
/*      */             //   3: astore_2
/*      */             //   4: aload_1
/*      */             //   5: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */             //   10: astore_3
/*      */             //   11: aload_3
/*      */             //   12: invokeinterface hasNext : ()Z
/*      */             //   17: ifeq -> 50
/*      */             //   20: aload_3
/*      */             //   21: invokeinterface next : ()Ljava/lang/Object;
/*      */             //   26: astore #4
/*      */             //   28: aload_0
/*      */             //   29: aload #4
/*      */             //   31: invokevirtual a : (Ljava/lang/Object;)Ljava/lang/Class;
/*      */             //   34: invokevirtual isInterface : ()Z
/*      */             //   37: ifne -> 47
/*      */             //   40: aload_2
/*      */             //   41: aload #4
/*      */             //   43: invokevirtual a : (Ljava/lang/Object;)Lcom/google/a/d/bh$a;
/*      */             //   46: pop
/*      */             //   47: goto -> 11
/*      */             //   50: aload_0
/*      */             //   51: aload_2
/*      */             //   52: invokevirtual g : ()Lcom/google/a/d/bh;
/*      */             //   55: invokespecial d : (Ljava/lang/Iterable;)Lcom/google/a/d/bh;
/*      */             //   58: areturn
/*      */             // Line number table:
/*      */             //   Java source line number -> byte code offset
/*      */             //   #1345	-> 0
/*      */             //   #1346	-> 4
/*      */             //   #1347	-> 28
/*      */             //   #1348	-> 40
/*      */             //   #1350	-> 47
/*      */             //   #1351	-> 50
/*      */           }
/*      */         };
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final bh<K> d(K param1K) {
/* 1357 */       return d((Iterable<? extends K>)bh.a(param1K));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     bh<K> d(Iterable<? extends K> param1Iterable) {
/*      */       // Byte code:
/*      */       //   0: invokestatic a : ()Ljava/util/HashMap;
/*      */       //   3: astore_2
/*      */       //   4: aload_1
/*      */       //   5: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */       //   10: astore_3
/*      */       //   11: aload_3
/*      */       //   12: invokeinterface hasNext : ()Z
/*      */       //   17: ifeq -> 39
/*      */       //   20: aload_3
/*      */       //   21: invokeinterface next : ()Ljava/lang/Object;
/*      */       //   26: astore #4
/*      */       //   28: aload_0
/*      */       //   29: aload #4
/*      */       //   31: aload_2
/*      */       //   32: invokespecial a : (Ljava/lang/Object;Ljava/util/Map;)I
/*      */       //   35: pop
/*      */       //   36: goto -> 11
/*      */       //   39: aload_2
/*      */       //   40: invokestatic e : ()Lcom/google/a/d/cj;
/*      */       //   43: invokevirtual a : ()Lcom/google/a/d/cj;
/*      */       //   46: invokestatic a : (Ljava/util/Map;Ljava/util/Comparator;)Lcom/google/a/d/bh;
/*      */       //   49: areturn
/*      */       // Line number table:
/*      */       //   Java source line number -> byte code offset
/*      */       //   #1362	-> 0
/*      */       //   #1363	-> 4
/*      */       //   #1364	-> 28
/*      */       //   #1365	-> 36
/*      */       //   #1366	-> 39
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @com.google.b.a.a
/*      */     private int a(K param1K, Map<? super K, Integer> param1Map) {
/*      */       // Byte code:
/*      */       //   0: aload_2
/*      */       //   1: aload_1
/*      */       //   2: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*      */       //   7: checkcast java/lang/Integer
/*      */       //   10: astore_3
/*      */       //   11: aload_3
/*      */       //   12: ifnull -> 20
/*      */       //   15: aload_3
/*      */       //   16: invokevirtual intValue : ()I
/*      */       //   19: ireturn
/*      */       //   20: aload_0
/*      */       //   21: aload_1
/*      */       //   22: invokevirtual a : (Ljava/lang/Object;)Ljava/lang/Class;
/*      */       //   25: invokevirtual isInterface : ()Z
/*      */       //   28: ifeq -> 35
/*      */       //   31: iconst_1
/*      */       //   32: goto -> 36
/*      */       //   35: iconst_0
/*      */       //   36: istore #4
/*      */       //   38: aload_0
/*      */       //   39: aload_1
/*      */       //   40: invokevirtual g : (Ljava/lang/Object;)Ljava/lang/Iterable;
/*      */       //   43: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */       //   48: astore #5
/*      */       //   50: aload #5
/*      */       //   52: invokeinterface hasNext : ()Z
/*      */       //   57: ifeq -> 86
/*      */       //   60: aload #5
/*      */       //   62: invokeinterface next : ()Ljava/lang/Object;
/*      */       //   67: astore #6
/*      */       //   69: iload #4
/*      */       //   71: aload_0
/*      */       //   72: aload #6
/*      */       //   74: aload_2
/*      */       //   75: invokespecial a : (Ljava/lang/Object;Ljava/util/Map;)I
/*      */       //   78: invokestatic max : (II)I
/*      */       //   81: istore #4
/*      */       //   83: goto -> 50
/*      */       //   86: aload_0
/*      */       //   87: aload_1
/*      */       //   88: invokevirtual H : (Ljava/lang/Object;)Ljava/lang/Object;
/*      */       //   91: astore #5
/*      */       //   93: aload #5
/*      */       //   95: ifnull -> 112
/*      */       //   98: iload #4
/*      */       //   100: aload_0
/*      */       //   101: aload #5
/*      */       //   103: aload_2
/*      */       //   104: invokespecial a : (Ljava/lang/Object;Ljava/util/Map;)I
/*      */       //   107: invokestatic max : (II)I
/*      */       //   110: istore #4
/*      */       //   112: aload_2
/*      */       //   113: aload_1
/*      */       //   114: iload #4
/*      */       //   116: iconst_1
/*      */       //   117: iadd
/*      */       //   118: invokestatic valueOf : (I)Ljava/lang/Integer;
/*      */       //   121: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*      */       //   126: pop
/*      */       //   127: iload #4
/*      */       //   129: iconst_1
/*      */       //   130: iadd
/*      */       //   131: ireturn
/*      */       // Line number table:
/*      */       //   Java source line number -> byte code offset
/*      */       //   #1372	-> 0
/*      */       //   #1373	-> 11
/*      */       //   #1375	-> 15
/*      */       //   #1378	-> 20
/*      */       //   #1379	-> 38
/*      */       //   #1380	-> 69
/*      */       //   #1381	-> 83
/*      */       //   #1382	-> 86
/*      */       //   #1383	-> 93
/*      */       //   #1384	-> 98
/*      */       //   #1391	-> 112
/*      */       //   #1392	-> 127
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static <K, V> bh<K> a(Map<K, V> param1Map, Comparator<? super V> param1Comparator) {
/* 1397 */       cj<K> cj = new cj<K>(param1Comparator, param1Map)
/*      */         {
/*      */           public int compare(K param2K1, K param2K2)
/*      */           {
/* 1401 */             return this.i.compare(this.ai.get(param2K1), this.ai.get(param2K2));
/*      */           }
/*      */         };
/* 1404 */       return cj.a(param1Map.keySet());
/*      */     }
/*      */     
/*      */     abstract Class<?> a(K param1K);
/*      */     
/*      */     abstract Iterable<? extends K> g(K param1K);
/*      */     
/*      */     abstract K H(K param1K);
/*      */     
/*      */     private static class a<K>
/*      */       extends e<K> {
/*      */       private final m.e<K> c;
/*      */       
/*      */       a(m.e<K> param2e) {
/* 1418 */         this.c = param2e;
/*      */       }
/*      */ 
/*      */       
/*      */       Class<?> a(K param2K) {
/* 1423 */         return this.c.a(param2K);
/*      */       }
/*      */ 
/*      */       
/*      */       Iterable<? extends K> g(K param2K) {
/* 1428 */         return this.c.g(param2K);
/*      */       }
/*      */ 
/*      */       
/*      */       K H(K param2K) {
/* 1433 */         return this.c.H(param2K);
/*      */       }
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\n\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */