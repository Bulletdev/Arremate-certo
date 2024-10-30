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
/*    */ @FunctionalInterface
/*    */ public interface FailableConsumer<T, E extends Throwable>
/*    */ {
/*    */   public static final FailableConsumer NOP = paramObject -> {
/*    */     
/*    */     };
/*    */   
/*    */   static <T, E extends Throwable> FailableConsumer<T, E> nop() {
/* 45 */     return NOP;
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
/*    */   default FailableConsumer<T, E> andThen(FailableConsumer<? super T, E> paramFailableConsumer) {
/* 64 */     Objects.requireNonNull(paramFailableConsumer);
/* 65 */     return paramObject -> {
/*    */         accept((T)paramObject);
/*    */         paramFailableConsumer.accept(paramObject);
/*    */       };
/*    */   }
/*    */   
/*    */   void accept(T paramT) throws E;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\function\FailableConsumer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */