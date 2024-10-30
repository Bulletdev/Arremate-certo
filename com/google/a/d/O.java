/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.NavigableSet;
/*     */ import java.util.Set;
/*     */ import java.util.SortedSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b(cl = true)
/*     */ abstract class o<E>
/*     */   extends i<E>
/*     */   implements cP<E>
/*     */ {
/*     */   @aS
/*     */   final Comparator<? super E> comparator;
/*     */   private transient cP<E> a;
/*     */   
/*     */   o() {
/*  42 */     this(cj.e());
/*     */   }
/*     */   
/*     */   o(Comparator<? super E> paramComparator) {
/*  46 */     this.comparator = (Comparator<? super E>)D.checkNotNull(paramComparator);
/*     */   }
/*     */ 
/*     */   
/*     */   public NavigableSet<E> d() {
/*  51 */     return (NavigableSet<E>)super.d();
/*     */   }
/*     */ 
/*     */   
/*     */   NavigableSet<E> e() {
/*  56 */     return new cR.b<>(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public Comparator<? super E> comparator() {
/*  61 */     return this.comparator;
/*     */   }
/*     */ 
/*     */   
/*     */   public cc.a<E> b() {
/*  66 */     Iterator<cc.a<E>> iterator = c();
/*  67 */     return iterator.hasNext() ? iterator.next() : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public cc.a<E> c() {
/*  72 */     Iterator<cc.a<E>> iterator = f();
/*  73 */     return iterator.hasNext() ? iterator.next() : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public cc.a<E> d() {
/*  78 */     Iterator<cc.a<E>> iterator = c();
/*  79 */     if (iterator.hasNext()) {
/*  80 */       cc.a<?> a = iterator.next();
/*  81 */       a = cd.a(a.getElement(), a.getCount());
/*  82 */       iterator.remove();
/*  83 */       return (cc.a)a;
/*     */     } 
/*  85 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public cc.a<E> e() {
/*  90 */     Iterator<cc.a<E>> iterator = f();
/*  91 */     if (iterator.hasNext()) {
/*  92 */       cc.a<?> a = iterator.next();
/*  93 */       a = cd.a(a.getElement(), a.getCount());
/*  94 */       iterator.remove();
/*  95 */       return (cc.a)a;
/*     */     } 
/*  97 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public cP<E> a(E paramE1, x paramx1, E paramE2, x paramx2) {
/* 107 */     D.checkNotNull(paramx1);
/* 108 */     D.checkNotNull(paramx2);
/* 109 */     return a(paramE1, paramx1).b(paramE2, paramx2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Iterator<E> descendingIterator() {
/* 115 */     return cd.a(a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public cP<E> a() {
/* 122 */     cP<E> cP1 = this.a;
/* 123 */     return (cP1 == null) ? (this.a = b()) : cP1;
/*     */   }
/*     */   
/*     */   class a
/*     */     extends X<E> {
/*     */     a(o this$0) {}
/*     */     
/*     */     cP<E> c() {
/* 131 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     Iterator<cc.a<E>> c() {
/* 136 */       return this.a.f();
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<E> iterator() {
/* 141 */       return this.a.descendingIterator();
/*     */     } }
/*     */   cP<E> b() {
/* 144 */     return new a(this);
/*     */   }
/*     */   
/*     */   abstract Iterator<cc.a<E>> f();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */