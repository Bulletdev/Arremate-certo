/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import java.time.Duration;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.TimeoutException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public abstract class g
/*     */   implements ai
/*     */ {
/*  53 */   private static final X.a<ai.a> a = new X.a<ai.a>()
/*     */     {
/*     */       public void a(ai.a param1a)
/*     */       {
/*  57 */         param1a.gd();
/*     */       }
/*     */ 
/*     */       
/*     */       public String toString() {
/*  62 */         return "starting()";
/*     */       }
/*     */     };
/*  65 */   private static final X.a<ai.a> b = new X.a<ai.a>()
/*     */     {
/*     */       public void a(ai.a param1a)
/*     */       {
/*  69 */         param1a.ge();
/*     */       }
/*     */ 
/*     */       
/*     */       public String toString() {
/*  74 */         return "running()";
/*     */       }
/*     */     };
/*     */   
/*  78 */   private static final X.a<ai.a> c = b(ai.b.d);
/*     */   
/*  80 */   private static final X.a<ai.a> d = b(ai.b.e);
/*     */ 
/*     */   
/*  83 */   private static final X.a<ai.a> e = a(ai.b.c);
/*     */   
/*  85 */   private static final X.a<ai.a> f = a(ai.b.d);
/*     */   
/*  87 */   private static final X.a<ai.a> g = a(ai.b.e);
/*     */   
/*  89 */   private static final X.a<ai.a> h = a(ai.b.f); private final aa a; private final aa.a a; private final aa.a b;
/*     */   
/*     */   private static X.a<ai.a> a(ai.b paramb) {
/*  92 */     return new X.a<ai.a>(paramb)
/*     */       {
/*     */         public void a(ai.a param1a) {
/*  95 */           param1a.a(this.a);
/*     */         }
/*     */ 
/*     */         
/*     */         public String toString() {
/* 100 */           String str = String.valueOf(this.a); return (new StringBuilder(21 + String.valueOf(str).length())).append("terminated({from = ").append(str).append("})").toString();
/*     */         }
/*     */       };
/*     */   }
/*     */   private final aa.a c; private final aa.a d; private final X<ai.a> a;
/*     */   private static X.a<ai.a> b(ai.b paramb) {
/* 106 */     return new X.a<ai.a>(paramb)
/*     */       {
/*     */         public void a(ai.a param1a) {
/* 109 */           param1a.e(this.a);
/*     */         }
/*     */ 
/*     */         
/*     */         public String toString() {
/* 114 */           String str = String.valueOf(this.a); return (new StringBuilder(19 + String.valueOf(str).length())).append("stopping({from = ").append(str).append("})").toString();
/*     */         }
/*     */       };
/*     */   }
/*     */   
/* 119 */   private volatile e a = (e)new aa();
/*     */   protected g() {
/* 121 */     this.a = (e)new b(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 135 */     this.b = new c(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 149 */     this.c = new a(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     this.d = new d(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 178 */     this.a = (e)new X();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 189 */     this.a = new e(ai.b.c);
/*     */   }
/*     */   
/*     */   private final class b
/*     */     extends aa.a
/*     */   {
/*     */     b(g this$0) {
/*     */       super(g.a(this$0));
/*     */     }
/*     */     
/*     */     public boolean dy() {
/*     */       return (this.c.a() == ai.b.c);
/*     */     }
/*     */   }
/*     */   
/*     */   private final class c
/*     */     extends aa.a
/*     */   {
/*     */     c(g this$0) {
/*     */       super(g.a(this$0));
/*     */     }
/*     */     
/*     */     public boolean dy() {
/*     */       return (this.c.a().compareTo(ai.b.e) <= 0);
/*     */     }
/*     */   }
/*     */   
/*     */   private final class a
/*     */     extends aa.a
/*     */   {
/*     */     a(g this$0) {
/*     */       super(g.a(this$0));
/*     */     }
/*     */     
/*     */     public boolean dy() {
/*     */       return (this.c.a().compareTo(ai.b.e) >= 0);
/*     */     }
/*     */   }
/*     */   
/*     */   private final class d
/*     */     extends aa.a {
/*     */     d(g this$0) {
/*     */       super(g.a(this$0));
/*     */     }
/*     */     
/*     */     public boolean dy() {
/*     */       return this.c.a().dH();
/*     */     }
/*     */   }
/*     */   
/*     */   @com.google.a.a.a
/*     */   @com.google.b.a.g
/*     */   protected void fK() {}
/*     */   
/*     */   @com.google.b.a.a
/*     */   public final ai a() {
/* 245 */     if (this.a.a((aa.a)this.a)) {
/*     */       try {
/* 247 */         this.a = new e(ai.b.d);
/* 248 */         fO();
/* 249 */         fD();
/* 250 */       } catch (Throwable throwable) {
/* 251 */         c(throwable);
/*     */       } finally {
/* 253 */         this.a.fX();
/* 254 */         fN();
/*     */       } 
/*     */     } else {
/* 257 */       String str = String.valueOf(this); throw new IllegalStateException((new StringBuilder(33 + String.valueOf(str).length())).append("Service ").append(str).append(" has already been started").toString());
/*     */     } 
/* 259 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public final ai b() {
/* 265 */     if (this.a.a(this.b)) {
/*     */       try {
/* 267 */         String str; ai.b b = a();
/* 268 */         switch (null.ad[b.ordinal()]) {
/*     */           case 1:
/* 270 */             this.a = new e(ai.b.g);
/* 271 */             d(ai.b.c);
/*     */             break;
/*     */           case 2:
/* 274 */             this.a = new e(ai.b.d, true, null);
/* 275 */             c(ai.b.d);
/* 276 */             fK();
/*     */             break;
/*     */           case 3:
/* 279 */             this.a = new e(ai.b.f);
/* 280 */             c(ai.b.e);
/* 281 */             fE();
/*     */             break;
/*     */           
/*     */           case 4:
/*     */           case 5:
/*     */           case 6:
/* 287 */             str = String.valueOf(b); throw new AssertionError((new StringBuilder(45 + String.valueOf(str).length())).append("isStoppable is incorrectly implemented, saw: ").append(str).toString());
/*     */         } 
/* 289 */       } catch (Throwable throwable) {
/* 290 */         c(throwable);
/*     */       } finally {
/* 292 */         this.a.fX();
/* 293 */         fN();
/*     */       } 
/*     */     }
/* 296 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fB() {
/* 301 */     this.a.b(this.c);
/*     */     try {
/* 303 */       b(ai.b.e);
/*     */     } finally {
/* 305 */       this.a.fX();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(Duration paramDuration) throws TimeoutException {
/* 312 */     super.a(paramDuration);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void a(long paramLong, TimeUnit paramTimeUnit) throws TimeoutException {
/* 317 */     if (this.a.b(this.c, paramLong, paramTimeUnit)) {
/*     */       try {
/* 319 */         b(ai.b.e);
/*     */       } finally {
/* 321 */         this.a.fX();
/*     */       
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 328 */       String str = String.valueOf(this); throw new TimeoutException((new StringBuilder(50 + String.valueOf(str).length())).append("Timed out waiting for ").append(str).append(" to reach the RUNNING state.").toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void fC() {
/* 334 */     this.a.b(this.d);
/*     */     try {
/* 336 */       b(ai.b.g);
/*     */     } finally {
/* 338 */       this.a.fX();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(Duration paramDuration) throws TimeoutException {
/* 345 */     super.b(paramDuration);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void b(long paramLong, TimeUnit paramTimeUnit) throws TimeoutException {
/* 350 */     if (this.a.b(this.d, paramLong, paramTimeUnit)) {
/*     */       try {
/* 352 */         b(ai.b.g);
/*     */       } finally {
/* 354 */         this.a.fX();
/*     */       
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 361 */       String str1 = String.valueOf(this);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 366 */       String str2 = String.valueOf(a()); throw new TimeoutException((new StringBuilder(65 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("Timed out waiting for ").append(str1).append(" to reach a terminal state. Current state: ").append(str2).toString());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.b.a.a.a("monitor")
/*     */   private void b(ai.b paramb) {
/* 373 */     ai.b b1 = a();
/* 374 */     if (b1 != paramb) {
/* 375 */       if (b1 == ai.b.h) {
/*     */         
/* 377 */         String str4 = String.valueOf(this), str5 = String.valueOf(paramb); throw new IllegalStateException((new StringBuilder(56 + String.valueOf(str4).length() + String.valueOf(str5).length())).append("Expected the service ").append(str4).append(" to be ").append(str5).append(", but the service has FAILED").toString(), 
/*     */             
/* 379 */             a());
/*     */       } 
/* 381 */       String str1 = String.valueOf(this), str2 = String.valueOf(paramb), str3 = String.valueOf(b1); throw new IllegalStateException((new StringBuilder(38 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length())).append("Expected the service ").append(str1).append(" to be ").append(str2).append(", but was ").append(str3).toString());
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
/*     */   protected final void fL() {
/* 393 */     this.a.enter();
/*     */ 
/*     */     
/*     */     try {
/* 397 */       if (this.a.b != ai.b.d) {
/* 398 */         String str = String.valueOf(this.a.b); IllegalStateException illegalStateException = new IllegalStateException((new StringBuilder(43 + String.valueOf(str).length())).append("Cannot notifyStarted() when the service is ").append(str).toString());
/*     */ 
/*     */         
/* 401 */         c(illegalStateException);
/* 402 */         throw illegalStateException;
/*     */       } 
/*     */       
/* 405 */       if (this.a.bl) {
/* 406 */         this.a = new e(ai.b.f);
/*     */ 
/*     */         
/* 409 */         fE();
/*     */       } else {
/* 411 */         this.a = new e(ai.b.e);
/* 412 */         fP();
/*     */       } 
/*     */     } finally {
/* 415 */       this.a.fX();
/* 416 */       fN();
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
/*     */   protected final void fM() {
/* 429 */     this.a.enter(); try {
/*     */       String str;
/* 431 */       ai.b b = a();
/* 432 */       switch (null.ad[b.ordinal()]) {
/*     */         case 1:
/*     */         case 5:
/*     */         case 6:
/* 436 */           str = String.valueOf(b); throw new IllegalStateException((new StringBuilder(43 + String.valueOf(str).length())).append("Cannot notifyStopped() when the service is ").append(str).toString());
/*     */         case 2:
/*     */         case 3:
/*     */         case 4:
/* 440 */           this.a = new e(ai.b.g);
/* 441 */           d(b);
/*     */           break;
/*     */       } 
/*     */     } finally {
/* 445 */       this.a.fX();
/* 446 */       fN();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void c(Throwable paramThrowable) {
/* 456 */     D.checkNotNull(paramThrowable);
/*     */     
/* 458 */     this.a.enter(); try {
/*     */       String str;
/* 460 */       ai.b b = a();
/* 461 */       switch (null.ad[b.ordinal()]) {
/*     */         case 1:
/*     */         case 5:
/* 464 */           str = String.valueOf(b); throw new IllegalStateException((new StringBuilder(22 + String.valueOf(str).length())).append("Failed while in state:").append(str).toString(), paramThrowable);
/*     */         case 2:
/*     */         case 3:
/*     */         case 4:
/* 468 */           this.a = new e(ai.b.h, false, paramThrowable);
/* 469 */           b(b, paramThrowable);
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */     
/*     */     } finally {
/* 476 */       this.a.fX();
/* 477 */       fN();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isRunning() {
/* 483 */     return (a() == ai.b.e);
/*     */   }
/*     */ 
/*     */   
/*     */   public final ai.b a() {
/* 488 */     return this.a.b();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Throwable a() {
/* 494 */     return this.a.a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(ai.a parama, Executor paramExecutor) {
/* 500 */     this.a.a(parama, paramExecutor);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 505 */     String str1 = getClass().getSimpleName(), str2 = String.valueOf(a()); return (new StringBuilder(3 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(" [").append(str2).append("]").toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void fN() {
/* 513 */     if (!this.a.dE()) {
/* 514 */       this.a.fV();
/*     */     }
/*     */   }
/*     */   
/*     */   private void fO() {
/* 519 */     this.a.a((X.a)a);
/*     */   }
/*     */   
/*     */   private void fP() {
/* 523 */     this.a.a((X.a)b);
/*     */   }
/*     */   
/*     */   private void c(ai.b paramb) {
/* 527 */     if (paramb == ai.b.d) {
/* 528 */       this.a.a((X.a)c);
/* 529 */     } else if (paramb == ai.b.e) {
/* 530 */       this.a.a((X.a)d);
/*     */     } else {
/* 532 */       throw new AssertionError();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void d(ai.b paramb) {
/* 537 */     switch (null.ad[paramb.ordinal()]) {
/*     */       case 1:
/* 539 */         this.a.a(e);
/*     */         break;
/*     */       case 2:
/* 542 */         this.a.a(f);
/*     */         break;
/*     */       case 3:
/* 545 */         this.a.a(g);
/*     */         break;
/*     */       case 4:
/* 548 */         this.a.a(h);
/*     */         break;
/*     */       case 5:
/*     */       case 6:
/* 552 */         throw new AssertionError();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void b(ai.b paramb, Throwable paramThrowable) {
/* 558 */     this.a.a(new X.a<ai.a>(this, paramb, paramThrowable)
/*     */         {
/*     */           public void a(ai.a param1a)
/*     */           {
/* 562 */             param1a.a(this.a, this.d);
/*     */           }
/*     */ 
/*     */           
/*     */           public String toString() {
/* 567 */             String str1 = String.valueOf(this.a), str2 = String.valueOf(this.d); return (new StringBuilder(27 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("failed({from = ").append(str1).append(", cause = ").append(str2).append("})").toString();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.g
/*     */   protected abstract void fD();
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.g
/*     */   protected abstract void fE();
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class e
/*     */   {
/*     */     final ai.b b;
/*     */     
/*     */     final boolean bl;
/*     */     
/*     */     final Throwable e;
/*     */ 
/*     */     
/*     */     e(ai.b param1b) {
/* 594 */       this(param1b, false, null);
/*     */     }
/*     */ 
/*     */     
/*     */     e(ai.b param1b, boolean param1Boolean, Throwable param1Throwable) {
/* 599 */       D.a((!param1Boolean || param1b == ai.b.d), "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", param1b);
/*     */ 
/*     */ 
/*     */       
/* 603 */       D.a(((((param1Throwable != null) ? 1 : 0) ^ ((param1b == ai.b.h) ? 1 : 0)) == 0), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", param1b, param1Throwable);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 609 */       this.b = param1b;
/* 610 */       this.bl = param1Boolean;
/* 611 */       this.e = param1Throwable;
/*     */     }
/*     */ 
/*     */     
/*     */     ai.b b() {
/* 616 */       if (this.bl && this.b == ai.b.d) {
/* 617 */         return ai.b.f;
/*     */       }
/* 619 */       return this.b;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     Throwable a() {
/* 625 */       D.b((this.b == ai.b.h), "failureCause() is only valid if the service has failed, service is %s", this.b);
/*     */ 
/*     */ 
/*     */       
/* 629 */       return this.e;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */