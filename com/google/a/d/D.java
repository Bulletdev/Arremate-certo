/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.b.a.a;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
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
/*     */ @b
/*     */ abstract class d<K, V>
/*     */   extends e<K, V>
/*     */   implements bR<K, V>
/*     */ {
/*     */   private static final long serialVersionUID = 6588350623831699109L;
/*     */   
/*     */   protected d(Map<K, Collection<V>> paramMap) {
/*  44 */     super(paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   List<V> O() {
/*  52 */     return Collections.emptyList();
/*     */   }
/*     */ 
/*     */   
/*     */   <E> Collection<E> a(Collection<E> paramCollection) {
/*  57 */     return Collections.unmodifiableList((List<? extends E>)paramCollection);
/*     */   }
/*     */ 
/*     */   
/*     */   Collection<V> a(K paramK, Collection<V> paramCollection) {
/*  62 */     return a(paramK, (List<V>)paramCollection, (e<K, V>.i)null);
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
/*     */   public List<V> get(K paramK) {
/*  76 */     return (List<V>)super.get(paramK);
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
/*     */   public List<V> a(Object paramObject) {
/*  89 */     return (List<V>)super.a(paramObject);
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
/*     */   public List<V> a(K paramK, Iterable<? extends V> paramIterable) {
/* 102 */     return (List<V>)super.a(paramK, paramIterable);
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
/*     */   public boolean put(K paramK, V paramV) {
/* 115 */     return super.put(paramK, paramV);
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
/* 126 */     return super.asMap();
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
/* 137 */     return super.equals(paramObject);
/*     */   }
/*     */   
/*     */   abstract List<V> createCollection();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */