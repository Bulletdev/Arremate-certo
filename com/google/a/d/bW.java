/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import java.util.AbstractMap;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.NavigableSet;
/*     */ import java.util.Set;
/*     */ import java.util.SortedMap;
/*     */ import java.util.Spliterator;
/*     */ import java.util.TreeMap;
/*     */ import java.util.function.BiConsumer;
/*     */ import java.util.function.BinaryOperator;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.function.Function;
/*     */ import java.util.stream.Collector;
/*     */ import java.util.stream.Collectors;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class bw<K, V>
/*     */   extends bx<K, V>
/*     */   implements NavigableMap<K, V>
/*     */ {
/*     */   public static <T, K, V> Collector<T, ?, bw<K, V>> a(Comparator<? super K> paramComparator, Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1) {
/*  79 */     return B.a(paramComparator, paramFunction, paramFunction1);
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
/*     */   public static <T, K, V> Collector<T, ?, bw<K, V>> a(Comparator<? super K> paramComparator, Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1, BinaryOperator<V> paramBinaryOperator) {
/*  98 */     D.checkNotNull(paramComparator);
/*  99 */     D.checkNotNull(paramFunction);
/* 100 */     D.checkNotNull(paramFunction1);
/* 101 */     D.checkNotNull(paramBinaryOperator);
/* 102 */     return Collectors.collectingAndThen(
/* 103 */         Collectors.toMap(paramFunction, paramFunction1, paramBinaryOperator, () -> new TreeMap<>(paramComparator)), bw::a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 112 */   private static final Comparator<Comparable> NATURAL_ORDER = cj.e();
/*     */   
/* 114 */   private static final bw<Comparable, Object> a = new bw(
/*     */       
/* 116 */       bA.a(cj.e()), bh.e()); private final transient cz<K> a;
/*     */   
/*     */   static <K, V> bw<K, V> a(Comparator<? super K> paramComparator) {
/* 119 */     if (cj.<Comparable>e().equals(paramComparator)) {
/* 120 */       return a();
/*     */     }
/* 122 */     return new bw<>(
/* 123 */         bA.a(paramComparator), bh.e());
/*     */   }
/*     */ 
/*     */   
/*     */   private final transient bh<V> l;
/*     */   private transient bw<K, V> b;
/*     */   private static final long serialVersionUID = 0L;
/*     */   
/*     */   public static <K, V> bw<K, V> a() {
/* 132 */     return (bw)a;
/*     */   }
/*     */ 
/*     */   
/*     */   public static <K extends Comparable<? super K>, V> bw<K, V> a(K paramK, V paramV) {
/* 137 */     return a(cj.e(), paramK, paramV);
/*     */   }
/*     */ 
/*     */   
/*     */   private static <K, V> bw<K, V> a(Comparator<? super K> paramComparator, K paramK, V paramV) {
/* 142 */     return new bw<>(new cz<>(
/* 143 */           bh.a(paramK), (Comparator<? super K>)D.checkNotNull(paramComparator)), 
/* 144 */         bh.a(paramV));
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
/*     */   public static <K extends Comparable<? super K>, V> bw<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2) {
/* 156 */     return a((Map.Entry<K, V>[])new Map.Entry[] { c(paramK1, paramV1), c(paramK2, paramV2) });
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
/*     */   public static <K extends Comparable<? super K>, V> bw<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3) {
/* 168 */     return a((Map.Entry<K, V>[])new Map.Entry[] { c(paramK1, paramV1), c(paramK2, paramV2), c(paramK3, paramV3) });
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
/*     */   public static <K extends Comparable<? super K>, V> bw<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4) {
/* 180 */     return a((Map.Entry<K, V>[])new Map.Entry[] { c(paramK1, paramV1), c(paramK2, paramV2), c(paramK3, paramV3), c(paramK4, paramV4) });
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
/*     */   public static <K extends Comparable<? super K>, V> bw<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5) {
/* 192 */     return a((Map.Entry<K, V>[])new Map.Entry[] {
/* 193 */           c(paramK1, paramV1), c(paramK2, paramV2), c(paramK3, paramV3), c(paramK4, paramV4), c(paramK5, paramV5)
/*     */         });
/*     */   }
/*     */   
/*     */   private static <K extends Comparable<? super K>, V> bw<K, V> a(Map.Entry<K, V>... paramVarArgs) {
/* 198 */     return a(cj.e(), false, paramVarArgs, paramVarArgs.length);
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
/*     */   public static <K, V> bw<K, V> a(Map<? extends K, ? extends V> paramMap) {
/* 220 */     cj<? super K> cj = (cj)NATURAL_ORDER;
/* 221 */     return b(paramMap, cj);
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
/*     */   public static <K, V> bw<K, V> a(Map<? extends K, ? extends V> paramMap, Comparator<? super K> paramComparator) {
/* 237 */     return b(paramMap, (Comparator<? super K>)D.checkNotNull(paramComparator));
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
/*     */   @com.google.a.a.a
/*     */   public static <K, V> bw<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable) {
/* 257 */     cj<? super K> cj = (cj)NATURAL_ORDER;
/* 258 */     return a(paramIterable, cj);
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
/*     */   @com.google.a.a.a
/*     */   public static <K, V> bw<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable, Comparator<? super K> paramComparator) {
/* 273 */     return a((Comparator<? super K>)D.checkNotNull(paramComparator), false, paramIterable);
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
/*     */   public static <K, V> bw<K, V> a(SortedMap<K, ? extends V> paramSortedMap) {
/*     */     Comparator<Comparable> comparator;
/* 288 */     Comparator<? super K> comparator1 = paramSortedMap.comparator();
/* 289 */     if (comparator1 == null)
/*     */     {
/*     */       
/* 292 */       comparator = NATURAL_ORDER;
/*     */     }
/* 294 */     if (paramSortedMap instanceof bw) {
/*     */ 
/*     */ 
/*     */       
/* 298 */       bw<K, V> bw1 = (bw)paramSortedMap;
/* 299 */       if (!bw1.cO()) {
/* 300 */         return bw1;
/*     */       }
/*     */     } 
/* 303 */     return a((Comparator)comparator, true, paramSortedMap.entrySet());
/*     */   }
/*     */ 
/*     */   
/*     */   private static <K, V> bw<K, V> b(Map<? extends K, ? extends V> paramMap, Comparator<? super K> paramComparator) {
/* 308 */     boolean bool = false;
/* 309 */     if (paramMap instanceof SortedMap) {
/* 310 */       SortedMap sortedMap = (SortedMap)paramMap;
/* 311 */       Comparator comparator = sortedMap.comparator();
/*     */       
/* 313 */       bool = (comparator == null) ? ((paramComparator == NATURAL_ORDER) ? true : false) : paramComparator.equals(comparator);
/*     */     } 
/*     */     
/* 316 */     if (bool && paramMap instanceof bw) {
/*     */ 
/*     */ 
/*     */       
/* 320 */       bw<K, V> bw1 = (bw)paramMap;
/* 321 */       if (!bw1.cO()) {
/* 322 */         return bw1;
/*     */       }
/*     */     } 
/* 325 */     return a(paramComparator, bool, paramMap.entrySet());
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
/*     */   private static <K, V> bw<K, V> a(Comparator<? super K> paramComparator, boolean paramBoolean, Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable) {
/*     */     // Byte code:
/*     */     //   0: aload_2
/*     */     //   1: getstatic com/google/a/d/bw.a : [Ljava/util/Map$Entry;
/*     */     //   4: invokestatic a : (Ljava/lang/Iterable;[Ljava/lang/Object;)[Ljava/lang/Object;
/*     */     //   7: checkcast [Ljava/util/Map$Entry;
/*     */     //   10: astore_3
/*     */     //   11: aload_0
/*     */     //   12: iload_1
/*     */     //   13: aload_3
/*     */     //   14: aload_3
/*     */     //   15: arraylength
/*     */     //   16: invokestatic a : (Ljava/util/Comparator;Z[Ljava/util/Map$Entry;I)Lcom/google/a/d/bw;
/*     */     //   19: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #340	-> 0
/*     */     //   #341	-> 11
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
/*     */   private static <K, V> bw<K, V> a(final Comparator<? super K> comparator, boolean paramBoolean, Map.Entry<K, V>[] paramArrayOfEntry, int paramInt) {
/* 349 */     switch (paramInt) {
/*     */       case 0:
/* 351 */         return a(comparator);
/*     */       case 1:
/* 353 */         return a(comparator, paramArrayOfEntry[0]
/* 354 */             .getKey(), paramArrayOfEntry[0].getValue());
/*     */     } 
/* 356 */     Object[] arrayOfObject1 = new Object[paramInt];
/* 357 */     Object[] arrayOfObject2 = new Object[paramInt];
/* 358 */     if (paramBoolean) {
/*     */       
/* 360 */       for (byte b = 0; b < paramInt; b++) {
/* 361 */         K k = paramArrayOfEntry[b].getKey();
/* 362 */         V v = paramArrayOfEntry[b].getValue();
/* 363 */         C.a(k, v);
/* 364 */         arrayOfObject1[b] = k;
/* 365 */         arrayOfObject2[b] = v;
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 371 */       Arrays.sort(paramArrayOfEntry, 0, paramInt, new Comparator<Map.Entry<K, V>>()
/*     */           {
/*     */ 
/*     */ 
/*     */             
/*     */             public int b(Map.Entry<K, V> param1Entry1, Map.Entry<K, V> param1Entry2)
/*     */             {
/* 378 */               return comparator.compare(param1Entry1.getKey(), param1Entry2.getKey());
/*     */             }
/*     */           });
/* 381 */       K k = paramArrayOfEntry[0].getKey();
/* 382 */       arrayOfObject1[0] = k;
/* 383 */       arrayOfObject2[0] = paramArrayOfEntry[0].getValue();
/* 384 */       C.a(arrayOfObject1[0], arrayOfObject2[0]);
/* 385 */       for (byte b = 1; b < paramInt; b++) {
/* 386 */         K k2 = paramArrayOfEntry[b].getKey();
/* 387 */         V v = paramArrayOfEntry[b].getValue();
/* 388 */         C.a(k2, v);
/* 389 */         arrayOfObject1[b] = k2;
/* 390 */         arrayOfObject2[b] = v;
/* 391 */         a(
/* 392 */             (comparator.compare(k, k2) != 0), "key", paramArrayOfEntry[b - 1], paramArrayOfEntry[b]);
/* 393 */         K k1 = k2;
/*     */       } 
/*     */     } 
/* 396 */     return new bw<>(new cz<>(new cu<>(arrayOfObject1), comparator), new cu<>(arrayOfObject2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K extends Comparable<?>, V> b<K, V> a() {
/* 407 */     return new b<>(cj.e());
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
/*     */   public static <K, V> b<K, V> b(Comparator<K> paramComparator) {
/* 419 */     return new b<>(paramComparator);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K extends Comparable<?>, V> b<K, V> b() {
/* 427 */     return new b<>(cj.<Comparable>e().a());
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
/*     */   public static class b<K, V>
/*     */     extends bj.a<K, V>
/*     */   {
/*     */     private final Comparator<? super K> comparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b(Comparator<? super K> param1Comparator) {
/* 460 */       this.comparator = (Comparator<? super K>)D.checkNotNull(param1Comparator);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public b<K, V> a(K param1K, V param1V) {
/* 471 */       super.a(param1K, param1V);
/* 472 */       return this;
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
/*     */     public b<K, V> a(Map.Entry<? extends K, ? extends V> param1Entry) {
/* 485 */       super.a(param1Entry);
/* 486 */       return this;
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
/*     */     public b<K, V> a(Map<? extends K, ? extends V> param1Map) {
/* 499 */       super.a(param1Map);
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
/*     */     @com.google.b.a.a
/*     */     @com.google.a.a.a
/*     */     public b<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> param1Iterable) {
/* 515 */       super.a(param1Iterable);
/* 516 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Deprecated
/*     */     @com.google.b.a.a
/*     */     @com.google.a.a.a
/*     */     public b<K, V> c(Comparator<? super V> param1Comparator) {
/* 530 */       throw new UnsupportedOperationException("Not available on ImmutableSortedMap.Builder");
/*     */     }
/*     */ 
/*     */     
/*     */     b<K, V> a(bj.a<K, V> param1a) {
/* 535 */       super.a(param1a);
/* 536 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public bw<K, V> c() {
/* 547 */       switch (this.size) {
/*     */         case 0:
/* 549 */           return bw.a(this.comparator);
/*     */         case 1:
/* 551 */           return bw.b(this.comparator, this.b[0].getKey(), this.b[0].getValue());
/*     */       } 
/* 553 */       return bw.b(this.comparator, false, (Map.Entry[])this.b, this.size);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   bw(cz<K> paramcz, bh<V> parambh) {
/* 563 */     this(paramcz, parambh, (bw<K, V>)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   bw(cz<K> paramcz, bh<V> parambh, bw<K, V> parambw) {
/* 570 */     this.a = paramcz;
/* 571 */     this.l = parambh;
/* 572 */     this.b = parambw;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 577 */     return this.l.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public void forEach(BiConsumer<? super K, ? super V> paramBiConsumer) {
/* 582 */     D.checkNotNull(paramBiConsumer);
/* 583 */     bh<K> bh1 = this.a.c();
/* 584 */     for (byte b = 0; b < size(); b++) {
/* 585 */       paramBiConsumer.accept(bh1.get(b), this.l.get(b));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public V get(Object paramObject) {
/* 591 */     int i = this.a.indexOf(paramObject);
/* 592 */     return (i == -1) ? null : this.l.get(i);
/*     */   }
/*     */ 
/*     */   
/*     */   boolean cO() {
/* 597 */     return (this.a.cO() || this.l.cO());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public bt<Map.Entry<K, V>> h() {
/* 603 */     return super.h();
/*     */   }
/*     */   
/*     */   class a
/*     */     extends bl<K, V> {
/*     */     a(bw this$0) {}
/*     */     
/*     */     public dj<Map.Entry<K, V>> b() {
/* 611 */       return c().b();
/*     */     }
/*     */ 
/*     */     
/*     */     public Spliterator<Map.Entry<K, V>> spliterator() {
/* 616 */       return c().spliterator();
/*     */     }
/*     */ 
/*     */     
/*     */     public void forEach(Consumer<? super Map.Entry<K, V>> param1Consumer) {
/* 621 */       c().forEach(param1Consumer);
/*     */     }
/*     */ 
/*     */     
/*     */     bh<Map.Entry<K, V>> h() {
/* 626 */       return new aZ<Map.Entry<K, V>>(this)
/*     */         {
/*     */           public Map.Entry<K, V> b(int param2Int) {
/* 629 */             return new AbstractMap.SimpleImmutableEntry<>(
/* 630 */                 bw.a(this.a.c).c().get(param2Int), bw.a(this.a.c).get(param2Int));
/*     */           }
/*     */ 
/*     */           
/*     */           public Spliterator<Map.Entry<K, V>> spliterator() {
/* 635 */             return D.a(
/* 636 */                 size(), 1297, this::b);
/*     */           }
/*     */ 
/*     */           
/*     */           bd<Map.Entry<K, V>> a() {
/* 641 */             return this.a;
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */     
/*     */     bj<K, V> g() {
/* 648 */       return this.c;
/*     */     } }
/*     */   bt<Map.Entry<K, V>> i() {
/* 651 */     return isEmpty() ? bt.<Map.Entry<K, V>>n() : new a(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public bA<K> e() {
/* 657 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   bt<K> c() {
/* 662 */     throw new AssertionError("should never be called");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public bd<V> c() {
/* 671 */     return this.l;
/*     */   }
/*     */ 
/*     */   
/*     */   bd<V> b() {
/* 676 */     throw new AssertionError("should never be called");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Comparator<? super K> comparator() {
/* 686 */     return e().comparator();
/*     */   }
/*     */ 
/*     */   
/*     */   public K firstKey() {
/* 691 */     return e().first();
/*     */   }
/*     */ 
/*     */   
/*     */   public K lastKey() {
/* 696 */     return e().last();
/*     */   }
/*     */   
/*     */   private bw<K, V> a(int paramInt1, int paramInt2) {
/* 700 */     if (paramInt1 == 0 && paramInt2 == size())
/* 701 */       return this; 
/* 702 */     if (paramInt1 == paramInt2) {
/* 703 */       return a(comparator());
/*     */     }
/* 705 */     return new bw(this.a
/* 706 */         .a(paramInt1, paramInt2), this.l.a(paramInt1, paramInt2));
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
/*     */   public bw<K, V> a(K paramK) {
/* 721 */     return a(paramK, false);
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
/*     */   public bw<K, V> a(K paramK, boolean paramBoolean) {
/* 737 */     return a(0, this.a.a((K)D.checkNotNull(paramK), paramBoolean));
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
/*     */   public bw<K, V> a(K paramK1, K paramK2) {
/* 752 */     return a(paramK1, true, paramK2, false);
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
/*     */   public bw<K, V> a(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2) {
/* 771 */     D.checkNotNull(paramK1);
/* 772 */     D.checkNotNull(paramK2);
/* 773 */     D.a(
/* 774 */         (comparator().compare(paramK1, paramK2) <= 0), "expected fromKey <= toKey but %s > %s", paramK1, paramK2);
/*     */ 
/*     */ 
/*     */     
/* 778 */     return a(paramK2, paramBoolean2).b(paramK1, paramBoolean1);
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
/*     */   public bw<K, V> b(K paramK) {
/* 792 */     return b(paramK, true);
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
/*     */   public bw<K, V> b(K paramK, boolean paramBoolean) {
/* 808 */     return a(this.a.b((K)D.checkNotNull(paramK), paramBoolean), size());
/*     */   }
/*     */ 
/*     */   
/*     */   public Map.Entry<K, V> lowerEntry(K paramK) {
/* 813 */     return a(paramK, false).lastEntry();
/*     */   }
/*     */ 
/*     */   
/*     */   public K lowerKey(K paramK) {
/* 818 */     return bW.b(lowerEntry(paramK));
/*     */   }
/*     */ 
/*     */   
/*     */   public Map.Entry<K, V> floorEntry(K paramK) {
/* 823 */     return a(paramK, true).lastEntry();
/*     */   }
/*     */ 
/*     */   
/*     */   public K floorKey(K paramK) {
/* 828 */     return bW.b(floorEntry(paramK));
/*     */   }
/*     */ 
/*     */   
/*     */   public Map.Entry<K, V> ceilingEntry(K paramK) {
/* 833 */     return b(paramK, true).firstEntry();
/*     */   }
/*     */ 
/*     */   
/*     */   public K ceilingKey(K paramK) {
/* 838 */     return bW.b(ceilingEntry(paramK));
/*     */   }
/*     */ 
/*     */   
/*     */   public Map.Entry<K, V> higherEntry(K paramK) {
/* 843 */     return b(paramK, false).firstEntry();
/*     */   }
/*     */ 
/*     */   
/*     */   public K higherKey(K paramK) {
/* 848 */     return bW.b(higherEntry(paramK));
/*     */   }
/*     */ 
/*     */   
/*     */   public Map.Entry<K, V> firstEntry() {
/* 853 */     return isEmpty() ? null : h().c().get(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public Map.Entry<K, V> lastEntry() {
/* 858 */     return isEmpty() ? null : h().c().get(size() - 1);
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
/*     */   public final Map.Entry<K, V> pollFirstEntry() {
/* 871 */     throw new UnsupportedOperationException();
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
/*     */   public final Map.Entry<K, V> pollLastEntry() {
/* 884 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public bw<K, V> b() {
/* 891 */     bw<K, V> bw1 = this.b;
/* 892 */     if (bw1 == null) {
/* 893 */       if (isEmpty()) {
/* 894 */         return bw1 = a(cj.b(comparator()).a());
/*     */       }
/* 896 */       return 
/*     */         
/* 898 */         bw1 = new bw((cz<K>)this.a.c(), this.l.f(), this);
/*     */     } 
/*     */     
/* 901 */     return bw1;
/*     */   }
/*     */ 
/*     */   
/*     */   public bA<K> f() {
/* 906 */     return this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public bA<K> g() {
/* 911 */     return this.a.c();
/*     */   }
/*     */ 
/*     */   
/*     */   private static class c<K, V>
/*     */     extends bj.d<K, V>
/*     */   {
/*     */     private final Comparator<? super K> comparator;
/*     */     
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     c(bw<K, V> param1bw) {
/* 923 */       super(param1bw);
/* 924 */       this.comparator = param1bw.comparator();
/*     */     }
/*     */ 
/*     */     
/*     */     bw.b<K, V> a(int param1Int) {
/* 929 */       return new bw.b<>(this.comparator);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Object writeReplace() {
/* 937 */     return new c<>(this);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\bw.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */