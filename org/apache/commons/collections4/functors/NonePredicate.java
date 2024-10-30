/*    */ package org.apache.commons.collections4.functors;
/*    */ 
/*    */ import java.util.Collection;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class NonePredicate<T>
/*    */   extends AbstractQuantifierPredicate<T>
/*    */ {
/*    */   private static final long serialVersionUID = 2007613066565892961L;
/*    */   
/*    */   public static <T> Predicate<T> nonePredicate(Predicate<? super T>... paramVarArgs) {
/* 51 */     FunctorUtils.validate((Predicate<?>[])paramVarArgs);
/* 52 */     if (paramVarArgs.length == 0) {
/* 53 */       return TruePredicate.truePredicate();
/*    */     }
/* 55 */     return new NonePredicate<T>((Predicate<? super T>[])FunctorUtils.copy(paramVarArgs));
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
/*    */   public static <T> Predicate<T> nonePredicate(Collection<? extends Predicate<? super T>> paramCollection) {
/* 70 */     Predicate[] arrayOfPredicate = (Predicate[])FunctorUtils.validate(paramCollection);
/* 71 */     if (arrayOfPredicate.length == 0) {
/* 72 */       return TruePredicate.truePredicate();
/*    */     }
/* 74 */     return new NonePredicate<T>((Predicate<? super T>[])arrayOfPredicate);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NonePredicate(Predicate<? super T>... paramVarArgs) {
/* 84 */     super(paramVarArgs);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean evaluate(T paramT) {
/* 94 */     for (Predicate<? super T> predicate : this.iPredicates) {
/* 95 */       if (predicate.evaluate(paramT)) {
/* 96 */         return false;
/*    */       }
/*    */     } 
/* 99 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\NonePredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */