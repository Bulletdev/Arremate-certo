/*    */ package org.apache.commons.lang3.function;
/*    */ 
/*    */ import java.util.Objects;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @FunctionalInterface
/*    */ public interface FailableBiPredicate<T, U, E extends Throwable>
/*    */ {
/*    */   public static final FailableBiPredicate FALSE = (paramObject1, paramObject2) -> false;
/*    */   public static final FailableBiPredicate TRUE = (paramObject1, paramObject2) -> true;
/*    */   
/*    */   static <T, U, E extends Throwable> FailableBiPredicate<T, U, E> falsePredicate() {
/* 51 */     return FALSE;
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
/*    */   static <T, U, E extends Throwable> FailableBiPredicate<T, U, E> truePredicate() {
/* 63 */     return TRUE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FailableBiPredicate<T, U, E> and(FailableBiPredicate<? super T, ? super U, E> paramFailableBiPredicate) {
/* 74 */     Objects.requireNonNull(paramFailableBiPredicate);
/* 75 */     return (paramObject1, paramObject2) -> (test((T)paramObject1, (U)paramObject2) && paramFailableBiPredicate.test(paramObject1, paramObject2));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FailableBiPredicate<T, U, E> negate() {
/* 84 */     return (paramObject1, paramObject2) -> !test((T)paramObject1, (U)paramObject2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FailableBiPredicate<T, U, E> or(FailableBiPredicate<? super T, ? super U, E> paramFailableBiPredicate) {
/* 95 */     Objects.requireNonNull(paramFailableBiPredicate);
/* 96 */     return (paramObject1, paramObject2) -> (test((T)paramObject1, (U)paramObject2) || paramFailableBiPredicate.test(paramObject1, paramObject2));
/*    */   }
/*    */   
/*    */   boolean test(T paramT, U paramU) throws E;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\function\FailableBiPredicate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */