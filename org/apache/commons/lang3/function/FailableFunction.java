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
/*    */ public interface FailableFunction<T, R, E extends Throwable>
/*    */ {
/*    */   public static final FailableFunction NOP = paramObject -> null;
/*    */   
/*    */   static <T, E extends Throwable> FailableFunction<T, T, E> identity() {
/* 46 */     return paramObject -> paramObject;
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
/*    */   static <T, R, E extends Throwable> FailableFunction<T, R, E> nop() {
/* 58 */     return NOP;
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
/*    */   default <V> FailableFunction<T, V, E> andThen(FailableFunction<? super R, ? extends V, E> paramFailableFunction) {
/* 70 */     Objects.requireNonNull(paramFailableFunction);
/* 71 */     return paramObject -> paramFailableFunction.apply(apply((T)paramObject));
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
/*    */   default <V> FailableFunction<V, R, E> compose(FailableFunction<? super V, ? extends T, E> paramFailableFunction) {
/* 93 */     Objects.requireNonNull(paramFailableFunction);
/* 94 */     return paramObject -> apply((T)paramFailableFunction.apply(paramObject));
/*    */   }
/*    */   
/*    */   R apply(T paramT) throws E;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\function\FailableFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */