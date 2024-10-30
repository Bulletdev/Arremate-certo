/*     */ package org.apache.commons.collections4.set;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.NavigableSet;
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
/*     */ public class PredicatedNavigableSet<E>
/*     */   extends PredicatedSortedSet<E>
/*     */   implements NavigableSet<E>
/*     */ {
/*     */   private static final long serialVersionUID = 20150528L;
/*     */   
/*     */   public static <E> PredicatedNavigableSet<E> predicatedNavigableSet(NavigableSet<E> paramNavigableSet, Predicate<? super E> paramPredicate) {
/*  63 */     return new PredicatedNavigableSet<E>(paramNavigableSet, paramPredicate);
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
/*     */   protected PredicatedNavigableSet(NavigableSet<E> paramNavigableSet, Predicate<? super E> paramPredicate) {
/*  79 */     super(paramNavigableSet, paramPredicate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected NavigableSet<E> decorated() {
/*  89 */     return (NavigableSet<E>)super.decorated();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E lower(E paramE) {
/*  96 */     return decorated().lower(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public E floor(E paramE) {
/* 101 */     return decorated().floor(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public E ceiling(E paramE) {
/* 106 */     return decorated().ceiling(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public E higher(E paramE) {
/* 111 */     return decorated().higher(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public E pollFirst() {
/* 116 */     return decorated().pollFirst();
/*     */   }
/*     */ 
/*     */   
/*     */   public E pollLast() {
/* 121 */     return decorated().pollLast();
/*     */   }
/*     */ 
/*     */   
/*     */   public NavigableSet<E> descendingSet() {
/* 126 */     return predicatedNavigableSet(decorated().descendingSet(), this.predicate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<E> descendingIterator() {
/* 131 */     return decorated().descendingIterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public NavigableSet<E> subSet(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2) {
/* 136 */     NavigableSet<E> navigableSet = decorated().subSet(paramE1, paramBoolean1, paramE2, paramBoolean2);
/* 137 */     return predicatedNavigableSet(navigableSet, this.predicate);
/*     */   }
/*     */ 
/*     */   
/*     */   public NavigableSet<E> headSet(E paramE, boolean paramBoolean) {
/* 142 */     NavigableSet<E> navigableSet = decorated().headSet(paramE, paramBoolean);
/* 143 */     return predicatedNavigableSet(navigableSet, this.predicate);
/*     */   }
/*     */ 
/*     */   
/*     */   public NavigableSet<E> tailSet(E paramE, boolean paramBoolean) {
/* 148 */     NavigableSet<E> navigableSet = decorated().tailSet(paramE, paramBoolean);
/* 149 */     return predicatedNavigableSet(navigableSet, this.predicate);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\set\PredicatedNavigableSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */