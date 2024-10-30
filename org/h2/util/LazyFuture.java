/*     */ package org.h2.util;
/*     */ 
/*     */ import java.util.concurrent.CancellationException;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.h2.message.DbException;
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
/*     */ public abstract class LazyFuture<T>
/*     */   implements Future<T>
/*     */ {
/*     */   private static final int S_READY = 0;
/*     */   private static final int S_DONE = 1;
/*     */   private static final int S_ERROR = 2;
/*     */   private static final int S_CANCELED = 3;
/*  27 */   private int state = 0;
/*     */ 
/*     */   
/*     */   private T result;
/*     */ 
/*     */   
/*     */   private Exception error;
/*     */ 
/*     */   
/*     */   public boolean reset() {
/*  37 */     if (this.state == 0) {
/*  38 */       return false;
/*     */     }
/*  40 */     this.state = 0;
/*  41 */     this.result = null;
/*  42 */     this.error = null;
/*  43 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract T run() throws Exception;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean cancel(boolean paramBoolean) {
/*  55 */     if (this.state != 0) {
/*  56 */       return false;
/*     */     }
/*  58 */     this.state = 3;
/*  59 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public T get() throws InterruptedException, ExecutionException {
/*  64 */     switch (this.state) {
/*     */       case 0:
/*     */         try {
/*  67 */           this.result = run();
/*  68 */           this.state = 1;
/*  69 */         } catch (Exception exception) {
/*  70 */           this.error = exception;
/*  71 */           if (exception instanceof InterruptedException) {
/*  72 */             throw (InterruptedException)exception;
/*     */           }
/*  74 */           throw new ExecutionException(exception);
/*     */         } finally {
/*  76 */           if (this.state != 1) {
/*  77 */             this.state = 2;
/*     */           }
/*     */         } 
/*  80 */         return this.result;
/*     */       case 1:
/*  82 */         return this.result;
/*     */       case 2:
/*  84 */         throw new ExecutionException(this.error);
/*     */       case 3:
/*  86 */         throw new CancellationException();
/*     */     } 
/*  88 */     throw DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T get(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, ExecutionException {
/*  94 */     return get();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCancelled() {
/*  99 */     return (this.state == 3);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDone() {
/* 104 */     return (this.state != 0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\LazyFuture.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */