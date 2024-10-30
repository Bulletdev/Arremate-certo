/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.util.AbstractCollection;
/*     */ import java.util.AbstractSet;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.KeyValue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class StaticBucketMap<K, V>
/*     */   extends AbstractIterableMap<K, V>
/*     */ {
/*     */   private static final int DEFAULT_BUCKETS = 255;
/*     */   private final Node<K, V>[] buckets;
/*     */   private final Lock[] locks;
/*     */   
/*     */   public StaticBucketMap() {
/* 109 */     this(255);
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
/*     */   public StaticBucketMap(int paramInt) {
/* 124 */     int i = Math.max(17, paramInt);
/*     */ 
/*     */     
/* 127 */     if (i % 2 == 0) {
/* 128 */       i--;
/*     */     }
/*     */     
/* 131 */     this.buckets = (Node<K, V>[])new Node[i];
/* 132 */     this.locks = new Lock[i];
/*     */     
/* 134 */     for (byte b = 0; b < i; b++) {
/* 135 */       this.locks[b] = new Lock();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int getHash(Object paramObject) {
/* 154 */     if (paramObject == null) {
/* 155 */       return 0;
/*     */     }
/* 157 */     int i = paramObject.hashCode();
/* 158 */     i += i << 15 ^ 0xFFFFFFFF;
/* 159 */     i ^= i >>> 10;
/* 160 */     i += i << 3;
/* 161 */     i ^= i >>> 6;
/* 162 */     i += i << 11 ^ 0xFFFFFFFF;
/* 163 */     i ^= i >>> 16;
/* 164 */     i %= this.buckets.length;
/* 165 */     return (i < 0) ? (i * -1) : i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 175 */     int i = 0;
/*     */     
/* 177 */     for (byte b = 0; b < this.buckets.length; b++) {
/* 178 */       synchronized (this.locks[b]) {
/* 179 */         i += (this.locks[b]).size;
/*     */       } 
/*     */     } 
/* 182 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 191 */     return (size() == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V get(Object paramObject) {
/* 201 */     int i = getHash(paramObject);
/*     */     
/* 203 */     synchronized (this.locks[i]) {
/* 204 */       Node<K, V> node = this.buckets[i];
/*     */       
/* 206 */       while (node != null) {
/* 207 */         if (node.key == paramObject || (node.key != null && node.key.equals(paramObject))) {
/* 208 */           return node.value;
/*     */         }
/*     */         
/* 211 */         node = node.next;
/*     */       } 
/*     */     } 
/* 214 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/* 224 */     int i = getHash(paramObject);
/*     */     
/* 226 */     synchronized (this.locks[i]) {
/* 227 */       Node<K, V> node = this.buckets[i];
/*     */       
/* 229 */       while (node != null) {
/* 230 */         if (node.key == paramObject || (node.key != null && node.key.equals(paramObject))) {
/* 231 */           return true;
/*     */         }
/*     */         
/* 234 */         node = node.next;
/*     */       } 
/*     */     } 
/* 237 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsValue(Object paramObject) {
/* 247 */     for (byte b = 0; b < this.buckets.length; b++) {
/* 248 */       synchronized (this.locks[b]) {
/* 249 */         Node<K, V> node = this.buckets[b];
/*     */         
/* 251 */         while (node != null) {
/* 252 */           if (node.value == paramObject || (node.value != null && node.value.equals(paramObject))) {
/* 253 */             return true;
/*     */           }
/*     */           
/* 256 */           node = node.next;
/*     */         } 
/*     */       } 
/*     */     } 
/* 260 */     return false;
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
/*     */   public V put(K paramK, V paramV) {
/* 272 */     int i = getHash(paramK);
/*     */     
/* 274 */     synchronized (this.locks[i]) {
/* 275 */       Node<K, V> node1 = this.buckets[i];
/*     */       
/* 277 */       if (node1 == null) {
/* 278 */         node1 = new Node<K, V>();
/* 279 */         node1.key = paramK;
/* 280 */         node1.value = paramV;
/* 281 */         this.buckets[i] = node1;
/* 282 */         (this.locks[i]).size++;
/* 283 */         return null;
/*     */       } 
/*     */ 
/*     */       
/*     */       Node<K, V> node2;
/*     */       
/* 289 */       for (node2 = node1; node2 != null; node2 = node2.next) {
/* 290 */         node1 = node2;
/*     */         
/* 292 */         if (node1.key == paramK || (node1.key != null && node1.key.equals(paramK))) {
/* 293 */           V v = node1.value;
/* 294 */           node1.value = paramV;
/* 295 */           return v;
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 301 */       node2 = new Node<K, V>();
/* 302 */       node2.key = paramK;
/* 303 */       node2.value = paramV;
/* 304 */       node1.next = node2;
/* 305 */       (this.locks[i]).size++;
/*     */     } 
/* 307 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V remove(Object paramObject) {
/* 317 */     int i = getHash(paramObject);
/*     */     
/* 319 */     synchronized (this.locks[i]) {
/* 320 */       Node<K, V> node1 = this.buckets[i];
/* 321 */       Node<K, V> node2 = null;
/*     */       
/* 323 */       while (node1 != null) {
/* 324 */         if (node1.key == paramObject || (node1.key != null && node1.key.equals(paramObject))) {
/*     */           
/* 326 */           if (null == node2) {
/*     */             
/* 328 */             this.buckets[i] = node1.next;
/*     */           } else {
/*     */             
/* 331 */             node2.next = node1.next;
/*     */           } 
/* 333 */           (this.locks[i]).size--;
/* 334 */           return node1.value;
/*     */         } 
/*     */         
/* 337 */         node2 = node1;
/* 338 */         node1 = node1.next;
/*     */       } 
/*     */     } 
/* 341 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<K> keySet() {
/* 351 */     return new KeySet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<V> values() {
/* 360 */     return new Values();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<K, V>> entrySet() {
/* 369 */     return new EntrySet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/* 380 */     for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet()) {
/* 381 */       put((K)entry.getKey(), (V)entry.getValue());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 389 */     for (byte b = 0; b < this.buckets.length; b++) {
/* 390 */       Lock lock = this.locks[b];
/* 391 */       synchronized (lock) {
/* 392 */         this.buckets[b] = null;
/* 393 */         lock.size = 0;
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
/*     */   public boolean equals(Object paramObject) {
/* 406 */     if (paramObject == this) {
/* 407 */       return true;
/*     */     }
/* 409 */     if (!(paramObject instanceof Map)) {
/* 410 */       return false;
/*     */     }
/* 412 */     Map map = (Map)paramObject;
/* 413 */     return entrySet().equals(map.entrySet());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 423 */     int i = 0;
/*     */     
/* 425 */     for (byte b = 0; b < this.buckets.length; b++) {
/* 426 */       synchronized (this.locks[b]) {
/* 427 */         Node<K, V> node = this.buckets[b];
/*     */         
/* 429 */         while (node != null) {
/* 430 */           i += node.hashCode();
/* 431 */           node = node.next;
/*     */         } 
/*     */       } 
/*     */     } 
/* 435 */     return i;
/*     */   }
/*     */   
/*     */   private static final class Node<K, V>
/*     */     implements Map.Entry<K, V>, KeyValue<K, V>
/*     */   {
/*     */     protected K key;
/*     */     protected V value;
/*     */     protected Node<K, V> next;
/*     */     
/*     */     private Node() {}
/*     */     
/*     */     public K getKey() {
/* 448 */       return this.key;
/*     */     }
/*     */     
/*     */     public V getValue() {
/* 452 */       return this.value;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 457 */       return ((this.key == null) ? 0 : this.key.hashCode()) ^ ((this.value == null) ? 0 : this.value.hashCode());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 463 */       if (param1Object == this) {
/* 464 */         return true;
/*     */       }
/* 466 */       if (!(param1Object instanceof Map.Entry)) {
/* 467 */         return false;
/*     */       }
/*     */       
/* 470 */       Map.Entry entry = (Map.Entry)param1Object;
/* 471 */       return (((this.key == null) ? (entry.getKey() == null) : this.key.equals(entry.getKey())) && ((this.value == null) ? (entry.getValue() == null) : this.value.equals(entry.getValue())));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public V setValue(V param1V) {
/* 477 */       V v = this.value;
/* 478 */       this.value = param1V;
/* 479 */       return v;
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class Lock
/*     */   {
/*     */     public int size;
/*     */     
/*     */     private Lock() {}
/*     */   }
/*     */   
/*     */   private class BaseIterator
/*     */   {
/* 492 */     private final ArrayList<Map.Entry<K, V>> current = new ArrayList<Map.Entry<K, V>>();
/*     */     private int bucket;
/*     */     private Map.Entry<K, V> last;
/*     */     
/*     */     public boolean hasNext() {
/* 497 */       if (this.current.size() > 0) {
/* 498 */         return true;
/*     */       }
/* 500 */       while (this.bucket < StaticBucketMap.this.buckets.length) {
/* 501 */         synchronized (StaticBucketMap.this.locks[this.bucket]) {
/* 502 */           StaticBucketMap.Node<K, V> node = StaticBucketMap.this.buckets[this.bucket];
/* 503 */           while (node != null) {
/* 504 */             this.current.add(node);
/* 505 */             node = node.next;
/*     */           } 
/* 507 */           this.bucket++;
/* 508 */           if (this.current.size() > 0) {
/* 509 */             return true;
/*     */           }
/*     */         } 
/*     */       } 
/* 513 */       return false;
/*     */     }
/*     */     
/*     */     protected Map.Entry<K, V> nextEntry() {
/* 517 */       if (!hasNext()) {
/* 518 */         throw new NoSuchElementException();
/*     */       }
/* 520 */       this.last = this.current.remove(this.current.size() - 1);
/* 521 */       return this.last;
/*     */     }
/*     */     
/*     */     public void remove() {
/* 525 */       if (this.last == null) {
/* 526 */         throw new IllegalStateException();
/*     */       }
/* 528 */       StaticBucketMap.this.remove(this.last.getKey());
/* 529 */       this.last = null;
/*     */     }
/*     */     
/*     */     private BaseIterator() {}
/*     */   }
/*     */   
/*     */   private class EntryIterator extends BaseIterator implements Iterator<Map.Entry<K, V>> { public Map.Entry<K, V> next() {
/* 536 */       return nextEntry();
/*     */     }
/*     */     
/*     */     private EntryIterator() {} }
/*     */ 
/*     */   
/*     */   private class ValueIterator extends BaseIterator implements Iterator<V> {
/*     */     public V next() {
/* 544 */       return nextEntry().getValue();
/*     */     }
/*     */     
/*     */     private ValueIterator() {} }
/*     */   
/*     */   private class KeyIterator extends BaseIterator implements Iterator<K> { private KeyIterator() {}
/*     */     
/*     */     public K next() {
/* 552 */       return nextEntry().getKey();
/*     */     } }
/*     */ 
/*     */   
/*     */   private class EntrySet
/*     */     extends AbstractSet<Map.Entry<K, V>> {
/*     */     private EntrySet() {}
/*     */     
/*     */     public int size() {
/* 561 */       return StaticBucketMap.this.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 566 */       StaticBucketMap.this.clear();
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<Map.Entry<K, V>> iterator() {
/* 571 */       return new StaticBucketMap.EntryIterator();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 576 */       Map.Entry entry = (Map.Entry)param1Object;
/* 577 */       int i = StaticBucketMap.this.getHash(entry.getKey());
/* 578 */       synchronized (StaticBucketMap.this.locks[i]) {
/* 579 */         for (StaticBucketMap.Node node = StaticBucketMap.this.buckets[i]; node != null; node = node.next) {
/* 580 */           if (node.equals(entry)) {
/* 581 */             return true;
/*     */           }
/*     */         } 
/*     */       } 
/* 585 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean remove(Object param1Object) {
/* 590 */       if (!(param1Object instanceof Map.Entry)) {
/* 591 */         return false;
/*     */       }
/* 593 */       Map.Entry entry = (Map.Entry)param1Object;
/* 594 */       int i = StaticBucketMap.this.getHash(entry.getKey());
/* 595 */       synchronized (StaticBucketMap.this.locks[i]) {
/* 596 */         for (StaticBucketMap.Node node = StaticBucketMap.this.buckets[i]; node != null; node = node.next) {
/* 597 */           if (node.equals(entry)) {
/* 598 */             StaticBucketMap.this.remove(node.getKey());
/* 599 */             return true;
/*     */           } 
/*     */         } 
/*     */       } 
/* 603 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   private class KeySet
/*     */     extends AbstractSet<K> {
/*     */     private KeySet() {}
/*     */     
/*     */     public int size() {
/* 612 */       return StaticBucketMap.this.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 617 */       StaticBucketMap.this.clear();
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<K> iterator() {
/* 622 */       return new StaticBucketMap.KeyIterator();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 627 */       return StaticBucketMap.this.containsKey(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean remove(Object param1Object) {
/* 632 */       int i = StaticBucketMap.this.getHash(param1Object);
/* 633 */       synchronized (StaticBucketMap.this.locks[i]) {
/* 634 */         for (StaticBucketMap.Node node = StaticBucketMap.this.buckets[i]; node != null; node = node.next) {
/* 635 */           Object object = node.getKey();
/* 636 */           if (object == param1Object || (object != null && object.equals(param1Object))) {
/* 637 */             StaticBucketMap.this.remove(object);
/* 638 */             return true;
/*     */           } 
/*     */         } 
/*     */       } 
/* 642 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   private class Values
/*     */     extends AbstractCollection<V>
/*     */   {
/*     */     private Values() {}
/*     */     
/*     */     public int size() {
/* 652 */       return StaticBucketMap.this.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 657 */       StaticBucketMap.this.clear();
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterator<V> iterator() {
/* 662 */       return new StaticBucketMap.ValueIterator();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void atomic(Runnable paramRunnable) {
/* 702 */     if (paramRunnable == null) {
/* 703 */       throw new NullPointerException();
/*     */     }
/* 705 */     atomic(paramRunnable, 0);
/*     */   }
/*     */   
/*     */   private void atomic(Runnable paramRunnable, int paramInt) {
/* 709 */     if (paramInt >= this.buckets.length) {
/* 710 */       paramRunnable.run();
/*     */       return;
/*     */     } 
/* 713 */     synchronized (this.locks[paramInt]) {
/* 714 */       atomic(paramRunnable, paramInt + 1);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\StaticBucketMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */