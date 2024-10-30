/*      */ package com.google.a.o.a;
/*      */ 
/*      */ import com.google.a.a.a;
/*      */ import com.google.a.a.c;
/*      */ import com.google.a.b.D;
/*      */ import com.google.a.m.m;
/*      */ import com.google.c.a.i;
/*      */ import java.time.Duration;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import java.util.concurrent.locks.Condition;
/*      */ import java.util.concurrent.locks.ReentrantLock;
/*      */ import java.util.function.BooleanSupplier;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @a
/*      */ @c
/*      */ public final class aa
/*      */ {
/*      */   private final boolean bs;
/*      */   private final ReentrantLock lock;
/*      */   
/*      */   @a
/*      */   public static abstract class a
/*      */   {
/*      */     @i
/*      */     final aa a;
/*      */     final Condition condition;
/*      */     @com.google.b.a.a.a("monitor.lock")
/*  312 */     int gr = 0;
/*      */ 
/*      */     
/*      */     @com.google.b.a.a.a("monitor.lock")
/*      */     a f;
/*      */ 
/*      */ 
/*      */     
/*      */     protected a(aa param1aa) {
/*  321 */       this.a = (aa)D.b(param1aa, "monitor");
/*  322 */       this.condition = aa.a(param1aa).newCondition();
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
/*      */     public abstract boolean dy();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.b.a.a.a("lock")
/*  343 */   private a e = null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public aa() {
/*  351 */     this(false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public aa(boolean paramBoolean) {
/*  361 */     this.bs = paramBoolean;
/*  362 */     this.lock = new ReentrantLock(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public a a(BooleanSupplier paramBooleanSupplier) {
/*  373 */     D.b(paramBooleanSupplier, "isSatisfied");
/*  374 */     return new a(this, this, paramBooleanSupplier)
/*      */       {
/*      */         public boolean dy() {
/*  377 */           return this.a.getAsBoolean();
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */   
/*      */   public void enter() {
/*  384 */     this.lock.lock();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean a(Duration paramDuration) {
/*  394 */     return a(R.a(paramDuration), TimeUnit.NANOSECONDS);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean a(long paramLong, TimeUnit paramTimeUnit) {
/*  404 */     long l = a(paramLong, paramTimeUnit);
/*  405 */     ReentrantLock reentrantLock = this.lock;
/*  406 */     if (!this.bs && reentrantLock.tryLock()) {
/*  407 */       return true;
/*      */     }
/*  409 */     boolean bool = Thread.interrupted();
/*      */     try {
/*  411 */       long l1 = System.nanoTime();
/*  412 */       long l2 = l; while (true) {
/*      */         try {
/*  414 */           return reentrantLock.tryLock(l2, TimeUnit.NANOSECONDS);
/*  415 */         } catch (InterruptedException interruptedException) {
/*  416 */           bool = true;
/*  417 */           l2 = p(l1, l);
/*      */         } 
/*      */       } 
/*      */     } finally {
/*  421 */       if (bool) {
/*  422 */         Thread.currentThread().interrupt();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void fW() throws InterruptedException {
/*  433 */     this.lock.lockInterruptibly();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean b(Duration paramDuration) throws InterruptedException {
/*  444 */     return b(R.a(paramDuration), TimeUnit.NANOSECONDS);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean b(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
/*  455 */     return this.lock.tryLock(paramLong, paramTimeUnit);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean dC() {
/*  466 */     return this.lock.tryLock();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(a parama) throws InterruptedException {
/*  475 */     if (parama.a != this) {
/*  476 */       throw new IllegalMonitorStateException();
/*      */     }
/*  478 */     ReentrantLock reentrantLock = this.lock;
/*  479 */     boolean bool = reentrantLock.isHeldByCurrentThread();
/*  480 */     reentrantLock.lockInterruptibly();
/*      */     
/*  482 */     boolean bool1 = false;
/*      */     try {
/*  484 */       if (!parama.dy()) {
/*  485 */         a(parama, bool);
/*      */       }
/*  487 */       bool1 = true;
/*      */     } finally {
/*  489 */       if (!bool1) {
/*  490 */         fX();
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
/*      */   public boolean a(a parama, Duration paramDuration) throws InterruptedException {
/*  505 */     return a(parama, R.a(paramDuration), TimeUnit.NANOSECONDS);
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
/*      */   public boolean a(a parama, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
/*      */     // Byte code:
/*      */     //   0: lload_2
/*      */     //   1: aload #4
/*      */     //   3: invokestatic a : (JLjava/util/concurrent/TimeUnit;)J
/*      */     //   6: lstore #5
/*      */     //   8: aload_1
/*      */     //   9: getfield a : Lcom/google/a/o/a/aa;
/*      */     //   12: aload_0
/*      */     //   13: if_acmpeq -> 24
/*      */     //   16: new java/lang/IllegalMonitorStateException
/*      */     //   19: dup
/*      */     //   20: invokespecial <init> : ()V
/*      */     //   23: athrow
/*      */     //   24: aload_0
/*      */     //   25: getfield lock : Ljava/util/concurrent/locks/ReentrantLock;
/*      */     //   28: astore #7
/*      */     //   30: aload #7
/*      */     //   32: invokevirtual isHeldByCurrentThread : ()Z
/*      */     //   35: istore #8
/*      */     //   37: lconst_0
/*      */     //   38: lstore #9
/*      */     //   40: aload_0
/*      */     //   41: getfield bs : Z
/*      */     //   44: ifne -> 72
/*      */     //   47: invokestatic interrupted : ()Z
/*      */     //   50: ifeq -> 61
/*      */     //   53: new java/lang/InterruptedException
/*      */     //   56: dup
/*      */     //   57: invokespecial <init> : ()V
/*      */     //   60: athrow
/*      */     //   61: aload #7
/*      */     //   63: invokevirtual tryLock : ()Z
/*      */     //   66: ifeq -> 72
/*      */     //   69: goto -> 92
/*      */     //   72: lload #5
/*      */     //   74: invokestatic j : (J)J
/*      */     //   77: lstore #9
/*      */     //   79: aload #7
/*      */     //   81: lload_2
/*      */     //   82: aload #4
/*      */     //   84: invokevirtual tryLock : (JLjava/util/concurrent/TimeUnit;)Z
/*      */     //   87: ifne -> 92
/*      */     //   90: iconst_0
/*      */     //   91: ireturn
/*      */     //   92: iconst_0
/*      */     //   93: istore #11
/*      */     //   95: iconst_1
/*      */     //   96: istore #12
/*      */     //   98: aload_1
/*      */     //   99: invokevirtual dy : ()Z
/*      */     //   102: ifne -> 134
/*      */     //   105: aload_0
/*      */     //   106: aload_1
/*      */     //   107: lload #9
/*      */     //   109: lconst_0
/*      */     //   110: lcmp
/*      */     //   111: ifne -> 119
/*      */     //   114: lload #5
/*      */     //   116: goto -> 126
/*      */     //   119: lload #9
/*      */     //   121: lload #5
/*      */     //   123: invokestatic p : (JJ)J
/*      */     //   126: iload #8
/*      */     //   128: invokespecial a : (Lcom/google/a/o/a/aa$a;JZ)Z
/*      */     //   131: ifeq -> 138
/*      */     //   134: iconst_1
/*      */     //   135: goto -> 139
/*      */     //   138: iconst_0
/*      */     //   139: istore #11
/*      */     //   141: iconst_0
/*      */     //   142: istore #12
/*      */     //   144: iload #11
/*      */     //   146: istore #13
/*      */     //   148: iload #11
/*      */     //   150: ifne -> 185
/*      */     //   153: iload #12
/*      */     //   155: ifeq -> 167
/*      */     //   158: iload #8
/*      */     //   160: ifne -> 167
/*      */     //   163: aload_0
/*      */     //   164: invokespecial fY : ()V
/*      */     //   167: aload #7
/*      */     //   169: invokevirtual unlock : ()V
/*      */     //   172: goto -> 185
/*      */     //   175: astore #14
/*      */     //   177: aload #7
/*      */     //   179: invokevirtual unlock : ()V
/*      */     //   182: aload #14
/*      */     //   184: athrow
/*      */     //   185: iload #13
/*      */     //   187: ireturn
/*      */     //   188: astore #15
/*      */     //   190: iload #11
/*      */     //   192: ifne -> 227
/*      */     //   195: iload #12
/*      */     //   197: ifeq -> 209
/*      */     //   200: iload #8
/*      */     //   202: ifne -> 209
/*      */     //   205: aload_0
/*      */     //   206: invokespecial fY : ()V
/*      */     //   209: aload #7
/*      */     //   211: invokevirtual unlock : ()V
/*      */     //   214: goto -> 227
/*      */     //   217: astore #16
/*      */     //   219: aload #7
/*      */     //   221: invokevirtual unlock : ()V
/*      */     //   224: aload #16
/*      */     //   226: athrow
/*      */     //   227: aload #15
/*      */     //   229: athrow
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #518	-> 0
/*      */     //   #519	-> 8
/*      */     //   #520	-> 16
/*      */     //   #522	-> 24
/*      */     //   #523	-> 30
/*      */     //   #524	-> 37
/*      */     //   #528	-> 40
/*      */     //   #530	-> 47
/*      */     //   #531	-> 53
/*      */     //   #533	-> 61
/*      */     //   #534	-> 69
/*      */     //   #537	-> 72
/*      */     //   #538	-> 79
/*      */     //   #539	-> 90
/*      */     //   #543	-> 92
/*      */     //   #544	-> 95
/*      */     //   #546	-> 98
/*      */     //   #547	-> 99
/*      */     //   #550	-> 107
/*      */     //   #548	-> 128
/*      */     //   #552	-> 141
/*      */     //   #553	-> 144
/*      */     //   #555	-> 148
/*      */     //   #558	-> 153
/*      */     //   #559	-> 163
/*      */     //   #562	-> 167
/*      */     //   #563	-> 172
/*      */     //   #562	-> 175
/*      */     //   #563	-> 182
/*      */     //   #553	-> 185
/*      */     //   #555	-> 188
/*      */     //   #558	-> 195
/*      */     //   #559	-> 205
/*      */     //   #562	-> 209
/*      */     //   #563	-> 214
/*      */     //   #562	-> 217
/*      */     //   #563	-> 224
/*      */     //   #565	-> 227
/*      */     // Exception table:
/*      */     //   from	to	target	type
/*      */     //   98	148	188	finally
/*      */     //   153	167	175	finally
/*      */     //   175	177	175	finally
/*      */     //   188	190	188	finally
/*      */     //   195	209	217	finally
/*      */     //   217	219	217	finally
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
/*      */   public void b(a parama) {
/*  570 */     if (parama.a != this) {
/*  571 */       throw new IllegalMonitorStateException();
/*      */     }
/*  573 */     ReentrantLock reentrantLock = this.lock;
/*  574 */     boolean bool = reentrantLock.isHeldByCurrentThread();
/*  575 */     reentrantLock.lock();
/*      */     
/*  577 */     boolean bool1 = false;
/*      */     try {
/*  579 */       if (!parama.dy()) {
/*  580 */         b(parama, bool);
/*      */       }
/*  582 */       bool1 = true;
/*      */     } finally {
/*  584 */       if (!bool1) {
/*  585 */         fX();
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
/*      */   public boolean b(a parama, Duration paramDuration) {
/*  598 */     return b(parama, R.a(paramDuration), TimeUnit.NANOSECONDS);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean b(a parama, long paramLong, TimeUnit paramTimeUnit) {
/*  609 */     long l1 = a(paramLong, paramTimeUnit);
/*  610 */     if (parama.a != this) {
/*  611 */       throw new IllegalMonitorStateException();
/*      */     }
/*  613 */     ReentrantLock reentrantLock = this.lock;
/*  614 */     long l2 = 0L;
/*  615 */     boolean bool1 = reentrantLock.isHeldByCurrentThread();
/*  616 */     boolean bool2 = Thread.interrupted();
/*      */     try {
/*  618 */       if (this.bs || !reentrantLock.tryLock()) {
/*  619 */         l2 = j(l1);
/*  620 */         long l = l1; while (true) {
/*      */           try {
/*  622 */             if (reentrantLock.tryLock(l, TimeUnit.NANOSECONDS)) {
/*      */               break;
/*      */             }
/*  625 */             return false;
/*      */           }
/*  627 */           catch (InterruptedException interruptedException) {
/*  628 */             bool2 = true;
/*  629 */             l = p(l2, l1);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/*  634 */       boolean bool = false;
/*      */       
/*      */       while (true) {
/*      */         try {
/*  638 */           if (parama.dy()) {
/*  639 */             bool = true;
/*      */           } else {
/*      */             long l;
/*  642 */             if (l2 == 0L) {
/*  643 */               l2 = j(l1);
/*  644 */               l = l1;
/*      */             } else {
/*  646 */               l = p(l2, l1);
/*      */             } 
/*  648 */             bool = a(parama, l, bool1);
/*      */           } 
/*  650 */           return bool;
/*  651 */         } catch (InterruptedException interruptedException) {
/*  652 */           bool2 = true;
/*      */         
/*      */         }
/*      */         finally {
/*      */           
/*  657 */           if (!bool)
/*  658 */             reentrantLock.unlock(); 
/*      */         } 
/*      */       } 
/*      */     } finally {
/*  662 */       if (bool2) {
/*  663 */         Thread.currentThread().interrupt();
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
/*      */   public boolean a(a parama) {
/*  675 */     if (parama.a != this) {
/*  676 */       throw new IllegalMonitorStateException();
/*      */     }
/*  678 */     ReentrantLock reentrantLock = this.lock;
/*  679 */     reentrantLock.lock();
/*      */     
/*  681 */     boolean bool = false;
/*      */     try {
/*  683 */       return bool = parama.dy();
/*      */     } finally {
/*  685 */       if (!bool) {
/*  686 */         reentrantLock.unlock();
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
/*      */   public boolean c(a parama, Duration paramDuration) {
/*  699 */     return c(parama, R.a(paramDuration), TimeUnit.NANOSECONDS);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean c(a parama, long paramLong, TimeUnit paramTimeUnit) {
/*  710 */     if (parama.a != this) {
/*  711 */       throw new IllegalMonitorStateException();
/*      */     }
/*  713 */     if (!a(paramLong, paramTimeUnit)) {
/*  714 */       return false;
/*      */     }
/*      */     
/*  717 */     boolean bool = false;
/*      */     try {
/*  719 */       return bool = parama.dy();
/*      */     } finally {
/*  721 */       if (!bool) {
/*  722 */         this.lock.unlock();
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
/*      */   public boolean b(a parama) throws InterruptedException {
/*  735 */     if (parama.a != this) {
/*  736 */       throw new IllegalMonitorStateException();
/*      */     }
/*  738 */     ReentrantLock reentrantLock = this.lock;
/*  739 */     reentrantLock.lockInterruptibly();
/*      */     
/*  741 */     boolean bool = false;
/*      */     try {
/*  743 */       return bool = parama.dy();
/*      */     } finally {
/*  745 */       if (!bool) {
/*  746 */         reentrantLock.unlock();
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
/*      */   public boolean d(a parama, Duration paramDuration) throws InterruptedException {
/*  759 */     return d(parama, R.a(paramDuration), TimeUnit.NANOSECONDS);
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
/*      */   public boolean d(a parama, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
/*  771 */     if (parama.a != this) {
/*  772 */       throw new IllegalMonitorStateException();
/*      */     }
/*  774 */     ReentrantLock reentrantLock = this.lock;
/*  775 */     if (!reentrantLock.tryLock(paramLong, paramTimeUnit)) {
/*  776 */       return false;
/*      */     }
/*      */     
/*  779 */     boolean bool = false;
/*      */     try {
/*  781 */       return bool = parama.dy();
/*      */     } finally {
/*  783 */       if (!bool) {
/*  784 */         reentrantLock.unlock();
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
/*      */   public boolean c(a parama) {
/*  798 */     if (parama.a != this) {
/*  799 */       throw new IllegalMonitorStateException();
/*      */     }
/*  801 */     ReentrantLock reentrantLock = this.lock;
/*  802 */     if (!reentrantLock.tryLock()) {
/*  803 */       return false;
/*      */     }
/*      */     
/*  806 */     boolean bool = false;
/*      */     try {
/*  808 */       return bool = parama.dy();
/*      */     } finally {
/*  810 */       if (!bool) {
/*  811 */         reentrantLock.unlock();
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
/*      */   public void c(a parama) throws InterruptedException {
/*  823 */     if ((((parama.a == this) ? 1 : 0) & this.lock.isHeldByCurrentThread()) == 0) {
/*  824 */       throw new IllegalMonitorStateException();
/*      */     }
/*  826 */     if (!parama.dy()) {
/*  827 */       a(parama, true);
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
/*      */   public boolean e(a parama, Duration paramDuration) throws InterruptedException {
/*  840 */     return e(parama, R.a(paramDuration), TimeUnit.NANOSECONDS);
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
/*      */   public boolean e(a parama, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
/*  852 */     long l = a(paramLong, paramTimeUnit);
/*  853 */     if ((((parama.a == this) ? 1 : 0) & this.lock.isHeldByCurrentThread()) == 0) {
/*  854 */       throw new IllegalMonitorStateException();
/*      */     }
/*  856 */     if (parama.dy()) {
/*  857 */       return true;
/*      */     }
/*  859 */     if (Thread.interrupted()) {
/*  860 */       throw new InterruptedException();
/*      */     }
/*  862 */     return a(parama, l, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void d(a parama) {
/*  870 */     if ((((parama.a == this) ? 1 : 0) & this.lock.isHeldByCurrentThread()) == 0) {
/*  871 */       throw new IllegalMonitorStateException();
/*      */     }
/*  873 */     if (!parama.dy()) {
/*  874 */       b(parama, true);
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
/*      */   public boolean f(a parama, Duration paramDuration) {
/*  886 */     return f(parama, R.a(paramDuration), TimeUnit.NANOSECONDS);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean f(a parama, long paramLong, TimeUnit paramTimeUnit) {
/*  897 */     long l1 = a(paramLong, paramTimeUnit);
/*  898 */     if ((((parama.a == this) ? 1 : 0) & this.lock.isHeldByCurrentThread()) == 0) {
/*  899 */       throw new IllegalMonitorStateException();
/*      */     }
/*  901 */     if (parama.dy()) {
/*  902 */       return true;
/*      */     }
/*  904 */     boolean bool = true;
/*  905 */     long l2 = j(l1);
/*  906 */     boolean bool1 = Thread.interrupted();
/*      */     try {
/*  908 */       long l = l1; while (true) {
/*      */         try {
/*  910 */           return a(parama, l, bool);
/*  911 */         } catch (InterruptedException interruptedException) {
/*  912 */           bool1 = true;
/*  913 */           if (parama.dy()) {
/*  914 */             return true;
/*      */           }
/*  916 */           bool = false;
/*  917 */           l = p(l2, l1);
/*      */         } 
/*      */       } 
/*      */     } finally {
/*  921 */       if (bool1) {
/*  922 */         Thread.currentThread().interrupt();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void fX() {
/*  929 */     ReentrantLock reentrantLock = this.lock;
/*      */     
/*      */     try {
/*  932 */       if (reentrantLock.getHoldCount() == 1) {
/*  933 */         fY();
/*      */       }
/*      */     } finally {
/*  936 */       reentrantLock.unlock();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean dD() {
/*  942 */     return this.bs;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isOccupied() {
/*  950 */     return this.lock.isLocked();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean dE() {
/*  958 */     return this.lock.isHeldByCurrentThread();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int ay() {
/*  966 */     return this.lock.getHoldCount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int az() {
/*  976 */     return this.lock.getQueueLength();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean dF() {
/*  986 */     return this.lock.hasQueuedThreads();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean a(Thread paramThread) {
/*  996 */     return this.lock.hasQueuedThread(paramThread);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean d(a parama) {
/* 1006 */     return (a(parama) > 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int a(a parama) {
/* 1016 */     if (parama.a != this) {
/* 1017 */       throw new IllegalMonitorStateException();
/*      */     }
/* 1019 */     this.lock.lock();
/*      */     try {
/* 1021 */       return parama.gr;
/*      */     } finally {
/* 1023 */       this.lock.unlock();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static long a(long paramLong, TimeUnit paramTimeUnit) {
/* 1033 */     long l = paramTimeUnit.toNanos(paramLong);
/* 1034 */     return m.f(l, 0L, 6917529027641081853L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static long j(long paramLong) {
/* 1042 */     if (paramLong <= 0L) {
/* 1043 */       return 0L;
/*      */     }
/* 1045 */     long l = System.nanoTime();
/* 1046 */     return (l == 0L) ? 1L : l;
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
/*      */   private static long p(long paramLong1, long paramLong2) {
/* 1062 */     return (paramLong2 <= 0L) ? 0L : (paramLong2 - System.nanoTime() - paramLong1);
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
/*      */   @com.google.b.a.a.a("lock")
/*      */   private void fY() {
/* 1091 */     for (a a1 = this.e; a1 != null; a1 = a1.f) {
/* 1092 */       if (e(a1)) {
/* 1093 */         a1.condition.signal();
/*      */         break;
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
/*      */   @com.google.b.a.a.a("lock")
/*      */   private boolean e(a parama) {
/*      */     try {
/* 1124 */       return parama.dy();
/* 1125 */     } catch (Throwable throwable) {
/* 1126 */       fZ();
/* 1127 */       throw throwable;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @com.google.b.a.a.a("lock")
/*      */   private void fZ() {
/* 1134 */     for (a a1 = this.e; a1 != null; a1 = a1.f) {
/* 1135 */       a1.condition.signalAll();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   @com.google.b.a.a.a("lock")
/*      */   private void e(a parama) {
/* 1142 */     int i = parama.gr++;
/* 1143 */     if (i == 0) {
/*      */       
/* 1145 */       parama.f = this.e;
/* 1146 */       this.e = parama;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @com.google.b.a.a.a("lock")
/*      */   private void f(a parama) {
/* 1153 */     int i = --parama.gr;
/* 1154 */     if (i == 0)
/*      */     {
/* 1156 */       for (a a1 = this.e, a2 = null;; a2 = a1, a1 = a1.f) {
/* 1157 */         if (a1 == parama) {
/* 1158 */           if (a2 == null) {
/* 1159 */             this.e = a1.f;
/*      */           } else {
/* 1161 */             a2.f = a1.f;
/*      */           } 
/* 1163 */           a1.f = null;
/*      */           break;
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
/*      */   @com.google.b.a.a.a("lock")
/*      */   private void a(a parama, boolean paramBoolean) throws InterruptedException {
/* 1178 */     if (paramBoolean) {
/* 1179 */       fY();
/*      */     }
/* 1181 */     e(parama);
/*      */     try {
/*      */       do {
/* 1184 */         parama.condition.await();
/* 1185 */       } while (!parama.dy());
/*      */     } finally {
/* 1187 */       f(parama);
/*      */     } 
/*      */   }
/*      */   
/*      */   @com.google.b.a.a.a("lock")
/*      */   private void b(a parama, boolean paramBoolean) {
/* 1193 */     if (paramBoolean) {
/* 1194 */       fY();
/*      */     }
/* 1196 */     e(parama);
/*      */     try {
/*      */       do {
/* 1199 */         parama.condition.awaitUninterruptibly();
/* 1200 */       } while (!parama.dy());
/*      */     } finally {
/* 1202 */       f(parama);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.b.a.a.a("lock")
/*      */   private boolean a(a parama, long paramLong, boolean paramBoolean) throws InterruptedException {
/* 1210 */     boolean bool = true;
/*      */     
/*      */     try { while (true) {
/* 1213 */         if (paramLong <= 0L) {
/* 1214 */           return false;
/*      */         }
/* 1216 */         if (bool) {
/* 1217 */           if (paramBoolean) {
/* 1218 */             fY();
/*      */           }
/* 1220 */           e(parama);
/* 1221 */           bool = false;
/*      */         } 
/* 1223 */         paramLong = parama.condition.awaitNanos(paramLong);
/* 1224 */         if (parama.dy())
/* 1225 */           return true; 
/*      */       }  }
/* 1227 */     finally { if (!bool)
/* 1228 */         f(parama);  }
/*      */   
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\aa.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */