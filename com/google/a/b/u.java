/*     */ package com.google.a.b;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
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
/*     */ @b
/*     */ public final class u
/*     */ {
/*     */   public static s<Object, String> a() {
/*  60 */     return (s<Object, String>)h.a;
/*     */   }
/*     */   
/*     */   private enum h
/*     */     implements s<Object, String> {
/*  65 */     a;
/*     */ 
/*     */     
/*     */     public String j(Object param1Object) {
/*  69 */       D.checkNotNull(param1Object);
/*  70 */       return param1Object.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  75 */       return "Functions.toStringFunction()";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> s<E, E> b() {
/*  83 */     return (s<E, E>)e.a;
/*     */   }
/*     */   
/*     */   private enum e
/*     */     implements s<Object, Object> {
/*  88 */     a;
/*     */ 
/*     */     
/*     */     public Object apply(Object param1Object) {
/*  92 */       return param1Object;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  97 */       return "Functions.identity()";
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
/*     */   public static <K, V> s<K, V> a(Map<K, V> paramMap) {
/* 115 */     return new d<>(paramMap);
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
/*     */   public static <K, V> s<K, V> a(Map<K, ? extends V> paramMap, V paramV) {
/* 132 */     return new b<>(paramMap, paramV);
/*     */   }
/*     */   
/*     */   private static class d<K, V> implements s<K, V>, Serializable {
/*     */     final Map<K, V> map;
/*     */     
/*     */     d(Map<K, V> param1Map) {
/* 139 */       this.map = D.<Map<K, V>>checkNotNull(param1Map);
/*     */     }
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     public V apply(K param1K) {
/* 144 */       V v = this.map.get(param1K);
/* 145 */       D.a((v != null || this.map.containsKey(param1K)), "Key '%s' not present in map", param1K);
/* 146 */       return v;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 151 */       if (param1Object instanceof d) {
/* 152 */         d d1 = (d)param1Object;
/* 153 */         return this.map.equals(d1.map);
/*     */       } 
/* 155 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 160 */       return this.map.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 165 */       String str = String.valueOf(this.map); return (new StringBuilder(18 + String.valueOf(str).length())).append("Functions.forMap(").append(str).append(")").toString();
/*     */     }
/*     */   }
/*     */   
/*     */   private static class b<K, V>
/*     */     implements s<K, V>, Serializable {
/*     */     final Map<K, ? extends V> map;
/*     */     final V j;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     b(Map<K, ? extends V> param1Map, V param1V) {
/* 176 */       this.map = D.<Map<K, ? extends V>>checkNotNull(param1Map);
/* 177 */       this.j = param1V;
/*     */     }
/*     */ 
/*     */     
/*     */     public V apply(K param1K) {
/* 182 */       V v = this.map.get(param1K);
/* 183 */       return (v != null || this.map.containsKey(param1K)) ? v : this.j;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 188 */       if (param1Object instanceof b) {
/* 189 */         b b1 = (b)param1Object;
/* 190 */         return (this.map.equals(b1.map) && y.equal(this.j, b1.j));
/*     */       } 
/* 192 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 197 */       return y.a(new Object[] { this.map, this.j });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 203 */       String str1 = String.valueOf(this.map), str2 = String.valueOf(this.j); return (new StringBuilder(33 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("Functions.forMap(").append(str1).append(", defaultValue=").append(str2).append(")").toString();
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
/*     */   public static <A, B, C> s<A, C> a(s<B, C> params, s<A, ? extends B> params1) {
/* 222 */     return new c<>(params, params1);
/*     */   }
/*     */   
/*     */   private static class c<A, B, C> implements s<A, C>, Serializable { private final s<B, C> d;
/*     */     private final s<A, ? extends B> e;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     public c(s<B, C> param1s, s<A, ? extends B> param1s1) {
/* 230 */       this.d = D.<s<B, C>>checkNotNull(param1s);
/* 231 */       this.e = D.<s<A, ? extends B>>checkNotNull(param1s1);
/*     */     }
/*     */ 
/*     */     
/*     */     public C apply(A param1A) {
/* 236 */       return this.d.apply(this.e.apply(param1A));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 241 */       if (param1Object instanceof c) {
/* 242 */         c c1 = (c)param1Object;
/* 243 */         return (this.e.equals(c1.e) && this.d.equals(c1.d));
/*     */       } 
/* 245 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 250 */       return this.e.hashCode() ^ this.d.hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 256 */       String str1 = String.valueOf(this.d), str2 = String.valueOf(this.e); return (new StringBuilder(2 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append("(").append(str2).append(")").toString();
/*     */     } }
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
/*     */   public static <T> s<T, Boolean> a(E<T> paramE) {
/* 271 */     return new f<>(paramE);
/*     */   }
/*     */   
/*     */   private static class f<T> implements s<T, Boolean>, Serializable {
/*     */     private final E<T> a;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     private f(E<T> param1E) {
/* 279 */       this.a = D.<E<T>>checkNotNull(param1E);
/*     */     }
/*     */ 
/*     */     
/*     */     public Boolean a(T param1T) {
/* 284 */       return Boolean.valueOf(this.a.b(param1T));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 289 */       if (param1Object instanceof f) {
/* 290 */         f f1 = (f)param1Object;
/* 291 */         return this.a.equals(f1.a);
/*     */       } 
/* 293 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 298 */       return this.a.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 303 */       String str = String.valueOf(this.a); return (new StringBuilder(24 + String.valueOf(str).length())).append("Functions.forPredicate(").append(str).append(")").toString();
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
/*     */   public static <E> s<Object, E> a(E paramE) {
/* 318 */     return new a<>(paramE);
/*     */   }
/*     */   
/*     */   private static class a<E> implements s<Object, E>, Serializable { private final E value;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     public a(E param1E) {
/* 325 */       this.value = param1E;
/*     */     }
/*     */ 
/*     */     
/*     */     public E apply(Object param1Object) {
/* 330 */       return this.value;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 335 */       if (param1Object instanceof a) {
/* 336 */         a a1 = (a)param1Object;
/* 337 */         return y.equal(this.value, a1.value);
/*     */       } 
/* 339 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 344 */       return (this.value == null) ? 0 : this.value.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 349 */       String str = String.valueOf(this.value); return (new StringBuilder(20 + String.valueOf(str).length())).append("Functions.constant(").append(str).append(")").toString();
/*     */     } }
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
/*     */   public static <T> s<Object, T> a(M<T> paramM) {
/* 363 */     return new g<>(paramM);
/*     */   }
/*     */   
/*     */   private static class g<T>
/*     */     implements s<Object, T>, Serializable {
/*     */     private final M<T> a;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     private g(M<T> param1M) {
/* 372 */       this.a = D.<M<T>>checkNotNull(param1M);
/*     */     }
/*     */ 
/*     */     
/*     */     public T apply(Object param1Object) {
/* 377 */       return this.a.get();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 382 */       if (param1Object instanceof g) {
/* 383 */         g g1 = (g)param1Object;
/* 384 */         return this.a.equals(g1.a);
/*     */       } 
/* 386 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 391 */       return this.a.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 396 */       String str = String.valueOf(this.a); return (new StringBuilder(23 + String.valueOf(str).length())).append("Functions.forSupplier(").append(str).append(")").toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\\\u.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */