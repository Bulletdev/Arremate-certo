/*     */ package com.google.a.g;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.E;
/*     */ import com.google.a.b.s;
/*     */ import com.google.a.d.bH;
/*     */ import com.google.a.d.bW;
/*     */ import com.google.a.d.bt;
/*     */ import com.google.a.d.cG;
/*     */ import java.util.AbstractSet;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public abstract class e<N, E>
/*     */   implements H<N, E>
/*     */ {
/*     */   public s<N> a() {
/*  57 */     return new c<N>(this)
/*     */       {
/*     */         public Set<N> A() {
/*  60 */           return this.a.A();
/*     */         }
/*     */ 
/*     */         
/*     */         public Set<n<N>> v() {
/*  65 */           if (this.a.db()) {
/*  66 */             return super.v();
/*     */           }
/*     */ 
/*     */           
/*  70 */           return new AbstractSet<n<N>>(this)
/*     */             {
/*     */               public Iterator<n<N>> iterator() {
/*  73 */                 return bH.a(this.a.a
/*  74 */                     .v().iterator(), new s<E, n<N>>(this)
/*     */                     {
/*     */                       public n<N> a(E param3E)
/*     */                       {
/*  78 */                         return this.a.a.a.b(param3E);
/*     */                       }
/*     */                     });
/*     */               }
/*     */ 
/*     */               
/*     */               public int size() {
/*  85 */                 return this.a.a.v().size();
/*     */               }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*     */               public boolean contains(Object param2Object) {
/*  94 */                 if (!(param2Object instanceof n)) {
/*  95 */                   return false;
/*     */                 }
/*  97 */                 n<?> n = (n)param2Object;
/*  98 */                 return (this.a.b(n) && this.a
/*  99 */                   .A().contains(n.D()) && this.a
/* 100 */                   .f((N)n.D()).contains(n.E()));
/*     */               }
/*     */             };
/*     */         }
/*     */ 
/*     */         
/*     */         public m<N> b() {
/* 107 */           return this.a.b();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public m<N> a() {
/* 114 */           return m.c();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean cX() {
/* 119 */           return this.a.cX();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean cY() {
/* 124 */           return this.a.cY();
/*     */         }
/*     */ 
/*     */         
/*     */         public Set<N> d(N param1N) {
/* 129 */           return this.a.d(param1N);
/*     */         }
/*     */ 
/*     */         
/*     */         public Set<N> e(N param1N) {
/* 134 */           return this.a.e(param1N);
/*     */         }
/*     */ 
/*     */         
/*     */         public Set<N> f(N param1N) {
/* 139 */           return this.a.f(param1N);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int m(N paramN) {
/* 148 */     if (cX()) {
/* 149 */       return com.google.a.k.e.v(h(paramN).size(), i(paramN).size());
/*     */     }
/* 151 */     return com.google.a.k.e.v(b(paramN).size(), a(paramN, paramN).size());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int n(N paramN) {
/* 157 */     return cX() ? h(paramN).size() : m(paramN);
/*     */   }
/*     */ 
/*     */   
/*     */   public int o(N paramN) {
/* 162 */     return cX() ? i(paramN).size() : m(paramN);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<E> c(E paramE) {
/* 167 */     n<N> n = b(paramE);
/*     */     
/* 169 */     cG.i i = cG.a(b(n.D()), b(n.E()));
/* 170 */     return (Set<E>)cG.c((Set)i, (Set)bt.b(paramE));
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<E> a(N paramN1, N paramN2) {
/* 175 */     Set<E> set1 = i(paramN1);
/* 176 */     Set<E> set2 = h(paramN2);
/* 177 */     return (set1.size() <= set2.size()) ? 
/* 178 */       Collections.<E>unmodifiableSet(cG.a(set1, a(paramN1, paramN2))) : 
/* 179 */       Collections.<E>unmodifiableSet(cG.a(set2, a(paramN2, paramN1)));
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<E> a(n<N> paramn) {
/* 184 */     a(paramn);
/* 185 */     return a(paramn.D(), paramn.E());
/*     */   }
/*     */   
/*     */   private E<E> a(N paramN1, N paramN2) {
/* 189 */     return new E<E>(this, paramN1, paramN2)
/*     */       {
/*     */         public boolean b(E param1E) {
/* 192 */           return this.a.b(param1E).A(this.ad).equals(this.ae);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public Optional<E> a(N paramN1, N paramN2) {
/* 199 */     return Optional.ofNullable(l(paramN1, paramN2));
/*     */   }
/*     */ 
/*     */   
/*     */   public Optional<E> a(n<N> paramn) {
/* 204 */     a(paramn);
/* 205 */     return a(paramn.D(), paramn.E());
/*     */   }
/*     */ 
/*     */   
/*     */   public E l(N paramN1, N paramN2) {
/* 210 */     Set<E> set = a(paramN1, paramN2);
/* 211 */     switch (set.size()) {
/*     */       case 0:
/* 213 */         return null;
/*     */       case 1:
/* 215 */         return set.iterator().next();
/*     */     } 
/* 217 */     throw new IllegalArgumentException(String.format("Cannot call edgeConnecting() when parallel edges exist between %s and %s. Consider calling edgesConnecting() instead.", new Object[] { paramN1, paramN2 }));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public E a(n<N> paramn) {
/* 223 */     a(paramn);
/* 224 */     return l(paramn.D(), paramn.E());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean f(N paramN1, N paramN2) {
/* 229 */     D.checkNotNull(paramN1);
/* 230 */     D.checkNotNull(paramN2);
/* 231 */     return (A().contains(paramN1) && f(paramN1).contains(paramN2));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(n<N> paramn) {
/* 236 */     D.checkNotNull(paramn);
/* 237 */     if (!b(paramn)) {
/* 238 */       return false;
/*     */     }
/* 240 */     return f(paramn.D(), paramn.E());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void a(n<?> paramn) {
/* 248 */     D.checkNotNull(paramn);
/* 249 */     D.a(b(paramn), "Mismatch: unordered endpoints cannot be used with directed graphs");
/*     */   }
/*     */   
/*     */   protected final boolean b(n<?> paramn) {
/* 253 */     return (paramn.cZ() || !cX());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 258 */     if (paramObject == this) {
/* 259 */       return true;
/*     */     }
/* 261 */     if (!(paramObject instanceof H)) {
/* 262 */       return false;
/*     */     }
/* 264 */     H<?, ?> h = (H)paramObject;
/*     */     
/* 266 */     return (cX() == h.cX() && 
/* 267 */       A().equals(h.A()) && 
/* 268 */       a(this).equals(a(h)));
/*     */   }
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 273 */     return a(this).hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 280 */     boolean bool1 = cX();
/*     */     
/* 282 */     boolean bool2 = db();
/*     */     
/* 284 */     boolean bool3 = cY();
/*     */     
/* 286 */     String str1 = String.valueOf(A());
/*     */     
/* 288 */     String str2 = String.valueOf(a(this)); return (new StringBuilder(87 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("isDirected: ").append(bool1).append(", allowsParallelEdges: ").append(bool2).append(", allowsSelfLoops: ").append(bool3).append(", nodes: ").append(str1).append(", edges: ").append(str2).toString();
/*     */   }
/*     */   
/*     */   private static <N, E> Map<E, n<N>> a(H<N, E> paramH) {
/* 292 */     s<E, n<N>> s = new s<E, n<N>>(paramH)
/*     */       {
/*     */         public n<N> a(E param1E)
/*     */         {
/* 296 */           return this.a.b(param1E);
/*     */         }
/*     */       };
/* 299 */     return bW.a(paramH.v(), s);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\g\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */