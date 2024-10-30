/*     */ package org.apache.commons.lang3.concurrent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class LazyInitializer<T>
/*     */   implements ConcurrentInitializer<T>
/*     */ {
/*  82 */   private static final Object NO_INIT = new Object();
/*     */   
/*  84 */   private volatile T object = (T)NO_INIT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public T get() throws ConcurrentException {
/* 100 */     T t = this.object;
/*     */     
/* 102 */     if (t == NO_INIT) {
/* 103 */       synchronized (this) {
/* 104 */         t = this.object;
/* 105 */         if (t == NO_INIT) {
/* 106 */           this.object = t = initialize();
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 111 */     return t;
/*     */   }
/*     */   
/*     */   protected abstract T initialize() throws ConcurrentException;
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\concurrent\LazyInitializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */