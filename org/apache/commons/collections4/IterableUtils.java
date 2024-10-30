/*      */ package org.apache.commons.collections4;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Comparator;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Set;
/*      */ import org.apache.commons.collections4.functors.EqualPredicate;
/*      */ import org.apache.commons.collections4.iterators.LazyIteratorChain;
/*      */ import org.apache.commons.collections4.iterators.ReverseListIterator;
/*      */ import org.apache.commons.collections4.iterators.UniqueFilterIterator;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class IterableUtils
/*      */ {
/*   56 */   static final FluentIterable EMPTY_ITERABLE = new FluentIterable()
/*      */     {
/*      */       public Iterator<Object> iterator() {
/*   59 */         return IteratorUtils.emptyIterator();
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <E> Iterable<E> emptyIterable() {
/*   76 */     return EMPTY_ITERABLE;
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
/*      */   public static <E> Iterable<E> chainedIterable(Iterable<? extends E> paramIterable1, Iterable<? extends E> paramIterable2) {
/*  101 */     return chainedIterable((Iterable<? extends E>[])new Iterable[] { paramIterable1, paramIterable2 });
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
/*      */   public static <E> Iterable<E> chainedIterable(Iterable<? extends E> paramIterable1, Iterable<? extends E> paramIterable2, Iterable<? extends E> paramIterable3) {
/*  125 */     return chainedIterable((Iterable<? extends E>[])new Iterable[] { paramIterable1, paramIterable2, paramIterable3 });
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
/*      */   public static <E> Iterable<E> chainedIterable(Iterable<? extends E> paramIterable1, Iterable<? extends E> paramIterable2, Iterable<? extends E> paramIterable3, Iterable<? extends E> paramIterable4) {
/*  151 */     return chainedIterable((Iterable<? extends E>[])new Iterable[] { paramIterable1, paramIterable2, paramIterable3, paramIterable4 });
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
/*      */   public static <E> Iterable<E> chainedIterable(Iterable<? extends E>... iterables) {
/*  170 */     checkNotNull((Iterable<?>[])iterables);
/*  171 */     return new FluentIterable<E>()
/*      */       {
/*      */         public Iterator<E> iterator() {
/*  174 */           return (Iterator<E>)new LazyIteratorChain<E>()
/*      */             {
/*      */               protected Iterator<? extends E> nextIterator(int param2Int) {
/*  177 */                 if (param2Int > iterables.length) {
/*  178 */                   return null;
/*      */                 }
/*  180 */                 return iterables[param2Int - 1].iterator();
/*      */               }
/*      */             };
/*      */         }
/*      */       };
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
/*      */   public static <E> Iterable<E> collatedIterable(final Iterable<? extends E> a, final Iterable<? extends E> b) {
/*  206 */     checkNotNull((Iterable<?>[])new Iterable[] { a, b });
/*  207 */     return new FluentIterable<E>()
/*      */       {
/*      */         public Iterator<E> iterator() {
/*  210 */           return IteratorUtils.collatedIterator(null, a.iterator(), b.iterator());
/*      */         }
/*      */       };
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
/*      */   public static <E> Iterable<E> collatedIterable(final Comparator<? super E> comparator, final Iterable<? extends E> a, final Iterable<? extends E> b) {
/*  234 */     checkNotNull((Iterable<?>[])new Iterable[] { a, b });
/*  235 */     return new FluentIterable<E>()
/*      */       {
/*      */         public Iterator<E> iterator() {
/*  238 */           return IteratorUtils.collatedIterator(comparator, a.iterator(), b.iterator());
/*      */         }
/*      */       };
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
/*      */   public static <E> Iterable<E> filteredIterable(final Iterable<E> iterable, final Predicate<? super E> predicate) {
/*  261 */     checkNotNull(iterable);
/*  262 */     if (predicate == null) {
/*  263 */       throw new NullPointerException("Predicate must not be null.");
/*      */     }
/*  265 */     return new FluentIterable<E>()
/*      */       {
/*      */         public Iterator<E> iterator() {
/*  268 */           return IteratorUtils.filteredIterator(IterableUtils.emptyIteratorIfNull(iterable), predicate);
/*      */         }
/*      */       };
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
/*      */   public static <E> Iterable<E> boundedIterable(final Iterable<E> iterable, final long maxSize) {
/*  291 */     checkNotNull(iterable);
/*  292 */     if (maxSize < 0L) {
/*  293 */       throw new IllegalArgumentException("MaxSize parameter must not be negative.");
/*      */     }
/*      */     
/*  296 */     return new FluentIterable<E>()
/*      */       {
/*      */         public Iterator<E> iterator() {
/*  299 */           return (Iterator)IteratorUtils.boundedIterator(iterable.iterator(), maxSize);
/*      */         }
/*      */       };
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
/*      */   public static <E> Iterable<E> loopingIterable(final Iterable<E> iterable) {
/*  323 */     checkNotNull(iterable);
/*  324 */     return new FluentIterable<E>()
/*      */       {
/*      */         public Iterator<E> iterator() {
/*  327 */           return (Iterator<E>)new LazyIteratorChain<E>()
/*      */             {
/*      */               protected Iterator<? extends E> nextIterator(int param2Int) {
/*  330 */                 if (IterableUtils.isEmpty(iterable)) {
/*  331 */                   return null;
/*      */                 }
/*  333 */                 return iterable.iterator();
/*      */               }
/*      */             };
/*      */         }
/*      */       };
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
/*      */   public static <E> Iterable<E> reversedIterable(final Iterable<E> iterable) {
/*  361 */     checkNotNull(iterable);
/*  362 */     return new FluentIterable<E>()
/*      */       {
/*      */         public Iterator<E> iterator() {
/*  365 */           List list = (iterable instanceof List) ? (List)iterable : IteratorUtils.toList(iterable.iterator());
/*      */ 
/*      */           
/*  368 */           return (Iterator<E>)new ReverseListIterator(list);
/*      */         }
/*      */       };
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
/*      */   public static <E> Iterable<E> skippingIterable(final Iterable<E> iterable, final long elementsToSkip) {
/*  390 */     checkNotNull(iterable);
/*  391 */     if (elementsToSkip < 0L) {
/*  392 */       throw new IllegalArgumentException("ElementsToSkip parameter must not be negative.");
/*      */     }
/*      */     
/*  395 */     return new FluentIterable<E>()
/*      */       {
/*      */         public Iterator<E> iterator() {
/*  398 */           return (Iterator)IteratorUtils.skippingIterator(iterable.iterator(), elementsToSkip);
/*      */         }
/*      */       };
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
/*      */   public static <I, O> Iterable<O> transformedIterable(final Iterable<I> iterable, final Transformer<? super I, ? extends O> transformer) {
/*  422 */     checkNotNull(iterable);
/*  423 */     if (transformer == null) {
/*  424 */       throw new NullPointerException("Transformer must not be null.");
/*      */     }
/*  426 */     return new FluentIterable<O>()
/*      */       {
/*      */         public Iterator<O> iterator() {
/*  429 */           return IteratorUtils.transformedIterator(iterable.iterator(), transformer);
/*      */         }
/*      */       };
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
/*      */   public static <E> Iterable<E> uniqueIterable(final Iterable<E> iterable) {
/*  450 */     checkNotNull(iterable);
/*  451 */     return new FluentIterable<E>()
/*      */       {
/*      */         public Iterator<E> iterator() {
/*  454 */           return (Iterator<E>)new UniqueFilterIterator(iterable.iterator());
/*      */         }
/*      */       };
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
/*      */   public static <E> Iterable<E> unmodifiableIterable(Iterable<E> paramIterable) {
/*  473 */     checkNotNull(paramIterable);
/*  474 */     if (paramIterable instanceof UnmodifiableIterable) {
/*  475 */       return paramIterable;
/*      */     }
/*  477 */     return new UnmodifiableIterable<E>(paramIterable);
/*      */   }
/*      */ 
/*      */   
/*      */   private static final class UnmodifiableIterable<E>
/*      */     extends FluentIterable<E>
/*      */   {
/*      */     private final Iterable<E> unmodifiable;
/*      */ 
/*      */     
/*      */     public UnmodifiableIterable(Iterable<E> param1Iterable) {
/*  488 */       this.unmodifiable = param1Iterable;
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<E> iterator() {
/*  493 */       return IteratorUtils.unmodifiableIterator(this.unmodifiable.iterator());
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
/*      */   public static <E> Iterable<E> zippingIterable(final Iterable<? extends E> a, final Iterable<? extends E> b) {
/*  518 */     checkNotNull(a);
/*  519 */     checkNotNull(b);
/*  520 */     return new FluentIterable<E>()
/*      */       {
/*      */         public Iterator<E> iterator() {
/*  523 */           return (Iterator)IteratorUtils.zippingIterator(a.iterator(), b.iterator());
/*      */         }
/*      */       };
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
/*      */   public static <E> Iterable<E> zippingIterable(final Iterable<? extends E> first, Iterable<? extends E>... others) {
/*  546 */     checkNotNull(first);
/*  547 */     checkNotNull((Iterable<?>[])others);
/*  548 */     return new FluentIterable<E>()
/*      */       {
/*      */         public Iterator<E> iterator()
/*      */         {
/*  552 */           Iterator[] arrayOfIterator = new Iterator[others.length + 1];
/*  553 */           arrayOfIterator[0] = first.iterator();
/*  554 */           for (byte b = 0; b < others.length; b++) {
/*  555 */             arrayOfIterator[b + 1] = others[b].iterator();
/*      */           }
/*  557 */           return (Iterator)IteratorUtils.zippingIterator((Iterator<?>[])arrayOfIterator);
/*      */         }
/*      */       };
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
/*      */   public static <E> Iterable<E> emptyIfNull(Iterable<E> paramIterable) {
/*  574 */     return (paramIterable == null) ? emptyIterable() : paramIterable;
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
/*      */   public static <E> void forEach(Iterable<E> paramIterable, Closure<? super E> paramClosure) {
/*  586 */     IteratorUtils.forEach(emptyIteratorIfNull(paramIterable), paramClosure);
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
/*      */   public static <E> E forEachButLast(Iterable<E> paramIterable, Closure<? super E> paramClosure) {
/*  600 */     return IteratorUtils.forEachButLast(emptyIteratorIfNull(paramIterable), paramClosure);
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
/*      */   public static <E> E find(Iterable<E> paramIterable, Predicate<? super E> paramPredicate) {
/*  615 */     return IteratorUtils.find(emptyIteratorIfNull(paramIterable), paramPredicate);
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
/*      */   public static <E> int indexOf(Iterable<E> paramIterable, Predicate<? super E> paramPredicate) {
/*  631 */     return IteratorUtils.indexOf(emptyIteratorIfNull(paramIterable), paramPredicate);
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
/*      */   public static <E> boolean matchesAll(Iterable<E> paramIterable, Predicate<? super E> paramPredicate) {
/*  647 */     return IteratorUtils.matchesAll(emptyIteratorIfNull(paramIterable), paramPredicate);
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
/*      */   public static <E> boolean matchesAny(Iterable<E> paramIterable, Predicate<? super E> paramPredicate) {
/*  662 */     return IteratorUtils.matchesAny(emptyIteratorIfNull(paramIterable), paramPredicate);
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
/*      */   public static <E> long countMatches(Iterable<E> paramIterable, Predicate<? super E> paramPredicate) {
/*  677 */     if (paramPredicate == null) {
/*  678 */       throw new NullPointerException("Predicate must not be null.");
/*      */     }
/*  680 */     return size(filteredIterable(emptyIfNull(paramIterable), paramPredicate));
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
/*      */   public static boolean isEmpty(Iterable<?> paramIterable) {
/*  692 */     if (paramIterable instanceof Collection) {
/*  693 */       return ((Collection)paramIterable).isEmpty();
/*      */     }
/*  695 */     return IteratorUtils.isEmpty(emptyIteratorIfNull(paramIterable));
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
/*      */   public static <E> boolean contains(Iterable<E> paramIterable, Object paramObject) {
/*  710 */     if (paramIterable instanceof Collection) {
/*  711 */       return ((Collection)paramIterable).contains(paramObject);
/*      */     }
/*  713 */     return IteratorUtils.contains(emptyIteratorIfNull(paramIterable), paramObject);
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
/*      */   public static <E> boolean contains(Iterable<? extends E> paramIterable, E paramE, Equator<? super E> paramEquator) {
/*  736 */     if (paramEquator == null) {
/*  737 */       throw new NullPointerException("Equator must not be null.");
/*      */     }
/*  739 */     return matchesAny(paramIterable, EqualPredicate.equalPredicate(paramE, paramEquator));
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
/*      */   public static <E, T extends E> int frequency(Iterable<E> paramIterable, T paramT) {
/*  752 */     if (paramIterable instanceof Set) {
/*  753 */       return ((Set)paramIterable).contains(paramT) ? 1 : 0;
/*      */     }
/*  755 */     if (paramIterable instanceof Bag) {
/*  756 */       return ((Bag)paramIterable).getCount(paramT);
/*      */     }
/*  758 */     return size(filteredIterable(emptyIfNull(paramIterable), EqualPredicate.equalPredicate(paramT)));
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
/*      */   public static <T> T get(Iterable<T> paramIterable, int paramInt) {
/*  774 */     CollectionUtils.checkIndexBounds(paramInt);
/*  775 */     if (paramIterable instanceof List) {
/*  776 */       return ((List<T>)paramIterable).get(paramInt);
/*      */     }
/*  778 */     return IteratorUtils.get(emptyIteratorIfNull(paramIterable), paramInt);
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
/*      */   public static int size(Iterable<?> paramIterable) {
/*  790 */     if (paramIterable instanceof Collection) {
/*  791 */       return ((Collection)paramIterable).size();
/*      */     }
/*  793 */     return IteratorUtils.size(emptyIteratorIfNull(paramIterable));
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
/*      */   public static <O> List<List<O>> partition(Iterable<? extends O> paramIterable, Predicate<? super O> paramPredicate) {
/*  826 */     if (paramPredicate == null) {
/*  827 */       throw new NullPointerException("Predicate must not be null.");
/*      */     }
/*      */     
/*  830 */     Factory<ArrayList> factory = FactoryUtils.instantiateFactory(ArrayList.class);
/*      */     
/*  832 */     Predicate[] arrayOfPredicate = { paramPredicate };
/*  833 */     return partition(paramIterable, (Factory)factory, (Predicate<? super O>[])arrayOfPredicate);
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
/*      */   public static <O> List<List<O>> partition(Iterable<? extends O> paramIterable, Predicate<? super O>... paramVarArgs) {
/*  872 */     Factory<ArrayList> factory = FactoryUtils.instantiateFactory(ArrayList.class);
/*  873 */     return partition(paramIterable, (Factory)factory, paramVarArgs);
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
/*      */   public static <O, R extends Collection<O>> List<R> partition(Iterable<? extends O> paramIterable, Factory<R> paramFactory, Predicate<? super O>... paramVarArgs) {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: ifnonnull -> 15
/*      */     //   4: invokestatic emptyIterable : ()Ljava/lang/Iterable;
/*      */     //   7: astore_3
/*      */     //   8: aload_3
/*      */     //   9: aload_1
/*      */     //   10: aload_2
/*      */     //   11: invokestatic partition : (Ljava/lang/Iterable;Lorg/apache/commons/collections4/Factory;[Lorg/apache/commons/collections4/Predicate;)Ljava/util/List;
/*      */     //   14: areturn
/*      */     //   15: aload_2
/*      */     //   16: ifnonnull -> 29
/*      */     //   19: new java/lang/NullPointerException
/*      */     //   22: dup
/*      */     //   23: ldc 'Predicates must not be null.'
/*      */     //   25: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   28: athrow
/*      */     //   29: aload_2
/*      */     //   30: astore_3
/*      */     //   31: aload_3
/*      */     //   32: arraylength
/*      */     //   33: istore #4
/*      */     //   35: iconst_0
/*      */     //   36: istore #5
/*      */     //   38: iload #5
/*      */     //   40: iload #4
/*      */     //   42: if_icmpge -> 72
/*      */     //   45: aload_3
/*      */     //   46: iload #5
/*      */     //   48: aaload
/*      */     //   49: astore #6
/*      */     //   51: aload #6
/*      */     //   53: ifnonnull -> 66
/*      */     //   56: new java/lang/NullPointerException
/*      */     //   59: dup
/*      */     //   60: ldc 'Predicate must not be null.'
/*      */     //   62: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   65: athrow
/*      */     //   66: iinc #5, 1
/*      */     //   69: goto -> 38
/*      */     //   72: aload_2
/*      */     //   73: arraylength
/*      */     //   74: iconst_1
/*      */     //   75: if_icmpge -> 99
/*      */     //   78: aload_1
/*      */     //   79: invokeinterface create : ()Ljava/lang/Object;
/*      */     //   84: checkcast java/util/Collection
/*      */     //   87: astore_3
/*      */     //   88: aload_3
/*      */     //   89: aload_0
/*      */     //   90: invokestatic addAll : (Ljava/util/Collection;Ljava/lang/Iterable;)Z
/*      */     //   93: pop
/*      */     //   94: aload_3
/*      */     //   95: invokestatic singletonList : (Ljava/lang/Object;)Ljava/util/List;
/*      */     //   98: areturn
/*      */     //   99: aload_2
/*      */     //   100: arraylength
/*      */     //   101: istore_3
/*      */     //   102: iload_3
/*      */     //   103: iconst_1
/*      */     //   104: iadd
/*      */     //   105: istore #4
/*      */     //   107: new java/util/ArrayList
/*      */     //   110: dup
/*      */     //   111: iload #4
/*      */     //   113: invokespecial <init> : (I)V
/*      */     //   116: astore #5
/*      */     //   118: iconst_0
/*      */     //   119: istore #6
/*      */     //   121: iload #6
/*      */     //   123: iload #4
/*      */     //   125: if_icmpge -> 148
/*      */     //   128: aload #5
/*      */     //   130: aload_1
/*      */     //   131: invokeinterface create : ()Ljava/lang/Object;
/*      */     //   136: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   141: pop
/*      */     //   142: iinc #6, 1
/*      */     //   145: goto -> 121
/*      */     //   148: aload_0
/*      */     //   149: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */     //   154: astore #6
/*      */     //   156: aload #6
/*      */     //   158: invokeinterface hasNext : ()Z
/*      */     //   163: ifeq -> 260
/*      */     //   166: aload #6
/*      */     //   168: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   173: astore #7
/*      */     //   175: iconst_0
/*      */     //   176: istore #8
/*      */     //   178: iconst_0
/*      */     //   179: istore #9
/*      */     //   181: iload #9
/*      */     //   183: iload_3
/*      */     //   184: if_icmpge -> 233
/*      */     //   187: aload_2
/*      */     //   188: iload #9
/*      */     //   190: aaload
/*      */     //   191: aload #7
/*      */     //   193: invokeinterface evaluate : (Ljava/lang/Object;)Z
/*      */     //   198: ifeq -> 227
/*      */     //   201: aload #5
/*      */     //   203: iload #9
/*      */     //   205: invokeinterface get : (I)Ljava/lang/Object;
/*      */     //   210: checkcast java/util/Collection
/*      */     //   213: aload #7
/*      */     //   215: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   220: pop
/*      */     //   221: iconst_1
/*      */     //   222: istore #8
/*      */     //   224: goto -> 233
/*      */     //   227: iinc #9, 1
/*      */     //   230: goto -> 181
/*      */     //   233: iload #8
/*      */     //   235: ifne -> 257
/*      */     //   238: aload #5
/*      */     //   240: iload_3
/*      */     //   241: invokeinterface get : (I)Ljava/lang/Object;
/*      */     //   246: checkcast java/util/Collection
/*      */     //   249: aload #7
/*      */     //   251: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   256: pop
/*      */     //   257: goto -> 156
/*      */     //   260: aload #5
/*      */     //   262: areturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #915	-> 0
/*      */     //   #916	-> 4
/*      */     //   #917	-> 8
/*      */     //   #920	-> 15
/*      */     //   #921	-> 19
/*      */     //   #924	-> 29
/*      */     //   #925	-> 51
/*      */     //   #926	-> 56
/*      */     //   #924	-> 66
/*      */     //   #930	-> 72
/*      */     //   #932	-> 78
/*      */     //   #933	-> 88
/*      */     //   #934	-> 94
/*      */     //   #938	-> 99
/*      */     //   #939	-> 102
/*      */     //   #940	-> 107
/*      */     //   #941	-> 118
/*      */     //   #942	-> 128
/*      */     //   #941	-> 142
/*      */     //   #949	-> 148
/*      */     //   #950	-> 175
/*      */     //   #951	-> 178
/*      */     //   #952	-> 187
/*      */     //   #953	-> 201
/*      */     //   #954	-> 221
/*      */     //   #955	-> 224
/*      */     //   #951	-> 227
/*      */     //   #959	-> 233
/*      */     //   #962	-> 238
/*      */     //   #964	-> 257
/*      */     //   #966	-> 260
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
/*      */   public static <E> List<E> toList(Iterable<E> paramIterable) {
/*  977 */     return IteratorUtils.toList(emptyIteratorIfNull(paramIterable));
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
/*      */   public static <E> String toString(Iterable<E> paramIterable) {
/*  993 */     return IteratorUtils.toString(emptyIteratorIfNull(paramIterable));
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
/*      */   public static <E> String toString(Iterable<E> paramIterable, Transformer<? super E, String> paramTransformer) {
/* 1012 */     if (paramTransformer == null) {
/* 1013 */       throw new NullPointerException("Transformer must not be null.");
/*      */     }
/* 1015 */     return IteratorUtils.toString(emptyIteratorIfNull(paramIterable), paramTransformer);
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
/*      */   public static <E> String toString(Iterable<E> paramIterable, Transformer<? super E, String> paramTransformer, String paramString1, String paramString2, String paramString3) {
/* 1040 */     return IteratorUtils.toString(emptyIteratorIfNull(paramIterable), paramTransformer, paramString1, paramString2, paramString3);
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
/*      */   static void checkNotNull(Iterable<?> paramIterable) {
/* 1054 */     if (paramIterable == null) {
/* 1055 */       throw new NullPointerException("Iterable must not be null.");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static void checkNotNull(Iterable<?>... paramVarArgs) {
/* 1066 */     if (paramVarArgs == null) {
/* 1067 */       throw new NullPointerException("Iterables must not be null.");
/*      */     }
/* 1069 */     for (Iterable<?> iterable : paramVarArgs) {
/* 1070 */       checkNotNull(iterable);
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
/*      */   private static <E> Iterator<E> emptyIteratorIfNull(Iterable<E> paramIterable) {
/* 1083 */     return (paramIterable != null) ? paramIterable.iterator() : IteratorUtils.<E>emptyIterator();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\IterableUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */