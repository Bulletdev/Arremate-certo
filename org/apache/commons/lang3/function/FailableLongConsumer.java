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
/*    */ @FunctionalInterface
/*    */ public interface FailableLongConsumer<E extends Throwable>
/*    */ {
/*    */   public static final FailableLongConsumer NOP = paramLong -> {
/*    */     
/*    */     };
/*    */   
/*    */   static <E extends Throwable> FailableLongConsumer<E> nop() {
/* 43 */     return NOP;
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
/*    */   default FailableLongConsumer<E> andThen(FailableLongConsumer<E> paramFailableLongConsumer) {
/* 62 */     Objects.requireNonNull(paramFailableLongConsumer);
/* 63 */     return paramLong -> {
/*    */         accept(paramLong);
/*    */         paramFailableLongConsumer.accept(paramLong);
/*    */       };
/*    */   }
/*    */   
/*    */   void accept(long paramLong) throws E;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\function\FailableLongConsumer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */