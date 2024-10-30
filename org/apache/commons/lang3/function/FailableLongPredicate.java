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
/*    */ @FunctionalInterface
/*    */ public interface FailableLongPredicate<E extends Throwable>
/*    */ {
/*    */   public static final FailableLongPredicate FALSE = paramLong -> false;
/*    */   public static final FailableLongPredicate TRUE = paramLong -> true;
/*    */   
/*    */   static <E extends Throwable> FailableLongPredicate<E> falsePredicate() {
/* 47 */     return FALSE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static <E extends Throwable> FailableLongPredicate<E> truePredicate() {
/* 57 */     return TRUE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FailableLongPredicate<E> and(FailableLongPredicate<E> paramFailableLongPredicate) {
/* 68 */     Objects.requireNonNull(paramFailableLongPredicate);
/* 69 */     return paramLong -> (test(paramLong) && paramFailableLongPredicate.test(paramLong));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FailableLongPredicate<E> negate() {
/* 78 */     return paramLong -> !test(paramLong);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FailableLongPredicate<E> or(FailableLongPredicate<E> paramFailableLongPredicate) {
/* 89 */     Objects.requireNonNull(paramFailableLongPredicate);
/* 90 */     return paramLong -> (test(paramLong) || paramFailableLongPredicate.test(paramLong));
/*    */   }
/*    */   
/*    */   boolean test(long paramLong) throws E;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\function\FailableLongPredicate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */