/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.c.a.i;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.Spliterator;
/*     */ import java.util.function.BiConsumer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b(cl = true)
/*     */ public abstract class bo<K, V>
/*     */   extends v<K, V>
/*     */   implements Serializable
/*     */ {
/*     */   final transient bj<K, ? extends bd<V>> j;
/*     */   final transient int size;
/*     */   private static final long serialVersionUID = 0L;
/*     */   
/*     */   public static <K, V> bo<K, V> c() {
/*  74 */     return bi.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public static <K, V> bo<K, V> a(K paramK, V paramV) {
/*  79 */     return bi.a(paramK, paramV);
/*     */   }
/*     */ 
/*     */   
/*     */   public static <K, V> bo<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2) {
/*  84 */     return bi.a(paramK1, paramV1, paramK2, paramV2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> bo<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3) {
/*  92 */     return bi.a(paramK1, paramV1, paramK2, paramV2, paramK3, paramV3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> bo<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4) {
/* 100 */     return bi.a(paramK1, paramV1, paramK2, paramV2, paramK3, paramV3, paramK4, paramV4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> bo<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5) {
/* 109 */     return bi.a(paramK1, paramV1, paramK2, paramV2, paramK3, paramV3, paramK4, paramV4, paramK5, paramV5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> a<K, V> a() {
/* 119 */     return new a<>();
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
/*     */   @com.google.b.a.f
/*     */   public static class a<K, V>
/*     */   {
/* 152 */     Map<K, Collection<V>> J = cl.J(); Comparator<? super K> a;
/*     */     Comparator<? super V> valueComparator;
/*     */     
/*     */     Collection<V> g() {
/* 156 */       return new ArrayList<>();
/*     */     }
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<K, V> a(K param1K, V param1V) {
/* 162 */       C.a(param1K, param1V);
/* 163 */       Collection<V> collection = this.J.get(param1K);
/* 164 */       if (collection == null) {
/* 165 */         this.J.put(param1K, collection = g());
/*     */       }
/* 167 */       collection.add(param1V);
/* 168 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<K, V> a(Map.Entry<? extends K, ? extends V> param1Entry) {
/* 178 */       return a(param1Entry.getKey(), param1Entry.getValue());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     @com.google.a.a.a
/*     */     public a<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> param1Iterable) {
/* 189 */       for (Map.Entry<? extends K, ? extends V> entry : param1Iterable) {
/* 190 */         a(entry);
/*     */       }
/* 192 */       return this;
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
/*     */     @com.google.b.a.a
/*     */     public a<K, V> a(K param1K, Iterable<? extends V> param1Iterable) {
/*     */       // Byte code:
/*     */       //   0: aload_1
/*     */       //   1: ifnonnull -> 43
/*     */       //   4: new java/lang/NullPointerException
/*     */       //   7: dup
/*     */       //   8: ldc 'null key in entry: null='
/*     */       //   10: aload_2
/*     */       //   11: invokestatic toString : (Ljava/lang/Iterable;)Ljava/lang/String;
/*     */       //   14: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
/*     */       //   17: dup
/*     */       //   18: invokevirtual length : ()I
/*     */       //   21: ifeq -> 30
/*     */       //   24: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
/*     */       //   27: goto -> 39
/*     */       //   30: pop
/*     */       //   31: new java/lang/String
/*     */       //   34: dup_x1
/*     */       //   35: swap
/*     */       //   36: invokespecial <init> : (Ljava/lang/String;)V
/*     */       //   39: invokespecial <init> : (Ljava/lang/String;)V
/*     */       //   42: athrow
/*     */       //   43: aload_0
/*     */       //   44: getfield J : Ljava/util/Map;
/*     */       //   47: aload_1
/*     */       //   48: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */       //   53: checkcast java/util/Collection
/*     */       //   56: astore_3
/*     */       //   57: aload_3
/*     */       //   58: ifnull -> 108
/*     */       //   61: aload_2
/*     */       //   62: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */       //   67: astore #4
/*     */       //   69: aload #4
/*     */       //   71: invokeinterface hasNext : ()Z
/*     */       //   76: ifeq -> 106
/*     */       //   79: aload #4
/*     */       //   81: invokeinterface next : ()Ljava/lang/Object;
/*     */       //   86: astore #5
/*     */       //   88: aload_1
/*     */       //   89: aload #5
/*     */       //   91: invokestatic a : (Ljava/lang/Object;Ljava/lang/Object;)V
/*     */       //   94: aload_3
/*     */       //   95: aload #5
/*     */       //   97: invokeinterface add : (Ljava/lang/Object;)Z
/*     */       //   102: pop
/*     */       //   103: goto -> 69
/*     */       //   106: aload_0
/*     */       //   107: areturn
/*     */       //   108: aload_2
/*     */       //   109: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */       //   114: astore #4
/*     */       //   116: aload #4
/*     */       //   118: invokeinterface hasNext : ()Z
/*     */       //   123: ifne -> 128
/*     */       //   126: aload_0
/*     */       //   127: areturn
/*     */       //   128: aload_0
/*     */       //   129: invokevirtual g : ()Ljava/util/Collection;
/*     */       //   132: astore_3
/*     */       //   133: aload #4
/*     */       //   135: invokeinterface hasNext : ()Z
/*     */       //   140: ifeq -> 170
/*     */       //   143: aload #4
/*     */       //   145: invokeinterface next : ()Ljava/lang/Object;
/*     */       //   150: astore #5
/*     */       //   152: aload_1
/*     */       //   153: aload #5
/*     */       //   155: invokestatic a : (Ljava/lang/Object;Ljava/lang/Object;)V
/*     */       //   158: aload_3
/*     */       //   159: aload #5
/*     */       //   161: invokeinterface add : (Ljava/lang/Object;)Z
/*     */       //   166: pop
/*     */       //   167: goto -> 133
/*     */       //   170: aload_0
/*     */       //   171: getfield J : Ljava/util/Map;
/*     */       //   174: aload_1
/*     */       //   175: aload_3
/*     */       //   176: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */       //   181: pop
/*     */       //   182: aload_0
/*     */       //   183: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #203	-> 0
/*     */       //   #204	-> 4
/*     */       //   #206	-> 43
/*     */       //   #207	-> 57
/*     */       //   #208	-> 61
/*     */       //   #209	-> 88
/*     */       //   #210	-> 94
/*     */       //   #211	-> 103
/*     */       //   #212	-> 106
/*     */       //   #214	-> 108
/*     */       //   #215	-> 116
/*     */       //   #216	-> 126
/*     */       //   #218	-> 128
/*     */       //   #219	-> 133
/*     */       //   #220	-> 143
/*     */       //   #221	-> 152
/*     */       //   #222	-> 158
/*     */       //   #223	-> 167
/*     */       //   #224	-> 170
/*     */       //   #225	-> 182
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
/*     */     @com.google.b.a.a
/*     */     public a<K, V> a(K param1K, V... param1VarArgs) {
/* 236 */       return a(param1K, Arrays.asList(param1VarArgs));
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
/*     */     public a<K, V> a(bZ<? extends K, ? extends V> param1bZ) {
/* 250 */       for (Map.Entry entry : param1bZ.asMap().entrySet()) {
/* 251 */         a((K)entry.getKey(), (Iterable<? extends V>)entry.getValue());
/*     */       }
/* 253 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<K, V> b(Comparator<? super K> param1Comparator) {
/* 263 */       this.a = (Comparator<? super K>)D.checkNotNull(param1Comparator);
/* 264 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<K, V> a(Comparator<? super V> param1Comparator) {
/* 274 */       this.valueComparator = (Comparator<? super V>)D.checkNotNull(param1Comparator);
/* 275 */       return this;
/*     */     }
/*     */     
/*     */     @com.google.b.a.a
/*     */     a<K, V> a(a<K, V> param1a) {
/* 280 */       for (Map.Entry<K, Collection<V>> entry : param1a.J.entrySet()) {
/* 281 */         a((K)entry.getKey(), (Iterable<? extends V>)entry.getValue());
/*     */       }
/* 283 */       return this;
/*     */     }
/*     */     
/*     */     public bo<K, V> b() {
/*     */       bh<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> bh;
/* 288 */       Set<Map.Entry<K, Collection<V>>> set = this.J.entrySet();
/* 289 */       if (this.a != null) {
/* 290 */         bh = cj.<K>b(this.a).i().a(set);
/*     */       }
/* 292 */       return bi.a(bh, this.valueComparator);
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
/*     */   public static <K, V> bo<K, V> a(bZ<? extends K, ? extends V> parambZ) {
/* 307 */     if (parambZ instanceof bo) {
/*     */       
/* 309 */       bo<K, V> bo1 = (bo)parambZ;
/* 310 */       if (!bo1.cO()) {
/* 311 */         return bo1;
/*     */       }
/*     */     } 
/* 314 */     return bi.a(parambZ);
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
/*     */   @com.google.a.a.a
/*     */   public static <K, V> bo<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable) {
/* 328 */     return bi.a(paramIterable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.c
/*     */   static class c
/*     */   {
/* 340 */     static final cE.a<bo> b = cE.a(bo.class, "map");
/*     */     
/* 342 */     static final cE.a<bo> c = cE.a(bo.class, "size");
/*     */   }
/*     */   
/*     */   bo(bj<K, ? extends bd<V>> parambj, int paramInt) {
/* 346 */     this.j = parambj;
/* 347 */     this.size = paramInt;
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
/*     */   public bd<V> b(Object paramObject) {
/* 362 */     throw new UnsupportedOperationException();
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
/*     */   public bd<V> a(K paramK, Iterable<? extends V> paramIterable) {
/* 375 */     throw new UnsupportedOperationException();
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
/*     */   public void clear() {
/* 387 */     throw new UnsupportedOperationException();
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
/*     */   @Deprecated
/*     */   @com.google.b.a.a
/*     */   public boolean put(K paramK, V paramV) {
/* 416 */     throw new UnsupportedOperationException();
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
/*     */   public boolean putAll(K paramK, Iterable<? extends V> paramIterable) {
/* 429 */     throw new UnsupportedOperationException();
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
/*     */   public boolean a(bZ<? extends K, ? extends V> parambZ) {
/* 442 */     throw new UnsupportedOperationException();
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
/*     */   public boolean remove(Object paramObject1, Object paramObject2) {
/* 455 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean cO() {
/* 465 */     return this.j.cO();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/* 472 */     return this.j.containsKey(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsValue(Object paramObject) {
/* 477 */     return (paramObject != null && super.containsValue(paramObject));
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 482 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public bt<K> j() {
/* 493 */     return this.j.j();
/*     */   }
/*     */ 
/*     */   
/*     */   Set<K> b() {
/* 498 */     throw new AssertionError("unreachable");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public bj<K, Collection<V>> h() {
/* 508 */     return (bj)this.j;
/*     */   }
/*     */ 
/*     */   
/*     */   Map<K, Collection<V>> u() {
/* 513 */     throw new AssertionError("should never be called");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public bd<Map.Entry<K, V>> e() {
/* 519 */     return (bd<Map.Entry<K, V>>)super.entries();
/*     */   }
/*     */ 
/*     */   
/*     */   bd<Map.Entry<K, V>> f() {
/* 524 */     return new b<>(this);
/*     */   }
/*     */   private static class b<K, V> extends bd<Map.Entry<K, V>> { @i
/*     */     final bo<K, V> b;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     b(bo<K, V> param1bo) {
/* 531 */       this.b = param1bo;
/*     */     }
/*     */ 
/*     */     
/*     */     public dj<Map.Entry<K, V>> b() {
/* 536 */       return this.b.a();
/*     */     }
/*     */ 
/*     */     
/*     */     boolean cO() {
/* 541 */       return this.b.cO();
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 546 */       return this.b.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 551 */       if (param1Object instanceof Map.Entry) {
/* 552 */         Map.Entry entry = (Map.Entry)param1Object;
/* 553 */         return this.b.c(entry.getKey(), entry.getValue());
/*     */       } 
/* 555 */       return false;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   dj<Map.Entry<K, V>> a() {
/* 563 */     return new dj<Map.Entry<K, V>>(this) {
/* 564 */         final Iterator<? extends Map.Entry<K, ? extends bd<V>>> k = this.a.j
/* 565 */           .h().b();
/* 566 */         K currentKey = null;
/* 567 */         Iterator<V> l = bH.g();
/*     */ 
/*     */         
/*     */         public boolean hasNext() {
/* 571 */           return (this.l.hasNext() || this.k.hasNext());
/*     */         }
/*     */ 
/*     */         
/*     */         public Map.Entry<K, V> next() {
/* 576 */           if (!this.l.hasNext()) {
/* 577 */             Map.Entry entry = this.k.next();
/* 578 */             this.currentKey = (K)entry.getKey();
/* 579 */             this.l = ((bd<V>)entry.getValue()).b();
/*     */           } 
/* 581 */           return bW.d(this.currentKey, this.l.next());
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   Spliterator<Map.Entry<K, V>> b() {
/* 588 */     return D.a(
/* 589 */         h().h().spliterator(), paramEntry -> { Object object = paramEntry.getKey(); Collection<?> collection = (Collection)paramEntry.getValue(); return D.a(collection.spliterator(), ()); }0x40 | (
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 596 */         (this instanceof cF) ? 1 : 0), 
/* 597 */         size());
/*     */   }
/*     */ 
/*     */   
/*     */   public void forEach(BiConsumer<? super K, ? super V> paramBiConsumer) {
/* 602 */     D.checkNotNull(paramBiConsumer);
/* 603 */     h()
/* 604 */       .forEach((paramObject, paramCollection) -> paramCollection.forEach(()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public bp<K> b() {
/* 615 */     return (bp<K>)super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   bp<K> c() {
/* 620 */     return new d(this);
/*     */   }
/*     */   
/*     */   class d
/*     */     extends bp<K> {
/*     */     d(bo this$0) {}
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 628 */       return this.a.containsKey(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public int b(Object param1Object) {
/* 633 */       Collection collection = (Collection)this.a.j.get(param1Object);
/* 634 */       return (collection == null) ? 0 : collection.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public bt<K> d() {
/* 639 */       return this.a.j();
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 644 */       return this.a.size();
/*     */     }
/*     */ 
/*     */     
/*     */     cc.a<K> a(int param1Int) {
/* 649 */       Map.Entry entry = this.a.j.h().c().get(param1Int);
/* 650 */       return cd.a((K)entry.getKey(), ((Collection)entry.getValue()).size());
/*     */     }
/*     */ 
/*     */     
/*     */     boolean cO() {
/* 655 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     @com.google.a.a.c
/*     */     Object writeReplace() {
/* 661 */       return new bo.e(this.a);
/*     */     }
/*     */   }
/*     */   
/*     */   @com.google.a.a.c
/*     */   private static final class e implements Serializable {
/*     */     final bo<?, ?> b;
/*     */     
/*     */     e(bo<?, ?> param1bo) {
/* 670 */       this.b = param1bo;
/*     */     }
/*     */     
/*     */     Object readResolve() {
/* 674 */       return this.b.b();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public bd<V> c() {
/* 684 */     return (bd<V>)super.values();
/*     */   }
/*     */ 
/*     */   
/*     */   bd<V> b() {
/* 689 */     return new f<>(this);
/*     */   }
/*     */ 
/*     */   
/*     */   dj<V> e() {
/* 694 */     return new dj<V>(this) {
/* 695 */         Iterator<? extends bd<V>> m = this.a.j.c().b();
/* 696 */         Iterator<V> l = bH.g();
/*     */ 
/*     */         
/*     */         public boolean hasNext() {
/* 700 */           return (this.l.hasNext() || this.m.hasNext());
/*     */         }
/*     */ 
/*     */         
/*     */         public V next() {
/* 705 */           if (!this.l.hasNext()) {
/* 706 */             this.l = ((bd<V>)this.m.next()).b();
/*     */           }
/* 708 */           return this.l.next();
/*     */         }
/*     */       };
/*     */   }
/*     */   public abstract bd<V> a(K paramK);
/*     */   public abstract bo<V, K> a();
/*     */   private static final class f<K, V> extends bd<V> { @i
/*     */     private final transient bo<K, V> b;
/*     */     f(bo<K, V> param1bo) {
/* 717 */       this.b = param1bo;
/*     */     }
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 722 */       return this.b.containsValue(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public dj<V> b() {
/* 727 */       return this.b.e();
/*     */     }
/*     */ 
/*     */     
/*     */     @com.google.a.a.c
/*     */     int a(Object[] param1ArrayOfObject, int param1Int) {
/* 733 */       for (dj<bd> dj = this.b.j.c().b(); dj.hasNext(); ) { bd bd1 = dj.next();
/* 734 */         param1Int = bd1.a(param1ArrayOfObject, param1Int); }
/*     */       
/* 736 */       return param1Int;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 741 */       return this.b.size();
/*     */     }
/*     */ 
/*     */     
/*     */     boolean cO() {
/* 746 */       return true;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\bo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */