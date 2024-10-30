/*      */ package org.apache.commons.collections4.map;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.io.ObjectOutputStream;
/*      */ import java.io.Serializable;
/*      */ import java.util.AbstractCollection;
/*      */ import java.util.AbstractSet;
/*      */ import java.util.Collection;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.NoSuchElementException;
/*      */ import java.util.Set;
/*      */ import org.apache.commons.collections4.IterableMap;
/*      */ import org.apache.commons.collections4.MapIterator;
/*      */ import org.apache.commons.collections4.ResettableIterator;
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
/*      */ public class Flat3Map<K, V>
/*      */   implements Serializable, Cloneable, IterableMap<K, V>
/*      */ {
/*      */   private static final long serialVersionUID = -6701087419741928296L;
/*      */   private transient int size;
/*      */   private transient int hash1;
/*      */   private transient int hash2;
/*      */   private transient int hash3;
/*      */   private transient K key1;
/*      */   private transient K key2;
/*      */   private transient K key3;
/*      */   private transient V value1;
/*      */   private transient V value2;
/*      */   private transient V value3;
/*      */   private transient AbstractHashedMap<K, V> delegateMap;
/*      */   
/*      */   public Flat3Map() {}
/*      */   
/*      */   public Flat3Map(Map<? extends K, ? extends V> paramMap) {
/*  116 */     putAll(paramMap);
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
/*  127 */     if (this.delegateMap != null) {
/*  128 */       return this.delegateMap.get(paramObject);
/*      */     }
/*  130 */     if (paramObject == null) {
/*  131 */       switch (this.size) {
/*      */         
/*      */         case 3:
/*  134 */           if (this.key3 == null) {
/*  135 */             return this.value3;
/*      */           }
/*      */         case 2:
/*  138 */           if (this.key2 == null) {
/*  139 */             return this.value2;
/*      */           }
/*      */         case 1:
/*  142 */           if (this.key1 == null) {
/*  143 */             return this.value1;
/*      */           }
/*      */           break;
/*      */       } 
/*  147 */     } else if (this.size > 0) {
/*  148 */       int i = paramObject.hashCode();
/*  149 */       switch (this.size) {
/*      */         
/*      */         case 3:
/*  152 */           if (this.hash3 == i && paramObject.equals(this.key3)) {
/*  153 */             return this.value3;
/*      */           }
/*      */         case 2:
/*  156 */           if (this.hash2 == i && paramObject.equals(this.key2)) {
/*  157 */             return this.value2;
/*      */           }
/*      */         case 1:
/*  160 */           if (this.hash1 == i && paramObject.equals(this.key1)) {
/*  161 */             return this.value1;
/*      */           }
/*      */           break;
/*      */       } 
/*      */     } 
/*  166 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int size() {
/*  175 */     if (this.delegateMap != null) {
/*  176 */       return this.delegateMap.size();
/*      */     }
/*  178 */     return this.size;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmpty() {
/*  187 */     return (size() == 0);
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
/*  198 */     if (this.delegateMap != null) {
/*  199 */       return this.delegateMap.containsKey(paramObject);
/*      */     }
/*  201 */     if (paramObject == null) {
/*  202 */       switch (this.size) {
/*      */         case 3:
/*  204 */           if (this.key3 == null) {
/*  205 */             return true;
/*      */           }
/*      */         case 2:
/*  208 */           if (this.key2 == null) {
/*  209 */             return true;
/*      */           }
/*      */         case 1:
/*  212 */           if (this.key1 == null) {
/*  213 */             return true;
/*      */           }
/*      */           break;
/*      */       } 
/*  217 */     } else if (this.size > 0) {
/*  218 */       int i = paramObject.hashCode();
/*  219 */       switch (this.size) {
/*      */         case 3:
/*  221 */           if (this.hash3 == i && paramObject.equals(this.key3)) {
/*  222 */             return true;
/*      */           }
/*      */         case 2:
/*  225 */           if (this.hash2 == i && paramObject.equals(this.key2)) {
/*  226 */             return true;
/*      */           }
/*      */         case 1:
/*  229 */           if (this.hash1 == i && paramObject.equals(this.key1)) {
/*  230 */             return true;
/*      */           }
/*      */           break;
/*      */       } 
/*      */     } 
/*  235 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean containsValue(Object paramObject) {
/*  245 */     if (this.delegateMap != null) {
/*  246 */       return this.delegateMap.containsValue(paramObject);
/*      */     }
/*  248 */     if (paramObject == null) {
/*  249 */       switch (this.size) {
/*      */         case 3:
/*  251 */           if (this.value3 == null) {
/*  252 */             return true;
/*      */           }
/*      */         case 2:
/*  255 */           if (this.value2 == null) {
/*  256 */             return true;
/*      */           }
/*      */         case 1:
/*  259 */           if (this.value1 == null)
/*  260 */             return true; 
/*      */           break;
/*      */       } 
/*      */     } else {
/*  264 */       switch (this.size) {
/*      */         case 3:
/*  266 */           if (paramObject.equals(this.value3)) {
/*  267 */             return true;
/*      */           }
/*      */         case 2:
/*  270 */           if (paramObject.equals(this.value2)) {
/*  271 */             return true;
/*      */           }
/*      */         case 1:
/*  274 */           if (paramObject.equals(this.value1))
/*  275 */             return true; 
/*      */           break;
/*      */       } 
/*      */     } 
/*  279 */     return false;
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
/*      */   public V put(K paramK, V paramV) {
/*  291 */     if (this.delegateMap != null) {
/*  292 */       return this.delegateMap.put(paramK, paramV);
/*      */     }
/*      */     
/*  295 */     if (paramK == null) {
/*  296 */       switch (this.size) {
/*      */         case 3:
/*  298 */           if (this.key3 == null) {
/*  299 */             V v = this.value3;
/*  300 */             this.value3 = paramV;
/*  301 */             return v;
/*      */           } 
/*      */         case 2:
/*  304 */           if (this.key2 == null) {
/*  305 */             V v = this.value2;
/*  306 */             this.value2 = paramV;
/*  307 */             return v;
/*      */           } 
/*      */         case 1:
/*  310 */           if (this.key1 == null) {
/*  311 */             V v = this.value1;
/*  312 */             this.value1 = paramV;
/*  313 */             return v;
/*      */           } 
/*      */           break;
/*      */       } 
/*  317 */     } else if (this.size > 0) {
/*  318 */       int i = paramK.hashCode();
/*  319 */       switch (this.size) {
/*      */         case 3:
/*  321 */           if (this.hash3 == i && paramK.equals(this.key3)) {
/*  322 */             V v = this.value3;
/*  323 */             this.value3 = paramV;
/*  324 */             return v;
/*      */           } 
/*      */         case 2:
/*  327 */           if (this.hash2 == i && paramK.equals(this.key2)) {
/*  328 */             V v = this.value2;
/*  329 */             this.value2 = paramV;
/*  330 */             return v;
/*      */           } 
/*      */         case 1:
/*  333 */           if (this.hash1 == i && paramK.equals(this.key1)) {
/*  334 */             V v = this.value1;
/*  335 */             this.value1 = paramV;
/*  336 */             return v;
/*      */           } 
/*      */           break;
/*      */       } 
/*      */ 
/*      */     
/*      */     } 
/*  343 */     switch (this.size)
/*      */     { default:
/*  345 */         convertToMap();
/*  346 */         this.delegateMap.put(paramK, paramV);
/*  347 */         return null;
/*      */       case 2:
/*  349 */         this.hash3 = (paramK == null) ? 0 : paramK.hashCode();
/*  350 */         this.key3 = paramK;
/*  351 */         this.value3 = paramV;
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
/*  364 */         this.size++;
/*  365 */         return null;case 1: this.hash2 = (paramK == null) ? 0 : paramK.hashCode(); this.key2 = paramK; this.value2 = paramV; this.size++; return null;case 0: break; }  this.hash1 = (paramK == null) ? 0 : paramK.hashCode(); this.key1 = paramK; this.value1 = paramV; this.size++; return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/*  375 */     int i = paramMap.size();
/*  376 */     if (i == 0) {
/*      */       return;
/*      */     }
/*  379 */     if (this.delegateMap != null) {
/*  380 */       this.delegateMap.putAll(paramMap);
/*      */       return;
/*      */     } 
/*  383 */     if (i < 4) {
/*  384 */       for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet()) {
/*  385 */         put((K)entry.getKey(), (V)entry.getValue());
/*      */       }
/*      */     } else {
/*  388 */       convertToMap();
/*  389 */       this.delegateMap.putAll(paramMap);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void convertToMap() {
/*  397 */     this.delegateMap = createDelegateMap();
/*  398 */     switch (this.size) {
/*      */       case 3:
/*  400 */         this.delegateMap.put(this.key3, this.value3);
/*      */       case 2:
/*  402 */         this.delegateMap.put(this.key2, this.value2);
/*      */       case 1:
/*  404 */         this.delegateMap.put(this.key1, this.value1); break;
/*      */       case 0:
/*      */         break;
/*      */       default:
/*  408 */         throw new IllegalStateException("Invalid map index: " + this.size);
/*      */     } 
/*      */     
/*  411 */     this.size = 0;
/*  412 */     this.hash1 = this.hash2 = this.hash3 = 0;
/*  413 */     this.key1 = this.key2 = this.key3 = null;
/*  414 */     this.value1 = this.value2 = this.value3 = null;
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
/*      */   protected AbstractHashedMap<K, V> createDelegateMap() {
/*  428 */     return new HashedMap<K, V>();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public V remove(Object paramObject) {
/*  438 */     if (this.delegateMap != null) {
/*  439 */       return this.delegateMap.remove(paramObject);
/*      */     }
/*  441 */     if (this.size == 0) {
/*  442 */       return null;
/*      */     }
/*  444 */     if (paramObject == null) {
/*  445 */       switch (this.size) {
/*      */         case 3:
/*  447 */           if (this.key3 == null) {
/*  448 */             V v = this.value3;
/*  449 */             this.hash3 = 0;
/*  450 */             this.key3 = null;
/*  451 */             this.value3 = null;
/*  452 */             this.size = 2;
/*  453 */             return v;
/*      */           } 
/*  455 */           if (this.key2 == null) {
/*  456 */             V v = this.value2;
/*  457 */             this.hash2 = this.hash3;
/*  458 */             this.key2 = this.key3;
/*  459 */             this.value2 = this.value3;
/*  460 */             this.hash3 = 0;
/*  461 */             this.key3 = null;
/*  462 */             this.value3 = null;
/*  463 */             this.size = 2;
/*  464 */             return v;
/*      */           } 
/*  466 */           if (this.key1 == null) {
/*  467 */             V v = this.value1;
/*  468 */             this.hash1 = this.hash3;
/*  469 */             this.key1 = this.key3;
/*  470 */             this.value1 = this.value3;
/*  471 */             this.hash3 = 0;
/*  472 */             this.key3 = null;
/*  473 */             this.value3 = null;
/*  474 */             this.size = 2;
/*  475 */             return v;
/*      */           } 
/*  477 */           return null;
/*      */         case 2:
/*  479 */           if (this.key2 == null) {
/*  480 */             V v = this.value2;
/*  481 */             this.hash2 = 0;
/*  482 */             this.key2 = null;
/*  483 */             this.value2 = null;
/*  484 */             this.size = 1;
/*  485 */             return v;
/*      */           } 
/*  487 */           if (this.key1 == null) {
/*  488 */             V v = this.value1;
/*  489 */             this.hash1 = this.hash2;
/*  490 */             this.key1 = this.key2;
/*  491 */             this.value1 = this.value2;
/*  492 */             this.hash2 = 0;
/*  493 */             this.key2 = null;
/*  494 */             this.value2 = null;
/*  495 */             this.size = 1;
/*  496 */             return v;
/*      */           } 
/*  498 */           return null;
/*      */         case 1:
/*  500 */           if (this.key1 == null) {
/*  501 */             V v = this.value1;
/*  502 */             this.hash1 = 0;
/*  503 */             this.key1 = null;
/*  504 */             this.value1 = null;
/*  505 */             this.size = 0;
/*  506 */             return v;
/*      */           } 
/*      */           break;
/*      */       } 
/*  510 */     } else if (this.size > 0) {
/*  511 */       int i = paramObject.hashCode();
/*  512 */       switch (this.size) {
/*      */         case 3:
/*  514 */           if (this.hash3 == i && paramObject.equals(this.key3)) {
/*  515 */             V v = this.value3;
/*  516 */             this.hash3 = 0;
/*  517 */             this.key3 = null;
/*  518 */             this.value3 = null;
/*  519 */             this.size = 2;
/*  520 */             return v;
/*      */           } 
/*  522 */           if (this.hash2 == i && paramObject.equals(this.key2)) {
/*  523 */             V v = this.value2;
/*  524 */             this.hash2 = this.hash3;
/*  525 */             this.key2 = this.key3;
/*  526 */             this.value2 = this.value3;
/*  527 */             this.hash3 = 0;
/*  528 */             this.key3 = null;
/*  529 */             this.value3 = null;
/*  530 */             this.size = 2;
/*  531 */             return v;
/*      */           } 
/*  533 */           if (this.hash1 == i && paramObject.equals(this.key1)) {
/*  534 */             V v = this.value1;
/*  535 */             this.hash1 = this.hash3;
/*  536 */             this.key1 = this.key3;
/*  537 */             this.value1 = this.value3;
/*  538 */             this.hash3 = 0;
/*  539 */             this.key3 = null;
/*  540 */             this.value3 = null;
/*  541 */             this.size = 2;
/*  542 */             return v;
/*      */           } 
/*  544 */           return null;
/*      */         case 2:
/*  546 */           if (this.hash2 == i && paramObject.equals(this.key2)) {
/*  547 */             V v = this.value2;
/*  548 */             this.hash2 = 0;
/*  549 */             this.key2 = null;
/*  550 */             this.value2 = null;
/*  551 */             this.size = 1;
/*  552 */             return v;
/*      */           } 
/*  554 */           if (this.hash1 == i && paramObject.equals(this.key1)) {
/*  555 */             V v = this.value1;
/*  556 */             this.hash1 = this.hash2;
/*  557 */             this.key1 = this.key2;
/*  558 */             this.value1 = this.value2;
/*  559 */             this.hash2 = 0;
/*  560 */             this.key2 = null;
/*  561 */             this.value2 = null;
/*  562 */             this.size = 1;
/*  563 */             return v;
/*      */           } 
/*  565 */           return null;
/*      */         case 1:
/*  567 */           if (this.hash1 == i && paramObject.equals(this.key1)) {
/*  568 */             V v = this.value1;
/*  569 */             this.hash1 = 0;
/*  570 */             this.key1 = null;
/*  571 */             this.value1 = null;
/*  572 */             this.size = 0;
/*  573 */             return v;
/*      */           } 
/*      */           break;
/*      */       } 
/*      */     } 
/*  578 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void clear() {
/*  586 */     if (this.delegateMap != null) {
/*  587 */       this.delegateMap.clear();
/*  588 */       this.delegateMap = null;
/*      */     } else {
/*  590 */       this.size = 0;
/*  591 */       this.hash1 = this.hash2 = this.hash3 = 0;
/*  592 */       this.key1 = this.key2 = this.key3 = null;
/*  593 */       this.value1 = this.value2 = this.value3 = null;
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
/*      */   public MapIterator<K, V> mapIterator() {
/*  610 */     if (this.delegateMap != null) {
/*  611 */       return this.delegateMap.mapIterator();
/*      */     }
/*  613 */     if (this.size == 0) {
/*  614 */       return EmptyMapIterator.emptyMapIterator();
/*      */     }
/*  616 */     return new FlatMapIterator<K, V>(this);
/*      */   }
/*      */ 
/*      */   
/*      */   static class FlatMapIterator<K, V>
/*      */     implements MapIterator<K, V>, ResettableIterator<K>
/*      */   {
/*      */     private final Flat3Map<K, V> parent;
/*  624 */     private int nextIndex = 0;
/*      */     
/*      */     private boolean canRemove = false;
/*      */     
/*      */     FlatMapIterator(Flat3Map<K, V> param1Flat3Map) {
/*  629 */       this.parent = param1Flat3Map;
/*      */     }
/*      */     
/*      */     public boolean hasNext() {
/*  633 */       return (this.nextIndex < this.parent.size);
/*      */     }
/*      */     
/*      */     public K next() {
/*  637 */       if (!hasNext()) {
/*  638 */         throw new NoSuchElementException("No next() entry in the iteration");
/*      */       }
/*  640 */       this.canRemove = true;
/*  641 */       this.nextIndex++;
/*  642 */       return getKey();
/*      */     }
/*      */     
/*      */     public void remove() {
/*  646 */       if (!this.canRemove) {
/*  647 */         throw new IllegalStateException("remove() can only be called once after next()");
/*      */       }
/*  649 */       this.parent.remove(getKey());
/*  650 */       this.nextIndex--;
/*  651 */       this.canRemove = false;
/*      */     }
/*      */     
/*      */     public K getKey() {
/*  655 */       if (!this.canRemove) {
/*  656 */         throw new IllegalStateException("getKey() can only be called after next() and before remove()");
/*      */       }
/*  658 */       switch (this.nextIndex) {
/*      */         case 3:
/*  660 */           return this.parent.key3;
/*      */         case 2:
/*  662 */           return this.parent.key2;
/*      */         case 1:
/*  664 */           return this.parent.key1;
/*      */       } 
/*  666 */       throw new IllegalStateException("Invalid map index: " + this.nextIndex);
/*      */     }
/*      */     
/*      */     public V getValue() {
/*  670 */       if (!this.canRemove) {
/*  671 */         throw new IllegalStateException("getValue() can only be called after next() and before remove()");
/*      */       }
/*  673 */       switch (this.nextIndex) {
/*      */         case 3:
/*  675 */           return this.parent.value3;
/*      */         case 2:
/*  677 */           return this.parent.value2;
/*      */         case 1:
/*  679 */           return this.parent.value1;
/*      */       } 
/*  681 */       throw new IllegalStateException("Invalid map index: " + this.nextIndex);
/*      */     }
/*      */     
/*      */     public V setValue(V param1V) {
/*  685 */       if (!this.canRemove) {
/*  686 */         throw new IllegalStateException("setValue() can only be called after next() and before remove()");
/*      */       }
/*  688 */       V v = getValue();
/*  689 */       switch (this.nextIndex) {
/*      */         case 3:
/*  691 */           this.parent.value3 = param1V;
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
/*  702 */           return v;case 2: this.parent.value2 = param1V; return v;case 1: this.parent.value1 = param1V; return v;
/*      */       } 
/*      */       throw new IllegalStateException("Invalid map index: " + this.nextIndex);
/*      */     } public void reset() {
/*  706 */       this.nextIndex = 0;
/*  707 */       this.canRemove = false;
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/*  712 */       if (this.canRemove) {
/*  713 */         return "Iterator[" + getKey() + "=" + getValue() + "]";
/*      */       }
/*  715 */       return "Iterator[]";
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
/*      */   public Set<Map.Entry<K, V>> entrySet() {
/*  730 */     if (this.delegateMap != null) {
/*  731 */       return this.delegateMap.entrySet();
/*      */     }
/*  733 */     return new EntrySet<K, V>(this);
/*      */   }
/*      */ 
/*      */   
/*      */   static class EntrySet<K, V>
/*      */     extends AbstractSet<Map.Entry<K, V>>
/*      */   {
/*      */     private final Flat3Map<K, V> parent;
/*      */ 
/*      */     
/*      */     EntrySet(Flat3Map<K, V> param1Flat3Map) {
/*  744 */       this.parent = param1Flat3Map;
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/*  749 */       return this.parent.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/*  754 */       this.parent.clear();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object) {
/*  759 */       if (!(param1Object instanceof Map.Entry)) {
/*  760 */         return false;
/*      */       }
/*  762 */       Map.Entry entry = (Map.Entry)param1Object;
/*  763 */       Object object = entry.getKey();
/*  764 */       boolean bool = this.parent.containsKey(object);
/*  765 */       this.parent.remove(object);
/*  766 */       return bool;
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<Map.Entry<K, V>> iterator() {
/*  771 */       if (this.parent.delegateMap != null) {
/*  772 */         return this.parent.delegateMap.entrySet().iterator();
/*      */       }
/*  774 */       if (this.parent.size() == 0) {
/*  775 */         return EmptyIterator.emptyIterator();
/*      */       }
/*  777 */       return new Flat3Map.EntrySetIterator<K, V>(this.parent);
/*      */     }
/*      */   }
/*      */   
/*      */   static class FlatMapEntry<K, V> implements Map.Entry<K, V> {
/*      */     private final Flat3Map<K, V> parent;
/*      */     private final int index;
/*      */     private volatile boolean removed;
/*      */     
/*      */     public FlatMapEntry(Flat3Map<K, V> param1Flat3Map, int param1Int) {
/*  787 */       this.parent = param1Flat3Map;
/*  788 */       this.index = param1Int;
/*  789 */       this.removed = false;
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
/*      */     void setRemoved(boolean param1Boolean) {
/*  802 */       this.removed = param1Boolean;
/*      */     }
/*      */     
/*      */     public K getKey() {
/*  806 */       if (this.removed) {
/*  807 */         throw new IllegalStateException("getKey() can only be called after next() and before remove()");
/*      */       }
/*  809 */       switch (this.index) {
/*      */         case 3:
/*  811 */           return this.parent.key3;
/*      */         case 2:
/*  813 */           return this.parent.key2;
/*      */         case 1:
/*  815 */           return this.parent.key1;
/*      */       } 
/*  817 */       throw new IllegalStateException("Invalid map index: " + this.index);
/*      */     }
/*      */     
/*      */     public V getValue() {
/*  821 */       if (this.removed) {
/*  822 */         throw new IllegalStateException("getValue() can only be called after next() and before remove()");
/*      */       }
/*  824 */       switch (this.index) {
/*      */         case 3:
/*  826 */           return this.parent.value3;
/*      */         case 2:
/*  828 */           return this.parent.value2;
/*      */         case 1:
/*  830 */           return this.parent.value1;
/*      */       } 
/*  832 */       throw new IllegalStateException("Invalid map index: " + this.index);
/*      */     }
/*      */     
/*      */     public V setValue(V param1V) {
/*  836 */       if (this.removed) {
/*  837 */         throw new IllegalStateException("setValue() can only be called after next() and before remove()");
/*      */       }
/*  839 */       V v = getValue();
/*  840 */       switch (this.index) {
/*      */         case 3:
/*  842 */           this.parent.value3 = param1V;
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
/*  853 */           return v;case 2: this.parent.value2 = param1V; return v;case 1: this.parent.value1 = param1V; return v;
/*      */       } 
/*      */       throw new IllegalStateException("Invalid map index: " + this.index);
/*      */     }
/*      */     public boolean equals(Object param1Object) {
/*  858 */       if (this.removed) {
/*  859 */         return false;
/*      */       }
/*  861 */       if (!(param1Object instanceof Map.Entry)) {
/*  862 */         return false;
/*      */       }
/*  864 */       Map.Entry entry = (Map.Entry)param1Object;
/*  865 */       K k = getKey();
/*  866 */       V v = getValue();
/*  867 */       return (((k == null) ? (entry.getKey() == null) : k.equals(entry.getKey())) && ((v == null) ? (entry.getValue() == null) : v.equals(entry.getValue())));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*  873 */       if (this.removed) {
/*  874 */         return 0;
/*      */       }
/*  876 */       K k = getKey();
/*  877 */       V v = getValue();
/*  878 */       return ((k == null) ? 0 : k.hashCode()) ^ ((v == null) ? 0 : v.hashCode());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/*  884 */       if (!this.removed) {
/*  885 */         return (new StringBuilder()).append(getKey()).append("=").append(getValue()).toString();
/*      */       }
/*  887 */       return "";
/*      */     }
/*      */   }
/*      */   
/*      */   static abstract class EntryIterator<K, V>
/*      */   {
/*      */     private final Flat3Map<K, V> parent;
/*  894 */     private int nextIndex = 0;
/*  895 */     private Flat3Map.FlatMapEntry<K, V> currentEntry = null;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public EntryIterator(Flat3Map<K, V> param1Flat3Map) {
/*  901 */       this.parent = param1Flat3Map;
/*      */     }
/*      */     
/*      */     public boolean hasNext() {
/*  905 */       return (this.nextIndex < this.parent.size);
/*      */     }
/*      */     
/*      */     public Map.Entry<K, V> nextEntry() {
/*  909 */       if (!hasNext()) {
/*  910 */         throw new NoSuchElementException("No next() entry in the iteration");
/*      */       }
/*  912 */       this.currentEntry = new Flat3Map.FlatMapEntry<K, V>(this.parent, ++this.nextIndex);
/*  913 */       return this.currentEntry;
/*      */     }
/*      */     
/*      */     public void remove() {
/*  917 */       if (this.currentEntry == null) {
/*  918 */         throw new IllegalStateException("remove() can only be called once after next()");
/*      */       }
/*  920 */       this.currentEntry.setRemoved(true);
/*  921 */       this.parent.remove(this.currentEntry.getKey());
/*  922 */       this.nextIndex--;
/*  923 */       this.currentEntry = null;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   static class EntrySetIterator<K, V>
/*      */     extends EntryIterator<K, V>
/*      */     implements Iterator<Map.Entry<K, V>>
/*      */   {
/*      */     EntrySetIterator(Flat3Map<K, V> param1Flat3Map) {
/*  933 */       super(param1Flat3Map);
/*      */     }
/*      */     
/*      */     public Map.Entry<K, V> next() {
/*  937 */       return nextEntry();
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
/*      */   public Set<K> keySet() {
/*  949 */     if (this.delegateMap != null) {
/*  950 */       return this.delegateMap.keySet();
/*      */     }
/*  952 */     return new KeySet<K>(this);
/*      */   }
/*      */ 
/*      */   
/*      */   static class KeySet<K>
/*      */     extends AbstractSet<K>
/*      */   {
/*      */     private final Flat3Map<K, ?> parent;
/*      */ 
/*      */     
/*      */     KeySet(Flat3Map<K, ?> param1Flat3Map) {
/*  963 */       this.parent = param1Flat3Map;
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/*  968 */       return this.parent.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/*  973 */       this.parent.clear();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean contains(Object param1Object) {
/*  978 */       return this.parent.containsKey(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object) {
/*  983 */       boolean bool = this.parent.containsKey(param1Object);
/*  984 */       this.parent.remove(param1Object);
/*  985 */       return bool;
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<K> iterator() {
/*  990 */       if (this.parent.delegateMap != null) {
/*  991 */         return this.parent.delegateMap.keySet().iterator();
/*      */       }
/*  993 */       if (this.parent.size() == 0) {
/*  994 */         return EmptyIterator.emptyIterator();
/*      */       }
/*  996 */       return new Flat3Map.KeySetIterator<K>(this.parent);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static class KeySetIterator<K>
/*      */     extends EntryIterator<K, Object>
/*      */     implements Iterator<K>
/*      */   {
/*      */     KeySetIterator(Flat3Map<K, ?> param1Flat3Map) {
/* 1007 */       super((Flat3Map)param1Flat3Map);
/*      */     }
/*      */     
/*      */     public K next() {
/* 1011 */       return nextEntry().getKey();
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
/*      */   public Collection<V> values() {
/* 1023 */     if (this.delegateMap != null) {
/* 1024 */       return this.delegateMap.values();
/*      */     }
/* 1026 */     return new Values<V>(this);
/*      */   }
/*      */ 
/*      */   
/*      */   static class Values<V>
/*      */     extends AbstractCollection<V>
/*      */   {
/*      */     private final Flat3Map<?, V> parent;
/*      */ 
/*      */     
/*      */     Values(Flat3Map<?, V> param1Flat3Map) {
/* 1037 */       this.parent = param1Flat3Map;
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/* 1042 */       return this.parent.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/* 1047 */       this.parent.clear();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean contains(Object param1Object) {
/* 1052 */       return this.parent.containsValue(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<V> iterator() {
/* 1057 */       if (this.parent.delegateMap != null) {
/* 1058 */         return this.parent.delegateMap.values().iterator();
/*      */       }
/* 1060 */       if (this.parent.size() == 0) {
/* 1061 */         return EmptyIterator.emptyIterator();
/*      */       }
/* 1063 */       return new Flat3Map.ValuesIterator<V>(this.parent);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static class ValuesIterator<V>
/*      */     extends EntryIterator<Object, V>
/*      */     implements Iterator<V>
/*      */   {
/*      */     ValuesIterator(Flat3Map<?, V> param1Flat3Map) {
/* 1074 */       super((Flat3Map)param1Flat3Map);
/*      */     }
/*      */     
/*      */     public V next() {
/* 1078 */       return nextEntry().getValue();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 1087 */     paramObjectOutputStream.defaultWriteObject();
/* 1088 */     paramObjectOutputStream.writeInt(size());
/* 1089 */     for (MapIterator<K, V> mapIterator = mapIterator(); mapIterator.hasNext(); ) {
/* 1090 */       paramObjectOutputStream.writeObject(mapIterator.next());
/* 1091 */       paramObjectOutputStream.writeObject(mapIterator.getValue());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 1100 */     paramObjectInputStream.defaultReadObject();
/* 1101 */     int i = paramObjectInputStream.readInt();
/* 1102 */     if (i > 3) {
/* 1103 */       this.delegateMap = createDelegateMap();
/*      */     }
/* 1105 */     for (int j = i; j > 0; j--) {
/* 1106 */       put((K)paramObjectInputStream.readObject(), (V)paramObjectInputStream.readObject());
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
/*      */   public Flat3Map<K, V> clone() {
/*      */     try {
/* 1121 */       Flat3Map<K, V> flat3Map = (Flat3Map)super.clone();
/* 1122 */       if (flat3Map.delegateMap != null) {
/* 1123 */         flat3Map.delegateMap = flat3Map.delegateMap.clone();
/*      */       }
/* 1125 */       return flat3Map;
/* 1126 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 1127 */       throw new InternalError();
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
/* 1139 */     if (paramObject == this) {
/* 1140 */       return true;
/*      */     }
/* 1142 */     if (this.delegateMap != null) {
/* 1143 */       return this.delegateMap.equals(paramObject);
/*      */     }
/* 1145 */     if (!(paramObject instanceof Map)) {
/* 1146 */       return false;
/*      */     }
/* 1148 */     Map map = (Map)paramObject;
/* 1149 */     if (this.size != map.size()) {
/* 1150 */       return false;
/*      */     }
/* 1152 */     if (this.size > 0) {
/* 1153 */       Object object = null;
/* 1154 */       switch (this.size) {
/*      */         case 3:
/* 1156 */           if (!map.containsKey(this.key3)) {
/* 1157 */             return false;
/*      */           }
/* 1159 */           object = map.get(this.key3);
/* 1160 */           if ((this.value3 == null) ? (object != null) : !this.value3.equals(object)) {
/* 1161 */             return false;
/*      */           }
/*      */         case 2:
/* 1164 */           if (!map.containsKey(this.key2)) {
/* 1165 */             return false;
/*      */           }
/* 1167 */           object = map.get(this.key2);
/* 1168 */           if ((this.value2 == null) ? (object != null) : !this.value2.equals(object)) {
/* 1169 */             return false;
/*      */           }
/*      */         case 1:
/* 1172 */           if (!map.containsKey(this.key1)) {
/* 1173 */             return false;
/*      */           }
/* 1175 */           object = map.get(this.key1);
/* 1176 */           if ((this.value1 == null) ? (object != null) : !this.value1.equals(object))
/* 1177 */             return false; 
/*      */           break;
/*      */       } 
/*      */     } 
/* 1181 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 1191 */     if (this.delegateMap != null) {
/* 1192 */       return this.delegateMap.hashCode();
/*      */     }
/* 1194 */     int i = 0;
/* 1195 */     switch (this.size) {
/*      */       case 3:
/* 1197 */         i += this.hash3 ^ ((this.value3 == null) ? 0 : this.value3.hashCode());
/*      */       case 2:
/* 1199 */         i += this.hash2 ^ ((this.value2 == null) ? 0 : this.value2.hashCode());
/*      */       case 1:
/* 1201 */         i += this.hash1 ^ ((this.value1 == null) ? 0 : this.value1.hashCode());
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 0:
/* 1207 */         return i;
/*      */     } 
/*      */     throw new IllegalStateException("Invalid map index: " + this.size);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1217 */     if (this.delegateMap != null) {
/* 1218 */       return this.delegateMap.toString();
/*      */     }
/* 1220 */     if (this.size == 0) {
/* 1221 */       return "{}";
/*      */     }
/* 1223 */     StringBuilder stringBuilder = new StringBuilder(128);
/* 1224 */     stringBuilder.append('{');
/* 1225 */     switch (this.size) {
/*      */       case 3:
/* 1227 */         stringBuilder.append((this.key3 == this) ? "(this Map)" : this.key3);
/* 1228 */         stringBuilder.append('=');
/* 1229 */         stringBuilder.append((this.value3 == this) ? "(this Map)" : this.value3);
/* 1230 */         stringBuilder.append(',');
/*      */       case 2:
/* 1232 */         stringBuilder.append((this.key2 == this) ? "(this Map)" : this.key2);
/* 1233 */         stringBuilder.append('=');
/* 1234 */         stringBuilder.append((this.value2 == this) ? "(this Map)" : this.value2);
/* 1235 */         stringBuilder.append(',');
/*      */       case 1:
/* 1237 */         stringBuilder.append((this.key1 == this) ? "(this Map)" : this.key1);
/* 1238 */         stringBuilder.append('=');
/* 1239 */         stringBuilder.append((this.value1 == this) ? "(this Map)" : this.value1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1245 */         stringBuilder.append('}');
/* 1246 */         return stringBuilder.toString();
/*      */     } 
/*      */     throw new IllegalStateException("Invalid map index: " + this.size);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\map\Flat3Map.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */