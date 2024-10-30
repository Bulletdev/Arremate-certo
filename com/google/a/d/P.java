/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.b.a.a;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @b
/*     */ abstract class p<K, V>
/*     */   extends m<K, V>
/*     */   implements cS<K, V>
/*     */ {
/*     */   private static final long serialVersionUID = 430848587173315748L;
/*     */   
/*     */   protected p(Map<K, Collection<V>> paramMap) {
/*  44 */     super(paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   SortedSet<V> f() {
/*  52 */     return a(e());
/*     */   }
/*     */ 
/*     */   
/*     */   <E> SortedSet<E> a(Collection<E> paramCollection) {
/*  57 */     if (paramCollection instanceof NavigableSet) {
/*  58 */       return cG.unmodifiableNavigableSet((NavigableSet<E>)paramCollection);
/*     */     }
/*  60 */     return Collections.unmodifiableSortedSet((SortedSet<E>)paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Collection<V> a(K paramK, Collection<V> paramCollection) {
/*  66 */     if (paramCollection instanceof NavigableSet) {
/*  67 */       return new e.k(this, paramK, (NavigableSet<V>)paramCollection, null);
/*     */     }
/*  69 */     return new e.m(this, paramK, (SortedSet<V>)paramCollection, null);
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
/*     */   public SortedSet<V> a(K paramK) {
/*  87 */     return (SortedSet<V>)super.get(paramK);
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
/*     */   @a
/*     */   public SortedSet<V> b(Object paramObject) {
/* 100 */     return (SortedSet<V>)super.a(paramObject);
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
/*     */   @a
/*     */   public SortedSet<V> a(K paramK, Iterable<? extends V> paramIterable) {
/* 116 */     return (SortedSet<V>)super.a(paramK, paramIterable);
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
/*     */   public Map<K, Collection<V>> asMap() {
/* 133 */     return super.asMap();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<V> values() {
/* 144 */     return super.values();
/*     */   }
/*     */   
/*     */   abstract SortedSet<V> e();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */