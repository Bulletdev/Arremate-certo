/*     */ package com.google.gson.internal;
/*     */ 
/*     */ import java.io.ObjectStreamException;
/*     */ import java.io.Serializable;
/*     */ import java.util.AbstractMap;
/*     */ import java.util.AbstractSet;
/*     */ import java.util.Comparator;
/*     */ import java.util.ConcurrentModificationException;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class LinkedTreeMap<K, V>
/*     */   extends AbstractMap<K, V>
/*     */   implements Serializable
/*     */ {
/*  40 */   private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() {
/*     */       public int compare(Comparable<Comparable> param1Comparable1, Comparable param1Comparable2) {
/*  42 */         return param1Comparable1.compareTo(param1Comparable2);
/*     */       }
/*     */     };
/*     */   
/*     */   Comparator<? super K> comparator;
/*     */   Node<K, V> root;
/*  48 */   int size = 0;
/*  49 */   int modCount = 0;
/*     */ 
/*     */   
/*  52 */   final Node<K, V> header = new Node<K, V>();
/*     */   
/*     */   private EntrySet entrySet;
/*     */   
/*     */   private KeySet keySet;
/*     */ 
/*     */   
/*     */   public LinkedTreeMap() {
/*  60 */     this((Comparator)NATURAL_ORDER);
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
/*     */   public LinkedTreeMap(Comparator<? super K> paramComparator) {
/*  72 */     this.comparator = (paramComparator != null) ? paramComparator : (Comparator)NATURAL_ORDER;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/*  78 */     return this.size;
/*     */   }
/*     */   
/*     */   public V get(Object paramObject) {
/*  82 */     Node<K, V> node = findByObject(paramObject);
/*  83 */     return (node != null) ? node.value : null;
/*     */   }
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/*  87 */     return (findByObject(paramObject) != null);
/*     */   }
/*     */   
/*     */   public V put(K paramK, V paramV) {
/*  91 */     if (paramK == null) {
/*  92 */       throw new NullPointerException("key == null");
/*     */     }
/*  94 */     Node<K, V> node = find(paramK, true);
/*  95 */     V v = node.value;
/*  96 */     node.value = paramV;
/*  97 */     return v;
/*     */   }
/*     */   
/*     */   public void clear() {
/* 101 */     this.root = null;
/* 102 */     this.size = 0;
/* 103 */     this.modCount++;
/*     */ 
/*     */     
/* 106 */     Node<K, V> node = this.header;
/* 107 */     node.next = node.prev = node;
/*     */   }
/*     */   
/*     */   public V remove(Object paramObject) {
/* 111 */     Node<K, V> node = removeInternalByKey(paramObject);
/* 112 */     return (node != null) ? node.value : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Node<K, V> find(K paramK, boolean paramBoolean) {
/*     */     Node<K, V> node3;
/* 122 */     Comparator<? super K> comparator = this.comparator;
/* 123 */     Node<K, V> node1 = this.root;
/* 124 */     int i = 0;
/*     */     
/* 126 */     if (node1 != null) {
/*     */ 
/*     */       
/* 129 */       Comparable<K> comparable = (comparator == NATURAL_ORDER) ? (Comparable)paramK : null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       while (true) {
/* 136 */         i = (comparable != null) ? comparable.compareTo(node1.key) : comparator.compare(paramK, node1.key);
/*     */ 
/*     */         
/* 139 */         if (i == 0) {
/* 140 */           return node1;
/*     */         }
/*     */ 
/*     */         
/* 144 */         node3 = (i < 0) ? node1.left : node1.right;
/* 145 */         if (node3 == null) {
/*     */           break;
/*     */         }
/*     */         
/* 149 */         node1 = node3;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 154 */     if (!paramBoolean) {
/* 155 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 159 */     Node<K, V> node2 = this.header;
/*     */     
/* 161 */     if (node1 == null) {
/*     */       
/* 163 */       if (comparator == NATURAL_ORDER && !(paramK instanceof Comparable)) {
/* 164 */         throw new ClassCastException(paramK.getClass().getName() + " is not Comparable");
/*     */       }
/* 166 */       node3 = new Node<K, V>(node1, paramK, node2, node2.prev);
/* 167 */       this.root = node3;
/*     */     } else {
/* 169 */       node3 = new Node<K, V>(node1, paramK, node2, node2.prev);
/* 170 */       if (i < 0) {
/* 171 */         node1.left = node3;
/*     */       } else {
/* 173 */         node1.right = node3;
/*     */       } 
/* 175 */       rebalance(node1, true);
/*     */     } 
/* 177 */     this.size++;
/* 178 */     this.modCount++;
/*     */     
/* 180 */     return node3;
/*     */   }
/*     */ 
/*     */   
/*     */   Node<K, V> findByObject(Object paramObject) {
/*     */     try {
/* 186 */       return (paramObject != null) ? find((K)paramObject, false) : null;
/* 187 */     } catch (ClassCastException classCastException) {
/* 188 */       return null;
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
/*     */   Node<K, V> findByEntry(Map.Entry<?, ?> paramEntry) {
/* 202 */     Node<K, V> node = findByObject(paramEntry.getKey());
/* 203 */     boolean bool = (node != null && equal(node.value, paramEntry.getValue())) ? true : false;
/* 204 */     return bool ? node : null;
/*     */   }
/*     */   
/*     */   private boolean equal(Object paramObject1, Object paramObject2) {
/* 208 */     return (paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeInternal(Node<K, V> paramNode, boolean paramBoolean) {
/* 218 */     if (paramBoolean) {
/* 219 */       paramNode.prev.next = paramNode.next;
/* 220 */       paramNode.next.prev = paramNode.prev;
/*     */     } 
/*     */     
/* 223 */     Node<K, V> node1 = paramNode.left;
/* 224 */     Node<K, V> node2 = paramNode.right;
/* 225 */     Node<K, V> node3 = paramNode.parent;
/* 226 */     if (node1 != null && node2 != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 237 */       Node<K, V> node = (node1.height > node2.height) ? node1.last() : node2.first();
/* 238 */       removeInternal(node, false);
/*     */       
/* 240 */       int i = 0;
/* 241 */       node1 = paramNode.left;
/* 242 */       if (node1 != null) {
/* 243 */         i = node1.height;
/* 244 */         node.left = node1;
/* 245 */         node1.parent = node;
/* 246 */         paramNode.left = null;
/*     */       } 
/*     */       
/* 249 */       int j = 0;
/* 250 */       node2 = paramNode.right;
/* 251 */       if (node2 != null) {
/* 252 */         j = node2.height;
/* 253 */         node.right = node2;
/* 254 */         node2.parent = node;
/* 255 */         paramNode.right = null;
/*     */       } 
/*     */       
/* 258 */       node.height = Math.max(i, j) + 1;
/* 259 */       replaceInParent(paramNode, node); return;
/*     */     } 
/* 261 */     if (node1 != null) {
/* 262 */       replaceInParent(paramNode, node1);
/* 263 */       paramNode.left = null;
/* 264 */     } else if (node2 != null) {
/* 265 */       replaceInParent(paramNode, node2);
/* 266 */       paramNode.right = null;
/*     */     } else {
/* 268 */       replaceInParent(paramNode, null);
/*     */     } 
/*     */     
/* 271 */     rebalance(node3, false);
/* 272 */     this.size--;
/* 273 */     this.modCount++;
/*     */   }
/*     */   
/*     */   Node<K, V> removeInternalByKey(Object paramObject) {
/* 277 */     Node<K, V> node = findByObject(paramObject);
/* 278 */     if (node != null) {
/* 279 */       removeInternal(node, true);
/*     */     }
/* 281 */     return node;
/*     */   }
/*     */   
/*     */   private void replaceInParent(Node<K, V> paramNode1, Node<K, V> paramNode2) {
/* 285 */     Node<K, V> node = paramNode1.parent;
/* 286 */     paramNode1.parent = null;
/* 287 */     if (paramNode2 != null) {
/* 288 */       paramNode2.parent = node;
/*     */     }
/*     */     
/* 291 */     if (node != null) {
/* 292 */       if (node.left == paramNode1) {
/* 293 */         node.left = paramNode2;
/*     */       } else {
/* 295 */         assert node.right == paramNode1;
/* 296 */         node.right = paramNode2;
/*     */       } 
/*     */     } else {
/* 299 */       this.root = paramNode2;
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
/*     */   private void rebalance(Node<K, V> paramNode, boolean paramBoolean) {
/* 311 */     for (Node<K, V> node = paramNode; node != null; node = node.parent) {
/* 312 */       Node<K, V> node1 = node.left;
/* 313 */       Node<K, V> node2 = node.right;
/* 314 */       byte b1 = (node1 != null) ? node1.height : 0;
/* 315 */       byte b2 = (node2 != null) ? node2.height : 0;
/*     */       
/* 317 */       int i = b1 - b2;
/* 318 */       if (i == -2) {
/* 319 */         Node<K, V> node3 = node2.left;
/* 320 */         Node<K, V> node4 = node2.right;
/* 321 */         byte b3 = (node4 != null) ? node4.height : 0;
/* 322 */         byte b4 = (node3 != null) ? node3.height : 0;
/*     */         
/* 324 */         int j = b4 - b3;
/* 325 */         if (j == -1 || (j == 0 && !paramBoolean)) {
/* 326 */           rotateLeft(node);
/*     */         } else {
/* 328 */           assert j == 1;
/* 329 */           rotateRight(node2);
/* 330 */           rotateLeft(node);
/*     */         } 
/* 332 */         if (paramBoolean) {
/*     */           break;
/*     */         }
/*     */       }
/* 336 */       else if (i == 2) {
/* 337 */         Node<K, V> node3 = node1.left;
/* 338 */         Node<K, V> node4 = node1.right;
/* 339 */         byte b3 = (node4 != null) ? node4.height : 0;
/* 340 */         byte b4 = (node3 != null) ? node3.height : 0;
/*     */         
/* 342 */         int j = b4 - b3;
/* 343 */         if (j == 1 || (j == 0 && !paramBoolean)) {
/* 344 */           rotateRight(node);
/*     */         } else {
/* 346 */           assert j == -1;
/* 347 */           rotateLeft(node1);
/* 348 */           rotateRight(node);
/*     */         } 
/* 350 */         if (paramBoolean) {
/*     */           break;
/*     */         }
/*     */       }
/* 354 */       else if (i == 0) {
/* 355 */         node.height = b1 + 1;
/* 356 */         if (paramBoolean) {
/*     */           break;
/*     */         }
/*     */       } else {
/*     */         
/* 361 */         assert i == -1 || i == 1;
/* 362 */         node.height = Math.max(b1, b2) + 1;
/* 363 */         if (!paramBoolean) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void rotateLeft(Node<K, V> paramNode) {
/* 374 */     Node<K, V> node1 = paramNode.left;
/* 375 */     Node<K, V> node2 = paramNode.right;
/* 376 */     Node<K, V> node3 = node2.left;
/* 377 */     Node<K, V> node4 = node2.right;
/*     */ 
/*     */     
/* 380 */     paramNode.right = node3;
/* 381 */     if (node3 != null) {
/* 382 */       node3.parent = paramNode;
/*     */     }
/*     */     
/* 385 */     replaceInParent(paramNode, node2);
/*     */ 
/*     */     
/* 388 */     node2.left = paramNode;
/* 389 */     paramNode.parent = node2;
/*     */ 
/*     */     
/* 392 */     paramNode.height = Math.max((node1 != null) ? node1.height : 0, (node3 != null) ? node3.height : 0) + 1;
/*     */     
/* 394 */     node2.height = Math.max(paramNode.height, (node4 != null) ? node4.height : 0) + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void rotateRight(Node<K, V> paramNode) {
/* 402 */     Node<K, V> node1 = paramNode.left;
/* 403 */     Node<K, V> node2 = paramNode.right;
/* 404 */     Node<K, V> node3 = node1.left;
/* 405 */     Node<K, V> node4 = node1.right;
/*     */ 
/*     */     
/* 408 */     paramNode.left = node4;
/* 409 */     if (node4 != null) {
/* 410 */       node4.parent = paramNode;
/*     */     }
/*     */     
/* 413 */     replaceInParent(paramNode, node1);
/*     */ 
/*     */     
/* 416 */     node1.right = paramNode;
/* 417 */     paramNode.parent = node1;
/*     */ 
/*     */     
/* 420 */     paramNode.height = Math.max((node2 != null) ? node2.height : 0, (node4 != null) ? node4.height : 0) + 1;
/*     */     
/* 422 */     node1.height = Math.max(paramNode.height, (node3 != null) ? node3.height : 0) + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<K, V>> entrySet() {
/* 430 */     EntrySet entrySet = this.entrySet;
/* 431 */     return (entrySet != null) ? entrySet : (this.entrySet = new EntrySet());
/*     */   }
/*     */   
/*     */   public Set<K> keySet() {
/* 435 */     KeySet keySet = this.keySet;
/* 436 */     return (keySet != null) ? keySet : (this.keySet = new KeySet());
/*     */   }
/*     */   
/*     */   static final class Node<K, V>
/*     */     implements Map.Entry<K, V> {
/*     */     Node<K, V> parent;
/*     */     Node<K, V> left;
/*     */     Node<K, V> right;
/*     */     Node<K, V> next;
/*     */     Node<K, V> prev;
/*     */     final K key;
/*     */     V value;
/*     */     int height;
/*     */     
/*     */     Node() {
/* 451 */       this.key = null;
/* 452 */       this.next = this.prev = this;
/*     */     }
/*     */ 
/*     */     
/*     */     Node(Node<K, V> param1Node1, K param1K, Node<K, V> param1Node2, Node<K, V> param1Node3) {
/* 457 */       this.parent = param1Node1;
/* 458 */       this.key = param1K;
/* 459 */       this.height = 1;
/* 460 */       this.next = param1Node2;
/* 461 */       this.prev = param1Node3;
/* 462 */       param1Node3.next = this;
/* 463 */       param1Node2.prev = this;
/*     */     }
/*     */     
/*     */     public K getKey() {
/* 467 */       return this.key;
/*     */     }
/*     */     
/*     */     public V getValue() {
/* 471 */       return this.value;
/*     */     }
/*     */     
/*     */     public V setValue(V param1V) {
/* 475 */       V v = this.value;
/* 476 */       this.value = param1V;
/* 477 */       return v;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 482 */       if (param1Object instanceof Map.Entry) {
/* 483 */         Map.Entry entry = (Map.Entry)param1Object;
/* 484 */         return (((this.key == null) ? (entry.getKey() == null) : this.key.equals(entry.getKey())) && ((this.value == null) ? (entry
/* 485 */           .getValue() == null) : this.value.equals(entry.getValue())));
/*     */       } 
/* 487 */       return false;
/*     */     }
/*     */     
/*     */     public int hashCode() {
/* 491 */       return ((this.key == null) ? 0 : this.key.hashCode()) ^ ((this.value == null) ? 0 : this.value
/* 492 */         .hashCode());
/*     */     }
/*     */     
/*     */     public String toString() {
/* 496 */       return (new StringBuilder()).append(this.key).append("=").append(this.value).toString();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Node<K, V> first() {
/* 503 */       Node<K, V> node1 = this;
/* 504 */       Node<K, V> node2 = node1.left;
/* 505 */       while (node2 != null) {
/* 506 */         node1 = node2;
/* 507 */         node2 = node1.left;
/*     */       } 
/* 509 */       return node1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Node<K, V> last() {
/* 516 */       Node<K, V> node1 = this;
/* 517 */       Node<K, V> node2 = node1.right;
/* 518 */       while (node2 != null) {
/* 519 */         node1 = node2;
/* 520 */         node2 = node1.right;
/*     */       } 
/* 522 */       return node1;
/*     */     }
/*     */   }
/*     */   
/*     */   private abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
/* 527 */     LinkedTreeMap.Node<K, V> next = LinkedTreeMap.this.header.next;
/* 528 */     LinkedTreeMap.Node<K, V> lastReturned = null;
/* 529 */     int expectedModCount = LinkedTreeMap.this.modCount;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean hasNext() {
/* 535 */       return (this.next != LinkedTreeMap.this.header);
/*     */     }
/*     */     
/*     */     final LinkedTreeMap.Node<K, V> nextNode() {
/* 539 */       LinkedTreeMap.Node<K, V> node = this.next;
/* 540 */       if (node == LinkedTreeMap.this.header) {
/* 541 */         throw new NoSuchElementException();
/*     */       }
/* 543 */       if (LinkedTreeMap.this.modCount != this.expectedModCount) {
/* 544 */         throw new ConcurrentModificationException();
/*     */       }
/* 546 */       this.next = node.next;
/* 547 */       return this.lastReturned = node;
/*     */     }
/*     */     
/*     */     public final void remove() {
/* 551 */       if (this.lastReturned == null) {
/* 552 */         throw new IllegalStateException();
/*     */       }
/* 554 */       LinkedTreeMap.this.removeInternal(this.lastReturned, true);
/* 555 */       this.lastReturned = null;
/* 556 */       this.expectedModCount = LinkedTreeMap.this.modCount;
/*     */     }
/*     */   }
/*     */   
/*     */   class EntrySet extends AbstractSet<Map.Entry<K, V>> {
/*     */     public int size() {
/* 562 */       return LinkedTreeMap.this.size;
/*     */     }
/*     */     
/*     */     public Iterator<Map.Entry<K, V>> iterator() {
/* 566 */       return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>() {
/*     */           public Map.Entry<K, V> next() {
/* 568 */             return nextNode();
/*     */           }
/*     */         };
/*     */     }
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 574 */       return (param1Object instanceof Map.Entry && LinkedTreeMap.this.findByEntry((Map.Entry<?, ?>)param1Object) != null);
/*     */     }
/*     */     
/*     */     public boolean remove(Object param1Object) {
/* 578 */       if (!(param1Object instanceof Map.Entry)) {
/* 579 */         return false;
/*     */       }
/*     */       
/* 582 */       LinkedTreeMap.Node node = LinkedTreeMap.this.findByEntry((Map.Entry<?, ?>)param1Object);
/* 583 */       if (node == null) {
/* 584 */         return false;
/*     */       }
/* 586 */       LinkedTreeMap.this.removeInternal(node, true);
/* 587 */       return true;
/*     */     }
/*     */     
/*     */     public void clear() {
/* 591 */       LinkedTreeMap.this.clear();
/*     */     }
/*     */   }
/*     */   
/*     */   final class KeySet extends AbstractSet<K> {
/*     */     public int size() {
/* 597 */       return LinkedTreeMap.this.size;
/*     */     }
/*     */     
/*     */     public Iterator<K> iterator() {
/* 601 */       return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<K>() {
/*     */           public K next() {
/* 603 */             return (nextNode()).key;
/*     */           }
/*     */         };
/*     */     }
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 609 */       return LinkedTreeMap.this.containsKey(param1Object);
/*     */     }
/*     */     
/*     */     public boolean remove(Object param1Object) {
/* 613 */       return (LinkedTreeMap.this.removeInternalByKey(param1Object) != null);
/*     */     }
/*     */     
/*     */     public void clear() {
/* 617 */       LinkedTreeMap.this.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object writeReplace() throws ObjectStreamException {
/* 628 */     return new LinkedHashMap<Object, Object>(this);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\LinkedTreeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */