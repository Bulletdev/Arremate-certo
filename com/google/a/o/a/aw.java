/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.R;
/*     */ import com.google.b.a.a;
/*     */ import java.time.Duration;
/*     */ import java.util.concurrent.BlockingQueue;
/*     */ import java.util.concurrent.CountDownLatch;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.Semaphore;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.TimeoutException;
/*     */ import java.util.concurrent.locks.Condition;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class aw
/*     */ {
/*     */   @c
/*     */   public static void a(CountDownLatch paramCountDownLatch) {
/*  56 */     boolean bool = false;
/*     */     
/*     */     while (true) {
/*     */       try {
/*  60 */         paramCountDownLatch.await();
/*     */         return;
/*  62 */       } catch (InterruptedException interruptedException) {
/*     */ 
/*     */       
/*     */       } finally {
/*     */         
/*  67 */         if (bool) {
/*  68 */           Thread.currentThread().interrupt();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   @c
/*     */   @a
/*     */   public static boolean a(CountDownLatch paramCountDownLatch, Duration paramDuration) {
/*  83 */     return a(paramCountDownLatch, R.a(paramDuration), TimeUnit.NANOSECONDS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   @c
/*     */   public static boolean a(CountDownLatch paramCountDownLatch, long paramLong, TimeUnit paramTimeUnit) {
/*  94 */     boolean bool = false;
/*     */     try {
/*  96 */       long l1 = paramTimeUnit.toNanos(paramLong);
/*  97 */       long l2 = System.nanoTime() + l1;
/*     */ 
/*     */       
/*     */       while (true) {
/*     */         try {
/* 102 */           return paramCountDownLatch.await(l1, TimeUnit.NANOSECONDS);
/* 103 */         } catch (InterruptedException interruptedException) {
/* 104 */           bool = true;
/* 105 */           l1 = l2 - System.nanoTime();
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 109 */       if (bool) {
/* 110 */         Thread.currentThread().interrupt();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   @a
/*     */   public static boolean a(Condition paramCondition, Duration paramDuration) {
/* 124 */     return a(paramCondition, R.a(paramDuration), TimeUnit.NANOSECONDS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   public static boolean a(Condition paramCondition, long paramLong, TimeUnit paramTimeUnit) {
/* 136 */     boolean bool = false;
/*     */     try {
/* 138 */       long l1 = paramTimeUnit.toNanos(paramLong);
/* 139 */       long l2 = System.nanoTime() + l1;
/*     */       
/*     */       while (true) {
/*     */         try {
/* 143 */           return paramCondition.await(l1, TimeUnit.NANOSECONDS);
/* 144 */         } catch (InterruptedException interruptedException) {
/* 145 */           bool = true;
/* 146 */           l1 = l2 - System.nanoTime();
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 150 */       if (bool) {
/* 151 */         Thread.currentThread().interrupt();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @c
/*     */   public static void b(Thread paramThread) {
/* 159 */     boolean bool = false;
/*     */     
/*     */     while (true) {
/*     */       try {
/* 163 */         paramThread.join();
/*     */         return;
/* 165 */       } catch (InterruptedException interruptedException) {
/*     */ 
/*     */       
/*     */       } finally {
/*     */         
/* 170 */         if (bool) {
/* 171 */           Thread.currentThread().interrupt();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   @a
/*     */   public static void a(Thread paramThread, Duration paramDuration) {
/* 185 */     a(paramThread, R.a(paramDuration), TimeUnit.NANOSECONDS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   public static void a(Thread paramThread, long paramLong, TimeUnit paramTimeUnit) {
/* 195 */     D.checkNotNull(paramThread);
/* 196 */     boolean bool = false;
/*     */     try {
/* 198 */       long l1 = paramTimeUnit.toNanos(paramLong);
/* 199 */       long l2 = System.nanoTime() + l1;
/*     */       
/*     */       while (true) {
/*     */         try {
/* 203 */           TimeUnit.NANOSECONDS.timedJoin(paramThread, l1);
/*     */           return;
/* 205 */         } catch (InterruptedException interruptedException) {
/* 206 */           bool = true;
/* 207 */           l1 = l2 - System.nanoTime();
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 211 */       if (bool) {
/* 212 */         Thread.currentThread().interrupt();
/*     */       }
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public static <V> V a(Future<V> paramFuture) throws ExecutionException {
/* 236 */     boolean bool = false;
/*     */     
/*     */     while (true) {
/*     */       try {
/* 240 */         return paramFuture.get();
/* 241 */       } catch (InterruptedException interruptedException) {
/*     */ 
/*     */       
/*     */       } finally {
/*     */         
/* 246 */         if (bool) {
/* 247 */           Thread.currentThread().interrupt();
/*     */         }
/*     */       } 
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   @c
/*     */   @a
/*     */   public static <V> V a(Future<V> paramFuture, Duration paramDuration) throws ExecutionException, TimeoutException {
/* 276 */     return a(paramFuture, R.a(paramDuration), TimeUnit.NANOSECONDS);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   @c
/*     */   public static <V> V a(Future<V> paramFuture, long paramLong, TimeUnit paramTimeUnit) throws ExecutionException, TimeoutException {
/* 302 */     boolean bool = false;
/*     */     try {
/* 304 */       long l1 = paramTimeUnit.toNanos(paramLong);
/* 305 */       long l2 = System.nanoTime() + l1;
/*     */ 
/*     */       
/*     */       while (true) {
/*     */         try {
/* 310 */           return paramFuture.get(l1, TimeUnit.NANOSECONDS);
/* 311 */         } catch (InterruptedException interruptedException) {
/* 312 */           bool = true;
/* 313 */           l1 = l2 - System.nanoTime();
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 317 */       if (bool) {
/* 318 */         Thread.currentThread().interrupt();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @c
/*     */   public static <E> E a(BlockingQueue<E> paramBlockingQueue) {
/* 326 */     boolean bool = false;
/*     */     
/*     */     while (true) {
/*     */       try {
/* 330 */         return paramBlockingQueue.take();
/* 331 */       } catch (InterruptedException interruptedException) {
/*     */ 
/*     */       
/*     */       } finally {
/*     */         
/* 336 */         if (bool) {
/* 337 */           Thread.currentThread().interrupt();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   public static <E> void a(BlockingQueue<E> paramBlockingQueue, E paramE) {
/* 352 */     boolean bool = false;
/*     */     
/*     */     while (true) {
/*     */       try {
/* 356 */         paramBlockingQueue.put(paramE);
/*     */         return;
/* 358 */       } catch (InterruptedException interruptedException) {
/*     */ 
/*     */       
/*     */       } finally {
/*     */         
/* 363 */         if (bool) {
/* 364 */           Thread.currentThread().interrupt();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   @a
/*     */   public static void e(Duration paramDuration) {
/* 378 */     e(R.a(paramDuration), TimeUnit.NANOSECONDS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   public static void e(long paramLong, TimeUnit paramTimeUnit) {
/* 386 */     boolean bool = false;
/*     */     try {
/* 388 */       long l1 = paramTimeUnit.toNanos(paramLong);
/* 389 */       long l2 = System.nanoTime() + l1;
/*     */       
/*     */       while (true) {
/*     */         try {
/* 393 */           TimeUnit.NANOSECONDS.sleep(l1);
/*     */           return;
/* 395 */         } catch (InterruptedException interruptedException) {
/* 396 */           bool = true;
/* 397 */           l1 = l2 - System.nanoTime();
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 401 */       if (bool) {
/* 402 */         Thread.currentThread().interrupt();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   @a
/*     */   public static boolean a(Semaphore paramSemaphore, Duration paramDuration) {
/* 416 */     return a(paramSemaphore, R.a(paramDuration), TimeUnit.NANOSECONDS);
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
/*     */   @c
/*     */   public static boolean a(Semaphore paramSemaphore, long paramLong, TimeUnit paramTimeUnit) {
/* 429 */     return a(paramSemaphore, 1, paramLong, paramTimeUnit);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   @a
/*     */   public static boolean a(Semaphore paramSemaphore, int paramInt, Duration paramDuration) {
/* 442 */     return a(paramSemaphore, paramInt, 
/* 443 */         R.a(paramDuration), TimeUnit.NANOSECONDS);
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
/*     */   @c
/*     */   public static boolean a(Semaphore paramSemaphore, int paramInt, long paramLong, TimeUnit paramTimeUnit) {
/* 456 */     boolean bool = false;
/*     */     try {
/* 458 */       long l1 = paramTimeUnit.toNanos(paramLong);
/* 459 */       long l2 = System.nanoTime() + l1;
/*     */ 
/*     */       
/*     */       while (true) {
/*     */         try {
/* 464 */           return paramSemaphore.tryAcquire(paramInt, l1, TimeUnit.NANOSECONDS);
/* 465 */         } catch (InterruptedException interruptedException) {
/* 466 */           bool = true;
/* 467 */           l1 = l2 - System.nanoTime();
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 471 */       if (bool) {
/* 472 */         Thread.currentThread().interrupt();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   @a
/*     */   public static boolean a(Lock paramLock, Duration paramDuration) {
/* 486 */     return a(paramLock, R.a(paramDuration), TimeUnit.NANOSECONDS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   public static boolean a(Lock paramLock, long paramLong, TimeUnit paramTimeUnit) {
/* 498 */     boolean bool = false;
/*     */     try {
/* 500 */       long l1 = paramTimeUnit.toNanos(paramLong);
/* 501 */       long l2 = System.nanoTime() + l1;
/*     */       
/*     */       while (true) {
/*     */         try {
/* 505 */           return paramLock.tryLock(l1, TimeUnit.NANOSECONDS);
/* 506 */         } catch (InterruptedException interruptedException) {
/* 507 */           bool = true;
/* 508 */           l1 = l2 - System.nanoTime();
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 512 */       if (bool) {
/* 513 */         Thread.currentThread().interrupt();
/*     */       }
/*     */     } 
/*     */   }
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
/*     */   public static void a(ExecutorService paramExecutorService) {
/* 528 */     R.ac(b(paramExecutorService, Long.MAX_VALUE, TimeUnit.NANOSECONDS));
/*     */   }
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
/*     */   public static boolean b(ExecutorService paramExecutorService, Duration paramDuration) {
/* 541 */     return b(paramExecutorService, R.a(paramDuration), TimeUnit.NANOSECONDS);
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
/*     */   @a
/*     */   @c
/*     */   public static boolean b(ExecutorService paramExecutorService, long paramLong, TimeUnit paramTimeUnit) {
/* 555 */     boolean bool = false;
/*     */     try {
/* 557 */       long l1 = paramTimeUnit.toNanos(paramLong);
/* 558 */       long l2 = System.nanoTime() + l1;
/*     */       
/*     */       while (true) {
/*     */         try {
/* 562 */           return paramExecutorService.awaitTermination(l1, TimeUnit.NANOSECONDS);
/* 563 */         } catch (InterruptedException interruptedException) {
/* 564 */           bool = true;
/* 565 */           l1 = l2 - System.nanoTime();
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 569 */       if (bool)
/* 570 */         Thread.currentThread().interrupt(); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\aw.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */