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
/*    */ public interface FailableIntUnaryOperator<E extends Throwable>
/*    */ {
/*    */   public static final FailableIntUnaryOperator NOP = paramInt -> 0;
/*    */   
/*    */   static <E extends Throwable> FailableIntUnaryOperator<E> identity() {
/* 42 */     return paramInt -> paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static <E extends Throwable> FailableIntUnaryOperator<E> nop() {
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
/*    */   default FailableIntUnaryOperator<E> andThen(FailableIntUnaryOperator<E> paramFailableIntUnaryOperator) {
/* 64 */     Objects.requireNonNull(paramFailableIntUnaryOperator);
/* 65 */     return paramInt -> paramFailableIntUnaryOperator.applyAsInt(applyAsInt(paramInt));
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
/*    */   default FailableIntUnaryOperator<E> compose(FailableIntUnaryOperator<E> paramFailableIntUnaryOperator) {
/* 86 */     Objects.requireNonNull(paramFailableIntUnaryOperator);
/* 87 */     return paramInt -> applyAsInt(paramFailableIntUnaryOperator.applyAsInt(paramInt));
/*    */   }
/*    */   
/*    */   int applyAsInt(int paramInt) throws E;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\function\FailableIntUnaryOperator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */