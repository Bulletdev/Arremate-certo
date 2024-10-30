/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.b.a.f;
/*     */ import java.time.Duration;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.TimeoutException;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @f("Create an AbstractIdleService")
/*     */ @c
/*     */ public interface ai
/*     */ {
/*     */   @com.google.b.a.a
/*     */   ai a();
/*     */   
/*     */   boolean isRunning();
/*     */   
/*     */   b a();
/*     */   
/*     */   @com.google.b.a.a
/*     */   ai b();
/*     */   
/*     */   void fB();
/*     */   
/*     */   default void a(Duration paramDuration) throws TimeoutException {
/* 112 */     a(R.a(paramDuration), TimeUnit.NANOSECONDS);
/*     */   }
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
/*     */   void a(long paramLong, TimeUnit paramTimeUnit) throws TimeoutException;
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
/*     */   void fC();
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
/*     */   default void b(Duration paramDuration) throws TimeoutException {
/* 148 */     b(R.a(paramDuration), TimeUnit.NANOSECONDS);
/*     */   }
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
/*     */   void b(long paramLong, TimeUnit paramTimeUnit) throws TimeoutException;
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
/*     */   Throwable a();
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
/*     */   void a(a parama, Executor paramExecutor);
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
/*     */   public enum b
/*     */   {
/* 209 */     c
/*     */     {
/*     */       boolean dH() {
/* 212 */         return false;
/*     */       }
/*     */     },
/*     */ 
/*     */     
/* 217 */     d
/*     */     {
/*     */       boolean dH() {
/* 220 */         return false;
/*     */       }
/*     */     },
/*     */ 
/*     */     
/* 225 */     e
/*     */     {
/*     */       boolean dH() {
/* 228 */         return false;
/*     */       }
/*     */     },
/*     */ 
/*     */     
/* 233 */     f
/*     */     {
/*     */       boolean dH() {
/* 236 */         return false;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 244 */     g
/*     */     {
/*     */       boolean dH() {
/* 247 */         return true;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 255 */     h
/*     */     {
/*     */       boolean dH() {
/* 258 */         return true;
/*     */       }
/*     */     };
/*     */     
/*     */     abstract boolean dH();
/*     */   }
/*     */   
/*     */   public static abstract class a {
/*     */     public void gd() {}
/*     */     
/*     */     public void ge() {}
/*     */     
/*     */     public void e(ai.b param1b) {}
/*     */     
/*     */     public void a(ai.b param1b) {}
/*     */     
/*     */     public void a(ai.b param1b, Throwable param1Throwable) {}
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\ai.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */