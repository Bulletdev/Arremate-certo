/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.IterableMap;
/*     */ import org.apache.commons.collections4.MapIterator;
/*     */ import org.apache.commons.collections4.Unmodifiable;
/*     */ import org.apache.commons.collections4.collection.UnmodifiableCollection;
/*     */ import org.apache.commons.collections4.iterators.EntrySetMapIterator;
/*     */ import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
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
/*     */ public final class UnmodifiableMap<K, V>
/*     */   extends AbstractMapDecorator<K, V>
/*     */   implements Serializable, Unmodifiable
/*     */ {
/*     */   private static final long serialVersionUID = 2737023427269031941L;
/*     */   
/*     */   public static <K, V> Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> paramMap) {
/*  63 */     if (paramMap instanceof Unmodifiable)
/*     */     {
/*  65 */       return (Map)paramMap;
/*     */     }
/*     */     
/*  68 */     return (Map<K, V>)new UnmodifiableMap<K, V>(paramMap);
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
/*     */   private UnmodifiableMap(Map<? extends K, ? extends V> paramMap) {
/*  80 */     super((Map)paramMap);
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
/*  92 */     paramObjectOutputStream.defaultWriteObject();
/*  93 */     paramObjectOutputStream.writeObject(this.map);
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
/* 106 */     paramObjectInputStream.defaultReadObject();
/* 107 */     this.map = (Map<K, V>)paramObjectInputStream.readObject();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 113 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public V put(K paramK, V paramV) {
/* 118 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/* 123 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public V remove(Object paramObject) {
/* 128 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public MapIterator<K, V> mapIterator() {
/* 133 */     if (this.map instanceof IterableMap) {
/* 134 */       MapIterator mapIterator = ((IterableMap)this.map).mapIterator();
/* 135 */       return UnmodifiableMapIterator.unmodifiableMapIterator(mapIterator);
/*     */     } 
/* 137 */     EntrySetMapIterator entrySetMapIterator = new EntrySetMapIterator(this.map);
/* 138 */     return UnmodifiableMapIterator.unmodifiableMapIterator((MapIterator)entrySetMapIterator);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<K, V>> entrySet() {
/* 143 */     Set<Map.Entry<K, V>> set = super.entrySet();
/* 144 */     return UnmodifiableEntrySet.unmodifiableEntrySet(set);
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<K> keySet() {
/* 149 */     Set<K> set = super.keySet();
/* 150 */     return UnmodifiableSet.unmodifiableSet(set);
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<V> values() {
/* 155 */     Collection<V> collection = super.values();
/* 156 */     return UnmodifiableCollection.unmodifiableCollection(collection);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\UnmodifiableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */