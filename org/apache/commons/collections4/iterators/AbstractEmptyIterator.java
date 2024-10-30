/*    */ package org.apache.commons.collections4.iterators;
/*    */ 
/*    */ import java.util.NoSuchElementException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ abstract class AbstractEmptyIterator<E>
/*    */ {
/*    */   public boolean hasNext() {
/* 37 */     return false;
/*    */   }
/*    */   
/*    */   public E next() {
/* 41 */     throw new NoSuchElementException("Iterator contains no elements");
/*    */   }
/*    */   
/*    */   public boolean hasPrevious() {
/* 45 */     return false;
/*    */   }
/*    */   
/*    */   public E previous() {
/* 49 */     throw new NoSuchElementException("Iterator contains no elements");
/*    */   }
/*    */   
/*    */   public int nextIndex() {
/* 53 */     return 0;
/*    */   }
/*    */   
/*    */   public int previousIndex() {
/* 57 */     return -1;
/*    */   }
/*    */   
/*    */   public void add(E paramE) {
/* 61 */     throw new UnsupportedOperationException("add() not supported for empty Iterator");
/*    */   }
/*    */   
/*    */   public void set(E paramE) {
/* 65 */     throw new IllegalStateException("Iterator contains no elements");
/*    */   }
/*    */   
/*    */   public void remove() {
/* 69 */     throw new IllegalStateException("Iterator contains no elements");
/*    */   }
/*    */   
/*    */   public void reset() {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\AbstractEmptyIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */