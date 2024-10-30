/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.s;
/*     */ import com.google.a.m.k;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
/*     */ import java.util.stream.Collector;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class bs<C extends Comparable>
/*     */   extends k<C>
/*     */   implements Serializable
/*     */ {
/*  52 */   private static final bs<Comparable<?>> a = new bs(
/*  53 */       bh.e());
/*     */   
/*  55 */   private static final bs<Comparable<?>> b = new bs(
/*  56 */       bh.a((cn)cn.c()));
/*     */ 
/*     */   
/*     */   private final transient bh<cn<C>> j;
/*     */ 
/*     */   
/*     */   @com.google.b.a.a.b
/*     */   private transient bs<C> c;
/*     */ 
/*     */   
/*     */   public static <E extends Comparable<? super E>> Collector<cn<E>, ?, bs<E>> c() {
/*  67 */     return B.c();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <C extends Comparable> bs<C> a() {
/*  73 */     return (bs)a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <C extends Comparable> bs<C> a(cn<C> paramcn) {
/*  81 */     D.checkNotNull(paramcn);
/*  82 */     if (paramcn.isEmpty())
/*  83 */       return a(); 
/*  84 */     if (paramcn.equals(cn.c())) {
/*  85 */       return b();
/*     */     }
/*  87 */     return new bs<>(bh.a(paramcn));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static <C extends Comparable> bs<C> b() {
/*  94 */     return (bs)b;
/*     */   }
/*     */ 
/*     */   
/*     */   public static <C extends Comparable> bs<C> a(cq<C> paramcq) {
/*  99 */     D.checkNotNull(paramcq);
/* 100 */     if (paramcq.isEmpty())
/* 101 */       return a(); 
/* 102 */     if (paramcq.b((cn)cn.c())) {
/* 103 */       return b();
/*     */     }
/*     */     
/* 106 */     if (paramcq instanceof bs) {
/* 107 */       bs<C> bs1 = (bs)paramcq;
/* 108 */       if (!bs1.cO()) {
/* 109 */         return bs1;
/*     */       }
/*     */     } 
/* 112 */     return new bs<>(bh.a(paramcq.p()));
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
/*     */   public static <C extends Comparable<?>> bs<C> a(Iterable<cn<C>> paramIterable) {
/* 124 */     return (new c<>()).a(paramIterable).d();
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
/*     */   public static <C extends Comparable<?>> bs<C> b(Iterable<cn<C>> paramIterable) {
/* 136 */     return (bs)a(dh.a(paramIterable));
/*     */   }
/*     */   
/*     */   bs(bh<cn<C>> parambh) {
/* 140 */     this.j = parambh;
/*     */   }
/*     */   
/*     */   private bs(bh<cn<C>> parambh, bs<C> parambs) {
/* 144 */     this.j = parambh;
/* 145 */     this.c = parambs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean a(cn<C> paramcn) {
/* 153 */     int i = cN.a(this.j, 
/*     */         
/* 155 */         (s)cn.g(), paramcn.a, 
/*     */         
/* 157 */         cj.e(), (cN.b)cN.b.a, cN.a.b);
/*     */ 
/*     */     
/* 160 */     if (i < this.j.size() && ((cn<C>)this.j
/* 161 */       .get(i)).c(paramcn) && 
/* 162 */       !((cn<C>)this.j.get(i)).a(paramcn).isEmpty()) {
/* 163 */       return true;
/*     */     }
/* 165 */     return (i > 0 && ((cn<C>)this.j
/* 166 */       .get(i - 1)).c(paramcn) && 
/* 167 */       !((cn<C>)this.j.get(i - 1)).a(paramcn).isEmpty());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean b(cn<C> paramcn) {
/* 173 */     int i = cN.a(this.j, 
/*     */         
/* 175 */         (s)cn.g(), paramcn.a, 
/*     */         
/* 177 */         cj.e(), (cN.b)cN.b.a, (cN.a)cN.a.a);
/*     */ 
/*     */     
/* 180 */     return (i != -1 && ((cn<C>)this.j.get(i)).b(paramcn));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public cn<C> a(C paramC) {
/* 186 */     int i = cN.a(this.j, 
/*     */         
/* 188 */         (s)cn.g(), 
/* 189 */         T.a(paramC), 
/* 190 */         cj.e(), (cN.b)cN.b.a, (cN.a)cN.a.a);
/*     */ 
/*     */     
/* 193 */     if (i != -1) {
/* 194 */       cn<C> cn = this.j.get(i);
/* 195 */       return cn.a(paramC) ? cn : null;
/*     */     } 
/* 197 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public cn<C> b() {
/* 202 */     if (this.j.isEmpty()) {
/* 203 */       throw new NoSuchElementException();
/*     */     }
/* 205 */     return (cn)cn.a(((cn)this.j.get(0)).a, ((cn)this.j.get(this.j.size() - 1)).b);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 210 */     return this.j.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void a(cn<C> paramcn) {
/* 222 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void a(cq<C> paramcq) {
/* 234 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void b(Iterable<cn<C>> paramIterable) {
/* 246 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void b(cn<C> paramcn) {
/* 258 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void b(cq<C> paramcq) {
/* 270 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void c(Iterable<cn<C>> paramIterable) {
/* 282 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public bt<cn<C>> l() {
/* 287 */     if (this.j.isEmpty()) {
/* 288 */       return bt.n();
/*     */     }
/* 290 */     return new cz<>(this.j, (Comparator)cn.k());
/*     */   }
/*     */ 
/*     */   
/*     */   public bt<cn<C>> m() {
/* 295 */     if (this.j.isEmpty()) {
/* 296 */       return bt.n();
/*     */     }
/* 298 */     return new cz<>(this.j.f(), cn.<Comparable<?>>k().a());
/*     */   }
/*     */ 
/*     */   
/*     */   private final class d
/*     */     extends bh<cn<C>>
/*     */   {
/*     */     private final boolean aJ;
/*     */     
/*     */     private final boolean aK;
/*     */     
/*     */     private final int size;
/*     */ 
/*     */     
/*     */     d(bs this$0) {
/* 313 */       this.aJ = ((cn)bs.a(this$0).get(0)).cT();
/* 314 */       this.aK = ((cn)bG.<cn>b(bs.a(this$0))).cU();
/*     */       
/* 316 */       int i = bs.a(this$0).size() - 1;
/* 317 */       if (this.aJ) {
/* 318 */         i++;
/*     */       }
/* 320 */       if (this.aK) {
/* 321 */         i++;
/*     */       }
/* 323 */       this.size = i;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 328 */       return this.size;
/*     */     }
/*     */     
/*     */     public cn<C> a(int param1Int) {
/*     */       T<Comparable<?>> t1, t2;
/* 333 */       D.b(param1Int, this.size);
/*     */ 
/*     */       
/* 336 */       if (this.aJ) {
/* 337 */         t1 = (param1Int == 0) ? T.<Comparable>a() : ((cn)bs.a(this.d).get(param1Int - 1)).b;
/*     */       } else {
/* 339 */         t1 = ((cn)bs.a(this.d).get(param1Int)).b;
/*     */       } 
/*     */ 
/*     */       
/* 343 */       if (this.aK && param1Int == this.size - 1) {
/* 344 */         t2 = T.b();
/*     */       } else {
/* 346 */         t2 = ((cn)bs.a(this.d).get(param1Int + (this.aJ ? 0 : 1))).a;
/*     */       } 
/*     */       
/* 349 */       return (cn)cn.a(t1, t2);
/*     */     }
/*     */ 
/*     */     
/*     */     boolean cO() {
/* 354 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public bs<C> c() {
/* 360 */     bs<C> bs1 = this.c;
/* 361 */     if (bs1 != null)
/* 362 */       return bs1; 
/* 363 */     if (this.j.isEmpty())
/* 364 */       return this.c = b(); 
/* 365 */     if (this.j.size() == 1 && ((cn)this.j.get(0)).equals(cn.c())) {
/* 366 */       return this.c = a();
/*     */     }
/* 368 */     d d = new d(this);
/* 369 */     bs1 = this.c = new bs(d, this);
/*     */     
/* 371 */     return bs1;
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
/*     */   public bs<C> b(cq<C> paramcq) {
/* 383 */     return (bs)b((Iterable)bG.a(l(), paramcq.p()));
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
/*     */   public bs<C> c(cq<C> paramcq) {
/* 396 */     dh<Comparable<?>> dh = dh.a(this);
/* 397 */     dh.b(paramcq.a());
/* 398 */     return a((cq)dh);
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
/*     */   public bs<C> d(cq<C> paramcq) {
/* 410 */     dh<Comparable<?>> dh = dh.a(this);
/* 411 */     dh.b(paramcq);
/* 412 */     return a((cq)dh);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private bh<cn<C>> a(cn<C> paramcn) {
/*     */     byte b;
/*     */     int i;
/* 420 */     if (this.j.isEmpty() || paramcn.isEmpty())
/* 421 */       return bh.e(); 
/* 422 */     if (paramcn.b(b())) {
/* 423 */       return this.j;
/*     */     }
/*     */ 
/*     */     
/* 427 */     if (paramcn.cT()) {
/*     */       
/* 429 */       b = cN.a(this.j, 
/*     */           
/* 431 */           (s)cn.h(), paramcn.a, cN.b.d, cN.a.b);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 436 */       b = 0;
/*     */     } 
/*     */ 
/*     */     
/* 440 */     if (paramcn.cU()) {
/*     */       
/* 442 */       i = cN.a(this.j, 
/*     */           
/* 444 */           (s)cn.g(), paramcn.b, cN.b.c, cN.a.b);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 449 */       i = this.j.size();
/*     */     } 
/* 451 */     int j = i - b;
/* 452 */     if (j == 0) {
/* 453 */       return bh.e();
/*     */     }
/* 455 */     return new bh<cn<C>>(this, j, b, paramcn)
/*     */       {
/*     */         public int size() {
/* 458 */           return this.dy;
/*     */         }
/*     */ 
/*     */         
/*     */         public cn<C> a(int param1Int) {
/* 463 */           D.b(param1Int, this.dy);
/* 464 */           if (param1Int == 0 || param1Int == this.dy - 1) {
/* 465 */             return ((cn<C>)bs.a(this.d).get(param1Int + this.eA)).a(this.a);
/*     */           }
/* 467 */           return bs.a(this.d).get(param1Int + this.eA);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         boolean cO() {
/* 473 */           return true;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public bs<C> b(cn<C> paramcn) {
/* 482 */     if (!isEmpty()) {
/* 483 */       cn<C> cn1 = b();
/* 484 */       if (paramcn.b(cn1))
/* 485 */         return this; 
/* 486 */       if (paramcn.c(cn1)) {
/* 487 */         return new bs(a(paramcn));
/*     */       }
/*     */     } 
/* 490 */     return a();
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
/*     */   public bA<C> a(Y<C> paramY) {
/* 513 */     D.checkNotNull(paramY);
/* 514 */     if (isEmpty()) {
/* 515 */       return bA.h();
/*     */     }
/* 517 */     cn<C> cn = b().a(paramY);
/* 518 */     if (!cn.cT())
/*     */     {
/*     */       
/* 521 */       throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
/*     */     }
/* 523 */     if (!cn.cU()) {
/*     */       try {
/* 525 */         paramY.c();
/* 526 */       } catch (NoSuchElementException noSuchElementException) {
/* 527 */         throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 532 */     return new a(this, paramY);
/*     */   }
/*     */   
/*     */   private final class a extends bA<C> {
/*     */     private final Y<C> a;
/*     */     
/*     */     a(bs this$0, Y<C> param1Y) {
/* 539 */       super(cj.e());
/* 540 */       this.a = param1Y;
/*     */     }
/*     */ 
/*     */     
/*     */     private transient Integer e;
/*     */ 
/*     */     
/*     */     public int size() {
/* 548 */       Integer integer = this.e;
/* 549 */       if (integer == null) {
/* 550 */         long l = 0L;
/* 551 */         for (dj<cn> dj = bs.a(this.d).b(); dj.hasNext(); ) { cn<C> cn = dj.next();
/* 552 */           l += R.<C>a(cn, this.a).size();
/* 553 */           if (l >= 2147483647L) {
/*     */             break;
/*     */           } }
/*     */         
/* 557 */         integer = this.e = Integer.valueOf(k.e(l));
/*     */       } 
/* 559 */       return integer.intValue();
/*     */     }
/*     */ 
/*     */     
/*     */     public dj<C> b() {
/* 564 */       return new c<C>(this) {
/* 565 */           final Iterator<cn<C>> n = bs.a(this.a.d).b();
/* 566 */           Iterator<C> o = bH.g();
/*     */ 
/*     */           
/*     */           protected C f() {
/* 570 */             while (!this.o.hasNext()) {
/* 571 */               if (this.n.hasNext()) {
/* 572 */                 this.o = R.<C>a(this.n.next(), bs.a.a(this.a)).b(); continue;
/*     */               } 
/* 574 */               return c();
/*     */             } 
/*     */             
/* 577 */             return this.o.next();
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     @c("NavigableSet")
/*     */     public dj<C> c() {
/* 585 */       return new c<C>(this) {
/* 586 */           final Iterator<cn<C>> n = bs.a(this.a.d).f().b();
/* 587 */           Iterator<C> o = bH.g();
/*     */ 
/*     */           
/*     */           protected C f() {
/* 591 */             while (!this.o.hasNext()) {
/* 592 */               if (this.n.hasNext()) {
/* 593 */                 this.o = R.<C>a(this.n.next(), bs.a.a(this.a)).c(); continue;
/*     */               } 
/* 595 */               return c();
/*     */             } 
/*     */             
/* 598 */             return this.o.next();
/*     */           }
/*     */         };
/*     */     }
/*     */     
/*     */     bA<C> a(cn<C> param1cn) {
/* 604 */       return this.d.b(param1cn).a(this.a);
/*     */     }
/*     */ 
/*     */     
/*     */     bA<C> a(C param1C, boolean param1Boolean) {
/* 609 */       return a((cn)cn.a((Comparable<?>)param1C, x.a(param1Boolean)));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     bA<C> a(C param1C1, boolean param1Boolean1, C param1C2, boolean param1Boolean2) {
/* 615 */       if (!param1Boolean1 && !param1Boolean2 && cn.a((Comparable)param1C1, (Comparable)param1C2) == 0) {
/* 616 */         return bA.h();
/*     */       }
/* 618 */       return a(
/* 619 */           (cn)cn.a((Comparable<?>)param1C1, 
/* 620 */             x.a(param1Boolean1), (Comparable<?>)param1C2, 
/* 621 */             x.a(param1Boolean2)));
/*     */     }
/*     */ 
/*     */     
/*     */     bA<C> b(C param1C, boolean param1Boolean) {
/* 626 */       return a((cn)cn.b((Comparable<?>)param1C, x.a(param1Boolean)));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 631 */       if (param1Object == null) {
/* 632 */         return false;
/*     */       }
/*     */       
/*     */       try {
/* 636 */         Comparable comparable = (Comparable)param1Object;
/* 637 */         return this.d.a(comparable);
/* 638 */       } catch (ClassCastException classCastException) {
/* 639 */         return false;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     int indexOf(Object param1Object) {
/* 645 */       if (contains(param1Object)) {
/*     */         
/* 647 */         Comparable comparable = (Comparable)param1Object;
/* 648 */         long l = 0L;
/* 649 */         for (dj<cn> dj = bs.a(this.d).b(); dj.hasNext(); ) { cn<Comparable> cn = dj.next();
/* 650 */           if (cn.a(comparable)) {
/* 651 */             return k.e(l + R.<Comparable>a(cn, this.a).indexOf(comparable));
/*     */           }
/* 653 */           l += R.<Comparable>a(cn, this.a).size(); }
/*     */ 
/*     */         
/* 656 */         throw new AssertionError("impossible");
/*     */       } 
/* 658 */       return -1;
/*     */     }
/*     */ 
/*     */     
/*     */     bA<C> a() {
/* 663 */       return new W<>(this);
/*     */     }
/*     */ 
/*     */     
/*     */     boolean cO() {
/* 668 */       return bs.a(this.d).cO();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 673 */       return bs.a(this.d).toString();
/*     */     }
/*     */ 
/*     */     
/*     */     Object writeReplace() {
/* 678 */       return new bs.b<>(bs.a(this.d), this.a);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class b<C extends Comparable> implements Serializable {
/*     */     private final bh<cn<C>> j;
/*     */     private final Y<C> a;
/*     */     
/*     */     b(bh<cn<C>> param1bh, Y<C> param1Y) {
/* 687 */       this.j = param1bh;
/* 688 */       this.a = param1Y;
/*     */     }
/*     */     
/*     */     Object readResolve() {
/* 692 */       return (new bs<>(this.j)).a(this.a);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean cO() {
/* 703 */     return this.j.cO();
/*     */   }
/*     */ 
/*     */   
/*     */   public static <C extends Comparable<?>> c<C> a() {
/* 708 */     return new c<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class c<C extends Comparable<?>>
/*     */   {
/* 720 */     private final List<cn<C>> L = bS.a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public c<C> a(cn<C> param1cn) {
/* 733 */       D.a(!param1cn.isEmpty(), "range must not be empty, but was %s", param1cn);
/* 734 */       this.L.add(param1cn);
/* 735 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public c<C> a(cq<C> param1cq) {
/* 745 */       return a(param1cq.p());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public c<C> a(Iterable<cn<C>> param1Iterable) {
/* 757 */       for (cn<C> cn : param1Iterable) {
/* 758 */         a(cn);
/*     */       }
/* 760 */       return this;
/*     */     }
/*     */     
/*     */     @com.google.b.a.a
/*     */     c<C> a(c<C> param1c) {
/* 765 */       a(param1c.L);
/* 766 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public bs<C> d() {
/* 776 */       bh.a<cn> a = new bh.a(this.L.size());
/* 777 */       Collections.sort(this.L, (Comparator)cn.k());
/* 778 */       ck<?> ck = bH.a(this.L.iterator());
/* 779 */       while (ck.hasNext()) {
/* 780 */         cn cn = (cn)ck.next();
/* 781 */         while (ck.hasNext()) {
/* 782 */           cn cn1 = (cn)ck.peek();
/* 783 */           if (cn.c(cn1)) {
/* 784 */             D.a(cn
/* 785 */                 .a(cn1).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", cn, cn1);
/*     */ 
/*     */ 
/*     */             
/* 789 */             cn = cn.c((cn)ck.next());
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 794 */         a.a(cn);
/*     */       } 
/* 796 */       bh<cn> bh = a.g();
/* 797 */       if (bh.isEmpty())
/* 798 */         return (bs)bs.a(); 
/* 799 */       if (bh.size() == 1 && (
/* 800 */         (cn)bG.<cn>a(bh)).equals(cn.c())) {
/* 801 */         return (bs)bs.b();
/*     */       }
/* 803 */       return (bs)new bs<>((bh)bh);
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class e<C extends Comparable>
/*     */     implements Serializable {
/*     */     private final bh<cn<C>> j;
/*     */     
/*     */     e(bh<cn<C>> param1bh) {
/* 812 */       this.j = param1bh;
/*     */     }
/*     */     
/*     */     Object readResolve() {
/* 816 */       if (this.j.isEmpty())
/* 817 */         return bs.a(); 
/* 818 */       if (this.j.equals(bh.a(cn.c()))) {
/* 819 */         return bs.b();
/*     */       }
/* 821 */       return new bs<>(this.j);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   Object writeReplace() {
/* 827 */     return new e<>(this.j);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\bs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */