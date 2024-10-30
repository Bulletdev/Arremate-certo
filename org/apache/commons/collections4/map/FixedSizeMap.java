/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.BoundedMap;
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
/*     */ public class FixedSizeMap<K, V>
/*     */   extends AbstractMapDecorator<K, V>
/*     */   implements Serializable, BoundedMap<K, V>
/*     */ {
/*     */   private static final long serialVersionUID = 7450927208116179316L;
/*     */   
/*     */   public static <K, V> FixedSizeMap<K, V> fixedSizeMap(Map<K, V> paramMap) {
/*  73 */     return new FixedSizeMap<K, V>(paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected FixedSizeMap(Map<K, V> paramMap) {
/*  84 */     super(paramMap);
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
/*  96 */     paramObjectOutputStream.defaultWriteObject();
/*  97 */     paramObjectOutputStream.writeObject(this.map);
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
/* 110 */     paramObjectInputStream.defaultReadObject();
/* 111 */     this.map = (Map<K, V>)paramObjectInputStream.readObject();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public V put(K paramK, V paramV) {
/* 117 */     if (!this.map.containsKey(paramK)) {
/* 118 */       throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
/*     */     }
/* 120 */     return this.map.put(paramK, paramV);
/*     */   }
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/* 125 */     for (K k : paramMap.keySet()) {
/* 126 */       if (!containsKey(k)) {
/* 127 */         throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
/*     */       }
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
/* 145 */     Set<Map.Entry<K, V>> set = this.map.entrySet();
/*     */     
/* 147 */     return UnmodifiableSet.unmodifiableSet(set);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<K> keySet() {
/* 152 */     Set<K> set = this.map.keySet();
/* 153 */     return UnmodifiableSet.unmodifiableSet(set);
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<V> values() {
/* 158 */     Collection<V> collection = this.map.values();
/* 159 */     return UnmodifiableCollection.unmodifiableCollection(collection);
/*     */   }
/*     */   
/*     */   public boolean isFull() {
/* 163 */     return true;
/*     */   }
/*     */   
/*     */   public int maxSize() {
/* 167 */     return size();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\FixedSizeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */