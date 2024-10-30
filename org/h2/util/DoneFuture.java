/*    */ package org.h2.util;
/*    */ 
/*    */ import java.util.concurrent.ExecutionException;
/*    */ import java.util.concurrent.Future;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import java.util.concurrent.TimeoutException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DoneFuture<T>
/*    */   implements Future<T>
/*    */ {
/*    */   final T x;
/*    */   
/*    */   public DoneFuture(T paramT) {
/* 23 */     this.x = paramT;
/*    */   }
/*    */ 
/*    */   
/*    */   public T get() throws InterruptedException, ExecutionException {
/* 28 */     return this.x;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public T get(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
/* 34 */     return this.x;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isDone() {
/* 39 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean cancel(boolean paramBoolean) {
/* 44 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isCancelled() {
/* 49 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 54 */     return "DoneFuture->" + this.x;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\DoneFuture.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */