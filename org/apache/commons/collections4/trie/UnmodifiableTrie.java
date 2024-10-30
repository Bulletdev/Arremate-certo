/*     */ package org.apache.commons.collections4.trie;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.SortedMap;
/*     */ import org.apache.commons.collections4.MapIterator;
/*     */ import org.apache.commons.collections4.OrderedMapIterator;
/*     */ import org.apache.commons.collections4.Trie;
/*     */ import org.apache.commons.collections4.Unmodifiable;
/*     */ import org.apache.commons.collections4.iterators.UnmodifiableOrderedMapIterator;
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
/*     */ public class UnmodifiableTrie<K, V>
/*     */   implements Serializable, Trie<K, V>, Unmodifiable
/*     */ {
/*     */   private static final long serialVersionUID = -7156426030315945159L;
/*     */   private final Trie<K, V> delegate;
/*     */   
/*     */   public static <K, V> Trie<K, V> unmodifiableTrie(Trie<K, ? extends V> paramTrie) {
/*  55 */     if (paramTrie instanceof Unmodifiable)
/*     */     {
/*  57 */       return (Trie)paramTrie;
/*     */     }
/*     */     
/*  60 */     return new UnmodifiableTrie<K, V>(paramTrie);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UnmodifiableTrie(Trie<K, ? extends V> paramTrie) {
/*  71 */     if (paramTrie == null) {
/*  72 */       throw new NullPointerException("Trie must not be null");
/*     */     }
/*     */     
/*  75 */     Trie<K, ? extends V> trie = paramTrie;
/*  76 */     this.delegate = (Trie)trie;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<K, V>> entrySet() {
/*  82 */     return Collections.unmodifiableSet(this.delegate.entrySet());
/*     */   }
/*     */   
/*     */   public Set<K> keySet() {
/*  86 */     return Collections.unmodifiableSet(this.delegate.keySet());
/*     */   }
/*     */   
/*     */   public Collection<V> values() {
/*  90 */     return Collections.unmodifiableCollection(this.delegate.values());
/*     */   }
/*     */   
/*     */   public void clear() {
/*  94 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/*  98 */     return this.delegate.containsKey(paramObject);
/*     */   }
/*     */   
/*     */   public boolean containsValue(Object paramObject) {
/* 102 */     return this.delegate.containsValue(paramObject);
/*     */   }
/*     */   
/*     */   public V get(Object paramObject) {
/* 106 */     return (V)this.delegate.get(paramObject);
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 110 */     return this.delegate.isEmpty();
/*     */   }
/*     */   
/*     */   public V put(K paramK, V paramV) {
/* 114 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/* 118 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public V remove(Object paramObject) {
/* 122 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public int size() {
/* 126 */     return this.delegate.size();
/*     */   }
/*     */   
/*     */   public K firstKey() {
/* 130 */     return (K)this.delegate.firstKey();
/*     */   }
/*     */   
/*     */   public SortedMap<K, V> headMap(K paramK) {
/* 134 */     return Collections.unmodifiableSortedMap(this.delegate.headMap(paramK));
/*     */   }
/*     */   
/*     */   public K lastKey() {
/* 138 */     return (K)this.delegate.lastKey();
/*     */   }
/*     */   
/*     */   public SortedMap<K, V> subMap(K paramK1, K paramK2) {
/* 142 */     return Collections.unmodifiableSortedMap(this.delegate.subMap(paramK1, paramK2));
/*     */   }
/*     */   
/*     */   public SortedMap<K, V> tailMap(K paramK) {
/* 146 */     return Collections.unmodifiableSortedMap(this.delegate.tailMap(paramK));
/*     */   }
/*     */   
/*     */   public SortedMap<K, V> prefixMap(K paramK) {
/* 150 */     return Collections.unmodifiableSortedMap(this.delegate.prefixMap(paramK));
/*     */   }
/*     */   
/*     */   public Comparator<? super K> comparator() {
/* 154 */     return this.delegate.comparator();
/*     */   }
/*     */ 
/*     */   
/*     */   public OrderedMapIterator<K, V> mapIterator() {
/* 159 */     OrderedMapIterator orderedMapIterator = this.delegate.mapIterator();
/* 160 */     return UnmodifiableOrderedMapIterator.unmodifiableOrderedMapIterator(orderedMapIterator);
/*     */   }
/*     */   
/*     */   public K nextKey(K paramK) {
/* 164 */     return (K)this.delegate.nextKey(paramK);
/*     */   }
/*     */   
/*     */   public K previousKey(K paramK) {
/* 168 */     return (K)this.delegate.previousKey(paramK);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 174 */     return this.delegate.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 179 */     return this.delegate.equals(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 184 */     return this.delegate.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\trie\UnmodifiableTrie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */