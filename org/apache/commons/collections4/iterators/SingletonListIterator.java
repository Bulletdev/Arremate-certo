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
/*     */ public class SingletonListIterator<E>
/*     */   implements ResettableListIterator<E>
/*     */ {
/*     */   private boolean beforeFirst = true;
/*     */   private boolean nextCalled = false;
/*     */   private boolean removed = false;
/*     */   private E object;
/*     */   
/*     */   public SingletonListIterator(E paramE) {
/*  44 */     this.object = paramE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/*  55 */     return (this.beforeFirst && !this.removed);
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
/*  66 */     return (!this.beforeFirst && !this.removed);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int nextIndex() {
/*  76 */     return this.beforeFirst ? 0 : 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int previousIndex() {
/*  87 */     return this.beforeFirst ? -1 : 0;
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
/* 100 */     if (!this.beforeFirst || this.removed) {
/* 101 */       throw new NoSuchElementException();
/*     */     }
/* 103 */     this.beforeFirst = false;
/* 104 */     this.nextCalled = true;
/* 105 */     return this.object;
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
/*     */   public E previous() {
/* 118 */     if (this.beforeFirst || this.removed) {
/* 119 */       throw new NoSuchElementException();
/*     */     }
/* 121 */     this.beforeFirst = true;
/* 122 */     return this.object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove() {
/* 133 */     if (!this.nextCalled || this.removed) {
/* 134 */       throw new IllegalStateException();
/*     */     }
/* 136 */     this.object = null;
/* 137 */     this.removed = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(E paramE) {
/* 147 */     throw new UnsupportedOperationException("add() is not supported by this iterator");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(E paramE) {
/* 158 */     if (!this.nextCalled || this.removed) {
/* 159 */       throw new IllegalStateException();
/*     */     }
/* 161 */     this.object = paramE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 168 */     this.beforeFirst = true;
/* 169 */     this.nextCalled = false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\SingletonListIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */