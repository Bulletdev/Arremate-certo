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
/*    */ public interface FailableIntPredicate<E extends Throwable>
/*    */ {
/*    */   public static final FailableIntPredicate FALSE = paramInt -> false;
/*    */   public static final FailableIntPredicate TRUE = paramInt -> true;
/*    */   
/*    */   static <E extends Throwable> FailableIntPredicate<E> falsePredicate() {
/* 47 */     return FALSE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static <E extends Throwable> FailableIntPredicate<E> truePredicate() {
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
/*    */   default FailableIntPredicate<E> and(FailableIntPredicate<E> paramFailableIntPredicate) {
/* 68 */     Objects.requireNonNull(paramFailableIntPredicate);
/* 69 */     return paramInt -> (test(paramInt) && paramFailableIntPredicate.test(paramInt));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FailableIntPredicate<E> negate() {
/* 78 */     return paramInt -> !test(paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FailableIntPredicate<E> or(FailableIntPredicate<E> paramFailableIntPredicate) {
/* 89 */     Objects.requireNonNull(paramFailableIntPredicate);
/* 90 */     return paramInt -> (test(paramInt) || paramFailableIntPredicate.test(paramInt));
/*    */   }
/*    */   
/*    */   boolean test(int paramInt) throws E;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\function\FailableIntPredicate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */