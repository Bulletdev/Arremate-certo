/*    */ package org.apache.commons.collections4.functors;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import org.apache.commons.collections4.FunctorException;
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
/*    */ public final class NullIsExceptionPredicate<T>
/*    */   implements Serializable, PredicateDecorator<T>
/*    */ {
/*    */   private static final long serialVersionUID = 3243449850504576071L;
/*    */   private final Predicate<? super T> iPredicate;
/*    */   
/*    */   public static <T> Predicate<T> nullIsExceptionPredicate(Predicate<? super T> paramPredicate) {
/* 47 */     if (paramPredicate == null) {
/* 48 */       throw new NullPointerException("Predicate must not be null");
/*    */     }
/* 50 */     return new NullIsExceptionPredicate<T>(paramPredicate);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NullIsExceptionPredicate(Predicate<? super T> paramPredicate) {
/* 61 */     this.iPredicate = paramPredicate;
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
/*    */   public boolean evaluate(T paramT) {
/* 73 */     if (paramT == null) {
/* 74 */       throw new FunctorException("Input Object must not be null");
/*    */     }
/* 76 */     return this.iPredicate.evaluate(paramT);
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
/* 87 */     return (Predicate<? super T>[])new Predicate[] { this.iPredicate };
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\NullIsExceptionPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */