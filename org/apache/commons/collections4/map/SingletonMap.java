/*     */ package org.apache.commons.collections4.map;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.AbstractSet;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.collections4.BoundedMap;
/*     */ import org.apache.commons.collections4.KeyValue;
/*     */ import org.apache.commons.collections4.MapIterator;
/*     */ import org.apache.commons.collections4.OrderedMap;
/*     */ import org.apache.commons.collections4.OrderedMapIterator;
/*     */ import org.apache.commons.collections4.ResettableIterator;
/*     */ import org.apache.commons.collections4.iterators.SingletonIterator;
/*     */ import org.apache.commons.collections4.keyvalue.TiedMapEntry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SingletonMap<K, V>
/*     */   implements Serializable, Cloneable, BoundedMap<K, V>, KeyValue<K, V>, OrderedMap<K, V>
/*     */ {
/*     */   private static final long serialVersionUID = -8931271118676803261L;
/*     */   private final K key;
/*     */   private V value;
/*     */   
/*     */   public SingletonMap() {
/*  75 */     this.key = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SingletonMap(K paramK, V paramV) {
/*  86 */     this.key = paramK;
/*  87 */     this.value = paramV;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SingletonMap(KeyValue<K, V> paramKeyValue) {
/*  97 */     this.key = (K)paramKeyValue.getKey();
/*  98 */     this.value = (V)paramKeyValue.getValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SingletonMap(Map.Entry<? extends K, ? extends V> paramEntry) {
/* 108 */     this.key = paramEntry.getKey();
/* 109 */     this.value = paramEntry.getValue();
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
/*     */   public SingletonMap(Map<? extends K, ? extends V> paramMap) {
/* 121 */     if (paramMap.size() != 1) {
/* 122 */       throw new IllegalArgumentException("The map size must be 1");
/*     */     }
/* 124 */     Map.Entry entry = paramMap.entrySet().iterator().next();
/* 125 */     this.key = (K)entry.getKey();
/* 126 */     this.value = (V)entry.getValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public K getKey() {
/* 137 */     return this.key;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V getValue() {
/* 146 */     return this.value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public V setValue(V paramV) {
/* 156 */     V v = this.value;
/* 157 */     this.value = paramV;
/* 158 */     return v;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFull() {
/* 169 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int maxSize() {
/* 178 */     return 1;
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
/*     */   public V get(Object paramObject) {
/* 190 */     if (isEqualKey(paramObject)) {
/* 191 */       return this.value;
/*     */     }
/* 193 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 202 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 211 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/* 222 */     return isEqualKey(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsValue(Object paramObject) {
/* 232 */     return isEqualValue(paramObject);
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
/*     */   public V put(K paramK, V paramV) {
/* 248 */     if (isEqualKey(paramK)) {
/* 249 */       return setValue(paramV);
/*     */     }
/* 251 */     throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size singleton");
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
/*     */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/*     */     Map.Entry entry;
/* 266 */     switch (paramMap.size()) {
/*     */       case 0:
/*     */         return;
/*     */       
/*     */       case 1:
/* 271 */         entry = paramMap.entrySet().iterator().next();
/* 272 */         put((K)entry.getKey(), (V)entry.getValue());
/*     */         return;
/*     */     } 
/*     */     
/* 276 */     throw new IllegalArgumentException("The map size must be 0 or 1");
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
/*     */   public V remove(Object paramObject) {
/* 288 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 295 */     throw new UnsupportedOperationException();
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
/* 307 */     TiedMapEntry tiedMapEntry = new TiedMapEntry((Map)this, getKey());
/* 308 */     return (Set)Collections.singleton(tiedMapEntry);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<K> keySet() {
/* 319 */     return Collections.singleton(this.key);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection<V> values() {
/* 330 */     return new SingletonValues<V>(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OrderedMapIterator<K, V> mapIterator() {
/* 337 */     return new SingletonMapIterator<K, V>(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public K firstKey() {
/* 346 */     return getKey();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public K lastKey() {
/* 355 */     return getKey();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public K nextKey(K paramK) {
/* 365 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public K previousKey(K paramK) {
/* 375 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isEqualKey(Object paramObject) {
/* 386 */     return (paramObject == null) ? ((getKey() == null)) : paramObject.equals(getKey());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isEqualValue(Object paramObject) {
/* 396 */     return (paramObject == null) ? ((getValue() == null)) : paramObject.equals(getValue());
/*     */   }
/*     */ 
/*     */   
/*     */   static class SingletonMapIterator<K, V>
/*     */     implements OrderedMapIterator<K, V>, ResettableIterator<K>
/*     */   {
/*     */     private final SingletonMap<K, V> parent;
/*     */     
/*     */     private boolean hasNext = true;
/*     */     
/*     */     private boolean canGetSet = false;
/*     */     
/*     */     SingletonMapIterator(SingletonMap<K, V> param1SingletonMap) {
/* 410 */       this.parent = param1SingletonMap;
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 414 */       return this.hasNext;
/*     */     }
/*     */     
/*     */     public K next() {
/* 418 */       if (!this.hasNext) {
/* 419 */         throw new NoSuchElementException("No next() entry in the iteration");
/*     */       }
/* 421 */       this.hasNext = false;
/* 422 */       this.canGetSet = true;
/* 423 */       return this.parent.getKey();
/*     */     }
/*     */     
/*     */     public boolean hasPrevious() {
/* 427 */       return !this.hasNext;
/*     */     }
/*     */     
/*     */     public K previous() {
/* 431 */       if (this.hasNext == true) {
/* 432 */         throw new NoSuchElementException("No previous() entry in the iteration");
/*     */       }
/* 434 */       this.hasNext = true;
/* 435 */       return this.parent.getKey();
/*     */     }
/*     */     
/*     */     public void remove() {
/* 439 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public K getKey() {
/* 443 */       if (!this.canGetSet) {
/* 444 */         throw new IllegalStateException("getKey() can only be called after next() and before remove()");
/*     */       }
/* 446 */       return this.parent.getKey();
/*     */     }
/*     */     
/*     */     public V getValue() {
/* 450 */       if (!this.canGetSet) {
/* 451 */         throw new IllegalStateException("getValue() can only be called after next() and before remove()");
/*     */       }
/* 453 */       return this.parent.getValue();
/*     */     }
/*     */     
/*     */     public V setValue(V param1V) {
/* 457 */       if (!this.canGetSet) {
/* 458 */         throw new IllegalStateException("setValue() can only be called after next() and before remove()");
/*     */       }
/* 460 */       return this.parent.setValue(param1V);
/*     */     }
/*     */     
/*     */     public void reset() {
/* 464 */       this.hasNext = true;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 469 */       if (this.hasNext) {
/* 470 */         return "Iterator[]";
/*     */       }
/* 472 */       return "Iterator[" + getKey() + "=" + getValue() + "]";
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class SingletonValues<V>
/*     */     extends AbstractSet<V>
/*     */     implements Serializable
/*     */   {
/*     */     private static final long serialVersionUID = -3689524741863047872L;
/*     */     
/*     */     private final SingletonMap<?, V> parent;
/*     */     
/*     */     SingletonValues(SingletonMap<?, V> param1SingletonMap) {
/* 486 */       this.parent = param1SingletonMap;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 491 */       return 1;
/*     */     }
/*     */     
/*     */     public boolean isEmpty() {
/* 495 */       return false;
/*     */     }
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 499 */       return this.parent.containsValue(param1Object);
/*     */     }
/*     */     
/*     */     public void clear() {
/* 503 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Iterator<V> iterator() {
/* 507 */       return (Iterator<V>)new SingletonIterator(this.parent.getValue(), false);
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
/*     */   public SingletonMap<K, V> clone() {
/*     */     try {
/* 521 */       return (SingletonMap<K, V>)super.clone();
/* 522 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 523 */       throw new InternalError();
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
/* 535 */     if (paramObject == this) {
/* 536 */       return true;
/*     */     }
/* 538 */     if (!(paramObject instanceof Map)) {
/* 539 */       return false;
/*     */     }
/* 541 */     Map map = (Map)paramObject;
/* 542 */     if (map.size() != 1) {
/* 543 */       return false;
/*     */     }
/* 545 */     Map.Entry entry = map.entrySet().iterator().next();
/* 546 */     return (isEqualKey(entry.getKey()) && isEqualValue(entry.getValue()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 556 */     return ((getKey() == null) ? 0 : getKey().hashCode()) ^ ((getValue() == null) ? 0 : getValue().hashCode());
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
/* 567 */     return (new StringBuilder(128)).append('{').append((getKey() == this) ? "(this Map)" : getKey()).append('=').append((getValue() == this) ? "(this Map)" : getValue()).append('}').toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\SingletonMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */