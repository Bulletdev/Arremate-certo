/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.d.bd;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.concurrent.RejectedExecutionException;
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
/*     */ @b
/*     */ final class t<V>
/*     */   extends i<Object, V>
/*     */ {
/*     */   private c<?> a;
/*     */   
/*     */   t(bd<? extends U<?>> parambd, boolean paramBoolean, Executor paramExecutor, k<V> paramk) {
/*  40 */     super(parambd, paramBoolean, false);
/*  41 */     this.a = new a(this, paramk, paramExecutor);
/*  42 */     init();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   t(bd<? extends U<?>> parambd, boolean paramBoolean, Executor paramExecutor, Callable<V> paramCallable) {
/*  50 */     super(parambd, paramBoolean, false);
/*  51 */     this.a = new b(this, paramCallable, paramExecutor);
/*  52 */     init();
/*     */   }
/*     */ 
/*     */   
/*     */   void c(int paramInt, Object paramObject) {}
/*     */ 
/*     */   
/*     */   void fQ() {
/*  60 */     c<?> c1 = this.a;
/*  61 */     if (c1 != null) {
/*  62 */       c1.execute();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   void a(i.a parama) {
/*  68 */     super.a(parama);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  76 */     if (parama == i.a.a) {
/*  77 */       this.a = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void fF() {
/*  83 */     c<?> c1 = this.a;
/*  84 */     if (c1 != null)
/*  85 */       c1.fF(); 
/*     */   }
/*     */   
/*     */   private abstract class c<T>
/*     */     extends S<T>
/*     */   {
/*     */     private final Executor c;
/*     */     
/*     */     c(t this$0, Executor param1Executor) {
/*  94 */       this.c = (Executor)D.checkNotNull(param1Executor);
/*     */     }
/*     */ 
/*     */     
/*     */     final boolean isDone() {
/*  99 */       return this.a.isDone();
/*     */     }
/*     */     
/*     */     final void execute() {
/*     */       try {
/* 104 */         this.c.execute(this);
/* 105 */       } catch (RejectedExecutionException rejectedExecutionException) {
/* 106 */         this.a.a(rejectedExecutionException);
/*     */       } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     final void a(T param1T, Throwable param1Throwable) {
/* 123 */       t.a(this.a, (c)null);
/*     */       
/* 125 */       if (param1Throwable != null) {
/* 126 */         if (param1Throwable instanceof java.util.concurrent.ExecutionException) {
/* 127 */           this.a.a(param1Throwable.getCause());
/* 128 */         } else if (param1Throwable instanceof java.util.concurrent.CancellationException) {
/* 129 */           this.a.cancel(false);
/*     */         } else {
/* 131 */           this.a.a(param1Throwable);
/*     */         } 
/*     */       } else {
/* 134 */         setValue(param1T);
/*     */       } 
/*     */     }
/*     */     
/*     */     abstract void setValue(T param1T);
/*     */   }
/*     */   
/*     */   private final class a
/*     */     extends c<U<V>>
/*     */   {
/*     */     private final k<V> a;
/*     */     
/*     */     a(t this$0, k<V> param1k, Executor param1Executor) {
/* 147 */       super(this$0, param1Executor);
/* 148 */       this.a = (t)D.checkNotNull(param1k);
/*     */     }
/*     */ 
/*     */     
/*     */     U<V> c() throws Exception {
/* 153 */       U u = this.a.a();
/* 154 */       return (U<V>)D.a(u, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.a);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void b(U<V> param1U) {
/* 163 */       this.a.a(param1U);
/*     */     }
/*     */ 
/*     */     
/*     */     String dv() {
/* 168 */       return this.a.toString();
/*     */     }
/*     */   }
/*     */   
/*     */   private final class b
/*     */     extends c<V> {
/*     */     private final Callable<V> callable;
/*     */     
/*     */     b(t this$0, Callable<V> param1Callable, Executor param1Executor) {
/* 177 */       super(this$0, param1Executor);
/* 178 */       this.callable = (Callable<V>)D.checkNotNull(param1Callable);
/*     */     }
/*     */ 
/*     */     
/*     */     V F() throws Exception {
/* 183 */       return this.callable.call();
/*     */     }
/*     */ 
/*     */     
/*     */     void setValue(V param1V) {
/* 188 */       this.a.c(param1V);
/*     */     }
/*     */ 
/*     */     
/*     */     String dv() {
/* 193 */       return this.callable.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\t.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */