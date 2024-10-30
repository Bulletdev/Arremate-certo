/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.b.a.a.b;
/*     */ import com.google.c.a.h;
/*     */ import java.io.IOException;
/*     */ import java.io.InvalidObjectException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @b(ck = true, cl = true)
/*     */ public class bi<K, V>
/*     */   extends bo<K, V>
/*     */   implements bR<K, V>
/*     */ {
/*     */   @b
/*     */   @h
/*     */   private transient bi<V, K> a;
/*     */   @c
/*     */   private static final long serialVersionUID = 0L;
/*     */   
/*     */   public static <T, K, V> Collector<T, ?, bi<K, V>> d(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1) {
/*  86 */     D.b(paramFunction, "keyFunction");
/*  87 */     D.b(paramFunction1, "valueFunction");
/*  88 */     return Collector.of(bi::a, (parama, paramObject) -> parama.a(paramFunction1.apply(paramObject), paramFunction2.apply(paramObject)), a::a, a::d, new Collector.Characteristics[0]);
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
/*     */   public static <T, K, V> Collector<T, ?, bi<K, V>> e(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends Stream<? extends V>> paramFunction1) {
/* 130 */     D.checkNotNull(paramFunction);
/* 131 */     D.checkNotNull(paramFunction1);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 136 */     Objects.requireNonNull(ca.b().a()); return Collectors.collectingAndThen(cb.b(paramObject -> D.checkNotNull(paramFunction.apply(paramObject)), paramObject -> ((Stream)paramFunction.apply(paramObject)).peek(D::checkNotNull), ca.b().a()::c), bi::a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> bi<K, V> a() {
/* 144 */     return aa.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public static <K, V> bi<K, V> a(K paramK, V paramV) {
/* 149 */     a<?, ?> a = a();
/* 150 */     a.a(paramK, paramV);
/* 151 */     return (bi)a.d();
/*     */   }
/*     */ 
/*     */   
/*     */   public static <K, V> bi<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2) {
/* 156 */     a<?, ?> a = a();
/* 157 */     a.a(paramK1, paramV1);
/* 158 */     a.a(paramK2, paramV2);
/* 159 */     return (bi)a.d();
/*     */   }
/*     */ 
/*     */   
/*     */   public static <K, V> bi<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3) {
/* 164 */     a<?, ?> a = a();
/* 165 */     a.a(paramK1, paramV1);
/* 166 */     a.a(paramK2, paramV2);
/* 167 */     a.a(paramK3, paramV3);
/* 168 */     return (bi)a.d();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> bi<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4) {
/* 174 */     a<?, ?> a = a();
/* 175 */     a.a(paramK1, paramV1);
/* 176 */     a.a(paramK2, paramV2);
/* 177 */     a.a(paramK3, paramV3);
/* 178 */     a.a(paramK4, paramV4);
/* 179 */     return (bi)a.d();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> bi<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5) {
/* 185 */     a<?, ?> a = a();
/* 186 */     a.a(paramK1, paramV1);
/* 187 */     a.a(paramK2, paramV2);
/* 188 */     a.a(paramK3, paramV3);
/* 189 */     a.a(paramK4, paramV4);
/* 190 */     a.a(paramK5, paramV5);
/* 191 */     return (bi)a.d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> a<K, V> a() {
/* 201 */     return new a<>();
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
/*     */   public static final class a<K, V>
/*     */     extends bo.a<K, V>
/*     */   {
/*     */     @com.google.b.a.a
/*     */     public a<K, V> a(K param1K, V param1V) {
/* 233 */       super.a(param1K, param1V);
/* 234 */       return this;
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
/* 245 */       super.a(param1Entry);
/* 246 */       return this;
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
/* 258 */       super.a(param1Iterable);
/* 259 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<K, V> a(K param1K, Iterable<? extends V> param1Iterable) {
/* 265 */       super.a(param1K, param1Iterable);
/* 266 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<K, V> a(K param1K, V... param1VarArgs) {
/* 272 */       super.a(param1K, param1VarArgs);
/* 273 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<K, V> a(bZ<? extends K, ? extends V> param1bZ) {
/* 279 */       super.a(param1bZ);
/* 280 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     a<K, V> a(bo.a<K, V> param1a) {
/* 286 */       super.a(param1a);
/* 287 */       return this;
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
/* 298 */       super.b(param1Comparator);
/* 299 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<K, V> b(Comparator<? super V> param1Comparator) {
/* 310 */       super.a(param1Comparator);
/* 311 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public bi<K, V> d() {
/* 317 */       return (bi<K, V>)super.b();
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
/*     */   public static <K, V> bi<K, V> a(bZ<? extends K, ? extends V> parambZ) {
/* 334 */     if (parambZ.isEmpty()) {
/* 335 */       return a();
/*     */     }
/*     */ 
/*     */     
/* 339 */     if (parambZ instanceof bi) {
/*     */       
/* 341 */       bi<K, V> bi1 = (bi)parambZ;
/* 342 */       if (!bi1.cO()) {
/* 343 */         return bi1;
/*     */       }
/*     */     } 
/*     */     
/* 347 */     return a(parambZ.asMap().entrySet(), (Comparator<? super V>)null);
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
/*     */   public static <K, V> bi<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable) {
/* 361 */     return (new a<>()).a(paramIterable).d();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static <K, V> bi<K, V> a(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> paramCollection, Comparator<? super V> paramComparator) {
/* 368 */     if (paramCollection.isEmpty()) {
/* 369 */       return a();
/*     */     }
/*     */     
/* 372 */     bj.a<Object, Object> a = new bj.a<>(paramCollection.size());
/* 373 */     int i = 0;
/*     */     
/* 375 */     for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : paramCollection) {
/* 376 */       Object object = entry.getKey();
/* 377 */       Collection<? extends E> collection = (Collection)entry.getValue();
/*     */ 
/*     */ 
/*     */       
/* 381 */       bh<E> bh = (paramComparator == null) ? bh.<E>a(collection) : bh.<E>a(paramComparator, collection);
/* 382 */       if (!bh.isEmpty()) {
/* 383 */         a.a(object, bh);
/* 384 */         i += bh.size();
/*     */       } 
/*     */     } 
/*     */     
/* 388 */     return new bi<>((bj)a.e(), i);
/*     */   }
/*     */   
/*     */   bi(bj<K, bh<V>> parambj, int paramInt) {
/* 392 */     super((bj)parambj, paramInt);
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
/*     */   public bh<V> b(K paramK) {
/* 405 */     bh<V> bh = (bh)this.j.get(paramK);
/* 406 */     return (bh == null) ? bh.<V>e() : bh;
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
/*     */   public bi<V, K> b() {
/* 422 */     bi<V, K> bi1 = this.a;
/* 423 */     return (bi1 == null) ? (this.a = c()) : bi1;
/*     */   }
/*     */   
/*     */   private bi<V, K> c() {
/* 427 */     a<?, ?> a = a();
/* 428 */     for (dj<Map.Entry<K, V>> dj = e().b(); dj.hasNext(); ) { Map.Entry entry = dj.next();
/* 429 */       a.a(entry.getValue(), entry.getKey()); }
/*     */     
/* 431 */     bi<?, ?> bi1 = a.d();
/* 432 */     bi1.a = this;
/* 433 */     return (bi)bi1;
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
/*     */   public bh<V> c(Object paramObject) {
/* 446 */     throw new UnsupportedOperationException();
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
/*     */   public bh<V> a(K paramK, Iterable<? extends V> paramIterable) {
/* 459 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @c
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/* 468 */     paramObjectOutputStream.defaultWriteObject();
/* 469 */     cE.a(this, paramObjectOutputStream);
/*     */   }
/*     */   @c
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/*     */     bj<?, ?> bj;
/* 474 */     paramObjectInputStream.defaultReadObject();
/* 475 */     int i = paramObjectInputStream.readInt();
/* 476 */     if (i < 0) {
/* 477 */       throw new InvalidObjectException((new StringBuilder(29)).append("Invalid key count ").append(i).toString());
/*     */     }
/* 479 */     bj.a<?, ?> a = bj.a();
/* 480 */     int j = 0;
/*     */     
/* 482 */     for (byte b = 0; b < i; b++) {
/* 483 */       Object object = paramObjectInputStream.readObject();
/* 484 */       int k = paramObjectInputStream.readInt();
/* 485 */       if (k <= 0) {
/* 486 */         throw new InvalidObjectException((new StringBuilder(31)).append("Invalid value count ").append(k).toString());
/*     */       }
/*     */       
/* 489 */       bh.a<?> a1 = bh.a();
/* 490 */       for (byte b1 = 0; b1 < k; b1++) {
/* 491 */         a1.a(paramObjectInputStream.readObject());
/*     */       }
/* 493 */       a.a(object, a1.g());
/* 494 */       j += k;
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 499 */       bj = a.e();
/* 500 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 501 */       throw (InvalidObjectException)(new InvalidObjectException(illegalArgumentException.getMessage())).initCause(illegalArgumentException);
/*     */     } 
/*     */     
/* 504 */     bo.c.b.c(this, bj);
/* 505 */     bo.c.c.b(this, j);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\bi.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */