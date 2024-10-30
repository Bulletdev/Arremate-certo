/*      */ package com.google.a.c;
/*      */ 
/*      */ import com.google.a.a.b;
/*      */ import com.google.a.a.c;
/*      */ import com.google.a.b.D;
/*      */ import com.google.a.b.M;
/*      */ import com.google.a.b.N;
/*      */ import com.google.a.b.P;
/*      */ import com.google.a.b.c;
/*      */ import com.google.a.b.l;
/*      */ import com.google.a.b.x;
/*      */ import java.time.Duration;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */ public final class d<K, V>
/*      */ {
/*      */   private static final int DEFAULT_INITIAL_CAPACITY = 16;
/*      */   private static final int dz = 4;
/*      */   private static final int dA = 0;
/*      */   private static final int dB = 0;
/*      */   
/*  165 */   static final M<? extends a.b> c = N.a(new a.b()
/*      */       {
/*      */         public void au(int param1Int) {}
/*      */ 
/*      */ 
/*      */         
/*      */         public void av(int param1Int) {}
/*      */ 
/*      */ 
/*      */         
/*      */         public void E(long param1Long) {}
/*      */ 
/*      */ 
/*      */         
/*      */         public void F(long param1Long) {}
/*      */ 
/*      */         
/*      */         public void eB() {}
/*      */ 
/*      */         
/*      */         public g b() {
/*  186 */           return (g)d.a;
/*      */         }
/*      */       });
/*  189 */   static final g a = new g(0L, 0L, 0L, 0L, 0L, 0L);
/*      */   
/*  191 */   static final M<a.b> d = new M<a.b>()
/*      */     {
/*      */       public a.b a()
/*      */       {
/*  195 */         return new a.a();
/*      */       }
/*      */     };
/*      */   
/*      */   enum a implements q<Object, Object> {
/*  200 */     a;
/*      */     
/*      */     public void a(s<Object, Object> param1s) {}
/*      */   }
/*      */   
/*      */   enum b
/*      */     implements u<Object, Object> {
/*  207 */     a;
/*      */ 
/*      */     
/*      */     public int a(Object param1Object1, Object param1Object2) {
/*  211 */       return 1;
/*      */     }
/*      */   }
/*      */   
/*  215 */   static final P c = new P()
/*      */     {
/*      */       public long H()
/*      */       {
/*  219 */         return 0L;
/*      */       }
/*      */     };
/*      */   
/*  223 */   private static final Logger logger = Logger.getLogger(d.class.getName());
/*      */   
/*      */   static final int dC = -1;
/*      */   
/*      */   boolean aA = true;
/*      */   
/*  229 */   int dD = -1;
/*  230 */   int dE = -1;
/*  231 */   long aa = -1L;
/*  232 */   long ab = -1L;
/*      */   
/*      */   u<? super K, ? super V> a;
/*      */   
/*      */   k.r a;
/*      */   k.r b;
/*  238 */   long ac = -1L;
/*      */ 
/*      */   
/*  241 */   long ad = -1L;
/*      */ 
/*      */   
/*  244 */   long ae = -1L;
/*      */   
/*      */   l<Object> d;
/*      */   
/*      */   l<Object> e;
/*      */   
/*      */   q<? super K, ? super V> a;
/*      */   
/*      */   P a;
/*  253 */   M<? extends a.b> e = (M<? extends a.b>)c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static d<Object, Object> a() {
/*  265 */     return new d<>();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @c
/*      */   public static d<Object, Object> a(e parame) {
/*  275 */     return parame.g().b();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @c
/*      */   public static d<Object, Object> a(String paramString) {
/*  287 */     return a(e.a(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @c
/*      */   d<K, V> b() {
/*  297 */     this.aA = false;
/*  298 */     return this;
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
/*      */   @c
/*      */   d<K, V> a(l<Object> paraml) {
/*  311 */     D.b((this.d == null), "key equivalence was already set to %s", this.d);
/*  312 */     this.d = (l<Object>)D.checkNotNull(paraml);
/*  313 */     return this;
/*      */   }
/*      */   
/*      */   l<Object> d() {
/*  317 */     return (l<Object>)x.a(this.d, a().f());
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
/*      */   @c
/*      */   d<K, V> b(l<Object> paraml) {
/*  331 */     D.b((this.e == null), "value equivalence was already set to %s", this.e);
/*      */     
/*  333 */     this.e = (M<? extends a.b>)D.checkNotNull(paraml);
/*  334 */     return this;
/*      */   }
/*      */   
/*      */   l<Object> e() {
/*  338 */     return (l<Object>)x.a(this.e, b().f());
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
/*      */   public d<K, V> a(int paramInt) {
/*  353 */     D.b((this.dD == -1), "initial capacity was already set to %s", this.dD);
/*      */ 
/*      */ 
/*      */     
/*  357 */     D.checkArgument((paramInt >= 0));
/*  358 */     this.dD = paramInt;
/*  359 */     return this;
/*      */   }
/*      */   
/*      */   int ad() {
/*  363 */     return (this.dD == -1) ? 16 : this.dD;
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
/*      */   public d<K, V> b(int paramInt) {
/*  398 */     D.b((this.dE == -1), "concurrency level was already set to %s", this.dE);
/*      */ 
/*      */ 
/*      */     
/*  402 */     D.checkArgument((paramInt > 0));
/*  403 */     this.dE = paramInt;
/*  404 */     return this;
/*      */   }
/*      */   
/*      */   int ae() {
/*  408 */     return (this.dE == -1) ? 4 : this.dE;
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
/*      */   public d<K, V> a(long paramLong) {
/*  433 */     D.b((this.aa == -1L), "maximum size was already set to %s", this.aa);
/*      */     
/*  435 */     D.b((this.ab == -1L), "maximum weight was already set to %s", this.ab);
/*      */ 
/*      */ 
/*      */     
/*  439 */     D.b((this.a == null), "maximum size can not be combined with weigher");
/*  440 */     D.a((paramLong >= 0L), "maximum size must not be negative");
/*  441 */     this.aa = paramLong;
/*  442 */     return this;
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
/*      */   @c
/*      */   public d<K, V> b(long paramLong) {
/*  474 */     D.b((this.ab == -1L), "maximum weight was already set to %s", this.ab);
/*      */ 
/*      */ 
/*      */     
/*  478 */     D.b((this.aa == -1L), "maximum size was already set to %s", this.aa);
/*      */     
/*  480 */     this.ab = paramLong;
/*  481 */     D.a((paramLong >= 0L), "maximum weight must not be negative");
/*  482 */     return this;
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
/*      */   @c
/*      */   public <K1 extends K, V1 extends V> d<K1, V1> a(u<? super K1, ? super V1> paramu) {
/*  517 */     D.ab((this.a == null));
/*  518 */     if (this.aA) {
/*  519 */       D.b((this.aa == -1L), "weigher can not be combined with maximum size", this.aa);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  527 */     d<K1, V1> d1 = this;
/*  528 */     d1.a = (P)D.checkNotNull(paramu);
/*  529 */     return d1;
/*      */   }
/*      */   
/*      */   long I() {
/*  533 */     if (this.ac == 0L || this.ad == 0L) {
/*  534 */       return 0L;
/*      */     }
/*  536 */     return (this.a == null) ? this.aa : this.ab;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   <K1 extends K, V1 extends V> u<K1, V1> a() {
/*  542 */     return (u<K1, V1>)x.a(this.a, b.a);
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
/*      */   @c
/*      */   public d<K, V> c() {
/*  563 */     return a(k.r.f);
/*      */   }
/*      */   
/*      */   d<K, V> a(k.r paramr) {
/*  567 */     D.b((this.a == null), "Key strength was already set to %s", this.a);
/*  568 */     this.a = (P)D.checkNotNull(paramr);
/*  569 */     return this;
/*      */   }
/*      */   
/*      */   k.r a() {
/*  573 */     return (k.r)x.a(this.a, k.r.d);
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
/*      */   @c
/*      */   public d<K, V> d() {
/*  595 */     return b(k.r.f);
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
/*      */   @c
/*      */   public d<K, V> e() {
/*  620 */     return b(k.r.e);
/*      */   }
/*      */   
/*      */   d<K, V> b(k.r paramr) {
/*  624 */     D.b((this.b == null), "Value strength was already set to %s", this.b);
/*  625 */     this.b = (k.r)D.checkNotNull(paramr);
/*  626 */     return this;
/*      */   }
/*      */   
/*      */   k.r b() {
/*  630 */     return (k.r)x.a(this.b, k.r.d);
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
/*      */   @c
/*      */   public d<K, V> a(Duration paramDuration) {
/*  657 */     return a(a(paramDuration), TimeUnit.NANOSECONDS);
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
/*      */   public d<K, V> a(long paramLong, TimeUnit paramTimeUnit) {
/*  684 */     D.b((this.ac == -1L), "expireAfterWrite was already set to %s ns", this.ac);
/*      */ 
/*      */ 
/*      */     
/*  688 */     D.a((paramLong >= 0L), "duration cannot be negative: %s %s", paramLong, paramTimeUnit);
/*  689 */     this.ac = paramTimeUnit.toNanos(paramLong);
/*  690 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   long J() {
/*  695 */     return (this.ac == -1L) ? 0L : this.ac;
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
/*      */   @c
/*      */   public d<K, V> b(Duration paramDuration) {
/*  727 */     return b(a(paramDuration), TimeUnit.NANOSECONDS);
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
/*      */   public d<K, V> b(long paramLong, TimeUnit paramTimeUnit) {
/*  759 */     D.b((this.ad == -1L), "expireAfterAccess was already set to %s ns", this.ad);
/*      */ 
/*      */ 
/*      */     
/*  763 */     D.a((paramLong >= 0L), "duration cannot be negative: %s %s", paramLong, paramTimeUnit);
/*  764 */     this.ad = paramTimeUnit.toNanos(paramLong);
/*  765 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   long K() {
/*  770 */     return (this.ad == -1L) ? 
/*  771 */       0L : 
/*  772 */       this.ad;
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
/*      */   @c
/*      */   public d<K, V> c(Duration paramDuration) {
/*  805 */     return c(a(paramDuration), TimeUnit.NANOSECONDS);
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
/*      */   @c
/*      */   public d<K, V> c(long paramLong, TimeUnit paramTimeUnit) {
/*  840 */     D.checkNotNull(paramTimeUnit);
/*  841 */     D.b((this.ae == -1L), "refresh was already set to %s ns", this.ae);
/*  842 */     D.a((paramLong > 0L), "duration must be positive: %s %s", paramLong, paramTimeUnit);
/*  843 */     this.ae = paramTimeUnit.toNanos(paramLong);
/*  844 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   long L() {
/*  849 */     return (this.ae == -1L) ? 0L : this.ae;
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
/*      */   public d<K, V> a(P paramP) {
/*  863 */     D.ab((this.a == null));
/*  864 */     this.a = (P)D.checkNotNull(paramP);
/*  865 */     return this;
/*      */   }
/*      */   
/*      */   P a(boolean paramBoolean) {
/*  869 */     if (this.a != null) {
/*  870 */       return this.a;
/*      */     }
/*  872 */     return paramBoolean ? P.a() : c;
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
/*      */   @com.google.b.a.b
/*      */   public <K1 extends K, V1 extends V> d<K1, V1> a(q<? super K1, ? super V1> paramq) {
/*  899 */     D.ab((this.a == null));
/*      */ 
/*      */ 
/*      */     
/*  903 */     d<K1, V1> d1 = this;
/*  904 */     d1.a = (P)D.checkNotNull(paramq);
/*  905 */     return d1;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   <K1 extends K, V1 extends V> q<K1, V1> a() {
/*  911 */     return 
/*  912 */       (q<K1, V1>)x.a(this.a, a.a);
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
/*      */   public d<K, V> f() {
/*  925 */     this.e = (M)d;
/*  926 */     return this;
/*      */   }
/*      */   
/*      */   boolean ct() {
/*  930 */     return (this.e == d);
/*      */   }
/*      */   
/*      */   M<? extends a.b> a() {
/*  934 */     return this.e;
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
/*      */   public <K1 extends K, V1 extends V> j<K1, V1> a(f<? super K1, V1> paramf) {
/*  951 */     eD();
/*  952 */     return new k.l<>(this, paramf);
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
/*      */   public <K1 extends K, V1 extends V> c<K1, V1> a() {
/*  968 */     eD();
/*  969 */     eC();
/*  970 */     return new k.m<>(this);
/*      */   }
/*      */   
/*      */   private void eC() {
/*  974 */     D.b((this.ae == -1L), "refreshAfterWrite requires a LoadingCache");
/*      */   }
/*      */   
/*      */   private void eD() {
/*  978 */     if (this.a == null) {
/*  979 */       D.b((this.ab == -1L), "maximumWeight requires weigher");
/*      */     }
/*  981 */     else if (this.aA) {
/*  982 */       D.b((this.ab != -1L), "weigher requires maximumWeight");
/*      */     }
/*  984 */     else if (this.ab == -1L) {
/*  985 */       logger.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
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
/*      */   public String toString() {
/*  997 */     x.a a = x.a(this);
/*  998 */     if (this.dD != -1) {
/*  999 */       a.a("initialCapacity", this.dD);
/*      */     }
/* 1001 */     if (this.dE != -1) {
/* 1002 */       a.a("concurrencyLevel", this.dE);
/*      */     }
/* 1004 */     if (this.aa != -1L) {
/* 1005 */       a.a("maximumSize", this.aa);
/*      */     }
/* 1007 */     if (this.ab != -1L) {
/* 1008 */       a.a("maximumWeight", this.ab);
/*      */     }
/* 1010 */     if (this.ac != -1L) {
/* 1011 */       long l1 = this.ac; a.a("expireAfterWrite", (new StringBuilder(22)).append(l1).append("ns").toString());
/*      */     } 
/* 1013 */     if (this.ad != -1L) {
/* 1014 */       long l1 = this.ad; a.a("expireAfterAccess", (new StringBuilder(22)).append(l1).append("ns").toString());
/*      */     } 
/* 1016 */     if (this.a != null) {
/* 1017 */       a.a("keyStrength", c.ag(this.a.toString()));
/*      */     }
/* 1019 */     if (this.b != null) {
/* 1020 */       a.a("valueStrength", c.ag(this.b.toString()));
/*      */     }
/* 1022 */     if (this.d != null) {
/* 1023 */       a.b("keyEquivalence");
/*      */     }
/* 1025 */     if (this.e != null) {
/* 1026 */       a.b("valueEquivalence");
/*      */     }
/* 1028 */     if (this.a != null) {
/* 1029 */       a.b("removalListener");
/*      */     }
/* 1031 */     return a.toString();
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
/*      */   @c
/*      */   private static long a(Duration paramDuration) {
/*      */     try {
/* 1047 */       return paramDuration.toNanos();
/* 1048 */     } catch (ArithmeticException arithmeticException) {
/* 1049 */       return paramDuration.isNegative() ? Long.MIN_VALUE : Long.MAX_VALUE;
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\c\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */