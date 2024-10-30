/*    */ package org.apache.commons.lang3.concurrent;
/*    */ 
/*    */ import java.util.concurrent.atomic.AtomicReference;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AtomicSafeInitializer<T>
/*    */   implements ConcurrentInitializer<T>
/*    */ {
/* 58 */   private final AtomicReference<AtomicSafeInitializer<T>> factory = new AtomicReference<>();
/*    */ 
/*    */ 
/*    */   
/* 62 */   private final AtomicReference<T> reference = new AtomicReference<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final T get() throws ConcurrentException {
/*    */     T t;
/* 75 */     while ((t = this.reference.get()) == null) {
/* 76 */       if (this.factory.compareAndSet(null, this)) {
/* 77 */         this.reference.set(initialize());
/*    */       }
/*    */     } 
/*    */     
/* 81 */     return t;
/*    */   }
/*    */   
/*    */   protected abstract T initialize() throws ConcurrentException;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\concurrent\AtomicSafeInitializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */