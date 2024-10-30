/*     */ package org.apache.commons.collections4.set;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.NavigableSet;
/*     */ import org.apache.commons.collections4.Transformer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TransformedNavigableSet<E>
/*     */   extends TransformedSortedSet<E>
/*     */   implements NavigableSet<E>
/*     */ {
/*     */   private static final long serialVersionUID = 20150528L;
/*     */   
/*     */   public static <E> TransformedNavigableSet<E> transformingNavigableSet(NavigableSet<E> paramNavigableSet, Transformer<? super E, ? extends E> paramTransformer) {
/*  55 */     return new TransformedNavigableSet<E>(paramNavigableSet, paramTransformer);
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
/*     */   public static <E> TransformedNavigableSet<E> transformedNavigableSet(NavigableSet<E> paramNavigableSet, Transformer<? super E, ? extends E> paramTransformer) {
/*  75 */     TransformedNavigableSet<E> transformedNavigableSet = new TransformedNavigableSet<E>(paramNavigableSet, paramTransformer);
/*  76 */     if (paramNavigableSet.size() > 0) {
/*     */       
/*  78 */       Object[] arrayOfObject = paramNavigableSet.toArray();
/*  79 */       paramNavigableSet.clear();
/*  80 */       for (Object object : arrayOfObject) {
/*  81 */         transformedNavigableSet.decorated().add(paramTransformer.transform(object));
/*     */       }
/*     */     } 
/*  84 */     return transformedNavigableSet;
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
/*     */   protected TransformedNavigableSet(NavigableSet<E> paramNavigableSet, Transformer<? super E, ? extends E> paramTransformer) {
/* 100 */     super(paramNavigableSet, paramTransformer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected NavigableSet<E> decorated() {
/* 110 */     return (NavigableSet<E>)super.decorated();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E lower(E paramE) {
/* 117 */     return decorated().lower(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public E floor(E paramE) {
/* 122 */     return decorated().floor(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public E ceiling(E paramE) {
/* 127 */     return decorated().ceiling(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public E higher(E paramE) {
/* 132 */     return decorated().higher(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public E pollFirst() {
/* 137 */     return decorated().pollFirst();
/*     */   }
/*     */ 
/*     */   
/*     */   public E pollLast() {
/* 142 */     return decorated().pollLast();
/*     */   }
/*     */ 
/*     */   
/*     */   public NavigableSet<E> descendingSet() {
/* 147 */     return transformingNavigableSet(decorated().descendingSet(), this.transformer);
/*     */   }
/*     */ 
/*     */   
/*     */   public Iterator<E> descendingIterator() {
/* 152 */     return decorated().descendingIterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public NavigableSet<E> subSet(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2) {
/* 157 */     NavigableSet<E> navigableSet = decorated().subSet(paramE1, paramBoolean1, paramE2, paramBoolean2);
/* 158 */     return transformingNavigableSet(navigableSet, this.transformer);
/*     */   }
/*     */ 
/*     */   
/*     */   public NavigableSet<E> headSet(E paramE, boolean paramBoolean) {
/* 163 */     NavigableSet<E> navigableSet = decorated().headSet(paramE, paramBoolean);
/* 164 */     return transformingNavigableSet(navigableSet, this.transformer);
/*     */   }
/*     */ 
/*     */   
/*     */   public NavigableSet<E> tailSet(E paramE, boolean paramBoolean) {
/* 169 */     NavigableSet<E> navigableSet = decorated().tailSet(paramE, paramBoolean);
/* 170 */     return transformingNavigableSet(navigableSet, this.transformer);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\set\TransformedNavigableSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */