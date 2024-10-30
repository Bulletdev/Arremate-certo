/*     */ package org.apache.commons.collections4.multimap;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.AbstractCollection;
/*     */ import java.util.AbstractMap;
/*     */ import java.util.AbstractSet;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.CollectionUtils;
/*     */ import org.apache.commons.collections4.IteratorUtils;
/*     */ import org.apache.commons.collections4.MapIterator;
/*     */ import org.apache.commons.collections4.MultiSet;
/*     */ import org.apache.commons.collections4.MultiValuedMap;
/*     */ import org.apache.commons.collections4.Transformer;
/*     */ import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
/*     */ import org.apache.commons.collections4.iterators.EmptyMapIterator;
/*     */ import org.apache.commons.collections4.iterators.IteratorChain;
/*     */ import org.apache.commons.collections4.iterators.LazyIteratorChain;
/*     */ import org.apache.commons.collections4.iterators.TransformIterator;
/*     */ import org.apache.commons.collections4.keyvalue.AbstractMapEntry;
/*     */ import org.apache.commons.collections4.keyvalue.UnmodifiableMapEntry;
/*     */ import org.apache.commons.collections4.multiset.AbstractMultiSet;
/*     */ import org.apache.commons.collections4.multiset.UnmodifiableMultiSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractMultiValuedMap<K, V>
/*     */   implements MultiValuedMap<K, V>
/*     */ {
/*     */   private transient Collection<V> valuesView;
/*     */   private transient EntryValues entryValuesView;
/*     */   private transient MultiSet<K> keysMultiSetView;
/*     */   private transient AsMap asMapView;
/*     */   private transient Map<K, Collection<V>> map;
/*     */   
/*     */   protected AbstractMultiValuedMap() {}
/*     */   
/*     */   protected AbstractMultiValuedMap(Map<K, ? extends Collection<V>> paramMap) {
/*  89 */     if (paramMap == null) {
/*  90 */       throw new NullPointerException("Map must not be null.");
/*     */     }
/*  92 */     this.map = (Map)paramMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Map<K, ? extends Collection<V>> getMap() {
/* 102 */     return this.map;
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
/*     */   protected void setMap(Map<K, ? extends Collection<V>> paramMap) {
/* 114 */     this.map = (Map)paramMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/* 122 */     return getMap().containsKey(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsValue(Object paramObject) {
/* 127 */     return values().contains(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsMapping(Object paramObject1, Object paramObject2) {
/* 132 */     Collection collection = getMap().get(paramObject1);
/* 133 */     return (collection != null && collection.contains(paramObject2));
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<Map.Entry<K, V>> entries() {
/* 138 */     return (this.entryValuesView != null) ? this.entryValuesView : (this.entryValuesView = new EntryValues());
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
/*     */   public Collection<V> get(K paramK) {
/* 150 */     return wrappedCollection(paramK);
/*     */   }
/*     */   
/*     */   Collection<V> wrappedCollection(K paramK) {
/* 154 */     return new WrappedCollection(paramK);
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
/*     */   public Collection<V> remove(Object paramObject) {
/* 168 */     return CollectionUtils.emptyIfNull(getMap().remove(paramObject));
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
/*     */   public boolean removeMapping(Object paramObject1, Object paramObject2) {
/* 186 */     Collection collection = getMap().get(paramObject1);
/* 187 */     if (collection == null) {
/* 188 */       return false;
/*     */     }
/* 190 */     boolean bool = collection.remove(paramObject2);
/* 191 */     if (collection.isEmpty()) {
/* 192 */       getMap().remove(paramObject1);
/*     */     }
/* 194 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 199 */     return getMap().isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<K> keySet() {
/* 204 */     return getMap().keySet();
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
/*     */   public int size() {
/* 220 */     int i = 0;
/* 221 */     for (Collection<V> collection : getMap().values()) {
/* 222 */       i += collection.size();
/*     */     }
/* 224 */     return i;
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
/*     */   public Collection<V> values() {
/* 236 */     Collection<V> collection = this.valuesView;
/* 237 */     return (collection != null) ? collection : (this.valuesView = new Values());
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 242 */     getMap().clear();
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
/*     */   public boolean put(K paramK, V paramV) {
/* 257 */     Collection<V> collection = getMap().get(paramK);
/* 258 */     if (collection == null) {
/* 259 */       collection = createCollection();
/* 260 */       if (collection.add(paramV)) {
/* 261 */         this.map.put(paramK, collection);
/* 262 */         return true;
/*     */       } 
/* 264 */       return false;
/*     */     } 
/*     */     
/* 267 */     return collection.add(paramV);
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
/*     */   public boolean putAll(Map<? extends K, ? extends V> paramMap) {
/* 285 */     if (paramMap == null) {
/* 286 */       throw new NullPointerException("Map must not be null.");
/*     */     }
/* 288 */     boolean bool = false;
/* 289 */     for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet()) {
/* 290 */       bool |= put((K)entry.getKey(), (V)entry.getValue());
/*     */     }
/* 292 */     return bool;
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
/*     */   public boolean putAll(MultiValuedMap<? extends K, ? extends V> paramMultiValuedMap) {
/* 309 */     if (paramMultiValuedMap == null) {
/* 310 */       throw new NullPointerException("Map must not be null.");
/*     */     }
/* 312 */     boolean bool = false;
/* 313 */     for (Map.Entry entry : paramMultiValuedMap.entries()) {
/* 314 */       bool |= put((K)entry.getKey(), (V)entry.getValue());
/*     */     }
/* 316 */     return bool;
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
/*     */   public MultiSet<K> keys() {
/* 331 */     if (this.keysMultiSetView == null) {
/* 332 */       this.keysMultiSetView = UnmodifiableMultiSet.unmodifiableMultiSet((MultiSet)new KeysMultiSet());
/*     */     }
/* 334 */     return this.keysMultiSetView;
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<K, Collection<V>> asMap() {
/* 339 */     return (this.asMapView != null) ? this.asMapView : (this.asMapView = new AsMap(this.map));
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
/*     */   public boolean putAll(K paramK, Iterable<? extends V> paramIterable) {
/* 352 */     if (paramIterable == null) {
/* 353 */       throw new NullPointerException("Values must not be null.");
/*     */     }
/*     */     
/* 356 */     if (paramIterable instanceof Collection) {
/* 357 */       Collection<? extends V> collection = (Collection)paramIterable;
/* 358 */       return (!collection.isEmpty() && get(paramK).addAll(collection));
/*     */     } 
/* 360 */     Iterator<? extends V> iterator = paramIterable.iterator();
/* 361 */     return (iterator.hasNext() && CollectionUtils.addAll(get(paramK), iterator));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MapIterator<K, V> mapIterator() {
/* 367 */     if (size() == 0) {
/* 368 */       return EmptyMapIterator.emptyMapIterator();
/*     */     }
/* 370 */     return new MultiValuedMapIterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 375 */     if (this == paramObject) {
/* 376 */       return true;
/*     */     }
/* 378 */     if (paramObject instanceof MultiValuedMap) {
/* 379 */       return asMap().equals(((MultiValuedMap)paramObject).asMap());
/*     */     }
/* 381 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 386 */     return getMap().hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 391 */     return getMap().toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   class WrappedCollection
/*     */     implements Collection<V>
/*     */   {
/*     */     protected final K key;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public WrappedCollection(K param1K) {
/* 411 */       this.key = param1K;
/*     */     }
/*     */     
/*     */     protected Collection<V> getMapping() {
/* 415 */       return (Collection<V>)AbstractMultiValuedMap.this.getMap().get(this.key);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean add(V param1V) {
/* 420 */       Collection<V> collection = getMapping();
/* 421 */       if (collection == null) {
/* 422 */         collection = AbstractMultiValuedMap.this.createCollection();
/* 423 */         AbstractMultiValuedMap.this.map.put(this.key, collection);
/*     */       } 
/* 425 */       return collection.add(param1V);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean addAll(Collection<? extends V> param1Collection) {
/* 430 */       Collection<V> collection = getMapping();
/* 431 */       if (collection == null) {
/* 432 */         collection = AbstractMultiValuedMap.this.createCollection();
/* 433 */         AbstractMultiValuedMap.this.map.put(this.key, collection);
/*     */       } 
/* 435 */       return collection.addAll(param1Collection);
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 440 */       Collection<V> collection = getMapping();
/* 441 */       if (collection != null) {
/* 442 */         collection.clear();
/* 443 */         AbstractMultiValuedMap.this.remove(this.key);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Iterator<V> iterator() {
/* 450 */       Collection<V> collection = getMapping();
/* 451 */       if (collection == null) {
/* 452 */         return (Iterator<V>)IteratorUtils.EMPTY_ITERATOR;
/*     */       }
/* 454 */       return new AbstractMultiValuedMap.ValuesIterator(this.key);
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 459 */       Collection<V> collection = getMapping();
/* 460 */       return (collection == null) ? 0 : collection.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 465 */       Collection<V> collection = getMapping();
/* 466 */       return (collection == null) ? false : collection.contains(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean containsAll(Collection<?> param1Collection) {
/* 471 */       Collection<V> collection = getMapping();
/* 472 */       return (collection == null) ? false : collection.containsAll(param1Collection);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() {
/* 477 */       Collection<V> collection = getMapping();
/* 478 */       return (collection == null) ? true : collection.isEmpty();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean remove(Object param1Object) {
/* 483 */       Collection<V> collection = getMapping();
/* 484 */       if (collection == null) {
/* 485 */         return false;
/*     */       }
/*     */       
/* 488 */       boolean bool = collection.remove(param1Object);
/* 489 */       if (collection.isEmpty()) {
/* 490 */         AbstractMultiValuedMap.this.remove(this.key);
/*     */       }
/* 492 */       return bool;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean removeAll(Collection<?> param1Collection) {
/* 497 */       Collection<V> collection = getMapping();
/* 498 */       if (collection == null) {
/* 499 */         return false;
/*     */       }
/*     */       
/* 502 */       boolean bool = collection.removeAll(param1Collection);
/* 503 */       if (collection.isEmpty()) {
/* 504 */         AbstractMultiValuedMap.this.remove(this.key);
/*     */       }
/* 506 */       return bool;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean retainAll(Collection<?> param1Collection) {
/* 511 */       Collection<V> collection = getMapping();
/* 512 */       if (collection == null) {
/* 513 */         return false;
/*     */       }
/*     */       
/* 516 */       boolean bool = collection.retainAll(param1Collection);
/* 517 */       if (collection.isEmpty()) {
/* 518 */         AbstractMultiValuedMap.this.remove(this.key);
/*     */       }
/* 520 */       return bool;
/*     */     }
/*     */ 
/*     */     
/*     */     public Object[] toArray() {
/* 525 */       Collection<V> collection = getMapping();
/* 526 */       if (collection == null) {
/* 527 */         return CollectionUtils.EMPTY_COLLECTION.toArray();
/*     */       }
/* 529 */       return collection.toArray();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public <T> T[] toArray(T[] param1ArrayOfT) {
/* 535 */       Collection<V> collection = getMapping();
/* 536 */       if (collection == null) {
/* 537 */         return (T[])CollectionUtils.EMPTY_COLLECTION.toArray((Object[])param1ArrayOfT);
/*     */       }
/* 539 */       return collection.toArray(param1ArrayOfT);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 544 */       Collection<V> collection = getMapping();
/* 545 */       if (collection == null) {
/* 546 */         return CollectionUtils.EMPTY_COLLECTION.toString();
/*     */       }
/* 548 */       return collection.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private class KeysMultiSet
/*     */     extends AbstractMultiSet<K>
/*     */   {
/*     */     private KeysMultiSet() {}
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 560 */       return AbstractMultiValuedMap.this.getMap().containsKey(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() {
/* 565 */       return AbstractMultiValuedMap.this.getMap().isEmpty();
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 570 */       return AbstractMultiValuedMap.this.size();
/*     */     }
/*     */ 
/*     */     
/*     */     protected int uniqueElements() {
/* 575 */       return AbstractMultiValuedMap.this.getMap().size();
/*     */     }
/*     */ 
/*     */     
/*     */     public int getCount(Object param1Object) {
/* 580 */       int i = 0;
/* 581 */       Collection collection = (Collection)AbstractMultiValuedMap.this.getMap().get(param1Object);
/* 582 */       if (collection != null) {
/* 583 */         i = collection.size();
/*     */       }
/* 585 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     protected Iterator<MultiSet.Entry<K>> createEntrySetIterator() {
/* 590 */       MapEntryTransformer mapEntryTransformer = new MapEntryTransformer();
/* 591 */       return IteratorUtils.transformedIterator(AbstractMultiValuedMap.this.map.entrySet().iterator(), mapEntryTransformer);
/*     */     }
/*     */     
/*     */     private final class MapEntryTransformer implements Transformer<Map.Entry<K, Collection<V>>, MultiSet.Entry<K>> {
/*     */       private MapEntryTransformer() {}
/*     */       
/*     */       public MultiSet.Entry<K> transform(final Map.Entry<K, Collection<V>> mapEntry) {
/* 598 */         return (MultiSet.Entry<K>)new AbstractMultiSet.AbstractEntry<K>()
/*     */           {
/*     */             public K getElement() {
/* 601 */               return (K)mapEntry.getKey();
/*     */             }
/*     */ 
/*     */             
/*     */             public int getCount() {
/* 606 */               return ((Collection)mapEntry.getValue()).size();
/*     */             }
/*     */           };
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private class EntryValues
/*     */     extends AbstractCollection<Map.Entry<K, V>>
/*     */   {
/*     */     private EntryValues() {}
/*     */     
/*     */     public Iterator<Map.Entry<K, V>> iterator() {
/* 620 */       return (Iterator<Map.Entry<K, V>>)new LazyIteratorChain<Map.Entry<K, V>>()
/*     */         {
/* 622 */           final Collection<K> keysCol = new ArrayList<K>(AbstractMultiValuedMap.this.getMap().keySet());
/* 623 */           final Iterator<K> keyIterator = this.keysCol.iterator();
/*     */ 
/*     */           
/*     */           protected Iterator<? extends Map.Entry<K, V>> nextIterator(int param2Int) {
/* 627 */             if (!this.keyIterator.hasNext()) {
/* 628 */               return null;
/*     */             }
/* 630 */             final K key = this.keyIterator.next();
/* 631 */             Transformer<V, Map.Entry<K, V>> transformer = new Transformer<V, Map.Entry<K, V>>()
/*     */               {
/*     */                 public Map.Entry<K, V> transform(V param3V)
/*     */                 {
/* 635 */                   return (Map.Entry<K, V>)new AbstractMultiValuedMap.MultiValuedMapEntry((K)key, param3V);
/*     */                 }
/*     */               };
/*     */             
/* 639 */             return (Iterator<? extends Map.Entry<K, V>>)new TransformIterator(new AbstractMultiValuedMap.ValuesIterator(k), transformer);
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 646 */       return AbstractMultiValuedMap.this.size();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class MultiValuedMapEntry
/*     */     extends AbstractMapEntry<K, V>
/*     */   {
/*     */     public MultiValuedMapEntry(K param1K, V param1V) {
/* 657 */       super(param1K, param1V);
/*     */     }
/*     */ 
/*     */     
/*     */     public V setValue(V param1V) {
/* 662 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class MultiValuedMapIterator
/*     */     implements MapIterator<K, V>
/*     */   {
/*     */     private final Iterator<Map.Entry<K, V>> it;
/*     */ 
/*     */     
/* 674 */     private Map.Entry<K, V> current = null;
/*     */     
/*     */     public MultiValuedMapIterator() {
/* 677 */       this.it = AbstractMultiValuedMap.this.entries().iterator();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 682 */       return this.it.hasNext();
/*     */     }
/*     */ 
/*     */     
/*     */     public K next() {
/* 687 */       this.current = this.it.next();
/* 688 */       return this.current.getKey();
/*     */     }
/*     */ 
/*     */     
/*     */     public K getKey() {
/* 693 */       if (this.current == null) {
/* 694 */         throw new IllegalStateException();
/*     */       }
/* 696 */       return this.current.getKey();
/*     */     }
/*     */ 
/*     */     
/*     */     public V getValue() {
/* 701 */       if (this.current == null) {
/* 702 */         throw new IllegalStateException();
/*     */       }
/* 704 */       return this.current.getValue();
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 709 */       this.it.remove();
/*     */     }
/*     */ 
/*     */     
/*     */     public V setValue(V param1V) {
/* 714 */       if (this.current == null) {
/* 715 */         throw new IllegalStateException();
/*     */       }
/* 717 */       return this.current.setValue(param1V);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private class Values
/*     */     extends AbstractCollection<V>
/*     */   {
/*     */     private Values() {}
/*     */     
/*     */     public Iterator<V> iterator() {
/* 728 */       IteratorChain iteratorChain = new IteratorChain();
/* 729 */       for (Object object : AbstractMultiValuedMap.this.keySet()) {
/* 730 */         iteratorChain.addIterator(new AbstractMultiValuedMap.ValuesIterator(object));
/*     */       }
/* 732 */       return (Iterator<V>)iteratorChain;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 737 */       return AbstractMultiValuedMap.this.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 742 */       AbstractMultiValuedMap.this.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private class ValuesIterator
/*     */     implements Iterator<V>
/*     */   {
/*     */     private final Object key;
/*     */     private final Collection<V> values;
/*     */     private final Iterator<V> iterator;
/*     */     
/*     */     public ValuesIterator(Object param1Object) {
/* 755 */       this.key = param1Object;
/* 756 */       this.values = (Collection<V>)AbstractMultiValuedMap.this.getMap().get(param1Object);
/* 757 */       this.iterator = this.values.iterator();
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/* 762 */       this.iterator.remove();
/* 763 */       if (this.values.isEmpty()) {
/* 764 */         AbstractMultiValuedMap.this.remove(this.key);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 770 */       return this.iterator.hasNext();
/*     */     }
/*     */ 
/*     */     
/*     */     public V next() {
/* 775 */       return this.iterator.next();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private class AsMap
/*     */     extends AbstractMap<K, Collection<V>>
/*     */   {
/*     */     final transient Map<K, Collection<V>> decoratedMap;
/*     */     
/*     */     AsMap(Map<K, Collection<V>> param1Map) {
/* 786 */       this.decoratedMap = param1Map;
/*     */     }
/*     */ 
/*     */     
/*     */     public Set<Map.Entry<K, Collection<V>>> entrySet() {
/* 791 */       return new AsMapEntrySet();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean containsKey(Object param1Object) {
/* 796 */       return this.decoratedMap.containsKey(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public Collection<V> get(Object param1Object) {
/* 801 */       Collection collection = this.decoratedMap.get(param1Object);
/* 802 */       if (collection == null) {
/* 803 */         return null;
/*     */       }
/*     */       
/* 806 */       Object object = param1Object;
/* 807 */       return AbstractMultiValuedMap.this.wrappedCollection(object);
/*     */     }
/*     */ 
/*     */     
/*     */     public Set<K> keySet() {
/* 812 */       return AbstractMultiValuedMap.this.keySet();
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 817 */       return this.decoratedMap.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public Collection<V> remove(Object param1Object) {
/* 822 */       Collection collection = this.decoratedMap.remove(param1Object);
/* 823 */       if (collection == null) {
/* 824 */         return null;
/*     */       }
/*     */       
/* 827 */       Collection<V> collection1 = AbstractMultiValuedMap.this.createCollection();
/* 828 */       collection1.addAll(collection);
/* 829 */       collection.clear();
/* 830 */       return collection1;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 835 */       return (this == param1Object || this.decoratedMap.equals(param1Object));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 840 */       return this.decoratedMap.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 845 */       return this.decoratedMap.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 850 */       AbstractMultiValuedMap.this.clear();
/*     */     }
/*     */     
/*     */     class AsMapEntrySet
/*     */       extends AbstractSet<Map.Entry<K, Collection<V>>>
/*     */     {
/*     */       public Iterator<Map.Entry<K, Collection<V>>> iterator() {
/* 857 */         return (Iterator<Map.Entry<K, Collection<V>>>)new AbstractMultiValuedMap.AsMap.AsMapEntrySetIterator(AbstractMultiValuedMap.AsMap.this.decoratedMap.entrySet().iterator());
/*     */       }
/*     */ 
/*     */       
/*     */       public int size() {
/* 862 */         return AbstractMultiValuedMap.AsMap.this.size();
/*     */       }
/*     */ 
/*     */       
/*     */       public void clear() {
/* 867 */         AbstractMultiValuedMap.AsMap.this.clear();
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean contains(Object param2Object) {
/* 872 */         return AbstractMultiValuedMap.AsMap.this.decoratedMap.entrySet().contains(param2Object);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean remove(Object param2Object) {
/* 877 */         if (!contains(param2Object)) {
/* 878 */           return false;
/*     */         }
/* 880 */         Map.Entry entry = (Map.Entry)param2Object;
/* 881 */         AbstractMultiValuedMap.this.remove(entry.getKey());
/* 882 */         return true;
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     class AsMapEntrySetIterator
/*     */       extends AbstractIteratorDecorator<Map.Entry<K, Collection<V>>>
/*     */     {
/*     */       AsMapEntrySetIterator(Iterator<Map.Entry<K, Collection<V>>> param2Iterator) {
/* 892 */         super(param2Iterator);
/*     */       }
/*     */ 
/*     */       
/*     */       public Map.Entry<K, Collection<V>> next() {
/* 897 */         Map.Entry entry = (Map.Entry)super.next();
/* 898 */         Object object = entry.getKey();
/* 899 */         return (Map.Entry<K, Collection<V>>)new UnmodifiableMapEntry(object, AbstractMultiValuedMap.this.wrappedCollection(object));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void doWriteObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 911 */     paramObjectOutputStream.writeInt(this.map.size());
/* 912 */     for (Map.Entry<K, Collection<V>> entry : this.map.entrySet()) {
/* 913 */       paramObjectOutputStream.writeObject(entry.getKey());
/* 914 */       paramObjectOutputStream.writeInt(((Collection)entry.getValue()).size());
/* 915 */       for (Object object : entry.getValue()) {
/* 916 */         paramObjectOutputStream.writeObject(object);
/*     */       }
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
/*     */   protected void doReadObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 930 */     int i = paramObjectInputStream.readInt();
/* 931 */     for (byte b = 0; b < i; b++) {
/*     */       
/* 933 */       Object object = paramObjectInputStream.readObject();
/* 934 */       Collection<V> collection = get((K)object);
/* 935 */       int j = paramObjectInputStream.readInt();
/* 936 */       for (byte b1 = 0; b1 < j; b1++) {
/*     */         
/* 938 */         Object object1 = paramObjectInputStream.readObject();
/* 939 */         collection.add((V)object1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected abstract Collection<V> createCollection();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\multimap\AbstractMultiValuedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */