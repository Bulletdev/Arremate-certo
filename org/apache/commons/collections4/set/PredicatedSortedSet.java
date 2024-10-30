/*     */ package org.apache.commons.collections4.set;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.Set;
/*     */ import java.util.SortedSet;
/*     */ import org.apache.commons.collections4.Predicate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PredicatedSortedSet<E>
/*     */   extends PredicatedSet<E>
/*     */   implements SortedSet<E>
/*     */ {
/*     */   private static final long serialVersionUID = -9110948148132275052L;
/*     */   
/*     */   public static <E> PredicatedSortedSet<E> predicatedSortedSet(SortedSet<E> paramSortedSet, Predicate<? super E> paramPredicate) {
/*  65 */     return new PredicatedSortedSet<E>(paramSortedSet, paramPredicate);
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
/*     */   protected PredicatedSortedSet(SortedSet<E> paramSortedSet, Predicate<? super E> paramPredicate) {
/*  81 */     super(paramSortedSet, paramPredicate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SortedSet<E> decorated() {
/*  91 */     return (SortedSet<E>)super.decorated();
/*     */   }
/*     */ 
/*     */   
/*     */   public Comparator<? super E> comparator() {
/*  96 */     return decorated().comparator();
/*     */   }
/*     */   
/*     */   public E first() {
/* 100 */     return decorated().first();
/*     */   }
/*     */   
/*     */   public E last() {
/* 104 */     return decorated().last();
/*     */   }
/*     */   
/*     */   public SortedSet<E> subSet(E paramE1, E paramE2) {
/* 108 */     SortedSet<E> sortedSet = decorated().subSet(paramE1, paramE2);
/* 109 */     return new PredicatedSortedSet(sortedSet, this.predicate);
/*     */   }
/*     */   
/*     */   public SortedSet<E> headSet(E paramE) {
/* 113 */     SortedSet<E> sortedSet = decorated().headSet(paramE);
/* 114 */     return new PredicatedSortedSet(sortedSet, this.predicate);
/*     */   }
/*     */   
/*     */   public SortedSet<E> tailSet(E paramE) {
/* 118 */     SortedSet<E> sortedSet = decorated().tailSet(paramE);
/* 119 */     return new PredicatedSortedSet(sortedSet, this.predicate);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\set\PredicatedSortedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */