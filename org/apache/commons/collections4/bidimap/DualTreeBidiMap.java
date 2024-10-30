/*     */ package org.apache.commons.collections4.bidimap;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Map;
/*     */ import java.util.SortedMap;
/*     */ import java.util.TreeMap;
/*     */ import org.apache.commons.collections4.BidiMap;
/*     */ import org.apache.commons.collections4.MapIterator;
/*     */ import org.apache.commons.collections4.OrderedBidiMap;
/*     */ import org.apache.commons.collections4.OrderedMap;
/*     */ import org.apache.commons.collections4.OrderedMapIterator;
/*     */ import org.apache.commons.collections4.ResettableIterator;
/*     */ import org.apache.commons.collections4.SortedBidiMap;
/*     */ import org.apache.commons.collections4.map.AbstractSortedMapDecorator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DualTreeBidiMap<K, V>
/*     */   extends AbstractDualBidiMap<K, V>
/*     */   implements Serializable, SortedBidiMap<K, V>
/*     */ {
/*     */   private static final long serialVersionUID = 721969328361809L;
/*     */   private final Comparator<? super K> comparator;
/*     */   private final Comparator<? super V> valueComparator;
/*     */   
/*     */   public DualTreeBidiMap() {
/*  71 */     super(new TreeMap<K, V>(), new TreeMap<V, K>());
/*  72 */     this.comparator = null;
/*  73 */     this.valueComparator = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DualTreeBidiMap(Map<? extends K, ? extends V> paramMap) {
/*  83 */     super(new TreeMap<K, V>(), new TreeMap<V, K>());
/*  84 */     putAll(paramMap);
/*  85 */     this.comparator = null;
/*  86 */     this.valueComparator = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DualTreeBidiMap(Comparator<? super K> paramComparator, Comparator<? super V> paramComparator1) {
/*  96 */     super(new TreeMap<K, V>(paramComparator), new TreeMap<V, K>(paramComparator1));
/*  97 */     this.comparator = paramComparator;
/*  98 */     this.valueComparator = paramComparator1;
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
/*     */   protected DualTreeBidiMap(Map<K, V> paramMap, Map<V, K> paramMap1, BidiMap<V, K> paramBidiMap) {
/* 110 */     super(paramMap, paramMap1, paramBidiMap);
/* 111 */     this.comparator = ((SortedMap)paramMap).comparator();
/* 112 */     this.valueComparator = ((SortedMap)paramMap1).comparator();
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
/*     */   
/*     */   protected DualTreeBidiMap<V, K> createBidiMap(Map<V, K> paramMap, Map<K, V> paramMap1, BidiMap<K, V> paramBidiMap) {
/* 126 */     return new DualTreeBidiMap(paramMap, paramMap1, paramBidiMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Comparator<? super K> comparator() {
/* 133 */     return ((SortedMap)this.normalMap).comparator();
/*     */   }
/*     */ 
/*     */   
/*     */   public Comparator<? super V> valueComparator() {
/* 138 */     return ((SortedMap)this.reverseMap).comparator();
/*     */   }
/*     */ 
/*     */   
/*     */   public K firstKey() {
/* 143 */     return (K)((SortedMap)this.normalMap).firstKey();
/*     */   }
/*     */ 
/*     */   
/*     */   public K lastKey() {
/* 148 */     return (K)((SortedMap)this.normalMap).lastKey();
/*     */   }
/*     */ 
/*     */   
/*     */   public K nextKey(K paramK) {
/* 153 */     if (isEmpty()) {
/* 154 */       return null;
/*     */     }
/* 156 */     if (this.normalMap instanceof OrderedMap) {
/* 157 */       return (K)((OrderedMap)this.normalMap).nextKey(paramK);
/*     */     }
/* 159 */     SortedMap sortedMap = (SortedMap)this.normalMap;
/* 160 */     Iterator<K> iterator = sortedMap.tailMap(paramK).keySet().iterator();
/* 161 */     iterator.next();
/* 162 */     if (iterator.hasNext()) {
/* 163 */       return iterator.next();
/*     */     }
/* 165 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public K previousKey(K paramK) {
/* 170 */     if (isEmpty()) {
/* 171 */       return null;
/*     */     }
/* 173 */     if (this.normalMap instanceof OrderedMap) {
/* 174 */       return (K)((OrderedMap)this.normalMap).previousKey(paramK);
/*     */     }
/* 176 */     SortedMap sortedMap1 = (SortedMap)this.normalMap;
/* 177 */     SortedMap sortedMap2 = sortedMap1.headMap(paramK);
/* 178 */     if (sortedMap2.isEmpty()) {
/* 179 */       return null;
/*     */     }
/* 181 */     return (K)sortedMap2.lastKey();
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
/*     */   
/*     */   public OrderedMapIterator<K, V> mapIterator() {
/* 195 */     return new BidiOrderedMapIterator<K, V>(this);
/*     */   }
/*     */   
/*     */   public SortedBidiMap<V, K> inverseSortedBidiMap() {
/* 199 */     return inverseBidiMap();
/*     */   }
/*     */   
/*     */   public OrderedBidiMap<V, K> inverseOrderedBidiMap() {
/* 203 */     return (OrderedBidiMap<V, K>)inverseBidiMap();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SortedMap<K, V> headMap(K paramK) {
/* 210 */     SortedMap<?, ?> sortedMap = ((SortedMap)this.normalMap).headMap(paramK);
/* 211 */     return (SortedMap)new ViewMap<Object, Object>(this, sortedMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public SortedMap<K, V> tailMap(K paramK) {
/* 216 */     SortedMap<?, ?> sortedMap = ((SortedMap)this.normalMap).tailMap(paramK);
/* 217 */     return (SortedMap)new ViewMap<Object, Object>(this, sortedMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public SortedMap<K, V> subMap(K paramK1, K paramK2) {
/* 222 */     SortedMap<?, ?> sortedMap = ((SortedMap)this.normalMap).subMap(paramK1, paramK2);
/* 223 */     return (SortedMap)new ViewMap<Object, Object>(this, sortedMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public SortedBidiMap<V, K> inverseBidiMap() {
/* 228 */     return (SortedBidiMap<V, K>)super.inverseBidiMap();
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
/*     */   
/*     */   protected static class ViewMap<K, V>
/*     */     extends AbstractSortedMapDecorator<K, V>
/*     */   {
/*     */     protected ViewMap(DualTreeBidiMap<K, V> param1DualTreeBidiMap, SortedMap<K, V> param1SortedMap) {
/* 245 */       super((SortedMap)new DualTreeBidiMap<K, V>(param1SortedMap, param1DualTreeBidiMap.reverseMap, param1DualTreeBidiMap.inverseBidiMap));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean containsValue(Object param1Object) {
/* 251 */       return (decorated()).normalMap.containsValue(param1Object);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void clear() {
/* 257 */       for (Iterator iterator = keySet().iterator(); iterator.hasNext(); ) {
/* 258 */         iterator.next();
/* 259 */         iterator.remove();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public SortedMap<K, V> headMap(K param1K) {
/* 265 */       return (SortedMap<K, V>)new ViewMap(decorated(), super.headMap(param1K));
/*     */     }
/*     */ 
/*     */     
/*     */     public SortedMap<K, V> tailMap(K param1K) {
/* 270 */       return (SortedMap<K, V>)new ViewMap(decorated(), super.tailMap(param1K));
/*     */     }
/*     */ 
/*     */     
/*     */     public SortedMap<K, V> subMap(K param1K1, K param1K2) {
/* 275 */       return (SortedMap<K, V>)new ViewMap(decorated(), super.subMap(param1K1, param1K2));
/*     */     }
/*     */ 
/*     */     
/*     */     protected DualTreeBidiMap<K, V> decorated() {
/* 280 */       return (DualTreeBidiMap<K, V>)super.decorated();
/*     */     }
/*     */ 
/*     */     
/*     */     public K previousKey(K param1K) {
/* 285 */       return decorated().previousKey(param1K);
/*     */     }
/*     */ 
/*     */     
/*     */     public K nextKey(K param1K) {
/* 290 */       return decorated().nextKey(param1K);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class BidiOrderedMapIterator<K, V>
/*     */     implements OrderedMapIterator<K, V>, ResettableIterator<K>
/*     */   {
/*     */     private final AbstractDualBidiMap<K, V> parent;
/*     */ 
/*     */ 
/*     */     
/*     */     private ListIterator<Map.Entry<K, V>> iterator;
/*     */ 
/*     */     
/* 307 */     private Map.Entry<K, V> last = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected BidiOrderedMapIterator(AbstractDualBidiMap<K, V> param1AbstractDualBidiMap) {
/* 315 */       this.parent = param1AbstractDualBidiMap;
/* 316 */       this.iterator = (new ArrayList<Map.Entry<K, V>>(param1AbstractDualBidiMap.entrySet())).listIterator();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 321 */       return this.iterator.hasNext();
/*     */     }
/*     */ 
/*     */     
/*     */     public K next() {
/* 326 */       this.last = this.iterator.next();
/* 327 */       return this.last.getKey();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasPrevious() {
/* 332 */       return this.iterator.hasPrevious();
/*     */     }
/*     */ 
/*     */     
/*     */     public K previous() {
/* 337 */       this.last = this.iterator.previous();
/* 338 */       return this.last.getKey();
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 343 */       this.iterator.remove();
/* 344 */       this.parent.remove(this.last.getKey());
/* 345 */       this.last = null;
/*     */     }
/*     */ 
/*     */     
/*     */     public K getKey() {
/* 350 */       if (this.last == null) {
/* 351 */         throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
/*     */       }
/*     */       
/* 354 */       return this.last.getKey();
/*     */     }
/*     */ 
/*     */     
/*     */     public V getValue() {
/* 359 */       if (this.last == null) {
/* 360 */         throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
/*     */       }
/*     */       
/* 363 */       return this.last.getValue();
/*     */     }
/*     */ 
/*     */     
/*     */     public V setValue(V param1V) {
/* 368 */       if (this.last == null) {
/* 369 */         throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
/*     */       }
/*     */       
/* 372 */       if (this.parent.reverseMap.containsKey(param1V) && this.parent.reverseMap.get(param1V) != this.last.getKey())
/*     */       {
/* 374 */         throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
/*     */       }
/*     */       
/* 377 */       V v = this.parent.put(this.last.getKey(), param1V);
/*     */ 
/*     */ 
/*     */       
/* 381 */       this.last.setValue(param1V);
/* 382 */       return v;
/*     */     }
/*     */ 
/*     */     
/*     */     public void reset() {
/* 387 */       this.iterator = (new ArrayList<Map.Entry<K, V>>(this.parent.entrySet())).listIterator();
/* 388 */       this.last = null;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 393 */       if (this.last != null) {
/* 394 */         return "MapIterator[" + getKey() + "=" + getValue() + "]";
/*     */       }
/* 396 */       return "MapIterator[]";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 403 */     paramObjectOutputStream.defaultWriteObject();
/* 404 */     paramObjectOutputStream.writeObject(this.normalMap);
/*     */   }
/*     */   
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 408 */     paramObjectInputStream.defaultReadObject();
/* 409 */     this.normalMap = new TreeMap<K, V>(this.comparator);
/* 410 */     this.reverseMap = new TreeMap<V, K>(this.valueComparator);
/*     */     
/* 412 */     Map<? extends K, ? extends V> map = (Map)paramObjectInputStream.readObject();
/* 413 */     putAll(map);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\bidimap\DualTreeBidiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */