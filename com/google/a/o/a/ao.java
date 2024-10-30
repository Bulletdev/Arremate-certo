/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.M;
/*     */ import com.google.a.b.x;
/*     */ import com.google.a.d.bG;
/*     */ import com.google.a.d.bU;
/*     */ import com.google.a.d.bh;
/*     */ import java.lang.ref.Reference;
/*     */ import java.lang.ref.ReferenceQueue;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ import java.util.concurrent.Semaphore;
/*     */ import java.util.concurrent.atomic.AtomicReferenceArray;
/*     */ import java.util.concurrent.locks.Condition;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ @c
/*     */ public abstract class ao<L>
/*     */ {
/*     */   private static final int gu = 1024;
/*     */   
/*     */   private ao() {}
/*     */   
/*     */   public Iterable<L> l(Iterable<?> paramIterable) {
/* 141 */     Object[] arrayOfObject = bG.a(paramIterable, Object.class);
/* 142 */     if (arrayOfObject.length == 0) {
/* 143 */       return (Iterable<L>)bh.e();
/*     */     }
/* 145 */     int[] arrayOfInt = new int[arrayOfObject.length]; int i;
/* 146 */     for (i = 0; i < arrayOfObject.length; i++) {
/* 147 */       arrayOfInt[i] = p(arrayOfObject[i]);
/*     */     }
/* 149 */     Arrays.sort(arrayOfInt);
/*     */     
/* 151 */     i = arrayOfInt[0];
/* 152 */     arrayOfObject[0] = f(i);
/* 153 */     for (byte b = 1; b < arrayOfObject.length; b++) {
/* 154 */       int j = arrayOfInt[b];
/* 155 */       if (j == i) {
/* 156 */         arrayOfObject[b] = arrayOfObject[b - 1];
/*     */       } else {
/* 158 */         arrayOfObject[b] = f(j);
/* 159 */         i = j;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 180 */     List<? extends L> list = Arrays.asList(arrayOfObject);
/* 181 */     return Collections.unmodifiableList(list);
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
/*     */   static <L> ao<L> a(int paramInt, M<L> paramM) {
/* 195 */     return new a<>(paramInt, paramM);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ao<Lock> a(int paramInt) {
/* 206 */     return a(paramInt, new M<Lock>()
/*     */         {
/*     */           
/*     */           public Lock b()
/*     */           {
/* 211 */             return new ao.c();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ao<Lock> b(int paramInt) {
/* 224 */     return b(paramInt, new M<Lock>()
/*     */         {
/*     */           
/*     */           public Lock b()
/*     */           {
/* 229 */             return new ReentrantLock(false);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   private static <L> ao<L> b(int paramInt, M<L> paramM) {
/* 235 */     return (paramInt < 1024) ? 
/* 236 */       new f<>(paramInt, paramM) : 
/* 237 */       new b<>(paramInt, paramM);
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
/*     */   public static ao<Semaphore> a(int paramInt1, int paramInt2) {
/* 249 */     return a(paramInt1, new M<Semaphore>(paramInt2)
/*     */         {
/*     */           
/*     */           public Semaphore a()
/*     */           {
/* 254 */             return new ao.d(this.gw);
/*     */           }
/*     */         });
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
/*     */   public static ao<Semaphore> b(int paramInt1, int paramInt2) {
/* 268 */     return b(paramInt1, new M<Semaphore>(paramInt2)
/*     */         {
/*     */           
/*     */           public Semaphore a()
/*     */           {
/* 273 */             return new Semaphore(this.gw, false);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ao<ReadWriteLock> c(int paramInt) {
/* 286 */     return a(paramInt, k);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ao<ReadWriteLock> d(int paramInt) {
/* 297 */     return b(paramInt, l);
/*     */   }
/*     */   
/* 300 */   private static final M<ReadWriteLock> k = new M<ReadWriteLock>()
/*     */     {
/*     */       public ReadWriteLock a()
/*     */       {
/* 304 */         return new ReentrantReadWriteLock();
/*     */       }
/*     */     };
/*     */   
/* 308 */   private static final M<ReadWriteLock> l = new M<ReadWriteLock>()
/*     */     {
/*     */       public ReadWriteLock a()
/*     */       {
/* 312 */         return new ao.i();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int gv = -1;
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class i
/*     */     implements ReadWriteLock
/*     */   {
/* 325 */     private final ReadWriteLock a = new ReentrantReadWriteLock();
/*     */ 
/*     */ 
/*     */     
/*     */     public Lock readLock() {
/* 330 */       return new ao.h(this.a.readLock(), this);
/*     */     }
/*     */ 
/*     */     
/*     */     public Lock writeLock() {
/* 335 */       return new ao.h(this.a.writeLock(), this);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class h
/*     */     extends J
/*     */   {
/*     */     private final Lock a;
/*     */     private final ao.i a;
/*     */     
/*     */     h(Lock param1Lock, ao.i param1i) {
/* 347 */       this.a = (ao.i)param1Lock;
/* 348 */       this.a = param1i;
/*     */     }
/*     */ 
/*     */     
/*     */     Lock a() {
/* 353 */       return (Lock)this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public Condition newCondition() {
/* 358 */       return new ao.g(this.a.newCondition(), this.a);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class g
/*     */     extends D
/*     */   {
/*     */     private final Condition a;
/*     */     private final ao.i a;
/*     */     
/*     */     g(Condition param1Condition, ao.i param1i) {
/* 370 */       this.a = (ao.i)param1Condition;
/* 371 */       this.a = param1i;
/*     */     }
/*     */ 
/*     */     
/*     */     Condition a() {
/* 376 */       return (Condition)this.a;
/*     */     }
/*     */   }
/*     */   
/*     */   private static abstract class e<L>
/*     */     extends ao<L> {
/*     */     final int mask;
/*     */     
/*     */     e(int param1Int) {
/* 385 */       D.a((param1Int > 0), "Stripes must be positive");
/* 386 */       this.mask = (param1Int > 1073741824) ? -1 : (ao.T(param1Int) - 1);
/*     */     }
/*     */ 
/*     */     
/*     */     final int p(Object param1Object) {
/* 391 */       int i = ao.U(param1Object.hashCode());
/* 392 */       return i & this.mask;
/*     */     }
/*     */ 
/*     */     
/*     */     public final L get(Object param1Object) {
/* 397 */       return f(p(param1Object));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class a<L>
/*     */     extends e<L>
/*     */   {
/*     */     private final Object[] array;
/*     */ 
/*     */     
/*     */     private a(int param1Int, M<L> param1M) {
/* 410 */       super(param1Int);
/* 411 */       D.a((param1Int <= 1073741824), "Stripes must be <= 2^30)");
/*     */       
/* 413 */       this.array = new Object[this.mask + 1];
/* 414 */       for (byte b = 0; b < this.array.length; b++) {
/* 415 */         this.array[b] = param1M.get();
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public L f(int param1Int) {
/* 422 */       return (L)this.array[param1Int];
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 427 */       return this.array.length;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.a.a.d
/*     */   static class f<L>
/*     */     extends e<L>
/*     */   {
/*     */     final AtomicReferenceArray<a<? extends L>> c;
/*     */     
/*     */     final M<L> a;
/*     */     
/*     */     final int size;
/* 441 */     final ReferenceQueue<L> queue = new ReferenceQueue<>();
/*     */     
/*     */     f(int param1Int, M<L> param1M) {
/* 444 */       super(param1Int);
/* 445 */       this.size = (this.mask == -1) ? Integer.MAX_VALUE : (this.mask + 1);
/* 446 */       this.c = new AtomicReferenceArray<>(this.size);
/* 447 */       this.a = param1M;
/*     */     }
/*     */ 
/*     */     
/*     */     public L f(int param1Int) {
/* 452 */       if (this.size != Integer.MAX_VALUE) {
/* 453 */         D.b(param1Int, size());
/*     */       }
/* 455 */       a<L> a = (a)this.c.get(param1Int);
/* 456 */       L l = (a == null) ? null : a.get();
/* 457 */       if (l != null) {
/* 458 */         return l;
/*     */       }
/* 460 */       Object object = this.a.get();
/* 461 */       a<? extends L> a1 = new a(object, param1Int, this.queue);
/* 462 */       while (!this.c.compareAndSet(param1Int, a, a1)) {
/*     */         
/* 464 */         a = (a<L>)this.c.get(param1Int);
/* 465 */         l = (a == null) ? null : a.get();
/* 466 */         if (l != null) {
/* 467 */           return l;
/*     */         }
/*     */       } 
/* 470 */       gn();
/* 471 */       return (L)object;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void gn() {
/*     */       Reference<? extends L> reference;
/* 479 */       while ((reference = this.queue.poll()) != null) {
/*     */         
/* 481 */         a<? extends L> a = (a)reference;
/*     */ 
/*     */         
/* 484 */         this.c.compareAndSet(a.index, a, null);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 490 */       return this.size;
/*     */     }
/*     */     
/*     */     private static final class a<L> extends WeakReference<L> {
/*     */       final int index;
/*     */       
/*     */       a(L param2L, int param2Int, ReferenceQueue<L> param2ReferenceQueue) {
/* 497 */         super(param2L, param2ReferenceQueue);
/* 498 */         this.index = param2Int;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.a.a.d
/*     */   static class b<L>
/*     */     extends e<L>
/*     */   {
/*     */     final ConcurrentMap<Integer, L> f;
/*     */     
/*     */     final M<L> a;
/*     */     
/*     */     final int size;
/*     */     
/*     */     b(int param1Int, M<L> param1M) {
/* 515 */       super(param1Int);
/* 516 */       this.size = (this.mask == -1) ? Integer.MAX_VALUE : (this.mask + 1);
/* 517 */       this.a = param1M;
/* 518 */       this.f = (new bU()).b().c();
/*     */     }
/*     */ 
/*     */     
/*     */     public L f(int param1Int) {
/* 523 */       if (this.size != Integer.MAX_VALUE) {
/* 524 */         D.b(param1Int, size());
/*     */       }
/* 526 */       L l = this.f.get(Integer.valueOf(param1Int));
/* 527 */       if (l != null) {
/* 528 */         return l;
/*     */       }
/* 530 */       Object object = this.a.get();
/* 531 */       l = this.f.putIfAbsent(Integer.valueOf(param1Int), (L)object);
/* 532 */       return (L)x.a(l, object);
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 537 */       return this.size;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int T(int paramInt) {
/* 545 */     return 1 << com.google.a.k.e.a(paramInt, RoundingMode.CEILING);
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
/*     */   private static int d(int paramInt) {
/* 558 */     paramInt ^= paramInt >>> 20 ^ paramInt >>> 12;
/* 559 */     return paramInt ^ paramInt >>> 7 ^ paramInt >>> 4;
/*     */   }
/*     */   
/*     */   public abstract L get(Object paramObject);
/*     */   
/*     */   public abstract L f(int paramInt);
/*     */   
/*     */   abstract int p(Object paramObject);
/*     */   
/*     */   public abstract int size();
/*     */   
/*     */   private static class c extends ReentrantLock { long bG;
/*     */     
/*     */     c() {
/* 573 */       super(false);
/*     */     }
/*     */     
/*     */     long bH;
/*     */     long bI; }
/*     */   
/*     */   private static class d extends Semaphore { long bG;
/*     */     long bH;
/*     */     long bI;
/*     */     
/*     */     d(int param1Int) {
/* 584 */       super(param1Int, false);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\ao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */