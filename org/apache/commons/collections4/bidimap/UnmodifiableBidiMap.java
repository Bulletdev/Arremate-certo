/*     */ package org.apache.commons.collections4.bidimap;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.BidiMap;
/*     */ import org.apache.commons.collections4.MapIterator;
/*     */ import org.apache.commons.collections4.Unmodifiable;
/*     */ import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
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
/*     */ 
/*     */ public final class UnmodifiableBidiMap<K, V>
/*     */   extends AbstractBidiMapDecorator<K, V>
/*     */   implements Unmodifiable
/*     */ {
/*     */   private UnmodifiableBidiMap<V, K> inverse;
/*     */   
/*     */   public static <K, V> BidiMap<K, V> unmodifiableBidiMap(BidiMap<? extends K, ? extends V> paramBidiMap) {
/*  56 */     if (paramBidiMap instanceof Unmodifiable)
/*     */     {
/*  58 */       return (BidiMap)paramBidiMap;
/*     */     }
/*     */     
/*  61 */     return new UnmodifiableBidiMap<K, V>(paramBidiMap);
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
/*     */   private UnmodifiableBidiMap(BidiMap<? extends K, ? extends V> paramBidiMap) {
/*  73 */     super((BidiMap)paramBidiMap);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/*  79 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public V put(K paramK, V paramV) {
/*  84 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/*  89 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public V remove(Object paramObject) {
/*  94 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<K, V>> entrySet() {
/*  99 */     Set set = super.entrySet();
/* 100 */     return UnmodifiableEntrySet.unmodifiableEntrySet(set);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<K> keySet() {
/* 105 */     Set set = super.keySet();
/* 106 */     return UnmodifiableSet.unmodifiableSet(set);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<V> values() {
/* 111 */     Set<V> set = super.values();
/* 112 */     return UnmodifiableSet.unmodifiableSet(set);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public K removeValue(Object paramObject) {
/* 118 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public MapIterator<K, V> mapIterator() {
/* 123 */     MapIterator mapIterator = decorated().mapIterator();
/* 124 */     return UnmodifiableMapIterator.unmodifiableMapIterator(mapIterator);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized BidiMap<V, K> inverseBidiMap() {
/* 129 */     if (this.inverse == null) {
/* 130 */       this.inverse = new UnmodifiableBidiMap(decorated().inverseBidiMap());
/* 131 */       this.inverse.inverse = this;
/*     */     } 
/* 133 */     return this.inverse;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\bidimap\UnmodifiableBidiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */