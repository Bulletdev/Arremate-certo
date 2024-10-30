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
/*    */ @FunctionalInterface
/*    */ public interface FailableBiConsumer<T, U, E extends Throwable>
/*    */ {
/*    */   public static final FailableBiConsumer NOP = (paramObject1, paramObject2) -> {
/*    */     
/*    */     };
/*    */   
/*    */   static <T, U, E extends Throwable> FailableBiConsumer<T, U, E> nop() {
/* 47 */     return NOP;
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
/*    */   default FailableBiConsumer<T, U, E> andThen(FailableBiConsumer<? super T, ? super U, E> paramFailableBiConsumer) {
/* 67 */     Objects.requireNonNull(paramFailableBiConsumer);
/* 68 */     return (paramObject1, paramObject2) -> {
/*    */         accept((T)paramObject1, (U)paramObject2);
/*    */         paramFailableBiConsumer.accept(paramObject1, paramObject2);
/*    */       };
/*    */   }
/*    */   
/*    */   void accept(T paramT, U paramU) throws E;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\function\FailableBiConsumer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */