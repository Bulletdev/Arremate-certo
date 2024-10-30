/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.util.ConcurrentModificationException;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import org.apache.commons.collections4.MapIterator;
/*     */ import org.apache.commons.collections4.OrderedIterator;
/*     */ import org.apache.commons.collections4.OrderedMap;
/*     */ import org.apache.commons.collections4.OrderedMapIterator;
/*     */ import org.apache.commons.collections4.ResettableIterator;
/*     */ import org.apache.commons.collections4.iterators.EmptyOrderedIterator;
/*     */ import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractLinkedMap<K, V>
/*     */   extends AbstractHashedMap<K, V>
/*     */   implements OrderedMap<K, V>
/*     */ {
/*     */   transient LinkEntry<K, V> header;
/*     */   
/*     */   protected AbstractLinkedMap() {}
/*     */   
/*     */   protected AbstractLinkedMap(int paramInt1, float paramFloat, int paramInt2) {
/*  82 */     super(paramInt1, paramFloat, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractLinkedMap(int paramInt) {
/*  92 */     super(paramInt);
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
/*     */   protected AbstractLinkedMap(int paramInt, float paramFloat) {
/* 105 */     super(paramInt, paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractLinkedMap(Map<? extends K, ? extends V> paramMap) {
/* 115 */     super(paramMap);
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
/*     */   protected void init() {
/* 127 */     this.header = createEntry((AbstractHashedMap.HashEntry<K, V>)null, -1, (K)null, (V)null);
/* 128 */     this.header.before = this.header.after = this.header;
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
/*     */   public boolean containsValue(Object paramObject) {
/* 141 */     if (paramObject == null) {
/* 142 */       for (LinkEntry<K, V> linkEntry = this.header.after; linkEntry != this.header; linkEntry = linkEntry.after) {
/* 143 */         if (linkEntry.getValue() == null) {
/* 144 */           return true;
/*     */         }
/*     */       } 
/*     */     } else {
/* 148 */       for (LinkEntry<K, V> linkEntry = this.header.after; linkEntry != this.header; linkEntry = linkEntry.after) {
/* 149 */         if (isEqualValue(paramObject, linkEntry.getValue())) {
/* 150 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/* 154 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 164 */     super.clear();
/* 165 */     this.header.before = this.header.after = this.header;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public K firstKey() {
/* 175 */     if (this.size == 0) {
/* 176 */       throw new NoSuchElementException("Map is empty");
/*     */     }
/* 178 */     return this.header.after.getKey();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public K lastKey() {
/* 187 */     if (this.size == 0) {
/* 188 */       throw new NoSuchElementException("Map is empty");
/*     */     }
/* 190 */     return this.header.before.getKey();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public K nextKey(Object paramObject) {
/* 200 */     LinkEntry<K, V> linkEntry = getEntry(paramObject);
/* 201 */     return (linkEntry == null || linkEntry.after == this.header) ? null : linkEntry.after.getKey();
/*     */   }
/*     */ 
/*     */   
/*     */   protected LinkEntry<K, V> getEntry(Object paramObject) {
/* 206 */     return (LinkEntry<K, V>)super.getEntry(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public K previousKey(Object paramObject) {
/* 216 */     LinkEntry<K, V> linkEntry = getEntry(paramObject);
/* 217 */     return (linkEntry == null || linkEntry.before == this.header) ? null : linkEntry.before.getKey();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected LinkEntry<K, V> getEntry(int paramInt) {
/*     */     LinkEntry<K, V> linkEntry;
/* 229 */     if (paramInt < 0) {
/* 230 */       throw new IndexOutOfBoundsException("Index " + paramInt + " is less than zero");
/*     */     }
/* 232 */     if (paramInt >= this.size) {
/* 233 */       throw new IndexOutOfBoundsException("Index " + paramInt + " is invalid for size " + this.size);
/*     */     }
/*     */     
/* 236 */     if (paramInt < this.size / 2) {
/*     */       
/* 238 */       linkEntry = this.header.after;
/* 239 */       for (byte b = 0; b < paramInt; b++) {
/* 240 */         linkEntry = linkEntry.after;
/*     */       }
/*     */     } else {
/*     */       
/* 244 */       linkEntry = this.header;
/* 245 */       for (int i = this.size; i > paramInt; i--) {
/* 246 */         linkEntry = linkEntry.before;
/*     */       }
/*     */     } 
/* 249 */     return linkEntry;
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
/*     */   protected void addEntry(AbstractHashedMap.HashEntry<K, V> paramHashEntry, int paramInt) {
/* 263 */     LinkEntry<K, V> linkEntry = (LinkEntry)paramHashEntry;
/* 264 */     linkEntry.after = this.header;
/* 265 */     linkEntry.before = this.header.before;
/* 266 */     this.header.before.after = linkEntry;
/* 267 */     this.header.before = linkEntry;
/* 268 */     this.data[paramInt] = linkEntry;
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
/*     */   protected LinkEntry<K, V> createEntry(AbstractHashedMap.HashEntry<K, V> paramHashEntry, int paramInt, K paramK, V paramV) {
/* 284 */     return new LinkEntry<K, V>(paramHashEntry, paramInt, convertKey(paramK), paramV);
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
/*     */   protected void removeEntry(AbstractHashedMap.HashEntry<K, V> paramHashEntry1, int paramInt, AbstractHashedMap.HashEntry<K, V> paramHashEntry2) {
/* 299 */     LinkEntry linkEntry = (LinkEntry)paramHashEntry1;
/* 300 */     linkEntry.before.after = linkEntry.after;
/* 301 */     linkEntry.after.before = linkEntry.before;
/* 302 */     linkEntry.after = null;
/* 303 */     linkEntry.before = null;
/* 304 */     super.removeEntry(paramHashEntry1, paramInt, paramHashEntry2);
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
/*     */   protected LinkEntry<K, V> entryBefore(LinkEntry<K, V> paramLinkEntry) {
/* 318 */     return paramLinkEntry.before;
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
/*     */   protected LinkEntry<K, V> entryAfter(LinkEntry<K, V> paramLinkEntry) {
/* 331 */     return paramLinkEntry.after;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OrderedMapIterator<K, V> mapIterator() {
/* 340 */     if (this.size == 0) {
/* 341 */       return EmptyOrderedMapIterator.emptyOrderedMapIterator();
/*     */     }
/* 343 */     return new LinkMapIterator<K, V>(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class LinkMapIterator<K, V>
/*     */     extends LinkIterator<K, V>
/*     */     implements OrderedMapIterator<K, V>, ResettableIterator<K>
/*     */   {
/*     */     protected LinkMapIterator(AbstractLinkedMap<K, V> param1AbstractLinkedMap) {
/* 353 */       super(param1AbstractLinkedMap);
/*     */     }
/*     */     
/*     */     public K next() {
/* 357 */       return nextEntry().getKey();
/*     */     }
/*     */     
/*     */     public K previous() {
/* 361 */       return previousEntry().getKey();
/*     */     }
/*     */     
/*     */     public K getKey() {
/* 365 */       AbstractLinkedMap.LinkEntry<K, V> linkEntry = currentEntry();
/* 366 */       if (linkEntry == null) {
/* 367 */         throw new IllegalStateException("getKey() can only be called after next() and before remove()");
/*     */       }
/* 369 */       return linkEntry.getKey();
/*     */     }
/*     */     
/*     */     public V getValue() {
/* 373 */       AbstractLinkedMap.LinkEntry<K, V> linkEntry = currentEntry();
/* 374 */       if (linkEntry == null) {
/* 375 */         throw new IllegalStateException("getValue() can only be called after next() and before remove()");
/*     */       }
/* 377 */       return linkEntry.getValue();
/*     */     }
/*     */     
/*     */     public V setValue(V param1V) {
/* 381 */       AbstractLinkedMap.LinkEntry<K, V> linkEntry = currentEntry();
/* 382 */       if (linkEntry == null) {
/* 383 */         throw new IllegalStateException("setValue() can only be called after next() and before remove()");
/*     */       }
/* 385 */       return linkEntry.setValue(param1V);
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
/*     */   protected Iterator<Map.Entry<K, V>> createEntrySetIterator() {
/* 398 */     if (size() == 0) {
/* 399 */       return (Iterator<Map.Entry<K, V>>)EmptyOrderedIterator.emptyOrderedIterator();
/*     */     }
/* 401 */     return (Iterator)new EntrySetIterator<Object, Object>(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class EntrySetIterator<K, V>
/*     */     extends LinkIterator<K, V>
/*     */     implements OrderedIterator<Map.Entry<K, V>>, ResettableIterator<Map.Entry<K, V>>
/*     */   {
/*     */     protected EntrySetIterator(AbstractLinkedMap<K, V> param1AbstractLinkedMap) {
/* 411 */       super(param1AbstractLinkedMap);
/*     */     }
/*     */     
/*     */     public Map.Entry<K, V> next() {
/* 415 */       return nextEntry();
/*     */     }
/*     */     
/*     */     public Map.Entry<K, V> previous() {
/* 419 */       return previousEntry();
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
/*     */   protected Iterator<K> createKeySetIterator() {
/* 432 */     if (size() == 0) {
/* 433 */       return (Iterator<K>)EmptyOrderedIterator.emptyOrderedIterator();
/*     */     }
/* 435 */     return (Iterator<K>)new KeySetIterator(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class KeySetIterator<K>
/*     */     extends LinkIterator<K, Object>
/*     */     implements OrderedIterator<K>, ResettableIterator<K>
/*     */   {
/*     */     protected KeySetIterator(AbstractLinkedMap<K, ?> param1AbstractLinkedMap) {
/* 446 */       super((AbstractLinkedMap)param1AbstractLinkedMap);
/*     */     }
/*     */     
/*     */     public K next() {
/* 450 */       return nextEntry().getKey();
/*     */     }
/*     */     
/*     */     public K previous() {
/* 454 */       return previousEntry().getKey();
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
/*     */   protected Iterator<V> createValuesIterator() {
/* 467 */     if (size() == 0) {
/* 468 */       return (Iterator<V>)EmptyOrderedIterator.emptyOrderedIterator();
/*     */     }
/* 470 */     return (Iterator<V>)new ValuesIterator(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class ValuesIterator<V>
/*     */     extends LinkIterator<Object, V>
/*     */     implements OrderedIterator<V>, ResettableIterator<V>
/*     */   {
/*     */     protected ValuesIterator(AbstractLinkedMap<?, V> param1AbstractLinkedMap) {
/* 481 */       super((AbstractLinkedMap)param1AbstractLinkedMap);
/*     */     }
/*     */     
/*     */     public V next() {
/* 485 */       return nextEntry().getValue();
/*     */     }
/*     */     
/*     */     public V previous() {
/* 489 */       return previousEntry().getValue();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static class LinkEntry<K, V>
/*     */     extends AbstractHashedMap.HashEntry<K, V>
/*     */   {
/*     */     protected LinkEntry<K, V> before;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected LinkEntry<K, V> after;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected LinkEntry(AbstractHashedMap.HashEntry<K, V> param1HashEntry, int param1Int, Object param1Object, V param1V) {
/* 517 */       super(param1HashEntry, param1Int, param1Object, param1V);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static abstract class LinkIterator<K, V>
/*     */   {
/*     */     protected final AbstractLinkedMap<K, V> parent;
/*     */ 
/*     */     
/*     */     protected AbstractLinkedMap.LinkEntry<K, V> last;
/*     */ 
/*     */     
/*     */     protected AbstractLinkedMap.LinkEntry<K, V> next;
/*     */     
/*     */     protected int expectedModCount;
/*     */ 
/*     */     
/*     */     protected LinkIterator(AbstractLinkedMap<K, V> param1AbstractLinkedMap) {
/* 537 */       this.parent = param1AbstractLinkedMap;
/* 538 */       this.next = param1AbstractLinkedMap.header.after;
/* 539 */       this.expectedModCount = param1AbstractLinkedMap.modCount;
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 543 */       return (this.next != this.parent.header);
/*     */     }
/*     */     
/*     */     public boolean hasPrevious() {
/* 547 */       return (this.next.before != this.parent.header);
/*     */     }
/*     */     
/*     */     protected AbstractLinkedMap.LinkEntry<K, V> nextEntry() {
/* 551 */       if (this.parent.modCount != this.expectedModCount) {
/* 552 */         throw new ConcurrentModificationException();
/*     */       }
/* 554 */       if (this.next == this.parent.header) {
/* 555 */         throw new NoSuchElementException("No next() entry in the iteration");
/*     */       }
/* 557 */       this.last = this.next;
/* 558 */       this.next = this.next.after;
/* 559 */       return this.last;
/*     */     }
/*     */     
/*     */     protected AbstractLinkedMap.LinkEntry<K, V> previousEntry() {
/* 563 */       if (this.parent.modCount != this.expectedModCount) {
/* 564 */         throw new ConcurrentModificationException();
/*     */       }
/* 566 */       AbstractLinkedMap.LinkEntry<K, V> linkEntry = this.next.before;
/* 567 */       if (linkEntry == this.parent.header) {
/* 568 */         throw new NoSuchElementException("No previous() entry in the iteration");
/*     */       }
/* 570 */       this.next = linkEntry;
/* 571 */       this.last = linkEntry;
/* 572 */       return this.last;
/*     */     }
/*     */     
/*     */     protected AbstractLinkedMap.LinkEntry<K, V> currentEntry() {
/* 576 */       return this.last;
/*     */     }
/*     */     
/*     */     public void remove() {
/* 580 */       if (this.last == null) {
/* 581 */         throw new IllegalStateException("remove() can only be called once after next()");
/*     */       }
/* 583 */       if (this.parent.modCount != this.expectedModCount) {
/* 584 */         throw new ConcurrentModificationException();
/*     */       }
/* 586 */       this.parent.remove(this.last.getKey());
/* 587 */       this.last = null;
/* 588 */       this.expectedModCount = this.parent.modCount;
/*     */     }
/*     */     
/*     */     public void reset() {
/* 592 */       this.last = null;
/* 593 */       this.next = this.parent.header.after;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 598 */       if (this.last != null) {
/* 599 */         return "Iterator[" + this.last.getKey() + "=" + this.last.getValue() + "]";
/*     */       }
/* 601 */       return "Iterator[]";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\AbstractLinkedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */