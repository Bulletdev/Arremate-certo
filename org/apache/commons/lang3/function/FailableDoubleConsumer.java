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
/*    */ public interface FailableDoubleConsumer<E extends Throwable>
/*    */ {
/*    */   public static final FailableDoubleConsumer NOP = paramDouble -> {
/*    */     
/*    */     };
/*    */   
/*    */   static <E extends Throwable> FailableDoubleConsumer<E> nop() {
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
/*    */   default FailableDoubleConsumer<E> andThen(FailableDoubleConsumer<E> paramFailableDoubleConsumer) {
/* 62 */     Objects.requireNonNull(paramFailableDoubleConsumer);
/* 63 */     return paramDouble -> {
/*    */         accept(paramDouble);
/*    */         paramFailableDoubleConsumer.accept(paramDouble);
/*    */       };
/*    */   }
/*    */   
/*    */   void accept(double paramDouble) throws E;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\function\FailableDoubleConsumer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */