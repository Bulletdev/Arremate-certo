/*     */ package org.apache.commons.collections4.iterators;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PeekingIterator<E>
/*     */   implements Iterator<E>
/*     */ {
/*     */   private final Iterator<? extends E> iterator;
/*     */   private boolean exhausted = false;
/*     */   private boolean slotFilled = false;
/*     */   private E slot;
/*     */   
/*     */   public static <E> PeekingIterator<E> peekingIterator(Iterator<? extends E> paramIterator) {
/*  59 */     if (paramIterator == null) {
/*  60 */       throw new NullPointerException("Iterator must not be null");
/*     */     }
/*  62 */     if (paramIterator instanceof PeekingIterator)
/*     */     {
/*  64 */       return (PeekingIterator)paramIterator;
/*     */     }
/*     */     
/*  67 */     return new PeekingIterator<E>(paramIterator);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PeekingIterator(Iterator<? extends E> paramIterator) {
/*  78 */     this.iterator = paramIterator;
/*     */   }
/*     */   
/*     */   private void fill() {
/*  82 */     if (this.exhausted || this.slotFilled) {
/*     */       return;
/*     */     }
/*  85 */     if (this.iterator.hasNext()) {
/*  86 */       this.slot = this.iterator.next();
/*  87 */       this.slotFilled = true;
/*     */     } else {
/*  89 */       this.exhausted = true;
/*  90 */       this.slot = null;
/*  91 */       this.slotFilled = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/*  97 */     if (this.exhausted) {
/*  98 */       return false;
/*     */     }
/* 100 */     return this.slotFilled ? true : this.iterator.hasNext();
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
/*     */   public E peek() {
/* 116 */     fill();
/* 117 */     return this.exhausted ? null : this.slot;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E element() {
/* 128 */     fill();
/* 129 */     if (this.exhausted) {
/* 130 */       throw new NoSuchElementException();
/*     */     }
/* 132 */     return this.slot;
/*     */   }
/*     */   
/*     */   public E next() {
/* 136 */     if (!hasNext()) {
/* 137 */       throw new NoSuchElementException();
/*     */     }
/* 139 */     E e = this.slotFilled ? this.slot : this.iterator.next();
/*     */     
/* 141 */     this.slot = null;
/* 142 */     this.slotFilled = false;
/* 143 */     return e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove() {
/* 153 */     if (this.slotFilled) {
/* 154 */       throw new IllegalStateException("peek() or element() called before remove()");
/*     */     }
/* 156 */     this.iterator.remove();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\PeekingIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */