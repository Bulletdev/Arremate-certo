/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.SortedMap;
/*     */ import org.apache.commons.collections4.Unmodifiable;
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
/*     */ public final class UnmodifiableSortedMap<K, V>
/*     */   extends AbstractSortedMapDecorator<K, V>
/*     */   implements Serializable, Unmodifiable
/*     */ {
/*     */   private static final long serialVersionUID = 5805344239827376360L;
/*     */   
/*     */   public static <K, V> SortedMap<K, V> unmodifiableSortedMap(SortedMap<K, ? extends V> paramSortedMap) {
/*  61 */     if (paramSortedMap instanceof Unmodifiable)
/*     */     {
/*  63 */       return (SortedMap)paramSortedMap;
/*     */     }
/*     */     
/*  66 */     return (SortedMap<K, V>)new UnmodifiableSortedMap<K, V>(paramSortedMap);
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
/*     */   private UnmodifiableSortedMap(SortedMap<K, ? extends V> paramSortedMap) {
/*  78 */     super((SortedMap)paramSortedMap);
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
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/*  90 */     paramObjectOutputStream.defaultWriteObject();
/*  91 */     paramObjectOutputStream.writeObject(this.map);
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
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 104 */     paramObjectInputStream.defaultReadObject();
/* 105 */     this.map = (Map<K, V>)paramObjectInputStream.readObject();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 111 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public V put(K paramK, V paramV) {
/* 116 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/* 121 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public V remove(Object paramObject) {
/* 126 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<K, V>> entrySet() {
/* 131 */     return UnmodifiableEntrySet.unmodifiableEntrySet(super.entrySet());
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<K> keySet() {
/* 136 */     return UnmodifiableSet.unmodifiableSet(super.keySet());
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<V> values() {
/* 141 */     return UnmodifiableCollection.unmodifiableCollection(super.values());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public K firstKey() {
/* 147 */     return decorated().firstKey();
/*     */   }
/*     */ 
/*     */   
/*     */   public K lastKey() {
/* 152 */     return decorated().lastKey();
/*     */   }
/*     */ 
/*     */   
/*     */   public Comparator<? super K> comparator() {
/* 157 */     return decorated().comparator();
/*     */   }
/*     */ 
/*     */   
/*     */   public SortedMap<K, V> subMap(K paramK1, K paramK2) {
/* 162 */     return (SortedMap<K, V>)new UnmodifiableSortedMap(decorated().subMap(paramK1, paramK2));
/*     */   }
/*     */ 
/*     */   
/*     */   public SortedMap<K, V> headMap(K paramK) {
/* 167 */     return (SortedMap<K, V>)new UnmodifiableSortedMap(decorated().headMap(paramK));
/*     */   }
/*     */ 
/*     */   
/*     */   public SortedMap<K, V> tailMap(K paramK) {
/* 172 */     return (SortedMap<K, V>)new UnmodifiableSortedMap(decorated().tailMap(paramK));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\UnmodifiableSortedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */