/*     */ package org.apache.commons.collections4.iterators;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.NoSuchElementException;
/*     */ import org.apache.commons.collections4.ResettableListIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArrayListIterator<E>
/*     */   extends ArrayIterator<E>
/*     */   implements ResettableListIterator<E>
/*     */ {
/*  51 */   private int lastItemIndex = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayListIterator(Object paramObject) {
/*  64 */     super(paramObject);
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
/*     */   public ArrayListIterator(Object paramObject, int paramInt) {
/*  78 */     super(paramObject, paramInt);
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
/*     */   public ArrayListIterator(Object paramObject, int paramInt1, int paramInt2) {
/*  94 */     super(paramObject, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasPrevious() {
/* 105 */     return (this.index > this.startIndex);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E previous() {
/* 116 */     if (!hasPrevious()) {
/* 117 */       throw new NoSuchElementException();
/*     */     }
/* 119 */     this.lastItemIndex = --this.index;
/* 120 */     return (E)Array.get(this.array, this.index);
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
/*     */   public E next() {
/* 132 */     if (!hasNext()) {
/* 133 */       throw new NoSuchElementException();
/*     */     }
/* 135 */     this.lastItemIndex = this.index;
/* 136 */     return (E)Array.get(this.array, this.index++);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int nextIndex() {
/* 145 */     return this.index - this.startIndex;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int previousIndex() {
/* 154 */     return this.index - this.startIndex - 1;
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
/*     */   public void add(Object paramObject) {
/* 166 */     throw new UnsupportedOperationException("add() method is not supported");
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
/*     */   
/*     */   public void set(Object paramObject) {
/* 188 */     if (this.lastItemIndex == -1) {
/* 189 */       throw new IllegalStateException("must call next() or previous() before a call to set()");
/*     */     }
/*     */     
/* 192 */     Array.set(this.array, this.lastItemIndex, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 200 */     super.reset();
/* 201 */     this.lastItemIndex = -1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\ArrayListIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */