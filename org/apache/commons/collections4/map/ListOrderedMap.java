/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.AbstractList;
/*     */ import java.util.AbstractSet;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.MapIterator;
/*     */ import org.apache.commons.collections4.OrderedMap;
/*     */ import org.apache.commons.collections4.OrderedMapIterator;
/*     */ import org.apache.commons.collections4.ResettableIterator;
/*     */ import org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator;
/*     */ import org.apache.commons.collections4.keyvalue.AbstractMapEntry;
/*     */ import org.apache.commons.collections4.list.UnmodifiableList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ListOrderedMap<K, V>
/*     */   extends AbstractMapDecorator<K, V>
/*     */   implements Serializable, OrderedMap<K, V>
/*     */ {
/*     */   private static final long serialVersionUID = 2728177751851003750L;
/*  86 */   private final List<K> insertOrder = new ArrayList<K>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> ListOrderedMap<K, V> listOrderedMap(Map<K, V> paramMap) {
/* 101 */     return new ListOrderedMap<K, V>(paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ListOrderedMap() {
/* 112 */     this(new HashMap<K, V>());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ListOrderedMap(Map<K, V> paramMap) {
/* 122 */     super(paramMap);
/* 123 */     this.insertOrder.addAll(decorated().keySet());
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
/* 135 */     paramObjectOutputStream.defaultWriteObject();
/* 136 */     paramObjectOutputStream.writeObject(this.map);
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
/* 149 */     paramObjectInputStream.defaultReadObject();
/* 150 */     this.map = (Map<K, V>)paramObjectInputStream.readObject();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OrderedMapIterator<K, V> mapIterator() {
/* 157 */     return new ListOrderedMapIterator<K, V>(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public K firstKey() {
/* 167 */     if (size() == 0) {
/* 168 */       throw new NoSuchElementException("Map is empty");
/*     */     }
/* 170 */     return this.insertOrder.get(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public K lastKey() {
/* 180 */     if (size() == 0) {
/* 181 */       throw new NoSuchElementException("Map is empty");
/*     */     }
/* 183 */     return this.insertOrder.get(size() - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public K nextKey(Object paramObject) {
/* 194 */     int i = this.insertOrder.indexOf(paramObject);
/* 195 */     if (i >= 0 && i < size() - 1) {
/* 196 */       return this.insertOrder.get(i + 1);
/*     */     }
/* 198 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public K previousKey(Object paramObject) {
/* 209 */     int i = this.insertOrder.indexOf(paramObject);
/* 210 */     if (i > 0) {
/* 211 */       return this.insertOrder.get(i - 1);
/*     */     }
/* 213 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public V put(K paramK, V paramV) {
/* 219 */     if (decorated().containsKey(paramK))
/*     */     {
/* 221 */       return decorated().put(paramK, paramV);
/*     */     }
/*     */     
/* 224 */     V v = decorated().put(paramK, paramV);
/* 225 */     this.insertOrder.add(paramK);
/* 226 */     return v;
/*     */   }
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/* 231 */     for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet()) {
/* 232 */       put((K)entry.getKey(), (V)entry.getValue());
/*     */     }
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
/*     */   public void putAll(int paramInt, Map<? extends K, ? extends V> paramMap) {
/* 245 */     if (paramInt < 0 || paramInt > this.insertOrder.size()) {
/* 246 */       throw new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.insertOrder.size());
/*     */     }
/* 248 */     for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet()) {
/* 249 */       Object object = entry.getKey();
/* 250 */       boolean bool = containsKey(object);
/*     */ 
/*     */       
/* 253 */       put(paramInt, (K)entry.getKey(), (V)entry.getValue());
/* 254 */       if (!bool) {
/*     */         
/* 256 */         paramInt++;
/*     */         continue;
/*     */       } 
/* 259 */       paramInt = indexOf(entry.getKey()) + 1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public V remove(Object paramObject) {
/* 266 */     V v = null;
/* 267 */     if (decorated().containsKey(paramObject)) {
/* 268 */       v = decorated().remove(paramObject);
/* 269 */       this.insertOrder.remove(paramObject);
/*     */     } 
/* 271 */     return v;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 276 */     decorated().clear();
/* 277 */     this.insertOrder.clear();
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
/*     */   public Set<K> keySet() {
/* 291 */     return new KeySetView<K>(this);
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
/*     */   public List<K> keyList() {
/* 305 */     return UnmodifiableList.unmodifiableList(this.insertOrder);
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
/*     */ 
/*     */   
/*     */   public Collection<V> values() {
/* 321 */     return new ValuesView<V>(this);
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
/*     */   public List<V> valueList() {
/* 335 */     return new ValuesView<V>(this);
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
/*     */   public Set<Map.Entry<K, V>> entrySet() {
/* 347 */     return new EntrySetView<K, V>(this, this.insertOrder);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 358 */     if (isEmpty()) {
/* 359 */       return "{}";
/*     */     }
/* 361 */     StringBuilder stringBuilder = new StringBuilder();
/* 362 */     stringBuilder.append('{');
/* 363 */     boolean bool = true;
/* 364 */     for (Map.Entry<K, V> entry : entrySet()) {
/* 365 */       Object object1 = entry.getKey();
/* 366 */       Object object2 = entry.getValue();
/* 367 */       if (bool) {
/* 368 */         bool = false;
/*     */       } else {
/* 370 */         stringBuilder.append(", ");
/*     */       } 
/* 372 */       stringBuilder.append((object1 == this) ? "(this Map)" : object1);
/* 373 */       stringBuilder.append('=');
/* 374 */       stringBuilder.append((object2 == this) ? "(this Map)" : object2);
/*     */     } 
/* 376 */     stringBuilder.append('}');
/* 377 */     return stringBuilder.toString();
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
/*     */   public K get(int paramInt) {
/* 389 */     return this.insertOrder.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V getValue(int paramInt) {
/* 400 */     return get(this.insertOrder.get(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int indexOf(Object paramObject) {
/* 410 */     return this.insertOrder.indexOf(paramObject);
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
/*     */   public V setValue(int paramInt, V paramV) {
/* 423 */     K k = this.insertOrder.get(paramInt);
/* 424 */     return put(k, paramV);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V put(int paramInt, K paramK, V paramV) {
/* 447 */     if (paramInt < 0 || paramInt > this.insertOrder.size()) {
/* 448 */       throw new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.insertOrder.size());
/*     */     }
/*     */     
/* 451 */     Map<K, V> map = decorated();
/* 452 */     if (map.containsKey(paramK)) {
/* 453 */       V v = map.remove(paramK);
/* 454 */       int i = this.insertOrder.indexOf(paramK);
/* 455 */       this.insertOrder.remove(i);
/* 456 */       if (i < paramInt) {
/* 457 */         paramInt--;
/*     */       }
/* 459 */       this.insertOrder.add(paramInt, paramK);
/* 460 */       map.put(paramK, paramV);
/* 461 */       return v;
/*     */     } 
/* 463 */     this.insertOrder.add(paramInt, paramK);
/* 464 */     map.put(paramK, paramV);
/* 465 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V remove(int paramInt) {
/* 476 */     return remove(get(paramInt));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<K> asList() {
/* 497 */     return keyList();
/*     */   }
/*     */ 
/*     */   
/*     */   static class ValuesView<V>
/*     */     extends AbstractList<V>
/*     */   {
/*     */     private final ListOrderedMap<Object, V> parent;
/*     */     
/*     */     ValuesView(ListOrderedMap<?, V> param1ListOrderedMap) {
/* 507 */       this.parent = (ListOrderedMap)param1ListOrderedMap;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 512 */       return this.parent.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 517 */       return this.parent.containsValue(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 522 */       this.parent.clear();
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<V> iterator() {
/* 527 */       return (Iterator)new AbstractUntypedIteratorDecorator<Map.Entry<Object, V>, V>(this.parent.entrySet().iterator()) {
/*     */           public V next() {
/* 529 */             return (V)((Map.Entry)getIterator().next()).getValue();
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     public V get(int param1Int) {
/* 536 */       return this.parent.getValue(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public V set(int param1Int, V param1V) {
/* 541 */       return this.parent.setValue(param1Int, param1V);
/*     */     }
/*     */ 
/*     */     
/*     */     public V remove(int param1Int) {
/* 546 */       return this.parent.remove(param1Int);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class KeySetView<K>
/*     */     extends AbstractSet<K>
/*     */   {
/*     */     private final ListOrderedMap<K, Object> parent;
/*     */     
/*     */     KeySetView(ListOrderedMap<K, ?> param1ListOrderedMap) {
/* 557 */       this.parent = (ListOrderedMap)param1ListOrderedMap;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 562 */       return this.parent.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 567 */       return this.parent.containsKey(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 572 */       this.parent.clear();
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<K> iterator() {
/* 577 */       return (Iterator)new AbstractUntypedIteratorDecorator<Map.Entry<K, Object>, K>(this.parent.entrySet().iterator()) {
/*     */           public K next() {
/* 579 */             return (K)((Map.Entry)getIterator().next()).getKey();
/*     */           }
/*     */         };
/*     */     }
/*     */   }
/*     */   
/*     */   static class EntrySetView<K, V>
/*     */     extends AbstractSet<Map.Entry<K, V>>
/*     */   {
/*     */     private final ListOrderedMap<K, V> parent;
/*     */     private final List<K> insertOrder;
/*     */     private Set<Map.Entry<K, V>> entrySet;
/*     */     
/*     */     public EntrySetView(ListOrderedMap<K, V> param1ListOrderedMap, List<K> param1List) {
/* 593 */       this.parent = param1ListOrderedMap;
/* 594 */       this.insertOrder = param1List;
/*     */     }
/*     */     
/*     */     private Set<Map.Entry<K, V>> getEntrySet() {
/* 598 */       if (this.entrySet == null) {
/* 599 */         this.entrySet = this.parent.decorated().entrySet();
/*     */       }
/* 601 */       return this.entrySet;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 606 */       return this.parent.size();
/*     */     }
/*     */     
/*     */     public boolean isEmpty() {
/* 610 */       return this.parent.isEmpty();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 615 */       return getEntrySet().contains(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean containsAll(Collection<?> param1Collection) {
/* 620 */       return getEntrySet().containsAll(param1Collection);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean remove(Object param1Object) {
/* 626 */       if (!(param1Object instanceof Map.Entry)) {
/* 627 */         return false;
/*     */       }
/* 629 */       if (getEntrySet().contains(param1Object)) {
/* 630 */         Object object = ((Map.Entry)param1Object).getKey();
/* 631 */         this.parent.remove(object);
/* 632 */         return true;
/*     */       } 
/* 634 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 639 */       this.parent.clear();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 644 */       if (param1Object == this) {
/* 645 */         return true;
/*     */       }
/* 647 */       return getEntrySet().equals(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 652 */       return getEntrySet().hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 657 */       return getEntrySet().toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<Map.Entry<K, V>> iterator() {
/* 662 */       return (Iterator)new ListOrderedMap.ListOrderedIterator<K, V>(this.parent, this.insertOrder);
/*     */     }
/*     */   }
/*     */   
/*     */   static class ListOrderedIterator<K, V>
/*     */     extends AbstractUntypedIteratorDecorator<K, Map.Entry<K, V>> {
/*     */     private final ListOrderedMap<K, V> parent;
/* 669 */     private K last = null;
/*     */     
/*     */     ListOrderedIterator(ListOrderedMap<K, V> param1ListOrderedMap, List<K> param1List) {
/* 672 */       super(param1List.iterator());
/* 673 */       this.parent = param1ListOrderedMap;
/*     */     }
/*     */     
/*     */     public Map.Entry<K, V> next() {
/* 677 */       this.last = getIterator().next();
/* 678 */       return (Map.Entry<K, V>)new ListOrderedMap.ListOrderedMapEntry<K, V>(this.parent, this.last);
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 683 */       super.remove();
/* 684 */       this.parent.decorated().remove(this.last);
/*     */     }
/*     */   }
/*     */   
/*     */   static class ListOrderedMapEntry<K, V>
/*     */     extends AbstractMapEntry<K, V> {
/*     */     private final ListOrderedMap<K, V> parent;
/*     */     
/*     */     ListOrderedMapEntry(ListOrderedMap<K, V> param1ListOrderedMap, K param1K) {
/* 693 */       super(param1K, null);
/* 694 */       this.parent = param1ListOrderedMap;
/*     */     }
/*     */ 
/*     */     
/*     */     public V getValue() {
/* 699 */       return this.parent.get(getKey());
/*     */     }
/*     */ 
/*     */     
/*     */     public V setValue(V param1V) {
/* 704 */       return this.parent.decorated().put(getKey(), param1V);
/*     */     }
/*     */   }
/*     */   
/*     */   static class ListOrderedMapIterator<K, V>
/*     */     implements OrderedMapIterator<K, V>, ResettableIterator<K> {
/*     */     private final ListOrderedMap<K, V> parent;
/*     */     private ListIterator<K> iterator;
/* 712 */     private K last = null;
/*     */     
/*     */     private boolean readable = false;
/*     */     
/*     */     ListOrderedMapIterator(ListOrderedMap<K, V> param1ListOrderedMap) {
/* 717 */       this.parent = param1ListOrderedMap;
/* 718 */       this.iterator = param1ListOrderedMap.insertOrder.listIterator();
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 722 */       return this.iterator.hasNext();
/*     */     }
/*     */     
/*     */     public K next() {
/* 726 */       this.last = this.iterator.next();
/* 727 */       this.readable = true;
/* 728 */       return this.last;
/*     */     }
/*     */     
/*     */     public boolean hasPrevious() {
/* 732 */       return this.iterator.hasPrevious();
/*     */     }
/*     */     
/*     */     public K previous() {
/* 736 */       this.last = this.iterator.previous();
/* 737 */       this.readable = true;
/* 738 */       return this.last;
/*     */     }
/*     */     
/*     */     public void remove() {
/* 742 */       if (!this.readable) {
/* 743 */         throw new IllegalStateException("remove() can only be called once after next()");
/*     */       }
/* 745 */       this.iterator.remove();
/* 746 */       this.parent.map.remove(this.last);
/* 747 */       this.readable = false;
/*     */     }
/*     */     
/*     */     public K getKey() {
/* 751 */       if (!this.readable) {
/* 752 */         throw new IllegalStateException("getKey() can only be called after next() and before remove()");
/*     */       }
/* 754 */       return this.last;
/*     */     }
/*     */     
/*     */     public V getValue() {
/* 758 */       if (!this.readable) {
/* 759 */         throw new IllegalStateException("getValue() can only be called after next() and before remove()");
/*     */       }
/* 761 */       return this.parent.get(this.last);
/*     */     }
/*     */     
/*     */     public V setValue(V param1V) {
/* 765 */       if (!this.readable) {
/* 766 */         throw new IllegalStateException("setValue() can only be called after next() and before remove()");
/*     */       }
/* 768 */       return this.parent.map.put(this.last, param1V);
/*     */     }
/*     */     
/*     */     public void reset() {
/* 772 */       this.iterator = this.parent.insertOrder.listIterator();
/* 773 */       this.last = null;
/* 774 */       this.readable = false;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 779 */       if (this.readable == true) {
/* 780 */         return "Iterator[" + getKey() + "=" + getValue() + "]";
/*     */       }
/* 782 */       return "Iterator[]";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\ListOrderedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */