/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.SortedMap;
/*     */ import org.apache.commons.collections4.BoundedMap;
/*     */ import org.apache.commons.collections4.CollectionUtils;
/*     */ import org.apache.commons.collections4.collection.UnmodifiableCollection;
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
/*     */ public class FixedSizeSortedMap<K, V>
/*     */   extends AbstractSortedMapDecorator<K, V>
/*     */   implements Serializable, BoundedMap<K, V>
/*     */ {
/*     */   private static final long serialVersionUID = 3126019624511683653L;
/*     */   
/*     */   public static <K, V> FixedSizeSortedMap<K, V> fixedSizeSortedMap(SortedMap<K, V> paramSortedMap) {
/*  75 */     return new FixedSizeSortedMap<K, V>(paramSortedMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected FixedSizeSortedMap(SortedMap<K, V> paramSortedMap) {
/*  86 */     super(paramSortedMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SortedMap<K, V> getSortedMap() {
/*  95 */     return (SortedMap<K, V>)this.map;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 103 */     paramObjectOutputStream.defaultWriteObject();
/* 104 */     paramObjectOutputStream.writeObject(this.map);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 112 */     paramObjectInputStream.defaultReadObject();
/* 113 */     this.map = (Map<K, V>)paramObjectInputStream.readObject();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public V put(K paramK, V paramV) {
/* 119 */     if (!this.map.containsKey(paramK)) {
/* 120 */       throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
/*     */     }
/* 122 */     return this.map.put(paramK, paramV);
/*     */   }
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/* 127 */     if (CollectionUtils.isSubCollection(paramMap.keySet(), keySet())) {
/* 128 */       throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
/*     */     }
/* 130 */     this.map.putAll(paramMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 135 */     throw new UnsupportedOperationException("Map is fixed size");
/*     */   }
/*     */ 
/*     */   
/*     */   public V remove(Object paramObject) {
/* 140 */     throw new UnsupportedOperationException("Map is fixed size");
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<K, V>> entrySet() {
/* 145 */     return UnmodifiableSet.unmodifiableSet(this.map.entrySet());
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<K> keySet() {
/* 150 */     return UnmodifiableSet.unmodifiableSet(this.map.keySet());
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<V> values() {
/* 155 */     return UnmodifiableCollection.unmodifiableCollection(this.map.values());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SortedMap<K, V> subMap(K paramK1, K paramK2) {
/* 161 */     return (SortedMap<K, V>)new FixedSizeSortedMap(getSortedMap().subMap(paramK1, paramK2));
/*     */   }
/*     */ 
/*     */   
/*     */   public SortedMap<K, V> headMap(K paramK) {
/* 166 */     return (SortedMap<K, V>)new FixedSizeSortedMap(getSortedMap().headMap(paramK));
/*     */   }
/*     */ 
/*     */   
/*     */   public SortedMap<K, V> tailMap(K paramK) {
/* 171 */     return (SortedMap<K, V>)new FixedSizeSortedMap(getSortedMap().tailMap(paramK));
/*     */   }
/*     */   
/*     */   public boolean isFull() {
/* 175 */     return true;
/*     */   }
/*     */   
/*     */   public int maxSize() {
/* 179 */     return size();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\FixedSizeSortedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */