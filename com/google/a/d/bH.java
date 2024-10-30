/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import java.io.InvalidObjectException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.RandomAccess;
/*     */ import java.util.Spliterator;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.function.UnaryOperator;
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
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public abstract class bh<E>
/*     */   extends bd<E>
/*     */   implements List<E>, RandomAccess
/*     */ {
/*     */   public static <E> Collector<E, ?, bh<E>> a() {
/*  71 */     return B.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bh<E> e() {
/*  82 */     return (bh)cu.n;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bh<E> a(E paramE) {
/*  93 */     return new cI<>(paramE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bh<E> a(E paramE1, E paramE2) {
/* 102 */     return b(new Object[] { paramE1, paramE2 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bh<E> a(E paramE1, E paramE2, E paramE3) {
/* 111 */     return b(new Object[] { paramE1, paramE2, paramE3 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bh<E> a(E paramE1, E paramE2, E paramE3, E paramE4) {
/* 120 */     return b(new Object[] { paramE1, paramE2, paramE3, paramE4 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bh<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5) {
/* 129 */     return b(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bh<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6) {
/* 138 */     return b(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bh<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7) {
/* 147 */     return b(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bh<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8) {
/* 156 */     return b(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7, paramE8 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bh<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8, E paramE9) {
/* 165 */     return b(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7, paramE8, paramE9 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bh<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8, E paramE9, E paramE10) {
/* 175 */     return b(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7, paramE8, paramE9, paramE10 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bh<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8, E paramE9, E paramE10, E paramE11) {
/* 185 */     return b(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7, paramE8, paramE9, paramE10, paramE11 });
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
/*     */   @SafeVarargs
/*     */   public static <E> bh<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8, E paramE9, E paramE10, E paramE11, E paramE12, E... paramVarArgs) {
/* 202 */     D.a((paramVarArgs.length <= 2147483635), "the total number of elements must fit in an int");
/*     */     
/* 204 */     Object[] arrayOfObject = new Object[12 + paramVarArgs.length];
/* 205 */     arrayOfObject[0] = paramE1;
/* 206 */     arrayOfObject[1] = paramE2;
/* 207 */     arrayOfObject[2] = paramE3;
/* 208 */     arrayOfObject[3] = paramE4;
/* 209 */     arrayOfObject[4] = paramE5;
/* 210 */     arrayOfObject[5] = paramE6;
/* 211 */     arrayOfObject[6] = paramE7;
/* 212 */     arrayOfObject[7] = paramE8;
/* 213 */     arrayOfObject[8] = paramE9;
/* 214 */     arrayOfObject[9] = paramE10;
/* 215 */     arrayOfObject[10] = paramE11;
/* 216 */     arrayOfObject[11] = paramE12;
/* 217 */     System.arraycopy(paramVarArgs, 0, arrayOfObject, 12, paramVarArgs.length);
/* 218 */     return b(arrayOfObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bh<E> b(Iterable<? extends E> paramIterable) {
/* 229 */     D.checkNotNull(paramIterable);
/* 230 */     return (paramIterable instanceof Collection) ? 
/* 231 */       a((Collection<? extends E>)paramIterable) : 
/* 232 */       a(paramIterable.iterator());
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
/*     */   public static <E> bh<E> a(Collection<? extends E> paramCollection) {
/* 253 */     if (paramCollection instanceof bd) {
/*     */       
/* 255 */       bh<E> bh1 = ((bd)paramCollection).c();
/* 256 */       return bh1.cO() ? c(bh1.toArray()) : bh1;
/*     */     } 
/* 258 */     return b(paramCollection.toArray());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bh<E> a(Iterator<? extends E> paramIterator) {
/* 268 */     if (!paramIterator.hasNext()) {
/* 269 */       return e();
/*     */     }
/* 271 */     E e = paramIterator.next();
/* 272 */     if (!paramIterator.hasNext()) {
/* 273 */       return a(e);
/*     */     }
/* 275 */     return (new a<>()).a(e).a(paramIterator).g();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> bh<E> a(E[] paramArrayOfE) {
/* 286 */     switch (paramArrayOfE.length) {
/*     */       case 0:
/* 288 */         return e();
/*     */       case 1:
/* 290 */         return a(paramArrayOfE[0]);
/*     */     } 
/* 292 */     return b((Object[])paramArrayOfE.clone());
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
/*     */   public static <E extends Comparable<? super E>> bh<E> c(Iterable<? extends E> paramIterable) {
/* 313 */     Comparable[] arrayOfComparable = bG.<Comparable>a(paramIterable, new Comparable[0]);
/* 314 */     ci.b((Object[])arrayOfComparable);
/* 315 */     Arrays.sort((Object[])arrayOfComparable);
/* 316 */     return c((Object[])arrayOfComparable);
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
/*     */   public static <E> bh<E> a(Comparator<? super E> paramComparator, Iterable<? extends E> paramIterable) {
/* 336 */     D.checkNotNull(paramComparator);
/*     */     
/* 338 */     Object[] arrayOfObject = bG.a(paramIterable);
/* 339 */     ci.b(arrayOfObject);
/* 340 */     Arrays.sort(arrayOfObject, (Comparator)paramComparator);
/* 341 */     return c(arrayOfObject);
/*     */   }
/*     */ 
/*     */   
/*     */   private static <E> bh<E> b(Object... paramVarArgs) {
/* 346 */     return c(ci.b(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static <E> bh<E> c(Object[] paramArrayOfObject) {
/* 355 */     return a(paramArrayOfObject, paramArrayOfObject.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static <E> bh<E> a(Object[] paramArrayOfObject, int paramInt) {
/* 363 */     switch (paramInt) {
/*     */       case 0:
/* 365 */         return e();
/*     */       case 1:
/* 367 */         return a((E)paramArrayOfObject[0]);
/*     */     } 
/* 369 */     if (paramInt < paramArrayOfObject.length) {
/* 370 */       paramArrayOfObject = Arrays.copyOf(paramArrayOfObject, paramInt);
/*     */     }
/* 372 */     return new cu<>(paramArrayOfObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public dj<E> b() {
/* 382 */     return a();
/*     */   }
/*     */ 
/*     */   
/*     */   public dk<E> a() {
/* 387 */     return a(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public dk<E> a(int paramInt) {
/* 392 */     return new b<E>(this, size(), paramInt)
/*     */       {
/*     */         protected E get(int param1Int) {
/* 395 */           return this.e.get(param1Int);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public void forEach(Consumer<? super E> paramConsumer) {
/* 402 */     D.checkNotNull(paramConsumer);
/* 403 */     int i = size();
/* 404 */     for (byte b = 0; b < i; b++) {
/* 405 */       paramConsumer.accept(get(b));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int indexOf(Object paramObject) {
/* 411 */     return (paramObject == null) ? -1 : bS.a(this, paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int lastIndexOf(Object paramObject) {
/* 416 */     return (paramObject == null) ? -1 : bS.c(this, paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(Object paramObject) {
/* 421 */     return (indexOf(paramObject) >= 0);
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
/*     */   public bh<E> a(int paramInt1, int paramInt2) {
/* 433 */     D.a(paramInt1, paramInt2, size());
/* 434 */     int i = paramInt2 - paramInt1;
/* 435 */     if (i == size())
/* 436 */       return this; 
/* 437 */     if (i == 0)
/* 438 */       return e(); 
/* 439 */     if (i == 1) {
/* 440 */       return a(get(paramInt1));
/*     */     }
/* 442 */     return b(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   bh<E> b(int paramInt1, int paramInt2) {
/* 451 */     return new d(this, paramInt1, paramInt2 - paramInt1);
/*     */   }
/*     */   
/*     */   class d extends bh<E> {
/*     */     final transient int offset;
/*     */     final transient int length;
/*     */     
/*     */     d(bh this$0, int param1Int1, int param1Int2) {
/* 459 */       this.offset = param1Int1;
/* 460 */       this.length = param1Int2;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 465 */       return this.length;
/*     */     }
/*     */ 
/*     */     
/*     */     public E get(int param1Int) {
/* 470 */       D.b(param1Int, this.length);
/* 471 */       return this.e.get(param1Int + this.offset);
/*     */     }
/*     */ 
/*     */     
/*     */     public bh<E> a(int param1Int1, int param1Int2) {
/* 476 */       D.a(param1Int1, param1Int2, this.length);
/* 477 */       return this.e.a(param1Int1 + this.offset, param1Int2 + this.offset);
/*     */     }
/*     */ 
/*     */     
/*     */     boolean cO() {
/* 482 */       return true;
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
/*     */   @Deprecated
/*     */   @com.google.b.a.a
/*     */   public final boolean addAll(int paramInt, Collection<? extends E> paramCollection) {
/* 496 */     throw new UnsupportedOperationException();
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
/*     */   @com.google.b.a.a
/*     */   public final E set(int paramInt, E paramE) {
/* 509 */     throw new UnsupportedOperationException();
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
/*     */   public final void add(int paramInt, E paramE) {
/* 521 */     throw new UnsupportedOperationException();
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
/*     */   @com.google.b.a.a
/*     */   public final E remove(int paramInt) {
/* 534 */     throw new UnsupportedOperationException();
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
/*     */   public final void replaceAll(UnaryOperator<E> paramUnaryOperator) {
/* 546 */     throw new UnsupportedOperationException();
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
/*     */   public final void sort(Comparator<? super E> paramComparator) {
/* 558 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final bh<E> c() {
/* 568 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Spliterator<E> spliterator() {
/* 573 */     return D.a(size(), 1296, this::get);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   int a(Object[] paramArrayOfObject, int paramInt) {
/* 579 */     int i = size();
/* 580 */     for (byte b = 0; b < i; b++) {
/* 581 */       paramArrayOfObject[paramInt + b] = get(b);
/*     */     }
/* 583 */     return paramInt + i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public bh<E> f() {
/* 594 */     return (size() <= 1) ? this : new b<>(this);
/*     */   }
/*     */   
/*     */   private static class b<E> extends bh<E> {
/*     */     private final transient bh<E> f;
/*     */     
/*     */     b(bh<E> param1bh) {
/* 601 */       this.f = param1bh;
/*     */     }
/*     */     
/*     */     private int o(int param1Int) {
/* 605 */       return size() - 1 - param1Int;
/*     */     }
/*     */     
/*     */     private int p(int param1Int) {
/* 609 */       return size() - param1Int;
/*     */     }
/*     */ 
/*     */     
/*     */     public bh<E> f() {
/* 614 */       return this.f;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 619 */       return this.f.contains(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public int indexOf(Object param1Object) {
/* 624 */       int i = this.f.lastIndexOf(param1Object);
/* 625 */       return (i >= 0) ? o(i) : -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public int lastIndexOf(Object param1Object) {
/* 630 */       int i = this.f.indexOf(param1Object);
/* 631 */       return (i >= 0) ? o(i) : -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public bh<E> a(int param1Int1, int param1Int2) {
/* 636 */       D.a(param1Int1, param1Int2, size());
/* 637 */       return this.f.a(p(param1Int2), p(param1Int1)).f();
/*     */     }
/*     */ 
/*     */     
/*     */     public E get(int param1Int) {
/* 642 */       D.b(param1Int, size());
/* 643 */       return this.f.get(o(param1Int));
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 648 */       return this.f.size();
/*     */     }
/*     */ 
/*     */     
/*     */     boolean cO() {
/* 653 */       return this.f.cO();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 659 */     return bS.a(this, paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 664 */     int i = 1;
/* 665 */     int j = size();
/* 666 */     for (byte b = 0; b < j; b++) {
/* 667 */       i = 31 * i + get(b).hashCode();
/*     */       
/* 669 */       i = i ^ 0xFFFFFFFF ^ 0xFFFFFFFF;
/*     */     } 
/*     */     
/* 672 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   static class c
/*     */     implements Serializable
/*     */   {
/*     */     final Object[] elements;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     c(Object[] param1ArrayOfObject) {
/* 683 */       this.elements = param1ArrayOfObject;
/*     */     }
/*     */     
/*     */     Object readResolve() {
/* 687 */       return bh.a(this.elements);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws InvalidObjectException {
/* 694 */     throw new InvalidObjectException("Use SerializedForm");
/*     */   }
/*     */ 
/*     */   
/*     */   Object writeReplace() {
/* 699 */     return new c(toArray());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> a<E> a() {
/* 707 */     return new a<>();
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
/* 724 */     C.b(paramInt, "expectedSize");
/* 725 */     return new a<>(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class a<E>
/*     */     extends bd.a<E>
/*     */   {
/*     */     @com.google.a.a.d
/*     */     Object[] d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int size;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean aG;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a() {
/* 758 */       this(4);
/*     */     }
/*     */     
/*     */     a(int param1Int) {
/* 762 */       this.d = new Object[param1Int];
/* 763 */       this.size = 0;
/*     */     }
/*     */     
/*     */     private void aA(int param1Int) {
/* 767 */       if (this.d.length < param1Int) {
/* 768 */         this.d = Arrays.copyOf(this.d, h(this.d.length, param1Int));
/* 769 */         this.aG = false;
/* 770 */       } else if (this.aG) {
/* 771 */         this.d = Arrays.copyOf(this.d, this.d.length);
/* 772 */         this.aG = false;
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
/*     */     @com.google.b.a.a
/*     */     public a<E> a(E param1E) {
/* 786 */       D.checkNotNull(param1E);
/* 787 */       aA(this.size + 1);
/* 788 */       this.d[this.size++] = param1E;
/* 789 */       return this;
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
/*     */     @com.google.b.a.a
/*     */     public a<E> a(E... param1VarArgs) {
/* 802 */       ci.b((Object[])param1VarArgs);
/* 803 */       a((Object[])param1VarArgs, param1VarArgs.length);
/* 804 */       return this;
/*     */     }
/*     */     
/*     */     private void a(Object[] param1ArrayOfObject, int param1Int) {
/* 808 */       aA(this.size + param1Int);
/* 809 */       System.arraycopy(param1ArrayOfObject, 0, this.d, this.size, param1Int);
/* 810 */       this.size += param1Int;
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
/*     */     @com.google.b.a.a
/*     */     public a<E> a(Iterable<? extends E> param1Iterable) {
/* 823 */       D.checkNotNull(param1Iterable);
/* 824 */       if (param1Iterable instanceof Collection) {
/* 825 */         Collection collection = (Collection)param1Iterable;
/* 826 */         aA(this.size + collection.size());
/* 827 */         if (collection instanceof bd) {
/* 828 */           bd bd = (bd)collection;
/* 829 */           this.size = bd.a(this.d, this.size);
/* 830 */           return this;
/*     */         } 
/*     */       } 
/* 833 */       super.a(param1Iterable);
/* 834 */       return this;
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
/*     */     @com.google.b.a.a
/*     */     public a<E> a(Iterator<? extends E> param1Iterator) {
/* 847 */       super.a(param1Iterator);
/* 848 */       return this;
/*     */     }
/*     */     
/*     */     @com.google.b.a.a
/*     */     a<E> a(a<E> param1a) {
/* 853 */       D.checkNotNull(param1a);
/* 854 */       a(param1a.d, param1a.size);
/* 855 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public bh<E> g() {
/* 863 */       this.aG = true;
/* 864 */       return bh.a(this.d, this.size);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\bh.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */