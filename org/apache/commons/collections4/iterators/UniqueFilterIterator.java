/*    */ package org.apache.commons.collections4.iterators;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import org.apache.commons.collections4.functors.UniquePredicate;
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
/*    */ public class UniqueFilterIterator<E>
/*    */   extends FilterIterator<E>
/*    */ {
/*    */   public UniqueFilterIterator(Iterator<? extends E> paramIterator) {
/* 41 */     super(paramIterator, UniquePredicate.uniquePredicate());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\UniqueFilterIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */