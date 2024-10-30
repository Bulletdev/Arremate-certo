/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.b.a.a;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
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
/*     */ @b
/*     */ abstract class m<K, V>
/*     */   extends e<K, V>
/*     */   implements cF<K, V>
/*     */ {
/*     */   private static final long serialVersionUID = 7431625294878419160L;
/*     */   
/*     */   protected m(Map<K, Collection<V>> paramMap) {
/*  44 */     super(paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Set<V> f() {
/*  52 */     return Collections.emptySet();
/*     */   }
/*     */ 
/*     */   
/*     */   <E> Collection<E> a(Collection<E> paramCollection) {
/*  57 */     return Collections.unmodifiableSet((Set<? extends E>)paramCollection);
/*     */   }
/*     */ 
/*     */   
/*     */   Collection<V> a(K paramK, Collection<V> paramCollection) {
/*  62 */     return new e.l(this, paramK, (Set<V>)paramCollection);
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
/*     */   public Set<V> get(K paramK) {
/*  75 */     return (Set<V>)super.get(paramK);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<K, V>> g() {
/*  86 */     return (Set<Map.Entry<K, V>>)super.entries();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public Set<V> a(Object paramObject) {
/*  98 */     return (Set<V>)super.a(paramObject);
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
/*     */   @a
/*     */   public Set<V> a(K paramK, Iterable<? extends V> paramIterable) {
/* 112 */     return (Set<V>)super.a(paramK, paramIterable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<K, Collection<V>> asMap() {
/* 123 */     return super.asMap();
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
/*     */   @a
/*     */   public boolean put(K paramK, V paramV) {
/* 137 */     return super.put(paramK, paramV);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 148 */     return super.equals(paramObject);
/*     */   }
/*     */   
/*     */   abstract Set<V> createCollection();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */