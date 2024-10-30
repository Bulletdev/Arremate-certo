/*     */ package com.google.a.g;
/*     */ 
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.s;
/*     */ import com.google.a.d.bH;
/*     */ import com.google.a.d.bt;
/*     */ import com.google.a.d.cG;
/*     */ import com.google.a.d.dj;
/*     */ import com.google.a.k.e;
/*     */ import com.google.a.m.k;
/*     */ import java.util.AbstractSet;
/*     */ import java.util.Iterator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class a<N>
/*     */   implements h<N>
/*     */ {
/*     */   protected long Z() {
/*     */     // Byte code:
/*     */     //   0: lconst_0
/*     */     //   1: lstore_1
/*     */     //   2: aload_0
/*     */     //   3: invokevirtual A : ()Ljava/util/Set;
/*     */     //   6: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   11: astore_3
/*     */     //   12: aload_3
/*     */     //   13: invokeinterface hasNext : ()Z
/*     */     //   18: ifeq -> 42
/*     */     //   21: aload_3
/*     */     //   22: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   27: astore #4
/*     */     //   29: lload_1
/*     */     //   30: aload_0
/*     */     //   31: aload #4
/*     */     //   33: invokevirtual m : (Ljava/lang/Object;)I
/*     */     //   36: i2l
/*     */     //   37: ladd
/*     */     //   38: lstore_1
/*     */     //   39: goto -> 12
/*     */     //   42: lload_1
/*     */     //   43: lconst_1
/*     */     //   44: land
/*     */     //   45: lconst_0
/*     */     //   46: lcmp
/*     */     //   47: ifne -> 54
/*     */     //   50: iconst_1
/*     */     //   51: goto -> 55
/*     */     //   54: iconst_0
/*     */     //   55: invokestatic ab : (Z)V
/*     */     //   58: lload_1
/*     */     //   59: iconst_1
/*     */     //   60: lushr
/*     */     //   61: lreturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #52	-> 0
/*     */     //   #53	-> 2
/*     */     //   #54	-> 29
/*     */     //   #55	-> 39
/*     */     //   #57	-> 42
/*     */     //   #58	-> 58
/*     */   }
/*     */   
/*     */   public Set<n<N>> v() {
/*  67 */     return new AbstractSet<n<N>>(this)
/*     */       {
/*     */         public dj<n<N>> b() {
/*  70 */           return (dj)o.a(this.a);
/*     */         }
/*     */ 
/*     */         
/*     */         public int size() {
/*  75 */           return k.e(this.a.Z());
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean remove(Object param1Object) {
/*  80 */           throw new UnsupportedOperationException();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean contains(Object param1Object) {
/*  89 */           if (!(param1Object instanceof n)) {
/*  90 */             return false;
/*     */           }
/*  92 */           n<?> n = (n)param1Object;
/*  93 */           return (this.a.b(n) && this.a
/*  94 */             .A().contains(n.D()) && this.a
/*  95 */             .f(n.D()).contains(n.E()));
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public m<N> a() {
/* 102 */     return m.c();
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<n<N>> b(N paramN) {
/* 107 */     D.checkNotNull(paramN);
/* 108 */     D.a(A().contains(paramN), "Node %s is not an element of this graph.", paramN);
/* 109 */     return new A<N>(this, this, paramN)
/*     */       {
/*     */         public dj<n<N>> b() {
/* 112 */           if (this.a.cX()) {
/* 113 */             return bH.a(
/* 114 */                 bH.a(
/* 115 */                   bH.a(this.a
/* 116 */                     .e(this.ah).iterator(), new s<N, n<N>>(this)
/*     */                     {
/*     */                       public n<N> a(N param2N)
/*     */                       {
/* 120 */                         return n.a(param2N, this.a.ah);
/*     */                       }
/* 123 */                     }), bH.a(
/*     */                     
/* 125 */                     (Iterator)cG.c(this.a.f(this.ah), (Set)bt.b(this.ah)).b(), new s<N, n<N>>(this)
/*     */                     {
/*     */                       public n<N> a(N param2N)
/*     */                       {
/* 129 */                         return n.a(this.a.ah, param2N);
/*     */                       }
/*     */                     })));
/*     */           }
/* 133 */           return bH.a(
/* 134 */               bH.a(this.a
/* 135 */                 .d(this.ah).iterator(), new s<N, n<N>>(this)
/*     */                 {
/*     */                   public n<N> a(N param2N)
/*     */                   {
/* 139 */                     return n.b(this.a.ah, param2N);
/*     */                   }
/*     */                 }));
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int m(N paramN) {
/* 149 */     if (cX()) {
/* 150 */       return e.v(e(paramN).size(), f(paramN).size());
/*     */     }
/* 152 */     Set<N> set = d(paramN);
/* 153 */     boolean bool = (cY() && set.contains(paramN)) ? true : false;
/* 154 */     return e.v(set.size(), bool);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int n(N paramN) {
/* 160 */     return cX() ? e(paramN).size() : m(paramN);
/*     */   }
/*     */ 
/*     */   
/*     */   public int o(N paramN) {
/* 165 */     return cX() ? f(paramN).size() : m(paramN);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean f(N paramN1, N paramN2) {
/* 170 */     D.checkNotNull(paramN1);
/* 171 */     D.checkNotNull(paramN2);
/* 172 */     return (A().contains(paramN1) && f(paramN1).contains(paramN2));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(n<N> paramn) {
/* 177 */     D.checkNotNull(paramn);
/* 178 */     if (!b(paramn)) {
/* 179 */       return false;
/*     */     }
/* 181 */     N n1 = paramn.D();
/* 182 */     N n2 = paramn.E();
/* 183 */     return (A().contains(n1) && f(n1).contains(n2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void a(n<?> paramn) {
/* 191 */     D.checkNotNull(paramn);
/* 192 */     D.a(b(paramn), "Mismatch: unordered endpoints cannot be used with directed graphs");
/*     */   }
/*     */   
/*     */   protected final boolean b(n<?> paramn) {
/* 196 */     return (paramn.cZ() || !cX());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\g\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */