/*     */ package org.apache.commons.collections4.bidimap;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.BidiMap;
/*     */ import org.apache.commons.collections4.MapIterator;
/*     */ import org.apache.commons.collections4.ResettableIterator;
/*     */ import org.apache.commons.collections4.collection.AbstractCollectionDecorator;
/*     */ import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
/*     */ import org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractDualBidiMap<K, V>
/*     */   implements BidiMap<K, V>
/*     */ {
/*     */   transient Map<K, V> normalMap;
/*     */   transient Map<V, K> reverseMap;
/*  57 */   transient BidiMap<V, K> inverseBidiMap = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  62 */   transient Set<K> keySet = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  67 */   transient Set<V> values = null;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  72 */   transient Set<Map.Entry<K, V>> entrySet = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractDualBidiMap(Map<K, V> paramMap, Map<V, K> paramMap1) {
/* 101 */     this.normalMap = paramMap;
/* 102 */     this.reverseMap = paramMap1;
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
/*     */   protected AbstractDualBidiMap(Map<K, V> paramMap, Map<V, K> paramMap1, BidiMap<V, K> paramBidiMap) {
/* 116 */     this.normalMap = paramMap;
/* 117 */     this.reverseMap = paramMap1;
/* 118 */     this.inverseBidiMap = paramBidiMap;
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
/*     */   public V get(Object paramObject) {
/* 136 */     return this.normalMap.get(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 141 */     return this.normalMap.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 146 */     return this.normalMap.isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/* 151 */     return this.normalMap.containsKey(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 156 */     return this.normalMap.equals(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 161 */     return this.normalMap.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 166 */     return this.normalMap.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V put(K paramK, V paramV) {
/* 174 */     if (this.normalMap.containsKey(paramK)) {
/* 175 */       this.reverseMap.remove(this.normalMap.get(paramK));
/*     */     }
/* 177 */     if (this.reverseMap.containsKey(paramV)) {
/* 178 */       this.normalMap.remove(this.reverseMap.get(paramV));
/*     */     }
/* 180 */     V v = this.normalMap.put(paramK, paramV);
/* 181 */     this.reverseMap.put(paramV, paramK);
/* 182 */     return v;
/*     */   }
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/* 187 */     for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet()) {
/* 188 */       put((K)entry.getKey(), (V)entry.getValue());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public V remove(Object paramObject) {
/* 194 */     V v = null;
/* 195 */     if (this.normalMap.containsKey(paramObject)) {
/* 196 */       v = this.normalMap.remove(paramObject);
/* 197 */       this.reverseMap.remove(v);
/*     */     } 
/* 199 */     return v;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 204 */     this.normalMap.clear();
/* 205 */     this.reverseMap.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsValue(Object paramObject) {
/* 210 */     return this.reverseMap.containsKey(paramObject);
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
/*     */   public MapIterator<K, V> mapIterator() {
/* 228 */     return new BidiMapIterator<K, V>(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public K getKey(Object paramObject) {
/* 233 */     return this.reverseMap.get(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public K removeValue(Object paramObject) {
/* 238 */     K k = null;
/* 239 */     if (this.reverseMap.containsKey(paramObject)) {
/* 240 */       k = this.reverseMap.remove(paramObject);
/* 241 */       this.normalMap.remove(k);
/*     */     } 
/* 243 */     return k;
/*     */   }
/*     */ 
/*     */   
/*     */   public BidiMap<V, K> inverseBidiMap() {
/* 248 */     if (this.inverseBidiMap == null) {
/* 249 */       this.inverseBidiMap = createBidiMap(this.reverseMap, this.normalMap, this);
/*     */     }
/* 251 */     return this.inverseBidiMap;
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
/* 265 */     if (this.keySet == null) {
/* 266 */       this.keySet = new KeySet<K>(this);
/*     */     }
/* 268 */     return this.keySet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Iterator<K> createKeySetIterator(Iterator<K> paramIterator) {
/* 279 */     return (Iterator<K>)new KeySetIterator<K>(paramIterator, this);
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
/*     */   public Set<V> values() {
/* 291 */     if (this.values == null) {
/* 292 */       this.values = new Values<V>(this);
/*     */     }
/* 294 */     return this.values;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Iterator<V> createValuesIterator(Iterator<V> paramIterator) {
/* 305 */     return (Iterator<V>)new ValuesIterator<V>(paramIterator, this);
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
/*     */   public Set<Map.Entry<K, V>> entrySet() {
/* 321 */     if (this.entrySet == null) {
/* 322 */       this.entrySet = new EntrySet<K, V>(this);
/*     */     }
/* 324 */     return this.entrySet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Iterator<Map.Entry<K, V>> createEntrySetIterator(Iterator<Map.Entry<K, V>> paramIterator) {
/* 335 */     return (Iterator)new EntrySetIterator<K, V>(paramIterator, this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractDualBidiMap() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract BidiMap<V, K> createBidiMap(Map<V, K> paramMap, Map<K, V> paramMap1, BidiMap<K, V> paramBidiMap);
/*     */ 
/*     */ 
/*     */   
/*     */   protected static abstract class View<K, V, E>
/*     */     extends AbstractCollectionDecorator<E>
/*     */   {
/*     */     private static final long serialVersionUID = 4621510560119690639L;
/*     */     
/*     */     protected final AbstractDualBidiMap<K, V> parent;
/*     */ 
/*     */     
/*     */     protected View(Collection<E> param1Collection, AbstractDualBidiMap<K, V> param1AbstractDualBidiMap) {
/* 357 */       super(param1Collection);
/* 358 */       this.parent = param1AbstractDualBidiMap;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 363 */       return (param1Object == this || decorated().equals(param1Object));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 368 */       return decorated().hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean removeAll(Collection<?> param1Collection) {
/* 373 */       if (this.parent.isEmpty() || param1Collection.isEmpty()) {
/* 374 */         return false;
/*     */       }
/* 376 */       boolean bool = false;
/* 377 */       Iterator<?> iterator = param1Collection.iterator();
/* 378 */       while (iterator.hasNext()) {
/* 379 */         bool |= remove(iterator.next());
/*     */       }
/* 381 */       return bool;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean retainAll(Collection<?> param1Collection) {
/* 395 */       if (this.parent.isEmpty()) {
/* 396 */         return false;
/*     */       }
/* 398 */       if (param1Collection.isEmpty()) {
/* 399 */         this.parent.clear();
/* 400 */         return true;
/*     */       } 
/* 402 */       boolean bool = false;
/* 403 */       Iterator iterator = iterator();
/* 404 */       while (iterator.hasNext()) {
/* 405 */         if (!param1Collection.contains(iterator.next())) {
/* 406 */           iterator.remove();
/* 407 */           bool = true;
/*     */         } 
/*     */       } 
/* 410 */       return bool;
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 415 */       this.parent.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class KeySet<K>
/*     */     extends View<K, Object, K>
/*     */     implements Set<K>
/*     */   {
/*     */     private static final long serialVersionUID = -7107935777385040694L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected KeySet(AbstractDualBidiMap<K, ?> param1AbstractDualBidiMap) {
/* 435 */       super(param1AbstractDualBidiMap.normalMap.keySet(), (AbstractDualBidiMap)param1AbstractDualBidiMap);
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<K> iterator() {
/* 440 */       return this.parent.createKeySetIterator(super.iterator());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 445 */       return this.parent.normalMap.containsKey(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean remove(Object param1Object) {
/* 450 */       if (this.parent.normalMap.containsKey(param1Object)) {
/* 451 */         Object object = this.parent.normalMap.remove(param1Object);
/* 452 */         this.parent.reverseMap.remove(object);
/* 453 */         return true;
/*     */       } 
/* 455 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class KeySetIterator<K>
/*     */     extends AbstractIteratorDecorator<K>
/*     */   {
/*     */     protected final AbstractDualBidiMap<K, ?> parent;
/*     */ 
/*     */     
/* 468 */     protected K lastKey = null;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean canRemove = false;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected KeySetIterator(Iterator<K> param1Iterator, AbstractDualBidiMap<K, ?> param1AbstractDualBidiMap) {
/* 479 */       super(param1Iterator);
/* 480 */       this.parent = param1AbstractDualBidiMap;
/*     */     }
/*     */ 
/*     */     
/*     */     public K next() {
/* 485 */       this.lastKey = (K)super.next();
/* 486 */       this.canRemove = true;
/* 487 */       return this.lastKey;
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 492 */       if (!this.canRemove) {
/* 493 */         throw new IllegalStateException("Iterator remove() can only be called once after next()");
/*     */       }
/* 495 */       Object object = this.parent.normalMap.get(this.lastKey);
/* 496 */       super.remove();
/* 497 */       this.parent.reverseMap.remove(object);
/* 498 */       this.lastKey = null;
/* 499 */       this.canRemove = false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class Values<V>
/*     */     extends View<Object, V, V>
/*     */     implements Set<V>
/*     */   {
/*     */     private static final long serialVersionUID = 4023777119829639864L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected Values(AbstractDualBidiMap<?, V> param1AbstractDualBidiMap) {
/* 519 */       super(param1AbstractDualBidiMap.normalMap.values(), (AbstractDualBidiMap)param1AbstractDualBidiMap);
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<V> iterator() {
/* 524 */       return this.parent.createValuesIterator(super.iterator());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 529 */       return this.parent.reverseMap.containsKey(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean remove(Object param1Object) {
/* 534 */       if (this.parent.reverseMap.containsKey(param1Object)) {
/* 535 */         Object object = this.parent.reverseMap.remove(param1Object);
/* 536 */         this.parent.normalMap.remove(object);
/* 537 */         return true;
/*     */       } 
/* 539 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class ValuesIterator<V>
/*     */     extends AbstractIteratorDecorator<V>
/*     */   {
/*     */     protected final AbstractDualBidiMap<Object, V> parent;
/*     */ 
/*     */     
/* 552 */     protected V lastValue = null;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean canRemove = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected ValuesIterator(Iterator<V> param1Iterator, AbstractDualBidiMap<?, V> param1AbstractDualBidiMap) {
/* 564 */       super(param1Iterator);
/* 565 */       this.parent = (AbstractDualBidiMap)param1AbstractDualBidiMap;
/*     */     }
/*     */ 
/*     */     
/*     */     public V next() {
/* 570 */       this.lastValue = (V)super.next();
/* 571 */       this.canRemove = true;
/* 572 */       return this.lastValue;
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 577 */       if (!this.canRemove) {
/* 578 */         throw new IllegalStateException("Iterator remove() can only be called once after next()");
/*     */       }
/* 580 */       super.remove();
/* 581 */       this.parent.reverseMap.remove(this.lastValue);
/* 582 */       this.lastValue = null;
/* 583 */       this.canRemove = false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class EntrySet<K, V>
/*     */     extends View<K, V, Map.Entry<K, V>>
/*     */     implements Set<Map.Entry<K, V>>
/*     */   {
/*     */     private static final long serialVersionUID = 4040410962603292348L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected EntrySet(AbstractDualBidiMap<K, V> param1AbstractDualBidiMap) {
/* 602 */       super(param1AbstractDualBidiMap.normalMap.entrySet(), param1AbstractDualBidiMap);
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<Map.Entry<K, V>> iterator() {
/* 607 */       return this.parent.createEntrySetIterator(super.iterator());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean remove(Object param1Object) {
/* 612 */       if (!(param1Object instanceof Map.Entry)) {
/* 613 */         return false;
/*     */       }
/* 615 */       Map.Entry entry = (Map.Entry)param1Object;
/* 616 */       Object object = entry.getKey();
/* 617 */       if (this.parent.containsKey(object)) {
/* 618 */         V v = this.parent.normalMap.get(object);
/* 619 */         if ((v == null) ? (entry.getValue() == null) : v.equals(entry.getValue())) {
/* 620 */           this.parent.normalMap.remove(object);
/* 621 */           this.parent.reverseMap.remove(v);
/* 622 */           return true;
/*     */         } 
/*     */       } 
/* 625 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class EntrySetIterator<K, V>
/*     */     extends AbstractIteratorDecorator<Map.Entry<K, V>>
/*     */   {
/*     */     protected final AbstractDualBidiMap<K, V> parent;
/*     */ 
/*     */     
/* 638 */     protected Map.Entry<K, V> last = null;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean canRemove = false;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected EntrySetIterator(Iterator<Map.Entry<K, V>> param1Iterator, AbstractDualBidiMap<K, V> param1AbstractDualBidiMap) {
/* 649 */       super(param1Iterator);
/* 650 */       this.parent = param1AbstractDualBidiMap;
/*     */     }
/*     */ 
/*     */     
/*     */     public Map.Entry<K, V> next() {
/* 655 */       this.last = (Map.Entry<K, V>)new AbstractDualBidiMap.MapEntry<K, V>((Map.Entry<K, V>)super.next(), this.parent);
/* 656 */       this.canRemove = true;
/* 657 */       return this.last;
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 662 */       if (!this.canRemove) {
/* 663 */         throw new IllegalStateException("Iterator remove() can only be called once after next()");
/*     */       }
/*     */       
/* 666 */       V v = this.last.getValue();
/* 667 */       super.remove();
/* 668 */       this.parent.reverseMap.remove(v);
/* 669 */       this.last = null;
/* 670 */       this.canRemove = false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class MapEntry<K, V>
/*     */     extends AbstractMapEntryDecorator<K, V>
/*     */   {
/*     */     protected final AbstractDualBidiMap<K, V> parent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected MapEntry(Map.Entry<K, V> param1Entry, AbstractDualBidiMap<K, V> param1AbstractDualBidiMap) {
/* 688 */       super(param1Entry);
/* 689 */       this.parent = param1AbstractDualBidiMap;
/*     */     }
/*     */ 
/*     */     
/*     */     public V setValue(V param1V) {
/* 694 */       Object object = getKey();
/* 695 */       if (this.parent.reverseMap.containsKey(param1V) && this.parent.reverseMap.get(param1V) != object)
/*     */       {
/* 697 */         throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
/*     */       }
/*     */       
/* 700 */       this.parent.put((K)object, param1V);
/* 701 */       return (V)super.setValue(param1V);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class BidiMapIterator<K, V>
/*     */     implements MapIterator<K, V>, ResettableIterator<K>
/*     */   {
/*     */     protected final AbstractDualBidiMap<K, V> parent;
/*     */ 
/*     */     
/*     */     protected Iterator<Map.Entry<K, V>> iterator;
/*     */ 
/*     */     
/* 717 */     protected Map.Entry<K, V> last = null;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean canRemove = false;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected BidiMapIterator(AbstractDualBidiMap<K, V> param1AbstractDualBidiMap) {
/* 728 */       this.parent = param1AbstractDualBidiMap;
/* 729 */       this.iterator = param1AbstractDualBidiMap.normalMap.entrySet().iterator();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 734 */       return this.iterator.hasNext();
/*     */     }
/*     */ 
/*     */     
/*     */     public K next() {
/* 739 */       this.last = this.iterator.next();
/* 740 */       this.canRemove = true;
/* 741 */       return this.last.getKey();
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 746 */       if (!this.canRemove) {
/* 747 */         throw new IllegalStateException("Iterator remove() can only be called once after next()");
/*     */       }
/*     */       
/* 750 */       V v = this.last.getValue();
/* 751 */       this.iterator.remove();
/* 752 */       this.parent.reverseMap.remove(v);
/* 753 */       this.last = null;
/* 754 */       this.canRemove = false;
/*     */     }
/*     */ 
/*     */     
/*     */     public K getKey() {
/* 759 */       if (this.last == null) {
/* 760 */         throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
/*     */       }
/*     */       
/* 763 */       return this.last.getKey();
/*     */     }
/*     */ 
/*     */     
/*     */     public V getValue() {
/* 768 */       if (this.last == null) {
/* 769 */         throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
/*     */       }
/*     */       
/* 772 */       return this.last.getValue();
/*     */     }
/*     */ 
/*     */     
/*     */     public V setValue(V param1V) {
/* 777 */       if (this.last == null) {
/* 778 */         throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
/*     */       }
/*     */       
/* 781 */       if (this.parent.reverseMap.containsKey(param1V) && this.parent.reverseMap.get(param1V) != this.last.getKey())
/*     */       {
/* 783 */         throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
/*     */       }
/*     */       
/* 786 */       return this.parent.put(this.last.getKey(), param1V);
/*     */     }
/*     */ 
/*     */     
/*     */     public void reset() {
/* 791 */       this.iterator = this.parent.normalMap.entrySet().iterator();
/* 792 */       this.last = null;
/* 793 */       this.canRemove = false;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 798 */       if (this.last != null) {
/* 799 */         return "MapIterator[" + getKey() + "=" + getValue() + "]";
/*     */       }
/* 801 */       return "MapIterator[]";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\bidimap\AbstractDualBidiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */