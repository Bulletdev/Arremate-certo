/*     */ package org.apache.http.pool;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.CancellationException;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.TimeoutException;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import java.util.concurrent.atomic.AtomicReference;
/*     */ import java.util.concurrent.locks.Condition;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.concurrent.FutureCallback;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.Asserts;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/*     */ public abstract class AbstractConnPool<T, C, E extends PoolEntry<T, C>>
/*     */   implements ConnPool<T, E>, ConnPoolControl<T>
/*     */ {
/*     */   private final Lock lock;
/*     */   private final Condition condition;
/*     */   private final ConnFactory<T, C> connFactory;
/*     */   private final Map<T, RouteSpecificPool<T, C, E>> routeToPool;
/*     */   private final Set<E> leased;
/*     */   private final LinkedList<E> available;
/*     */   private final LinkedList<Future<E>> pending;
/*     */   private final Map<T, Integer> maxPerRoute;
/*     */   private volatile boolean isShutDown;
/*     */   private volatile int defaultMaxPerRoute;
/*     */   private volatile int maxTotal;
/*     */   private volatile int validateAfterInactivity;
/*     */   
/*     */   public AbstractConnPool(ConnFactory<T, C> paramConnFactory, int paramInt1, int paramInt2) {
/*  92 */     this.connFactory = (ConnFactory<T, C>)Args.notNull(paramConnFactory, "Connection factory");
/*  93 */     this.defaultMaxPerRoute = Args.positive(paramInt1, "Max per route value");
/*  94 */     this.maxTotal = Args.positive(paramInt2, "Max total value");
/*  95 */     this.lock = new ReentrantLock();
/*  96 */     this.condition = this.lock.newCondition();
/*  97 */     this.routeToPool = new HashMap<T, RouteSpecificPool<T, C, E>>();
/*  98 */     this.leased = new HashSet<E>();
/*  99 */     this.available = new LinkedList<E>();
/* 100 */     this.pending = new LinkedList<Future<E>>();
/* 101 */     this.maxPerRoute = new HashMap<T, Integer>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onLease(E paramE) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onRelease(E paramE) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onReuse(E paramE) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean validate(E paramE) {
/* 131 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isShutdown() {
/* 135 */     return this.isShutDown;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void shutdown() throws IOException {
/* 142 */     if (this.isShutDown) {
/*     */       return;
/*     */     }
/* 145 */     this.isShutDown = true;
/* 146 */     this.lock.lock();
/*     */     try {
/* 148 */       for (PoolEntry poolEntry : this.available) {
/* 149 */         poolEntry.close();
/*     */       }
/* 151 */       for (PoolEntry poolEntry : this.leased) {
/* 152 */         poolEntry.close();
/*     */       }
/* 154 */       for (RouteSpecificPool<T, C, E> routeSpecificPool : this.routeToPool.values()) {
/* 155 */         routeSpecificPool.shutdown();
/*     */       }
/* 157 */       this.routeToPool.clear();
/* 158 */       this.leased.clear();
/* 159 */       this.available.clear();
/*     */     } finally {
/* 161 */       this.lock.unlock();
/*     */     } 
/*     */   }
/*     */   
/*     */   private RouteSpecificPool<T, C, E> getPool(final T route) {
/* 166 */     RouteSpecificPool<T, C, E> routeSpecificPool = this.routeToPool.get(route);
/* 167 */     if (routeSpecificPool == null) {
/* 168 */       routeSpecificPool = new RouteSpecificPool<T, C, E>(route)
/*     */         {
/*     */           protected E createEntry(C param1C)
/*     */           {
/* 172 */             return AbstractConnPool.this.createEntry(route, param1C);
/*     */           }
/*     */         };
/*     */       
/* 176 */       this.routeToPool.put(route, routeSpecificPool);
/*     */     } 
/* 178 */     return routeSpecificPool;
/*     */   }
/*     */   
/*     */   private static Exception operationAborted() {
/* 182 */     return new CancellationException("Operation aborted");
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
/*     */   public Future<E> lease(final T route, final Object state, final FutureCallback<E> callback) {
/* 195 */     Args.notNull(route, "Route");
/* 196 */     Asserts.check(!this.isShutDown, "Connection pool shut down");
/*     */     
/* 198 */     return new Future<E>()
/*     */       {
/* 200 */         private final AtomicBoolean cancelled = new AtomicBoolean(false);
/* 201 */         private final AtomicBoolean done = new AtomicBoolean(false);
/* 202 */         private final AtomicReference<E> entryRef = new AtomicReference<E>(null);
/*     */ 
/*     */         
/*     */         public boolean cancel(boolean param1Boolean) {
/* 206 */           if (this.done.compareAndSet(false, true)) {
/* 207 */             this.cancelled.set(true);
/* 208 */             AbstractConnPool.this.lock.lock();
/*     */             try {
/* 210 */               AbstractConnPool.this.condition.signalAll();
/*     */             } finally {
/* 212 */               AbstractConnPool.this.lock.unlock();
/*     */             } 
/* 214 */             if (callback != null) {
/* 215 */               callback.cancelled();
/*     */             }
/* 217 */             return true;
/*     */           } 
/* 219 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isCancelled() {
/* 224 */           return this.cancelled.get();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isDone() {
/* 229 */           return this.done.get();
/*     */         }
/*     */ 
/*     */         
/*     */         public E get() throws InterruptedException, ExecutionException {
/*     */           try {
/* 235 */             return get(0L, TimeUnit.MILLISECONDS);
/* 236 */           } catch (TimeoutException timeoutException) {
/* 237 */             throw new ExecutionException(timeoutException);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public E get(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
/*     */           while (true) {
/* 244 */             synchronized (this) {
/*     */               
/* 246 */               PoolEntry poolEntry1 = (PoolEntry)this.entryRef.get();
/* 247 */               if (poolEntry1 != null) {
/* 248 */                 return (E)poolEntry1;
/*     */               }
/* 250 */               if (this.done.get()) {
/* 251 */                 throw new ExecutionException(AbstractConnPool.operationAborted());
/*     */               }
/* 253 */               PoolEntry poolEntry2 = (PoolEntry)AbstractConnPool.this.getPoolEntryBlocking((T)route, state, param1Long, param1TimeUnit, this);
/* 254 */               if (AbstractConnPool.this.validateAfterInactivity > 0 && 
/* 255 */                 poolEntry2.getUpdated() + AbstractConnPool.this.validateAfterInactivity <= System.currentTimeMillis() && 
/* 256 */                 !AbstractConnPool.this.validate(poolEntry2)) {
/* 257 */                 poolEntry2.close();
/* 258 */                 AbstractConnPool.this.release(poolEntry2, false);
/*     */                 
/*     */                 continue;
/*     */               } 
/*     */               
/* 263 */               if (this.done.compareAndSet(false, true)) {
/* 264 */                 this.entryRef.set((E)poolEntry2);
/* 265 */                 this.done.set(true);
/* 266 */                 AbstractConnPool.this.onLease(poolEntry2);
/* 267 */                 if (callback != null) {
/* 268 */                   callback.completed(poolEntry2);
/*     */                 }
/* 270 */                 return (E)poolEntry2;
/*     */               } 
/* 272 */               AbstractConnPool.this.release(poolEntry2, true);
/* 273 */               throw new ExecutionException(AbstractConnPool.operationAborted());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Future<E> lease(T paramT, Object paramObject) {
/* 307 */     return lease(paramT, paramObject, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private E getPoolEntryBlocking(T paramT, Object paramObject, long paramLong, TimeUnit paramTimeUnit, Future<E> paramFuture) throws IOException, InterruptedException, ExecutionException, TimeoutException {
/* 315 */     Date date = null;
/* 316 */     if (paramLong > 0L) {
/* 317 */       date = new Date(System.currentTimeMillis() + paramTimeUnit.toMillis(paramLong));
/*     */     }
/* 319 */     this.lock.lock(); try {
/*     */       boolean bool;
/*     */       do {
/*     */         E e;
/* 323 */         Asserts.check(!this.isShutDown, "Connection pool shut down");
/* 324 */         if (paramFuture.isCancelled()) {
/* 325 */           throw new ExecutionException(operationAborted());
/*     */         }
/* 327 */         RouteSpecificPool<T, C, E> routeSpecificPool = getPool(paramT);
/*     */         while (true) {
/* 329 */           e = routeSpecificPool.getFree(paramObject);
/* 330 */           if (e == null) {
/*     */             break;
/*     */           }
/* 333 */           if (e.isExpired(System.currentTimeMillis())) {
/* 334 */             e.close();
/*     */           }
/* 336 */           if (e.isClosed()) {
/* 337 */             this.available.remove(e);
/* 338 */             routeSpecificPool.free(e, false);
/*     */             continue;
/*     */           } 
/*     */           break;
/*     */         } 
/* 343 */         if (e != null) {
/* 344 */           this.available.remove(e);
/* 345 */           this.leased.add(e);
/* 346 */           onReuse(e);
/* 347 */           return e;
/*     */         } 
/*     */ 
/*     */         
/* 351 */         int i = getMax(paramT);
/*     */         
/* 353 */         int j = Math.max(0, routeSpecificPool.getAllocatedCount() + 1 - i);
/* 354 */         if (j > 0) {
/* 355 */           for (byte b = 0; b < j; b++) {
/* 356 */             E e1 = routeSpecificPool.getLastUsed();
/* 357 */             if (e1 == null) {
/*     */               break;
/*     */             }
/* 360 */             e1.close();
/* 361 */             this.available.remove(e1);
/* 362 */             routeSpecificPool.remove(e1);
/*     */           } 
/*     */         }
/*     */         
/* 366 */         if (routeSpecificPool.getAllocatedCount() < i) {
/* 367 */           int k = this.leased.size();
/* 368 */           int m = Math.max(this.maxTotal - k, 0);
/* 369 */           if (m > 0) {
/* 370 */             int n = this.available.size();
/* 371 */             if (n > m - 1) {
/* 372 */               PoolEntry poolEntry = (PoolEntry)this.available.removeLast();
/* 373 */               poolEntry.close();
/* 374 */               RouteSpecificPool<T, C, E> routeSpecificPool1 = getPool((T)poolEntry.getRoute());
/* 375 */               routeSpecificPool1.remove((E)poolEntry);
/*     */             } 
/* 377 */             C c = this.connFactory.create(paramT);
/* 378 */             e = routeSpecificPool.add(c);
/* 379 */             this.leased.add(e);
/* 380 */             return e;
/*     */           } 
/*     */         } 
/*     */         
/* 384 */         bool = false;
/*     */         try {
/* 386 */           routeSpecificPool.queue(paramFuture);
/* 387 */           this.pending.add(paramFuture);
/* 388 */           if (date != null) {
/* 389 */             bool = this.condition.awaitUntil(date);
/*     */           } else {
/* 391 */             this.condition.await();
/* 392 */             bool = true;
/*     */           } 
/* 394 */           if (paramFuture.isCancelled()) {
/* 395 */             throw new ExecutionException(operationAborted());
/*     */           
/*     */           }
/*     */         
/*     */         }
/*     */         finally {
/*     */           
/* 402 */           routeSpecificPool.unqueue(paramFuture);
/* 403 */           this.pending.remove(paramFuture);
/*     */         }
/*     */       
/* 406 */       } while (bool || date == null || date.getTime() > System.currentTimeMillis());
/*     */ 
/*     */ 
/*     */       
/* 410 */       throw new TimeoutException("Timeout waiting for connection");
/*     */     } finally {
/* 412 */       this.lock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void release(E paramE, boolean paramBoolean) {
/* 418 */     this.lock.lock();
/*     */     try {
/* 420 */       if (this.leased.remove(paramE)) {
/* 421 */         RouteSpecificPool<T, C, E> routeSpecificPool = getPool((T)paramE.getRoute());
/* 422 */         routeSpecificPool.free(paramE, paramBoolean);
/* 423 */         if (paramBoolean && !this.isShutDown) {
/* 424 */           this.available.addFirst(paramE);
/*     */         } else {
/* 426 */           paramE.close();
/*     */         } 
/* 428 */         onRelease(paramE);
/* 429 */         Future<E> future = routeSpecificPool.nextPending();
/* 430 */         if (future != null) {
/* 431 */           this.pending.remove(future);
/*     */         } else {
/* 433 */           future = this.pending.poll();
/*     */         } 
/* 435 */         if (future != null) {
/* 436 */           this.condition.signalAll();
/*     */         }
/*     */       } 
/*     */     } finally {
/* 440 */       this.lock.unlock();
/*     */     } 
/*     */   }
/*     */   
/*     */   private int getMax(T paramT) {
/* 445 */     Integer integer = this.maxPerRoute.get(paramT);
/* 446 */     return (integer != null) ? integer.intValue() : this.defaultMaxPerRoute;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaxTotal(int paramInt) {
/* 451 */     Args.positive(paramInt, "Max value");
/* 452 */     this.lock.lock();
/*     */     try {
/* 454 */       this.maxTotal = paramInt;
/*     */     } finally {
/* 456 */       this.lock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxTotal() {
/* 462 */     this.lock.lock();
/*     */     try {
/* 464 */       return this.maxTotal;
/*     */     } finally {
/* 466 */       this.lock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDefaultMaxPerRoute(int paramInt) {
/* 472 */     Args.positive(paramInt, "Max per route value");
/* 473 */     this.lock.lock();
/*     */     try {
/* 475 */       this.defaultMaxPerRoute = paramInt;
/*     */     } finally {
/* 477 */       this.lock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDefaultMaxPerRoute() {
/* 483 */     this.lock.lock();
/*     */     try {
/* 485 */       return this.defaultMaxPerRoute;
/*     */     } finally {
/* 487 */       this.lock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaxPerRoute(T paramT, int paramInt) {
/* 493 */     Args.notNull(paramT, "Route");
/* 494 */     this.lock.lock();
/*     */     try {
/* 496 */       if (paramInt > -1) {
/* 497 */         this.maxPerRoute.put(paramT, Integer.valueOf(paramInt));
/*     */       } else {
/* 499 */         this.maxPerRoute.remove(paramT);
/*     */       } 
/*     */     } finally {
/* 502 */       this.lock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxPerRoute(T paramT) {
/* 508 */     Args.notNull(paramT, "Route");
/* 509 */     this.lock.lock();
/*     */     try {
/* 511 */       return getMax(paramT);
/*     */     } finally {
/* 513 */       this.lock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public PoolStats getTotalStats() {
/* 519 */     this.lock.lock();
/*     */     try {
/* 521 */       return new PoolStats(this.leased.size(), this.pending.size(), this.available.size(), this.maxTotal);
/*     */     
/*     */     }
/*     */     finally {
/*     */ 
/*     */       
/* 527 */       this.lock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public PoolStats getStats(T paramT) {
/* 533 */     Args.notNull(paramT, "Route");
/* 534 */     this.lock.lock();
/*     */     try {
/* 536 */       RouteSpecificPool<T, C, E> routeSpecificPool = getPool(paramT);
/* 537 */       return new PoolStats(routeSpecificPool.getLeasedCount(), routeSpecificPool.getPendingCount(), routeSpecificPool.getAvailableCount(), getMax(paramT));
/*     */     
/*     */     }
/*     */     finally {
/*     */ 
/*     */       
/* 543 */       this.lock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<T> getRoutes() {
/* 554 */     this.lock.lock();
/*     */     try {
/* 556 */       return new HashSet(this.routeToPool.keySet());
/*     */     } finally {
/* 558 */       this.lock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void enumAvailable(PoolEntryCallback<T, C> paramPoolEntryCallback) {
/* 568 */     this.lock.lock();
/*     */     try {
/* 570 */       Iterator<E> iterator = this.available.iterator();
/* 571 */       while (iterator.hasNext()) {
/* 572 */         PoolEntry<T, C> poolEntry = (PoolEntry)iterator.next();
/* 573 */         paramPoolEntryCallback.process(poolEntry);
/* 574 */         if (poolEntry.isClosed()) {
/* 575 */           RouteSpecificPool<T, C, E> routeSpecificPool = getPool(poolEntry.getRoute());
/* 576 */           routeSpecificPool.remove((E)poolEntry);
/* 577 */           iterator.remove();
/*     */         } 
/*     */       } 
/* 580 */       purgePoolMap();
/*     */     } finally {
/* 582 */       this.lock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void enumLeased(PoolEntryCallback<T, C> paramPoolEntryCallback) {
/* 592 */     this.lock.lock();
/*     */     try {
/* 594 */       Iterator<E> iterator = this.leased.iterator();
/* 595 */       while (iterator.hasNext()) {
/* 596 */         PoolEntry<T, C> poolEntry = (PoolEntry)iterator.next();
/* 597 */         paramPoolEntryCallback.process(poolEntry);
/*     */       } 
/*     */     } finally {
/* 600 */       this.lock.unlock();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void purgePoolMap() {
/* 605 */     Iterator<Map.Entry> iterator = this.routeToPool.entrySet().iterator();
/* 606 */     while (iterator.hasNext()) {
/* 607 */       Map.Entry entry = iterator.next();
/* 608 */       RouteSpecificPool routeSpecificPool = (RouteSpecificPool)entry.getValue();
/* 609 */       if (routeSpecificPool.getPendingCount() + routeSpecificPool.getAllocatedCount() == 0) {
/* 610 */         iterator.remove();
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
/*     */   public void closeIdle(long paramLong, TimeUnit paramTimeUnit) {
/* 623 */     Args.notNull(paramTimeUnit, "Time unit");
/* 624 */     long l1 = paramTimeUnit.toMillis(paramLong);
/* 625 */     if (l1 < 0L) {
/* 626 */       l1 = 0L;
/*     */     }
/* 628 */     final long deadline = System.currentTimeMillis() - l1;
/* 629 */     enumAvailable(new PoolEntryCallback<T, C>()
/*     */         {
/*     */           public void process(PoolEntry<T, C> param1PoolEntry)
/*     */           {
/* 633 */             if (param1PoolEntry.getUpdated() <= deadline) {
/* 634 */               param1PoolEntry.close();
/*     */             }
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeExpired() {
/* 645 */     final long now = System.currentTimeMillis();
/* 646 */     enumAvailable(new PoolEntryCallback<T, C>()
/*     */         {
/*     */           public void process(PoolEntry<T, C> param1PoolEntry)
/*     */           {
/* 650 */             if (param1PoolEntry.isExpired(now)) {
/* 651 */               param1PoolEntry.close();
/*     */             }
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getValidateAfterInactivity() {
/* 663 */     return this.validateAfterInactivity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setValidateAfterInactivity(int paramInt) {
/* 671 */     this.validateAfterInactivity = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 676 */     this.lock.lock();
/*     */     try {
/* 678 */       StringBuilder stringBuilder = new StringBuilder();
/* 679 */       stringBuilder.append("[leased: ");
/* 680 */       stringBuilder.append(this.leased);
/* 681 */       stringBuilder.append("][available: ");
/* 682 */       stringBuilder.append(this.available);
/* 683 */       stringBuilder.append("][pending: ");
/* 684 */       stringBuilder.append(this.pending);
/* 685 */       stringBuilder.append("]");
/* 686 */       return stringBuilder.toString();
/*     */     } finally {
/* 688 */       this.lock.unlock();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected abstract E createEntry(T paramT, C paramC);
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\pool\AbstractConnPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */