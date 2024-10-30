/*      */ package com.google.a.d;
/*      */ 
/*      */ import com.google.a.a.b;
/*      */ import com.google.a.b.D;
/*      */ import com.google.a.b.E;
/*      */ import com.google.a.b.F;
/*      */ import com.google.a.b.M;
/*      */ import com.google.a.b.s;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.io.ObjectOutputStream;
/*      */ import java.io.Serializable;
/*      */ import java.util.AbstractCollection;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.NavigableSet;
/*      */ import java.util.NoSuchElementException;
/*      */ import java.util.Objects;
/*      */ import java.util.Set;
/*      */ import java.util.SortedSet;
/*      */ import java.util.Spliterator;
/*      */ import java.util.function.BiConsumer;
/*      */ import java.util.function.Consumer;
/*      */ import java.util.function.Function;
/*      */ import java.util.function.Supplier;
/*      */ import java.util.stream.Collector;
/*      */ import java.util.stream.Stream;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @b(cl = true)
/*      */ public final class cb
/*      */ {
/*      */   public static <T, K, V, M extends bZ<K, V>> Collector<T, ?, M> a(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1, Supplier<M> paramSupplier) {
/*  111 */     D.checkNotNull(paramFunction);
/*  112 */     D.checkNotNull(paramFunction1);
/*  113 */     D.checkNotNull(paramSupplier);
/*  114 */     return (Collector)Collector.of(paramSupplier, (parambZ, paramObject) -> parambZ.put(paramFunction1.apply(paramObject), paramFunction2.apply(paramObject)), (parambZ1, parambZ2) -> { parambZ1.a(parambZ2); return parambZ1; }new Collector.Characteristics[0]);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.a
/*      */   public static <T, K, V, M extends bZ<K, V>> Collector<T, ?, M> b(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends Stream<? extends V>> paramFunction1, Supplier<M> paramSupplier) {
/*  161 */     D.checkNotNull(paramFunction);
/*  162 */     D.checkNotNull(paramFunction1);
/*  163 */     D.checkNotNull(paramSupplier);
/*  164 */     return (Collector)Collector.of(paramSupplier, (parambZ, paramObject) -> { Object object = paramFunction1.apply(paramObject); Collection collection = parambZ.get(object); Objects.requireNonNull(collection); ((Stream)paramFunction2.apply(paramObject)).forEachOrdered(collection::add); }(parambZ1, parambZ2) -> { parambZ1.a(parambZ2); return parambZ1; }new Collector.Characteristics[0]);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <K, V> bZ<K, V> a(Map<K, Collection<V>> paramMap, M<? extends Collection<V>> paramM) {
/*  215 */     return new c<>(paramMap, paramM);
/*      */   }
/*      */   private static class c<K, V> extends e<K, V> { transient M<? extends Collection<V>> h;
/*      */     @com.google.a.a.c
/*      */     private static final long serialVersionUID = 0L;
/*      */     
/*      */     c(Map<K, Collection<V>> param1Map, M<? extends Collection<V>> param1M) {
/*  222 */       super(param1Map);
/*  223 */       this.h = (M<? extends Collection<V>>)D.checkNotNull(param1M);
/*      */     }
/*      */ 
/*      */     
/*      */     Set<K> b() {
/*  228 */       return c();
/*      */     }
/*      */ 
/*      */     
/*      */     Map<K, Collection<V>> u() {
/*  233 */       return v();
/*      */     }
/*      */ 
/*      */     
/*      */     protected Collection<V> createCollection() {
/*  238 */       return (Collection<V>)this.h.get();
/*      */     }
/*      */ 
/*      */     
/*      */     <E> Collection<E> a(Collection<E> param1Collection) {
/*  243 */       if (param1Collection instanceof NavigableSet)
/*  244 */         return cG.unmodifiableNavigableSet((NavigableSet<E>)param1Collection); 
/*  245 */       if (param1Collection instanceof SortedSet)
/*  246 */         return Collections.unmodifiableSortedSet((SortedSet<E>)param1Collection); 
/*  247 */       if (param1Collection instanceof Set)
/*  248 */         return Collections.unmodifiableSet((Set<? extends E>)param1Collection); 
/*  249 */       if (param1Collection instanceof List) {
/*  250 */         return Collections.unmodifiableList((List<? extends E>)param1Collection);
/*      */       }
/*  252 */       return Collections.unmodifiableCollection(param1Collection);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     Collection<V> a(K param1K, Collection<V> param1Collection) {
/*  258 */       if (param1Collection instanceof List)
/*  259 */         return a(param1K, (List<V>)param1Collection, (e<K, V>.i)null); 
/*  260 */       if (param1Collection instanceof NavigableSet)
/*  261 */         return new e.k(this, param1K, (NavigableSet<V>)param1Collection, null); 
/*  262 */       if (param1Collection instanceof SortedSet)
/*  263 */         return new e.m(this, param1K, (SortedSet<V>)param1Collection, null); 
/*  264 */       if (param1Collection instanceof Set) {
/*  265 */         return new e.l(this, param1K, (Set<V>)param1Collection);
/*      */       }
/*  267 */       return new e.i(this, param1K, param1Collection, null);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @com.google.a.a.c
/*      */     private void writeObject(ObjectOutputStream param1ObjectOutputStream) throws IOException {
/*  277 */       param1ObjectOutputStream.defaultWriteObject();
/*  278 */       param1ObjectOutputStream.writeObject(this.h);
/*  279 */       param1ObjectOutputStream.writeObject(t());
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.a.a.c
/*      */     private void readObject(ObjectInputStream param1ObjectInputStream) throws IOException, ClassNotFoundException {
/*  285 */       param1ObjectInputStream.defaultReadObject();
/*  286 */       this.h = (M<? extends Collection<V>>)param1ObjectInputStream.readObject();
/*  287 */       Map<K, Collection<V>> map = (Map)param1ObjectInputStream.readObject();
/*  288 */       setMap(map);
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <K, V> bR<K, V> a(Map<K, Collection<V>> paramMap, M<? extends List<V>> paramM) {
/*  327 */     return new b<>(paramMap, paramM);
/*      */   }
/*      */   private static class b<K, V> extends d<K, V> { transient M<? extends List<V>> h;
/*      */     @com.google.a.a.c
/*      */     private static final long serialVersionUID = 0L;
/*      */     
/*      */     b(Map<K, Collection<V>> param1Map, M<? extends List<V>> param1M) {
/*  334 */       super(param1Map);
/*  335 */       this.h = (M<? extends List<V>>)D.checkNotNull(param1M);
/*      */     }
/*      */ 
/*      */     
/*      */     Set<K> b() {
/*  340 */       return c();
/*      */     }
/*      */ 
/*      */     
/*      */     Map<K, Collection<V>> u() {
/*  345 */       return v();
/*      */     }
/*      */ 
/*      */     
/*      */     protected List<V> createCollection() {
/*  350 */       return (List<V>)this.h.get();
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.a.a.c
/*      */     private void writeObject(ObjectOutputStream param1ObjectOutputStream) throws IOException {
/*  356 */       param1ObjectOutputStream.defaultWriteObject();
/*  357 */       param1ObjectOutputStream.writeObject(this.h);
/*  358 */       param1ObjectOutputStream.writeObject(t());
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.a.a.c
/*      */     private void readObject(ObjectInputStream param1ObjectInputStream) throws IOException, ClassNotFoundException {
/*  364 */       param1ObjectInputStream.defaultReadObject();
/*  365 */       this.h = (M<? extends List<V>>)param1ObjectInputStream.readObject();
/*  366 */       Map<K, Collection<V>> map = (Map)param1ObjectInputStream.readObject();
/*  367 */       setMap(map);
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <K, V> cF<K, V> a(Map<K, Collection<V>> paramMap, M<? extends Set<V>> paramM) {
/*  405 */     return new d<>(paramMap, paramM);
/*      */   }
/*      */   private static class d<K, V> extends m<K, V> { transient M<? extends Set<V>> h;
/*      */     @com.google.a.a.c
/*      */     private static final long serialVersionUID = 0L;
/*      */     
/*      */     d(Map<K, Collection<V>> param1Map, M<? extends Set<V>> param1M) {
/*  412 */       super(param1Map);
/*  413 */       this.h = (M<? extends Set<V>>)D.checkNotNull(param1M);
/*      */     }
/*      */ 
/*      */     
/*      */     Set<K> b() {
/*  418 */       return c();
/*      */     }
/*      */ 
/*      */     
/*      */     Map<K, Collection<V>> u() {
/*  423 */       return v();
/*      */     }
/*      */ 
/*      */     
/*      */     protected Set<V> createCollection() {
/*  428 */       return (Set<V>)this.h.get();
/*      */     }
/*      */ 
/*      */     
/*      */     <E> Collection<E> a(Collection<E> param1Collection) {
/*  433 */       if (param1Collection instanceof NavigableSet)
/*  434 */         return cG.unmodifiableNavigableSet((NavigableSet<E>)param1Collection); 
/*  435 */       if (param1Collection instanceof SortedSet) {
/*  436 */         return Collections.unmodifiableSortedSet((SortedSet<E>)param1Collection);
/*      */       }
/*  438 */       return Collections.unmodifiableSet((Set<? extends E>)param1Collection);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     Collection<V> a(K param1K, Collection<V> param1Collection) {
/*  444 */       if (param1Collection instanceof NavigableSet)
/*  445 */         return new e.k(this, param1K, (NavigableSet<V>)param1Collection, null); 
/*  446 */       if (param1Collection instanceof SortedSet) {
/*  447 */         return new e.m(this, param1K, (SortedSet<V>)param1Collection, null);
/*      */       }
/*  449 */       return new e.l(this, param1K, (Set<V>)param1Collection);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     @com.google.a.a.c
/*      */     private void writeObject(ObjectOutputStream param1ObjectOutputStream) throws IOException {
/*  456 */       param1ObjectOutputStream.defaultWriteObject();
/*  457 */       param1ObjectOutputStream.writeObject(this.h);
/*  458 */       param1ObjectOutputStream.writeObject(t());
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.a.a.c
/*      */     private void readObject(ObjectInputStream param1ObjectInputStream) throws IOException, ClassNotFoundException {
/*  464 */       param1ObjectInputStream.defaultReadObject();
/*  465 */       this.h = (M<? extends Set<V>>)param1ObjectInputStream.readObject();
/*  466 */       Map<K, Collection<V>> map = (Map)param1ObjectInputStream.readObject();
/*  467 */       setMap(map);
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <K, V> cS<K, V> a(Map<K, Collection<V>> paramMap, M<? extends SortedSet<V>> paramM) {
/*  505 */     return new e<>(paramMap, paramM);
/*      */   }
/*      */   private static class e<K, V> extends p<K, V> { transient M<? extends SortedSet<V>> h;
/*      */     transient Comparator<? super V> valueComparator;
/*      */     @com.google.a.a.c
/*      */     private static final long serialVersionUID = 0L;
/*      */     
/*      */     e(Map<K, Collection<V>> param1Map, M<? extends SortedSet<V>> param1M) {
/*  513 */       super(param1Map);
/*  514 */       this.h = (M<? extends SortedSet<V>>)D.checkNotNull(param1M);
/*  515 */       this.valueComparator = ((SortedSet<V>)param1M.get()).comparator();
/*      */     }
/*      */ 
/*      */     
/*      */     Set<K> b() {
/*  520 */       return c();
/*      */     }
/*      */ 
/*      */     
/*      */     Map<K, Collection<V>> u() {
/*  525 */       return v();
/*      */     }
/*      */ 
/*      */     
/*      */     protected SortedSet<V> e() {
/*  530 */       return (SortedSet<V>)this.h.get();
/*      */     }
/*      */ 
/*      */     
/*      */     public Comparator<? super V> valueComparator() {
/*  535 */       return this.valueComparator;
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.a.a.c
/*      */     private void writeObject(ObjectOutputStream param1ObjectOutputStream) throws IOException {
/*  541 */       param1ObjectOutputStream.defaultWriteObject();
/*  542 */       param1ObjectOutputStream.writeObject(this.h);
/*  543 */       param1ObjectOutputStream.writeObject(t());
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.a.a.c
/*      */     private void readObject(ObjectInputStream param1ObjectInputStream) throws IOException, ClassNotFoundException {
/*  549 */       param1ObjectInputStream.defaultReadObject();
/*  550 */       this.h = (M<? extends SortedSet<V>>)param1ObjectInputStream.readObject();
/*  551 */       this.valueComparator = ((SortedSet<V>)this.h.get()).comparator();
/*  552 */       Map<K, Collection<V>> map = (Map)param1ObjectInputStream.readObject();
/*  553 */       setMap(map);
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.b.a.a
/*      */   public static <K, V, M extends bZ<K, V>> M a(bZ<? extends V, ? extends K> parambZ, M paramM) {
/*  574 */     D.checkNotNull(paramM);
/*  575 */     for (Map.Entry<? extends V, ? extends K> entry : parambZ.entries()) {
/*  576 */       paramM.put(entry.getValue(), entry.getKey());
/*      */     }
/*  578 */     return paramM;
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
/*      */   public static <K, V> bZ<K, V> b(bZ<K, V> parambZ) {
/*  614 */     return cX.a(parambZ, (Object)null);
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
/*      */   public static <K, V> bZ<K, V> c(bZ<K, V> parambZ) {
/*  629 */     if (parambZ instanceof l || parambZ instanceof bo) {
/*  630 */       return parambZ;
/*      */     }
/*  632 */     return new l<>(parambZ);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static <K, V> bZ<K, V> a(bo<K, V> parambo) {
/*  643 */     return (bZ<K, V>)D.checkNotNull(parambo);
/*      */   }
/*      */   
/*      */   private static class l<K, V> extends aE<K, V> implements Serializable {
/*      */     final bZ<K, V> d;
/*      */     transient Collection<Map.Entry<K, V>> e;
/*      */     transient cc<K> a;
/*      */     transient Set<K> keySet;
/*      */     transient Collection<V> values;
/*      */     transient Map<K, Collection<V>> map;
/*      */     private static final long serialVersionUID = 0L;
/*      */     
/*      */     l(bZ<K, V> param1bZ) {
/*  656 */       this.d = (bZ<K, V>)D.checkNotNull(param1bZ);
/*      */     }
/*      */ 
/*      */     
/*      */     protected bZ<K, V> c() {
/*  661 */       return this.d;
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/*  666 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public Map<K, Collection<V>> asMap() {
/*  671 */       Map<K, Collection<V>> map = this.map;
/*  672 */       if (map == null)
/*      */       {
/*      */         
/*  675 */         map = this.map = Collections.<K, V>unmodifiableMap(
/*  676 */             bW.a(this.d
/*  677 */               .asMap(), new s<Collection<V>, Collection<V>>(this)
/*      */               {
/*      */                 public Collection<V> g(Collection<V> param2Collection)
/*      */                 {
/*  681 */                   return cb.e(param2Collection);
/*      */                 }
/*      */               }));
/*      */       }
/*  685 */       return map;
/*      */     }
/*      */ 
/*      */     
/*      */     public Collection<Map.Entry<K, V>> entries() {
/*  690 */       Collection<Map.Entry<K, V>> collection = this.e;
/*  691 */       if (collection == null) {
/*  692 */         this.e = collection = cb.f(this.d.entries());
/*      */       }
/*  694 */       return collection;
/*      */     }
/*      */ 
/*      */     
/*      */     public void forEach(BiConsumer<? super K, ? super V> param1BiConsumer) {
/*  699 */       this.d.forEach((BiConsumer<? super K, ? super V>)D.checkNotNull(param1BiConsumer));
/*      */     }
/*      */ 
/*      */     
/*      */     public Collection<V> get(K param1K) {
/*  704 */       return cb.e(this.d.get(param1K));
/*      */     }
/*      */ 
/*      */     
/*      */     public cc<K> b() {
/*  709 */       cc<K> cc1 = this.a;
/*  710 */       if (cc1 == null) {
/*  711 */         this.a = cc1 = cd.a(this.d.b());
/*      */       }
/*  713 */       return cc1;
/*      */     }
/*      */ 
/*      */     
/*      */     public Set<K> keySet() {
/*  718 */       Set<K> set = this.keySet;
/*  719 */       if (set == null) {
/*  720 */         this.keySet = set = Collections.unmodifiableSet(this.d.keySet());
/*      */       }
/*  722 */       return set;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean put(K param1K, V param1V) {
/*  727 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean putAll(K param1K, Iterable<? extends V> param1Iterable) {
/*  732 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean a(bZ<? extends K, ? extends V> param1bZ) {
/*  737 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object1, Object param1Object2) {
/*  742 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public Collection<V> a(Object param1Object) {
/*  747 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public Collection<V> a(K param1K, Iterable<? extends V> param1Iterable) {
/*  752 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public Collection<V> values() {
/*  757 */       Collection<V> collection = this.values;
/*  758 */       if (collection == null) {
/*  759 */         this.values = collection = Collections.unmodifiableCollection(this.d.values());
/*      */       }
/*  761 */       return collection;
/*      */     }
/*      */   }
/*      */   
/*      */   private static class k<K, V>
/*      */     extends l<K, V> implements bR<K, V> {
/*      */     private static final long serialVersionUID = 0L;
/*      */     
/*      */     k(bR<K, V> param1bR) {
/*  770 */       super(param1bR);
/*      */     }
/*      */ 
/*      */     
/*      */     public bR<K, V> b() {
/*  775 */       return (bR<K, V>)super.c();
/*      */     }
/*      */ 
/*      */     
/*      */     public List<V> get(K param1K) {
/*  780 */       return Collections.unmodifiableList(b().get(param1K));
/*      */     }
/*      */ 
/*      */     
/*      */     public List<V> a(Object param1Object) {
/*  785 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public List<V> a(K param1K, Iterable<? extends V> param1Iterable) {
/*  790 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private static class m<K, V>
/*      */     extends l<K, V> implements cF<K, V> {
/*      */     private static final long serialVersionUID = 0L;
/*      */     
/*      */     m(cF<K, V> param1cF) {
/*  799 */       super(param1cF);
/*      */     }
/*      */ 
/*      */     
/*      */     public cF<K, V> b() {
/*  804 */       return (cF<K, V>)super.c();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Set<V> get(K param1K) {
/*  813 */       return Collections.unmodifiableSet(b().get(param1K));
/*      */     }
/*      */ 
/*      */     
/*      */     public Set<Map.Entry<K, V>> g() {
/*  818 */       return bW.unmodifiableEntrySet(b().g());
/*      */     }
/*      */ 
/*      */     
/*      */     public Set<V> a(Object param1Object) {
/*  823 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public Set<V> a(K param1K, Iterable<? extends V> param1Iterable) {
/*  828 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private static class n<K, V>
/*      */     extends m<K, V> implements cS<K, V> {
/*      */     private static final long serialVersionUID = 0L;
/*      */     
/*      */     n(cS<K, V> param1cS) {
/*  837 */       super(param1cS);
/*      */     }
/*      */ 
/*      */     
/*      */     public cS<K, V> a() {
/*  842 */       return (cS<K, V>)super.b();
/*      */     }
/*      */ 
/*      */     
/*      */     public SortedSet<V> a(K param1K) {
/*  847 */       return Collections.unmodifiableSortedSet(a().a(param1K));
/*      */     }
/*      */ 
/*      */     
/*      */     public SortedSet<V> b(Object param1Object) {
/*  852 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public SortedSet<V> a(K param1K, Iterable<? extends V> param1Iterable) {
/*  857 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public Comparator<? super V> valueComparator() {
/*  862 */       return a().valueComparator();
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
/*      */   public static <K, V> cF<K, V> a(cF<K, V> paramcF) {
/*  879 */     return cX.a(paramcF, (Object)null);
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
/*      */   public static <K, V> cF<K, V> b(cF<K, V> paramcF) {
/*  894 */     if (paramcF instanceof m || paramcF instanceof bu) {
/*  895 */       return paramcF;
/*      */     }
/*  897 */     return new m<>(paramcF);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static <K, V> cF<K, V> a(bu<K, V> parambu) {
/*  909 */     return (cF<K, V>)D.checkNotNull(parambu);
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
/*      */   public static <K, V> cS<K, V> a(cS<K, V> paramcS) {
/*  925 */     return cX.a(paramcS, (Object)null);
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
/*      */   public static <K, V> cS<K, V> b(cS<K, V> paramcS) {
/*  941 */     if (paramcS instanceof n) {
/*  942 */       return paramcS;
/*      */     }
/*  944 */     return new n<>(paramcS);
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
/*      */   public static <K, V> bR<K, V> a(bR<K, V> parambR) {
/*  956 */     return cX.a(parambR, (Object)null);
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
/*      */   public static <K, V> bR<K, V> b(bR<K, V> parambR) {
/*  971 */     if (parambR instanceof k || parambR instanceof bi) {
/*  972 */       return parambR;
/*      */     }
/*  974 */     return new k<>(parambR);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static <K, V> bR<K, V> a(bi<K, V> parambi) {
/*  986 */     return (bR<K, V>)D.checkNotNull(parambi);
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
/*      */   private static <V> Collection<V> c(Collection<V> paramCollection) {
/*  998 */     if (paramCollection instanceof SortedSet)
/*  999 */       return Collections.unmodifiableSortedSet((SortedSet<V>)paramCollection); 
/* 1000 */     if (paramCollection instanceof Set)
/* 1001 */       return Collections.unmodifiableSet((Set<? extends V>)paramCollection); 
/* 1002 */     if (paramCollection instanceof List) {
/* 1003 */       return Collections.unmodifiableList((List<? extends V>)paramCollection);
/*      */     }
/* 1005 */     return Collections.unmodifiableCollection(paramCollection);
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
/*      */   private static <K, V> Collection<Map.Entry<K, V>> d(Collection<Map.Entry<K, V>> paramCollection) {
/* 1018 */     if (paramCollection instanceof Set) {
/* 1019 */       return bW.unmodifiableEntrySet((Set<Map.Entry<K, V>>)paramCollection);
/*      */     }
/* 1021 */     return new bW.A<>(Collections.unmodifiableCollection(paramCollection));
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
/*      */   @com.google.a.a.a
/*      */   public static <K, V> Map<K, List<V>> a(bR<K, V> parambR) {
/* 1034 */     return (Map)parambR.asMap();
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
/*      */   @com.google.a.a.a
/*      */   public static <K, V> Map<K, Set<V>> a(cF<K, V> paramcF) {
/* 1047 */     return (Map)paramcF.asMap();
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
/*      */   @com.google.a.a.a
/*      */   public static <K, V> Map<K, SortedSet<V>> a(cS<K, V> paramcS) {
/* 1060 */     return (Map)paramcS.asMap();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.a
/*      */   public static <K, V> Map<K, Collection<V>> a(bZ<K, V> parambZ) {
/* 1071 */     return parambZ.asMap();
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
/*      */   public static <K, V> cF<K, V> a(Map<K, V> paramMap) {
/* 1090 */     return new h<>(paramMap);
/*      */   }
/*      */   
/*      */   private static class h<K, V>
/*      */     extends h<K, V> implements cF<K, V>, Serializable {
/*      */     final Map<K, V> map;
/*      */     private static final long serialVersionUID = 7845222491160860175L;
/*      */     
/*      */     h(Map<K, V> param1Map) {
/* 1099 */       this.map = (Map<K, V>)D.checkNotNull(param1Map);
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/* 1104 */       return this.map.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean containsKey(Object param1Object) {
/* 1109 */       return this.map.containsKey(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean containsValue(Object param1Object) {
/* 1114 */       return this.map.containsValue(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean c(Object param1Object1, Object param1Object2) {
/* 1119 */       return this.map.entrySet().contains(bW.d(param1Object1, param1Object2));
/*      */     }
/*      */ 
/*      */     
/*      */     public Set<V> get(final K key) {
/* 1124 */       return new cG.g<V>(this)
/*      */         {
/*      */           public Iterator<V> iterator() {
/* 1127 */             return new Iterator<V>(this)
/*      */               {
/*      */                 int i;
/*      */                 
/*      */                 public boolean hasNext() {
/* 1132 */                   return (this.i == 0 && this.a.a.map.containsKey(key));
/*      */                 }
/*      */ 
/*      */                 
/*      */                 public V next() {
/* 1137 */                   if (!hasNext()) {
/* 1138 */                     throw new NoSuchElementException();
/*      */                   }
/* 1140 */                   this.i++;
/* 1141 */                   return (V)this.a.a.map.get(key);
/*      */                 }
/*      */ 
/*      */                 
/*      */                 public void remove() {
/* 1146 */                   C.ad((this.i == 1));
/* 1147 */                   this.i = -1;
/* 1148 */                   this.a.a.map.remove(key);
/*      */                 }
/*      */               };
/*      */           }
/*      */ 
/*      */           
/*      */           public int size() {
/* 1155 */             return this.a.map.containsKey(key) ? 1 : 0;
/*      */           }
/*      */         };
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean put(K param1K, V param1V) {
/* 1162 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean putAll(K param1K, Iterable<? extends V> param1Iterable) {
/* 1167 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean a(bZ<? extends K, ? extends V> param1bZ) {
/* 1172 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public Set<V> a(K param1K, Iterable<? extends V> param1Iterable) {
/* 1177 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object1, Object param1Object2) {
/* 1182 */       return this.map.entrySet().remove(bW.d(param1Object1, param1Object2));
/*      */     }
/*      */ 
/*      */     
/*      */     public Set<V> a(Object param1Object) {
/* 1187 */       HashSet<V> hashSet = new HashSet(2);
/* 1188 */       if (!this.map.containsKey(param1Object)) {
/* 1189 */         return hashSet;
/*      */       }
/* 1191 */       hashSet.add(this.map.remove(param1Object));
/* 1192 */       return hashSet;
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/* 1197 */       this.map.clear();
/*      */     }
/*      */ 
/*      */     
/*      */     Set<K> b() {
/* 1202 */       return this.map.keySet();
/*      */     }
/*      */ 
/*      */     
/*      */     Collection<V> c() {
/* 1207 */       return this.map.values();
/*      */     }
/*      */ 
/*      */     
/*      */     public Set<Map.Entry<K, V>> g() {
/* 1212 */       return this.map.entrySet();
/*      */     }
/*      */ 
/*      */     
/*      */     Collection<Map.Entry<K, V>> d() {
/* 1217 */       throw new AssertionError("unreachable");
/*      */     }
/*      */ 
/*      */     
/*      */     cc<K> a() {
/* 1222 */       return new cb.g<>(this);
/*      */     }
/*      */ 
/*      */     
/*      */     Iterator<Map.Entry<K, V>> c() {
/* 1227 */       return this.map.entrySet().iterator();
/*      */     }
/*      */ 
/*      */     
/*      */     Map<K, Collection<V>> u() {
/* 1232 */       return new cb.a<>(this);
/*      */     }
/*      */ 
/*      */     
/*      */     public int hashCode() {
/* 1237 */       return this.map.hashCode();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <K, V1, V2> bZ<K, V2> a(bZ<K, V1> parambZ, s<? super V1, V2> params) {
/* 1286 */     D.checkNotNull(params);
/* 1287 */     bW.h<?, V1, V2> h = bW.a(params);
/* 1288 */     return a(parambZ, (bW.h)h);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <K, V1, V2> bR<K, V2> a(bR<K, V1> parambR, s<? super V1, V2> params) {
/* 1333 */     D.checkNotNull(params);
/* 1334 */     bW.h<?, V1, V2> h = bW.a(params);
/* 1335 */     return a(parambR, (bW.h)h);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <K, V1, V2> bZ<K, V2> a(bZ<K, V1> parambZ, bW.h<? super K, ? super V1, V2> paramh) {
/* 1391 */     return new j<>(parambZ, paramh);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <K, V1, V2> bR<K, V2> a(bR<K, V1> parambR, bW.h<? super K, ? super V1, V2> paramh) {
/* 1444 */     return new i<>(parambR, paramh);
/*      */   }
/*      */   
/*      */   private static class j<K, V1, V2>
/*      */     extends h<K, V2>
/*      */   {
/*      */     final bZ<K, V1> c;
/*      */     final bW.h<? super K, ? super V1, V2> b;
/*      */     
/*      */     j(bZ<K, V1> param1bZ, bW.h<? super K, ? super V1, V2> param1h) {
/* 1454 */       this.c = (bZ<K, V1>)D.checkNotNull(param1bZ);
/* 1455 */       this.b = (bW.h<? super K, ? super V1, V2>)D.checkNotNull(param1h);
/*      */     }
/*      */     
/*      */     Collection<V2> b(K param1K, Collection<V1> param1Collection) {
/* 1459 */       s<? super V1, V2> s = bW.a(this.b, param1K);
/* 1460 */       if (param1Collection instanceof List) {
/* 1461 */         return bS.a((List<V1>)param1Collection, s);
/*      */       }
/* 1463 */       return E.a(param1Collection, s);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     Map<K, Collection<V2>> u() {
/* 1469 */       return bW.a(this.c
/* 1470 */           .asMap(), (bW.h)new bW.h<K, Collection<Collection<V1>>, Collection<Collection<V2>>>(this)
/*      */           {
/*      */             public Collection<V2> c(K param2K, Collection<V1> param2Collection)
/*      */             {
/* 1474 */               return this.a.b(param2K, param2Collection);
/*      */             }
/*      */           });
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/* 1481 */       this.c.clear();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean containsKey(Object param1Object) {
/* 1486 */       return this.c.containsKey(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     Collection<Map.Entry<K, V2>> d() {
/* 1491 */       return new h.a(this);
/*      */     }
/*      */ 
/*      */     
/*      */     Iterator<Map.Entry<K, V2>> c() {
/* 1496 */       return bH.a(this.c
/* 1497 */           .entries().iterator(), bW.b(this.b));
/*      */     }
/*      */ 
/*      */     
/*      */     public Collection<V2> get(K param1K) {
/* 1502 */       return b(param1K, this.c.get(param1K));
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isEmpty() {
/* 1507 */       return this.c.isEmpty();
/*      */     }
/*      */ 
/*      */     
/*      */     Set<K> b() {
/* 1512 */       return this.c.keySet();
/*      */     }
/*      */ 
/*      */     
/*      */     cc<K> a() {
/* 1517 */       return this.c.b();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean put(K param1K, V2 param1V2) {
/* 1522 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean putAll(K param1K, Iterable<? extends V2> param1Iterable) {
/* 1527 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean a(bZ<? extends K, ? extends V2> param1bZ) {
/* 1532 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object1, Object param1Object2) {
/* 1538 */       return get((K)param1Object1).remove(param1Object2);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Collection<V2> a(Object param1Object) {
/* 1544 */       return b((K)param1Object, this.c.a(param1Object));
/*      */     }
/*      */ 
/*      */     
/*      */     public Collection<V2> a(K param1K, Iterable<? extends V2> param1Iterable) {
/* 1549 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/* 1554 */       return this.c.size();
/*      */     }
/*      */ 
/*      */     
/*      */     Collection<V2> c() {
/* 1559 */       return E.a(this.c
/* 1560 */           .entries(), bW.a(this.b));
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class i<K, V1, V2>
/*      */     extends j<K, V1, V2>
/*      */     implements bR<K, V2>
/*      */   {
/*      */     i(bR<K, V1> param1bR, bW.h<? super K, ? super V1, V2> param1h) {
/* 1569 */       super(param1bR, param1h);
/*      */     }
/*      */ 
/*      */     
/*      */     List<V2> a(K param1K, Collection<V1> param1Collection) {
/* 1574 */       return bS.a((List)param1Collection, bW.a(this.b, param1K));
/*      */     }
/*      */ 
/*      */     
/*      */     public List<V2> get(K param1K) {
/* 1579 */       return a(param1K, this.c.get(param1K));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public List<V2> a(Object param1Object) {
/* 1585 */       return a((K)param1Object, this.c.a(param1Object));
/*      */     }
/*      */ 
/*      */     
/*      */     public List<V2> a(K param1K, Iterable<? extends V2> param1Iterable) {
/* 1590 */       throw new UnsupportedOperationException();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <K, V> bi<K, V> a(Iterable<V> paramIterable, s<? super V, K> params) {
/* 1631 */     return a(paramIterable.iterator(), params);
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
/*      */ 
/*      */   
/*      */   public static <K, V> bi<K, V> a(Iterator<V> paramIterator, s<? super V, K> params) {
/* 1672 */     D.checkNotNull(params);
/* 1673 */     bi.a<?, ?> a = bi.a();
/* 1674 */     while (paramIterator.hasNext()) {
/* 1675 */       V v = paramIterator.next();
/* 1676 */       D.b(v, paramIterator);
/* 1677 */       a.a(params.apply(v), v);
/*      */     } 
/* 1679 */     return (bi)a.d();
/*      */   }
/*      */   
/*      */   static class g<K, V> extends i<K> { @com.google.c.a.i
/*      */     final bZ<K, V> b;
/*      */     
/*      */     g(bZ<K, V> param1bZ) {
/* 1686 */       this.b = param1bZ;
/*      */     }
/*      */ 
/*      */     
/*      */     Iterator<cc.a<K>> c() {
/* 1691 */       return new db<Map.Entry<K, Collection<V>>, cc.a<K>>(this, this.b
/* 1692 */           .asMap().entrySet().iterator())
/*      */         {
/*      */           cc.a<K> a(Map.Entry<K, Collection<V>> param2Entry) {
/* 1695 */             return new cd.a<K>(this, param2Entry)
/*      */               {
/*      */                 public K getElement() {
/* 1698 */                   return (K)this.e.getKey();
/*      */                 }
/*      */ 
/*      */                 
/*      */                 public int getCount() {
/* 1703 */                   return ((Collection)this.e.getValue()).size();
/*      */                 }
/*      */               };
/*      */           }
/*      */         };
/*      */     }
/*      */ 
/*      */     
/*      */     public Spliterator<K> spliterator() {
/* 1712 */       return D.a(this.b.entries().spliterator(), Map.Entry::getKey);
/*      */     }
/*      */ 
/*      */     
/*      */     public void forEach(Consumer<? super K> param1Consumer) {
/* 1717 */       D.checkNotNull(param1Consumer);
/* 1718 */       this.b.entries().forEach(param1Entry -> param1Consumer.accept(param1Entry.getKey()));
/*      */     }
/*      */ 
/*      */     
/*      */     int ah() {
/* 1723 */       return this.b.asMap().size();
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/* 1728 */       return this.b.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean contains(Object param1Object) {
/* 1733 */       return this.b.containsKey(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<K> iterator() {
/* 1738 */       return bW.c(this.b.entries().iterator());
/*      */     }
/*      */ 
/*      */     
/*      */     public int b(Object param1Object) {
/* 1743 */       Collection collection = bW.<Collection>a((Map)this.b.asMap(), param1Object);
/* 1744 */       return (collection == null) ? 0 : collection.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public int remove(Object param1Object, int param1Int) {
/* 1749 */       C.b(param1Int, "occurrences");
/* 1750 */       if (param1Int == 0) {
/* 1751 */         return b(param1Object);
/*      */       }
/*      */       
/* 1754 */       Collection collection = bW.<Collection>a((Map)this.b.asMap(), param1Object);
/*      */       
/* 1756 */       if (collection == null) {
/* 1757 */         return 0;
/*      */       }
/*      */       
/* 1760 */       int j = collection.size();
/* 1761 */       if (param1Int >= j) {
/* 1762 */         collection.clear();
/*      */       } else {
/* 1764 */         Iterator iterator = collection.iterator();
/* 1765 */         for (byte b = 0; b < param1Int; b++) {
/* 1766 */           iterator.next();
/* 1767 */           iterator.remove();
/*      */         } 
/*      */       } 
/* 1770 */       return j;
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/* 1775 */       this.b.clear();
/*      */     }
/*      */ 
/*      */     
/*      */     public Set<K> d() {
/* 1780 */       return this.b.keySet();
/*      */     }
/*      */ 
/*      */     
/*      */     Iterator<K> e() {
/* 1785 */       throw new AssertionError("should never be called");
/*      */     } }
/*      */ 
/*      */   
/*      */   static abstract class f<K, V>
/*      */     extends AbstractCollection<Map.Entry<K, V>>
/*      */   {
/*      */     abstract bZ<K, V> a();
/*      */     
/*      */     public int size() {
/* 1795 */       return a().size();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean contains(Object param1Object) {
/* 1800 */       if (param1Object instanceof Map.Entry) {
/* 1801 */         Map.Entry entry = (Map.Entry)param1Object;
/* 1802 */         return a().c(entry.getKey(), entry.getValue());
/*      */       } 
/* 1804 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object) {
/* 1809 */       if (param1Object instanceof Map.Entry) {
/* 1810 */         Map.Entry entry = (Map.Entry)param1Object;
/* 1811 */         return a().remove(entry.getKey(), entry.getValue());
/*      */       } 
/* 1813 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/* 1818 */       a().clear();
/*      */     }
/*      */   }
/*      */   
/*      */   static final class a<K, V> extends bW.F<K, Collection<V>> {
/*      */     @com.google.c.a.i
/*      */     private final bZ<K, V> b;
/*      */     
/*      */     a(bZ<K, V> param1bZ) {
/* 1827 */       this.b = (bZ<K, V>)D.checkNotNull(param1bZ);
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/* 1832 */       return this.b.keySet().size();
/*      */     }
/*      */ 
/*      */     
/*      */     protected Set<Map.Entry<K, Collection<V>>> createEntrySet() {
/* 1837 */       return new a(this);
/*      */     }
/*      */     
/*      */     void h(Object param1Object) {
/* 1841 */       this.b.keySet().remove(param1Object);
/*      */     }
/*      */     
/*      */     class a extends bW.g<K, Collection<V>> {
/*      */       a(cb.a this$0) {}
/*      */       
/*      */       Map<K, Collection<V>> w() {
/* 1848 */         return this.a;
/*      */       }
/*      */ 
/*      */       
/*      */       public Iterator<Map.Entry<K, Collection<V>>> iterator() {
/* 1853 */         return bW.a(
/* 1854 */             cb.a.a(this.a).keySet(), new s<K, Collection<V>>(this)
/*      */             {
/*      */               public Collection<V> d(K param3K)
/*      */               {
/* 1858 */                 return cb.a.a(this.a.a).get(param3K);
/*      */               }
/*      */             });
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean remove(Object param2Object) {
/* 1865 */         if (!contains(param2Object)) {
/* 1866 */           return false;
/*      */         }
/* 1868 */         Map.Entry entry = (Map.Entry)param2Object;
/* 1869 */         this.a.h(entry.getKey());
/* 1870 */         return true;
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Collection<V> get(Object param1Object) {
/* 1877 */       return containsKey(param1Object) ? this.b.get((K)param1Object) : null;
/*      */     }
/*      */ 
/*      */     
/*      */     public Collection<V> remove(Object param1Object) {
/* 1882 */       return containsKey(param1Object) ? this.b.a(param1Object) : null;
/*      */     }
/*      */ 
/*      */     
/*      */     public Set<K> keySet() {
/* 1887 */       return this.b.keySet();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isEmpty() {
/* 1892 */       return this.b.isEmpty();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean containsKey(Object param1Object) {
/* 1897 */       return this.b.containsKey(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/* 1902 */       this.b.clear();
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <K, V> bZ<K, V> a(bZ<K, V> parambZ, E<? super K> paramE) {
/* 1935 */     if (parambZ instanceof cF)
/* 1936 */       return a((cF<K, V>)parambZ, paramE); 
/* 1937 */     if (parambZ instanceof bR)
/* 1938 */       return a((bR<K, V>)parambZ, paramE); 
/* 1939 */     if (parambZ instanceof ak) {
/* 1940 */       ak ak = (ak)parambZ;
/* 1941 */       return new ak<>(ak.a, 
/* 1942 */           F.a(ak.d, paramE));
/* 1943 */     }  if (parambZ instanceof am) {
/* 1944 */       am<K, V> am = (am)parambZ;
/* 1945 */       return a(am, (E)bW.b(paramE));
/*      */     } 
/* 1947 */     return new ak<>(parambZ, paramE);
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
/*      */   public static <K, V> cF<K, V> a(cF<K, V> paramcF, E<? super K> paramE) {
/* 1980 */     if (paramcF instanceof al) {
/* 1981 */       al<K, V> al = (al)paramcF;
/* 1982 */       return new al<>(al
/* 1983 */           .a(), F.a(al.d, paramE));
/* 1984 */     }  if (paramcF instanceof ao) {
/* 1985 */       ao<K, V> ao = (ao)paramcF;
/* 1986 */       return a(ao, (E)bW.b(paramE));
/*      */     } 
/* 1988 */     return new al<>(paramcF, paramE);
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
/*      */   public static <K, V> bR<K, V> a(bR<K, V> parambR, E<? super K> paramE) {
/* 2021 */     if (parambR instanceof aj) {
/* 2022 */       aj<K, V> aj = (aj)parambR;
/* 2023 */       return new aj<>(aj
/* 2024 */           .a(), F.a(aj.d, paramE));
/*      */     } 
/* 2026 */     return new aj<>(parambR, paramE);
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
/*      */   public static <K, V> bZ<K, V> b(bZ<K, V> parambZ, E<? super V> paramE) {
/* 2059 */     return c(parambZ, (E)bW.c(paramE));
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
/*      */   public static <K, V> cF<K, V> b(cF<K, V> paramcF, E<? super V> paramE) {
/* 2091 */     return c(paramcF, (E)bW.c(paramE));
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
/*      */   public static <K, V> bZ<K, V> c(bZ<K, V> parambZ, E<? super Map.Entry<K, V>> paramE) {
/* 2121 */     D.checkNotNull(paramE);
/* 2122 */     if (parambZ instanceof cF) {
/* 2123 */       return c((cF<K, V>)parambZ, paramE);
/*      */     }
/* 2125 */     return (parambZ instanceof am) ? 
/* 2126 */       a((am<K, V>)parambZ, paramE) : 
/* 2127 */       new ah<>((bZ<K, V>)D.checkNotNull(parambZ), paramE);
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
/*      */   public static <K, V> cF<K, V> c(cF<K, V> paramcF, E<? super Map.Entry<K, V>> paramE) {
/* 2157 */     D.checkNotNull(paramE);
/* 2158 */     return (paramcF instanceof ao) ? 
/* 2159 */       a((ao<K, V>)paramcF, paramE) : 
/* 2160 */       new ai<>((cF<K, V>)D.checkNotNull(paramcF), paramE);
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
/*      */   private static <K, V> bZ<K, V> a(am<K, V> paramam, E<? super Map.Entry<K, V>> paramE) {
/* 2172 */     E<? super Map.Entry<K, V>> e = F.a(paramam.f(), paramE);
/* 2173 */     return new ah<>(paramam.b(), e);
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
/*      */   private static <K, V> cF<K, V> a(ao<K, V> paramao, E<? super Map.Entry<K, V>> paramE) {
/* 2185 */     E<? super Map.Entry<K, V>> e = F.a(paramao.f(), paramE);
/* 2186 */     return new ai<>(paramao.a(), e);
/*      */   }
/*      */   
/*      */   static boolean a(bZ<?, ?> parambZ, Object paramObject) {
/* 2190 */     if (paramObject == parambZ) {
/* 2191 */       return true;
/*      */     }
/* 2193 */     if (paramObject instanceof bZ) {
/* 2194 */       bZ bZ1 = (bZ)paramObject;
/* 2195 */       return parambZ.asMap().equals(bZ1.asMap());
/*      */     } 
/* 2197 */     return false;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\cb.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */