/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.RunnableFuture;
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
/*     */ @b
/*     */ class as<V>
/*     */   extends A.a<V>
/*     */   implements RunnableFuture<V>
/*     */ {
/*     */   private volatile S<?> a;
/*     */   
/*     */   static <V> as<V> a(k<V> paramk) {
/*  37 */     return new as<>(paramk);
/*     */   }
/*     */   
/*     */   static <V> as<V> a(Callable<V> paramCallable) {
/*  41 */     return new as<>(paramCallable);
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
/*     */   static <V> as<V> a(Runnable paramRunnable, V paramV) {
/*  54 */     return new as<>(Executors.callable(paramRunnable, paramV));
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
/*     */   as(Callable<V> paramCallable) {
/*  67 */     this.a = new b(this, paramCallable);
/*     */   }
/*     */   
/*     */   as(k<V> paramk) {
/*  71 */     this.a = new a(this, paramk);
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*  76 */     S<?> s = this.a;
/*  77 */     if (s != null) {
/*  78 */       s.run();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  84 */     this.a = null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void fx() {
/*  89 */     super.fx();
/*     */     
/*  91 */     if (dw()) {
/*  92 */       S<?> s = this.a;
/*  93 */       if (s != null) {
/*  94 */         s.fF();
/*     */       }
/*     */     } 
/*     */     
/*  98 */     this.a = null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String ds() {
/* 103 */     S<?> s = this.a;
/* 104 */     if (s != null) {
/* 105 */       String str = String.valueOf(s); return (new StringBuilder(7 + String.valueOf(str).length())).append("task=[").append(str).append("]").toString();
/*     */     } 
/* 107 */     return super.ds();
/*     */   }
/*     */   
/*     */   private final class b
/*     */     extends S<V> {
/*     */     private final Callable<V> callable;
/*     */     
/*     */     b(as this$0, Callable<V> param1Callable) {
/* 115 */       this.callable = (Callable<V>)D.checkNotNull(param1Callable);
/*     */     }
/*     */ 
/*     */     
/*     */     final boolean isDone() {
/* 120 */       return this.b.isDone();
/*     */     }
/*     */ 
/*     */     
/*     */     V F() throws Exception {
/* 125 */       return this.callable.call();
/*     */     }
/*     */ 
/*     */     
/*     */     void a(V param1V, Throwable param1Throwable) {
/* 130 */       if (param1Throwable == null) {
/* 131 */         this.b.c(param1V);
/*     */       } else {
/* 133 */         this.b.a(param1Throwable);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     String dv() {
/* 139 */       return this.callable.toString();
/*     */     }
/*     */   }
/*     */   
/*     */   private final class a
/*     */     extends S<U<V>>
/*     */   {
/*     */     private final k<V> a;
/*     */     
/*     */     a(as this$0, k<V> param1k) {
/* 149 */       this.a = (k<V>)D.checkNotNull(param1k);
/*     */     }
/*     */ 
/*     */     
/*     */     final boolean isDone() {
/* 154 */       return this.b.isDone();
/*     */     }
/*     */ 
/*     */     
/*     */     U<V> c() throws Exception {
/* 159 */       return (U<V>)D.a(this.a
/* 160 */           .a(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.a);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void a(U<V> param1U, Throwable param1Throwable) {
/* 168 */       if (param1Throwable == null) {
/* 169 */         this.b.a(param1U);
/*     */       } else {
/* 171 */         this.b.a(param1Throwable);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     String dv() {
/* 177 */       return this.a.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\as.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */