/*    */ package org.apache.commons.collections4.iterators;
/*    */ 
/*    */ import org.apache.commons.collections4.OrderedIterator;
/*    */ import org.apache.commons.collections4.ResettableIterator;
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
/*    */ public class EmptyOrderedIterator<E>
/*    */   extends AbstractEmptyIterator<E>
/*    */   implements OrderedIterator<E>, ResettableIterator<E>
/*    */ {
/* 36 */   public static final OrderedIterator INSTANCE = new EmptyOrderedIterator();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <E> OrderedIterator<E> emptyOrderedIterator() {
/* 45 */     return INSTANCE;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\EmptyOrderedIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */