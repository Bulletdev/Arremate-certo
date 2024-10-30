/*      */ package org.apache.commons.collections4.map;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.io.ObjectOutputStream;
/*      */ import java.util.AbstractCollection;
/*      */ import java.util.AbstractMap;
/*      */ import java.util.AbstractSet;
/*      */ import java.util.Collection;
/*      */ import java.util.ConcurrentModificationException;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.NoSuchElementException;
/*      */ import java.util.Set;
/*      */ import org.apache.commons.collections4.IterableMap;
/*      */ import org.apache.commons.collections4.KeyValue;
/*      */ import org.apache.commons.collections4.MapIterator;
/*      */ import org.apache.commons.collections4.iterators.EmptyIterator;
/*      */ import org.apache.commons.collections4.iterators.EmptyMapIterator;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class AbstractHashedMap<K, V>
/*      */   extends AbstractMap<K, V>
/*      */   implements IterableMap<K, V>
/*      */ {
/*      */   protected static final String NO_NEXT_ENTRY = "No next() entry in the iteration";
/*      */   protected static final String NO_PREVIOUS_ENTRY = "No previous() entry in the iteration";
/*      */   protected static final String REMOVE_INVALID = "remove() can only be called once after next()";
/*      */   protected static final String GETKEY_INVALID = "getKey() can only be called after next() and before remove()";
/*      */   protected static final String GETVALUE_INVALID = "getValue() can only be called after next() and before remove()";
/*      */   protected static final String SETVALUE_INVALID = "setValue() can only be called after next() and before remove()";
/*      */   protected static final int DEFAULT_CAPACITY = 16;
/*      */   protected static final int DEFAULT_THRESHOLD = 12;
/*      */   protected static final float DEFAULT_LOAD_FACTOR = 0.75F;
/*      */   protected static final int MAXIMUM_CAPACITY = 1073741824;
/*   76 */   protected static final Object NULL = new Object();
/*      */ 
/*      */ 
/*      */   
/*      */   transient float loadFactor;
/*      */ 
/*      */ 
/*      */   
/*      */   transient int size;
/*      */ 
/*      */ 
/*      */   
/*      */   transient HashEntry<K, V>[] data;
/*      */ 
/*      */   
/*      */   transient int threshold;
/*      */ 
/*      */   
/*      */   transient int modCount;
/*      */ 
/*      */   
/*      */   transient EntrySet<K, V> entrySet;
/*      */ 
/*      */   
/*      */   transient KeySet<K> keySet;
/*      */ 
/*      */   
/*      */   transient Values<V> values;
/*      */ 
/*      */ 
/*      */   
/*      */   protected AbstractHashedMap() {}
/*      */ 
/*      */ 
/*      */   
/*      */   protected AbstractHashedMap(int paramInt1, float paramFloat, int paramInt2) {
/*  112 */     this.loadFactor = paramFloat;
/*  113 */     this.data = (HashEntry<K, V>[])new HashEntry[paramInt1];
/*  114 */     this.threshold = paramInt2;
/*  115 */     init();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected AbstractHashedMap(int paramInt) {
/*  126 */     this(paramInt, 0.75F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected AbstractHashedMap(int paramInt, float paramFloat) {
/*  141 */     if (paramInt < 0) {
/*  142 */       throw new IllegalArgumentException("Initial capacity must be a non negative number");
/*      */     }
/*  144 */     if (paramFloat <= 0.0F || Float.isNaN(paramFloat)) {
/*  145 */       throw new IllegalArgumentException("Load factor must be greater than 0");
/*      */     }
/*  147 */     this.loadFactor = paramFloat;
/*  148 */     paramInt = calculateNewCapacity(paramInt);
/*  149 */     this.threshold = calculateThreshold(paramInt, paramFloat);
/*  150 */     this.data = (HashEntry<K, V>[])new HashEntry[paramInt];
/*  151 */     init();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected AbstractHashedMap(Map<? extends K, ? extends V> paramMap) {
/*  161 */     this(Math.max(2 * paramMap.size(), 16), 0.75F);
/*  162 */     _putAll(paramMap);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void init() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public V get(Object paramObject) {
/*  180 */     paramObject = convertKey(paramObject);
/*  181 */     int i = hash(paramObject);
/*  182 */     HashEntry<K, V> hashEntry = this.data[hashIndex(i, this.data.length)];
/*  183 */     while (hashEntry != null) {
/*  184 */       if (hashEntry.hashCode == i && isEqualKey(paramObject, hashEntry.key)) {
/*  185 */         return hashEntry.getValue();
/*      */       }
/*  187 */       hashEntry = hashEntry.next;
/*      */     } 
/*  189 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int size() {
/*  199 */     return this.size;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmpty() {
/*  209 */     return (this.size == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean containsKey(Object paramObject) {
/*  221 */     paramObject = convertKey(paramObject);
/*  222 */     int i = hash(paramObject);
/*  223 */     HashEntry<K, V> hashEntry = this.data[hashIndex(i, this.data.length)];
/*  224 */     while (hashEntry != null) {
/*  225 */       if (hashEntry.hashCode == i && isEqualKey(paramObject, hashEntry.key)) {
/*  226 */         return true;
/*      */       }
/*  228 */       hashEntry = hashEntry.next;
/*      */     } 
/*  230 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean containsValue(Object paramObject) {
/*  241 */     if (paramObject == null) {
/*  242 */       for (HashEntry<K, V> hashEntry1 : this.data) {
/*  243 */         HashEntry<K, V> hashEntry2 = hashEntry1;
/*  244 */         while (hashEntry2 != null) {
/*  245 */           if (hashEntry2.getValue() == null) {
/*  246 */             return true;
/*      */           }
/*  248 */           hashEntry2 = hashEntry2.next;
/*      */         } 
/*      */       } 
/*      */     } else {
/*  252 */       for (HashEntry<K, V> hashEntry1 : this.data) {
/*  253 */         HashEntry<K, V> hashEntry2 = hashEntry1;
/*  254 */         while (hashEntry2 != null) {
/*  255 */           if (isEqualValue(paramObject, hashEntry2.getValue())) {
/*  256 */             return true;
/*      */           }
/*  258 */           hashEntry2 = hashEntry2.next;
/*      */         } 
/*      */       } 
/*      */     } 
/*  262 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public V put(K paramK, V paramV) {
/*  275 */     Object object = convertKey(paramK);
/*  276 */     int i = hash(object);
/*  277 */     int j = hashIndex(i, this.data.length);
/*  278 */     HashEntry<K, V> hashEntry = this.data[j];
/*  279 */     while (hashEntry != null) {
/*  280 */       if (hashEntry.hashCode == i && isEqualKey(object, hashEntry.key)) {
/*  281 */         V v = hashEntry.getValue();
/*  282 */         updateEntry(hashEntry, paramV);
/*  283 */         return v;
/*      */       } 
/*  285 */       hashEntry = hashEntry.next;
/*      */     } 
/*      */     
/*  288 */     addMapping(j, i, paramK, paramV);
/*  289 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/*  303 */     _putAll(paramMap);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void _putAll(Map<? extends K, ? extends V> paramMap) {
/*  319 */     int i = paramMap.size();
/*  320 */     if (i == 0) {
/*      */       return;
/*      */     }
/*  323 */     int j = (int)((this.size + i) / this.loadFactor + 1.0F);
/*  324 */     ensureCapacity(calculateNewCapacity(j));
/*  325 */     for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet()) {
/*  326 */       put((K)entry.getKey(), (V)entry.getValue());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public V remove(Object paramObject) {
/*  338 */     paramObject = convertKey(paramObject);
/*  339 */     int i = hash(paramObject);
/*  340 */     int j = hashIndex(i, this.data.length);
/*  341 */     HashEntry<K, V> hashEntry1 = this.data[j];
/*  342 */     HashEntry<K, V> hashEntry2 = null;
/*  343 */     while (hashEntry1 != null) {
/*  344 */       if (hashEntry1.hashCode == i && isEqualKey(paramObject, hashEntry1.key)) {
/*  345 */         V v = hashEntry1.getValue();
/*  346 */         removeMapping(hashEntry1, j, hashEntry2);
/*  347 */         return v;
/*      */       } 
/*  349 */       hashEntry2 = hashEntry1;
/*  350 */       hashEntry1 = hashEntry1.next;
/*      */     } 
/*  352 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clear() {
/*  361 */     this.modCount++;
/*  362 */     HashEntry<K, V>[] arrayOfHashEntry = this.data;
/*  363 */     for (int i = arrayOfHashEntry.length - 1; i >= 0; i--) {
/*  364 */       arrayOfHashEntry[i] = null;
/*      */     }
/*  366 */     this.size = 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Object convertKey(Object paramObject) {
/*  382 */     return (paramObject == null) ? NULL : paramObject;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int hash(Object paramObject) {
/*  395 */     int i = paramObject.hashCode();
/*  396 */     i += i << 9 ^ 0xFFFFFFFF;
/*  397 */     i ^= i >>> 14;
/*  398 */     i += i << 4;
/*  399 */     i ^= i >>> 10;
/*  400 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isEqualKey(Object paramObject1, Object paramObject2) {
/*  413 */     return (paramObject1 == paramObject2 || paramObject1.equals(paramObject2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isEqualValue(Object paramObject1, Object paramObject2) {
/*  426 */     return (paramObject1 == paramObject2 || paramObject1.equals(paramObject2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int hashIndex(int paramInt1, int paramInt2) {
/*  439 */     return paramInt1 & paramInt2 - 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected HashEntry<K, V> getEntry(Object paramObject) {
/*  454 */     paramObject = convertKey(paramObject);
/*  455 */     int i = hash(paramObject);
/*  456 */     HashEntry<K, V> hashEntry = this.data[hashIndex(i, this.data.length)];
/*  457 */     while (hashEntry != null) {
/*  458 */       if (hashEntry.hashCode == i && isEqualKey(paramObject, hashEntry.key)) {
/*  459 */         return hashEntry;
/*      */       }
/*  461 */       hashEntry = hashEntry.next;
/*      */     } 
/*  463 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void updateEntry(HashEntry<K, V> paramHashEntry, V paramV) {
/*  477 */     paramHashEntry.setValue(paramV);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void reuseEntry(HashEntry<K, V> paramHashEntry, int paramInt1, int paramInt2, K paramK, V paramV) {
/*  494 */     paramHashEntry.next = this.data[paramInt1];
/*  495 */     paramHashEntry.hashCode = paramInt2;
/*  496 */     paramHashEntry.key = paramK;
/*  497 */     paramHashEntry.value = paramV;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void addMapping(int paramInt1, int paramInt2, K paramK, V paramV) {
/*  515 */     this.modCount++;
/*  516 */     HashEntry<K, V> hashEntry = createEntry(this.data[paramInt1], paramInt2, paramK, paramV);
/*  517 */     addEntry(hashEntry, paramInt1);
/*  518 */     this.size++;
/*  519 */     checkCapacity();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected HashEntry<K, V> createEntry(HashEntry<K, V> paramHashEntry, int paramInt, K paramK, V paramV) {
/*  536 */     return new HashEntry<K, V>(paramHashEntry, paramInt, convertKey(paramK), paramV);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void addEntry(HashEntry<K, V> paramHashEntry, int paramInt) {
/*  549 */     this.data[paramInt] = paramHashEntry;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void removeMapping(HashEntry<K, V> paramHashEntry1, int paramInt, HashEntry<K, V> paramHashEntry2) {
/*  565 */     this.modCount++;
/*  566 */     removeEntry(paramHashEntry1, paramInt, paramHashEntry2);
/*  567 */     this.size--;
/*  568 */     destroyEntry(paramHashEntry1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void removeEntry(HashEntry<K, V> paramHashEntry1, int paramInt, HashEntry<K, V> paramHashEntry2) {
/*  583 */     if (paramHashEntry2 == null) {
/*  584 */       this.data[paramInt] = paramHashEntry1.next;
/*      */     } else {
/*  586 */       paramHashEntry2.next = paramHashEntry1.next;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void destroyEntry(HashEntry<K, V> paramHashEntry) {
/*  599 */     paramHashEntry.next = null;
/*  600 */     paramHashEntry.key = null;
/*  601 */     paramHashEntry.value = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void checkCapacity() {
/*  611 */     if (this.size >= this.threshold) {
/*  612 */       int i = this.data.length * 2;
/*  613 */       if (i <= 1073741824) {
/*  614 */         ensureCapacity(i);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void ensureCapacity(int paramInt) {
/*  626 */     int i = this.data.length;
/*  627 */     if (paramInt <= i) {
/*      */       return;
/*      */     }
/*  630 */     if (this.size == 0) {
/*  631 */       this.threshold = calculateThreshold(paramInt, this.loadFactor);
/*  632 */       this.data = (HashEntry<K, V>[])new HashEntry[paramInt];
/*      */     } else {
/*  634 */       HashEntry<K, V>[] arrayOfHashEntry = this.data;
/*  635 */       HashEntry[] arrayOfHashEntry1 = new HashEntry[paramInt];
/*      */       
/*  637 */       this.modCount++;
/*  638 */       for (int j = i - 1; j >= 0; j--) {
/*  639 */         HashEntry<K, V> hashEntry = arrayOfHashEntry[j];
/*  640 */         if (hashEntry != null) {
/*  641 */           arrayOfHashEntry[j] = null;
/*      */           do {
/*  643 */             HashEntry<K, V> hashEntry1 = hashEntry.next;
/*  644 */             int k = hashIndex(hashEntry.hashCode, paramInt);
/*  645 */             hashEntry.next = arrayOfHashEntry1[k];
/*  646 */             arrayOfHashEntry1[k] = hashEntry;
/*  647 */             hashEntry = hashEntry1;
/*  648 */           } while (hashEntry != null);
/*      */         } 
/*      */       } 
/*  651 */       this.threshold = calculateThreshold(paramInt, this.loadFactor);
/*  652 */       this.data = (HashEntry<K, V>[])arrayOfHashEntry1;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int calculateNewCapacity(int paramInt) {
/*  664 */     int i = 1;
/*  665 */     if (paramInt > 1073741824) {
/*  666 */       i = 1073741824;
/*      */     } else {
/*  668 */       while (i < paramInt) {
/*  669 */         i <<= 1;
/*      */       }
/*  671 */       if (i > 1073741824) {
/*  672 */         i = 1073741824;
/*      */       }
/*      */     } 
/*  675 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int calculateThreshold(int paramInt, float paramFloat) {
/*  687 */     return (int)(paramInt * paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected HashEntry<K, V> entryNext(HashEntry<K, V> paramHashEntry) {
/*  701 */     return paramHashEntry.next;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int entryHashCode(HashEntry<K, V> paramHashEntry) {
/*  714 */     return paramHashEntry.hashCode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected K entryKey(HashEntry<K, V> paramHashEntry) {
/*  727 */     return paramHashEntry.getKey();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected V entryValue(HashEntry<K, V> paramHashEntry) {
/*  740 */     return paramHashEntry.getValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MapIterator<K, V> mapIterator() {
/*  756 */     if (this.size == 0) {
/*  757 */       return EmptyMapIterator.emptyMapIterator();
/*      */     }
/*  759 */     return new HashMapIterator<K, V>(this);
/*      */   }
/*      */ 
/*      */   
/*      */   protected static class HashMapIterator<K, V>
/*      */     extends HashIterator<K, V>
/*      */     implements MapIterator<K, V>
/*      */   {
/*      */     protected HashMapIterator(AbstractHashedMap<K, V> param1AbstractHashedMap) {
/*  768 */       super(param1AbstractHashedMap);
/*      */     }
/*      */     
/*      */     public K next() {
/*  772 */       return nextEntry().getKey();
/*      */     }
/*      */     
/*      */     public K getKey() {
/*  776 */       AbstractHashedMap.HashEntry<K, V> hashEntry = currentEntry();
/*  777 */       if (hashEntry == null) {
/*  778 */         throw new IllegalStateException("getKey() can only be called after next() and before remove()");
/*      */       }
/*  780 */       return hashEntry.getKey();
/*      */     }
/*      */     
/*      */     public V getValue() {
/*  784 */       AbstractHashedMap.HashEntry<K, V> hashEntry = currentEntry();
/*  785 */       if (hashEntry == null) {
/*  786 */         throw new IllegalStateException("getValue() can only be called after next() and before remove()");
/*      */       }
/*  788 */       return hashEntry.getValue();
/*      */     }
/*      */     
/*      */     public V setValue(V param1V) {
/*  792 */       AbstractHashedMap.HashEntry<K, V> hashEntry = currentEntry();
/*  793 */       if (hashEntry == null) {
/*  794 */         throw new IllegalStateException("setValue() can only be called after next() and before remove()");
/*      */       }
/*  796 */       return hashEntry.setValue(param1V);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<Map.Entry<K, V>> entrySet() {
/*  810 */     if (this.entrySet == null) {
/*  811 */       this.entrySet = new EntrySet<K, V>(this);
/*      */     }
/*  813 */     return this.entrySet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Iterator<Map.Entry<K, V>> createEntrySetIterator() {
/*  823 */     if (size() == 0) {
/*  824 */       return EmptyIterator.emptyIterator();
/*      */     }
/*  826 */     return new EntrySetIterator<K, V>(this);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected static class EntrySet<K, V>
/*      */     extends AbstractSet<Map.Entry<K, V>>
/*      */   {
/*      */     private final AbstractHashedMap<K, V> parent;
/*      */ 
/*      */     
/*      */     protected EntrySet(AbstractHashedMap<K, V> param1AbstractHashedMap) {
/*  838 */       this.parent = param1AbstractHashedMap;
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/*  843 */       return this.parent.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/*  848 */       this.parent.clear();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean contains(Object param1Object) {
/*  853 */       if (param1Object instanceof Map.Entry) {
/*  854 */         Map.Entry entry = (Map.Entry)param1Object;
/*  855 */         AbstractHashedMap.HashEntry<K, V> hashEntry = this.parent.getEntry(entry.getKey());
/*  856 */         return (hashEntry != null && hashEntry.equals(entry));
/*      */       } 
/*  858 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object) {
/*  863 */       if (!(param1Object instanceof Map.Entry)) {
/*  864 */         return false;
/*      */       }
/*  866 */       if (!contains(param1Object)) {
/*  867 */         return false;
/*      */       }
/*  869 */       Map.Entry entry = (Map.Entry)param1Object;
/*  870 */       this.parent.remove(entry.getKey());
/*  871 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<Map.Entry<K, V>> iterator() {
/*  876 */       return this.parent.createEntrySetIterator();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   protected static class EntrySetIterator<K, V>
/*      */     extends HashIterator<K, V>
/*      */     implements Iterator<Map.Entry<K, V>>
/*      */   {
/*      */     protected EntrySetIterator(AbstractHashedMap<K, V> param1AbstractHashedMap) {
/*  886 */       super(param1AbstractHashedMap);
/*      */     }
/*      */     
/*      */     public Map.Entry<K, V> next() {
/*  890 */       return nextEntry();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<K> keySet() {
/*  904 */     if (this.keySet == null) {
/*  905 */       this.keySet = new KeySet<K>(this);
/*      */     }
/*  907 */     return this.keySet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Iterator<K> createKeySetIterator() {
/*  917 */     if (size() == 0) {
/*  918 */       return EmptyIterator.emptyIterator();
/*      */     }
/*  920 */     return new KeySetIterator<K>(this);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected static class KeySet<K>
/*      */     extends AbstractSet<K>
/*      */   {
/*      */     private final AbstractHashedMap<K, ?> parent;
/*      */ 
/*      */     
/*      */     protected KeySet(AbstractHashedMap<K, ?> param1AbstractHashedMap) {
/*  932 */       this.parent = param1AbstractHashedMap;
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/*  937 */       return this.parent.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/*  942 */       this.parent.clear();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean contains(Object param1Object) {
/*  947 */       return this.parent.containsKey(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object) {
/*  952 */       boolean bool = this.parent.containsKey(param1Object);
/*  953 */       this.parent.remove(param1Object);
/*  954 */       return bool;
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<K> iterator() {
/*  959 */       return this.parent.createKeySetIterator();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected static class KeySetIterator<K>
/*      */     extends HashIterator<K, Object>
/*      */     implements Iterator<K>
/*      */   {
/*      */     protected KeySetIterator(AbstractHashedMap<K, ?> param1AbstractHashedMap) {
/*  970 */       super((AbstractHashedMap)param1AbstractHashedMap);
/*      */     }
/*      */     
/*      */     public K next() {
/*  974 */       return nextEntry().getKey();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Collection<V> values() {
/*  988 */     if (this.values == null) {
/*  989 */       this.values = new Values<V>(this);
/*      */     }
/*  991 */     return this.values;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Iterator<V> createValuesIterator() {
/* 1001 */     if (size() == 0) {
/* 1002 */       return EmptyIterator.emptyIterator();
/*      */     }
/* 1004 */     return new ValuesIterator<V>(this);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected static class Values<V>
/*      */     extends AbstractCollection<V>
/*      */   {
/*      */     private final AbstractHashedMap<?, V> parent;
/*      */ 
/*      */     
/*      */     protected Values(AbstractHashedMap<?, V> param1AbstractHashedMap) {
/* 1016 */       this.parent = param1AbstractHashedMap;
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/* 1021 */       return this.parent.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/* 1026 */       this.parent.clear();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean contains(Object param1Object) {
/* 1031 */       return this.parent.containsValue(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<V> iterator() {
/* 1036 */       return this.parent.createValuesIterator();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected static class ValuesIterator<V>
/*      */     extends HashIterator<Object, V>
/*      */     implements Iterator<V>
/*      */   {
/*      */     protected ValuesIterator(AbstractHashedMap<?, V> param1AbstractHashedMap) {
/* 1047 */       super((AbstractHashedMap)param1AbstractHashedMap);
/*      */     }
/*      */     
/*      */     public V next() {
/* 1051 */       return nextEntry().getValue();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static class HashEntry<K, V>
/*      */     implements Map.Entry<K, V>, KeyValue<K, V>
/*      */   {
/*      */     protected HashEntry<K, V> next;
/*      */ 
/*      */ 
/*      */     
/*      */     protected int hashCode;
/*      */ 
/*      */     
/*      */     protected Object key;
/*      */ 
/*      */     
/*      */     protected Object value;
/*      */ 
/*      */ 
/*      */     
/*      */     protected HashEntry(HashEntry<K, V> param1HashEntry, int param1Int, Object param1Object, V param1V) {
/* 1076 */       this.next = param1HashEntry;
/* 1077 */       this.hashCode = param1Int;
/* 1078 */       this.key = param1Object;
/* 1079 */       this.value = param1V;
/*      */     }
/*      */ 
/*      */     
/*      */     public K getKey() {
/* 1084 */       if (this.key == AbstractHashedMap.NULL) {
/* 1085 */         return null;
/*      */       }
/* 1087 */       return (K)this.key;
/*      */     }
/*      */ 
/*      */     
/*      */     public V getValue() {
/* 1092 */       return (V)this.value;
/*      */     }
/*      */ 
/*      */     
/*      */     public V setValue(V param1V) {
/* 1097 */       Object object = this.value;
/* 1098 */       this.value = param1V;
/* 1099 */       return (V)object;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(Object param1Object) {
/* 1104 */       if (param1Object == this) {
/* 1105 */         return true;
/*      */       }
/* 1107 */       if (!(param1Object instanceof Map.Entry)) {
/* 1108 */         return false;
/*      */       }
/* 1110 */       Map.Entry entry = (Map.Entry)param1Object;
/* 1111 */       return (((getKey() == null) ? (entry.getKey() == null) : getKey().equals(entry.getKey())) && ((getValue() == null) ? (entry.getValue() == null) : getValue().equals(entry.getValue())));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/* 1118 */       return ((getKey() == null) ? 0 : getKey().hashCode()) ^ ((getValue() == null) ? 0 : getValue().hashCode());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1124 */       return (new StringBuilder()).append(getKey()).append('=').append(getValue()).toString();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected static abstract class HashIterator<K, V>
/*      */   {
/*      */     private final AbstractHashedMap<K, V> parent;
/*      */ 
/*      */     
/*      */     private int hashIndex;
/*      */ 
/*      */     
/*      */     private AbstractHashedMap.HashEntry<K, V> last;
/*      */     
/*      */     private AbstractHashedMap.HashEntry<K, V> next;
/*      */     
/*      */     private int expectedModCount;
/*      */ 
/*      */     
/*      */     protected HashIterator(AbstractHashedMap<K, V> param1AbstractHashedMap) {
/* 1146 */       this.parent = param1AbstractHashedMap;
/* 1147 */       AbstractHashedMap.HashEntry<K, V>[] arrayOfHashEntry = param1AbstractHashedMap.data;
/* 1148 */       int i = arrayOfHashEntry.length;
/* 1149 */       AbstractHashedMap.HashEntry<K, V> hashEntry = null;
/* 1150 */       while (i > 0 && hashEntry == null) {
/* 1151 */         hashEntry = arrayOfHashEntry[--i];
/*      */       }
/* 1153 */       this.next = hashEntry;
/* 1154 */       this.hashIndex = i;
/* 1155 */       this.expectedModCount = param1AbstractHashedMap.modCount;
/*      */     }
/*      */     
/*      */     public boolean hasNext() {
/* 1159 */       return (this.next != null);
/*      */     }
/*      */     
/*      */     protected AbstractHashedMap.HashEntry<K, V> nextEntry() {
/* 1163 */       if (this.parent.modCount != this.expectedModCount) {
/* 1164 */         throw new ConcurrentModificationException();
/*      */       }
/* 1166 */       AbstractHashedMap.HashEntry<K, V> hashEntry1 = this.next;
/* 1167 */       if (hashEntry1 == null) {
/* 1168 */         throw new NoSuchElementException("No next() entry in the iteration");
/*      */       }
/* 1170 */       AbstractHashedMap.HashEntry<K, V>[] arrayOfHashEntry = this.parent.data;
/* 1171 */       int i = this.hashIndex;
/* 1172 */       AbstractHashedMap.HashEntry<K, V> hashEntry2 = hashEntry1.next;
/* 1173 */       while (hashEntry2 == null && i > 0) {
/* 1174 */         hashEntry2 = arrayOfHashEntry[--i];
/*      */       }
/* 1176 */       this.next = hashEntry2;
/* 1177 */       this.hashIndex = i;
/* 1178 */       this.last = hashEntry1;
/* 1179 */       return hashEntry1;
/*      */     }
/*      */     
/*      */     protected AbstractHashedMap.HashEntry<K, V> currentEntry() {
/* 1183 */       return this.last;
/*      */     }
/*      */     
/*      */     public void remove() {
/* 1187 */       if (this.last == null) {
/* 1188 */         throw new IllegalStateException("remove() can only be called once after next()");
/*      */       }
/* 1190 */       if (this.parent.modCount != this.expectedModCount) {
/* 1191 */         throw new ConcurrentModificationException();
/*      */       }
/* 1193 */       this.parent.remove(this.last.getKey());
/* 1194 */       this.last = null;
/* 1195 */       this.expectedModCount = this.parent.modCount;
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1200 */       if (this.last != null) {
/* 1201 */         return "Iterator[" + this.last.getKey() + "=" + this.last.getValue() + "]";
/*      */       }
/* 1203 */       return "Iterator[]";
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void doWriteObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 1229 */     paramObjectOutputStream.writeFloat(this.loadFactor);
/* 1230 */     paramObjectOutputStream.writeInt(this.data.length);
/* 1231 */     paramObjectOutputStream.writeInt(this.size);
/* 1232 */     for (MapIterator<K, V> mapIterator = mapIterator(); mapIterator.hasNext(); ) {
/* 1233 */       paramObjectOutputStream.writeObject(mapIterator.next());
/* 1234 */       paramObjectOutputStream.writeObject(mapIterator.getValue());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void doReadObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 1260 */     this.loadFactor = paramObjectInputStream.readFloat();
/* 1261 */     int i = paramObjectInputStream.readInt();
/* 1262 */     int j = paramObjectInputStream.readInt();
/* 1263 */     init();
/* 1264 */     this.threshold = calculateThreshold(i, this.loadFactor);
/* 1265 */     this.data = (HashEntry<K, V>[])new HashEntry[i];
/* 1266 */     for (byte b = 0; b < j; b++) {
/* 1267 */       Object object1 = paramObjectInputStream.readObject();
/* 1268 */       Object object2 = paramObjectInputStream.readObject();
/* 1269 */       put((K)object1, (V)object2);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected AbstractHashedMap<K, V> clone() {
/*      */     try {
/* 1287 */       AbstractHashedMap<K, V> abstractHashedMap = (AbstractHashedMap)super.clone();
/* 1288 */       abstractHashedMap.data = (HashEntry<K, V>[])new HashEntry[this.data.length];
/* 1289 */       abstractHashedMap.entrySet = null;
/* 1290 */       abstractHashedMap.keySet = null;
/* 1291 */       abstractHashedMap.values = null;
/* 1292 */       abstractHashedMap.modCount = 0;
/* 1293 */       abstractHashedMap.size = 0;
/* 1294 */       abstractHashedMap.init();
/* 1295 */       abstractHashedMap.putAll(this);
/* 1296 */       return abstractHashedMap;
/* 1297 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 1298 */       throw new InternalError();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(Object paramObject) {
/* 1310 */     if (paramObject == this) {
/* 1311 */       return true;
/*      */     }
/* 1313 */     if (!(paramObject instanceof Map)) {
/* 1314 */       return false;
/*      */     }
/* 1316 */     Map map = (Map)paramObject;
/* 1317 */     if (map.size() != size()) {
/* 1318 */       return false;
/*      */     }
/* 1320 */     MapIterator<K, V> mapIterator = mapIterator();
/*      */     try {
/* 1322 */       while (mapIterator.hasNext()) {
/* 1323 */         Object object1 = mapIterator.next();
/* 1324 */         Object object2 = mapIterator.getValue();
/* 1325 */         if (object2 == null) {
/* 1326 */           if (map.get(object1) != null || !map.containsKey(object1))
/* 1327 */             return false; 
/*      */           continue;
/*      */         } 
/* 1330 */         if (!object2.equals(map.get(object1))) {
/* 1331 */           return false;
/*      */         }
/*      */       }
/*      */     
/* 1335 */     } catch (ClassCastException classCastException) {
/* 1336 */       return false;
/* 1337 */     } catch (NullPointerException nullPointerException) {
/* 1338 */       return false;
/*      */     } 
/* 1340 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 1350 */     int i = 0;
/* 1351 */     Iterator<Map.Entry<K, V>> iterator = createEntrySetIterator();
/* 1352 */     while (iterator.hasNext()) {
/* 1353 */       i += ((Map.Entry)iterator.next()).hashCode();
/*      */     }
/* 1355 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1365 */     if (size() == 0) {
/* 1366 */       return "{}";
/*      */     }
/* 1368 */     StringBuilder stringBuilder = new StringBuilder(32 * size());
/* 1369 */     stringBuilder.append('{');
/*      */     
/* 1371 */     MapIterator<K, V> mapIterator = mapIterator();
/* 1372 */     boolean bool = mapIterator.hasNext();
/* 1373 */     while (bool) {
/* 1374 */       Object object1 = mapIterator.next();
/* 1375 */       Object object2 = mapIterator.getValue();
/* 1376 */       stringBuilder.append((object1 == this) ? "(this Map)" : object1).append('=').append((object2 == this) ? "(this Map)" : object2);
/*      */ 
/*      */ 
/*      */       
/* 1380 */       bool = mapIterator.hasNext();
/* 1381 */       if (bool) {
/* 1382 */         stringBuilder.append(',').append(' ');
/*      */       }
/*      */     } 
/*      */     
/* 1386 */     stringBuilder.append('}');
/* 1387 */     return stringBuilder.toString();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\AbstractHashedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */