/*     */ package org.apache.commons.collections4.iterators;
/*     */ 
/*     */ import java.util.ListIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AbstractListIteratorDecorator<E>
/*     */   implements ListIterator<E>
/*     */ {
/*     */   private final ListIterator<E> iterator;
/*     */   
/*     */   public AbstractListIteratorDecorator(ListIterator<E> paramListIterator) {
/*  43 */     if (paramListIterator == null) {
/*  44 */       throw new NullPointerException("ListIterator must not be null");
/*     */     }
/*  46 */     this.iterator = paramListIterator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ListIterator<E> getListIterator() {
/*  55 */     return this.iterator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/*  62 */     return this.iterator.hasNext();
/*     */   }
/*     */ 
/*     */   
/*     */   public E next() {
/*  67 */     return this.iterator.next();
/*     */   }
/*     */ 
/*     */   
/*     */   public int nextIndex() {
/*  72 */     return this.iterator.nextIndex();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasPrevious() {
/*  77 */     return this.iterator.hasPrevious();
/*     */   }
/*     */ 
/*     */   
/*     */   public E previous() {
/*  82 */     return this.iterator.previous();
/*     */   }
/*     */ 
/*     */   
/*     */   public int previousIndex() {
/*  87 */     return this.iterator.previousIndex();
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove() {
/*  92 */     this.iterator.remove();
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(E paramE) {
/*  97 */     this.iterator.set(paramE);
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(E paramE) {
/* 102 */     this.iterator.add(paramE);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\AbstractListIteratorDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */