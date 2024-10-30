/*     */ package org.apache.commons.collections4.bidimap;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.SortedMap;
/*     */ import org.apache.commons.collections4.BidiMap;
/*     */ import org.apache.commons.collections4.MapIterator;
/*     */ import org.apache.commons.collections4.OrderedBidiMap;
/*     */ import org.apache.commons.collections4.OrderedMapIterator;
/*     */ import org.apache.commons.collections4.SortedBidiMap;
/*     */ import org.apache.commons.collections4.Unmodifiable;
/*     */ import org.apache.commons.collections4.iterators.UnmodifiableOrderedMapIterator;
/*     */ import org.apache.commons.collections4.map.UnmodifiableEntrySet;
/*     */ import org.apache.commons.collections4.map.UnmodifiableSortedMap;
/*     */ import org.apache.commons.collections4.set.UnmodifiableSet;
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
/*     */ public final class UnmodifiableSortedBidiMap<K, V>
/*     */   extends AbstractSortedBidiMapDecorator<K, V>
/*     */   implements Unmodifiable
/*     */ {
/*     */   private UnmodifiableSortedBidiMap<V, K> inverse;
/*     */   
/*     */   public static <K, V> SortedBidiMap<K, V> unmodifiableSortedBidiMap(SortedBidiMap<K, ? extends V> paramSortedBidiMap) {
/*  58 */     if (paramSortedBidiMap instanceof Unmodifiable)
/*     */     {
/*  60 */       return (SortedBidiMap)paramSortedBidiMap;
/*     */     }
/*     */     
/*  63 */     return new UnmodifiableSortedBidiMap<K, V>(paramSortedBidiMap);
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
/*     */   private UnmodifiableSortedBidiMap(SortedBidiMap<K, ? extends V> paramSortedBidiMap) {
/*  75 */     super((SortedBidiMap)paramSortedBidiMap);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/*  81 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public V put(K paramK, V paramV) {
/*  86 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/*  91 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public V remove(Object paramObject) {
/*  96 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<K, V>> entrySet() {
/* 101 */     Set set = super.entrySet();
/* 102 */     return UnmodifiableEntrySet.unmodifiableEntrySet(set);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<K> keySet() {
/* 107 */     Set set = super.keySet();
/* 108 */     return UnmodifiableSet.unmodifiableSet(set);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<V> values() {
/* 113 */     Set<V> set = super.values();
/* 114 */     return UnmodifiableSet.unmodifiableSet(set);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public K removeValue(Object paramObject) {
/* 120 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public OrderedMapIterator<K, V> mapIterator() {
/* 126 */     OrderedMapIterator orderedMapIterator = decorated().mapIterator();
/* 127 */     return UnmodifiableOrderedMapIterator.unmodifiableOrderedMapIterator(orderedMapIterator);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SortedBidiMap<V, K> inverseBidiMap() {
/* 133 */     if (this.inverse == null) {
/* 134 */       this.inverse = new UnmodifiableSortedBidiMap(decorated().inverseBidiMap());
/* 135 */       this.inverse.inverse = this;
/*     */     } 
/* 137 */     return this.inverse;
/*     */   }
/*     */ 
/*     */   
/*     */   public SortedMap<K, V> subMap(K paramK1, K paramK2) {
/* 142 */     SortedMap sortedMap = decorated().subMap(paramK1, paramK2);
/* 143 */     return UnmodifiableSortedMap.unmodifiableSortedMap(sortedMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public SortedMap<K, V> headMap(K paramK) {
/* 148 */     SortedMap sortedMap = decorated().headMap(paramK);
/* 149 */     return UnmodifiableSortedMap.unmodifiableSortedMap(sortedMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public SortedMap<K, V> tailMap(K paramK) {
/* 154 */     SortedMap sortedMap = decorated().tailMap(paramK);
/* 155 */     return UnmodifiableSortedMap.unmodifiableSortedMap(sortedMap);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\bidimap\UnmodifiableSortedBidiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */