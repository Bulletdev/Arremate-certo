/*    */ package com.google.a.o.a;
/*    */ 
/*    */ import com.google.a.a.c;
/*    */ import com.google.b.a.a;
/*    */ import java.util.concurrent.Callable;
/*    */ import java.util.concurrent.ScheduledExecutorService;
/*    */ import java.util.concurrent.ScheduledFuture;
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
/*    */ @a
/*    */ @c
/*    */ abstract class ay
/*    */   extends ax
/*    */   implements ScheduledExecutorService
/*    */ {
/*    */   final ScheduledExecutorService h;
/*    */   
/*    */   protected ay(ScheduledExecutorService paramScheduledExecutorService) {
/* 39 */     super(paramScheduledExecutorService);
/* 40 */     this.h = paramScheduledExecutorService;
/*    */   }
/*    */ 
/*    */   
/*    */   public final ScheduledFuture<?> schedule(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit) {
/* 45 */     return this.h.schedule(a(paramRunnable), paramLong, paramTimeUnit);
/*    */   }
/*    */ 
/*    */   
/*    */   public final <V> ScheduledFuture<V> schedule(Callable<V> paramCallable, long paramLong, TimeUnit paramTimeUnit) {
/* 50 */     return this.h.schedule(a(paramCallable), paramLong, paramTimeUnit);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final ScheduledFuture<?> scheduleAtFixedRate(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit) {
/* 56 */     return this.h.scheduleAtFixedRate(a(paramRunnable), paramLong1, paramLong2, paramTimeUnit);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final ScheduledFuture<?> scheduleWithFixedDelay(Runnable paramRunnable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit) {
/* 62 */     return this.h.scheduleWithFixedDelay(a(paramRunnable), paramLong1, paramLong2, paramTimeUnit);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\ay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */