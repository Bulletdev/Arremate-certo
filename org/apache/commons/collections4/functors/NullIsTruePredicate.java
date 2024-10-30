/*    */ package org.apache.commons.collections4.functors;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import org.apache.commons.collections4.Predicate;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class NullIsTruePredicate<T>
/*    */   implements Serializable, PredicateDecorator<T>
/*    */ {
/*    */   private static final long serialVersionUID = -7625133768987126273L;
/*    */   private final Predicate<? super T> iPredicate;
/*    */   
/*    */   public static <T> Predicate<T> nullIsTruePredicate(Predicate<? super T> paramPredicate) {
/* 46 */     if (paramPredicate == null) {
/* 47 */       throw new NullPointerException("Predicate must not be null");
/*    */     }
/* 49 */     return new NullIsTruePredicate<T>(paramPredicate);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NullIsTruePredicate(Predicate<? super T> paramPredicate) {
/* 60 */     this.iPredicate = paramPredicate;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean evaluate(T paramT) {
/* 71 */     if (paramT == null) {
/* 72 */       return true;
/*    */     }
/* 74 */     return this.iPredicate.evaluate(paramT);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Predicate<? super T>[] getPredicates() {
/* 85 */     return (Predicate<? super T>[])new Predicate[] { this.iPredicate };
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\NullIsTruePredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */