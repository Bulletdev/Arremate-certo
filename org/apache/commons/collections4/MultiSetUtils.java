/*     */ package org.apache.commons.collections4;
/*     */ 
/*     */ import org.apache.commons.collections4.multiset.HashMultiSet;
/*     */ import org.apache.commons.collections4.multiset.PredicatedMultiSet;
/*     */ import org.apache.commons.collections4.multiset.SynchronizedMultiSet;
/*     */ import org.apache.commons.collections4.multiset.UnmodifiableMultiSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MultiSetUtils
/*     */ {
/*  36 */   public static final MultiSet EMPTY_MULTISET = UnmodifiableMultiSet.unmodifiableMultiSet((MultiSet)new HashMultiSet());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> MultiSet<E> synchronizedMultiSet(MultiSet<E> paramMultiSet) {
/*  72 */     return (MultiSet<E>)SynchronizedMultiSet.synchronizedMultiSet(paramMultiSet);
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
/*     */   public static <E> MultiSet<E> unmodifiableMultiSet(MultiSet<? extends E> paramMultiSet) {
/*  85 */     return UnmodifiableMultiSet.unmodifiableMultiSet(paramMultiSet);
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
/*     */   public static <E> MultiSet<E> predicatedMultiSet(MultiSet<E> paramMultiSet, Predicate<? super E> paramPredicate) {
/* 105 */     return (MultiSet<E>)PredicatedMultiSet.predicatedMultiSet(paramMultiSet, paramPredicate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> MultiSet<E> emptyMultiSet() {
/* 116 */     return EMPTY_MULTISET;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\MultiSetUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */