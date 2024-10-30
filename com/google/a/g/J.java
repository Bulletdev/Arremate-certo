/*     */ package com.google.a.g;
/*     */ 
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.d.aX;
/*     */ import com.google.a.d.bj;
/*     */ import com.google.a.d.cc;
/*     */ import com.google.b.a.a.b;
/*     */ import java.lang.ref.Reference;
/*     */ import java.lang.ref.SoftReference;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ final class j<N, E>
/*     */   extends b<N, E>
/*     */ {
/*     */   @b
/*     */   private transient Reference<cc<N>> a;
/*     */   @b
/*     */   private transient Reference<cc<N>> b;
/*     */   
/*     */   private j(Map<E, N> paramMap1, Map<E, N> paramMap2, int paramInt) {
/*  46 */     super(paramMap1, paramMap2, paramInt);
/*     */   }
/*     */   
/*     */   static <N, E> j<N, E> a() {
/*  50 */     return new j<>(new HashMap<>(2, 1.0F), new HashMap<>(2, 1.0F), 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static <N, E> j<N, E> a(Map<E, N> paramMap1, Map<E, N> paramMap2, int paramInt) {
/*  58 */     return new j<>(
/*  59 */         (Map<E, N>)bj.a(paramMap1), (Map<E, N>)bj.a(paramMap2), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<N> B() {
/*  66 */     return Collections.unmodifiableSet(e().d());
/*     */   }
/*     */   private cc<N> e() {
/*     */     aX aX;
/*  70 */     cc cc = a((Reference)this.a);
/*  71 */     if (cc == null) {
/*  72 */       aX = aX.a(this.Z.values());
/*  73 */       this.a = new SoftReference(aX);
/*     */     } 
/*  75 */     return (cc<N>)aX;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<N> C() {
/*  82 */     return Collections.unmodifiableSet(f().d());
/*     */   }
/*     */   private cc<N> f() {
/*     */     aX aX;
/*  86 */     cc cc = a((Reference)this.b);
/*  87 */     if (cc == null) {
/*  88 */       aX = aX.a(this.aa.values());
/*  89 */       this.b = new SoftReference(aX);
/*     */     } 
/*  91 */     return (cc<N>)aX;
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<E> g(N paramN) {
/*  96 */     return new D<E>(this, this.aa, paramN, paramN)
/*     */       {
/*     */         public int size() {
/*  99 */           return j.a(this.a).b(this.aj);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public N a(E paramE, boolean paramBoolean) {
/* 106 */     N n = super.a(paramE, paramBoolean);
/* 107 */     cc cc = a((Reference)this.a);
/* 108 */     if (cc != null) {
/* 109 */       D.ab(cc.remove(n));
/*     */     }
/* 111 */     return n;
/*     */   }
/*     */ 
/*     */   
/*     */   public N B(E paramE) {
/* 116 */     N n = super.B(paramE);
/* 117 */     cc cc = a((Reference)this.b);
/* 118 */     if (cc != null) {
/* 119 */       D.ab(cc.remove(n));
/*     */     }
/* 121 */     return n;
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(E paramE, N paramN, boolean paramBoolean) {
/* 126 */     super.a(paramE, paramN, paramBoolean);
/* 127 */     cc cc = a((Reference)this.a);
/* 128 */     if (cc != null) {
/* 129 */       D.ab(cc.add(paramN));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void e(E paramE, N paramN) {
/* 135 */     super.e(paramE, paramN);
/* 136 */     cc cc = a((Reference)this.b);
/* 137 */     if (cc != null) {
/* 138 */       D.ab(cc.add(paramN));
/*     */     }
/*     */   }
/*     */   
/*     */   private static <T> T a(Reference<T> paramReference) {
/* 143 */     return (paramReference == null) ? null : paramReference.get();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\g\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */