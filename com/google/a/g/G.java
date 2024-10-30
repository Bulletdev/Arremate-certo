/*     */ package com.google.a.g;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.b.s;
/*     */ import com.google.a.d.bW;
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
/*     */ @a
/*     */ public abstract class g<N, V>
/*     */   extends a<N>
/*     */   implements V<N, V>
/*     */ {
/*     */   public s<N> a() {
/*  45 */     return new c<N>(this)
/*     */       {
/*     */         public Set<N> A() {
/*  48 */           return this.a.A();
/*     */         }
/*     */ 
/*     */         
/*     */         public Set<n<N>> v() {
/*  53 */           return this.a.v();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean cX() {
/*  58 */           return this.a.cX();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean cY() {
/*  63 */           return this.a.cY();
/*     */         }
/*     */ 
/*     */         
/*     */         public m<N> b() {
/*  68 */           return this.a.b();
/*     */         }
/*     */ 
/*     */         
/*     */         public m<N> a() {
/*  73 */           return this.a.a();
/*     */         }
/*     */ 
/*     */         
/*     */         public Set<N> d(N param1N) {
/*  78 */           return this.a.d(param1N);
/*     */         }
/*     */ 
/*     */         
/*     */         public Set<N> e(N param1N) {
/*  83 */           return this.a.e(param1N);
/*     */         }
/*     */ 
/*     */         
/*     */         public Set<N> f(N param1N) {
/*  88 */           return this.a.f(param1N);
/*     */         }
/*     */ 
/*     */         
/*     */         public int m(N param1N) {
/*  93 */           return this.a.m(param1N);
/*     */         }
/*     */ 
/*     */         
/*     */         public int n(N param1N) {
/*  98 */           return this.a.n(param1N);
/*     */         }
/*     */ 
/*     */         
/*     */         public int o(N param1N) {
/* 103 */           return this.a.o(param1N);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public Optional<V> b(N paramN1, N paramN2) {
/* 110 */     return Optional.ofNullable(a(paramN1, paramN2, null));
/*     */   }
/*     */ 
/*     */   
/*     */   public Optional<V> b(n<N> paramn) {
/* 115 */     return Optional.ofNullable(a(paramn, null));
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 120 */     if (paramObject == this) {
/* 121 */       return true;
/*     */     }
/* 123 */     if (!(paramObject instanceof V)) {
/* 124 */       return false;
/*     */     }
/* 126 */     V<?, ?> v = (V)paramObject;
/*     */     
/* 128 */     return (cX() == v.cX() && 
/* 129 */       A().equals(v.A()) && 
/* 130 */       a(this).equals(a(v)));
/*     */   }
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 135 */     return a(this).hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 142 */     boolean bool1 = cX();
/*     */     
/* 144 */     boolean bool2 = cY();
/*     */     
/* 146 */     String str1 = String.valueOf(A());
/*     */     
/* 148 */     String str2 = String.valueOf(a(this)); return (new StringBuilder(59 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("isDirected: ").append(bool1).append(", allowsSelfLoops: ").append(bool2).append(", nodes: ").append(str1).append(", edges: ").append(str2).toString();
/*     */   }
/*     */   
/*     */   private static <N, V> Map<n<N>, V> a(V<N, V> paramV) {
/* 152 */     s<n<N>, V> s = new s<n<N>, V>(paramV)
/*     */       {
/*     */         public V b(n<N> param1n)
/*     */         {
/* 156 */           return (V)this.a.a(param1n.D(), param1n.E(), null);
/*     */         }
/*     */       };
/* 159 */     return bW.a(paramV.v(), s);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\g\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */