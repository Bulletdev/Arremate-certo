/*     */ package org.apache.commons.collections4.set;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.NavigableSet;
/*     */ import java.util.Set;
/*     */ import java.util.SortedSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractNavigableSetDecorator<E>
/*     */   extends AbstractSortedSetDecorator<E>
/*     */   implements NavigableSet<E>
/*     */ {
/*     */   private static final long serialVersionUID = 20150528L;
/*     */   
/*     */   protected AbstractNavigableSetDecorator() {}
/*     */   
/*     */   protected AbstractNavigableSetDecorator(NavigableSet<E> paramNavigableSet) {
/*  52 */     super(paramNavigableSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected NavigableSet<E> decorated() {
/*  62 */     return (NavigableSet<E>)super.decorated();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E lower(E paramE) {
/*  69 */     return decorated().lower(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public E floor(E paramE) {
/*  74 */     return decorated().floor(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public E ceiling(E paramE) {
/*  79 */     return decorated().ceiling(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public E higher(E paramE) {
/*  84 */     return decorated().higher(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public E pollFirst() {
/*  89 */     return decorated().pollFirst();
/*     */   }
/*     */ 
/*     */   
/*     */   public E pollLast() {
/*  94 */     return decorated().pollLast();
/*     */   }
/*     */ 
/*     */   
/*     */   public NavigableSet<E> descendingSet() {
/*  99 */     return decorated().descendingSet();
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<E> descendingIterator() {
/* 104 */     return decorated().descendingIterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public NavigableSet<E> subSet(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2) {
/* 109 */     return decorated().subSet(paramE1, paramBoolean1, paramE2, paramBoolean2);
/*     */   }
/*     */ 
/*     */   
/*     */   public NavigableSet<E> headSet(E paramE, boolean paramBoolean) {
/* 114 */     return decorated().headSet(paramE, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public NavigableSet<E> tailSet(E paramE, boolean paramBoolean) {
/* 119 */     return decorated().tailSet(paramE, paramBoolean);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\set\AbstractNavigableSetDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */