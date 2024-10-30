/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.b.D;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.concurrent.atomic.AtomicReference;
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
/*     */ @a
/*     */ public final class y
/*     */ {
/*     */   public static y a() {
/*  87 */     return new y();
/*     */   }
/*     */ 
/*     */   
/*  91 */   private final AtomicReference<U<Void>> b = new AtomicReference<>(
/*  92 */       L.e());
/*     */   
/*  94 */   private c a = new c();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class c
/*     */   {
/*     */     Thread thread;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Runnable g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Executor e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private c() {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> U<T> a(Callable<T> paramCallable, Executor paramExecutor) {
/* 140 */     D.checkNotNull(paramCallable);
/* 141 */     D.checkNotNull(paramExecutor);
/* 142 */     return a(new k<T>(this, paramCallable)
/*     */         {
/*     */           public U<T> a() throws Exception
/*     */           {
/* 146 */             return L.b(this.d.call());
/*     */           }
/*     */ 
/*     */           
/*     */           public String toString() {
/* 151 */             return this.d.toString();
/*     */           }
/*     */         }paramExecutor);
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
/*     */   public <T> U<T> a(k<T> paramk, Executor paramExecutor) {
/* 166 */     D.checkNotNull(paramk);
/* 167 */     D.checkNotNull(paramExecutor);
/* 168 */     b b = new b(paramExecutor, this);
/* 169 */     k<T> k1 = new k<T>(this, b, paramk)
/*     */       {
/*     */         public U<T> a() throws Exception
/*     */         {
/* 173 */           if (!y.b.a(this.a)) {
/* 174 */             return L.f();
/*     */           }
/* 176 */           return this.b.a();
/*     */         }
/*     */ 
/*     */         
/*     */         public String toString() {
/* 181 */           return this.b.toString();
/*     */         }
/*     */       };
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
/* 195 */     al<?> al = al.a();
/*     */     
/* 197 */     U u = (U)this.b.getAndSet(al);
/*     */ 
/*     */     
/* 200 */     as<T> as = as.a(k1);
/* 201 */     u.a(as, b);
/*     */     
/* 203 */     U<T> u1 = L.a(as);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 209 */     Runnable runnable = new Runnable(this, as, al, u, u1, b)
/*     */       {
/*     */         public void run()
/*     */         {
/* 213 */           if (this.a.isDone()) {
/*     */ 
/*     */ 
/*     */             
/* 217 */             this.b.a(this.e);
/* 218 */           } else if (this.f.isCancelled() && y.b.b(this.a)) {
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
/* 245 */             this.a.cancel(false);
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 252 */     u1.a(runnable, ab.b());
/* 253 */     as.a(runnable, ab.b());
/*     */     
/* 255 */     return u1;
/*     */   }
/*     */   
/*     */   enum a {
/* 259 */     a,
/* 260 */     b,
/* 261 */     c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class b
/*     */     extends AtomicReference<a>
/*     */     implements Runnable, Executor
/*     */   {
/*     */     y a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Executor d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Runnable c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Thread c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private b(Executor param1Executor, y param1y) {
/* 308 */       super((y.a)y.a.a);
/* 309 */       this.d = param1Executor;
/* 310 */       this.a = param1y;
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
/*     */     public void execute(Runnable param1Runnable) {
/* 324 */       if (get() == y.a.b) {
/* 325 */         this.d = null;
/* 326 */         this.a = null;
/*     */         return;
/*     */       } 
/* 329 */       this.c = Thread.currentThread();
/*     */       try {
/* 331 */         y.c c = y.a(this.a);
/* 332 */         if (c.thread == this.c) {
/* 333 */           this.a = null;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 338 */           D.ab((c.g == null));
/* 339 */           c.g = param1Runnable;
/* 340 */           c.e = this.d;
/* 341 */           this.d = null;
/*     */         } else {
/* 343 */           Executor executor = this.d;
/* 344 */           this.d = null;
/* 345 */           this.c = (Thread)param1Runnable;
/* 346 */           executor.execute(this);
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */       finally {
/*     */         
/* 353 */         this.c = null;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void run() {
/* 360 */       Thread thread = Thread.currentThread();
/* 361 */       if (thread != this.c) {
/* 362 */         Thread thread1 = this.c;
/* 363 */         this.c = null;
/* 364 */         thread1.run();
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 370 */       y.c c = new y.c();
/* 371 */       c.thread = thread;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 381 */       y.a(this.a, c);
/* 382 */       this.a = null;
/*     */       try {
/* 384 */         Thread thread1 = this.c;
/* 385 */         this.c = null;
/* 386 */         thread1.run();
/*     */         
/*     */         while (true) {
/*     */           Runnable runnable;
/*     */           Executor executor;
/* 391 */           if (((((runnable = c.g) != null) ? 1 : 0) & (((executor = c.e) != null) ? 1 : 0)) != 0) {
/*     */             
/* 393 */             c.g = null;
/* 394 */             c.e = null;
/* 395 */             executor.execute(runnable);
/*     */ 
/*     */             
/*     */             continue;
/*     */           } 
/*     */           
/*     */           break;
/*     */         } 
/*     */       } finally {
/* 404 */         c.thread = null;
/*     */       } 
/*     */     }
/*     */     
/*     */     private boolean dA() {
/* 409 */       return compareAndSet((y.a)y.a.a, y.a.c);
/*     */     }
/*     */     
/*     */     private boolean dB() {
/* 413 */       return compareAndSet((y.a)y.a.a, y.a.b);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\y.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */