/*      */ package org.apache.commons.collections4.trie;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.io.ObjectOutputStream;
/*      */ import java.util.AbstractCollection;
/*      */ import java.util.AbstractMap;
/*      */ import java.util.AbstractSet;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.ConcurrentModificationException;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.NoSuchElementException;
/*      */ import java.util.Set;
/*      */ import java.util.SortedMap;
/*      */ import org.apache.commons.collections4.MapIterator;
/*      */ import org.apache.commons.collections4.OrderedMapIterator;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ abstract class AbstractPatriciaTrie<K, V>
/*      */   extends AbstractBitwiseTrie<K, V>
/*      */ {
/*      */   private static final long serialVersionUID = 5155253417231339498L;
/*   49 */   private transient TrieEntry<K, V> root = new TrieEntry<K, V>(null, null, -1);
/*      */ 
/*      */   
/*      */   private volatile transient Set<K> keySet;
/*      */ 
/*      */   
/*      */   private volatile transient Collection<V> values;
/*      */ 
/*      */   
/*      */   private volatile transient Set<Map.Entry<K, V>> entrySet;
/*      */ 
/*      */   
/*   61 */   private transient int size = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   67 */   protected transient int modCount = 0;
/*      */   
/*      */   protected AbstractPatriciaTrie(KeyAnalyzer<? super K> paramKeyAnalyzer) {
/*   70 */     super(paramKeyAnalyzer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected AbstractPatriciaTrie(KeyAnalyzer<? super K> paramKeyAnalyzer, Map<? extends K, ? extends V> paramMap) {
/*   80 */     super(paramKeyAnalyzer);
/*   81 */     putAll(paramMap);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void clear() {
/*   87 */     this.root.key = null;
/*   88 */     this.root.bitIndex = -1;
/*   89 */     this.root.value = null;
/*      */     
/*   91 */     this.root.parent = null;
/*   92 */     this.root.left = this.root;
/*   93 */     this.root.right = null;
/*   94 */     this.root.predecessor = this.root;
/*      */     
/*   96 */     this.size = 0;
/*   97 */     incrementModCount();
/*      */   }
/*      */ 
/*      */   
/*      */   public int size() {
/*  102 */     return this.size;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void incrementSize() {
/*  109 */     this.size++;
/*  110 */     incrementModCount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void decrementSize() {
/*  117 */     this.size--;
/*  118 */     incrementModCount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void incrementModCount() {
/*  125 */     this.modCount++;
/*      */   }
/*      */ 
/*      */   
/*      */   public V put(K paramK, V paramV) {
/*  130 */     if (paramK == null) {
/*  131 */       throw new NullPointerException("Key cannot be null");
/*      */     }
/*      */     
/*  134 */     int i = lengthInBits(paramK);
/*      */ 
/*      */ 
/*      */     
/*  138 */     if (i == 0) {
/*  139 */       if (this.root.isEmpty()) {
/*  140 */         incrementSize();
/*      */       } else {
/*  142 */         incrementModCount();
/*      */       } 
/*  144 */       return this.root.setKeyValue(paramK, paramV);
/*      */     } 
/*      */     
/*  147 */     TrieEntry<K, V> trieEntry = getNearestEntryForKey(paramK, i);
/*  148 */     if (compareKeys(paramK, trieEntry.key)) {
/*  149 */       if (trieEntry.isEmpty()) {
/*  150 */         incrementSize();
/*      */       } else {
/*  152 */         incrementModCount();
/*      */       } 
/*  154 */       return trieEntry.setKeyValue(paramK, paramV);
/*      */     } 
/*      */     
/*  157 */     int j = bitIndex(paramK, trieEntry.key);
/*  158 */     if (!KeyAnalyzer.isOutOfBoundsIndex(j)) {
/*  159 */       if (KeyAnalyzer.isValidBitIndex(j)) {
/*      */         
/*  161 */         TrieEntry<K, V> trieEntry1 = new TrieEntry<K, V>(paramK, paramV, j);
/*  162 */         addEntry(trieEntry1, i);
/*  163 */         incrementSize();
/*  164 */         return null;
/*  165 */       }  if (KeyAnalyzer.isNullBitKey(j)) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  170 */         if (this.root.isEmpty()) {
/*  171 */           incrementSize();
/*      */         } else {
/*  173 */           incrementModCount();
/*      */         } 
/*  175 */         return this.root.setKeyValue(paramK, paramV);
/*      */       } 
/*  177 */       if (KeyAnalyzer.isEqualBitKey(j))
/*      */       {
/*      */ 
/*      */         
/*  181 */         if (trieEntry != this.root) {
/*  182 */           incrementModCount();
/*  183 */           return trieEntry.setKeyValue(paramK, paramV);
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/*  188 */     throw new IllegalArgumentException("Failed to put: " + paramK + " -> " + paramV + ", " + j);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   TrieEntry<K, V> addEntry(TrieEntry<K, V> paramTrieEntry, int paramInt) {
/*  195 */     TrieEntry<K, V> trieEntry1 = this.root.left;
/*  196 */     TrieEntry<K, V> trieEntry2 = this.root;
/*      */     while (true) {
/*  198 */       if (trieEntry1.bitIndex >= paramTrieEntry.bitIndex || trieEntry1.bitIndex <= trieEntry2.bitIndex) {
/*      */         
/*  200 */         paramTrieEntry.predecessor = paramTrieEntry;
/*      */         
/*  202 */         if (!isBitSet(paramTrieEntry.key, paramTrieEntry.bitIndex, paramInt)) {
/*  203 */           paramTrieEntry.left = paramTrieEntry;
/*  204 */           paramTrieEntry.right = trieEntry1;
/*      */         } else {
/*  206 */           paramTrieEntry.left = trieEntry1;
/*  207 */           paramTrieEntry.right = paramTrieEntry;
/*      */         } 
/*      */         
/*  210 */         paramTrieEntry.parent = trieEntry2;
/*  211 */         if (trieEntry1.bitIndex >= paramTrieEntry.bitIndex) {
/*  212 */           trieEntry1.parent = paramTrieEntry;
/*      */         }
/*      */ 
/*      */         
/*  216 */         if (trieEntry1.bitIndex <= trieEntry2.bitIndex) {
/*  217 */           trieEntry1.predecessor = paramTrieEntry;
/*      */         }
/*      */         
/*  220 */         if (trieEntry2 == this.root || !isBitSet(paramTrieEntry.key, trieEntry2.bitIndex, paramInt)) {
/*  221 */           trieEntry2.left = paramTrieEntry;
/*      */         } else {
/*  223 */           trieEntry2.right = paramTrieEntry;
/*      */         } 
/*      */         
/*  226 */         return paramTrieEntry;
/*      */       } 
/*      */       
/*  229 */       trieEntry2 = trieEntry1;
/*      */       
/*  231 */       if (!isBitSet(paramTrieEntry.key, trieEntry1.bitIndex, paramInt)) {
/*  232 */         trieEntry1 = trieEntry1.left; continue;
/*      */       } 
/*  234 */       trieEntry1 = trieEntry1.right;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public V get(Object paramObject) {
/*  241 */     TrieEntry<K, V> trieEntry = getEntry(paramObject);
/*  242 */     return (trieEntry != null) ? trieEntry.getValue() : null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   TrieEntry<K, V> getEntry(Object paramObject) {
/*  253 */     K k = castKey(paramObject);
/*  254 */     if (k == null) {
/*  255 */       return null;
/*      */     }
/*      */     
/*  258 */     int i = lengthInBits(k);
/*  259 */     TrieEntry<K, V> trieEntry = getNearestEntryForKey(k, i);
/*  260 */     return (!trieEntry.isEmpty() && compareKeys(k, trieEntry.key)) ? trieEntry : null;
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
/*      */   public Map.Entry<K, V> select(K paramK) {
/*  283 */     int i = lengthInBits(paramK);
/*  284 */     Reference<Map.Entry<K, V>> reference = new Reference();
/*  285 */     if (!selectR(this.root.left, -1, paramK, i, reference)) {
/*  286 */       return reference.get();
/*      */     }
/*  288 */     return null;
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
/*      */   public K selectKey(K paramK) {
/*  311 */     Map.Entry<K, V> entry = select(paramK);
/*  312 */     if (entry == null) {
/*  313 */       return null;
/*      */     }
/*  315 */     return entry.getKey();
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
/*      */   public V selectValue(K paramK) {
/*  339 */     Map.Entry<K, V> entry = select(paramK);
/*  340 */     if (entry == null) {
/*  341 */       return null;
/*      */     }
/*  343 */     return entry.getValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean selectR(TrieEntry<K, V> paramTrieEntry, int paramInt1, K paramK, int paramInt2, Reference<Map.Entry<K, V>> paramReference) {
/*  354 */     if (paramTrieEntry.bitIndex <= paramInt1) {
/*      */ 
/*      */ 
/*      */       
/*  358 */       if (!paramTrieEntry.isEmpty()) {
/*  359 */         paramReference.set(paramTrieEntry);
/*  360 */         return false;
/*      */       } 
/*  362 */       return true;
/*      */     } 
/*      */     
/*  365 */     if (!isBitSet(paramK, paramTrieEntry.bitIndex, paramInt2)) {
/*  366 */       if (selectR(paramTrieEntry.left, paramTrieEntry.bitIndex, paramK, paramInt2, paramReference)) {
/*  367 */         return selectR(paramTrieEntry.right, paramTrieEntry.bitIndex, paramK, paramInt2, paramReference);
/*      */       }
/*      */     }
/*  370 */     else if (selectR(paramTrieEntry.right, paramTrieEntry.bitIndex, paramK, paramInt2, paramReference)) {
/*  371 */       return selectR(paramTrieEntry.left, paramTrieEntry.bitIndex, paramK, paramInt2, paramReference);
/*      */     } 
/*      */     
/*  374 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean containsKey(Object paramObject) {
/*  379 */     if (paramObject == null) {
/*  380 */       return false;
/*      */     }
/*      */     
/*  383 */     K k = castKey(paramObject);
/*  384 */     int i = lengthInBits(k);
/*  385 */     TrieEntry<K, V> trieEntry = getNearestEntryForKey(k, i);
/*  386 */     return (!trieEntry.isEmpty() && compareKeys(k, trieEntry.key));
/*      */   }
/*      */ 
/*      */   
/*      */   public Set<Map.Entry<K, V>> entrySet() {
/*  391 */     if (this.entrySet == null) {
/*  392 */       this.entrySet = new EntrySet();
/*      */     }
/*  394 */     return this.entrySet;
/*      */   }
/*      */ 
/*      */   
/*      */   public Set<K> keySet() {
/*  399 */     if (this.keySet == null) {
/*  400 */       this.keySet = new KeySet();
/*      */     }
/*  402 */     return this.keySet;
/*      */   }
/*      */ 
/*      */   
/*      */   public Collection<V> values() {
/*  407 */     if (this.values == null) {
/*  408 */       this.values = new Values();
/*      */     }
/*  410 */     return this.values;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public V remove(Object paramObject) {
/*  420 */     if (paramObject == null) {
/*  421 */       return null;
/*      */     }
/*      */     
/*  424 */     K k = castKey(paramObject);
/*  425 */     int i = lengthInBits(k);
/*  426 */     TrieEntry<K, V> trieEntry1 = this.root.left;
/*  427 */     TrieEntry<K, V> trieEntry2 = this.root;
/*      */     while (true) {
/*  429 */       if (trieEntry1.bitIndex <= trieEntry2.bitIndex) {
/*  430 */         if (!trieEntry1.isEmpty() && compareKeys(k, trieEntry1.key)) {
/*  431 */           return removeEntry(trieEntry1);
/*      */         }
/*  433 */         return null;
/*      */       } 
/*      */       
/*  436 */       trieEntry2 = trieEntry1;
/*      */       
/*  438 */       if (!isBitSet(k, trieEntry1.bitIndex, i)) {
/*  439 */         trieEntry1 = trieEntry1.left; continue;
/*      */       } 
/*  441 */       trieEntry1 = trieEntry1.right;
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
/*      */   TrieEntry<K, V> getNearestEntryForKey(K paramK, int paramInt) {
/*  456 */     TrieEntry<K, V> trieEntry1 = this.root.left;
/*  457 */     TrieEntry<K, V> trieEntry2 = this.root;
/*      */     while (true) {
/*  459 */       if (trieEntry1.bitIndex <= trieEntry2.bitIndex) {
/*  460 */         return trieEntry1;
/*      */       }
/*      */       
/*  463 */       trieEntry2 = trieEntry1;
/*  464 */       if (!isBitSet(paramK, trieEntry1.bitIndex, paramInt)) {
/*  465 */         trieEntry1 = trieEntry1.left; continue;
/*      */       } 
/*  467 */       trieEntry1 = trieEntry1.right;
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
/*      */   V removeEntry(TrieEntry<K, V> paramTrieEntry) {
/*  480 */     if (paramTrieEntry != this.root) {
/*  481 */       if (paramTrieEntry.isInternalNode()) {
/*  482 */         removeInternalEntry(paramTrieEntry);
/*      */       } else {
/*  484 */         removeExternalEntry(paramTrieEntry);
/*      */       } 
/*      */     }
/*      */     
/*  488 */     decrementSize();
/*  489 */     return paramTrieEntry.setKeyValue(null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void removeExternalEntry(TrieEntry<K, V> paramTrieEntry) {
/*  499 */     if (paramTrieEntry == this.root)
/*  500 */       throw new IllegalArgumentException("Cannot delete root Entry!"); 
/*  501 */     if (!paramTrieEntry.isExternalNode()) {
/*  502 */       throw new IllegalArgumentException(paramTrieEntry + " is not an external Entry!");
/*      */     }
/*      */     
/*  505 */     TrieEntry<K, V> trieEntry1 = paramTrieEntry.parent;
/*  506 */     TrieEntry<K, V> trieEntry2 = (paramTrieEntry.left == paramTrieEntry) ? paramTrieEntry.right : paramTrieEntry.left;
/*      */     
/*  508 */     if (trieEntry1.left == paramTrieEntry) {
/*  509 */       trieEntry1.left = trieEntry2;
/*      */     } else {
/*  511 */       trieEntry1.right = trieEntry2;
/*      */     } 
/*      */ 
/*      */     
/*  515 */     if (trieEntry2.bitIndex > trieEntry1.bitIndex) {
/*  516 */       trieEntry2.parent = trieEntry1;
/*      */     } else {
/*  518 */       trieEntry2.predecessor = trieEntry1;
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
/*      */   private void removeInternalEntry(TrieEntry<K, V> paramTrieEntry) {
/*  531 */     if (paramTrieEntry == this.root)
/*  532 */       throw new IllegalArgumentException("Cannot delete root Entry!"); 
/*  533 */     if (!paramTrieEntry.isInternalNode()) {
/*  534 */       throw new IllegalArgumentException(paramTrieEntry + " is not an internal Entry!");
/*      */     }
/*      */     
/*  537 */     TrieEntry<K, V> trieEntry1 = paramTrieEntry.predecessor;
/*      */ 
/*      */     
/*  540 */     trieEntry1.bitIndex = paramTrieEntry.bitIndex;
/*      */ 
/*      */ 
/*      */     
/*  544 */     TrieEntry<K, V> trieEntry2 = trieEntry1.parent;
/*  545 */     TrieEntry<K, V> trieEntry3 = (trieEntry1.left == paramTrieEntry) ? trieEntry1.right : trieEntry1.left;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  553 */     if (trieEntry1.predecessor == trieEntry1 && trieEntry1.parent != paramTrieEntry) {
/*  554 */       trieEntry1.predecessor = trieEntry1.parent;
/*      */     }
/*      */     
/*  557 */     if (trieEntry2.left == trieEntry1) {
/*  558 */       trieEntry2.left = trieEntry3;
/*      */     } else {
/*  560 */       trieEntry2.right = trieEntry3;
/*      */     } 
/*      */     
/*  563 */     if (trieEntry3.bitIndex > trieEntry2.bitIndex) {
/*  564 */       trieEntry3.parent = trieEntry2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  572 */     if (paramTrieEntry.left.parent == paramTrieEntry) {
/*  573 */       paramTrieEntry.left.parent = trieEntry1;
/*      */     }
/*      */     
/*  576 */     if (paramTrieEntry.right.parent == paramTrieEntry) {
/*  577 */       paramTrieEntry.right.parent = trieEntry1;
/*      */     }
/*      */ 
/*      */     
/*  581 */     if (paramTrieEntry.parent.left == paramTrieEntry) {
/*  582 */       paramTrieEntry.parent.left = trieEntry1;
/*      */     } else {
/*  584 */       paramTrieEntry.parent.right = trieEntry1;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  590 */     trieEntry1.parent = paramTrieEntry.parent;
/*  591 */     trieEntry1.left = paramTrieEntry.left;
/*  592 */     trieEntry1.right = paramTrieEntry.right;
/*      */ 
/*      */ 
/*      */     
/*  596 */     if (isValidUplink(trieEntry1.left, trieEntry1)) {
/*  597 */       trieEntry1.left.predecessor = trieEntry1;
/*      */     }
/*      */     
/*  600 */     if (isValidUplink(trieEntry1.right, trieEntry1)) {
/*  601 */       trieEntry1.right.predecessor = trieEntry1;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   TrieEntry<K, V> nextEntry(TrieEntry<K, V> paramTrieEntry) {
/*  610 */     if (paramTrieEntry == null) {
/*  611 */       return firstEntry();
/*      */     }
/*  613 */     return nextEntryImpl(paramTrieEntry.predecessor, paramTrieEntry, (TrieEntry<K, V>)null);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   TrieEntry<K, V> nextEntryImpl(TrieEntry<K, V> paramTrieEntry1, TrieEntry<K, V> paramTrieEntry2, TrieEntry<K, V> paramTrieEntry3) {
/*  652 */     TrieEntry<K, V> trieEntry = paramTrieEntry1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  657 */     if (paramTrieEntry2 == null || paramTrieEntry1 != paramTrieEntry2.predecessor) {
/*  658 */       while (!trieEntry.left.isEmpty()) {
/*      */ 
/*      */         
/*  661 */         if (paramTrieEntry2 == trieEntry.left) {
/*      */           break;
/*      */         }
/*      */         
/*  665 */         if (isValidUplink(trieEntry.left, trieEntry)) {
/*  666 */           return trieEntry.left;
/*      */         }
/*      */         
/*  669 */         trieEntry = trieEntry.left;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  674 */     if (trieEntry.isEmpty()) {
/*  675 */       return null;
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
/*  687 */     if (trieEntry.right == null) {
/*  688 */       return null;
/*      */     }
/*      */ 
/*      */     
/*  692 */     if (paramTrieEntry2 != trieEntry.right) {
/*      */       
/*  694 */       if (isValidUplink(trieEntry.right, trieEntry)) {
/*  695 */         return trieEntry.right;
/*      */       }
/*      */ 
/*      */       
/*  699 */       return nextEntryImpl(trieEntry.right, paramTrieEntry2, paramTrieEntry3);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  704 */     while (trieEntry == trieEntry.parent.right) {
/*      */       
/*  706 */       if (trieEntry == paramTrieEntry3) {
/*  707 */         return null;
/*      */       }
/*      */       
/*  710 */       trieEntry = trieEntry.parent;
/*      */     } 
/*      */ 
/*      */     
/*  714 */     if (trieEntry == paramTrieEntry3) {
/*  715 */       return null;
/*      */     }
/*      */ 
/*      */     
/*  719 */     if (trieEntry.parent.right == null) {
/*  720 */       return null;
/*      */     }
/*      */ 
/*      */     
/*  724 */     if (paramTrieEntry2 != trieEntry.parent.right && isValidUplink(trieEntry.parent.right, trieEntry.parent))
/*      */     {
/*  726 */       return trieEntry.parent.right;
/*      */     }
/*      */ 
/*      */     
/*  730 */     if (trieEntry.parent.right == trieEntry.parent) {
/*  731 */       return null;
/*      */     }
/*      */ 
/*      */     
/*  735 */     return nextEntryImpl(trieEntry.parent.right, paramTrieEntry2, paramTrieEntry3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   TrieEntry<K, V> firstEntry() {
/*  746 */     if (isEmpty()) {
/*  747 */       return null;
/*      */     }
/*      */     
/*  750 */     return followLeft(this.root);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   TrieEntry<K, V> followLeft(TrieEntry<K, V> paramTrieEntry) {
/*      */     while (true) {
/*  758 */       TrieEntry<K, V> trieEntry = paramTrieEntry.left;
/*      */       
/*  760 */       if (trieEntry.isEmpty()) {
/*  761 */         trieEntry = paramTrieEntry.right;
/*      */       }
/*      */       
/*  764 */       if (trieEntry.bitIndex <= paramTrieEntry.bitIndex) {
/*  765 */         return trieEntry;
/*      */       }
/*      */       
/*  768 */       paramTrieEntry = trieEntry;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Comparator<? super K> comparator() {
/*  775 */     return getKeyAnalyzer();
/*      */   }
/*      */   
/*      */   public K firstKey() {
/*  779 */     if (size() == 0) {
/*  780 */       throw new NoSuchElementException();
/*      */     }
/*  782 */     return firstEntry().getKey();
/*      */   }
/*      */   
/*      */   public K lastKey() {
/*  786 */     TrieEntry<K, V> trieEntry = lastEntry();
/*  787 */     if (trieEntry != null) {
/*  788 */       return trieEntry.getKey();
/*      */     }
/*  790 */     throw new NoSuchElementException();
/*      */   }
/*      */   
/*      */   public K nextKey(K paramK) {
/*  794 */     if (paramK == null) {
/*  795 */       throw new NullPointerException();
/*      */     }
/*  797 */     TrieEntry<K, V> trieEntry = getEntry(paramK);
/*  798 */     if (trieEntry != null) {
/*  799 */       TrieEntry<K, V> trieEntry1 = nextEntry(trieEntry);
/*  800 */       return (trieEntry1 != null) ? trieEntry1.getKey() : null;
/*      */     } 
/*  802 */     return null;
/*      */   }
/*      */   
/*      */   public K previousKey(K paramK) {
/*  806 */     if (paramK == null) {
/*  807 */       throw new NullPointerException();
/*      */     }
/*  809 */     TrieEntry<K, V> trieEntry = getEntry(paramK);
/*  810 */     if (trieEntry != null) {
/*  811 */       TrieEntry<K, V> trieEntry1 = previousEntry(trieEntry);
/*  812 */       return (trieEntry1 != null) ? trieEntry1.getKey() : null;
/*      */     } 
/*  814 */     return null;
/*      */   }
/*      */   
/*      */   public OrderedMapIterator<K, V> mapIterator() {
/*  818 */     return new TrieMapIterator();
/*      */   }
/*      */   
/*      */   public SortedMap<K, V> prefixMap(K paramK) {
/*  822 */     return getPrefixMapByBits(paramK, 0, lengthInBits(paramK));
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
/*      */   private SortedMap<K, V> getPrefixMapByBits(K paramK, int paramInt1, int paramInt2) {
/*  848 */     int i = paramInt1 + paramInt2;
/*  849 */     if (i > lengthInBits(paramK)) {
/*  850 */       throw new IllegalArgumentException(paramInt1 + " + " + paramInt2 + " > " + lengthInBits(paramK));
/*      */     }
/*      */ 
/*      */     
/*  854 */     if (i == 0) {
/*  855 */       return (SortedMap<K, V>)this;
/*      */     }
/*      */     
/*  858 */     return new PrefixRangeMap(paramK, paramInt1, paramInt2);
/*      */   }
/*      */   
/*      */   public SortedMap<K, V> headMap(K paramK) {
/*  862 */     return new RangeEntryMap(null, paramK);
/*      */   }
/*      */   
/*      */   public SortedMap<K, V> subMap(K paramK1, K paramK2) {
/*  866 */     return new RangeEntryMap(paramK1, paramK2);
/*      */   }
/*      */   
/*      */   public SortedMap<K, V> tailMap(K paramK) {
/*  870 */     return new RangeEntryMap(paramK, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   TrieEntry<K, V> higherEntry(K paramK) {
/*  881 */     int i = lengthInBits(paramK);
/*      */     
/*  883 */     if (i == 0) {
/*  884 */       if (!this.root.isEmpty()) {
/*      */         
/*  886 */         if (size() > 1) {
/*  887 */           return nextEntry(this.root);
/*      */         }
/*      */         
/*  890 */         return null;
/*      */       } 
/*      */       
/*  893 */       return firstEntry();
/*      */     } 
/*      */     
/*  896 */     TrieEntry<K, V> trieEntry = getNearestEntryForKey(paramK, i);
/*  897 */     if (compareKeys(paramK, trieEntry.key)) {
/*  898 */       return nextEntry(trieEntry);
/*      */     }
/*      */     
/*  901 */     int j = bitIndex(paramK, trieEntry.key);
/*  902 */     if (KeyAnalyzer.isValidBitIndex(j)) {
/*  903 */       TrieEntry<K, Object> trieEntry1 = new TrieEntry<K, Object>(paramK, null, j);
/*  904 */       addEntry((TrieEntry)trieEntry1, i);
/*  905 */       incrementSize();
/*  906 */       TrieEntry<K, V> trieEntry2 = nextEntry((TrieEntry)trieEntry1);
/*  907 */       removeEntry((TrieEntry)trieEntry1);
/*  908 */       this.modCount -= 2;
/*  909 */       return trieEntry2;
/*  910 */     }  if (KeyAnalyzer.isNullBitKey(j)) {
/*  911 */       if (!this.root.isEmpty())
/*  912 */         return firstEntry(); 
/*  913 */       if (size() > 1) {
/*  914 */         return nextEntry(firstEntry());
/*      */       }
/*  916 */       return null;
/*      */     } 
/*  918 */     if (KeyAnalyzer.isEqualBitKey(j)) {
/*  919 */       return nextEntry(trieEntry);
/*      */     }
/*      */ 
/*      */     
/*  923 */     throw new IllegalStateException("invalid lookup: " + paramK);
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
/*      */   TrieEntry<K, V> ceilingEntry(K paramK) {
/*  949 */     int i = lengthInBits(paramK);
/*      */     
/*  951 */     if (i == 0) {
/*  952 */       if (!this.root.isEmpty()) {
/*  953 */         return this.root;
/*      */       }
/*  955 */       return firstEntry();
/*      */     } 
/*      */     
/*  958 */     TrieEntry<K, V> trieEntry = getNearestEntryForKey(paramK, i);
/*  959 */     if (compareKeys(paramK, trieEntry.key)) {
/*  960 */       return trieEntry;
/*      */     }
/*      */     
/*  963 */     int j = bitIndex(paramK, trieEntry.key);
/*  964 */     if (KeyAnalyzer.isValidBitIndex(j)) {
/*  965 */       TrieEntry<K, Object> trieEntry1 = new TrieEntry<K, Object>(paramK, null, j);
/*  966 */       addEntry((TrieEntry)trieEntry1, i);
/*  967 */       incrementSize();
/*  968 */       TrieEntry<K, V> trieEntry2 = nextEntry((TrieEntry)trieEntry1);
/*  969 */       removeEntry((TrieEntry)trieEntry1);
/*  970 */       this.modCount -= 2;
/*  971 */       return trieEntry2;
/*  972 */     }  if (KeyAnalyzer.isNullBitKey(j)) {
/*  973 */       if (!this.root.isEmpty()) {
/*  974 */         return this.root;
/*      */       }
/*  976 */       return firstEntry();
/*  977 */     }  if (KeyAnalyzer.isEqualBitKey(j)) {
/*  978 */       return trieEntry;
/*      */     }
/*      */ 
/*      */     
/*  982 */     throw new IllegalStateException("invalid lookup: " + paramK);
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
/*      */   TrieEntry<K, V> lowerEntry(K paramK) {
/* 1007 */     int i = lengthInBits(paramK);
/*      */     
/* 1009 */     if (i == 0) {
/* 1010 */       return null;
/*      */     }
/*      */     
/* 1013 */     TrieEntry<K, V> trieEntry = getNearestEntryForKey(paramK, i);
/* 1014 */     if (compareKeys(paramK, trieEntry.key)) {
/* 1015 */       return previousEntry(trieEntry);
/*      */     }
/*      */     
/* 1018 */     int j = bitIndex(paramK, trieEntry.key);
/* 1019 */     if (KeyAnalyzer.isValidBitIndex(j)) {
/* 1020 */       TrieEntry<K, Object> trieEntry1 = new TrieEntry<K, Object>(paramK, null, j);
/* 1021 */       addEntry((TrieEntry)trieEntry1, i);
/* 1022 */       incrementSize();
/* 1023 */       TrieEntry<K, V> trieEntry2 = previousEntry((TrieEntry)trieEntry1);
/* 1024 */       removeEntry((TrieEntry)trieEntry1);
/* 1025 */       this.modCount -= 2;
/* 1026 */       return trieEntry2;
/* 1027 */     }  if (KeyAnalyzer.isNullBitKey(j))
/* 1028 */       return null; 
/* 1029 */     if (KeyAnalyzer.isEqualBitKey(j)) {
/* 1030 */       return previousEntry(trieEntry);
/*      */     }
/*      */ 
/*      */     
/* 1034 */     throw new IllegalStateException("invalid lookup: " + paramK);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   TrieEntry<K, V> floorEntry(K paramK) {
/* 1045 */     int i = lengthInBits(paramK);
/*      */     
/* 1047 */     if (i == 0) {
/* 1048 */       if (!this.root.isEmpty()) {
/* 1049 */         return this.root;
/*      */       }
/* 1051 */       return null;
/*      */     } 
/*      */     
/* 1054 */     TrieEntry<K, V> trieEntry = getNearestEntryForKey(paramK, i);
/* 1055 */     if (compareKeys(paramK, trieEntry.key)) {
/* 1056 */       return trieEntry;
/*      */     }
/*      */     
/* 1059 */     int j = bitIndex(paramK, trieEntry.key);
/* 1060 */     if (KeyAnalyzer.isValidBitIndex(j)) {
/* 1061 */       TrieEntry<K, Object> trieEntry1 = new TrieEntry<K, Object>(paramK, null, j);
/* 1062 */       addEntry((TrieEntry)trieEntry1, i);
/* 1063 */       incrementSize();
/* 1064 */       TrieEntry<K, V> trieEntry2 = previousEntry((TrieEntry)trieEntry1);
/* 1065 */       removeEntry((TrieEntry)trieEntry1);
/* 1066 */       this.modCount -= 2;
/* 1067 */       return trieEntry2;
/* 1068 */     }  if (KeyAnalyzer.isNullBitKey(j)) {
/* 1069 */       if (!this.root.isEmpty()) {
/* 1070 */         return this.root;
/*      */       }
/* 1072 */       return null;
/* 1073 */     }  if (KeyAnalyzer.isEqualBitKey(j)) {
/* 1074 */       return trieEntry;
/*      */     }
/*      */ 
/*      */     
/* 1078 */     throw new IllegalStateException("invalid lookup: " + paramK);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   TrieEntry<K, V> subtree(K paramK, int paramInt1, int paramInt2) {
/* 1088 */     TrieEntry<K, V> trieEntry1 = this.root.left;
/* 1089 */     TrieEntry<K, V> trieEntry2 = this.root;
/*      */     
/* 1091 */     while (trieEntry1.bitIndex > trieEntry2.bitIndex && paramInt2 > trieEntry1.bitIndex) {
/*      */ 
/*      */ 
/*      */       
/* 1095 */       trieEntry2 = trieEntry1;
/* 1096 */       if (!isBitSet(paramK, paramInt1 + trieEntry1.bitIndex, paramInt1 + paramInt2)) {
/* 1097 */         trieEntry1 = trieEntry1.left; continue;
/*      */       } 
/* 1099 */       trieEntry1 = trieEntry1.right;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1104 */     TrieEntry<K, V> trieEntry3 = trieEntry1.isEmpty() ? trieEntry2 : trieEntry1;
/*      */ 
/*      */     
/* 1107 */     if (trieEntry3.isEmpty()) {
/* 1108 */       return null;
/*      */     }
/*      */     
/* 1111 */     int i = paramInt1 + paramInt2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1117 */     if (trieEntry3 == this.root && lengthInBits(trieEntry3.getKey()) < i) {
/* 1118 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1123 */     if (isBitSet(paramK, i - 1, i) != isBitSet(trieEntry3.key, paramInt2 - 1, lengthInBits(trieEntry3.key)))
/*      */     {
/* 1125 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 1129 */     int j = getKeyAnalyzer().bitIndex(paramK, paramInt1, paramInt2, trieEntry3.key, 0, lengthInBits(trieEntry3.getKey()));
/*      */ 
/*      */     
/* 1132 */     if (j >= 0 && j < paramInt2) {
/* 1133 */       return null;
/*      */     }
/*      */     
/* 1136 */     return trieEntry3;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   TrieEntry<K, V> lastEntry() {
/* 1146 */     return followRight(this.root.left);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   TrieEntry<K, V> followRight(TrieEntry<K, V> paramTrieEntry) {
/* 1154 */     if (paramTrieEntry.right == null) {
/* 1155 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 1159 */     while (paramTrieEntry.right.bitIndex > paramTrieEntry.bitIndex) {
/* 1160 */       paramTrieEntry = paramTrieEntry.right;
/*      */     }
/*      */     
/* 1163 */     return paramTrieEntry.right;
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
/*      */   TrieEntry<K, V> previousEntry(TrieEntry<K, V> paramTrieEntry) {
/* 1186 */     if (paramTrieEntry.predecessor == null) {
/* 1187 */       throw new IllegalArgumentException("must have come from somewhere!");
/*      */     }
/*      */     
/* 1190 */     if (paramTrieEntry.predecessor.right == paramTrieEntry) {
/* 1191 */       if (isValidUplink(paramTrieEntry.predecessor.left, paramTrieEntry.predecessor)) {
/* 1192 */         return paramTrieEntry.predecessor.left;
/*      */       }
/* 1194 */       return followRight(paramTrieEntry.predecessor.left);
/*      */     } 
/* 1196 */     TrieEntry<K, V> trieEntry = paramTrieEntry.predecessor;
/* 1197 */     while (trieEntry.parent != null && trieEntry == trieEntry.parent.left) {
/* 1198 */       trieEntry = trieEntry.parent;
/*      */     }
/*      */     
/* 1201 */     if (trieEntry.parent == null) {
/* 1202 */       return null;
/*      */     }
/*      */     
/* 1205 */     if (isValidUplink(trieEntry.parent.left, trieEntry.parent)) {
/* 1206 */       if (trieEntry.parent.left == this.root) {
/* 1207 */         if (this.root.isEmpty()) {
/* 1208 */           return null;
/*      */         }
/* 1210 */         return this.root;
/*      */       } 
/*      */       
/* 1213 */       return trieEntry.parent.left;
/*      */     } 
/* 1215 */     return followRight(trieEntry.parent.left);
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
/*      */   TrieEntry<K, V> nextEntryInSubtree(TrieEntry<K, V> paramTrieEntry1, TrieEntry<K, V> paramTrieEntry2) {
/* 1227 */     if (paramTrieEntry1 == null) {
/* 1228 */       return firstEntry();
/*      */     }
/* 1230 */     return nextEntryImpl(paramTrieEntry1.predecessor, paramTrieEntry1, paramTrieEntry2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static boolean isValidUplink(TrieEntry<?, ?> paramTrieEntry1, TrieEntry<?, ?> paramTrieEntry2) {
/* 1237 */     return (paramTrieEntry1 != null && paramTrieEntry1.bitIndex <= paramTrieEntry2.bitIndex && !paramTrieEntry1.isEmpty());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static class Reference<E>
/*      */   {
/*      */     private E item;
/*      */ 
/*      */ 
/*      */     
/*      */     private Reference() {}
/*      */ 
/*      */     
/*      */     public void set(E param1E) {
/* 1252 */       this.item = param1E;
/*      */     }
/*      */     
/*      */     public E get() {
/* 1256 */       return this.item;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected static class TrieEntry<K, V>
/*      */     extends AbstractBitwiseTrie.BasicEntry<K, V>
/*      */   {
/*      */     private static final long serialVersionUID = 4596023148184140013L;
/*      */ 
/*      */     
/*      */     protected int bitIndex;
/*      */ 
/*      */     
/*      */     protected TrieEntry<K, V> parent;
/*      */ 
/*      */     
/*      */     protected TrieEntry<K, V> left;
/*      */ 
/*      */     
/*      */     protected TrieEntry<K, V> right;
/*      */     
/*      */     protected TrieEntry<K, V> predecessor;
/*      */ 
/*      */     
/*      */     public TrieEntry(K param1K, V param1V, int param1Int) {
/* 1283 */       super(param1K, param1V);
/*      */       
/* 1285 */       this.bitIndex = param1Int;
/*      */       
/* 1287 */       this.parent = null;
/* 1288 */       this.left = this;
/* 1289 */       this.right = null;
/* 1290 */       this.predecessor = this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isEmpty() {
/* 1299 */       return (this.key == null);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isInternalNode() {
/* 1306 */       return (this.left != this && this.right != this);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isExternalNode() {
/* 1313 */       return !isInternalNode();
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1318 */       StringBuilder stringBuilder = new StringBuilder();
/*      */       
/* 1320 */       if (this.bitIndex == -1) {
/* 1321 */         stringBuilder.append("RootEntry(");
/*      */       } else {
/* 1323 */         stringBuilder.append("Entry(");
/*      */       } 
/*      */       
/* 1326 */       stringBuilder.append("key=").append(getKey()).append(" [").append(this.bitIndex).append("], ");
/* 1327 */       stringBuilder.append("value=").append(getValue()).append(", ");
/*      */ 
/*      */       
/* 1330 */       if (this.parent != null) {
/* 1331 */         if (this.parent.bitIndex == -1) {
/* 1332 */           stringBuilder.append("parent=").append("ROOT");
/*      */         } else {
/* 1334 */           stringBuilder.append("parent=").append(this.parent.getKey()).append(" [").append(this.parent.bitIndex).append("]");
/*      */         } 
/*      */       } else {
/* 1337 */         stringBuilder.append("parent=").append("null");
/*      */       } 
/* 1339 */       stringBuilder.append(", ");
/*      */       
/* 1341 */       if (this.left != null) {
/* 1342 */         if (this.left.bitIndex == -1) {
/* 1343 */           stringBuilder.append("left=").append("ROOT");
/*      */         } else {
/* 1345 */           stringBuilder.append("left=").append(this.left.getKey()).append(" [").append(this.left.bitIndex).append("]");
/*      */         } 
/*      */       } else {
/* 1348 */         stringBuilder.append("left=").append("null");
/*      */       } 
/* 1350 */       stringBuilder.append(", ");
/*      */       
/* 1352 */       if (this.right != null) {
/* 1353 */         if (this.right.bitIndex == -1) {
/* 1354 */           stringBuilder.append("right=").append("ROOT");
/*      */         } else {
/* 1356 */           stringBuilder.append("right=").append(this.right.getKey()).append(" [").append(this.right.bitIndex).append("]");
/*      */         } 
/*      */       } else {
/* 1359 */         stringBuilder.append("right=").append("null");
/*      */       } 
/* 1361 */       stringBuilder.append(", ");
/*      */       
/* 1363 */       if (this.predecessor != null) {
/* 1364 */         if (this.predecessor.bitIndex == -1) {
/* 1365 */           stringBuilder.append("predecessor=").append("ROOT");
/*      */         } else {
/* 1367 */           stringBuilder.append("predecessor=").append(this.predecessor.getKey()).append(" [").append(this.predecessor.bitIndex).append("]");
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/* 1372 */       stringBuilder.append(")");
/* 1373 */       return stringBuilder.toString();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private class EntrySet
/*      */     extends AbstractSet<Map.Entry<K, V>>
/*      */   {
/*      */     private EntrySet() {}
/*      */ 
/*      */     
/*      */     public Iterator<Map.Entry<K, V>> iterator() {
/* 1385 */       return new EntryIterator();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean contains(Object param1Object) {
/* 1390 */       if (!(param1Object instanceof Map.Entry)) {
/* 1391 */         return false;
/*      */       }
/*      */       
/* 1394 */       AbstractPatriciaTrie.TrieEntry trieEntry = AbstractPatriciaTrie.this.getEntry(((Map.Entry)param1Object).getKey());
/* 1395 */       return (trieEntry != null && trieEntry.equals(param1Object));
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object) {
/* 1400 */       if (!(param1Object instanceof Map.Entry)) {
/* 1401 */         return false;
/*      */       }
/* 1403 */       if (!contains(param1Object)) {
/* 1404 */         return false;
/*      */       }
/* 1406 */       Map.Entry entry = (Map.Entry)param1Object;
/* 1407 */       AbstractPatriciaTrie.this.remove(entry.getKey());
/* 1408 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/* 1413 */       return AbstractPatriciaTrie.this.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/* 1418 */       AbstractPatriciaTrie.this.clear();
/*      */     }
/*      */     
/*      */     private class EntryIterator
/*      */       extends AbstractPatriciaTrie<K, V>.TrieIterator<Map.Entry<K, V>> {
/*      */       private EntryIterator() {}
/*      */       
/*      */       public Map.Entry<K, V> next() {
/* 1426 */         return nextEntry();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private class KeySet
/*      */     extends AbstractSet<K>
/*      */   {
/*      */     private KeySet() {}
/*      */     
/*      */     public Iterator<K> iterator() {
/* 1438 */       return new KeyIterator();
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/* 1443 */       return AbstractPatriciaTrie.this.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean contains(Object param1Object) {
/* 1448 */       return AbstractPatriciaTrie.this.containsKey(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object) {
/* 1453 */       int i = size();
/* 1454 */       AbstractPatriciaTrie.this.remove(param1Object);
/* 1455 */       return (i != size());
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/* 1460 */       AbstractPatriciaTrie.this.clear();
/*      */     }
/*      */     
/*      */     private class KeyIterator
/*      */       extends AbstractPatriciaTrie<K, V>.TrieIterator<K> {
/*      */       private KeyIterator() {}
/*      */       
/*      */       public K next() {
/* 1468 */         return (K)nextEntry().getKey();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private class Values
/*      */     extends AbstractCollection<V>
/*      */   {
/*      */     private Values() {}
/*      */     
/*      */     public Iterator<V> iterator() {
/* 1480 */       return new ValueIterator();
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/* 1485 */       return AbstractPatriciaTrie.this.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean contains(Object param1Object) {
/* 1490 */       return AbstractPatriciaTrie.this.containsValue(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/* 1495 */       AbstractPatriciaTrie.this.clear();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object) {
/* 1500 */       for (Iterator<V> iterator = iterator(); iterator.hasNext(); ) {
/* 1501 */         V v = iterator.next();
/* 1502 */         if (AbstractBitwiseTrie.compare(v, param1Object)) {
/* 1503 */           iterator.remove();
/* 1504 */           return true;
/*      */         } 
/*      */       } 
/* 1507 */       return false;
/*      */     }
/*      */     
/*      */     private class ValueIterator
/*      */       extends AbstractPatriciaTrie<K, V>.TrieIterator<V> {
/*      */       private ValueIterator() {}
/*      */       
/*      */       public V next() {
/* 1515 */         return (V)nextEntry().getValue();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   abstract class TrieIterator<E>
/*      */     implements Iterator<E>
/*      */   {
/* 1526 */     protected int expectedModCount = AbstractPatriciaTrie.this.modCount;
/*      */ 
/*      */     
/*      */     protected AbstractPatriciaTrie.TrieEntry<K, V> next;
/*      */     
/*      */     protected AbstractPatriciaTrie.TrieEntry<K, V> current;
/*      */ 
/*      */     
/*      */     protected TrieIterator() {
/* 1535 */       this.next = AbstractPatriciaTrie.this.nextEntry((AbstractPatriciaTrie.TrieEntry<K, V>)null);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected TrieIterator(AbstractPatriciaTrie.TrieEntry<K, V> param1TrieEntry) {
/* 1542 */       this.next = param1TrieEntry;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected AbstractPatriciaTrie.TrieEntry<K, V> nextEntry() {
/* 1549 */       if (this.expectedModCount != AbstractPatriciaTrie.this.modCount) {
/* 1550 */         throw new ConcurrentModificationException();
/*      */       }
/*      */       
/* 1553 */       AbstractPatriciaTrie.TrieEntry<K, V> trieEntry = this.next;
/* 1554 */       if (trieEntry == null) {
/* 1555 */         throw new NoSuchElementException();
/*      */       }
/*      */       
/* 1558 */       this.next = findNext(trieEntry);
/* 1559 */       this.current = trieEntry;
/* 1560 */       return trieEntry;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected AbstractPatriciaTrie.TrieEntry<K, V> findNext(AbstractPatriciaTrie.TrieEntry<K, V> param1TrieEntry) {
/* 1567 */       return AbstractPatriciaTrie.this.nextEntry(param1TrieEntry);
/*      */     }
/*      */     
/*      */     public boolean hasNext() {
/* 1571 */       return (this.next != null);
/*      */     }
/*      */     
/*      */     public void remove() {
/* 1575 */       if (this.current == null) {
/* 1576 */         throw new IllegalStateException();
/*      */       }
/*      */       
/* 1579 */       if (this.expectedModCount != AbstractPatriciaTrie.this.modCount) {
/* 1580 */         throw new ConcurrentModificationException();
/*      */       }
/*      */       
/* 1583 */       AbstractPatriciaTrie.TrieEntry<K, V> trieEntry = this.current;
/* 1584 */       this.current = null;
/* 1585 */       AbstractPatriciaTrie.this.removeEntry(trieEntry);
/*      */       
/* 1587 */       this.expectedModCount = AbstractPatriciaTrie.this.modCount;
/*      */     }
/*      */   }
/*      */   
/*      */   private class TrieMapIterator
/*      */     extends TrieIterator<K>
/*      */     implements OrderedMapIterator<K, V> {
/*      */     protected AbstractPatriciaTrie.TrieEntry<K, V> previous;
/*      */     
/*      */     private TrieMapIterator() {}
/*      */     
/*      */     public K next() {
/* 1599 */       return nextEntry().getKey();
/*      */     }
/*      */     
/*      */     public K getKey() {
/* 1603 */       if (this.current == null) {
/* 1604 */         throw new IllegalStateException();
/*      */       }
/* 1606 */       return (K)this.current.getKey();
/*      */     }
/*      */     
/*      */     public V getValue() {
/* 1610 */       if (this.current == null) {
/* 1611 */         throw new IllegalStateException();
/*      */       }
/* 1613 */       return (V)this.current.getValue();
/*      */     }
/*      */     
/*      */     public V setValue(V param1V) {
/* 1617 */       if (this.current == null) {
/* 1618 */         throw new IllegalStateException();
/*      */       }
/* 1620 */       return (V)this.current.setValue(param1V);
/*      */     }
/*      */     
/*      */     public boolean hasPrevious() {
/* 1624 */       return (this.previous != null);
/*      */     }
/*      */     
/*      */     public K previous() {
/* 1628 */       return previousEntry().getKey();
/*      */     }
/*      */ 
/*      */     
/*      */     protected AbstractPatriciaTrie.TrieEntry<K, V> nextEntry() {
/* 1633 */       AbstractPatriciaTrie.TrieEntry<K, V> trieEntry = super.nextEntry();
/* 1634 */       this.previous = trieEntry;
/* 1635 */       return trieEntry;
/*      */     }
/*      */     
/*      */     protected AbstractPatriciaTrie.TrieEntry<K, V> previousEntry() {
/* 1639 */       if (this.expectedModCount != AbstractPatriciaTrie.this.modCount) {
/* 1640 */         throw new ConcurrentModificationException();
/*      */       }
/*      */       
/* 1643 */       AbstractPatriciaTrie.TrieEntry<K, V> trieEntry = this.previous;
/* 1644 */       if (trieEntry == null) {
/* 1645 */         throw new NoSuchElementException();
/*      */       }
/*      */       
/* 1648 */       this.previous = AbstractPatriciaTrie.this.previousEntry(trieEntry);
/* 1649 */       this.next = this.current;
/* 1650 */       this.current = trieEntry;
/* 1651 */       return this.current;
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
/*      */   private abstract class RangeMap
/*      */     extends AbstractMap<K, V>
/*      */     implements SortedMap<K, V>
/*      */   {
/*      */     private volatile transient Set<Map.Entry<K, V>> entrySet;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private RangeMap() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Comparator<? super K> comparator() {
/* 1691 */       return AbstractPatriciaTrie.this.comparator();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean containsKey(Object param1Object) {
/* 1696 */       if (!inRange((K)AbstractPatriciaTrie.this.castKey(param1Object))) {
/* 1697 */         return false;
/*      */       }
/*      */       
/* 1700 */       return AbstractPatriciaTrie.this.containsKey(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public V remove(Object param1Object) {
/* 1705 */       if (!inRange((K)AbstractPatriciaTrie.this.castKey(param1Object))) {
/* 1706 */         return null;
/*      */       }
/*      */       
/* 1709 */       return (V)AbstractPatriciaTrie.this.remove(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public V get(Object param1Object) {
/* 1714 */       if (!inRange((K)AbstractPatriciaTrie.this.castKey(param1Object))) {
/* 1715 */         return null;
/*      */       }
/*      */       
/* 1718 */       return (V)AbstractPatriciaTrie.this.get(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public V put(K param1K, V param1V) {
/* 1723 */       if (!inRange(param1K)) {
/* 1724 */         throw new IllegalArgumentException("Key is out of range: " + param1K);
/*      */       }
/* 1726 */       return AbstractPatriciaTrie.this.put(param1K, param1V);
/*      */     }
/*      */ 
/*      */     
/*      */     public Set<Map.Entry<K, V>> entrySet() {
/* 1731 */       if (this.entrySet == null) {
/* 1732 */         this.entrySet = createEntrySet();
/*      */       }
/* 1734 */       return this.entrySet;
/*      */     }
/*      */     
/*      */     public SortedMap<K, V> subMap(K param1K1, K param1K2) {
/* 1738 */       if (!inRange2(param1K1)) {
/* 1739 */         throw new IllegalArgumentException("FromKey is out of range: " + param1K1);
/*      */       }
/*      */       
/* 1742 */       if (!inRange2(param1K2)) {
/* 1743 */         throw new IllegalArgumentException("ToKey is out of range: " + param1K2);
/*      */       }
/*      */       
/* 1746 */       return createRangeMap(param1K1, isFromInclusive(), param1K2, isToInclusive());
/*      */     }
/*      */     
/*      */     public SortedMap<K, V> headMap(K param1K) {
/* 1750 */       if (!inRange2(param1K)) {
/* 1751 */         throw new IllegalArgumentException("ToKey is out of range: " + param1K);
/*      */       }
/* 1753 */       return createRangeMap(getFromKey(), isFromInclusive(), param1K, isToInclusive());
/*      */     }
/*      */     
/*      */     public SortedMap<K, V> tailMap(K param1K) {
/* 1757 */       if (!inRange2(param1K)) {
/* 1758 */         throw new IllegalArgumentException("FromKey is out of range: " + param1K);
/*      */       }
/* 1760 */       return createRangeMap(param1K, isFromInclusive(), getToKey(), isToInclusive());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean inRange(K param1K) {
/* 1767 */       K k1 = getFromKey();
/* 1768 */       K k2 = getToKey();
/*      */       
/* 1770 */       return ((k1 == null || inFromRange(param1K, false)) && (k2 == null || inToRange(param1K, false)));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean inRange2(K param1K) {
/* 1777 */       K k1 = getFromKey();
/* 1778 */       K k2 = getToKey();
/*      */       
/* 1780 */       return ((k1 == null || inFromRange(param1K, false)) && (k2 == null || inToRange(param1K, true)));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean inFromRange(K param1K, boolean param1Boolean) {
/* 1787 */       K k = getFromKey();
/* 1788 */       boolean bool = isFromInclusive();
/*      */       
/* 1790 */       int i = AbstractPatriciaTrie.this.getKeyAnalyzer().compare(param1K, k);
/* 1791 */       if (bool || param1Boolean) {
/* 1792 */         return (i >= 0);
/*      */       }
/* 1794 */       return (i > 0);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean inToRange(K param1K, boolean param1Boolean) {
/* 1801 */       K k = getToKey();
/* 1802 */       boolean bool = isToInclusive();
/*      */       
/* 1804 */       int i = AbstractPatriciaTrie.this.getKeyAnalyzer().compare(param1K, k);
/* 1805 */       if (bool || param1Boolean) {
/* 1806 */         return (i <= 0);
/*      */       }
/* 1808 */       return (i < 0);
/*      */     }
/*      */ 
/*      */     
/*      */     protected abstract Set<Map.Entry<K, V>> createEntrySet();
/*      */ 
/*      */     
/*      */     protected abstract K getFromKey();
/*      */ 
/*      */     
/*      */     protected abstract boolean isFromInclusive();
/*      */ 
/*      */     
/*      */     protected abstract K getToKey();
/*      */ 
/*      */     
/*      */     protected abstract boolean isToInclusive();
/*      */ 
/*      */     
/*      */     protected abstract SortedMap<K, V> createRangeMap(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2);
/*      */   }
/*      */ 
/*      */   
/*      */   private class RangeEntryMap
/*      */     extends RangeMap
/*      */   {
/*      */     private final K fromKey;
/*      */     private final K toKey;
/*      */     private final boolean fromInclusive;
/*      */     private final boolean toInclusive;
/*      */     
/*      */     protected RangeEntryMap(K param1K1, K param1K2) {
/* 1840 */       this(param1K1, true, param1K2, false);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected RangeEntryMap(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
/* 1849 */       if (param1K1 == null && param1K2 == null) {
/* 1850 */         throw new IllegalArgumentException("must have a from or to!");
/*      */       }
/*      */       
/* 1853 */       if (param1K1 != null && param1K2 != null && AbstractPatriciaTrie.this.getKeyAnalyzer().compare(param1K1, param1K2) > 0) {
/* 1854 */         throw new IllegalArgumentException("fromKey > toKey");
/*      */       }
/*      */       
/* 1857 */       this.fromKey = param1K1;
/* 1858 */       this.fromInclusive = param1Boolean1;
/* 1859 */       this.toKey = param1K2;
/* 1860 */       this.toInclusive = param1Boolean2;
/*      */     }
/*      */     
/*      */     public K firstKey() {
/* 1864 */       AbstractPatriciaTrie.TrieEntry trieEntry = null;
/* 1865 */       if (this.fromKey == null) {
/* 1866 */         trieEntry = AbstractPatriciaTrie.this.firstEntry();
/*      */       }
/* 1868 */       else if (this.fromInclusive) {
/* 1869 */         trieEntry = AbstractPatriciaTrie.this.ceilingEntry(this.fromKey);
/*      */       } else {
/* 1871 */         trieEntry = AbstractPatriciaTrie.this.higherEntry(this.fromKey);
/*      */       } 
/*      */ 
/*      */       
/* 1875 */       K k = (trieEntry != null) ? (K)trieEntry.getKey() : null;
/* 1876 */       if (trieEntry == null || (this.toKey != null && !inToRange(k, false))) {
/* 1877 */         throw new NoSuchElementException();
/*      */       }
/* 1879 */       return k;
/*      */     }
/*      */     
/*      */     public K lastKey() {
/*      */       AbstractPatriciaTrie.TrieEntry trieEntry;
/* 1884 */       if (this.toKey == null) {
/* 1885 */         trieEntry = AbstractPatriciaTrie.this.lastEntry();
/*      */       }
/* 1887 */       else if (this.toInclusive) {
/* 1888 */         trieEntry = AbstractPatriciaTrie.this.floorEntry(this.toKey);
/*      */       } else {
/* 1890 */         trieEntry = AbstractPatriciaTrie.this.lowerEntry(this.toKey);
/*      */       } 
/*      */ 
/*      */       
/* 1894 */       K k = (trieEntry != null) ? (K)trieEntry.getKey() : null;
/* 1895 */       if (trieEntry == null || (this.fromKey != null && !inFromRange(k, false))) {
/* 1896 */         throw new NoSuchElementException();
/*      */       }
/* 1898 */       return k;
/*      */     }
/*      */ 
/*      */     
/*      */     protected Set<Map.Entry<K, V>> createEntrySet() {
/* 1903 */       return new AbstractPatriciaTrie.RangeEntrySet(this);
/*      */     }
/*      */ 
/*      */     
/*      */     public K getFromKey() {
/* 1908 */       return this.fromKey;
/*      */     }
/*      */ 
/*      */     
/*      */     public K getToKey() {
/* 1913 */       return this.toKey;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isFromInclusive() {
/* 1918 */       return this.fromInclusive;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isToInclusive() {
/* 1923 */       return this.toInclusive;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected SortedMap<K, V> createRangeMap(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
/* 1929 */       return new RangeEntryMap(param1K1, param1Boolean1, param1K2, param1Boolean2);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private class RangeEntrySet
/*      */     extends AbstractSet<Map.Entry<K, V>>
/*      */   {
/*      */     private final AbstractPatriciaTrie<K, V>.RangeMap delegate;
/*      */     
/* 1940 */     private transient int size = -1;
/*      */ 
/*      */     
/*      */     private transient int expectedModCount;
/*      */ 
/*      */ 
/*      */     
/*      */     public RangeEntrySet(AbstractPatriciaTrie<K, V>.RangeMap param1RangeMap) {
/* 1948 */       if (param1RangeMap == null) {
/* 1949 */         throw new NullPointerException("delegate");
/*      */       }
/*      */       
/* 1952 */       this.delegate = param1RangeMap;
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<Map.Entry<K, V>> iterator() {
/* 1957 */       K k1 = this.delegate.getFromKey();
/* 1958 */       K k2 = this.delegate.getToKey();
/*      */       
/* 1960 */       AbstractPatriciaTrie.TrieEntry trieEntry1 = null;
/* 1961 */       if (k1 == null) {
/* 1962 */         trieEntry1 = AbstractPatriciaTrie.this.firstEntry();
/*      */       } else {
/* 1964 */         trieEntry1 = AbstractPatriciaTrie.this.ceilingEntry(k1);
/*      */       } 
/*      */       
/* 1967 */       AbstractPatriciaTrie.TrieEntry trieEntry2 = null;
/* 1968 */       if (k2 != null) {
/* 1969 */         trieEntry2 = AbstractPatriciaTrie.this.ceilingEntry(k2);
/*      */       }
/*      */       
/* 1972 */       return new EntryIterator(trieEntry1, trieEntry2);
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/* 1977 */       if (this.size == -1 || this.expectedModCount != AbstractPatriciaTrie.this.modCount) {
/* 1978 */         this.size = 0;
/*      */         
/* 1980 */         for (Iterator<Map.Entry<K, V>> iterator = iterator(); iterator.hasNext(); iterator.next()) {
/* 1981 */           this.size++;
/*      */         }
/*      */         
/* 1984 */         this.expectedModCount = AbstractPatriciaTrie.this.modCount;
/*      */       } 
/* 1986 */       return this.size;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isEmpty() {
/* 1991 */       return !iterator().hasNext();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean contains(Object param1Object) {
/* 1997 */       if (!(param1Object instanceof Map.Entry)) {
/* 1998 */         return false;
/*      */       }
/*      */       
/* 2001 */       Map.Entry entry = (Map.Entry)param1Object;
/* 2002 */       Object object = entry.getKey();
/* 2003 */       if (!this.delegate.inRange((K)object)) {
/* 2004 */         return false;
/*      */       }
/*      */       
/* 2007 */       AbstractPatriciaTrie.TrieEntry trieEntry = AbstractPatriciaTrie.this.getEntry(object);
/* 2008 */       return (trieEntry != null && AbstractBitwiseTrie.compare(trieEntry.getValue(), entry.getValue()));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object) {
/* 2014 */       if (!(param1Object instanceof Map.Entry)) {
/* 2015 */         return false;
/*      */       }
/*      */       
/* 2018 */       Map.Entry entry = (Map.Entry)param1Object;
/* 2019 */       Object object = entry.getKey();
/* 2020 */       if (!this.delegate.inRange((K)object)) {
/* 2021 */         return false;
/*      */       }
/*      */       
/* 2024 */       AbstractPatriciaTrie.TrieEntry trieEntry = AbstractPatriciaTrie.this.getEntry(object);
/* 2025 */       if (trieEntry != null && AbstractBitwiseTrie.compare(trieEntry.getValue(), entry.getValue())) {
/* 2026 */         AbstractPatriciaTrie.this.removeEntry(trieEntry);
/* 2027 */         return true;
/*      */       } 
/* 2029 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final class EntryIterator
/*      */       extends AbstractPatriciaTrie<K, V>.TrieIterator<Map.Entry<K, V>>
/*      */     {
/*      */       private final K excludedKey;
/*      */ 
/*      */ 
/*      */       
/*      */       private EntryIterator(AbstractPatriciaTrie.TrieEntry<K, V> param2TrieEntry1, AbstractPatriciaTrie.TrieEntry<K, V> param2TrieEntry2) {
/* 2043 */         super(param2TrieEntry1);
/* 2044 */         this.excludedKey = (param2TrieEntry2 != null) ? param2TrieEntry2.getKey() : null;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean hasNext() {
/* 2049 */         return (this.next != null && !AbstractBitwiseTrie.compare(this.next.key, this.excludedKey));
/*      */       }
/*      */       
/*      */       public Map.Entry<K, V> next() {
/* 2053 */         if (this.next == null || AbstractBitwiseTrie.compare(this.next.key, this.excludedKey)) {
/* 2054 */           throw new NoSuchElementException();
/*      */         }
/* 2056 */         return nextEntry();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private class PrefixRangeMap
/*      */     extends RangeMap
/*      */   {
/*      */     private final K prefix;
/*      */     
/*      */     private final int offsetInBits;
/*      */     
/*      */     private final int lengthInBits;
/*      */     
/* 2072 */     private K fromKey = null;
/*      */     
/* 2074 */     private K toKey = null;
/*      */     
/* 2076 */     private transient int expectedModCount = 0;
/*      */     
/* 2078 */     private int size = -1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private PrefixRangeMap(K param1K, int param1Int1, int param1Int2) {
/* 2084 */       this.prefix = param1K;
/* 2085 */       this.offsetInBits = param1Int1;
/* 2086 */       this.lengthInBits = param1Int2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int fixup() {
/* 2097 */       if (this.size == -1 || AbstractPatriciaTrie.this.modCount != this.expectedModCount) {
/* 2098 */         Iterator<Map.Entry<K, V>> iterator = entrySet().iterator();
/* 2099 */         this.size = 0;
/*      */         
/* 2101 */         Map.Entry entry = null;
/* 2102 */         if (iterator.hasNext()) {
/* 2103 */           entry = iterator.next();
/* 2104 */           this.size = 1;
/*      */         } 
/*      */         
/* 2107 */         this.fromKey = (entry == null) ? null : (K)entry.getKey();
/* 2108 */         if (this.fromKey != null) {
/* 2109 */           AbstractPatriciaTrie.TrieEntry trieEntry = AbstractPatriciaTrie.this.previousEntry((AbstractPatriciaTrie.TrieEntry)entry);
/* 2110 */           this.fromKey = (trieEntry == null) ? null : (K)trieEntry.getKey();
/*      */         } 
/*      */         
/* 2113 */         this.toKey = this.fromKey;
/*      */         
/* 2115 */         while (iterator.hasNext()) {
/* 2116 */           this.size++;
/* 2117 */           entry = iterator.next();
/*      */         } 
/*      */         
/* 2120 */         this.toKey = (entry == null) ? null : (K)entry.getKey();
/*      */         
/* 2122 */         if (this.toKey != null) {
/* 2123 */           entry = AbstractPatriciaTrie.this.nextEntry((AbstractPatriciaTrie.TrieEntry)entry);
/* 2124 */           this.toKey = (entry == null) ? null : (K)entry.getKey();
/*      */         } 
/*      */         
/* 2127 */         this.expectedModCount = AbstractPatriciaTrie.this.modCount;
/*      */       } 
/*      */       
/* 2130 */       return this.size;
/*      */     }
/*      */     
/*      */     public K firstKey() {
/* 2134 */       fixup();
/*      */       
/* 2136 */       AbstractPatriciaTrie.TrieEntry trieEntry = null;
/* 2137 */       if (this.fromKey == null) {
/* 2138 */         trieEntry = AbstractPatriciaTrie.this.firstEntry();
/*      */       } else {
/* 2140 */         trieEntry = AbstractPatriciaTrie.this.higherEntry(this.fromKey);
/*      */       } 
/*      */       
/* 2143 */       K k = (trieEntry != null) ? (K)trieEntry.getKey() : null;
/* 2144 */       if (trieEntry == null || !AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, k)) {
/* 2145 */         throw new NoSuchElementException();
/*      */       }
/*      */       
/* 2148 */       return k;
/*      */     }
/*      */     
/*      */     public K lastKey() {
/* 2152 */       fixup();
/*      */       
/* 2154 */       AbstractPatriciaTrie.TrieEntry trieEntry = null;
/* 2155 */       if (this.toKey == null) {
/* 2156 */         trieEntry = AbstractPatriciaTrie.this.lastEntry();
/*      */       } else {
/* 2158 */         trieEntry = AbstractPatriciaTrie.this.lowerEntry(this.toKey);
/*      */       } 
/*      */       
/* 2161 */       K k = (trieEntry != null) ? (K)trieEntry.getKey() : null;
/* 2162 */       if (trieEntry == null || !AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, k)) {
/* 2163 */         throw new NoSuchElementException();
/*      */       }
/*      */       
/* 2166 */       return k;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean inRange(K param1K) {
/* 2174 */       return AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, param1K);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean inRange2(K param1K) {
/* 2182 */       return inRange(param1K);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean inFromRange(K param1K, boolean param1Boolean) {
/* 2190 */       return AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, param1K);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean inToRange(K param1K, boolean param1Boolean) {
/* 2198 */       return AbstractPatriciaTrie.this.getKeyAnalyzer().isPrefix(this.prefix, this.offsetInBits, this.lengthInBits, param1K);
/*      */     }
/*      */ 
/*      */     
/*      */     protected Set<Map.Entry<K, V>> createEntrySet() {
/* 2203 */       return new AbstractPatriciaTrie.PrefixRangeEntrySet(this);
/*      */     }
/*      */ 
/*      */     
/*      */     public K getFromKey() {
/* 2208 */       return this.fromKey;
/*      */     }
/*      */ 
/*      */     
/*      */     public K getToKey() {
/* 2213 */       return this.toKey;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isFromInclusive() {
/* 2218 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isToInclusive() {
/* 2223 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected SortedMap<K, V> createRangeMap(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
/* 2229 */       return new AbstractPatriciaTrie.RangeEntryMap(param1K1, param1Boolean1, param1K2, param1Boolean2);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private final class PrefixRangeEntrySet
/*      */     extends RangeEntrySet
/*      */   {
/*      */     private final AbstractPatriciaTrie<K, V>.PrefixRangeMap delegate;
/*      */     
/*      */     private AbstractPatriciaTrie.TrieEntry<K, V> prefixStart;
/*      */     
/* 2242 */     private int expectedModCount = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public PrefixRangeEntrySet(AbstractPatriciaTrie<K, V>.PrefixRangeMap param1PrefixRangeMap) {
/* 2248 */       super(param1PrefixRangeMap);
/* 2249 */       this.delegate = param1PrefixRangeMap;
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/* 2254 */       return this.delegate.fixup();
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<Map.Entry<K, V>> iterator() {
/* 2259 */       if (AbstractPatriciaTrie.this.modCount != this.expectedModCount) {
/* 2260 */         this.prefixStart = AbstractPatriciaTrie.this.subtree(this.delegate.prefix, this.delegate.offsetInBits, this.delegate.lengthInBits);
/* 2261 */         this.expectedModCount = AbstractPatriciaTrie.this.modCount;
/*      */       } 
/*      */       
/* 2264 */       if (this.prefixStart == null) {
/* 2265 */         Set<?> set = Collections.emptySet();
/* 2266 */         return (Iterator)set.iterator();
/* 2267 */       }  if (this.delegate.lengthInBits > this.prefixStart.bitIndex) {
/* 2268 */         return new SingletonIterator(this.prefixStart);
/*      */       }
/* 2270 */       return new EntryIterator(this.prefixStart, this.delegate.prefix, this.delegate.offsetInBits, this.delegate.lengthInBits);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private final class SingletonIterator
/*      */       implements Iterator<Map.Entry<K, V>>
/*      */     {
/*      */       private final AbstractPatriciaTrie.TrieEntry<K, V> entry;
/*      */ 
/*      */       
/* 2281 */       private int hit = 0;
/*      */       
/*      */       public SingletonIterator(AbstractPatriciaTrie.TrieEntry<K, V> param2TrieEntry) {
/* 2284 */         this.entry = param2TrieEntry;
/*      */       }
/*      */       
/*      */       public boolean hasNext() {
/* 2288 */         return (this.hit == 0);
/*      */       }
/*      */       
/*      */       public Map.Entry<K, V> next() {
/* 2292 */         if (this.hit != 0) {
/* 2293 */           throw new NoSuchElementException();
/*      */         }
/*      */         
/* 2296 */         this.hit++;
/* 2297 */         return this.entry;
/*      */       }
/*      */       
/*      */       public void remove() {
/* 2301 */         if (this.hit != 1) {
/* 2302 */           throw new IllegalStateException();
/*      */         }
/*      */         
/* 2305 */         this.hit++;
/* 2306 */         AbstractPatriciaTrie.this.removeEntry(this.entry);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private final class EntryIterator
/*      */       extends AbstractPatriciaTrie<K, V>.TrieIterator<Map.Entry<K, V>>
/*      */     {
/*      */       private final K prefix;
/*      */ 
/*      */       
/*      */       private final int offset;
/*      */ 
/*      */       
/*      */       private final int lengthInBits;
/*      */       
/*      */       private boolean lastOne;
/*      */       
/*      */       private AbstractPatriciaTrie.TrieEntry<K, V> subtree;
/*      */ 
/*      */       
/*      */       EntryIterator(AbstractPatriciaTrie.TrieEntry<K, V> param2TrieEntry, K param2K, int param2Int1, int param2Int2) {
/* 2329 */         this.subtree = param2TrieEntry;
/* 2330 */         this.next = AbstractPatriciaTrie.this.followLeft(param2TrieEntry);
/* 2331 */         this.prefix = param2K;
/* 2332 */         this.offset = param2Int1;
/* 2333 */         this.lengthInBits = param2Int2;
/*      */       }
/*      */       
/*      */       public Map.Entry<K, V> next() {
/* 2337 */         AbstractPatriciaTrie.TrieEntry<K, V> trieEntry = nextEntry();
/* 2338 */         if (this.lastOne) {
/* 2339 */           this.next = null;
/*      */         }
/* 2341 */         return trieEntry;
/*      */       }
/*      */ 
/*      */       
/*      */       protected AbstractPatriciaTrie.TrieEntry<K, V> findNext(AbstractPatriciaTrie.TrieEntry<K, V> param2TrieEntry) {
/* 2346 */         return AbstractPatriciaTrie.this.nextEntryInSubtree(param2TrieEntry, this.subtree);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public void remove() {
/* 2353 */         boolean bool = false;
/* 2354 */         int i = this.subtree.bitIndex;
/* 2355 */         if (this.current == this.subtree) {
/* 2356 */           bool = true;
/*      */         }
/*      */         
/* 2359 */         super.remove();
/*      */ 
/*      */ 
/*      */         
/* 2363 */         if (i != this.subtree.bitIndex || bool) {
/* 2364 */           this.subtree = AbstractPatriciaTrie.this.subtree(this.prefix, this.offset, this.lengthInBits);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2370 */         if (this.lengthInBits >= this.subtree.bitIndex) {
/* 2371 */           this.lastOne = true;
/*      */         }
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
/*      */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 2384 */     paramObjectInputStream.defaultReadObject();
/* 2385 */     this.root = new TrieEntry<K, V>(null, null, -1);
/* 2386 */     int i = paramObjectInputStream.readInt();
/* 2387 */     for (byte b = 0; b < i; b++) {
/* 2388 */       Object object1 = paramObjectInputStream.readObject();
/* 2389 */       Object object2 = paramObjectInputStream.readObject();
/* 2390 */       put((K)object1, (V)object2);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 2398 */     paramObjectOutputStream.defaultWriteObject();
/* 2399 */     paramObjectOutputStream.writeInt(size());
/* 2400 */     for (Map.Entry<K, V> entry : entrySet()) {
/* 2401 */       paramObjectOutputStream.writeObject(entry.getKey());
/* 2402 */       paramObjectOutputStream.writeObject(entry.getValue());
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\trie\AbstractPatriciaTrie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */