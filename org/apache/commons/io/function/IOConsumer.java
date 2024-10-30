/*    */ package org.apache.commons.io.function;
/*    */ 
/*    */ import java.io.IOException;
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
/*    */ 
/*    */ @FunctionalInterface
/*    */ public interface IOConsumer<T>
/*    */ {
/*    */   void accept(T paramT) throws IOException;
/*    */   
/*    */   default IOConsumer<T> andThen(IOConsumer<? super T> paramIOConsumer) {
/* 52 */     Objects.requireNonNull(paramIOConsumer);
/* 53 */     return paramObject -> {
/*    */         accept((T)paramObject);
/*    */         paramIOConsumer.accept(paramObject);
/*    */       };
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\function\IOConsumer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */