/*     */ package org.apache.commons.collections4.multimap;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.MapIterator;
/*     */ import org.apache.commons.collections4.MultiSet;
/*     */ import org.apache.commons.collections4.MultiValuedMap;
/*     */ import org.apache.commons.collections4.Unmodifiable;
/*     */ import org.apache.commons.collections4.collection.UnmodifiableCollection;
/*     */ import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
/*     */ import org.apache.commons.collections4.map.UnmodifiableMap;
/*     */ import org.apache.commons.collections4.multiset.UnmodifiableMultiSet;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class UnmodifiableMultiValuedMap<K, V>
/*     */   extends AbstractMultiValuedMapDecorator<K, V>
/*     */   implements Unmodifiable
/*     */ {
/*     */   private static final long serialVersionUID = 20150612L;
/*     */   
/*     */   public static <K, V> UnmodifiableMultiValuedMap<K, V> unmodifiableMultiValuedMap(MultiValuedMap<? extends K, ? extends V> paramMultiValuedMap) {
/*  65 */     if (paramMultiValuedMap instanceof Unmodifiable) {
/*  66 */       return (UnmodifiableMultiValuedMap)paramMultiValuedMap;
/*     */     }
/*  68 */     return new UnmodifiableMultiValuedMap<K, V>(paramMultiValuedMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private UnmodifiableMultiValuedMap(MultiValuedMap<? extends K, ? extends V> paramMultiValuedMap) {
/*  79 */     super((MultiValuedMap)paramMultiValuedMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<V> remove(Object paramObject) {
/*  84 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeMapping(Object paramObject1, Object paramObject2) {
/*  89 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  94 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<V> get(K paramK) {
/*  99 */     return UnmodifiableCollection.unmodifiableCollection(decorated().get(paramK));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean put(K paramK, V paramV) {
/* 104 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<K> keySet() {
/* 109 */     return UnmodifiableSet.unmodifiableSet(decorated().keySet());
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<Map.Entry<K, V>> entries() {
/* 114 */     return UnmodifiableCollection.unmodifiableCollection(decorated().entries());
/*     */   }
/*     */ 
/*     */   
/*     */   public MultiSet<K> keys() {
/* 119 */     return UnmodifiableMultiSet.unmodifiableMultiSet(decorated().keys());
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<V> values() {
/* 124 */     return UnmodifiableCollection.unmodifiableCollection(decorated().values());
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<K, Collection<V>> asMap() {
/* 129 */     return UnmodifiableMap.unmodifiableMap(decorated().asMap());
/*     */   }
/*     */ 
/*     */   
/*     */   public MapIterator<K, V> mapIterator() {
/* 134 */     return UnmodifiableMapIterator.unmodifiableMapIterator(decorated().mapIterator());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean putAll(K paramK, Iterable<? extends V> paramIterable) {
/* 139 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean putAll(Map<? extends K, ? extends V> paramMap) {
/* 144 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean putAll(MultiValuedMap<? extends K, ? extends V> paramMultiValuedMap) {
/* 149 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\multimap\UnmodifiableMultiValuedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */