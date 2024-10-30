/*      */ package org.apache.commons.collections4;
/*      */ 
/*      */ import java.lang.reflect.Array;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.lang.reflect.Method;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Comparator;
/*      */ import java.util.Dictionary;
/*      */ import java.util.Enumeration;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.ListIterator;
/*      */ import java.util.Map;
/*      */ import org.apache.commons.collections4.functors.EqualPredicate;
/*      */ import org.apache.commons.collections4.iterators.ArrayIterator;
/*      */ import org.apache.commons.collections4.iterators.ArrayListIterator;
/*      */ import org.apache.commons.collections4.iterators.BoundedIterator;
/*      */ import org.apache.commons.collections4.iterators.CollatingIterator;
/*      */ import org.apache.commons.collections4.iterators.EmptyIterator;
/*      */ import org.apache.commons.collections4.iterators.EmptyListIterator;
/*      */ import org.apache.commons.collections4.iterators.EmptyMapIterator;
/*      */ import org.apache.commons.collections4.iterators.EmptyOrderedIterator;
/*      */ import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;
/*      */ import org.apache.commons.collections4.iterators.EnumerationIterator;
/*      */ import org.apache.commons.collections4.iterators.FilterIterator;
/*      */ import org.apache.commons.collections4.iterators.FilterListIterator;
/*      */ import org.apache.commons.collections4.iterators.IteratorChain;
/*      */ import org.apache.commons.collections4.iterators.IteratorEnumeration;
/*      */ import org.apache.commons.collections4.iterators.IteratorIterable;
/*      */ import org.apache.commons.collections4.iterators.ListIteratorWrapper;
/*      */ import org.apache.commons.collections4.iterators.LoopingIterator;
/*      */ import org.apache.commons.collections4.iterators.LoopingListIterator;
/*      */ import org.apache.commons.collections4.iterators.NodeListIterator;
/*      */ import org.apache.commons.collections4.iterators.ObjectArrayIterator;
/*      */ import org.apache.commons.collections4.iterators.ObjectArrayListIterator;
/*      */ import org.apache.commons.collections4.iterators.ObjectGraphIterator;
/*      */ import org.apache.commons.collections4.iterators.PeekingIterator;
/*      */ import org.apache.commons.collections4.iterators.PushbackIterator;
/*      */ import org.apache.commons.collections4.iterators.SingletonIterator;
/*      */ import org.apache.commons.collections4.iterators.SingletonListIterator;
/*      */ import org.apache.commons.collections4.iterators.SkippingIterator;
/*      */ import org.apache.commons.collections4.iterators.TransformIterator;
/*      */ import org.apache.commons.collections4.iterators.UnmodifiableIterator;
/*      */ import org.apache.commons.collections4.iterators.UnmodifiableListIterator;
/*      */ import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
/*      */ import org.apache.commons.collections4.iterators.ZippingIterator;
/*      */ import org.w3c.dom.Node;
/*      */ import org.w3c.dom.NodeList;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class IteratorUtils
/*      */ {
/*   83 */   public static final ResettableIterator EMPTY_ITERATOR = EmptyIterator.RESETTABLE_INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   89 */   public static final ResettableListIterator EMPTY_LIST_ITERATOR = EmptyListIterator.RESETTABLE_INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   95 */   public static final OrderedIterator EMPTY_ORDERED_ITERATOR = EmptyOrderedIterator.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  101 */   public static final MapIterator EMPTY_MAP_ITERATOR = EmptyMapIterator.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  107 */   public static final OrderedMapIterator EMPTY_ORDERED_MAP_ITERATOR = EmptyOrderedMapIterator.INSTANCE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final String DEFAULT_TOSTRING_PREFIX = "[";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final String DEFAULT_TOSTRING_SUFFIX = "]";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final String DEFAULT_TOSTRING_DELIMITER = ", ";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <E> ResettableIterator<E> emptyIterator() {
/*  141 */     return EmptyIterator.resettableEmptyIterator();
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
/*      */   public static <E> ResettableListIterator<E> emptyListIterator() {
/*  154 */     return EmptyListIterator.resettableEmptyListIterator();
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
/*      */   public static <E> OrderedIterator<E> emptyOrderedIterator() {
/*  167 */     return EmptyOrderedIterator.emptyOrderedIterator();
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
/*      */   public static <K, V> MapIterator<K, V> emptyMapIterator() {
/*  181 */     return EmptyMapIterator.emptyMapIterator();
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
/*      */   public static <K, V> OrderedMapIterator<K, V> emptyOrderedMapIterator() {
/*  195 */     return EmptyOrderedMapIterator.emptyOrderedMapIterator();
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
/*      */   public static <E> ResettableIterator<E> singletonIterator(E paramE) {
/*  211 */     return (ResettableIterator<E>)new SingletonIterator(paramE);
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
/*      */   public static <E> ListIterator<E> singletonListIterator(E paramE) {
/*  225 */     return (ListIterator<E>)new SingletonListIterator(paramE);
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
/*      */   public static <E> ResettableIterator<E> arrayIterator(E... paramVarArgs) {
/*  239 */     return (ResettableIterator<E>)new ObjectArrayIterator((Object[])paramVarArgs);
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
/*      */   public static <E> ResettableIterator<E> arrayIterator(Object paramObject) {
/*  255 */     return (ResettableIterator<E>)new ArrayIterator(paramObject);
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
/*      */   public static <E> ResettableIterator<E> arrayIterator(E[] paramArrayOfE, int paramInt) {
/*  270 */     return (ResettableIterator<E>)new ObjectArrayIterator((Object[])paramArrayOfE, paramInt);
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
/*      */   public static <E> ResettableIterator<E> arrayIterator(Object paramObject, int paramInt) {
/*  289 */     return (ResettableIterator<E>)new ArrayIterator(paramObject, paramInt);
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
/*      */   public static <E> ResettableIterator<E> arrayIterator(E[] paramArrayOfE, int paramInt1, int paramInt2) {
/*  305 */     return (ResettableIterator<E>)new ObjectArrayIterator((Object[])paramArrayOfE, paramInt1, paramInt2);
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
/*      */   public static <E> ResettableIterator<E> arrayIterator(Object paramObject, int paramInt1, int paramInt2) {
/*  324 */     return (ResettableIterator<E>)new ArrayIterator(paramObject, paramInt1, paramInt2);
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
/*      */   public static <E> ResettableListIterator<E> arrayListIterator(E... paramVarArgs) {
/*  337 */     return (ResettableListIterator<E>)new ObjectArrayListIterator((Object[])paramVarArgs);
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
/*      */   public static <E> ResettableListIterator<E> arrayListIterator(Object paramObject) {
/*  353 */     return (ResettableListIterator<E>)new ArrayListIterator(paramObject);
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
/*      */   public static <E> ResettableListIterator<E> arrayListIterator(E[] paramArrayOfE, int paramInt) {
/*  367 */     return (ResettableListIterator<E>)new ObjectArrayListIterator((Object[])paramArrayOfE, paramInt);
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
/*      */   public static <E> ResettableListIterator<E> arrayListIterator(Object paramObject, int paramInt) {
/*  385 */     return (ResettableListIterator<E>)new ArrayListIterator(paramObject, paramInt);
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
/*      */   public static <E> ResettableListIterator<E> arrayListIterator(E[] paramArrayOfE, int paramInt1, int paramInt2) {
/*  401 */     return (ResettableListIterator<E>)new ObjectArrayListIterator((Object[])paramArrayOfE, paramInt1, paramInt2);
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
/*      */   public static <E> ResettableListIterator<E> arrayListIterator(Object paramObject, int paramInt1, int paramInt2) {
/*  420 */     return (ResettableListIterator<E>)new ArrayListIterator(paramObject, paramInt1, paramInt2);
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
/*      */   public static <E> BoundedIterator<E> boundedIterator(Iterator<? extends E> paramIterator, long paramLong) {
/*  438 */     return boundedIterator(paramIterator, 0L, paramLong);
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
/*      */   public static <E> BoundedIterator<E> boundedIterator(Iterator<? extends E> paramIterator, long paramLong1, long paramLong2) {
/*  460 */     return new BoundedIterator(paramIterator, paramLong1, paramLong2);
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
/*      */   public static <E> Iterator<E> unmodifiableIterator(Iterator<E> paramIterator) {
/*  475 */     return UnmodifiableIterator.unmodifiableIterator(paramIterator);
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
/*      */   public static <E> ListIterator<E> unmodifiableListIterator(ListIterator<E> paramListIterator) {
/*  489 */     return UnmodifiableListIterator.umodifiableListIterator(paramListIterator);
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
/*      */   public static <K, V> MapIterator<K, V> unmodifiableMapIterator(MapIterator<K, V> paramMapIterator) {
/*  503 */     return UnmodifiableMapIterator.unmodifiableMapIterator(paramMapIterator);
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
/*      */   public static <E> Iterator<E> chainedIterator(Iterator<? extends E> paramIterator1, Iterator<? extends E> paramIterator2) {
/*  523 */     return (Iterator<E>)new IteratorChain(paramIterator1, paramIterator2);
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
/*      */   public static <E> Iterator<E> chainedIterator(Iterator<? extends E>... paramVarArgs) {
/*  536 */     return (Iterator<E>)new IteratorChain((Iterator[])paramVarArgs);
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
/*      */   public static <E> Iterator<E> chainedIterator(Collection<Iterator<? extends E>> paramCollection) {
/*  550 */     return (Iterator<E>)new IteratorChain(paramCollection);
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
/*      */   public static <E> Iterator<E> collatedIterator(Comparator<? super E> paramComparator, Iterator<? extends E> paramIterator1, Iterator<? extends E> paramIterator2) {
/*  576 */     Comparator comparator = (paramComparator == null) ? ComparatorUtils.NATURAL_COMPARATOR : paramComparator;
/*      */     
/*  578 */     return (Iterator<E>)new CollatingIterator(comparator, paramIterator1, paramIterator2);
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
/*      */   public static <E> Iterator<E> collatedIterator(Comparator<? super E> paramComparator, Iterator<? extends E>... paramVarArgs) {
/*  600 */     Comparator comparator = (paramComparator == null) ? ComparatorUtils.NATURAL_COMPARATOR : paramComparator;
/*      */     
/*  602 */     return (Iterator<E>)new CollatingIterator(comparator, (Iterator[])paramVarArgs);
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
/*      */   public static <E> Iterator<E> collatedIterator(Comparator<? super E> paramComparator, Collection<Iterator<? extends E>> paramCollection) {
/*  625 */     Comparator comparator = (paramComparator == null) ? ComparatorUtils.NATURAL_COMPARATOR : paramComparator;
/*      */     
/*  627 */     return (Iterator<E>)new CollatingIterator(comparator, paramCollection);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <E> Iterator<E> objectGraphIterator(E paramE, Transformer<? super E, ? extends E> paramTransformer) {
/*  688 */     return (Iterator<E>)new ObjectGraphIterator(paramE, paramTransformer);
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
/*      */   public static <I, O> Iterator<O> transformedIterator(Iterator<? extends I> paramIterator, Transformer<? super I, ? extends O> paramTransformer) {
/*  709 */     if (paramIterator == null) {
/*  710 */       throw new NullPointerException("Iterator must not be null");
/*      */     }
/*  712 */     if (paramTransformer == null) {
/*  713 */       throw new NullPointerException("Transformer must not be null");
/*      */     }
/*  715 */     return (Iterator<O>)new TransformIterator(paramIterator, paramTransformer);
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
/*      */   public static <E> Iterator<E> filteredIterator(Iterator<? extends E> paramIterator, Predicate<? super E> paramPredicate) {
/*  734 */     if (paramIterator == null) {
/*  735 */       throw new NullPointerException("Iterator must not be null");
/*      */     }
/*  737 */     if (paramPredicate == null) {
/*  738 */       throw new NullPointerException("Predicate must not be null");
/*      */     }
/*  740 */     return (Iterator<E>)new FilterIterator(paramIterator, paramPredicate);
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
/*      */   public static <E> ListIterator<E> filteredListIterator(ListIterator<? extends E> paramListIterator, Predicate<? super E> paramPredicate) {
/*  758 */     if (paramListIterator == null) {
/*  759 */       throw new NullPointerException("ListIterator must not be null");
/*      */     }
/*  761 */     if (paramPredicate == null) {
/*  762 */       throw new NullPointerException("Predicate must not be null");
/*      */     }
/*  764 */     return (ListIterator<E>)new FilterListIterator(paramListIterator, paramPredicate);
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
/*      */   public static <E> ResettableIterator<E> loopingIterator(Collection<? extends E> paramCollection) {
/*  782 */     if (paramCollection == null) {
/*  783 */       throw new NullPointerException("Collection must not be null");
/*      */     }
/*  785 */     return (ResettableIterator<E>)new LoopingIterator(paramCollection);
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
/*      */   public static <E> ResettableListIterator<E> loopingListIterator(List<E> paramList) {
/*  801 */     if (paramList == null) {
/*  802 */       throw new NullPointerException("List must not be null");
/*      */     }
/*  804 */     return (ResettableListIterator<E>)new LoopingListIterator(paramList);
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
/*      */   public static NodeListIterator nodeListIterator(NodeList paramNodeList) {
/*  819 */     if (paramNodeList == null) {
/*  820 */       throw new NullPointerException("NodeList must not be null");
/*      */     }
/*  822 */     return new NodeListIterator(paramNodeList);
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
/*      */   public static NodeListIterator nodeListIterator(Node paramNode) {
/*  843 */     if (paramNode == null) {
/*  844 */       throw new NullPointerException("Node must not be null");
/*      */     }
/*  846 */     return new NodeListIterator(paramNode);
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
/*      */   public static <E> Iterator<E> peekingIterator(Iterator<? extends E> paramIterator) {
/*  862 */     return (Iterator<E>)PeekingIterator.peekingIterator(paramIterator);
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
/*      */   public static <E> Iterator<E> pushbackIterator(Iterator<? extends E> paramIterator) {
/*  878 */     return (Iterator<E>)PushbackIterator.pushbackIterator(paramIterator);
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
/*      */   public static <E> SkippingIterator<E> skippingIterator(Iterator<E> paramIterator, long paramLong) {
/*  895 */     return new SkippingIterator(paramIterator, paramLong);
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
/*      */   public static <E> ZippingIterator<E> zippingIterator(Iterator<? extends E> paramIterator1, Iterator<? extends E> paramIterator2) {
/*  912 */     return new ZippingIterator(paramIterator1, paramIterator2);
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
/*      */   public static <E> ZippingIterator<E> zippingIterator(Iterator<? extends E> paramIterator1, Iterator<? extends E> paramIterator2, Iterator<? extends E> paramIterator3) {
/*  929 */     return new ZippingIterator(paramIterator1, paramIterator2, paramIterator3);
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
/*      */   public static <E> ZippingIterator<E> zippingIterator(Iterator<? extends E>... paramVarArgs) {
/*  942 */     return new ZippingIterator((Iterator[])paramVarArgs);
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
/*      */   public static <E> Iterator<E> asIterator(Enumeration<? extends E> paramEnumeration) {
/*  956 */     if (paramEnumeration == null) {
/*  957 */       throw new NullPointerException("Enumeration must not be null");
/*      */     }
/*  959 */     return (Iterator<E>)new EnumerationIterator(paramEnumeration);
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
/*      */   public static <E> Iterator<E> asIterator(Enumeration<? extends E> paramEnumeration, Collection<? super E> paramCollection) {
/*  974 */     if (paramEnumeration == null) {
/*  975 */       throw new NullPointerException("Enumeration must not be null");
/*      */     }
/*  977 */     if (paramCollection == null) {
/*  978 */       throw new NullPointerException("Collection must not be null");
/*      */     }
/*  980 */     return (Iterator<E>)new EnumerationIterator(paramEnumeration, paramCollection);
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
/*      */   public static <E> Enumeration<E> asEnumeration(Iterator<? extends E> paramIterator) {
/*  992 */     if (paramIterator == null) {
/*  993 */       throw new NullPointerException("Iterator must not be null");
/*      */     }
/*  995 */     return (Enumeration<E>)new IteratorEnumeration(paramIterator);
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
/*      */   public static <E> Iterable<E> asIterable(Iterator<? extends E> paramIterator) {
/* 1008 */     if (paramIterator == null) {
/* 1009 */       throw new NullPointerException("Iterator must not be null");
/*      */     }
/* 1011 */     return (Iterable<E>)new IteratorIterable(paramIterator, false);
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
/*      */   public static <E> Iterable<E> asMultipleUseIterable(Iterator<? extends E> paramIterator) {
/* 1024 */     if (paramIterator == null) {
/* 1025 */       throw new NullPointerException("Iterator must not be null");
/*      */     }
/* 1027 */     return (Iterable<E>)new IteratorIterable(paramIterator, true);
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
/*      */   public static <E> ListIterator<E> toListIterator(Iterator<? extends E> paramIterator) {
/* 1042 */     if (paramIterator == null) {
/* 1043 */       throw new NullPointerException("Iterator must not be null");
/*      */     }
/* 1045 */     return (ListIterator<E>)new ListIteratorWrapper(paramIterator);
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
/*      */   public static Object[] toArray(Iterator<?> paramIterator) {
/* 1059 */     if (paramIterator == null) {
/* 1060 */       throw new NullPointerException("Iterator must not be null");
/*      */     }
/* 1062 */     List<?> list = toList(paramIterator, 100);
/* 1063 */     return list.toArray();
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
/*      */   public static <E> E[] toArray(Iterator<? extends E> paramIterator, Class<E> paramClass) {
/* 1080 */     if (paramIterator == null) {
/* 1081 */       throw new NullPointerException("Iterator must not be null");
/*      */     }
/* 1083 */     if (paramClass == null) {
/* 1084 */       throw new NullPointerException("Array class must not be null");
/*      */     }
/* 1086 */     List<E> list = toList(paramIterator, 100);
/*      */     
/* 1088 */     Object[] arrayOfObject = (Object[])Array.newInstance(paramClass, list.size());
/* 1089 */     return list.toArray((E[])arrayOfObject);
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
/*      */   public static <E> List<E> toList(Iterator<? extends E> paramIterator) {
/* 1104 */     return toList(paramIterator, 10);
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
/*      */   public static <E> List<E> toList(Iterator<? extends E> paramIterator, int paramInt) {
/* 1121 */     if (paramIterator == null) {
/* 1122 */       throw new NullPointerException("Iterator must not be null");
/*      */     }
/* 1124 */     if (paramInt < 1) {
/* 1125 */       throw new IllegalArgumentException("Estimated size must be greater than 0");
/*      */     }
/* 1127 */     ArrayList<E> arrayList = new ArrayList(paramInt);
/* 1128 */     while (paramIterator.hasNext()) {
/* 1129 */       arrayList.add(paramIterator.next());
/*      */     }
/* 1131 */     return arrayList;
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
/*      */   public static Iterator<?> getIterator(Object paramObject) {
/* 1156 */     if (paramObject == null) {
/* 1157 */       return emptyIterator();
/*      */     }
/* 1159 */     if (paramObject instanceof Iterator) {
/* 1160 */       return (Iterator)paramObject;
/*      */     }
/* 1162 */     if (paramObject instanceof Iterable) {
/* 1163 */       return ((Iterable)paramObject).iterator();
/*      */     }
/* 1165 */     if (paramObject instanceof Object[]) {
/* 1166 */       return (Iterator<?>)new ObjectArrayIterator((Object[])paramObject);
/*      */     }
/* 1168 */     if (paramObject instanceof Enumeration) {
/* 1169 */       return (Iterator<?>)new EnumerationIterator((Enumeration)paramObject);
/*      */     }
/* 1171 */     if (paramObject instanceof Map) {
/* 1172 */       return ((Map)paramObject).values().iterator();
/*      */     }
/* 1174 */     if (paramObject instanceof NodeList) {
/* 1175 */       return (Iterator<?>)new NodeListIterator((NodeList)paramObject);
/*      */     }
/* 1177 */     if (paramObject instanceof Node) {
/* 1178 */       return (Iterator<?>)new NodeListIterator((Node)paramObject);
/*      */     }
/* 1180 */     if (paramObject instanceof Dictionary)
/* 1181 */       return (Iterator<?>)new EnumerationIterator(((Dictionary)paramObject).elements()); 
/* 1182 */     if (paramObject.getClass().isArray()) {
/* 1183 */       return (Iterator<?>)new ArrayIterator(paramObject);
/*      */     }
/*      */     try {
/* 1186 */       Method method = paramObject.getClass().getMethod("iterator", (Class[])null);
/* 1187 */       if (Iterator.class.isAssignableFrom(method.getReturnType())) {
/* 1188 */         Iterator<?> iterator = (Iterator)method.invoke(paramObject, (Object[])null);
/* 1189 */         if (iterator != null) {
/* 1190 */           return iterator;
/*      */         }
/*      */       } 
/* 1193 */     } catch (RuntimeException runtimeException) {
/*      */     
/* 1195 */     } catch (NoSuchMethodException noSuchMethodException) {
/*      */     
/* 1197 */     } catch (IllegalAccessException illegalAccessException) {
/*      */     
/* 1199 */     } catch (InvocationTargetException invocationTargetException) {}
/*      */ 
/*      */     
/* 1202 */     return singletonIterator(paramObject);
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
/*      */   public static <E> void forEach(Iterator<E> paramIterator, Closure<? super E> paramClosure) {
/* 1218 */     if (paramClosure == null) {
/* 1219 */       throw new NullPointerException("Closure must not be null");
/*      */     }
/*      */     
/* 1222 */     if (paramIterator != null) {
/* 1223 */       while (paramIterator.hasNext()) {
/* 1224 */         E e = paramIterator.next();
/* 1225 */         paramClosure.execute(e);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <E> E forEachButLast(Iterator<E> paramIterator, Closure<? super E> paramClosure) {
/* 1243 */     if (paramClosure == null) {
/* 1244 */       throw new NullPointerException("Closure must not be null.");
/*      */     }
/* 1246 */     if (paramIterator != null) {
/* 1247 */       while (paramIterator.hasNext()) {
/* 1248 */         E e = paramIterator.next();
/* 1249 */         if (paramIterator.hasNext()) {
/* 1250 */           paramClosure.execute(e); continue;
/*      */         } 
/* 1252 */         return e;
/*      */       } 
/*      */     }
/*      */     
/* 1256 */     return null;
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
/*      */   public static <E> E find(Iterator<E> paramIterator, Predicate<? super E> paramPredicate) {
/* 1272 */     if (paramPredicate == null) {
/* 1273 */       throw new NullPointerException("Predicate must not be null");
/*      */     }
/*      */     
/* 1276 */     if (paramIterator != null) {
/* 1277 */       while (paramIterator.hasNext()) {
/* 1278 */         E e = paramIterator.next();
/* 1279 */         if (paramPredicate.evaluate(e)) {
/* 1280 */           return e;
/*      */         }
/*      */       } 
/*      */     }
/* 1284 */     return null;
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
/*      */   public static <E> int indexOf(Iterator<E> paramIterator, Predicate<? super E> paramPredicate) {
/* 1301 */     if (paramPredicate == null) {
/* 1302 */       throw new NullPointerException("Predicate must not be null");
/*      */     }
/*      */     
/* 1305 */     if (paramIterator != null) {
/* 1306 */       for (byte b = 0; paramIterator.hasNext(); b++) {
/* 1307 */         E e = paramIterator.next();
/* 1308 */         if (paramPredicate.evaluate(e)) {
/* 1309 */           return b;
/*      */         }
/*      */       } 
/*      */     }
/* 1313 */     return -1;
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
/*      */   public static <E> boolean matchesAny(Iterator<E> paramIterator, Predicate<? super E> paramPredicate) {
/* 1329 */     return (indexOf(paramIterator, paramPredicate) != -1);
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
/*      */   public static <E> boolean matchesAll(Iterator<E> paramIterator, Predicate<? super E> paramPredicate) {
/* 1346 */     if (paramPredicate == null) {
/* 1347 */       throw new NullPointerException("Predicate must not be null");
/*      */     }
/*      */     
/* 1350 */     if (paramIterator != null) {
/* 1351 */       while (paramIterator.hasNext()) {
/* 1352 */         E e = paramIterator.next();
/* 1353 */         if (!paramPredicate.evaluate(e)) {
/* 1354 */           return false;
/*      */         }
/*      */       } 
/*      */     }
/* 1358 */     return true;
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
/*      */   public static boolean isEmpty(Iterator<?> paramIterator) {
/* 1371 */     return (paramIterator == null || !paramIterator.hasNext());
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
/*      */   public static <E> boolean contains(Iterator<E> paramIterator, Object paramObject) {
/* 1386 */     return matchesAny(paramIterator, EqualPredicate.equalPredicate(paramObject));
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
/*      */   public static <E> E get(Iterator<E> paramIterator, int paramInt) {
/* 1404 */     int i = paramInt;
/* 1405 */     CollectionUtils.checkIndexBounds(i);
/* 1406 */     while (paramIterator.hasNext()) {
/* 1407 */       i--;
/* 1408 */       if (i == -1) {
/* 1409 */         return paramIterator.next();
/*      */       }
/* 1411 */       paramIterator.next();
/*      */     } 
/* 1413 */     throw new IndexOutOfBoundsException("Entry does not exist: " + i);
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
/*      */   public static int size(Iterator<?> paramIterator) {
/* 1426 */     byte b = 0;
/* 1427 */     if (paramIterator != null) {
/* 1428 */       while (paramIterator.hasNext()) {
/* 1429 */         paramIterator.next();
/* 1430 */         b++;
/*      */       } 
/*      */     }
/* 1433 */     return b;
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
/*      */   public static <E> String toString(Iterator<E> paramIterator) {
/* 1450 */     return toString(paramIterator, TransformerUtils.stringValueTransformer(), ", ", "[", "]");
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
/*      */   public static <E> String toString(Iterator<E> paramIterator, Transformer<? super E, String> paramTransformer) {
/* 1472 */     return toString(paramIterator, paramTransformer, ", ", "[", "]");
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
/*      */   public static <E> String toString(Iterator<E> paramIterator, Transformer<? super E, String> paramTransformer, String paramString1, String paramString2, String paramString3) {
/* 1499 */     if (paramTransformer == null) {
/* 1500 */       throw new NullPointerException("transformer may not be null");
/*      */     }
/* 1502 */     if (paramString1 == null) {
/* 1503 */       throw new NullPointerException("delimiter may not be null");
/*      */     }
/* 1505 */     if (paramString2 == null) {
/* 1506 */       throw new NullPointerException("prefix may not be null");
/*      */     }
/* 1508 */     if (paramString3 == null) {
/* 1509 */       throw new NullPointerException("suffix may not be null");
/*      */     }
/* 1511 */     StringBuilder stringBuilder = new StringBuilder(paramString2);
/* 1512 */     if (paramIterator != null) {
/* 1513 */       while (paramIterator.hasNext()) {
/* 1514 */         E e = paramIterator.next();
/* 1515 */         stringBuilder.append(paramTransformer.transform(e));
/* 1516 */         stringBuilder.append(paramString1);
/*      */       } 
/* 1518 */       if (stringBuilder.length() > paramString2.length()) {
/* 1519 */         stringBuilder.setLength(stringBuilder.length() - paramString1.length());
/*      */       }
/*      */     } 
/* 1522 */     stringBuilder.append(paramString3);
/* 1523 */     return stringBuilder.toString();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\IteratorUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */