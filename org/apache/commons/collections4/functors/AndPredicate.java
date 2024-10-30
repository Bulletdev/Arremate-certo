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
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class AndPredicate<T>
/*    */   implements Serializable, PredicateDecorator<T>
/*    */ {
/*    */   private static final long serialVersionUID = 4189014213763186912L;
/*    */   private final Predicate<? super T> iPredicate1;
/*    */   private final Predicate<? super T> iPredicate2;
/*    */   
/*    */   public static <T> Predicate<T> andPredicate(Predicate<? super T> paramPredicate1, Predicate<? super T> paramPredicate2) {
/* 50 */     if (paramPredicate1 == null || paramPredicate2 == null) {
/* 51 */       throw new NullPointerException("Predicate must not be null");
/*    */     }
/* 53 */     return new AndPredicate<T>(paramPredicate1, paramPredicate2);
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
/*    */   public AndPredicate(Predicate<? super T> paramPredicate1, Predicate<? super T> paramPredicate2) {
/* 65 */     this.iPredicate1 = paramPredicate1;
/* 66 */     this.iPredicate2 = paramPredicate2;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean evaluate(T paramT) {
/* 76 */     return (this.iPredicate1.evaluate(paramT) && this.iPredicate2.evaluate(paramT));
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
/* 87 */     return (Predicate<? super T>[])new Predicate[] { this.iPredicate1, this.iPredicate2 };
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\AndPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */