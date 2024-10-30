/*     */ package org.apache.commons.collections4.bag;
/*     */ 
/*     */ import java.util.Comparator;
/*     */ import org.apache.commons.collections4.Bag;
/*     */ import org.apache.commons.collections4.SortedBag;
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
/*     */ public class TransformedSortedBag<E>
/*     */   extends TransformedBag<E>
/*     */   implements SortedBag<E>
/*     */ {
/*     */   private static final long serialVersionUID = -251737742649401930L;
/*     */   
/*     */   public static <E> TransformedSortedBag<E> transformingSortedBag(SortedBag<E> paramSortedBag, Transformer<? super E, ? extends E> paramTransformer) {
/*  57 */     return new TransformedSortedBag<E>(paramSortedBag, paramTransformer);
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
/*     */   public static <E> TransformedSortedBag<E> transformedSortedBag(SortedBag<E> paramSortedBag, Transformer<? super E, ? extends E> paramTransformer) {
/*  78 */     TransformedSortedBag<E> transformedSortedBag = new TransformedSortedBag<E>(paramSortedBag, paramTransformer);
/*  79 */     if (paramSortedBag.size() > 0) {
/*     */       
/*  81 */       Object[] arrayOfObject = paramSortedBag.toArray();
/*  82 */       paramSortedBag.clear();
/*  83 */       for (Object object : arrayOfObject) {
/*  84 */         transformedSortedBag.decorated().add(paramTransformer.transform(object));
/*     */       }
/*     */     } 
/*  87 */     return transformedSortedBag;
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
/*     */   protected TransformedSortedBag(SortedBag<E> paramSortedBag, Transformer<? super E, ? extends E> paramTransformer) {
/* 102 */     super((Bag<E>)paramSortedBag, paramTransformer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected SortedBag<E> getSortedBag() {
/* 111 */     return (SortedBag<E>)decorated();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E first() {
/* 118 */     return (E)getSortedBag().first();
/*     */   }
/*     */ 
/*     */   
/*     */   public E last() {
/* 123 */     return (E)getSortedBag().last();
/*     */   }
/*     */ 
/*     */   
/*     */   public Comparator<? super E> comparator() {
/* 128 */     return getSortedBag().comparator();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\bag\TransformedSortedBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */