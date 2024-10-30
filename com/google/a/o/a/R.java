/*      */ package com.google.a.o.a;
/*      */ 
/*      */ import com.google.a.a.a;
/*      */ import com.google.a.b.D;
/*      */ import com.google.a.b.s;
/*      */ import com.google.a.b.u;
/*      */ import com.google.a.b.x;
/*      */ import com.google.a.d.ap;
/*      */ import com.google.a.d.bS;
/*      */ import com.google.a.d.bh;
/*      */ import com.google.b.a.f;
/*      */ import java.io.Closeable;
/*      */ import java.util.IdentityHashMap;
/*      */ import java.util.Map;
/*      */ import java.util.concurrent.Callable;
/*      */ import java.util.concurrent.CountDownLatch;
/*      */ import java.util.concurrent.ExecutionException;
/*      */ import java.util.concurrent.Executor;
/*      */ import java.util.concurrent.RejectedExecutionException;
/*      */ import java.util.concurrent.atomic.AtomicReference;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @f("Use ClosingFuture.from(Futures.immediate*Future)")
/*      */ @a
/*      */ public final class r<V>
/*      */ {
/*  196 */   private static final Logger logger = Logger.getLogger(r.class.getName());
/*      */ 
/*      */   
/*      */   public static final class j
/*      */   {
/*      */     @com.google.c.a.h
/*      */     private final r.b b;
/*      */ 
/*      */     
/*      */     j(r.b param1b) {
/*  206 */       this.b = param1b;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @com.google.b.a.a
/*      */     public <C extends AutoCloseable> C a(C param1C, Executor param1Executor) {
/*  235 */       D.checkNotNull(param1Executor);
/*  236 */       if (param1C != null) {
/*  237 */         this.b.c((AutoCloseable)param1C, param1Executor);
/*      */       }
/*  239 */       return param1C;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class m<V>
/*      */   {
/*      */     private final r<? extends V> h;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     m(r<? extends V> param1r) {
/*  312 */       this.h = (r<? extends V>)D.checkNotNull(param1r);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public V get() throws ExecutionException {
/*  327 */       return L.b(r.a(this.h));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void fT() {
/*  341 */       r.a(this.h);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <V> r<V> a(c<V> paramc, Executor paramExecutor) {
/*  366 */     return new r<>(paramc, paramExecutor);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <V> r<V> a(U<V> paramU) {
/*  379 */     return new r<>(paramU);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static <C extends AutoCloseable> r<C> a(U<C> paramU, Executor paramExecutor) {
/*  407 */     D.checkNotNull(paramExecutor);
/*  408 */     r<C> r1 = new r(L.a(paramU));
/*  409 */     L.a(paramU, (K)new K<AutoCloseable>(r1, paramExecutor)
/*      */         {
/*      */           
/*      */           public void a(AutoCloseable param1AutoCloseable)
/*      */           {
/*  414 */             r.b.a(r.a(this.a)).a(param1AutoCloseable, this.b);
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           public void f(Throwable param1Throwable) {}
/*  420 */         }ab.b());
/*  421 */     return r1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static e a(Iterable<? extends r<?>> paramIterable) {
/*  431 */     return new e(false, paramIterable);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static e a(r<?> paramr, r<?>... paramVarArgs) {
/*  442 */     return a(bS.a(paramr, (Object[])paramVarArgs));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static e b(Iterable<? extends r<?>> paramIterable) {
/*  453 */     return new e(true, paramIterable);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <V1, V2> f<V1, V2> a(r<V1> paramr, r<V2> paramr1) {
/*  468 */     return new f<>(paramr, paramr1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <V1, V2, V3> g<V1, V2, V3> a(r<V1> paramr, r<V2> paramr1, r<V3> paramr2) {
/*  483 */     return new g<>(paramr, paramr1, paramr2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <V1, V2, V3, V4> h<V1, V2, V3, V4> a(r<V1> paramr, r<V2> paramr1, r<V3> paramr2, r<V4> paramr3) {
/*  501 */     return new h<>(paramr, paramr1, paramr2, paramr3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <V1, V2, V3, V4, V5> i<V1, V2, V3, V4, V5> a(r<V1> paramr, r<V2> paramr1, r<V3> paramr2, r<V4> paramr3, r<V5> paramr4) {
/*  520 */     return new i<>(paramr, paramr1, paramr2, paramr3, paramr4);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static e a(r<?> paramr1, r<?> paramr2, r<?> paramr3, r<?> paramr4, r<?> paramr5, r<?> paramr6, r<?>... paramVarArgs) {
/*  538 */     return b(
/*  539 */         (Iterable<? extends r<?>>)ap.a(paramr1, (Object[])new r[] { paramr2, paramr3, paramr4, paramr5, paramr6
/*  540 */           }).b((Object[])paramVarArgs));
/*      */   }
/*      */   
/*  543 */   private final AtomicReference<l> state = new AtomicReference<>((l)l.a); private final b a;
/*  544 */   private final A<V> a = (A<V>)new b();
/*      */ 
/*      */   
/*      */   private r(U<V> paramU) {
/*  548 */     this.a = A.a(paramU);
/*      */   }
/*      */   
/*      */   private r(c<V> paramc, Executor paramExecutor) {
/*  552 */     D.checkNotNull(paramc);
/*      */     
/*  554 */     as<?> as = as.a(new Callable<V>(this, paramc)
/*      */         {
/*      */           public V call() throws Exception
/*      */           {
/*  558 */             return this.a.a(r.b.a(r.a(this.b)));
/*      */           }
/*      */ 
/*      */           
/*      */           public String toString() {
/*  563 */             return this.a.toString();
/*      */           }
/*      */         });
/*  566 */     paramExecutor.execute(as);
/*  567 */     this.a = (A)as;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public U<?> b() {
/*  582 */     return L.a(this.a.a(u.a(null), ab.b()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <U> r<U> a(d<? super V, U> paramd, Executor paramExecutor) {
/*  620 */     D.checkNotNull(paramd);
/*  621 */     l<V, U> l = new l<V, U>(this, paramd)
/*      */       {
/*      */         public U<U> a(V param1V) throws Exception
/*      */         {
/*  625 */           return r.a(this.b).a(this.a, param1V);
/*      */         }
/*      */ 
/*      */         
/*      */         public String toString() {
/*  630 */           return this.a.toString();
/*      */         }
/*      */       };
/*      */     
/*  634 */     return a(this.a.a(l, paramExecutor));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <U> r<U> a(a<? super V, U> parama, Executor paramExecutor) {
/*  714 */     D.checkNotNull(parama);
/*  715 */     l<V, U> l = new l<V, U>(this, parama)
/*      */       {
/*      */         public U<U> a(V param1V) throws Exception
/*      */         {
/*  719 */           return r.a(this.b).a(this.a, param1V);
/*      */         }
/*      */ 
/*      */         
/*      */         public String toString() {
/*  724 */           return this.a.toString();
/*      */         }
/*      */       };
/*  727 */     return a(this.a.a(l, paramExecutor));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <V, U> a<V, U> a(l<V, U> paraml) {
/*  758 */     D.checkNotNull(paraml);
/*  759 */     return new a<V, U>(paraml)
/*      */       {
/*      */         public r<U> a(r.j param1j, V param1V) throws Exception {
/*  762 */           return r.a(this.a.a(param1V));
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <X extends Throwable> r<V> a(Class<X> paramClass, d<? super X, ? extends V> paramd, Executor paramExecutor) {
/*  810 */     return b(paramClass, paramd, paramExecutor);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private <X extends Throwable, W extends V> r<V> b(Class<X> paramClass, d<? super X, W> paramd, Executor paramExecutor) {
/*  816 */     D.checkNotNull(paramd);
/*  817 */     l<X, W> l = new l<X, W>(this, paramd)
/*      */       {
/*      */         public U<W> b(X param1X) throws Exception
/*      */         {
/*  821 */           return r.a(this.b).a((r.d<? super X, W>)this.b, param1X);
/*      */         }
/*      */ 
/*      */         
/*      */         public String toString() {
/*  826 */           return this.b.toString();
/*      */         }
/*      */       };
/*      */     
/*  830 */     return a(this.a.a(paramClass, l, paramExecutor));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <X extends Throwable> r<V> a(Class<X> paramClass, a<? super X, ? extends V> parama, Executor paramExecutor) {
/*  907 */     return b(paramClass, parama, paramExecutor);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private <X extends Throwable, W extends V> r<V> b(Class<X> paramClass, a<? super X, W> parama, Executor paramExecutor) {
/*  915 */     D.checkNotNull(parama);
/*  916 */     l<X, W> l = new l<X, W>(this, parama)
/*      */       {
/*      */         public U<W> b(X param1X) throws Exception
/*      */         {
/*  920 */           return r.a(this.b).a((r.a<X, W>)this.b, param1X);
/*      */         }
/*      */ 
/*      */         
/*      */         public String toString() {
/*  925 */           return this.b.toString();
/*      */         }
/*      */       };
/*  928 */     return a(this.a.a(paramClass, l, paramExecutor));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public A<V> a() {
/*  943 */     if (a((l)l.a, l.c)) {
/*  944 */       logger.log(Level.FINER, "will close {0}", this);
/*  945 */       this.a.a(new Runnable(this)
/*      */           {
/*      */             public void run()
/*      */             {
/*  949 */               r.a(this.b, r.l.c, r.l.d);
/*  950 */               r.a(this.b);
/*  951 */               r.a(this.b, r.l.d, r.l.e);
/*      */             }
/*  954 */           }ab.b());
/*      */     } else {
/*  956 */       switch (null.ae[((l)this.state.get()).ordinal()]) {
/*      */         case 1:
/*  958 */           throw new IllegalStateException("Cannot call finishToFuture() after deriving another step");
/*      */ 
/*      */         
/*      */         case 2:
/*  962 */           throw new IllegalStateException("Cannot call finishToFuture() after calling finishToValueAndCloser()");
/*      */ 
/*      */         
/*      */         case 3:
/*      */         case 4:
/*      */         case 5:
/*  968 */           throw new IllegalStateException("Cannot call finishToFuture() twice");
/*      */         
/*      */         case 6:
/*  971 */           throw new AssertionError();
/*      */       } 
/*      */     } 
/*  974 */     return this.a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(n<? super V> paramn, Executor paramExecutor) {
/*  990 */     D.checkNotNull(paramn);
/*  991 */     if (!a((l)l.a, l.f)) {
/*  992 */       switch (null.ae[((l)this.state.get()).ordinal()]) {
/*      */         case 1:
/*  994 */           throw new IllegalStateException("Cannot call finishToValueAndCloser() after deriving another step");
/*      */ 
/*      */         
/*      */         case 3:
/*      */         case 4:
/*      */         case 5:
/* 1000 */           throw new IllegalStateException("Cannot call finishToValueAndCloser() after calling finishToFuture()");
/*      */ 
/*      */         
/*      */         case 2:
/* 1004 */           throw new IllegalStateException("Cannot call finishToValueAndCloser() twice");
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1009 */       throw new AssertionError(this.state);
/*      */     } 
/* 1011 */     this.a.a(new Runnable(this, paramn)
/*      */         {
/*      */           public void run()
/*      */           {
/* 1015 */             r.b(this.a, this.b);
/*      */           }
/*      */         }paramExecutor);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static <C, V extends C> void a(n<C> paramn, r<V> paramr) {
/* 1023 */     paramn.a(new m<>(paramr));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.b.a.a
/*      */   public boolean cancel(boolean paramBoolean) {
/* 1044 */     logger.log(Level.FINER, "cancelling {0}", this);
/* 1045 */     boolean bool = this.a.cancel(paramBoolean);
/* 1046 */     if (bool) {
/* 1047 */       close();
/*      */     }
/* 1049 */     return bool;
/*      */   }
/*      */   
/*      */   private void close() {
/* 1053 */     logger.log(Level.FINER, "closing {0}", this);
/* 1054 */     this.a.close();
/*      */   }
/*      */   
/*      */   private <U> r<U> a(A<U> paramA) {
/* 1058 */     r<U> r1 = new r(paramA);
/* 1059 */     a((b)r1.a);
/* 1060 */     return r1;
/*      */   }
/*      */   
/*      */   private void a(b paramb) {
/* 1064 */     a((l)l.a, l.b);
/* 1065 */     paramb.c((AutoCloseable)this.a, ab.b());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class k
/*      */   {
/*      */     private final bh<r<?>> x;
/*      */ 
/*      */     
/*      */     private volatile boolean bo;
/*      */ 
/*      */     
/*      */     private k(bh<r<?>> param1bh) {
/* 1079 */       this.x = (bh<r<?>>)D.checkNotNull(param1bh);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final <D> D a(r<D> param1r) throws ExecutionException {
/* 1095 */       D.ab(this.bo);
/* 1096 */       D.checkArgument(this.x.contains(param1r));
/* 1097 */       return L.b(r.a(param1r));
/*      */     }
/*      */ 
/*      */     
/*      */     private <V> V a(r.e.b<V> param1b, r.b param1b1) throws Exception {
/* 1102 */       this.bo = true;
/* 1103 */       r.b b1 = new r.b();
/*      */       try {
/* 1105 */         return param1b.a(r.b.a(b1), this);
/*      */       } finally {
/* 1107 */         param1b1.c(b1, ab.b());
/* 1108 */         this.bo = false;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     private <V> A<V> a(r.e.a<V> param1a, r.b param1b) throws Exception {
/* 1114 */       this.bo = true;
/* 1115 */       r.b b1 = new r.b();
/*      */       try {
/* 1117 */         r<V> r = param1a.a(r.b.a(b1), this);
/* 1118 */         r.a(r, param1b);
/* 1119 */         return r.a(r);
/*      */       } finally {
/* 1121 */         param1b.c(b1, ab.b());
/* 1122 */         this.bo = false;
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @f("Use ClosingFuture.whenAllSucceed() or .whenAllComplete() instead.")
/*      */   public static class e
/*      */   {
/* 1155 */     private final r.b a = new r.b();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final boolean bm;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected final bh<r<?>> w;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private e(boolean param1Boolean, Iterable<? extends r<?>> param1Iterable) {
/* 1201 */       this.bm = param1Boolean;
/* 1202 */       this.w = bh.b(param1Iterable);
/* 1203 */       for (r<?> r : param1Iterable) {
/* 1204 */         r.a(r, this.a);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public <V> r<V> a(b<V> param1b, Executor param1Executor) {
/* 1224 */       Callable<V> callable = new Callable<V>(this, param1b)
/*      */         {
/*      */           public V call() throws Exception
/*      */           {
/* 1228 */             return (V)r.k.a(new r.k(this.a.w), (r.e.b)this.a, r.e.a(this.a));
/*      */           }
/*      */ 
/*      */           
/*      */           public String toString() {
/* 1233 */             return this.a.toString();
/*      */           }
/*      */         };
/* 1236 */       r<V> r = new r(a().b(callable, param1Executor));
/* 1237 */       r.a(r).c(this.a, ab.b());
/* 1238 */       return r;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public <V> r<V> a(a<V> param1a, Executor param1Executor) {
/* 1280 */       k<V> k = new k<V>(this, param1a)
/*      */         {
/*      */           public U<V> a() throws Exception
/*      */           {
/* 1284 */             return r.k.a(new r.k(this.a.w), (r.e.a)this.a, r.e.a(this.a));
/*      */           }
/*      */ 
/*      */           
/*      */           public String toString() {
/* 1289 */             return this.a.toString();
/*      */           }
/*      */         };
/*      */       
/* 1293 */       r<V> r = new r(a().b(k, param1Executor));
/* 1294 */       r.a(r).c(this.a, ab.b());
/* 1295 */       return r;
/*      */     }
/*      */     
/*      */     private L.b<Object> a() {
/* 1299 */       return this.bm ? 
/* 1300 */         L.<Object>b((Iterable)p()) : 
/* 1301 */         L.<Object>a((Iterable)p());
/*      */     }
/*      */     
/* 1304 */     private static final s<r<?>, A<?>> m = new s<r<?>, A<?>>()
/*      */       {
/*      */         public A<?> b(r<?> param2r)
/*      */         {
/* 1308 */           return r.a(param2r);
/*      */         }
/*      */       };
/*      */     
/*      */     private bh<A<?>> p() {
/* 1313 */       return ap.a((Iterable)this.w).a(m).d();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @FunctionalInterface
/*      */     public static interface b<V>
/*      */     {
/*      */       V a(r.j param2j, r.k param2k) throws Exception;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @FunctionalInterface
/*      */     public static interface a<V>
/*      */     {
/*      */       r<V> a(r.j param2j, r.k param2k) throws Exception;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class f<V1, V2>
/*      */     extends e
/*      */   {
/*      */     private final r<V1> c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final r<V2> d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private f(r<V1> param1r, r<V2> param1r1) {
/* 1378 */       super(true, (Iterable)bh.a(param1r, param1r1));
/* 1379 */       this.c = param1r;
/* 1380 */       this.d = param1r1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public <U> r<U> a(b<V1, V2, U> param1b, Executor param1Executor) {
/* 1398 */       return a(new r.e.b<U>(this, param1b)
/*      */           {
/*      */             public U a(r.j param2j, r.k param2k) throws Exception
/*      */             {
/* 1402 */               return (U)this.a.a(param2j, param2k.a(r.f.a(this.a)), param2k.a(r.f.b(this.a)));
/*      */             }
/*      */ 
/*      */             
/*      */             public String toString() {
/* 1407 */               return this.a.toString();
/*      */             }
/*      */           }param1Executor);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public <U> r<U> a(a<V1, V2, U> param1a, Executor param1Executor) {
/* 1451 */       return a(new r.e.a<U>(this, param1a)
/*      */           {
/*      */             public r<U> a(r.j param2j, r.k param2k) throws Exception
/*      */             {
/* 1455 */               return this.a.a(param2j, param2k.a(r.f.a(this.a)), param2k.a(r.f.b(this.a)));
/*      */             }
/*      */ 
/*      */             
/*      */             public String toString() {
/* 1460 */               return this.a.toString();
/*      */             }
/*      */           }param1Executor);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @FunctionalInterface
/*      */     public static interface b<V1, V2, U>
/*      */     {
/*      */       U a(r.j param2j, V1 param2V1, V2 param2V2) throws Exception;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @FunctionalInterface
/*      */     public static interface a<V1, V2, U>
/*      */     {
/*      */       r<U> a(r.j param2j, V1 param2V1, V2 param2V2) throws Exception;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class g<V1, V2, V3>
/*      */     extends e
/*      */   {
/*      */     private final r<V1> c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final r<V2> d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final r<V3> e;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private g(r<V1> param1r, r<V2> param1r1, r<V3> param1r2) {
/* 1538 */       super(true, (Iterable)bh.a(param1r, param1r1, param1r2));
/* 1539 */       this.c = param1r;
/* 1540 */       this.d = param1r1;
/* 1541 */       this.e = param1r2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public <U> r<U> a(b<V1, V2, V3, U> param1b, Executor param1Executor) {
/* 1559 */       return a(new r.e.b<U>(this, param1b)
/*      */           {
/*      */             public U a(r.j param2j, r.k param2k) throws Exception
/*      */             {
/* 1563 */               return (U)this.a.a(param2j, param2k
/*      */                   
/* 1565 */                   .a(r.g.a(this.a)), param2k
/* 1566 */                   .a(r.g.b(this.a)), param2k
/* 1567 */                   .a(r.g.c(this.a)));
/*      */             }
/*      */ 
/*      */             
/*      */             public String toString() {
/* 1572 */               return this.a.toString();
/*      */             }
/*      */           }param1Executor);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public <U> r<U> a(a<V1, V2, V3, U> param1a, Executor param1Executor) {
/* 1616 */       return a(new r.e.a<U>(this, param1a)
/*      */           {
/*      */             public r<U> a(r.j param2j, r.k param2k) throws Exception
/*      */             {
/* 1620 */               return this.a.a(param2j, param2k
/*      */                   
/* 1622 */                   .a(r.g.a(this.a)), param2k
/* 1623 */                   .a(r.g.b(this.a)), param2k
/* 1624 */                   .a(r.g.c(this.a)));
/*      */             }
/*      */ 
/*      */             
/*      */             public String toString() {
/* 1629 */               return this.a.toString();
/*      */             }
/*      */           }param1Executor);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @FunctionalInterface
/*      */     public static interface b<V1, V2, V3, U>
/*      */     {
/*      */       U a(r.j param2j, V1 param2V1, V2 param2V2, V3 param2V3) throws Exception;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @FunctionalInterface
/*      */     public static interface a<V1, V2, V3, U>
/*      */     {
/*      */       r<U> a(r.j param2j, V1 param2V1, V2 param2V2, V3 param2V3) throws Exception;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class h<V1, V2, V3, V4>
/*      */     extends e
/*      */   {
/*      */     private final r<V1> c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final r<V2> d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final r<V3> e;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final r<V4> f;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private h(r<V1> param1r, r<V2> param1r1, r<V3> param1r2, r<V4> param1r3) {
/* 1720 */       super(true, (Iterable)bh.a(param1r, param1r1, param1r2, param1r3));
/* 1721 */       this.c = param1r;
/* 1722 */       this.d = param1r1;
/* 1723 */       this.e = param1r2;
/* 1724 */       this.f = param1r3;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public <U> r<U> a(b<V1, V2, V3, V4, U> param1b, Executor param1Executor) {
/* 1742 */       return a(new r.e.b<U>(this, param1b)
/*      */           {
/*      */             public U a(r.j param2j, r.k param2k) throws Exception
/*      */             {
/* 1746 */               return (U)this.a.a(param2j, param2k
/*      */                   
/* 1748 */                   .a(r.h.a(this.a)), param2k
/* 1749 */                   .a(r.h.b(this.a)), param2k
/* 1750 */                   .a(r.h.c(this.a)), param2k
/* 1751 */                   .a(r.h.d(this.a)));
/*      */             }
/*      */ 
/*      */             
/*      */             public String toString() {
/* 1756 */               return this.a.toString();
/*      */             }
/*      */           }param1Executor);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public <U> r<U> a(a<V1, V2, V3, V4, U> param1a, Executor param1Executor) {
/* 1800 */       return a(new r.e.a<U>(this, param1a)
/*      */           {
/*      */             public r<U> a(r.j param2j, r.k param2k) throws Exception
/*      */             {
/* 1804 */               return this.a.a(param2j, param2k
/*      */                   
/* 1806 */                   .a(r.h.a(this.a)), param2k
/* 1807 */                   .a(r.h.b(this.a)), param2k
/* 1808 */                   .a(r.h.c(this.a)), param2k
/* 1809 */                   .a(r.h.d(this.a)));
/*      */             }
/*      */ 
/*      */             
/*      */             public String toString() {
/* 1814 */               return this.a.toString();
/*      */             }
/*      */           }param1Executor);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @FunctionalInterface
/*      */     public static interface b<V1, V2, V3, V4, U>
/*      */     {
/*      */       U a(r.j param2j, V1 param2V1, V2 param2V2, V3 param2V3, V4 param2V4) throws Exception;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @FunctionalInterface
/*      */     public static interface a<V1, V2, V3, V4, U>
/*      */     {
/*      */       r<U> a(r.j param2j, V1 param2V1, V2 param2V2, V3 param2V3, V4 param2V4) throws Exception;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final class i<V1, V2, V3, V4, V5>
/*      */     extends e
/*      */   {
/*      */     private final r<V1> c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final r<V2> d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final r<V3> e;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final r<V4> f;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final r<V5> g;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private i(r<V1> param1r, r<V2> param1r1, r<V3> param1r2, r<V4> param1r3, r<V5> param1r4) {
/* 1916 */       super(true, (Iterable)bh.a(param1r, param1r1, param1r2, param1r3, param1r4));
/* 1917 */       this.c = param1r;
/* 1918 */       this.d = param1r1;
/* 1919 */       this.e = param1r2;
/* 1920 */       this.f = param1r3;
/* 1921 */       this.g = param1r4;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public <U> r<U> a(b<V1, V2, V3, V4, V5, U> param1b, Executor param1Executor) {
/* 1940 */       return a(new r.e.b<U>(this, param1b)
/*      */           {
/*      */             public U a(r.j param2j, r.k param2k) throws Exception
/*      */             {
/* 1944 */               return (U)this.a.a(param2j, param2k
/*      */                   
/* 1946 */                   .a(r.i.a(this.a)), param2k
/* 1947 */                   .a(r.i.b(this.a)), param2k
/* 1948 */                   .a(r.i.c(this.a)), param2k
/* 1949 */                   .a(r.i.d(this.a)), param2k
/* 1950 */                   .a(r.i.e(this.a)));
/*      */             }
/*      */ 
/*      */             
/*      */             public String toString() {
/* 1955 */               return this.a.toString();
/*      */             }
/*      */           }param1Executor);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public <U> r<U> a(a<V1, V2, V3, V4, V5, U> param1a, Executor param1Executor) {
/* 2000 */       return a(new r.e.a<U>(this, param1a)
/*      */           {
/*      */             public r<U> a(r.j param2j, r.k param2k) throws Exception
/*      */             {
/* 2004 */               return this.a.a(param2j, param2k
/*      */                   
/* 2006 */                   .a(r.i.a(this.a)), param2k
/* 2007 */                   .a(r.i.b(this.a)), param2k
/* 2008 */                   .a(r.i.c(this.a)), param2k
/* 2009 */                   .a(r.i.d(this.a)), param2k
/* 2010 */                   .a(r.i.e(this.a)));
/*      */             }
/*      */ 
/*      */             
/*      */             public String toString() {
/* 2015 */               return this.a.toString();
/*      */             }
/*      */           }param1Executor);
/*      */     } @FunctionalInterface
/*      */     public static interface b<V1, V2, V3, V4, V5, U> {
/*      */       U a(r.j param2j, V1 param2V1, V2 param2V2, V3 param2V3, V4 param2V4, V5 param2V5) throws Exception; }
/*      */     @FunctionalInterface
/*      */     public static interface a<V1, V2, V3, V4, V5, U> { r<U> a(r.j param2j, V1 param2V1, V2 param2V2, V3 param2V3, V4 param2V4, V5 param2V5) throws Exception; }
/*      */   }
/*      */   public String toString() {
/* 2025 */     return x.a(this).a("state", this.state.get()).b(this.a).toString();
/*      */   }
/*      */ 
/*      */   
/*      */   protected void finalize() {
/* 2030 */     if (((l)this.state.get()).equals(l.a)) {
/* 2031 */       logger.log(Level.SEVERE, "Uh oh! An open ClosingFuture has leaked and will close: {0}", this);
/* 2032 */       A<V> a = a();
/*      */     } 
/*      */   }
/*      */   
/*      */   private static void a(AutoCloseable paramAutoCloseable, Executor paramExecutor) {
/* 2037 */     if (paramAutoCloseable == null) {
/*      */       return;
/*      */     }
/*      */     try {
/* 2041 */       paramExecutor.execute(new Runnable(paramAutoCloseable)
/*      */           {
/*      */             public void run()
/*      */             {
/*      */               try {
/* 2046 */                 this.a.close();
/* 2047 */               } catch (Exception exception) {
/* 2048 */                 r.c().log(Level.WARNING, "thrown by close()", exception);
/*      */               } 
/*      */             }
/*      */           });
/* 2052 */     } catch (RejectedExecutionException rejectedExecutionException) {
/* 2053 */       if (logger.isLoggable(Level.WARNING)) {
/* 2054 */         logger.log(Level.WARNING, 
/* 2055 */             String.format("while submitting close to %s; will close inline", new Object[] { paramExecutor }), rejectedExecutionException);
/*      */       }
/* 2057 */       a(paramAutoCloseable, ab.b());
/*      */     } 
/*      */   }
/*      */   
/*      */   private void a(l paraml1, l paraml2) {
/* 2062 */     D.b(
/* 2063 */         a(paraml1, paraml2), "Expected state to be %s, but it was %s", paraml1, paraml2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean a(l paraml1, l paraml2) {
/* 2070 */     return this.state.compareAndSet(paraml1, paraml2);
/*      */   }
/*      */   
/*      */   private static final class b extends IdentityHashMap<AutoCloseable, Executor> implements Closeable {
/*      */     private final r.j a;
/*      */     private volatile boolean closed;
/* 2076 */     private volatile CountDownLatch a = (CountDownLatch)new r.j(this);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     <V, U> U<U> a(r.d<? super V, U> param1d, V param1V) throws Exception {
/* 2083 */       b b1 = new b();
/*      */       try {
/* 2085 */         return (U)L.b(param1d.a((r.j)b1.a, param1V));
/*      */       } finally {
/* 2087 */         c(b1, ab.b());
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     <V, U> A<U> a(r.a<V, U> param1a, V param1V) throws Exception {
/* 2094 */       b b1 = new b();
/*      */       try {
/* 2096 */         r<U> r = param1a.a((r.j)b1.a, param1V);
/* 2097 */         r.a(r, b1);
/* 2098 */         return r.a(r);
/*      */       } finally {
/* 2100 */         c(b1, ab.b());
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public void close() {
/* 2106 */       if (this.closed) {
/*      */         return;
/*      */       }
/* 2109 */       synchronized (this) {
/* 2110 */         if (this.closed) {
/*      */           return;
/*      */         }
/* 2113 */         this.closed = true;
/*      */       } 
/* 2115 */       for (Map.Entry<AutoCloseable, Executor> entry : entrySet()) {
/* 2116 */         r.b((AutoCloseable)entry.getKey(), (Executor)entry.getValue());
/*      */       }
/* 2118 */       clear();
/* 2119 */       if (this.a != null) {
/* 2120 */         this.a.countDown();
/*      */       }
/*      */     }
/*      */     
/*      */     void c(AutoCloseable param1AutoCloseable, Executor param1Executor) {
/* 2125 */       D.checkNotNull(param1Executor);
/* 2126 */       if (param1AutoCloseable == null) {
/*      */         return;
/*      */       }
/* 2129 */       synchronized (this) {
/* 2130 */         if (!this.closed) {
/* 2131 */           put(param1AutoCloseable, param1Executor);
/*      */           return;
/*      */         } 
/*      */       } 
/* 2135 */       r.b(param1AutoCloseable, param1Executor);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     CountDownLatch a() {
/* 2142 */       if (this.closed) {
/* 2143 */         return new CountDownLatch(0);
/*      */       }
/* 2145 */       synchronized (this) {
/* 2146 */         if (this.closed) {
/* 2147 */           return new CountDownLatch(0);
/*      */         }
/* 2149 */         D.ab((this.a == null));
/* 2150 */         return this.a = new CountDownLatch(1);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     private b() {}
/*      */   }
/*      */ 
/*      */   
/*      */   @com.google.a.a.d
/*      */   CountDownLatch a() {
/* 2161 */     return this.a.a();
/*      */   }
/*      */ 
/*      */   
/*      */   enum l
/*      */   {
/* 2167 */     a,
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2173 */     b,
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2179 */     c,
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2185 */     d,
/*      */ 
/*      */     
/* 2188 */     e,
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2194 */     f;
/*      */   }
/*      */   
/*      */   @FunctionalInterface
/*      */   public static interface n<V> {
/*      */     void a(r.m<V> param1m);
/*      */   }
/*      */   
/*      */   @FunctionalInterface
/*      */   public static interface a<T, U> {
/*      */     r<U> a(r.j param1j, T param1T) throws Exception;
/*      */   }
/*      */   
/*      */   @FunctionalInterface
/*      */   public static interface d<T, U> {
/*      */     U a(r.j param1j, T param1T) throws Exception;
/*      */   }
/*      */   
/*      */   @FunctionalInterface
/*      */   public static interface c<V> {
/*      */     V a(r.j param1j) throws Exception;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\r.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */