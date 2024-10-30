/*    */ package com.google.a.o.a;
/*    */ 
/*    */ import com.google.a.a.a;
/*    */ import com.google.a.a.c;
/*    */ import com.google.b.a.a;
/*    */ import java.util.concurrent.AbstractExecutorService;
/*    */ import java.util.concurrent.Callable;
/*    */ import java.util.concurrent.Future;
/*    */ import java.util.concurrent.RunnableFuture;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @a
/*    */ @a
/*    */ @c
/*    */ public abstract class e
/*    */   extends AbstractExecutorService
/*    */   implements Y
/*    */ {
/*    */   protected final <T> RunnableFuture<T> newTaskFor(Runnable paramRunnable, T paramT) {
/* 45 */     return as.a(paramRunnable, paramT);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected final <T> RunnableFuture<T> newTaskFor(Callable<T> paramCallable) {
/* 51 */     return as.a(paramCallable);
/*    */   }
/*    */ 
/*    */   
/*    */   public U<?> a(Runnable paramRunnable) {
/* 56 */     return (U)super.submit(paramRunnable);
/*    */   }
/*    */ 
/*    */   
/*    */   public <T> U<T> a(Runnable paramRunnable, T paramT) {
/* 61 */     return (U<T>)super.<T>submit(paramRunnable, paramT);
/*    */   }
/*    */ 
/*    */   
/*    */   public <T> U<T> a(Callable<T> paramCallable) {
/* 66 */     return (U<T>)super.<T>submit(paramCallable);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */