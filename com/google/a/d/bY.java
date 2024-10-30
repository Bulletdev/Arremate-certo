/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.NavigableSet;
/*     */ import java.util.Set;
/*     */ import java.util.SortedSet;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.ToIntFunction;
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
/*     */ @c
/*     */ public abstract class by<E>
/*     */   extends bz<E>
/*     */   implements cP<E>
/*     */ {
/*     */   @com.google.b.a.a.b
/*     */   transient by<E> b;
/*     */   
/*     */   public static <E> Collector<E, ?, by<E>> b(Comparator<? super E> paramComparator) {
/*  66 */     return a(paramComparator, (Function)Function.identity(), paramObject -> 1);
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
/*     */   public static <T, E> Collector<T, ?, by<E>> a(Comparator<? super E> paramComparator, Function<? super T, ? extends E> paramFunction, ToIntFunction<? super T> paramToIntFunction) {
/*  84 */     D.checkNotNull(paramComparator);
/*  85 */     D.checkNotNull(paramFunction);
/*  86 */     D.checkNotNull(paramToIntFunction);
/*  87 */     return Collector.of(() -> df.a(paramComparator), (paramcc, paramObject) -> paramcc.add(D.checkNotNull(paramFunction.apply(paramObject)), paramToIntFunction.applyAsInt(paramObject)), (paramcc1, paramcc2) -> { paramcc1.addAll(paramcc2); return paramcc1; }paramcc -> a(paramComparator, paramcc.entrySet()), new Collector.Characteristics[0]);
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
/*     */   public static <E> by<E> b() {
/* 101 */     return (by<E>)cy.c;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E extends Comparable<? super E>> by<E> a(E paramE) {
/* 107 */     cz<E> cz = (cz)bA.<E>a(paramE);
/* 108 */     long[] arrayOfLong = { 0L, 1L };
/* 109 */     return new cy<>(cz, arrayOfLong, 0, 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E extends Comparable<? super E>> by<E> a(E paramE1, E paramE2) {
/* 120 */     return a(cj.e(), Arrays.asList((E[])new Comparable[] { (Comparable)paramE1, (Comparable)paramE2 }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E extends Comparable<? super E>> by<E> a(E paramE1, E paramE2, E paramE3) {
/* 131 */     return a(cj.e(), Arrays.asList((E[])new Comparable[] { (Comparable)paramE1, (Comparable)paramE2, (Comparable)paramE3 }));
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
/*     */   public static <E extends Comparable<? super E>> by<E> a(E paramE1, E paramE2, E paramE3, E paramE4) {
/* 143 */     return a(cj.e(), Arrays.asList((E[])new Comparable[] { (Comparable)paramE1, (Comparable)paramE2, (Comparable)paramE3, (Comparable)paramE4 }));
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
/*     */   public static <E extends Comparable<? super E>> by<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5) {
/* 155 */     return a(cj.e(), Arrays.asList((E[])new Comparable[] { (Comparable)paramE1, (Comparable)paramE2, (Comparable)paramE3, (Comparable)paramE4, (Comparable)paramE5 }));
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
/*     */   public static <E extends Comparable<? super E>> by<E> a(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E... paramVarArgs) {
/* 167 */     int i = paramVarArgs.length + 6;
/* 168 */     ArrayList<?> arrayList = bS.a(i);
/* 169 */     Collections.addAll(arrayList, (Object[])new Comparable[] { (Comparable)paramE1, (Comparable)paramE2, (Comparable)paramE3, (Comparable)paramE4, (Comparable)paramE5, (Comparable)paramE6 });
/* 170 */     Collections.addAll(arrayList, (Object[])paramVarArgs);
/* 171 */     return a(cj.e(), (Iterable)arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E extends Comparable<? super E>> by<E> a(E[] paramArrayOfE) {
/* 181 */     return a(cj.e(), Arrays.asList(paramArrayOfE));
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
/*     */   public static <E> by<E> a(Iterable<? extends E> paramIterable) {
/* 209 */     cj<Comparable> cj = cj.e();
/* 210 */     return a((Comparator)cj, paramIterable);
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
/*     */   public static <E> by<E> a(Iterator<? extends E> paramIterator) {
/* 227 */     cj<Comparable> cj = cj.e();
/* 228 */     return a((Comparator)cj, paramIterator);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <E> by<E> a(Comparator<? super E> paramComparator, Iterator<? extends E> paramIterator) {
/* 239 */     D.checkNotNull(paramComparator);
/* 240 */     return (new a<>(paramComparator)).a(paramIterator).c();
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
/*     */   public static <E> by<E> a(Comparator<? super E> paramComparator, Iterable<? extends E> paramIterable) {
/* 255 */     if (paramIterable instanceof by) {
/*     */       
/* 257 */       by<E> by1 = (by)paramIterable;
/* 258 */       if (paramComparator.equals(by1.comparator())) {
/* 259 */         if (by1.cO()) {
/* 260 */           return a(paramComparator, by1.h().c());
/*     */         }
/* 262 */         return by1;
/*     */       } 
/*     */     } 
/*     */     
/* 266 */     paramIterable = bS.a(paramIterable);
/* 267 */     df<?> df = df.a((Comparator)D.checkNotNull(paramComparator));
/* 268 */     bG.addAll(df, paramIterable);
/* 269 */     return a(paramComparator, df.entrySet());
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
/*     */   public static <E> by<E> a(cP<E> paramcP) {
/* 287 */     return a(paramcP
/* 288 */         .comparator(), bS.a(paramcP.entrySet()));
/*     */   }
/*     */ 
/*     */   
/*     */   private static <E> by<E> a(Comparator<? super E> paramComparator, Collection<cc.a<E>> paramCollection) {
/* 293 */     if (paramCollection.isEmpty()) {
/* 294 */       return a(paramComparator);
/*     */     }
/* 296 */     bh.a<E> a = new bh.a(paramCollection.size());
/* 297 */     long[] arrayOfLong = new long[paramCollection.size() + 1];
/* 298 */     byte b = 0;
/* 299 */     for (cc.a<E> a1 : paramCollection) {
/* 300 */       a.a(a1.getElement());
/* 301 */       arrayOfLong[b + 1] = arrayOfLong[b] + a1.getCount();
/* 302 */       b++;
/*     */     } 
/* 304 */     return new cy<>(new cz<>(a
/* 305 */           .g(), paramComparator), arrayOfLong, 0, paramCollection
/*     */ 
/*     */         
/* 308 */         .size());
/*     */   }
/*     */ 
/*     */   
/*     */   static <E> by<E> a(Comparator<? super E> paramComparator) {
/* 313 */     if (cj.<Comparable>e().equals(paramComparator)) {
/* 314 */       return (by<E>)cy.c;
/*     */     }
/* 316 */     return new cy<>(paramComparator);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Comparator<? super E> comparator() {
/* 324 */     return b().comparator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public by<E> a() {
/* 334 */     by<E> by1 = this.b;
/* 335 */     if (by1 == null) {
/* 336 */       return this
/*     */ 
/*     */         
/* 339 */         .b = isEmpty() ? a(cj.b(comparator()).a()) : new V<>(this);
/*     */     }
/* 341 */     return by1;
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
/*     */   @Deprecated
/*     */   @com.google.b.a.a
/*     */   public final cc.a<E> d() {
/* 356 */     throw new UnsupportedOperationException();
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
/*     */   @Deprecated
/*     */   @com.google.b.a.a
/*     */   public final cc.a<E> e() {
/* 371 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public by<E> a(E paramE1, x paramx1, E paramE2, x paramx2) {
/* 380 */     D.a(
/* 381 */         (comparator().compare(paramE1, paramE2) <= 0), "Expected lowerBound <= upperBound but %s > %s", paramE1, paramE2);
/*     */ 
/*     */ 
/*     */     
/* 385 */     return b(paramE1, paramx1).a(paramE2, paramx2);
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
/*     */   public static <E> a<E> a(Comparator<E> paramComparator) {
/* 400 */     return new a<>(paramComparator);
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
/*     */   public static <E extends Comparable<?>> a<E> a() {
/* 412 */     return new a<>(cj.<Comparable>e().a());
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
/*     */   public static <E extends Comparable<?>> a<E> b() {
/* 426 */     return new a<>(cj.e());
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
/*     */   public static class a<E>
/*     */     extends bp.a<E>
/*     */   {
/*     */     public a(Comparator<? super E> param1Comparator) {
/* 454 */       super(df.a((Comparator<? super E>)D.checkNotNull(param1Comparator)));
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
/* 467 */       super.a(param1E);
/* 468 */       return this;
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
/* 481 */       super.a(param1VarArgs);
/* 482 */       return this;
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
/*     */     @com.google.b.a.a
/*     */     public a<E> a(E param1E, int param1Int) {
/* 499 */       super.a(param1E, param1Int);
/* 500 */       return this;
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
/*     */     @com.google.b.a.a
/*     */     public a<E> b(E param1E, int param1Int) {
/* 516 */       super.b(param1E, param1Int);
/* 517 */       return this;
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
/* 530 */       super.a(param1Iterable);
/* 531 */       return this;
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
/* 544 */       super.a(param1Iterator);
/* 545 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public by<E> c() {
/* 554 */       return by.a((cP<E>)this.b);
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class b<E>
/*     */     implements Serializable {
/*     */     final Comparator<? super E> comparator;
/*     */     final E[] elements;
/*     */     final int[] O;
/*     */     
/*     */     b(cP<E> param1cP) {
/* 565 */       this.comparator = param1cP.comparator();
/* 566 */       int i = param1cP.entrySet().size();
/* 567 */       this.elements = (E[])new Object[i];
/* 568 */       this.O = new int[i];
/* 569 */       byte b1 = 0;
/* 570 */       for (cc.a<E> a : param1cP.entrySet()) {
/* 571 */         this.elements[b1] = a.getElement();
/* 572 */         this.O[b1] = a.getCount();
/* 573 */         b1++;
/*     */       } 
/*     */     }
/*     */     
/*     */     Object readResolve() {
/* 578 */       int i = this.elements.length;
/* 579 */       by.a<E> a = new by.a<>(this.comparator);
/* 580 */       for (byte b1 = 0; b1 < i; b1++) {
/* 581 */         a.a(this.elements[b1], this.O[b1]);
/*     */       }
/* 583 */       return a.c();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   Object writeReplace() {
/* 589 */     return new b(this);
/*     */   }
/*     */   
/*     */   public abstract bA<E> b();
/*     */   
/*     */   public abstract by<E> a(E paramE, x paramx);
/*     */   
/*     */   public abstract by<E> b(E paramE, x paramx);
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\by.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */