/*      */ package com.google.a.d;
/*      */ 
/*      */ import com.google.a.a.b;
/*      */ import com.google.a.b.D;
/*      */ import java.io.Serializable;
/*      */ import java.util.AbstractCollection;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.ConcurrentModificationException;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.ListIterator;
/*      */ import java.util.Map;
/*      */ import java.util.NavigableMap;
/*      */ import java.util.NavigableSet;
/*      */ import java.util.RandomAccess;
/*      */ import java.util.Set;
/*      */ import java.util.SortedMap;
/*      */ import java.util.SortedSet;
/*      */ import java.util.Spliterator;
/*      */ import java.util.function.BiConsumer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @b
/*      */ abstract class e<K, V>
/*      */   extends h<K, V>
/*      */   implements Serializable
/*      */ {
/*      */   private transient Map<K, Collection<V>> map;
/*      */   private transient int totalSize;
/*      */   private static final long serialVersionUID = 2447537837011683357L;
/*      */   
/*      */   protected e(Map<K, Collection<V>> paramMap) {
/*  117 */     D.checkArgument(paramMap.isEmpty());
/*  118 */     this.map = paramMap;
/*      */   }
/*      */ 
/*      */   
/*      */   final void setMap(Map<K, Collection<V>> paramMap) {
/*  123 */     this.map = paramMap;
/*  124 */     this.totalSize = 0;
/*  125 */     for (Collection<V> collection : paramMap.values()) {
/*  126 */       D.checkArgument(!collection.isEmpty());
/*  127 */       this.totalSize += collection.size();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Collection<V> b() {
/*  137 */     return a(createCollection());
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
/*      */   Collection<V> b(K paramK) {
/*  161 */     return createCollection();
/*      */   }
/*      */   
/*      */   Map<K, Collection<V>> t() {
/*  165 */     return this.map;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int size() {
/*  172 */     return this.totalSize;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean containsKey(Object paramObject) {
/*  177 */     return this.map.containsKey(paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean put(K paramK, V paramV) {
/*  184 */     Collection<V> collection = this.map.get(paramK);
/*  185 */     if (collection == null) {
/*  186 */       collection = b(paramK);
/*  187 */       if (collection.add(paramV)) {
/*  188 */         this.totalSize++;
/*  189 */         this.map.put(paramK, collection);
/*  190 */         return true;
/*      */       } 
/*  192 */       throw new AssertionError("New Collection violated the Collection spec");
/*      */     } 
/*  194 */     if (collection.add(paramV)) {
/*  195 */       this.totalSize++;
/*  196 */       return true;
/*      */     } 
/*  198 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private Collection<V> c(K paramK) {
/*  203 */     Collection<V> collection = this.map.get(paramK);
/*  204 */     if (collection == null) {
/*  205 */       collection = b(paramK);
/*  206 */       this.map.put(paramK, collection);
/*      */     } 
/*  208 */     return collection;
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
/*      */   public Collection<V> a(K paramK, Iterable<? extends V> paramIterable) {
/*  220 */     Iterator<? extends V> iterator = paramIterable.iterator();
/*  221 */     if (!iterator.hasNext()) {
/*  222 */       return a(paramK);
/*      */     }
/*      */ 
/*      */     
/*  226 */     Collection<V> collection1 = c(paramK);
/*  227 */     Collection<V> collection2 = createCollection();
/*  228 */     collection2.addAll(collection1);
/*      */     
/*  230 */     this.totalSize -= collection1.size();
/*  231 */     collection1.clear();
/*      */     
/*  233 */     while (iterator.hasNext()) {
/*  234 */       if (collection1.add(iterator.next())) {
/*  235 */         this.totalSize++;
/*      */       }
/*      */     } 
/*      */     
/*  239 */     return a(collection2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Collection<V> a(Object paramObject) {
/*  249 */     Collection<? extends V> collection = this.map.remove(paramObject);
/*      */     
/*  251 */     if (collection == null) {
/*  252 */       return b();
/*      */     }
/*      */     
/*  255 */     Collection<V> collection1 = createCollection();
/*  256 */     collection1.addAll(collection);
/*  257 */     this.totalSize -= collection.size();
/*  258 */     collection.clear();
/*      */     
/*  260 */     return a(collection1);
/*      */   }
/*      */   
/*      */   <E> Collection<E> a(Collection<E> paramCollection) {
/*  264 */     return Collections.unmodifiableCollection(paramCollection);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void clear() {
/*  270 */     for (Collection<V> collection : this.map.values()) {
/*  271 */       collection.clear();
/*      */     }
/*  273 */     this.map.clear();
/*  274 */     this.totalSize = 0;
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
/*      */   public Collection<V> get(K paramK) {
/*  286 */     Collection<V> collection = this.map.get(paramK);
/*  287 */     if (collection == null) {
/*  288 */       collection = b(paramK);
/*      */     }
/*  290 */     return a(paramK, collection);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Collection<V> a(K paramK, Collection<V> paramCollection) {
/*  298 */     return new i(this, paramK, paramCollection, null);
/*      */   }
/*      */   
/*      */   final List<V> a(K paramK, List<V> paramList, i parami) {
/*  302 */     return (paramList instanceof RandomAccess) ? 
/*  303 */       new f(this, paramK, paramList, parami) : 
/*  304 */       new j(this, paramK, paramList, parami);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   class i
/*      */     extends AbstractCollection<V>
/*      */   {
/*      */     final K key;
/*      */ 
/*      */ 
/*      */     
/*      */     Collection<V> b;
/*      */ 
/*      */ 
/*      */     
/*      */     final i a;
/*      */ 
/*      */ 
/*      */     
/*      */     final Collection<V> c;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     i(e this$0, K param1K, Collection<V> param1Collection, i param1i) {
/*  331 */       this.key = param1K;
/*  332 */       this.b = param1Collection;
/*  333 */       this.a = (e)param1i;
/*  334 */       this.c = (param1i == null) ? null : param1i.e();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void eR() {
/*  345 */       if (this.a != null) {
/*  346 */         this.a.eR();
/*  347 */         if (this.a.e() != this.c) {
/*  348 */           throw new ConcurrentModificationException();
/*      */         }
/*  350 */       } else if (this.b.isEmpty()) {
/*  351 */         Collection<V> collection = (Collection)e.a(this.a).get(this.key);
/*  352 */         if (collection != null) {
/*  353 */           this.b = collection;
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void eS() {
/*  363 */       if (this.a != null) {
/*  364 */         this.a.eS();
/*  365 */       } else if (this.b.isEmpty()) {
/*  366 */         e.a(this.a).remove(this.key);
/*      */       } 
/*      */     }
/*      */     
/*      */     K getKey() {
/*  371 */       return this.key;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void eT() {
/*  381 */       if (this.a != null) {
/*  382 */         this.a.eT();
/*      */       } else {
/*  384 */         e.a(this.a).put(this.key, this.b);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/*  390 */       eR();
/*  391 */       return this.b.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(Object param1Object) {
/*  396 */       if (param1Object == this) {
/*  397 */         return true;
/*      */       }
/*  399 */       eR();
/*  400 */       return this.b.equals(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*  405 */       eR();
/*  406 */       return this.b.hashCode();
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/*  411 */       eR();
/*  412 */       return this.b.toString();
/*      */     }
/*      */     
/*      */     Collection<V> e() {
/*  416 */       return this.b;
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<V> iterator() {
/*  421 */       eR();
/*  422 */       return new a(this);
/*      */     }
/*      */ 
/*      */     
/*      */     public Spliterator<V> spliterator() {
/*  427 */       eR();
/*  428 */       return this.b.spliterator();
/*      */     }
/*      */     
/*      */     class a
/*      */       implements Iterator<V> {
/*      */       final Iterator<V> b;
/*  434 */       final Collection<V> d = this.b.b;
/*      */       
/*      */       a(e.i this$0) {
/*  437 */         this.b = (e.i)e.b(this$0.b);
/*      */       }
/*      */       
/*      */       a(e.i this$0, Iterator<V> param2Iterator) {
/*  441 */         this.b = (e.i)param2Iterator;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       void eU() {
/*  448 */         this.b.eR();
/*  449 */         if (this.b.b != this.d) {
/*  450 */           throw new ConcurrentModificationException();
/*      */         }
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean hasNext() {
/*  456 */         eU();
/*  457 */         return this.b.hasNext();
/*      */       }
/*      */ 
/*      */       
/*      */       public V next() {
/*  462 */         eU();
/*  463 */         return this.b.next();
/*      */       }
/*      */ 
/*      */       
/*      */       public void remove() {
/*  468 */         this.b.remove();
/*  469 */         e.a(this.b.a);
/*  470 */         this.b.eS();
/*      */       }
/*      */       
/*      */       Iterator<V> d() {
/*  474 */         eU();
/*  475 */         return (Iterator<V>)this.b;
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean add(V param1V) {
/*  481 */       eR();
/*  482 */       boolean bool1 = this.b.isEmpty();
/*  483 */       boolean bool2 = this.b.add(param1V);
/*  484 */       if (bool2) {
/*  485 */         e.b(this.a);
/*  486 */         if (bool1) {
/*  487 */           eT();
/*      */         }
/*      */       } 
/*  490 */       return bool2;
/*      */     }
/*      */     
/*      */     i a() {
/*  494 */       return (i)this.a;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean addAll(Collection<? extends V> param1Collection) {
/*  501 */       if (param1Collection.isEmpty()) {
/*  502 */         return false;
/*      */       }
/*  504 */       int j = size();
/*  505 */       boolean bool = this.b.addAll(param1Collection);
/*  506 */       if (bool) {
/*  507 */         int k = this.b.size();
/*  508 */         e.a(this.a, k - j);
/*  509 */         if (j == 0) {
/*  510 */           eT();
/*      */         }
/*      */       } 
/*  513 */       return bool;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean contains(Object param1Object) {
/*  518 */       eR();
/*  519 */       return this.b.contains(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean containsAll(Collection<?> param1Collection) {
/*  524 */       eR();
/*  525 */       return this.b.containsAll(param1Collection);
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/*  530 */       int j = size();
/*  531 */       if (j == 0) {
/*      */         return;
/*      */       }
/*  534 */       this.b.clear();
/*  535 */       e.b(this.a, j);
/*  536 */       eS();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object) {
/*  541 */       eR();
/*  542 */       boolean bool = this.b.remove(param1Object);
/*  543 */       if (bool) {
/*  544 */         e.a(this.a);
/*  545 */         eS();
/*      */       } 
/*  547 */       return bool;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean removeAll(Collection<?> param1Collection) {
/*  552 */       if (param1Collection.isEmpty()) {
/*  553 */         return false;
/*      */       }
/*  555 */       int j = size();
/*  556 */       boolean bool = this.b.removeAll(param1Collection);
/*  557 */       if (bool) {
/*  558 */         int k = this.b.size();
/*  559 */         e.a(this.a, k - j);
/*  560 */         eS();
/*      */       } 
/*  562 */       return bool;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean retainAll(Collection<?> param1Collection) {
/*  567 */       D.checkNotNull(param1Collection);
/*  568 */       int j = size();
/*  569 */       boolean bool = this.b.retainAll(param1Collection);
/*  570 */       if (bool) {
/*  571 */         int k = this.b.size();
/*  572 */         e.a(this.a, k - j);
/*  573 */         eS();
/*      */       } 
/*  575 */       return bool;
/*      */     }
/*      */   }
/*      */   
/*      */   private static <E> Iterator<E> a(Collection<E> paramCollection) {
/*  580 */     return (paramCollection instanceof List) ? (
/*  581 */       (List<E>)paramCollection).listIterator() : 
/*  582 */       paramCollection.iterator();
/*      */   }
/*      */   
/*      */   class l
/*      */     extends i
/*      */     implements Set<V> {
/*      */     l(e this$0, K param1K, Set<V> param1Set) {
/*  589 */       super(this$0, param1K, param1Set, null);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean removeAll(Collection<?> param1Collection) {
/*  594 */       if (param1Collection.isEmpty()) {
/*  595 */         return false;
/*      */       }
/*  597 */       int j = size();
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  602 */       boolean bool = cG.a((Set)this.b, param1Collection);
/*  603 */       if (bool) {
/*  604 */         int k = this.b.size();
/*  605 */         e.a(this.a, k - j);
/*  606 */         eS();
/*      */       } 
/*  608 */       return bool;
/*      */     }
/*      */   }
/*      */   
/*      */   class m
/*      */     extends i
/*      */     implements SortedSet<V> {
/*      */     m(e this$0, K param1K, SortedSet<V> param1SortedSet, e<K, V>.i param1i) {
/*  616 */       super(this$0, param1K, param1SortedSet, param1i);
/*      */     }
/*      */     
/*      */     SortedSet<V> c() {
/*  620 */       return (SortedSet<V>)e();
/*      */     }
/*      */ 
/*      */     
/*      */     public Comparator<? super V> comparator() {
/*  625 */       return c().comparator();
/*      */     }
/*      */ 
/*      */     
/*      */     public V first() {
/*  630 */       eR();
/*  631 */       return c().first();
/*      */     }
/*      */ 
/*      */     
/*      */     public V last() {
/*  636 */       eR();
/*  637 */       return c().last();
/*      */     }
/*      */ 
/*      */     
/*      */     public SortedSet<V> headSet(V param1V) {
/*  642 */       eR();
/*  643 */       return new m(this.a, 
/*  644 */           getKey(), 
/*  645 */           c().headSet(param1V), 
/*  646 */           (a() == null) ? this : a());
/*      */     }
/*      */ 
/*      */     
/*      */     public SortedSet<V> subSet(V param1V1, V param1V2) {
/*  651 */       eR();
/*  652 */       return new m(this.a, 
/*  653 */           getKey(), 
/*  654 */           c().subSet(param1V1, param1V2), 
/*  655 */           (a() == null) ? this : a());
/*      */     }
/*      */ 
/*      */     
/*      */     public SortedSet<V> tailSet(V param1V) {
/*  660 */       eR();
/*  661 */       return new m(this.a, 
/*  662 */           getKey(), 
/*  663 */           c().tailSet(param1V), 
/*  664 */           (a() == null) ? this : a());
/*      */     }
/*      */   }
/*      */   
/*      */   class k
/*      */     extends m
/*      */     implements NavigableSet<V> {
/*      */     k(e this$0, K param1K, NavigableSet<V> param1NavigableSet, e<K, V>.i param1i) {
/*  672 */       super(this$0, param1K, param1NavigableSet, param1i);
/*      */     }
/*      */ 
/*      */     
/*      */     NavigableSet<V> c() {
/*  677 */       return (NavigableSet<V>)super.c();
/*      */     }
/*      */ 
/*      */     
/*      */     public V lower(V param1V) {
/*  682 */       return c().lower(param1V);
/*      */     }
/*      */ 
/*      */     
/*      */     public V floor(V param1V) {
/*  687 */       return c().floor(param1V);
/*      */     }
/*      */ 
/*      */     
/*      */     public V ceiling(V param1V) {
/*  692 */       return c().ceiling(param1V);
/*      */     }
/*      */ 
/*      */     
/*      */     public V higher(V param1V) {
/*  697 */       return c().higher(param1V);
/*      */     }
/*      */ 
/*      */     
/*      */     public V pollFirst() {
/*  702 */       return bH.c(iterator());
/*      */     }
/*      */ 
/*      */     
/*      */     public V pollLast() {
/*  707 */       return bH.c(descendingIterator());
/*      */     }
/*      */     
/*      */     private NavigableSet<V> a(NavigableSet<V> param1NavigableSet) {
/*  711 */       return new k(this.a, this.key, param1NavigableSet, (a() == null) ? this : a());
/*      */     }
/*      */ 
/*      */     
/*      */     public NavigableSet<V> descendingSet() {
/*  716 */       return a(c().descendingSet());
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<V> descendingIterator() {
/*  721 */       return new e.i.a(this, c().descendingIterator());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public NavigableSet<V> subSet(V param1V1, boolean param1Boolean1, V param1V2, boolean param1Boolean2) {
/*  727 */       return a(
/*  728 */           c().subSet(param1V1, param1Boolean1, param1V2, param1Boolean2));
/*      */     }
/*      */ 
/*      */     
/*      */     public NavigableSet<V> headSet(V param1V, boolean param1Boolean) {
/*  733 */       return a(c().headSet(param1V, param1Boolean));
/*      */     }
/*      */ 
/*      */     
/*      */     public NavigableSet<V> tailSet(V param1V, boolean param1Boolean) {
/*  738 */       return a(c().tailSet(param1V, param1Boolean));
/*      */     }
/*      */   }
/*      */   
/*      */   class j
/*      */     extends i
/*      */     implements List<V> {
/*      */     j(e this$0, K param1K, List<V> param1List, e<K, V>.i param1i) {
/*  746 */       super(this$0, param1K, param1List, param1i);
/*      */     }
/*      */     
/*      */     List<V> P() {
/*  750 */       return (List<V>)e();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean addAll(int param1Int, Collection<? extends V> param1Collection) {
/*  755 */       if (param1Collection.isEmpty()) {
/*  756 */         return false;
/*      */       }
/*  758 */       int k = size();
/*  759 */       boolean bool = P().addAll(param1Int, param1Collection);
/*  760 */       if (bool) {
/*  761 */         int m = e().size();
/*  762 */         e.a(this.a, m - k);
/*  763 */         if (k == 0) {
/*  764 */           eT();
/*      */         }
/*      */       } 
/*  767 */       return bool;
/*      */     }
/*      */ 
/*      */     
/*      */     public V get(int param1Int) {
/*  772 */       eR();
/*  773 */       return P().get(param1Int);
/*      */     }
/*      */ 
/*      */     
/*      */     public V set(int param1Int, V param1V) {
/*  778 */       eR();
/*  779 */       return P().set(param1Int, param1V);
/*      */     }
/*      */ 
/*      */     
/*      */     public void add(int param1Int, V param1V) {
/*  784 */       eR();
/*  785 */       boolean bool = e().isEmpty();
/*  786 */       P().add(param1Int, param1V);
/*  787 */       e.b(this.a);
/*  788 */       if (bool) {
/*  789 */         eT();
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public V remove(int param1Int) {
/*  795 */       eR();
/*  796 */       V v = P().remove(param1Int);
/*  797 */       e.a(this.a);
/*  798 */       eS();
/*  799 */       return v;
/*      */     }
/*      */ 
/*      */     
/*      */     public int indexOf(Object param1Object) {
/*  804 */       eR();
/*  805 */       return P().indexOf(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public int lastIndexOf(Object param1Object) {
/*  810 */       eR();
/*  811 */       return P().lastIndexOf(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public ListIterator<V> listIterator() {
/*  816 */       eR();
/*  817 */       return new a(this);
/*      */     }
/*      */ 
/*      */     
/*      */     public ListIterator<V> listIterator(int param1Int) {
/*  822 */       eR();
/*  823 */       return new a(this, param1Int);
/*      */     }
/*      */ 
/*      */     
/*      */     public List<V> subList(int param1Int1, int param1Int2) {
/*  828 */       eR();
/*  829 */       return this.a.a(
/*  830 */           getKey(), 
/*  831 */           P().subList(param1Int1, param1Int2), 
/*  832 */           (a() == null) ? this : a());
/*      */     }
/*      */     
/*      */     private class a extends e<K, V>.i.a implements ListIterator<V> {
/*      */       a(e.j this$0) {
/*  837 */         super(this$0);
/*      */       }
/*      */       public a(e.j this$0, int param2Int) {
/*  840 */         super(this$0, this$0.P().listIterator(param2Int));
/*      */       }
/*      */       
/*      */       private ListIterator<V> a() {
/*  844 */         return (ListIterator<V>)d();
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean hasPrevious() {
/*  849 */         return a().hasPrevious();
/*      */       }
/*      */ 
/*      */       
/*      */       public V previous() {
/*  854 */         return a().previous();
/*      */       }
/*      */ 
/*      */       
/*      */       public int nextIndex() {
/*  859 */         return a().nextIndex();
/*      */       }
/*      */ 
/*      */       
/*      */       public int previousIndex() {
/*  864 */         return a().previousIndex();
/*      */       }
/*      */ 
/*      */       
/*      */       public void set(V param2V) {
/*  869 */         a().set(param2V);
/*      */       }
/*      */ 
/*      */       
/*      */       public void add(V param2V) {
/*  874 */         boolean bool = this.a.isEmpty();
/*  875 */         a().add(param2V);
/*  876 */         e.b(this.a.a);
/*  877 */         if (bool) {
/*  878 */           this.a.eT();
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private class f
/*      */     extends j
/*      */     implements RandomAccess
/*      */   {
/*      */     f(e this$0, K param1K, List<V> param1List, e<K, V>.i param1i) {
/*  891 */       super(this$0, param1K, param1List, param1i);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   Set<K> b() {
/*  897 */     return new c(this, this.map);
/*      */   }
/*      */   
/*      */   final Set<K> c() {
/*  901 */     if (this.map instanceof NavigableMap)
/*  902 */       return new e(this, (NavigableMap<K, Collection<V>>)this.map); 
/*  903 */     if (this.map instanceof SortedMap) {
/*  904 */       return new h(this, (SortedMap<K, Collection<V>>)this.map);
/*      */     }
/*  906 */     return new c(this, this.map);
/*      */   }
/*      */   
/*      */   private class c
/*      */     extends bW.p<K, Collection<V>>
/*      */   {
/*      */     c(e this$0, Map<K, Collection<V>> param1Map) {
/*  913 */       super(param1Map);
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<K> iterator() {
/*  918 */       Iterator iterator = w().entrySet().iterator();
/*  919 */       return new Iterator<K>(this, iterator)
/*      */         {
/*      */           Map.Entry<K, Collection<V>> entry;
/*      */           
/*      */           public boolean hasNext() {
/*  924 */             return this.d.hasNext();
/*      */           }
/*      */ 
/*      */           
/*      */           public K next() {
/*  929 */             this.entry = this.d.next();
/*  930 */             return this.entry.getKey();
/*      */           }
/*      */ 
/*      */           
/*      */           public void remove() {
/*  935 */             C.ad((this.entry != null));
/*  936 */             Collection collection = this.entry.getValue();
/*  937 */             this.d.remove();
/*  938 */             e.b(this.a.a, collection.size());
/*  939 */             collection.clear();
/*  940 */             this.entry = null;
/*      */           }
/*      */         };
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Spliterator<K> spliterator() {
/*  949 */       return w().keySet().spliterator();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object) {
/*  954 */       int i = 0;
/*  955 */       Collection collection = w().remove(param1Object);
/*  956 */       if (collection != null) {
/*  957 */         i = collection.size();
/*  958 */         collection.clear();
/*  959 */         e.b(this.a, i);
/*      */       } 
/*  961 */       return (i > 0);
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/*  966 */       bH.a(iterator());
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean containsAll(Collection<?> param1Collection) {
/*  971 */       return w().keySet().containsAll(param1Collection);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(Object param1Object) {
/*  976 */       return (this == param1Object || w().keySet().equals(param1Object));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*  981 */       return w().keySet().hashCode();
/*      */     }
/*      */   }
/*      */   
/*      */   private class h
/*      */     extends c
/*      */     implements SortedSet<K> {
/*      */     h(e this$0, SortedMap<K, Collection<V>> param1SortedMap) {
/*  989 */       super(this$0, param1SortedMap);
/*      */     }
/*      */     
/*      */     SortedMap<K, Collection<V>> a() {
/*  993 */       return (SortedMap<K, Collection<V>>)w();
/*      */     }
/*      */ 
/*      */     
/*      */     public Comparator<? super K> comparator() {
/*  998 */       return a().comparator();
/*      */     }
/*      */ 
/*      */     
/*      */     public K first() {
/* 1003 */       return a().firstKey();
/*      */     }
/*      */ 
/*      */     
/*      */     public SortedSet<K> headSet(K param1K) {
/* 1008 */       return new h(this.a, a().headMap(param1K));
/*      */     }
/*      */ 
/*      */     
/*      */     public K last() {
/* 1013 */       return a().lastKey();
/*      */     }
/*      */ 
/*      */     
/*      */     public SortedSet<K> subSet(K param1K1, K param1K2) {
/* 1018 */       return new h(this.a, a().subMap(param1K1, param1K2));
/*      */     }
/*      */ 
/*      */     
/*      */     public SortedSet<K> tailSet(K param1K) {
/* 1023 */       return new h(this.a, a().tailMap(param1K));
/*      */     }
/*      */   }
/*      */   
/*      */   class e
/*      */     extends h implements NavigableSet<K> {
/*      */     e(e this$0, NavigableMap<K, Collection<V>> param1NavigableMap) {
/* 1030 */       super(this$0, param1NavigableMap);
/*      */     }
/*      */ 
/*      */     
/*      */     NavigableMap<K, Collection<V>> a() {
/* 1035 */       return (NavigableMap<K, Collection<V>>)super.a();
/*      */     }
/*      */ 
/*      */     
/*      */     public K lower(K param1K) {
/* 1040 */       return a().lowerKey(param1K);
/*      */     }
/*      */ 
/*      */     
/*      */     public K floor(K param1K) {
/* 1045 */       return a().floorKey(param1K);
/*      */     }
/*      */ 
/*      */     
/*      */     public K ceiling(K param1K) {
/* 1050 */       return a().ceilingKey(param1K);
/*      */     }
/*      */ 
/*      */     
/*      */     public K higher(K param1K) {
/* 1055 */       return a().higherKey(param1K);
/*      */     }
/*      */ 
/*      */     
/*      */     public K pollFirst() {
/* 1060 */       return bH.c(iterator());
/*      */     }
/*      */ 
/*      */     
/*      */     public K pollLast() {
/* 1065 */       return bH.c(descendingIterator());
/*      */     }
/*      */ 
/*      */     
/*      */     public NavigableSet<K> descendingSet() {
/* 1070 */       return new e(this.a, a().descendingMap());
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<K> descendingIterator() {
/* 1075 */       return descendingSet().iterator();
/*      */     }
/*      */ 
/*      */     
/*      */     public NavigableSet<K> a(K param1K) {
/* 1080 */       return headSet(param1K, false);
/*      */     }
/*      */ 
/*      */     
/*      */     public NavigableSet<K> headSet(K param1K, boolean param1Boolean) {
/* 1085 */       return new e(this.a, a().headMap(param1K, param1Boolean));
/*      */     }
/*      */ 
/*      */     
/*      */     public NavigableSet<K> a(K param1K1, K param1K2) {
/* 1090 */       return subSet(param1K1, true, param1K2, false);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public NavigableSet<K> subSet(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
/* 1096 */       return new e(this.a, 
/* 1097 */           a().subMap(param1K1, param1Boolean1, param1K2, param1Boolean2));
/*      */     }
/*      */ 
/*      */     
/*      */     public NavigableSet<K> b(K param1K) {
/* 1102 */       return tailSet(param1K, true);
/*      */     }
/*      */ 
/*      */     
/*      */     public NavigableSet<K> tailSet(K param1K, boolean param1Boolean) {
/* 1107 */       return new e(this.a, a().tailMap(param1K, param1Boolean));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void h(Object paramObject) {
/* 1113 */     Collection collection = bW.<Collection>b((Map)this.map, paramObject);
/*      */     
/* 1115 */     if (collection != null) {
/* 1116 */       int i = collection.size();
/* 1117 */       collection.clear();
/* 1118 */       this.totalSize -= i;
/*      */     } 
/*      */   }
/*      */   
/*      */   private abstract class b<T> implements Iterator<T> {
/*      */     final Iterator<Map.Entry<K, Collection<V>>> keyIterator;
/*      */     K key;
/*      */     Collection<V> collection;
/*      */     Iterator<V> c;
/*      */     
/*      */     b(e this$0) {
/* 1129 */       this.keyIterator = e.a(this$0).entrySet().iterator();
/* 1130 */       this.key = null;
/* 1131 */       this.collection = null;
/* 1132 */       this.c = bH.k();
/*      */     }
/*      */ 
/*      */     
/*      */     abstract T d(K param1K, V param1V);
/*      */     
/*      */     public boolean hasNext() {
/* 1139 */       return (this.keyIterator.hasNext() || this.c.hasNext());
/*      */     }
/*      */ 
/*      */     
/*      */     public T next() {
/* 1144 */       if (!this.c.hasNext()) {
/* 1145 */         Map.Entry entry = this.keyIterator.next();
/* 1146 */         this.key = (K)entry.getKey();
/* 1147 */         this.collection = (Collection<V>)entry.getValue();
/* 1148 */         this.c = this.collection.iterator();
/*      */       } 
/* 1150 */       return d(this.key, this.c.next());
/*      */     }
/*      */ 
/*      */     
/*      */     public void remove() {
/* 1155 */       this.c.remove();
/* 1156 */       if (this.collection.isEmpty()) {
/* 1157 */         this.keyIterator.remove();
/*      */       }
/* 1159 */       e.a(this.a);
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
/* 1171 */     return super.values();
/*      */   }
/*      */ 
/*      */   
/*      */   Collection<V> c() {
/* 1176 */     return new h.c(this);
/*      */   }
/*      */ 
/*      */   
/*      */   Iterator<V> b() {
/* 1181 */     return new b<V>(this)
/*      */       {
/*      */         V d(K param1K, V param1V) {
/* 1184 */           return param1V;
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */   
/*      */   Spliterator<V> a() {
/* 1191 */     return D.a(this.map
/* 1192 */         .values().spliterator(), Collection::spliterator, 64, size());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   cc<K> a() {
/* 1203 */     return new cb.g<>(this);
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
/*      */   public Collection<Map.Entry<K, V>> entries() {
/* 1217 */     return super.entries();
/*      */   }
/*      */ 
/*      */   
/*      */   Collection<Map.Entry<K, V>> d() {
/* 1222 */     if (this instanceof cF) {
/* 1223 */       return new h.b(this);
/*      */     }
/* 1225 */     return new h.a(this);
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
/*      */   Iterator<Map.Entry<K, V>> c() {
/* 1239 */     return new b<Map.Entry<K, V>>(this)
/*      */       {
/*      */         Map.Entry<K, V> b(K param1K, V param1V) {
/* 1242 */           return bW.d(param1K, param1V);
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */   
/*      */   Spliterator<Map.Entry<K, V>> b() {
/* 1249 */     return D.a(this.map
/* 1250 */         .entrySet().spliterator(), paramEntry -> { Object object = paramEntry.getKey(); Collection<?> collection = (Collection)paramEntry.getValue(); return D.a(collection.spliterator(), ()); }64, 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1258 */         size());
/*      */   }
/*      */ 
/*      */   
/*      */   public void forEach(BiConsumer<? super K, ? super V> paramBiConsumer) {
/* 1263 */     D.checkNotNull(paramBiConsumer);
/* 1264 */     this.map.forEach((paramObject, paramCollection) -> paramCollection.forEach(()));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   Map<K, Collection<V>> u() {
/* 1270 */     return new a(this, this.map);
/*      */   }
/*      */   
/*      */   final Map<K, Collection<V>> v() {
/* 1274 */     if (this.map instanceof NavigableMap)
/* 1275 */       return new d(this, (NavigableMap<K, Collection<V>>)this.map); 
/* 1276 */     if (this.map instanceof SortedMap) {
/* 1277 */       return new g(this, (SortedMap<K, Collection<V>>)this.map);
/*      */     }
/* 1279 */     return new a(this, this.map);
/*      */   }
/*      */ 
/*      */   
/*      */   abstract Collection<V> createCollection();
/*      */ 
/*      */   
/*      */   private class a
/*      */     extends bW.F<K, Collection<V>>
/*      */   {
/*      */     final transient Map<K, Collection<V>> G;
/*      */     
/*      */     a(e this$0, Map<K, Collection<V>> param1Map) {
/* 1292 */       this.G = param1Map;
/*      */     }
/*      */ 
/*      */     
/*      */     protected Set<Map.Entry<K, Collection<V>>> createEntrySet() {
/* 1297 */       return new a(this);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean containsKey(Object param1Object) {
/* 1304 */       return bW.a(this.G, param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public Collection<V> get(Object param1Object) {
/* 1309 */       Collection<V> collection = bW.<Collection>a((Map)this.G, param1Object);
/* 1310 */       if (collection == null) {
/* 1311 */         return null;
/*      */       }
/*      */       
/* 1314 */       Object object = param1Object;
/* 1315 */       return this.a.a(object, collection);
/*      */     }
/*      */ 
/*      */     
/*      */     public Set<K> keySet() {
/* 1320 */       return this.a.keySet();
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/* 1325 */       return this.G.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public Collection<V> remove(Object param1Object) {
/* 1330 */       Collection collection = this.G.remove(param1Object);
/* 1331 */       if (collection == null) {
/* 1332 */         return null;
/*      */       }
/*      */       
/* 1335 */       Collection<V> collection1 = this.a.createCollection();
/* 1336 */       collection1.addAll(collection);
/* 1337 */       e.b(this.a, collection.size());
/* 1338 */       collection.clear();
/* 1339 */       return collection1;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(Object param1Object) {
/* 1344 */       return (this == param1Object || this.G.equals(param1Object));
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/* 1349 */       return this.G.hashCode();
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1354 */       return this.G.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/* 1359 */       if (this.G == e.a(this.a)) {
/* 1360 */         this.a.clear();
/*      */       } else {
/* 1362 */         bH.a(new b(this));
/*      */       } 
/*      */     }
/*      */     
/*      */     Map.Entry<K, Collection<V>> a(Map.Entry<K, Collection<V>> param1Entry) {
/* 1367 */       K k = param1Entry.getKey();
/* 1368 */       return bW.d(k, this.a.a(k, param1Entry.getValue()));
/*      */     }
/*      */     
/*      */     class a extends bW.g<K, Collection<V>> {
/*      */       a(e.a this$0) {}
/*      */       
/*      */       Map<K, Collection<V>> w() {
/* 1375 */         return this.a;
/*      */       }
/*      */ 
/*      */       
/*      */       public Iterator<Map.Entry<K, Collection<V>>> iterator() {
/* 1380 */         return new e.a.b(this.a);
/*      */       }
/*      */ 
/*      */       
/*      */       public Spliterator<Map.Entry<K, Collection<V>>> spliterator() {
/* 1385 */         return D.a(this.a.G.entrySet().spliterator(), this.a::a);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public boolean contains(Object param2Object) {
/* 1392 */         return E.a(this.a.G.entrySet(), param2Object);
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean remove(Object param2Object) {
/* 1397 */         if (!contains(param2Object)) {
/* 1398 */           return false;
/*      */         }
/* 1400 */         Map.Entry entry = (Map.Entry)param2Object;
/* 1401 */         e.a(this.a.a, entry.getKey());
/* 1402 */         return true;
/*      */       }
/*      */     }
/*      */     
/*      */     class b
/*      */       implements Iterator<Map.Entry<K, Collection<V>>> {
/* 1408 */       final Iterator<Map.Entry<K, Collection<V>>> b = this.a.G.entrySet().iterator();
/*      */       
/*      */       Collection<V> collection;
/*      */       
/*      */       public boolean hasNext() {
/* 1413 */         return this.b.hasNext();
/*      */       }
/*      */ 
/*      */       
/*      */       public Map.Entry<K, Collection<V>> next() {
/* 1418 */         Map.Entry<K, Collection<V>> entry = this.b.next();
/* 1419 */         this.collection = (Collection<V>)entry.getValue();
/* 1420 */         return this.a.a(entry);
/*      */       }
/*      */ 
/*      */       
/*      */       public void remove() {
/* 1425 */         C.ad((this.collection != null));
/* 1426 */         this.b.remove();
/* 1427 */         e.b(this.a.a, this.collection.size());
/* 1428 */         this.collection.clear();
/* 1429 */         this.collection = null;
/*      */       }
/*      */       
/*      */       b(e.a this$0) {} } }
/*      */   
/*      */   private class g extends a implements SortedMap<K, Collection<V>> { SortedSet<K> a;
/*      */     
/*      */     g(e this$0, SortedMap<K, Collection<V>> param1SortedMap) {
/* 1437 */       super(this$0, param1SortedMap);
/*      */     }
/*      */     
/*      */     SortedMap<K, Collection<V>> a() {
/* 1441 */       return (SortedMap<K, Collection<V>>)this.G;
/*      */     }
/*      */ 
/*      */     
/*      */     public Comparator<? super K> comparator() {
/* 1446 */       return a().comparator();
/*      */     }
/*      */ 
/*      */     
/*      */     public K firstKey() {
/* 1451 */       return a().firstKey();
/*      */     }
/*      */ 
/*      */     
/*      */     public K lastKey() {
/* 1456 */       return a().lastKey();
/*      */     }
/*      */ 
/*      */     
/*      */     public SortedMap<K, Collection<V>> headMap(K param1K) {
/* 1461 */       return new g(this.a, a().headMap(param1K));
/*      */     }
/*      */ 
/*      */     
/*      */     public SortedMap<K, Collection<V>> subMap(K param1K1, K param1K2) {
/* 1466 */       return new g(this.a, a().subMap(param1K1, param1K2));
/*      */     }
/*      */ 
/*      */     
/*      */     public SortedMap<K, Collection<V>> tailMap(K param1K) {
/* 1471 */       return new g(this.a, a().tailMap(param1K));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public SortedSet<K> b() {
/* 1480 */       e e1 = this.a;
/* 1481 */       return (e1 == null) ? (SortedSet<K>)(this.a = (e)a()) : (SortedSet<K>)e1;
/*      */     }
/*      */ 
/*      */     
/*      */     SortedSet<K> a() {
/* 1486 */       return new e.h(this.a, a());
/*      */     } }
/*      */ 
/*      */   
/*      */   class d
/*      */     extends g implements NavigableMap<K, Collection<V>> {
/*      */     d(e this$0, NavigableMap<K, Collection<V>> param1NavigableMap) {
/* 1493 */       super(this$0, param1NavigableMap);
/*      */     }
/*      */ 
/*      */     
/*      */     NavigableMap<K, Collection<V>> a() {
/* 1498 */       return (NavigableMap<K, Collection<V>>)super.a();
/*      */     }
/*      */ 
/*      */     
/*      */     public Map.Entry<K, Collection<V>> lowerEntry(K param1K) {
/* 1503 */       Map.Entry<K, Collection<V>> entry = a().lowerEntry(param1K);
/* 1504 */       return (entry == null) ? null : a(entry);
/*      */     }
/*      */ 
/*      */     
/*      */     public K lowerKey(K param1K) {
/* 1509 */       return a().lowerKey(param1K);
/*      */     }
/*      */ 
/*      */     
/*      */     public Map.Entry<K, Collection<V>> floorEntry(K param1K) {
/* 1514 */       Map.Entry<K, Collection<V>> entry = a().floorEntry(param1K);
/* 1515 */       return (entry == null) ? null : a(entry);
/*      */     }
/*      */ 
/*      */     
/*      */     public K floorKey(K param1K) {
/* 1520 */       return a().floorKey(param1K);
/*      */     }
/*      */ 
/*      */     
/*      */     public Map.Entry<K, Collection<V>> ceilingEntry(K param1K) {
/* 1525 */       Map.Entry<K, Collection<V>> entry = a().ceilingEntry(param1K);
/* 1526 */       return (entry == null) ? null : a(entry);
/*      */     }
/*      */ 
/*      */     
/*      */     public K ceilingKey(K param1K) {
/* 1531 */       return a().ceilingKey(param1K);
/*      */     }
/*      */ 
/*      */     
/*      */     public Map.Entry<K, Collection<V>> higherEntry(K param1K) {
/* 1536 */       Map.Entry<K, Collection<V>> entry = a().higherEntry(param1K);
/* 1537 */       return (entry == null) ? null : a(entry);
/*      */     }
/*      */ 
/*      */     
/*      */     public K higherKey(K param1K) {
/* 1542 */       return a().higherKey(param1K);
/*      */     }
/*      */ 
/*      */     
/*      */     public Map.Entry<K, Collection<V>> firstEntry() {
/* 1547 */       Map.Entry<K, Collection<V>> entry = a().firstEntry();
/* 1548 */       return (entry == null) ? null : a(entry);
/*      */     }
/*      */ 
/*      */     
/*      */     public Map.Entry<K, Collection<V>> lastEntry() {
/* 1553 */       Map.Entry<K, Collection<V>> entry = a().lastEntry();
/* 1554 */       return (entry == null) ? null : a(entry);
/*      */     }
/*      */ 
/*      */     
/*      */     public Map.Entry<K, Collection<V>> pollFirstEntry() {
/* 1559 */       return a(entrySet().iterator());
/*      */     }
/*      */ 
/*      */     
/*      */     public Map.Entry<K, Collection<V>> pollLastEntry() {
/* 1564 */       return a(descendingMap().entrySet().iterator());
/*      */     }
/*      */     
/*      */     Map.Entry<K, Collection<V>> a(Iterator<Map.Entry<K, Collection<V>>> param1Iterator) {
/* 1568 */       if (!param1Iterator.hasNext()) {
/* 1569 */         return null;
/*      */       }
/* 1571 */       Map.Entry entry = param1Iterator.next();
/* 1572 */       Collection collection = this.a.createCollection();
/* 1573 */       collection.addAll((Collection)entry.getValue());
/* 1574 */       param1Iterator.remove();
/* 1575 */       return bW.d((K)entry.getKey(), this.a.a(collection));
/*      */     }
/*      */ 
/*      */     
/*      */     public NavigableMap<K, Collection<V>> descendingMap() {
/* 1580 */       return new d(this.a, a().descendingMap());
/*      */     }
/*      */ 
/*      */     
/*      */     public NavigableSet<K> a() {
/* 1585 */       return (NavigableSet<K>)super.b();
/*      */     }
/*      */ 
/*      */     
/*      */     NavigableSet<K> b() {
/* 1590 */       return new e.e(this.a, a());
/*      */     }
/*      */ 
/*      */     
/*      */     public NavigableSet<K> navigableKeySet() {
/* 1595 */       return a();
/*      */     }
/*      */ 
/*      */     
/*      */     public NavigableSet<K> descendingKeySet() {
/* 1600 */       return descendingMap().navigableKeySet();
/*      */     }
/*      */ 
/*      */     
/*      */     public NavigableMap<K, Collection<V>> a(K param1K1, K param1K2) {
/* 1605 */       return subMap(param1K1, true, param1K2, false);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public NavigableMap<K, Collection<V>> subMap(K param1K1, boolean param1Boolean1, K param1K2, boolean param1Boolean2) {
/* 1611 */       return new d(this.a, a().subMap(param1K1, param1Boolean1, param1K2, param1Boolean2));
/*      */     }
/*      */ 
/*      */     
/*      */     public NavigableMap<K, Collection<V>> a(K param1K) {
/* 1616 */       return headMap(param1K, false);
/*      */     }
/*      */ 
/*      */     
/*      */     public NavigableMap<K, Collection<V>> headMap(K param1K, boolean param1Boolean) {
/* 1621 */       return new d(this.a, a().headMap(param1K, param1Boolean));
/*      */     }
/*      */ 
/*      */     
/*      */     public NavigableMap<K, Collection<V>> b(K param1K) {
/* 1626 */       return tailMap(param1K, true);
/*      */     }
/*      */ 
/*      */     
/*      */     public NavigableMap<K, Collection<V>> tailMap(K param1K, boolean param1Boolean) {
/* 1631 */       return new d(this.a, a().tailMap(param1K, param1Boolean));
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */