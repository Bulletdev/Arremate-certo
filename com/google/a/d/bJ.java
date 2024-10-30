/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.b.a.f;
/*     */ import com.google.c.a.h;
/*     */ import java.io.Serializable;
/*     */ import java.util.AbstractMap;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.EnumMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.Spliterator;
/*     */ import java.util.Spliterators;
/*     */ import java.util.function.BiFunction;
/*     */ import java.util.function.BinaryOperator;
/*     */ import java.util.function.Function;
/*     */ import java.util.function.Supplier;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @f("Use ImmutableMap.of or another implementation")
/*     */ @b(ck = true, cl = true)
/*     */ public abstract class bj<K, V>
/*     */   implements Serializable, Map<K, V>
/*     */ {
/*     */   public static <T, K, V> Collector<T, ?, bj<K, V>> b(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1) {
/*  83 */     return B.b(paramFunction, paramFunction1);
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
/*     */   public static <T, K, V> Collector<T, ?, bj<K, V>> a(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1, BinaryOperator<V> paramBinaryOperator) {
/* 100 */     D.checkNotNull(paramFunction);
/* 101 */     D.checkNotNull(paramFunction1);
/* 102 */     D.checkNotNull(paramBinaryOperator);
/* 103 */     return Collectors.collectingAndThen(
/* 104 */         Collectors.toMap(paramFunction, paramFunction1, paramBinaryOperator, java.util.LinkedHashMap::new), bj::a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> bj<K, V> f() {
/* 115 */     return (bj)cv.l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> bj<K, V> a(K paramK, V paramV) {
/* 124 */     return ba.a(paramK, paramV);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> bj<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2) {
/* 133 */     return cv.a((Map.Entry<K, V>[])new Map.Entry[] { c(paramK1, paramV1), c(paramK2, paramV2) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> bj<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3) {
/* 142 */     return cv.a((Map.Entry<K, V>[])new Map.Entry[] { c(paramK1, paramV1), c(paramK2, paramV2), c(paramK3, paramV3) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> bj<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4) {
/* 151 */     return cv.a((Map.Entry<K, V>[])new Map.Entry[] {
/* 152 */           c(paramK1, paramV1), c(paramK2, paramV2), c(paramK3, paramV3), c(paramK4, paramV4)
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> bj<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5) {
/* 162 */     return cv.a((Map.Entry<K, V>[])new Map.Entry[] {
/* 163 */           c(paramK1, paramV1), c(paramK2, paramV2), c(paramK3, paramV3), c(paramK4, paramV4), c(paramK5, paramV5)
/*     */         });
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
/*     */   static <K, V> Map.Entry<K, V> c(K paramK, V paramV) {
/* 176 */     C.a(paramK, paramV);
/* 177 */     return new AbstractMap.SimpleImmutableEntry<>(paramK, paramV);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> a<K, V> a() {
/* 185 */     return new a<>();
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
/*     */   public static <K, V> a<K, V> b(int paramInt) {
/* 202 */     C.b(paramInt, "expectedSize");
/* 203 */     return new a<>(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   static void a(boolean paramBoolean, String paramString, Map.Entry<?, ?> paramEntry1, Map.Entry<?, ?> paramEntry2) {
/* 208 */     if (!paramBoolean) {
/* 209 */       throw a(paramString, paramEntry1, paramEntry2);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static IllegalArgumentException a(String paramString, Object paramObject1, Object paramObject2) {
/* 215 */     String str1 = String.valueOf(paramObject1), str2 = String.valueOf(paramObject2); return new IllegalArgumentException((new StringBuilder(34 + String.valueOf(paramString).length() + String.valueOf(str1).length() + String.valueOf(str2).length())).append("Multiple entries with same ").append(paramString).append(": ").append(str1).append(" and ").append(str2).toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @f
/*     */   public static class a<K, V>
/*     */   {
/*     */     Comparator<? super V> valueComparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Map.Entry<K, V>[] b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int size;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean aH;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a() {
/* 260 */       this(4);
/*     */     }
/*     */ 
/*     */     
/*     */     a(int param1Int) {
/* 265 */       this.b = (Map.Entry<K, V>[])new Map.Entry[param1Int];
/* 266 */       this.size = 0;
/* 267 */       this.aH = false;
/*     */     }
/*     */     
/*     */     private void ensureCapacity(int param1Int) {
/* 271 */       if (param1Int > this.b.length) {
/* 272 */         this
/* 273 */           .b = Arrays.<Map.Entry<K, V>>copyOf(this.b, 
/* 274 */             bd.a.h(this.b.length, param1Int));
/* 275 */         this.aH = false;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<K, V> a(K param1K, V param1V) {
/* 285 */       ensureCapacity(this.size + 1);
/* 286 */       Map.Entry<K, V> entry = bj.c(param1K, param1V);
/*     */       
/* 288 */       this.b[this.size++] = entry;
/* 289 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<K, V> a(Map.Entry<? extends K, ? extends V> param1Entry) {
/* 300 */       return a(param1Entry.getKey(), param1Entry.getValue());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<K, V> a(Map<? extends K, ? extends V> param1Map) {
/* 311 */       return a(param1Map.entrySet());
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
/*     */     @com.google.a.a.a
/*     */     public a<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> param1Iterable) {
/* 324 */       if (param1Iterable instanceof Collection) {
/* 325 */         ensureCapacity(this.size + ((Collection)param1Iterable).size());
/*     */       }
/* 327 */       for (Map.Entry<? extends K, ? extends V> entry : param1Iterable) {
/* 328 */         a(entry);
/*     */       }
/* 330 */       return this;
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
/*     */     @com.google.b.a.a
/*     */     @com.google.a.a.a
/*     */     public a<K, V> a(Comparator<? super V> param1Comparator) {
/* 346 */       D.b((this.valueComparator == null), "valueComparator was already set");
/* 347 */       this.valueComparator = (Comparator<? super V>)D.b(param1Comparator, "valueComparator");
/* 348 */       return this;
/*     */     }
/*     */     
/*     */     @com.google.b.a.a
/*     */     a<K, V> a(a<K, V> param1a) {
/* 353 */       D.checkNotNull(param1a);
/* 354 */       ensureCapacity(this.size + param1a.size);
/* 355 */       System.arraycopy(param1a.b, 0, this.b, this.size, param1a.size);
/* 356 */       this.size += param1a.size;
/* 357 */       return this;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public bj<K, V> e() {
/* 380 */       if (this.valueComparator != null) {
/* 381 */         if (this.aH) {
/* 382 */           this.b = Arrays.<Map.Entry<K, V>>copyOf(this.b, this.size);
/*     */         }
/* 384 */         Arrays.sort(this.b, 0, this.size, 
/* 385 */             cj.<V>b(this.valueComparator).a(bW.f()));
/*     */       } 
/* 387 */       switch (this.size) {
/*     */         case 0:
/* 389 */           return bj.f();
/*     */         case 1:
/* 391 */           return bj.a(this.b[0].getKey(), this.b[0].getValue());
/*     */       } 
/* 393 */       this.aH = true;
/* 394 */       return cv.b(this.size, this.b);
/*     */     }
/*     */ 
/*     */     
/*     */     @com.google.a.a.d
/*     */     bj<K, V> d() {
/* 400 */       D.b((this.valueComparator == null), "buildJdkBacked is only for testing; can't use valueComparator");
/*     */       
/* 402 */       switch (this.size) {
/*     */         case 0:
/* 404 */           return bj.f();
/*     */         case 1:
/* 406 */           return bj.a(this.b[0].getKey(), this.b[0].getValue());
/*     */       } 
/* 408 */       this.aH = true;
/* 409 */       return bJ.a(this.size, this.b);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> bj<K, V> a(Map<? extends K, ? extends V> paramMap) {
/* 427 */     if (paramMap instanceof bj && !(paramMap instanceof java.util.SortedMap)) {
/*     */       
/* 429 */       bj<K, V> bj1 = (bj)paramMap;
/* 430 */       if (!bj1.cO()) {
/* 431 */         return bj1;
/*     */       }
/* 433 */     } else if (paramMap instanceof EnumMap) {
/*     */       
/* 435 */       return (bj)b((EnumMap)paramMap);
/*     */     } 
/*     */     
/* 438 */     return c(paramMap.entrySet());
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
/*     */   public static <K, V> bj<K, V> c(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getstatic com/google/a/d/bj.a : [Ljava/util/Map$Entry;
/*     */     //   4: invokestatic a : (Ljava/lang/Iterable;[Ljava/lang/Object;)[Ljava/lang/Object;
/*     */     //   7: checkcast [Ljava/util/Map$Entry;
/*     */     //   10: astore_1
/*     */     //   11: aload_1
/*     */     //   12: arraylength
/*     */     //   13: lookupswitch default -> 64, 0 -> 40, 1 -> 44
/*     */     //   40: invokestatic f : ()Lcom/google/a/d/bj;
/*     */     //   43: areturn
/*     */     //   44: aload_1
/*     */     //   45: iconst_0
/*     */     //   46: aaload
/*     */     //   47: astore_2
/*     */     //   48: aload_2
/*     */     //   49: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   54: aload_2
/*     */     //   55: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   60: invokestatic a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/a/d/bj;
/*     */     //   63: areturn
/*     */     //   64: aload_1
/*     */     //   65: invokestatic a : ([Ljava/util/Map$Entry;)Lcom/google/a/d/bj;
/*     */     //   68: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #453	-> 0
/*     */     //   #454	-> 11
/*     */     //   #456	-> 40
/*     */     //   #458	-> 44
/*     */     //   #459	-> 48
/*     */     //   #465	-> 64
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
/*     */   private static <K extends Enum<K>, V> bj<K, V> b(EnumMap<K, ? extends V> paramEnumMap) {
/* 471 */     EnumMap<K, V> enumMap = new EnumMap<>(paramEnumMap);
/* 472 */     for (Map.Entry<K, V> entry : enumMap.entrySet()) {
/* 473 */       C.a(entry.getKey(), entry.getValue());
/*     */     }
/* 475 */     return bf.a(enumMap); } @com.google.b.a.a.b @h
/*     */   private transient bt<Map.Entry<K, V>> a; @com.google.b.a.a.b
/*     */   @h
/* 478 */   private transient bt<K> b; static final Map.Entry<?, ?>[] a = (Map.Entry<?, ?>[])new Map.Entry[0]; @com.google.b.a.a.b
/*     */   @h
/*     */   private transient bd<V> b; @com.google.b.a.a.b
/*     */   private transient bu<K, V> a;
/*     */   
/*     */   static abstract class b<K, V> extends bj<K, V> { Spliterator<Map.Entry<K, V>> b() {
/* 484 */       return Spliterators.spliterator(
/* 485 */           a(), 
/* 486 */           size(), 1297);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     bt<K> c() {
/* 492 */       return new bm<>(this);
/*     */     }
/*     */     
/*     */     class a
/*     */       extends bl<K, V> {
/*     */       a(bj.b this$0) {}
/*     */       
/*     */       bj<K, V> g() {
/* 500 */         return this.a;
/*     */       }
/*     */ 
/*     */       
/*     */       public dj<Map.Entry<K, V>> b() {
/* 505 */         return this.a.a();
/*     */       } }
/*     */     bt<Map.Entry<K, V>> i() {
/* 508 */       return new a(this);
/*     */     }
/*     */ 
/*     */     
/*     */     bd<V> b() {
/* 513 */       return new bn<>(this);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     abstract dj<Map.Entry<K, V>> a(); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   @com.google.b.a.a
/*     */   public final V put(K paramK, V paramV) {
/* 529 */     throw new UnsupportedOperationException();
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
/*     */   public final V putIfAbsent(K paramK, V paramV) {
/* 542 */     throw new UnsupportedOperationException();
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
/*     */   public final boolean replace(K paramK, V paramV1, V paramV2) {
/* 554 */     throw new UnsupportedOperationException();
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
/*     */   public final V replace(K paramK, V paramV) {
/* 566 */     throw new UnsupportedOperationException();
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
/*     */   public final V computeIfAbsent(K paramK, Function<? super K, ? extends V> paramFunction) {
/* 578 */     throw new UnsupportedOperationException();
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
/*     */   @Deprecated
/*     */   public final V computeIfPresent(K paramK, BiFunction<? super K, ? super V, ? extends V> paramBiFunction) {
/* 591 */     throw new UnsupportedOperationException();
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
/*     */   public final V compute(K paramK, BiFunction<? super K, ? super V, ? extends V> paramBiFunction) {
/* 603 */     throw new UnsupportedOperationException();
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
/*     */   @Deprecated
/*     */   public final V merge(K paramK, V paramV, BiFunction<? super V, ? super V, ? extends V> paramBiFunction) {
/* 616 */     throw new UnsupportedOperationException();
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
/*     */   public final void putAll(Map<? extends K, ? extends V> paramMap) {
/* 628 */     throw new UnsupportedOperationException();
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
/*     */   public final void replaceAll(BiFunction<? super K, ? super V, ? extends V> paramBiFunction) {
/* 640 */     throw new UnsupportedOperationException();
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
/*     */   public final V remove(Object paramObject) {
/* 652 */     throw new UnsupportedOperationException();
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
/*     */   public final boolean remove(Object paramObject1, Object paramObject2) {
/* 664 */     throw new UnsupportedOperationException();
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
/*     */   public final void clear() {
/* 676 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 681 */     return (size() == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/* 686 */     return (get(paramObject) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsValue(Object paramObject) {
/* 691 */     return c().contains(paramObject);
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
/*     */   public final V getOrDefault(Object paramObject, V paramV) {
/* 705 */     V v = get(paramObject);
/* 706 */     return (v != null) ? v : paramV;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public bt<Map.Entry<K, V>> h() {
/* 717 */     bu<K, V> bu1 = this.a;
/* 718 */     return (bu1 == null) ? (bt)(this.a = (bu)i()) : (bt)bu1;
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
/*     */   public bt<K> j() {
/* 731 */     bd<V> bd1 = this.b;
/* 732 */     return (bd1 == null) ? (bt<K>)(this.b = c()) : (bt<K>)bd1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   dj<K> d() {
/* 743 */     dj<Map.Entry<K, V>> dj = h().b();
/* 744 */     return new dj<K>(this, dj)
/*     */       {
/*     */         public boolean hasNext() {
/* 747 */           return this.a.hasNext();
/*     */         }
/*     */ 
/*     */         
/*     */         public K next() {
/* 752 */           return (K)((Map.Entry)this.a.next()).getKey();
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   Spliterator<K> e() {
/* 758 */     return D.a(h().spliterator(), Map.Entry::getKey);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public bd<V> c() {
/* 769 */     bd<V> bd1 = this.b;
/* 770 */     return (bd1 == null) ? (this.b = b()) : bd1;
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
/*     */   public bu<K, V> a() {
/* 789 */     if (isEmpty()) {
/* 790 */       return bu.b();
/*     */     }
/* 792 */     bu<K, V> bu1 = this.a;
/* 793 */     return (bu1 == null) ? (
/* 794 */       this
/* 795 */       .a = new bu<>(new c(), size(), null)) : 
/* 796 */       bu1;
/*     */   }
/*     */   
/*     */   private final class c
/*     */     extends b<K, bt<V>>
/*     */   {
/*     */     private c(bj this$0) {}
/*     */     
/*     */     public int size() {
/* 805 */       return this.i.size();
/*     */     }
/*     */ 
/*     */     
/*     */     bt<K> c() {
/* 810 */       return this.i.j();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean containsKey(Object param1Object) {
/* 815 */       return this.i.containsKey(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public bt<V> a(Object param1Object) {
/* 820 */       Object object = this.i.get(param1Object);
/* 821 */       return (object == null) ? null : bt.<V>b((V)object);
/*     */     }
/*     */ 
/*     */     
/*     */     boolean cO() {
/* 826 */       return this.i.cO();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 832 */       return this.i.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     boolean cR() {
/* 837 */       return this.i.cR();
/*     */     }
/*     */ 
/*     */     
/*     */     dj<Map.Entry<K, bt<V>>> a() {
/* 842 */       dj dj = this.i.h().b();
/* 843 */       return new dj<Map.Entry<K, bt<V>>>(this, dj)
/*     */         {
/*     */           public boolean hasNext() {
/* 846 */             return this.j.hasNext();
/*     */           }
/*     */ 
/*     */           
/*     */           public Map.Entry<K, bt<V>> next() {
/* 851 */             Map.Entry entry = this.j.next();
/* 852 */             return (Map.Entry)new g<K, bt<bt<V>>>(this, entry)
/*     */               {
/*     */                 public K getKey() {
/* 855 */                   return (K)this.e.getKey();
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public bt<V> k() {
/* 860 */                   return bt.b((V)this.e.getValue());
/*     */                 }
/*     */               };
/*     */           }
/*     */         };
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 870 */     return bW.d(this, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 877 */     return cG.a(h());
/*     */   }
/*     */   
/*     */   boolean cR() {
/* 881 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 886 */     return bW.d(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class d<K, V>
/*     */     implements Serializable
/*     */   {
/*     */     private static final boolean aI = true;
/*     */ 
/*     */     
/*     */     private final Object z;
/*     */ 
/*     */     
/*     */     private final Object A;
/*     */ 
/*     */     
/*     */     private static final long serialVersionUID = 0L;
/*     */ 
/*     */     
/*     */     d(bj<K, V> param1bj) {
/* 907 */       Object[] arrayOfObject1 = new Object[param1bj.size()];
/* 908 */       Object[] arrayOfObject2 = new Object[param1bj.size()];
/* 909 */       byte b = 0;
/* 910 */       for (dj<Map.Entry> dj = param1bj.h().b(); dj.hasNext(); ) { Map.Entry entry = dj.next();
/* 911 */         arrayOfObject1[b] = entry.getKey();
/* 912 */         arrayOfObject2[b] = entry.getValue();
/* 913 */         b++; }
/*     */       
/* 915 */       this.z = arrayOfObject1;
/* 916 */       this.A = arrayOfObject2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     final Object readResolve() {
/* 925 */       if (!(this.z instanceof bt)) {
/* 926 */         return u();
/*     */       }
/*     */       
/* 929 */       bt bt = (bt)this.z;
/* 930 */       bd bd = (bd)this.A;
/*     */       
/* 932 */       bj.a<K, V> a = a(bt.size());
/*     */       
/* 934 */       dj<K> dj = bt.b();
/* 935 */       dj<V> dj1 = bd.b();
/*     */       
/* 937 */       while (dj.hasNext()) {
/* 938 */         a.a(dj.next(), dj1.next());
/*     */       }
/*     */       
/* 941 */       return a.e();
/*     */     }
/*     */ 
/*     */     
/*     */     final Object u() {
/* 946 */       Object[] arrayOfObject1 = (Object[])this.z;
/* 947 */       Object[] arrayOfObject2 = (Object[])this.A;
/*     */       
/* 949 */       bj.a<K, V> a = a(arrayOfObject1.length);
/*     */       
/* 951 */       for (byte b = 0; b < arrayOfObject1.length; b++) {
/* 952 */         a.a((K)arrayOfObject1[b], (V)arrayOfObject2[b]);
/*     */       }
/* 954 */       return a.e();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     bj.a<K, V> a(int param1Int) {
/* 961 */       return new bj.a<>(param1Int);
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
/*     */   Object writeReplace() {
/* 973 */     return new d<>(this);
/*     */   }
/*     */   
/*     */   public abstract V get(Object paramObject);
/*     */   
/*     */   abstract bt<Map.Entry<K, V>> i();
/*     */   
/*     */   abstract bt<K> c();
/*     */   
/*     */   abstract bd<V> b();
/*     */   
/*     */   abstract boolean cO();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\bj.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */