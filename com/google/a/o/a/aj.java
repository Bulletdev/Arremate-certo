/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.F;
/*     */ import com.google.a.b.K;
/*     */ import com.google.a.b.s;
/*     */ import com.google.a.b.x;
/*     */ import com.google.a.d.E;
/*     */ import com.google.a.d.bS;
/*     */ import com.google.a.d.bW;
/*     */ import com.google.a.d.bd;
/*     */ import com.google.a.d.bh;
/*     */ import com.google.a.d.bj;
/*     */ import com.google.a.d.bo;
/*     */ import com.google.a.d.bt;
/*     */ import com.google.a.d.bu;
/*     */ import com.google.a.d.cF;
/*     */ import com.google.a.d.ca;
/*     */ import com.google.a.d.cb;
/*     */ import com.google.a.d.cc;
/*     */ import com.google.a.d.cj;
/*     */ import com.google.a.d.dj;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.time.Duration;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.EnumSet;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.TimeoutException;
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
/*     */ @c
/*     */ public final class aj
/*     */   implements ak
/*     */ {
/* 124 */   private static final Logger logger = Logger.getLogger(aj.class.getName());
/* 125 */   private static final X.a<c> i = new X.a<c>()
/*     */     {
/*     */       public void a(aj.c param1c)
/*     */       {
/* 129 */         param1c.gh();
/*     */       }
/*     */ 
/*     */       
/*     */       public String toString() {
/* 134 */         return "healthy()";
/*     */       }
/*     */     };
/* 137 */   private static final X.a<c> j = new X.a<c>()
/*     */     {
/*     */       public void a(aj.c param1c)
/*     */       {
/* 141 */         param1c.gi();
/*     */       }
/*     */ 
/*     */       
/*     */       public String toString() {
/* 146 */         return "stopped()";
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
/*     */   private final f a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final bh<ai> z;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class c
/*     */   {
/*     */     public void gh() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void gi() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void a(ai param1ai) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public aj(Iterable<? extends ai> paramIterable) {
/* 203 */     bh<ai> bh1 = bh.b(paramIterable);
/* 204 */     if (bh1.isEmpty()) {
/*     */ 
/*     */       
/* 207 */       logger.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", new a());
/*     */ 
/*     */ 
/*     */       
/* 211 */       bh1 = bh.a(new d());
/*     */     } 
/* 213 */     this.a = new f((bd<ai>)bh1);
/* 214 */     this.z = bh1;
/* 215 */     WeakReference<f> weakReference = new WeakReference<>(this.a);
/* 216 */     for (dj<ai> dj = bh1.b(); dj.hasNext(); ) { ai ai = dj.next();
/* 217 */       ai.a(new e(ai, weakReference), ab.b());
/*     */ 
/*     */       
/* 220 */       D.a((ai.a() == ai.b.c), "Can only manage NEW services, %s", ai); }
/*     */ 
/*     */ 
/*     */     
/* 224 */     this.a.gj();
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
/*     */   public void a(c paramc, Executor paramExecutor) {
/* 252 */     this.a.a(paramc, paramExecutor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public aj a() {
/*     */     dj<ai> dj;
/* 265 */     for (dj = this.z.b(); dj.hasNext(); ) { ai ai = dj.next();
/* 266 */       ai.b b = ai.a();
/* 267 */       D.b((b == ai.b.c), "Service %s is %s, cannot start it.", ai, b); }
/*     */     
/* 269 */     for (dj = this.z.b(); dj.hasNext(); ) { ai ai = dj.next();
/*     */       try {
/* 271 */         this.a.b(ai);
/* 272 */         ai.a();
/* 273 */       } catch (IllegalStateException illegalStateException) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 278 */         String str = String.valueOf(ai); logger.log(Level.WARNING, (new StringBuilder(24 + String.valueOf(str).length())).append("Unable to start Service ").append(str).toString(), illegalStateException);
/*     */       }  }
/*     */     
/* 281 */     return this;
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
/*     */   public void gf() {
/* 293 */     this.a.gf();
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
/*     */   public void c(Duration paramDuration) throws TimeoutException {
/* 308 */     c(R.a(paramDuration), TimeUnit.NANOSECONDS);
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
/*     */   public void c(long paramLong, TimeUnit paramTimeUnit) throws TimeoutException {
/* 324 */     this.a.c(paramLong, paramTimeUnit);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public aj b() {
/* 335 */     for (dj<ai> dj = this.z.b(); dj.hasNext(); ) { ai ai = dj.next();
/* 336 */       ai.b(); }
/*     */     
/* 338 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void gg() {
/* 347 */     this.a.gg();
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
/*     */   public void d(Duration paramDuration) throws TimeoutException {
/* 360 */     d(R.a(paramDuration), TimeUnit.NANOSECONDS);
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
/*     */   public void d(long paramLong, TimeUnit paramTimeUnit) throws TimeoutException {
/* 374 */     this.a.d(paramLong, paramTimeUnit);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean dI() {
/* 384 */     for (dj<ai> dj = this.z.b(); dj.hasNext(); ) { ai ai = dj.next();
/* 385 */       if (!ai.isRunning()) {
/* 386 */         return false;
/*     */       } }
/*     */     
/* 389 */     return true;
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
/*     */   public bu<ai.b, ai> f() {
/* 402 */     return this.a.f();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public bj<ai, Long> l() {
/* 413 */     return this.a.l();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 418 */     return x.a(aj.class)
/* 419 */       .a("services", E.a((Collection)this.z, F.a(F.a(d.class))))
/* 420 */       .toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class f
/*     */   {
/* 428 */     final X<aj.c> a = (X<aj.c>)new aa();
/*     */ 
/*     */     
/*     */     @com.google.b.a.a.a("monitor")
/* 432 */     final cF<ai.b, ai> b = ca.a(ai.b.class).b().c();
/*     */     
/* 434 */     final aa.a h = (aa.a)this.b
/* 435 */       .b();
/*     */     
/*     */     @com.google.b.a.a.a("monitor")
/* 438 */     final Map<ai, K> am = bW.a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     final aa a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a.a("monitor")
/*     */     final cc<ai.b> h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a.a("monitor")
/*     */     boolean bt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 465 */     final aa.a g = new a(this); @com.google.b.a.a.a("monitor")
/*     */     boolean bu;
/*     */     final int gt;
/*     */     
/*     */     final class a extends aa.a { a(aj.f this$0) {
/* 470 */         super((aa)this$0.a);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       @com.google.b.a.a.a("ServiceManagerState.this.monitor")
/*     */       public boolean dy() {
/* 477 */         return (this.b.h.b(ai.b.e) == this.b.gt || this.b.h
/* 478 */           .contains(ai.b.f) || this.b.h
/* 479 */           .contains(ai.b.g) || this.b.h
/* 480 */           .contains(ai.b.h));
/*     */       } }
/*     */ 
/*     */     
/*     */     f(bd<ai> param1bd) {
/* 485 */       this.h = new b(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 501 */       this.a = new X<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 510 */       this.gt = param1bd.size();
/* 511 */       this.b.putAll(ai.b.c, (Iterable)param1bd);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void b(ai param1ai) {
/* 519 */       this.a.enter();
/*     */       try {
/* 521 */         K k = this.am.get(param1ai);
/* 522 */         if (k == null) {
/* 523 */           this.am.put(param1ai, K.b());
/*     */         }
/*     */       } finally {
/* 526 */         this.a.fX();
/*     */       } 
/*     */     } final class b extends aa.a {
/*     */       b(aj.f this$0) {
/*     */         super((aa)this$0.a);
/*     */       } @com.google.b.a.a.a("ServiceManagerState.this.monitor")
/*     */       public boolean dy() {
/*     */         return (this.b.h.b(ai.b.g) + this.b.h.b(ai.b.h) == this.b.gt);
/*     */       } } void gj() {
/* 535 */       this.a.enter();
/*     */       try {
/* 537 */         if (!this.bu) {
/*     */           
/* 539 */           this.bt = true;
/*     */         } else {
/*     */           
/* 542 */           ArrayList<ai> arrayList = bS.a();
/* 543 */           for (dj<ai> dj = f().c().b(); dj.hasNext(); ) { ai ai = dj.next();
/* 544 */             if (ai.a() != ai.b.c) {
/* 545 */               arrayList.add(ai);
/*     */             } }
/*     */           
/* 548 */           String str = String.valueOf(arrayList); throw new IllegalArgumentException((new StringBuilder(89 + String.valueOf(str).length())).append("Services started transitioning asynchronously before the ServiceManager was constructed: ").append(str).toString());
/*     */         }
/*     */       
/*     */       }
/*     */       finally {
/*     */         
/* 554 */         this.a.fX();
/*     */       } 
/*     */     }
/*     */     
/*     */     void a(aj.c param1c, Executor param1Executor) {
/* 559 */       this.a.a(param1c, param1Executor);
/*     */     }
/*     */     
/*     */     void gf() {
/* 563 */       this.a.b(this.g);
/*     */       try {
/* 565 */         gm();
/*     */       } finally {
/* 567 */         this.a.fX();
/*     */       } 
/*     */     }
/*     */     
/*     */     void c(long param1Long, TimeUnit param1TimeUnit) throws TimeoutException {
/* 572 */       this.a.enter();
/*     */       try {
/* 574 */         if (!this.a.f(this.g, param1Long, param1TimeUnit)) {
/*     */ 
/*     */ 
/*     */           
/* 578 */           String str = String.valueOf(cb.a(this.b, F.a((Collection)bt.a(ai.b.c, ai.b.d)))); throw new TimeoutException((new StringBuilder(93 + String.valueOf(str).length())).append("Timeout waiting for the services to become healthy. The following services have not started: ").append(str).toString());
/*     */         } 
/* 580 */         gm();
/*     */       } finally {
/* 582 */         this.a.fX();
/*     */       } 
/*     */     }
/*     */     
/*     */     void gg() {
/* 587 */       this.a.b(this.h);
/* 588 */       this.a.fX();
/*     */     }
/*     */     
/*     */     void d(long param1Long, TimeUnit param1TimeUnit) throws TimeoutException {
/* 592 */       this.a.enter();
/*     */       try {
/* 594 */         if (!this.a.f(this.h, param1Long, param1TimeUnit)) {
/*     */ 
/*     */ 
/*     */           
/* 598 */           String str = String.valueOf(cb.a(this.b, F.a(F.a(EnumSet.of(ai.b.g, ai.b.h))))); throw new TimeoutException((new StringBuilder(83 + String.valueOf(str).length())).append("Timeout waiting for the services to stop. The following services have not stopped: ").append(str).toString());
/*     */         } 
/*     */       } finally {
/* 601 */         this.a.fX();
/*     */       } 
/*     */     }
/*     */     
/*     */     bu<ai.b, ai> f() {
/* 606 */       bu.a a1 = bu.a();
/* 607 */       this.a.enter();
/*     */       try {
/* 609 */         for (Map.Entry entry : this.b.g()) {
/* 610 */           if (!(entry.getValue() instanceof aj.d)) {
/* 611 */             a1.a(entry);
/*     */           }
/*     */         } 
/*     */       } finally {
/* 615 */         this.a.fX();
/*     */       } 
/* 617 */       return a1.e();
/*     */     }
/*     */     
/*     */     bj<ai, Long> l() {
/*     */       ArrayList<Map.Entry> arrayList;
/* 622 */       this.a.enter();
/*     */       try {
/* 624 */         arrayList = bS.a(this.am.size());
/*     */         
/* 626 */         for (Map.Entry<ai, K> entry : this.am.entrySet()) {
/* 627 */           ai ai = (ai)entry.getKey();
/* 628 */           K k = (K)entry.getValue();
/* 629 */           if (!k.isRunning() && !(ai instanceof aj.d)) {
/* 630 */             arrayList.add(bW.d(ai, Long.valueOf(k.a(TimeUnit.MILLISECONDS))));
/*     */           }
/*     */         } 
/*     */       } finally {
/* 634 */         this.a.fX();
/*     */       } 
/* 636 */       Collections.sort(arrayList, 
/*     */           
/* 638 */           (Comparator<? super Map.Entry>)cj.e()
/* 639 */           .a(new s<Map.Entry<ai, Long>, Long>(this)
/*     */             {
/*     */               public Long a(Map.Entry<ai, Long> param2Entry)
/*     */               {
/* 643 */                 return param2Entry.getValue();
/*     */               }
/*     */             }));
/* 646 */       return bj.c(arrayList);
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
/*     */     void a(ai param1ai, ai.b param1b1, ai.b param1b2) {
/* 662 */       D.checkNotNull(param1ai);
/* 663 */       D.checkArgument((param1b1 != param1b2));
/* 664 */       this.a.enter();
/*     */       try {
/* 666 */         this.bu = true;
/* 667 */         if (!this.bt) {
/*     */           return;
/*     */         }
/*     */         
/* 671 */         D.b(this.b
/* 672 */             .remove(param1b1, param1ai), "Service %s not at the expected location in the state map %s", param1ai, param1b1);
/*     */ 
/*     */ 
/*     */         
/* 676 */         D.b(this.b
/* 677 */             .put(param1b2, param1ai), "Service %s in the state map unexpectedly at %s", param1ai, param1b2);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 682 */         K k = this.am.get(param1ai);
/* 683 */         if (k == null) {
/*     */           
/* 685 */           k = K.b();
/* 686 */           this.am.put(param1ai, k);
/*     */         } 
/* 688 */         if (param1b2.compareTo(ai.b.e) >= 0 && k.isRunning()) {
/*     */           
/* 690 */           k.d();
/* 691 */           if (!(param1ai instanceof aj.d)) {
/* 692 */             aj.d().log(Level.FINE, "Started {0} in {1}.", new Object[] { param1ai, k });
/*     */           }
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 698 */         if (param1b2 == ai.b.h) {
/* 699 */           c(param1ai);
/*     */         }
/*     */         
/* 702 */         if (this.h.b(ai.b.e) == this.gt) {
/*     */ 
/*     */           
/* 705 */           gl();
/* 706 */         } else if (this.h.b(ai.b.g) + this.h.b(ai.b.h) == this.gt) {
/* 707 */           gk();
/*     */         } 
/*     */       } finally {
/* 710 */         this.a.fX();
/*     */         
/* 712 */         fN();
/*     */       } 
/*     */     }
/*     */     
/*     */     void gk() {
/* 717 */       this.a.a(aj.a());
/*     */     }
/*     */     
/*     */     void gl() {
/* 721 */       this.a.a(aj.b());
/*     */     }
/*     */     
/*     */     void c(ai param1ai) {
/* 725 */       this.a.a(new X.a<aj.c>(this, param1ai)
/*     */           {
/*     */             public void a(aj.c param2c)
/*     */             {
/* 729 */               param2c.a(this.c);
/*     */             }
/*     */ 
/*     */             
/*     */             public String toString() {
/* 734 */               String str = String.valueOf(this.c); return (new StringBuilder(18 + String.valueOf(str).length())).append("failed({service=").append(str).append("})").toString();
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */     
/*     */     void fN() {
/* 741 */       D.b(
/* 742 */           !this.a.dE(), "It is incorrect to execute listeners with the monitor held.");
/*     */       
/* 744 */       this.a.fV();
/*     */     }
/*     */     
/*     */     @com.google.b.a.a.a("monitor")
/*     */     void gm() {
/* 749 */       if (this.h.b(ai.b.e) != this.gt) {
/*     */ 
/*     */ 
/*     */         
/* 753 */         String str = String.valueOf(cb.a(this.b, F.a(F.b(ai.b.e)))); IllegalStateException illegalStateException = new IllegalStateException((new StringBuilder(79 + String.valueOf(str).length())).append("Expected to be healthy after starting. The following services are not running: ").append(str).toString());
/* 754 */         for (ai ai : this.b.get(ai.b.h)) {
/* 755 */           illegalStateException.addSuppressed(new aj.b(ai));
/*     */         }
/* 757 */         throw illegalStateException;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class e
/*     */     extends ai.a
/*     */   {
/*     */     final ai b;
/*     */ 
/*     */     
/*     */     final WeakReference<aj.f> c;
/*     */ 
/*     */     
/*     */     e(ai param1ai, WeakReference<aj.f> param1WeakReference) {
/* 774 */       this.b = param1ai;
/* 775 */       this.c = param1WeakReference;
/*     */     }
/*     */ 
/*     */     
/*     */     public void gd() {
/* 780 */       aj.f f = this.c.get();
/* 781 */       if (f != null) {
/* 782 */         f.a(this.b, ai.b.c, ai.b.d);
/* 783 */         if (!(this.b instanceof aj.d)) {
/* 784 */           aj.d().log(Level.FINE, "Starting {0}.", this.b);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void ge() {
/* 791 */       aj.f f = this.c.get();
/* 792 */       if (f != null) {
/* 793 */         f.a(this.b, ai.b.d, ai.b.e);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void e(ai.b param1b) {
/* 799 */       aj.f f = this.c.get();
/* 800 */       if (f != null) {
/* 801 */         f.a(this.b, param1b, ai.b.f);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void a(ai.b param1b) {
/* 807 */       aj.f f = this.c.get();
/* 808 */       if (f != null) {
/* 809 */         if (!(this.b instanceof aj.d)) {
/* 810 */           aj.d().log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[] { this.b, param1b });
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 815 */         f.a(this.b, param1b, ai.b.g);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void a(ai.b param1b, Throwable param1Throwable) {
/* 821 */       aj.f f = this.c.get();
/* 822 */       if (f != null) {
/*     */ 
/*     */         
/* 825 */         int i = !(this.b instanceof aj.d) ? 1 : 0;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 830 */         i &= (param1b != ai.b.d) ? 1 : 0;
/* 831 */         if (i != 0) {
/* 832 */           String str1 = String.valueOf(this.b), str2 = String.valueOf(param1b); aj.d().log(Level.SEVERE, (new StringBuilder(34 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("Service ").append(str1).append(" has failed in the ").append(str2).append(" state.").toString(), param1Throwable);
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 837 */         f.a(this.b, param1b, ai.b.h);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class d
/*     */     extends g
/*     */   {
/*     */     private d() {}
/*     */ 
/*     */ 
/*     */     
/*     */     protected void fD() {
/* 853 */       fL();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void fE() {
/* 858 */       fM();
/*     */     } }
/*     */   
/*     */   private static final class a extends Throwable {
/*     */     private a() {}
/*     */   }
/*     */   
/*     */   private static final class b extends Throwable {
/*     */     b(ai param1ai) {
/* 867 */       super(param1ai
/* 868 */           .toString(), param1ai
/* 869 */           .a(), false, false);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\aj.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */