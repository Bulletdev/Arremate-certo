/*     */ package com.google.a.g;
/*     */ 
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.d.bG;
/*     */ import com.google.a.d.bH;
/*     */ import com.google.a.d.cG;
/*     */ import com.google.a.d.dj;
/*     */ import com.google.a.k.e;
/*     */ import java.util.AbstractSet;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class b<N, E>
/*     */   implements J<N, E>
/*     */ {
/*     */   protected final Map<E, N> Z;
/*     */   protected final Map<E, N> aa;
/*     */   private int fo;
/*     */   
/*     */   protected b(Map<E, N> paramMap1, Map<E, N> paramMap2, int paramInt) {
/*  53 */     this.Z = (Map<E, N>)D.checkNotNull(paramMap1);
/*  54 */     this.aa = (Map<E, N>)D.checkNotNull(paramMap2);
/*  55 */     this.fo = w.F(paramInt);
/*  56 */     D.ab((paramInt <= paramMap1.size() && paramInt <= paramMap2.size()));
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<N> w() {
/*  61 */     return (Set<N>)cG.a(B(), C());
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<E> x() {
/*  66 */     return new AbstractSet<E>(this)
/*     */       {
/*     */ 
/*     */         
/*     */         public dj<E> b()
/*     */         {
/*  72 */           Iterable iterable = (Iterable)((b.a(this.a) == 0) ? bG.a(this.a.Z.keySet(), this.a.aa.keySet()) : cG.a(this.a.Z.keySet(), this.a.aa.keySet()));
/*  73 */           return bH.a(iterable.iterator());
/*     */         }
/*     */ 
/*     */         
/*     */         public int size() {
/*  78 */           return e.v(this.a.Z.size(), this.a.aa.size() - b.a(this.a));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean contains(Object param1Object) {
/*  83 */           return (this.a.Z.containsKey(param1Object) || this.a.aa.containsKey(param1Object));
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<E> y() {
/*  90 */     return Collections.unmodifiableSet(this.Z.keySet());
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<E> z() {
/*  95 */     return Collections.unmodifiableSet(this.aa.keySet());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public N A(E paramE) {
/* 102 */     return (N)D.checkNotNull(this.aa.get(paramE));
/*     */   }
/*     */ 
/*     */   
/*     */   public N a(E paramE, boolean paramBoolean) {
/* 107 */     if (paramBoolean) {
/* 108 */       w.F(--this.fo);
/*     */     }
/* 110 */     N n = this.Z.remove(paramE);
/* 111 */     return (N)D.checkNotNull(n);
/*     */   }
/*     */ 
/*     */   
/*     */   public N B(E paramE) {
/* 116 */     N n = this.aa.remove(paramE);
/* 117 */     return (N)D.checkNotNull(n);
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(E paramE, N paramN, boolean paramBoolean) {
/* 122 */     D.checkNotNull(paramE);
/* 123 */     D.checkNotNull(paramN);
/*     */     
/* 125 */     if (paramBoolean) {
/* 126 */       w.G(++this.fo);
/*     */     }
/* 128 */     N n = this.Z.put(paramE, paramN);
/* 129 */     D.ab((n == null));
/*     */   }
/*     */ 
/*     */   
/*     */   public void e(E paramE, N paramN) {
/* 134 */     D.checkNotNull(paramE);
/* 135 */     D.checkNotNull(paramN);
/*     */     
/* 137 */     N n = this.aa.put(paramE, paramN);
/* 138 */     D.ab((n == null));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\g\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */