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
/*    */ public interface FailableLongUnaryOperator<E extends Throwable>
/*    */ {
/*    */   public static final FailableLongUnaryOperator NOP = paramLong -> 0L;
/*    */   
/*    */   static <E extends Throwable> FailableLongUnaryOperator<E> identity() {
/* 42 */     return paramLong -> paramLong;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static <E extends Throwable> FailableLongUnaryOperator<E> nop() {
/* 52 */     return NOP;
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
/*    */   default FailableLongUnaryOperator<E> andThen(FailableLongUnaryOperator<E> paramFailableLongUnaryOperator) {
/* 64 */     Objects.requireNonNull(paramFailableLongUnaryOperator);
/* 65 */     return paramLong -> paramFailableLongUnaryOperator.applyAsLong(applyAsLong(paramLong));
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FailableLongUnaryOperator<E> compose(FailableLongUnaryOperator<E> paramFailableLongUnaryOperator) {
/* 86 */     Objects.requireNonNull(paramFailableLongUnaryOperator);
/* 87 */     return paramLong -> applyAsLong(paramFailableLongUnaryOperator.applyAsLong(paramLong));
/*    */   }
/*    */   
/*    */   long applyAsLong(long paramLong) throws E;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\function\FailableLongUnaryOperator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */