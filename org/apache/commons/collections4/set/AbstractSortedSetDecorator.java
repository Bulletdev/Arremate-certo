/*    */ package org.apache.commons.collections4.set;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Comparator;
/*    */ import java.util.Set;
/*    */ import java.util.SortedSet;
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
/*    */ 
/*    */ 
/*    */ public abstract class AbstractSortedSetDecorator<E>
/*    */   extends AbstractSetDecorator<E>
/*    */   implements SortedSet<E>
/*    */ {
/*    */   private static final long serialVersionUID = -3462240946294214398L;
/*    */   
/*    */   protected AbstractSortedSetDecorator() {}
/*    */   
/*    */   protected AbstractSortedSetDecorator(Set<E> paramSet) {
/* 54 */     super(paramSet);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected SortedSet<E> decorated() {
/* 64 */     return (SortedSet<E>)super.decorated();
/*    */   }
/*    */ 
/*    */   
/*    */   public SortedSet<E> subSet(E paramE1, E paramE2) {
/* 69 */     return decorated().subSet(paramE1, paramE2);
/*    */   }
/*    */   
/*    */   public SortedSet<E> headSet(E paramE) {
/* 73 */     return decorated().headSet(paramE);
/*    */   }
/*    */   
/*    */   public SortedSet<E> tailSet(E paramE) {
/* 77 */     return decorated().tailSet(paramE);
/*    */   }
/*    */   
/*    */   public E first() {
/* 81 */     return decorated().first();
/*    */   }
/*    */   
/*    */   public E last() {
/* 85 */     return decorated().last();
/*    */   }
/*    */   
/*    */   public Comparator<? super E> comparator() {
/* 89 */     return decorated().comparator();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\set\AbstractSortedSetDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */