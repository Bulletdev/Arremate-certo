/*    */ package org.apache.commons.collections4.bag;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Comparator;
/*    */ import org.apache.commons.collections4.Bag;
/*    */ import org.apache.commons.collections4.SortedBag;
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
/*    */ 
/*    */ public abstract class AbstractSortedBagDecorator<E>
/*    */   extends AbstractBagDecorator<E>
/*    */   implements SortedBag<E>
/*    */ {
/*    */   private static final long serialVersionUID = -8223473624050467718L;
/*    */   
/*    */   protected AbstractSortedBagDecorator() {}
/*    */   
/*    */   protected AbstractSortedBagDecorator(SortedBag<E> paramSortedBag) {
/* 52 */     super((Bag<E>)paramSortedBag);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected SortedBag<E> decorated() {
/* 62 */     return (SortedBag<E>)super.decorated();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public E first() {
/* 69 */     return (E)decorated().first();
/*    */   }
/*    */ 
/*    */   
/*    */   public E last() {
/* 74 */     return (E)decorated().last();
/*    */   }
/*    */ 
/*    */   
/*    */   public Comparator<? super E> comparator() {
/* 79 */     return decorated().comparator();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\bag\AbstractSortedBagDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */