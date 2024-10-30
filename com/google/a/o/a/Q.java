/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.M;
/*     */ import java.util.concurrent.Callable;
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
/*     */ @b(cl = true)
/*     */ public final class q
/*     */ {
/*     */   public static <T> Callable<T> a(T paramT) {
/*  38 */     return new Callable<T>(paramT)
/*     */       {
/*     */         public T call() {
/*  41 */           return (T)this.D;
/*     */         }
/*     */       };
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
/*     */   @a
/*     */   @c
/*     */   public static <T> k<T> a(Callable<T> paramCallable, Y paramY) {
/*  58 */     D.checkNotNull(paramCallable);
/*  59 */     D.checkNotNull(paramY);
/*  60 */     return new k<T>(paramY, paramCallable)
/*     */       {
/*     */         public U<T> a() throws Exception {
/*  63 */           return this.a.a(this.d);
/*     */         }
/*     */       };
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
/*     */   @c
/*     */   static <T> Callable<T> a(Callable<T> paramCallable, M<String> paramM) {
/*  80 */     D.checkNotNull(paramM);
/*  81 */     D.checkNotNull(paramCallable);
/*  82 */     return new Callable<T>(paramM, paramCallable)
/*     */       {
/*     */         public T call() throws Exception {
/*  85 */           Thread thread = Thread.currentThread();
/*  86 */           String str = thread.getName();
/*  87 */           boolean bool = q.b((String)this.j.get(), thread);
/*     */           try {
/*  89 */             return (T)this.d.call();
/*     */           } finally {
/*  91 */             if (bool) {
/*  92 */               boolean bool1 = q.b(str, thread);
/*     */             }
/*     */           } 
/*     */         }
/*     */       };
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
/*     */   @c
/*     */   static Runnable a(Runnable paramRunnable, M<String> paramM) {
/* 110 */     D.checkNotNull(paramM);
/* 111 */     D.checkNotNull(paramRunnable);
/* 112 */     return new Runnable(paramM, paramRunnable)
/*     */       {
/*     */         public void run() {
/* 115 */           Thread thread = Thread.currentThread();
/* 116 */           String str = thread.getName();
/* 117 */           boolean bool = q.b((String)this.j.get(), thread);
/*     */           try {
/* 119 */             this.e.run();
/*     */           } finally {
/* 121 */             if (bool) {
/* 122 */               boolean bool1 = q.b(str, thread);
/*     */             }
/*     */           } 
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   private static boolean a(String paramString, Thread paramThread) {
/*     */     try {
/* 137 */       paramThread.setName(paramString);
/* 138 */       return true;
/* 139 */     } catch (SecurityException securityException) {
/* 140 */       return false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\q.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */