/*    */ package org.apache.commons.collections4.iterators;
/*    */ 
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
/*    */ public abstract class AbstractUntypedIteratorDecorator<I, O>
/*    */   implements Iterator<O>
/*    */ {
/*    */   private final Iterator<I> iterator;
/*    */   
/*    */   protected AbstractUntypedIteratorDecorator(Iterator<I> paramIterator) {
/* 43 */     if (paramIterator == null) {
/* 44 */       throw new NullPointerException("Iterator must not be null");
/*    */     }
/* 46 */     this.iterator = paramIterator;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Iterator<I> getIterator() {
/* 55 */     return this.iterator;
/*    */   }
/*    */   
/*    */   public boolean hasNext() {
/* 59 */     return this.iterator.hasNext();
/*    */   }
/*    */   
/*    */   public void remove() {
/* 63 */     this.iterator.remove();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\AbstractUntypedIteratorDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */