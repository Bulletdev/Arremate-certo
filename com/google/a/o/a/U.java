/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.x;
/*     */ import com.google.a.d.bS;
/*     */ import com.google.a.d.bU;
/*     */ import com.google.a.d.bW;
/*     */ import com.google.a.d.bt;
/*     */ import com.google.a.d.cG;
/*     */ import com.google.b.a.a;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.EnumMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ @a
/*     */ @c
/*     */ public class u
/*     */ {
/*     */   @a
/*     */   public enum h
/*     */     implements i
/*     */   {
/* 201 */     a
/*     */     {
/*     */       public void a(u.j param2j) {
/* 204 */         throw param2j;
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 213 */     b
/*     */     {
/*     */       public void a(u.j param2j) {
/* 216 */         u.a().log(Level.SEVERE, "Detected potential deadlock", param2j);
/*     */       }
/*     */     },
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 228 */     c
/*     */     {
/*     */       public void a(u.j param2j) {}
/*     */     };
/*     */   }
/*     */ 
/*     */   
/*     */   public static u a(i parami) {
/* 236 */     return new u(parami);
/*     */   }
/*     */ 
/*     */   
/*     */   public ReentrantLock a(String paramString) {
/* 241 */     return a(paramString, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReentrantLock a(String paramString, boolean paramBoolean) {
/* 249 */     return (this.a == h.c) ? 
/* 250 */       new ReentrantLock(paramBoolean) : 
/* 251 */       new b(new g(paramString), paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   public ReentrantReadWriteLock a(String paramString) {
/* 256 */     return a(paramString, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReentrantReadWriteLock a(String paramString, boolean paramBoolean) {
/* 265 */     return (this.a == h.c) ? 
/* 266 */       new ReentrantReadWriteLock(paramBoolean) : 
/* 267 */       new d(new g(paramString), paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 272 */   private static final ConcurrentMap<Class<? extends Enum>, Map<? extends Enum, g>> e = (new bU()).a().c();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E extends Enum<E>> k<E> a(Class<E> paramClass, i parami) {
/* 279 */     D.checkNotNull(paramClass);
/* 280 */     D.checkNotNull(parami);
/*     */     
/* 282 */     Map<? extends Enum, g> map = c(paramClass);
/* 283 */     return new k<>(parami, (Map)map);
/*     */   }
/*     */   
/*     */   private static Map<? extends Enum, g> c(Class<? extends Enum> paramClass) {
/* 287 */     Map<? extends Enum, g> map1 = e.get(paramClass);
/* 288 */     if (map1 != null) {
/* 289 */       return map1;
/*     */     }
/* 291 */     Map<? extends Enum, g> map2 = d(paramClass);
/* 292 */     map1 = e.putIfAbsent(paramClass, map2);
/* 293 */     return (Map<? extends Enum, g>)x.a(map1, map2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.d
/*     */   static <E extends Enum<E>> Map<E, g> d(Class<E> paramClass) {
/* 304 */     EnumMap<Enum<?>, g> enumMap = bW.a(paramClass);
/* 305 */     Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
/* 306 */     int j = arrayOfEnum.length;
/* 307 */     ArrayList<g> arrayList = bS.a(j);
/*     */     
/* 309 */     for (Enum<?> enum_ : arrayOfEnum) {
/* 310 */       g g = new g(b(enum_));
/* 311 */       arrayList.add(g);
/* 312 */       enumMap.put(enum_, g);
/*     */     } 
/*     */     byte b;
/* 315 */     for (b = 1; b < j; b++) {
/* 316 */       ((g)arrayList.get(b)).a((i)h.a, arrayList.subList(0, b));
/*     */     }
/*     */     
/* 319 */     for (b = 0; b < j - 1; b++) {
/* 320 */       ((g)arrayList.get(b)).a(h.c, arrayList.subList(b + 1, j));
/*     */     }
/* 322 */     return Collections.unmodifiableMap((Map)enumMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String b(Enum<?> paramEnum) {
/* 330 */     String str1 = paramEnum.getDeclaringClass().getSimpleName(), str2 = paramEnum.name(); return (new StringBuilder(1 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(".").append(str2).toString();
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
/*     */   
/*     */   @a
/*     */   public static final class k<E extends Enum<E>>
/*     */     extends u
/*     */   {
/*     */     private final Map<E, u.g> al;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.a.a.d
/*     */     k(u.i param1i, Map<E, u.g> param1Map) {
/* 400 */       super(param1i);
/* 401 */       this.al = param1Map;
/*     */     }
/*     */ 
/*     */     
/*     */     public ReentrantLock a(E param1E) {
/* 406 */       return a(param1E, false);
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
/*     */     public ReentrantLock a(E param1E, boolean param1Boolean) {
/* 418 */       return (this.a == u.h.c) ? 
/* 419 */         new ReentrantLock(param1Boolean) : 
/* 420 */         new u.b(this.al.get(param1E), param1Boolean);
/*     */     }
/*     */ 
/*     */     
/*     */     public ReentrantReadWriteLock a(E param1E) {
/* 425 */       return a(param1E, false);
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
/*     */     public ReentrantReadWriteLock a(E param1E, boolean param1Boolean) {
/* 437 */       return (this.a == u.h.c) ? 
/* 438 */         new ReentrantReadWriteLock(param1Boolean) : 
/* 439 */         new u.d(this.al.get(param1E), param1Boolean);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 445 */   private static final Logger logger = Logger.getLogger(u.class.getName());
/*     */   
/*     */   final i a;
/*     */   
/*     */   private u(i parami) {
/* 450 */     this.a = (i)D.checkNotNull(parami);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 459 */   private static final ThreadLocal<ArrayList<g>> e = new ThreadLocal<ArrayList<g>>()
/*     */     {
/*     */       protected ArrayList<u.g> b()
/*     */       {
/* 463 */         return bS.a(3);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class f
/*     */     extends IllegalStateException
/*     */   {
/* 482 */     static final StackTraceElement[] a = new StackTraceElement[0];
/*     */ 
/*     */     
/* 485 */     static final bt<String> l = bt.a(u.class
/* 486 */         .getName(), f.class
/* 487 */         .getName(), u.g.class
/* 488 */         .getName());
/*     */     
/*     */     f(u.g param1g1, u.g param1g2) {
/* 491 */       super((new StringBuilder(4 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(" -> ").append(str2).toString());
/* 492 */       StackTraceElement[] arrayOfStackTraceElement = getStackTrace(); byte b; int i;
/* 493 */       for (b = 0, i = arrayOfStackTraceElement.length; b < i; b++) {
/* 494 */         if (u.k.class.getName().equals(arrayOfStackTraceElement[b].getClassName())) {
/*     */           
/* 496 */           setStackTrace(a);
/*     */           break;
/*     */         } 
/* 499 */         if (!l.contains(arrayOfStackTraceElement[b].getClassName())) {
/* 500 */           setStackTrace(Arrays.<StackTraceElement>copyOfRange(arrayOfStackTraceElement, b, i));
/*     */           break;
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
/*     */   @a
/*     */   public static final class j
/*     */     extends f
/*     */   {
/*     */     private final u.f a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private j(u.g param1g1, u.g param1g2, u.f param1f) {
/* 534 */       super(param1g1, param1g2);
/* 535 */       this.a = param1f;
/* 536 */       initCause(param1f);
/*     */     }
/*     */     
/*     */     public u.f a() {
/* 540 */       return this.a;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getMessage() {
/* 549 */       StringBuilder stringBuilder = new StringBuilder(super.getMessage());
/* 550 */       for (u.f f1 = this.a; f1 != null; throwable = f1.getCause()) {
/* 551 */         Throwable throwable; stringBuilder.append(", ").append(f1.getMessage());
/*     */       } 
/* 553 */       return stringBuilder.toString();
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
/*     */ 
/*     */ 
/*     */   
/*     */   private static class g
/*     */   {
/* 581 */     final Map<g, u.f> aj = (new bU())
/* 582 */       .a().c();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 588 */     final Map<g, u.j> ak = (new bU())
/* 589 */       .a().c();
/*     */     
/*     */     final String iU;
/*     */     
/*     */     g(String param1String) {
/* 594 */       this.iU = (String)D.checkNotNull(param1String);
/*     */     }
/*     */     
/*     */     String dw() {
/* 598 */       return this.iU;
/*     */     } void a(u.i param1i, List<g> param1List) {
/*     */       byte b;
/*     */       int j;
/* 602 */       for (b = 0, j = param1List.size(); b < j; b++) {
/* 603 */         a(param1i, param1List.get(b));
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
/*     */     void a(u.i param1i, g param1g) {
/* 623 */       D.b((this != param1g), "Attempted to acquire multiple locks with the same rank %s", param1g
/*     */ 
/*     */           
/* 626 */           .dw());
/*     */       
/* 628 */       if (this.aj.containsKey(param1g)) {
/*     */         return;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 634 */       u.j j = this.ak.get(param1g);
/* 635 */       if (j != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 641 */         u.j j1 = new u.j(param1g, this, j.a());
/* 642 */         param1i.a(j1);
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 647 */       Set<g> set = cG.newIdentityHashSet();
/* 648 */       u.f f = param1g.a(this, set);
/*     */       
/* 650 */       if (f == null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 659 */         this.aj.put(param1g, new u.f(param1g, this));
/*     */       }
/*     */       else {
/*     */         
/* 663 */         u.j j1 = new u.j(param1g, this, f);
/*     */         
/* 665 */         this.ak.put(param1g, j1);
/* 666 */         param1i.a(j1);
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
/*     */     private u.f a(g param1g, Set<g> param1Set) {
/* 678 */       if (!param1Set.add(this)) {
/* 679 */         return null;
/*     */       }
/* 681 */       u.f f = this.aj.get(param1g);
/* 682 */       if (f != null) {
/* 683 */         return f;
/*     */       }
/*     */       
/* 686 */       for (Map.Entry<g, u.f> entry : this.aj.entrySet()) {
/* 687 */         g g1 = (g)entry.getKey();
/* 688 */         f = g1.a(param1g, param1Set);
/* 689 */         if (f != null) {
/*     */ 
/*     */ 
/*     */           
/* 693 */           u.f f1 = new u.f(g1, this);
/* 694 */           f1.setStackTrace(((u.f)entry.getValue()).getStackTrace());
/* 695 */           f1.initCause(f);
/* 696 */           return f1;
/*     */         } 
/*     */       } 
/* 699 */       return null;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(a parama) {
/* 707 */     if (!parama.dz()) {
/* 708 */       ArrayList<g> arrayList = e.get();
/* 709 */       g g = parama.a();
/* 710 */       g.a(this.a, arrayList);
/* 711 */       arrayList.add(g);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void b(a parama) {
/* 721 */     if (!parama.dz()) {
/* 722 */       ArrayList<g> arrayList = e.get();
/* 723 */       g g = parama.a();
/*     */ 
/*     */       
/* 726 */       for (int j = arrayList.size() - 1; j >= 0; j--) {
/* 727 */         if (arrayList.get(j) == g) {
/* 728 */           arrayList.remove(j);
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   final class b
/*     */     extends ReentrantLock implements a {
/*     */     private final u.g a;
/*     */     
/*     */     private b(u this$0, u.g param1g, boolean param1Boolean) {
/* 740 */       super(param1Boolean);
/* 741 */       this.a = (u)D.checkNotNull(param1g);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public u.g a() {
/* 748 */       return (u.g)this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean dz() {
/* 753 */       return isHeldByCurrentThread();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void lock() {
/* 760 */       u.a(this.a, this);
/*     */       try {
/* 762 */         super.lock();
/*     */       } finally {
/* 764 */         u.c(this);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void lockInterruptibly() throws InterruptedException {
/* 770 */       u.a(this.a, this);
/*     */       try {
/* 772 */         super.lockInterruptibly();
/*     */       } finally {
/* 774 */         u.c(this);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean tryLock() {
/* 780 */       u.a(this.a, this);
/*     */       try {
/* 782 */         return super.tryLock();
/*     */       } finally {
/* 784 */         u.c(this);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean tryLock(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException {
/* 790 */       u.a(this.a, this);
/*     */       try {
/* 792 */         return super.tryLock(param1Long, param1TimeUnit);
/*     */       } finally {
/* 794 */         u.c(this);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void unlock() {
/*     */       try {
/* 801 */         super.unlock();
/*     */       } finally {
/* 803 */         u.c(this);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   final class d
/*     */     extends ReentrantReadWriteLock
/*     */     implements a
/*     */   {
/*     */     private final u.c a;
/*     */     
/*     */     private final u.e a;
/*     */     
/*     */     private final u.g a;
/*     */ 
/*     */     
/*     */     private d(u this$0, u.g param1g, boolean param1Boolean) {
/* 821 */       super(param1Boolean);
/* 822 */       this.a = (u.g)new u.c(u.this, this);
/* 823 */       this.a = (u.g)new u.e(u.this, this);
/* 824 */       this.a = (u.g)D.checkNotNull(param1g);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ReentrantReadWriteLock.ReadLock readLock() {
/* 831 */       return (ReentrantReadWriteLock.ReadLock)this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public ReentrantReadWriteLock.WriteLock writeLock() {
/* 836 */       return (ReentrantReadWriteLock.WriteLock)this.a;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public u.g a() {
/* 843 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean dz() {
/* 848 */       return (isWriteLockedByCurrentThread() || getReadHoldCount() > 0);
/*     */     }
/*     */   }
/*     */   
/*     */   private class c extends ReentrantReadWriteLock.ReadLock {
/*     */     @com.google.c.a.i
/*     */     final u.d a;
/*     */     
/*     */     c(u this$0, u.d param1d) {
/* 857 */       super(param1d);
/* 858 */       this.a = (u)param1d;
/*     */     }
/*     */ 
/*     */     
/*     */     public void lock() {
/* 863 */       u.a(this.a, (u.a)this.a);
/*     */       try {
/* 865 */         super.lock();
/*     */       } finally {
/* 867 */         u.c((u.a)this.a);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void lockInterruptibly() throws InterruptedException {
/* 873 */       u.a(this.a, (u.a)this.a);
/*     */       try {
/* 875 */         super.lockInterruptibly();
/*     */       } finally {
/* 877 */         u.c((u.a)this.a);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean tryLock() {
/* 883 */       u.a(this.a, (u.a)this.a);
/*     */       try {
/* 885 */         return super.tryLock();
/*     */       } finally {
/* 887 */         u.c((u.a)this.a);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean tryLock(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException {
/* 893 */       u.a(this.a, (u.a)this.a);
/*     */       try {
/* 895 */         return super.tryLock(param1Long, param1TimeUnit);
/*     */       } finally {
/* 897 */         u.c((u.a)this.a);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void unlock() {
/*     */       try {
/* 904 */         super.unlock();
/*     */       } finally {
/* 906 */         u.c((u.a)this.a);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private class e extends ReentrantReadWriteLock.WriteLock {
/*     */     @com.google.c.a.i
/*     */     final u.d a;
/*     */     
/*     */     e(u this$0, u.d param1d) {
/* 916 */       super(param1d);
/* 917 */       this.a = (u)param1d;
/*     */     }
/*     */ 
/*     */     
/*     */     public void lock() {
/* 922 */       u.a(this.a, (u.a)this.a);
/*     */       try {
/* 924 */         super.lock();
/*     */       } finally {
/* 926 */         u.c((u.a)this.a);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void lockInterruptibly() throws InterruptedException {
/* 932 */       u.a(this.a, (u.a)this.a);
/*     */       try {
/* 934 */         super.lockInterruptibly();
/*     */       } finally {
/* 936 */         u.c((u.a)this.a);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean tryLock() {
/* 942 */       u.a(this.a, (u.a)this.a);
/*     */       try {
/* 944 */         return super.tryLock();
/*     */       } finally {
/* 946 */         u.c((u.a)this.a);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean tryLock(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException {
/* 952 */       u.a(this.a, (u.a)this.a);
/*     */       try {
/* 954 */         return super.tryLock(param1Long, param1TimeUnit);
/*     */       } finally {
/* 956 */         u.c((u.a)this.a);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void unlock() {
/*     */       try {
/* 963 */         super.unlock();
/*     */       } finally {
/* 965 */         u.c((u.a)this.a);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private static interface a {
/*     */     u.g a();
/*     */     
/*     */     boolean dz();
/*     */   }
/*     */   
/*     */   @a
/*     */   public static interface i {
/*     */     void a(u.j param1j);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\\\u.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */