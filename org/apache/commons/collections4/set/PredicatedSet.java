/*    */ package org.apache.commons.collections4.set;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Set;
/*    */ import org.apache.commons.collections4.Predicate;
/*    */ import org.apache.commons.collections4.collection.PredicatedCollection;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PredicatedSet<E>
/*    */   extends PredicatedCollection<E>
/*    */   implements Set<E>
/*    */ {
/*    */   private static final long serialVersionUID = -684521469108685117L;
/*    */   
/*    */   public static <E> PredicatedSet<E> predicatedSet(Set<E> paramSet, Predicate<? super E> paramPredicate) {
/* 60 */     return new PredicatedSet<E>(paramSet, paramPredicate);
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
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected PredicatedSet(Set<E> paramSet, Predicate<? super E> paramPredicate) {
/* 76 */     super(paramSet, paramPredicate);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Set<E> decorated() {
/* 86 */     return (Set<E>)super.decorated();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 91 */     return (paramObject == this || decorated().equals(paramObject));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 96 */     return decorated().hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\set\PredicatedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */