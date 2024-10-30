/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.c.a.h;
/*     */ import java.io.Serializable;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.EnumSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import java.util.Spliterator;
/*     */ import java.util.function.Consumer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b(ck = true, cl = true)
/*     */ public abstract class bt<E>
/*     */   extends bd<E>
/*     */   implements Set<E>
/*     */ {
/*     */   static final int ex = 1297;
/*     */   @com.google.b.a.a.b
/*     */   @h
/*     */   private transient bh<E> i;
/*     */   static final int ew = 1073741824;
/*     */   private static final double r = 0.7D;
/*     */   private static final int eB = 751619276;
/*     */   static final double s = 0.001D;
/*     */   static final int eC = 13;
/*     */   
/*     */   public static <E> Collector<E, ?, bt<E>> b() {
/*  66 */     return B.b();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bt<E> n() {
/*  75 */     return cx.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bt<E> b(E paramE) {
/*  84 */     return new cJ<>(paramE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bt<E> a(E paramE1, E paramE2) {
/*  93 */     return a(2, 2, new Object[] { paramE1, paramE2 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bt<E> a(E paramE1, E paramE2, E paramE3) {
/* 102 */     return a(3, 3, new Object[] { paramE1, paramE2, paramE3 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bt<E> a(E paramE1, E paramE2, E paramE3, E paramE4) {
/* 111 */     return a(4, 4, new Object[] { paramE1, paramE2, paramE3, paramE4 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bt<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5) {
/* 120 */     return a(5, 5, new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5 });
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
/*     */   @SafeVarargs
/*     */   public static <E> bt<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E... paramVarArgs) {
/* 134 */     D.a((paramVarArgs.length <= 2147483641), "the total number of elements must fit in an int");
/*     */     
/* 136 */     byte b = 6;
/* 137 */     Object[] arrayOfObject = new Object[6 + paramVarArgs.length];
/* 138 */     arrayOfObject[0] = paramE1;
/* 139 */     arrayOfObject[1] = paramE2;
/* 140 */     arrayOfObject[2] = paramE3;
/* 141 */     arrayOfObject[3] = paramE4;
/* 142 */     arrayOfObject[4] = paramE5;
/* 143 */     arrayOfObject[5] = paramE6;
/* 144 */     System.arraycopy(paramVarArgs, 0, arrayOfObject, 6, paramVarArgs.length);
/* 145 */     return a(arrayOfObject.length, arrayOfObject.length, arrayOfObject);
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
/*     */   private static <E> bt<E> a(int paramInt, Object... paramVarArgs) {
/* 165 */     return a(paramInt, 
/*     */         
/* 167 */         Math.max(4, 
/*     */           
/* 169 */           com.google.a.k.e.c(paramInt, RoundingMode.CEILING)), paramVarArgs);
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
/*     */   private static <E> bt<E> a(int paramInt1, int paramInt2, Object... paramVarArgs) {
/*     */     Object object;
/* 188 */     switch (paramInt1) {
/*     */       case 0:
/* 190 */         return n();
/*     */       
/*     */       case 1:
/* 193 */         object = paramVarArgs[0];
/* 194 */         return b((E)object);
/*     */     } 
/* 196 */     f<E> f = new d(paramInt2);
/* 197 */     for (byte b = 0; b < paramInt1; b++) {
/*     */       
/* 199 */       Object object1 = D.checkNotNull(paramVarArgs[b]);
/* 200 */       f = f.a(object1);
/*     */     } 
/* 202 */     return f.b().o();
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
/*     */   public static <E> bt<E> a(Collection<? extends E> paramCollection) {
/* 224 */     if (paramCollection instanceof bt && !(paramCollection instanceof java.util.SortedSet)) {
/*     */       
/* 226 */       bt<E> bt1 = (bt)paramCollection;
/* 227 */       if (!bt1.cO()) {
/* 228 */         return bt1;
/*     */       }
/* 230 */     } else if (paramCollection instanceof EnumSet) {
/* 231 */       return b((EnumSet)paramCollection);
/*     */     } 
/* 233 */     Object[] arrayOfObject = paramCollection.toArray();
/* 234 */     if (paramCollection instanceof Set)
/*     */     {
/* 236 */       return a(arrayOfObject.length, arrayOfObject.length, arrayOfObject);
/*     */     }
/* 238 */     return a(arrayOfObject.length, arrayOfObject);
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
/*     */   public static <E> bt<E> a(Iterable<? extends E> paramIterable) {
/* 255 */     return (paramIterable instanceof Collection) ? 
/* 256 */       a((Collection<? extends E>)paramIterable) : 
/* 257 */       a(paramIterable.iterator());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bt<E> a(Iterator<? extends E> paramIterator) {
/* 268 */     if (!paramIterator.hasNext()) {
/* 269 */       return n();
/*     */     }
/* 271 */     E e = paramIterator.next();
/* 272 */     if (!paramIterator.hasNext()) {
/* 273 */       return b(e);
/*     */     }
/* 275 */     return (new a<>()).a(e).a(paramIterator).o();
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
/*     */   public static <E> bt<E> a(E[] paramArrayOfE) {
/* 287 */     switch (paramArrayOfE.length) {
/*     */       case 0:
/* 289 */         return n();
/*     */       case 1:
/* 291 */         return b(paramArrayOfE[0]);
/*     */     } 
/* 293 */     return a(paramArrayOfE.length, (Object[])paramArrayOfE.clone());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static bt b(EnumSet<Enum> paramEnumSet) {
/* 299 */     return bg.a(EnumSet.copyOf(paramEnumSet));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean cR() {
/* 306 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 311 */     if (paramObject == this)
/* 312 */       return true; 
/* 313 */     if (paramObject instanceof bt && 
/* 314 */       cR() && ((bt)paramObject)
/* 315 */       .cR() && 
/* 316 */       hashCode() != paramObject.hashCode()) {
/* 317 */       return false;
/*     */     }
/* 319 */     return cG.a(this, paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 324 */     return cG.a(this);
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
/*     */   public bh<E> c() {
/* 336 */     bh<E> bh1 = this.i;
/* 337 */     return (bh1 == null) ? (this.i = h()) : bh1;
/*     */   }
/*     */   
/*     */   bh<E> h() {
/* 341 */     return new cs<>(this, toArray());
/*     */   }
/*     */ 
/*     */   
/*     */   static abstract class b<E>
/*     */     extends bt<E>
/*     */   {
/*     */     public dj<E> b() {
/* 349 */       return c().b();
/*     */     }
/*     */ 
/*     */     
/*     */     public Spliterator<E> spliterator() {
/* 354 */       return D.a(size(), 1297, this::get);
/*     */     }
/*     */ 
/*     */     
/*     */     public void forEach(Consumer<? super E> param1Consumer) {
/* 359 */       D.checkNotNull(param1Consumer);
/* 360 */       int i = size();
/* 361 */       for (byte b1 = 0; b1 < i; b1++) {
/* 362 */         param1Consumer.accept(get(b1));
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     int a(Object[] param1ArrayOfObject, int param1Int) {
/* 368 */       return c().a(param1ArrayOfObject, param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     bh<E> h() {
/* 373 */       return new aZ<E>(this)
/*     */         {
/*     */           public E get(int param2Int) {
/* 376 */             return this.a.get(param2Int);
/*     */           }
/*     */ 
/*     */           
/*     */           bt.b<E> a() {
/* 381 */             return this.a;
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     abstract E get(int param1Int);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class e
/*     */     implements Serializable
/*     */   {
/*     */     final Object[] elements;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     e(Object[] param1ArrayOfObject) {
/* 398 */       this.elements = param1ArrayOfObject;
/*     */     }
/*     */     
/*     */     Object readResolve() {
/* 402 */       return bt.a(this.elements);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Object writeReplace() {
/* 410 */     return new e(toArray());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> a<E> a() {
/* 418 */     return new a<>();
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
/*     */   @com.google.a.a.a
/*     */   public static <E> a<E> a(int paramInt) {
/* 435 */     C.b(paramInt, "expectedSize");
/* 436 */     return new a<>(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   static Object[] a(int paramInt1, Object[] paramArrayOfObject, int paramInt2) {
/* 441 */     Object[] arrayOfObject = new Object[paramInt1];
/* 442 */     int i = arrayOfObject.length - 1;
/* 443 */     for (byte b = 0; b < paramInt2; ) {
/* 444 */       Object object = paramArrayOfObject[b];
/* 445 */       int j = aY.d(object.hashCode());
/* 446 */       int k = j; for (;; b++) {
/* 447 */         int m = k & i;
/* 448 */         if (arrayOfObject[m] == null) {
/* 449 */           arrayOfObject[m] = object;
/*     */         } else {
/*     */           k++; continue;
/*     */         } 
/*     */       } 
/* 454 */     }  return arrayOfObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class a<E>
/*     */     extends bd.a<E>
/*     */   {
/*     */     private bt.f<E> a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean aG;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a() {
/* 480 */       this(4);
/*     */     }
/*     */     
/*     */     a(int param1Int) {
/* 484 */       this.a = new bt.d<>(param1Int);
/*     */     }
/*     */     
/*     */     a(boolean param1Boolean) {
/* 488 */       this.a = null;
/*     */     }
/*     */     
/*     */     @com.google.a.a.d
/*     */     void fd() {
/* 493 */       this.a = new bt.c<>(this.a);
/*     */     }
/*     */     
/*     */     final void fe() {
/* 497 */       if (this.aG) {
/* 498 */         ff();
/* 499 */         this.aG = false;
/*     */       } 
/*     */     }
/*     */     
/*     */     void ff() {
/* 504 */       this.a = this.a.a();
/*     */     }
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<E> a(E param1E) {
/* 510 */       D.checkNotNull(param1E);
/* 511 */       fe();
/* 512 */       this.a = this.a.a(param1E);
/* 513 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<E> a(E... param1VarArgs) {
/* 519 */       super.a(param1VarArgs);
/* 520 */       return this;
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
/*     */     @com.google.b.a.a
/*     */     public a<E> a(Iterable<? extends E> param1Iterable) {
/* 534 */       super.a(param1Iterable);
/* 535 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<E> a(Iterator<? extends E> param1Iterator) {
/* 541 */       super.a(param1Iterator);
/* 542 */       return this;
/*     */     }
/*     */     
/*     */     a<E> a(a<E> param1a) {
/* 546 */       fe();
/* 547 */       this.a = this.a.a(param1a.a);
/* 548 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public bt<E> o() {
/* 553 */       this.aG = true;
/* 554 */       this.a = this.a.b();
/* 555 */       return this.a.o();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static abstract class f<E>
/*     */   {
/*     */     E[] f;
/*     */     int eF;
/*     */     
/*     */     f(int param1Int) {
/* 566 */       this.f = (E[])new Object[param1Int];
/* 567 */       this.eF = 0;
/*     */     }
/*     */ 
/*     */     
/*     */     f(f<E> param1f) {
/* 572 */       this.f = Arrays.copyOf(param1f.f, param1f.f.length);
/* 573 */       this.eF = param1f.eF;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void ensureCapacity(int param1Int) {
/* 581 */       if (param1Int > this.f.length) {
/*     */         
/* 583 */         int i = bd.a.h(this.f.length, param1Int);
/* 584 */         this.f = Arrays.copyOf(this.f, i);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     final void l(E param1E) {
/* 590 */       ensureCapacity(this.eF + 1);
/* 591 */       this.f[this.eF++] = param1E;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     abstract f<E> a(E param1E);
/*     */ 
/*     */ 
/*     */     
/*     */     final f<E> a(f<E> param1f) {
/* 602 */       f<E> f1 = this;
/* 603 */       for (byte b = 0; b < param1f.eF; b++) {
/* 604 */         f1 = f1.a(param1f.f[b]);
/*     */       }
/* 606 */       return f1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     abstract f<E> a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     f<E> b() {
/* 620 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     abstract bt<E> o();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.d
/*     */   static int e(int paramInt) {
/* 642 */     paramInt = Math.max(paramInt, 2);
/*     */     
/* 644 */     if (paramInt < 751619276) {
/*     */       
/* 646 */       int i = Integer.highestOneBit(paramInt - 1) << 1;
/* 647 */       while (i * 0.7D < paramInt) {
/* 648 */         i <<= 1;
/*     */       }
/* 650 */       return i;
/*     */     } 
/*     */ 
/*     */     
/* 654 */     D.a((paramInt < 1073741824), "collection too large");
/* 655 */     return 1073741824;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean a(Object[] paramArrayOfObject) {
/* 697 */     int i = q(paramArrayOfObject.length);
/*     */     
/*     */     byte b;
/*     */     
/* 701 */     for (b = 0; b < paramArrayOfObject.length && 
/* 702 */       paramArrayOfObject[b] != null; ) {
/*     */ 
/*     */       
/* 705 */       b++;
/* 706 */       if (b > i) {
/* 707 */         return true;
/*     */       }
/*     */     } 
/*     */     int j;
/* 711 */     for (j = paramArrayOfObject.length - 1; j > b && 
/* 712 */       paramArrayOfObject[j] != null; j--) {
/*     */ 
/*     */       
/* 715 */       if (b + paramArrayOfObject.length - 1 - j > i) {
/* 716 */         return true;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 722 */     int k = i / 2;
/*     */     int m;
/* 724 */     for (m = b + 1; m + k <= j; m += k) {
/* 725 */       byte b1 = 0; while (true) { if (b1 < k) {
/* 726 */           if (paramArrayOfObject[m + b1] == null)
/*     */             break;  b1++;
/*     */           continue;
/*     */         } 
/* 730 */         return true; }
/*     */     
/* 732 */     }  return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int q(int paramInt) {
/* 741 */     return 13 * com.google.a.k.e.a(paramInt, RoundingMode.UNNECESSARY);
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract dj<E> b();
/*     */ 
/*     */   
/*     */   private static final class d<E>
/*     */     extends f<E>
/*     */   {
/*     */     private Object[] e;
/*     */     
/*     */     private int eD;
/*     */     
/*     */     private int eE;
/*     */     private int hashCode;
/*     */     
/*     */     d(int param1Int) {
/* 759 */       super(param1Int);
/* 760 */       int i = bt.e(param1Int);
/* 761 */       this.e = new Object[i];
/* 762 */       this.eD = bt.r(i);
/* 763 */       this.eE = (int)(0.7D * i);
/*     */     }
/*     */     
/*     */     d(d<E> param1d) {
/* 767 */       super(param1d);
/* 768 */       this.e = Arrays.copyOf(param1d.e, param1d.e.length);
/* 769 */       this.eD = param1d.eD;
/* 770 */       this.eE = param1d.eE;
/* 771 */       this.hashCode = param1d.hashCode;
/*     */     }
/*     */     
/*     */     void aB(int param1Int) {
/* 775 */       if (param1Int > this.eE && this.e.length < 1073741824) {
/* 776 */         int i = this.e.length * 2;
/* 777 */         this.e = bt.a(i, (Object[])this.f, this.eF);
/* 778 */         this.eD = bt.r(i);
/* 779 */         this.eE = (int)(0.7D * i);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     bt.f<E> a(E param1E) {
/* 785 */       D.checkNotNull(param1E);
/* 786 */       int i = param1E.hashCode();
/* 787 */       int j = aY.d(i);
/* 788 */       int k = this.e.length - 1;
/* 789 */       for (int m = j; m - j < this.eD; m++) {
/* 790 */         int n = m & k;
/* 791 */         Object object = this.e[n];
/* 792 */         if (object == null) {
/* 793 */           l(param1E);
/* 794 */           this.e[n] = param1E;
/* 795 */           this.hashCode += i;
/* 796 */           aB(this.eF);
/* 797 */           return this;
/* 798 */         }  if (object.equals(param1E)) {
/* 799 */           return this;
/*     */         }
/*     */       } 
/*     */       
/* 803 */       return (new bt.c<>(this)).a(param1E);
/*     */     }
/*     */ 
/*     */     
/*     */     bt.f<E> a() {
/* 808 */       return new d(this);
/*     */     }
/*     */ 
/*     */     
/*     */     bt.f<E> b() {
/* 813 */       int i = bt.e(this.eF);
/* 814 */       if (i * 2 < this.e.length) {
/* 815 */         this.e = bt.a(i, (Object[])this.f, this.eF);
/* 816 */         this.eD = bt.r(i);
/* 817 */         this.eE = (int)(0.7D * i);
/*     */       } 
/* 819 */       return bt.a(this.e) ? new bt.c<>(this) : this;
/*     */     }
/*     */ 
/*     */     
/*     */     bt<E> o() {
/* 824 */       switch (this.eF) {
/*     */         case 0:
/* 826 */           return bt.n();
/*     */         case 1:
/* 828 */           return bt.b(this.f[0]);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 833 */       Object[] arrayOfObject = (Object[])((this.eF == this.f.length) ? (Object)this.f : Arrays.<Object>copyOf((Object[])this.f, this.eF));
/* 834 */       return new cx<>(arrayOfObject, this.hashCode, this.e, this.e.length - 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class c<E>
/*     */     extends f<E>
/*     */   {
/*     */     private final Set<Object> n;
/*     */ 
/*     */     
/*     */     c(bt.f<E> param1f) {
/* 846 */       super(param1f);
/* 847 */       this.n = cG.a(this.eF);
/* 848 */       for (byte b = 0; b < this.eF; b++) {
/* 849 */         this.n.add(this.f[b]);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     bt.f<E> a(E param1E) {
/* 855 */       D.checkNotNull(param1E);
/* 856 */       if (this.n.add(param1E)) {
/* 857 */         l(param1E);
/*     */       }
/* 859 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     bt.f<E> a() {
/* 864 */       return new c(this);
/*     */     }
/*     */ 
/*     */     
/*     */     bt<E> o() {
/* 869 */       switch (this.eF) {
/*     */         case 0:
/* 871 */           return bt.n();
/*     */         case 1:
/* 873 */           return bt.b(this.f[0]);
/*     */       } 
/* 875 */       return new bL<>(this.n, 
/* 876 */           bh.a((Object[])this.f, this.eF));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\bt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */