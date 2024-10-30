/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.MapIterator;
/*     */ import org.apache.commons.collections4.OrderedMap;
/*     */ import org.apache.commons.collections4.OrderedMapIterator;
/*     */ import org.apache.commons.collections4.Unmodifiable;
/*     */ import org.apache.commons.collections4.collection.UnmodifiableCollection;
/*     */ import org.apache.commons.collections4.iterators.UnmodifiableOrderedMapIterator;
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
/*     */ public final class UnmodifiableOrderedMap<K, V>
/*     */   extends AbstractOrderedMapDecorator<K, V>
/*     */   implements Serializable, Unmodifiable
/*     */ {
/*     */   private static final long serialVersionUID = 8136428161720526266L;
/*     */   
/*     */   public static <K, V> OrderedMap<K, V> unmodifiableOrderedMap(OrderedMap<? extends K, ? extends V> paramOrderedMap) {
/*  61 */     if (paramOrderedMap instanceof Unmodifiable)
/*     */     {
/*  63 */       return (OrderedMap)paramOrderedMap;
/*     */     }
/*     */     
/*  66 */     return new UnmodifiableOrderedMap<K, V>(paramOrderedMap);
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
/*     */   private UnmodifiableOrderedMap(OrderedMap<? extends K, ? extends V> paramOrderedMap) {
/*  78 */     super((OrderedMap)paramOrderedMap);
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
/*     */   public OrderedMapIterator<K, V> mapIterator() {
/* 111 */     OrderedMapIterator orderedMapIterator = decorated().mapIterator();
/* 112 */     return UnmodifiableOrderedMapIterator.unmodifiableOrderedMapIterator(orderedMapIterator);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 117 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public V put(K paramK, V paramV) {
/* 122 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/* 127 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public V remove(Object paramObject) {
/* 132 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<K, V>> entrySet() {
/* 137 */     Set<Map.Entry<K, V>> set = super.entrySet();
/* 138 */     return UnmodifiableEntrySet.unmodifiableEntrySet(set);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<K> keySet() {
/* 143 */     Set<K> set = super.keySet();
/* 144 */     return UnmodifiableSet.unmodifiableSet(set);
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<V> values() {
/* 149 */     Collection<V> collection = super.values();
/* 150 */     return UnmodifiableCollection.unmodifiableCollection(collection);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\UnmodifiableOrderedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */