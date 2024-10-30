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
/*    */ public interface FailableBiFunction<T, U, R, E extends Throwable>
/*    */ {
/*    */   public static final FailableBiFunction NOP = (paramObject1, paramObject2) -> null;
/*    */   
/*    */   static <T, U, R, E extends Throwable> FailableBiFunction<T, U, R, E> nop() {
/* 50 */     return NOP;
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
/*    */   default <V> FailableBiFunction<T, U, V, E> andThen(FailableFunction<? super R, ? extends V, E> paramFailableFunction) {
/* 62 */     Objects.requireNonNull(paramFailableFunction);
/* 63 */     return (paramObject1, paramObject2) -> paramFailableFunction.apply(apply((T)paramObject1, (U)paramObject2));
/*    */   }
/*    */   
/*    */   R apply(T paramT, U paramU) throws E;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\function\FailableBiFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */