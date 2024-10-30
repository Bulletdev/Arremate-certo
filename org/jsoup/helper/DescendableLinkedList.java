/*    */ package org.jsoup.helper;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import java.util.ListIterator;
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
/*    */ public class DescendableLinkedList<E>
/*    */   extends LinkedList<E>
/*    */ {
/*    */   public void push(E paramE) {
/* 24 */     addFirst(paramE);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public E peekLast() {
/* 32 */     return (size() == 0) ? null : getLast();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public E pollLast() {
/* 40 */     return (size() == 0) ? null : removeLast();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Iterator<E> descendingIterator() {
/* 48 */     return new DescendingIterator<E>(size());
/*    */   }
/*    */   
/*    */   private class DescendingIterator<E>
/*    */     implements Iterator<E> {
/*    */     private final ListIterator<E> iter;
/*    */     
/*    */     private DescendingIterator(int param1Int) {
/* 56 */       this.iter = DescendableLinkedList.this.listIterator(param1Int);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public boolean hasNext() {
/* 64 */       return this.iter.hasPrevious();
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public E next() {
/* 72 */       return this.iter.previous();
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public void remove() {
/* 79 */       this.iter.remove();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\helper\DescendableLinkedList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */