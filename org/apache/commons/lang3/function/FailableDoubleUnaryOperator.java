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
/*    */ public interface FailableDoubleUnaryOperator<E extends Throwable>
/*    */ {
/*    */   public static final FailableDoubleUnaryOperator NOP = paramDouble -> 0.0D;
/*    */   
/*    */   static <E extends Throwable> FailableDoubleUnaryOperator<E> identity() {
/* 42 */     return paramDouble -> paramDouble;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static <E extends Throwable> FailableDoubleUnaryOperator<E> nop() {
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
/*    */ 
/*    */   
/*    */   default FailableDoubleUnaryOperator<E> andThen(FailableDoubleUnaryOperator<E> paramFailableDoubleUnaryOperator) {
/* 66 */     Objects.requireNonNull(paramFailableDoubleUnaryOperator);
/* 67 */     return paramDouble -> paramFailableDoubleUnaryOperator.applyAsDouble(applyAsDouble(paramDouble));
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
/*    */ 
/*    */   
/*    */   default FailableDoubleUnaryOperator<E> compose(FailableDoubleUnaryOperator<E> paramFailableDoubleUnaryOperator) {
/* 90 */     Objects.requireNonNull(paramFailableDoubleUnaryOperator);
/* 91 */     return paramDouble -> applyAsDouble(paramFailableDoubleUnaryOperator.applyAsDouble(paramDouble));
/*    */   }
/*    */   
/*    */   double applyAsDouble(double paramDouble) throws E;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\function\FailableDoubleUnaryOperator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */