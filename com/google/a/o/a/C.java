/*      */ package com.google.a.o.a;
/*      */ 
/*      */ import com.google.a.a.b;
/*      */ import com.google.a.b.D;
/*      */ import com.google.a.b.L;
/*      */ import com.google.a.b.O;
/*      */ import com.google.a.o.a.a.a;
/*      */ import com.google.a.o.a.a.b;
/*      */ import com.google.c.a.f;
/*      */ import java.lang.reflect.Field;
/*      */ import java.security.AccessController;
/*      */ import java.security.PrivilegedActionException;
/*      */ import java.security.PrivilegedExceptionAction;
/*      */ import java.util.Locale;
/*      */ import java.util.concurrent.CancellationException;
/*      */ import java.util.concurrent.ExecutionException;
/*      */ import java.util.concurrent.Executor;
/*      */ import java.util.concurrent.Future;
/*      */ import java.util.concurrent.ScheduledFuture;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import java.util.concurrent.TimeoutException;
/*      */ import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
/*      */ import java.util.concurrent.locks.LockSupport;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
/*      */ import sun.misc.Unsafe;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */ @f(a = f.a.FULL)
/*      */ public abstract class c<V>
/*      */   extends a
/*      */   implements U<V>
/*      */ {
/*      */   private static final boolean bj;
/*      */   
/*      */   static {
/*      */     boolean bool;
/*      */     g g;
/*      */     try {
/*   81 */       bool = Boolean.parseBoolean(
/*   82 */           System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
/*   83 */     } catch (SecurityException securityException) {
/*   84 */       bool = false;
/*      */     } 
/*   86 */     bj = bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static interface h<V>
/*      */     extends U<V> {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static abstract class i<V>
/*      */     extends c<V>
/*      */     implements h<V>
/*      */   {
/*      */     @com.google.b.a.a
/*      */     public final V get() throws InterruptedException, ExecutionException {
/*  104 */       return super.get();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     @com.google.b.a.a
/*      */     public final V get(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
/*  111 */       return super.get(param1Long, param1TimeUnit);
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean isDone() {
/*  116 */       return super.isDone();
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean isCancelled() {
/*  121 */       return super.isCancelled();
/*      */     }
/*      */ 
/*      */     
/*      */     public final void a(Runnable param1Runnable, Executor param1Executor) {
/*  126 */       super.a(param1Runnable, param1Executor);
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.b.a.a
/*      */     public final boolean cancel(boolean param1Boolean) {
/*  132 */       return super.cancel(param1Boolean);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*  137 */   private static final Logger a = Logger.getLogger(c.class.getName());
/*      */ 
/*      */   
/*      */   private static final long bq = 1000L;
/*      */ 
/*      */   
/*      */   private static final a a;
/*      */ 
/*      */   
/*      */   static {
/*  147 */     Throwable throwable1 = null;
/*  148 */     Throwable throwable2 = null;
/*      */     
/*      */     try {
/*  151 */       j j = new j();
/*  152 */     } catch (Throwable throwable) {
/*  153 */       throwable1 = throwable;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       try {
/*  164 */         e e = new e(AtomicReferenceFieldUpdater.newUpdater(k.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(k.class, k.class, "c"), AtomicReferenceFieldUpdater.newUpdater(c.class, k.class, "a"), AtomicReferenceFieldUpdater.newUpdater(c.class, d.class, "a"), AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "value"));
/*  165 */       } catch (Throwable throwable3) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  170 */         throwable2 = throwable3;
/*  171 */         g = new g();
/*      */       } 
/*      */     } 
/*  174 */     a = (k)g;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  179 */     Class<LockSupport> clazz = LockSupport.class;
/*      */ 
/*      */ 
/*      */     
/*  183 */     if (throwable2 != null) {
/*  184 */       a.log(Level.SEVERE, "UnsafeAtomicHelper is broken!", throwable1);
/*  185 */       a.log(Level.SEVERE, "SafeAtomicHelper is broken!", throwable2);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static final class k
/*      */   {
/*  192 */     static final k b = new k(false);
/*      */ 
/*      */     
/*      */     volatile Thread thread;
/*      */ 
/*      */     
/*      */     volatile k c;
/*      */ 
/*      */     
/*      */     k(boolean param1Boolean) {}
/*      */ 
/*      */     
/*      */     k() {
/*  205 */       c.a().a(this, Thread.currentThread());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     void b(k param1k) {
/*  211 */       c.a().a(this, param1k);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void fH() {
/*  218 */       Thread thread = this.thread;
/*  219 */       if (thread != null) {
/*  220 */         this.thread = null;
/*  221 */         LockSupport.unpark(thread);
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
/*      */   private void a(k paramk) {
/*  238 */     paramk.thread = null;
/*      */     
/*      */     label22: while (true) {
/*  241 */       k k1 = null;
/*  242 */       k k2 = this.a;
/*  243 */       if (k2 == k.b) {
/*      */         return;
/*      */       }
/*      */       
/*  247 */       while (k2 != null) {
/*  248 */         k k3 = k2.c;
/*  249 */         if (k2.thread != null) {
/*  250 */           k1 = k2;
/*  251 */         } else if (k1 != null) {
/*  252 */           k1.c = k3;
/*  253 */           if (k1.thread == null) {
/*      */             continue label22;
/*      */           }
/*  256 */         } else if (!a.a(this, k2, k3)) {
/*      */           continue label22;
/*      */         } 
/*  259 */         k2 = k3;
/*      */       } 
/*      */       break;
/*      */     } 
/*      */   }
/*      */   
/*      */   private static final class d
/*      */   {
/*  267 */     static final d b = new d(null, null);
/*      */     
/*      */     final Runnable c;
/*      */     
/*      */     final Executor executor;
/*      */     d c;
/*      */     
/*      */     d(Runnable param1Runnable, Executor param1Executor) {
/*  275 */       this.c = (d)param1Runnable;
/*  276 */       this.executor = param1Executor;
/*      */     }
/*      */   }
/*      */   private volatile Object value;
/*      */   private volatile d a;
/*  281 */   private static final Object NULL = new Object();
/*      */   private volatile k a;
/*      */   
/*      */   private static final class c {
/*  285 */     static final c a = new c(new Throwable("Failure occurred while trying to finish a future.")
/*      */         {
/*      */           
/*      */           public synchronized Throwable fillInStackTrace()
/*      */           {
/*  290 */             return this;
/*      */           }
/*      */         });
/*      */ 
/*      */     
/*      */     c(Throwable param1Throwable) {
/*  296 */       this.c = (Throwable)D.checkNotNull(param1Throwable);
/*      */     }
/*      */     
/*      */     final Throwable c; }
/*      */   
/*      */   private static final class b { static final b a;
/*      */     static final b b;
/*      */     final boolean bk;
/*      */     final Throwable cause;
/*      */     
/*      */     static {
/*  307 */       if (c.dx()) {
/*  308 */         b = null;
/*  309 */         a = null;
/*      */       } else {
/*  311 */         b = new b(false, null);
/*  312 */         a = new b(true, null);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     b(boolean param1Boolean, Throwable param1Throwable) {
/*  320 */       this.bk = param1Boolean;
/*  321 */       this.cause = param1Throwable;
/*      */     } }
/*      */ 
/*      */   
/*      */   private static final class f<V>
/*      */     implements Runnable {
/*      */     final c<V> a;
/*      */     final U<? extends V> c;
/*      */     
/*      */     f(c<V> param1c, U<? extends V> param1U) {
/*  331 */       this.a = param1c;
/*  332 */       this.c = param1U;
/*      */     }
/*      */ 
/*      */     
/*      */     public void run() {
/*  337 */       if (c.a(this.a) != this) {
/*      */         return;
/*      */       }
/*      */       
/*  341 */       Object object = c.b(this.c);
/*  342 */       if (c.a().a(this.a, this, object)) {
/*  343 */         c.b(this.a);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */   public V get(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, TimeoutException, ExecutionException {
/*  414 */     long l1 = paramTimeUnit.toNanos(paramLong);
/*  415 */     long l2 = l1;
/*  416 */     if (Thread.interrupted()) {
/*  417 */       throw new InterruptedException();
/*      */     }
/*  419 */     Object object = this.value;
/*  420 */     if ((((object != null) ? 1 : 0) & (!(object instanceof f) ? 1 : 0)) != 0) {
/*  421 */       return I(object);
/*      */     }
/*      */     
/*  424 */     long l3 = (l2 > 0L) ? (System.nanoTime() + l2) : 0L;
/*      */     
/*  426 */     if (l2 >= 1000L) {
/*  427 */       k k1 = this.a;
/*  428 */       if (k1 != k.b) {
/*  429 */         k k2 = new k();
/*      */         label77: while (true) {
/*  431 */           k2.b(k1);
/*  432 */           if (a.a(this, k1, k2)) {
/*      */             do {
/*  434 */               ac.a(this, l2);
/*      */               
/*  436 */               if (Thread.interrupted()) {
/*  437 */                 a(k2);
/*  438 */                 throw new InterruptedException();
/*      */               } 
/*      */ 
/*      */ 
/*      */               
/*  443 */               object = this.value;
/*  444 */               if ((((object != null) ? 1 : 0) & (!(object instanceof f) ? 1 : 0)) != 0) {
/*  445 */                 return I(object);
/*      */               }
/*      */ 
/*      */               
/*  449 */               l2 = l3 - System.nanoTime();
/*  450 */             } while (l2 >= 1000L);
/*      */             
/*  452 */             a(k2);
/*      */             
/*      */             break;
/*      */           } 
/*      */           
/*  457 */           k1 = this.a;
/*  458 */           if (k1 == k.b)
/*      */             break label77; 
/*      */         } 
/*      */       } else {
/*  462 */         return I(this.value);
/*      */       } 
/*      */     } 
/*      */     
/*  466 */     while (l2 > 0L) {
/*  467 */       object = this.value;
/*  468 */       if ((((object != null) ? 1 : 0) & (!(object instanceof f) ? 1 : 0)) != 0) {
/*  469 */         return I(object);
/*      */       }
/*  471 */       if (Thread.interrupted()) {
/*  472 */         throw new InterruptedException();
/*      */       }
/*  474 */       l2 = l3 - System.nanoTime();
/*      */     } 
/*      */     
/*  477 */     String str1 = toString();
/*  478 */     String str2 = paramTimeUnit.toString().toLowerCase(Locale.ROOT);
/*  479 */     String str4 = paramTimeUnit.toString().toLowerCase(Locale.ROOT), str3 = (new StringBuilder(28 + String.valueOf(str4).length())).append("Waited ").append(paramLong).append(" ").append(str4).toString();
/*      */     
/*  481 */     if (l2 + 1000L < 0L) {
/*      */       
/*  483 */       str3 = String.valueOf(str3).concat(" (plus ");
/*  484 */       long l4 = -l2;
/*  485 */       long l5 = paramTimeUnit.convert(l4, TimeUnit.NANOSECONDS);
/*  486 */       long l6 = l4 - paramTimeUnit.toNanos(l5);
/*  487 */       boolean bool = (l5 == 0L || l6 > 1000L) ? true : false;
/*      */       
/*  489 */       if (l5 > 0L) {
/*  490 */         String str = String.valueOf(str3); str3 = (new StringBuilder(21 + String.valueOf(str).length() + String.valueOf(str2).length())).append(str).append(l5).append(" ").append(str2).toString();
/*  491 */         if (bool) {
/*  492 */           str3 = String.valueOf(str3).concat(",");
/*      */         }
/*  494 */         str3 = String.valueOf(str3).concat(" ");
/*      */       } 
/*  496 */       if (bool) {
/*  497 */         String str = String.valueOf(str3); str3 = (new StringBuilder(33 + String.valueOf(str).length())).append(str).append(l6).append(" nanoseconds ").toString();
/*      */       } 
/*      */       
/*  500 */       str3 = String.valueOf(str3).concat("delay)");
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  505 */     if (isDone()) {
/*  506 */       throw new TimeoutException(String.valueOf(str3).concat(" but future completed as timeout expired"));
/*      */     }
/*  508 */     str4 = str3; throw new TimeoutException((new StringBuilder(5 + String.valueOf(str4).length() + String.valueOf(str1).length())).append(str4).append(" for ").append(str1).toString());
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
/*      */   @com.google.b.a.a
/*      */   public V get() throws InterruptedException, ExecutionException {
/*  522 */     if (Thread.interrupted()) {
/*  523 */       throw new InterruptedException();
/*      */     }
/*  525 */     Object object = this.value;
/*  526 */     if ((((object != null) ? 1 : 0) & (!(object instanceof f) ? 1 : 0)) != 0) {
/*  527 */       return I(object);
/*      */     }
/*  529 */     k k1 = this.a;
/*  530 */     if (k1 != k.b) {
/*  531 */       k k2 = new k();
/*      */       do {
/*  533 */         k2.b(k1);
/*  534 */         if (a.a(this, k1, k2)) {
/*      */           while (true) {
/*      */             
/*  537 */             LockSupport.park(this);
/*      */             
/*  539 */             if (Thread.interrupted()) {
/*  540 */               a(k2);
/*  541 */               throw new InterruptedException();
/*      */             } 
/*      */ 
/*      */             
/*  545 */             object = this.value;
/*  546 */             if ((((object != null) ? 1 : 0) & (!(object instanceof f) ? 1 : 0)) != 0) {
/*  547 */               return I(object);
/*      */             }
/*      */           } 
/*      */         }
/*  551 */         k1 = this.a;
/*  552 */       } while (k1 != k.b);
/*      */     } 
/*      */ 
/*      */     
/*  556 */     return I(this.value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private V I(Object paramObject) throws ExecutionException {
/*  563 */     if (paramObject instanceof b)
/*  564 */       throw a("Task was cancelled.", ((b)paramObject).cause); 
/*  565 */     if (paramObject instanceof c)
/*  566 */       throw new ExecutionException(((c)paramObject).c); 
/*  567 */     if (paramObject == NULL) {
/*  568 */       return null;
/*      */     }
/*      */     
/*  571 */     return (V)paramObject;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isDone() {
/*  578 */     Object object = this.value;
/*  579 */     return ((object != null)) & (!(object instanceof f));
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isCancelled() {
/*  584 */     Object object = this.value;
/*  585 */     return object instanceof b;
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
/*      */   @com.google.b.a.a
/*      */   public boolean cancel(boolean paramBoolean) {
/*  607 */     Object object = this.value;
/*  608 */     boolean bool = false;
/*  609 */     if ((((object == null) ? 1 : 0) | object instanceof f) != 0) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  618 */       b b = bj ? new b(paramBoolean, new CancellationException("Future.cancel() was called.")) : (paramBoolean ? b.a : b.b);
/*  619 */       c<?> c1 = this;
/*      */       do {
/*  621 */         while (a.a(c1, object, b)) {
/*  622 */           bool = true;
/*      */ 
/*      */           
/*  625 */           if (paramBoolean) {
/*  626 */             c1.fF();
/*      */           }
/*  628 */           a(c1);
/*  629 */           if (object instanceof f) {
/*      */ 
/*      */             
/*  632 */             U u = ((f)object).c;
/*  633 */             if (u instanceof h) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */               
/*  641 */               c<?> c2 = (c)u;
/*  642 */               object = c2.value;
/*  643 */               if ((((object == null) ? 1 : 0) | object instanceof f) != 0) {
/*  644 */                 c1 = c2;
/*      */                 continue;
/*      */               } 
/*      */               // Byte code: goto -> 190
/*      */             } 
/*  649 */             u.cancel(paramBoolean);
/*      */             
/*      */             break;
/*      */           } 
/*      */           // Byte code: goto -> 190
/*      */         } 
/*  655 */         object = c1.value;
/*  656 */       } while (object instanceof f);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  664 */     return bool;
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
/*      */   protected void fF() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final boolean dw() {
/*  687 */     Object object = this.value;
/*  688 */     return (object instanceof b && ((b)object).bk);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(Runnable paramRunnable, Executor paramExecutor) {
/*  698 */     D.b(paramRunnable, "Runnable was null.");
/*  699 */     D.b(paramExecutor, "Executor was null.");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  709 */     if (!isDone()) {
/*  710 */       k k1 = this.a;
/*  711 */       if (k1 != d.b) {
/*  712 */         d d1 = new d(paramRunnable, paramExecutor);
/*      */         do {
/*  714 */           d1.c = (d)k1;
/*  715 */           if (a.a(this, (d)k1, d1)) {
/*      */             return;
/*      */           }
/*  718 */           k1 = this.a;
/*  719 */         } while (k1 != d.b);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  724 */     b(paramRunnable, paramExecutor);
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
/*      */   @com.google.b.a.a
/*      */   protected boolean c(V paramV) {
/*  744 */     Object object = (paramV == null) ? NULL : (Object)paramV;
/*  745 */     if (a.a(this, (Object)null, object)) {
/*  746 */       a(this);
/*  747 */       return true;
/*      */     } 
/*  749 */     return false;
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
/*      */   @com.google.b.a.a
/*      */   protected boolean a(Throwable paramThrowable) {
/*  769 */     c c1 = new c((Throwable)D.checkNotNull(paramThrowable));
/*  770 */     if (a.a(this, (Object)null, c1)) {
/*  771 */       a(this);
/*  772 */       return true;
/*      */     } 
/*  774 */     return false;
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
/*      */   @com.google.b.a.a
/*      */   protected boolean a(U<? extends V> paramU) {
/*  808 */     D.checkNotNull(paramU);
/*  809 */     Object object = this.value;
/*  810 */     if (object == null) {
/*  811 */       if (paramU.isDone()) {
/*  812 */         Object object1 = a(paramU);
/*  813 */         if (a.a(this, (Object)null, object1)) {
/*  814 */           a(this);
/*  815 */           return true;
/*      */         } 
/*  817 */         return false;
/*      */       } 
/*  819 */       f<V> f = new f<>(this, paramU);
/*  820 */       if (a.a(this, (Object)null, f)) {
/*      */ 
/*      */         
/*      */         try {
/*  824 */           paramU.a(f, (Executor)v.a);
/*  825 */         } catch (Throwable throwable) {
/*      */           c c1;
/*      */ 
/*      */ 
/*      */           
/*      */           try {
/*  831 */             c1 = new c(throwable);
/*  832 */           } catch (Throwable throwable1) {
/*  833 */             c1 = c.a;
/*      */           } 
/*      */           
/*  836 */           boolean bool = a.a(this, f, c1);
/*      */         } 
/*  838 */         return true;
/*      */       } 
/*  840 */       object = this.value;
/*      */     } 
/*      */ 
/*      */     
/*  844 */     if (object instanceof b)
/*      */     {
/*  846 */       paramU.cancel(((b)object).bk);
/*      */     }
/*  848 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Object a(U<?> paramU) {
/*  858 */     if (paramU instanceof h) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  863 */       Object object = ((c)paramU).value;
/*  864 */       if (object instanceof b) {
/*      */ 
/*      */ 
/*      */         
/*  868 */         b b = (b)object;
/*  869 */         if (b.bk)
/*      */         {
/*      */ 
/*      */           
/*  873 */           object = (b.cause != null) ? new b(false, b.cause) : b.b;
/*      */         }
/*      */       } 
/*  876 */       return object;
/*      */     } 
/*  878 */     if (paramU instanceof a) {
/*      */       
/*  880 */       Throwable throwable = b.a((a)paramU);
/*  881 */       if (throwable != null) {
/*  882 */         return new c(throwable);
/*      */       }
/*      */     } 
/*  885 */     boolean bool = paramU.isCancelled();
/*      */     
/*  887 */     if (((!bj ? 1 : 0) & bool) != 0) {
/*  888 */       return b.b;
/*      */     }
/*      */     
/*      */     try {
/*  892 */       Object object = a((Future)paramU);
/*  893 */       if (bool) {
/*  894 */         String str = String.valueOf(paramU); return new b(false, new IllegalArgumentException((new StringBuilder(84 + String.valueOf(str).length())).append("get() did not throw CancellationException, despite reporting isCancelled() == true: ").append(str).toString()));
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  901 */       return (object == null) ? NULL : object;
/*  902 */     } catch (ExecutionException executionException) {
/*  903 */       if (bool) {
/*  904 */         String str = String.valueOf(paramU); return new b(false, new IllegalArgumentException((new StringBuilder(84 + String.valueOf(str).length())).append("get() did not throw CancellationException, despite reporting isCancelled() == true: ").append(str).toString(), executionException));
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  912 */       return new c(executionException.getCause());
/*  913 */     } catch (CancellationException cancellationException) {
/*  914 */       if (!bool) {
/*  915 */         String str = String.valueOf(paramU); return new c(new IllegalArgumentException((new StringBuilder(77 + String.valueOf(str).length())).append("get() threw CancellationException, despite reporting isCancelled() == false: ").append(str).toString(), cancellationException));
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  921 */       return new b(false, cancellationException);
/*  922 */     } catch (Throwable throwable) {
/*  923 */       return new c(throwable);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static <V> V a(Future<V> paramFuture) throws ExecutionException {
/*  932 */     boolean bool = false;
/*      */     
/*      */     while (true) {
/*      */       try {
/*  936 */         return paramFuture.get();
/*  937 */       } catch (InterruptedException interruptedException) {
/*      */ 
/*      */       
/*      */       } finally {
/*      */         
/*  942 */         if (bool) {
/*  943 */           Thread.currentThread().interrupt();
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private static void a(c<?> paramc) {
/*  950 */     d d1 = null;
/*      */     
/*      */     label17: while (true) {
/*  953 */       paramc.fG();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  959 */       paramc.fx();
/*      */       
/*  961 */       d1 = paramc.a(d1);
/*  962 */       paramc = null;
/*  963 */       while (d1 != null) {
/*  964 */         d d2 = d1;
/*  965 */         d1 = d1.c;
/*  966 */         d d3 = d2.c;
/*  967 */         if (d3 instanceof f) {
/*  968 */           f f = (f)d3;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  974 */           paramc = f.a;
/*  975 */           if (paramc.value == f) {
/*  976 */             Object object = a(f.c);
/*  977 */             if (a.a(paramc, f, object)) {
/*      */               continue label17;
/*      */             }
/*      */           } 
/*      */           continue;
/*      */         } 
/*  983 */         b((Runnable)d3, d2.executor);
/*      */       } 
/*      */       break;
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
/*      */   @com.google.a.a.a
/*      */   @com.google.b.a.g
/*      */   protected void fx() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final Throwable b() {
/* 1028 */     if (this instanceof h) {
/* 1029 */       Object object = this.value;
/* 1030 */       if (object instanceof c) {
/* 1031 */         return ((c)object).c;
/*      */       }
/*      */     } 
/* 1034 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final void h(Future<?> paramFuture) {
/* 1042 */     if ((((paramFuture != null) ? 1 : 0) & isCancelled()) != 0) {
/* 1043 */       paramFuture.cancel(dw());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void fG() {
/*      */     while (true) {
/* 1051 */       k k1 = this.a;
/* 1052 */       if (a.a(this, k1, k.b)) {
/* 1053 */         for (k k2 = k1; k2 != null; k2 = k2.c) {
/* 1054 */           k2.fH();
/*      */         }
/*      */         return;
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
/*      */   private d a(d paramd) {
/*      */     while (true) {
/* 1071 */       k k1 = this.a;
/* 1072 */       if (a.a(this, (d)k1, d.b)) {
/* 1073 */         k k2; d d1 = paramd;
/* 1074 */         while (k1 != null) {
/* 1075 */           k k3 = k1;
/* 1076 */           d d2 = ((d)k1).c;
/* 1077 */           ((d)k3).c = d1;
/* 1078 */           k2 = k3;
/*      */         } 
/* 1080 */         return (d)k2;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1087 */     StringBuilder stringBuilder = new StringBuilder();
/* 1088 */     if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
/* 1089 */       stringBuilder.append(getClass().getSimpleName());
/*      */     } else {
/* 1091 */       stringBuilder.append(getClass().getName());
/*      */     } 
/* 1093 */     stringBuilder.append('@').append(Integer.toHexString(System.identityHashCode(this))).append("[status=");
/* 1094 */     if (isCancelled()) {
/* 1095 */       stringBuilder.append("CANCELLED");
/* 1096 */     } else if (isDone()) {
/* 1097 */       e(stringBuilder);
/*      */     } else {
/* 1099 */       d(stringBuilder);
/*      */     } 
/* 1101 */     return stringBuilder.append("]").toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String ds() {
/* 1112 */     if (this instanceof ScheduledFuture) {
/*      */       
/* 1114 */       long l = ((ScheduledFuture)this).getDelay(TimeUnit.MILLISECONDS); return (new StringBuilder(41)).append("remaining delay=[").append(l).append(" ms]").toString();
/*      */     } 
/*      */     
/* 1117 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void d(StringBuilder paramStringBuilder) {
/* 1123 */     int i = paramStringBuilder.length();
/*      */     
/* 1125 */     paramStringBuilder.append("PENDING");
/*      */     
/* 1127 */     Object object = this.value;
/* 1128 */     if (object instanceof f) {
/* 1129 */       paramStringBuilder.append(", setFuture=[");
/* 1130 */       b(paramStringBuilder, ((f)object).c);
/* 1131 */       paramStringBuilder.append("]");
/*      */     } else {
/*      */       String str;
/*      */       try {
/* 1135 */         str = L.aq(ds());
/* 1136 */       } catch (RuntimeException|StackOverflowError runtimeException) {
/*      */ 
/*      */         
/* 1139 */         String str1 = String.valueOf(runtimeException.getClass()); str = (new StringBuilder(38 + String.valueOf(str1).length())).append("Exception thrown from implementation: ").append(str1).toString();
/*      */       } 
/* 1141 */       if (str != null) {
/* 1142 */         paramStringBuilder.append(", info=[").append(str).append("]");
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1148 */     if (isDone()) {
/*      */       
/* 1150 */       paramStringBuilder.delete(i, paramStringBuilder.length());
/* 1151 */       e(paramStringBuilder);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void e(StringBuilder paramStringBuilder) {
/*      */     try {
/* 1157 */       Object object = a(this);
/* 1158 */       paramStringBuilder.append("SUCCESS, result=[");
/* 1159 */       a(paramStringBuilder, object);
/* 1160 */       paramStringBuilder.append("]");
/* 1161 */     } catch (ExecutionException executionException) {
/* 1162 */       paramStringBuilder.append("FAILURE, cause=[").append(executionException.getCause()).append("]");
/* 1163 */     } catch (CancellationException cancellationException) {
/* 1164 */       paramStringBuilder.append("CANCELLED");
/* 1165 */     } catch (RuntimeException runtimeException) {
/* 1166 */       paramStringBuilder.append("UNKNOWN, cause=[").append(runtimeException.getClass()).append(" thrown from get()]");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(StringBuilder paramStringBuilder, Object paramObject) {
/* 1176 */     if (paramObject == null) {
/* 1177 */       paramStringBuilder.append("null");
/* 1178 */     } else if (paramObject == this) {
/* 1179 */       paramStringBuilder.append("this future");
/*      */     } else {
/* 1181 */       paramStringBuilder
/* 1182 */         .append(paramObject.getClass().getName())
/* 1183 */         .append("@")
/* 1184 */         .append(Integer.toHexString(System.identityHashCode(paramObject)));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b(StringBuilder paramStringBuilder, Object paramObject) {
/*      */     try {
/* 1195 */       if (paramObject == this) {
/* 1196 */         paramStringBuilder.append("this future");
/*      */       } else {
/* 1198 */         paramStringBuilder.append(paramObject);
/*      */       } 
/* 1200 */     } catch (RuntimeException|StackOverflowError runtimeException) {
/*      */ 
/*      */       
/* 1203 */       paramStringBuilder.append("Exception thrown from implementation: ").append(runtimeException.getClass());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void b(Runnable paramRunnable, Executor paramExecutor) {
/*      */     try {
/* 1213 */       paramExecutor.execute(paramRunnable);
/* 1214 */     } catch (RuntimeException runtimeException) {
/*      */ 
/*      */ 
/*      */       
/* 1218 */       String str1 = String.valueOf(paramRunnable), str2 = String.valueOf(paramExecutor); a.log(Level.SEVERE, (new StringBuilder(57 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("RuntimeException while executing runnable ").append(str1).append(" with executor ").append(str2).toString(), runtimeException);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static abstract class a
/*      */   {
/*      */     private a() {}
/*      */ 
/*      */     
/*      */     abstract void a(c.k param1k, Thread param1Thread);
/*      */ 
/*      */     
/*      */     abstract void a(c.k param1k1, c.k param1k2);
/*      */ 
/*      */     
/*      */     abstract boolean a(c<?> param1c, c.k param1k1, c.k param1k2);
/*      */ 
/*      */     
/*      */     abstract boolean a(c<?> param1c, c.d param1d1, c.d param1d2);
/*      */ 
/*      */     
/*      */     abstract boolean a(c<?> param1c, Object param1Object1, Object param1Object2);
/*      */   }
/*      */ 
/*      */   
/*      */   private static final class j
/*      */     extends a
/*      */   {
/*      */     static final Unsafe a;
/*      */     static final long br;
/*      */     static final long bs;
/*      */     static final long bt;
/*      */     static final long bu;
/*      */     static final long bv;
/*      */     
/*      */     private j() {}
/*      */     
/*      */     static {
/* 1257 */       Unsafe unsafe = null;
/*      */       try {
/* 1259 */         unsafe = Unsafe.getUnsafe();
/* 1260 */       } catch (SecurityException securityException) {
/*      */         
/*      */         try {
/* 1263 */           unsafe = AccessController.<Unsafe>doPrivileged(new PrivilegedExceptionAction<Unsafe>()
/*      */               {
/*      */                 public Unsafe c() throws Exception
/*      */                 {
/* 1267 */                   Class<Unsafe> clazz = Unsafe.class;
/* 1268 */                   for (Field field : clazz.getDeclaredFields()) {
/* 1269 */                     field.setAccessible(true);
/* 1270 */                     Object object = field.get((Object)null);
/* 1271 */                     if (clazz.isInstance(object)) {
/* 1272 */                       return clazz.cast(object);
/*      */                     }
/*      */                   } 
/* 1275 */                   throw new NoSuchFieldError("the Unsafe");
/*      */                 }
/*      */               });
/* 1278 */         } catch (PrivilegedActionException privilegedActionException) {
/* 1279 */           throw new RuntimeException("Could not initialize intrinsics", privilegedActionException.getCause());
/*      */         } 
/*      */       } 
/*      */       try {
/* 1283 */         Class<c> clazz = c.class;
/* 1284 */         bs = unsafe.objectFieldOffset(clazz.getDeclaredField("waiters"));
/* 1285 */         br = unsafe.objectFieldOffset(clazz.getDeclaredField("listeners"));
/* 1286 */         bt = unsafe.objectFieldOffset(clazz.getDeclaredField("value"));
/* 1287 */         bu = unsafe.objectFieldOffset(c.k.class.getDeclaredField("thread"));
/* 1288 */         bv = unsafe.objectFieldOffset(c.k.class.getDeclaredField("c"));
/* 1289 */         a = unsafe;
/* 1290 */       } catch (Exception exception) {
/* 1291 */         O.a(exception);
/* 1292 */         throw new RuntimeException(exception);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     void a(c.k param1k, Thread param1Thread) {
/* 1298 */       a.putObject(param1k, bu, param1Thread);
/*      */     }
/*      */ 
/*      */     
/*      */     void a(c.k param1k1, c.k param1k2) {
/* 1303 */       a.putObject(param1k1, bv, param1k2);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     boolean a(c<?> param1c, c.k param1k1, c.k param1k2) {
/* 1309 */       return a.compareAndSwapObject(param1c, bs, param1k1, param1k2);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     boolean a(c<?> param1c, c.d param1d1, c.d param1d2) {
/* 1315 */       return a.compareAndSwapObject(param1c, br, param1d1, param1d2);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     boolean a(c<?> param1c, Object param1Object1, Object param1Object2) {
/* 1321 */       return a.compareAndSwapObject(param1c, bt, param1Object1, param1Object2);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static final class e
/*      */     extends a
/*      */   {
/*      */     final AtomicReferenceFieldUpdater<c.k, Thread> a;
/*      */     
/*      */     final AtomicReferenceFieldUpdater<c.k, c.k> b;
/*      */     
/*      */     final AtomicReferenceFieldUpdater<c, c.k> c;
/*      */     
/*      */     final AtomicReferenceFieldUpdater<c, c.d> d;
/*      */     final AtomicReferenceFieldUpdater<c, Object> e;
/*      */     
/*      */     e(AtomicReferenceFieldUpdater<c.k, Thread> param1AtomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<c.k, c.k> param1AtomicReferenceFieldUpdater1, AtomicReferenceFieldUpdater<c, c.k> param1AtomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<c, c.d> param1AtomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<c, Object> param1AtomicReferenceFieldUpdater4) {
/* 1339 */       this.a = param1AtomicReferenceFieldUpdater;
/* 1340 */       this.b = param1AtomicReferenceFieldUpdater1;
/* 1341 */       this.c = param1AtomicReferenceFieldUpdater2;
/* 1342 */       this.d = param1AtomicReferenceFieldUpdater3;
/* 1343 */       this.e = param1AtomicReferenceFieldUpdater4;
/*      */     }
/*      */ 
/*      */     
/*      */     void a(c.k param1k, Thread param1Thread) {
/* 1348 */       this.a.lazySet(param1k, param1Thread);
/*      */     }
/*      */ 
/*      */     
/*      */     void a(c.k param1k1, c.k param1k2) {
/* 1353 */       this.b.lazySet(param1k1, param1k2);
/*      */     }
/*      */ 
/*      */     
/*      */     boolean a(c<?> param1c, c.k param1k1, c.k param1k2) {
/* 1358 */       return this.c.compareAndSet(param1c, param1k1, param1k2);
/*      */     }
/*      */ 
/*      */     
/*      */     boolean a(c<?> param1c, c.d param1d1, c.d param1d2) {
/* 1363 */       return this.d.compareAndSet(param1c, param1d1, param1d2);
/*      */     }
/*      */ 
/*      */     
/*      */     boolean a(c<?> param1c, Object param1Object1, Object param1Object2) {
/* 1368 */       return this.e.compareAndSet(param1c, param1Object1, param1Object2);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class g
/*      */     extends a
/*      */   {
/*      */     private g() {}
/*      */ 
/*      */     
/*      */     void a(c.k param1k, Thread param1Thread) {
/* 1381 */       param1k.thread = param1Thread;
/*      */     }
/*      */ 
/*      */     
/*      */     void a(c.k param1k1, c.k param1k2) {
/* 1386 */       param1k1.c = param1k2;
/*      */     }
/*      */ 
/*      */     
/*      */     boolean a(c<?> param1c, c.k param1k1, c.k param1k2) {
/* 1391 */       synchronized (param1c) {
/* 1392 */         if (c.a(param1c) == param1k1) {
/* 1393 */           c.a(param1c, param1k2);
/* 1394 */           return true;
/*      */         } 
/* 1396 */         return false;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     boolean a(c<?> param1c, c.d param1d1, c.d param1d2) {
/* 1402 */       synchronized (param1c) {
/* 1403 */         if (c.a(param1c) == param1d1) {
/* 1404 */           c.a(param1c, param1d2);
/* 1405 */           return true;
/*      */         } 
/* 1407 */         return false;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     boolean a(c<?> param1c, Object param1Object1, Object param1Object2) {
/* 1413 */       synchronized (param1c) {
/* 1414 */         if (c.a(param1c) == param1Object1) {
/* 1415 */           c.a(param1c, param1Object2);
/* 1416 */           return true;
/*      */         } 
/* 1418 */         return false;
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static CancellationException a(String paramString, Throwable paramThrowable) {
/* 1425 */     CancellationException cancellationException = new CancellationException(paramString);
/* 1426 */     cancellationException.initCause(paramThrowable);
/* 1427 */     return cancellationException;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */