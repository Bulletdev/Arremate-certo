/*     */ package org.apache.commons.collections4.iterators;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import org.apache.commons.collections4.FluentIterable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ZippingIterator<E>
/*     */   implements Iterator<E>
/*     */ {
/*     */   private final Iterator<Iterator<? extends E>> iterators;
/*  43 */   private Iterator<? extends E> nextIterator = null;
/*     */ 
/*     */   
/*  46 */   private Iterator<? extends E> lastReturned = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ZippingIterator(Iterator<? extends E> paramIterator1, Iterator<? extends E> paramIterator2) {
/*  61 */     this((Iterator<? extends E>[])new Iterator[] { paramIterator1, paramIterator2 });
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
/*     */   public ZippingIterator(Iterator<? extends E> paramIterator1, Iterator<? extends E> paramIterator2, Iterator<? extends E> paramIterator3) {
/*  77 */     this((Iterator<? extends E>[])new Iterator[] { paramIterator1, paramIterator2, paramIterator3 });
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
/*     */   public ZippingIterator(Iterator<? extends E>... paramVarArgs) {
/*  89 */     ArrayList<Iterator<? extends E>> arrayList = new ArrayList();
/*  90 */     for (Iterator<? extends E> iterator : paramVarArgs) {
/*  91 */       if (iterator == null) {
/*  92 */         throw new NullPointerException("Iterator must not be null.");
/*     */       }
/*  94 */       arrayList.add(iterator);
/*     */     } 
/*  96 */     this.iterators = FluentIterable.of(arrayList).loop().iterator();
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
/*     */   public boolean hasNext() {
/* 110 */     if (this.nextIterator != null) {
/* 111 */       return true;
/*     */     }
/*     */     
/* 114 */     while (this.iterators.hasNext()) {
/* 115 */       Iterator<? extends E> iterator = this.iterators.next();
/* 116 */       if (iterator.hasNext()) {
/* 117 */         this.nextIterator = iterator;
/* 118 */         return true;
/*     */       } 
/*     */       
/* 121 */       this.iterators.remove();
/*     */     } 
/*     */     
/* 124 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E next() throws NoSuchElementException {
/* 134 */     if (!hasNext()) {
/* 135 */       throw new NoSuchElementException();
/*     */     }
/*     */     
/* 138 */     E e = this.nextIterator.next();
/* 139 */     this.lastReturned = this.nextIterator;
/* 140 */     this.nextIterator = null;
/* 141 */     return e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove() {
/* 151 */     if (this.lastReturned == null) {
/* 152 */       throw new IllegalStateException("No value can be removed at present");
/*     */     }
/* 154 */     this.lastReturned.remove();
/* 155 */     this.lastReturned = null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\ZippingIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */