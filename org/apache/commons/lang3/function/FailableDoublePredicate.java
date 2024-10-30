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
/*    */ public interface FailableDoublePredicate<E extends Throwable>
/*    */ {
/*    */   public static final FailableDoublePredicate FALSE = paramDouble -> false;
/*    */   public static final FailableDoublePredicate TRUE = paramDouble -> true;
/*    */   
/*    */   static <E extends Throwable> FailableDoublePredicate<E> falsePredicate() {
/* 47 */     return FALSE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static <E extends Throwable> FailableDoublePredicate<E> truePredicate() {
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
/*    */   default FailableDoublePredicate<E> and(FailableDoublePredicate<E> paramFailableDoublePredicate) {
/* 68 */     Objects.requireNonNull(paramFailableDoublePredicate);
/* 69 */     return paramDouble -> (test(paramDouble) && paramFailableDoublePredicate.test(paramDouble));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FailableDoublePredicate<E> negate() {
/* 78 */     return paramDouble -> !test(paramDouble);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FailableDoublePredicate<E> or(FailableDoublePredicate<E> paramFailableDoublePredicate) {
/* 89 */     Objects.requireNonNull(paramFailableDoublePredicate);
/* 90 */     return paramDouble -> (test(paramDouble) || paramFailableDoublePredicate.test(paramDouble));
/*    */   }
/*    */   
/*    */   boolean test(double paramDouble) throws E;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\function\FailableDoublePredicate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */