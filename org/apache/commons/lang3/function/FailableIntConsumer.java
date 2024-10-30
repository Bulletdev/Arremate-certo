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
/*    */ public interface FailableIntConsumer<E extends Throwable>
/*    */ {
/*    */   public static final FailableIntConsumer NOP = paramInt -> {
/*    */     
/*    */     };
/*    */   
/*    */   static <E extends Throwable> FailableIntConsumer<E> nop() {
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
/*    */   default FailableIntConsumer<E> andThen(FailableIntConsumer<E> paramFailableIntConsumer) {
/* 62 */     Objects.requireNonNull(paramFailableIntConsumer);
/* 63 */     return paramInt -> {
/*    */         accept(paramInt);
/*    */         paramFailableIntConsumer.accept(paramInt);
/*    */       };
/*    */   }
/*    */   
/*    */   void accept(int paramInt) throws E;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\function\FailableIntConsumer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */