/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.b.a.a;
/*     */ import java.time.Duration;
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.Collection;
/*     */ import java.util.Deque;
/*     */ import java.util.PriorityQueue;
/*     */ import java.util.Queue;
/*     */ import java.util.concurrent.ArrayBlockingQueue;
/*     */ import java.util.concurrent.BlockingQueue;
/*     */ import java.util.concurrent.ConcurrentLinkedQueue;
/*     */ import java.util.concurrent.LinkedBlockingDeque;
/*     */ import java.util.concurrent.LinkedBlockingQueue;
/*     */ import java.util.concurrent.PriorityBlockingQueue;
/*     */ import java.util.concurrent.SynchronousQueue;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class cm
/*     */ {
/*     */   @c
/*     */   public static <E> ArrayBlockingQueue<E> a(int paramInt) {
/*  55 */     return new ArrayBlockingQueue<>(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> ArrayDeque<E> a() {
/*  66 */     return new ArrayDeque<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> ArrayDeque<E> a(Iterable<? extends E> paramIterable) {
/*  76 */     if (paramIterable instanceof Collection) {
/*  77 */       return new ArrayDeque<>((Collection<? extends E>)paramIterable);
/*     */     }
/*  79 */     ArrayDeque<E> arrayDeque = new ArrayDeque();
/*  80 */     bG.addAll(arrayDeque, paramIterable);
/*  81 */     return arrayDeque;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   public static <E> ConcurrentLinkedQueue<E> a() {
/*  89 */     return new ConcurrentLinkedQueue<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   public static <E> ConcurrentLinkedQueue<E> a(Iterable<? extends E> paramIterable) {
/*  99 */     if (paramIterable instanceof Collection) {
/* 100 */       return new ConcurrentLinkedQueue<>((Collection<? extends E>)paramIterable);
/*     */     }
/* 102 */     ConcurrentLinkedQueue<E> concurrentLinkedQueue = new ConcurrentLinkedQueue();
/* 103 */     bG.addAll(concurrentLinkedQueue, paramIterable);
/* 104 */     return concurrentLinkedQueue;
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
/*     */   public static <E> LinkedBlockingDeque<E> a() {
/* 116 */     return new LinkedBlockingDeque<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   public static <E> LinkedBlockingDeque<E> newLinkedBlockingDeque(int paramInt) {
/* 127 */     return new LinkedBlockingDeque<>(paramInt);
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
/*     */   public static <E> LinkedBlockingDeque<E> a(Iterable<? extends E> paramIterable) {
/* 139 */     if (paramIterable instanceof Collection) {
/* 140 */       return new LinkedBlockingDeque<>((Collection<? extends E>)paramIterable);
/*     */     }
/* 142 */     LinkedBlockingDeque<E> linkedBlockingDeque = new LinkedBlockingDeque();
/* 143 */     bG.addAll(linkedBlockingDeque, paramIterable);
/* 144 */     return linkedBlockingDeque;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   public static <E> LinkedBlockingQueue<E> a() {
/* 152 */     return new LinkedBlockingQueue<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   public static <E> LinkedBlockingQueue<E> a(int paramInt) {
/* 162 */     return new LinkedBlockingQueue<>(paramInt);
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
/*     */   public static <E> LinkedBlockingQueue<E> a(Iterable<? extends E> paramIterable) {
/* 175 */     if (paramIterable instanceof Collection) {
/* 176 */       return new LinkedBlockingQueue<>((Collection<? extends E>)paramIterable);
/*     */     }
/* 178 */     LinkedBlockingQueue<E> linkedBlockingQueue = new LinkedBlockingQueue();
/* 179 */     bG.addAll(linkedBlockingQueue, paramIterable);
/* 180 */     return linkedBlockingQueue;
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
/*     */   public static <E extends Comparable> PriorityBlockingQueue<E> a() {
/* 195 */     return new PriorityBlockingQueue<>();
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
/*     */   public static <E extends Comparable> PriorityBlockingQueue<E> a(Iterable<? extends E> paramIterable) {
/* 209 */     if (paramIterable instanceof Collection) {
/* 210 */       return new PriorityBlockingQueue<>((Collection<? extends E>)paramIterable);
/*     */     }
/* 212 */     PriorityBlockingQueue<E> priorityBlockingQueue = new PriorityBlockingQueue();
/* 213 */     bG.addAll(priorityBlockingQueue, paramIterable);
/* 214 */     return priorityBlockingQueue;
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
/*     */   public static <E extends Comparable> PriorityQueue<E> a() {
/* 226 */     return new PriorityQueue<>();
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
/*     */   public static <E extends Comparable> PriorityQueue<E> a(Iterable<? extends E> paramIterable) {
/* 239 */     if (paramIterable instanceof Collection) {
/* 240 */       return new PriorityQueue<>((Collection<? extends E>)paramIterable);
/*     */     }
/* 242 */     PriorityQueue<E> priorityQueue = new PriorityQueue();
/* 243 */     bG.addAll(priorityQueue, paramIterable);
/* 244 */     return priorityQueue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   public static <E> SynchronousQueue<E> a() {
/* 252 */     return new SynchronousQueue<>();
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
/*     */   @a
/*     */   @a
/*     */   @c
/*     */   public static <E> int a(BlockingQueue<E> paramBlockingQueue, Collection<? super E> paramCollection, int paramInt, Duration paramDuration) throws InterruptedException {
/* 274 */     return a(paramBlockingQueue, paramCollection, paramInt, paramDuration.toNanos(), TimeUnit.NANOSECONDS);
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
/*     */   @a
/*     */   @c
/*     */   public static <E> int a(BlockingQueue<E> paramBlockingQueue, Collection<? super E> paramCollection, int paramInt, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
/* 300 */     D.checkNotNull(paramCollection);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 306 */     long l = System.nanoTime() + paramTimeUnit.toNanos(paramLong);
/* 307 */     int i = 0;
/* 308 */     while (i < paramInt) {
/*     */ 
/*     */       
/* 311 */       i += paramBlockingQueue.drainTo(paramCollection, paramInt - i);
/* 312 */       if (i < paramInt) {
/* 313 */         E e = paramBlockingQueue.poll(l - System.nanoTime(), TimeUnit.NANOSECONDS);
/* 314 */         if (e == null) {
/*     */           break;
/*     */         }
/* 317 */         paramCollection.add(e);
/* 318 */         i++;
/*     */       } 
/*     */     } 
/* 321 */     return i;
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
/*     */   @a
/*     */   @a
/*     */   @c
/*     */   public static <E> int b(BlockingQueue<E> paramBlockingQueue, Collection<? super E> paramCollection, int paramInt, Duration paramDuration) {
/* 346 */     return b(paramBlockingQueue, paramCollection, paramInt, paramDuration.toNanos(), TimeUnit.NANOSECONDS);
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
/*     */   @a
/*     */   @c
/*     */   public static <E> int b(BlockingQueue<E> paramBlockingQueue, Collection<? super E> paramCollection, int paramInt, long paramLong, TimeUnit paramTimeUnit) {
/* 372 */     D.checkNotNull(paramCollection);
/* 373 */     long l = System.nanoTime() + paramTimeUnit.toNanos(paramLong);
/* 374 */     int i = 0;
/* 375 */     boolean bool = false;
/*     */     try {
/* 377 */       while (i < paramInt) {
/*     */ 
/*     */         
/* 380 */         i += paramBlockingQueue.drainTo(paramCollection, paramInt - i);
/* 381 */         if (i < paramInt) {
/*     */           E e;
/*     */           while (true) {
/*     */             try {
/* 385 */               e = paramBlockingQueue.poll(l - System.nanoTime(), TimeUnit.NANOSECONDS);
/*     */               break;
/* 387 */             } catch (InterruptedException interruptedException) {
/* 388 */               bool = true;
/*     */             } 
/*     */           } 
/* 391 */           if (e == null) {
/*     */             break;
/*     */           }
/* 394 */           paramCollection.add(e);
/* 395 */           i++;
/*     */         } 
/*     */       } 
/*     */     } finally {
/* 399 */       if (bool) {
/* 400 */         Thread.currentThread().interrupt();
/*     */       }
/*     */     } 
/* 403 */     return i;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> Queue<E> a(Queue<E> paramQueue) {
/* 436 */     return cX.a(paramQueue, (Object)null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> Deque<E> a(Deque<E> paramDeque) {
/* 469 */     return cX.a(paramDeque, (Object)null);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\cm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */