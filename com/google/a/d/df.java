/*      */ package com.google.a.d;
/*      */ 
/*      */ import com.google.a.a.b;
/*      */ import com.google.a.b.D;
/*      */ import com.google.a.b.x;
/*      */ import com.google.a.m.k;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.io.ObjectOutputStream;
/*      */ import java.io.Serializable;
/*      */ import java.util.Comparator;
/*      */ import java.util.ConcurrentModificationException;
/*      */ import java.util.Iterator;
/*      */ import java.util.NavigableSet;
/*      */ import java.util.NoSuchElementException;
/*      */ import java.util.Set;
/*      */ import java.util.function.ObjIntConsumer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
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
/*      */ public final class df<E>
/*      */   extends o<E>
/*      */   implements Serializable
/*      */ {
/*      */   private final transient c<b<E>> a;
/*      */   private final transient aR<E> b;
/*      */   private final transient b<E> a;
/*      */   @com.google.a.a.c
/*      */   private static final long serialVersionUID = 1L;
/*      */   
/*      */   public static <E extends Comparable> df<E> a() {
/*   75 */     return new df<>(cj.e());
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
/*      */   public static <E> df<E> a(Comparator<? super E> paramComparator) {
/*   91 */     return (paramComparator == null) ? 
/*   92 */       new df<>(cj.e()) : 
/*   93 */       new df<>(paramComparator);
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
/*      */   public static <E extends Comparable> df<E> a(Iterable<? extends E> paramIterable) {
/*  106 */     df<Comparable> df1 = a();
/*  107 */     bG.addAll(df1, paramIterable);
/*  108 */     return (df)df1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   df(c<b<E>> paramc, aR<E> paramaR, b<E> paramb) {
/*  116 */     super(paramaR.comparator());
/*  117 */     this.a = (b)paramc;
/*  118 */     this.b = paramaR;
/*  119 */     this.a = paramb;
/*      */   }
/*      */   
/*      */   df(Comparator<? super E> paramComparator) {
/*  123 */     super(paramComparator);
/*  124 */     this.b = aR.a(paramComparator);
/*  125 */     this.a = new b<>(null, 1);
/*  126 */     a(this.a, this.a);
/*  127 */     this.a = (b<E>)new c();
/*      */   }
/*      */   
/*      */   private enum a
/*      */   {
/*  132 */     a
/*      */     {
/*      */       int b(df.b<?> param2b) {
/*  135 */         return df.b.d(param2b);
/*      */       }
/*      */ 
/*      */       
/*      */       long a(df.b<?> param2b) {
/*  140 */         return (param2b == null) ? 0L : df.b.c(param2b);
/*      */       }
/*      */     },
/*  143 */     b
/*      */     {
/*      */       int b(df.b<?> param2b) {
/*  146 */         return 1;
/*      */       }
/*      */ 
/*      */       
/*      */       long a(df.b<?> param2b) {
/*  151 */         return (param2b == null) ? 0L : df.b.e(param2b);
/*      */       }
/*      */     };
/*      */     
/*      */     abstract int b(df.b<?> param1b);
/*      */     
/*      */     abstract long a(df.b<?> param1b);
/*      */   }
/*      */   
/*      */   private long a(a parama) {
/*  161 */     b<?> b1 = (b)this.a.get();
/*  162 */     long l = parama.a(b1);
/*  163 */     if (this.b.cT()) {
/*  164 */       l -= a(parama, (b)b1);
/*      */     }
/*  166 */     if (this.b.cU()) {
/*  167 */       l -= b(parama, (b)b1);
/*      */     }
/*  169 */     return l;
/*      */   }
/*      */   
/*      */   private long a(a parama, b<E> paramb) {
/*  173 */     if (paramb == null) {
/*  174 */       return 0L;
/*      */     }
/*  176 */     int i = comparator().compare(this.b.s(), b.a(paramb));
/*  177 */     if (i < 0)
/*  178 */       return a(parama, b.c(paramb)); 
/*  179 */     if (i == 0) {
/*  180 */       switch (null.I[this.b.d().ordinal()]) {
/*      */         case 1:
/*  182 */           return parama.b(paramb) + parama.a(b.c(paramb));
/*      */         case 2:
/*  184 */           return parama.a(b.c(paramb));
/*      */       } 
/*  186 */       throw new AssertionError();
/*      */     } 
/*      */     
/*  189 */     return parama.a(b.c(paramb)) + parama
/*  190 */       .b(paramb) + 
/*  191 */       a(parama, b.d(paramb));
/*      */   }
/*      */ 
/*      */   
/*      */   private long b(a parama, b<E> paramb) {
/*  196 */     if (paramb == null) {
/*  197 */       return 0L;
/*      */     }
/*  199 */     int i = comparator().compare(this.b.t(), b.a(paramb));
/*  200 */     if (i > 0)
/*  201 */       return b(parama, b.d(paramb)); 
/*  202 */     if (i == 0) {
/*  203 */       switch (null.I[this.b.e().ordinal()]) {
/*      */         case 1:
/*  205 */           return parama.b(paramb) + parama.a(b.d(paramb));
/*      */         case 2:
/*  207 */           return parama.a(b.d(paramb));
/*      */       } 
/*  209 */       throw new AssertionError();
/*      */     } 
/*      */     
/*  212 */     return parama.a(b.d(paramb)) + parama
/*  213 */       .b(paramb) + 
/*  214 */       b(parama, b.c(paramb));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int size() {
/*  220 */     return k.e(a((a)a.a));
/*      */   }
/*      */ 
/*      */   
/*      */   int ah() {
/*  225 */     return k.e(a(a.b));
/*      */   }
/*      */   
/*      */   static int a(b<?> paramb) {
/*  229 */     return (paramb == null) ? 0 : b.e(paramb);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int b(Object paramObject) {
/*      */     try {
/*  236 */       Object object = paramObject;
/*  237 */       b<Object> b1 = (b)this.a.get();
/*  238 */       if (!this.b.contains((E)object) || b1 == null) {
/*  239 */         return 0;
/*      */       }
/*  241 */       return b1.a(comparator(), object);
/*  242 */     } catch (ClassCastException|NullPointerException classCastException) {
/*  243 */       return 0;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   @com.google.b.a.a
/*      */   public int add(E paramE, int paramInt) {
/*  250 */     C.b(paramInt, "occurrences");
/*  251 */     if (paramInt == 0) {
/*  252 */       return b(paramE);
/*      */     }
/*  254 */     D.checkArgument(this.b.contains(paramE));
/*  255 */     b<E> b1 = (b)this.a.get();
/*  256 */     if (b1 == null) {
/*  257 */       comparator().compare(paramE, paramE);
/*  258 */       b<E> b3 = new b<>(paramE, paramInt);
/*  259 */       a(this.a, b3, this.a);
/*  260 */       this.a.d((E)b1, (E)b3);
/*  261 */       return 0;
/*      */     } 
/*  263 */     int[] arrayOfInt = new int[1];
/*  264 */     b<E> b2 = b1.a(comparator(), paramE, paramInt, arrayOfInt);
/*  265 */     this.a.d((E)b1, (E)b2);
/*  266 */     return arrayOfInt[0];
/*      */   }
/*      */   
/*      */   @com.google.b.a.a
/*      */   public int remove(Object paramObject, int paramInt) {
/*      */     b b2;
/*  272 */     C.b(paramInt, "occurrences");
/*  273 */     if (paramInt == 0) {
/*  274 */       return b(paramObject);
/*      */     }
/*  276 */     b<Object> b1 = (b)this.a.get();
/*  277 */     int[] arrayOfInt = new int[1];
/*      */ 
/*      */     
/*      */     try {
/*  281 */       Object object = paramObject;
/*  282 */       if (!this.b.contains((E)object) || b1 == null) {
/*  283 */         return 0;
/*      */       }
/*  285 */       b2 = b1.b(comparator(), object, paramInt, arrayOfInt);
/*  286 */     } catch (ClassCastException|NullPointerException classCastException) {
/*  287 */       return 0;
/*      */     } 
/*  289 */     this.a.d((E)b1, (E)b2);
/*  290 */     return arrayOfInt[0];
/*      */   }
/*      */ 
/*      */   
/*      */   @com.google.b.a.a
/*      */   public int setCount(E paramE, int paramInt) {
/*  296 */     C.b(paramInt, "count");
/*  297 */     if (!this.b.contains(paramE)) {
/*  298 */       D.checkArgument((paramInt == 0));
/*  299 */       return 0;
/*      */     } 
/*      */     
/*  302 */     b<E> b1 = (b)this.a.get();
/*  303 */     if (b1 == null) {
/*  304 */       if (paramInt > 0) {
/*  305 */         add(paramE, paramInt);
/*      */       }
/*  307 */       return 0;
/*      */     } 
/*  309 */     int[] arrayOfInt = new int[1];
/*  310 */     b<E> b2 = b1.c(comparator(), paramE, paramInt, arrayOfInt);
/*  311 */     this.a.d((E)b1, (E)b2);
/*  312 */     return arrayOfInt[0];
/*      */   }
/*      */ 
/*      */   
/*      */   @com.google.b.a.a
/*      */   public boolean a(E paramE, int paramInt1, int paramInt2) {
/*  318 */     C.b(paramInt2, "newCount");
/*  319 */     C.b(paramInt1, "oldCount");
/*  320 */     D.checkArgument(this.b.contains(paramE));
/*      */     
/*  322 */     b<E> b1 = (b)this.a.get();
/*  323 */     if (b1 == null) {
/*  324 */       if (paramInt1 == 0) {
/*  325 */         if (paramInt2 > 0) {
/*  326 */           add(paramE, paramInt2);
/*      */         }
/*  328 */         return true;
/*      */       } 
/*  330 */       return false;
/*      */     } 
/*      */     
/*  333 */     int[] arrayOfInt = new int[1];
/*  334 */     b<E> b2 = b1.a(comparator(), paramE, paramInt1, paramInt2, arrayOfInt);
/*  335 */     this.a.d((E)b1, (E)b2);
/*  336 */     return (arrayOfInt[0] == paramInt1);
/*      */   }
/*      */ 
/*      */   
/*      */   public void clear() {
/*  341 */     if (!this.b.cT() && !this.b.cU()) {
/*      */       
/*  343 */       for (b<E> b1 = b.e(this.a); b1 != this.a; ) {
/*  344 */         b<E> b2 = b.e(b1);
/*      */         
/*  346 */         b.a(b1, 0);
/*      */         
/*  348 */         b.a(b1, (b)null);
/*  349 */         b.b(b1, (b)null);
/*  350 */         b.c(b1, null);
/*  351 */         b.d(b1, null);
/*      */         
/*  353 */         b1 = b2;
/*      */       } 
/*  355 */       a(this.a, this.a);
/*  356 */       this.a.clear();
/*      */     } else {
/*      */       
/*  359 */       bH.a(c());
/*      */     } 
/*      */   }
/*      */   
/*      */   private cc.a<E> a(b<E> paramb) {
/*  364 */     return new cd.a<E>(this, paramb)
/*      */       {
/*      */         public E getElement() {
/*  367 */           return this.b.getElement();
/*      */         }
/*      */ 
/*      */         
/*      */         public int getCount() {
/*  372 */           int i = this.b.getCount();
/*  373 */           if (i == 0) {
/*  374 */             return this.a.b(getElement());
/*      */           }
/*  376 */           return i;
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */   
/*      */   private b<E> a() {
/*      */     b<E> b2;
/*  384 */     b b1 = (b)this.a.get();
/*  385 */     if (b1 == null) {
/*  386 */       return null;
/*      */     }
/*      */     
/*  389 */     if (this.b.cT()) {
/*  390 */       E e = this.b.s();
/*  391 */       b2 = b.a((b)this.a.get(), comparator(), e);
/*  392 */       if (b2 == null) {
/*  393 */         return null;
/*      */       }
/*  395 */       if (this.b.d() == x.a && 
/*  396 */         comparator().compare(e, b2.getElement()) == 0) {
/*  397 */         b2 = b.e(b2);
/*      */       }
/*      */     } else {
/*  400 */       b2 = b.e(this.a);
/*      */     } 
/*  402 */     return (b2 == this.a || !this.b.contains(b2.getElement())) ? null : b2;
/*      */   }
/*      */   private b<E> b() {
/*      */     b<E> b2;
/*  406 */     b b1 = (b)this.a.get();
/*  407 */     if (b1 == null) {
/*  408 */       return null;
/*      */     }
/*      */     
/*  411 */     if (this.b.cU()) {
/*  412 */       E e = this.b.t();
/*  413 */       b2 = b.b((b)this.a.get(), comparator(), e);
/*  414 */       if (b2 == null) {
/*  415 */         return null;
/*      */       }
/*  417 */       if (this.b.e() == x.a && 
/*  418 */         comparator().compare(e, b2.getElement()) == 0) {
/*  419 */         b2 = b.f(b2);
/*      */       }
/*      */     } else {
/*  422 */       b2 = b.f(this.a);
/*      */     } 
/*  424 */     return (b2 == this.a || !this.b.contains(b2.getElement())) ? null : b2;
/*      */   }
/*      */ 
/*      */   
/*      */   Iterator<E> e() {
/*  429 */     return cd.e(c());
/*      */   }
/*      */ 
/*      */   
/*      */   Iterator<cc.a<E>> c() {
/*  434 */     return (Iterator)new Iterator<cc.a<cc.a<E>>>(this) { df.b<E> c;
/*  435 */         cc.a<E> c = (cc.a<E>)df.a(this.a);
/*      */ 
/*      */ 
/*      */         
/*      */         public boolean hasNext() {
/*  440 */           if (this.c == null)
/*  441 */             return false; 
/*  442 */           if (df.a(this.a).o(this.c.getElement())) {
/*  443 */             this.c = null;
/*  444 */             return false;
/*      */           } 
/*  446 */           return true;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public cc.a<E> a() {
/*  452 */           if (!hasNext()) {
/*  453 */             throw new NoSuchElementException();
/*      */           }
/*  455 */           cc.a<E> a1 = df.a(this.a, (df.b)this.c);
/*  456 */           this.c = a1;
/*  457 */           if (df.b.e((df.b)this.c) == df.b(this.a)) {
/*  458 */             this.c = null;
/*      */           } else {
/*  460 */             this.c = (cc.a<E>)df.b.e((df.b)this.c);
/*      */           } 
/*  462 */           return a1;
/*      */         }
/*      */ 
/*      */         
/*      */         public void remove() {
/*  467 */           C.ad((this.c != null));
/*  468 */           this.a.setCount(this.c.getElement(), 0);
/*  469 */           this.c = null;
/*      */         } }
/*      */       ;
/*      */   }
/*      */ 
/*      */   
/*      */   Iterator<cc.a<E>> f() {
/*  476 */     return (Iterator)new Iterator<cc.a<cc.a<E>>>(this)
/*      */       {
/*      */         df.b<E> c;
/*      */         cc.a<E> c;
/*      */         
/*      */         public boolean hasNext() {
/*  482 */           if (this.c == null)
/*  483 */             return false; 
/*  484 */           if (df.a(this.a).n(this.c.getElement())) {
/*  485 */             this.c = null;
/*  486 */             return false;
/*      */           } 
/*  488 */           return true;
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public cc.a<E> a() {
/*  494 */           if (!hasNext()) {
/*  495 */             throw new NoSuchElementException();
/*      */           }
/*  497 */           cc.a<E> a1 = df.a(this.a, (df.b)this.c);
/*  498 */           this.c = a1;
/*  499 */           if (df.b.f((df.b)this.c) == df.b(this.a)) {
/*  500 */             this.c = null;
/*      */           } else {
/*  502 */             this.c = (cc.a<E>)df.b.f((df.b)this.c);
/*      */           } 
/*  504 */           return a1;
/*      */         }
/*      */ 
/*      */         
/*      */         public void remove() {
/*  509 */           C.ad((this.c != null));
/*  510 */           this.a.setCount(this.c.getElement(), 0);
/*  511 */           this.c = null;
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */   
/*      */   public void a(ObjIntConsumer<? super E> paramObjIntConsumer) {
/*  518 */     D.checkNotNull(paramObjIntConsumer);
/*  519 */     b<E> b1 = a();
/*  520 */     for (; b1 != this.a && b1 != null && !this.b.o(b1.getElement()); 
/*  521 */       b1 = b.e(b1)) {
/*  522 */       paramObjIntConsumer.accept(b1.getElement(), b1.getCount());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public Iterator<E> iterator() {
/*  528 */     return cd.a(this);
/*      */   }
/*      */ 
/*      */   
/*      */   public cP<E> b(E paramE, x paramx) {
/*  533 */     return new df((c)this.a, this.b
/*      */         
/*  535 */         .a(aR.b(comparator(), paramE, paramx)), this.a);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public cP<E> a(E paramE, x paramx) {
/*  541 */     return new df((c)this.a, this.b
/*      */         
/*  543 */         .a(aR.a(comparator(), paramE, paramx)), this.a);
/*      */   }
/*      */   
/*      */   private static final class c<T> { private T value;
/*      */     
/*      */     private c() {}
/*      */     
/*      */     public T get() {
/*  551 */       return this.value;
/*      */     }
/*      */     
/*      */     public void d(T param1T1, T param1T2) {
/*  555 */       if (this.value != param1T1) {
/*  556 */         throw new ConcurrentModificationException();
/*      */       }
/*  558 */       this.value = param1T2;
/*      */     }
/*      */     
/*      */     void clear() {
/*  562 */       this.value = null;
/*      */     } }
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class b<E>
/*      */   {
/*      */     private final E Y;
/*      */     
/*      */     private int fh;
/*      */     private int er;
/*      */     private long totalCount;
/*      */     private int height;
/*      */     private b<E> d;
/*      */     private b<E> e;
/*      */     private b<E> f;
/*      */     private b<E> g;
/*      */     
/*      */     b(E param1E, int param1Int) {
/*  581 */       D.checkArgument((param1Int > 0));
/*  582 */       this.Y = param1E;
/*  583 */       this.fh = param1Int;
/*  584 */       this.totalCount = param1Int;
/*  585 */       this.er = 1;
/*  586 */       this.height = 1;
/*  587 */       this.d = null;
/*  588 */       this.e = null;
/*      */     }
/*      */     
/*      */     public int a(Comparator<? super E> param1Comparator, E param1E) {
/*  592 */       int i = param1Comparator.compare(param1E, this.Y);
/*  593 */       if (i < 0)
/*  594 */         return (this.d == null) ? 0 : this.d.a(param1Comparator, param1E); 
/*  595 */       if (i > 0) {
/*  596 */         return (this.e == null) ? 0 : this.e.a(param1Comparator, param1E);
/*      */       }
/*  598 */       return this.fh;
/*      */     }
/*      */ 
/*      */     
/*      */     private b<E> a(E param1E, int param1Int) {
/*  603 */       this.e = new b(param1E, param1Int);
/*  604 */       df.b(this, this.e, this.g);
/*  605 */       this.height = Math.max(2, this.height);
/*  606 */       this.er++;
/*  607 */       this.totalCount += param1Int;
/*  608 */       return this;
/*      */     }
/*      */     
/*      */     private b<E> b(E param1E, int param1Int) {
/*  612 */       this.d = new b(param1E, param1Int);
/*  613 */       df.b(this.f, this.d, this);
/*  614 */       this.height = Math.max(2, this.height);
/*  615 */       this.er++;
/*  616 */       this.totalCount += param1Int;
/*  617 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     b<E> a(Comparator<? super E> param1Comparator, E param1E, int param1Int, int[] param1ArrayOfint) {
/*  625 */       int i = param1Comparator.compare(param1E, this.Y);
/*  626 */       if (i < 0) {
/*  627 */         b<E> b1 = this.d;
/*  628 */         if (b1 == null) {
/*  629 */           param1ArrayOfint[0] = 0;
/*  630 */           return b(param1E, param1Int);
/*      */         } 
/*  632 */         int j = b1.height;
/*      */         
/*  634 */         this.d = b1.a(param1Comparator, param1E, param1Int, param1ArrayOfint);
/*  635 */         if (param1ArrayOfint[0] == 0) {
/*  636 */           this.er++;
/*      */         }
/*  638 */         this.totalCount += param1Int;
/*  639 */         return (this.d.height == j) ? this : d();
/*  640 */       }  if (i > 0) {
/*  641 */         b<E> b1 = this.e;
/*  642 */         if (b1 == null) {
/*  643 */           param1ArrayOfint[0] = 0;
/*  644 */           return a(param1E, param1Int);
/*      */         } 
/*  646 */         int j = b1.height;
/*      */         
/*  648 */         this.e = b1.a(param1Comparator, param1E, param1Int, param1ArrayOfint);
/*  649 */         if (param1ArrayOfint[0] == 0) {
/*  650 */           this.er++;
/*      */         }
/*  652 */         this.totalCount += param1Int;
/*  653 */         return (this.e.height == j) ? this : d();
/*      */       } 
/*      */ 
/*      */       
/*  657 */       param1ArrayOfint[0] = this.fh;
/*  658 */       long l = this.fh + param1Int;
/*  659 */       D.checkArgument((l <= 2147483647L));
/*  660 */       this.fh += param1Int;
/*  661 */       this.totalCount += param1Int;
/*  662 */       return this;
/*      */     }
/*      */     
/*      */     b<E> b(Comparator<? super E> param1Comparator, E param1E, int param1Int, int[] param1ArrayOfint) {
/*  666 */       int i = param1Comparator.compare(param1E, this.Y);
/*  667 */       if (i < 0) {
/*  668 */         b<E> b1 = this.d;
/*  669 */         if (b1 == null) {
/*  670 */           param1ArrayOfint[0] = 0;
/*  671 */           return this;
/*      */         } 
/*      */         
/*  674 */         this.d = b1.b(param1Comparator, param1E, param1Int, param1ArrayOfint);
/*      */         
/*  676 */         if (param1ArrayOfint[0] > 0) {
/*  677 */           if (param1Int >= param1ArrayOfint[0]) {
/*  678 */             this.er--;
/*  679 */             this.totalCount -= param1ArrayOfint[0];
/*      */           } else {
/*  681 */             this.totalCount -= param1Int;
/*      */           } 
/*      */         }
/*  684 */         return (param1ArrayOfint[0] == 0) ? this : d();
/*  685 */       }  if (i > 0) {
/*  686 */         b<E> b1 = this.e;
/*  687 */         if (b1 == null) {
/*  688 */           param1ArrayOfint[0] = 0;
/*  689 */           return this;
/*      */         } 
/*      */         
/*  692 */         this.e = b1.b(param1Comparator, param1E, param1Int, param1ArrayOfint);
/*      */         
/*  694 */         if (param1ArrayOfint[0] > 0) {
/*  695 */           if (param1Int >= param1ArrayOfint[0]) {
/*  696 */             this.er--;
/*  697 */             this.totalCount -= param1ArrayOfint[0];
/*      */           } else {
/*  699 */             this.totalCount -= param1Int;
/*      */           } 
/*      */         }
/*  702 */         return d();
/*      */       } 
/*      */ 
/*      */       
/*  706 */       param1ArrayOfint[0] = this.fh;
/*  707 */       if (param1Int >= this.fh) {
/*  708 */         return c();
/*      */       }
/*  710 */       this.fh -= param1Int;
/*  711 */       this.totalCount -= param1Int;
/*  712 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     b<E> c(Comparator<? super E> param1Comparator, E param1E, int param1Int, int[] param1ArrayOfint) {
/*  717 */       int i = param1Comparator.compare(param1E, this.Y);
/*  718 */       if (i < 0) {
/*  719 */         b<E> b1 = this.d;
/*  720 */         if (b1 == null) {
/*  721 */           param1ArrayOfint[0] = 0;
/*  722 */           return (param1Int > 0) ? b(param1E, param1Int) : this;
/*      */         } 
/*      */         
/*  725 */         this.d = b1.c(param1Comparator, param1E, param1Int, param1ArrayOfint);
/*      */         
/*  727 */         if (param1Int == 0 && param1ArrayOfint[0] != 0) {
/*  728 */           this.er--;
/*  729 */         } else if (param1Int > 0 && param1ArrayOfint[0] == 0) {
/*  730 */           this.er++;
/*      */         } 
/*      */         
/*  733 */         this.totalCount += (param1Int - param1ArrayOfint[0]);
/*  734 */         return d();
/*  735 */       }  if (i > 0) {
/*  736 */         b<E> b1 = this.e;
/*  737 */         if (b1 == null) {
/*  738 */           param1ArrayOfint[0] = 0;
/*  739 */           return (param1Int > 0) ? a(param1E, param1Int) : this;
/*      */         } 
/*      */         
/*  742 */         this.e = b1.c(param1Comparator, param1E, param1Int, param1ArrayOfint);
/*      */         
/*  744 */         if (param1Int == 0 && param1ArrayOfint[0] != 0) {
/*  745 */           this.er--;
/*  746 */         } else if (param1Int > 0 && param1ArrayOfint[0] == 0) {
/*  747 */           this.er++;
/*      */         } 
/*      */         
/*  750 */         this.totalCount += (param1Int - param1ArrayOfint[0]);
/*  751 */         return d();
/*      */       } 
/*      */ 
/*      */       
/*  755 */       param1ArrayOfint[0] = this.fh;
/*  756 */       if (param1Int == 0) {
/*  757 */         return c();
/*      */       }
/*  759 */       this.totalCount += (param1Int - this.fh);
/*  760 */       this.fh = param1Int;
/*  761 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     b<E> a(Comparator<? super E> param1Comparator, E param1E, int param1Int1, int param1Int2, int[] param1ArrayOfint) {
/*  770 */       int i = param1Comparator.compare(param1E, this.Y);
/*  771 */       if (i < 0) {
/*  772 */         b<E> b1 = this.d;
/*  773 */         if (b1 == null) {
/*  774 */           param1ArrayOfint[0] = 0;
/*  775 */           if (param1Int1 == 0 && param1Int2 > 0) {
/*  776 */             return b(param1E, param1Int2);
/*      */           }
/*  778 */           return this;
/*      */         } 
/*      */         
/*  781 */         this.d = b1.a(param1Comparator, param1E, param1Int1, param1Int2, param1ArrayOfint);
/*      */         
/*  783 */         if (param1ArrayOfint[0] == param1Int1) {
/*  784 */           if (param1Int2 == 0 && param1ArrayOfint[0] != 0) {
/*  785 */             this.er--;
/*  786 */           } else if (param1Int2 > 0 && param1ArrayOfint[0] == 0) {
/*  787 */             this.er++;
/*      */           } 
/*  789 */           this.totalCount += (param1Int2 - param1ArrayOfint[0]);
/*      */         } 
/*  791 */         return d();
/*  792 */       }  if (i > 0) {
/*  793 */         b<E> b1 = this.e;
/*  794 */         if (b1 == null) {
/*  795 */           param1ArrayOfint[0] = 0;
/*  796 */           if (param1Int1 == 0 && param1Int2 > 0) {
/*  797 */             return a(param1E, param1Int2);
/*      */           }
/*  799 */           return this;
/*      */         } 
/*      */         
/*  802 */         this.e = b1.a(param1Comparator, param1E, param1Int1, param1Int2, param1ArrayOfint);
/*      */         
/*  804 */         if (param1ArrayOfint[0] == param1Int1) {
/*  805 */           if (param1Int2 == 0 && param1ArrayOfint[0] != 0) {
/*  806 */             this.er--;
/*  807 */           } else if (param1Int2 > 0 && param1ArrayOfint[0] == 0) {
/*  808 */             this.er++;
/*      */           } 
/*  810 */           this.totalCount += (param1Int2 - param1ArrayOfint[0]);
/*      */         } 
/*  812 */         return d();
/*      */       } 
/*      */ 
/*      */       
/*  816 */       param1ArrayOfint[0] = this.fh;
/*  817 */       if (param1Int1 == this.fh) {
/*  818 */         if (param1Int2 == 0) {
/*  819 */           return c();
/*      */         }
/*  821 */         this.totalCount += (param1Int2 - this.fh);
/*  822 */         this.fh = param1Int2;
/*      */       } 
/*  824 */       return this;
/*      */     }
/*      */     
/*      */     private b<E> c() {
/*  828 */       int i = this.fh;
/*  829 */       this.fh = 0;
/*  830 */       df.b(this.f, this.g);
/*  831 */       if (this.d == null)
/*  832 */         return this.e; 
/*  833 */       if (this.e == null)
/*  834 */         return this.d; 
/*  835 */       if (this.d.height >= this.e.height) {
/*  836 */         b<E> b2 = this.f;
/*      */         
/*  838 */         b2.d = this.d.b(b2);
/*  839 */         b2.e = this.e;
/*  840 */         b2.er = this.er - 1;
/*  841 */         b2.totalCount = this.totalCount - i;
/*  842 */         return b2.d();
/*      */       } 
/*  844 */       b<E> b1 = this.g;
/*  845 */       b1.e = this.e.a(b1);
/*  846 */       b1.d = this.d;
/*  847 */       b1.er = this.er - 1;
/*  848 */       b1.totalCount = this.totalCount - i;
/*  849 */       return b1.d();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private b<E> a(b<E> param1b) {
/*  855 */       if (this.d == null) {
/*  856 */         return this.e;
/*      */       }
/*  858 */       this.d = this.d.a(param1b);
/*  859 */       this.er--;
/*  860 */       this.totalCount -= param1b.fh;
/*  861 */       return d();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private b<E> b(b<E> param1b) {
/*  867 */       if (this.e == null) {
/*  868 */         return this.d;
/*      */       }
/*  870 */       this.e = this.e.b(param1b);
/*  871 */       this.er--;
/*  872 */       this.totalCount -= param1b.fh;
/*  873 */       return d();
/*      */     }
/*      */ 
/*      */     
/*      */     private void fq() {
/*  878 */       this
/*  879 */         .er = 1 + df.a(this.d) + df.a(this.e);
/*  880 */       this.totalCount = this.fh + b(this.d) + b(this.e);
/*      */     }
/*      */     
/*      */     private void fr() {
/*  884 */       this.height = 1 + Math.max(c(this.d), c(this.e));
/*      */     }
/*      */     
/*      */     private void fs() {
/*  888 */       fq();
/*  889 */       fr();
/*      */     }
/*      */     
/*      */     private b<E> d() {
/*  893 */       switch (au()) {
/*      */         case -2:
/*  895 */           if (this.e.au() > 0) {
/*  896 */             this.e = this.e.f();
/*      */           }
/*  898 */           return e();
/*      */         case 2:
/*  900 */           if (this.d.au() < 0) {
/*  901 */             this.d = this.d.e();
/*      */           }
/*  903 */           return f();
/*      */       } 
/*  905 */       fr();
/*  906 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     private int au() {
/*  911 */       return c(this.d) - c(this.e);
/*      */     }
/*      */     
/*      */     private b<E> e() {
/*  915 */       D.ab((this.e != null));
/*  916 */       b<E> b1 = this.e;
/*  917 */       this.e = b1.d;
/*  918 */       b1.d = this;
/*  919 */       b1.totalCount = this.totalCount;
/*  920 */       b1.er = this.er;
/*  921 */       fs();
/*  922 */       b1.fr();
/*  923 */       return b1;
/*      */     }
/*      */     
/*      */     private b<E> f() {
/*  927 */       D.ab((this.d != null));
/*  928 */       b<E> b1 = this.d;
/*  929 */       this.d = b1.e;
/*  930 */       b1.e = this;
/*  931 */       b1.totalCount = this.totalCount;
/*  932 */       b1.er = this.er;
/*  933 */       fs();
/*  934 */       b1.fr();
/*  935 */       return b1;
/*      */     }
/*      */     
/*      */     private static long b(b<?> param1b) {
/*  939 */       return (param1b == null) ? 0L : param1b.totalCount;
/*      */     }
/*      */     
/*      */     private static int c(b<?> param1b) {
/*  943 */       return (param1b == null) ? 0 : param1b.height;
/*      */     }
/*      */     
/*      */     private b<E> a(Comparator<? super E> param1Comparator, E param1E) {
/*  947 */       int i = param1Comparator.compare(param1E, this.Y);
/*  948 */       if (i < 0)
/*  949 */         return (this.d == null) ? this : (b<E>)x.a(this.d.a(param1Comparator, param1E), this); 
/*  950 */       if (i == 0) {
/*  951 */         return this;
/*      */       }
/*  953 */       return (this.e == null) ? null : this.e.a(param1Comparator, param1E);
/*      */     }
/*      */ 
/*      */     
/*      */     private b<E> b(Comparator<? super E> param1Comparator, E param1E) {
/*  958 */       int i = param1Comparator.compare(param1E, this.Y);
/*  959 */       if (i > 0)
/*  960 */         return (this.e == null) ? this : (b<E>)x.a(this.e.b(param1Comparator, param1E), this); 
/*  961 */       if (i == 0) {
/*  962 */         return this;
/*      */       }
/*  964 */       return (this.d == null) ? null : this.d.b(param1Comparator, param1E);
/*      */     }
/*      */ 
/*      */     
/*      */     E getElement() {
/*  969 */       return this.Y;
/*      */     }
/*      */     
/*      */     int getCount() {
/*  973 */       return this.fh;
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/*  978 */       return cd.<E>a(getElement(), getCount()).toString();
/*      */     }
/*      */   }
/*      */   
/*      */   private static <T> void a(b<T> paramb1, b<T> paramb2) {
/*  983 */     b.d(paramb1, paramb2);
/*  984 */     b.c(paramb2, paramb1);
/*      */   }
/*      */   
/*      */   private static <T> void a(b<T> paramb1, b<T> paramb2, b<T> paramb3) {
/*  988 */     a(paramb1, paramb2);
/*  989 */     a(paramb2, paramb3);
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
/*      */   @com.google.a.a.c
/*      */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 1004 */     paramObjectOutputStream.defaultWriteObject();
/* 1005 */     paramObjectOutputStream.writeObject(d().comparator());
/* 1006 */     cE.a(this, paramObjectOutputStream);
/*      */   }
/*      */   
/*      */   @com.google.a.a.c
/*      */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 1011 */     paramObjectInputStream.defaultReadObject();
/*      */ 
/*      */     
/* 1014 */     Comparator<?> comparator = (Comparator)paramObjectInputStream.readObject();
/* 1015 */     cE.<o>a(o.class, "comparator").c(this, comparator);
/* 1016 */     cE.<df>a(df.class, "range")
/* 1017 */       .c(this, aR.a(comparator));
/* 1018 */     cE.<df>a(df.class, "rootReference")
/* 1019 */       .c(this, new c());
/* 1020 */     b<?> b1 = new b(null, 1);
/* 1021 */     cE.<df>a(df.class, "header").c(this, b1);
/* 1022 */     a(b1, b1);
/* 1023 */     cE.a(this, paramObjectInputStream);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\df.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */