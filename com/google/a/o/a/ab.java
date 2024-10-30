/*      */ package com.google.a.o.a;
/*      */ 
/*      */ import com.google.a.a.b;
/*      */ import com.google.a.b.D;
/*      */ import com.google.a.b.M;
/*      */ import com.google.a.b.O;
/*      */ import com.google.a.d.bS;
/*      */ import com.google.a.d.cm;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.time.Duration;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.List;
/*      */ import java.util.concurrent.BlockingQueue;
/*      */ import java.util.concurrent.Callable;
/*      */ import java.util.concurrent.Delayed;
/*      */ import java.util.concurrent.ExecutionException;
/*      */ import java.util.concurrent.Executor;
/*      */ import java.util.concurrent.ExecutorService;
/*      */ import java.util.concurrent.Executors;
/*      */ import java.util.concurrent.Future;
/*      */ import java.util.concurrent.LinkedBlockingQueue;
/*      */ import java.util.concurrent.RejectedExecutionException;
/*      */ import java.util.concurrent.ScheduledExecutorService;
/*      */ import java.util.concurrent.ScheduledFuture;
/*      */ import java.util.concurrent.ScheduledThreadPoolExecutor;
/*      */ import java.util.concurrent.ThreadFactory;
/*      */ import java.util.concurrent.ThreadPoolExecutor;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import java.util.concurrent.TimeoutException;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @b(cl = true)
/*      */ public final class ab
/*      */ {
/*      */   @com.google.a.a.a
/*      */   @com.google.a.a.c
/*      */   public static ExecutorService a(ThreadPoolExecutor paramThreadPoolExecutor, Duration paramDuration) {
/*   85 */     return a(paramThreadPoolExecutor, 
/*   86 */         R.a(paramDuration), TimeUnit.NANOSECONDS);
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
/*      */   @com.google.a.a.a
/*      */   @com.google.a.a.c
/*      */   public static ExecutorService a(ThreadPoolExecutor paramThreadPoolExecutor, long paramLong, TimeUnit paramTimeUnit) {
/*  107 */     return (new a()).a(paramThreadPoolExecutor, paramLong, paramTimeUnit);
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
/*      */   @com.google.a.a.a
/*      */   @com.google.a.a.c
/*      */   public static ExecutorService a(ThreadPoolExecutor paramThreadPoolExecutor) {
/*  126 */     return (new a()).a(paramThreadPoolExecutor);
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
/*      */   @com.google.a.a.a
/*      */   @com.google.a.a.c
/*      */   public static ScheduledExecutorService a(ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor, Duration paramDuration) {
/*  146 */     return a(paramScheduledThreadPoolExecutor, 
/*  147 */         R.a(paramDuration), TimeUnit.NANOSECONDS);
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
/*      */   @com.google.a.a.a
/*      */   @com.google.a.a.c
/*      */   public static ScheduledExecutorService a(ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor, long paramLong, TimeUnit paramTimeUnit) {
/*  168 */     return (new a())
/*  169 */       .a(paramScheduledThreadPoolExecutor, paramLong, paramTimeUnit);
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
/*      */   @com.google.a.a.a
/*      */   @com.google.a.a.c
/*      */   public static ScheduledExecutorService a(ScheduledThreadPoolExecutor paramScheduledThreadPoolExecutor) {
/*  189 */     return (new a()).a(paramScheduledThreadPoolExecutor);
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
/*      */   @com.google.a.a.a
/*      */   @com.google.a.a.c
/*      */   public static void a(ExecutorService paramExecutorService, Duration paramDuration) {
/*  206 */     a(paramExecutorService, R.a(paramDuration), TimeUnit.NANOSECONDS);
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
/*      */   @com.google.a.a.a
/*      */   @com.google.a.a.c
/*      */   public static void a(ExecutorService paramExecutorService, long paramLong, TimeUnit paramTimeUnit) {
/*  225 */     (new a()).a(paramExecutorService, paramLong, paramTimeUnit);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.c
/*      */   @com.google.a.a.d
/*      */   static class a
/*      */   {
/*      */     final ExecutorService a(ThreadPoolExecutor param1ThreadPoolExecutor, long param1Long, TimeUnit param1TimeUnit) {
/*  235 */       ab.b(param1ThreadPoolExecutor);
/*  236 */       ExecutorService executorService = Executors.unconfigurableExecutorService(param1ThreadPoolExecutor);
/*  237 */       a(param1ThreadPoolExecutor, param1Long, param1TimeUnit);
/*  238 */       return executorService;
/*      */     }
/*      */     
/*      */     final ExecutorService a(ThreadPoolExecutor param1ThreadPoolExecutor) {
/*  242 */       return a(param1ThreadPoolExecutor, 120L, TimeUnit.SECONDS);
/*      */     }
/*      */ 
/*      */     
/*      */     final ScheduledExecutorService a(ScheduledThreadPoolExecutor param1ScheduledThreadPoolExecutor, long param1Long, TimeUnit param1TimeUnit) {
/*  247 */       ab.b(param1ScheduledThreadPoolExecutor);
/*  248 */       ScheduledExecutorService scheduledExecutorService = Executors.unconfigurableScheduledExecutorService(param1ScheduledThreadPoolExecutor);
/*  249 */       a(param1ScheduledThreadPoolExecutor, param1Long, param1TimeUnit);
/*  250 */       return scheduledExecutorService;
/*      */     }
/*      */ 
/*      */     
/*      */     final ScheduledExecutorService a(ScheduledThreadPoolExecutor param1ScheduledThreadPoolExecutor) {
/*  255 */       return a(param1ScheduledThreadPoolExecutor, 120L, TimeUnit.SECONDS);
/*      */     }
/*      */ 
/*      */     
/*      */     final void a(ExecutorService param1ExecutorService, long param1Long, TimeUnit param1TimeUnit) {
/*  260 */       D.checkNotNull(param1ExecutorService);
/*  261 */       D.checkNotNull(param1TimeUnit);
/*  262 */       String str = String.valueOf(param1ExecutorService); a(
/*  263 */           ab.a((new StringBuilder(24 + String.valueOf(str).length())).append("DelayedShutdownHook-for-").append(str).toString(), new Runnable(this, param1ExecutorService, param1Long, param1TimeUnit)
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*      */               public void run()
/*      */               {
/*      */                 try {
/*  274 */                   this.i.shutdown();
/*  275 */                   this.i.awaitTermination(this.bA, this.e);
/*  276 */                 } catch (InterruptedException interruptedException) {}
/*      */               }
/*      */             }));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     @com.google.a.a.d
/*      */     void a(Thread param1Thread) {
/*  285 */       Runtime.getRuntime().addShutdownHook(param1Thread);
/*      */     }
/*      */   }
/*      */   
/*      */   @com.google.a.a.c
/*      */   private static void a(ThreadPoolExecutor paramThreadPoolExecutor) {
/*  291 */     paramThreadPoolExecutor.setThreadFactory((new ap())
/*      */         
/*  293 */         .a(true)
/*  294 */         .a(paramThreadPoolExecutor.getThreadFactory())
/*  295 */         .b());
/*      */   }
/*      */   
/*      */   @com.google.a.a.c
/*      */   private static final class b
/*      */     extends e
/*      */   {
/*  302 */     private final Object lock = new Object();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @com.google.b.a.a.a("lock")
/*  311 */     private int gs = 0;
/*      */ 
/*      */     
/*      */     @com.google.b.a.a.a("lock")
/*      */     private boolean shutdown = false;
/*      */ 
/*      */     
/*      */     public void execute(Runnable param1Runnable) {
/*  319 */       ga();
/*      */       try {
/*  321 */         param1Runnable.run();
/*      */       } finally {
/*  323 */         gb();
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isShutdown() {
/*  329 */       synchronized (this.lock) {
/*  330 */         return this.shutdown;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public void shutdown() {
/*  336 */       synchronized (this.lock) {
/*  337 */         this.shutdown = true;
/*  338 */         if (this.gs == 0) {
/*  339 */           this.lock.notifyAll();
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public List<Runnable> shutdownNow() {
/*  347 */       shutdown();
/*  348 */       return Collections.emptyList();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isTerminated() {
/*  353 */       synchronized (this.lock) {
/*  354 */         return (this.shutdown && this.gs == 0);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean awaitTermination(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException {
/*  360 */       long l = param1TimeUnit.toNanos(param1Long);
/*  361 */       synchronized (this.lock) {
/*      */         while (true) {
/*  363 */           if (this.shutdown && this.gs == 0)
/*  364 */             return true; 
/*  365 */           if (l <= 0L) {
/*  366 */             return false;
/*      */           }
/*  368 */           long l1 = System.nanoTime();
/*  369 */           TimeUnit.NANOSECONDS.timedWait(this.lock, l);
/*  370 */           l -= System.nanoTime() - l1;
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void ga() {
/*  382 */       synchronized (this.lock) {
/*  383 */         if (this.shutdown) {
/*  384 */           throw new RejectedExecutionException("Executor already shutdown");
/*      */         }
/*  386 */         this.gs++;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     private void gb() {
/*  392 */       synchronized (this.lock) {
/*  393 */         int i = --this.gs;
/*  394 */         if (i == 0) {
/*  395 */           this.lock.notifyAll();
/*      */         }
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
/*      */     private b() {}
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
/*      */   @com.google.a.a.c
/*      */   public static Y b() {
/*  429 */     return new b();
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
/*      */   public static Executor b() {
/*  479 */     return (Executor)v.a;
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
/*      */   @com.google.a.a.a
/*      */   @com.google.a.a.c
/*      */   public static Executor a(Executor paramExecutor) {
/*  526 */     return new ah(paramExecutor);
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
/*      */   @com.google.a.a.c
/*      */   public static Y a(ExecutorService paramExecutorService) {
/*  546 */     return (paramExecutorService instanceof Y) ? 
/*  547 */       (Y)paramExecutorService : (
/*  548 */       (paramExecutorService instanceof ScheduledExecutorService) ? 
/*  549 */       new d((ScheduledExecutorService)paramExecutorService) : 
/*  550 */       new c(paramExecutorService));
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
/*      */   @com.google.a.a.c
/*      */   public static Z a(ScheduledExecutorService paramScheduledExecutorService) {
/*  572 */     return (paramScheduledExecutorService instanceof Z) ? 
/*  573 */       (Z)paramScheduledExecutorService : 
/*  574 */       new d(paramScheduledExecutorService);
/*      */   }
/*      */   
/*      */   @com.google.a.a.c
/*      */   private static class c extends e {
/*      */     private final ExecutorService j;
/*      */     
/*      */     c(ExecutorService param1ExecutorService) {
/*  582 */       this.j = (ExecutorService)D.checkNotNull(param1ExecutorService);
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean awaitTermination(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException {
/*  587 */       return this.j.awaitTermination(param1Long, param1TimeUnit);
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean isShutdown() {
/*  592 */       return this.j.isShutdown();
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean isTerminated() {
/*  597 */       return this.j.isTerminated();
/*      */     }
/*      */ 
/*      */     
/*      */     public final void shutdown() {
/*  602 */       this.j.shutdown();
/*      */     }
/*      */ 
/*      */     
/*      */     public final List<Runnable> shutdownNow() {
/*  607 */       return this.j.shutdownNow();
/*      */     }
/*      */ 
/*      */     
/*      */     public final void execute(Runnable param1Runnable) {
/*  612 */       this.j.execute(param1Runnable);
/*      */     }
/*      */   }
/*      */   
/*      */   @com.google.a.a.c
/*      */   private static final class d
/*      */     extends c
/*      */     implements Z {
/*      */     final ScheduledExecutorService h;
/*      */     
/*      */     d(ScheduledExecutorService param1ScheduledExecutorService) {
/*  623 */       super(param1ScheduledExecutorService);
/*  624 */       this.h = (ScheduledExecutorService)D.checkNotNull(param1ScheduledExecutorService);
/*      */     }
/*      */ 
/*      */     
/*      */     public W<?> a(Runnable param1Runnable, long param1Long, TimeUnit param1TimeUnit) {
/*  629 */       as<?> as = as.a(param1Runnable, null);
/*  630 */       ScheduledFuture<?> scheduledFuture = this.h.schedule(as, param1Long, param1TimeUnit);
/*  631 */       return new a(as, scheduledFuture);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public <V> W<V> a(Callable<V> param1Callable, long param1Long, TimeUnit param1TimeUnit) {
/*  637 */       as<V> as = as.a(param1Callable);
/*  638 */       ScheduledFuture<?> scheduledFuture = this.h.schedule(as, param1Long, param1TimeUnit);
/*  639 */       return new a<>(as, scheduledFuture);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public W<?> a(Runnable param1Runnable, long param1Long1, long param1Long2, TimeUnit param1TimeUnit) {
/*  645 */       b b = new b(param1Runnable);
/*  646 */       ScheduledFuture<?> scheduledFuture = this.h.scheduleAtFixedRate(b, param1Long1, param1Long2, param1TimeUnit);
/*  647 */       return new a(b, scheduledFuture);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public W<?> b(Runnable param1Runnable, long param1Long1, long param1Long2, TimeUnit param1TimeUnit) {
/*  653 */       b b = new b(param1Runnable);
/*      */       
/*  655 */       ScheduledFuture<?> scheduledFuture = this.h.scheduleWithFixedDelay(b, param1Long1, param1Long2, param1TimeUnit);
/*  656 */       return new a(b, scheduledFuture);
/*      */     }
/*      */     
/*      */     private static final class a<V>
/*      */       extends H.a<V>
/*      */       implements W<V>
/*      */     {
/*      */       private final ScheduledFuture<?> b;
/*      */       
/*      */       public a(U<V> param2U, ScheduledFuture<?> param2ScheduledFuture) {
/*  666 */         super(param2U);
/*  667 */         this.b = param2ScheduledFuture;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean cancel(boolean param2Boolean) {
/*  672 */         boolean bool = super.cancel(param2Boolean);
/*  673 */         if (bool)
/*      */         {
/*  675 */           this.b.cancel(param2Boolean);
/*      */         }
/*      */ 
/*      */         
/*  679 */         return bool;
/*      */       }
/*      */ 
/*      */       
/*      */       public long getDelay(TimeUnit param2TimeUnit) {
/*  684 */         return this.b.getDelay(param2TimeUnit);
/*      */       }
/*      */ 
/*      */       
/*      */       public int a(Delayed param2Delayed) {
/*  689 */         return this.b.compareTo(param2Delayed);
/*      */       }
/*      */     }
/*      */     
/*      */     @com.google.a.a.c
/*      */     private static final class b
/*      */       extends c.i<Void> implements Runnable {
/*      */       private final Runnable l;
/*      */       
/*      */       public b(Runnable param2Runnable) {
/*  699 */         this.l = (Runnable)D.checkNotNull(param2Runnable);
/*      */       }
/*      */ 
/*      */       
/*      */       public void run() {
/*      */         try {
/*  705 */           this.l.run();
/*  706 */         } catch (Throwable throwable) {
/*  707 */           a(throwable);
/*  708 */           throw O.a(throwable);
/*      */         } 
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
/*      */   @com.google.a.a.c
/*      */   static <T> T a(Y paramY, Collection<? extends Callable<T>> paramCollection, boolean paramBoolean, Duration paramDuration) throws InterruptedException, ExecutionException, TimeoutException {
/*  735 */     return a(paramY, paramCollection, paramBoolean, 
/*  736 */         R.a(paramDuration), TimeUnit.NANOSECONDS);
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
/*      */   @com.google.a.a.c
/*      */   static <T> T a(Y paramY, Collection<? extends Callable<T>> paramCollection, boolean paramBoolean, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
/*  751 */     D.checkNotNull(paramY);
/*  752 */     D.checkNotNull(paramTimeUnit);
/*  753 */     int i = paramCollection.size();
/*  754 */     D.checkArgument((i > 0));
/*  755 */     ArrayList arrayList = bS.a(i);
/*  756 */     LinkedBlockingQueue<Future<?>> linkedBlockingQueue = cm.a();
/*  757 */     long l = paramTimeUnit.toNanos(paramLong);
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
/*      */   @com.google.a.a.c
/*      */   private static <T> U<T> a(Y paramY, Callable<T> paramCallable, BlockingQueue<Future<T>> paramBlockingQueue) {
/*  828 */     U<T> u = paramY.a(paramCallable);
/*  829 */     u.a(new Runnable(paramBlockingQueue, u)
/*      */         {
/*      */           public void run()
/*      */           {
/*  833 */             this.b.add(this.d);
/*      */           }
/*  836 */         }b());
/*  837 */     return u;
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
/*      */   @com.google.a.a.a
/*      */   @com.google.a.a.c
/*      */   public static ThreadFactory a() {
/*  853 */     if (!dG()) {
/*  854 */       return Executors.defaultThreadFactory();
/*      */     }
/*      */     try {
/*  857 */       return 
/*  858 */         (ThreadFactory)Class.forName("com.google.appengine.api.ThreadManager")
/*  859 */         .getMethod("currentRequestThreadFactory", new Class[0])
/*  860 */         .invoke(null, new Object[0]);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*  866 */     catch (IllegalAccessException illegalAccessException) {
/*  867 */       throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", illegalAccessException);
/*  868 */     } catch (ClassNotFoundException classNotFoundException) {
/*  869 */       throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", classNotFoundException);
/*  870 */     } catch (NoSuchMethodException noSuchMethodException) {
/*  871 */       throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", noSuchMethodException);
/*  872 */     } catch (InvocationTargetException invocationTargetException) {
/*  873 */       throw O.a(invocationTargetException.getCause());
/*      */     } 
/*      */   }
/*      */   
/*      */   @com.google.a.a.c
/*      */   private static boolean dG() {
/*  879 */     if (System.getProperty("com.google.appengine.runtime.environment") == null) {
/*  880 */       return false;
/*      */     }
/*      */     try {
/*  883 */       Class.forName("com.google.appengine.api.utils.SystemProperty");
/*  884 */     } catch (ClassNotFoundException classNotFoundException) {
/*  885 */       return false;
/*      */     } 
/*      */     
/*      */     try {
/*  889 */       return 
/*      */         
/*  891 */         (Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke(null, new Object[0]) != null);
/*      */     }
/*  893 */     catch (ClassNotFoundException classNotFoundException) {
/*      */       
/*  895 */       return false;
/*  896 */     } catch (InvocationTargetException invocationTargetException) {
/*      */       
/*  898 */       return false;
/*  899 */     } catch (IllegalAccessException illegalAccessException) {
/*      */       
/*  901 */       return false;
/*  902 */     } catch (NoSuchMethodException noSuchMethodException) {
/*      */       
/*  904 */       return false;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.c
/*      */   static Thread a(String paramString, Runnable paramRunnable) {
/*  914 */     D.checkNotNull(paramString);
/*  915 */     D.checkNotNull(paramRunnable);
/*  916 */     Thread thread = a().newThread(paramRunnable);
/*      */     try {
/*  918 */       thread.setName(paramString);
/*  919 */     } catch (SecurityException securityException) {}
/*      */ 
/*      */     
/*  922 */     return thread;
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
/*      */   @com.google.a.a.c
/*      */   static Executor a(Executor paramExecutor, M<String> paramM) {
/*  942 */     D.checkNotNull(paramExecutor);
/*  943 */     D.checkNotNull(paramM);
/*  944 */     return new Executor(paramExecutor, paramM)
/*      */       {
/*      */         public void execute(Runnable param1Runnable) {
/*  947 */           this.a.execute(q.a(param1Runnable, this.j));
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
/*      */   @com.google.a.a.c
/*      */   static ExecutorService a(ExecutorService paramExecutorService, M<String> paramM) {
/*  967 */     D.checkNotNull(paramExecutorService);
/*  968 */     D.checkNotNull(paramM);
/*  969 */     return new ax(paramExecutorService, paramM)
/*      */       {
/*      */         protected <T> Callable<T> a(Callable<T> param1Callable) {
/*  972 */           return q.a(param1Callable, this.j);
/*      */         }
/*      */ 
/*      */         
/*      */         protected Runnable a(Runnable param1Runnable) {
/*  977 */           return q.a(param1Runnable, this.j);
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
/*      */   @com.google.a.a.c
/*      */   static ScheduledExecutorService a(ScheduledExecutorService paramScheduledExecutorService, M<String> paramM) {
/*  997 */     D.checkNotNull(paramScheduledExecutorService);
/*  998 */     D.checkNotNull(paramM);
/*  999 */     return new ay(paramScheduledExecutorService, paramM)
/*      */       {
/*      */         protected <T> Callable<T> a(Callable<T> param1Callable) {
/* 1002 */           return q.a(param1Callable, this.j);
/*      */         }
/*      */ 
/*      */         
/*      */         protected Runnable a(Runnable param1Runnable) {
/* 1007 */           return q.a(param1Runnable, this.j);
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
/*      */   @com.google.a.a.a
/*      */   @com.google.b.a.a
/*      */   @com.google.a.a.c
/*      */   public static boolean a(ExecutorService paramExecutorService, Duration paramDuration) {
/* 1039 */     return a(paramExecutorService, R.a(paramDuration), TimeUnit.NANOSECONDS);
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
/*      */   @com.google.a.a.a
/*      */   @com.google.b.a.a
/*      */   @com.google.a.a.c
/*      */   public static boolean a(ExecutorService paramExecutorService, long paramLong, TimeUnit paramTimeUnit) {
/* 1072 */     long l = paramTimeUnit.toNanos(paramLong) / 2L;
/*      */     
/* 1074 */     paramExecutorService.shutdown();
/*      */     
/*      */     try {
/* 1077 */       if (!paramExecutorService.awaitTermination(l, TimeUnit.NANOSECONDS)) {
/*      */         
/* 1079 */         paramExecutorService.shutdownNow();
/*      */         
/* 1081 */         paramExecutorService.awaitTermination(l, TimeUnit.NANOSECONDS);
/*      */       } 
/* 1083 */     } catch (InterruptedException interruptedException) {
/*      */       
/* 1085 */       Thread.currentThread().interrupt();
/*      */       
/* 1087 */       paramExecutorService.shutdownNow();
/*      */     } 
/* 1089 */     return paramExecutorService.isTerminated();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static Executor a(Executor paramExecutor, c<?> paramc) {
/* 1100 */     D.checkNotNull(paramExecutor);
/* 1101 */     D.checkNotNull(paramc);
/* 1102 */     if (paramExecutor == b())
/*      */     {
/* 1104 */       return paramExecutor;
/*      */     }
/* 1106 */     return new Executor(paramExecutor, paramc)
/*      */       {
/*      */         public void execute(Runnable param1Runnable) {
/*      */           try {
/* 1110 */             this.h.execute(param1Runnable);
/* 1111 */           } catch (RejectedExecutionException rejectedExecutionException) {
/* 1112 */             this.b.a(rejectedExecutionException);
/*      */           } 
/*      */         }
/*      */       };
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\ab.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */