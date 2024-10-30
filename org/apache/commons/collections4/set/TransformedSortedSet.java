/*     */ package org.apache.commons.collections4.set;
/*     */ 
/*     */ import java.util.Comparator;
/*     */ import java.util.SortedSet;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TransformedSortedSet<E>
/*     */   extends TransformedSet<E>
/*     */   implements SortedSet<E>
/*     */ {
/*     */   private static final long serialVersionUID = -1675486811351124386L;
/*     */   
/*     */   public static <E> TransformedSortedSet<E> transformingSortedSet(SortedSet<E> paramSortedSet, Transformer<? super E, ? extends E> paramTransformer) {
/*  58 */     return new TransformedSortedSet<E>(paramSortedSet, paramTransformer);
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
/*     */   public static <E> TransformedSortedSet<E> transformedSortedSet(SortedSet<E> paramSortedSet, Transformer<? super E, ? extends E> paramTransformer) {
/*  79 */     TransformedSortedSet<E> transformedSortedSet = new TransformedSortedSet<E>(paramSortedSet, paramTransformer);
/*  80 */     if (paramSortedSet.size() > 0) {
/*     */       
/*  82 */       Object[] arrayOfObject = paramSortedSet.toArray();
/*  83 */       paramSortedSet.clear();
/*  84 */       for (Object object : arrayOfObject) {
/*  85 */         transformedSortedSet.decorated().add(paramTransformer.transform(object));
/*     */       }
/*     */     } 
/*  88 */     return transformedSortedSet;
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
/*     */   protected TransformedSortedSet(SortedSet<E> paramSortedSet, Transformer<? super E, ? extends E> paramTransformer) {
/* 103 */     super(paramSortedSet, paramTransformer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SortedSet<E> getSortedSet() {
/* 112 */     return (SortedSet<E>)decorated();
/*     */   }
/*     */ 
/*     */   
/*     */   public E first() {
/* 117 */     return getSortedSet().first();
/*     */   }
/*     */   
/*     */   public E last() {
/* 121 */     return getSortedSet().last();
/*     */   }
/*     */   
/*     */   public Comparator<? super E> comparator() {
/* 125 */     return getSortedSet().comparator();
/*     */   }
/*     */ 
/*     */   
/*     */   public SortedSet<E> subSet(E paramE1, E paramE2) {
/* 130 */     SortedSet<E> sortedSet = getSortedSet().subSet(paramE1, paramE2);
/* 131 */     return new TransformedSortedSet(sortedSet, this.transformer);
/*     */   }
/*     */   
/*     */   public SortedSet<E> headSet(E paramE) {
/* 135 */     SortedSet<E> sortedSet = getSortedSet().headSet(paramE);
/* 136 */     return new TransformedSortedSet(sortedSet, this.transformer);
/*     */   }
/*     */   
/*     */   public SortedSet<E> tailSet(E paramE) {
/* 140 */     SortedSet<E> sortedSet = getSortedSet().tailSet(paramE);
/* 141 */     return new TransformedSortedSet(sortedSet, this.transformer);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\set\TransformedSortedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */