/*    */ package org.apache.commons.collections4.iterators;
/*    */ 
/*    */ import java.util.Enumeration;
/*    */ import java.util.Iterator;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IteratorEnumeration<E>
/*    */   implements Enumeration<E>
/*    */ {
/*    */   private Iterator<? extends E> iterator;
/*    */   
/*    */   public IteratorEnumeration() {}
/*    */   
/*    */   public IteratorEnumeration(Iterator<? extends E> paramIterator) {
/* 48 */     this.iterator = paramIterator;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean hasMoreElements() {
/* 60 */     return this.iterator.hasNext();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public E nextElement() {
/* 71 */     return this.iterator.next();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Iterator<? extends E> getIterator() {
/* 83 */     return this.iterator;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setIterator(Iterator<? extends E> paramIterator) {
/* 92 */     this.iterator = paramIterator;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\IteratorEnumeration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */