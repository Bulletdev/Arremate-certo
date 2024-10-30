/*     */ package org.apache.commons.collections4.iterators;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import org.apache.commons.collections4.ResettableIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LoopingIterator<E>
/*     */   implements ResettableIterator<E>
/*     */ {
/*     */   private final Collection<? extends E> collection;
/*     */   private Iterator<? extends E> iterator;
/*     */   
/*     */   public LoopingIterator(Collection<? extends E> paramCollection) {
/*  55 */     if (paramCollection == null) {
/*  56 */       throw new NullPointerException("The collection must not be null");
/*     */     }
/*  58 */     this.collection = paramCollection;
/*  59 */     reset();
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
/*     */   public boolean hasNext() {
/*  71 */     return (this.collection.size() > 0);
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
/*     */   public E next() {
/*  84 */     if (this.collection.size() == 0) {
/*  85 */       throw new NoSuchElementException("There are no elements for this iterator to loop on");
/*     */     }
/*  87 */     if (!this.iterator.hasNext()) {
/*  88 */       reset();
/*     */     }
/*  90 */     return this.iterator.next();
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
/*     */   public void remove() {
/* 106 */     this.iterator.remove();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 113 */     this.iterator = this.collection.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 122 */     return this.collection.size();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\LoopingIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */