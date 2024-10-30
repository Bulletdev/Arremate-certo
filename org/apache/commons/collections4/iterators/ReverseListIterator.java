/*     */ package org.apache.commons.collections4.iterators;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
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
/*     */ 
/*     */ public class ReverseListIterator<E>
/*     */   implements ResettableListIterator<E>
/*     */ {
/*     */   private final List<E> list;
/*     */   private ListIterator<E> iterator;
/*     */   private boolean validForUpdate = true;
/*     */   
/*     */   public ReverseListIterator(List<E> paramList) {
/*  56 */     if (paramList == null) {
/*  57 */       throw new NullPointerException("List must not be null.");
/*     */     }
/*  59 */     this.list = paramList;
/*  60 */     this.iterator = paramList.listIterator(paramList.size());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/*  70 */     return this.iterator.hasPrevious();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E next() {
/*  80 */     E e = this.iterator.previous();
/*  81 */     this.validForUpdate = true;
/*  82 */     return e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int nextIndex() {
/*  91 */     return this.iterator.previousIndex();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasPrevious() {
/* 100 */     return this.iterator.hasNext();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E previous() {
/* 110 */     E e = this.iterator.next();
/* 111 */     this.validForUpdate = true;
/* 112 */     return e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int previousIndex() {
/* 121 */     return this.iterator.nextIndex();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove() {
/* 131 */     if (!this.validForUpdate) {
/* 132 */       throw new IllegalStateException("Cannot remove from list until next() or previous() called");
/*     */     }
/* 134 */     this.iterator.remove();
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
/* 145 */     if (!this.validForUpdate) {
/* 146 */       throw new IllegalStateException("Cannot set to list until next() or previous() called");
/*     */     }
/* 148 */     this.iterator.set(paramE);
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
/*     */   public void add(E paramE) {
/* 161 */     if (!this.validForUpdate) {
/* 162 */       throw new IllegalStateException("Cannot add to list until next() or previous() called");
/*     */     }
/* 164 */     this.validForUpdate = false;
/* 165 */     this.iterator.add(paramE);
/* 166 */     this.iterator.previous();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 174 */     this.iterator = this.list.listIterator(this.list.size());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\ReverseListIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */