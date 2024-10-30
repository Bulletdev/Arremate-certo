/*     */ package org.apache.commons.collections4;
/*     */ 
/*     */ import java.util.AbstractSet;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.IdentityHashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.NavigableSet;
/*     */ import java.util.Set;
/*     */ import java.util.SortedSet;
/*     */ import java.util.TreeSet;
/*     */ import org.apache.commons.collections4.set.ListOrderedSet;
/*     */ import org.apache.commons.collections4.set.PredicatedNavigableSet;
/*     */ import org.apache.commons.collections4.set.PredicatedSet;
/*     */ import org.apache.commons.collections4.set.PredicatedSortedSet;
/*     */ import org.apache.commons.collections4.set.TransformedNavigableSet;
/*     */ import org.apache.commons.collections4.set.TransformedSet;
/*     */ import org.apache.commons.collections4.set.TransformedSortedSet;
/*     */ import org.apache.commons.collections4.set.UnmodifiableNavigableSet;
/*     */ import org.apache.commons.collections4.set.UnmodifiableSet;
/*     */ import org.apache.commons.collections4.set.UnmodifiableSortedSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SetUtils
/*     */ {
/*     */   public static <E> Set<E> emptySet() {
/*  56 */     return Collections.emptySet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  64 */   public static final SortedSet EMPTY_SORTED_SET = UnmodifiableSortedSet.unmodifiableSortedSet(new TreeSet());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> SortedSet<E> emptySortedSet() {
/*  74 */     return EMPTY_SORTED_SET;
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
/*     */   public static <T> Set<T> emptyIfNull(Set<T> paramSet) {
/*  93 */     return (paramSet == null) ? Collections.<T>emptySet() : paramSet;
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
/*     */   public static boolean isEqualSet(Collection<?> paramCollection1, Collection<?> paramCollection2) {
/* 125 */     if (paramCollection1 == paramCollection2) {
/* 126 */       return true;
/*     */     }
/* 128 */     if (paramCollection1 == null || paramCollection2 == null || paramCollection1.size() != paramCollection2.size()) {
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     return paramCollection1.containsAll(paramCollection2);
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
/*     */   public static <T> int hashCodeForSet(Collection<T> paramCollection) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: ifnonnull -> 6
/*     */     //   4: iconst_0
/*     */     //   5: ireturn
/*     */     //   6: iconst_0
/*     */     //   7: istore_1
/*     */     //   8: aload_0
/*     */     //   9: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   14: astore_2
/*     */     //   15: aload_2
/*     */     //   16: invokeinterface hasNext : ()Z
/*     */     //   21: ifeq -> 45
/*     */     //   24: aload_2
/*     */     //   25: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   30: astore_3
/*     */     //   31: aload_3
/*     */     //   32: ifnull -> 42
/*     */     //   35: iload_1
/*     */     //   36: aload_3
/*     */     //   37: invokevirtual hashCode : ()I
/*     */     //   40: iadd
/*     */     //   41: istore_1
/*     */     //   42: goto -> 15
/*     */     //   45: iload_1
/*     */     //   46: ireturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #149	-> 0
/*     */     //   #150	-> 4
/*     */     //   #153	-> 6
/*     */     //   #154	-> 8
/*     */     //   #155	-> 31
/*     */     //   #156	-> 35
/*     */     //   #158	-> 42
/*     */     //   #159	-> 45
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
/*     */   public static <E> Set<E> newIdentityHashSet() {
/* 182 */     return Collections.newSetFromMap(new IdentityHashMap<E, Boolean>());
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
/*     */   public static <E> Set<E> synchronizedSet(Set<E> paramSet) {
/* 211 */     return Collections.synchronizedSet(paramSet);
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
/*     */   public static <E> Set<E> unmodifiableSet(Set<? extends E> paramSet) {
/* 225 */     return UnmodifiableSet.unmodifiableSet(paramSet);
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
/*     */   public static <E> Set<E> predicatedSet(Set<E> paramSet, Predicate<? super E> paramPredicate) {
/* 243 */     return (Set<E>)PredicatedSet.predicatedSet(paramSet, paramPredicate);
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
/*     */   public static <E> Set<E> transformedSet(Set<E> paramSet, Transformer<? super E, ? extends E> paramTransformer) {
/* 264 */     return (Set<E>)TransformedSet.transformingSet(paramSet, paramTransformer);
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
/*     */   public static <E> Set<E> orderedSet(Set<E> paramSet) {
/* 280 */     return (Set<E>)ListOrderedSet.listOrderedSet(paramSet);
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
/*     */   public static <E> SortedSet<E> synchronizedSortedSet(SortedSet<E> paramSortedSet) {
/* 309 */     return Collections.synchronizedSortedSet(paramSortedSet);
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
/*     */   public static <E> SortedSet<E> unmodifiableSortedSet(SortedSet<E> paramSortedSet) {
/* 323 */     return UnmodifiableSortedSet.unmodifiableSortedSet(paramSortedSet);
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
/*     */   public static <E> SortedSet<E> predicatedSortedSet(SortedSet<E> paramSortedSet, Predicate<? super E> paramPredicate) {
/* 342 */     return (SortedSet<E>)PredicatedSortedSet.predicatedSortedSet(paramSortedSet, paramPredicate);
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
/*     */   public static <E> SortedSet<E> transformedSortedSet(SortedSet<E> paramSortedSet, Transformer<? super E, ? extends E> paramTransformer) {
/* 363 */     return (SortedSet<E>)TransformedSortedSet.transformingSortedSet(paramSortedSet, paramTransformer);
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
/*     */   public static <E> SortedSet<E> unmodifiableNavigableSet(NavigableSet<E> paramNavigableSet) {
/* 380 */     return UnmodifiableNavigableSet.unmodifiableNavigableSet(paramNavigableSet);
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
/*     */   public static <E> SortedSet<E> predicatedNavigableSet(NavigableSet<E> paramNavigableSet, Predicate<? super E> paramPredicate) {
/* 400 */     return (SortedSet<E>)PredicatedNavigableSet.predicatedNavigableSet(paramNavigableSet, paramPredicate);
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
/*     */   public static <E> SortedSet<E> transformedNavigableSet(NavigableSet<E> paramNavigableSet, Transformer<? super E, ? extends E> paramTransformer) {
/* 422 */     return (SortedSet<E>)TransformedNavigableSet.transformingNavigableSet(paramNavigableSet, paramTransformer);
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
/*     */   public static <E> SetView<E> union(final Set<? extends E> a, final Set<? extends E> b) {
/* 442 */     if (a == null || b == null) {
/* 443 */       throw new NullPointerException("Sets must not be null.");
/*     */     }
/*     */     
/* 446 */     final SetView<E> bMinusA = difference(b, a);
/*     */     
/* 448 */     return new SetView<E>()
/*     */       {
/*     */         public boolean contains(Object param1Object) {
/* 451 */           return (a.contains(param1Object) || b.contains(param1Object));
/*     */         }
/*     */ 
/*     */         
/*     */         public Iterator<E> createIterator() {
/* 456 */           return IteratorUtils.chainedIterator(a.iterator(), bMinusA.iterator());
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isEmpty() {
/* 461 */           return (a.isEmpty() && b.isEmpty());
/*     */         }
/*     */ 
/*     */         
/*     */         public int size() {
/* 466 */           return a.size() + bMinusA.size();
/*     */         }
/*     */       };
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
/*     */   public static <E> SetView<E> difference(final Set<? extends E> a, final Set<? extends E> b) {
/* 486 */     if (a == null || b == null) {
/* 487 */       throw new NullPointerException("Sets must not be null.");
/*     */     }
/*     */     
/* 490 */     final Predicate<E> notContainedInB = new Predicate<E>()
/*     */       {
/*     */         public boolean evaluate(E param1E) {
/* 493 */           return !b.contains(param1E);
/*     */         }
/*     */       };
/*     */     
/* 497 */     return new SetView<E>()
/*     */       {
/*     */         public boolean contains(Object param1Object) {
/* 500 */           return (a.contains(param1Object) && !b.contains(param1Object));
/*     */         }
/*     */ 
/*     */         
/*     */         public Iterator<E> createIterator() {
/* 505 */           return IteratorUtils.filteredIterator(a.iterator(), notContainedInB);
/*     */         }
/*     */       };
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
/*     */   public static <E> SetView<E> intersection(final Set<? extends E> a, final Set<? extends E> b) {
/* 524 */     if (a == null || b == null) {
/* 525 */       throw new NullPointerException("Sets must not be null.");
/*     */     }
/*     */     
/* 528 */     final Predicate<E> containedInB = new Predicate<E>()
/*     */       {
/*     */         public boolean evaluate(E param1E) {
/* 531 */           return b.contains(param1E);
/*     */         }
/*     */       };
/*     */     
/* 535 */     return new SetView<E>()
/*     */       {
/*     */         public boolean contains(Object param1Object) {
/* 538 */           return (a.contains(param1Object) && b.contains(param1Object));
/*     */         }
/*     */ 
/*     */         
/*     */         public Iterator<E> createIterator() {
/* 543 */           return IteratorUtils.filteredIterator(a.iterator(), containedInB);
/*     */         }
/*     */       };
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
/*     */   public static <E> SetView<E> disjunction(final Set<? extends E> a, final Set<? extends E> b) {
/* 565 */     if (a == null || b == null) {
/* 566 */       throw new NullPointerException("Sets must not be null.");
/*     */     }
/*     */     
/* 569 */     final SetView<E> aMinusB = difference(a, b);
/* 570 */     final SetView<E> bMinusA = difference(b, a);
/*     */     
/* 572 */     return new SetView<E>()
/*     */       {
/*     */         public boolean contains(Object param1Object) {
/* 575 */           return a.contains(param1Object) ^ b.contains(param1Object);
/*     */         }
/*     */ 
/*     */         
/*     */         public Iterator<E> createIterator() {
/* 580 */           return IteratorUtils.chainedIterator(aMinusB.iterator(), bMinusA.iterator());
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isEmpty() {
/* 585 */           return (aMinusB.isEmpty() && bMinusA.isEmpty());
/*     */         }
/*     */ 
/*     */         
/*     */         public int size() {
/* 590 */           return aMinusB.size() + bMinusA.size();
/*     */         }
/*     */       };
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
/*     */   public static abstract class SetView<E>
/*     */     extends AbstractSet<E>
/*     */   {
/*     */     public Iterator<E> iterator() {
/* 609 */       return IteratorUtils.unmodifiableIterator(createIterator());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract Iterator<E> createIterator();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int size() {
/* 621 */       return IteratorUtils.size(iterator());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public <S extends Set<E>> void copyInto(S param1S) {
/* 631 */       CollectionUtils.addAll((Collection<?>)param1S, this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<E> toSet() {
/* 640 */       HashSet<E> hashSet = new HashSet(size());
/* 641 */       copyInto(hashSet);
/* 642 */       return hashSet;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\SetUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */