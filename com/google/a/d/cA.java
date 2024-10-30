/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.M;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.EnumMap;
/*     */ import java.util.EnumSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.SortedSet;
/*     */ import java.util.TreeMap;
/*     */ import java.util.TreeSet;
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
/*     */ @b
/*     */ public abstract class ca<K0, V0>
/*     */ {
/*     */   private static final int eV = 8;
/*     */   
/*     */   private ca() {}
/*     */   
/*     */   public static g<Object> a() {
/*  76 */     return a(8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static g<Object> a(int paramInt) {
/*  86 */     C.b(paramInt, "expectedKeys");
/*  87 */     return new g(paramInt)
/*     */       {
/*     */         <K, V> Map<K, Collection<V>> I() {
/*  90 */           return cl.c(this.eW);
/*     */         }
/*     */       };
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
/*     */   public static g<Object> b() {
/* 104 */     return b(8);
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
/*     */   public static g<Object> b(int paramInt) {
/* 117 */     C.b(paramInt, "expectedKeys");
/* 118 */     return new g(paramInt)
/*     */       {
/*     */         <K, V> Map<K, Collection<V>> I() {
/* 121 */           return cl.d(this.eW);
/*     */         }
/*     */       };
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
/*     */   public static g<Comparable> c() {
/* 138 */     return a(cj.e());
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
/*     */   public static <K0> g<K0> a(final Comparator<K0> comparator) {
/* 155 */     D.checkNotNull(comparator);
/* 156 */     return new g<K0>()
/*     */       {
/*     */         <K extends K0, V> Map<K, Collection<V>> I() {
/* 159 */           return new TreeMap<>(comparator);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K0 extends Enum<K0>> g<K0> a(Class<K0> paramClass) {
/* 171 */     D.checkNotNull(paramClass);
/* 172 */     return new g<K0>(paramClass)
/*     */       {
/*     */ 
/*     */         
/*     */         <K extends K0, V> Map<K, Collection<V>> I()
/*     */         {
/* 178 */           return (Map)new EnumMap<>(this.d);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private static final class a<V> implements M<List<V>>, Serializable {
/*     */     private final int dU;
/*     */     
/*     */     a(int param1Int) {
/* 187 */       this.dU = C.b(param1Int, "expectedValuesPerKey");
/*     */     }
/*     */ 
/*     */     
/*     */     public List<V> X() {
/* 192 */       return new ArrayList<>(this.dU);
/*     */     }
/*     */   }
/*     */   
/*     */   private enum e implements M<List<Object>> {
/* 197 */     a;
/*     */ 
/*     */ 
/*     */     
/*     */     public static <V> M<List<V>> b() {
/* 202 */       return (M<List<V>>)a;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public List<Object> X() {
/* 208 */       return new LinkedList();
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class c<V> implements M<Set<V>>, Serializable {
/*     */     private final int dU;
/*     */     
/*     */     c(int param1Int) {
/* 216 */       this.dU = C.b(param1Int, "expectedValuesPerKey");
/*     */     }
/*     */ 
/*     */     
/*     */     public Set<V> r() {
/* 221 */       return cl.b(this.dU);
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class d<V> implements M<Set<V>>, Serializable {
/*     */     private final int dU;
/*     */     
/*     */     d(int param1Int) {
/* 229 */       this.dU = C.b(param1Int, "expectedValuesPerKey");
/*     */     }
/*     */ 
/*     */     
/*     */     public Set<V> r() {
/* 234 */       return cl.c(this.dU);
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class j<V> implements M<SortedSet<V>>, Serializable {
/*     */     private final Comparator<? super V> comparator;
/*     */     
/*     */     j(Comparator<? super V> param1Comparator) {
/* 242 */       this.comparator = (Comparator<? super V>)D.checkNotNull(param1Comparator);
/*     */     }
/*     */ 
/*     */     
/*     */     public SortedSet<V> i() {
/* 247 */       return new TreeSet<>(this.comparator);
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class b<V extends Enum<V>>
/*     */     implements M<Set<V>>, Serializable {
/*     */     private final Class<V> clazz;
/*     */     
/*     */     b(Class<V> param1Class) {
/* 256 */       this.clazz = (Class<V>)D.checkNotNull(param1Class);
/*     */     }
/*     */ 
/*     */     
/*     */     public Set<V> r() {
/* 261 */       return EnumSet.noneOf(this.clazz);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class g<K0>
/*     */   {
/*     */     private static final int eX = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     abstract <K extends K0, V> Map<K, Collection<V>> I();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ca.f<K0, Object> a() {
/* 282 */       return a(2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ca.f<K0, Object> a(int param1Int) {
/* 292 */       C.b(param1Int, "expectedValuesPerKey");
/* 293 */       return new ca.f<K0, Object>(this, param1Int)
/*     */         {
/*     */           public <K extends K0, V> bR<K, V> c() {
/* 296 */             return cb.a(this.a
/* 297 */                 .I(), new ca.a(this.eY));
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public ca.f<K0, Object> b() {
/* 305 */       return new ca.f<K0, Object>(this)
/*     */         {
/*     */           public <K extends K0, V> bR<K, V> c() {
/* 308 */             return cb.a(this.a
/* 309 */                 .I(), (M)ca.e.b());
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     public ca.h<K0, Object> a() {
/* 316 */       return a(2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ca.h<K0, Object> a(int param1Int) {
/* 326 */       C.b(param1Int, "expectedValuesPerKey");
/* 327 */       return new ca.h<K0, Object>(this, param1Int)
/*     */         {
/*     */           public <K extends K0, V> cF<K, V> c() {
/* 330 */             return cb.a(this.a
/* 331 */                 .I(), new ca.c(this.eY));
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public ca.h<K0, Object> b() {
/* 339 */       return b(2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ca.h<K0, Object> b(int param1Int) {
/* 349 */       C.b(param1Int, "expectedValuesPerKey");
/* 350 */       return new ca.h<K0, Object>(this, param1Int)
/*     */         {
/*     */           public <K extends K0, V> cF<K, V> c() {
/* 353 */             return cb.a(this.a
/* 354 */                 .I(), new ca.d(this.eY));
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ca.i<K0, Comparable> a() {
/* 363 */       return a(cj.e());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public <V0> ca.i<K0, V0> a(final Comparator<V0> comparator) {
/* 373 */       D.b(comparator, "comparator");
/* 374 */       return new ca.i<K0, V0>(this)
/*     */         {
/*     */           public <K extends K0, V extends V0> cS<K, V> b() {
/* 377 */             return cb.a(this.a
/* 378 */                 .I(), new ca.j(comparator));
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public <V0 extends Enum<V0>> ca.h<K0, V0> a(Class<V0> param1Class) {
/* 386 */       D.b(param1Class, "valueClass");
/* 387 */       return new ca.h<K0, V0>(this, param1Class)
/*     */         {
/*     */ 
/*     */           
/*     */           public <K extends K0, V extends V0> cF<K, V> c()
/*     */           {
/* 393 */             ca.b<Enum> b = new ca.b<>(this.e);
/* 394 */             return cb.a(this.a.I(), (M)b);
/*     */           }
/*     */         };
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
/*     */   public <K extends K0, V extends V0> bZ<K, V> a(bZ<? extends K, ? extends V> parambZ) {
/* 409 */     bZ<Object, Object> bZ1 = d();
/* 410 */     bZ1.a(parambZ);
/* 411 */     return (bZ)bZ1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract <K extends K0, V extends V0> bZ<K, V> d();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class f<K0, V0>
/*     */     extends ca<K0, V0>
/*     */   {
/*     */     public <K extends K0, V extends V0> bR<K, V> a(bZ<? extends K, ? extends V> param1bZ) {
/* 428 */       return (bR<K, V>)super.<K, V>a(param1bZ);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract <K extends K0, V extends V0> bR<K, V> c();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class h<K0, V0>
/*     */     extends ca<K0, V0>
/*     */   {
/*     */     public <K extends K0, V extends V0> cF<K, V> a(bZ<? extends K, ? extends V> param1bZ) {
/* 446 */       return (cF<K, V>)super.<K, V>a(param1bZ);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract <K extends K0, V extends V0> cF<K, V> c();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class i<K0, V0>
/*     */     extends h<K0, V0>
/*     */   {
/*     */     public <K extends K0, V extends V0> cS<K, V> a(bZ<? extends K, ? extends V> param1bZ) {
/* 464 */       return (cS<K, V>)super.<K, V>a(param1bZ);
/*     */     }
/*     */     
/*     */     public abstract <K extends K0, V extends V0> cS<K, V> b();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\ca.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */