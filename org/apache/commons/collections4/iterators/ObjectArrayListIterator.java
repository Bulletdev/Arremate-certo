/*     */ package org.apache.commons.collections4.iterators;
/*     */ 
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
/*     */ public class ObjectArrayListIterator<E>
/*     */   extends ObjectArrayIterator<E>
/*     */   implements ResettableListIterator<E>
/*     */ {
/*  48 */   private int lastItemIndex = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectArrayListIterator(E... paramVarArgs) {
/*  59 */     super(paramVarArgs);
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
/*     */   public ObjectArrayListIterator(E[] paramArrayOfE, int paramInt) {
/*  72 */     super(paramArrayOfE, paramInt);
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
/*     */   public ObjectArrayListIterator(E[] paramArrayOfE, int paramInt1, int paramInt2) {
/*  87 */     super(paramArrayOfE, paramInt1, paramInt2);
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
/*     */   public boolean hasPrevious() {
/*  99 */     return (this.index > getStartIndex());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E previous() {
/* 109 */     if (!hasPrevious()) {
/* 110 */       throw new NoSuchElementException();
/*     */     }
/* 112 */     this.lastItemIndex = --this.index;
/* 113 */     return this.array[this.index];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E next() {
/* 124 */     if (!hasNext()) {
/* 125 */       throw new NoSuchElementException();
/*     */     }
/* 127 */     this.lastItemIndex = this.index;
/* 128 */     return this.array[this.index++];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int nextIndex() {
/* 137 */     return this.index - getStartIndex();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int previousIndex() {
/* 146 */     return this.index - getStartIndex() - 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(E paramE) {
/* 157 */     throw new UnsupportedOperationException("add() method is not supported");
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
/*     */   public void set(E paramE) {
/* 178 */     if (this.lastItemIndex == -1) {
/* 179 */       throw new IllegalStateException("must call next() or previous() before a call to set()");
/*     */     }
/*     */     
/* 182 */     this.array[this.lastItemIndex] = paramE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 190 */     super.reset();
/* 191 */     this.lastItemIndex = -1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\ObjectArrayListIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */