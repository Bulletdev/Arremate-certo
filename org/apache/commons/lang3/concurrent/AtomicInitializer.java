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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class AtomicInitializer<T>
/*    */   implements ConcurrentInitializer<T>
/*    */ {
/* 68 */   private final AtomicReference<T> reference = new AtomicReference<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public T get() throws ConcurrentException {
/* 81 */     T t = this.reference.get();
/*    */     
/* 83 */     if (t == null) {
/* 84 */       t = initialize();
/* 85 */       if (!this.reference.compareAndSet(null, t))
/*    */       {
/* 87 */         t = this.reference.get();
/*    */       }
/*    */     } 
/*    */     
/* 91 */     return t;
/*    */   }
/*    */   
/*    */   protected abstract T initialize() throws ConcurrentException;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\concurrent\AtomicInitializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */