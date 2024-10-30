/*    */ package org.apache.commons.collections4.bag;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Set;
/*    */ import org.apache.commons.collections4.Bag;
/*    */ import org.apache.commons.collections4.collection.AbstractCollectionDecorator;
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
/*    */ public abstract class AbstractBagDecorator<E>
/*    */   extends AbstractCollectionDecorator<E>
/*    */   implements Bag<E>
/*    */ {
/*    */   private static final long serialVersionUID = -3768146017343785417L;
/*    */   
/*    */   protected AbstractBagDecorator() {}
/*    */   
/*    */   protected AbstractBagDecorator(Bag<E> paramBag) {
/* 53 */     super((Collection)paramBag);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Bag<E> decorated() {
/* 63 */     return (Bag<E>)super.decorated();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 68 */     return (paramObject == this || decorated().equals(paramObject));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 73 */     return decorated().hashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getCount(Object paramObject) {
/* 80 */     return decorated().getCount(paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean add(E paramE, int paramInt) {
/* 85 */     return decorated().add(paramE, paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean remove(Object paramObject, int paramInt) {
/* 90 */     return decorated().remove(paramObject, paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<E> uniqueSet() {
/* 95 */     return decorated().uniqueSet();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\bag\AbstractBagDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */