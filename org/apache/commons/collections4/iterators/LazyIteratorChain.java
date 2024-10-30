/*     */ package org.apache.commons.collections4.iterators;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class LazyIteratorChain<E>
/*     */   implements Iterator<E>
/*     */ {
/*  52 */   private int callCounter = 0;
/*     */ 
/*     */   
/*     */   private boolean chainExhausted = false;
/*     */ 
/*     */   
/*  58 */   private Iterator<? extends E> currentIterator = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  64 */   private Iterator<? extends E> lastUsedIterator = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract Iterator<? extends E> nextIterator(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void updateCurrentIterator() {
/*  83 */     if (this.callCounter == 0) {
/*  84 */       this.currentIterator = nextIterator(++this.callCounter);
/*  85 */       if (this.currentIterator == null) {
/*  86 */         this.currentIterator = EmptyIterator.emptyIterator();
/*  87 */         this.chainExhausted = true;
/*     */       } 
/*     */ 
/*     */       
/*  91 */       this.lastUsedIterator = this.currentIterator;
/*     */     } 
/*     */     
/*  94 */     while (!this.currentIterator.hasNext() && !this.chainExhausted) {
/*  95 */       Iterator<? extends E> iterator = nextIterator(++this.callCounter);
/*  96 */       if (iterator != null) {
/*  97 */         this.currentIterator = iterator; continue;
/*     */       } 
/*  99 */       this.chainExhausted = true;
/*     */     } 
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
/* 112 */     updateCurrentIterator();
/* 113 */     this.lastUsedIterator = this.currentIterator;
/*     */     
/* 115 */     return this.currentIterator.hasNext();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E next() {
/* 125 */     updateCurrentIterator();
/* 126 */     this.lastUsedIterator = this.currentIterator;
/*     */     
/* 128 */     return this.currentIterator.next();
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
/* 144 */     if (this.currentIterator == null) {
/* 145 */       updateCurrentIterator();
/*     */     }
/* 147 */     this.lastUsedIterator.remove();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\LazyIteratorChain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */