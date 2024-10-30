/*     */ package org.apache.commons.collections4.iterators;
/*     */ 
/*     */ import java.util.ListIterator;
/*     */ import org.apache.commons.collections4.Unmodifiable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class UnmodifiableListIterator<E>
/*     */   implements ListIterator<E>, Unmodifiable
/*     */ {
/*     */   private final ListIterator<? extends E> iterator;
/*     */   
/*     */   public static <E> ListIterator<E> umodifiableListIterator(ListIterator<? extends E> paramListIterator) {
/*  46 */     if (paramListIterator == null) {
/*  47 */       throw new NullPointerException("ListIterator must not be null");
/*     */     }
/*  49 */     if (paramListIterator instanceof Unmodifiable)
/*     */     {
/*  51 */       return (ListIterator)paramListIterator;
/*     */     }
/*     */     
/*  54 */     return new UnmodifiableListIterator<E>(paramListIterator);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private UnmodifiableListIterator(ListIterator<? extends E> paramListIterator) {
/*  65 */     this.iterator = paramListIterator;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/*  70 */     return this.iterator.hasNext();
/*     */   }
/*     */   
/*     */   public E next() {
/*  74 */     return this.iterator.next();
/*     */   }
/*     */   
/*     */   public int nextIndex() {
/*  78 */     return this.iterator.nextIndex();
/*     */   }
/*     */   
/*     */   public boolean hasPrevious() {
/*  82 */     return this.iterator.hasPrevious();
/*     */   }
/*     */   
/*     */   public E previous() {
/*  86 */     return this.iterator.previous();
/*     */   }
/*     */   
/*     */   public int previousIndex() {
/*  90 */     return this.iterator.previousIndex();
/*     */   }
/*     */   
/*     */   public void remove() {
/*  94 */     throw new UnsupportedOperationException("remove() is not supported");
/*     */   }
/*     */   
/*     */   public void set(E paramE) {
/*  98 */     throw new UnsupportedOperationException("set() is not supported");
/*     */   }
/*     */   
/*     */   public void add(E paramE) {
/* 102 */     throw new UnsupportedOperationException("add() is not supported");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\UnmodifiableListIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */