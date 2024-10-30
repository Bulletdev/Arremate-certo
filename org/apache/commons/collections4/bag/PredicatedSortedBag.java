/*     */ package org.apache.commons.collections4.bag;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import org.apache.commons.collections4.Bag;
/*     */ import org.apache.commons.collections4.Predicate;
/*     */ import org.apache.commons.collections4.SortedBag;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PredicatedSortedBag<E>
/*     */   extends PredicatedBag<E>
/*     */   implements SortedBag<E>
/*     */ {
/*     */   private static final long serialVersionUID = 3448581314086406616L;
/*     */   
/*     */   public static <E> PredicatedSortedBag<E> predicatedSortedBag(SortedBag<E> paramSortedBag, Predicate<? super E> paramPredicate) {
/*  63 */     return new PredicatedSortedBag<E>(paramSortedBag, paramPredicate);
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
/*     */   protected PredicatedSortedBag(SortedBag<E> paramSortedBag, Predicate<? super E> paramPredicate) {
/*  78 */     super((Bag<E>)paramSortedBag, paramPredicate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SortedBag<E> decorated() {
/*  88 */     return (SortedBag<E>)super.decorated();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E first() {
/*  95 */     return (E)decorated().first();
/*     */   }
/*     */ 
/*     */   
/*     */   public E last() {
/* 100 */     return (E)decorated().last();
/*     */   }
/*     */ 
/*     */   
/*     */   public Comparator<? super E> comparator() {
/* 105 */     return decorated().comparator();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\bag\PredicatedSortedBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */