/*    */ package com.google.a.o.a;
/*    */ 
/*    */ import com.google.a.a.a;
/*    */ import com.google.a.a.c;
/*    */ import com.google.a.b.D;
/*    */ import com.google.b.a.a;
/*    */ import java.util.concurrent.Callable;
/*    */ import java.util.concurrent.ExecutionException;
/*    */ import java.util.concurrent.TimeUnit;
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
/*    */ public final class z
/*    */   implements aq
/*    */ {
/*    */   public <T> T a(T paramT, Class<T> paramClass, long paramLong, TimeUnit paramTimeUnit) {
/* 43 */     D.checkNotNull(paramT);
/* 44 */     D.checkNotNull(paramClass);
/* 45 */     D.checkNotNull(paramTimeUnit);
/* 46 */     return paramT;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public <T> T a(Callable<T> paramCallable, long paramLong, TimeUnit paramTimeUnit) throws ExecutionException {
/* 52 */     D.checkNotNull(paramCallable);
/* 53 */     D.checkNotNull(paramTimeUnit);
/*    */     try {
/* 55 */       return paramCallable.call();
/* 56 */     } catch (RuntimeException runtimeException) {
/* 57 */       throw new au(runtimeException);
/* 58 */     } catch (Exception exception) {
/* 59 */       throw new ExecutionException(exception);
/* 60 */     } catch (Error error) {
/* 61 */       throw new w(error);
/* 62 */     } catch (Throwable throwable) {
/*    */ 
/*    */       
/* 65 */       throw new ExecutionException(throwable);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public <T> T b(Callable<T> paramCallable, long paramLong, TimeUnit paramTimeUnit) throws ExecutionException {
/* 72 */     return a(paramCallable, paramLong, paramTimeUnit);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit) {
/* 77 */     D.checkNotNull(paramRunnable);
/* 78 */     D.checkNotNull(paramTimeUnit);
/*    */     try {
/* 80 */       paramRunnable.run();
/* 81 */     } catch (RuntimeException runtimeException) {
/* 82 */       throw new au(runtimeException);
/* 83 */     } catch (Error error) {
/* 84 */       throw new w(error);
/* 85 */     } catch (Throwable throwable) {
/*    */ 
/*    */       
/* 88 */       throw new au(throwable);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void b(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit) {
/* 95 */     a(paramRunnable, paramLong, paramTimeUnit);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\z.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */