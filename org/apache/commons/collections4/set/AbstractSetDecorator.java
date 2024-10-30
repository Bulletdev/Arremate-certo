/*    */ package org.apache.commons.collections4.set;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Set;
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
/*    */ 
/*    */ public abstract class AbstractSetDecorator<E>
/*    */   extends AbstractCollectionDecorator<E>
/*    */   implements Set<E>
/*    */ {
/*    */   private static final long serialVersionUID = -4678668309576958546L;
/*    */   
/*    */   protected AbstractSetDecorator() {}
/*    */   
/*    */   protected AbstractSetDecorator(Set<E> paramSet) {
/* 53 */     super(paramSet);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Set<E> decorated() {
/* 63 */     return (Set<E>)super.decorated();
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
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\set\AbstractSetDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */