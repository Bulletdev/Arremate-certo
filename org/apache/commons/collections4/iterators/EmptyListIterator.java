/*    */ package org.apache.commons.collections4.iterators;
/*    */ 
/*    */ import java.util.ListIterator;
/*    */ import org.apache.commons.collections4.ResettableListIterator;
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
/*    */ public class EmptyListIterator<E>
/*    */   extends AbstractEmptyIterator<E>
/*    */   implements ResettableListIterator<E>
/*    */ {
/* 41 */   public static final ResettableListIterator RESETTABLE_INSTANCE = new EmptyListIterator();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 48 */   public static final ListIterator INSTANCE = (ListIterator)RESETTABLE_INSTANCE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <E> ResettableListIterator<E> resettableEmptyListIterator() {
/* 57 */     return RESETTABLE_INSTANCE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static <E> ListIterator<E> emptyListIterator() {
/* 67 */     return INSTANCE;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\iterators\EmptyListIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */