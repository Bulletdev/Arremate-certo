/*     */ package org.apache.commons.collections4;
/*     */ 
/*     */ import org.apache.commons.collections4.bag.CollectionBag;
/*     */ import org.apache.commons.collections4.bag.HashBag;
/*     */ import org.apache.commons.collections4.bag.PredicatedBag;
/*     */ import org.apache.commons.collections4.bag.PredicatedSortedBag;
/*     */ import org.apache.commons.collections4.bag.SynchronizedBag;
/*     */ import org.apache.commons.collections4.bag.SynchronizedSortedBag;
/*     */ import org.apache.commons.collections4.bag.TransformedBag;
/*     */ import org.apache.commons.collections4.bag.TransformedSortedBag;
/*     */ import org.apache.commons.collections4.bag.TreeBag;
/*     */ import org.apache.commons.collections4.bag.UnmodifiableBag;
/*     */ import org.apache.commons.collections4.bag.UnmodifiableSortedBag;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BagUtils
/*     */ {
/*  43 */   public static final Bag EMPTY_BAG = UnmodifiableBag.unmodifiableBag((Bag)new HashBag());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   public static final Bag EMPTY_SORTED_BAG = UnmodifiableSortedBag.unmodifiableSortedBag((SortedBag)new TreeBag());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> Bag<E> synchronizedBag(Bag<E> paramBag) {
/*  85 */     return (Bag<E>)SynchronizedBag.synchronizedBag(paramBag);
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
/*     */   public static <E> Bag<E> unmodifiableBag(Bag<? extends E> paramBag) {
/*  98 */     return UnmodifiableBag.unmodifiableBag(paramBag);
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
/*     */   public static <E> Bag<E> predicatedBag(Bag<E> paramBag, Predicate<? super E> paramPredicate) {
/* 117 */     return (Bag<E>)PredicatedBag.predicatedBag(paramBag, paramPredicate);
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
/*     */   public static <E> Bag<E> transformingBag(Bag<E> paramBag, Transformer<? super E, ? extends E> paramTransformer) {
/* 137 */     return TransformedBag.transformingBag(paramBag, paramTransformer);
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
/*     */   public static <E> Bag<E> collectionBag(Bag<E> paramBag) {
/* 150 */     return CollectionBag.collectionBag(paramBag);
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
/*     */   public static <E> SortedBag<E> synchronizedSortedBag(SortedBag<E> paramSortedBag) {
/* 181 */     return (SortedBag<E>)SynchronizedSortedBag.synchronizedSortedBag(paramSortedBag);
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
/*     */   public static <E> SortedBag<E> unmodifiableSortedBag(SortedBag<E> paramSortedBag) {
/* 195 */     return UnmodifiableSortedBag.unmodifiableSortedBag(paramSortedBag);
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
/*     */   public static <E> SortedBag<E> predicatedSortedBag(SortedBag<E> paramSortedBag, Predicate<? super E> paramPredicate) {
/* 216 */     return (SortedBag<E>)PredicatedSortedBag.predicatedSortedBag(paramSortedBag, paramPredicate);
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
/*     */   public static <E> SortedBag<E> transformingSortedBag(SortedBag<E> paramSortedBag, Transformer<? super E, ? extends E> paramTransformer) {
/* 238 */     return (SortedBag<E>)TransformedSortedBag.transformingSortedBag(paramSortedBag, paramTransformer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> Bag<E> emptyBag() {
/* 249 */     return EMPTY_BAG;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> SortedBag<E> emptySortedBag() {
/* 260 */     return (SortedBag<E>)EMPTY_SORTED_BAG;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\BagUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */