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
/*    */ @FunctionalInterface
/*    */ public interface FailablePredicate<T, E extends Throwable>
/*    */ {
/*    */   public static final FailablePredicate FALSE = paramObject -> false;
/*    */   public static final FailablePredicate TRUE = paramObject -> true;
/*    */   
/*    */   static <T, E extends Throwable> FailablePredicate<T, E> falsePredicate() {
/* 49 */     return FALSE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static <T, E extends Throwable> FailablePredicate<T, E> truePredicate() {
/* 60 */     return TRUE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FailablePredicate<T, E> and(FailablePredicate<? super T, E> paramFailablePredicate) {
/* 71 */     Objects.requireNonNull(paramFailablePredicate);
/* 72 */     return paramObject -> (test((T)paramObject) && paramFailablePredicate.test(paramObject));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FailablePredicate<T, E> negate() {
/* 81 */     return paramObject -> !test((T)paramObject);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FailablePredicate<T, E> or(FailablePredicate<? super T, E> paramFailablePredicate) {
/* 92 */     Objects.requireNonNull(paramFailablePredicate);
/* 93 */     return paramObject -> (test((T)paramObject) || paramFailablePredicate.test(paramObject));
/*    */   }
/*    */   
/*    */   boolean test(T paramT) throws E;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\function\FailablePredicate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */