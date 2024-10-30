/*      */ package org.apache.commons.collections4.map;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.io.ObjectOutputStream;
/*      */ import java.lang.ref.Reference;
/*      */ import java.lang.ref.ReferenceQueue;
/*      */ import java.lang.ref.SoftReference;
/*      */ import java.lang.ref.WeakReference;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.ConcurrentModificationException;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.NoSuchElementException;
/*      */ import java.util.Set;
/*      */ import org.apache.commons.collections4.MapIterator;
/*      */ import org.apache.commons.collections4.keyvalue.DefaultMapEntry;
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
/*      */ public abstract class AbstractReferenceMap<K, V>
/*      */   extends AbstractHashedMap<K, V>
/*      */ {
/*      */   private ReferenceStrength keyType;
/*      */   private ReferenceStrength valueType;
/*      */   private boolean purgeValues;
/*      */   private transient ReferenceQueue<Object> queue;
/*      */   
/*      */   public enum ReferenceStrength
/*      */   {
/*   88 */     HARD(0), SOFT(1), WEAK(2);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final int value;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static ReferenceStrength resolve(int param1Int) {
/*  100 */       switch (param1Int) {
/*      */         case 0:
/*  102 */           return HARD;
/*      */         case 1:
/*  104 */           return SOFT;
/*      */         case 2:
/*  106 */           return WEAK;
/*      */       } 
/*  108 */       throw new IllegalArgumentException();
/*      */     }
/*      */ 
/*      */     
/*      */     ReferenceStrength(int param1Int1) {
/*  113 */       this.value = param1Int1;
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
/*      */ 
/*      */ 
/*      */   
/*      */   protected AbstractReferenceMap() {}
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
/*      */   protected AbstractReferenceMap(ReferenceStrength paramReferenceStrength1, ReferenceStrength paramReferenceStrength2, int paramInt, float paramFloat, boolean paramBoolean) {
/*  167 */     super(paramInt, paramFloat);
/*  168 */     this.keyType = paramReferenceStrength1;
/*  169 */     this.valueType = paramReferenceStrength2;
/*  170 */     this.purgeValues = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void init() {
/*  178 */     this.queue = new ReferenceQueue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int size() {
/*  189 */     purgeBeforeRead();
/*  190 */     return super.size();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmpty() {
/*  200 */     purgeBeforeRead();
/*  201 */     return super.isEmpty();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean containsKey(Object paramObject) {
/*  212 */     purgeBeforeRead();
/*  213 */     AbstractHashedMap.HashEntry<K, V> hashEntry = getEntry(paramObject);
/*  214 */     if (hashEntry == null) {
/*  215 */       return false;
/*      */     }
/*  217 */     return (hashEntry.getValue() != null);
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
/*  228 */     purgeBeforeRead();
/*  229 */     if (paramObject == null) {
/*  230 */       return false;
/*      */     }
/*  232 */     return super.containsValue(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public V get(Object paramObject) {
/*  243 */     purgeBeforeRead();
/*  244 */     AbstractHashedMap.HashEntry<K, V> hashEntry = getEntry(paramObject);
/*  245 */     if (hashEntry == null) {
/*  246 */       return null;
/*      */     }
/*  248 */     return hashEntry.getValue();
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
/*      */   public V put(K paramK, V paramV) {
/*  263 */     if (paramK == null) {
/*  264 */       throw new NullPointerException("null keys not allowed");
/*      */     }
/*  266 */     if (paramV == null) {
/*  267 */       throw new NullPointerException("null values not allowed");
/*      */     }
/*      */     
/*  270 */     purgeBeforeWrite();
/*  271 */     return super.put(paramK, paramV);
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
/*  282 */     if (paramObject == null) {
/*  283 */       return null;
/*      */     }
/*  285 */     purgeBeforeWrite();
/*  286 */     return super.remove(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clear() {
/*  294 */     super.clear();
/*  295 */     while (this.queue.poll() != null);
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
/*      */   public MapIterator<K, V> mapIterator() {
/*  307 */     return new ReferenceMapIterator<K, V>(this);
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
/*      */   public Set<Map.Entry<K, V>> entrySet() {
/*  319 */     if (this.entrySet == null) {
/*  320 */       this.entrySet = new ReferenceEntrySet<K, V>(this);
/*      */     }
/*  322 */     return this.entrySet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<K> keySet() {
/*  332 */     if (this.keySet == null) {
/*  333 */       this.keySet = new ReferenceKeySet<K>(this);
/*      */     }
/*  335 */     return this.keySet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Collection<V> values() {
/*  345 */     if (this.values == null) {
/*  346 */       this.values = new ReferenceValues<V>(this);
/*      */     }
/*  348 */     return this.values;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void purgeBeforeRead() {
/*  358 */     purge();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void purgeBeforeWrite() {
/*  367 */     purge();
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
/*      */   protected void purge() {
/*  379 */     Reference<?> reference = this.queue.poll();
/*  380 */     while (reference != null) {
/*  381 */       purge(reference);
/*  382 */       reference = this.queue.poll();
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
/*      */   protected void purge(Reference<?> paramReference) {
/*  395 */     int i = paramReference.hashCode();
/*  396 */     int j = hashIndex(i, this.data.length);
/*  397 */     AbstractHashedMap.HashEntry<K, V> hashEntry1 = null;
/*  398 */     AbstractHashedMap.HashEntry<K, V> hashEntry2 = this.data[j];
/*  399 */     while (hashEntry2 != null) {
/*  400 */       if (((ReferenceEntry)hashEntry2).purge(paramReference)) {
/*  401 */         if (hashEntry1 == null) {
/*  402 */           this.data[j] = hashEntry2.next;
/*      */         } else {
/*  404 */           hashEntry1.next = hashEntry2.next;
/*      */         } 
/*  406 */         this.size--;
/*      */         return;
/*      */       } 
/*  409 */       hashEntry1 = hashEntry2;
/*  410 */       hashEntry2 = hashEntry2.next;
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
/*      */   protected AbstractHashedMap.HashEntry<K, V> getEntry(Object paramObject) {
/*  424 */     if (paramObject == null) {
/*  425 */       return null;
/*      */     }
/*  427 */     return super.getEntry(paramObject);
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
/*      */   protected int hashEntry(Object paramObject1, Object paramObject2) {
/*  439 */     return ((paramObject1 == null) ? 0 : paramObject1.hashCode()) ^ ((paramObject2 == null) ? 0 : paramObject2.hashCode());
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
/*      */   protected boolean isEqualKey(Object paramObject1, Object paramObject2) {
/*  456 */     paramObject2 = (this.keyType == ReferenceStrength.HARD) ? paramObject2 : ((Reference)paramObject2).get();
/*  457 */     return (paramObject1 == paramObject2 || paramObject1.equals(paramObject2));
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
/*      */   protected ReferenceEntry<K, V> createEntry(AbstractHashedMap.HashEntry<K, V> paramHashEntry, int paramInt, K paramK, V paramV) {
/*  472 */     return new ReferenceEntry<K, V>(this, paramHashEntry, paramInt, paramK, paramV);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Iterator<Map.Entry<K, V>> createEntrySetIterator() {
/*  482 */     return new ReferenceEntrySetIterator<K, V>(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Iterator<K> createKeySetIterator() {
/*  492 */     return new ReferenceKeySetIterator<K>(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Iterator<V> createValuesIterator() {
/*  502 */     return new ReferenceValuesIterator<V>(this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class ReferenceEntrySet<K, V>
/*      */     extends AbstractHashedMap.EntrySet<K, V>
/*      */   {
/*      */     protected ReferenceEntrySet(AbstractHashedMap<K, V> param1AbstractHashedMap) {
/*  512 */       super(param1AbstractHashedMap);
/*      */     }
/*      */ 
/*      */     
/*      */     public Object[] toArray() {
/*  517 */       return toArray(new Object[size()]);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public <T> T[] toArray(T[] param1ArrayOfT) {
/*  523 */       ArrayList<DefaultMapEntry> arrayList = new ArrayList(size());
/*  524 */       for (Map.Entry entry : this) {
/*  525 */         arrayList.add(new DefaultMapEntry(entry));
/*      */       }
/*  527 */       return arrayList.toArray(param1ArrayOfT);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class ReferenceKeySet<K>
/*      */     extends AbstractHashedMap.KeySet<K>
/*      */   {
/*      */     protected ReferenceKeySet(AbstractHashedMap<K, ?> param1AbstractHashedMap) {
/*  538 */       super(param1AbstractHashedMap);
/*      */     }
/*      */ 
/*      */     
/*      */     public Object[] toArray() {
/*  543 */       return toArray(new Object[size()]);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public <T> T[] toArray(T[] param1ArrayOfT) {
/*  549 */       ArrayList<K> arrayList = new ArrayList(size());
/*  550 */       for (K k : this) {
/*  551 */         arrayList.add(k);
/*      */       }
/*  553 */       return arrayList.toArray(param1ArrayOfT);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class ReferenceValues<V>
/*      */     extends AbstractHashedMap.Values<V>
/*      */   {
/*      */     protected ReferenceValues(AbstractHashedMap<?, V> param1AbstractHashedMap) {
/*  564 */       super(param1AbstractHashedMap);
/*      */     }
/*      */ 
/*      */     
/*      */     public Object[] toArray() {
/*  569 */       return toArray(new Object[size()]);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public <T> T[] toArray(T[] param1ArrayOfT) {
/*  575 */       ArrayList<V> arrayList = new ArrayList(size());
/*  576 */       for (V v : this) {
/*  577 */         arrayList.add(v);
/*      */       }
/*  579 */       return arrayList.toArray(param1ArrayOfT);
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
/*      */   protected static class ReferenceEntry<K, V>
/*      */     extends AbstractHashedMap.HashEntry<K, V>
/*      */   {
/*      */     private final AbstractReferenceMap<K, V> parent;
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
/*      */     public ReferenceEntry(AbstractReferenceMap<K, V> param1AbstractReferenceMap, AbstractHashedMap.HashEntry<K, V> param1HashEntry, int param1Int, K param1K, V param1V) {
/*  607 */       super(param1HashEntry, param1Int, null, null);
/*  608 */       this.parent = param1AbstractReferenceMap;
/*  609 */       this.key = toReference(param1AbstractReferenceMap.keyType, param1K, param1Int);
/*  610 */       this.value = toReference(param1AbstractReferenceMap.valueType, param1V, param1Int);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public K getKey() {
/*  622 */       return (this.parent.keyType == AbstractReferenceMap.ReferenceStrength.HARD) ? (K)this.key : ((Reference<K>)this.key).get();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public V getValue() {
/*  634 */       return (this.parent.valueType == AbstractReferenceMap.ReferenceStrength.HARD) ? (V)this.value : ((Reference<V>)this.value).get();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public V setValue(V param1V) {
/*  646 */       V v = getValue();
/*  647 */       if (this.parent.valueType != AbstractReferenceMap.ReferenceStrength.HARD) {
/*  648 */         ((Reference)this.value).clear();
/*      */       }
/*  650 */       this.value = toReference(this.parent.valueType, param1V, this.hashCode);
/*  651 */       return v;
/*      */     }
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
/*      */     public boolean equals(Object param1Object) {
/*  665 */       if (param1Object == this) {
/*  666 */         return true;
/*      */       }
/*  668 */       if (!(param1Object instanceof Map.Entry)) {
/*  669 */         return false;
/*      */       }
/*      */       
/*  672 */       Map.Entry entry = (Map.Entry)param1Object;
/*  673 */       Object object1 = entry.getKey();
/*  674 */       Object object2 = entry.getValue();
/*  675 */       if (object1 == null || object2 == null) {
/*  676 */         return false;
/*      */       }
/*      */ 
/*      */       
/*  680 */       return (this.parent.isEqualKey(object1, this.key) && this.parent.isEqualValue(object2, getValue()));
/*      */     }
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
/*      */     public int hashCode() {
/*  693 */       return this.parent.hashEntry(getKey(), getValue());
/*      */     }
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
/*      */     protected <T> Object toReference(AbstractReferenceMap.ReferenceStrength param1ReferenceStrength, T param1T, int param1Int) {
/*  709 */       if (param1ReferenceStrength == AbstractReferenceMap.ReferenceStrength.HARD) {
/*  710 */         return param1T;
/*      */       }
/*  712 */       if (param1ReferenceStrength == AbstractReferenceMap.ReferenceStrength.SOFT) {
/*  713 */         return new AbstractReferenceMap.SoftRef<T>(param1Int, param1T, this.parent.queue);
/*      */       }
/*  715 */       if (param1ReferenceStrength == AbstractReferenceMap.ReferenceStrength.WEAK) {
/*  716 */         return new AbstractReferenceMap.WeakRef<T>(param1Int, param1T, this.parent.queue);
/*      */       }
/*  718 */       throw new Error();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     boolean purge(Reference<?> param1Reference) {
/*  727 */       boolean bool = (this.parent.keyType != AbstractReferenceMap.ReferenceStrength.HARD && this.key == param1Reference) ? true : false;
/*  728 */       bool = (bool || (this.parent.valueType != AbstractReferenceMap.ReferenceStrength.HARD && this.value == param1Reference)) ? true : false;
/*  729 */       if (bool) {
/*  730 */         if (this.parent.keyType != AbstractReferenceMap.ReferenceStrength.HARD) {
/*  731 */           ((Reference)this.key).clear();
/*      */         }
/*  733 */         if (this.parent.valueType != AbstractReferenceMap.ReferenceStrength.HARD) {
/*  734 */           ((Reference)this.value).clear();
/*  735 */         } else if (this.parent.purgeValues) {
/*  736 */           this.value = null;
/*      */         } 
/*      */       } 
/*  739 */       return bool;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected ReferenceEntry<K, V> next() {
/*  748 */       return (ReferenceEntry<K, V>)this.next;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   static class ReferenceBaseIterator<K, V>
/*      */   {
/*      */     final AbstractReferenceMap<K, V> parent;
/*      */     
/*      */     int index;
/*      */     
/*      */     AbstractReferenceMap.ReferenceEntry<K, V> entry;
/*      */     
/*      */     AbstractReferenceMap.ReferenceEntry<K, V> previous;
/*      */     
/*      */     K currentKey;
/*      */     
/*      */     K nextKey;
/*      */     
/*      */     V currentValue;
/*      */     
/*      */     V nextValue;
/*      */     
/*      */     int expectedModCount;
/*      */ 
/*      */     
/*      */     public ReferenceBaseIterator(AbstractReferenceMap<K, V> param1AbstractReferenceMap) {
/*  775 */       this.parent = param1AbstractReferenceMap;
/*  776 */       this.index = (param1AbstractReferenceMap.size() != 0) ? param1AbstractReferenceMap.data.length : 0;
/*      */ 
/*      */       
/*  779 */       this.expectedModCount = param1AbstractReferenceMap.modCount;
/*      */     }
/*      */     
/*      */     public boolean hasNext() {
/*  783 */       checkMod();
/*  784 */       while (nextNull()) {
/*  785 */         AbstractReferenceMap.ReferenceEntry<K, V> referenceEntry = this.entry;
/*  786 */         int i = this.index;
/*  787 */         while (referenceEntry == null && i > 0) {
/*  788 */           i--;
/*  789 */           referenceEntry = (AbstractReferenceMap.ReferenceEntry<K, V>)this.parent.data[i];
/*      */         } 
/*  791 */         this.entry = referenceEntry;
/*  792 */         this.index = i;
/*  793 */         if (referenceEntry == null) {
/*  794 */           this.currentKey = null;
/*  795 */           this.currentValue = null;
/*  796 */           return false;
/*      */         } 
/*  798 */         this.nextKey = referenceEntry.getKey();
/*  799 */         this.nextValue = referenceEntry.getValue();
/*  800 */         if (nextNull()) {
/*  801 */           this.entry = this.entry.next();
/*      */         }
/*      */       } 
/*  804 */       return true;
/*      */     }
/*      */     
/*      */     private void checkMod() {
/*  808 */       if (this.parent.modCount != this.expectedModCount) {
/*  809 */         throw new ConcurrentModificationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private boolean nextNull() {
/*  814 */       return (this.nextKey == null || this.nextValue == null);
/*      */     }
/*      */     
/*      */     protected AbstractReferenceMap.ReferenceEntry<K, V> nextEntry() {
/*  818 */       checkMod();
/*  819 */       if (nextNull() && !hasNext()) {
/*  820 */         throw new NoSuchElementException();
/*      */       }
/*  822 */       this.previous = this.entry;
/*  823 */       this.entry = this.entry.next();
/*  824 */       this.currentKey = this.nextKey;
/*  825 */       this.currentValue = this.nextValue;
/*  826 */       this.nextKey = null;
/*  827 */       this.nextValue = null;
/*  828 */       return this.previous;
/*      */     }
/*      */     
/*      */     protected AbstractReferenceMap.ReferenceEntry<K, V> currentEntry() {
/*  832 */       checkMod();
/*  833 */       return this.previous;
/*      */     }
/*      */     
/*      */     public void remove() {
/*  837 */       checkMod();
/*  838 */       if (this.previous == null) {
/*  839 */         throw new IllegalStateException();
/*      */       }
/*  841 */       this.parent.remove(this.currentKey);
/*  842 */       this.previous = null;
/*  843 */       this.currentKey = null;
/*  844 */       this.currentValue = null;
/*  845 */       this.expectedModCount = this.parent.modCount;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static class ReferenceEntrySetIterator<K, V>
/*      */     extends ReferenceBaseIterator<K, V>
/*      */     implements Iterator<Map.Entry<K, V>>
/*      */   {
/*      */     public ReferenceEntrySetIterator(AbstractReferenceMap<K, V> param1AbstractReferenceMap) {
/*  856 */       super(param1AbstractReferenceMap);
/*      */     }
/*      */     
/*      */     public Map.Entry<K, V> next() {
/*  860 */       return nextEntry();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class ReferenceKeySetIterator<K>
/*      */     extends ReferenceBaseIterator<K, Object>
/*      */     implements Iterator<K>
/*      */   {
/*      */     ReferenceKeySetIterator(AbstractReferenceMap<K, ?> param1AbstractReferenceMap) {
/*  872 */       super((AbstractReferenceMap)param1AbstractReferenceMap);
/*      */     }
/*      */     
/*      */     public K next() {
/*  876 */       return nextEntry().getKey();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static class ReferenceValuesIterator<V>
/*      */     extends ReferenceBaseIterator<Object, V>
/*      */     implements Iterator<V>
/*      */   {
/*      */     ReferenceValuesIterator(AbstractReferenceMap<?, V> param1AbstractReferenceMap) {
/*  887 */       super((AbstractReferenceMap)param1AbstractReferenceMap);
/*      */     }
/*      */     
/*      */     public V next() {
/*  891 */       return nextEntry().getValue();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   static class ReferenceMapIterator<K, V>
/*      */     extends ReferenceBaseIterator<K, V>
/*      */     implements MapIterator<K, V>
/*      */   {
/*      */     protected ReferenceMapIterator(AbstractReferenceMap<K, V> param1AbstractReferenceMap) {
/*  901 */       super(param1AbstractReferenceMap);
/*      */     }
/*      */     
/*      */     public K next() {
/*  905 */       return nextEntry().getKey();
/*      */     }
/*      */     
/*      */     public K getKey() {
/*  909 */       AbstractReferenceMap.ReferenceEntry<K, V> referenceEntry = currentEntry();
/*  910 */       if (referenceEntry == null) {
/*  911 */         throw new IllegalStateException("getKey() can only be called after next() and before remove()");
/*      */       }
/*  913 */       return referenceEntry.getKey();
/*      */     }
/*      */     
/*      */     public V getValue() {
/*  917 */       AbstractReferenceMap.ReferenceEntry<K, V> referenceEntry = currentEntry();
/*  918 */       if (referenceEntry == null) {
/*  919 */         throw new IllegalStateException("getValue() can only be called after next() and before remove()");
/*      */       }
/*  921 */       return referenceEntry.getValue();
/*      */     }
/*      */     
/*      */     public V setValue(V param1V) {
/*  925 */       AbstractReferenceMap.ReferenceEntry<K, V> referenceEntry = currentEntry();
/*  926 */       if (referenceEntry == null) {
/*  927 */         throw new IllegalStateException("setValue() can only be called after next() and before remove()");
/*      */       }
/*  929 */       return referenceEntry.setValue(param1V);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class SoftRef<T>
/*      */     extends SoftReference<T>
/*      */   {
/*      */     private final int hash;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public SoftRef(int param1Int, T param1T, ReferenceQueue<? super T> param1ReferenceQueue) {
/*  946 */       super(param1T, param1ReferenceQueue);
/*  947 */       this.hash = param1Int;
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*  952 */       return this.hash;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   static class WeakRef<T>
/*      */     extends WeakReference<T>
/*      */   {
/*      */     private final int hash;
/*      */ 
/*      */     
/*      */     public WeakRef(int param1Int, T param1T, ReferenceQueue<? super T> param1ReferenceQueue) {
/*  964 */       super(param1T, param1ReferenceQueue);
/*  965 */       this.hash = param1Int;
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*  970 */       return this.hash;
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
/*  996 */     paramObjectOutputStream.writeInt(this.keyType.value);
/*  997 */     paramObjectOutputStream.writeInt(this.valueType.value);
/*  998 */     paramObjectOutputStream.writeBoolean(this.purgeValues);
/*  999 */     paramObjectOutputStream.writeFloat(this.loadFactor);
/* 1000 */     paramObjectOutputStream.writeInt(this.data.length);
/* 1001 */     for (MapIterator<K, V> mapIterator = mapIterator(); mapIterator.hasNext(); ) {
/* 1002 */       paramObjectOutputStream.writeObject(mapIterator.next());
/* 1003 */       paramObjectOutputStream.writeObject(mapIterator.getValue());
/*      */     } 
/* 1005 */     paramObjectOutputStream.writeObject(null);
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
/*      */   
/*      */   protected void doReadObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 1031 */     this.keyType = ReferenceStrength.resolve(paramObjectInputStream.readInt());
/* 1032 */     this.valueType = ReferenceStrength.resolve(paramObjectInputStream.readInt());
/* 1033 */     this.purgeValues = paramObjectInputStream.readBoolean();
/* 1034 */     this.loadFactor = paramObjectInputStream.readFloat();
/* 1035 */     int i = paramObjectInputStream.readInt();
/* 1036 */     init();
/* 1037 */     this.data = (AbstractHashedMap.HashEntry<K, V>[])new AbstractHashedMap.HashEntry[i];
/*      */     while (true) {
/* 1039 */       Object object1 = paramObjectInputStream.readObject();
/* 1040 */       if (object1 == null) {
/*      */         break;
/*      */       }
/* 1043 */       Object object2 = paramObjectInputStream.readObject();
/* 1044 */       put((K)object1, (V)object2);
/*      */     } 
/* 1046 */     this.threshold = calculateThreshold(this.data.length, this.loadFactor);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isKeyType(ReferenceStrength paramReferenceStrength) {
/* 1056 */     return (this.keyType == paramReferenceStrength);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\AbstractReferenceMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */