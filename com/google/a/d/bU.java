/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.x;
/*     */ import com.google.c.a.h;
/*     */ import com.google.c.a.i;
/*     */ import java.io.IOException;
/*     */ import java.io.InvalidObjectException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ import java.util.function.Function;
/*     */ import java.util.stream.Collector;
/*     */ import java.util.stream.Collectors;
/*     */ import java.util.stream.Stream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class bu<K, V>
/*     */   extends bo<K, V>
/*     */   implements cF<K, V>
/*     */ {
/*     */   private final transient bt<V> c;
/*     */   @com.google.b.a.a.b
/*     */   @h
/*     */   private transient bu<V, K> b;
/*     */   @com.google.b.a.a.b
/*     */   @h
/*     */   private transient bt<Map.Entry<K, V>> d;
/*     */   @com.google.a.a.c
/*     */   private static final long serialVersionUID = 0L;
/*     */   
/*     */   public static <T, K, V> Collector<T, ?, bu<K, V>> f(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1) {
/*  89 */     D.b(paramFunction, "keyFunction");
/*  90 */     D.b(paramFunction1, "valueFunction");
/*  91 */     return Collector.of(bu::a, (parama, paramObject) -> parama.a(paramFunction1.apply(paramObject), paramFunction2.apply(paramObject)), a::a, a::e, new Collector.Characteristics[0]);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T, K, V> Collector<T, ?, bu<K, V>> g(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends Stream<? extends V>> paramFunction1) {
/* 142 */     D.checkNotNull(paramFunction);
/* 143 */     D.checkNotNull(paramFunction1);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 148 */     Objects.requireNonNull(ca.b().b()); return Collectors.collectingAndThen(cb.b(paramObject -> D.checkNotNull(paramFunction.apply(paramObject)), paramObject -> ((Stream)paramFunction.apply(paramObject)).peek(D::checkNotNull), ca.b().b()::c), bu::a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> bu<K, V> b() {
/* 156 */     return ab.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public static <K, V> bu<K, V> a(K paramK, V paramV) {
/* 161 */     a<?, ?> a = a();
/* 162 */     a.a(paramK, paramV);
/* 163 */     return (bu)a.e();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> bu<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2) {
/* 171 */     a<?, ?> a = a();
/* 172 */     a.a(paramK1, paramV1);
/* 173 */     a.a(paramK2, paramV2);
/* 174 */     return (bu)a.e();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> bu<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3) {
/* 182 */     a<?, ?> a = a();
/* 183 */     a.a(paramK1, paramV1);
/* 184 */     a.a(paramK2, paramV2);
/* 185 */     a.a(paramK3, paramV3);
/* 186 */     return (bu)a.e();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> bu<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4) {
/* 195 */     a<?, ?> a = a();
/* 196 */     a.a(paramK1, paramV1);
/* 197 */     a.a(paramK2, paramV2);
/* 198 */     a.a(paramK3, paramV3);
/* 199 */     a.a(paramK4, paramV4);
/* 200 */     return (bu)a.e();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> bu<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5) {
/* 209 */     a<?, ?> a = a();
/* 210 */     a.a(paramK1, paramV1);
/* 211 */     a.a(paramK2, paramV2);
/* 212 */     a.a(paramK3, paramV3);
/* 213 */     a.a(paramK4, paramV4);
/* 214 */     a.a(paramK5, paramV5);
/* 215 */     return (bu)a.e();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> a<K, V> a() {
/* 222 */     return new a<>();
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
/*     */   public static final class a<K, V>
/*     */     extends bo.a<K, V>
/*     */   {
/*     */     Collection<V> g() {
/* 255 */       return cl.s();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<K, V> a(K param1K, V param1V) {
/* 262 */       super.a(param1K, param1V);
/* 263 */       return this;
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
/* 274 */       super.a(param1Entry);
/* 275 */       return this;
/*     */     }
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
/* 287 */       super.a(param1Iterable);
/* 288 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<K, V> a(K param1K, Iterable<? extends V> param1Iterable) {
/* 294 */       super.a(param1K, param1Iterable);
/* 295 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<K, V> a(K param1K, V... param1VarArgs) {
/* 301 */       return a(param1K, Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<K, V> a(bZ<? extends K, ? extends V> param1bZ) {
/* 308 */       for (Map.Entry entry : param1bZ.asMap().entrySet()) {
/* 309 */         a((K)entry.getKey(), (Iterable<? extends V>)entry.getValue());
/*     */       }
/* 311 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     a<K, V> a(bo.a<K, V> param1a) {
/* 317 */       super.a(param1a);
/* 318 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<K, V> a(Comparator<? super K> param1Comparator) {
/* 329 */       super.b(param1Comparator);
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
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<K, V> b(Comparator<? super V> param1Comparator) {
/* 347 */       super.a(param1Comparator);
/* 348 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public bu<K, V> e() {
/*     */       bh<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> bh;
/* 354 */       Set<Map.Entry<K, Collection<V>>> set = this.J.entrySet();
/* 355 */       if (this.a != null) {
/* 356 */         bh = cj.<K>b(this.a).i().a(set);
/*     */       }
/* 358 */       return bu.a(bh, this.valueComparator);
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
/*     */   public static <K, V> bu<K, V> a(bZ<? extends K, ? extends V> parambZ) {
/* 376 */     return a(parambZ, (Comparator<? super V>)null);
/*     */   }
/*     */ 
/*     */   
/*     */   private static <K, V> bu<K, V> a(bZ<? extends K, ? extends V> parambZ, Comparator<? super V> paramComparator) {
/* 381 */     D.checkNotNull(parambZ);
/* 382 */     if (parambZ.isEmpty() && paramComparator == null) {
/* 383 */       return b();
/*     */     }
/*     */     
/* 386 */     if (parambZ instanceof bu) {
/*     */       
/* 388 */       bu<K, V> bu1 = (bu)parambZ;
/* 389 */       if (!bu1.cO()) {
/* 390 */         return bu1;
/*     */       }
/*     */     } 
/*     */     
/* 394 */     return a(parambZ.asMap().entrySet(), paramComparator);
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
/*     */   public static <K, V> bu<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable) {
/* 409 */     return (new a<>()).a(paramIterable).e();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static <K, V> bu<K, V> a(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> paramCollection, Comparator<? super V> paramComparator) {
/* 416 */     if (paramCollection.isEmpty()) {
/* 417 */       return b();
/*     */     }
/*     */     
/* 420 */     bj.a<Object, Object> a = new bj.a<>(paramCollection.size());
/* 421 */     int i = 0;
/*     */     
/* 423 */     for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : paramCollection) {
/* 424 */       Object object = entry.getKey();
/* 425 */       Collection<? extends V> collection = (Collection)entry.getValue();
/* 426 */       bt<V> bt1 = a(paramComparator, collection);
/* 427 */       if (!bt1.isEmpty()) {
/* 428 */         a.a(object, bt1);
/* 429 */         i += bt1.size();
/*     */       } 
/*     */     } 
/*     */     
/* 433 */     return new bu<>((bj)a.e(), i, paramComparator);
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
/*     */   bu(bj<K, bt<V>> parambj, int paramInt, Comparator<? super V> paramComparator) {
/* 446 */     super((bj)parambj, paramInt);
/* 447 */     this.c = a(paramComparator);
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
/*     */   public bt<V> a(K paramK) {
/* 460 */     bt bt1 = (bt)this.j.get(paramK);
/* 461 */     return (bt<V>)x.a(bt1, this.c);
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
/*     */   public bu<V, K> c() {
/* 475 */     bu<V, K> bu1 = this.b;
/* 476 */     return (bu1 == null) ? (this.b = d()) : bu1;
/*     */   }
/*     */   
/*     */   private bu<V, K> d() {
/* 480 */     a<?, ?> a = a();
/* 481 */     for (dj<Map.Entry<K, V>> dj = p().b(); dj.hasNext(); ) { Map.Entry entry = dj.next();
/* 482 */       a.a(entry.getValue(), entry.getKey()); }
/*     */     
/* 484 */     bu<?, ?> bu1 = a.e();
/* 485 */     bu1.b = this;
/* 486 */     return (bu)bu1;
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
/*     */   public bt<V> c(Object paramObject) {
/* 499 */     throw new UnsupportedOperationException();
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
/*     */   public bt<V> a(K paramK, Iterable<? extends V> paramIterable) {
/* 512 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public bt<Map.Entry<K, V>> p() {
/* 523 */     bt<Map.Entry<K, V>> bt1 = this.d;
/* 524 */     return (bt1 == null) ? (this.d = new b<>(this)) : bt1;
/*     */   }
/*     */   
/*     */   private static final class b<K, V> extends bt<Map.Entry<K, V>> { @i
/*     */     private final transient bu<K, V> c;
/*     */     
/*     */     b(bu<K, V> param1bu) {
/* 531 */       this.c = param1bu;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(Object param1Object) {
/* 536 */       if (param1Object instanceof Map.Entry) {
/* 537 */         Map.Entry entry = (Map.Entry)param1Object;
/* 538 */         return this.c.c(entry.getKey(), entry.getValue());
/*     */       } 
/* 540 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public int size() {
/* 545 */       return this.c.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public dj<Map.Entry<K, V>> b() {
/* 550 */       return this.c.a();
/*     */     }
/*     */ 
/*     */     
/*     */     boolean cO() {
/* 555 */       return false;
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   private static <V> bt<V> a(Comparator<? super V> paramComparator, Collection<? extends V> paramCollection) {
/* 561 */     return (paramComparator == null) ? 
/* 562 */       bt.<V>a(paramCollection) : 
/* 563 */       bA.<V>a(paramComparator, paramCollection);
/*     */   }
/*     */   
/*     */   private static <V> bt<V> a(Comparator<? super V> paramComparator) {
/* 567 */     return (paramComparator == null) ? 
/* 568 */       bt.<V>n() : 
/* 569 */       bA.<V>a(paramComparator);
/*     */   }
/*     */ 
/*     */   
/*     */   private static <V> bt.a<V> a(Comparator<? super V> paramComparator) {
/* 574 */     return (paramComparator == null) ? 
/* 575 */       new bt.a<>() : 
/* 576 */       new bA.a<>(paramComparator);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.c
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 585 */     paramObjectOutputStream.defaultWriteObject();
/* 586 */     paramObjectOutputStream.writeObject(valueComparator());
/* 587 */     cE.a(this, paramObjectOutputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   Comparator<? super V> valueComparator() {
/* 592 */     return (this.c instanceof bA) ? (
/* 593 */       (bA<V>)this.c).comparator() : 
/* 594 */       null;
/*     */   }
/*     */   
/*     */   @com.google.a.a.c
/*     */   private static final class c
/*     */   {
/* 600 */     static final cE.a<bu> d = cE.a(bu.class, "emptySet");
/*     */   }
/*     */ 
/*     */   
/*     */   @com.google.a.a.c
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/*     */     bj<?, ?> bj;
/* 607 */     paramObjectInputStream.defaultReadObject();
/* 608 */     Comparator<?> comparator = (Comparator)paramObjectInputStream.readObject();
/* 609 */     int i = paramObjectInputStream.readInt();
/* 610 */     if (i < 0) {
/* 611 */       throw new InvalidObjectException((new StringBuilder(29)).append("Invalid key count ").append(i).toString());
/*     */     }
/* 613 */     bj.a<?, ?> a = bj.a();
/* 614 */     int j = 0;
/*     */     
/* 616 */     for (byte b = 0; b < i; b++) {
/* 617 */       Object object = paramObjectInputStream.readObject();
/* 618 */       int k = paramObjectInputStream.readInt();
/* 619 */       if (k <= 0) {
/* 620 */         throw new InvalidObjectException((new StringBuilder(31)).append("Invalid value count ").append(k).toString());
/*     */       }
/*     */       
/* 623 */       bt.a<?> a1 = a(comparator);
/* 624 */       for (byte b1 = 0; b1 < k; b1++) {
/* 625 */         a1.a(paramObjectInputStream.readObject());
/*     */       }
/* 627 */       bt<?> bt1 = a1.o();
/* 628 */       if (bt1.size() != k) {
/* 629 */         String str = String.valueOf(object); throw new InvalidObjectException((new StringBuilder(40 + String.valueOf(str).length())).append("Duplicate key-value pairs exist for key ").append(str).toString());
/*     */       } 
/* 631 */       a.a(object, bt1);
/* 632 */       j += k;
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 637 */       bj = a.e();
/* 638 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 639 */       throw (InvalidObjectException)(new InvalidObjectException(illegalArgumentException.getMessage())).initCause(illegalArgumentException);
/*     */     } 
/*     */     
/* 642 */     bo.c.b.c(this, bj);
/* 643 */     bo.c.c.b(this, j);
/* 644 */     c.d.c(this, a(comparator));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\bu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */