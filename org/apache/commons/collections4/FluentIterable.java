/*     */ package org.apache.commons.collections4;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.commons.collections4.iterators.SingletonIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FluentIterable<E>
/*     */   implements Iterable<E>
/*     */ {
/*     */   private final Iterable<E> iterable;
/*     */   
/*     */   public static <T> FluentIterable<T> empty() {
/*  82 */     return IterableUtils.EMPTY_ITERABLE;
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
/*     */   public static <T> FluentIterable<T> of(T paramT) {
/*  95 */     return of(IteratorUtils.asIterable((Iterator<? extends T>)new SingletonIterator(paramT, false)));
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
/*     */   public static <T> FluentIterable<T> of(T... paramVarArgs) {
/* 108 */     return of(Arrays.asList(paramVarArgs));
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
/*     */   public static <T> FluentIterable<T> of(Iterable<T> paramIterable) {
/* 125 */     IterableUtils.checkNotNull(paramIterable);
/* 126 */     if (paramIterable instanceof FluentIterable) {
/* 127 */       return (FluentIterable<T>)paramIterable;
/*     */     }
/* 129 */     return new FluentIterable<T>(paramIterable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FluentIterable() {
/* 140 */     this.iterable = this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FluentIterable(Iterable<E> paramIterable) {
/* 148 */     this.iterable = paramIterable;
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
/*     */   public FluentIterable<E> append(E... paramVarArgs) {
/* 163 */     return append(Arrays.asList(paramVarArgs));
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
/*     */   public FluentIterable<E> append(Iterable<? extends E> paramIterable) {
/* 176 */     return of(IterableUtils.chainedIterable(this.iterable, paramIterable));
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
/*     */   public FluentIterable<E> collate(Iterable<? extends E> paramIterable) {
/* 198 */     return of(IterableUtils.collatedIterable(this.iterable, paramIterable));
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
/*     */   public FluentIterable<E> collate(Iterable<? extends E> paramIterable, Comparator<? super E> paramComparator) {
/* 224 */     return of(IterableUtils.collatedIterable(paramComparator, this.iterable, paramIterable));
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
/*     */   public FluentIterable<E> eval() {
/* 241 */     return of(toList());
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
/*     */   public FluentIterable<E> filter(Predicate<? super E> paramPredicate) {
/* 253 */     return of(IterableUtils.filteredIterable(this.iterable, paramPredicate));
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
/*     */   public FluentIterable<E> limit(long paramLong) {
/* 265 */     return of(IterableUtils.boundedIterable(this.iterable, paramLong));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FluentIterable<E> loop() {
/* 275 */     return of(IterableUtils.loopingIterable(this.iterable));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FluentIterable<E> reverse() {
/* 285 */     return of(IterableUtils.reversedIterable(this.iterable));
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
/*     */   public FluentIterable<E> skip(long paramLong) {
/* 298 */     return of(IterableUtils.skippingIterable(this.iterable, paramLong));
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
/*     */   public <O> FluentIterable<O> transform(Transformer<? super E, ? extends O> paramTransformer) {
/* 311 */     return of(IterableUtils.transformedIterable(this.iterable, paramTransformer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FluentIterable<E> unique() {
/* 321 */     return of(IterableUtils.uniqueIterable(this.iterable));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FluentIterable<E> unmodifiable() {
/* 331 */     return of(IterableUtils.unmodifiableIterable(this.iterable));
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
/*     */   public FluentIterable<E> zip(Iterable<? extends E> paramIterable) {
/* 344 */     return of(IterableUtils.zippingIterable(this.iterable, paramIterable));
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
/*     */   public FluentIterable<E> zip(Iterable<? extends E>... paramVarArgs) {
/* 357 */     return of(IterableUtils.zippingIterable(this.iterable, paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<E> iterator() {
/* 366 */     return this.iterable.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Enumeration<E> asEnumeration() {
/* 376 */     return IteratorUtils.asEnumeration(iterator());
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
/*     */   public boolean allMatch(Predicate<? super E> paramPredicate) {
/* 391 */     return IterableUtils.matchesAll(this.iterable, paramPredicate);
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
/*     */   public boolean anyMatch(Predicate<? super E> paramPredicate) {
/* 405 */     return IterableUtils.matchesAny(this.iterable, paramPredicate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 414 */     return IterableUtils.isEmpty(this.iterable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject) {
/* 424 */     return IterableUtils.contains(this.iterable, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void forEach(Closure<? super E> paramClosure) {
/* 434 */     IterableUtils.forEach(this.iterable, paramClosure);
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
/*     */   public E get(int paramInt) {
/* 448 */     return IterableUtils.get(this.iterable, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 458 */     return IterableUtils.size(this.iterable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void copyInto(Collection<? super E> paramCollection) {
/* 469 */     if (paramCollection == null) {
/* 470 */       throw new NullPointerException("Collection must not be null");
/*     */     }
/* 472 */     CollectionUtils.addAll(paramCollection, this.iterable);
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
/*     */   public E[] toArray(Class<E> paramClass) {
/* 484 */     return IteratorUtils.toArray(iterator(), paramClass);
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
/*     */   public List<E> toList() {
/* 496 */     return IterableUtils.toList(this.iterable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 502 */     return IterableUtils.toString(this.iterable);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\FluentIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */