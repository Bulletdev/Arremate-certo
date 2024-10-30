/*     */ package org.apache.commons.collections4.bidimap;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.BidiMap;
/*     */ import org.apache.commons.collections4.MapIterator;
/*     */ import org.apache.commons.collections4.OrderedBidiMap;
/*     */ import org.apache.commons.collections4.OrderedMapIterator;
/*     */ import org.apache.commons.collections4.Unmodifiable;
/*     */ import org.apache.commons.collections4.iterators.UnmodifiableOrderedMapIterator;
/*     */ import org.apache.commons.collections4.map.UnmodifiableEntrySet;
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
/*     */ public final class UnmodifiableOrderedBidiMap<K, V>
/*     */   extends AbstractOrderedBidiMapDecorator<K, V>
/*     */   implements Unmodifiable
/*     */ {
/*     */   private UnmodifiableOrderedBidiMap<V, K> inverse;
/*     */   
/*     */   public static <K, V> OrderedBidiMap<K, V> unmodifiableOrderedBidiMap(OrderedBidiMap<? extends K, ? extends V> paramOrderedBidiMap) {
/*  57 */     if (paramOrderedBidiMap instanceof Unmodifiable)
/*     */     {
/*  59 */       return (OrderedBidiMap)paramOrderedBidiMap;
/*     */     }
/*     */     
/*  62 */     return new UnmodifiableOrderedBidiMap<K, V>(paramOrderedBidiMap);
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
/*     */   private UnmodifiableOrderedBidiMap(OrderedBidiMap<? extends K, ? extends V> paramOrderedBidiMap) {
/*  74 */     super((OrderedBidiMap)paramOrderedBidiMap);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/*  80 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public V put(K paramK, V paramV) {
/*  85 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/*  90 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public V remove(Object paramObject) {
/*  95 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<K, V>> entrySet() {
/* 100 */     Set set = super.entrySet();
/* 101 */     return UnmodifiableEntrySet.unmodifiableEntrySet(set);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<K> keySet() {
/* 106 */     Set set = super.keySet();
/* 107 */     return UnmodifiableSet.unmodifiableSet(set);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<V> values() {
/* 112 */     Set<V> set = super.values();
/* 113 */     return UnmodifiableSet.unmodifiableSet(set);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public K removeValue(Object paramObject) {
/* 119 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public OrderedBidiMap<V, K> inverseBidiMap() {
/* 124 */     return inverseOrderedBidiMap();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public OrderedMapIterator<K, V> mapIterator() {
/* 130 */     OrderedMapIterator orderedMapIterator = decorated().mapIterator();
/* 131 */     return UnmodifiableOrderedMapIterator.unmodifiableOrderedMapIterator(orderedMapIterator);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OrderedBidiMap<V, K> inverseOrderedBidiMap() {
/* 140 */     if (this.inverse == null) {
/* 141 */       this.inverse = new UnmodifiableOrderedBidiMap(decorated().inverseBidiMap());
/* 142 */       this.inverse.inverse = this;
/*     */     } 
/* 144 */     return this.inverse;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\bidimap\UnmodifiableOrderedBidiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */