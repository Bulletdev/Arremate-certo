/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
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
/*     */ @b(cl = true)
/*     */ final class dl<E>
/*     */   extends cd.h<E>
/*     */   implements cP<E>
/*     */ {
/*     */   private transient dl<E> a;
/*     */   private static final long serialVersionUID = 0L;
/*     */   
/*     */   dl(cP<E> paramcP) {
/*  36 */     super(paramcP);
/*     */   }
/*     */ 
/*     */   
/*     */   protected cP<E> d() {
/*  41 */     return (cP<E>)super.d();
/*     */   }
/*     */ 
/*     */   
/*     */   public Comparator<? super E> comparator() {
/*  46 */     return d().comparator();
/*     */   }
/*     */ 
/*     */   
/*     */   NavigableSet<E> e() {
/*  51 */     return cG.unmodifiableNavigableSet(d().d());
/*     */   }
/*     */ 
/*     */   
/*     */   public NavigableSet<E> d() {
/*  56 */     return (NavigableSet<E>)super.d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public cP<E> a() {
/*  63 */     dl<E> dl1 = this.a;
/*  64 */     if (dl1 == null) {
/*  65 */       dl1 = new dl(d().a());
/*  66 */       dl1.a = this;
/*  67 */       return this.a = dl1;
/*     */     } 
/*  69 */     return dl1;
/*     */   }
/*     */ 
/*     */   
/*     */   public cc.a<E> b() {
/*  74 */     return d().b();
/*     */   }
/*     */ 
/*     */   
/*     */   public cc.a<E> c() {
/*  79 */     return d().c();
/*     */   }
/*     */ 
/*     */   
/*     */   public cc.a<E> d() {
/*  84 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public cc.a<E> e() {
/*  89 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public cP<E> b(E paramE, x paramx) {
/*  94 */     return cd.a(d().b(paramE, paramx));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public cP<E> a(E paramE1, x paramx1, E paramE2, x paramx2) {
/* 100 */     return cd.a(
/* 101 */         d().a(paramE1, paramx1, paramE2, paramx2));
/*     */   }
/*     */ 
/*     */   
/*     */   public cP<E> a(E paramE, x paramx) {
/* 106 */     return cd.a(d().a(paramE, paramx));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\dl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */