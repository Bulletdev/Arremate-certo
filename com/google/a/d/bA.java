/*     */ package com.google.a.d;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.a.d;
/*     */ import com.google.a.b.D;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.function.Function;
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
/*     */ @b(ck = true, cl = true)
/*     */ public abstract class ba<K, V>
/*     */   extends bb<K, V>
/*     */   implements w<K, V>
/*     */ {
/*     */   public static <T, K, V> Collector<T, ?, ba<K, V>> a(Function<? super T, ? extends K> paramFunction, Function<? super T, ? extends V> paramFunction1) {
/*  59 */     return B.a(paramFunction, paramFunction1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> ba<K, V> a() {
/*  66 */     return ct.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public static <K, V> ba<K, V> a(K paramK, V paramV) {
/*  71 */     return new cH<>(paramK, paramV);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> ba<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2) {
/*  80 */     return ct.a((Map.Entry<K, V>[])new Map.Entry[] { c(paramK1, paramV1), c(paramK2, paramV2) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> ba<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3) {
/*  89 */     return ct.a((Map.Entry<K, V>[])new Map.Entry[] { c(paramK1, paramV1), c(paramK2, paramV2), c(paramK3, paramV3) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> ba<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4) {
/*  98 */     return ct.a((Map.Entry<K, V>[])new Map.Entry[] {
/*  99 */           c(paramK1, paramV1), c(paramK2, paramV2), c(paramK3, paramV3), c(paramK4, paramV4)
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> ba<K, V> a(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5) {
/* 109 */     return ct.a((Map.Entry<K, V>[])new Map.Entry[] {
/* 110 */           c(paramK1, paramV1), c(paramK2, paramV2), c(paramK3, paramV3), c(paramK4, paramV4), c(paramK5, paramV5)
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> a<K, V> a() {
/* 120 */     return new a<>();
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
/*     */   public static <K, V> a<K, V> a(int paramInt) {
/* 137 */     C.b(paramInt, "expectedSize");
/* 138 */     return new a<>(paramInt);
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
/*     */   public static final class a<K, V>
/*     */     extends bj.a<K, V>
/*     */   {
/*     */     public a() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     a(int param1Int) {
/* 178 */       super(param1Int);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a<K, V> a(K param1K, V param1V) {
/* 188 */       super.a(param1K, param1V);
/* 189 */       return this;
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
/*     */     public a<K, V> a(Map.Entry<? extends K, ? extends V> param1Entry) {
/* 201 */       super.a(param1Entry);
/* 202 */       return this;
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
/*     */     public a<K, V> a(Map<? extends K, ? extends V> param1Map) {
/* 214 */       super.a(param1Map);
/* 215 */       return this;
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
/*     */     @com.google.a.a.a
/*     */     public a<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> param1Iterable) {
/* 229 */       super.a(param1Iterable);
/* 230 */       return this;
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
/*     */     @com.google.a.a.a
/*     */     public a<K, V> a(Comparator<? super V> param1Comparator) {
/* 247 */       super.a(param1Comparator);
/* 248 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     a<K, V> a(bj.a<K, V> param1a) {
/* 254 */       super.a(param1a);
/* 255 */       return this;
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
/*     */     public ba<K, V> c() {
/* 267 */       switch (this.size) {
/*     */         case 0:
/* 269 */           return ba.a();
/*     */         case 1:
/* 271 */           return ba.a(this.b[0].getKey(), this.b[0].getValue());
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 280 */       if (this.valueComparator != null) {
/* 281 */         if (this.aH) {
/* 282 */           this.b = Arrays.<Map.Entry<K, V>>copyOf(this.b, this.size);
/*     */         }
/* 284 */         Arrays.sort(this.b, 0, this.size, 
/*     */ 
/*     */ 
/*     */             
/* 288 */             cj.<V>b(this.valueComparator).a(bW.f()));
/*     */       } 
/* 290 */       this.aH = true;
/* 291 */       return ct.b(this.size, this.b);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     @d
/*     */     ba<K, V> d() {
/* 298 */       D.b((this.valueComparator == null), "buildJdkBacked is for tests only, doesn't support orderEntriesByValue");
/*     */ 
/*     */       
/* 301 */       switch (this.size) {
/*     */         case 0:
/* 303 */           return ba.a();
/*     */         case 1:
/* 305 */           return ba.a(this.b[0].getKey(), this.b[0].getValue());
/*     */       } 
/* 307 */       this.aH = true;
/* 308 */       return ct.b(this.size, this.b);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <K, V> ba<K, V> a(Map<? extends K, ? extends V> paramMap) {
/* 330 */     if (paramMap instanceof ba) {
/*     */       
/* 332 */       ba<K, V> ba1 = (ba)paramMap;
/*     */ 
/*     */       
/* 335 */       if (!ba1.cO()) {
/* 336 */         return ba1;
/*     */       }
/*     */     } 
/* 339 */     return a(paramMap.entrySet());
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
/*     */   @com.google.a.a.a
/*     */   public static <K, V> ba<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getstatic com/google/a/d/ba.a : [Ljava/util/Map$Entry;
/*     */     //   4: invokestatic a : (Ljava/lang/Iterable;[Ljava/lang/Object;)[Ljava/lang/Object;
/*     */     //   7: checkcast [Ljava/util/Map$Entry;
/*     */     //   10: astore_1
/*     */     //   11: aload_1
/*     */     //   12: arraylength
/*     */     //   13: lookupswitch default -> 64, 0 -> 40, 1 -> 44
/*     */     //   40: invokestatic a : ()Lcom/google/a/d/ba;
/*     */     //   43: areturn
/*     */     //   44: aload_1
/*     */     //   45: iconst_0
/*     */     //   46: aaload
/*     */     //   47: astore_2
/*     */     //   48: aload_2
/*     */     //   49: invokeinterface getKey : ()Ljava/lang/Object;
/*     */     //   54: aload_2
/*     */     //   55: invokeinterface getValue : ()Ljava/lang/Object;
/*     */     //   60: invokestatic a : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/a/d/ba;
/*     */     //   63: areturn
/*     */     //   64: aload_1
/*     */     //   65: invokestatic a : ([Ljava/util/Map$Entry;)Lcom/google/a/d/ba;
/*     */     //   68: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #355	-> 0
/*     */     //   #356	-> 11
/*     */     //   #358	-> 40
/*     */     //   #360	-> 44
/*     */     //   #361	-> 48
/*     */     //   #367	-> 64
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
/*     */   public bt<V> f() {
/* 387 */     return b().j();
/*     */   }
/*     */ 
/*     */   
/*     */   final bt<V> g() {
/* 392 */     throw new AssertionError("should never be called");
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
/*     */   public V c(K paramK, V paramV) {
/* 405 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class b<K, V>
/*     */     extends bj.d<K, V>
/*     */   {
/*     */     private static final long serialVersionUID = 0L;
/*     */ 
/*     */ 
/*     */     
/*     */     b(ba<K, V> param1ba) {
/* 418 */       super(param1ba);
/*     */     }
/*     */ 
/*     */     
/*     */     ba.a<K, V> b(int param1Int) {
/* 423 */       return new ba.a<>(param1Int);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Object writeReplace() {
/* 431 */     return new b<>(this);
/*     */   }
/*     */   
/*     */   public abstract ba<V, K> b();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\d\ba.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */