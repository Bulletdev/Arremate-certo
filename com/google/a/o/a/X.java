/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
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
/*     */ @c
/*     */ public final class x
/*     */ {
/*  45 */   private static final Logger a = Logger.getLogger(x.class.getName());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a.a("this")
/*     */   private a a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a.a("this")
/*     */   private boolean executed;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void c(Runnable paramRunnable, Executor paramExecutor) {
/*  71 */     D.b(paramRunnable, "Runnable was null.");
/*  72 */     D.b(paramExecutor, "Executor was null.");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  77 */     synchronized (this) {
/*  78 */       if (!this.executed) {
/*  79 */         this.a = new a(paramRunnable, paramExecutor, this.a);
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  87 */     b(paramRunnable, paramExecutor);
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
/*     */   public void execute() {
/*     */     a a1;
/* 105 */     synchronized (this) {
/* 106 */       if (this.executed) {
/*     */         return;
/*     */       }
/* 109 */       this.executed = true;
/* 110 */       a1 = this.a;
/* 111 */       this.a = null;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 122 */     a a2 = null;
/* 123 */     while (a1 != null) {
/* 124 */       a a3 = a1;
/* 125 */       a1 = a1.b;
/* 126 */       a3.b = a2;
/* 127 */       a2 = a3;
/*     */     } 
/* 129 */     while (a2 != null) {
/* 130 */       b(a2.f, a2.executor);
/* 131 */       a2 = a2.b;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void b(Runnable paramRunnable, Executor paramExecutor) {
/*     */     try {
/* 141 */       paramExecutor.execute(paramRunnable);
/* 142 */     } catch (RuntimeException runtimeException) {
/*     */ 
/*     */ 
/*     */       
/* 146 */       String str1 = String.valueOf(paramRunnable), str2 = String.valueOf(paramExecutor); a.log(Level.SEVERE, (new StringBuilder(57 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("RuntimeException while executing runnable ").append(str1).append(" with executor ").append(str2).toString(), runtimeException);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class a
/*     */   {
/*     */     final Runnable f;
/*     */     
/*     */     final Executor executor;
/*     */     a b;
/*     */     
/*     */     a(Runnable param1Runnable, Executor param1Executor, a param1a) {
/* 159 */       this.f = param1Runnable;
/* 160 */       this.executor = param1Executor;
/* 161 */       this.b = param1a;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\x.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */