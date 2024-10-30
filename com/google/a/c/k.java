/*      */ package com.google.a.c;
/*      */ 
/*      */ import com.google.a.a.b;
/*      */ import com.google.a.b.K;
/*      */ import com.google.a.b.P;
/*      */ import com.google.a.d.bH;
/*      */ import com.google.a.d.bW;
/*      */ import com.google.a.d.bj;
/*      */ import com.google.a.d.bt;
/*      */ import com.google.a.o.a.L;
/*      */ import com.google.a.o.a.U;
/*      */ import com.google.a.o.a.ab;
/*      */ import com.google.a.o.a.al;
/*      */ import com.google.a.o.a.au;
/*      */ import com.google.a.o.a.aw;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.io.Serializable;
/*      */ import java.lang.ref.Reference;
/*      */ import java.lang.ref.ReferenceQueue;
/*      */ import java.lang.ref.SoftReference;
/*      */ import java.lang.ref.WeakReference;
/*      */ import java.util.AbstractCollection;
/*      */ import java.util.AbstractMap;
/*      */ import java.util.AbstractQueue;
/*      */ import java.util.AbstractSet;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.Map;
/*      */ import java.util.NoSuchElementException;
/*      */ import java.util.Queue;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.Callable;
/*      */ import java.util.concurrent.ConcurrentLinkedQueue;
/*      */ import java.util.concurrent.ConcurrentMap;
/*      */ import java.util.concurrent.ExecutionException;
/*      */ import java.util.concurrent.Future;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import java.util.concurrent.atomic.AtomicInteger;
/*      */ import java.util.concurrent.atomic.AtomicReferenceArray;
/*      */ import java.util.concurrent.locks.ReentrantLock;
/*      */ import java.util.function.BiFunction;
/*      */ import java.util.function.BiPredicate;
/*      */ import java.util.function.Function;
/*      */ import java.util.function.Predicate;
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
/*      */ @b(cl = true)
/*      */ class k<K, V>
/*      */   extends AbstractMap<K, V>
/*      */   implements ConcurrentMap<K, V>
/*      */ {
/*      */   static final int MAXIMUM_CAPACITY = 1073741824;
/*      */   static final int dF = 65536;
/*      */   static final int dG = 3;
/*      */   static final int dH = 63;
/*      */   static final int dI = 16;
/*  163 */   static final Logger logger = Logger.getLogger(k.class.getName());
/*      */ 
/*      */ 
/*      */   
/*      */   final int segmentMask;
/*      */ 
/*      */ 
/*      */   
/*      */   final int segmentShift;
/*      */ 
/*      */ 
/*      */   
/*      */   final p<K, V>[] a;
/*      */ 
/*      */ 
/*      */   
/*      */   final int dE;
/*      */ 
/*      */ 
/*      */   
/*      */   final com.google.a.b.l<Object> d;
/*      */ 
/*      */ 
/*      */   
/*      */   final com.google.a.b.l<Object> e;
/*      */ 
/*      */ 
/*      */   
/*      */   final r a;
/*      */ 
/*      */ 
/*      */   
/*      */   final r b;
/*      */ 
/*      */ 
/*      */   
/*      */   final long ao;
/*      */ 
/*      */ 
/*      */   
/*      */   final u<K, V> a;
/*      */ 
/*      */ 
/*      */   
/*      */   final long ad;
/*      */ 
/*      */ 
/*      */   
/*      */   final long ac;
/*      */ 
/*      */ 
/*      */   
/*      */   final long ae;
/*      */ 
/*      */ 
/*      */   
/*      */   final Queue<s<K, V>> a;
/*      */ 
/*      */ 
/*      */   
/*      */   final q<K, V> a;
/*      */ 
/*      */   
/*      */   final P a;
/*      */ 
/*      */   
/*      */   final d a;
/*      */ 
/*      */   
/*      */   final a.b a;
/*      */ 
/*      */   
/*      */   final f<? super K, V> b;
/*      */ 
/*      */ 
/*      */   
/*      */   k(d<? super K, ? super V> paramd, f<? super K, V> paramf) {
/*  240 */     this.dE = Math.min(paramd.ae(), 65536);
/*      */     
/*  242 */     this.a = (y<Object, Object>)paramd.a();
/*  243 */     this.b = (Queue<?>)paramd.b();
/*      */     
/*  245 */     this.d = paramd.d();
/*  246 */     this.e = paramd.e();
/*      */     
/*  248 */     this.ao = paramd.I();
/*  249 */     this.a = paramd.a();
/*  250 */     this.ad = paramd.K();
/*  251 */     this.ac = paramd.J();
/*  252 */     this.ae = paramd.L();
/*      */     
/*  254 */     this.a = paramd.a();
/*  255 */     this
/*      */ 
/*      */       
/*  258 */       .a = (this.a == d.a.a) ? (y)a() : (y<Object, Object>)new ConcurrentLinkedQueue();
/*      */     
/*  260 */     this.a = (y<Object, Object>)paramd.a(cE());
/*  261 */     this.a = (y<Object, Object>)d.a((r)this.a, cG(), cF());
/*  262 */     this.a = (y<Object, Object>)paramd.a().get();
/*  263 */     this.b = (Queue<?>)paramf;
/*      */     
/*  265 */     int i = Math.min(paramd.ad(), 1073741824);
/*  266 */     if (cu() && !cv()) {
/*  267 */       i = (int)Math.min(i, this.ao);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  275 */     byte b1 = 0;
/*  276 */     int j = 1;
/*  277 */     while (j < this.dE && (!cu() || (j * 20) <= this.ao)) {
/*  278 */       b1++;
/*  279 */       j <<= 1;
/*      */     } 
/*  281 */     this.segmentShift = 32 - b1;
/*  282 */     this.segmentMask = j - 1;
/*      */     
/*  284 */     this.a = (y)a(j);
/*      */     
/*  286 */     int m = i / j;
/*  287 */     if (m * j < i) {
/*  288 */       m++;
/*      */     }
/*      */     
/*  291 */     int n = 1;
/*  292 */     while (n < m) {
/*  293 */       n <<= 1;
/*      */     }
/*      */     
/*  296 */     if (cu()) {
/*      */       
/*  298 */       long l1 = this.ao / j + 1L;
/*  299 */       long l2 = this.ao % j;
/*  300 */       for (byte b2 = 0; b2 < this.a.length; b2++) {
/*  301 */         if (b2 == l2) {
/*  302 */           l1--;
/*      */         }
/*  304 */         this.a[b2] = (y)
/*  305 */           a(n, l1, (a.b)paramd.a().get());
/*      */       } 
/*      */     } else {
/*  308 */       for (byte b2 = 0; b2 < this.a.length; b2++) {
/*  309 */         this.a[b2] = (y)
/*  310 */           a(n, -1L, (a.b)paramd.a().get());
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   boolean cu() {
/*  316 */     return (this.ao >= 0L);
/*      */   }
/*      */   
/*      */   boolean cv() {
/*  320 */     return (this.a != d.b.a);
/*      */   }
/*      */   
/*      */   boolean cw() {
/*  324 */     return (cx() || cy());
/*      */   }
/*      */   
/*      */   boolean cx() {
/*  328 */     return (this.ac > 0L);
/*      */   }
/*      */   
/*      */   boolean cy() {
/*  332 */     return (this.ad > 0L);
/*      */   }
/*      */   
/*      */   boolean cz() {
/*  336 */     return (this.ae > 0L);
/*      */   }
/*      */   
/*      */   boolean cA() {
/*  340 */     return (cy() || cu());
/*      */   }
/*      */   
/*      */   boolean cB() {
/*  344 */     return cx();
/*      */   }
/*      */   
/*      */   boolean cC() {
/*  348 */     return (cx() || cz());
/*      */   }
/*      */   
/*      */   boolean cD() {
/*  352 */     return cy();
/*      */   }
/*      */   
/*      */   boolean cE() {
/*  356 */     return (cC() || cD());
/*      */   }
/*      */   
/*      */   boolean cF() {
/*  360 */     return (cB() || cC());
/*      */   }
/*      */   
/*      */   boolean cG() {
/*  364 */     return (cA() || cD());
/*      */   }
/*      */   
/*      */   boolean cH() {
/*  368 */     return (this.a != r.d);
/*      */   }
/*      */   
/*      */   boolean cI() {
/*  372 */     return (this.b != r.d);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   enum r
/*      */   {
/*  381 */     d
/*      */     {
/*      */       <K, V> k.y<K, V> a(k.p<K, V> param2p, o<K, V> param2o, V param2V, int param2Int)
/*      */       {
/*  385 */         return (param2Int == 1) ? 
/*  386 */           new k.v<>(param2V) : 
/*  387 */           new k.G<>(param2V, param2Int);
/*      */       }
/*      */ 
/*      */       
/*      */       com.google.a.b.l<Object> f() {
/*  392 */         return com.google.a.b.l.b();
/*      */       }
/*      */     },
/*  395 */     e
/*      */     {
/*      */       <K, V> k.y<K, V> a(k.p<K, V> param2p, o<K, V> param2o, V param2V, int param2Int)
/*      */       {
/*  399 */         return (param2Int == 1) ? 
/*  400 */           new k.q<>((ReferenceQueue<V>)param2p.b, param2V, param2o) : 
/*  401 */           new k.F<>((ReferenceQueue<V>)param2p.b, param2V, param2o, param2Int);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       com.google.a.b.l<Object> f() {
/*  407 */         return com.google.a.b.l.c();
/*      */       }
/*      */     },
/*  410 */     f
/*      */     {
/*      */       <K, V> k.y<K, V> a(k.p<K, V> param2p, o<K, V> param2o, V param2V, int param2Int)
/*      */       {
/*  414 */         return (param2Int == 1) ? 
/*  415 */           new k.D<>((ReferenceQueue<V>)param2p.b, param2V, param2o) : 
/*  416 */           new k.H<>((ReferenceQueue<V>)param2p.b, param2V, param2o, param2Int);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       com.google.a.b.l<Object> f() {
/*  422 */         return com.google.a.b.l.c();
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     abstract <K, V> k.y<K, V> a(k.p<K, V> param1p, o<K, V> param1o, V param1V, int param1Int);
/*      */ 
/*      */ 
/*      */     
/*      */     abstract com.google.a.b.l<Object> f();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   enum d
/*      */   {
/*  440 */     b
/*      */     {
/*      */       <K, V> o<K, V> a(k.p<K, V> param2p, K param2K, int param2Int, o<K, V> param2o)
/*      */       {
/*  444 */         return new k.u<>(param2K, param2Int, param2o);
/*      */       }
/*      */     },
/*  447 */     c
/*      */     {
/*      */       <K, V> o<K, V> a(k.p<K, V> param2p, K param2K, int param2Int, o<K, V> param2o)
/*      */       {
/*  451 */         return new k.s<>(param2K, param2Int, param2o);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       <K, V> o<K, V> a(k.p<K, V> param2p, o<K, V> param2o1, o<K, V> param2o2) {
/*  457 */         o<K, V> o1 = super.a(param2p, param2o1, param2o2);
/*  458 */         c(param2o1, o1);
/*  459 */         return o1;
/*      */       }
/*      */     },
/*  462 */     d
/*      */     {
/*      */       <K, V> o<K, V> a(k.p<K, V> param2p, K param2K, int param2Int, o<K, V> param2o)
/*      */       {
/*  466 */         return new k.w<>(param2K, param2Int, param2o);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       <K, V> o<K, V> a(k.p<K, V> param2p, o<K, V> param2o1, o<K, V> param2o2) {
/*  472 */         o<K, V> o1 = super.a(param2p, param2o1, param2o2);
/*  473 */         d(param2o1, o1);
/*  474 */         return o1;
/*      */       }
/*      */     },
/*  477 */     e
/*      */     {
/*      */       <K, V> o<K, V> a(k.p<K, V> param2p, K param2K, int param2Int, o<K, V> param2o)
/*      */       {
/*  481 */         return new k.t<>(param2K, param2Int, param2o);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       <K, V> o<K, V> a(k.p<K, V> param2p, o<K, V> param2o1, o<K, V> param2o2) {
/*  487 */         o<K, V> o1 = super.a(param2p, param2o1, param2o2);
/*  488 */         c(param2o1, o1);
/*  489 */         d(param2o1, o1);
/*  490 */         return o1;
/*      */       }
/*      */     },
/*  493 */     f
/*      */     {
/*      */       <K, V> o<K, V> a(k.p<K, V> param2p, K param2K, int param2Int, o<K, V> param2o)
/*      */       {
/*  497 */         return new k.C<>(param2p.a, param2K, param2Int, param2o);
/*      */       }
/*      */     },
/*  500 */     g
/*      */     {
/*      */       <K, V> o<K, V> a(k.p<K, V> param2p, K param2K, int param2Int, o<K, V> param2o)
/*      */       {
/*  504 */         return new k.A<>(param2p.a, param2K, param2Int, param2o);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       <K, V> o<K, V> a(k.p<K, V> param2p, o<K, V> param2o1, o<K, V> param2o2) {
/*  510 */         o<K, V> o1 = super.a(param2p, param2o1, param2o2);
/*  511 */         c(param2o1, o1);
/*  512 */         return o1;
/*      */       }
/*      */     },
/*  515 */     h
/*      */     {
/*      */       <K, V> o<K, V> a(k.p<K, V> param2p, K param2K, int param2Int, o<K, V> param2o)
/*      */       {
/*  519 */         return new k.E<>(param2p.a, param2K, param2Int, param2o);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       <K, V> o<K, V> a(k.p<K, V> param2p, o<K, V> param2o1, o<K, V> param2o2) {
/*  525 */         o<K, V> o1 = super.a(param2p, param2o1, param2o2);
/*  526 */         d(param2o1, o1);
/*  527 */         return o1;
/*      */       }
/*      */     },
/*  530 */     i
/*      */     {
/*      */       <K, V> o<K, V> a(k.p<K, V> param2p, K param2K, int param2Int, o<K, V> param2o)
/*      */       {
/*  534 */         return new k.B<>(param2p.a, param2K, param2Int, param2o);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       <K, V> o<K, V> a(k.p<K, V> param2p, o<K, V> param2o1, o<K, V> param2o2) {
/*  540 */         o<K, V> o1 = super.a(param2p, param2o1, param2o2);
/*  541 */         c(param2o1, o1);
/*  542 */         d(param2o1, o1);
/*  543 */         return o1;
/*      */       }
/*      */     };
/*      */ 
/*      */     
/*      */     static final int dJ = 1;
/*      */     
/*      */     static final int dK = 2;
/*      */     
/*      */     static final int dL = 4;
/*      */     
/*  554 */     static final d[] a = new d[] { (d)b, c, d, e, f, g, h, i };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     static {
/*      */     
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     static d a(k.r param1r, boolean param1Boolean1, boolean param1Boolean2) {
/*  570 */       int i = ((param1r == k.r.f) ? 4 : 0) | (param1Boolean1 ? 1 : 0) | (param1Boolean2 ? 2 : 0);
/*  571 */       return a[i];
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     <K, V> o<K, V> a(k.p<K, V> param1p, o<K, V> param1o1, o<K, V> param1o2) {
/*  594 */       return a(param1p, param1o1.getKey(), param1o1.ag(), param1o2);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     <K, V> void c(o<K, V> param1o1, o<K, V> param1o2) {
/*  601 */       param1o2.G(param1o1.V());
/*      */       
/*  603 */       k.a(param1o1.e(), param1o2);
/*  604 */       k.a(param1o2, param1o1.d());
/*      */       
/*  606 */       k.b(param1o1);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     <K, V> void d(o<K, V> param1o1, o<K, V> param1o2) {
/*  613 */       param1o2.H(param1o1.W());
/*      */       
/*  615 */       k.b(param1o1.g(), param1o2);
/*  616 */       k.b(param1o2, param1o1.f());
/*      */       
/*  618 */       k.c(param1o1);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     abstract <K, V> o<K, V> a(k.p<K, V> param1p, K param1K, int param1Int, o<K, V> param1o);
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
/*  679 */   static final y<Object, Object> a = new y<Object, Object>()
/*      */     {
/*      */       public Object get()
/*      */       {
/*  683 */         return null;
/*      */       }
/*      */ 
/*      */       
/*      */       public int af() {
/*  688 */         return 0;
/*      */       }
/*      */ 
/*      */       
/*      */       public o<Object, Object> b() {
/*  693 */         return null;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public k.y<Object, Object> a(ReferenceQueue<Object> param1ReferenceQueue, Object param1Object, o<Object, Object> param1o) {
/*  701 */         return this;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean cJ() {
/*  706 */         return false;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean isActive() {
/*  711 */         return false;
/*      */       }
/*      */ 
/*      */       
/*      */       public Object g() {
/*  716 */         return null;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public void f(Object param1Object) {}
/*      */     };
/*      */ 
/*      */   
/*      */   static <K, V> y<K, V> a() {
/*  726 */     return (y)a;
/*      */   }
/*      */   
/*      */   private enum o implements o<Object, Object> {
/*  730 */     a;
/*      */ 
/*      */     
/*      */     public k.y<Object, Object> b() {
/*  734 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public void b(k.y<Object, Object> param1y) {}
/*      */ 
/*      */     
/*      */     public o<Object, Object> c() {
/*  742 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public int ag() {
/*  747 */       return 0;
/*      */     }
/*      */ 
/*      */     
/*      */     public Object getKey() {
/*  752 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public long V() {
/*  757 */       return 0L;
/*      */     }
/*      */ 
/*      */     
/*      */     public void G(long param1Long) {}
/*      */ 
/*      */     
/*      */     public o<Object, Object> d() {
/*  765 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public void d(o<Object, Object> param1o) {}
/*      */ 
/*      */     
/*      */     public o<Object, Object> e() {
/*  773 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public void e(o<Object, Object> param1o) {}
/*      */ 
/*      */     
/*      */     public long W() {
/*  781 */       return 0L;
/*      */     }
/*      */ 
/*      */     
/*      */     public void H(long param1Long) {}
/*      */ 
/*      */     
/*      */     public o<Object, Object> f() {
/*  789 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public void f(o<Object, Object> param1o) {}
/*      */ 
/*      */     
/*      */     public o<Object, Object> g() {
/*  797 */       return this;
/*      */     }
/*      */     
/*      */     public void g(o<Object, Object> param1o) {}
/*      */   }
/*      */   
/*      */   static abstract class b<K, V>
/*      */     implements o<K, V>
/*      */   {
/*      */     public k.y<K, V> b() {
/*  807 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public void b(k.y<K, V> param1y) {
/*  812 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public o<K, V> c() {
/*  817 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public int ag() {
/*  822 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public K getKey() {
/*  827 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public long V() {
/*  832 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public void G(long param1Long) {
/*  837 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public o<K, V> d() {
/*  842 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public void d(o<K, V> param1o) {
/*  847 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public o<K, V> e() {
/*  852 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public void e(o<K, V> param1o) {
/*  857 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public long W() {
/*  862 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public void H(long param1Long) {
/*  867 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public o<K, V> f() {
/*  872 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public void f(o<K, V> param1o) {
/*  877 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public o<K, V> g() {
/*  882 */       throw new UnsupportedOperationException();
/*      */     }
/*      */ 
/*      */     
/*      */     public void g(o<K, V> param1o) {
/*  887 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   static <K, V> o<K, V> a() {
/*  893 */     return (o<K, V>)o.a;
/*      */   }
/*      */   
/*  896 */   static final Queue<?> b = new AbstractQueue()
/*      */     {
/*      */       public boolean offer(Object param1Object)
/*      */       {
/*  900 */         return true;
/*      */       }
/*      */ 
/*      */       
/*      */       public Object peek() {
/*  905 */         return null;
/*      */       }
/*      */ 
/*      */       
/*      */       public Object poll() {
/*  910 */         return null;
/*      */       }
/*      */ 
/*      */       
/*      */       public int size() {
/*  915 */         return 0;
/*      */       }
/*      */ 
/*      */       
/*      */       public Iterator<Object> iterator() {
/*  920 */         return (Iterator<Object>)bt.n().b();
/*      */       }
/*      */     }; @com.google.c.a.h
/*      */   Set<K> keySet; @com.google.c.a.h
/*      */   Collection<V> values; @com.google.c.a.h
/*      */   Set<Map.Entry<K, V>> entrySet;
/*      */   static <E> Queue<E> a() {
/*  927 */     return (Queue)b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class u<K, V>
/*      */     extends b<K, V>
/*      */   {
/*      */     final K key;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final int hash;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final o<K, V> h;
/*      */ 
/*      */ 
/*      */     
/*      */     volatile k.y<K, V> c;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     u(K param1K, int param1Int, o<K, V> param1o) {
/*  957 */       this.c = k.a();
/*      */       this.key = param1K;
/*      */       this.hash = param1Int;
/*      */       this.h = param1o;
/*  961 */     } public K getKey() { return this.key; } public k.y<K, V> b() { return this.c; }
/*      */ 
/*      */ 
/*      */     
/*      */     public void b(k.y<K, V> param1y) {
/*  966 */       this.c = param1y;
/*      */     }
/*      */ 
/*      */     
/*      */     public int ag() {
/*  971 */       return this.hash;
/*      */     }
/*      */ 
/*      */     
/*      */     public o<K, V> c() {
/*  976 */       return this.h;
/*      */     } }
/*      */   static final class s<K, V> extends u<K, V> { volatile long ar; @com.google.c.a.i
/*      */     o<K, V> b; @com.google.c.a.i
/*      */     o<K, V> c;
/*      */     
/*  982 */     s(K param1K, int param1Int, o<K, V> param1o) { super(param1K, param1Int, param1o);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  987 */       this.ar = Long.MAX_VALUE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1000 */       this.b = k.a();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1013 */       this.c = k.a(); } public long V() { return this.ar; }
/*      */     public void G(long param1Long) { this.ar = param1Long; }
/*      */     public o<K, V> d() { return this.b; }
/*      */     public void d(o<K, V> param1o) { this.b = param1o; }
/* 1017 */     public o<K, V> e() { return this.c; }
/*      */ 
/*      */ 
/*      */     
/*      */     public void e(o<K, V> param1o) {
/* 1022 */       this.c = param1o;
/*      */     } }
/*      */   static final class w<K, V> extends u<K, V> { volatile long as; @com.google.c.a.i
/*      */     o<K, V> f; @com.google.c.a.i
/*      */     o<K, V> g;
/*      */     
/* 1028 */     w(K param1K, int param1Int, o<K, V> param1o) { super(param1K, param1Int, param1o);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1033 */       this.as = Long.MAX_VALUE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1046 */       this.f = k.a();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1059 */       this.g = k.a(); } public long W() { return this.as; }
/*      */     public void H(long param1Long) { this.as = param1Long; }
/*      */     public o<K, V> f() { return this.f; }
/*      */     public void f(o<K, V> param1o) { this.f = param1o; }
/* 1063 */     public o<K, V> g() { return this.g; }
/*      */ 
/*      */ 
/*      */     
/*      */     public void g(o<K, V> param1o) {
/* 1068 */       this.g = param1o;
/*      */     } } static final class t<K, V> extends u<K, V> { volatile long ar; @com.google.c.a.i
/*      */     o<K, V> b; @com.google.c.a.i
/*      */     o<K, V> c; volatile long as; @com.google.c.a.i
/*      */     o<K, V> f; @com.google.c.a.i
/*      */     o<K, V> g;
/* 1074 */     t(K param1K, int param1Int, o<K, V> param1o) { super(param1K, param1Int, param1o);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1079 */       this.ar = Long.MAX_VALUE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1092 */       this.b = k.a();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1105 */       this.c = k.a();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1119 */       this.as = Long.MAX_VALUE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1132 */       this.f = k.a();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1145 */       this.g = k.a(); } public long V() { return this.ar; } public void G(long param1Long) { this.ar = param1Long; }
/*      */     public o<K, V> d() { return this.b; }
/*      */     public void d(o<K, V> param1o) { this.b = param1o; }
/*      */     public o<K, V> e() { return this.c; }
/* 1149 */     public o<K, V> g() { return this.g; } public void e(o<K, V> param1o) { this.c = param1o; }
/*      */     public long W() { return this.as; }
/*      */     public void H(long param1Long) { this.as = param1Long; }
/*      */     public o<K, V> f() { return this.f; }
/*      */     public void f(o<K, V> param1o) { this.f = param1o; }
/* 1154 */     public void g(o<K, V> param1o) { this.g = param1o; } }
/*      */    static class C<K, V> extends WeakReference<K> implements o<K, V> { final int hash; final o<K, V> h; volatile k.y<K, V> c; public K getKey() {
/*      */       return get();
/*      */     } public long V() {
/*      */       throw new UnsupportedOperationException();
/*      */     } public void G(long param1Long) {
/*      */       throw new UnsupportedOperationException();
/* 1161 */     } C(ReferenceQueue<K> param1ReferenceQueue, K param1K, int param1Int, o<K, V> param1o) { super(param1K, param1ReferenceQueue);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1244 */       this.c = k.a(); this.hash = param1Int;
/*      */       this.h = param1o; }
/*      */     public o<K, V> d() { throw new UnsupportedOperationException(); }
/*      */     public void d(o<K, V> param1o) { throw new UnsupportedOperationException(); }
/* 1248 */     public o<K, V> e() { throw new UnsupportedOperationException(); } public k.y<K, V> b() { return this.c; } public void e(o<K, V> param1o) { throw new UnsupportedOperationException(); }
/*      */     public long W() { throw new UnsupportedOperationException(); }
/*      */     public void H(long param1Long) {
/*      */       throw new UnsupportedOperationException();
/*      */     }
/* 1253 */     public void b(k.y<K, V> param1y) { this.c = param1y; } public o<K, V> f() { throw new UnsupportedOperationException(); }
/*      */     public void f(o<K, V> param1o) { throw new UnsupportedOperationException(); }
/*      */     public o<K, V> g() { throw new UnsupportedOperationException(); }
/*      */     public void g(o<K, V> param1o) { throw new UnsupportedOperationException(); }
/*      */     public int ag() {
/* 1258 */       return this.hash;
/*      */     }
/*      */ 
/*      */     
/*      */     public o<K, V> c() {
/* 1263 */       return this.h;
/*      */     } }
/*      */   static final class A<K, V> extends C<K, V> { volatile long ar; @com.google.c.a.i
/*      */     o<K, V> b; @com.google.c.a.i
/*      */     o<K, V> c;
/*      */     
/* 1269 */     A(ReferenceQueue<K> param1ReferenceQueue, K param1K, int param1Int, o<K, V> param1o) { super(param1ReferenceQueue, param1K, param1Int, param1o);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1274 */       this.ar = Long.MAX_VALUE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1287 */       this.b = k.a();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1300 */       this.c = k.a(); } public long V() { return this.ar; }
/*      */     public void G(long param1Long) { this.ar = param1Long; }
/*      */     public o<K, V> d() { return this.b; }
/*      */     public void d(o<K, V> param1o) { this.b = param1o; }
/* 1304 */     public o<K, V> e() { return this.c; }
/*      */ 
/*      */ 
/*      */     
/*      */     public void e(o<K, V> param1o) {
/* 1309 */       this.c = param1o;
/*      */     } }
/*      */   static final class E<K, V> extends C<K, V> { volatile long as; @com.google.c.a.i
/*      */     o<K, V> f; @com.google.c.a.i
/*      */     o<K, V> g;
/*      */     
/* 1315 */     E(ReferenceQueue<K> param1ReferenceQueue, K param1K, int param1Int, o<K, V> param1o) { super(param1ReferenceQueue, param1K, param1Int, param1o);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1320 */       this.as = Long.MAX_VALUE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1333 */       this.f = k.a();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1346 */       this.g = k.a(); } public long W() { return this.as; }
/*      */     public void H(long param1Long) { this.as = param1Long; }
/*      */     public o<K, V> f() { return this.f; }
/*      */     public void f(o<K, V> param1o) { this.f = param1o; }
/* 1350 */     public o<K, V> g() { return this.g; }
/*      */ 
/*      */ 
/*      */     
/*      */     public void g(o<K, V> param1o) {
/* 1355 */       this.g = param1o;
/*      */     } }
/*      */   static final class B<K, V> extends C<K, V> { volatile long ar; @com.google.c.a.i
/*      */     o<K, V> b; @com.google.c.a.i
/*      */     o<K, V> c; volatile long as; @com.google.c.a.i
/*      */     o<K, V> f; @com.google.c.a.i
/*      */     o<K, V> g;
/* 1362 */     B(ReferenceQueue<K> param1ReferenceQueue, K param1K, int param1Int, o<K, V> param1o) { super(param1ReferenceQueue, param1K, param1Int, param1o);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1367 */       this.ar = Long.MAX_VALUE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1380 */       this.b = k.a();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1393 */       this.c = k.a();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1407 */       this.as = Long.MAX_VALUE;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1420 */       this.f = k.a();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1433 */       this.g = k.a(); } public long V() { return this.ar; } public void G(long param1Long) { this.ar = param1Long; }
/*      */     public o<K, V> d() { return this.b; }
/*      */     public void d(o<K, V> param1o) { this.b = param1o; }
/*      */     public o<K, V> e() { return this.c; }
/* 1437 */     public o<K, V> g() { return this.g; } public void e(o<K, V> param1o) { this.c = param1o; }
/*      */     public long W() { return this.as; }
/*      */     public void H(long param1Long) { this.as = param1Long; }
/*      */     public o<K, V> f() { return this.f; }
/*      */     public void f(o<K, V> param1o) { this.f = param1o; }
/* 1442 */     public void g(o<K, V> param1o) { this.g = param1o; }
/*      */      }
/*      */ 
/*      */   
/*      */   static class D<K, V>
/*      */     extends WeakReference<V> implements y<K, V> {
/*      */     final o<K, V> e;
/*      */     
/*      */     D(ReferenceQueue<V> param1ReferenceQueue, V param1V, o<K, V> param1o) {
/* 1451 */       super(param1V, param1ReferenceQueue);
/* 1452 */       this.e = param1o;
/*      */     }
/*      */ 
/*      */     
/*      */     public int af() {
/* 1457 */       return 1;
/*      */     }
/*      */ 
/*      */     
/*      */     public o<K, V> b() {
/* 1462 */       return this.e;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void f(V param1V) {}
/*      */ 
/*      */     
/*      */     public k.y<K, V> a(ReferenceQueue<V> param1ReferenceQueue, V param1V, o<K, V> param1o) {
/* 1471 */       return new D(param1ReferenceQueue, param1V, param1o);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean cJ() {
/* 1476 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isActive() {
/* 1481 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public V g() {
/* 1486 */       return get();
/*      */     }
/*      */   }
/*      */   
/*      */   static class q<K, V>
/*      */     extends SoftReference<V> implements y<K, V> {
/*      */     final o<K, V> e;
/*      */     
/*      */     q(ReferenceQueue<V> param1ReferenceQueue, V param1V, o<K, V> param1o) {
/* 1495 */       super(param1V, param1ReferenceQueue);
/* 1496 */       this.e = param1o;
/*      */     }
/*      */ 
/*      */     
/*      */     public int af() {
/* 1501 */       return 1;
/*      */     }
/*      */ 
/*      */     
/*      */     public o<K, V> b() {
/* 1506 */       return this.e;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void f(V param1V) {}
/*      */ 
/*      */     
/*      */     public k.y<K, V> a(ReferenceQueue<V> param1ReferenceQueue, V param1V, o<K, V> param1o) {
/* 1515 */       return new q(param1ReferenceQueue, param1V, param1o);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean cJ() {
/* 1520 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isActive() {
/* 1525 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public V g() {
/* 1530 */       return get();
/*      */     }
/*      */   }
/*      */   
/*      */   static class v<K, V>
/*      */     implements y<K, V> {
/*      */     final V q;
/*      */     
/*      */     v(V param1V) {
/* 1539 */       this.q = param1V;
/*      */     }
/*      */ 
/*      */     
/*      */     public V get() {
/* 1544 */       return this.q;
/*      */     }
/*      */ 
/*      */     
/*      */     public int af() {
/* 1549 */       return 1;
/*      */     }
/*      */ 
/*      */     
/*      */     public o<K, V> b() {
/* 1554 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public k.y<K, V> a(ReferenceQueue<V> param1ReferenceQueue, V param1V, o<K, V> param1o) {
/* 1560 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean cJ() {
/* 1565 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isActive() {
/* 1570 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public V g() {
/* 1575 */       return get();
/*      */     }
/*      */ 
/*      */     
/*      */     public void f(V param1V) {}
/*      */   }
/*      */   
/*      */   static final class H<K, V>
/*      */     extends D<K, V>
/*      */   {
/*      */     final int dP;
/*      */     
/*      */     H(ReferenceQueue<V> param1ReferenceQueue, V param1V, o<K, V> param1o, int param1Int) {
/* 1588 */       super(param1ReferenceQueue, param1V, param1o);
/* 1589 */       this.dP = param1Int;
/*      */     }
/*      */ 
/*      */     
/*      */     public int af() {
/* 1594 */       return this.dP;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public k.y<K, V> a(ReferenceQueue<V> param1ReferenceQueue, V param1V, o<K, V> param1o) {
/* 1600 */       return new H(param1ReferenceQueue, param1V, param1o, this.dP);
/*      */     }
/*      */   }
/*      */   
/*      */   static final class F<K, V>
/*      */     extends q<K, V>
/*      */   {
/*      */     final int dP;
/*      */     
/*      */     F(ReferenceQueue<V> param1ReferenceQueue, V param1V, o<K, V> param1o, int param1Int) {
/* 1610 */       super(param1ReferenceQueue, param1V, param1o);
/* 1611 */       this.dP = param1Int;
/*      */     }
/*      */ 
/*      */     
/*      */     public int af() {
/* 1616 */       return this.dP;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public k.y<K, V> a(ReferenceQueue<V> param1ReferenceQueue, V param1V, o<K, V> param1o) {
/* 1622 */       return new F(param1ReferenceQueue, param1V, param1o, this.dP);
/*      */     }
/*      */   }
/*      */   
/*      */   static final class G<K, V>
/*      */     extends v<K, V> {
/*      */     final int dP;
/*      */     
/*      */     G(V param1V, int param1Int) {
/* 1631 */       super(param1V);
/* 1632 */       this.dP = param1Int;
/*      */     }
/*      */ 
/*      */     
/*      */     public int af() {
/* 1637 */       return this.dP;
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
/*      */   static int h(int paramInt) {
/* 1653 */     paramInt += paramInt << 15 ^ 0xFFFFCD7D;
/* 1654 */     paramInt ^= paramInt >>> 10;
/* 1655 */     paramInt += paramInt << 3;
/* 1656 */     paramInt ^= paramInt >>> 6;
/* 1657 */     paramInt += (paramInt << 2) + (paramInt << 14);
/* 1658 */     return paramInt ^ paramInt >>> 16;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.d
/*      */   o<K, V> a(K paramK, int paramInt, o<K, V> paramo) {
/* 1666 */     p<K, V> p1 = a(paramInt);
/* 1667 */     p1.lock();
/*      */     try {
/* 1669 */       return p1.a(paramK, paramInt, paramo);
/*      */     } finally {
/* 1671 */       p1.unlock();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.d
/*      */   o<K, V> a(o<K, V> paramo1, o<K, V> paramo2) {
/* 1682 */     int i = paramo1.ag();
/* 1683 */     return a(i).a(paramo1, paramo2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.d
/*      */   y<K, V> a(o<K, V> paramo, V paramV, int paramInt) {
/* 1692 */     int i = paramo.ag();
/* 1693 */     return this.b.a(a(i), paramo, (V)com.google.a.b.D.checkNotNull(paramV), paramInt);
/*      */   }
/*      */   
/*      */   int hash(Object paramObject) {
/* 1697 */     int i = this.d.hash(paramObject);
/* 1698 */     return h(i);
/*      */   }
/*      */   
/*      */   void a(y<K, V> paramy) {
/* 1702 */     o<K, V> o = paramy.b();
/* 1703 */     int i = o.ag();
/* 1704 */     a(i).a(o.getKey(), i, paramy);
/*      */   }
/*      */   
/*      */   void a(o<K, V> paramo) {
/* 1708 */     int i = paramo.ag();
/* 1709 */     a(i).a(paramo, i);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.d
/*      */   boolean a(o<K, V> paramo, long paramLong) {
/* 1718 */     return (a(paramo.ag()).a(paramo, paramLong) != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   p<K, V> a(int paramInt) {
/* 1729 */     return (p)this.a[paramInt >>> this.segmentShift & this.segmentMask];
/*      */   }
/*      */ 
/*      */   
/*      */   p<K, V> a(int paramInt, long paramLong, a.b paramb) {
/* 1734 */     return new p<>(this, paramInt, paramLong, paramb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   V a(o<K, V> paramo, long paramLong) {
/* 1745 */     if (paramo.getKey() == null) {
/* 1746 */       return null;
/*      */     }
/* 1748 */     Object object = paramo.b().get();
/* 1749 */     if (object == null) {
/* 1750 */       return null;
/*      */     }
/*      */     
/* 1753 */     if (b(paramo, paramLong)) {
/* 1754 */       return null;
/*      */     }
/* 1756 */     return (V)object;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean b(o<K, V> paramo, long paramLong) {
/* 1763 */     com.google.a.b.D.checkNotNull(paramo);
/* 1764 */     if (cy() && paramLong - paramo.V() >= this.ad) {
/* 1765 */       return true;
/*      */     }
/* 1767 */     if (cx() && paramLong - paramo.W() >= this.ac) {
/* 1768 */       return true;
/*      */     }
/* 1770 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static <K, V> void a(o<K, V> paramo1, o<K, V> paramo2) {
/* 1777 */     paramo1.d(paramo2);
/* 1778 */     paramo2.e(paramo1);
/*      */   }
/*      */ 
/*      */   
/*      */   static <K, V> void b(o<K, V> paramo) {
/* 1783 */     o<?, ?> o1 = a();
/* 1784 */     paramo.d((o)o1);
/* 1785 */     paramo.e((o)o1);
/*      */   }
/*      */ 
/*      */   
/*      */   static <K, V> void b(o<K, V> paramo1, o<K, V> paramo2) {
/* 1790 */     paramo1.f(paramo2);
/* 1791 */     paramo2.g(paramo1);
/*      */   }
/*      */ 
/*      */   
/*      */   static <K, V> void c(o<K, V> paramo) {
/* 1796 */     o<?, ?> o1 = a();
/* 1797 */     paramo.f((o)o1);
/* 1798 */     paramo.g((o)o1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void eE() {
/*      */     s<Object, Object> s;
/* 1808 */     while ((s = (s)this.a.poll()) != null) {
/*      */       try {
/* 1810 */         this.a.a(s);
/* 1811 */       } catch (Throwable throwable) {
/* 1812 */         logger.log(Level.WARNING, "Exception thrown by removal listener", throwable);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   final p<K, V>[] a(int paramInt) {
/* 1819 */     return (p<K, V>[])new p[paramInt];
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
/*      */   static class p<K, V>
/*      */     extends ReentrantLock
/*      */   {
/*      */     @com.google.c.a.i
/*      */     final k<K, V> c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     volatile int count;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @com.google.b.a.a.a("this")
/*      */     long ap;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int modCount;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int threshold;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     volatile AtomicReferenceArray<o<K, V>> b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final long aq;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final ReferenceQueue<K> a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final ReferenceQueue<V> b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final Queue<o<K, V>> c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1916 */     final AtomicInteger h = new AtomicInteger();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @com.google.b.a.a.a("this")
/*      */     final Queue<o<K, V>> d;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @com.google.b.a.a.a("this")
/*      */     final Queue<o<K, V>> e;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final a.b b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     p(k<K, V> param1k, int param1Int, long param1Long, a.b param1b) {
/* 1940 */       this.c = (Queue)param1k;
/* 1941 */       this.aq = param1Long;
/* 1942 */       this.b = (a.b)com.google.a.b.D.checkNotNull(param1b);
/* 1943 */       a(a(param1Int));
/*      */       
/* 1945 */       this.a = param1k.cH() ? new ReferenceQueue<>() : null;
/*      */       
/* 1947 */       this.b = param1k.cI() ? (a.b)new ReferenceQueue() : null;
/*      */       
/* 1949 */       this
/*      */ 
/*      */         
/* 1952 */         .c = param1k.cA() ? new ConcurrentLinkedQueue<>() : k.<o<K, V>>a();
/*      */       
/* 1954 */       this
/*      */ 
/*      */         
/* 1957 */         .d = param1k.cB() ? new k.I<>() : k.<o<K, V>>a();
/*      */       
/* 1959 */       this
/*      */ 
/*      */         
/* 1962 */         .e = param1k.cA() ? new k.c<>() : k.<o<K, V>>a();
/*      */     }
/*      */     
/*      */     AtomicReferenceArray<o<K, V>> a(int param1Int) {
/* 1966 */       return new AtomicReferenceArray<>(param1Int);
/*      */     }
/*      */     
/*      */     void a(AtomicReferenceArray<o<K, V>> param1AtomicReferenceArray) {
/* 1970 */       this.threshold = param1AtomicReferenceArray.length() * 3 / 4;
/* 1971 */       if (!this.c.cv() && this.threshold == this.aq)
/*      */       {
/* 1973 */         this.threshold++;
/*      */       }
/* 1975 */       this.b = (a.b)param1AtomicReferenceArray;
/*      */     }
/*      */     
/*      */     @com.google.b.a.a.a("this")
/*      */     o<K, V> a(K param1K, int param1Int, o<K, V> param1o) {
/* 1980 */       return ((k)this.c).a.a(this, (K)com.google.a.b.D.checkNotNull(param1K), param1Int, param1o);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @com.google.b.a.a.a("this")
/*      */     o<K, V> a(o<K, V> param1o1, o<K, V> param1o2) {
/* 1989 */       if (param1o1.getKey() == null)
/*      */       {
/* 1991 */         return null;
/*      */       }
/*      */       
/* 1994 */       k.y<K, V> y = param1o1.b();
/* 1995 */       V v = y.get();
/* 1996 */       if (v == null && y.isActive())
/*      */       {
/* 1998 */         return null;
/*      */       }
/*      */       
/* 2001 */       o<K, V> o1 = ((k)this.c).a.a(this, param1o1, param1o2);
/* 2002 */       o1.b(y.a((ReferenceQueue<V>)this.b, v, o1));
/* 2003 */       return o1;
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.b.a.a.a("this")
/*      */     void a(o<K, V> param1o, K param1K, V param1V, long param1Long) {
/* 2009 */       k.y<K, V> y1 = param1o.b();
/* 2010 */       int i = ((k)this.c).a.a(param1K, param1V);
/* 2011 */       com.google.a.b.D.b((i >= 0), "Weights must be non-negative");
/*      */ 
/*      */       
/* 2014 */       k.y<K, V> y2 = ((k)this.c).b.a(this, param1o, param1V, i);
/* 2015 */       param1o.b(y2);
/* 2016 */       a(param1o, i, param1Long);
/* 2017 */       y1.f(param1V);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     V a(K param1K, int param1Int, f<? super K, V> param1f) throws ExecutionException {
/* 2023 */       com.google.a.b.D.checkNotNull(param1K);
/* 2024 */       com.google.a.b.D.checkNotNull(param1f);
/*      */       try {
/* 2026 */         if (this.count != 0) {
/*      */           
/* 2028 */           o<K, V> o = a(param1K, param1Int);
/* 2029 */           if (o != null) {
/* 2030 */             long l = ((k)this.c).a.H();
/* 2031 */             V v = a(o, l);
/* 2032 */             if (v != null) {
/* 2033 */               a(o, l);
/* 2034 */               this.b.au(1);
/* 2035 */               return a(o, param1K, param1Int, v, l, param1f);
/*      */             } 
/* 2037 */             k.y<K, V> y = o.b();
/* 2038 */             if (y.cJ()) {
/* 2039 */               return a(o, param1K, y);
/*      */             }
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/* 2045 */         return b(param1K, param1Int, param1f);
/* 2046 */       } catch (ExecutionException executionException) {
/* 2047 */         Throwable throwable = executionException.getCause();
/* 2048 */         if (throwable instanceof Error)
/* 2049 */           throw new com.google.a.o.a.w((Error)throwable); 
/* 2050 */         if (throwable instanceof RuntimeException) {
/* 2051 */           throw new au(throwable);
/*      */         }
/* 2053 */         throw executionException;
/*      */       } finally {
/* 2055 */         eO();
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     V get(Object param1Object, int param1Int) {
/*      */       try {
/* 2062 */         if (this.count != 0) {
/* 2063 */           long l = ((k)this.c).a.H();
/* 2064 */           o<K, V> o = a(param1Object, param1Int, l);
/* 2065 */           if (o == null) {
/* 2066 */             return null;
/*      */           }
/*      */           
/* 2069 */           Object object = o.b().get();
/* 2070 */           if (object != null) {
/* 2071 */             a(o, l);
/* 2072 */             return a(o, o.getKey(), param1Int, (V)object, l, (f)((k)this.c).b);
/*      */           } 
/* 2074 */           eF();
/*      */         } 
/* 2076 */         return null;
/*      */       } finally {
/* 2078 */         eO();
/*      */       } 
/*      */     }
/*      */     
/*      */     V b(K param1K, int param1Int, f<? super K, V> param1f) throws ExecutionException {
/*      */       o<o<K, V>, ?> o;
/* 2084 */       k.y<K, V> y = null;
/* 2085 */       k.k<Object, Object> k1 = null;
/* 2086 */       boolean bool = true;
/*      */       
/* 2088 */       lock();
/*      */       
/*      */       try {
/* 2091 */         long l = ((k)this.c).a.H();
/* 2092 */         K(l);
/*      */         
/* 2094 */         int i = this.count - 1;
/* 2095 */         a.b b1 = this.b;
/* 2096 */         int j = param1Int & b1.length() - 1;
/* 2097 */         o<o<K, V>, ?> o1 = b1.get(j);
/*      */         
/* 2099 */         for (o = o1; o != null; o = o.c()) {
/* 2100 */           Object object = o.getKey();
/* 2101 */           if (o.ag() == param1Int && object != null && ((k)this.c).d
/*      */             
/* 2103 */             .a(param1K, object)) {
/* 2104 */             y = o.b();
/* 2105 */             if (y.cJ()) {
/* 2106 */               bool = false; break;
/*      */             } 
/* 2108 */             Object object1 = y.get();
/* 2109 */             if (object1 == null) {
/* 2110 */               a((K)object, param1Int, (V)object1, y
/* 2111 */                   .af(), p.c);
/* 2112 */             } else if (this.c.b(o, l)) {
/*      */ 
/*      */               
/* 2115 */               a((K)object, param1Int, (V)object1, y
/* 2116 */                   .af(), p.d);
/*      */             } else {
/* 2118 */               b((o)o, l);
/* 2119 */               this.b.au(1);
/*      */               
/* 2121 */               return (V)object1;
/*      */             } 
/*      */ 
/*      */             
/* 2125 */             this.d.remove(o);
/* 2126 */             this.e.remove(o);
/* 2127 */             this.count = i;
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */         
/* 2133 */         if (bool) {
/* 2134 */           k1 = new k.k<>();
/*      */           
/* 2136 */           if (o == null) {
/* 2137 */             o = (o)a(param1K, param1Int, (o)o1);
/* 2138 */             o.b(k1);
/* 2139 */             b1.set(j, o);
/*      */           } else {
/* 2141 */             o.b(k1);
/*      */           } 
/*      */         } 
/*      */       } finally {
/* 2145 */         unlock();
/* 2146 */         eP();
/*      */       } 
/*      */       
/* 2149 */       if (bool) {
/*      */         
/*      */         try {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         } finally {
/*      */           
/* 2158 */           this.b.av(1);
/*      */         } 
/*      */       }
/*      */       
/* 2162 */       return a((o)o, param1K, y);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     V a(o<K, V> param1o, K param1K, k.y<K, V> param1y) throws ExecutionException {
/* 2168 */       if (!param1y.cJ()) {
/* 2169 */         throw new AssertionError();
/*      */       }
/*      */       
/* 2172 */       com.google.a.b.D.b(!Thread.holdsLock(param1o), "Recursive load of: %s", param1K);
/*      */       
/*      */       try {
/* 2175 */         V v = param1y.g();
/* 2176 */         if (v == null) {
/* 2177 */           String str = String.valueOf(param1K); throw new f.b((new StringBuilder(35 + String.valueOf(str).length())).append("CacheLoader returned null for key ").append(str).append(".").toString());
/*      */         } 
/*      */         
/* 2180 */         long l = ((k)this.c).a.H();
/* 2181 */         a(param1o, l);
/* 2182 */         return v;
/*      */       } finally {
/* 2184 */         this.b.av(1);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     V a(K param1K, int param1Int, BiFunction<? super K, ? super V, ? extends V> param1BiFunction) {
/* 2190 */       k.y<?, ?> y = null;
/* 2191 */       k.k<Object, Object> k1 = null;
/* 2192 */       boolean bool = true;
/*      */ 
/*      */       
/* 2195 */       lock();
/*      */       
/*      */       try {
/* 2198 */         long l = ((k)this.c).a.H();
/* 2199 */         K(l);
/*      */         
/* 2201 */         a.b b1 = this.b;
/* 2202 */         int i = param1Int & b1.length() - 1;
/* 2203 */         o<o<K, V>, ?> o2 = b1.get(i);
/*      */         o<o<K, V>, ?> o1;
/* 2205 */         for (o1 = o2; o1 != null; o1 = o1.c()) {
/* 2206 */           Object object1 = o1.getKey();
/* 2207 */           if (o1.ag() == param1Int && object1 != null && ((k)this.c).d
/*      */             
/* 2209 */             .a(param1K, object1)) {
/* 2210 */             y = o1.b();
/* 2211 */             if (this.c.b(o1, l))
/*      */             {
/*      */               
/* 2214 */               a((K)object1, param1Int, (V)y
/*      */ 
/*      */                   
/* 2217 */                   .get(), y
/* 2218 */                   .af(), p.d);
/*      */             }
/*      */ 
/*      */ 
/*      */             
/* 2223 */             this.d.remove(o1);
/* 2224 */             this.e.remove(o1);
/* 2225 */             bool = false;
/*      */ 
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */         
/* 2232 */         k1 = new k.k<>(y);
/*      */         
/* 2234 */         if (o1 == null) {
/* 2235 */           bool = true;
/* 2236 */           o1 = (o)a(param1K, param1Int, (o)o2);
/* 2237 */           o1.b(k1);
/* 2238 */           b1.set(i, o1);
/*      */         } else {
/* 2240 */           o1.b(k1);
/*      */         } 
/*      */         
/* 2243 */         Object object = k1.compute(param1K, (BiFunction)param1BiFunction);
/* 2244 */         if (object != null) {
/* 2245 */           if (y != null && object == y.get()) {
/* 2246 */             k1.c(object);
/* 2247 */             o1.b(y);
/* 2248 */             a((o)o1, 0, l);
/* 2249 */             return (V)object;
/*      */           } 
/*      */           try {
/* 2252 */             return a(param1K, param1Int, (k.k)k1, 
/* 2253 */                 L.b(object));
/* 2254 */           } catch (ExecutionException executionException) {
/* 2255 */             throw new AssertionError("impossible; Futures.immediateFuture can't throw");
/*      */           } 
/* 2257 */         }  if (bool) {
/* 2258 */           a(param1K, param1Int, (k.k)k1);
/* 2259 */           return null;
/*      */         } 
/* 2261 */         a((o)o1, param1Int, (p)p.a);
/* 2262 */         return null;
/*      */       } finally {
/*      */         
/* 2265 */         unlock();
/* 2266 */         eP();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     V a(K param1K, int param1Int, k.k<K, V> param1k, f<? super K, V> param1f) throws ExecutionException {
/* 2278 */       U<V> u = param1k.a(param1K, param1f);
/* 2279 */       return a(param1K, param1Int, param1k, u);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     U<V> a(K param1K, int param1Int, k.k<K, V> param1k, f<? super K, V> param1f) {
/* 2287 */       final U<V> key = param1k.a(param1K, param1f);
/* 2288 */       u.a(new Runnable(this, param1K, param1Int, param1k)
/*      */           {
/*      */             public void run()
/*      */             {
/*      */               try {
/* 2293 */                 this.b.a(key, this.dO, (k.k)this.b, this.a);
/* 2294 */               } catch (Throwable throwable) {
/* 2295 */                 k.logger.log(Level.WARNING, "Exception thrown during refresh", throwable);
/* 2296 */                 this.b.a(throwable);
/*      */               }
/*      */             
/*      */             }
/* 2300 */           }ab.b());
/* 2301 */       return u;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     V a(K param1K, int param1Int, k.k<K, V> param1k, U<V> param1U) throws ExecutionException {
/* 2311 */       Object object = null;
/*      */       try {
/* 2313 */         object = aw.a((Future)param1U);
/* 2314 */         if (object == null) {
/* 2315 */           String str = String.valueOf(param1K); throw new f.b((new StringBuilder(35 + String.valueOf(str).length())).append("CacheLoader returned null for key ").append(str).append(".").toString());
/*      */         } 
/* 2317 */         this.b.E(param1k.G());
/* 2318 */         a(param1K, param1Int, param1k, (V)object);
/* 2319 */         return (V)object;
/*      */       } finally {
/* 2321 */         if (object == null) {
/* 2322 */           this.b.F(param1k.G());
/* 2323 */           a(param1K, param1Int, param1k);
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     V a(o<K, V> param1o, K param1K, int param1Int, V param1V, long param1Long, f<? super K, V> param1f) {
/* 2335 */       if (this.c.cz() && param1Long - param1o
/* 2336 */         .W() > ((k)this.c).ae && 
/* 2337 */         !param1o.b().cJ()) {
/* 2338 */         V v = a(param1K, param1Int, param1f, true);
/* 2339 */         if (v != null) {
/* 2340 */           return v;
/*      */         }
/*      */       } 
/* 2343 */       return param1V;
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
/*      */     V a(K param1K, int param1Int, f<? super K, V> param1f, boolean param1Boolean) {
/* 2355 */       k.k<K, V> k1 = a(param1K, param1Int, param1Boolean);
/* 2356 */       if (k1 == null) {
/* 2357 */         return null;
/*      */       }
/*      */       
/* 2360 */       U<V> u = a(param1K, param1Int, k1, param1f);
/* 2361 */       if (u.isDone()) {
/*      */         try {
/* 2363 */           return (V)aw.a((Future)u);
/* 2364 */         } catch (Throwable throwable) {}
/*      */       }
/*      */ 
/*      */       
/* 2368 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     k.k<K, V> a(K param1K, int param1Int, boolean param1Boolean) {
/* 2378 */       o<Object, Object> o = null;
/* 2379 */       lock();
/*      */       try {
/* 2381 */         long l = ((k)this.c).a.H();
/* 2382 */         K(l);
/*      */         
/* 2384 */         a.b b1 = this.b;
/* 2385 */         int i = param1Int & b1.length() - 1;
/* 2386 */         o<Object, Object> o1 = b1.get(i);
/*      */ 
/*      */         
/* 2389 */         for (o = o1; o != null; o = o.c()) {
/* 2390 */           Object object = o.getKey();
/* 2391 */           if (o.ag() == param1Int && object != null && ((k)this.c).d
/*      */             
/* 2393 */             .a(param1K, object)) {
/*      */ 
/*      */             
/* 2396 */             k.y<?, ?> y = o.b();
/* 2397 */             if (y.cJ() || (param1Boolean && l - o
/* 2398 */               .W() < ((k)this.c).ae))
/*      */             {
/*      */ 
/*      */               
/* 2402 */               return null;
/*      */             }
/*      */ 
/*      */             
/* 2406 */             this.modCount++;
/* 2407 */             k.k<Object, Object> k2 = new k.k<>(y);
/*      */             
/* 2409 */             o.b(k2);
/* 2410 */             return (k.k)k2;
/*      */           } 
/*      */         } 
/*      */         
/* 2414 */         this.modCount++;
/* 2415 */         k.k<Object, Object> k1 = new k.k<>();
/* 2416 */         o = (o)a(param1K, param1Int, (o)o1);
/* 2417 */         o.b(k1);
/* 2418 */         b1.set(i, o);
/* 2419 */         return (k.k)k1;
/*      */       } finally {
/* 2421 */         unlock();
/* 2422 */         eP();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void eF() {
/* 2430 */       if (tryLock()) {
/*      */         try {
/* 2432 */           eG();
/*      */         } finally {
/* 2434 */           unlock();
/*      */         } 
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @com.google.b.a.a.a("this")
/*      */     void eG() {
/* 2445 */       if (this.c.cH()) {
/* 2446 */         eH();
/*      */       }
/* 2448 */       if (this.c.cI()) {
/* 2449 */         eI();
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.b.a.a.a("this")
/*      */     void eH() {
/* 2456 */       byte b1 = 0; Reference<? extends K> reference;
/* 2457 */       while ((reference = this.a.poll()) != null) {
/*      */         
/* 2459 */         o<o<K, V>, ?> o = (o)reference;
/* 2460 */         this.c.a(o);
/* 2461 */         if (++b1 == 16) {
/*      */           break;
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.b.a.a.a("this")
/*      */     void eI() {
/* 2470 */       byte b1 = 0; Reference reference;
/* 2471 */       while ((reference = this.b.poll()) != null) {
/*      */         
/* 2473 */         k.y<o<K, V>, ?> y = (k.y)reference;
/* 2474 */         this.c.a(y);
/* 2475 */         if (++b1 == 16) {
/*      */           break;
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     void eJ() {
/* 2483 */       if (this.c.cH()) {
/* 2484 */         eK();
/*      */       }
/* 2486 */       if (this.c.cI()) {
/* 2487 */         eL();
/*      */       }
/*      */     }
/*      */     
/*      */     void eK() {
/* 2492 */       while (this.a.poll() != null);
/*      */     }
/*      */     
/*      */     void eL() {
/* 2496 */       while (this.b.poll() != null);
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
/*      */     
/*      */     void a(o<K, V> param1o, long param1Long) {
/* 2509 */       if (this.c.cD()) {
/* 2510 */         param1o.G(param1Long);
/*      */       }
/* 2512 */       this.c.add(param1o);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @com.google.b.a.a.a("this")
/*      */     void b(o<K, V> param1o, long param1Long) {
/* 2524 */       if (this.c.cD()) {
/* 2525 */         param1o.G(param1Long);
/*      */       }
/* 2527 */       this.e.add(param1o);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @com.google.b.a.a.a("this")
/*      */     void a(o<K, V> param1o, int param1Int, long param1Long) {
/* 2537 */       eM();
/* 2538 */       this.ap += param1Int;
/*      */       
/* 2540 */       if (this.c.cD()) {
/* 2541 */         param1o.G(param1Long);
/*      */       }
/* 2543 */       if (this.c.cC()) {
/* 2544 */         param1o.H(param1Long);
/*      */       }
/* 2546 */       this.e.add(param1o);
/* 2547 */       this.d.add(param1o);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @com.google.b.a.a.a("this")
/*      */     void eM() {
/*      */       o<K, V> o;
/* 2559 */       while ((o = this.c.poll()) != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2564 */         if (this.e.contains(o)) {
/* 2565 */           this.e.add(o);
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void I(long param1Long) {
/* 2574 */       if (tryLock()) {
/*      */         try {
/* 2576 */           J(param1Long);
/*      */         } finally {
/* 2578 */           unlock();
/*      */         } 
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.b.a.a.a("this")
/*      */     void J(long param1Long) {
/* 2586 */       eM();
/*      */       
/*      */       o<o<K, V>, ?> o;
/* 2589 */       while ((o = (o)this.d.peek()) != null && this.c.b(o, param1Long)) {
/* 2590 */         if (!a((o)o, o.ag(), p.d)) {
/* 2591 */           throw new AssertionError();
/*      */         }
/*      */       } 
/* 2594 */       while ((o = (o<o<K, V>, ?>)this.e.peek()) != null && this.c.b(o, param1Long)) {
/* 2595 */         if (!a((o)o, o.ag(), p.d)) {
/* 2596 */           throw new AssertionError();
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @com.google.b.a.a.a("this")
/*      */     void a(K param1K, int param1Int1, V param1V, int param1Int2, p param1p) {
/* 2606 */       this.ap -= param1Int2;
/* 2607 */       if (param1p.cM()) {
/* 2608 */         this.b.eB();
/*      */       }
/* 2610 */       if (((k)this.c).a != k.b) {
/* 2611 */         s<K, V> s = s.a(param1K, param1V, param1p);
/* 2612 */         ((k)this.c).a.offer(s);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @com.google.b.a.a.a("this")
/*      */     void h(o<K, V> param1o) {
/* 2624 */       if (!this.c.cu()) {
/*      */         return;
/*      */       }
/*      */       
/* 2628 */       eM();
/*      */ 
/*      */ 
/*      */       
/* 2632 */       if (param1o.b().af() > this.aq && 
/* 2633 */         !a(param1o, param1o.ag(), p.e)) {
/* 2634 */         throw new AssertionError();
/*      */       }
/*      */ 
/*      */       
/* 2638 */       while (this.ap > this.aq) {
/* 2639 */         o<K, V> o1 = j();
/* 2640 */         if (!a(o1, o1.ag(), p.e)) {
/* 2641 */           throw new AssertionError();
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.b.a.a.a("this")
/*      */     o<K, V> j() {
/* 2649 */       for (o<K, V> o : this.e) {
/* 2650 */         int i = o.b().af();
/* 2651 */         if (i > 0) {
/* 2652 */           return o;
/*      */         }
/*      */       } 
/* 2655 */       throw new AssertionError();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     o<K, V> a(int param1Int) {
/* 2661 */       a.b b1 = this.b;
/* 2662 */       return b1.get(param1Int & b1.length() - 1);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     o<K, V> a(Object param1Object, int param1Int) {
/* 2669 */       for (o<K, V> o = a(param1Int); o != null; o = o.c()) {
/* 2670 */         if (o.ag() == param1Int) {
/*      */ 
/*      */ 
/*      */           
/* 2674 */           K k1 = o.getKey();
/* 2675 */           if (k1 == null) {
/* 2676 */             eF();
/*      */ 
/*      */           
/*      */           }
/* 2680 */           else if (((k)this.c).d.a(param1Object, k1)) {
/* 2681 */             return o;
/*      */           } 
/*      */         } 
/*      */       } 
/* 2685 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     o<K, V> a(Object param1Object, int param1Int, long param1Long) {
/* 2690 */       o<K, V> o = a(param1Object, param1Int);
/* 2691 */       if (o == null)
/* 2692 */         return null; 
/* 2693 */       if (this.c.b((o)o, param1Long)) {
/* 2694 */         I(param1Long);
/* 2695 */         return null;
/*      */       } 
/* 2697 */       return o;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     V a(o<K, V> param1o, long param1Long) {
/* 2705 */       if (param1o.getKey() == null) {
/* 2706 */         eF();
/* 2707 */         return null;
/*      */       } 
/* 2709 */       Object object = param1o.b().get();
/* 2710 */       if (object == null) {
/* 2711 */         eF();
/* 2712 */         return null;
/*      */       } 
/*      */       
/* 2715 */       if (this.c.b((o)param1o, param1Long)) {
/* 2716 */         I(param1Long);
/* 2717 */         return null;
/*      */       } 
/* 2719 */       return (V)object;
/*      */     }
/*      */     
/*      */     boolean a(Object param1Object, int param1Int) {
/*      */       try {
/* 2724 */         if (this.count != 0) {
/* 2725 */           long l = ((k)this.c).a.H();
/* 2726 */           o<K, V> o = a(param1Object, param1Int, l);
/* 2727 */           if (o == null) {
/* 2728 */             return false;
/*      */           }
/* 2730 */           return (o.b().get() != null);
/*      */         } 
/*      */         
/* 2733 */         return false;
/*      */       } finally {
/* 2735 */         eO();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @com.google.a.a.d
/*      */     boolean containsValue(Object param1Object) {
/*      */       try {
/* 2746 */         if (this.count != 0) {
/* 2747 */           long l = ((k)this.c).a.H();
/* 2748 */           a.b b1 = this.b;
/* 2749 */           int i = b1.length();
/* 2750 */           for (byte b2 = 0; b2 < i; b2++) {
/* 2751 */             for (o<K, V> o = b1.get(b2); o != null; o = o.c()) {
/* 2752 */               V v = a(o, l);
/* 2753 */               if (v != null)
/*      */               {
/*      */                 
/* 2756 */                 if (((k)this.c).e.a(param1Object, v)) {
/* 2757 */                   return true;
/*      */                 }
/*      */               }
/*      */             } 
/*      */           } 
/*      */         } 
/* 2763 */         return false;
/*      */       } finally {
/* 2765 */         eO();
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     V a(K param1K, int param1Int, V param1V, boolean param1Boolean) {
/* 2771 */       lock();
/*      */       try {
/* 2773 */         long l = ((k)this.c).a.H();
/* 2774 */         K(l);
/*      */         
/* 2776 */         int i = this.count + 1;
/* 2777 */         if (i > this.threshold) {
/* 2778 */           eN();
/* 2779 */           i = this.count + 1;
/*      */         } 
/*      */         
/* 2782 */         a.b b1 = this.b;
/* 2783 */         int j = param1Int & b1.length() - 1;
/* 2784 */         o<K, V> o1 = b1.get(j);
/*      */         
/*      */         o<K, V> o2;
/* 2787 */         for (o2 = o1; o2 != null; o2 = o2.c()) {
/* 2788 */           Object object = o2.getKey();
/* 2789 */           if (o2.ag() == param1Int && object != null && ((k)this.c).d
/*      */             
/* 2791 */             .a(param1K, object)) {
/*      */ 
/*      */             
/* 2794 */             k.y y = o2.b();
/* 2795 */             Object object1 = y.get();
/*      */             
/* 2797 */             if (object1 == null) {
/* 2798 */               this.modCount++;
/* 2799 */               if (y.isActive()) {
/* 2800 */                 a(param1K, param1Int, (V)object1, y
/* 2801 */                     .af(), p.c);
/* 2802 */                 a(o2, param1K, param1V, l);
/* 2803 */                 i = this.count;
/*      */               } else {
/* 2805 */                 a(o2, param1K, param1V, l);
/* 2806 */                 i = this.count + 1;
/*      */               } 
/* 2808 */               this.count = i;
/* 2809 */               h(o2);
/* 2810 */               return null;
/* 2811 */             }  if (param1Boolean) {
/*      */ 
/*      */ 
/*      */               
/* 2815 */               b(o2, l);
/* 2816 */               return (V)object1;
/*      */             } 
/*      */             
/* 2819 */             this.modCount++;
/* 2820 */             a(param1K, param1Int, (V)object1, y
/* 2821 */                 .af(), p.b);
/* 2822 */             a(o2, param1K, param1V, l);
/* 2823 */             h(o2);
/* 2824 */             return (V)object1;
/*      */           } 
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/* 2830 */         this.modCount++;
/* 2831 */         o2 = a(param1K, param1Int, o1);
/* 2832 */         a(o2, param1K, param1V, l);
/* 2833 */         b1.set(j, o2);
/* 2834 */         i = this.count + 1;
/* 2835 */         this.count = i;
/* 2836 */         h(o2);
/* 2837 */         return null;
/*      */       } finally {
/* 2839 */         unlock();
/* 2840 */         eP();
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     @com.google.b.a.a.a("this")
/*      */     void eN() {
/* 2847 */       a.b b1 = this.b;
/* 2848 */       int i = b1.length();
/* 2849 */       if (i >= 1073741824) {
/*      */         return;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2863 */       int j = this.count;
/* 2864 */       AtomicReferenceArray<o<K, V>> atomicReferenceArray = a(i << 1);
/* 2865 */       this.threshold = atomicReferenceArray.length() * 3 / 4;
/* 2866 */       int m = atomicReferenceArray.length() - 1;
/* 2867 */       for (byte b2 = 0; b2 < i; b2++) {
/*      */ 
/*      */         
/* 2870 */         o<K, V> o = b1.get(b2);
/*      */         
/* 2872 */         if (o != null) {
/* 2873 */           o<K, V> o1 = o.c();
/* 2874 */           int n = o.ag() & m;
/*      */ 
/*      */           
/* 2877 */           if (o1 == null) {
/* 2878 */             atomicReferenceArray.set(n, o);
/*      */           
/*      */           }
/*      */           else {
/*      */             
/* 2883 */             o<K, V> o2 = o;
/* 2884 */             int i1 = n; o<K, V> o3;
/* 2885 */             for (o3 = o1; o3 != null; o3 = o3.c()) {
/* 2886 */               int i2 = o3.ag() & m;
/* 2887 */               if (i2 != i1) {
/*      */                 
/* 2889 */                 i1 = i2;
/* 2890 */                 o2 = o3;
/*      */               } 
/*      */             } 
/* 2893 */             atomicReferenceArray.set(i1, o2);
/*      */ 
/*      */             
/* 2896 */             for (o3 = o; o3 != o2; o3 = o3.c()) {
/* 2897 */               int i2 = o3.ag() & m;
/* 2898 */               o<K, V> o4 = atomicReferenceArray.get(i2);
/* 2899 */               o<K, V> o5 = a(o3, o4);
/* 2900 */               if (o5 != null) {
/* 2901 */                 atomicReferenceArray.set(i2, o5);
/*      */               } else {
/* 2903 */                 i(o3);
/* 2904 */                 j--;
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/* 2910 */       this.b = (a.b)atomicReferenceArray;
/* 2911 */       this.count = j;
/*      */     }
/*      */     
/*      */     boolean a(K param1K, int param1Int, V param1V1, V param1V2) {
/* 2915 */       lock();
/*      */       try {
/* 2917 */         long l = ((k)this.c).a.H();
/* 2918 */         K(l);
/*      */         
/* 2920 */         a.b b1 = this.b;
/* 2921 */         int i = param1Int & b1.length() - 1;
/* 2922 */         o<K, V> o1 = b1.get(i);
/*      */         
/* 2924 */         for (o<K, V> o2 = o1; o2 != null; o2 = o2.c()) {
/* 2925 */           Object object = o2.getKey();
/* 2926 */           if (o2.ag() == param1Int && object != null && ((k)this.c).d
/*      */             
/* 2928 */             .a(param1K, object)) {
/* 2929 */             k.y<K, V> y = o2.b();
/* 2930 */             Object object1 = y.get();
/* 2931 */             if (object1 == null) {
/* 2932 */               if (y.isActive()) {
/*      */                 
/* 2934 */                 int j = this.count - 1;
/* 2935 */                 this.modCount++;
/*      */                 
/* 2937 */                 o<K, V> o = a(o1, o2, (K)object, param1Int, (V)object1, y, p.c);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 2945 */                 j = this.count - 1;
/* 2946 */                 b1.set(i, o);
/* 2947 */                 this.count = j;
/*      */               } 
/* 2949 */               return false;
/*      */             } 
/*      */             
/* 2952 */             if (((k)this.c).e.a(param1V1, object1)) {
/* 2953 */               this.modCount++;
/* 2954 */               a(param1K, param1Int, (V)object1, y
/* 2955 */                   .af(), p.b);
/* 2956 */               a(o2, param1K, param1V2, l);
/* 2957 */               h(o2);
/* 2958 */               return true;
/*      */             } 
/*      */ 
/*      */             
/* 2962 */             b(o2, l);
/* 2963 */             return false;
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/* 2968 */         return false;
/*      */       } finally {
/* 2970 */         unlock();
/* 2971 */         eP();
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     V a(K param1K, int param1Int, V param1V) {
/* 2977 */       lock();
/*      */       try {
/* 2979 */         long l = ((k)this.c).a.H();
/* 2980 */         K(l);
/*      */         
/* 2982 */         a.b b1 = this.b;
/* 2983 */         int i = param1Int & b1.length() - 1;
/* 2984 */         o<K, V> o1 = b1.get(i);
/*      */         o<K, V> o2;
/* 2986 */         for (o2 = o1; o2 != null; o2 = o2.c()) {
/* 2987 */           Object object = o2.getKey();
/* 2988 */           if (o2.ag() == param1Int && object != null && ((k)this.c).d
/*      */             
/* 2990 */             .a(param1K, object)) {
/* 2991 */             k.y<K, V> y = o2.b();
/* 2992 */             Object object1 = y.get();
/* 2993 */             if (object1 == null) {
/* 2994 */               if (y.isActive()) {
/*      */                 
/* 2996 */                 int j = this.count - 1;
/* 2997 */                 this.modCount++;
/*      */                 
/* 2999 */                 o<K, V> o = a(o1, o2, (K)object, param1Int, (V)object1, y, p.c);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/* 3007 */                 j = this.count - 1;
/* 3008 */                 b1.set(i, o);
/* 3009 */                 this.count = j;
/*      */               } 
/* 3011 */               return null;
/*      */             } 
/*      */             
/* 3014 */             this.modCount++;
/* 3015 */             a(param1K, param1Int, (V)object1, y
/* 3016 */                 .af(), p.b);
/* 3017 */             a(o2, param1K, param1V, l);
/* 3018 */             h(o2);
/* 3019 */             return (V)object1;
/*      */           } 
/*      */         } 
/*      */         
/* 3023 */         o2 = null; return (V)o2;
/*      */       } finally {
/* 3025 */         unlock();
/* 3026 */         eP();
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     V remove(Object param1Object, int param1Int) {
/* 3032 */       lock();
/*      */       try {
/* 3034 */         long l = ((k)this.c).a.H();
/* 3035 */         K(l);
/*      */         
/* 3037 */         int i = this.count - 1;
/* 3038 */         a.b b1 = this.b;
/* 3039 */         int j = param1Int & b1.length() - 1;
/* 3040 */         o<K, V> o1 = b1.get(j);
/*      */         o<K, V> o2;
/* 3042 */         for (o2 = o1; o2 != null; o2 = o2.c()) {
/* 3043 */           Object object = o2.getKey();
/* 3044 */           if (o2.ag() == param1Int && object != null && ((k)this.c).d
/*      */             
/* 3046 */             .a(param1Object, object)) {
/* 3047 */             p p1; k.y<K, V> y = o2.b();
/* 3048 */             Object object1 = y.get();
/*      */ 
/*      */             
/* 3051 */             if (object1 != null) {
/* 3052 */               p[] arrayOfP = p.a;
/* 3053 */             } else if (y.isActive()) {
/* 3054 */               p1 = p.c;
/*      */             } else {
/*      */               
/* 3057 */               return null;
/*      */             } 
/*      */             
/* 3060 */             this.modCount++;
/*      */             
/* 3062 */             o<K, V> o = a(o1, o2, (K)object, param1Int, (V)object1, y, p1);
/* 3063 */             i = this.count - 1;
/* 3064 */             b1.set(j, o);
/* 3065 */             this.count = i;
/* 3066 */             return (V)object1;
/*      */           } 
/*      */         } 
/*      */         
/* 3070 */         o2 = null; return (V)o2;
/*      */       } finally {
/* 3072 */         unlock();
/* 3073 */         eP();
/*      */       } 
/*      */     }
/*      */     
/*      */     boolean a(Object param1Object1, int param1Int, Object param1Object2) {
/* 3078 */       lock();
/*      */       try {
/* 3080 */         long l = ((k)this.c).a.H();
/* 3081 */         K(l);
/*      */         
/* 3083 */         int i = this.count - 1;
/* 3084 */         a.b b1 = this.b;
/* 3085 */         int j = param1Int & b1.length() - 1;
/* 3086 */         o<K, V> o1 = b1.get(j);
/*      */         
/* 3088 */         for (o<K, V> o2 = o1; o2 != null; o2 = o2.c()) {
/* 3089 */           Object object = o2.getKey();
/* 3090 */           if (o2.ag() == param1Int && object != null && ((k)this.c).d
/*      */             
/* 3092 */             .a(param1Object1, object)) {
/* 3093 */             p p1; k.y<K, V> y = o2.b();
/* 3094 */             Object object1 = y.get();
/*      */ 
/*      */             
/* 3097 */             if (((k)this.c).e.a(param1Object2, object1)) {
/* 3098 */               p[] arrayOfP = p.a;
/* 3099 */             } else if (object1 == null && y.isActive()) {
/* 3100 */               p1 = p.c;
/*      */             } else {
/*      */               
/* 3103 */               return false;
/*      */             } 
/*      */             
/* 3106 */             this.modCount++;
/*      */             
/* 3108 */             o<K, V> o = a(o1, o2, (K)object, param1Int, (V)object1, y, p1);
/* 3109 */             i = this.count - 1;
/* 3110 */             b1.set(j, o);
/* 3111 */             this.count = i;
/* 3112 */             return (p1 == p.a);
/*      */           } 
/*      */         } 
/*      */         
/* 3116 */         return false;
/*      */       } finally {
/* 3118 */         unlock();
/* 3119 */         eP();
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     boolean a(K param1K, int param1Int, k.k<K, V> param1k, V param1V) {
/* 3125 */       lock();
/*      */       try {
/* 3127 */         long l = ((k)this.c).a.H();
/* 3128 */         K(l);
/*      */         
/* 3130 */         int i = this.count + 1;
/* 3131 */         if (i > this.threshold) {
/* 3132 */           eN();
/* 3133 */           i = this.count + 1;
/*      */         } 
/*      */         
/* 3136 */         a.b b1 = this.b;
/* 3137 */         int j = param1Int & b1.length() - 1;
/* 3138 */         o<K, V> o1 = b1.get(j);
/*      */         o<K, V> o2;
/* 3140 */         for (o2 = o1; o2 != null; o2 = o2.c()) {
/* 3141 */           Object object = o2.getKey();
/* 3142 */           if (o2.ag() == param1Int && object != null && ((k)this.c).d
/*      */             
/* 3144 */             .a(param1K, object)) {
/* 3145 */             k.y<Object, Object> y = o2.b();
/* 3146 */             Object object1 = y.get();
/*      */ 
/*      */             
/* 3149 */             if (param1k == y || (object1 == null && y != k.a)) {
/*      */               
/* 3151 */               this.modCount++;
/* 3152 */               if (param1k.isActive()) {
/*      */                 
/* 3154 */                 p p1 = (object1 == null) ? p.c : p.b;
/* 3155 */                 a(param1K, param1Int, (V)object1, param1k.af(), p1);
/* 3156 */                 i--;
/*      */               } 
/* 3158 */               a(o2, param1K, param1V, l);
/* 3159 */               this.count = i;
/* 3160 */               h(o2);
/* 3161 */               return true;
/*      */             } 
/*      */ 
/*      */             
/* 3165 */             a(param1K, param1Int, param1V, 0, p.b);
/* 3166 */             return false;
/*      */           } 
/*      */         } 
/*      */         
/* 3170 */         this.modCount++;
/* 3171 */         o2 = a(param1K, param1Int, o1);
/* 3172 */         a(o2, param1K, param1V, l);
/* 3173 */         b1.set(j, o2);
/* 3174 */         this.count = i;
/* 3175 */         h(o2);
/* 3176 */         return true;
/*      */       } finally {
/* 3178 */         unlock();
/* 3179 */         eP();
/*      */       } 
/*      */     }
/*      */     
/*      */     void clear() {
/* 3184 */       if (this.count != 0) {
/* 3185 */         lock();
/*      */         try {
/* 3187 */           long l = ((k)this.c).a.H();
/* 3188 */           K(l);
/*      */           
/* 3190 */           a.b b1 = this.b; byte b2;
/* 3191 */           for (b2 = 0; b2 < b1.length(); b2++) {
/* 3192 */             for (o o = b1.get(b2); o != null; o = o.c()) {
/*      */               
/* 3194 */               if (o.b().isActive()) {
/* 3195 */                 Object object1 = o.getKey();
/* 3196 */                 Object object2 = o.b().get();
/*      */                 
/* 3198 */                 p p1 = (p)((object1 == null || object2 == null) ? p.c : p.a);
/* 3199 */                 a((K)object1, o
/* 3200 */                     .ag(), (V)object2, o.b().af(), p1);
/*      */               } 
/*      */             } 
/*      */           } 
/* 3204 */           for (b2 = 0; b2 < b1.length(); b2++) {
/* 3205 */             b1.set(b2, null);
/*      */           }
/* 3207 */           eJ();
/* 3208 */           this.d.clear();
/* 3209 */           this.e.clear();
/* 3210 */           this.h.set(0);
/*      */           
/* 3212 */           this.modCount++;
/* 3213 */           this.count = 0;
/*      */         } finally {
/* 3215 */           unlock();
/* 3216 */           eP();
/*      */         } 
/*      */       } 
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
/*      */     @com.google.b.a.a.a("this")
/*      */     o<K, V> a(o<K, V> param1o1, o<K, V> param1o2, K param1K, int param1Int, V param1V, k.y<K, V> param1y, p param1p) {
/* 3231 */       a(param1K, param1Int, param1V, param1y.af(), param1p);
/* 3232 */       this.d.remove(param1o2);
/* 3233 */       this.e.remove(param1o2);
/*      */       
/* 3235 */       if (param1y.cJ()) {
/* 3236 */         param1y.f(null);
/* 3237 */         return param1o1;
/*      */       } 
/* 3239 */       return b(param1o1, param1o2);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @com.google.b.a.a.a("this")
/*      */     o<K, V> b(o<K, V> param1o1, o<K, V> param1o2) {
/* 3247 */       int i = this.count;
/* 3248 */       o<K, V> o1 = param1o2.c();
/* 3249 */       for (o<K, V> o2 = param1o1; o2 != param1o2; o2 = o2.c()) {
/* 3250 */         o<K, V> o3 = a(o2, o1);
/* 3251 */         if (o3 != null) {
/* 3252 */           o1 = o3;
/*      */         } else {
/* 3254 */           i(o2);
/* 3255 */           i--;
/*      */         } 
/*      */       } 
/* 3258 */       this.count = i;
/* 3259 */       return o1;
/*      */     }
/*      */     
/*      */     @com.google.b.a.a.a("this")
/*      */     void i(o<K, V> param1o) {
/* 3264 */       a(param1o
/* 3265 */           .getKey(), param1o
/* 3266 */           .ag(), (V)param1o
/* 3267 */           .b().get(), param1o
/* 3268 */           .b().af(), p.c);
/*      */       
/* 3270 */       this.d.remove(param1o);
/* 3271 */       this.e.remove(param1o);
/*      */     }
/*      */ 
/*      */     
/*      */     boolean a(o<K, V> param1o, int param1Int) {
/* 3276 */       lock();
/*      */       try {
/* 3278 */         int i = this.count - 1;
/* 3279 */         a.b b1 = this.b;
/* 3280 */         int j = param1Int & b1.length() - 1;
/* 3281 */         o<K, V> o1 = b1.get(j);
/*      */         
/* 3283 */         for (o<K, V> o2 = o1; o2 != null; o2 = o2.c()) {
/* 3284 */           if (o2 == param1o) {
/* 3285 */             this.modCount++;
/*      */             
/* 3287 */             o<K, V> o3 = a(o1, o2, o2
/*      */ 
/*      */                 
/* 3290 */                 .getKey(), param1Int, (V)o2
/*      */                 
/* 3292 */                 .b().get(), o2
/* 3293 */                 .b(), p.c);
/*      */             
/* 3295 */             i = this.count - 1;
/* 3296 */             b1.set(j, o3);
/* 3297 */             this.count = i;
/* 3298 */             return true;
/*      */           } 
/*      */         } 
/*      */         
/* 3302 */         return false;
/*      */       } finally {
/* 3304 */         unlock();
/* 3305 */         eP();
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     boolean a(K param1K, int param1Int, k.y<K, V> param1y) {
/* 3311 */       lock();
/*      */       try {
/* 3313 */         int i = this.count - 1;
/* 3314 */         a.b b1 = this.b;
/* 3315 */         int j = param1Int & b1.length() - 1;
/* 3316 */         o<K, V> o1 = b1.get(j);
/*      */         
/* 3318 */         for (o<K, V> o2 = o1; o2 != null; o2 = o2.c()) {
/* 3319 */           Object object = o2.getKey();
/* 3320 */           if (o2.ag() == param1Int && object != null && ((k)this.c).d
/*      */             
/* 3322 */             .a(param1K, object)) {
/* 3323 */             k.y<K, V> y1 = o2.b();
/* 3324 */             if (y1 == param1y) {
/* 3325 */               this.modCount++;
/*      */               
/* 3327 */               o<K, V> o = a(o1, o2, (K)object, param1Int, param1y
/*      */ 
/*      */ 
/*      */ 
/*      */                   
/* 3332 */                   .get(), param1y, p.c);
/*      */ 
/*      */               
/* 3335 */               i = this.count - 1;
/* 3336 */               b1.set(j, o);
/* 3337 */               this.count = i;
/* 3338 */               return true;
/*      */             } 
/* 3340 */             return false;
/*      */           } 
/*      */         } 
/*      */         
/* 3344 */         return false;
/*      */       } finally {
/* 3346 */         unlock();
/* 3347 */         if (!isHeldByCurrentThread()) {
/* 3348 */           eP();
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/*      */     boolean a(K param1K, int param1Int, k.k<K, V> param1k) {
/* 3354 */       lock();
/*      */       try {
/* 3356 */         a.b b1 = this.b;
/* 3357 */         int i = param1Int & b1.length() - 1;
/* 3358 */         o<K, V> o1 = b1.get(i);
/*      */         
/* 3360 */         for (o<K, V> o2 = o1; o2 != null; o2 = o2.c()) {
/* 3361 */           Object object = o2.getKey();
/* 3362 */           if (o2.ag() == param1Int && object != null && ((k)this.c).d
/*      */             
/* 3364 */             .a(param1K, object)) {
/* 3365 */             k.y y = o2.b();
/* 3366 */             if (y == param1k) {
/* 3367 */               if (param1k.isActive()) {
/* 3368 */                 o2.b(param1k.c());
/*      */               } else {
/* 3370 */                 o<K, V> o = b(o1, o2);
/* 3371 */                 b1.set(i, o);
/*      */               } 
/* 3373 */               return true;
/*      */             } 
/* 3375 */             return false;
/*      */           } 
/*      */         } 
/*      */         
/* 3379 */         return false;
/*      */       } finally {
/* 3381 */         unlock();
/* 3382 */         eP();
/*      */       } 
/*      */     }
/*      */     
/*      */     @com.google.a.a.d
/*      */     @com.google.b.a.a.a("this")
/*      */     boolean a(o<K, V> param1o, int param1Int, p param1p) {
/* 3389 */       int i = this.count - 1;
/* 3390 */       a.b b1 = this.b;
/* 3391 */       int j = param1Int & b1.length() - 1;
/* 3392 */       o<K, V> o1 = b1.get(j);
/*      */       
/* 3394 */       for (o<K, V> o2 = o1; o2 != null; o2 = o2.c()) {
/* 3395 */         if (o2 == param1o) {
/* 3396 */           this.modCount++;
/*      */           
/* 3398 */           o<K, V> o3 = a(o1, o2, o2
/*      */ 
/*      */               
/* 3401 */               .getKey(), param1Int, (V)o2
/*      */               
/* 3403 */               .b().get(), o2
/* 3404 */               .b(), param1p);
/*      */           
/* 3406 */           i = this.count - 1;
/* 3407 */           b1.set(j, o3);
/* 3408 */           this.count = i;
/* 3409 */           return true;
/*      */         } 
/*      */       } 
/*      */       
/* 3413 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void eO() {
/* 3421 */       if ((this.h.incrementAndGet() & 0x3F) == 0) {
/* 3422 */         ey();
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     @com.google.b.a.a.a("this")
/*      */     void K(long param1Long) {
/* 3434 */       L(param1Long);
/*      */     }
/*      */ 
/*      */     
/*      */     void eP() {
/* 3439 */       eQ();
/*      */     }
/*      */     
/*      */     void ey() {
/* 3443 */       long l = ((k)this.c).a.H();
/* 3444 */       L(l);
/* 3445 */       eQ();
/*      */     }
/*      */     
/*      */     void L(long param1Long) {
/* 3449 */       if (tryLock()) {
/*      */         try {
/* 3451 */           eG();
/* 3452 */           J(param1Long);
/* 3453 */           this.h.set(0);
/*      */         } finally {
/* 3455 */           unlock();
/*      */         } 
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     void eQ() {
/* 3462 */       if (!isHeldByCurrentThread())
/* 3463 */         this.c.eE(); 
/*      */     }
/*      */   }
/*      */   
/*      */   static class k<K, V>
/*      */     implements y<K, V>
/*      */   {
/*      */     volatile k.y<K, V> b;
/*      */     final al<V> a;
/* 3472 */     final K a = (K)al.a(); public k(k.y<K, V> param1y) {
/* 3473 */       this.a = K.a();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3480 */       this.b = (param1y == null) ? k.<K, V>a() : param1y;
/*      */     } public k() {
/*      */       this(null);
/*      */     }
/*      */     public boolean cJ() {
/* 3485 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isActive() {
/* 3490 */       return this.b.isActive();
/*      */     }
/*      */ 
/*      */     
/*      */     public int af() {
/* 3495 */       return this.b.af();
/*      */     }
/*      */     
/*      */     public boolean c(V param1V) {
/* 3499 */       return this.a.c(param1V);
/*      */     }
/*      */     
/*      */     public boolean a(Throwable param1Throwable) {
/* 3503 */       return this.a.a(param1Throwable);
/*      */     }
/*      */     
/*      */     private U<V> a(Throwable param1Throwable) {
/* 3507 */       return L.c(param1Throwable);
/*      */     }
/*      */ 
/*      */     
/*      */     public void f(V param1V) {
/* 3512 */       if (param1V != null) {
/*      */ 
/*      */         
/* 3515 */         c(param1V);
/*      */       } else {
/*      */         
/* 3518 */         this.b = k.a();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public U<V> a(K param1K, f<? super K, V> param1f) {
/*      */       try {
/* 3526 */         this.a.c();
/* 3527 */         V v = this.b.get();
/* 3528 */         if (v == null) {
/* 3529 */           V v1 = param1f.j(param1K);
/* 3530 */           return c(v1) ? (U<V>)this.a : L.b(v1);
/*      */         } 
/* 3532 */         U<V> u = param1f.a(param1K, v);
/* 3533 */         if (u == null) {
/* 3534 */           return L.b(null);
/*      */         }
/*      */ 
/*      */         
/* 3538 */         return L.b(u, new com.google.a.b.s<V, V>(this)
/*      */             {
/*      */               
/*      */               public V apply(V param2V)
/*      */               {
/* 3543 */                 this.a.c(param2V);
/* 3544 */                 return param2V;
/*      */               }
/*      */             }, 
/* 3547 */             ab.b());
/* 3548 */       } catch (Throwable throwable) {
/* 3549 */         U u = (U)(a(throwable) ? this.a : a(throwable));
/* 3550 */         if (throwable instanceof InterruptedException) {
/* 3551 */           Thread.currentThread().interrupt();
/*      */         }
/* 3553 */         return u;
/*      */       } 
/*      */     }
/*      */     public V compute(K param1K, BiFunction<? super K, ? super V, ? extends V> param1BiFunction) {
/*      */       V v1, v2;
/* 3558 */       this.a.c();
/*      */       
/*      */       try {
/* 3561 */         V v = this.b.g();
/* 3562 */       } catch (ExecutionException executionException) {
/* 3563 */         v1 = null;
/*      */       } 
/*      */       
/*      */       try {
/* 3567 */         v2 = param1BiFunction.apply(param1K, v1);
/* 3568 */       } catch (Throwable throwable) {
/* 3569 */         a(throwable);
/* 3570 */         throw throwable;
/*      */       } 
/* 3572 */       c(v2);
/* 3573 */       return v2;
/*      */     }
/*      */     
/*      */     public long G() {
/* 3577 */       return this.a.a(TimeUnit.NANOSECONDS);
/*      */     }
/*      */ 
/*      */     
/*      */     public V g() throws ExecutionException {
/* 3582 */       return (V)aw.a((Future)this.a);
/*      */     }
/*      */ 
/*      */     
/*      */     public V get() {
/* 3587 */       return this.b.get();
/*      */     }
/*      */     
/*      */     public k.y<K, V> c() {
/* 3591 */       return this.b;
/*      */     }
/*      */ 
/*      */     
/*      */     public o<K, V> b() {
/* 3596 */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public k.y<K, V> a(ReferenceQueue<V> param1ReferenceQueue, V param1V, o<K, V> param1o) {
/* 3602 */       return this;
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
/*      */   static final class I<K, V>
/*      */     extends AbstractQueue<o<K, V>>
/*      */   {
/* 3620 */     final o<K, V> a = new k.b<K, V>(this)
/*      */       {
/*      */         
/*      */         public long W()
/*      */         {
/* 3625 */           return Long.MAX_VALUE;
/*      */         }
/*      */         
/*      */         public void H(long param2Long) {}
/*      */         
/*      */         @com.google.c.a.i
/* 3631 */         o<K, V> f = this;
/*      */ 
/*      */         
/*      */         public o<K, V> f() {
/* 3635 */           return this.f;
/*      */         }
/*      */ 
/*      */         
/*      */         public void f(o<K, V> param2o) {
/* 3640 */           this.f = param2o;
/*      */         }
/*      */         @com.google.c.a.i
/* 3643 */         o<K, V> g = this;
/*      */ 
/*      */         
/*      */         public o<K, V> g() {
/* 3647 */           return this.g;
/*      */         }
/*      */ 
/*      */         
/*      */         public void g(o<K, V> param2o) {
/* 3652 */           this.g = param2o;
/*      */         }
/*      */       };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean a(o<K, V> param1o) {
/* 3661 */       k.b(param1o.g(), param1o.f());
/*      */ 
/*      */       
/* 3664 */       k.b(this.a.g(), param1o);
/* 3665 */       k.b(param1o, this.a);
/*      */       
/* 3667 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public o<K, V> h() {
/* 3672 */       o<K, V> o1 = this.a.f();
/* 3673 */       return (o1 == this.a) ? null : o1;
/*      */     }
/*      */ 
/*      */     
/*      */     public o<K, V> i() {
/* 3678 */       o<K, V> o1 = this.a.f();
/* 3679 */       if (o1 == this.a) {
/* 3680 */         return null;
/*      */       }
/*      */       
/* 3683 */       remove(o1);
/* 3684 */       return o1;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object) {
/* 3690 */       o<?, ?> o1 = (o)param1Object;
/* 3691 */       o<?, ?> o2 = o1.g();
/* 3692 */       o<?, ?> o3 = o1.f();
/* 3693 */       k.b(o2, o3);
/* 3694 */       k.c(o1);
/*      */       
/* 3696 */       return (o3 != k.o.a);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean contains(Object param1Object) {
/* 3702 */       o o1 = (o)param1Object;
/* 3703 */       return (o1.f() != k.o.a);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isEmpty() {
/* 3708 */       return (this.a.f() == this.a);
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/* 3713 */       byte b = 0;
/* 3714 */       o<K, V> o1 = this.a.f();
/* 3715 */       for (; o1 != this.a; 
/* 3716 */         o1 = o1.f()) {
/* 3717 */         b++;
/*      */       }
/* 3719 */       return b;
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/* 3724 */       o<K, V> o1 = this.a.f();
/* 3725 */       while (o1 != this.a) {
/* 3726 */         o<K, V> o2 = o1.f();
/* 3727 */         k.c(o1);
/* 3728 */         o1 = o2;
/*      */       } 
/*      */       
/* 3731 */       this.a.f(this.a);
/* 3732 */       this.a.g(this.a);
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<o<K, V>> iterator() {
/* 3737 */       return (Iterator<o<K, V>>)new com.google.a.d.l<o<K, V>>(this, h())
/*      */         {
/*      */           protected o<K, V> a(o<K, V> param2o) {
/* 3740 */             o<K, V> o1 = param2o.f();
/* 3741 */             return (o1 == this.a.a) ? null : o1;
/*      */           }
/*      */         };
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
/*      */   static final class c<K, V>
/*      */     extends AbstractQueue<o<K, V>>
/*      */   {
/* 3759 */     final o<K, V> a = new k.b<K, V>(this)
/*      */       {
/*      */         
/*      */         public long V()
/*      */         {
/* 3764 */           return Long.MAX_VALUE;
/*      */         }
/*      */         
/*      */         public void G(long param2Long) {}
/*      */         
/*      */         @com.google.c.a.i
/* 3770 */         o<K, V> b = this;
/*      */ 
/*      */         
/*      */         public o<K, V> d() {
/* 3774 */           return this.b;
/*      */         }
/*      */ 
/*      */         
/*      */         public void d(o<K, V> param2o) {
/* 3779 */           this.b = param2o;
/*      */         }
/*      */         @com.google.c.a.i
/* 3782 */         o<K, V> c = this;
/*      */ 
/*      */         
/*      */         public o<K, V> e() {
/* 3786 */           return this.c;
/*      */         }
/*      */ 
/*      */         
/*      */         public void e(o<K, V> param2o) {
/* 3791 */           this.c = param2o;
/*      */         }
/*      */       };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean a(o<K, V> param1o) {
/* 3800 */       k.a(param1o.e(), param1o.d());
/*      */ 
/*      */       
/* 3803 */       k.a(this.a.e(), param1o);
/* 3804 */       k.a(param1o, this.a);
/*      */       
/* 3806 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public o<K, V> h() {
/* 3811 */       o<K, V> o1 = this.a.d();
/* 3812 */       return (o1 == this.a) ? null : o1;
/*      */     }
/*      */ 
/*      */     
/*      */     public o<K, V> i() {
/* 3817 */       o<K, V> o1 = this.a.d();
/* 3818 */       if (o1 == this.a) {
/* 3819 */         return null;
/*      */       }
/*      */       
/* 3822 */       remove(o1);
/* 3823 */       return o1;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object) {
/* 3829 */       o<?, ?> o1 = (o)param1Object;
/* 3830 */       o<?, ?> o2 = o1.e();
/* 3831 */       o<?, ?> o3 = o1.d();
/* 3832 */       k.a(o2, o3);
/* 3833 */       k.b(o1);
/*      */       
/* 3835 */       return (o3 != k.o.a);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean contains(Object param1Object) {
/* 3841 */       o o1 = (o)param1Object;
/* 3842 */       return (o1.d() != k.o.a);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isEmpty() {
/* 3847 */       return (this.a.d() == this.a);
/*      */     }
/*      */ 
/*      */     
/*      */     public int size() {
/* 3852 */       byte b = 0;
/* 3853 */       o<K, V> o1 = this.a.d();
/* 3854 */       for (; o1 != this.a; 
/* 3855 */         o1 = o1.d()) {
/* 3856 */         b++;
/*      */       }
/* 3858 */       return b;
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/* 3863 */       o<K, V> o1 = this.a.d();
/* 3864 */       while (o1 != this.a) {
/* 3865 */         o<K, V> o2 = o1.d();
/* 3866 */         k.b(o1);
/* 3867 */         o1 = o2;
/*      */       } 
/*      */       
/* 3870 */       this.a.d(this.a);
/* 3871 */       this.a.e(this.a);
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<o<K, V>> iterator() {
/* 3876 */       return (Iterator<o<K, V>>)new com.google.a.d.l<o<K, V>>(this, h())
/*      */         {
/*      */           protected o<K, V> a(o<K, V> param2o) {
/* 3879 */             o<K, V> o1 = param2o.d();
/* 3880 */             return (o1 == this.a.a) ? null : o1;
/*      */           }
/*      */         };
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
/*      */   public void ey() {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: getfield a : [Lcom/google/a/c/k$p;
/*      */     //   4: astore_1
/*      */     //   5: aload_1
/*      */     //   6: arraylength
/*      */     //   7: istore_2
/*      */     //   8: iconst_0
/*      */     //   9: istore_3
/*      */     //   10: iload_3
/*      */     //   11: iload_2
/*      */     //   12: if_icmpge -> 31
/*      */     //   15: aload_1
/*      */     //   16: iload_3
/*      */     //   17: aaload
/*      */     //   18: astore #4
/*      */     //   20: aload #4
/*      */     //   22: invokevirtual ey : ()V
/*      */     //   25: iinc #3, 1
/*      */     //   28: goto -> 10
/*      */     //   31: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #3889	-> 0
/*      */     //   #3890	-> 20
/*      */     //   #3889	-> 25
/*      */     //   #3892	-> 31
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmpty() {
/* 3905 */     long l1 = 0L;
/* 3906 */     y<Object, Object> y1 = this.a; byte b1;
/* 3907 */     for (b1 = 0; b1 < y1.length; b1++) {
/* 3908 */       if (((p)y1[b1]).count != 0) {
/* 3909 */         return false;
/*      */       }
/* 3911 */       l1 += ((p)y1[b1]).modCount;
/*      */     } 
/*      */     
/* 3914 */     if (l1 != 0L) {
/* 3915 */       for (b1 = 0; b1 < y1.length; b1++) {
/* 3916 */         if (((p)y1[b1]).count != 0) {
/* 3917 */           return false;
/*      */         }
/* 3919 */         l1 -= ((p)y1[b1]).modCount;
/*      */       } 
/* 3921 */       return (l1 == 0L);
/*      */     } 
/* 3923 */     return true;
/*      */   }
/*      */   
/*      */   long U() {
/* 3927 */     y<Object, Object> y1 = this.a;
/* 3928 */     long l1 = 0L;
/* 3929 */     for (byte b1 = 0; b1 < y1.length; b1++) {
/* 3930 */       l1 += Math.max(0, ((p)y1[b1]).count);
/*      */     }
/* 3932 */     return l1;
/*      */   }
/*      */ 
/*      */   
/*      */   public int size() {
/* 3937 */     return com.google.a.m.k.e(U());
/*      */   }
/*      */ 
/*      */   
/*      */   public V get(Object paramObject) {
/* 3942 */     if (paramObject == null) {
/* 3943 */       return null;
/*      */     }
/* 3945 */     int i = hash(paramObject);
/* 3946 */     return a(i).get(paramObject, i);
/*      */   }
/*      */   
/*      */   V a(K paramK, f<? super K, V> paramf) throws ExecutionException {
/* 3950 */     int i = hash(com.google.a.b.D.checkNotNull(paramK));
/* 3951 */     return a(i).a(paramK, i, paramf);
/*      */   }
/*      */   
/*      */   public V i(Object paramObject) {
/* 3955 */     int i = hash(com.google.a.b.D.checkNotNull(paramObject));
/* 3956 */     V v = a(i).get(paramObject, i);
/* 3957 */     if (v == null) {
/* 3958 */       this.a.av(1);
/*      */     } else {
/* 3960 */       this.a.au(1);
/*      */     } 
/* 3962 */     return v;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public V getOrDefault(Object paramObject, V paramV) {
/* 3969 */     V v = get(paramObject);
/* 3970 */     return (v != null) ? v : paramV;
/*      */   }
/*      */   
/*      */   V k(K paramK) throws ExecutionException {
/* 3974 */     return a(paramK, (f)this.b);
/*      */   }
/*      */   
/*      */   bj<K, V> a(Iterable<?> paramIterable) {
/* 3978 */     byte b1 = 0;
/* 3979 */     byte b2 = 0;
/*      */     
/* 3981 */     LinkedHashMap<Object, V> linkedHashMap = bW.a();
/* 3982 */     for (Object object1 : paramIterable) {
/* 3983 */       V v = get(object1);
/* 3984 */       if (v == null) {
/* 3985 */         b2++;
/*      */         
/*      */         continue;
/*      */       } 
/* 3989 */       Object object2 = object1;
/* 3990 */       linkedHashMap.put(object2, v);
/* 3991 */       b1++;
/*      */     } 
/*      */     
/* 3994 */     this.a.au(b1);
/* 3995 */     this.a.av(b2);
/* 3996 */     return bj.a(linkedHashMap);
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
/*      */   bj<K, V> b(Iterable<? extends K> paramIterable) throws ExecutionException {
/*      */     // Byte code:
/*      */     //   0: iconst_0
/*      */     //   1: istore_2
/*      */     //   2: iconst_0
/*      */     //   3: istore_3
/*      */     //   4: invokestatic a : ()Ljava/util/LinkedHashMap;
/*      */     //   7: astore #4
/*      */     //   9: invokestatic a : ()Ljava/util/LinkedHashSet;
/*      */     //   12: astore #5
/*      */     //   14: aload_1
/*      */     //   15: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */     //   20: astore #6
/*      */     //   22: aload #6
/*      */     //   24: invokeinterface hasNext : ()Z
/*      */     //   29: ifeq -> 100
/*      */     //   32: aload #6
/*      */     //   34: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   39: astore #7
/*      */     //   41: aload_0
/*      */     //   42: aload #7
/*      */     //   44: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
/*      */     //   47: astore #8
/*      */     //   49: aload #4
/*      */     //   51: aload #7
/*      */     //   53: invokeinterface containsKey : (Ljava/lang/Object;)Z
/*      */     //   58: ifne -> 97
/*      */     //   61: aload #4
/*      */     //   63: aload #7
/*      */     //   65: aload #8
/*      */     //   67: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*      */     //   72: pop
/*      */     //   73: aload #8
/*      */     //   75: ifnonnull -> 94
/*      */     //   78: iinc #3, 1
/*      */     //   81: aload #5
/*      */     //   83: aload #7
/*      */     //   85: invokeinterface add : (Ljava/lang/Object;)Z
/*      */     //   90: pop
/*      */     //   91: goto -> 97
/*      */     //   94: iinc #2, 1
/*      */     //   97: goto -> 22
/*      */     //   100: aload #5
/*      */     //   102: invokeinterface isEmpty : ()Z
/*      */     //   107: ifne -> 287
/*      */     //   110: aload_0
/*      */     //   111: aload #5
/*      */     //   113: aload_0
/*      */     //   114: getfield b : Lcom/google/a/c/f;
/*      */     //   117: invokevirtual a : (Ljava/util/Set;Lcom/google/a/c/f;)Ljava/util/Map;
/*      */     //   120: astore #6
/*      */     //   122: aload #5
/*      */     //   124: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */     //   129: astore #7
/*      */     //   131: aload #7
/*      */     //   133: invokeinterface hasNext : ()Z
/*      */     //   138: ifeq -> 228
/*      */     //   141: aload #7
/*      */     //   143: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   148: astore #8
/*      */     //   150: aload #6
/*      */     //   152: aload #8
/*      */     //   154: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*      */     //   159: astore #9
/*      */     //   161: aload #9
/*      */     //   163: ifnonnull -> 213
/*      */     //   166: new com/google/a/c/f$b
/*      */     //   169: dup
/*      */     //   170: aload #8
/*      */     //   172: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
/*      */     //   175: astore #10
/*      */     //   177: bipush #37
/*      */     //   179: aload #10
/*      */     //   181: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
/*      */     //   184: invokevirtual length : ()I
/*      */     //   187: iadd
/*      */     //   188: new java/lang/StringBuilder
/*      */     //   191: dup_x1
/*      */     //   192: swap
/*      */     //   193: invokespecial <init> : (I)V
/*      */     //   196: ldc 'loadAll failed to return a value for '
/*      */     //   198: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   201: aload #10
/*      */     //   203: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   206: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   209: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   212: athrow
/*      */     //   213: aload #4
/*      */     //   215: aload #8
/*      */     //   217: aload #9
/*      */     //   219: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*      */     //   224: pop
/*      */     //   225: goto -> 131
/*      */     //   228: goto -> 287
/*      */     //   231: astore #6
/*      */     //   233: aload #5
/*      */     //   235: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */     //   240: astore #7
/*      */     //   242: aload #7
/*      */     //   244: invokeinterface hasNext : ()Z
/*      */     //   249: ifeq -> 287
/*      */     //   252: aload #7
/*      */     //   254: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   259: astore #8
/*      */     //   261: iinc #3, -1
/*      */     //   264: aload #4
/*      */     //   266: aload #8
/*      */     //   268: aload_0
/*      */     //   269: aload #8
/*      */     //   271: aload_0
/*      */     //   272: getfield b : Lcom/google/a/c/f;
/*      */     //   275: invokevirtual a : (Ljava/lang/Object;Lcom/google/a/c/f;)Ljava/lang/Object;
/*      */     //   278: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*      */     //   283: pop
/*      */     //   284: goto -> 242
/*      */     //   287: aload #4
/*      */     //   289: invokestatic a : (Ljava/util/Map;)Lcom/google/a/d/bj;
/*      */     //   292: astore #6
/*      */     //   294: aload_0
/*      */     //   295: getfield a : Lcom/google/a/c/a$b;
/*      */     //   298: iload_2
/*      */     //   299: invokeinterface au : (I)V
/*      */     //   304: aload_0
/*      */     //   305: getfield a : Lcom/google/a/c/a$b;
/*      */     //   308: iload_3
/*      */     //   309: invokeinterface av : (I)V
/*      */     //   314: aload #6
/*      */     //   316: areturn
/*      */     //   317: astore #11
/*      */     //   319: aload_0
/*      */     //   320: getfield a : Lcom/google/a/c/a$b;
/*      */     //   323: iload_2
/*      */     //   324: invokeinterface au : (I)V
/*      */     //   329: aload_0
/*      */     //   330: getfield a : Lcom/google/a/c/a$b;
/*      */     //   333: iload_3
/*      */     //   334: invokeinterface av : (I)V
/*      */     //   339: aload #11
/*      */     //   341: athrow
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #4000	-> 0
/*      */     //   #4001	-> 2
/*      */     //   #4003	-> 4
/*      */     //   #4004	-> 9
/*      */     //   #4005	-> 14
/*      */     //   #4006	-> 41
/*      */     //   #4007	-> 49
/*      */     //   #4008	-> 61
/*      */     //   #4009	-> 73
/*      */     //   #4010	-> 78
/*      */     //   #4011	-> 81
/*      */     //   #4013	-> 94
/*      */     //   #4016	-> 97
/*      */     //   #4019	-> 100
/*      */     //   #4021	-> 110
/*      */     //   #4022	-> 122
/*      */     //   #4023	-> 150
/*      */     //   #4024	-> 161
/*      */     //   #4025	-> 166
/*      */     //   #4027	-> 213
/*      */     //   #4028	-> 225
/*      */     //   #4035	-> 228
/*      */     //   #4029	-> 231
/*      */     //   #4031	-> 233
/*      */     //   #4032	-> 261
/*      */     //   #4033	-> 264
/*      */     //   #4034	-> 284
/*      */     //   #4037	-> 287
/*      */     //   #4039	-> 294
/*      */     //   #4040	-> 304
/*      */     //   #4037	-> 314
/*      */     //   #4039	-> 317
/*      */     //   #4040	-> 329
/*      */     //   #4041	-> 339
/*      */     // Exception table:
/*      */     //   from	to	target	type
/*      */     //   100	294	317	finally
/*      */     //   110	228	231	com/google/a/c/f$d
/*      */     //   317	319	317	finally
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
/*      */   Map<K, V> a(Set<? extends K> paramSet, f<? super K, V> paramf) throws ExecutionException {
/*      */     Map<? super K, V> map;
/* 4051 */     com.google.a.b.D.checkNotNull(paramf);
/* 4052 */     com.google.a.b.D.checkNotNull(paramSet);
/* 4053 */     K k1 = K.b();
/*      */     
/* 4055 */     boolean bool1 = false;
/*      */     
/*      */     try {
/* 4058 */       Map<? super K, V> map1 = paramf.a(paramSet);
/* 4059 */       map = map1;
/* 4060 */       bool1 = true;
/* 4061 */     } catch (d d1) {
/* 4062 */       bool1 = true;
/* 4063 */       throw d1;
/* 4064 */     } catch (InterruptedException interruptedException) {
/* 4065 */       Thread.currentThread().interrupt();
/* 4066 */       throw new ExecutionException(interruptedException);
/* 4067 */     } catch (RuntimeException runtimeException) {
/* 4068 */       throw new au(runtimeException);
/* 4069 */     } catch (Exception exception) {
/* 4070 */       throw new ExecutionException(exception);
/* 4071 */     } catch (Error error) {
/* 4072 */       throw new com.google.a.o.a.w(error);
/*      */     } finally {
/* 4074 */       if (!bool1) {
/* 4075 */         this.a.F(k1.a(TimeUnit.NANOSECONDS));
/*      */       }
/*      */     } 
/*      */     
/* 4079 */     if (map == null) {
/* 4080 */       this.a.F(k1.a(TimeUnit.NANOSECONDS));
/* 4081 */       String str = String.valueOf(paramf); throw new f.b((new StringBuilder(31 + String.valueOf(str).length())).append(str).append(" returned null map from loadAll").toString());
/*      */     } 
/*      */     
/* 4084 */     k1.d();
/*      */     
/* 4086 */     boolean bool2 = false;
/* 4087 */     for (Map.Entry<? super K, V> entry : map.entrySet()) {
/* 4088 */       Object object1 = entry.getKey();
/* 4089 */       Object object2 = entry.getValue();
/* 4090 */       if (object1 == null || object2 == null) {
/*      */         
/* 4092 */         bool2 = true; continue;
/*      */       } 
/* 4094 */       put((K)object1, (V)object2);
/*      */     } 
/*      */ 
/*      */     
/* 4098 */     if (bool2) {
/* 4099 */       this.a.F(k1.a(TimeUnit.NANOSECONDS));
/* 4100 */       String str = String.valueOf(paramf); throw new f.b((new StringBuilder(42 + String.valueOf(str).length())).append(str).append(" returned null keys or values from loadAll").toString());
/*      */     } 
/*      */ 
/*      */     
/* 4104 */     this.a.E(k1.a(TimeUnit.NANOSECONDS));
/* 4105 */     return (Map)map;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   o<K, V> a(Object paramObject) {
/* 4114 */     if (paramObject == null) {
/* 4115 */       return null;
/*      */     }
/* 4117 */     int i = hash(paramObject);
/* 4118 */     return a(i).a(paramObject, i);
/*      */   }
/*      */   
/*      */   void e(K paramK) {
/* 4122 */     int i = hash(com.google.a.b.D.checkNotNull(paramK));
/* 4123 */     a(i).a(paramK, i, (f)this.b, false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean containsKey(Object paramObject) {
/* 4129 */     if (paramObject == null) {
/* 4130 */       return false;
/*      */     }
/* 4132 */     int i = hash(paramObject);
/* 4133 */     return a(i).a(paramObject, i);
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
/*      */   public boolean containsValue(Object paramObject) {
/*      */     // Byte code:
/*      */     //   0: aload_1
/*      */     //   1: ifnonnull -> 6
/*      */     //   4: iconst_0
/*      */     //   5: ireturn
/*      */     //   6: aload_0
/*      */     //   7: getfield a : Lcom/google/a/b/P;
/*      */     //   10: invokevirtual H : ()J
/*      */     //   13: lstore_2
/*      */     //   14: aload_0
/*      */     //   15: getfield a : [Lcom/google/a/c/k$p;
/*      */     //   18: astore #4
/*      */     //   20: ldc2_w -1
/*      */     //   23: lstore #5
/*      */     //   25: iconst_0
/*      */     //   26: istore #7
/*      */     //   28: iload #7
/*      */     //   30: iconst_3
/*      */     //   31: if_icmpge -> 193
/*      */     //   34: lconst_0
/*      */     //   35: lstore #8
/*      */     //   37: aload #4
/*      */     //   39: astore #10
/*      */     //   41: aload #10
/*      */     //   43: arraylength
/*      */     //   44: istore #11
/*      */     //   46: iconst_0
/*      */     //   47: istore #12
/*      */     //   49: iload #12
/*      */     //   51: iload #11
/*      */     //   53: if_icmpge -> 172
/*      */     //   56: aload #10
/*      */     //   58: iload #12
/*      */     //   60: aaload
/*      */     //   61: astore #13
/*      */     //   63: aload #13
/*      */     //   65: getfield count : I
/*      */     //   68: istore #14
/*      */     //   70: aload #13
/*      */     //   72: getfield b : Ljava/util/concurrent/atomic/AtomicReferenceArray;
/*      */     //   75: astore #15
/*      */     //   77: iconst_0
/*      */     //   78: istore #16
/*      */     //   80: iload #16
/*      */     //   82: aload #15
/*      */     //   84: invokevirtual length : ()I
/*      */     //   87: if_icmpge -> 155
/*      */     //   90: aload #15
/*      */     //   92: iload #16
/*      */     //   94: invokevirtual get : (I)Ljava/lang/Object;
/*      */     //   97: checkcast com/google/a/c/o
/*      */     //   100: astore #17
/*      */     //   102: aload #17
/*      */     //   104: ifnull -> 149
/*      */     //   107: aload #13
/*      */     //   109: aload #17
/*      */     //   111: lload_2
/*      */     //   112: invokevirtual a : (Lcom/google/a/c/o;J)Ljava/lang/Object;
/*      */     //   115: astore #18
/*      */     //   117: aload #18
/*      */     //   119: ifnull -> 137
/*      */     //   122: aload_0
/*      */     //   123: getfield e : Lcom/google/a/b/l;
/*      */     //   126: aload_1
/*      */     //   127: aload #18
/*      */     //   129: invokevirtual a : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*      */     //   132: ifeq -> 137
/*      */     //   135: iconst_1
/*      */     //   136: ireturn
/*      */     //   137: aload #17
/*      */     //   139: invokeinterface c : ()Lcom/google/a/c/o;
/*      */     //   144: astore #17
/*      */     //   146: goto -> 102
/*      */     //   149: iinc #16, 1
/*      */     //   152: goto -> 80
/*      */     //   155: lload #8
/*      */     //   157: aload #13
/*      */     //   159: getfield modCount : I
/*      */     //   162: i2l
/*      */     //   163: ladd
/*      */     //   164: lstore #8
/*      */     //   166: iinc #12, 1
/*      */     //   169: goto -> 49
/*      */     //   172: lload #8
/*      */     //   174: lload #5
/*      */     //   176: lcmp
/*      */     //   177: ifne -> 183
/*      */     //   180: goto -> 193
/*      */     //   183: lload #8
/*      */     //   185: lstore #5
/*      */     //   187: iinc #7, 1
/*      */     //   190: goto -> 28
/*      */     //   193: iconst_0
/*      */     //   194: ireturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #4139	-> 0
/*      */     //   #4140	-> 4
/*      */     //   #4148	-> 6
/*      */     //   #4149	-> 14
/*      */     //   #4150	-> 20
/*      */     //   #4151	-> 25
/*      */     //   #4152	-> 34
/*      */     //   #4153	-> 37
/*      */     //   #4155	-> 63
/*      */     //   #4157	-> 70
/*      */     //   #4158	-> 77
/*      */     //   #4159	-> 90
/*      */     //   #4160	-> 107
/*      */     //   #4161	-> 117
/*      */     //   #4162	-> 135
/*      */     //   #4159	-> 137
/*      */     //   #4158	-> 149
/*      */     //   #4166	-> 155
/*      */     //   #4153	-> 166
/*      */     //   #4168	-> 172
/*      */     //   #4169	-> 180
/*      */     //   #4171	-> 183
/*      */     //   #4151	-> 187
/*      */     //   #4173	-> 193
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
/*      */   public V put(K paramK, V paramV) {
/* 4178 */     com.google.a.b.D.checkNotNull(paramK);
/* 4179 */     com.google.a.b.D.checkNotNull(paramV);
/* 4180 */     int i = hash(paramK);
/* 4181 */     return a(i).a(paramK, i, paramV, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public V putIfAbsent(K paramK, V paramV) {
/* 4186 */     com.google.a.b.D.checkNotNull(paramK);
/* 4187 */     com.google.a.b.D.checkNotNull(paramV);
/* 4188 */     int i = hash(paramK);
/* 4189 */     return a(i).a(paramK, i, paramV, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public V compute(K paramK, BiFunction<? super K, ? super V, ? extends V> paramBiFunction) {
/* 4194 */     com.google.a.b.D.checkNotNull(paramK);
/* 4195 */     com.google.a.b.D.checkNotNull(paramBiFunction);
/* 4196 */     int i = hash(paramK);
/* 4197 */     return a(i).a(paramK, i, paramBiFunction);
/*      */   }
/*      */ 
/*      */   
/*      */   public V computeIfAbsent(K paramK, Function<? super K, ? extends V> paramFunction) {
/* 4202 */     com.google.a.b.D.checkNotNull(paramK);
/* 4203 */     com.google.a.b.D.checkNotNull(paramFunction);
/* 4204 */     return compute(paramK, (paramObject2, paramObject3) -> (paramObject3 == null) ? paramFunction.apply(paramObject1) : paramObject3);
/*      */   }
/*      */ 
/*      */   
/*      */   public V computeIfPresent(K paramK, BiFunction<? super K, ? super V, ? extends V> paramBiFunction) {
/* 4209 */     com.google.a.b.D.checkNotNull(paramK);
/* 4210 */     com.google.a.b.D.checkNotNull(paramBiFunction);
/* 4211 */     return compute(paramK, (paramObject1, paramObject2) -> (paramObject2 == null) ? null : paramBiFunction.apply(paramObject1, paramObject2));
/*      */   }
/*      */ 
/*      */   
/*      */   public V merge(K paramK, V paramV, BiFunction<? super V, ? super V, ? extends V> paramBiFunction) {
/* 4216 */     com.google.a.b.D.checkNotNull(paramK);
/* 4217 */     com.google.a.b.D.checkNotNull(paramV);
/* 4218 */     com.google.a.b.D.checkNotNull(paramBiFunction);
/* 4219 */     return compute(paramK, (paramObject2, paramObject3) -> (paramObject3 == null) ? paramObject1 : paramBiFunction.apply(paramObject3, paramObject1));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void putAll(Map<? extends K, ? extends V> paramMap) {
/* 4225 */     for (Map.Entry<? extends K, ? extends V> entry : paramMap.entrySet()) {
/* 4226 */       put((K)entry.getKey(), (V)entry.getValue());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public V remove(Object paramObject) {
/* 4232 */     if (paramObject == null) {
/* 4233 */       return null;
/*      */     }
/* 4235 */     int i = hash(paramObject);
/* 4236 */     return a(i).remove(paramObject, i);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean remove(Object paramObject1, Object paramObject2) {
/* 4241 */     if (paramObject1 == null || paramObject2 == null) {
/* 4242 */       return false;
/*      */     }
/* 4244 */     int i = hash(paramObject1);
/* 4245 */     return a(i).a(paramObject1, i, paramObject2);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean replace(K paramK, V paramV1, V paramV2) {
/* 4250 */     com.google.a.b.D.checkNotNull(paramK);
/* 4251 */     com.google.a.b.D.checkNotNull(paramV2);
/* 4252 */     if (paramV1 == null) {
/* 4253 */       return false;
/*      */     }
/* 4255 */     int i = hash(paramK);
/* 4256 */     return a(i).a(paramK, i, paramV1, paramV2);
/*      */   }
/*      */ 
/*      */   
/*      */   public V replace(K paramK, V paramV) {
/* 4261 */     com.google.a.b.D.checkNotNull(paramK);
/* 4262 */     com.google.a.b.D.checkNotNull(paramV);
/* 4263 */     int i = hash(paramK);
/* 4264 */     return a(i).a(paramK, i, paramV);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void clear() {
/*      */     // Byte code:
/*      */     //   0: aload_0
/*      */     //   1: getfield a : [Lcom/google/a/c/k$p;
/*      */     //   4: astore_1
/*      */     //   5: aload_1
/*      */     //   6: arraylength
/*      */     //   7: istore_2
/*      */     //   8: iconst_0
/*      */     //   9: istore_3
/*      */     //   10: iload_3
/*      */     //   11: iload_2
/*      */     //   12: if_icmpge -> 31
/*      */     //   15: aload_1
/*      */     //   16: iload_3
/*      */     //   17: aaload
/*      */     //   18: astore #4
/*      */     //   20: aload #4
/*      */     //   22: invokevirtual clear : ()V
/*      */     //   25: iinc #3, 1
/*      */     //   28: goto -> 10
/*      */     //   31: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #4269	-> 0
/*      */     //   #4270	-> 20
/*      */     //   #4269	-> 25
/*      */     //   #4272	-> 31
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void a(Iterable<?> paramIterable) {
/* 4276 */     for (Object object : paramIterable) {
/* 4277 */       remove(object);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<K> keySet() {
/* 4286 */     Set<K> set = this.keySet;
/* 4287 */     return (set != null) ? set : (this.keySet = new i(this));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Collection<V> values() {
/* 4295 */     Collection<V> collection = this.values;
/* 4296 */     return (collection != null) ? collection : (this.values = new z(this));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @com.google.a.a.c
/*      */   public Set<Map.Entry<K, V>> entrySet() {
/* 4305 */     Set<Map.Entry<K, V>> set = this.entrySet;
/* 4306 */     return (set != null) ? set : (this.entrySet = new f(this));
/*      */   }
/*      */ 
/*      */   
/*      */   abstract class g<T>
/*      */     implements Iterator<T>
/*      */   {
/*      */     int dM;
/*      */     int dN;
/*      */     k.p<K, V> a;
/*      */     AtomicReferenceArray<o<K, V>> a;
/*      */     o<K, V> d;
/*      */     k<K, V>.J a;
/*      */     k<K, V>.J b;
/*      */     
/*      */     g(k this$0) {
/* 4322 */       this.dM = this$0.a.length - 1;
/* 4323 */       this.dN = -1;
/* 4324 */       advance();
/*      */     }
/*      */ 
/*      */     
/*      */     public abstract T next();
/*      */     
/*      */     final void advance() {
/* 4331 */       this.a = null;
/*      */       
/* 4333 */       if (cK()) {
/*      */         return;
/*      */       }
/*      */       
/* 4337 */       if (cL()) {
/*      */         return;
/*      */       }
/*      */       
/* 4341 */       while (this.dM >= 0) {
/* 4342 */         this.a = (k)this.a.a[this.dM--];
/* 4343 */         if (((k.p)this.a).count != 0) {
/* 4344 */           this.a = (k)((k.p)this.a).b;
/* 4345 */           this.dN = this.a.length() - 1;
/* 4346 */           if (cL()) {
/*      */             return;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     boolean cK() {
/* 4355 */       if (this.d != null) {
/* 4356 */         for (this.d = this.d.c(); this.d != null; this.d = this.d.c()) {
/* 4357 */           if (b(this.d)) {
/* 4358 */             return true;
/*      */           }
/*      */         } 
/*      */       }
/* 4362 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     boolean cL() {
/* 4367 */       while (this.dN >= 0) {
/* 4368 */         if ((this.d = this.a.get(this.dN--)) != null && (
/* 4369 */           b(this.d) || cK())) {
/* 4370 */           return true;
/*      */         }
/*      */       } 
/*      */       
/* 4374 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     boolean b(o<K, V> param1o) {
/*      */       try {
/* 4383 */         long l = this.a.a.H();
/* 4384 */         K k1 = param1o.getKey();
/* 4385 */         V v = (V)this.a.a((o)param1o, l);
/* 4386 */         if (v != null) {
/* 4387 */           this.a = (k)new k.J(this.a, k1, v);
/* 4388 */           return true;
/*      */         } 
/*      */         
/* 4391 */         return false;
/*      */       } finally {
/*      */         
/* 4394 */         this.a.eO();
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean hasNext() {
/* 4400 */       return (this.a != null);
/*      */     }
/*      */     
/*      */     k<K, V>.J a() {
/* 4404 */       if (this.a == null) {
/* 4405 */         throw new NoSuchElementException();
/*      */       }
/* 4407 */       this.b = (k<K, V>.J)this.a;
/* 4408 */       advance();
/* 4409 */       return this.b;
/*      */     }
/*      */ 
/*      */     
/*      */     public void remove() {
/* 4414 */       com.google.a.b.D.ab((this.b != null));
/* 4415 */       this.a.remove(this.b.getKey());
/* 4416 */       this.b = null;
/*      */     } }
/*      */   
/*      */   final class h extends g<K> { h(k this$0) {
/* 4420 */       super(this$0);
/*      */     }
/*      */     
/*      */     public K next() {
/* 4424 */       return a().getKey();
/*      */     } }
/*      */   
/*      */   final class x extends g<V> { x(k this$0) {
/* 4428 */       super(this$0);
/*      */     }
/*      */     
/*      */     public V next() {
/* 4432 */       return a().getValue();
/*      */     } }
/*      */ 
/*      */ 
/*      */   
/*      */   final class J
/*      */     implements Map.Entry<K, V>
/*      */   {
/*      */     final K key;
/*      */     
/*      */     V value;
/*      */     
/*      */     J(k this$0, K param1K, V param1V) {
/* 4445 */       this.key = param1K;
/* 4446 */       this.value = param1V;
/*      */     }
/*      */ 
/*      */     
/*      */     public K getKey() {
/* 4451 */       return this.key;
/*      */     }
/*      */ 
/*      */     
/*      */     public V getValue() {
/* 4456 */       return this.value;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(Object param1Object) {
/* 4462 */       if (param1Object instanceof Map.Entry) {
/* 4463 */         Map.Entry entry = (Map.Entry)param1Object;
/* 4464 */         return (this.key.equals(entry.getKey()) && this.value.equals(entry.getValue()));
/*      */       } 
/* 4466 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/* 4472 */       return this.key.hashCode() ^ this.value.hashCode();
/*      */     }
/*      */ 
/*      */     
/*      */     public V setValue(V param1V) {
/* 4477 */       V v = (V)this.a.put(this.key, (Object)param1V);
/* 4478 */       this.value = param1V;
/* 4479 */       return v;
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 4484 */       String str1 = String.valueOf(getKey()), str2 = String.valueOf(getValue()); return (new StringBuilder(1 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append("=").append(str2).toString();
/*      */     } }
/*      */   
/*      */   final class e extends g<Map.Entry<K, V>> { e(k this$0) {
/* 4488 */       super(this$0);
/*      */     }
/*      */     
/*      */     public Map.Entry<K, V> next() {
/* 4492 */       return a();
/*      */     } }
/*      */   
/*      */   abstract class a<T> extends AbstractSet<T> {
/*      */     a(k this$0) {}
/*      */     
/*      */     public int size() {
/* 4499 */       return this.a.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isEmpty() {
/* 4504 */       return this.a.isEmpty();
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/* 4509 */       this.a.clear();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object[] toArray() {
/* 4517 */       return k.b(this).toArray();
/*      */     }
/*      */ 
/*      */     
/*      */     public <E> E[] toArray(E[] param1ArrayOfE) {
/* 4522 */       return (E[])k.b(this).toArray((Object[])param1ArrayOfE);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static <E> ArrayList<E> a(Collection<E> paramCollection) {
/* 4528 */     ArrayList<E> arrayList = new ArrayList(paramCollection.size());
/* 4529 */     bH.addAll(arrayList, paramCollection.iterator());
/* 4530 */     return arrayList;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean a(BiPredicate<? super K, ? super V> paramBiPredicate) {
/*      */     // Byte code:
/*      */     //   0: aload_1
/*      */     //   1: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
/*      */     //   4: pop
/*      */     //   5: iconst_0
/*      */     //   6: istore_2
/*      */     //   7: aload_0
/*      */     //   8: invokevirtual keySet : ()Ljava/util/Set;
/*      */     //   11: invokeinterface iterator : ()Ljava/util/Iterator;
/*      */     //   16: astore_3
/*      */     //   17: aload_3
/*      */     //   18: invokeinterface hasNext : ()Z
/*      */     //   23: ifeq -> 85
/*      */     //   26: aload_3
/*      */     //   27: invokeinterface next : ()Ljava/lang/Object;
/*      */     //   32: astore #4
/*      */     //   34: aload_0
/*      */     //   35: aload #4
/*      */     //   37: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
/*      */     //   40: astore #5
/*      */     //   42: aload #5
/*      */     //   44: ifnull -> 82
/*      */     //   47: aload_1
/*      */     //   48: aload #4
/*      */     //   50: aload #5
/*      */     //   52: invokeinterface test : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*      */     //   57: ifne -> 63
/*      */     //   60: goto -> 82
/*      */     //   63: aload_0
/*      */     //   64: aload #4
/*      */     //   66: aload #5
/*      */     //   68: invokevirtual remove : (Ljava/lang/Object;Ljava/lang/Object;)Z
/*      */     //   71: ifeq -> 79
/*      */     //   74: iconst_1
/*      */     //   75: istore_2
/*      */     //   76: goto -> 82
/*      */     //   79: goto -> 34
/*      */     //   82: goto -> 17
/*      */     //   85: iload_2
/*      */     //   86: ireturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #4534	-> 0
/*      */     //   #4535	-> 5
/*      */     //   #4536	-> 7
/*      */     //   #4538	-> 34
/*      */     //   #4539	-> 42
/*      */     //   #4540	-> 60
/*      */     //   #4541	-> 63
/*      */     //   #4542	-> 74
/*      */     //   #4543	-> 76
/*      */     //   #4545	-> 79
/*      */     //   #4546	-> 82
/*      */     //   #4547	-> 85
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final class i
/*      */     extends a<K>
/*      */   {
/*      */     i(k this$0) {
/* 4550 */       super(this$0);
/*      */     }
/*      */     
/*      */     public Iterator<K> iterator() {
/* 4554 */       return new k.h(this.a);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean contains(Object param1Object) {
/* 4559 */       return this.a.containsKey(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object) {
/* 4564 */       return (this.a.remove(param1Object) != null);
/*      */     }
/*      */   }
/*      */   
/*      */   final class z extends AbstractCollection<V> { z(k this$0) {}
/*      */     
/*      */     public int size() {
/* 4571 */       return this.a.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isEmpty() {
/* 4576 */       return this.a.isEmpty();
/*      */     }
/*      */ 
/*      */     
/*      */     public void clear() {
/* 4581 */       this.a.clear();
/*      */     }
/*      */ 
/*      */     
/*      */     public Iterator<V> iterator() {
/* 4586 */       return new k.x(this.a);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean removeIf(Predicate<? super V> param1Predicate) {
/* 4591 */       com.google.a.b.D.checkNotNull(param1Predicate);
/* 4592 */       return this.a.a((param1Object1, param1Object2) -> param1Predicate.test(param1Object2));
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean contains(Object param1Object) {
/* 4597 */       return this.a.containsValue(param1Object);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object[] toArray() {
/* 4605 */       return k.b(this).toArray();
/*      */     }
/*      */ 
/*      */     
/*      */     public <E> E[] toArray(E[] param1ArrayOfE) {
/* 4610 */       return (E[])k.b(this).toArray((Object[])param1ArrayOfE);
/*      */     } }
/*      */   
/*      */   final class f extends a<Map.Entry<K, V>> { f(k this$0) {
/* 4614 */       super(this$0);
/*      */     }
/*      */     
/*      */     public Iterator<Map.Entry<K, V>> iterator() {
/* 4618 */       return new k.e(this.a);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean removeIf(Predicate<? super Map.Entry<K, V>> param1Predicate) {
/* 4623 */       com.google.a.b.D.checkNotNull(param1Predicate);
/* 4624 */       return this.a.a((param1Object1, param1Object2) -> param1Predicate.test(bW.d(param1Object1, param1Object2)));
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean contains(Object param1Object) {
/* 4629 */       if (!(param1Object instanceof Map.Entry)) {
/* 4630 */         return false;
/*      */       }
/* 4632 */       Map.Entry entry = (Map.Entry)param1Object;
/* 4633 */       Object object1 = entry.getKey();
/* 4634 */       if (object1 == null) {
/* 4635 */         return false;
/*      */       }
/* 4637 */       Object object2 = this.a.get(object1);
/*      */       
/* 4639 */       return (object2 != null && this.a.e.a(entry.getValue(), object2));
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean remove(Object param1Object) {
/* 4644 */       if (!(param1Object instanceof Map.Entry)) {
/* 4645 */         return false;
/*      */       }
/* 4647 */       Map.Entry entry = (Map.Entry)param1Object;
/* 4648 */       Object object = entry.getKey();
/* 4649 */       return (object != null && this.a.remove(object, entry.getValue()));
/*      */     } }
/*      */ 
/*      */ 
/*      */   
/*      */   static class n<K, V>
/*      */     extends h<K, V>
/*      */     implements Serializable
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */     
/*      */     final k.r a;
/*      */     
/*      */     final k.r b;
/*      */     
/*      */     final com.google.a.b.l<Object> d;
/*      */     
/*      */     final com.google.a.b.l<Object> e;
/*      */     
/*      */     final long ac;
/*      */     
/*      */     final long ad;
/*      */     
/*      */     final long ao;
/*      */     
/*      */     final u<K, V> a;
/*      */     
/*      */     final int dE;
/*      */     final q<? super K, ? super V> a;
/*      */     final P a;
/*      */     final f<? super K, V> c;
/*      */     transient c<K, V> a;
/*      */     
/*      */     n(k<K, V> param1k) {
/* 4683 */       this((k.r)param1k.a, (k.r)param1k.b, param1k.d, param1k.e, param1k.ac, param1k.ad, param1k.ao, (u)param1k.a, param1k.dE, (q)param1k.a, (P)param1k.a, (f)param1k.b);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private n(k.r param1r1, k.r param1r2, com.google.a.b.l<Object> param1l1, com.google.a.b.l<Object> param1l2, long param1Long1, long param1Long2, long param1Long3, u<K, V> param1u, int param1Int, q<? super K, ? super V> param1q, P param1P, f<? super K, V> param1f) {
/* 4711 */       this.a = (c<K, V>)param1r1;
/* 4712 */       this.b = param1r2;
/* 4713 */       this.d = param1l1;
/* 4714 */       this.e = param1l2;
/* 4715 */       this.ac = param1Long1;
/* 4716 */       this.ad = param1Long2;
/* 4717 */       this.ao = param1Long3;
/* 4718 */       this.a = (c<K, V>)param1u;
/* 4719 */       this.dE = param1Int;
/* 4720 */       this.a = (c)param1q;
/* 4721 */       this.a = (param1P == P.a() || param1P == d.c) ? null : (c<K, V>)param1P;
/* 4722 */       this.c = param1f;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     d<K, V> h() {
/* 4733 */       d<K, V> d = d.a().a((k.r)this.a).b(this.b).a(this.d).b(this.e).b(this.dE).a((q)this.a);
/* 4734 */       d.aA = false;
/* 4735 */       if (this.ac > 0L) {
/* 4736 */         d.a(this.ac, TimeUnit.NANOSECONDS);
/*      */       }
/* 4738 */       if (this.ad > 0L) {
/* 4739 */         d.b(this.ad, TimeUnit.NANOSECONDS);
/*      */       }
/* 4741 */       if (this.a != d.b.a) {
/* 4742 */         d.a((u)this.a);
/* 4743 */         if (this.ao != -1L) {
/* 4744 */           d.b(this.ao);
/*      */         }
/*      */       }
/* 4747 */       else if (this.ao != -1L) {
/* 4748 */         d.a(this.ao);
/*      */       } 
/*      */       
/* 4751 */       if (this.a != null) {
/* 4752 */         d.a((P)this.a);
/*      */       }
/* 4754 */       return d;
/*      */     }
/*      */     
/*      */     private void readObject(ObjectInputStream param1ObjectInputStream) throws IOException, ClassNotFoundException {
/* 4758 */       param1ObjectInputStream.defaultReadObject();
/* 4759 */       d<K, V> d = h();
/* 4760 */       this.a = d.a();
/*      */     }
/*      */     
/*      */     private Object readResolve() {
/* 4764 */       return this.a;
/*      */     }
/*      */ 
/*      */     
/*      */     protected c<K, V> b() {
/* 4769 */       return this.a;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static final class j<K, V>
/*      */     extends n<K, V>
/*      */     implements j<K, V>, Serializable
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */     
/*      */     transient j<K, V> b;
/*      */ 
/*      */ 
/*      */     
/*      */     j(k<K, V> param1k) {
/* 4788 */       super(param1k);
/*      */     }
/*      */     
/*      */     private void readObject(ObjectInputStream param1ObjectInputStream) throws IOException, ClassNotFoundException {
/* 4792 */       param1ObjectInputStream.defaultReadObject();
/* 4793 */       d<K, V> d = h();
/* 4794 */       this.b = d.a(this.c);
/*      */     }
/*      */ 
/*      */     
/*      */     public V get(K param1K) throws ExecutionException {
/* 4799 */       return this.b.get(param1K);
/*      */     }
/*      */ 
/*      */     
/*      */     public V h(K param1K) {
/* 4804 */       return this.b.h(param1K);
/*      */     }
/*      */ 
/*      */     
/*      */     public bj<K, V> b(Iterable<? extends K> param1Iterable) throws ExecutionException {
/* 4809 */       return this.b.b(param1Iterable);
/*      */     }
/*      */ 
/*      */     
/*      */     public final V apply(K param1K) {
/* 4814 */       return this.b.apply(param1K);
/*      */     }
/*      */ 
/*      */     
/*      */     public void e(K param1K) {
/* 4819 */       this.b.e(param1K);
/*      */     }
/*      */     
/*      */     private Object readResolve() {
/* 4823 */       return this.b;
/*      */     } }
/*      */   
/*      */   static class m<K, V> implements c<K, V>, Serializable {
/*      */     final k<K, V> b;
/*      */     private static final long serialVersionUID = 1L;
/*      */     
/*      */     m(d<? super K, ? super V> param1d) {
/* 4831 */       this(new k<>(param1d, null));
/*      */     }
/*      */     
/*      */     private m(k<K, V> param1k) {
/* 4835 */       this.b = param1k;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public V i(Object param1Object) {
/* 4842 */       return this.b.i(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public V a(K param1K, Callable<? extends V> param1Callable) throws ExecutionException {
/* 4847 */       com.google.a.b.D.checkNotNull(param1Callable);
/* 4848 */       return this.b.a(param1K, (f)new f<Object, V>(this, param1Callable)
/*      */           {
/*      */             
/*      */             public V j(Object param2Object) throws Exception
/*      */             {
/* 4853 */               return this.c.call();
/*      */             }
/*      */           });
/*      */     }
/*      */ 
/*      */     
/*      */     public bj<K, V> a(Iterable<?> param1Iterable) {
/* 4860 */       return this.b.a(param1Iterable);
/*      */     }
/*      */ 
/*      */     
/*      */     public void put(K param1K, V param1V) {
/* 4865 */       this.b.put(param1K, param1V);
/*      */     }
/*      */ 
/*      */     
/*      */     public void putAll(Map<? extends K, ? extends V> param1Map) {
/* 4870 */       this.b.putAll(param1Map);
/*      */     }
/*      */ 
/*      */     
/*      */     public void d(Object param1Object) {
/* 4875 */       com.google.a.b.D.checkNotNull(param1Object);
/* 4876 */       this.b.remove(param1Object);
/*      */     }
/*      */ 
/*      */     
/*      */     public void a(Iterable<?> param1Iterable) {
/* 4881 */       this.b.a(param1Iterable);
/*      */     }
/*      */ 
/*      */     
/*      */     public void eA() {
/* 4886 */       this.b.clear();
/*      */     }
/*      */ 
/*      */     
/*      */     public long size() {
/* 4891 */       return this.b.U();
/*      */     }
/*      */ 
/*      */     
/*      */     public ConcurrentMap<K, V> a() {
/* 4896 */       return this.b;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public g a() {
/*      */       // Byte code:
/*      */       //   0: new com/google/a/c/a$a
/*      */       //   3: dup
/*      */       //   4: invokespecial <init> : ()V
/*      */       //   7: astore_1
/*      */       //   8: aload_1
/*      */       //   9: aload_0
/*      */       //   10: getfield b : Lcom/google/a/c/k;
/*      */       //   13: getfield a : Lcom/google/a/c/a$b;
/*      */       //   16: invokevirtual a : (Lcom/google/a/c/a$b;)V
/*      */       //   19: aload_0
/*      */       //   20: getfield b : Lcom/google/a/c/k;
/*      */       //   23: getfield a : [Lcom/google/a/c/k$p;
/*      */       //   26: astore_2
/*      */       //   27: aload_2
/*      */       //   28: arraylength
/*      */       //   29: istore_3
/*      */       //   30: iconst_0
/*      */       //   31: istore #4
/*      */       //   33: iload #4
/*      */       //   35: iload_3
/*      */       //   36: if_icmpge -> 60
/*      */       //   39: aload_2
/*      */       //   40: iload #4
/*      */       //   42: aaload
/*      */       //   43: astore #5
/*      */       //   45: aload_1
/*      */       //   46: aload #5
/*      */       //   48: getfield b : Lcom/google/a/c/a$b;
/*      */       //   51: invokevirtual a : (Lcom/google/a/c/a$b;)V
/*      */       //   54: iinc #4, 1
/*      */       //   57: goto -> 33
/*      */       //   60: aload_1
/*      */       //   61: invokevirtual b : ()Lcom/google/a/c/g;
/*      */       //   64: areturn
/*      */       // Line number table:
/*      */       //   Java source line number -> byte code offset
/*      */       //   #4901	-> 0
/*      */       //   #4902	-> 8
/*      */       //   #4903	-> 19
/*      */       //   #4904	-> 45
/*      */       //   #4903	-> 54
/*      */       //   #4906	-> 60
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void ey() {
/* 4911 */       this.b.ey();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Object writeReplace() {
/* 4919 */       return new k.n<>(this.b);
/*      */     }
/*      */   }
/*      */   
/*      */   static class l<K, V>
/*      */     extends m<K, V> implements j<K, V> {
/*      */     private static final long serialVersionUID = 1L;
/*      */     
/*      */     l(d<? super K, ? super V> param1d, f<? super K, V> param1f) {
/* 4928 */       super(new k<>(param1d, (f<? super K, V>)com.google.a.b.D.checkNotNull(param1f)));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public V get(K param1K) throws ExecutionException {
/* 4935 */       return this.b.k(param1K);
/*      */     }
/*      */ 
/*      */     
/*      */     public V h(K param1K) {
/*      */       try {
/* 4941 */         return get(param1K);
/* 4942 */       } catch (ExecutionException executionException) {
/* 4943 */         throw new au(executionException.getCause());
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public bj<K, V> b(Iterable<? extends K> param1Iterable) throws ExecutionException {
/* 4949 */       return this.b.b(param1Iterable);
/*      */     }
/*      */ 
/*      */     
/*      */     public void e(K param1K) {
/* 4954 */       this.b.e(param1K);
/*      */     }
/*      */ 
/*      */     
/*      */     public final V apply(K param1K) {
/* 4959 */       return h(param1K);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Object writeReplace() {
/* 4968 */       return new k.j<>(this.b);
/*      */     }
/*      */   }
/*      */   
/*      */   static interface y<K, V> {
/*      */     V get();
/*      */     
/*      */     V g() throws ExecutionException;
/*      */     
/*      */     int af();
/*      */     
/*      */     o<K, V> b();
/*      */     
/*      */     y<K, V> a(ReferenceQueue<V> param1ReferenceQueue, V param1V, o<K, V> param1o);
/*      */     
/*      */     void f(V param1V);
/*      */     
/*      */     boolean cJ();
/*      */     
/*      */     boolean isActive();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\c\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */