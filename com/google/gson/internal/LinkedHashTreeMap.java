/*     */ package com.google.gson.internal;
/*     */ 
/*     */ import java.io.ObjectStreamException;
/*     */ import java.io.Serializable;
/*     */ import java.util.AbstractMap;
/*     */ import java.util.AbstractSet;
/*     */ import java.util.Arrays;
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
/*     */ 
/*     */ public final class LinkedHashTreeMap<K, V>
/*     */   extends AbstractMap<K, V>
/*     */   implements Serializable
/*     */ {
/*  42 */   private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() {
/*     */       public int compare(Comparable<Comparable> param1Comparable1, Comparable param1Comparable2) {
/*  44 */         return param1Comparable1.compareTo(param1Comparable2);
/*     */       }
/*     */     };
/*     */   
/*     */   Comparator<? super K> comparator;
/*     */   Node<K, V>[] table;
/*     */   final Node<K, V> header;
/*  51 */   int size = 0;
/*  52 */   int modCount = 0;
/*     */   
/*     */   int threshold;
/*     */   
/*     */   private EntrySet entrySet;
/*     */   
/*     */   private KeySet keySet;
/*     */   
/*     */   public LinkedHashTreeMap() {
/*  61 */     this((Comparator)NATURAL_ORDER);
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
/*     */   public LinkedHashTreeMap(Comparator<? super K> paramComparator) {
/*  73 */     this.comparator = (paramComparator != null) ? paramComparator : (Comparator)NATURAL_ORDER;
/*     */ 
/*     */     
/*  76 */     this.header = new Node<K, V>();
/*  77 */     this.table = (Node<K, V>[])new Node[16];
/*  78 */     this.threshold = this.table.length / 2 + this.table.length / 4;
/*     */   }
/*     */   
/*     */   public int size() {
/*  82 */     return this.size;
/*     */   }
/*     */   
/*     */   public V get(Object paramObject) {
/*  86 */     Node<K, V> node = findByObject(paramObject);
/*  87 */     return (node != null) ? node.value : null;
/*     */   }
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/*  91 */     return (findByObject(paramObject) != null);
/*     */   }
/*     */   
/*     */   public V put(K paramK, V paramV) {
/*  95 */     if (paramK == null) {
/*  96 */       throw new NullPointerException("key == null");
/*     */     }
/*  98 */     Node<K, V> node = find(paramK, true);
/*  99 */     V v = node.value;
/* 100 */     node.value = paramV;
/* 101 */     return v;
/*     */   }
/*     */   
/*     */   public void clear() {
/* 105 */     Arrays.fill((Object[])this.table, (Object)null);
/* 106 */     this.size = 0;
/* 107 */     this.modCount++;
/*     */ 
/*     */     
/* 110 */     Node<K, V> node1 = this.header;
/* 111 */     for (Node<K, V> node2 = node1.next; node2 != node1; ) {
/* 112 */       Node<K, V> node = node2.next;
/* 113 */       node2.next = node2.prev = null;
/* 114 */       node2 = node;
/*     */     } 
/*     */     
/* 117 */     node1.next = node1.prev = node1;
/*     */   }
/*     */   
/*     */   public V remove(Object paramObject) {
/* 121 */     Node<K, V> node = removeInternalByKey(paramObject);
/* 122 */     return (node != null) ? node.value : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Node<K, V> find(K paramK, boolean paramBoolean) {
/*     */     Node<K, V> node3;
/* 132 */     Comparator<? super K> comparator = this.comparator;
/* 133 */     Node<K, V>[] arrayOfNode = this.table;
/* 134 */     int i = secondaryHash(paramK.hashCode());
/* 135 */     int j = i & arrayOfNode.length - 1;
/* 136 */     Node<K, V> node1 = arrayOfNode[j];
/* 137 */     int k = 0;
/*     */     
/* 139 */     if (node1 != null) {
/*     */ 
/*     */       
/* 142 */       Comparable<K> comparable = (comparator == NATURAL_ORDER) ? (Comparable)paramK : null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       while (true) {
/* 149 */         k = (comparable != null) ? comparable.compareTo(node1.key) : comparator.compare(paramK, node1.key);
/*     */ 
/*     */         
/* 152 */         if (k == 0) {
/* 153 */           return node1;
/*     */         }
/*     */ 
/*     */         
/* 157 */         node3 = (k < 0) ? node1.left : node1.right;
/* 158 */         if (node3 == null) {
/*     */           break;
/*     */         }
/*     */         
/* 162 */         node1 = node3;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 167 */     if (!paramBoolean) {
/* 168 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 172 */     Node<K, V> node2 = this.header;
/*     */     
/* 174 */     if (node1 == null) {
/*     */       
/* 176 */       if (comparator == NATURAL_ORDER && !(paramK instanceof Comparable)) {
/* 177 */         throw new ClassCastException(paramK.getClass().getName() + " is not Comparable");
/*     */       }
/* 179 */       node3 = new Node<K, V>(node1, paramK, i, node2, node2.prev);
/* 180 */       arrayOfNode[j] = node3;
/*     */     } else {
/* 182 */       node3 = new Node<K, V>(node1, paramK, i, node2, node2.prev);
/* 183 */       if (k < 0) {
/* 184 */         node1.left = node3;
/*     */       } else {
/* 186 */         node1.right = node3;
/*     */       } 
/* 188 */       rebalance(node1, true);
/*     */     } 
/*     */     
/* 191 */     if (this.size++ > this.threshold) {
/* 192 */       doubleCapacity();
/*     */     }
/* 194 */     this.modCount++;
/*     */     
/* 196 */     return node3;
/*     */   }
/*     */ 
/*     */   
/*     */   Node<K, V> findByObject(Object paramObject) {
/*     */     try {
/* 202 */       return (paramObject != null) ? find((K)paramObject, false) : null;
/* 203 */     } catch (ClassCastException classCastException) {
/* 204 */       return null;
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
/* 218 */     Node<K, V> node = findByObject(paramEntry.getKey());
/* 219 */     boolean bool = (node != null && equal(node.value, paramEntry.getValue())) ? true : false;
/* 220 */     return bool ? node : null;
/*     */   }
/*     */   
/*     */   private boolean equal(Object paramObject1, Object paramObject2) {
/* 224 */     return (paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int secondaryHash(int paramInt) {
/* 235 */     paramInt ^= paramInt >>> 20 ^ paramInt >>> 12;
/* 236 */     return paramInt ^ paramInt >>> 7 ^ paramInt >>> 4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void removeInternal(Node<K, V> paramNode, boolean paramBoolean) {
/* 246 */     if (paramBoolean) {
/* 247 */       paramNode.prev.next = paramNode.next;
/* 248 */       paramNode.next.prev = paramNode.prev;
/* 249 */       paramNode.next = paramNode.prev = null;
/*     */     } 
/*     */     
/* 252 */     Node<K, V> node1 = paramNode.left;
/* 253 */     Node<K, V> node2 = paramNode.right;
/* 254 */     Node<K, V> node3 = paramNode.parent;
/* 255 */     if (node1 != null && node2 != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 266 */       Node<K, V> node = (node1.height > node2.height) ? node1.last() : node2.first();
/* 267 */       removeInternal(node, false);
/*     */       
/* 269 */       int i = 0;
/* 270 */       node1 = paramNode.left;
/* 271 */       if (node1 != null) {
/* 272 */         i = node1.height;
/* 273 */         node.left = node1;
/* 274 */         node1.parent = node;
/* 275 */         paramNode.left = null;
/*     */       } 
/* 277 */       int j = 0;
/* 278 */       node2 = paramNode.right;
/* 279 */       if (node2 != null) {
/* 280 */         j = node2.height;
/* 281 */         node.right = node2;
/* 282 */         node2.parent = node;
/* 283 */         paramNode.right = null;
/*     */       } 
/* 285 */       node.height = Math.max(i, j) + 1;
/* 286 */       replaceInParent(paramNode, node); return;
/*     */     } 
/* 288 */     if (node1 != null) {
/* 289 */       replaceInParent(paramNode, node1);
/* 290 */       paramNode.left = null;
/* 291 */     } else if (node2 != null) {
/* 292 */       replaceInParent(paramNode, node2);
/* 293 */       paramNode.right = null;
/*     */     } else {
/* 295 */       replaceInParent(paramNode, null);
/*     */     } 
/*     */     
/* 298 */     rebalance(node3, false);
/* 299 */     this.size--;
/* 300 */     this.modCount++;
/*     */   }
/*     */   
/*     */   Node<K, V> removeInternalByKey(Object paramObject) {
/* 304 */     Node<K, V> node = findByObject(paramObject);
/* 305 */     if (node != null) {
/* 306 */       removeInternal(node, true);
/*     */     }
/* 308 */     return node;
/*     */   }
/*     */   
/*     */   private void replaceInParent(Node<K, V> paramNode1, Node<K, V> paramNode2) {
/* 312 */     Node<K, V> node = paramNode1.parent;
/* 313 */     paramNode1.parent = null;
/* 314 */     if (paramNode2 != null) {
/* 315 */       paramNode2.parent = node;
/*     */     }
/*     */     
/* 318 */     if (node != null) {
/* 319 */       if (node.left == paramNode1) {
/* 320 */         node.left = paramNode2;
/*     */       } else {
/* 322 */         assert node.right == paramNode1;
/* 323 */         node.right = paramNode2;
/*     */       } 
/*     */     } else {
/* 326 */       int i = paramNode1.hash & this.table.length - 1;
/* 327 */       this.table[i] = paramNode2;
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
/* 339 */     for (Node<K, V> node = paramNode; node != null; node = node.parent) {
/* 340 */       Node<K, V> node1 = node.left;
/* 341 */       Node<K, V> node2 = node.right;
/* 342 */       byte b1 = (node1 != null) ? node1.height : 0;
/* 343 */       byte b2 = (node2 != null) ? node2.height : 0;
/*     */       
/* 345 */       int i = b1 - b2;
/* 346 */       if (i == -2) {
/* 347 */         Node<K, V> node3 = node2.left;
/* 348 */         Node<K, V> node4 = node2.right;
/* 349 */         byte b3 = (node4 != null) ? node4.height : 0;
/* 350 */         byte b4 = (node3 != null) ? node3.height : 0;
/*     */         
/* 352 */         int j = b4 - b3;
/* 353 */         if (j == -1 || (j == 0 && !paramBoolean)) {
/* 354 */           rotateLeft(node);
/*     */         } else {
/* 356 */           assert j == 1;
/* 357 */           rotateRight(node2);
/* 358 */           rotateLeft(node);
/*     */         } 
/* 360 */         if (paramBoolean) {
/*     */           break;
/*     */         }
/*     */       }
/* 364 */       else if (i == 2) {
/* 365 */         Node<K, V> node3 = node1.left;
/* 366 */         Node<K, V> node4 = node1.right;
/* 367 */         byte b3 = (node4 != null) ? node4.height : 0;
/* 368 */         byte b4 = (node3 != null) ? node3.height : 0;
/*     */         
/* 370 */         int j = b4 - b3;
/* 371 */         if (j == 1 || (j == 0 && !paramBoolean)) {
/* 372 */           rotateRight(node);
/*     */         } else {
/* 374 */           assert j == -1;
/* 375 */           rotateLeft(node1);
/* 376 */           rotateRight(node);
/*     */         } 
/* 378 */         if (paramBoolean) {
/*     */           break;
/*     */         }
/*     */       }
/* 382 */       else if (i == 0) {
/* 383 */         node.height = b1 + 1;
/* 384 */         if (paramBoolean) {
/*     */           break;
/*     */         }
/*     */       } else {
/*     */         
/* 389 */         assert i == -1 || i == 1;
/* 390 */         node.height = Math.max(b1, b2) + 1;
/* 391 */         if (!paramBoolean) {
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
/* 402 */     Node<K, V> node1 = paramNode.left;
/* 403 */     Node<K, V> node2 = paramNode.right;
/* 404 */     Node<K, V> node3 = node2.left;
/* 405 */     Node<K, V> node4 = node2.right;
/*     */ 
/*     */     
/* 408 */     paramNode.right = node3;
/* 409 */     if (node3 != null) {
/* 410 */       node3.parent = paramNode;
/*     */     }
/*     */     
/* 413 */     replaceInParent(paramNode, node2);
/*     */ 
/*     */     
/* 416 */     node2.left = paramNode;
/* 417 */     paramNode.parent = node2;
/*     */ 
/*     */     
/* 420 */     paramNode.height = Math.max((node1 != null) ? node1.height : 0, (node3 != null) ? node3.height : 0) + 1;
/*     */     
/* 422 */     node2.height = Math.max(paramNode.height, (node4 != null) ? node4.height : 0) + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void rotateRight(Node<K, V> paramNode) {
/* 430 */     Node<K, V> node1 = paramNode.left;
/* 431 */     Node<K, V> node2 = paramNode.right;
/* 432 */     Node<K, V> node3 = node1.left;
/* 433 */     Node<K, V> node4 = node1.right;
/*     */ 
/*     */     
/* 436 */     paramNode.left = node4;
/* 437 */     if (node4 != null) {
/* 438 */       node4.parent = paramNode;
/*     */     }
/*     */     
/* 441 */     replaceInParent(paramNode, node1);
/*     */ 
/*     */     
/* 444 */     node1.right = paramNode;
/* 445 */     paramNode.parent = node1;
/*     */ 
/*     */     
/* 448 */     paramNode.height = Math.max((node2 != null) ? node2.height : 0, (node4 != null) ? node4.height : 0) + 1;
/*     */     
/* 450 */     node1.height = Math.max(paramNode.height, (node3 != null) ? node3.height : 0) + 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<K, V>> entrySet() {
/* 458 */     EntrySet entrySet = this.entrySet;
/* 459 */     return (entrySet != null) ? entrySet : (this.entrySet = new EntrySet());
/*     */   }
/*     */   
/*     */   public Set<K> keySet() {
/* 463 */     KeySet keySet = this.keySet;
/* 464 */     return (keySet != null) ? keySet : (this.keySet = new KeySet());
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
/*     */     final int hash;
/*     */     V value;
/*     */     int height;
/*     */     
/*     */     Node() {
/* 480 */       this.key = null;
/* 481 */       this.hash = -1;
/* 482 */       this.next = this.prev = this;
/*     */     }
/*     */ 
/*     */     
/*     */     Node(Node<K, V> param1Node1, K param1K, int param1Int, Node<K, V> param1Node2, Node<K, V> param1Node3) {
/* 487 */       this.parent = param1Node1;
/* 488 */       this.key = param1K;
/* 489 */       this.hash = param1Int;
/* 490 */       this.height = 1;
/* 491 */       this.next = param1Node2;
/* 492 */       this.prev = param1Node3;
/* 493 */       param1Node3.next = this;
/* 494 */       param1Node2.prev = this;
/*     */     }
/*     */     
/*     */     public K getKey() {
/* 498 */       return this.key;
/*     */     }
/*     */     
/*     */     public V getValue() {
/* 502 */       return this.value;
/*     */     }
/*     */     
/*     */     public V setValue(V param1V) {
/* 506 */       V v = this.value;
/* 507 */       this.value = param1V;
/* 508 */       return v;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 513 */       if (param1Object instanceof Map.Entry) {
/* 514 */         Map.Entry entry = (Map.Entry)param1Object;
/* 515 */         return (((this.key == null) ? (entry.getKey() == null) : this.key.equals(entry.getKey())) && ((this.value == null) ? (entry
/* 516 */           .getValue() == null) : this.value.equals(entry.getValue())));
/*     */       } 
/* 518 */       return false;
/*     */     }
/*     */     
/*     */     public int hashCode() {
/* 522 */       return ((this.key == null) ? 0 : this.key.hashCode()) ^ ((this.value == null) ? 0 : this.value
/* 523 */         .hashCode());
/*     */     }
/*     */     
/*     */     public String toString() {
/* 527 */       return (new StringBuilder()).append(this.key).append("=").append(this.value).toString();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Node<K, V> first() {
/* 534 */       Node<K, V> node1 = this;
/* 535 */       Node<K, V> node2 = node1.left;
/* 536 */       while (node2 != null) {
/* 537 */         node1 = node2;
/* 538 */         node2 = node1.left;
/*     */       } 
/* 540 */       return node1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Node<K, V> last() {
/* 547 */       Node<K, V> node1 = this;
/* 548 */       Node<K, V> node2 = node1.right;
/* 549 */       while (node2 != null) {
/* 550 */         node1 = node2;
/* 551 */         node2 = node1.right;
/*     */       } 
/* 553 */       return node1;
/*     */     }
/*     */   }
/*     */   
/*     */   private void doubleCapacity() {
/* 558 */     this.table = doubleCapacity(this.table);
/* 559 */     this.threshold = this.table.length / 2 + this.table.length / 4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static <K, V> Node<K, V>[] doubleCapacity(Node<K, V>[] paramArrayOfNode) {
/* 568 */     int i = paramArrayOfNode.length;
/*     */     
/* 570 */     Node[] arrayOfNode = new Node[i * 2];
/* 571 */     AvlIterator<Object, Object> avlIterator = new AvlIterator<Object, Object>();
/* 572 */     AvlBuilder<Object, Object> avlBuilder1 = new AvlBuilder<Object, Object>();
/* 573 */     AvlBuilder<Object, Object> avlBuilder2 = new AvlBuilder<Object, Object>();
/*     */ 
/*     */     
/* 576 */     for (byte b = 0; b < i; b++) {
/* 577 */       Node<K, V> node = paramArrayOfNode[b];
/* 578 */       if (node != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 583 */         avlIterator.reset((Node)node);
/* 584 */         byte b1 = 0;
/* 585 */         byte b2 = 0; Node<Object, Object> node1;
/* 586 */         while ((node1 = avlIterator.next()) != null) {
/* 587 */           if ((node1.hash & i) == 0) {
/* 588 */             b1++; continue;
/*     */           } 
/* 590 */           b2++;
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 595 */         avlBuilder1.reset(b1);
/* 596 */         avlBuilder2.reset(b2);
/* 597 */         avlIterator.reset((Node)node);
/* 598 */         while ((node1 = avlIterator.next()) != null) {
/* 599 */           if ((node1.hash & i) == 0) {
/* 600 */             avlBuilder1.add(node1); continue;
/*     */           } 
/* 602 */           avlBuilder2.add(node1);
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 607 */         arrayOfNode[b] = (b1 > 0) ? avlBuilder1.root() : null;
/* 608 */         arrayOfNode[b + i] = (b2 > 0) ? avlBuilder2.root() : null;
/*     */       } 
/* 610 */     }  return (Node<K, V>[])arrayOfNode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class AvlIterator<K, V>
/*     */   {
/*     */     private LinkedHashTreeMap.Node<K, V> stackTop;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void reset(LinkedHashTreeMap.Node<K, V> param1Node) {
/* 627 */       LinkedHashTreeMap.Node<K, V> node1 = null;
/* 628 */       for (LinkedHashTreeMap.Node<K, V> node2 = param1Node; node2 != null; node2 = node2.left) {
/* 629 */         node2.parent = node1;
/* 630 */         node1 = node2;
/*     */       } 
/* 632 */       this.stackTop = node1;
/*     */     }
/*     */     
/*     */     public LinkedHashTreeMap.Node<K, V> next() {
/* 636 */       LinkedHashTreeMap.Node<K, V> node1 = this.stackTop;
/* 637 */       if (node1 == null) {
/* 638 */         return null;
/*     */       }
/* 640 */       LinkedHashTreeMap.Node<K, V> node2 = node1;
/* 641 */       node1 = node2.parent;
/* 642 */       node2.parent = null;
/* 643 */       for (LinkedHashTreeMap.Node<K, V> node3 = node2.right; node3 != null; node3 = node3.left) {
/* 644 */         node3.parent = node1;
/* 645 */         node1 = node3;
/*     */       } 
/* 647 */       this.stackTop = node1;
/* 648 */       return node2;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class AvlBuilder<K, V>
/*     */   {
/*     */     private LinkedHashTreeMap.Node<K, V> stack;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int leavesToSkip;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int leavesSkipped;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int size;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void reset(int param1Int) {
/* 679 */       int i = Integer.highestOneBit(param1Int) * 2 - 1;
/* 680 */       this.leavesToSkip = i - param1Int;
/* 681 */       this.size = 0;
/* 682 */       this.leavesSkipped = 0;
/* 683 */       this.stack = null;
/*     */     }
/*     */     
/*     */     void add(LinkedHashTreeMap.Node<K, V> param1Node) {
/* 687 */       param1Node.left = param1Node.parent = param1Node.right = null;
/* 688 */       param1Node.height = 1;
/*     */ 
/*     */       
/* 691 */       if (this.leavesToSkip > 0 && (this.size & 0x1) == 0) {
/* 692 */         this.size++;
/* 693 */         this.leavesToSkip--;
/* 694 */         this.leavesSkipped++;
/*     */       } 
/*     */       
/* 697 */       param1Node.parent = this.stack;
/* 698 */       this.stack = param1Node;
/* 699 */       this.size++;
/*     */ 
/*     */       
/* 702 */       if (this.leavesToSkip > 0 && (this.size & 0x1) == 0) {
/* 703 */         this.size++;
/* 704 */         this.leavesToSkip--;
/* 705 */         this.leavesSkipped++;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 721 */       for (int i = 4; (this.size & i - 1) == i - 1; i *= 2) {
/* 722 */         if (this.leavesSkipped == 0) {
/*     */           
/* 724 */           LinkedHashTreeMap.Node<K, V> node1 = this.stack;
/* 725 */           LinkedHashTreeMap.Node<K, V> node2 = node1.parent;
/* 726 */           LinkedHashTreeMap.Node<K, V> node3 = node2.parent;
/* 727 */           node2.parent = node3.parent;
/* 728 */           this.stack = node2;
/*     */           
/* 730 */           node2.left = node3;
/* 731 */           node2.right = node1;
/* 732 */           node1.height++;
/* 733 */           node3.parent = node2;
/* 734 */           node1.parent = node2;
/* 735 */         } else if (this.leavesSkipped == 1) {
/*     */           
/* 737 */           LinkedHashTreeMap.Node<K, V> node1 = this.stack;
/* 738 */           LinkedHashTreeMap.Node<K, V> node2 = node1.parent;
/* 739 */           this.stack = node2;
/*     */           
/* 741 */           node2.right = node1;
/* 742 */           node1.height++;
/* 743 */           node1.parent = node2;
/* 744 */           this.leavesSkipped = 0;
/* 745 */         } else if (this.leavesSkipped == 2) {
/* 746 */           this.leavesSkipped = 0;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     LinkedHashTreeMap.Node<K, V> root() {
/* 752 */       LinkedHashTreeMap.Node<K, V> node = this.stack;
/* 753 */       if (node.parent != null) {
/* 754 */         throw new IllegalStateException();
/*     */       }
/* 756 */       return node;
/*     */     }
/*     */   }
/*     */   
/*     */   private abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
/* 761 */     LinkedHashTreeMap.Node<K, V> next = LinkedHashTreeMap.this.header.next;
/* 762 */     LinkedHashTreeMap.Node<K, V> lastReturned = null;
/* 763 */     int expectedModCount = LinkedHashTreeMap.this.modCount;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean hasNext() {
/* 769 */       return (this.next != LinkedHashTreeMap.this.header);
/*     */     }
/*     */     
/*     */     final LinkedHashTreeMap.Node<K, V> nextNode() {
/* 773 */       LinkedHashTreeMap.Node<K, V> node = this.next;
/* 774 */       if (node == LinkedHashTreeMap.this.header) {
/* 775 */         throw new NoSuchElementException();
/*     */       }
/* 777 */       if (LinkedHashTreeMap.this.modCount != this.expectedModCount) {
/* 778 */         throw new ConcurrentModificationException();
/*     */       }
/* 780 */       this.next = node.next;
/* 781 */       return this.lastReturned = node;
/*     */     }
/*     */     
/*     */     public final void remove() {
/* 785 */       if (this.lastReturned == null) {
/* 786 */         throw new IllegalStateException();
/*     */       }
/* 788 */       LinkedHashTreeMap.this.removeInternal(this.lastReturned, true);
/* 789 */       this.lastReturned = null;
/* 790 */       this.expectedModCount = LinkedHashTreeMap.this.modCount;
/*     */     }
/*     */   }
/*     */   
/*     */   final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
/*     */     public int size() {
/* 796 */       return LinkedHashTreeMap.this.size;
/*     */     }
/*     */     
/*     */     public Iterator<Map.Entry<K, V>> iterator() {
/* 800 */       return new LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>() {
/*     */           public Map.Entry<K, V> next() {
/* 802 */             return nextNode();
/*     */           }
/*     */         };
/*     */     }
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 808 */       return (param1Object instanceof Map.Entry && LinkedHashTreeMap.this.findByEntry((Map.Entry<?, ?>)param1Object) != null);
/*     */     }
/*     */     
/*     */     public boolean remove(Object param1Object) {
/* 812 */       if (!(param1Object instanceof Map.Entry)) {
/* 813 */         return false;
/*     */       }
/*     */       
/* 816 */       LinkedHashTreeMap.Node node = LinkedHashTreeMap.this.findByEntry((Map.Entry<?, ?>)param1Object);
/* 817 */       if (node == null) {
/* 818 */         return false;
/*     */       }
/* 820 */       LinkedHashTreeMap.this.removeInternal(node, true);
/* 821 */       return true;
/*     */     }
/*     */     
/*     */     public void clear() {
/* 825 */       LinkedHashTreeMap.this.clear();
/*     */     }
/*     */   }
/*     */   
/*     */   final class KeySet extends AbstractSet<K> {
/*     */     public int size() {
/* 831 */       return LinkedHashTreeMap.this.size;
/*     */     }
/*     */     
/*     */     public Iterator<K> iterator() {
/* 835 */       return new LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<K>() {
/*     */           public K next() {
/* 837 */             return (nextNode()).key;
/*     */           }
/*     */         };
/*     */     }
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 843 */       return LinkedHashTreeMap.this.containsKey(param1Object);
/*     */     }
/*     */     
/*     */     public boolean remove(Object param1Object) {
/* 847 */       return (LinkedHashTreeMap.this.removeInternalByKey(param1Object) != null);
/*     */     }
/*     */     
/*     */     public void clear() {
/* 851 */       LinkedHashTreeMap.this.clear();
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
/* 862 */     return new LinkedHashMap<Object, Object>(this);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\LinkedHashTreeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */